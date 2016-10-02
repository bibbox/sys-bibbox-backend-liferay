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

import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationTagLocalServiceUtil;
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
public class ApplicationTagClp extends BaseModelImpl<ApplicationTag>
	implements ApplicationTag {
	public ApplicationTagClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ApplicationTag.class;
	}

	@Override
	public String getModelClassName() {
		return ApplicationTag.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _applicationTagsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setApplicationTagsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _applicationTagsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("applicationTagsId", getApplicationTagsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("tag", getTag());
		attributes.put("applicationStoreItemId", getApplicationStoreItemId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long applicationTagsId = (Long)attributes.get("applicationTagsId");

		if (applicationTagsId != null) {
			setApplicationTagsId(applicationTagsId);
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

		String tag = (String)attributes.get("tag");

		if (tag != null) {
			setTag(tag);
		}

		Long applicationStoreItemId = (Long)attributes.get(
				"applicationStoreItemId");

		if (applicationStoreItemId != null) {
			setApplicationStoreItemId(applicationStoreItemId);
		}

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getApplicationTagsId() {
		return _applicationTagsId;
	}

	@Override
	public void setApplicationTagsId(long applicationTagsId) {
		_applicationTagsId = applicationTagsId;

		if (_applicationTagRemoteModel != null) {
			try {
				Class<?> clazz = _applicationTagRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationTagsId",
						long.class);

				method.invoke(_applicationTagRemoteModel, applicationTagsId);
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

		if (_applicationTagRemoteModel != null) {
			try {
				Class<?> clazz = _applicationTagRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_applicationTagRemoteModel, groupId);
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

		if (_applicationTagRemoteModel != null) {
			try {
				Class<?> clazz = _applicationTagRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_applicationTagRemoteModel, companyId);
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

		if (_applicationTagRemoteModel != null) {
			try {
				Class<?> clazz = _applicationTagRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_applicationTagRemoteModel, userId);
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

		if (_applicationTagRemoteModel != null) {
			try {
				Class<?> clazz = _applicationTagRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_applicationTagRemoteModel, userName);
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

		if (_applicationTagRemoteModel != null) {
			try {
				Class<?> clazz = _applicationTagRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_applicationTagRemoteModel, createDate);
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

		if (_applicationTagRemoteModel != null) {
			try {
				Class<?> clazz = _applicationTagRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_applicationTagRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTag() {
		return _tag;
	}

	@Override
	public void setTag(String tag) {
		_tag = tag;

		if (_applicationTagRemoteModel != null) {
			try {
				Class<?> clazz = _applicationTagRemoteModel.getClass();

				Method method = clazz.getMethod("setTag", String.class);

				method.invoke(_applicationTagRemoteModel, tag);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getApplicationStoreItemId() {
		return _applicationStoreItemId;
	}

	@Override
	public void setApplicationStoreItemId(long applicationStoreItemId) {
		_applicationStoreItemId = applicationStoreItemId;

		if (_applicationTagRemoteModel != null) {
			try {
				Class<?> clazz = _applicationTagRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationStoreItemId",
						long.class);

				method.invoke(_applicationTagRemoteModel, applicationStoreItemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getApplicationTagRemoteModel() {
		return _applicationTagRemoteModel;
	}

	public void setApplicationTagRemoteModel(
		BaseModel<?> applicationTagRemoteModel) {
		_applicationTagRemoteModel = applicationTagRemoteModel;
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

		Class<?> remoteModelClass = _applicationTagRemoteModel.getClass();

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

		Object returnValue = method.invoke(_applicationTagRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			ApplicationTagLocalServiceUtil.addApplicationTag(this);
		}
		else {
			ApplicationTagLocalServiceUtil.updateApplicationTag(this);
		}
	}

	@Override
	public ApplicationTag toEscapedModel() {
		return (ApplicationTag)ProxyUtil.newProxyInstance(ApplicationTag.class.getClassLoader(),
			new Class[] { ApplicationTag.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ApplicationTagClp clone = new ApplicationTagClp();

		clone.setApplicationTagsId(getApplicationTagsId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTag(getTag());
		clone.setApplicationStoreItemId(getApplicationStoreItemId());

		return clone;
	}

	@Override
	public int compareTo(ApplicationTag applicationTag) {
		int value = 0;

		value = getTag().compareTo(applicationTag.getTag());

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

		if (!(obj instanceof ApplicationTagClp)) {
			return false;
		}

		ApplicationTagClp applicationTag = (ApplicationTagClp)obj;

		long primaryKey = applicationTag.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{applicationTagsId=");
		sb.append(getApplicationTagsId());
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
		sb.append(", tag=");
		sb.append(getTag());
		sb.append(", applicationStoreItemId=");
		sb.append(getApplicationStoreItemId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>applicationTagsId</column-name><column-value><![CDATA[");
		sb.append(getApplicationTagsId());
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
			"<column><column-name>tag</column-name><column-value><![CDATA[");
		sb.append(getTag());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationStoreItemId</column-name><column-value><![CDATA[");
		sb.append(getApplicationStoreItemId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _applicationTagsId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _tag;
	private long _applicationStoreItemId;
	private BaseModel<?> _applicationTagRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}