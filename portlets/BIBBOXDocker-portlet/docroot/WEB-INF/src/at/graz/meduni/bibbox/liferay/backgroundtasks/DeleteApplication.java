package at.graz.meduni.bibbox.liferay.backgroundtasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import at.graz.meduni.bibbox.helper.ActivitiesProtocol;
import at.graz.meduni.bibbox.helper.FormatExceptionMessage;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceContainerLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstancePortLocalServiceUtil;

public class DeleteApplication extends BaseBackgroundTaskExecutor {

	/**
	 * Error Format for date
	 */
	private static String log_portlet_ = "BIBBOXDocker";
	private static String log_classname_ = "at.graz.meduni.bibbox.liferay.backgroundtasks.DeleteApplication";
	
	private String instanceId_;
	private String activityId_;
	private String result_status_ = "SUCCESS";
	private ApplicationInstance applicationinstance_;
	private Map<String, Serializable> taskContextMap_ = null;
	private SimpleDateFormat format_date = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat format_time = new SimpleDateFormat("HH:mm:ss.SSS");
	
	public DeleteApplication() {
		setBackgroundTaskStatusMessageTranslator(new DeleteApplicationBackgroundTaskStatusMessageTranslator());
	}
	
	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
		try {
			taskContextMap_ = backgroundTask.getTaskContextMap();
			instanceId_ = taskContextMap_.get("instanceId").toString();
			applicationinstance_ = ApplicationInstanceLocalServiceUtil.getApplicationInstance(instanceId_);
			addActivity();
			
			dockerDown();
			ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", "Deleting Folders and Files: " + applicationinstance_.getFolderPath());
			deleteFolderStructure(new File(applicationinstance_.getFolderPath()));
			ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", "Deleting Proxy Entry:");
			deleteProxyEntry(applicationinstance_.getInstanceId());
			ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", "Cleanup Portlist:");
			deletePorts(applicationinstance_.getApplicationPorts());
			ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", "Cleanup Container Informations:");
			deleteContainer(applicationinstance_.getContainers());
			ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", "Delete Instance entry.");
			ApplicationInstanceLocalServiceUtil.deleteApplicationInstance(applicationinstance_);
			
			finishActivity();
		} catch (Exception ex) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "execute(BackgroundTask backgroundTask)", "Error running backgroundTask. instanceId:" + instanceId_));
			ex.printStackTrace();
		}
		return new BackgroundTaskResult(BackgroundTaskConstants.STATUS_SUCCESSFUL);
	}

	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(BackgroundTask backgroundTask) {
		System.out.println("getBackgroundTaskDisplay");
		return new DeleteApplicationBackgroundTaskDisplay(backgroundTask);
	}

	@Override
	public BackgroundTaskExecutor clone() {
		System.out.println("clone");
		DeleteApplication deleteApplication = new DeleteApplication();
		deleteApplication.setBackgroundTaskStatusMessageTranslator(getBackgroundTaskStatusMessageTranslator());
		deleteApplication.setIsolationLevel(getIsolationLevel());
		return deleteApplication;
	}

	private void addActivity() {
		System.out.println(Thread.currentThread().getName()+" Start. delete Application: " + instanceId_);
		JSONObject activity = JSONFactoryUtil.createJSONObject();
		Date curDate = new Date();
		activity.put("name", "Delete " + applicationinstance_.getShortName());
		activity.put("type", "DELETEAPP");
		activity.put("state", "RUNNING");
		activity.put("start_time", format_date.format(curDate) + "T" + format_time.format(curDate) + "Z");
		JSONObject activityresult = ActivitiesProtocol.createActivity(activity.toJSONString());
		activityId_ = activityresult.getString("activitId");
	}
	
	private void dockerDown() {
		try {
			ProcessBuilder processbuilder = new ProcessBuilder("/bin/bash", "-c", "docker-compose down");
			processbuilder.directory(new File(applicationinstance_.getFolderPath()));
			Process process = processbuilder.start();
			process.waitFor();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String log;
			while ((log = reader.readLine()) != null) 
			{
				String loglevel = "INFO";
				if(log.startsWith("ERROR")) {
					loglevel = "ERROR";
				}
				result_status_ = "ERROR";
				ActivitiesProtocol.addActivityLogEntry(activityId_, loglevel, log);
			}
			
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((log = reader.readLine()) != null) 
			{
				String loglevel = "INFO";
				if(log.startsWith("ERROR")) {
					loglevel = "ERROR";
					result_status_ = "ERROR";
				}
				ActivitiesProtocol.addActivityLogEntry(activityId_, loglevel, log);
			}			
		} catch(IOException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "dockerDown(String applicationfolder)", "Error stopping containers and removes containers, networks, volumes, and images from Instance with ID: " + instanceId_));
			e.printStackTrace();
			result_status_ = "ERROR";
		} catch (InterruptedException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "dockerDown(String applicationfolder)", "Error stopping containers and removes containers, networks, volumes, and images from Instance with ID: " + instanceId_));
			e.printStackTrace();
			result_status_ = "ERROR";
		}
	}
	
	private void deleteFolderStructure(File folder) {
		File[] files = folder.listFiles();
		if(files!=null) {
			for(File file: files) {
				if(file.isDirectory()) {
					deleteFolderStructure(file);
	            } else {
	                file.delete();
	            }
			}
		}
		folder.delete();
	}
	
	private void deleteProxyEntry(String instanceId) {
		File sitesenabled = new File("/etc/apache2/sites-enabled/005-" + instanceId_ + ".conf");
		sitesenabled.delete();
		File sitesavailable = new File("/etc/apache2/sites-available/005-" + instanceId_ + ".conf");
		ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", "Deleting Link: " + sitesenabled.getName());
		sitesavailable.delete();
	}
	
	private void deletePorts(List<ApplicationInstancePort> ports) {
		ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", "Free Ports.");
		for(ApplicationInstancePort port : ports) {
			ApplicationInstancePortLocalServiceUtil.deleteApplicationInstancePort(port);
		}
	}
	
	private void deleteContainer(List<ApplicationInstanceContainer> containers) {
		ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", "Deleting container information.");
		for(ApplicationInstanceContainer container : containers) {
			ApplicationInstanceContainerLocalServiceUtil.deleteApplicationInstanceContainer(container);
		}
	}
	
	private void finishActivity() {
		JSONObject activity = JSONFactoryUtil.createJSONObject();
		activity.put("state", "FINISHED");
		activity.put("result", result_status_);
		Date curDate = new Date();
		activity.put("finished_time", format_date.format(curDate) + "T" + format_time.format(curDate) + "Z");
		ActivitiesProtocol.updateActivity(activityId_, activity.toJSONString());
		System.out.println(Thread.currentThread().getName()+" Finished. delete Application: " + instanceId_ + " SUCCESSFUL");
	}
}
