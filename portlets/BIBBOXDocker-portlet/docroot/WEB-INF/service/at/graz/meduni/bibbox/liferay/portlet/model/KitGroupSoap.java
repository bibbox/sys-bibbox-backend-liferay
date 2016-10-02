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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.bibbox.liferay.portlet.service.http.KitGroupServiceSoap}.
 *
 * @author Robert Reihs
 * @see at.graz.meduni.bibbox.liferay.portlet.service.http.KitGroupServiceSoap
 * @generated
 */
@ProviderType
public class KitGroupSoap implements Serializable {
	public static KitGroupSoap toSoapModel(KitGroup model) {
		KitGroupSoap soapModel = new KitGroupSoap();

		soapModel.setKitGroupId(model.getKitGroupId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGroup(model.getGroup());
		soapModel.setApplicationStoreItemId(model.getApplicationStoreItemId());
		soapModel.setBibboxKitId(model.getBibboxKitId());

		return soapModel;
	}

	public static KitGroupSoap[] toSoapModels(KitGroup[] models) {
		KitGroupSoap[] soapModels = new KitGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KitGroupSoap[][] toSoapModels(KitGroup[][] models) {
		KitGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new KitGroupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new KitGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KitGroupSoap[] toSoapModels(List<KitGroup> models) {
		List<KitGroupSoap> soapModels = new ArrayList<KitGroupSoap>(models.size());

		for (KitGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KitGroupSoap[soapModels.size()]);
	}

	public KitGroupSoap() {
	}

	public long getPrimaryKey() {
		return _kitGroupId;
	}

	public void setPrimaryKey(long pk) {
		setKitGroupId(pk);
	}

	public long getKitGroupId() {
		return _kitGroupId;
	}

	public void setKitGroupId(long kitGroupId) {
		_kitGroupId = kitGroupId;
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

	public String getGroup() {
		return _group;
	}

	public void setGroup(String group) {
		_group = group;
	}

	public long getApplicationStoreItemId() {
		return _applicationStoreItemId;
	}

	public void setApplicationStoreItemId(long applicationStoreItemId) {
		_applicationStoreItemId = applicationStoreItemId;
	}

	public long getBibboxKitId() {
		return _bibboxKitId;
	}

	public void setBibboxKitId(long bibboxKitId) {
		_bibboxKitId = bibboxKitId;
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
}