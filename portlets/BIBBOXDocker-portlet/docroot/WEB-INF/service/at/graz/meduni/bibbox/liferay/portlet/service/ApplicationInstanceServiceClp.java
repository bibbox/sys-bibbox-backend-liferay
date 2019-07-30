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
public class ApplicationInstanceServiceClp implements ApplicationInstanceService {
	public ApplicationInstanceServiceClp(InvokableService invokableService) {
		_invokableService = invokableService;

		_methodName0 = "deleteInstanceStatusAPI";

		_methodParameterTypes0 = new String[] { "java.lang.String" };

		_methodName1 = "getApplicationStoreItemAPI";

		_methodParameterTypes1 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName2 = "getApplicationStoreListAPI";

		_methodParameterTypes2 = new String[] {  };

		_methodName3 = "getIdMappingInfoAPI";

		_methodParameterTypes3 = new String[] { "java.lang.String" };

		_methodName4 = "getInstanceDashboardAPI";

		_methodParameterTypes4 = new String[] { "java.lang.String" };

		_methodName5 = "getInstanceInfoAPI";

		_methodParameterTypes5 = new String[] { "java.lang.String" };

		_methodName6 = "getInstanceListAPI";

		_methodParameterTypes6 = new String[] {  };

		_methodName7 = "getInstanceLogdAPI";

		_methodParameterTypes7 = new String[] { "java.lang.String" };

		_methodName8 = "getInstanceLogdAPI";

		_methodParameterTypes8 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName9 = "getInstanceMaintenanceAPI";

		_methodParameterTypes9 = new String[] { "java.lang.String" };

		_methodName10 = "getMetaDataInformationAppAPI";

		_methodParameterTypes10 = new String[] { "java.lang.String" };

		_methodName11 = "getMetaDataInformationDomainAPI";

		_methodParameterTypes11 = new String[] {  };

		_methodName12 = "getMetaDataInformationMachineAPI";

		_methodParameterTypes12 = new String[] {  };

		_methodName13 = "getOpenApplicationInfo";

		_methodParameterTypes13 = new String[] { "java.lang.String" };

		_methodName14 = "getOpenApplicationListAPI";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "getUpdatedApplicationStoreListAPI";

		_methodParameterTypes15 = new String[] {  };

		_methodName16 = "getVersionAPI";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "installApplicationAPI";

		_methodParameterTypes17 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName18 = "setInstanceStatusAPI";

		_methodParameterTypes18 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName19 = "setPortletConfiguration";

		_methodParameterTypes19 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String"
			};

		_methodName20 = "toggleInstanceMaintenanceStatusAPI";

		_methodParameterTypes20 = new String[] { "java.lang.String" };

		_methodName21 = "updateInstanceInfoAPI";

		_methodParameterTypes21 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName23 = "getOSGiServiceIdentifier";

		_methodParameterTypes23 = new String[] {  };

		_methodName24 = "getTestAPI";

		_methodParameterTypes24 = new String[] { "java.lang.String" };

		_methodName25 = "updateMetadataInfoAppAPI";

		_methodParameterTypes25 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName26 = "updateMetadataInfoDomainAPI";

		_methodParameterTypes26 = new String[] { "java.lang.String" };

		_methodName27 = "updateMetadataInfoMachineAPI";

