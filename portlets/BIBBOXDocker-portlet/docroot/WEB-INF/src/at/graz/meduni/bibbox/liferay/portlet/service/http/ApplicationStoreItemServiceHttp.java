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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link ApplicationStoreItemServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationStoreItemServiceSoap
 * @see HttpPrincipal
 * @see ApplicationStoreItemServiceUtil
 * @generated
 */
@ProviderType
public class ApplicationStoreItemServiceHttp {
	public static com.liferay.portal.kernel.json.JSONArray getApplicationStoreListAPI(
		HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationStoreItemServiceUtil.class,
					"getApplicationStoreListAPI",
					_getApplicationStoreListAPIParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray getApplicationStoreUpdatedListAPI(
		HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationStoreItemServiceUtil.class,
					"getApplicationStoreUpdatedListAPI",
					_getApplicationStoreUpdatedListAPIParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject getApplicationStoreItemAPI(
		HttpPrincipal httpPrincipal, long applicationstoreitemId) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationStoreItemServiceUtil.class,
					"getApplicationStoreItemAPI",
					_getApplicationStoreItemAPIParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					applicationstoreitemId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject getApplicationStoreItem(
		HttpPrincipal httpPrincipal, long applicationstoreitemId) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationStoreItemServiceUtil.class,
					"getApplicationStoreItem",
					_getApplicationStoreItemParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					applicationstoreitemId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void addApplicationStoreItem(HttpPrincipal httpPrincipal,
		java.lang.String name, java.lang.String shortname,
		java.lang.String version, java.lang.String release_state,
		java.lang.String description, java.lang.String catalogue_url,
		java.lang.String application_url, java.lang.String kits,
		java.lang.String tags) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationStoreItemServiceUtil.class,
					"addApplicationStoreItem",
					_addApplicationStoreItemParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, name,
					shortname, version, release_state, description,
					catalogue_url, application_url, kits, tags);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ApplicationStoreItemServiceHttp.class);
	private static final Class<?>[] _getApplicationStoreListAPIParameterTypes0 = new Class[] {
			
		};
	private static final Class<?>[] _getApplicationStoreUpdatedListAPIParameterTypes1 =
		new Class[] {  };
	private static final Class<?>[] _getApplicationStoreItemAPIParameterTypes2 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getApplicationStoreItemParameterTypes3 = new Class[] {
			long.class
		};
	private static final Class<?>[] _addApplicationStoreItemParameterTypes4 = new Class[] {
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class
		};
}