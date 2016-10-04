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

import at.graz.meduni.bibbox.liferay.portlet.service.ClpSerializer;
import at.graz.meduni.bibbox.liferay.portlet.service.KitGroupLocalServiceUtil;

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
public class KitGroupClp extends BaseModelImpl<KitGroup> implements KitGroup {
	public KitGroupClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return KitGroup.class;
	}

	@Override
	public String getModelClassName() {
		return KitGroup.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _kitGroupId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setKitGroupId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _kitGroupId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("kitGroupId", getKitGroupId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("group", getGroup());
		attributes.put("applicationStoreItemId", getApplicationStoreItemId());
		attributes.put("bibboxKitId", getBibboxKitId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long kitGroupId = (Long)attributes.get("kitGroupId");

		if (kitGroupId != null) {
			setKitGroupId(kitGroupId);
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

		String group = (String)attributes.get("group");

		if (group != null) {
			setGroup(group);
		}

		Long applicationStoreItemId = (Long)attributes.get(
				"applicationStoreItemId");

		if (applicationStoreItemId != null) {
			setApplicationStoreItemId(applicationStoreItemId);
		}

		Long bibboxKitId = (Long)attributes.get("bibboxKitId");

		if (bibboxKitId != null) {
			setBibboxKitId(bibboxKitId);
		}

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getKitGroupId() {
		return _kitGroupId;
	}

	@Override
	public void setKitGroupId(long kitGroupId) {
		_kitGroupId = kitGroupId;

		if (_kitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _kitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setKitGroupId", long.class);

				method.invoke(_kitGroupRemoteModel, kitGroupId);
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

		if (_kitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _kitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_kitGroupRemoteModel, groupId);
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

		if (_kitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _kitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_kitGroupRemoteModel, companyId);
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

		if (_kitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _kitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_kitGroupRemoteModel, userId);
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

		if (_kitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _kitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_kitGroupRemoteModel, userName);
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

		if (_kitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _kitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_kitGroupRemoteModel, createDate);
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

		if (_kitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _kitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_kitGroupRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGroup() {
		return _group;
	}

	@Override
	public void setGroup(String group) {
		_group = group;

		if (_kitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _kitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setGroup", String.class);

				method.invoke(_kitGroupRemoteModel, group);
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

		if (_kitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _kitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationStoreItemId",
						long.class);

				method.invoke(_kitGroupRemoteModel, applicationStoreItemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBibboxKitId() {
		return _bibboxKitId;
	}

	@Override
	public void setBibboxKitId(long bibboxKitId) {
		_bibboxKitId = bibboxKitId;

		if (_kitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _kitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setBibboxKitId", long.class);

				method.invoke(_kitGroupRemoteModel, bibboxKitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getBibboxKitName() {
		try {
			String methodName = "getBibboxKitName";

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

	public BaseModel<?> getKitGroupRemoteModel() {
		return _kitGroupRemoteModel;
	}

	public void setKitGroupRemoteModel(BaseModel<?> kitGroupRemoteModel) {
		_kitGroupRemoteModel = kitGroupRemoteModel;
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

		Class<?> remoteModelClass = _kitGroupRemoteModel.getClass();

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

		Object returnValue = method.invoke(_kitGroupRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			KitGroupLocalServiceUtil.addKitGroup(this);
		}
		else {
			KitGroupLocalServiceUtil.updateKitGroup(this);
		}
	}

	@Override
	public KitGroup toEscapedModel() {
		return (KitGroup)ProxyUtil.newProxyInstance(KitGroup.class.getClassLoader(),
			new Class[] { KitGroup.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		KitGroupClp clone = new KitGroupClp();

		clone.setKitGroupId(getKitGroupId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setGroup(getGroup());
		clone.setApplicationStoreItemId(getApplicationStoreItemId());
		clone.setBibboxKitId(getBibboxKitId());

		return clone;
	}

	@Override
	public int compareTo(KitGroup kitGroup) {
		int value = 0;

		value = getGroup().compareTo(kitGroup.getGroup());

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

		if (!(obj instanceof KitGroupClp)) {
			return false;
		}

		KitGroupClp kitGroup = (KitGroupClp)obj;

		long primaryKey = kitGroup.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{kitGroupId=");
		sb.append(getKitGroupId());
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
		sb.append(", group=");
		sb.append(getGroup());
		sb.append(", applicationStoreItemId=");
		sb.append(getApplicationStoreItemId());
		sb.append(", bibboxKitId=");
		sb.append(getBibboxKitId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.bibbox.liferay.portlet.model.KitGroup");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>kitGroupId</column-name><column-value><![CDATA[");
		sb.append(getKitGroupId());
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
			"<column><column-name>group</column-name><column-value><![CDATA[");
		sb.append(getGroup());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationStoreItemId</column-name><column-value><![CDATA[");
		sb.append(getApplicationStoreItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bibboxKitId</column-name><column-value><![CDATA[");
		sb.append(getBibboxKitId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _kitGroupId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _group;
	private long _applicationStoreItemId;
	private long _bibboxKitId;
	private BaseModel<?> _kitGroupRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}