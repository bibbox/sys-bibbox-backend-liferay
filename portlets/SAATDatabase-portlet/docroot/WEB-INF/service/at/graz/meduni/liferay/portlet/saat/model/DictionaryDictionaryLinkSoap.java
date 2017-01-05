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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.liferay.portlet.saat.service.http.DictionaryDictionaryLinkServiceSoap}.
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.saat.service.http.DictionaryDictionaryLinkServiceSoap
 * @generated
 */
@ProviderType
public class DictionaryDictionaryLinkSoap implements Serializable {
	public static DictionaryDictionaryLinkSoap toSoapModel(
		DictionaryDictionaryLink model) {
		DictionaryDictionaryLinkSoap soapModel = new DictionaryDictionaryLinkSoap();

		soapModel.setDictionaryDictionaryLinkId(model.getDictionaryDictionaryLinkId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDictionaryId(model.getDictionaryId());
		soapModel.setDictionaryAddictionId(model.getDictionaryAddictionId());

		return soapModel;
	}

	public static DictionaryDictionaryLinkSoap[] toSoapModels(
		DictionaryDictionaryLink[] models) {
		DictionaryDictionaryLinkSoap[] soapModels = new DictionaryDictionaryLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DictionaryDictionaryLinkSoap[][] toSoapModels(
		DictionaryDictionaryLink[][] models) {
		DictionaryDictionaryLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DictionaryDictionaryLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DictionaryDictionaryLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DictionaryDictionaryLinkSoap[] toSoapModels(
		List<DictionaryDictionaryLink> models) {
		List<DictionaryDictionaryLinkSoap> soapModels = new ArrayList<DictionaryDictionaryLinkSoap>(models.size());

		for (DictionaryDictionaryLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DictionaryDictionaryLinkSoap[soapModels.size()]);
	}

	public DictionaryDictionaryLinkSoap() {
	}

	public long getPrimaryKey() {
		return _dictionaryDictionaryLinkId;
	}

	public void setPrimaryKey(long pk) {
		setDictionaryDictionaryLinkId(pk);
	}

	public long getDictionaryDictionaryLinkId() {
		return _dictionaryDictionaryLinkId;
	}

	public void setDictionaryDictionaryLinkId(long dictionaryDictionaryLinkId) {
		_dictionaryDictionaryLinkId = dictionaryDictionaryLinkId;
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

	public long getDictionaryId() {
		return _dictionaryId;
	}

	public void setDictionaryId(long dictionaryId) {
		_dictionaryId = dictionaryId;
	}

	public long getDictionaryAddictionId() {
		return _dictionaryAddictionId;
	}

	public void setDictionaryAddictionId(long dictionaryAddictionId) {
		_dictionaryAddictionId = dictionaryAddictionId;
	}

	private long _dictionaryDictionaryLinkId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _dictionaryId;
	private long _dictionaryAddictionId;
}