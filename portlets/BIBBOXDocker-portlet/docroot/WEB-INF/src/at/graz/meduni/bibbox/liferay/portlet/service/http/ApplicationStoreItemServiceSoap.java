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

import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationStoreItemServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link ApplicationStoreItemServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link at.graz.meduni.bibbox.liferay.portlet.model.ApplicationStoreItemSoap}.
 * If the method in the service utility returns a
 * {@link at.graz.meduni.bibbox.liferay.portlet.model.ApplicationStoreItem}, that is translated to a
 * {@link at.graz.meduni.bibbox.liferay.portlet.model.ApplicationStoreItemSoap}. Methods that SOAP cannot
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
 * @see ApplicationStoreItemServiceHttp
 * @see at.graz.meduni.bibbox.liferay.portlet.model.ApplicationStoreItemSoap
 * @see ApplicationStoreItemServiceUtil
 * @generated
 */
@ProviderType
public class ApplicationStoreItemServiceSoap {
	public static java.lang.String getApplicationStoreListAPI()
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = ApplicationStoreItemServiceUtil.getApplicationStoreListAPI();

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getApplicationStoreUpdatedListAPI()
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = ApplicationStoreItemServiceUtil.getApplicationStoreUpdatedListAPI();

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getApplicationStoreItemAPI(
		long applicationstoreitemId) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ApplicationStoreItemServiceUtil.getApplicationStoreItemAPI(applicationstoreitemId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getApplicationStoreItem(
		long applicationstoreitemId) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = ApplicationStoreItemServiceUtil.getApplicationStoreItem(applicationstoreitemId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addApplicationStoreItem(java.lang.String name,
		java.lang.String shortname, java.lang.String version,
		java.lang.String release_state, java.lang.String description,
		java.lang.String catalogue_url, java.lang.String application_url,
		java.lang.String kits, java.lang.String tags) throws RemoteException {
		try {
			ApplicationStoreItemServiceUtil.addApplicationStoreItem(name,
				shortname, version, release_state, description, catalogue_url,
				application_url, kits, tags);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ApplicationStoreItemServiceSoap.class);
}