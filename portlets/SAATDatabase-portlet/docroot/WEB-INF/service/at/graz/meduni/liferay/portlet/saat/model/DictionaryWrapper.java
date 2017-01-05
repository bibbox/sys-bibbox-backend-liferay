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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Dictionary}.
 * </p>
 *
 * @author reihsr
 * @see Dictionary
 * @generated
 */
@ProviderType
public class DictionaryWrapper implements Dictionary, ModelWrapper<Dictionary> {
	public DictionaryWrapper(Dictionary dictionary) {
		_dictionary = dictionary;
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
	}

	@Override
	public at.graz.meduni.liferay.portlet.saat.model.Dictionary toEscapedModel() {
		return new DictionaryWrapper(_dictionary.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.saat.model.Dictionary toUnescapedModel() {
		return new DictionaryWrapper(_dictionary.toUnescapedModel());
	}

	/**
	* Returns the dirty of this dictionary.
	*
	* @return the dirty of this dictionary
	*/
	@Override
	public boolean getDirty() {
		return _dictionary.getDirty();
	}

	/**
	* Returns the ending of this dictionary.
	*
	* @return the ending of this dictionary
	*/
	@Override
	public boolean getEnding() {
		return _dictionary.getEnding();
	}

	/**
	* Returns the foreword of this dictionary.
	*
	* @return the foreword of this dictionary
	*/
	@Override
	public boolean getForeword() {
		return _dictionary.getForeword();
	}

	/**
	* Returns the iscode of this dictionary.
	*
	* @return the iscode of this dictionary
	*/
	@Override
	public boolean getIscode() {
		return _dictionary.getIscode();
	}

	/**
	* Returns the isroot of this dictionary.
	*
	* @return the isroot of this dictionary
	*/
	@Override
	public boolean getIsroot() {
		return _dictionary.getIsroot();
	}

	/**
	* Returns the nagation of this dictionary.
	*
	* @return the nagation of this dictionary
	*/
	@Override
	public boolean getNagation() {
		return _dictionary.getNagation();
	}

	/**
	* Returns the occure of this dictionary.
	*
	* @return the occure of this dictionary
	*/
	@Override
	public boolean getOccure() {
		return _dictionary.getOccure();
	}

	/**
	* Returns the priority_mode of this dictionary.
	*
	* @return the priority_mode of this dictionary
	*/
	@Override
	public boolean getPriority_mode() {
		return _dictionary.getPriority_mode();
	}

	/**
	* Returns the sentence of this dictionary.
	*
	* @return the sentence of this dictionary
	*/
	@Override
	public boolean getSentence() {
		return _dictionary.getSentence();
	}

	@Override
	public boolean isCachedModel() {
		return _dictionary.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this dictionary is dirty.
	*
	* @return <code>true</code> if this dictionary is dirty; <code>false</code> otherwise
	*/
	@Override
	public boolean isDirty() {
		return _dictionary.isDirty();
	}

	/**
	* Returns <code>true</code> if this dictionary is ending.
	*
	* @return <code>true</code> if this dictionary is ending; <code>false</code> otherwise
	*/
	@Override
	public boolean isEnding() {
		return _dictionary.isEnding();
	}

	@Override
	public boolean isEscapedModel() {
		return _dictionary.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this dictionary is foreword.
	*
	* @return <code>true</code> if this dictionary is foreword; <code>false</code> otherwise
	*/
	@Override
	public boolean isForeword() {
		return _dictionary.isForeword();
	}

	/**
	* Returns <code>true</code> if this dictionary is iscode.
	*
	* @return <code>true</code> if this dictionary is iscode; <code>false</code> otherwise
	*/
	@Override
	public boolean isIscode() {
		return _dictionary.isIscode();
	}

	/**
	* Returns <code>true</code> if this dictionary is isroot.
	*
	* @return <code>true</code> if this dictionary is isroot; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsroot() {
		return _dictionary.isIsroot();
	}

	/**
	* Returns <code>true</code> if this dictionary is nagation.
	*
	* @return <code>true</code> if this dictionary is nagation; <code>false</code> otherwise
	*/
	@Override
	public boolean isNagation() {
		return _dictionary.isNagation();
	}

	@Override
	public boolean isNew() {
		return _dictionary.isNew();
	}

	/**
	* Returns <code>true</code> if this dictionary is occure.
	*
	* @return <code>true</code> if this dictionary is occure; <code>false</code> otherwise
	*/
	@Override
	public boolean isOccure() {
		return _dictionary.isOccure();
	}

	/**
	* Returns <code>true</code> if this dictionary is priority_mode.
	*
	* @return <code>true</code> if this dictionary is priority_mode; <code>false</code> otherwise
	*/
	@Override
	public boolean isPriority_mode() {
		return _dictionary.isPriority_mode();
	}

	/**
	* Returns <code>true</code> if this dictionary is sentence.
	*
	* @return <code>true</code> if this dictionary is sentence; <code>false</code> otherwise
	*/
	@Override
	public boolean isSentence() {
		return _dictionary.isSentence();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _dictionary.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.liferay.portlet.saat.model.Dictionary> toCacheModel() {
		return _dictionary.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.saat.model.Dictionary dictionary) {
		return _dictionary.compareTo(dictionary);
	}

	@Override
	public int hashCode() {
		return _dictionary.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dictionary.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new DictionaryWrapper((Dictionary)_dictionary.clone());
	}

	/**
	* Returns the code type of this dictionary.
	*
	* @return the code type of this dictionary
	*/
	@Override
	public java.lang.String getCodeType() {
		return _dictionary.getCodeType();
	}

	/**
	* Returns the code value of this dictionary.
	*
	* @return the code value of this dictionary
	*/
	@Override
	public java.lang.String getCodeValue() {
		return _dictionary.getCodeValue();
	}

	/**
	* Returns the disease_ids of this dictionary.
	*
	* @return the disease_ids of this dictionary
	*/
	@Override
	public java.lang.String getDisease_ids() {
		return _dictionary.getDisease_ids();
	}

	/**
	* Returns the pattern of this dictionary.
	*
	* @return the pattern of this dictionary
	*/
	@Override
	public java.lang.String getPattern() {
		return _dictionary.getPattern();
	}

	/**
	* Returns the synonym of this dictionary.
	*
	* @return the synonym of this dictionary
	*/
	@Override
	public java.lang.String getSynonym() {
		return _dictionary.getSynonym();
	}

	/**
	* Returns the user name of this dictionary.
	*
	* @return the user name of this dictionary
	*/
	@Override
	public java.lang.String getUserName() {
		return _dictionary.getUserName();
	}

	/**
	* Returns the user uuid of this dictionary.
	*
	* @return the user uuid of this dictionary
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _dictionary.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _dictionary.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dictionary.toXmlString();
	}

	/**
	* Returns the create date of this dictionary.
	*
	* @return the create date of this dictionary
	*/
	@Override
	public Date getCreateDate() {
		return _dictionary.getCreateDate();
	}

	/**
	* Returns the modified date of this dictionary.
	*
	* @return the modified date of this dictionary
	*/
	@Override
	public Date getModifiedDate() {
		return _dictionary.getModifiedDate();
	}

	/**
	* Returns the after synonym of this dictionary.
	*
	* @return the after synonym of this dictionary
	*/
	@Override
	public long getAfterSynonym() {
		return _dictionary.getAfterSynonym();
	}

	/**
	* Returns the befor synonym of this dictionary.
	*
	* @return the befor synonym of this dictionary
	*/
	@Override
	public long getBeforSynonym() {
		return _dictionary.getBeforSynonym();
	}

	/**
	* Returns the company ID of this dictionary.
	*
	* @return the company ID of this dictionary
	*/
	@Override
	public long getCompanyId() {
		return _dictionary.getCompanyId();
	}

	/**
	* Returns the dictionary ID of this dictionary.
	*
	* @return the dictionary ID of this dictionary
	*/
	@Override
	public long getDictionaryId() {
		return _dictionary.getDictionaryId();
	}

	/**
	* Returns the disease_ids_count of this dictionary.
	*
	* @return the disease_ids_count of this dictionary
	*/
	@Override
	public long getDisease_ids_count() {
		return _dictionary.getDisease_ids_count();
	}

	/**
	* Returns the primary key of this dictionary.
	*
	* @return the primary key of this dictionary
	*/
	@Override
	public long getPrimaryKey() {
		return _dictionary.getPrimaryKey();
	}

	/**
	* Returns the priority of this dictionary.
	*
	* @return the priority of this dictionary
	*/
	@Override
	public long getPriority() {
		return _dictionary.getPriority();
	}

	/**
	* Returns the user ID of this dictionary.
	*
	* @return the user ID of this dictionary
	*/
	@Override
	public long getUserId() {
		return _dictionary.getUserId();
	}

	@Override
	public void persist() {
		_dictionary.persist();
	}

	/**
	* Sets the after synonym of this dictionary.
	*
	* @param afterSynonym the after synonym of this dictionary
	*/
	@Override
	public void setAfterSynonym(long afterSynonym) {
		_dictionary.setAfterSynonym(afterSynonym);
	}

	/**
	* Sets the befor synonym of this dictionary.
	*
	* @param beforSynonym the befor synonym of this dictionary
	*/
	@Override
	public void setBeforSynonym(long beforSynonym) {
		_dictionary.setBeforSynonym(beforSynonym);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dictionary.setCachedModel(cachedModel);
	}

	/**
	* Sets the code type of this dictionary.
	*
	* @param codeType the code type of this dictionary
	*/
	@Override
	public void setCodeType(java.lang.String codeType) {
		_dictionary.setCodeType(codeType);
	}

	/**
	* Sets the code value of this dictionary.
	*
	* @param codeValue the code value of this dictionary
	*/
	@Override
	public void setCodeValue(java.lang.String codeValue) {
		_dictionary.setCodeValue(codeValue);
	}

	/**
	* Sets the company ID of this dictionary.
	*
	* @param companyId the company ID of this dictionary
	*/
	@Override
	public void setCompanyId(long companyId) {
		_dictionary.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this dictionary.
	*
	* @param createDate the create date of this dictionary
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_dictionary.setCreateDate(createDate);
	}

	/**
	* Sets the dictionary ID of this dictionary.
	*
	* @param dictionaryId the dictionary ID of this dictionary
	*/
	@Override
	public void setDictionaryId(long dictionaryId) {
		_dictionary.setDictionaryId(dictionaryId);
	}

	/**
	* Sets whether this dictionary is dirty.
	*
	* @param dirty the dirty of this dictionary
	*/
	@Override
	public void setDirty(boolean dirty) {
		_dictionary.setDirty(dirty);
	}

	/**
	* Sets the disease_ids of this dictionary.
	*
	* @param disease_ids the disease_ids of this dictionary
	*/
	@Override
	public void setDisease_ids(java.lang.String disease_ids) {
		_dictionary.setDisease_ids(disease_ids);
	}

	/**
	* Sets the disease_ids_count of this dictionary.
	*
	* @param disease_ids_count the disease_ids_count of this dictionary
	*/
	@Override
	public void setDisease_ids_count(long disease_ids_count) {
		_dictionary.setDisease_ids_count(disease_ids_count);
	}

	/**
	* Sets whether this dictionary is ending.
	*
	* @param ending the ending of this dictionary
	*/
	@Override
	public void setEnding(boolean ending) {
		_dictionary.setEnding(ending);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_dictionary.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_dictionary.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_dictionary.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets whether this dictionary is foreword.
	*
	* @param foreword the foreword of this dictionary
	*/
	@Override
	public void setForeword(boolean foreword) {
		_dictionary.setForeword(foreword);
	}

	/**
	* Sets whether this dictionary is iscode.
	*
	* @param iscode the iscode of this dictionary
	*/
	@Override
	public void setIscode(boolean iscode) {
		_dictionary.setIscode(iscode);
	}

	/**
	* Sets whether this dictionary is isroot.
	*
	* @param isroot the isroot of this dictionary
	*/
	@Override
	public void setIsroot(boolean isroot) {
		_dictionary.setIsroot(isroot);
	}

	/**
	* Sets the modified date of this dictionary.
	*
	* @param modifiedDate the modified date of this dictionary
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_dictionary.setModifiedDate(modifiedDate);
	}

	/**
	* Sets whether this dictionary is nagation.
	*
	* @param nagation the nagation of this dictionary
	*/
	@Override
	public void setNagation(boolean nagation) {
		_dictionary.setNagation(nagation);
	}

	@Override
	public void setNew(boolean n) {
		_dictionary.setNew(n);
	}

	/**
	* Sets whether this dictionary is occure.
	*
	* @param occure the occure of this dictionary
	*/
	@Override
	public void setOccure(boolean occure) {
		_dictionary.setOccure(occure);
	}

	/**
	* Sets the pattern of this dictionary.
	*
	* @param pattern the pattern of this dictionary
	*/
	@Override
	public void setPattern(java.lang.String pattern) {
		_dictionary.setPattern(pattern);
	}

	/**
	* Sets the primary key of this dictionary.
	*
	* @param primaryKey the primary key of this dictionary
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dictionary.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_dictionary.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the priority of this dictionary.
	*
	* @param priority the priority of this dictionary
	*/
	@Override
	public void setPriority(long priority) {
		_dictionary.setPriority(priority);
	}

	/**
	* Sets whether this dictionary is priority_mode.
	*
	* @param priority_mode the priority_mode of this dictionary
	*/
	@Override
	public void setPriority_mode(boolean priority_mode) {
		_dictionary.setPriority_mode(priority_mode);
	}

	/**
	* Sets whether this dictionary is sentence.
	*
	* @param sentence the sentence of this dictionary
	*/
	@Override
	public void setSentence(boolean sentence) {
		_dictionary.setSentence(sentence);
	}

	/**
	* Sets the synonym of this dictionary.
	*
	* @param synonym the synonym of this dictionary
	*/
	@Override
	public void setSynonym(java.lang.String synonym) {
		_dictionary.setSynonym(synonym);
	}

	/**
	* Sets the user ID of this dictionary.
	*
	* @param userId the user ID of this dictionary
	*/
	@Override
	public void setUserId(long userId) {
		_dictionary.setUserId(userId);
	}

	/**
	* Sets the user name of this dictionary.
	*
	* @param userName the user name of this dictionary
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_dictionary.setUserName(userName);
	}

	/**
	* Sets the user uuid of this dictionary.
	*
	* @param userUuid the user uuid of this dictionary
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dictionary.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DictionaryWrapper)) {
			return false;
		}

		DictionaryWrapper dictionaryWrapper = (DictionaryWrapper)obj;

		if (Objects.equals(_dictionary, dictionaryWrapper._dictionary)) {
			return true;
		}

		return false;
	}

	@Override
	public Dictionary getWrappedModel() {
		return _dictionary;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _dictionary.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _dictionary.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_dictionary.resetOriginalValues();
	}

	private final Dictionary _dictionary;
}