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
 * This class is used by SOAP remote services, specifically {@link at.graz.meduni.bibbox.liferay.portlet.service.http.DockerContainerServiceSoap}.
 *
 * @author Robert Reihs
 * @see at.graz.meduni.bibbox.liferay.portlet.service.http.DockerContainerServiceSoap
 * @generated
 */
@ProviderType
public class DockerContainerSoap implements Serializable {
	public static DockerContainerSoap toSoapModel(DockerContainer model) {
		DockerContainerSoap soapModel = new DockerContainerSoap();

		soapModel.setDockerContainerId(model.getDockerContainerId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStartCommand(model.getStartCommand());
		soapModel.setToolName(model.getToolName());
		soapModel.setInstance(model.getInstance());
		soapModel.setPort(model.getPort());
		soapModel.setUrl(model.getUrl());
		soapModel.setSubdomain(model.getSubdomain());
		soapModel.setIp(model.getIp());
		soapModel.setDisplayName(model.getDisplayName());
		soapModel.setDisplayToolName(model.getDisplayToolName());
		soapModel.setCategory(model.getCategory());
		soapModel.setTool(model.getTool());
		soapModel.setDescription(model.getDescription());
		soapModel.setCompany(model.getCompany());
		soapModel.setPlatform(model.getPlatform());
		soapModel.setLicense(model.getLicense());
		soapModel.setToolDescription(model.getToolDescription());
		soapModel.setLogourl(model.getLogourl());

		return soapModel;
	}

	public static DockerContainerSoap[] toSoapModels(DockerContainer[] models) {
		DockerContainerSoap[] soapModels = new DockerContainerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DockerContainerSoap[][] toSoapModels(
		DockerContainer[][] models) {
		DockerContainerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DockerContainerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DockerContainerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DockerContainerSoap[] toSoapModels(
		List<DockerContainer> models) {
		List<DockerContainerSoap> soapModels = new ArrayList<DockerContainerSoap>(models.size());

		for (DockerContainer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DockerContainerSoap[soapModels.size()]);
	}

	public DockerContainerSoap() {
	}

	public long getPrimaryKey() {
		return _dockerContainerId;
	}

	public void setPrimaryKey(long pk) {
		setDockerContainerId(pk);
	}

	public long getDockerContainerId() {
		return _dockerContainerId;
	}

	public void setDockerContainerId(long dockerContainerId) {
		_dockerContainerId = dockerContainerId;
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

	public String getStartCommand() {
		return _startCommand;
	}

	public void setStartCommand(String startCommand) {
		_startCommand = startCommand;
	}

	public String getToolName() {
		return _toolName;
	}

	public void setToolName(String toolName) {
		_toolName = toolName;
	}

	public String getInstance() {
		return _instance;
	}

	public void setInstance(String instance) {
		_instance = instance;
	}

	public String getPort() {
		return _port;
	}

	public void setPort(String port) {
		_port = port;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getSubdomain() {
		return _subdomain;
	}

	public void setSubdomain(String subdomain) {
		_subdomain = subdomain;
	}

	public String getIp() {
		return _ip;
	}

	public void setIp(String ip) {
		_ip = ip;
	}

	public String getDisplayName() {
		return _displayName;
	}

	public void setDisplayName(String displayName) {
		_displayName = displayName;
	}

	public String getDisplayToolName() {
		return _displayToolName;
	}

	public void setDisplayToolName(String displayToolName) {
		_displayToolName = displayToolName;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public String getTool() {
		return _tool;
	}

	public void setTool(String tool) {
		_tool = tool;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getCompany() {
		return _company;
	}

	public void setCompany(String company) {
		_company = company;
	}

	public String getPlatform() {
		return _platform;
	}

	public void setPlatform(String platform) {
		_platform = platform;
	}

	public String getLicense() {
		return _license;
	}

	public void setLicense(String license) {
		_license = license;
	}

	public String getToolDescription() {
		return _toolDescription;
	}

	public void setToolDescription(String toolDescription) {
		_toolDescription = toolDescription;
	}

	public String getLogourl() {
		return _logourl;
	}

	public void setLogourl(String logourl) {
		_logourl = logourl;
	}

	private long _dockerContainerId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _startCommand;
	private String _toolName;
	private String _instance;
	private String _port;
	private String _url;
	private String _subdomain;
	private String _ip;
	private String _displayName;
	private String _displayToolName;
	private String _category;
	private String _tool;
	private String _description;
	private String _company;
	private String _platform;
	private String _license;
	private String _toolDescription;
	private String _logourl;
}