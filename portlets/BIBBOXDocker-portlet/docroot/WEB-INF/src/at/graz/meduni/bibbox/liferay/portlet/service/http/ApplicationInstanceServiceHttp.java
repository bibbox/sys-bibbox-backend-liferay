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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link ApplicationInstanceServiceUtil} service utility. The
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
 * @see ApplicationInstanceServiceSoap
 * @see HttpPrincipal
 * @see ApplicationInstanceServiceUtil
 * @generated
 */
@ProviderType
public class ApplicationInstanceServiceHttp {
	public static com.liferay.portal.kernel.json.JSONObject getVersionAPI(
		HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationInstanceServiceUtil.class,
					"getVersionAPI", _getVersionAPIParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey);

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

	public static com.liferay.portal.kernel.json.JSONObject getApplicationStoreListAPI(
		HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationInstanceServiceUtil.class,
					"getApplicationStoreListAPI",
					_getApplicationStoreListAPIParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey);

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

	public static com.liferay.portal.kernel.json.JSONObject getUpdatedApplicationStoreListAPI(
		HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationInstanceServiceUtil.class,
					"getUpdatedApplicationStoreListAPI",
					_getUpdatedApplicationStoreListAPIParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey);

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

	public static com.liferay.portal.kernel.json.JSONObject getApplicationStoreItemAPI(
		HttpPrincipal httpPrincipal, java.lang.String applicationname,
		java.lang.String version) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationInstanceServiceUtil.class,
					"getApplicationStoreItemAPI",
					_getApplicationStoreItemAPIParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					applicationname, version);

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

	public static com.liferay.portal.kernel.json.JSONObject installApplicationAPI(
		HttpPrincipal httpPrincipal, java.lang.String applicationname,
		java.lang.String version, java.lang.String instanceid,
		java.lang.String instancename, java.lang.String data) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationInstanceServiceUtil.class,
					"installApplicationAPI",
					_installApplicationAPIParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					applicationname, version, instanceid, instancename, data);

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

	public static com.liferay.portal.kernel.json.JSONObject getInstanceListAPI(
		HttpPrincipal httpPrincipal) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationInstanceServiceUtil.class,
					"getInstanceListAPI", _getInstanceListAPIParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey);

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

	public static com.liferay.portal.kernel.json.JSONObject getInstanceInfoAPI(
		HttpPrincipal httpPrincipal, java.lang.String instanceId) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationInstanceServiceUtil.class,
					"getInstanceInfoAPI", _getInstanceInfoAPIParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					instanceId);

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

	public static com.liferay.portal.kernel.json.JSONObject getInstanceDashboardAPI(
		HttpPrincipal httpPrincipal, java.lang.String instanceId) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationInstanceServiceUtil.class,
					"getInstanceDashboardAPI",
					_getInstanceDashboardAPIParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					instanceId);

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

	public static com.liferay.portal.kernel.json.JSONObject getInstanceLogdAPI(
		HttpPrincipal httpPrincipal, java.lang.String instanceId) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationInstanceServiceUtil.class,
					"getInstanceLogdAPI", _getInstanceLogdAPIParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					instanceId);

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

	public static com.liferay.portal.kernel.json.JSONObject getInstanceLogdAPI(
		HttpPrincipal httpPrincipal, java.lang.String instanceId,
		java.lang.String lines) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationInstanceServiceUtil.class,
					"getInstanceLogdAPI", _getInstanceLogdAPIParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					instanceId, lines);

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

	public static com.liferay.portal.kernel.json.JSONObject getInstanceMaintenanceAPI(
		HttpPrincipal httpPrincipal, java.lang.String instanceId) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationInstanceServiceUtil.class,
					"getInstanceMaintenanceAPI",
					_getInstanceMaintenanceAPIParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					instanceId);

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

	public static com.liferay.portal.kernel.json.JSONObject updateInstanceInfoAPI(
		HttpPrincipal httpPrincipal, java.lang.String instanceId,
		java.lang.String instancename, java.lang.String instanceshortname,
		java.lang.String description, java.lang.String shortdescription,
		java.lang.String adminnode, java.lang.String maintenance) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationInstanceServiceUtil.class,
					"updateInstanceInfoAPI",
					_updateInstanceInfoAPIParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					instanceId, instancename, instanceshortname, description,
					shortdescription, adminnode, maintenance);

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

	public static com.liferay.portal.kernel.json.JSONObject deleteInstanceStatusAPI(
		HttpPrincipal httpPrincipal, java.lang.String instanceId) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationInstanceServiceUtil.class,
					"deleteInstanceStatusAPI",
					_deleteInstanceStatusAPIParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					instanceId);

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

	public static com.liferay.portal.kernel.json.JSONObject setInstanceStatusAPI(
		HttpPrincipal httpPrincipal, java.lang.String instanceId,
		java.lang.String status) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationInstanceServiceUtil.class,
					"setInstanceStatusAPI",
					_setInstanceStatusAPIParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					instanceId, status);

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

	public static com.liferay.portal.kernel.json.JSONObject toggleInstanceMaintenanceStatusAPI(
		HttpPrincipal httpPrincipal, java.lang.String instanceId) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationInstanceServiceUtil.class,
					"toggleInstanceMaintenanceStatusAPI",
					_toggleInstanceMaintenanceStatusAPIParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					instanceId);

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

	public static com.liferay.portal.kernel.json.JSONObject getIdMappingInfoAPI(
		HttpPrincipal httpPrincipal, java.lang.String instanceId) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationInstanceServiceUtil.class,
					"getIdMappingInfoAPI", _getIdMappingInfoAPIParameterTypes15);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					instanceId);

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

	public static void getTestAPI(HttpPrincipal httpPrincipal,
		java.lang.String string) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationInstanceServiceUtil.class,
					"getTestAPI", _getTestAPIParameterTypes16);

			MethodHandler methodHandler = new MethodHandler(methodKey, string);

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

	public static com.liferay.portal.kernel.json.JSONObject setPortletConfiguration(
		HttpPrincipal httpPrincipal, long companyId, long plid,
		java.lang.String portletId, java.lang.String preferences) {
		try {
			MethodKey methodKey = new MethodKey(ApplicationInstanceServiceUtil.class,
					"setPortletConfiguration",
					_setPortletConfigurationParameterTypes17);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					companyId, plid, portletId, preferences);

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

	private static Log _log = LogFactoryUtil.getLog(ApplicationInstanceServiceHttp.class);
	private static final Class<?>[] _getVersionAPIParameterTypes0 = new Class[] {  };
	private static final Class<?>[] _getApplicationStoreListAPIParameterTypes1 = new Class[] {
			
		};
	private static final Class<?>[] _getUpdatedApplicationStoreListAPIParameterTypes2 =
		new Class[] {  };
	private static final Class<?>[] _getApplicationStoreItemAPIParameterTypes3 = new Class[] {
			java.lang.String.class, java.lang.String.class
		};
	private static final Class<?>[] _installApplicationAPIParameterTypes4 = new Class[] {
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class
		};
	private static final Class<?>[] _getInstanceListAPIParameterTypes5 = new Class[] {
			
		};
	private static final Class<?>[] _getInstanceInfoAPIParameterTypes6 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _getInstanceDashboardAPIParameterTypes7 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _getInstanceLogdAPIParameterTypes8 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _getInstanceLogdAPIParameterTypes9 = new Class[] {
			java.lang.String.class, java.lang.String.class
		};
	private static final Class<?>[] _getInstanceMaintenanceAPIParameterTypes10 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _updateInstanceInfoAPIParameterTypes11 = new Class[] {
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class
		};
	private static final Class<?>[] _deleteInstanceStatusAPIParameterTypes12 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _setInstanceStatusAPIParameterTypes13 = new Class[] {
			java.lang.String.class, java.lang.String.class
		};
	private static final Class<?>[] _toggleInstanceMaintenanceStatusAPIParameterTypes14 =
		new Class[] { java.lang.String.class };
	private static final Class<?>[] _getIdMappingInfoAPIParameterTypes15 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _getTestAPIParameterTypes16 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _setPortletConfigurationParameterTypes17 = new Class[] {
			long.class, long.class, java.lang.String.class,
			java.lang.String.class
		};
}