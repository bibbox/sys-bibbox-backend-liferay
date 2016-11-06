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
 * Provides a wrapper for {@link ApplicationInstanceService}.
 *
 * @author Robert Reihs
 * @see ApplicationInstanceService
 * @generated
 */
@ProviderType
public class ApplicationInstanceServiceWrapper
	implements ApplicationInstanceService,
		ServiceWrapper<ApplicationInstanceService> {
	public ApplicationInstanceServiceWrapper(
		ApplicationInstanceService applicationInstanceService) {
		_applicationInstanceService = applicationInstanceService;
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getApplicationStoreItemAPI(
		java.lang.String applicationname, java.lang.String version) {
		return _applicationInstanceService.getApplicationStoreItemAPI(applicationname,
			version);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getApplicationStoreListAPI() {
		return _applicationInstanceService.getApplicationStoreListAPI();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getInstanceListAPI() {
		return _applicationInstanceService.getInstanceListAPI();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getUpdatedApplicationStoreListAPI() {
		return _applicationInstanceService.getUpdatedApplicationStoreListAPI();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject installApplicationAPI(
		java.lang.String applicationname, java.lang.String version,
		java.lang.String instanceid, java.lang.String instancename,
		java.lang.String description, java.lang.String data) {
		return _applicationInstanceService.installApplicationAPI(applicationname,
			version, instanceid, instancename, description, data);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _applicationInstanceService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _applicationInstanceService.getOSGiServiceIdentifier();
	}

	@Override
	public ApplicationInstanceService getWrappedService() {
		return _applicationInstanceService;
	}

	@Override
	public void setWrappedService(
		ApplicationInstanceService applicationInstanceService) {
		_applicationInstanceService = applicationInstanceService;
	}

	private ApplicationInstanceService _applicationInstanceService;
}