		_methodParameterTypes27 = new String[] { "java.lang.String" };
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject deleteInstanceStatusAPI(
		java.lang.String instanceId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName0,
					_methodParameterTypes0,
					new Object[] { ClpSerializer.translateInput(instanceId) });
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
		java.lang.String applicationname, java.lang.String version) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName1,
					_methodParameterTypes1,
					new Object[] {
						ClpSerializer.translateInput(applicationname),
						
					ClpSerializer.translateInput(version)
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

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getApplicationStoreListAPI() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName2,
					_methodParameterTypes2, new Object[] {  });
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
	public com.liferay.portal.kernel.json.JSONObject getIdMappingInfoAPI(
		java.lang.String instanceId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] { ClpSerializer.translateInput(instanceId) });
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
	public com.liferay.portal.kernel.json.JSONObject getInstanceDashboardAPI(
		java.lang.String instanceId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName4,
					_methodParameterTypes4,
					new Object[] { ClpSerializer.translateInput(instanceId) });
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
	public com.liferay.portal.kernel.json.JSONObject getInstanceInfoAPI(
		java.lang.String instanceId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { ClpSerializer.translateInput(instanceId) });
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
	public com.liferay.portal.kernel.json.JSONObject getInstanceListAPI() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName6,
					_methodParameterTypes6, new Object[] {  });
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
	public com.liferay.portal.kernel.json.JSONObject getInstanceLogdAPI(
		java.lang.String instanceId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] { ClpSerializer.translateInput(instanceId) });
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
	public com.liferay.portal.kernel.json.JSONObject getInstanceLogdAPI(
		java.lang.String instanceId, java.lang.String lines) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] {
						ClpSerializer.translateInput(instanceId),
						
					ClpSerializer.translateInput(lines)
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

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getInstanceMaintenanceAPI(
		java.lang.String instanceId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] { ClpSerializer.translateInput(instanceId) });
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
	public com.liferay.portal.kernel.json.JSONObject getMetaDataInformationAppAPI(
		java.lang.String instanceId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName10,
					_methodParameterTypes10,
					new Object[] { ClpSerializer.translateInput(instanceId) });
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
	public com.liferay.portal.kernel.json.JSONObject getMetaDataInformationDomainAPI() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName11,
					_methodParameterTypes11, new Object[] {  });
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
	public com.liferay.portal.kernel.json.JSONObject getMetaDataInformationMachineAPI() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName12,
					_methodParameterTypes12, new Object[] {  });
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
	public com.liferay.portal.kernel.json.JSONObject getOpenApplicationInfo(
		java.lang.String instanceId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName13,
					_methodParameterTypes13,
					new Object[] { ClpSerializer.translateInput(instanceId) });
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
	public com.liferay.portal.kernel.json.JSONObject getOpenApplicationListAPI() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName14,
					_methodParameterTypes14, new Object[] {  });
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
	public com.liferay.portal.kernel.json.JSONObject getUpdatedApplicationStoreListAPI() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName15,
					_methodParameterTypes15, new Object[] {  });
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
	public com.liferay.portal.kernel.json.JSONObject getVersionAPI() {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName16,
					_methodParameterTypes16, new Object[] {  });
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
	public com.liferay.portal.kernel.json.JSONObject installApplicationAPI(
		java.lang.String applicationname, java.lang.String version,
		java.lang.String instanceid, java.lang.String instancename,
		java.lang.String data) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName17,
					_methodParameterTypes17,
					new Object[] {
						ClpSerializer.translateInput(applicationname),
						
					ClpSerializer.translateInput(version),
						
					ClpSerializer.translateInput(instanceid),
						
					ClpSerializer.translateInput(instancename),
						
					ClpSerializer.translateInput(data)
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

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject setInstanceStatusAPI(
		java.lang.String instanceId, java.lang.String status) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName18,
					_methodParameterTypes18,
					new Object[] {
						ClpSerializer.translateInput(instanceId),
						
					ClpSerializer.translateInput(status)
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

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject setPortletConfiguration(
		long companyId, long plid, java.lang.String portletId,
		java.lang.String preferences) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName19,
					_methodParameterTypes19,
					new Object[] {
						companyId,
						
					plid,
						
					ClpSerializer.translateInput(portletId),
						
					ClpSerializer.translateInput(preferences)
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

		return (com.liferay.portal.kernel.json.JSONObject)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject toggleInstanceMaintenanceStatusAPI(
		java.lang.String instanceId) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName20,
					_methodParameterTypes20,
					new Object[] { ClpSerializer.translateInput(instanceId) });
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
	public com.liferay.portal.kernel.json.JSONObject updateInstanceInfoAPI(
		java.lang.String instanceId, java.lang.String instancename,
		java.lang.String instanceshortname, java.lang.String description,
		java.lang.String shortdescription, java.lang.String adminnode,
		java.lang.String maintenance) {
		Object returnObj = null;

		try {
			returnObj = _invokableService.invokeMethod(_methodName21,
					_methodParameterTypes21,
					new Object[] {
						ClpSerializer.translateInput(instanceId),
						
					ClpSerializer.translateInput(instancename),
						
					ClpSerializer.translateInput(instanceshortname),
						
					ClpSerializer.translateInput(description),
						
					ClpSerializer.translateInput(shortdescription),
						
					ClpSerializer.translateInput(adminnode),
						
					ClpSerializer.translateInput(maintenance)
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
			returnObj = _invokableService.invokeMethod(_methodName23,
					_methodParameterTypes23, new Object[] {  });
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
	public void getTestAPI(java.lang.String string) {
		try {
			_invokableService.invokeMethod(_methodName24,
				_methodParameterTypes24,
				new Object[] { ClpSerializer.translateInput(string) });
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

	@Override
	public void updateMetadataInfoAppAPI(java.lang.String instanceId,
		java.lang.String data) {
		try {
			_invokableService.invokeMethod(_methodName25,
				_methodParameterTypes25,
				new Object[] {
					ClpSerializer.translateInput(instanceId),
					
				ClpSerializer.translateInput(data)
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

	@Override
	public void updateMetadataInfoDomainAPI(java.lang.String data) {
		try {
			_invokableService.invokeMethod(_methodName26,
				_methodParameterTypes26,
				new Object[] { ClpSerializer.translateInput(data) });
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

	@Override
	public void updateMetadataInfoMachineAPI(java.lang.String data) {
		try {
			_invokableService.invokeMethod(_methodName27,
				_methodParameterTypes27,
				new Object[] { ClpSerializer.translateInput(data) });
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
	private String _methodName14;
	private String[] _methodParameterTypes14;
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
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
}