package at.graz.meduni.bibbox.liferay.backgroundtasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import at.graz.meduni.bibbox.helper.ActivitiesProtocol;
import at.graz.meduni.bibbox.helper.BibboxConfigReader;
import at.graz.meduni.bibbox.helper.FormatExceptionMessage;
import at.graz.meduni.bibbox.helper.PortRegister;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceContainerLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstancePortLocalServiceUtil;

public class InstallApplicationBG extends BaseBackgroundTaskExecutor {
	
	/**
	 * Error Format for date
	 */
	private static String log_portlet_ = "BIBBOXDocker";
	private static String log_classname_ = "at.graz.meduni.bibbox.liferay.backgroundtasks.InstallApplicationBG";
	
	private String instanceId_;
	private String activityId_;
	private ApplicationInstance installapplicationinstance_ = null;
	private String applicationfolder_;
	private Map<String, Serializable> taskContextMap_ = null;
	private JSONObject data_ = null;
	private SimpleDateFormat format_date = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat format_time = new SimpleDateFormat("HH:mm:ss.SSS");
	private String result_status_ = "SUCCESS";

	public InstallApplicationBG() {
		setBackgroundTaskStatusMessageTranslator(new InstallBackgroundTaskStatusMessageTranslator());
	}
	
	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
		try {
			taskContextMap_ = backgroundTask.getTaskContextMap();
			
			instanceId_ = taskContextMap_.get("instanceId").toString();
			
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.getApplicationInstance(instanceId_);
			applicationfolder_ = BibboxConfigReader.getApplicationFolder(installapplicationinstance_.getApplication(), installapplicationinstance_.getVersion());
			addActivity();
			registerPort();
			registerContainers();
			try {
				readData();
			} catch (Exception ex) {
				System.err.println(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "execute(BackgroundTask backgroundTask)", "ERROR READ DATA. applicationfolder:" + applicationfolder_));
				ex.printStackTrace();
				result_status_ = "ERROR";
			}
			callInstallScript();
			addProxyEntry();
			pullDockerCompose();
			startDockerCompose();
			installapplicationinstance_.setIsinstalling(false);
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
			
