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
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutorRegistryUtil;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskManagerUtil;
import com.liferay.portal.kernel.exception.PortalException;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.json.JSONFactoryUtil;

import at.graz.meduni.bibbox.helper.BibboxConfigReader;
import at.graz.meduni.bibbox.helper.FormatExceptionMessage;
import at.graz.meduni.bibbox.helper.InstallApplication;
import at.graz.meduni.bibbox.helper.UpdateGitRepositoriesBackgroundTask;
import at.graz.meduni.bibbox.helper.UpdateGitRepository;
import at.graz.meduni.bibbox.liferay.backgroundtasks.BibboxBackgroundTaskExecutorNames;
import at.graz.meduni.bibbox.liferay.backgroundtasks.InstallApplicationBG;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceContainerLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstancePortLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.base.ApplicationInstanceServiceBaseImpl;
import at.graz.meduni.bibbox.threadtasks.ThreadTaskController;

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
		returnobject.put("user", getUserObject());
		return returnobject;
	}
	
	@JSONWebService("/get-updated-application-store-list")
	public JSONObject getUpdatedApplicationStoreListAPI() {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		UpdateGitRepository updategitrepository = new UpdateGitRepository();
		String gitstatus = updategitrepository.updateLocalGitRepository(BibboxConfigReader.getApplicationStorePWD() + "/application-store");
		returnobject.put("status", gitstatus);
		returnobject.put("groups", getApplicationStoreList());
		returnobject.put("user", getUserObject());
		UpdateGitRepositoriesBackgroundTask updategitrepositoriesbackgroundtask = new UpdateGitRepositoriesBackgroundTask("Update Application Store");
		updategitrepositoriesbackgroundtask.start();
		return returnobject;
	}
	
	@JSONWebService("/get-application-store-item")
	public JSONObject getApplicationStoreItemAPI(String applicationname, String version) {
		JSONObject returnobject = getApplicationStoreItem(applicationname, version);
		returnobject.put("user", getUserObject());
		return returnobject;
	}
	
	@JSONWebService(value = "/install-application", method = "POST")
	public JSONObject installApplicationAPI(String applicationname, String version, String instanceid, String instancename, String data) {
		JSONObject returnobject = installApplication(applicationname, version, instanceid, instancename, data);
		returnobject.put("user", getUserObject());
		return returnobject;
	}
	
	@JSONWebService(value = "/get-instance-list")
	public JSONObject getInstanceListAPI() {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		returnobject.put("instances", getInstanceList());
		returnobject.put("user", getUserObject());
		return returnobject;
	}
	
	@JSONWebService(value = "/get-instance-info")
	public JSONObject getInstanceInfoAPI(String instanceId) {
		JSONObject returnobject = getInstanceInfo(instanceId);
		returnobject.put("user", getUserObject());
		return returnobject;
	}
	
	@JSONWebService(value = "/get-instance-dashboard")
	public JSONObject getInstanceDashboardAPI(String instanceId) {
		JSONObject returnobject = getInstanceDashboard(instanceId);
		returnobject.put("user", getUserObject());
		return returnobject;
	}
	
	@JSONWebService(value = "/get-instance-log")
	public JSONObject getInstanceLogdAPI(String instanceId, String logtype) {
		JSONObject returnobject = getInstanceLogd(instanceId, logtype);
		returnobject.put("user", getUserObject());
		return returnobject;
	}
	
	@JSONWebService(value = "/get-instance-maintenance")
	public JSONObject getInstanceMaintenanceAPI(String instanceId) {
		JSONObject returnobject = getInstanceMaintenance(instanceId);
		returnobject.put("user", getUserObject());
		return returnobject;
	}
	
	@JSONWebService(value = "/update-instance-info", method = "POST")
	public JSONObject updateInstanceInfoAPI(String instanceId, String instancename, String instanceshortname, String description, String shortdescription, String adminnode, String maintenance) {
		JSONObject returnobject = updateInstanceInfo(instanceId, instancename, instanceshortname, description, shortdescription, adminnode, maintenance);
		returnobject.put("user", getUserObject());
		return returnobject;
	}
	
	@JSONWebService(value = "/delete-instance-status")
	public JSONObject deleteInstanceStatusAPI(String instanceId) {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		deleteInstance(instanceId);
		returnobject.put("user", getUserObject());
		return returnobject;
	}
	
	@JSONWebService(value = "/set-instance-status")
	public JSONObject setInstanceStatusAPI(String instanceId, String status) {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		if(status.equalsIgnoreCase("start")) {
			startInstance(instanceId);
		} else if(status.equalsIgnoreCase("stop")) {
			stopInstance(instanceId);
		} else if(status.equalsIgnoreCase("restart")) {
			restartInstance(instanceId);
		} else {
			returnobject.put("status", "error");
			returnobject.put("error", "Status not know!");
		}
		returnobject.put("user", getUserObject());
		return returnobject;
	}
	
	@JSONWebService(value = "/toggl-instance-maintenance-status")
	public JSONObject togglInstanceMaintenanceStatusAPI(String instanceId) {
		JSONObject returnobject = togglInstanceMaintenanceStatus(instanceId);
		returnobject.put("user", getUserObject());
		return returnobject;
	}
	
	@JSONWebService(value = "/get-id-mapping-info")
	public JSONObject getIdMappingInfoAPI(String instanceId) {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		ApplicationInstance applicationinstance = ApplicationInstanceLocalServiceUtil.getApplicationInstance(instanceId);
		if(applicationinstance == null) {
			returnobject.put("status", "error");
			returnobject.put("error", "InstanceId dose not exist!");
		} else {
			try {
				String jsonstring = BibboxConfigReader.readApplicationsStoreJsonFile(BibboxConfigReader.getApplicationFolder(applicationinstance.getApplication(), applicationinstance.getVersion()) + "/id-mapping-info.json");
				return JSONFactoryUtil.createJSONObject(jsonstring);
			} catch (JSONException e) {
				returnobject.put("status", "error");
				returnobject.put("error", "Parsing JSON file: " + e.getMessage());
				System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getIdMappingInfoAPI(String instanceId)", "Error parsing id-mapping-info.json for instance: " + instanceId));
				e.printStackTrace();
			}
		}
		return returnobject;
	}
	
	@JSONWebService(value = "/test")
	public void getTestAPI(String applicationname, String version, String instanceid, String instancename, String data) {
		/*System.out.println("T3");
		testInstallApplication(applicationname, version, instanceid, instancename, data);
		System.out.println("T4");*/
		/*String line = "";
		String abc = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("/Users/reihsr/Documents/BiBBox/docker/app-openspecimen" + "/sys-info.json"));
			System.out.println("/Users/reihsr/Documents/BiBBox/docker/app-openspecimen" + "/sys-info.json");
			StringBuilder sb = null;
			
			try {
			    sb = new StringBuilder();
			    System.out.println("T1");
			    line = br.readLine();
			    System.out.println("T2");
			    while (line != null) {
			    	System.out.println("T3");
			    	System.out.println(line);
			        sb.append(line);
			        abc += line;
			        line = br.readLine();
			        System.out.println("T4");
			    }
			} finally {
			    br.close();
			}
			System.out.println("T5");
		} catch (Exception e) {
			System.out.println("----");
			e.printStackTrace();
		}
		System.out.println(line);
		System.out.println("T6");
		String jsonstring = line;
		System.out.println("T7");
		System.out.println(abc);
		System.out.println("T8");
		System.out.println(abc.replaceAll("[§][§]INSTANCE", "test"));
		System.out.println("T9");*/
		
		/*for(int i = 0; i < 30; i++) {
			ThreadTaskController.addNewTast("T" + i);
		}*/
		
		long userId = 0;
		long groupId = 0;
		//String taskExecutorClassName = "Test";
		String taskExecutorClassName = BibboxBackgroundTaskExecutorNames.BIBBOX_INSTANCE_INSTALLER_BACKGROUND_TASK_EXECUTOR;
		try {
			User user = this.getGuestOrUser();
			Company company = CompanyLocalServiceUtil.getCompany(user.getCompanyId());
			groupId = company.getGroupId();
			userId = user.getUserId();
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getUserObject()", "Error getting user from api call"));
			e.printStackTrace();
		}
		
		Map<String, Serializable> taskContextMap = new HashMap<>();

		taskContextMap.put("configId", 123456);
		
		try {
			BackgroundTask backgroundTask = BackgroundTaskManagerUtil.addBackgroundTask(userId, groupId, taskExecutorClassName, new String[]{"BIBBOXDocker-portlet"}, InstallApplicationBG.class, taskContextMap, new ServiceContext());
			//BackgroundTask backgroundTask = BackgroundTaskManagerUtil.addBackgroundTask(userId, groupId, taskExecutorClassName, taskExecutorClassName, 
					//taskContextMap, new ServiceContext());
			
			System.out.println(backgroundTask.getStatus());
			
			System.out.println("BackgroundTaskId" + backgroundTask.getBackgroundTaskId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*BackgroundTask backgroundTask =
		BackgroundTaskManagerUtil.addBackgroundTask(
			userId, exportImportConfiguration.getGroupId(),
			exportImportConfiguration.getName(),
			BackgroundTaskExecutorNames.
				LAYOUT_EXPORT_BACKGROUND_TASK_EXECUTOR,
			taskContextMap, new ServiceContext());*/
		
		//BackgroundTaskExecutorRegistryUtil.registerBackgroundTaskExecutor(InstallApplicationBG.class.getName(), test);
	}
	
	private JSONObject testInstallApplication(String applicationname, String version, String instanceid, String instancename, String data) {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		
		if(ApplicationInstanceLocalServiceUtil.checkInstanceNameAvailable(instanceid)) {
			returnobject.put("status", "error");
			returnobject.put("error", "InstanceId alredy exists!");
			return returnobject;
		}
		
		//ApplicationInstance applicationinstance = ApplicationInstanceLocalServiceUtil.registerApplication(applicationname, version, instanceid, instancename);
		HashMap<String, String> config_ = new HashMap<String, String>();
		//config_.put("ApplicationInstanceId", applicationinstance.getApplicationInstanceId() + "");
		//ThreadTaskController.addNewTast(applicationinstance.getInstanceId(), "InstallApplicationTask", config_);
		ThreadTaskController.addNewTast("test", "InstallApplicationTask", config_);
		
		returnobject.put("status", "installing");
		returnobject.put("instanceid", instanceid);
		
		/*
		String applicationfodler = BibboxConfigReader.getApplicationFolder(applicationname, version);
		
		InstallApplication installapplication = new InstallApplication(applicationname, version, instanceid, instancename, data);
		installapplication.callInstallScript(applicationfodler);
		installapplication.addProxyEntry(applicationfodler);
		installapplication.startDockerCompose();
		*/
		
		return returnobject;
	}
	
	private JSONArray getApplicationStoreList() {
		try {
			String applicationstore = BibboxConfigReader.getApplicationStorePWD();
			String jsonstring = BibboxConfigReader.readApplicationsStoreJsonFile(applicationstore + "/application-store/" + BibboxConfigReader.getBibboxKit() + ".json");
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
	
	private JSONObject installApplication(String applicationname, String version, String instanceid, String instancename, String data) {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		
		if(ApplicationInstanceLocalServiceUtil.checkInstanceNameAvailable(instanceid)) {
			returnobject.put("status", "error");
			returnobject.put("error", "InstanceId alredy exists!");
			return returnobject;
		}
		
		String applicationfodler = BibboxConfigReader.getApplicationFolder(applicationname, version);
		
		InstallApplication installapplication = new InstallApplication(applicationname, version, instanceid, instancename, data);
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
		List<ApplicationInstance> applicationinstances = ApplicationInstanceLocalServiceUtil.getActiveApplicationInstances();
		for(ApplicationInstance applicationinstance : applicationinstances) {
			JSONObject instanceobject = JSONFactoryUtil.createJSONObject();
			instanceobject.put("instanceid", applicationinstance.getInstanceId());
			instanceobject.put("instancename", applicationinstance.getName());
			instanceobject.put("instanceshortname", applicationinstance.getShortName());
			instanceobject.put("description", applicationinstance.getShortdescription());
			instanceobject.put("application", applicationinstance.getApplication());
			instanceobject.put("version", applicationinstance.getVersion());
			instanceobject.put("status", applicationinstance.getApplicationStatus());
			instanceobject.put("url", applicationinstance.getInstanceUrl());
			instanceobject.put("applicationname", applicationinstance.getApplicationname());
			instanceobject.put("tags", applicationinstance.getApplicationTags());
			returnobject.put(instanceobject);
		}
		return returnobject;
	}
	
	private JSONObject getInstanceInfo(String instanceId) {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		ApplicationInstance applicationinstance = ApplicationInstanceLocalServiceUtil.getApplicationInstance(instanceId);
		if(applicationinstance == null) {
			returnobject.put("status", "error");
			returnobject.put("error", "InstanceId dose not exist!");
		} else {
			returnobject = applicationinstance.getInstanceJSONObject();
			returnobject.put("application", getApplicationStoreItem(applicationinstance.getApplication(), applicationinstance.getVersion()));
			returnobject.put("ismaintenance", applicationinstance.getIsmaintenance());
			return returnobject;
		}
		return returnobject;
	}
	
	private JSONObject getInstanceDashboard(String instanceId) {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		ApplicationInstance applicationinstance = ApplicationInstanceLocalServiceUtil.getApplicationInstance(instanceId);
		if(applicationinstance == null) {
			returnobject.put("status", "error");
			returnobject.put("error", "InstanceId dose not exist!");
		} else {
			returnobject = applicationinstance.getInstanceJSONObject();
			returnobject.put("maintenance", applicationinstance.getMaintenance());
			returnobject.put("adminnode", applicationinstance.getAdminnode());
			returnobject.put("application", getApplicationStoreItem(applicationinstance.getApplication(), applicationinstance.getVersion()));
			return returnobject;
		}
		return returnobject;
	}
	
	private JSONObject getInstanceMaintenance(String instanceId) {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		ApplicationInstance applicationinstance = ApplicationInstanceLocalServiceUtil.getApplicationInstance(instanceId);
		if(applicationinstance == null) {
			returnobject.put("status", "error");
			returnobject.put("error", "InstanceId dose not exist!");
		} else {
			returnobject = applicationinstance.getInstanceJSONObject();
			returnobject.put("maintenance", applicationinstance.getMaintenance());
			returnobject.put("ismaintenance", applicationinstance.getIsmaintenance());
			return returnobject;
		}
		return returnobject;
	}
	
	private JSONObject updateInstanceInfo(String instanceId, String instancename, String instanceshortname, String description, String shortdescription, String adminnode, String maintenance) {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		ApplicationInstance applicationinstance = ApplicationInstanceLocalServiceUtil.getApplicationInstance(instanceId);
		if(applicationinstance == null) {
			returnobject.put("status", "error");
			returnobject.put("error", "InstanceId dose not exist!");
		} else {
			applicationinstance.setName(instancename);
			applicationinstance.setShortName(instanceshortname);
			applicationinstance.setDescription(description);
			applicationinstance.setShortdescription(shortdescription);
			applicationinstance.setMaintenance(maintenance);
			applicationinstance.setAdminnode(adminnode);
			ApplicationInstanceLocalServiceUtil.updateApplicationInstance(applicationinstance);
			returnobject = applicationinstance.getInstanceJSONObject();
			returnobject.put("maintenance", applicationinstance.getMaintenance());
			returnobject.put("ismaintenance", applicationinstance.getIsmaintenance());
			return returnobject;
		}
		return returnobject;
	}
	
	private JSONObject getInstanceLogd(String instanceId, String logtype) {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		ApplicationInstance applicationinstance = ApplicationInstanceLocalServiceUtil.getApplicationInstance(instanceId);
		if(applicationinstance == null) {
			returnobject.put("status", "error");
			returnobject.put("error", "InstanceId dose not exist!");
		} else {
			returnobject.put("application", applicationinstance.getApplication());
			returnobject.put("applicationname", applicationinstance.getApplicationname());
			returnobject.put("version", applicationinstance.getVersion());
			returnobject.put("longname", applicationinstance.getName());
			if(logtype.equalsIgnoreCase("install")) {
				returnobject.put("log", getInstallLog(applicationinstance));
			} else {
				returnobject.put("log", getComposeLog(applicationinstance));
			}
			return returnobject;
		}
		return returnobject;
	}
	
	private String getInstallLog(ApplicationInstance applicationinstance) {
		return applicationinstance.getInstalllog();
	}
	
	private String getComposeLog(ApplicationInstance applicationinstance) {
		return applicationinstance.getComposeLog();
	}
	
	private JSONObject deleteInstance(String instanceId) {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		ApplicationInstance applicationinstance = ApplicationInstanceLocalServiceUtil.getApplicationInstance(instanceId);
		if(applicationinstance == null) {
			returnobject.put("status", "error");
			returnobject.put("error", "InstanceId dose not exist!");
		} else {
			applicationinstance.setDeleted(true);
			ApplicationInstanceLocalServiceUtil.updateApplicationInstance(applicationinstance);
			dockerDown(applicationinstance.getFolderPath());
			deleteFolderStructure(new File(applicationinstance.getFolderPath()));
			deleteProxyEntry(applicationinstance.getInstanceId());
			deletePorts(applicationinstance.getApplicationPorts());
			deleteContainer(applicationinstance.getContainers());
			ApplicationInstanceLocalServiceUtil.deleteApplicationInstance(applicationinstance);
		}
		return returnobject;
	}
	
	private void dockerDown(String applicationfolder) {
		try {
			ProcessBuilder processbuilder = new ProcessBuilder("/bin/bash", "-c", "docker-compose down");
			processbuilder.directory(new File(applicationfolder));
			Process process = processbuilder.start();
			process.waitFor();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String log;
			String statusreport = "";
			while ((log = reader.readLine()) != null) 
			{
				String loglevel = "INFO";
				if(log.startsWith("ERROR")) {
					loglevel = "ERROR";
				}
				statusreport = FormatExceptionMessage.formatLogMessage(loglevel, log, statusreport);
			}
			
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((log = reader.readLine()) != null) 
			{
				String loglevel = "INFO";
				if(log.startsWith("ERROR")) {
					loglevel = "ERROR";
				}
				statusreport = FormatExceptionMessage.formatLogMessage(loglevel, log, statusreport);
			}
			
			System.out.println(statusreport);
			
		} catch(IOException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "dockerDown(String applicationfolder)", "Error stopping containers and removes containers, networks, volumes, and images from folder: " + applicationfolder));
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "dockerDown(String applicationfolder)", "Error stopping containers and removes containers, networks, volumes, and images from folder: " + applicationfolder));
			e.printStackTrace();
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
		File sitesenabled = new File("/etc/apache2/sites-enabled/005-" + instanceId + ".conf");
		sitesenabled.delete();
		File sitesavailable = new File("/etc/apache2/sites-available/005-" + instanceId + ".conf");
		sitesavailable.delete();
	}
	
	private void deletePorts(List<ApplicationInstancePort> ports) {
		for(ApplicationInstancePort port : ports) {
			ApplicationInstancePortLocalServiceUtil.deleteApplicationInstancePort(port);
		}
	}
	
	private void deleteContainer(List<ApplicationInstanceContainer> containers) {
		for(ApplicationInstanceContainer container : containers) {
			ApplicationInstanceContainerLocalServiceUtil.deleteApplicationInstanceContainer(container);
		}
	}
	
	private JSONObject startInstance(String instanceId) {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		ApplicationInstance applicationinstance = ApplicationInstanceLocalServiceUtil.getApplicationInstance(instanceId);
		if(applicationinstance == null) {
			returnobject.put("status", "error");
			returnobject.put("error", "InstanceId dose not exist!");
		} else {
			returnobject.put("log", applicationinstance.startApplicationInstance());
		}
		return returnobject;
	}
	
	private JSONObject stopInstance(String instanceId) {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		ApplicationInstance applicationinstance = ApplicationInstanceLocalServiceUtil.getApplicationInstance(instanceId);
		if(applicationinstance == null) {
			returnobject.put("status", "error");
			returnobject.put("error", "InstanceId dose not exist!");
		} else {
			returnobject.put("log", applicationinstance.stopApplicationInstance());
		}
		return returnobject;
	}
	
	private JSONObject restartInstance(String instanceId) {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		ApplicationInstance applicationinstance = ApplicationInstanceLocalServiceUtil.getApplicationInstance(instanceId);
		if(applicationinstance == null) {
			returnobject.put("status", "error");
			returnobject.put("error", "InstanceId dose not exist!");
		} else {
			returnobject.put("log", applicationinstance.restartApplicationInstance());
		}
		return returnobject;
	}
	
	private JSONObject togglInstanceMaintenanceStatus(String instanceId) {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		ApplicationInstance applicationinstance = ApplicationInstanceLocalServiceUtil.getApplicationInstance(instanceId);
		if(applicationinstance == null) {
			returnobject.put("status", "error");
			returnobject.put("error", "InstanceId dose not exist!");
		} else {
			applicationinstance.setIsmaintenance(!applicationinstance.getIsmaintenance());;
			returnobject = getInstanceDashboard(instanceId);
		}
		return returnobject;
	}
	
	private JSONObject getUserObject() {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		try {
			User user = this.getGuestOrUser();
			returnobject.put("username", user.getFullName());
			if(user.getFirstName().equalsIgnoreCase("demo")) {
				returnobject.put("role", "admin");
			} else {
				returnobject.put("role", "admin");
			}
		} catch (Exception e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getUserObject()", "Error getting user from api call"));
			e.printStackTrace();
		}
		return returnobject;
	}
}