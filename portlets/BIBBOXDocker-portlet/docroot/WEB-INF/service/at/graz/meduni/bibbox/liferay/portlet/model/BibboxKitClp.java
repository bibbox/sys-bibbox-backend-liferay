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

import at.graz.meduni.bibbox.liferay.portlet.service.BibboxKitLocalServiceUtil;
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
public class BibboxKitClp extends BaseModelImpl<BibboxKit> implements BibboxKit {
	public BibboxKitClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BibboxKit.class;
	}

	@Override
	public String getModelClassName() {
		return BibboxKit.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _bibboxKitId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBibboxKitId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bibboxKitId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bibboxKitId", getBibboxKitId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("kitName", getKitName());
		attributes.put("applicationStoreItemId", getApplicationStoreItemId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bibboxKitId = (Long)attributes.get("bibboxKitId");

		if (bibboxKitId != null) {
			setBibboxKitId(bibboxKitId);
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

		String kitName = (String)attributes.get("kitName");

		if (kitName != null) {
			setKitName(kitName);
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
	public long getBibboxKitId() {
		return _bibboxKitId;
	}

	@Override
	public void setBibboxKitId(long bibboxKitId) {
		_bibboxKitId = bibboxKitId;

		if (_bibboxKitRemoteModel != null) {
			try {
				Class<?> clazz = _bibboxKitRemoteModel.getClass();

				Method method = clazz.getMethod("setBibboxKitId", long.class);

				method.invoke(_bibboxKitRemoteModel, bibboxKitId);
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

		if (_bibboxKitRemoteModel != null) {
			try {
				Class<?> clazz = _bibboxKitRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_bibboxKitRemoteModel, groupId);
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

		if (_bibboxKitRemoteModel != null) {
			try {
				Class<?> clazz = _bibboxKitRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_bibboxKitRemoteModel, companyId);
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

		if (_bibboxKitRemoteModel != null) {
			try {
				Class<?> clazz = _bibboxKitRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_bibboxKitRemoteModel, userId);
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

		if (_bibboxKitRemoteModel != null) {
			try {
				Class<?> clazz = _bibboxKitRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_bibboxKitRemoteModel, userName);
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

		if (_bibboxKitRemoteModel != null) {
			try {
				Class<?> clazz = _bibboxKitRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_bibboxKitRemoteModel, createDate);
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

		if (_bibboxKitRemoteModel != null) {
			try {
				Class<?> clazz = _bibboxKitRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_bibboxKitRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getKitName() {
		return _kitName;
	}

	@Override
	public void setKitName(String kitName) {
		_kitName = kitName;

		if (_bibboxKitRemoteModel != null) {
			try {
				Class<?> clazz = _bibboxKitRemoteModel.getClass();

				Method method = clazz.getMethod("setKitName", String.class);

				method.invoke(_bibboxKitRemoteModel, kitName);
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

		if (_bibboxKitRemoteModel != null) {
			try {
				Class<?> clazz = _bibboxKitRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationStoreItemId",
						long.class);

				method.invoke(_bibboxKitRemoteModel, applicationStoreItemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBibboxKitRemoteModel() {
		return _bibboxKitRemoteModel;
	}

	public void setBibboxKitRemoteModel(BaseModel<?> bibboxKitRemoteModel) {
		_bibboxKitRemoteModel = bibboxKitRemoteModel;
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

		Class<?> remoteModelClass = _bibboxKitRemoteModel.getClass();

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

		Object returnValue = method.invoke(_bibboxKitRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			BibboxKitLocalServiceUtil.addBibboxKit(this);
		}
		else {
			BibboxKitLocalServiceUtil.updateBibboxKit(this);
		}
	}

	@Override
	public BibboxKit toEscapedModel() {
		return (BibboxKit)ProxyUtil.newProxyInstance(BibboxKit.class.getClassLoader(),
			new Class[] { BibboxKit.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BibboxKitClp clone = new BibboxKitClp();

		clone.setBibboxKitId(getBibboxKitId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setKitName(getKitName());
		clone.setApplicationStoreItemId(getApplicationStoreItemId());

		return clone;
	}

	@Override
	public int compareTo(BibboxKit bibboxKit) {
		int value = 0;

		value = getKitName().compareTo(bibboxKit.getKitName());

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

		if (!(obj instanceof BibboxKitClp)) {
			return false;
		}

		BibboxKitClp bibboxKit = (BibboxKitClp)obj;

		long primaryKey = bibboxKit.getPrimaryKey();

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

		sb.append("{bibboxKitId=");
		sb.append(getBibboxKitId());
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
		sb.append(", kitName=");
		sb.append(getKitName());
		sb.append(", applicationStoreItemId=");
		sb.append(getApplicationStoreItemId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bibboxKitId</column-name><column-value><![CDATA[");
		sb.append(getBibboxKitId());
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
			"<column><column-name>kitName</column-name><column-value><![CDATA[");
		sb.append(getKitName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationStoreItemId</column-name><column-value><![CDATA[");
		sb.append(getApplicationStoreItemId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _bibboxKitId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _kitName;
	private long _applicationStoreItemId;
	private BaseModel<?> _bibboxKitRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}