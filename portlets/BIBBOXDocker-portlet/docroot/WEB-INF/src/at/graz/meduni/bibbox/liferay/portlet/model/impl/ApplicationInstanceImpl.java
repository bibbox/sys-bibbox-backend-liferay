/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package at.graz.meduni.bibbox.liferay.portlet.model.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import aQute.bnd.annotation.ProviderType;
import at.graz.meduni.bibbox.helper.BibboxConfigReader;
import at.graz.meduni.bibbox.helper.FormatExceptionMessage;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceContainerLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstancePortLocalServiceUtil;

/**
 * The extended model implementation for the ApplicationInstance service. Represents a row in the &quot;bibboxdocker_ApplicationInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance} interface.
 * </p>
 *
 * @author Robert Reihs
 */
@ProviderType
public class ApplicationInstanceImpl extends ApplicationInstanceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a application instance model instance should use the {@link at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance} interface instead.
	 */
	public ApplicationInstanceImpl() {
	}
	
	/**
	 * Error Format for date
	 */
	private static String log_portlet_ = "BIBBOXDocker";
	private static String log_classname_ = "at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceImpl";
	
	private static String applicationname_ = null;
	private static JSONArray tags_ = null;
	
	public String getBaseInstallationConfigString() {
		String installationconfigstring = "";
		installationconfigstring += " -i \"" + this.getInstanceId() + "\"";
		installationconfigstring += " -f \"" + this.getFolderPath() + "\"";
		installationconfigstring += " -p \"" + this.getPrimaryPort() + "\"";
		return installationconfigstring;
	}
	
	public String getBasicProxyConfigString() {
		String installationconfigstring = "";
		installationconfigstring += " -i \"" + this.getInstanceId() + "\"";
		installationconfigstring += " -s \"" + this.getInstanceId() + "\"";
		installationconfigstring += " -p \"" + this.getPrimaryPort() + "\"";
		installationconfigstring += " -u \"" + BibboxConfigReader.getBaseURL() + "\"";
		return installationconfigstring;
	}
	
	public String getFolderPath() {
		return BibboxConfigReader.getInstancePWD() + "/" + this.getFolderName();
	}
	
	public long getPrimaryPort() {
		return ApplicationInstancePortLocalServiceUtil.getPrimaryPortForInstance(this.getApplicationInstanceId());
	}
	
	public List<ApplicationInstancePort> getApplicationPorts() {
		return ApplicationInstancePortLocalServiceUtil.getApplicationInstancePortForInstance(this.getApplicationInstanceId());
	}
	
	public String stopApplicationInstance() {
		String installlog = "";
		try {
			ProcessBuilder processbuilder = new ProcessBuilder("/bin/bash", "-c", "docker-compose stop");
			processbuilder.directory(new File(this.getFolderPath()));
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
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "startUpApplicationInstance()", "Error startign docker-compose.yml file for instance:" + this.getInstanceId()));
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "startUpApplicationInstance()", "Error startign docker-compose.yml file for instance:" + this.getInstanceId()));
			e.printStackTrace();
		}
		return installlog;
	}
	
	public String startApplicationInstance() {
		String installlog = "";
		try {
			ProcessBuilder processbuilder = new ProcessBuilder("/bin/bash", "-c", "docker-compose up -d");
			processbuilder.directory(new File(this.getFolderPath()));
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
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "startUpApplicationInstance()", "Error startign docker-compose.yml file for instance:" + this.getInstanceId()));
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "startUpApplicationInstance()", "Error startign docker-compose.yml file for instance:" + this.getInstanceId()));
			e.printStackTrace();
		}
		return installlog;
	}
	
	public String restartApplicationInstance() {
		String installlog = "";
		try {
			ProcessBuilder processbuilder = new ProcessBuilder("/bin/bash", "-c", "docker-compose restart");
			processbuilder.directory(new File(this.getFolderPath()));
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
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "startUpApplicationInstance()", "Error startign docker-compose.yml file for instance:" + this.getInstanceId()));
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "startUpApplicationInstance()", "Error startign docker-compose.yml file for instance:" + this.getInstanceId()));
			e.printStackTrace();
		}
		return installlog;
	}
	
	public JSONArray getComposeLog(String lines) {
		JSONArray returnobject = JSONFactoryUtil.createJSONArray();
		for(ApplicationInstanceContainer container : getContainers()) {
			returnobject.put(container.getContainerLog(lines));
		}
		returnobject.put(getInstallLog());
		return returnobject;
	}
	
	public JSONObject getInstanceJSONObject() {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		returnobject.put("instancename", this.getName());
		returnobject.put("instanceshortname", this.getShortName());
		returnobject.put("instanceid", this.getInstanceId());
		returnobject.put("url", this.getInstanceUrl());
		returnobject.put("longdescription", this.getDescription());
		returnobject.put("shortdescription", this.getShortdescription());
		returnobject.put("applicationname", this.getApplication());
		returnobject.put("version", this.getVersion());
		returnobject.put("status", this.getApplicationStatus());
		returnobject.put("ismaintenance", this.getIsmaintenance());
		return returnobject;
	}
	
	public String getInstanceUrl() {
		return "http://" + this.getInstanceId() + "." + this.getBaseurl();
	}
	
	public List<ApplicationInstanceContainer> getContainersNeedToRun() {
		return ApplicationInstanceContainerLocalServiceUtil.getApplicationInstanceContainerNeedToRun(this.getApplicationInstanceId());
	}
	
	public List<ApplicationInstanceContainer> getContainers() {
		return ApplicationInstanceContainerLocalServiceUtil.getApplicationInstanceContainerForInstance(this.getApplicationInstanceId());
	}
	
	public String getApplicationStatus() {
		if(this.getIsinstalling()) {
			return "installing";
		} else {
			String status = "running";
			for(ApplicationInstanceContainer container : getContainersNeedToRun()) {
				if(!container.getRunning()) {
					status = "stopped";
				}
			}
			if(!this.getStatus().equals("")) {
				status = this.getStatus();
			}
			return status;
		}
	}
	
	public String getApplicationname() {
		if(applicationname_ == null) {
			JSONObject application = getApplicationfile();
			String applicationname_ = application.getString("short_name");
			if(applicationname_.equals("")) {
				applicationname_ = this.getApplication();
			}
		}
		return applicationname_;
	}
	
	public JSONArray getApplicationTags() {
		if(tags_ == null) {
			JSONObject application = getApplicationfile();
			tags_ = application.getJSONArray("tags");
		}
		return tags_;
	}
	
	private JSONObject getApplicationfile() {
		String applicationfolder = BibboxConfigReader.getApplicationFolder(this.getApplication(), this.getVersion());
		String jsonstring = BibboxConfigReader.readApplicationsStoreJsonFile(applicationfolder + "/appinfo.json");
		JSONObject object = JSONFactoryUtil.createJSONObject();
		try {
			object = JSONFactoryUtil.createJSONObject(jsonstring);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
	
	private JSONObject getInstallLog() {
		JSONObject object = JSONFactoryUtil.createJSONObject();
		object.put("containername", "install");
		object.put("log", this.getInstalllog());
		object.put("cmd", "");
		return object;
	}
}