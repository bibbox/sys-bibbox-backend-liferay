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
		_methodName42 = "getOSGiServiceIdentifier";

		_methodParameterTypes42 = new String[] {  };

		_methodName47 = "getVersionAPI";

		_methodParameterTypes47 = new String[] {  };

		_methodName48 = "getApplicationStoreListAPI";

		_methodParameterTypes48 = new String[] {  };

		_methodName49 = "getUpdatedApplicationStoreListAPI";

		_methodParameterTypes49 = new String[] {  };

		_methodName50 = "getApplicationStoreItemAPI";

		_methodParameterTypes50 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName51 = "installApplicationAPI";

		_methodParameterTypes51 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName52 = "getInstanceListAPI";

		_methodParameterTypes52 = new String[] {  };

		_methodName53 = "getInstanceInfoAPI";

		_methodParameterTypes53 = new String[] { "java.lang.String" };

		_methodName54 = "getInstanceDashboardAPI";

		_methodParameterTypes54 = new String[] { "java.lang.String" };

		_methodName55 = "getInstanceLogdAPI";

		_methodParameterTypes55 = new String[] { "java.lang.String" };

		_methodName56 = "getInstanceLogdAPI";

		_methodParameterTypes56 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName57 = "getInstanceMaintenanceAPI";

		_methodParameterTypes57 = new String[] { "java.lang.String" };

		_methodName58 = "updateInstanceInfoAPI";

		_methodParameterTypes58 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName59 = "deleteInstanceStatusAPI";

		_methodParameterTypes59 = new String[] { "java.lang.String" };

		_methodName60 = "setInstanceStatusAPI";

		_methodParameterTypes60 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName61 = "toggleInstanceMaintenanceStatusAPI";

		_methodParameterTypes61 = new String[] { "java.lang.String" };

		_methodName62 = "getIdMappingInfoAPI";

		_methodParameterTypes62 = new String[] { "java.lang.String" };

		_methodName63 = "getTestAPI";

		_methodParameterTypes63 = new String[] { "java.lang.String" };

		_methodName64 = "setPortletConfiguration";

		_methodParameterTypes64 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String"
			};

		_methodName65 = "getMetaDataInformationAppAPI";

		_methodParameterTypes65 = new String[] { "java.lang.String" };

		_methodName66 = "getMetaDataInformationMachineAPI";

		_methodParameterTypes66 = new String[] {  };

		_methodName67 = "getMetaDataInformationDomainAPI";

		_methodParameterTypes67 = new String[] {  };

		_methodName68 = "updateMetadataInfoAppAPI";

		_methodParameterTypes68 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName69 = "updateMetadataInfoMachineAPI";

		_methodParameterTypes69 = new String[] { "java.lang.String" };

		_methodName70 = "updateMetadataInfoDomainAPI";

		_methodParameterTypes70 = new String[] { "java.lang.String" };

		_methodName71 = "getOpenApplicationListAPI";

		_methodParameterTypes71 = new String[] {  };

		_methodName72 = "getOpenApplicationInfo";

		_methodParameterTypes72 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getOSGiServiceIdentifier();
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getVersionAPI();
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getApplicationStoreListAPI();
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getUpdatedApplicationStoreListAPI();
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getApplicationStoreItemAPI((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			return ApplicationInstanceServiceUtil.installApplicationAPI((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4]);
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getInstanceListAPI();
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getInstanceInfoAPI((java.lang.String)arguments[0]);
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getInstanceDashboardAPI((java.lang.String)arguments[0]);
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getInstanceLogdAPI((java.lang.String)arguments[0]);
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getInstanceLogdAPI((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getInstanceMaintenanceAPI((java.lang.String)arguments[0]);
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return ApplicationInstanceServiceUtil.updateInstanceInfoAPI((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6]);
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return ApplicationInstanceServiceUtil.deleteInstanceStatusAPI((java.lang.String)arguments[0]);
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return ApplicationInstanceServiceUtil.setInstanceStatusAPI((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return ApplicationInstanceServiceUtil.toggleInstanceMaintenanceStatusAPI((java.lang.String)arguments[0]);
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getIdMappingInfoAPI((java.lang.String)arguments[0]);
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			ApplicationInstanceServiceUtil.getTestAPI((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return ApplicationInstanceServiceUtil.setPortletConfiguration(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName65.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes65, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getMetaDataInformationAppAPI((java.lang.String)arguments[0]);
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getMetaDataInformationMachineAPI();
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getMetaDataInformationDomainAPI();
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			ApplicationInstanceServiceUtil.updateMetadataInfoAppAPI((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);

			return null;
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			ApplicationInstanceServiceUtil.updateMetadataInfoMachineAPI((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			ApplicationInstanceServiceUtil.updateMetadataInfoDomainAPI((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getOpenApplicationListAPI();
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return ApplicationInstanceServiceUtil.getOpenApplicationInfo((java.lang.String)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName42;
	private String[] _methodParameterTypes42;
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
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
}