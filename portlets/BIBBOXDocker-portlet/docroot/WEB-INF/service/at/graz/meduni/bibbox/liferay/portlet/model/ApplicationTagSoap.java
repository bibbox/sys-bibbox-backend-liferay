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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.bibbox.liferay.portlet.service.http.ApplicationTagServiceSoap}.
 *
 * @author Robert Reihs
 * @see at.graz.meduni.bibbox.liferay.portlet.service.http.ApplicationTagServiceSoap
 * @generated
 */
@ProviderType
public class ApplicationTagSoap implements Serializable {
	public static ApplicationTagSoap toSoapModel(ApplicationTag model) {
		ApplicationTagSoap soapModel = new ApplicationTagSoap();

		soapModel.setApplicationTagsId(model.getApplicationTagsId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTag(model.getTag());
		soapModel.setApplicationStoreItemId(model.getApplicationStoreItemId());

		return soapModel;
	}

	public static ApplicationTagSoap[] toSoapModels(ApplicationTag[] models) {
		ApplicationTagSoap[] soapModels = new ApplicationTagSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ApplicationTagSoap[][] toSoapModels(ApplicationTag[][] models) {
		ApplicationTagSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ApplicationTagSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ApplicationTagSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ApplicationTagSoap[] toSoapModels(List<ApplicationTag> models) {
		List<ApplicationTagSoap> soapModels = new ArrayList<ApplicationTagSoap>(models.size());

		for (ApplicationTag model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ApplicationTagSoap[soapModels.size()]);
	}

	public ApplicationTagSoap() {
	}

	public long getPrimaryKey() {
		return _applicationTagsId;
	}

	public void setPrimaryKey(long pk) {
		setApplicationTagsId(pk);
	}

	public long getApplicationTagsId() {
		return _applicationTagsId;
	}

	public void setApplicationTagsId(long applicationTagsId) {
		_applicationTagsId = applicationTagsId;
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

	public String getTag() {
		return _tag;
	}

	public void setTag(String tag) {
		_tag = tag;
	}

	public long getApplicationStoreItemId() {
		return _applicationStoreItemId;
	}

	public void setApplicationStoreItemId(long applicationStoreItemId) {
		_applicationStoreItemId = applicationStoreItemId;
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
}