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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.bibbox.liferay.portlet.service.http.ApplicationInstanceContainerServiceSoap}.
 *
 * @author Robert Reihs
 * @see at.graz.meduni.bibbox.liferay.portlet.service.http.ApplicationInstanceContainerServiceSoap
 * @generated
 */
@ProviderType
public class ApplicationInstanceContainerSoap implements Serializable {
	public static ApplicationInstanceContainerSoap toSoapModel(
		ApplicationInstanceContainer model) {
		ApplicationInstanceContainerSoap soapModel = new ApplicationInstanceContainerSoap();

		soapModel.setApplicationInstanceContainerId(model.getApplicationInstanceContainerId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setContainerName(model.getContainerName());
		soapModel.setNeedrunning(model.getNeedrunning());
		soapModel.setApplicationInstanceId(model.getApplicationInstanceId());

		return soapModel;
	}

	public static ApplicationInstanceContainerSoap[] toSoapModels(
		ApplicationInstanceContainer[] models) {
		ApplicationInstanceContainerSoap[] soapModels = new ApplicationInstanceContainerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ApplicationInstanceContainerSoap[][] toSoapModels(
		ApplicationInstanceContainer[][] models) {
		ApplicationInstanceContainerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ApplicationInstanceContainerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ApplicationInstanceContainerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ApplicationInstanceContainerSoap[] toSoapModels(
		List<ApplicationInstanceContainer> models) {
		List<ApplicationInstanceContainerSoap> soapModels = new ArrayList<ApplicationInstanceContainerSoap>(models.size());

		for (ApplicationInstanceContainer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ApplicationInstanceContainerSoap[soapModels.size()]);
	}

	public ApplicationInstanceContainerSoap() {
	}

	public long getPrimaryKey() {
		return _applicationInstanceContainerId;
	}

	public void setPrimaryKey(long pk) {
		setApplicationInstanceContainerId(pk);
	}

	public long getApplicationInstanceContainerId() {
		return _applicationInstanceContainerId;
	}

	public void setApplicationInstanceContainerId(
		long applicationInstanceContainerId) {
		_applicationInstanceContainerId = applicationInstanceContainerId;
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

	public String getContainerName() {
		return _containerName;
	}

	public void setContainerName(String containerName) {
		_containerName = containerName;
	}

	public boolean getNeedrunning() {
		return _needrunning;
	}

	public boolean isNeedrunning() {
		return _needrunning;
	}

	public void setNeedrunning(boolean needrunning) {
		_needrunning = needrunning;
	}

	public long getApplicationInstanceId() {
		return _applicationInstanceId;
	}

	public void setApplicationInstanceId(long applicationInstanceId) {
		_applicationInstanceId = applicationInstanceId;
	}

	private long _applicationInstanceContainerId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _containerName;
	private boolean _needrunning;
	private long _applicationInstanceId;
}