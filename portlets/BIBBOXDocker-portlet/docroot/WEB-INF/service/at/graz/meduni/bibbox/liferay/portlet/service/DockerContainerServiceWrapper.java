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

package at.graz.meduni.bibbox.liferay.portlet.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DockerContainerService}.
 *
 * @author Robert Reihs
 * @see DockerContainerService
 * @generated
 */
@ProviderType
public class DockerContainerServiceWrapper implements DockerContainerService,
	ServiceWrapper<DockerContainerService> {
	public DockerContainerServiceWrapper(
		DockerContainerService dockerContainerService) {
		_dockerContainerService = dockerContainerService;
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dockerContainerService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _dockerContainerService.getOSGiServiceIdentifier();
	}

	@Override
	public java.lang.String getVersion() {
		return _dockerContainerService.getVersion();
	}

	@Override
	public DockerContainerService getWrappedService() {
		return _dockerContainerService;
	}

	@Override
	public void setWrappedService(DockerContainerService dockerContainerService) {
		_dockerContainerService = dockerContainerService;
	}

	private DockerContainerService _dockerContainerService;
}