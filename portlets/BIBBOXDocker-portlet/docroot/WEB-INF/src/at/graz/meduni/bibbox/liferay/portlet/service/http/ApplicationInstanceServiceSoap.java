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

package at.graz.meduni.bibbox.liferay.portlet.service.http;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link ApplicationInstanceServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceSoap}.
 * If the method in the service utility returns a
 * {@link at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance}, that is translated to a
 * {@link at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationInstanceServiceHttp
 * @see at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceSoap
 * @see ApplicationInstanceServiceUtil
 * @generated
 */
@ProviderType
public class ApplicationInstanceServiceSoap {
	public static java.lang.String getApplicationStoreListAPI()
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ApplicationInstanceServiceUtil.getApplicationStoreListAPI();

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getUpdatedApplicationStoreListAPI()
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ApplicationInstanceServiceUtil.getUpdatedApplicationStoreListAPI();

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getApplicationStoreItemAPI(
		java.lang.String applicationname, java.lang.String version)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ApplicationInstanceServiceUtil.getApplicationStoreItemAPI(applicationname,
					version);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String installApplicationAPI(
		java.lang.String applicationname, java.lang.String version,
		java.lang.String instanceid, java.lang.String instancename,
		java.lang.String data) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ApplicationInstanceServiceUtil.installApplicationAPI(applicationname,
					version, instanceid, instancename, data);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getInstanceListAPI()
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ApplicationInstanceServiceUtil.getInstanceListAPI();

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getInstanceInfoAPI(
		java.lang.String instanceId) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ApplicationInstanceServiceUtil.getInstanceInfoAPI(instanceId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getInstanceDashboardAPI(
		java.lang.String instanceId) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ApplicationInstanceServiceUtil.getInstanceDashboardAPI(instanceId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getInstanceLogdAPI(
		java.lang.String instanceId) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ApplicationInstanceServiceUtil.getInstanceLogdAPI(instanceId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getInstanceLogdAPI(
		java.lang.String instanceId, java.lang.String lines)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ApplicationInstanceServiceUtil.getInstanceLogdAPI(instanceId,
					lines);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getInstanceMaintenanceAPI(
		java.lang.String instanceId) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ApplicationInstanceServiceUtil.getInstanceMaintenanceAPI(instanceId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String updateInstanceInfoAPI(
		java.lang.String instanceId, java.lang.String instancename,
		java.lang.String instanceshortname, java.lang.String description,
		java.lang.String shortdescription, java.lang.String adminnode,
		java.lang.String maintenance) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ApplicationInstanceServiceUtil.updateInstanceInfoAPI(instanceId,
					instancename, instanceshortname, description,
					shortdescription, adminnode, maintenance);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String deleteInstanceStatusAPI(
		java.lang.String instanceId) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ApplicationInstanceServiceUtil.deleteInstanceStatusAPI(instanceId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String setInstanceStatusAPI(
		java.lang.String instanceId, java.lang.String status)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ApplicationInstanceServiceUtil.setInstanceStatusAPI(instanceId,
					status);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String toggleInstanceMaintenanceStatusAPI(
		java.lang.String instanceId) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ApplicationInstanceServiceUtil.toggleInstanceMaintenanceStatusAPI(instanceId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getIdMappingInfoAPI(
		java.lang.String instanceId) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ApplicationInstanceServiceUtil.getIdMappingInfoAPI(instanceId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void getTestAPI(java.lang.String string)
		throws RemoteException {
		try {
			ApplicationInstanceServiceUtil.getTestAPI(string);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void setPortletConfiguration() throws RemoteException {
		try {
			ApplicationInstanceServiceUtil.setPortletConfiguration();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ApplicationInstanceServiceSoap.class);
}