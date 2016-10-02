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

import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationStoreItemLocalServiceUtil;
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
public class ApplicationStoreItemClp extends BaseModelImpl<ApplicationStoreItem>
	implements ApplicationStoreItem {
	public ApplicationStoreItemClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ApplicationStoreItem.class;
	}

	@Override
	public String getModelClassName() {
		return ApplicationStoreItem.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _applicationStoreItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setApplicationStoreItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _applicationStoreItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("applicationStoreItemId", getApplicationStoreItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("githash", getGithash());
		attributes.put("depreciated", getDepreciated());
		attributes.put("applicationFolderName", getApplicationFolderName());
		attributes.put("applicationName", getApplicationName());
		attributes.put("applicationShortName", getApplicationShortName());
		attributes.put("applicationVersion", getApplicationVersion());
		attributes.put("applicationReleaseState", getApplicationReleaseState());
		attributes.put("applicationDescription", getApplicationDescription());
		attributes.put("applicationCatalogueUrl", getApplicationCatalogueUrl());
		attributes.put("applicationApplicationUrl",
			getApplicationApplicationUrl());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long applicationStoreItemId = (Long)attributes.get(
				"applicationStoreItemId");

		if (applicationStoreItemId != null) {
			setApplicationStoreItemId(applicationStoreItemId);
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

		String githash = (String)attributes.get("githash");

		if (githash != null) {
			setGithash(githash);
		}

		Boolean depreciated = (Boolean)attributes.get("depreciated");

		if (depreciated != null) {
			setDepreciated(depreciated);
		}

		String applicationFolderName = (String)attributes.get(
				"applicationFolderName");

		if (applicationFolderName != null) {
			setApplicationFolderName(applicationFolderName);
		}

		String applicationName = (String)attributes.get("applicationName");

		if (applicationName != null) {
			setApplicationName(applicationName);
		}

		String applicationShortName = (String)attributes.get(
				"applicationShortName");

		if (applicationShortName != null) {
			setApplicationShortName(applicationShortName);
		}

		String applicationVersion = (String)attributes.get("applicationVersion");

		if (applicationVersion != null) {
			setApplicationVersion(applicationVersion);
		}

		String applicationReleaseState = (String)attributes.get(
				"applicationReleaseState");

		if (applicationReleaseState != null) {
			setApplicationReleaseState(applicationReleaseState);
		}

		String applicationDescription = (String)attributes.get(
				"applicationDescription");

		if (applicationDescription != null) {
			setApplicationDescription(applicationDescription);
		}

		String applicationCatalogueUrl = (String)attributes.get(
				"applicationCatalogueUrl");

		if (applicationCatalogueUrl != null) {
			setApplicationCatalogueUrl(applicationCatalogueUrl);
		}

		String applicationApplicationUrl = (String)attributes.get(
				"applicationApplicationUrl");

		if (applicationApplicationUrl != null) {
			setApplicationApplicationUrl(applicationApplicationUrl);
		}

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getApplicationStoreItemId() {
		return _applicationStoreItemId;
	}

	@Override
	public void setApplicationStoreItemId(long applicationStoreItemId) {
		_applicationStoreItemId = applicationStoreItemId;

		if (_applicationStoreItemRemoteModel != null) {
			try {
				Class<?> clazz = _applicationStoreItemRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationStoreItemId",
						long.class);

				method.invoke(_applicationStoreItemRemoteModel,
					applicationStoreItemId);
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

		if (_applicationStoreItemRemoteModel != null) {
			try {
				Class<?> clazz = _applicationStoreItemRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_applicationStoreItemRemoteModel, groupId);
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

		if (_applicationStoreItemRemoteModel != null) {
			try {
				Class<?> clazz = _applicationStoreItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_applicationStoreItemRemoteModel, companyId);
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

		if (_applicationStoreItemRemoteModel != null) {
			try {
				Class<?> clazz = _applicationStoreItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_applicationStoreItemRemoteModel, userId);
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

		if (_applicationStoreItemRemoteModel != null) {
			try {
				Class<?> clazz = _applicationStoreItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_applicationStoreItemRemoteModel, userName);
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

		if (_applicationStoreItemRemoteModel != null) {
			try {
				Class<?> clazz = _applicationStoreItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_applicationStoreItemRemoteModel, createDate);
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

		if (_applicationStoreItemRemoteModel != null) {
			try {
				Class<?> clazz = _applicationStoreItemRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_applicationStoreItemRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGithash() {
		return _githash;
	}

	@Override
	public void setGithash(String githash) {
		_githash = githash;

		if (_applicationStoreItemRemoteModel != null) {
			try {
				Class<?> clazz = _applicationStoreItemRemoteModel.getClass();

				Method method = clazz.getMethod("setGithash", String.class);

				method.invoke(_applicationStoreItemRemoteModel, githash);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Boolean getDepreciated() {
		return _depreciated;
	}

	@Override
	public void setDepreciated(Boolean depreciated) {
		_depreciated = depreciated;

		if (_applicationStoreItemRemoteModel != null) {
			try {
				Class<?> clazz = _applicationStoreItemRemoteModel.getClass();

				Method method = clazz.getMethod("setDepreciated", Boolean.class);

				method.invoke(_applicationStoreItemRemoteModel, depreciated);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApplicationFolderName() {
		return _applicationFolderName;
	}

	@Override
	public void setApplicationFolderName(String applicationFolderName) {
		_applicationFolderName = applicationFolderName;

		if (_applicationStoreItemRemoteModel != null) {
			try {
				Class<?> clazz = _applicationStoreItemRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationFolderName",
						String.class);

				method.invoke(_applicationStoreItemRemoteModel,
					applicationFolderName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApplicationName() {
		return _applicationName;
	}

	@Override
	public void setApplicationName(String applicationName) {
		_applicationName = applicationName;

		if (_applicationStoreItemRemoteModel != null) {
			try {
				Class<?> clazz = _applicationStoreItemRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationName",
						String.class);

				method.invoke(_applicationStoreItemRemoteModel, applicationName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApplicationShortName() {
		return _applicationShortName;
	}

	@Override
	public void setApplicationShortName(String applicationShortName) {
		_applicationShortName = applicationShortName;

		if (_applicationStoreItemRemoteModel != null) {
			try {
				Class<?> clazz = _applicationStoreItemRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationShortName",
						String.class);

				method.invoke(_applicationStoreItemRemoteModel,
					applicationShortName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApplicationVersion() {
		return _applicationVersion;
	}

	@Override
	public void setApplicationVersion(String applicationVersion) {
		_applicationVersion = applicationVersion;

		if (_applicationStoreItemRemoteModel != null) {
			try {
				Class<?> clazz = _applicationStoreItemRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationVersion",
						String.class);

				method.invoke(_applicationStoreItemRemoteModel,
					applicationVersion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApplicationReleaseState() {
		return _applicationReleaseState;
	}

	@Override
	public void setApplicationReleaseState(String applicationReleaseState) {
		_applicationReleaseState = applicationReleaseState;

		if (_applicationStoreItemRemoteModel != null) {
			try {
				Class<?> clazz = _applicationStoreItemRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationReleaseState",
						String.class);

				method.invoke(_applicationStoreItemRemoteModel,
					applicationReleaseState);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApplicationDescription() {
		return _applicationDescription;
	}

	@Override
	public void setApplicationDescription(String applicationDescription) {
		_applicationDescription = applicationDescription;

		if (_applicationStoreItemRemoteModel != null) {
			try {
				Class<?> clazz = _applicationStoreItemRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationDescription",
						String.class);

				method.invoke(_applicationStoreItemRemoteModel,
					applicationDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApplicationCatalogueUrl() {
		return _applicationCatalogueUrl;
	}

	@Override
	public void setApplicationCatalogueUrl(String applicationCatalogueUrl) {
		_applicationCatalogueUrl = applicationCatalogueUrl;

		if (_applicationStoreItemRemoteModel != null) {
			try {
				Class<?> clazz = _applicationStoreItemRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationCatalogueUrl",
						String.class);

				method.invoke(_applicationStoreItemRemoteModel,
					applicationCatalogueUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApplicationApplicationUrl() {
		return _applicationApplicationUrl;
	}

	@Override
	public void setApplicationApplicationUrl(String applicationApplicationUrl) {
		_applicationApplicationUrl = applicationApplicationUrl;

		if (_applicationStoreItemRemoteModel != null) {
			try {
				Class<?> clazz = _applicationStoreItemRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationApplicationUrl",
						String.class);

				method.invoke(_applicationStoreItemRemoteModel,
					applicationApplicationUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag> getApplicationTags() {
		try {
			String methodName = "getApplicationTags";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag> returnObj =
				(java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getApplicationStoreItemRemoteModel() {
		return _applicationStoreItemRemoteModel;
	}

	public void setApplicationStoreItemRemoteModel(
		BaseModel<?> applicationStoreItemRemoteModel) {
		_applicationStoreItemRemoteModel = applicationStoreItemRemoteModel;
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

		Class<?> remoteModelClass = _applicationStoreItemRemoteModel.getClass();

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

		Object returnValue = method.invoke(_applicationStoreItemRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			ApplicationStoreItemLocalServiceUtil.addApplicationStoreItem(this);
		}
		else {
			ApplicationStoreItemLocalServiceUtil.updateApplicationStoreItem(this);
		}
	}

	@Override
	public ApplicationStoreItem toEscapedModel() {
		return (ApplicationStoreItem)ProxyUtil.newProxyInstance(ApplicationStoreItem.class.getClassLoader(),
			new Class[] { ApplicationStoreItem.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ApplicationStoreItemClp clone = new ApplicationStoreItemClp();

		clone.setApplicationStoreItemId(getApplicationStoreItemId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setGithash(getGithash());
		clone.setDepreciated(getDepreciated());
		clone.setApplicationFolderName(getApplicationFolderName());
		clone.setApplicationName(getApplicationName());
		clone.setApplicationShortName(getApplicationShortName());
		clone.setApplicationVersion(getApplicationVersion());
		clone.setApplicationReleaseState(getApplicationReleaseState());
		clone.setApplicationDescription(getApplicationDescription());
		clone.setApplicationCatalogueUrl(getApplicationCatalogueUrl());
		clone.setApplicationApplicationUrl(getApplicationApplicationUrl());

		return clone;
	}

	@Override
	public int compareTo(ApplicationStoreItem applicationStoreItem) {
		int value = 0;

		value = getApplicationName()
					.compareTo(applicationStoreItem.getApplicationName());

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

		if (!(obj instanceof ApplicationStoreItemClp)) {
			return false;
		}

		ApplicationStoreItemClp applicationStoreItem = (ApplicationStoreItemClp)obj;

		long primaryKey = applicationStoreItem.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{applicationStoreItemId=");
		sb.append(getApplicationStoreItemId());
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
		sb.append(", githash=");
		sb.append(getGithash());
		sb.append(", depreciated=");
		sb.append(getDepreciated());
		sb.append(", applicationFolderName=");
		sb.append(getApplicationFolderName());
		sb.append(", applicationName=");
		sb.append(getApplicationName());
		sb.append(", applicationShortName=");
		sb.append(getApplicationShortName());
		sb.append(", applicationVersion=");
		sb.append(getApplicationVersion());
		sb.append(", applicationReleaseState=");
		sb.append(getApplicationReleaseState());
		sb.append(", applicationDescription=");
		sb.append(getApplicationDescription());
		sb.append(", applicationCatalogueUrl=");
		sb.append(getApplicationCatalogueUrl());
		sb.append(", applicationApplicationUrl=");
		sb.append(getApplicationApplicationUrl());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.bibbox.liferay.portlet.model.ApplicationStoreItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>applicationStoreItemId</column-name><column-value><![CDATA[");
		sb.append(getApplicationStoreItemId());
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
			"<column><column-name>githash</column-name><column-value><![CDATA[");
		sb.append(getGithash());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>depreciated</column-name><column-value><![CDATA[");
		sb.append(getDepreciated());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationFolderName</column-name><column-value><![CDATA[");
		sb.append(getApplicationFolderName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationName</column-name><column-value><![CDATA[");
		sb.append(getApplicationName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationShortName</column-name><column-value><![CDATA[");
		sb.append(getApplicationShortName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationVersion</column-name><column-value><![CDATA[");
		sb.append(getApplicationVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationReleaseState</column-name><column-value><![CDATA[");
		sb.append(getApplicationReleaseState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationDescription</column-name><column-value><![CDATA[");
		sb.append(getApplicationDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationCatalogueUrl</column-name><column-value><![CDATA[");
		sb.append(getApplicationCatalogueUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationApplicationUrl</column-name><column-value><![CDATA[");
		sb.append(getApplicationApplicationUrl());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _applicationStoreItemId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _githash;
	private Boolean _depreciated;
	private String _applicationFolderName;
	private String _applicationName;
	private String _applicationShortName;
	private String _applicationVersion;
	private String _applicationReleaseState;
	private String _applicationDescription;
	private String _applicationCatalogueUrl;
	private String _applicationApplicationUrl;
	private BaseModel<?> _applicationStoreItemRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}