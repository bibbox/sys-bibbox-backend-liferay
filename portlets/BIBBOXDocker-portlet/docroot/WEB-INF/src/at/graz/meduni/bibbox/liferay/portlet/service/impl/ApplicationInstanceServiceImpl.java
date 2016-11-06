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

package at.graz.meduni.bibbox.liferay.portlet.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;

import aQute.bnd.annotation.ProviderType;
import at.graz.meduni.bibbox.helper.BibboxConfigReader;
import at.graz.meduni.bibbox.helper.FormatExceptionMessage;
import at.graz.meduni.bibbox.helper.InstallApplication;
import at.graz.meduni.bibbox.helper.UpdateGitRepositoriesBackgroundTask;
import at.graz.meduni.bibbox.helper.UpdateGitRepository;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.base.ApplicationInstanceServiceBaseImpl;

/**
 * The implementation of the application instance remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationInstanceServiceBaseImpl
 * @see at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceServiceUtil
 */
@ProviderType
public class ApplicationInstanceServiceImpl
	extends ApplicationInstanceServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceServiceUtil} to access the application instance remote service.
	 */
	
	/**
	 * Error Format for date
	 */
	private String log_portlet_ = "BIBBOXDocker";
	private String log_classname_ = "at.graz.meduni.bibbox.liferay.portlet.service.impl.ApplicationInstanceServiceImpl";
	
	@JSONWebService("/get-application-store-list")
	public JSONObject getApplicationStoreListAPI() {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		returnobject.put("status", "local");
		returnobject.put("groups", getApplicationStoreList());
		return returnobject;
	}
	
	@JSONWebService("/get-updated-application-store-list")
	public JSONObject getUpdatedApplicationStoreListAPI() {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		UpdateGitRepository updategitrepository = new UpdateGitRepository();
		String gitstatus = updategitrepository.updateLocalGitRepository(BibboxConfigReader.getApplicationStorePWD() + "/application-store");
		returnobject.put("status", gitstatus);
		returnobject.put("groups", getApplicationStoreList());
		UpdateGitRepositoriesBackgroundTask updategitrepositoriesbackgroundtask = new UpdateGitRepositoriesBackgroundTask("Update Application Store");
		updategitrepositoriesbackgroundtask.start();
		return returnobject;
	}
	
	@JSONWebService("/get-application-store-item")
	public JSONObject getApplicationStoreItemAPI(String applicationname, String version) {
		return getApplicationStoreItem(applicationname, version);
	}
	
	@JSONWebService(value = "/install-application", method = "POST")
	public JSONObject installApplicationAPI(String applicationname, String version, String instanceid, String instancename, String description, String data) {
		JSONObject returnobject = installApplication(applicationname, version, instanceid, instancename, description, data);
		return returnobject;
	}
	
	@JSONWebService(value = "/instance-list", method = "POST")
	public JSONObject getInstanceListAPI() {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		returnobject.put("instances", getInstanceList());
		return returnobject;
	}
	
	private JSONArray getApplicationStoreList() {
		try {
			String applicationstore = BibboxConfigReader.getApplicationStorePWD();
			String jsonstring = BibboxConfigReader.readApplicationsStoreJsonFile(applicationstore + "/application-store/eB3kit.json");
			return JSONFactoryUtil.createJSONArray(jsonstring);
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getApplicationStoreList()", "Error reading application store list."));
			e.printStackTrace();
		}
		return JSONFactoryUtil.createJSONArray();
	}
	
	
	
	private JSONObject getApplicationStoreItem(String applicationname, String version) {
		JSONObject retrunobject = null;
		if(version.equalsIgnoreCase("development")) {
			retrunobject = getApplicationStoreItemDeveloperVersion(applicationname);
		} else {
			retrunobject = getApplicationStoreItemVersion(applicationname, version);
		}
		retrunobject.put("install", getApplicationStoreItemInstallParameters(applicationname, version));
		return retrunobject;
	}
	
	private JSONObject getApplicationStoreItemDeveloperVersion(String applicationname) {
		try {
			UpdateGitRepository updategitrepository = new UpdateGitRepository();
			String applicationstore = BibboxConfigReader.getApplicationStorePWD();
			String jsonstring = "";
			String applicationfolder = BibboxConfigReader.getApplicationFolder(applicationname, "development");
			if(updategitrepository.checkIfLocalRepositoryExists(applicationfolder)) {
				updategitrepository.updateLocalGitRepository(applicationfolder);
				jsonstring = BibboxConfigReader.readApplicationsStoreJsonFile(applicationfolder + "/appinfo.json");
			} else {
				updategitrepository.cloneRepositoryToFolder(applicationfolder, applicationname);
				jsonstring = BibboxConfigReader.readApplicationsStoreJsonFile(applicationfolder + "/appinfo.json");
			}
			return JSONFactoryUtil.createJSONObject(jsonstring);
		} catch (JSONException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getApplicationStoreItemDeveloperVersion(String applicationname)", "Error reading application store jason file. Applicationname:" + applicationname));
			e.printStackTrace();
		}
		return JSONFactoryUtil.createJSONObject();
	}
	
	private JSONObject getApplicationStoreItemVersion(String applicationname, String version) {
		try {
			UpdateGitRepository updategitrepository = new UpdateGitRepository();
			//String applicationstore = BibboxConfigReader.getApplicationStorePWD();
			String jsonstring = "";
			String applicationfolder = BibboxConfigReader.getApplicationFolder(applicationname, version);
			String applicationfolderdevelopment = BibboxConfigReader.getApplicationFolder(applicationname, "development");
			if(updategitrepository.checkIfLocalRepositoryExists(applicationfolder)) {
				jsonstring = BibboxConfigReader.readApplicationsStoreJsonFile(applicationfolder + "/appinfo.json");
			} else {
				if(!updategitrepository.checkIfLocalRepositoryExists(applicationfolderdevelopment)) {
					updategitrepository.cloneRepositoryToFolder(applicationfolderdevelopment, applicationname);
				} else {
					updategitrepository.updateLocalGitRepository(applicationfolderdevelopment);
				}
				updategitrepository.createTagFodler(applicationname, version);
				jsonstring = BibboxConfigReader.readApplicationsStoreJsonFile(applicationfolder + "/appinfo.json");
			}
			return JSONFactoryUtil.createJSONObject(jsonstring);
		} catch (JSONException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getApplicationStoreItemVersion(String applicationname, String version)", "Error reading application store json file. Applicationname:" + applicationname + " Version: " + version));
			e.printStackTrace();
		}
		return JSONFactoryUtil.createJSONObject();
	}
	
	private JSONArray getApplicationStoreItemInstallParameters(String applicationname, String version) {
		try {
			String applicationstore = BibboxConfigReader.getApplicationStorePWD();
			String jsonstring = "";
			String applicationfolder = BibboxConfigReader.getApplicationFolder(applicationname, version);
			jsonstring = BibboxConfigReader.readApplicationsStoreJsonFile(applicationfolder + "/environment-parameters.json");
			return JSONFactoryUtil.createJSONArray(jsonstring);
		} catch (JSONException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getApplicationStoreItemInstallParameters(String applicationname, String version)", "Error reading application store environment-parameters.json file. Applicationname:" + applicationname + " Version: " + version));
			e.printStackTrace();
		}
		return JSONFactoryUtil.createJSONArray();
	}
	
	private JSONObject installApplication(String applicationname, String version, String instanceid, String instancename, String description, String data) {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		
		if(ApplicationInstanceLocalServiceUtil.checkInstanceNameAvailable(instanceid)) {
			returnobject.put("status", "error");
			returnobject.put("error", "InstanceId alredy exists!");
			return returnobject;
		}
		
		String applicationfodler = BibboxConfigReader.getApplicationFolder(applicationname, version);
		
		InstallApplication installapplication = new InstallApplication(applicationname, version, instanceid, instancename, description, data);
		installapplication.callInstallScript(applicationfodler);
		installapplication.addProxyEntry(applicationfodler);
		installapplication.startDockerCompose();
		
		returnobject.put("status", "installing");
		returnobject.put("instanceid", installapplication.getInstanceId());
		returnobject.put("log", installapplication.getLog());
		return returnobject;
	}
	
	private JSONArray getInstanceList() {
		JSONArray returnobject = JSONFactoryUtil.createJSONArray();
		List<ApplicationInstance> applicationinstances = ApplicationInstanceLocalServiceUtil.getApplicationInstances(-1, -1);
		String status = "available";
		for(ApplicationInstance applicationinstance : applicationinstances) {
			JSONObject instanceobject = JSONFactoryUtil.createJSONObject();
			instanceobject.put("instanceid", applicationinstance.getInstanceId());
			instanceobject.put("instancename", applicationinstance.getName());
			instanceobject.put("instanceshortname", applicationinstance.getShortName());
			instanceobject.put("description", applicationinstance.getDescription());
			instanceobject.put("application", applicationinstance.getApplication());
			instanceobject.put("version", applicationinstance.getVersion());
			instanceobject.put("status", status);
			instanceobject.put("applicationname", "OpenSpecimen");
			JSONArray tagarray = JSONFactoryUtil.createJSONArray();
			tagarray.put("Sample Management");
			tagarray.put("LIMS");
			instanceobject.put("tags", tagarray);
			returnobject.put(instanceobject);
			if(status.equals("available")) {
				status = "maintenance";
			} else {
				status = "available";
			}
		}
		return returnobject;
	}
}