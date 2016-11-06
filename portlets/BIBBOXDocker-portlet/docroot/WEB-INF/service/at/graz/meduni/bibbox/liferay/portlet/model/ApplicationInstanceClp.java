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

package at.graz.meduni.bibbox.liferay.portlet.model;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class ApplicationInstanceClp extends BaseModelImpl<ApplicationInstance>
	implements ApplicationInstance {
	public ApplicationInstanceClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ApplicationInstance.class;
	}

	@Override
	public String getModelClassName() {
		return ApplicationInstance.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _applicationInstanceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setApplicationInstanceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _applicationInstanceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("applicationInstanceId", getApplicationInstanceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("instanceId", getInstanceId());
		attributes.put("name", getName());
		attributes.put("folderName", getFolderName());
		attributes.put("shortName", getShortName());
		attributes.put("application", getApplication());
		attributes.put("version", getVersion());
		attributes.put("description", getDescription());
		attributes.put("installlog", getInstalllog());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long applicationInstanceId = (Long)attributes.get(
				"applicationInstanceId");

		if (applicationInstanceId != null) {
			setApplicationInstanceId(applicationInstanceId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String instanceId = (String)attributes.get("instanceId");

		if (instanceId != null) {
			setInstanceId(instanceId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String folderName = (String)attributes.get("folderName");

		if (folderName != null) {
			setFolderName(folderName);
		}

		String shortName = (String)attributes.get("shortName");

		if (shortName != null) {
			setShortName(shortName);
		}

		String application = (String)attributes.get("application");

		if (application != null) {
			setApplication(application);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String installlog = (String)attributes.get("installlog");

		if (installlog != null) {
			setInstalllog(installlog);
		}

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getApplicationInstanceId() {
		return _applicationInstanceId;
	}

	@Override
	public void setApplicationInstanceId(long applicationInstanceId) {
		_applicationInstanceId = applicationInstanceId;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationInstanceId",
						long.class);

				method.invoke(_applicationInstanceRemoteModel,
					applicationInstanceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_applicationInstanceRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_applicationInstanceRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_applicationInstanceRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_applicationInstanceRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_applicationInstanceRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_applicationInstanceRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInstanceId() {
		return _instanceId;
	}

	@Override
	public void setInstanceId(String instanceId) {
		_instanceId = instanceId;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setInstanceId", String.class);

				method.invoke(_applicationInstanceRemoteModel, instanceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_applicationInstanceRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFolderName() {
		return _folderName;
	}

	@Override
	public void setFolderName(String folderName) {
		_folderName = folderName;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setFolderName", String.class);

				method.invoke(_applicationInstanceRemoteModel, folderName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShortName() {
		return _shortName;
	}

	@Override
	public void setShortName(String shortName) {
		_shortName = shortName;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setShortName", String.class);

				method.invoke(_applicationInstanceRemoteModel, shortName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApplication() {
		return _application;
	}

	@Override
	public void setApplication(String application) {
		_application = application;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setApplication", String.class);

				method.invoke(_applicationInstanceRemoteModel, application);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVersion() {
		return _version;
	}

	@Override
	public void setVersion(String version) {
		_version = version;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", String.class);

				method.invoke(_applicationInstanceRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_applicationInstanceRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInstalllog() {
		return _installlog;
	}

	@Override
	public void setInstalllog(String installlog) {
		_installlog = installlog;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setInstalllog", String.class);

				method.invoke(_applicationInstanceRemoteModel, installlog);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getBaseInstallationConfigString() {
		try {
			String methodName = "getBaseInstallationConfigString";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getBasicProxyConfigString() {
		try {
			String methodName = "getBasicProxyConfigString";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getFolderPath() {
		try {
			String methodName = "getFolderPath";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public long getPrimaryPort() {
		try {
			String methodName = "getPrimaryPort";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Long returnObj = (Long)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void startUpApplicationInstance() {
		try {
			String methodName = "startUpApplicationInstance";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getApplicationInstanceRemoteModel() {
		return _applicationInstanceRemoteModel;
	}

	public void setApplicationInstanceRemoteModel(
		BaseModel<?> applicationInstanceRemoteModel) {
		_applicationInstanceRemoteModel = applicationInstanceRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _applicationInstanceRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_applicationInstanceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			ApplicationInstanceLocalServiceUtil.addApplicationInstance(this);
		}
		else {
			ApplicationInstanceLocalServiceUtil.updateApplicationInstance(this);
		}
	}

	@Override
	public ApplicationInstance toEscapedModel() {
		return (ApplicationInstance)ProxyUtil.newProxyInstance(ApplicationInstance.class.getClassLoader(),
			new Class[] { ApplicationInstance.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ApplicationInstanceClp clone = new ApplicationInstanceClp();

		clone.setApplicationInstanceId(getApplicationInstanceId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setInstanceId(getInstanceId());
		clone.setName(getName());
		clone.setFolderName(getFolderName());
		clone.setShortName(getShortName());
		clone.setApplication(getApplication());
		clone.setVersion(getVersion());
		clone.setDescription(getDescription());
		clone.setInstalllog(getInstalllog());

		return clone;
	}

	@Override
	public int compareTo(ApplicationInstance applicationInstance) {
		int value = 0;

		value = getFolderName().compareTo(applicationInstance.getFolderName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApplicationInstanceClp)) {
			return false;
		}

		ApplicationInstanceClp applicationInstance = (ApplicationInstanceClp)obj;

		long primaryKey = applicationInstance.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{applicationInstanceId=");
		sb.append(getApplicationInstanceId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", instanceId=");
		sb.append(getInstanceId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", folderName=");
		sb.append(getFolderName());
		sb.append(", shortName=");
		sb.append(getShortName());
		sb.append(", application=");
		sb.append(getApplication());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", installlog=");
		sb.append(getInstalllog());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>applicationInstanceId</column-name><column-value><![CDATA[");
		sb.append(getApplicationInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>instanceId</column-name><column-value><![CDATA[");
		sb.append(getInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folderName</column-name><column-value><![CDATA[");
		sb.append(getFolderName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortName</column-name><column-value><![CDATA[");
		sb.append(getShortName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>application</column-name><column-value><![CDATA[");
		sb.append(getApplication());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>installlog</column-name><column-value><![CDATA[");
		sb.append(getInstalllog());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _applicationInstanceId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _instanceId;
	private String _name;
	private String _folderName;
	private String _shortName;
	private String _application;
	private String _version;
	private String _description;
	private String _installlog;
	private BaseModel<?> _applicationInstanceRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}