			finishActivity();
		} catch (Exception ex) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "execute(BackgroundTask backgroundTask)", "Error running backgroundTask. applicationfolder:" + applicationfolder_));
			ex.printStackTrace();
		}
		return new BackgroundTaskResult(BackgroundTaskConstants.STATUS_SUCCESSFUL);
	}

	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(BackgroundTask backgroundTask) {
		System.out.println("getBackgroundTaskDisplay");
		return new InstallBackgroundTaskDisplay(backgroundTask);
	}

	@Override
	public BackgroundTaskExecutor clone() {
		System.out.println("clone");
		InstallApplicationBG installApplicationBG = new InstallApplicationBG();
		installApplicationBG.setBackgroundTaskStatusMessageTranslator(getBackgroundTaskStatusMessageTranslator());
		installApplicationBG.setIsolationLevel(getIsolationLevel());
		return installApplicationBG;
	}
	
	private void addActivity() {
		System.out.println(Thread.currentThread().getName()+" Start. installing Application: " + instanceId_);
		JSONObject activity = JSONFactoryUtil.createJSONObject();
		Date curDate = new Date();
		activity.put("name", "Installing " + installapplicationinstance_.getApplication() + " as " + installapplicationinstance_.getName());
		activity.put("type", "INSTALLAPP");
		activity.put("state", "RUNNING");
		activity.put("start_time", format_date.format(curDate) + "T" + format_time.format(curDate) + "Z");
		JSONObject activityresult = ActivitiesProtocol.createActivity(activity.toJSONString());
		activityId_ = activityresult.getString("activitId");
	}
	
	private void registerPort() {
		long port = PortRegister.getNextAvailablePort();
		ApplicationInstancePort applicationinstanceport = ApplicationInstancePortLocalServiceUtil.createApplicationInstancePort(CounterLocalServiceUtil.increment());
		applicationinstanceport.setApplicationInstanceId(installapplicationinstance_.getApplicationInstanceId());
		applicationinstanceport.setPort(port);
		applicationinstanceport.setPrimary(true);
		installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatLogMessage("INFO", "Setting primary port for application to " + port, installapplicationinstance_.getInstalllog()));
		installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
		ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", "Setting primary port for application to " + port);
		applicationinstanceport = ApplicationInstancePortLocalServiceUtil.updateApplicationInstancePort(applicationinstanceport);
	}
	
	private void registerContainers() {
		String applicationfolder = BibboxConfigReader.getApplicationFolder(installapplicationinstance_.getApplication(), installapplicationinstance_.getVersion());
		try {
			String jsonstring = BibboxConfigReader.readApplicationsStoreJsonFile(applicationfolder + "/sys-info.json");
			JSONObject sysinfo = JSONFactoryUtil.createJSONObject(jsonstring);
			JSONArray runningcontainers = sysinfo.getJSONArray("runningcontainers");
			Iterator<?> iterator = runningcontainers.iterator();
			while (iterator.hasNext()) {
				registerContainer(iterator,  true);
			}
			JSONArray supportcontainers = sysinfo.getJSONArray("supportcontainers");
			iterator = supportcontainers.iterator();
			while (iterator.hasNext()) {
				registerContainer(iterator,  false);
			}
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatLogMessage("INFO", "Setting containers for instance", installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
		} catch (JSONException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "registerContainers()", "Error reading sys-info file. applicationfolder:" + applicationfolder));
			e.printStackTrace();
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "registerContainers()", "Error reading sys-info file. applicationfolder:" + applicationfolder, e.getStackTrace(), installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
			ActivitiesProtocol.addActivityLogEntry(activityId_, "ERROR", FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "registerContainers()", "Error reading sys-info file. applicationfolder:" + applicationfolder, e.getStackTrace()));
			result_status_ = "ERROR";
		}
	}
	
	private void registerContainer(Iterator<?> iterator, boolean needrunning) {
		String containername = iterator.next().toString();
		ApplicationInstanceContainer applicationinstancecontainer = ApplicationInstanceContainerLocalServiceUtil.createApplicationInstanceContainer(CounterLocalServiceUtil.increment());
		applicationinstancecontainer.setContainerName(containername.replaceAll("[§][§]INSTANCE", installapplicationinstance_.getInstanceId()));
		applicationinstancecontainer.setNeedrunning(needrunning);
		applicationinstancecontainer.setApplicationInstanceId(installapplicationinstance_.getApplicationInstanceId());
		ApplicationInstanceContainerLocalServiceUtil.updateApplicationInstanceContainer(applicationinstancecontainer);
	}
	
	private void readData() {
		String datasting = "";
		try {
			Serializable dataserializable = taskContextMap_.get("data");
			System.out.println(dataserializable);
			if(dataserializable != null) {
				datasting = dataserializable.toString();
			}
			data_ = JSONFactoryUtil.createJSONObject(datasting);
		} catch (JSONException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "readData()", "Error creating JSONObject from data field. data:" + datasting + " InstanceId: " + instanceId_));
			e.printStackTrace();
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "readData()", "Error creating JSONObject from data field. data:" + datasting + " InstanceId: " + instanceId_, e.getStackTrace(), installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
			ActivitiesProtocol.addActivityLogEntry(activityId_, "ERROR", FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "readData()", "Error creating JSONObject from data field. data:" + datasting + " InstanceId: " + instanceId_, e.getStackTrace()));
			result_status_ = "ERROR";
		}
	}
	
	private void callInstallScript() {
		try {
			ProcessBuilder processbuilder = new ProcessBuilder("/bin/bash", "-c", "./install.sh " + installapplicationinstance_.getBaseInstallationConfigString() + getInstallationConfigString());
			processbuilder.directory(new File(applicationfolder_));
			Process process = processbuilder.start();
			process.waitFor();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String log;
			String installlog = installapplicationinstance_.getInstalllog();
			while ((log = reader.readLine()) != null) 
			{
				String loglevel = "INFO";
				if(log.startsWith("ERROR")) {
					loglevel = "ERROR";
				}
				result_status_ = "ERROR";
				installlog = FormatExceptionMessage.formatLogMessage(loglevel, log, installlog);
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
				installlog = FormatExceptionMessage.formatLogMessage(loglevel, log, installlog);
				ActivitiesProtocol.addActivityLogEntry(activityId_, loglevel, log);
			}
			
			installapplicationinstance_.setInstalllog(installlog);
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
		} catch(IOException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "File Error running install.sh. applicationfolder:" + applicationfolder_));
			e.printStackTrace();
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "File Error running install.sh. applicationfolder:" + applicationfolder_, e.getStackTrace(), installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
			ActivitiesProtocol.addActivityLogEntry(activityId_, "ERROR", FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "File Error running install.sh. applicationfolder:" + applicationfolder_, e.getStackTrace()));
			result_status_ = "ERROR";
		} catch (InterruptedException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "Error running install.sh. applicationfolder:" + applicationfolder_));
			e.printStackTrace();
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "Error running install.sh. applicationfolder:" + applicationfolder_, e.getStackTrace(), installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
			ActivitiesProtocol.addActivityLogEntry(activityId_, "ERROR", FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "Error running install.sh. applicationfolder:" + applicationfolder_, e.getStackTrace()));
			result_status_ = "ERROR";
		}
	}
	
	private String getInstallationConfigString() {
		String parameters = "";
		Iterator<String> iterator = data_.keys();
		while (iterator.hasNext()) {
			String key = iterator.next();
			parameters += " --" + key + " \"" + data_.getString(key) + "\"";
		}
		return parameters;
	}
	
	private void addProxyEntry() {
		try {
			System.out.println("./addproxy.sh " + installapplicationinstance_.getBasicProxyConfigString() + getInstallationConfigString());
			ProcessBuilder processbuilder = new ProcessBuilder("/bin/bash", "-c", "./addproxy.sh " + installapplicationinstance_.getBasicProxyConfigString());
			processbuilder.directory(new File(applicationfolder_));
			Process process = processbuilder.start();
			process.waitFor();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String log;
			String installlog = installapplicationinstance_.getInstalllog();
			while ((log = reader.readLine()) != null) 
			{
				String loglevel = "INFO";
				if(log.startsWith("ERROR")) {
					loglevel = "ERROR";
				}
				result_status_ = "ERROR";
				installlog = FormatExceptionMessage.formatLogMessage(loglevel, log, installlog);
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
				installlog = FormatExceptionMessage.formatLogMessage(loglevel, log, installlog);
				ActivitiesProtocol.addActivityLogEntry(activityId_, loglevel, log);
			}
			
			installapplicationinstance_.setInstalllog(installlog);
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
		} catch(IOException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "File Error running install.sh. applicationfolder:" + applicationfolder_));
			e.printStackTrace();
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "File Error running install.sh. applicationfolder:" + applicationfolder_, e.getStackTrace(), installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
			ActivitiesProtocol.addActivityLogEntry(activityId_, "ERROR", FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "File Error running install.sh. applicationfolder:" + applicationfolder_, e.getStackTrace()));
			result_status_ = "ERROR";
		} catch (InterruptedException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "Error running install.sh. applicationfolder:" + applicationfolder_));
			e.printStackTrace();
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "Error running install.sh. applicationfolder:" + applicationfolder_, e.getStackTrace(), installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
			ActivitiesProtocol.addActivityLogEntry(activityId_, "ERROR", FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "Error running install.sh. applicationfolder:" + applicationfolder_, e.getStackTrace()));
			result_status_ = "ERROR";
		}
	}

	private void pullDockerCompose() {
		try {
			ProcessBuilder processbuilder = new ProcessBuilder("/bin/bash", "-c", "docker-compose pull");
			processbuilder.directory(new File(applicationfolder_));
			Process process = processbuilder.start();
			process.waitFor();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String log;
			String composelog = installapplicationinstance_.getInstalllog();
			while ((log = reader.readLine()) != null) 
			{
				String loglevel = "INFO";
				if(log.startsWith("ERROR")) {
					loglevel = "ERROR";
				}
				result_status_ = "ERROR";
				composelog = FormatExceptionMessage.formatLogMessage(loglevel, log, composelog);
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
				composelog = FormatExceptionMessage.formatLogMessage(loglevel, log, composelog);
				ActivitiesProtocol.addActivityLogEntry(activityId_, loglevel, log);
			}
			installapplicationinstance_.setInstalllog(composelog);
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
		} catch(IOException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "startUpApplicationInstance()", "Error pulling docker-compose.yml file for folder:" + applicationfolder_));
			e.printStackTrace();
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "Error pulling docker-compose.yml file for folder:" + applicationfolder_, e.getStackTrace(), installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
			ActivitiesProtocol.addActivityLogEntry(activityId_, "ERROR", FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "Error pulling docker-compose.yml file for folder:" + applicationfolder_, e.getStackTrace()));
			result_status_ = "ERROR";
		} catch (InterruptedException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "startUpApplicationInstance()", "Error pulling docker-compose.yml file for folder:" + applicationfolder_));
			e.printStackTrace();
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "Error pulling docker-compose.yml file for folder:" + applicationfolder_, e.getStackTrace(), installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
			ActivitiesProtocol.addActivityLogEntry(activityId_, "ERROR", FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "Error pulling docker-compose.yml file for folder:" + applicationfolder_, e.getStackTrace()));
			result_status_ = "ERROR";
		}
	}
	
	private void startDockerCompose() {
		String log = installapplicationinstance_.startApplicationInstance();
		installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatLogMessage("INFO", log, installapplicationinstance_.getInstalllog()));
		ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", log);
	}
	
	private void finishActivity() {
		JSONObject activity = JSONFactoryUtil.createJSONObject();
		activity.put("state", "FINISHED");
		activity.put("result", result_status_);
		Date curDate = new Date();
		activity.put("finished_time", format_date.format(curDate) + "T" + format_time.format(curDate) + "Z");
		ActivitiesProtocol.updateActivity(activityId_, activity.toJSONString());
		System.out.println(Thread.currentThread().getName()+" Finished. install Application: " + instanceId_ + " SUCCESSFUL");
	}
}
