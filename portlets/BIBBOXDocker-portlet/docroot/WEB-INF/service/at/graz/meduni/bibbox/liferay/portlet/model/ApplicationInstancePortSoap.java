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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.bibbox.liferay.portlet.service.http.ApplicationInstancePortServiceSoap}.
 *
 * @author Robert Reihs
 * @see at.graz.meduni.bibbox.liferay.portlet.service.http.ApplicationInstancePortServiceSoap
 * @generated
 */
@ProviderType
public class ApplicationInstancePortSoap implements Serializable {
	public static ApplicationInstancePortSoap toSoapModel(
		ApplicationInstancePort model) {
		ApplicationInstancePortSoap soapModel = new ApplicationInstancePortSoap();

		soapModel.setApplicationInstancePortId(model.getApplicationInstancePortId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPort(model.getPort());
		soapModel.setPortId(model.getPortId());
		soapModel.setPrimary(model.getPrimary());
		soapModel.setSubdomain(model.getSubdomain());
		soapModel.setApplicationInstanceId(model.getApplicationInstanceId());

		return soapModel;
	}

	public static ApplicationInstancePortSoap[] toSoapModels(
		ApplicationInstancePort[] models) {
		ApplicationInstancePortSoap[] soapModels = new ApplicationInstancePortSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ApplicationInstancePortSoap[][] toSoapModels(
		ApplicationInstancePort[][] models) {
		ApplicationInstancePortSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ApplicationInstancePortSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ApplicationInstancePortSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ApplicationInstancePortSoap[] toSoapModels(
		List<ApplicationInstancePort> models) {
		List<ApplicationInstancePortSoap> soapModels = new ArrayList<ApplicationInstancePortSoap>(models.size());

		for (ApplicationInstancePort model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ApplicationInstancePortSoap[soapModels.size()]);
	}

	public ApplicationInstancePortSoap() {
	}

	public long getPrimaryKey() {
		return _applicationInstancePortId;
	}

	public void setPrimaryKey(long pk) {
		setApplicationInstancePortId(pk);
	}

	public long getApplicationInstancePortId() {
		return _applicationInstancePortId;
	}

	public void setApplicationInstancePortId(long applicationInstancePortId) {
		_applicationInstancePortId = applicationInstancePortId;
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

	public long getPort() {
		return _port;
	}

	public void setPort(long port) {
		_port = port;
	}

	public String getPortId() {
		return _portId;
	}

	public void setPortId(String portId) {
		_portId = portId;
	}

	public boolean getPrimary() {
		return _primary;
	}

	public boolean isPrimary() {
		return _primary;
	}

	public void setPrimary(boolean primary) {
		_primary = primary;
	}

	public String getSubdomain() {
		return _subdomain;
	}

	public void setSubdomain(String subdomain) {
		_subdomain = subdomain;
	}

	public long getApplicationInstanceId() {
		return _applicationInstanceId;
	}

	public void setApplicationInstanceId(long applicationInstanceId) {
		_applicationInstanceId = applicationInstanceId;
	}

	private long _applicationInstancePortId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _port;
	private String _portId;
	private boolean _primary;
	private String _subdomain;
	private long _applicationInstanceId;
}