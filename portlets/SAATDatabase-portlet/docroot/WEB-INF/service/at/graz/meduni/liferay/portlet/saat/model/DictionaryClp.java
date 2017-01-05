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
import at.graz.meduni.liferay.portlet.saat.service.DictionaryLocalServiceUtil;

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
public class DictionaryClp extends BaseModelImpl<Dictionary>
	implements Dictionary {
	public DictionaryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Dictionary.class;
	}

	@Override
	public String getModelClassName() {
		return Dictionary.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _dictionaryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDictionaryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dictionaryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dictionaryId", getDictionaryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("isroot", getIsroot());
		attributes.put("iscode", getIscode());
		attributes.put("synonym", getSynonym());
		attributes.put("pattern", getPattern());
		attributes.put("beforSynonym", getBeforSynonym());
		attributes.put("afterSynonym", getAfterSynonym());
		attributes.put("foreword", getForeword());
		attributes.put("ending", getEnding());
		attributes.put("sentence", getSentence());
		attributes.put("occure", getOccure());
		attributes.put("nagation", getNagation());
		attributes.put("priority_mode", getPriority_mode());
		attributes.put("codeType", getCodeType());
		attributes.put("codeValue", getCodeValue());
		attributes.put("priority", getPriority());
		attributes.put("disease_ids", getDisease_ids());
		attributes.put("dirty", getDirty());
		attributes.put("disease_ids_count", getDisease_ids_count());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dictionaryId = (Long)attributes.get("dictionaryId");

		if (dictionaryId != null) {
			setDictionaryId(dictionaryId);
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

		Boolean isroot = (Boolean)attributes.get("isroot");

		if (isroot != null) {
			setIsroot(isroot);
		}

		Boolean iscode = (Boolean)attributes.get("iscode");

		if (iscode != null) {
			setIscode(iscode);
		}

		String synonym = (String)attributes.get("synonym");

		if (synonym != null) {
			setSynonym(synonym);
		}

		String pattern = (String)attributes.get("pattern");

		if (pattern != null) {
			setPattern(pattern);
		}

		Long beforSynonym = (Long)attributes.get("beforSynonym");

		if (beforSynonym != null) {
			setBeforSynonym(beforSynonym);
		}

		Long afterSynonym = (Long)attributes.get("afterSynonym");

		if (afterSynonym != null) {
			setAfterSynonym(afterSynonym);
		}

		Boolean foreword = (Boolean)attributes.get("foreword");

		if (foreword != null) {
			setForeword(foreword);
		}

		Boolean ending = (Boolean)attributes.get("ending");

		if (ending != null) {
			setEnding(ending);
		}

		Boolean sentence = (Boolean)attributes.get("sentence");

		if (sentence != null) {
			setSentence(sentence);
		}

		Boolean occure = (Boolean)attributes.get("occure");

		if (occure != null) {
			setOccure(occure);
		}

		Boolean nagation = (Boolean)attributes.get("nagation");

		if (nagation != null) {
			setNagation(nagation);
		}

		Boolean priority_mode = (Boolean)attributes.get("priority_mode");

		if (priority_mode != null) {
			setPriority_mode(priority_mode);
		}

		String codeType = (String)attributes.get("codeType");

		if (codeType != null) {
			setCodeType(codeType);
		}

		String codeValue = (String)attributes.get("codeValue");

		if (codeValue != null) {
			setCodeValue(codeValue);
		}

		Long priority = (Long)attributes.get("priority");

		if (priority != null) {
			setPriority(priority);
		}

		String disease_ids = (String)attributes.get("disease_ids");

		if (disease_ids != null) {
			setDisease_ids(disease_ids);
		}

		Boolean dirty = (Boolean)attributes.get("dirty");

		if (dirty != null) {
			setDirty(dirty);
		}

		Long disease_ids_count = (Long)attributes.get("disease_ids_count");

		if (disease_ids_count != null) {
			setDisease_ids_count(disease_ids_count);
		}

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getDictionaryId() {
		return _dictionaryId;
	}

	@Override
	public void setDictionaryId(long dictionaryId) {
		_dictionaryId = dictionaryId;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setDictionaryId", long.class);

				method.invoke(_dictionaryRemoteModel, dictionaryId);
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

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_dictionaryRemoteModel, companyId);
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

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_dictionaryRemoteModel, userId);
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

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_dictionaryRemoteModel, userName);
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

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_dictionaryRemoteModel, createDate);
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

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_dictionaryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsroot() {
		return _isroot;
	}

	@Override
	public boolean isIsroot() {
		return _isroot;
	}

	@Override
	public void setIsroot(boolean isroot) {
		_isroot = isroot;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setIsroot", boolean.class);

				method.invoke(_dictionaryRemoteModel, isroot);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIscode() {
		return _iscode;
	}

	@Override
	public boolean isIscode() {
		return _iscode;
	}

	@Override
	public void setIscode(boolean iscode) {
		_iscode = iscode;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setIscode", boolean.class);

				method.invoke(_dictionaryRemoteModel, iscode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSynonym() {
		return _synonym;
	}

	@Override
	public void setSynonym(String synonym) {
		_synonym = synonym;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setSynonym", String.class);

				method.invoke(_dictionaryRemoteModel, synonym);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPattern() {
		return _pattern;
	}

	@Override
	public void setPattern(String pattern) {
		_pattern = pattern;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setPattern", String.class);

				method.invoke(_dictionaryRemoteModel, pattern);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBeforSynonym() {
		return _beforSynonym;
	}

	@Override
	public void setBeforSynonym(long beforSynonym) {
		_beforSynonym = beforSynonym;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setBeforSynonym", long.class);

				method.invoke(_dictionaryRemoteModel, beforSynonym);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAfterSynonym() {
		return _afterSynonym;
	}

	@Override
	public void setAfterSynonym(long afterSynonym) {
		_afterSynonym = afterSynonym;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setAfterSynonym", long.class);

				method.invoke(_dictionaryRemoteModel, afterSynonym);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getForeword() {
		return _foreword;
	}

	@Override
	public boolean isForeword() {
		return _foreword;
	}

	@Override
	public void setForeword(boolean foreword) {
		_foreword = foreword;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setForeword", boolean.class);

				method.invoke(_dictionaryRemoteModel, foreword);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getEnding() {
		return _ending;
	}

	@Override
	public boolean isEnding() {
		return _ending;
	}

	@Override
	public void setEnding(boolean ending) {
		_ending = ending;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setEnding", boolean.class);

				method.invoke(_dictionaryRemoteModel, ending);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getSentence() {
		return _sentence;
	}

	@Override
	public boolean isSentence() {
		return _sentence;
	}

	@Override
	public void setSentence(boolean sentence) {
		_sentence = sentence;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setSentence", boolean.class);

				method.invoke(_dictionaryRemoteModel, sentence);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getOccure() {
		return _occure;
	}

	@Override
	public boolean isOccure() {
		return _occure;
	}

	@Override
	public void setOccure(boolean occure) {
		_occure = occure;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setOccure", boolean.class);

				method.invoke(_dictionaryRemoteModel, occure);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getNagation() {
		return _nagation;
	}

	@Override
	public boolean isNagation() {
		return _nagation;
	}

	@Override
	public void setNagation(boolean nagation) {
		_nagation = nagation;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setNagation", boolean.class);

				method.invoke(_dictionaryRemoteModel, nagation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPriority_mode() {
		return _priority_mode;
	}

	@Override
	public boolean isPriority_mode() {
		return _priority_mode;
	}

	@Override
	public void setPriority_mode(boolean priority_mode) {
		_priority_mode = priority_mode;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setPriority_mode",
						boolean.class);

				method.invoke(_dictionaryRemoteModel, priority_mode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodeType() {
		return _codeType;
	}

	@Override
	public void setCodeType(String codeType) {
		_codeType = codeType;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setCodeType", String.class);

				method.invoke(_dictionaryRemoteModel, codeType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodeValue() {
		return _codeValue;
	}

	@Override
	public void setCodeValue(String codeValue) {
		_codeValue = codeValue;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setCodeValue", String.class);

				method.invoke(_dictionaryRemoteModel, codeValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPriority() {
		return _priority;
	}

	@Override
	public void setPriority(long priority) {
		_priority = priority;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setPriority", long.class);

				method.invoke(_dictionaryRemoteModel, priority);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDisease_ids() {
		return _disease_ids;
	}

	@Override
	public void setDisease_ids(String disease_ids) {
		_disease_ids = disease_ids;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setDisease_ids", String.class);

				method.invoke(_dictionaryRemoteModel, disease_ids);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDirty() {
		return _dirty;
	}

	@Override
	public boolean isDirty() {
		return _dirty;
	}

	@Override
	public void setDirty(boolean dirty) {
		_dirty = dirty;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setDirty", boolean.class);

				method.invoke(_dictionaryRemoteModel, dirty);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDisease_ids_count() {
		return _disease_ids_count;
	}

	@Override
	public void setDisease_ids_count(long disease_ids_count) {
		_disease_ids_count = disease_ids_count;

		if (_dictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _dictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setDisease_ids_count",
						long.class);

				method.invoke(_dictionaryRemoteModel, disease_ids_count);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDictionaryRemoteModel() {
		return _dictionaryRemoteModel;
	}

	public void setDictionaryRemoteModel(BaseModel<?> dictionaryRemoteModel) {
		_dictionaryRemoteModel = dictionaryRemoteModel;
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

		Class<?> remoteModelClass = _dictionaryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_dictionaryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			DictionaryLocalServiceUtil.addDictionary(this);
		}
		else {
			DictionaryLocalServiceUtil.updateDictionary(this);
		}
	}

	@Override
	public Dictionary toEscapedModel() {
		return (Dictionary)ProxyUtil.newProxyInstance(Dictionary.class.getClassLoader(),
			new Class[] { Dictionary.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DictionaryClp clone = new DictionaryClp();

		clone.setDictionaryId(getDictionaryId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setIsroot(getIsroot());
		clone.setIscode(getIscode());
		clone.setSynonym(getSynonym());
		clone.setPattern(getPattern());
		clone.setBeforSynonym(getBeforSynonym());
		clone.setAfterSynonym(getAfterSynonym());
		clone.setForeword(getForeword());
		clone.setEnding(getEnding());
		clone.setSentence(getSentence());
		clone.setOccure(getOccure());
		clone.setNagation(getNagation());
		clone.setPriority_mode(getPriority_mode());
		clone.setCodeType(getCodeType());
		clone.setCodeValue(getCodeValue());
		clone.setPriority(getPriority());
		clone.setDisease_ids(getDisease_ids());
		clone.setDirty(getDirty());
		clone.setDisease_ids_count(getDisease_ids_count());

		return clone;
	}

	@Override
	public int compareTo(Dictionary dictionary) {
		int value = 0;

		if (getDictionaryId() < dictionary.getDictionaryId()) {
			value = -1;
		}
		else if (getDictionaryId() > dictionary.getDictionaryId()) {
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

		if (!(obj instanceof DictionaryClp)) {
			return false;
		}

		DictionaryClp dictionary = (DictionaryClp)obj;

		long primaryKey = dictionary.getPrimaryKey();

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
		StringBundler sb = new StringBundler(49);

		sb.append("{dictionaryId=");
		sb.append(getDictionaryId());
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
		sb.append(", isroot=");
		sb.append(getIsroot());
		sb.append(", iscode=");
		sb.append(getIscode());
		sb.append(", synonym=");
		sb.append(getSynonym());
		sb.append(", pattern=");
		sb.append(getPattern());
		sb.append(", beforSynonym=");
		sb.append(getBeforSynonym());
		sb.append(", afterSynonym=");
		sb.append(getAfterSynonym());
		sb.append(", foreword=");
		sb.append(getForeword());
		sb.append(", ending=");
		sb.append(getEnding());
		sb.append(", sentence=");
		sb.append(getSentence());
		sb.append(", occure=");
		sb.append(getOccure());
		sb.append(", nagation=");
		sb.append(getNagation());
		sb.append(", priority_mode=");
		sb.append(getPriority_mode());
		sb.append(", codeType=");
		sb.append(getCodeType());
		sb.append(", codeValue=");
		sb.append(getCodeValue());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append(", disease_ids=");
		sb.append(getDisease_ids());
		sb.append(", dirty=");
		sb.append(getDirty());
		sb.append(", disease_ids_count=");
		sb.append(getDisease_ids_count());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(76);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.liferay.portlet.saat.model.Dictionary");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dictionaryId</column-name><column-value><![CDATA[");
		sb.append(getDictionaryId());
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
			"<column><column-name>isroot</column-name><column-value><![CDATA[");
		sb.append(getIsroot());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>iscode</column-name><column-value><![CDATA[");
		sb.append(getIscode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>synonym</column-name><column-value><![CDATA[");
		sb.append(getSynonym());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pattern</column-name><column-value><![CDATA[");
		sb.append(getPattern());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>beforSynonym</column-name><column-value><![CDATA[");
		sb.append(getBeforSynonym());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>afterSynonym</column-name><column-value><![CDATA[");
		sb.append(getAfterSynonym());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>foreword</column-name><column-value><![CDATA[");
		sb.append(getForeword());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ending</column-name><column-value><![CDATA[");
		sb.append(getEnding());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sentence</column-name><column-value><![CDATA[");
		sb.append(getSentence());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>occure</column-name><column-value><![CDATA[");
		sb.append(getOccure());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nagation</column-name><column-value><![CDATA[");
		sb.append(getNagation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority_mode</column-name><column-value><![CDATA[");
		sb.append(getPriority_mode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codeType</column-name><column-value><![CDATA[");
		sb.append(getCodeType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codeValue</column-name><column-value><![CDATA[");
		sb.append(getCodeValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disease_ids</column-name><column-value><![CDATA[");
		sb.append(getDisease_ids());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dirty</column-name><column-value><![CDATA[");
		sb.append(getDirty());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disease_ids_count</column-name><column-value><![CDATA[");
		sb.append(getDisease_ids_count());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _dictionaryId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _isroot;
	private boolean _iscode;
	private String _synonym;
	private String _pattern;
	private long _beforSynonym;
	private long _afterSynonym;
	private boolean _foreword;
	private boolean _ending;
	private boolean _sentence;
	private boolean _occure;
	private boolean _nagation;
	private boolean _priority_mode;
	private String _codeType;
	private String _codeValue;
	private long _priority;
	private String _disease_ids;
	private boolean _dirty;
	private long _disease_ids_count;
	private BaseModel<?> _dictionaryRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}