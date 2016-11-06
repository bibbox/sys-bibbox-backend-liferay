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
 * Provides the remote service utility for ApplicationInstance. This utility wraps
 * {@link at.graz.meduni.bibbox.liferay.portlet.service.impl.ApplicationInstanceServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Robert Reihs
 * @see ApplicationInstanceService
 * @see at.graz.meduni.bibbox.liferay.portlet.service.base.ApplicationInstanceServiceBaseImpl
 * @see at.graz.meduni.bibbox.liferay.portlet.service.impl.ApplicationInstanceServiceImpl
 * @generated
 */
@ProviderType
public class ApplicationInstanceServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.graz.meduni.bibbox.liferay.portlet.service.impl.ApplicationInstanceServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.json.JSONObject getApplicationStoreItemAPI(
		java.lang.String applicationname, java.lang.String version) {
		return getService().getApplicationStoreItemAPI(applicationname, version);
	}

	public static com.liferay.portal.kernel.json.JSONObject getApplicationStoreListAPI() {
		return getService().getApplicationStoreListAPI();
	}

	public static com.liferay.portal.kernel.json.JSONObject getInstanceListAPI() {
		return getService().getInstanceListAPI();
	}

	public static com.liferay.portal.kernel.json.JSONObject getUpdatedApplicationStoreListAPI() {
		return getService().getUpdatedApplicationStoreListAPI();
	}

	public static com.liferay.portal.kernel.json.JSONObject installApplicationAPI(
		java.lang.String applicationname, java.lang.String version,
		java.lang.String instanceid, java.lang.String instancename,
		java.lang.String description, java.lang.String data) {
		return getService()
				   .installApplicationAPI(applicationname, version, instanceid,
			instancename, description, data);
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

	public static void clearService() {
		_service = null;
	}

	public static ApplicationInstanceService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ApplicationInstanceService.class.getName());

			if (invokableService instanceof ApplicationInstanceService) {
				_service = (ApplicationInstanceService)invokableService;
			}
			else {
				_service = new ApplicationInstanceServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ApplicationInstanceServiceUtil.class,
				"_service");
		}

		return _service;
	}

	private static ApplicationInstanceService _service;
}