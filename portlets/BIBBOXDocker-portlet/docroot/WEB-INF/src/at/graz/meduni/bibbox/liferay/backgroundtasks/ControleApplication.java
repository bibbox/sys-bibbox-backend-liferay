package at.graz.meduni.bibbox.liferay.backgroundtasks;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceStatusLocalServiceUtil;

public class ControleApplication extends BaseBackgroundTaskExecutor {
	
	/**
	 * Error Format for date
	 */
	private static String log_portlet_ = "BIBBOXDocker";
	private static String log_classname_ = "at.graz.meduni.bibbox.liferay.backgroundtasks.ControleApplication";

	private String instanceId_;
	private String activityId_;
	private SimpleDateFormat format_date = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat format_time = new SimpleDateFormat("HH:mm:ss.SSS");
	private String result_status_ = "SUCCESS";
	private ApplicationInstance applicationinstance_ = null;
	
	public static String newline_ = System.getProperty("line.separator");
	
	public ControleApplication() {
		super();
		setBackgroundTaskStatusMessageTranslator(new ControleBackgroundTaskStatusMessageTranslator());
	}
	
	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
		try {
			Map<String, Serializable> taskContextMap = backgroundTask.getTaskContextMap();
			instanceId_ = taskContextMap.get("instanceId").toString();
			String command = taskContextMap.get("command").toString();
			applicationinstance_ = ApplicationInstanceLocalServiceUtil.getApplicationInstance(instanceId_);
			if(command.equals("start")) {
				startApplicationInstance();
			} else if(command.equals("stop")) {
				stopApplicationInstance();
			} else if(command.equals("restart")) {
				restartApplicationInstance();
			} else {
				System.err.println(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "execute(BackgroundTask backgroundTask)", "Error command task not set correctly: command: " + command + " InstanceId:" + instanceId_));
				result_status_ = "ERROR";
			}
			ApplicationInstanceStatus applicationinstancestatus = ApplicationInstanceStatusLocalServiceUtil.getApplicationInstanceStatusByInstanceId(applicationinstance_.getApplicationInstanceId());
			applicationinstancestatus.setStatus("");
			applicationinstancestatus = ApplicationInstanceStatusLocalServiceUtil.updateApplicationInstanceStatus(applicationinstancestatus);
			finishActivity();
		} catch (Exception ex) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "execute(BackgroundTask backgroundTask)", "Error running backgroundTask. InstanceId:" + instanceId_));
			ex.printStackTrace();
			result_status_ = "ERROR";
			finishActivity();
		}
		int backgroundtaskstatus = BackgroundTaskConstants.STATUS_SUCCESSFUL;
		if(result_status_.equals("ERROR")) {
			backgroundtaskstatus = BackgroundTaskConstants.STATUS_FAILED;
		}
		return new BackgroundTaskResult(backgroundtaskstatus);
	}

	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(BackgroundTask backgroundTask) {
		System.out.println("getBackgroundTaskDisplay");
		return new ControleBackgroundTaskDisplay(backgroundTask);
	}

	@Override
	public BackgroundTaskExecutor clone() {
		System.out.println("clone");
		ControleApplication controleApplication = new ControleApplication();
		controleApplication.setBackgroundTaskStatusMessageTranslator(getBackgroundTaskStatusMessageTranslator());
		controleApplication.setIsolationLevel(getIsolationLevel());
		return controleApplication;
	}
	
	private void startApplicationInstance() {
		addActivity("Starting Instance " + instanceId_, "STARTAPP");

		String logs = applicationinstance_.startApplicationInstance();
		for(String log : logs.split(newline_)) {
			ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", log);
		}
	}
	
	private void stopApplicationInstance() {
		addActivity("Stopping Instance " + instanceId_, "STOPAPP");

		String logs = applicationinstance_.stopApplicationInstance();
		for(String log : logs.split(newline_)) {
			ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", log);
		}
	}
	
	private void restartApplicationInstance() {
		addActivity("Restarting Instance " + instanceId_, "RESTARTAPP");

		String logs = applicationinstance_.restartApplicationInstance();
		for(String log : logs.split(newline_)) {
			ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", log);
		}
	}
	
	private void addActivity(String message, String type) {
		System.out.println(Thread.currentThread().getName()+" Start. installing Application: " + instanceId_);
		JSONObject activity = JSONFactoryUtil.createJSONObject();
		Date curDate = new Date();
		activity.put("name", message);
		activity.put("type", type);
		activity.put("state", "RUNNING");
		activity.put("start_time", format_date.format(curDate) + "T" + format_time.format(curDate) + "Z");
		JSONObject activityresult = ActivitiesProtocol.createActivity(activity.toJSONString());
		activityId_ = activityresult.getString("activitId");
	}
	
	private void finishActivity() {
		JSONObject activity = JSONFactoryUtil.createJSONObject();
		activity.put("state", "FINISHED");
		activity.put("result", result_status_);
		Date curDate = new Date();
		activity.put("finished_time", format_date.format(curDate) + "T" + format_time.format(curDate) + "Z");
		ActivitiesProtocol.updateActivity(activityId_, activity.toJSONString());
		System.out.println(Thread.currentThread().getName()+" Finished. contorle Application: " + instanceId_ + " " + result_status_);
	}

}
