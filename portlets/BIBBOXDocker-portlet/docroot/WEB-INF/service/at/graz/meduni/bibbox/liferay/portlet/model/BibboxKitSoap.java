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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.bibbox.liferay.portlet.service.http.BibboxKitServiceSoap}.
 *
 * @author Robert Reihs
 * @see at.graz.meduni.bibbox.liferay.portlet.service.http.BibboxKitServiceSoap
 * @generated
 */
@ProviderType
public class BibboxKitSoap implements Serializable {
	public static BibboxKitSoap toSoapModel(BibboxKit model) {
		BibboxKitSoap soapModel = new BibboxKitSoap();

		soapModel.setBibboxKitId(model.getBibboxKitId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setKitName(model.getKitName());
		soapModel.setApplicationStoreItemId(model.getApplicationStoreItemId());

		return soapModel;
	}

	public static BibboxKitSoap[] toSoapModels(BibboxKit[] models) {
		BibboxKitSoap[] soapModels = new BibboxKitSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BibboxKitSoap[][] toSoapModels(BibboxKit[][] models) {
		BibboxKitSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BibboxKitSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BibboxKitSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BibboxKitSoap[] toSoapModels(List<BibboxKit> models) {
		List<BibboxKitSoap> soapModels = new ArrayList<BibboxKitSoap>(models.size());

		for (BibboxKit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BibboxKitSoap[soapModels.size()]);
	}

	public BibboxKitSoap() {
	}

	public long getPrimaryKey() {
		return _bibboxKitId;
	}

	public void setPrimaryKey(long pk) {
		setBibboxKitId(pk);
	}

	public long getBibboxKitId() {
		return _bibboxKitId;
	}

	public void setBibboxKitId(long bibboxKitId) {
		_bibboxKitId = bibboxKitId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public String getKitName() {
		return _kitName;
	}

	public void setKitName(String kitName) {
		_kitName = kitName;
	}

	public long getApplicationStoreItemId() {
		return _applicationStoreItemId;
	}

	public void setApplicationStoreItemId(long applicationStoreItemId) {
		_applicationStoreItemId = applicationStoreItemId;
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
}