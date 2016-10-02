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

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.liferay.portlet.service.base.DockerContainerServiceBaseImpl;

/**
 * The implementation of the docker container remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.bibbox.liferay.portlet.service.DockerContainerService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Robert Reihs
 * @see DockerContainerServiceBaseImpl
 * @see at.graz.meduni.bibbox.liferay.portlet.service.DockerContainerServiceUtil
 */
@ProviderType
public class DockerContainerServiceImpl extends DockerContainerServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link at.graz.meduni.bibbox.liferay.portlet.service.DockerContainerServiceUtil} to access the docker container remote service.
	 */
	
	@JSONWebService("/get-version")
	public String getVersion() {
		return "BIBBOX API v1.0";
	}
}