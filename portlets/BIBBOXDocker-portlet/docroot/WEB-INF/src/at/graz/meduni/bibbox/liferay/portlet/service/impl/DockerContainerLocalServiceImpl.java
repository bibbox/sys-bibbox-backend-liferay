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

import javax.portlet.ActionRequest;

import com.liferay.portal.kernel.util.ParamUtil;

import aQute.bnd.annotation.ProviderType;
import at.graz.meduni.bibbox.liferay.portlet.model.DockerContainer;
import at.graz.meduni.bibbox.liferay.portlet.model.impl.DockerContainerImpl;
import at.graz.meduni.bibbox.liferay.portlet.service.base.DockerContainerLocalServiceBaseImpl;

/**
 * The implementation of the docker container local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.bibbox.liferay.portlet.service.DockerContainerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Robert Reihs
 * @see DockerContainerLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.liferay.portlet.service.DockerContainerLocalServiceUtil
 */
@ProviderType
public class DockerContainerLocalServiceImpl
	extends DockerContainerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link at.graz.meduni.bibbox.liferay.portlet.service.DockerContainerLocalServiceUtil} to access the docker container local service.
	 */
	
	public DockerContainer dockerContainerFromRequest(ActionRequest request) {
		DockerContainerImpl dockercontainer = new DockerContainerImpl();
		dockercontainer.setDockerContainerId(ParamUtil.getLong(request, "dockerContainerId"));
		dockercontainer.setStartCommand(ParamUtil.getString(request, "startCommand"));
		dockercontainer.setToolName(ParamUtil.getString(request, "toolName"));
		dockercontainer.setInstance(ParamUtil.getString(request, "instance"));
		dockercontainer.setPort(ParamUtil.getString(request, "port"));
		dockercontainer.setUrl(ParamUtil.getString(request, "url"));
		dockercontainer.setSubdomain(ParamUtil.getString(request, "subdomain"));
		dockercontainer.setIp(ParamUtil.getString(request, "ip"));
		dockercontainer.setDisplayName(ParamUtil.getString(request, "displayName"));
		dockercontainer.setDisplayToolName(ParamUtil.getString(request, "displayToolName"));
		dockercontainer.setCategory(ParamUtil.getString(request, "category"));
		dockercontainer.setTool(ParamUtil.getString(request, "tool"));
		dockercontainer.setDescription(ParamUtil.getString(request, "description"));
		dockercontainer.setCompany(ParamUtil.getString(request, "company"));
		dockercontainer.setPlatform(ParamUtil.getString(request, "platform"));
		dockercontainer.setLicense(ParamUtil.getString(request, "license"));
		dockercontainer.setToolDescription(ParamUtil.getString(request, "toolDescription"));
		dockercontainer.setLogourl(ParamUtil.getString(request, "logourl"));
		return dockercontainer;
	}
}