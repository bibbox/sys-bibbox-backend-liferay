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

import aQute.bnd.annotation.ProviderType;
import at.graz.meduni.bibbox.helper.BibboxConfigReader;
import at.graz.meduni.bibbox.helper.FormatExceptionMessage;
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
	
	public void startUpApplicationInstance() {
		try {
			ProcessBuilder processbuilder = new ProcessBuilder("/bin/bash", "-c", "docker-compose up -d");
			processbuilder.directory(new File(this.getFolderPath()));
			Process process = processbuilder.start();
			process.waitFor();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String log;
			String installlog = "";
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
			
			System.out.println(installlog);
			
		} catch(IOException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "startUpApplicationInstance()", "Error startign docker-compose.yml file for instance:" + this.getInstanceId()));
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.err.println(FormatExceptionMessage.formatExceptionMessage("error", log_portlet_, log_classname_, "startUpApplicationInstance()", "Error startign docker-compose.yml file for instance:" + this.getInstanceId()));
			e.printStackTrace();
		}
	}
}