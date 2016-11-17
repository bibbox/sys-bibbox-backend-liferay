package at.graz.meduni.bibbox.threadtasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import at.graz.meduni.bibbox.helper.BibboxConfigReader;
import at.graz.meduni.bibbox.helper.FormatExceptionMessage;
import at.graz.meduni.bibbox.helper.PortRegister;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceContainerLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstancePortLocalServiceUtil;

public class InstallApplicationTask implements Runnable {

	/**
	 * Error Format for date
	 */
	private static String log_portlet_ = "BIBBOXDocker";
	private static String log_classname_ = "at.graz.meduni.bibbox.threadtasks.InstallApplicationTask";
	
	private String taskname_;
	private ApplicationInstance installapplicationinstance_ = null;
	private HashMap<String, String> config_ = null;
	JSONObject data_ = null;
	
	public InstallApplicationTask(String taskname, HashMap<String, String> config){
        taskname_ = taskname;
        config_ = config;
    }
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" Start. installing Application: " + taskname_);
		//installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.getApplicationInstance(taskname_);
		//String applicationfolder = BibboxConfigReader.getApplicationFolder(installapplicationinstance_.getApplication(), installapplicationinstance_.getVersion());
		//registerPort();
		//registerContainers();
		//readData();
		//callInstallScript(applicationfolder);
		//addProxyEntry(applicationfolder);
		String applicationfolder = "test";
		pullDockerCompose(applicationfolder);
		
		//installapplication.callInstallScript(applicationfodler);
		//installapplication.addProxyEntry(applicationfodler);
		//installapplication.startDockerCompose();
		
        System.out.println(Thread.currentThread().getName()+" End.");
	}

	private void registerPort() {
		long port = PortRegister.getNextAvailablePort();
		ApplicationInstancePort applicationinstanceport = ApplicationInstancePortLocalServiceUtil.createApplicationInstancePort(CounterLocalServiceUtil.increment());
		applicationinstanceport.setApplicationInstanceId(installapplicationinstance_.getApplicationInstanceId());
		applicationinstanceport.setPort(port);
		applicationinstanceport.setPrimary(true);
		installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatLogMessage("INFO", "Setting primary port for application to " + port, installapplicationinstance_.getInstalllog()));
		applicationinstanceport = ApplicationInstancePortLocalServiceUtil.updateApplicationInstancePort(applicationinstanceport);
	}
	
	private void registerContainers() {
		String applicationfolder = BibboxConfigReader.getApplicationFolder(installapplicationinstance_.getApplication(), installapplicationinstance_.getVersion());
		try {
			String jsonstring = BibboxConfigReader.readApplicationsStoreJsonFile(applicationfolder + "/sys-info.json");
			JSONObject sysinfo = JSONFactoryUtil.createJSONObject(jsonstring);
			JSONArray runningcontainers = sysinfo.getJSONArray("runningcontainers");
			Iterator<String> iterator = runningcontainers.iterator();
			while (iterator.hasNext()) {
				registerContainer(iterator,  true);
			}
			JSONArray supportcontainers = sysinfo.getJSONArray("supportcontainers");
			iterator = supportcontainers.iterator();
			while (iterator.hasNext()) {
				registerContainer(iterator,  false);
			}
		} catch (JSONException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "registerContainers()", "Error reading sys-info file. applicationfolder:" + applicationfolder));
			e.printStackTrace();
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "registerContainers()", "Error reading sys-info file. applicationfolder:" + applicationfolder, e.getStackTrace(), installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
		}
	}
	
	private void registerContainer(Iterator<String> iterator, boolean needrunning) {
		String containername = iterator.next();
		ApplicationInstanceContainer applicationinstancecontainer = ApplicationInstanceContainerLocalServiceUtil.createApplicationInstanceContainer(CounterLocalServiceUtil.increment());
		applicationinstancecontainer.setContainerName(containername.replaceAll("[§][§]INSTANCE", installapplicationinstance_.getInstanceId()));
		applicationinstancecontainer.setNeedrunning(needrunning);
		applicationinstancecontainer.setApplicationInstanceId(installapplicationinstance_.getApplicationInstanceId());
		ApplicationInstanceContainerLocalServiceUtil.updateApplicationInstanceContainer(applicationinstancecontainer);
	}
	
	private void readData() {
		String datasting = config_.get("data");
		try {
			data_ = JSONFactoryUtil.createJSONObject(datasting);
		} catch (JSONException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "readData()", "Error creating JSONObject from data field. data:" + datasting + " InstanceId: " + taskname_));
			e.printStackTrace();
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "readData()", "Error creating JSONObject from data field. data:" + datasting + " InstanceId: " + taskname_, e.getStackTrace(), installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
		}
	}
	
	private void callInstallScript(String applicationfolder) {
		try {
			ProcessBuilder processbuilder = new ProcessBuilder("/bin/bash", "-c", "./install.sh " + installapplicationinstance_.getBaseInstallationConfigString() + getInstallationConfigString());
			processbuilder.directory(new File(applicationfolder));
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
				installlog = FormatExceptionMessage.formatLogMessage(loglevel, log, installlog);
			}
			
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((log = reader.readLine()) != null) 
			{
				String loglevel = "INFO";
				if(log.startsWith("ERROR")) {
					loglevel = "ERROR";
				}
				installlog = FormatExceptionMessage.formatLogMessage(loglevel, log, installlog);
			}
			
			installapplicationinstance_.setInstalllog(installlog);
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
		} catch(IOException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "File Error running install.sh. applicationfolder:" + applicationfolder));
			e.printStackTrace();
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "File Error running install.sh. applicationfolder:" + applicationfolder, e.getStackTrace(), installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
		} catch (InterruptedException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "Error running install.sh. applicationfolder:" + applicationfolder));
			e.printStackTrace();
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "Error running install.sh. applicationfolder:" + applicationfolder, e.getStackTrace(), installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
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
	
	private void addProxyEntry(String applicationfolder) {
		try {
			System.out.println("./addproxy.sh " + installapplicationinstance_.getBasicProxyConfigString() + getInstallationConfigString());
			ProcessBuilder processbuilder = new ProcessBuilder("/bin/bash", "-c", "./addproxy.sh " + installapplicationinstance_.getBasicProxyConfigString());
			processbuilder.directory(new File(applicationfolder));
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
				installlog = FormatExceptionMessage.formatLogMessage(loglevel, log, installlog);
			}
			
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((log = reader.readLine()) != null) 
			{
				String loglevel = "INFO";
				if(log.startsWith("ERROR")) {
					loglevel = "ERROR";
				}
				installlog = FormatExceptionMessage.formatLogMessage(loglevel, log, installlog);
			}
			
			installapplicationinstance_.setInstalllog(installlog);
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
		} catch(IOException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "File Error running install.sh. applicationfolder:" + applicationfolder));
			e.printStackTrace();
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "File Error running install.sh. applicationfolder:" + applicationfolder, e.getStackTrace(), installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
		} catch (InterruptedException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "Error running install.sh. applicationfolder:" + applicationfolder));
			e.printStackTrace();
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "callInstallScript(String applicationfolder)", "Error running install.sh. applicationfolder:" + applicationfolder, e.getStackTrace(), installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
		}
	}
	
	private void pullDockerCompose(String applicationfolder) {
		String installlog = "";
		try {
			ProcessBuilder processbuilder = new ProcessBuilder("/bin/bash", "-c", "docker pull sath89/oracle-12c");
			//processbuilder.directory(new File(applicationfolder));
			Process process = processbuilder.start();
			//process.waitFor();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String log;
			
			while ((log = reader.readLine()) != null) 
			{
				String loglevel = "INFO";
				if(log.startsWith("ERROR")) {
					loglevel = "ERROR";
				}
				installlog = FormatExceptionMessage.formatLogMessage(loglevel, log, installlog);
			}
			
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((log = reader.readLine()) != null) 
			{
				String loglevel = "INFO";
				if(log.startsWith("ERROR")) {
					loglevel = "ERROR";
				}
				installlog = FormatExceptionMessage.formatLogMessage(loglevel, log, installlog);
			}
			
		} catch(IOException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "startUpApplicationInstance()", "Error pulling docker-compose.yml file for folder:" + applicationfolder));
			e.printStackTrace();
		} /*catch (InterruptedException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "startUpApplicationInstance()", "Error pulling docker-compose.yml file for folder:" + applicationfolder));
			e.printStackTrace();
		}*/
	}
	
	private void startDockerCompose() {
		String log = installapplicationinstance_.startApplicationInstance();
		installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatLogMessage("INFO", log, installapplicationinstance_.getInstalllog()));
		
	}
}
