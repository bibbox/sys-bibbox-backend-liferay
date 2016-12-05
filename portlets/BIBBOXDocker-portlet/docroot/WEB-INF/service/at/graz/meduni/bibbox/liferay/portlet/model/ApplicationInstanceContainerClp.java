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

import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceContainerLocalServiceUtil;
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
public class ApplicationInstanceContainerClp extends BaseModelImpl<ApplicationInstanceContainer>
	implements ApplicationInstanceContainer {
	public ApplicationInstanceContainerClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ApplicationInstanceContainer.class;
	}

	@Override
	public String getModelClassName() {
		return ApplicationInstanceContainer.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _applicationInstanceContainerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setApplicationInstanceContainerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _applicationInstanceContainerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("applicationInstanceContainerId",
			getApplicationInstanceContainerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("containerName", getContainerName());
		attributes.put("needrunning", getNeedrunning());
		attributes.put("running", getRunning());
		attributes.put("applicationInstanceId", getApplicationInstanceId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long applicationInstanceContainerId = (Long)attributes.get(
				"applicationInstanceContainerId");

		if (applicationInstanceContainerId != null) {
			setApplicationInstanceContainerId(applicationInstanceContainerId);
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

		String containerName = (String)attributes.get("containerName");

		if (containerName != null) {
			setContainerName(containerName);
		}

		Boolean needrunning = (Boolean)attributes.get("needrunning");

		if (needrunning != null) {
			setNeedrunning(needrunning);
		}

		Boolean running = (Boolean)attributes.get("running");

		if (running != null) {
			setRunning(running);
		}

		Long applicationInstanceId = (Long)attributes.get(
				"applicationInstanceId");

		if (applicationInstanceId != null) {
			setApplicationInstanceId(applicationInstanceId);
		}

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getApplicationInstanceContainerId() {
		return _applicationInstanceContainerId;
	}

	@Override
	public void setApplicationInstanceContainerId(
		long applicationInstanceContainerId) {
		_applicationInstanceContainerId = applicationInstanceContainerId;

		if (_applicationInstanceContainerRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationInstanceContainerId",
						long.class);

				method.invoke(_applicationInstanceContainerRemoteModel,
					applicationInstanceContainerId);
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

		if (_applicationInstanceContainerRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_applicationInstanceContainerRemoteModel, groupId);
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

		if (_applicationInstanceContainerRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_applicationInstanceContainerRemoteModel,
					companyId);
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

		if (_applicationInstanceContainerRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_applicationInstanceContainerRemoteModel, userId);
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

		if (_applicationInstanceContainerRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_applicationInstanceContainerRemoteModel, userName);
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

		if (_applicationInstanceContainerRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_applicationInstanceContainerRemoteModel,
					createDate);
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

		if (_applicationInstanceContainerRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_applicationInstanceContainerRemoteModel,
					modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContainerName() {
		return _containerName;
	}

	@Override
	public void setContainerName(String containerName) {
		_containerName = containerName;

		if (_applicationInstanceContainerRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setContainerName", String.class);

				method.invoke(_applicationInstanceContainerRemoteModel,
					containerName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getNeedrunning() {
		return _needrunning;
	}

	@Override
	public boolean isNeedrunning() {
		return _needrunning;
	}

	@Override
	public void setNeedrunning(boolean needrunning) {
		_needrunning = needrunning;

		if (_applicationInstanceContainerRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setNeedrunning", boolean.class);

				method.invoke(_applicationInstanceContainerRemoteModel,
					needrunning);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRunning() {
		return _running;
	}

	@Override
	public boolean isRunning() {
		return _running;
	}

	@Override
	public void setRunning(boolean running) {
		_running = running;

		if (_applicationInstanceContainerRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setRunning", boolean.class);

				method.invoke(_applicationInstanceContainerRemoteModel, running);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getApplicationInstanceId() {
		return _applicationInstanceId;
	}

	@Override
	public void setApplicationInstanceId(long applicationInstanceId) {
		_applicationInstanceId = applicationInstanceId;

		if (_applicationInstanceContainerRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationInstanceId",
						long.class);

				method.invoke(_applicationInstanceContainerRemoteModel,
					applicationInstanceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getContainerLog(
		java.lang.String lines) {
		try {
			String methodName = "getContainerLog";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { lines };

			com.liferay.portal.kernel.json.JSONObject returnObj = (com.liferay.portal.kernel.json.JSONObject)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean ApplicationInstanceExists() {
		try {
			String methodName = "ApplicationInstanceExists";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getApplicationInstanceContainerRemoteModel() {
		return _applicationInstanceContainerRemoteModel;
	}

	public void setApplicationInstanceContainerRemoteModel(
		BaseModel<?> applicationInstanceContainerRemoteModel) {
		_applicationInstanceContainerRemoteModel = applicationInstanceContainerRemoteModel;
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

		Class<?> remoteModelClass = _applicationInstanceContainerRemoteModel.getClass();

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

		Object returnValue = method.invoke(_applicationInstanceContainerRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			ApplicationInstanceContainerLocalServiceUtil.addApplicationInstanceContainer(this);
		}
		else {
			ApplicationInstanceContainerLocalServiceUtil.updateApplicationInstanceContainer(this);
		}
	}

	@Override
	public ApplicationInstanceContainer toEscapedModel() {
		return (ApplicationInstanceContainer)ProxyUtil.newProxyInstance(ApplicationInstanceContainer.class.getClassLoader(),
			new Class[] { ApplicationInstanceContainer.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ApplicationInstanceContainerClp clone = new ApplicationInstanceContainerClp();

		clone.setApplicationInstanceContainerId(getApplicationInstanceContainerId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setContainerName(getContainerName());
		clone.setNeedrunning(getNeedrunning());
		clone.setRunning(getRunning());
		clone.setApplicationInstanceId(getApplicationInstanceId());

		return clone;
	}

	@Override
	public int compareTo(
		ApplicationInstanceContainer applicationInstanceContainer) {
		int value = 0;

		if (getApplicationInstanceId() < applicationInstanceContainer.getApplicationInstanceId()) {
			value = -1;
		}
		else if (getApplicationInstanceId() > applicationInstanceContainer.getApplicationInstanceId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof ApplicationInstanceContainerClp)) {
			return false;
		}

		ApplicationInstanceContainerClp applicationInstanceContainer = (ApplicationInstanceContainerClp)obj;

		long primaryKey = applicationInstanceContainer.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{applicationInstanceContainerId=");
		sb.append(getApplicationInstanceContainerId());
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
		sb.append(", containerName=");
		sb.append(getContainerName());
		sb.append(", needrunning=");
		sb.append(getNeedrunning());
		sb.append(", running=");
		sb.append(getRunning());
		sb.append(", applicationInstanceId=");
		sb.append(getApplicationInstanceId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>applicationInstanceContainerId</column-name><column-value><![CDATA[");
		sb.append(getApplicationInstanceContainerId());
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
			"<column><column-name>containerName</column-name><column-value><![CDATA[");
		sb.append(getContainerName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>needrunning</column-name><column-value><![CDATA[");
		sb.append(getNeedrunning());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>running</column-name><column-value><![CDATA[");
		sb.append(getRunning());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationInstanceId</column-name><column-value><![CDATA[");
		sb.append(getApplicationInstanceId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _applicationInstanceContainerId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _containerName;
	private boolean _needrunning;
	private boolean _running;
	private long _applicationInstanceId;
	private BaseModel<?> _applicationInstanceContainerRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}