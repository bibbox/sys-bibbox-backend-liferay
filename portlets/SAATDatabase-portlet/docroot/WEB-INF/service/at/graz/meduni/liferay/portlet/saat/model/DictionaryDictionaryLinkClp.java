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

package at.graz.meduni.liferay.portlet.saat.model;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.liferay.portlet.saat.service.ClpSerializer;
import at.graz.meduni.liferay.portlet.saat.service.DictionaryDictionaryLinkLocalServiceUtil;

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
public class DictionaryDictionaryLinkClp extends BaseModelImpl<DictionaryDictionaryLink>
	implements DictionaryDictionaryLink {
	public DictionaryDictionaryLinkClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DictionaryDictionaryLink.class;
	}

	@Override
	public String getModelClassName() {
		return DictionaryDictionaryLink.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _dictionaryDictionaryLinkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDictionaryDictionaryLinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dictionaryDictionaryLinkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dictionaryDictionaryLinkId",
			getDictionaryDictionaryLinkId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dictionaryId", getDictionaryId());
		attributes.put("dictionaryAddictionId", getDictionaryAddictionId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dictionaryDictionaryLinkId = (Long)attributes.get(
				"dictionaryDictionaryLinkId");

		if (dictionaryDictionaryLinkId != null) {
			setDictionaryDictionaryLinkId(dictionaryDictionaryLinkId);
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

		Long dictionaryId = (Long)attributes.get("dictionaryId");

		if (dictionaryId != null) {
			setDictionaryId(dictionaryId);
		}

		Long dictionaryAddictionId = (Long)attributes.get(
				"dictionaryAddictionId");

		if (dictionaryAddictionId != null) {
			setDictionaryAddictionId(dictionaryAddictionId);
		}

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getDictionaryDictionaryLinkId() {
		return _dictionaryDictionaryLinkId;
	}

	@Override
	public void setDictionaryDictionaryLinkId(long dictionaryDictionaryLinkId) {
		_dictionaryDictionaryLinkId = dictionaryDictionaryLinkId;

		if (_dictionaryDictionaryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryDictionaryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setDictionaryDictionaryLinkId",
						long.class);

				method.invoke(_dictionaryDictionaryLinkRemoteModel,
					dictionaryDictionaryLinkId);
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

		if (_dictionaryDictionaryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryDictionaryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_dictionaryDictionaryLinkRemoteModel, companyId);
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

		if (_dictionaryDictionaryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryDictionaryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_dictionaryDictionaryLinkRemoteModel, userId);
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

		if (_dictionaryDictionaryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryDictionaryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_dictionaryDictionaryLinkRemoteModel, userName);
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

		if (_dictionaryDictionaryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryDictionaryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_dictionaryDictionaryLinkRemoteModel, createDate);
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

		if (_dictionaryDictionaryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryDictionaryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_dictionaryDictionaryLinkRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDictionaryId() {
		return _dictionaryId;
	}

	@Override
	public void setDictionaryId(long dictionaryId) {
		_dictionaryId = dictionaryId;

		if (_dictionaryDictionaryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryDictionaryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setDictionaryId", long.class);

				method.invoke(_dictionaryDictionaryLinkRemoteModel, dictionaryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDictionaryAddictionId() {
		return _dictionaryAddictionId;
	}

	@Override
	public void setDictionaryAddictionId(long dictionaryAddictionId) {
		_dictionaryAddictionId = dictionaryAddictionId;

		if (_dictionaryDictionaryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryDictionaryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setDictionaryAddictionId",
						long.class);

				method.invoke(_dictionaryDictionaryLinkRemoteModel,
					dictionaryAddictionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDictionaryDictionaryLinkRemoteModel() {
		return _dictionaryDictionaryLinkRemoteModel;
	}

	public void setDictionaryDictionaryLinkRemoteModel(
		BaseModel<?> dictionaryDictionaryLinkRemoteModel) {
		_dictionaryDictionaryLinkRemoteModel = dictionaryDictionaryLinkRemoteModel;
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

		Class<?> remoteModelClass = _dictionaryDictionaryLinkRemoteModel.getClass();

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

		Object returnValue = method.invoke(_dictionaryDictionaryLinkRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			DictionaryDictionaryLinkLocalServiceUtil.addDictionaryDictionaryLink(this);
		}
		else {
			DictionaryDictionaryLinkLocalServiceUtil.updateDictionaryDictionaryLink(this);
		}
	}

	@Override
	public DictionaryDictionaryLink toEscapedModel() {
		return (DictionaryDictionaryLink)ProxyUtil.newProxyInstance(DictionaryDictionaryLink.class.getClassLoader(),
			new Class[] { DictionaryDictionaryLink.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DictionaryDictionaryLinkClp clone = new DictionaryDictionaryLinkClp();

		clone.setDictionaryDictionaryLinkId(getDictionaryDictionaryLinkId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDictionaryId(getDictionaryId());
		clone.setDictionaryAddictionId(getDictionaryAddictionId());

		return clone;
	}

	@Override
	public int compareTo(DictionaryDictionaryLink dictionaryDictionaryLink) {
		int value = 0;

		if (getDictionaryDictionaryLinkId() < dictionaryDictionaryLink.getDictionaryDictionaryLinkId()) {
			value = -1;
		}
		else if (getDictionaryDictionaryLinkId() > dictionaryDictionaryLink.getDictionaryDictionaryLinkId()) {
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

		if (!(obj instanceof DictionaryDictionaryLinkClp)) {
			return false;
		}

		DictionaryDictionaryLinkClp dictionaryDictionaryLink = (DictionaryDictionaryLinkClp)obj;

		long primaryKey = dictionaryDictionaryLink.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{dictionaryDictionaryLinkId=");
		sb.append(getDictionaryDictionaryLinkId());
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
		sb.append(", dictionaryId=");
		sb.append(getDictionaryId());
		sb.append(", dictionaryAddictionId=");
		sb.append(getDictionaryAddictionId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dictionaryDictionaryLinkId</column-name><column-value><![CDATA[");
		sb.append(getDictionaryDictionaryLinkId());
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
			"<column><column-name>dictionaryId</column-name><column-value><![CDATA[");
		sb.append(getDictionaryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dictionaryAddictionId</column-name><column-value><![CDATA[");
		sb.append(getDictionaryAddictionId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _dictionaryDictionaryLinkId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _dictionaryId;
	private long _dictionaryAddictionId;
	private BaseModel<?> _dictionaryDictionaryLinkRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}