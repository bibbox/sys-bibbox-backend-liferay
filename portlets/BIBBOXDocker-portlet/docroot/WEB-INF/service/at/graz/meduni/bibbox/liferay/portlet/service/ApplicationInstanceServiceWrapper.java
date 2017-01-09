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
	public com.liferay.portal.kernel.json.JSONObject deleteInstanceStatusAPI(
		java.lang.String instanceId) {
		return _applicationInstanceService.deleteInstanceStatusAPI(instanceId);
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
	public com.liferay.portal.kernel.json.JSONObject getIdMappingInfoAPI(
		java.lang.String instanceId) {
		return _applicationInstanceService.getIdMappingInfoAPI(instanceId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getInstanceDashboardAPI(
		java.lang.String instanceId) {
		return _applicationInstanceService.getInstanceDashboardAPI(instanceId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getInstanceInfoAPI(
		java.lang.String instanceId) {
		return _applicationInstanceService.getInstanceInfoAPI(instanceId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getInstanceListAPI() {
		return _applicationInstanceService.getInstanceListAPI();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getInstanceLogdAPI(
		java.lang.String instanceId) {
		return _applicationInstanceService.getInstanceLogdAPI(instanceId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getInstanceLogdAPI(
		java.lang.String instanceId, java.lang.String lines) {
		return _applicationInstanceService.getInstanceLogdAPI(instanceId, lines);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getInstanceMaintenanceAPI(
		java.lang.String instanceId) {
		return _applicationInstanceService.getInstanceMaintenanceAPI(instanceId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getUpdatedApplicationStoreListAPI() {
		return _applicationInstanceService.getUpdatedApplicationStoreListAPI();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject installApplicationAPI(
		java.lang.String applicationname, java.lang.String version,
		java.lang.String instanceid, java.lang.String instancename,
		java.lang.String data) {
		return _applicationInstanceService.installApplicationAPI(applicationname,
			version, instanceid, instancename, data);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject setInstanceStatusAPI(
		java.lang.String instanceId, java.lang.String status) {
		return _applicationInstanceService.setInstanceStatusAPI(instanceId,
			status);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject toggleInstanceMaintenanceStatusAPI(
		java.lang.String instanceId) {
		return _applicationInstanceService.toggleInstanceMaintenanceStatusAPI(instanceId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject updateInstanceInfoAPI(
		java.lang.String instanceId, java.lang.String instancename,
		java.lang.String instanceshortname, java.lang.String description,
		java.lang.String shortdescription, java.lang.String adminnode,
		java.lang.String maintenance) {
		return _applicationInstanceService.updateInstanceInfoAPI(instanceId,
			instancename, instanceshortname, description, shortdescription,
			adminnode, maintenance);
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
	public void getTestAPI(java.lang.String string) {
		_applicationInstanceService.getTestAPI(string);
	}

	@Override
	public void setPortletConfiguration(long companyId, long plid,
		java.lang.String portletId, java.lang.String preferences) {
		_applicationInstanceService.setPortletConfiguration(companyId, plid,
			portletId, preferences);
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