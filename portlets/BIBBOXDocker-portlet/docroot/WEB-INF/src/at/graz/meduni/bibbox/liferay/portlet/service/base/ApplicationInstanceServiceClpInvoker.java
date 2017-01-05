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

package at.graz.meduni.bibbox.liferay.portlet.service.base;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceServiceUtil;

import java.util.Arrays;

/**
 * @author Robert Reihs
 * @generated
 */
@ProviderType
public class ApplicationInstanceServiceClpInvoker {
	public ApplicationInstanceServiceClpInvoker() {
		_methodName36 = "getOSGiServiceIdentifier";

		_methodParameterTypes36 = new String[] {  };

		_methodName41 = "getApplicationStoreListAPI";

		_methodParameterTypes41 = new String[] {  };

		_methodName42 = "getUpdatedApplicationStoreListAPI";

		_methodParameterTypes42 = new String[] {  };

		_methodName43 = "getApplicationStoreItemAPI";

		_methodParameterTypes43 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName44 = "installApplicationAPI";

		_methodParameterTypes44 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName45 = "getInstanceListAPI";

		_methodParameterTypes45 = new String[] {  };

		_methodName46 = "getInstanceInfoAPI";

		_methodParameterTypes46 = new String[] { "java.lang.String" };

		_methodName47 = "getInstanceDashboardAPI";

		_methodParameterTypes47 = new String[] { "java.lang.String" };

		_methodName48 = "getInstanceLogdAPI";

		_methodParameterTypes48 = new String[] { "java.lang.String" };

		_methodName49 = "getInstanceLogdAPI";

		_methodParameterTypes49 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName50 = "getInstanceMaintenanceAPI";

		_methodParameterTypes50 = new String[] { "java.lang.String" };

		_methodName51 = "updateInstanceInfoAPI";

		_methodParameterTypes51 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName52 = "deleteInstanceStatusAPI";

		_methodParameterTypes52 = new String[] { "java.lang.String" };

		_methodName53 = "setInstanceStatusAPI";

		_methodParameterTypes53 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName54 = "toggleInstanceMaintenanceStatusAPI";

		_methodParameterTypes54 = new String[] { "java.lang.String" };

		_methodName55 = "getIdMappingInfoAPI";

		_methodParameterTypes55 = new String[] { "java.lang.String" };

		_methodName56 = "getTestAPI";

		_methodParameterTypes56 = new String[] { "java.lang.String" };

		_methodName57 = "setPortletConfiguration";

		_methodParameterTypes57 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getOSGiServiceIdentifier();
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getApplicationStoreListAPI();
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getUpdatedApplicationStoreListAPI();
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getApplicationStoreItemAPI((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return ApplicationInstanceServiceUtil.installApplicationAPI((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4]);
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getInstanceListAPI();
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getInstanceInfoAPI((java.lang.String)arguments[0]);
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getInstanceDashboardAPI((java.lang.String)arguments[0]);
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getInstanceLogdAPI((java.lang.String)arguments[0]);
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getInstanceLogdAPI((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getInstanceMaintenanceAPI((java.lang.String)arguments[0]);
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			return ApplicationInstanceServiceUtil.updateInstanceInfoAPI((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6]);
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return ApplicationInstanceServiceUtil.deleteInstanceStatusAPI((java.lang.String)arguments[0]);
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return ApplicationInstanceServiceUtil.setInstanceStatusAPI((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return ApplicationInstanceServiceUtil.toggleInstanceMaintenanceStatusAPI((java.lang.String)arguments[0]);
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getIdMappingInfoAPI((java.lang.String)arguments[0]);
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			ApplicationInstanceServiceUtil.getTestAPI((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			ApplicationInstanceServiceUtil.setPortletConfiguration();

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
}