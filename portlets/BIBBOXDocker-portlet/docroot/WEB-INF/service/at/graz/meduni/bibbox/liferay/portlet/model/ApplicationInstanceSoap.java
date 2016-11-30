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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.bibbox.liferay.portlet.service.http.ApplicationInstanceServiceSoap}.
 *
 * @author Robert Reihs
 * @see at.graz.meduni.bibbox.liferay.portlet.service.http.ApplicationInstanceServiceSoap
 * @generated
 */
@ProviderType
public class ApplicationInstanceSoap implements Serializable {
	public static ApplicationInstanceSoap toSoapModel(ApplicationInstance model) {
		ApplicationInstanceSoap soapModel = new ApplicationInstanceSoap();

		soapModel.setApplicationInstanceId(model.getApplicationInstanceId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setInstanceId(model.getInstanceId());
		soapModel.setName(model.getName());
		soapModel.setShortName(model.getShortName());
		soapModel.setBaseurl(model.getBaseurl());
		soapModel.setFolderName(model.getFolderName());
		soapModel.setApplication(model.getApplication());
		soapModel.setVersion(model.getVersion());
		soapModel.setStatus(model.getStatus());
		soapModel.setDeleted(model.getDeleted());
		soapModel.setShortdescription(model.getShortdescription());
		soapModel.setDescription(model.getDescription());
		soapModel.setAdminnode(model.getAdminnode());
		soapModel.setMaintenance(model.getMaintenance());
		soapModel.setIsmaintenance(model.getIsmaintenance());
		soapModel.setInstalllog(model.getInstalllog());
		soapModel.setIsinstalling(model.getIsinstalling());

		return soapModel;
	}

	public static ApplicationInstanceSoap[] toSoapModels(
		ApplicationInstance[] models) {
		ApplicationInstanceSoap[] soapModels = new ApplicationInstanceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ApplicationInstanceSoap[][] toSoapModels(
		ApplicationInstance[][] models) {
		ApplicationInstanceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ApplicationInstanceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ApplicationInstanceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ApplicationInstanceSoap[] toSoapModels(
		List<ApplicationInstance> models) {
		List<ApplicationInstanceSoap> soapModels = new ArrayList<ApplicationInstanceSoap>(models.size());

		for (ApplicationInstance model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ApplicationInstanceSoap[soapModels.size()]);
	}

	public ApplicationInstanceSoap() {
	}

	public long getPrimaryKey() {
		return _applicationInstanceId;
	}

	public void setPrimaryKey(long pk) {
		setApplicationInstanceId(pk);
	}

	public long getApplicationInstanceId() {
		return _applicationInstanceId;
	}

	public void setApplicationInstanceId(long applicationInstanceId) {
		_applicationInstanceId = applicationInstanceId;
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

	public String getInstanceId() {
		return _instanceId;
	}

	public void setInstanceId(String instanceId) {
		_instanceId = instanceId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getShortName() {
		return _shortName;
	}

	public void setShortName(String shortName) {
		_shortName = shortName;
	}

	public String getBaseurl() {
		return _baseurl;
	}

	public void setBaseurl(String baseurl) {
		_baseurl = baseurl;
	}

	public String getFolderName() {
		return _folderName;
	}

	public void setFolderName(String folderName) {
		_folderName = folderName;
	}

	public String getApplication() {
		return _application;
	}

	public void setApplication(String application) {
		_application = application;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String version) {
		_version = version;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	public boolean getDeleted() {
		return _deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}

	public void setDeleted(boolean deleted) {
		_deleted = deleted;
	}

	public String getShortdescription() {
		return _shortdescription;
	}

	public void setShortdescription(String shortdescription) {
		_shortdescription = shortdescription;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getAdminnode() {
		return _adminnode;
	}

	public void setAdminnode(String adminnode) {
		_adminnode = adminnode;
	}

	public String getMaintenance() {
		return _maintenance;
	}

	public void setMaintenance(String maintenance) {
		_maintenance = maintenance;
	}

	public boolean getIsmaintenance() {
		return _ismaintenance;
	}

	public boolean isIsmaintenance() {
		return _ismaintenance;
	}

	public void setIsmaintenance(boolean ismaintenance) {
		_ismaintenance = ismaintenance;
	}

	public String getInstalllog() {
		return _installlog;
	}

	public void setInstalllog(String installlog) {
		_installlog = installlog;
	}

	public boolean getIsinstalling() {
		return _isinstalling;
	}

	public boolean isIsinstalling() {
		return _isinstalling;
	}

	public void setIsinstalling(boolean isinstalling) {
		_isinstalling = isinstalling;
	}

	private long _applicationInstanceId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _instanceId;
	private String _name;
	private String _shortName;
	private String _baseurl;
	private String _folderName;
	private String _application;
	private String _version;
	private boolean _status;
	private boolean _deleted;
	private String _shortdescription;
	private String _description;
	private String _adminnode;
	private String _maintenance;
	private boolean _ismaintenance;
	private String _installlog;
	private boolean _isinstalling;
}