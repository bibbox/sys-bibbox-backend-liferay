package at.graz.meduni.bibbox.liferay.backgroundtasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
import com.liferay.portal.kernel.security.permission.ActionKeys;

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
	private boolean new_install_ = false;
	private HashSet<ApplicationInstancePort> application_instance_ports_ = new HashSet<ApplicationInstancePort>();

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
			
			// Switch for new install
			File f = new File(applicationfolder_ + "/file_structure.json");
			System.out.println(applicationfolder_ + "/file_structure.json");
			if(f.exists()) { 
				System.out.println("New Installer");
				new_install_ = true;
				// Create folder (1)
				createFolder();
				// Copy files (2)
				copyFiles();
				// Register Port (3)
				registerPorts();
				// Register Containers (4)
				registerContainers("(4/8)");
				// write json files
				writeConfigurationFiles();
				// Create compose file (5)
				runInstallScript();
				// add Proxy (6)
				writeProxyFiles();
				// pullDocker (7)
				pullDockerCompose("(7/8)");
				// start Docker (8)
				startDockerCompose("(8/8)");
				
			// Switch for old install
			} else {
				System.out.println("Old Installer");
				registerPort();
				registerContainers("(2/6)");
				try {
					readData();
				} catch (Exception ex) {
					System.err.println(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "execute(BackgroundTask backgroundTask)", "ERROR READ DATA. applicationfolder:" + applicationfolder_));
					ex.printStackTrace();
					result_status_ = "ERROR";
				}
				callInstallScript();
				addProxyEntry();
				pullDockerCompose("(5/6)");
				startDockerCompose("6/6");
			}
			
			// Common Part
			
			installapplicationinstance_.setIsinstalling(false);
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
			finishActivity();
		} catch (Exception ex) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "execute(BackgroundTask backgroundTask)", "Error running backgroundTask. applicationfolder:" + applicationfolder_));
			ex.printStackTrace();
			result_status_ = "ERROR";
			finishActivity();
			if(installapplicationinstance_ != null) {
				installapplicationinstance_.setIsinstalling(false);
				installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
			}
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
	
	private void createFolder() {
		String installlog = FormatExceptionMessage.formatLogMessage("INFO", "New Setup script.", installapplicationinstance_.getInstalllog());
		boolean success = (new File(installapplicationinstance_.getFolderPath())).mkdirs();
		if (success) {
			installlog = FormatExceptionMessage.formatLogMessage("INFO", "Instance folder created: " + installapplicationinstance_.getFolderPath(), installlog);
		} else {
			installlog = FormatExceptionMessage.formatLogMessage("ERROR", "Cound not create Instance folder: " + installapplicationinstance_.getFolderPath(), installlog);
		}
	}
	
	private void copyFiles() {
		try{ 
			ProcessBuilder processbuilder = new ProcessBuilder("python3", "copyapplication.py", "-a "+applicationfolder_,"-i "+installapplicationinstance_.getFolderPath());
			processbuilder.directory(new File(BibboxConfigReader.getScriptPWD() + "/app-install"));
			Process process = processbuilder.start();
			process.waitFor();
				
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String log;
			String installlog = FormatExceptionMessage.formatLogMessage("INFO", "(2/8) Install Application.", installapplicationinstance_.getInstalllog());
			while ((log = reader.readLine()) != null) 
			{
				String loglevel = "ERROR";
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
		} catch(Exception e){
			System.err.println(e);
		}
	}
	
	private void registerPorts() {
		try {
			String jsonstring = BibboxConfigReader.readApplicationsStoreJsonFile(applicationfolder_ + "/portinfo.json");
			
			JSONObject sysinfo = JSONFactoryUtil.createJSONObject(jsonstring);
			JSONArray mappings = sysinfo.getJSONArray("mappings");
			Iterator<?> iterator = mappings.iterator();
			while (iterator.hasNext()) {
				String portmap_string = iterator.next().toString();
				JSONObject portmap = JSONFactoryUtil.createJSONObject(portmap_string);
				String portId = portmap.getString("id");
				String proxy = portmap.getString("proxy");
				String subdomain = portmap.getString("url");
				registerPort(portId, proxy, subdomain);
			}
					
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatLogMessage("INFO", "(3/8) Setting primary port for application.", installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
			ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", "(3/8) Register Ports.");
		} catch (JSONException ex) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "registerPorts()", "ERROR register port for application: applicationfolder:" + applicationfolder_));
			ex.printStackTrace();
			result_status_ = "ERROR";
		}
	}
	
	private void registerPort(String portId, String proxy, String subdomain) {
		long port = PortRegister.getNextAvailablePort();
		ApplicationInstancePort applicationinstanceport = ApplicationInstancePortLocalServiceUtil.createApplicationInstancePort(CounterLocalServiceUtil.increment());
		applicationinstanceport.setApplicationInstanceId(installapplicationinstance_.getApplicationInstanceId());
		applicationinstanceport.setPort(port);
		applicationinstanceport.setPortId(portId);
		subdomain = subdomain.replaceAll("§§INSTANCE", installapplicationinstance_.getBaseurl());
		applicationinstanceport.setSubdomain(subdomain);
		boolean primary = false;
		if(proxy.equalsIgnoreCase("PRIMARY")) {
			primary = true;
		}
		applicationinstanceport.setPrimary(primary);
		applicationinstanceport = ApplicationInstancePortLocalServiceUtil.updateApplicationInstancePort(applicationinstanceport);
		application_instance_ports_.add(applicationinstanceport);
	}
	
	private void registerPort() {
		long port = PortRegister.getNextAvailablePort();
		ApplicationInstancePort applicationinstanceport = ApplicationInstancePortLocalServiceUtil.createApplicationInstancePort(CounterLocalServiceUtil.increment());
		applicationinstanceport.setApplicationInstanceId(installapplicationinstance_.getApplicationInstanceId());
		applicationinstanceport.setPort(port);
		applicationinstanceport.setPrimary(true);
		installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatLogMessage("INFO", "(1/6) Setting primary port for application to " + port, installapplicationinstance_.getInstalllog()));
		installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
		ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", "(1/6) Register Ports.");
		applicationinstanceport = ApplicationInstancePortLocalServiceUtil.updateApplicationInstancePort(applicationinstanceport);
	}
	
	private void registerContainers(String counter) {
		String applicationfolder = BibboxConfigReader.getApplicationFolder(installapplicationinstance_.getApplication(), installapplicationinstance_.getVersion());
		try {
			ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", counter + " Register Containers.");
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatLogMessage("INFO", counter + " Setting containers for instance", installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
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
		} catch (JSONException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "registerContainers()", "Error reading sys-info file. applicationfolder:" + applicationfolder));
			e.printStackTrace();
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "registerContainers()", "Error reading sys-info file. applicationfolder:" + applicationfolder, e.getStackTrace(), installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
			ActivitiesProtocol.addActivityLogEntry(activityId_, "ERROR", FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "registerContainers()", "Error reading sys-info file. applicationfolder:" + applicationfolder, e.getStackTrace()));
			result_status_ = "ERROR";
		} catch (Exception e) {
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
	
	private void writeConfigurationFiles() {
		writePortConfigFile();
		writeEnvironmentConfigFile();
		writeConfigConfigFile();
	}
	
	private void writePortConfigFile() {
		try {
			File fout = new File(installapplicationinstance_.getFolderPath() + "/portmap.json");
			FileOutputStream fos;
		
			fos = new FileOutputStream(fout);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			
			bw.write("{");
			bw.newLine();
			bw.write("  \"instance\":\"" + installapplicationinstance_.getInstanceId() + "\",");
			bw.newLine();
			
			for (ApplicationInstancePort application_instance_port : application_instance_ports_) {
				bw.write("  \"" + application_instance_port.getPortId() + "\":\"" + application_instance_port.getPort() + "\",");
				bw.newLine();
			}
			
			bw.write("  \"baseurl\":\"" + installapplicationinstance_.getBaseurl() + "\"");
			bw.newLine();
			bw.write("}");
		 
			bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private void writeEnvironmentConfigFile() {
		try {
			File fout = new File(installapplicationinstance_.getFolderPath() + "/environment-parameters-settings.json");
			FileOutputStream fos;
		
			fos = new FileOutputStream(fout);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			
			String datasting = "";
			Serializable dataserializable = taskContextMap_.get("data");
			System.out.println(dataserializable);
			if(dataserializable != null) {
				datasting = dataserializable.toString();
			}
			
			JSONObject tmp = JSONFactoryUtil.createJSONObject(datasting);
			datasting = tmp.toJSONString();
			
			bw.write(datasting);
			bw.newLine();
		 
			bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private void writeConfigConfigFile() {
		try {
			File fout = new File(installapplicationinstance_.getFolderPath() + "/config-parameters-settings.json");
			FileOutputStream fos;
		
			fos = new FileOutputStream(fout);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			
			bw.write("{}");
			bw.newLine();
		 
			bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private void runInstallScript() {
		try{ 
			ProcessBuilder processbuilder = new ProcessBuilder("python3", "install.py", "-a "+applicationfolder_,"-i "+installapplicationinstance_.getFolderPath());
			processbuilder.directory(new File(BibboxConfigReader.getScriptPWD() + "/app-install"));
			Process process = processbuilder.start();
			process.waitFor();
				
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String log;
			String installlog = FormatExceptionMessage.formatLogMessage("INFO", "(5/8) Install Application.", installapplicationinstance_.getInstalllog());
			while ((log = reader.readLine()) != null) 
			{
				String loglevel = "ERROR";
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
		} catch(Exception e){
			System.err.println(e);
		}
	}
	
	private void writeProxyFiles() {
		try{ 
			ProcessBuilder processbuilder = new ProcessBuilder("python3", "port.py", "-a "+applicationfolder_,"-i "+installapplicationinstance_.getFolderPath());
			processbuilder.directory(new File(BibboxConfigReader.getScriptPWD() + "/app-install"));
			Process process = processbuilder.start();
			process.waitFor();
				
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String log;
			String installlog = FormatExceptionMessage.formatLogMessage("INFO", "(6/8) Install Application.", installapplicationinstance_.getInstalllog());
			while ((log = reader.readLine()) != null) 
			{
				String loglevel = "ERROR";
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
		} catch(Exception e){
			System.err.println(e);
		}
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
			ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", "(3/6) Install Application.");
			
			addExecutePrivilageToFile("install.sh");
			ProcessBuilder processbuilder = new ProcessBuilder("/bin/bash", "-c", "./install.sh " + installapplicationinstance_.getBaseInstallationConfigString() + getInstallationConfigString());
			processbuilder.directory(new File(applicationfolder_));
			Process process = processbuilder.start();
			process.waitFor();
				
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String log;
			String installlog = FormatExceptionMessage.formatLogMessage("INFO", "(3/6) Install Application.", installapplicationinstance_.getInstalllog());
			while ((log = reader.readLine()) != null) 
			{
				String loglevel = "ERROR";
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
			System.err.println(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "callInstallScript()", "File Error running install.sh. applicationfolder:" + applicationfolder_));
			e.printStackTrace();
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "callInstallScript()", "File Error running install.sh. applicationfolder:" + applicationfolder_, e.getStackTrace(), installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
			ActivitiesProtocol.addActivityLogEntry(activityId_, "ERROR", FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "callInstallScript()", "File Error running install.sh. applicationfolder:" + applicationfolder_, e.getStackTrace()));
			result_status_ = "ERROR";
		} catch (InterruptedException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "callInstallScript()", "Error running install.sh. applicationfolder:" + applicationfolder_));
			e.printStackTrace();
			installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "callInstallScript()", "Error running install.sh. applicationfolder:" + applicationfolder_, e.getStackTrace(), installapplicationinstance_.getInstalllog()));
			installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
			ActivitiesProtocol.addActivityLogEntry(activityId_, "ERROR", FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "callInstallScript()", "Error running install.sh. applicationfolder:" + applicationfolder_, e.getStackTrace()));
			result_status_ = "ERROR";
		}
	}
	
	private void addExecutePrivilageToFile(String filename) {
		try {
			ProcessBuilder processbuilder = new ProcessBuilder("/bin/bash", "-c", "chmod +x " + filename);
			processbuilder.directory(new File(applicationfolder_));
			Process process = processbuilder.start();
			process.waitFor();
		} catch(IOException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("ERROR", log_portlet_, log_classname_, "addExecutePrivilageToFile(String filename)", "File Error adding execute permission to file:" + applicationfolder_ + "/" + filename));
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "addExecutePrivilageToFile(String filename)", "Error adding execute permission to file:" + applicationfolder_ + "/" + filename));
			e.printStackTrace();
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
			ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", "(4/6) Add Proxy.");
			addExecutePrivilageToFile("addproxy.sh");
			ProcessBuilder processbuilder = new ProcessBuilder("/bin/bash", "-c", "./addproxy.sh " + installapplicationinstance_.getBasicProxyConfigString());
			processbuilder.directory(new File(applicationfolder_));
			Process process = processbuilder.start();
			process.waitFor();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String log;
			String installlog = FormatExceptionMessage.formatLogMessage("INFO", "(4/6) Add Proxy.", installapplicationinstance_.getInstalllog());
			while ((log = reader.readLine()) != null) 
			{
				String loglevel = "ERROR";
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

	private void pullDockerCompose(String step) {
		ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", step + " Pulling Container.");
		String log = installapplicationinstance_.composePullApplicationInstance();
		installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatLogMessage("INFO", step + " Pulling Container.", installapplicationinstance_.getInstalllog()));
		installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatLogMessage("INFO", log, installapplicationinstance_.getInstalllog()));
		ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", log);
	}
	
	private void startDockerCompose(String step) {
		ActivitiesProtocol.addActivityLogEntry(activityId_, "INFO", step + " Starting Container.");
		String log = installapplicationinstance_.composeUpApplicationInstance();
		installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatLogMessage("INFO", step + " Starting Container.", installapplicationinstance_.getInstalllog()));
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
		installapplicationinstance_.setInstalllog(FormatExceptionMessage.formatLogMessage("INFO", "installation finished", installapplicationinstance_.getInstalllog()));
		installapplicationinstance_ = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(installapplicationinstance_);
	}
}
