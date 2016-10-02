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

import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationStoreItemServiceUtil;

import java.util.Arrays;

/**
 * @author Robert Reihs
 * @generated
 */
@ProviderType
public class ApplicationStoreItemServiceClpInvoker {
	public ApplicationStoreItemServiceClpInvoker() {
		_methodName48 = "getOSGiServiceIdentifier";

		_methodParameterTypes48 = new String[] {  };

		_methodName53 = "getApplicationStoreListAPI";

		_methodParameterTypes53 = new String[] {  };

		_methodName54 = "getApplicationStoreUpdatedListAPI";

		_methodParameterTypes54 = new String[] {  };

		_methodName55 = "getApplicationStoreItemAPI";

		_methodParameterTypes55 = new String[] { "long" };

		_methodName56 = "getApplicationStoreItem";

		_methodParameterTypes56 = new String[] { "long" };

		_methodName57 = "addApplicationStoreItem";

		_methodParameterTypes57 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return ApplicationStoreItemServiceUtil.getOSGiServiceIdentifier();
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return ApplicationStoreItemServiceUtil.getApplicationStoreListAPI();
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return ApplicationStoreItemServiceUtil.getApplicationStoreUpdatedListAPI();
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return ApplicationStoreItemServiceUtil.getApplicationStoreItemAPI(((Long)arguments[0]).longValue());
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return ApplicationStoreItemServiceUtil.getApplicationStoreItem(((Long)arguments[0]).longValue());
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			ApplicationStoreItemServiceUtil.addApplicationStoreItem((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7], (java.lang.String)arguments[8]);

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName48;
	private String[] _methodParameterTypes48;
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