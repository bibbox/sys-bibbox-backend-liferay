package at.graz.meduni.bibbox.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstancePortLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.base.ApplicationInstancePortLocalServiceBaseImpl;

public class InstallApplication {
	/**
	 * Error Format for date
	 */
	private String log_portlet_ = "BIBBOXDocker";
	private String log_classname_ = "at.graz.meduni.bibbox.helper.InstallApplication";
	
	String applicationname_ = ""; 
	String version_ = ""; 
	String instanceid_ = ""; 
	String instancename_ = ""; 
	String description_ = ""; 
	JSONObject data_ = null;
	ApplicationInstance installapplicationinstance_ = null;
	
	public String getLog() {
		return installapplicationinstance_.getInstalllog();
	}
	
	public String getInstanceId() {
		return installapplicationinstance_.getInstanceId();
	}
	
	public InstallApplication(String applicationname, String version, String instanceid, String instancename, String description, String data) {
		applicationname_ = applicationname;
		version_ = version;
		instanceid_ = instanceid;
		instancename_ = instancename;
		description_ = description;
		installapplicationinstance_ = registerApplicationInstance(applicationname, version, instanceid, instancename, description);
		registerPort();
		try {
			data_ = JSONFactoryUtil.createJSONObject(data);
		} catch (JSONException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "InstallApplication(String applicationname, String version, String instanceid, String instancename, String description, String data)", "Error creating JSONObject from data field. data:" + data + " InstanceId: " + instanceid));
			e.printStackTrace();
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "InstallApplication(String applicationname, String version, String instanceid, String instancename, String description, String data)", "Error creating JSONObject from data field. data:" + data + " InstanceId: " + instanceid, e.getStackTrace(), installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
		}
	}
	
	public void callInstallScript(String applicationfolder) {
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
	
	public void addProxyEntry(String applicationfolder) {
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
	
	public void pullDockerCompose() {
		
	}
	
	public void startDockerCompose() {
		installapplicationinstance_.startUpApplicationInstance();
	}
	
	private ApplicationInstance registerApplicationInstance(String applicationname, String version, String instanceid, String instancename, String description) {
		ApplicationInstance applicationinstance = ApplicationInstanceLocalServiceUtil.createApplicationInstance(CounterLocalServiceUtil.increment());
		applicationinstance.setApplication(applicationname);
		applicationinstance.setVersion(version);
		applicationinstance.setInstanceId(instanceid);
		applicationinstance.setName(instancename);
		applicationinstance.setDescription(description);
		applicationinstance.setInstalllog(FormatExceptionMessage.formatLogMessage("INFO", "Application instance registered"));
		applicationinstance = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(applicationinstance);
		applicationinstance.setFolderName(instanceid + "-" + applicationname);
		return applicationinstance;
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
	
	private String getInstallationConfigString() {
		String parameters = "";
		Iterator<String> iterator = data_.keys();
		while (iterator.hasNext()) {
			String key = iterator.next();
			parameters += " --" + key + " \"" + data_.getString(key) + "\"";
		}
		return parameters;
	}
}
