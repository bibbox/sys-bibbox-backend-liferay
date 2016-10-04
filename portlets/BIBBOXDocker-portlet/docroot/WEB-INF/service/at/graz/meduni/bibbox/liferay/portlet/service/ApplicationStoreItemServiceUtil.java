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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.service.InvokableService;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * Provides the remote service utility for ApplicationStoreItem. This utility wraps
 * {@link at.graz.meduni.bibbox.liferay.portlet.service.impl.ApplicationStoreItemServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Robert Reihs
 * @see ApplicationStoreItemService
 * @see at.graz.meduni.bibbox.liferay.portlet.service.base.ApplicationStoreItemServiceBaseImpl
 * @see at.graz.meduni.bibbox.liferay.portlet.service.impl.ApplicationStoreItemServiceImpl
 * @generated
 */
@ProviderType
public class ApplicationStoreItemServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.graz.meduni.bibbox.liferay.portlet.service.impl.ApplicationStoreItemServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.json.JSONArray getApplicationStoreListAPI() {
		return getService().getApplicationStoreListAPI();
	}

	public static com.liferay.portal.kernel.json.JSONArray getApplicationStoreUpdatedListAPI() {
		return getService().getApplicationStoreUpdatedListAPI();
	}

	public static com.liferay.portal.kernel.json.JSONObject getApplicationStoreItem(
		long applicationstoreitemId) {
		return getService().getApplicationStoreItem(applicationstoreitemId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getApplicationStoreItemAPI(
		long applicationstoreitemId) {
		return getService().getApplicationStoreItemAPI(applicationstoreitemId);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void addApplicationStoreItem(java.lang.String name,
		java.lang.String shortname, java.lang.String version,
		java.lang.String release_state, java.lang.String description,
		java.lang.String catalogue_url, java.lang.String application_url,
		java.lang.String kits, java.lang.String tags) {
		getService()
			.addApplicationStoreItem(name, shortname, version, release_state,
			description, catalogue_url, application_url, kits, tags);
	}

	public static void clearService() {
		_service = null;
	}

	public static ApplicationStoreItemService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ApplicationStoreItemService.class.getName());

			if (invokableService instanceof ApplicationStoreItemService) {
				_service = (ApplicationStoreItemService)invokableService;
			}
			else {
				_service = new ApplicationStoreItemServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ApplicationStoreItemServiceUtil.class,
				"_service");
		}

		return _service;
	}

	private static ApplicationStoreItemService _service;
}