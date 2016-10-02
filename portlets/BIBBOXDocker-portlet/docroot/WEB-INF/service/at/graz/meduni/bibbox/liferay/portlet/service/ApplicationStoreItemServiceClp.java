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

package at.graz.meduni.bibbox.liferay.portlet.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.InvokableService;

/**
 * @author Robert Reihs
 * @generated
 */
@ProviderType
public class ApplicationStoreItemServiceClp
	implements ApplicationStoreItemService {
	public ApplicationStoreItemServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "getApplicationStoreListAPI";

		_methodParameterTypes0 = new String[] {  };

		_methodName1 = "getApplicationStoreUpdatedListAPI";

		_methodParameterTypes1 = new String[] {  };

		_methodName2 = "getApplicationStoreItem";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "getApplicationStoreItemAPI";

		_methodParameterTypes3 = new String[] { "long" };

		_methodName5 = "getOSGiServiceIdentifier";

		_methodParameterTypes5 = new String[] {  };

		_methodName6 = "addApplicationStoreItem";

		_methodParameterTypes6 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getApplicationStoreListAPI() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName0,
					_methodParameterTypes0, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getApplicationStoreUpdatedListAPI() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName1,
					_methodParameterTypes1, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.json.JSONArray)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getApplicationStoreItem(
		long applicationstoreitemId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName2,
					_methodParameterTypes2,
					new Object[] { applicationstoreitemId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getApplicationStoreItemAPI(
		long applicationstoreitemId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] { applicationstoreitemId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void addApplicationStoreItem(java.lang.String name,
		java.lang.String shortname, java.lang.String version,
		java.lang.String release_state, java.lang.String description,
		java.lang.String catalogue_url, java.lang.String application_url,
		java.lang.String kits, java.lang.String tags) {
		try {
			_invokableService.invokeMethod(_methodName6,
				_methodParameterTypes6,
				new Object[] {
					ClpSerializer.translateInput(name),
					
				ClpSerializer.translateInput(shortname),
					
				ClpSerializer.translateInput(version),
					
				ClpSerializer.translateInput(release_state),
					
				ClpSerializer.translateInput(description),
					
				ClpSerializer.translateInput(catalogue_url),
					
				ClpSerializer.translateInput(application_url),
					
				ClpSerializer.translateInput(kits),
					
				ClpSerializer.translateInput(tags)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	private InvokableService _invokableService;
	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
}