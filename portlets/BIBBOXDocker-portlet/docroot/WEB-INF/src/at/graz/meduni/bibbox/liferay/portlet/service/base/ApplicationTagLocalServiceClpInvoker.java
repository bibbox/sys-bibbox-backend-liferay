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

import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationTagLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Robert Reihs
 * @generated
 */
@ProviderType
public class ApplicationTagLocalServiceClpInvoker {
	public ApplicationTagLocalServiceClpInvoker() {
		_methodName0 = "addApplicationTag";

		_methodParameterTypes0 = new String[] {
				"at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag"
			};

		_methodName1 = "createApplicationTag";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteApplicationTag";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteApplicationTag";

		_methodParameterTypes3 = new String[] {
				"at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag"
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

		_methodName10 = "fetchApplicationTag";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getApplicationTag";

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

		_methodName17 = "getApplicationTags";

		_methodParameterTypes17 = new String[] { "int", "int" };

		_methodName18 = "getApplicationTagsCount";

		_methodParameterTypes18 = new String[] {  };

		_methodName19 = "updateApplicationTag";

		_methodParameterTypes19 = new String[] {
				"at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag"
			};

		_methodName54 = "getOSGiServiceIdentifier";

		_methodParameterTypes54 = new String[] {  };

		_methodName59 = "getApplicationTags";

		_methodParameterTypes59 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.addApplicationTag((at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.createApplicationTag(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.deleteApplicationTag(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.deleteApplicationTag((at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator<?>)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.fetchApplicationTag(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.getApplicationTag(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.getActionableDynamicQuery();
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.getIndexableActionableDynamicQuery();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.deletePersistedModel((com.liferay.portal.kernel.model.PersistedModel)arguments[0]);
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName17.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes17, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.getApplicationTags(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName18.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.getApplicationTagsCount();
		}

		if (_methodName19.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.updateApplicationTag((at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag)arguments[0]);
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.getOSGiServiceIdentifier();
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return ApplicationTagLocalServiceUtil.getApplicationTags(((Long)arguments[0]).longValue());
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
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName59;
	private String[] _methodParameterTypes59;
}