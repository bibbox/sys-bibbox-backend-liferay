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

import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Robert Reihs
 * @generated
 */
@ProviderType
public class ApplicationInstanceLocalServiceClpInvoker {
	public ApplicationInstanceLocalServiceClpInvoker() {
		_methodName0 = "addApplicationInstance";

		_methodParameterTypes0 = new String[] {
				"at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance"
			};

		_methodName1 = "createApplicationInstance";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteApplicationInstance";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteApplicationInstance";

		_methodParameterTypes3 = new String[] {
				"at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchApplicationInstance";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getApplicationInstance";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getActionableDynamicQuery";

		_methodParameterTypes12 = new String[] {  };

		_methodName13 = "getIndexableActionableDynamicQuery";

		_methodParameterTypes13 = new String[] {  };

		_methodName15 = "deletePersistedModel";

		_methodParameterTypes15 = new String[] {
				"com.liferay.portal.kernel.model.PersistedModel"
			};

		_methodName16 = "getPersistedModel";

		_methodParameterTypes16 = new String[] { "java.io.Serializable" };

		_methodName17 = "getApplicationInstances";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getApplicationInstancesCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateApplicationInstance";

		_methodParameterTypes19 = new String[] {
				"at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance"
			};

		_methodName50 = "getOSGiServiceIdentifier";

		_methodParameterTypes50 = new String[] {  };

		_methodName55 = "checkInstanceNameAvailable";

		_methodParameterTypes55 = new String[] { "java.lang.String" };

		_methodName56 = "getApplicationInstance";

		_methodParameterTypes56 = new String[] { "java.lang.String" };

		_methodName57 = "getActiveApplicationInstances";

		_methodParameterTypes57 = new String[] {  };

		_methodName58 = "registerApplication";

		_methodParameterTypes58 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName59 = "getUsedInstanceIds";

		_methodParameterTypes59 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.addApplicationInstance((at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.createApplicationInstance(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.deleteApplicationInstance(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.deleteApplicationInstance((at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator<?>)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.fetchApplicationInstance(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.getApplicationInstance(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.getActionableDynamicQuery();
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.getIndexableActionableDynamicQuery();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.deletePersistedModel((com.liferay.portal.kernel.model.PersistedModel)arguments[0]);
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.getApplicationInstances(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.getApplicationInstancesCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.updateApplicationInstance((at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance)arguments[0]);
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.getOSGiServiceIdentifier();
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.checkInstanceNameAvailable((java.lang.String)arguments[0]);
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.getApplicationInstance((java.lang.String)arguments[0]);
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.getActiveApplicationInstances();
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.registerApplication((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3]);
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return ApplicationInstanceLocalServiceUtil.getUsedInstanceIds();
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName18;
	private String[] _methodParameterTypes18;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName50;
	private String[] _methodParameterTypes50;
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
}