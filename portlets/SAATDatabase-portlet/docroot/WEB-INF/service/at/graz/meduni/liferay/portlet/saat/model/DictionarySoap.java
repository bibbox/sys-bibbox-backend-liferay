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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.saat.service.http.DictionaryServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.saat.service.http.DictionaryServiceSoap
 * @generated
 */
@ProviderType
public class DictionarySoap implements Serializable {
	public static DictionarySoap toSoapModel(Dictionary model) {
		DictionarySoap soapModel = new DictionarySoap();

		soapModel.setDictionaryId(model.getDictionaryId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setIsroot(model.getIsroot());
		soapModel.setIscode(model.getIscode());
		soapModel.setSynonym(model.getSynonym());
		soapModel.setPattern(model.getPattern());
		soapModel.setBeforSynonym(model.getBeforSynonym());
		soapModel.setAfterSynonym(model.getAfterSynonym());
		soapModel.setForeword(model.getForeword());
		soapModel.setEnding(model.getEnding());
		soapModel.setSentence(model.getSentence());
		soapModel.setOccure(model.getOccure());
		soapModel.setNagation(model.getNagation());
		soapModel.setPriority_mode(model.getPriority_mode());
		soapModel.setCodeType(model.getCodeType());
		soapModel.setCodeValue(model.getCodeValue());
		soapModel.setPriority(model.getPriority());
		soapModel.setDisease_ids(model.getDisease_ids());
		soapModel.setDirty(model.getDirty());
		soapModel.setDisease_ids_count(model.getDisease_ids_count());

		return soapModel;
	}

	public static DictionarySoap[] toSoapModels(Dictionary[] models) {
		DictionarySoap[] soapModels = new DictionarySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DictionarySoap[][] toSoapModels(Dictionary[][] models) {
		DictionarySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DictionarySoap[models.length][models[0].length];
		}
		else {
			soapModels = new DictionarySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DictionarySoap[] toSoapModels(List<Dictionary> models) {
		List<DictionarySoap> soapModels = new ArrayList<DictionarySoap>(models.size());

		for (Dictionary model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DictionarySoap[soapModels.size()]);
	}

	public DictionarySoap() {
	}

	public long getPrimaryKey() {
		return _dictionaryId;
	}

	public void setPrimaryKey(long pk) {
		setDictionaryId(pk);
	}

	public long getDictionaryId() {
		return _dictionaryId;
	}

	public void setDictionaryId(long dictionaryId) {
		_dictionaryId = dictionaryId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public boolean getIsroot() {
		return _isroot;
	}

	public boolean isIsroot() {
		return _isroot;
	}

	public void setIsroot(boolean isroot) {
		_isroot = isroot;
	}

	public boolean getIscode() {
		return _iscode;
	}

	public boolean isIscode() {
		return _iscode;
	}

	public void setIscode(boolean iscode) {
		_iscode = iscode;
	}

	public String getSynonym() {
		return _synonym;
	}

	public void setSynonym(String synonym) {
		_synonym = synonym;
	}

	public String getPattern() {
		return _pattern;
	}

	public void setPattern(String pattern) {
		_pattern = pattern;
	}

	public long getBeforSynonym() {
		return _beforSynonym;
	}

	public void setBeforSynonym(long beforSynonym) {
		_beforSynonym = beforSynonym;
	}

	public long getAfterSynonym() {
		return _afterSynonym;
	}

	public void setAfterSynonym(long afterSynonym) {
		_afterSynonym = afterSynonym;
	}

	public boolean getForeword() {
		return _foreword;
	}

	public boolean isForeword() {
		return _foreword;
	}

	public void setForeword(boolean foreword) {
		_foreword = foreword;
	}

	public boolean getEnding() {
		return _ending;
	}

	public boolean isEnding() {
		return _ending;
	}

	public void setEnding(boolean ending) {
		_ending = ending;
	}

	public boolean getSentence() {
		return _sentence;
	}

	public boolean isSentence() {
		return _sentence;
	}

	public void setSentence(boolean sentence) {
		_sentence = sentence;
	}

	public boolean getOccure() {
		return _occure;
	}

	public boolean isOccure() {
		return _occure;
	}

	public void setOccure(boolean occure) {
		_occure = occure;
	}

	public boolean getNagation() {
		return _nagation;
	}

	public boolean isNagation() {
		return _nagation;
	}

	public void setNagation(boolean nagation) {
		_nagation = nagation;
	}

	public boolean getPriority_mode() {
		return _priority_mode;
	}

	public boolean isPriority_mode() {
		return _priority_mode;
	}

	public void setPriority_mode(boolean priority_mode) {
		_priority_mode = priority_mode;
	}

	public String getCodeType() {
		return _codeType;
	}

	public void setCodeType(String codeType) {
		_codeType = codeType;
	}

	public String getCodeValue() {
		return _codeValue;
	}

	public void setCodeValue(String codeValue) {
		_codeValue = codeValue;
	}

	public long getPriority() {
		return _priority;
	}

	public void setPriority(long priority) {
		_priority = priority;
	}

	public String getDisease_ids() {
		return _disease_ids;
	}

	public void setDisease_ids(String disease_ids) {
		_disease_ids = disease_ids;
	}

	public boolean getDirty() {
		return _dirty;
	}

	public boolean isDirty() {
		return _dirty;
	}

	public void setDirty(boolean dirty) {
		_dirty = dirty;
	}

	public long getDisease_ids_count() {
		return _disease_ids_count;
	}

	public void setDisease_ids_count(long disease_ids_count) {
		_disease_ids_count = disease_ids_count;
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
}