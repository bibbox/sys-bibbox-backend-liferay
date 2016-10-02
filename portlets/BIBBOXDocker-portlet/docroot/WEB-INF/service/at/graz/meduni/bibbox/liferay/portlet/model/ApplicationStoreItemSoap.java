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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.bibbox.liferay.portlet.service.http.ApplicationStoreItemServiceSoap}.
 *
 * @author Robert Reihs
 * @see at.graz.meduni.bibbox.liferay.portlet.service.http.ApplicationStoreItemServiceSoap
 * @generated
 */
@ProviderType
public class ApplicationStoreItemSoap implements Serializable {
	public static ApplicationStoreItemSoap toSoapModel(
		ApplicationStoreItem model) {
		ApplicationStoreItemSoap soapModel = new ApplicationStoreItemSoap();

		soapModel.setApplicationStoreItemId(model.getApplicationStoreItemId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGithash(model.getGithash());
		soapModel.setDepreciated(model.getDepreciated());
		soapModel.setApplicationFolderName(model.getApplicationFolderName());
		soapModel.setApplicationName(model.getApplicationName());
		soapModel.setApplicationShortName(model.getApplicationShortName());
		soapModel.setApplicationVersion(model.getApplicationVersion());
		soapModel.setApplicationReleaseState(model.getApplicationReleaseState());
		soapModel.setApplicationDescription(model.getApplicationDescription());
		soapModel.setApplicationCatalogueUrl(model.getApplicationCatalogueUrl());
		soapModel.setApplicationApplicationUrl(model.getApplicationApplicationUrl());

		return soapModel;
	}

	public static ApplicationStoreItemSoap[] toSoapModels(
		ApplicationStoreItem[] models) {
		ApplicationStoreItemSoap[] soapModels = new ApplicationStoreItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ApplicationStoreItemSoap[][] toSoapModels(
		ApplicationStoreItem[][] models) {
		ApplicationStoreItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ApplicationStoreItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ApplicationStoreItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ApplicationStoreItemSoap[] toSoapModels(
		List<ApplicationStoreItem> models) {
		List<ApplicationStoreItemSoap> soapModels = new ArrayList<ApplicationStoreItemSoap>(models.size());

		for (ApplicationStoreItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ApplicationStoreItemSoap[soapModels.size()]);
	}

	public ApplicationStoreItemSoap() {
	}

	public long getPrimaryKey() {
		return _applicationStoreItemId;
	}

	public void setPrimaryKey(long pk) {
		setApplicationStoreItemId(pk);
	}

	public long getApplicationStoreItemId() {
		return _applicationStoreItemId;
	}

	public void setApplicationStoreItemId(long applicationStoreItemId) {
		_applicationStoreItemId = applicationStoreItemId;
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

	public String getGithash() {
		return _githash;
	}

	public void setGithash(String githash) {
		_githash = githash;
	}

	public Boolean getDepreciated() {
		return _depreciated;
	}

	public void setDepreciated(Boolean depreciated) {
		_depreciated = depreciated;
	}

	public String getApplicationFolderName() {
		return _applicationFolderName;
	}

	public void setApplicationFolderName(String applicationFolderName) {
		_applicationFolderName = applicationFolderName;
	}

	public String getApplicationName() {
		return _applicationName;
	}

	public void setApplicationName(String applicationName) {
		_applicationName = applicationName;
	}

	public String getApplicationShortName() {
		return _applicationShortName;
	}

	public void setApplicationShortName(String applicationShortName) {
		_applicationShortName = applicationShortName;
	}

	public String getApplicationVersion() {
		return _applicationVersion;
	}

	public void setApplicationVersion(String applicationVersion) {
		_applicationVersion = applicationVersion;
	}

	public String getApplicationReleaseState() {
		return _applicationReleaseState;
	}

	public void setApplicationReleaseState(String applicationReleaseState) {
		_applicationReleaseState = applicationReleaseState;
	}

	public String getApplicationDescription() {
		return _applicationDescription;
	}

	public void setApplicationDescription(String applicationDescription) {
		_applicationDescription = applicationDescription;
	}

	public String getApplicationCatalogueUrl() {
		return _applicationCatalogueUrl;
	}

	public void setApplicationCatalogueUrl(String applicationCatalogueUrl) {
		_applicationCatalogueUrl = applicationCatalogueUrl;
	}

	public String getApplicationApplicationUrl() {
		return _applicationApplicationUrl;
	}

	public void setApplicationApplicationUrl(String applicationApplicationUrl) {
		_applicationApplicationUrl = applicationApplicationUrl;
	}

	private long _applicationStoreItemId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _githash;
	private Boolean _depreciated;
	private String _applicationFolderName;
	private String _applicationName;
	private String _applicationShortName;
	private String _applicationVersion;
	private String _applicationReleaseState;
	private String _applicationDescription;
	private String _applicationCatalogueUrl;
	private String _applicationApplicationUrl;
}