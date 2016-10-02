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
 * Provides a wrapper for {@link ApplicationStoreItemService}.
 *
 * @author Robert Reihs
 * @see ApplicationStoreItemService
 * @generated
 */
@ProviderType
public class ApplicationStoreItemServiceWrapper
	implements ApplicationStoreItemService,
		ServiceWrapper<ApplicationStoreItemService> {
	public ApplicationStoreItemServiceWrapper(
		ApplicationStoreItemService applicationStoreItemService) {
		_applicationStoreItemService = applicationStoreItemService;
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getApplicationStoreListAPI() {
		return _applicationStoreItemService.getApplicationStoreListAPI();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getApplicationStoreUpdatedListAPI() {
		return _applicationStoreItemService.getApplicationStoreUpdatedListAPI();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getApplicationStoreItem(
		long applicationstoreitemId) {
		return _applicationStoreItemService.getApplicationStoreItem(applicationstoreitemId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getApplicationStoreItemAPI(
		long applicationstoreitemId) {
		return _applicationStoreItemService.getApplicationStoreItemAPI(applicationstoreitemId);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _applicationStoreItemService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _applicationStoreItemService.getOSGiServiceIdentifier();
	}

	@Override
	public void addApplicationStoreItem(java.lang.String name,
		java.lang.String shortname, java.lang.String version,
		java.lang.String release_state, java.lang.String description,
		java.lang.String catalogue_url, java.lang.String application_url,
		java.lang.String kits, java.lang.String tags) {
		_applicationStoreItemService.addApplicationStoreItem(name, shortname,
			version, release_state, description, catalogue_url,
			application_url, kits, tags);
	}

	@Override
	public ApplicationStoreItemService getWrappedService() {
		return _applicationStoreItemService;
	}

	@Override
	public void setWrappedService(
		ApplicationStoreItemService applicationStoreItemService) {
		_applicationStoreItemService = applicationStoreItemService;
	}

	private ApplicationStoreItemService _applicationStoreItemService;
}