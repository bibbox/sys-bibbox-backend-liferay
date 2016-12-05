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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import aQute.bnd.annotation.ProviderType;
import at.graz.meduni.bibbox.helper.FormatExceptionMessage;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalServiceUtil;

/**
 * The extended model implementation for the ApplicationInstanceContainer service. Represents a row in the &quot;bibboxdocker_ApplicationInstanceContainer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer} interface.
 * </p>
 *
 * @author Robert Reihs
 */
@ProviderType
public class ApplicationInstanceContainerImpl
	extends ApplicationInstanceContainerBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a application instance container model instance should use the {@link at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer} interface instead.
	 */
	public ApplicationInstanceContainerImpl() {
	}
	
	/**
	 * Error Format for date
	 */
	private static String log_portlet_ = "BIBBOXDocker";
	private static String log_classname_ = "at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceContainerImpl";
	
	public JSONObject getContainerLog(String lines) {
		JSONObject returnobject = JSONFactoryUtil.createJSONObject();
		String composelog = "";
		try {
			ProcessBuilder processbuilder = new ProcessBuilder("/bin/bash", "-c", "docker " + this.getContainerName() + " logs --tail " + lines);
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
				composelog = FormatExceptionMessage.formatLogMessage(loglevel, log, composelog);
			}
			
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while ((log = reader.readLine()) != null) 
			{
				String loglevel = "INFO";
				if(log.startsWith("ERROR")) {
					loglevel = "ERROR";
				}
				composelog = FormatExceptionMessage.formatLogMessage(loglevel, log, composelog);
			}
			
		} catch(IOException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getContainerLog(String lines)", "Error getting docker log for container: " + this.getContainerName()));
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "getContainerLog(String lines)", "Error getting docker log for container: " + this.getContainerName()));
			e.printStackTrace();
		}
		returnobject.put("containername", this.getContainerName());
		returnobject.put("log", composelog);
		returnobject.put("cmd", "docker " + this.getContainerName() + " logs --tail " + lines);
		return returnobject;
	}
	
	public boolean ApplicationInstanceExists() {
		try {
			ApplicationInstance applicationinstance = ApplicationInstanceLocalServiceUtil.getApplicationInstance(this.getApplicationInstanceId());
			return !applicationinstance.getDeleted();
		} catch (PortalException e) {
			return false;
		}
	}
}