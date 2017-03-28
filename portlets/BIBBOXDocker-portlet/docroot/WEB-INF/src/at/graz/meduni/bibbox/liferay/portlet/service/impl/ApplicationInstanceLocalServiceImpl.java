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
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;

import aQute.bnd.annotation.ProviderType;
import at.graz.meduni.bibbox.helper.BibboxConfigReader;
import at.graz.meduni.bibbox.helper.FormatExceptionMessage;
import at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceException;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.base.ApplicationInstanceLocalServiceBaseImpl;

/**
 * The implementation of the application instance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationInstanceLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalServiceUtil
 */
@ProviderType
public class ApplicationInstanceLocalServiceImpl
	extends ApplicationInstanceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalServiceUtil} to access the application instance local service.
	 */
	
	/**
	 * Error Format for date
	 */
	private static String log_portlet_ = "BIBBOXDocker";
	private static String log_classname_ = "at.graz.meduni.bibbox.liferay.portlet.service.impl.ApplicationInstanceLocalServiceImpl";
	
	public boolean checkInstanceNameAvailable(String instanceId) {
		try {
			applicationInstancePersistence.findByInstanceId(instanceId);
			return true;
		} catch (NoSuchApplicationInstanceException e) {
			
		}
		return false;
	}
	
	public ApplicationInstance getApplicationInstance(String instanceId) {
		try {
			return applicationInstancePersistence.findByInstanceId(instanceId);
		} catch (NoSuchApplicationInstanceException e) {
			
		}
		return null;
	}
	
	public List<ApplicationInstance> getActiveApplicationInstances() {
		return applicationInstancePersistence.findByInstancesNotDeleted(false);
	}
	
	public ApplicationInstance registerApplication(String applicationname, String version, String instanceid, String instancename) {
		ApplicationInstance applicationinstance = ApplicationInstanceLocalServiceUtil.createApplicationInstance(CounterLocalServiceUtil.increment());
		applicationinstance.setApplication(applicationname);
		applicationinstance.setVersion(version);
		applicationinstance.setInstanceId(instanceid);
		applicationinstance.setName(instancename);
		applicationinstance.setShortName(instancename);
		applicationinstance.setIsmaintenance(true);
		applicationinstance.setDeleted(false);
		applicationinstance.setIsinstalling(true);
		applicationinstance.setInstalllog(FormatExceptionMessage.formatLogMessage("INFO", "Application instance registered"));
		applicationinstance.setFolderName(instanceid + "-" + applicationname);
		applicationinstance = ApplicationInstanceLocalServiceUtil.updateApplicationInstance(applicationinstance);
		return applicationinstance;
	}
	
	public JSONArray getUsedInstanceIds() {
		JSONArray returnobject = JSONFactoryUtil.createJSONArray();
		String reservedids = BibboxConfigReader.getBibboxUsedInstanceIds();
		for(String reservedid : reservedids.split(";")) {
			returnobject.put(reservedid);
		}
		List<ApplicationInstance> applicationinstances = ApplicationInstanceLocalServiceUtil.getApplicationInstances(-1, -1);
		for(ApplicationInstance applicationinstance : applicationinstances) {
			returnobject.put(applicationinstance.getInstanceId());
		}
		return returnobject;
	}
}