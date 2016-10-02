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

import at.graz.meduni.bibbox.liferay.portlet.service.DockerContainerServiceUtil;

import java.util.Arrays;

/**
 * @author Robert Reihs
 * @generated
 */
@ProviderType
public class DockerContainerServiceClpInvoker {
	public DockerContainerServiceClpInvoker() {
		_methodName48 = "getOSGiServiceIdentifier";

		_methodParameterTypes48 = new String[] {  };

		_methodName53 = "getVersion";

		_methodParameterTypes53 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return DockerContainerServiceUtil.getOSGiServiceIdentifier();
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return DockerContainerServiceUtil.getVersion();
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName53;
	private String[] _methodParameterTypes53;
}