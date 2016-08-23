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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link DockerContainer}.
 * </p>
 *
 * @author Robert Reihs
 * @see DockerContainer
 * @generated
 */
@ProviderType
public class DockerContainerWrapper implements DockerContainer,
	ModelWrapper<DockerContainer> {
	public DockerContainerWrapper(DockerContainer dockerContainer) {
		_dockerContainer = dockerContainer;
	}

	@Override
	public Class<?> getModelClass() {
		return DockerContainer.class;
	}

	@Override
	public String getModelClassName() {
		return DockerContainer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dockerContainerId", getDockerContainerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("startCommand", getStartCommand());
		attributes.put("toolName", getToolName());
		attributes.put("instance", getInstance());
		attributes.put("port", getPort());
		attributes.put("url", getUrl());
		attributes.put("subdomain", getSubdomain());
		attributes.put("ip", getIp());
		attributes.put("displayName", getDisplayName());
		attributes.put("displayToolName", getDisplayToolName());
		attributes.put("category", getCategory());
		attributes.put("tool", getTool());
		attributes.put("description", getDescription());
		attributes.put("company", getCompany());
		attributes.put("platform", getPlatform());
		attributes.put("license", getLicense());
		attributes.put("toolDescription", getToolDescription());
		attributes.put("logourl", getLogourl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dockerContainerId = (Long)attributes.get("dockerContainerId");

		if (dockerContainerId != null) {
			setDockerContainerId(dockerContainerId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String startCommand = (String)attributes.get("startCommand");

		if (startCommand != null) {
			setStartCommand(startCommand);
		}

		String toolName = (String)attributes.get("toolName");

		if (toolName != null) {
			setToolName(toolName);
		}

		String instance = (String)attributes.get("instance");

		if (instance != null) {
			setInstance(instance);
		}

		String port = (String)attributes.get("port");

		if (port != null) {
			setPort(port);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String subdomain = (String)attributes.get("subdomain");

		if (subdomain != null) {
			setSubdomain(subdomain);
		}

		String ip = (String)attributes.get("ip");

		if (ip != null) {
			setIp(ip);
		}

		String displayName = (String)attributes.get("displayName");

		if (displayName != null) {
			setDisplayName(displayName);
		}

		String displayToolName = (String)attributes.get("displayToolName");

		if (displayToolName != null) {
			setDisplayToolName(displayToolName);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String tool = (String)attributes.get("tool");

		if (tool != null) {
			setTool(tool);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}

		String platform = (String)attributes.get("platform");

		if (platform != null) {
			setPlatform(platform);
		}

		String license = (String)attributes.get("license");

		if (license != null) {
			setLicense(license);
		}

		String toolDescription = (String)attributes.get("toolDescription");

		if (toolDescription != null) {
			setToolDescription(toolDescription);
		}

		String logourl = (String)attributes.get("logourl");

		if (logourl != null) {
			setLogourl(logourl);
		}
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.DockerContainer toEscapedModel() {
		return new DockerContainerWrapper(_dockerContainer.toEscapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.DockerContainer toUnescapedModel() {
		return new DockerContainerWrapper(_dockerContainer.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _dockerContainer.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _dockerContainer.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _dockerContainer.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _dockerContainer.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.bibbox.liferay.portlet.model.DockerContainer> toCacheModel() {
		return _dockerContainer.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.liferay.portlet.model.DockerContainer dockerContainer) {
		return _dockerContainer.compareTo(dockerContainer);
	}

	@Override
	public int hashCode() {
		return _dockerContainer.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dockerContainer.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new DockerContainerWrapper((DockerContainer)_dockerContainer.clone());
	}

	/**
	* Returns the category of this docker container.
	*
	* @return the category of this docker container
	*/
	@Override
	public java.lang.String getCategory() {
		return _dockerContainer.getCategory();
	}

	/**
	* Returns the company of this docker container.
	*
	* @return the company of this docker container
	*/
	@Override
	public java.lang.String getCompany() {
		return _dockerContainer.getCompany();
	}

	/**
	* Returns the description of this docker container.
	*
	* @return the description of this docker container
	*/
	@Override
	public java.lang.String getDescription() {
		return _dockerContainer.getDescription();
	}

	/**
	* Returns the display name of this docker container.
	*
	* @return the display name of this docker container
	*/
	@Override
	public java.lang.String getDisplayName() {
		return _dockerContainer.getDisplayName();
	}

	/**
	* Returns the display tool name of this docker container.
	*
	* @return the display tool name of this docker container
	*/
	@Override
	public java.lang.String getDisplayToolName() {
		return _dockerContainer.getDisplayToolName();
	}

	/**
	* Returns the instance of this docker container.
	*
	* @return the instance of this docker container
	*/
	@Override
	public java.lang.String getInstance() {
		return _dockerContainer.getInstance();
	}

	/**
	* Returns the ip of this docker container.
	*
	* @return the ip of this docker container
	*/
	@Override
	public java.lang.String getIp() {
		return _dockerContainer.getIp();
	}

	/**
	* Returns the license of this docker container.
	*
	* @return the license of this docker container
	*/
	@Override
	public java.lang.String getLicense() {
		return _dockerContainer.getLicense();
	}

	/**
	* Returns the logourl of this docker container.
	*
	* @return the logourl of this docker container
	*/
	@Override
	public java.lang.String getLogourl() {
		return _dockerContainer.getLogourl();
	}

	/**
	* Returns the platform of this docker container.
	*
	* @return the platform of this docker container
	*/
	@Override
	public java.lang.String getPlatform() {
		return _dockerContainer.getPlatform();
	}

	/**
	* Returns the port of this docker container.
	*
	* @return the port of this docker container
	*/
	@Override
	public java.lang.String getPort() {
		return _dockerContainer.getPort();
	}

	/**
	* Returns the start command of this docker container.
	*
	* @return the start command of this docker container
	*/
	@Override
	public java.lang.String getStartCommand() {
		return _dockerContainer.getStartCommand();
	}

	/**
	* Returns the subdomain of this docker container.
	*
	* @return the subdomain of this docker container
	*/
	@Override
	public java.lang.String getSubdomain() {
		return _dockerContainer.getSubdomain();
	}

	/**
	* Returns the tool of this docker container.
	*
	* @return the tool of this docker container
	*/
	@Override
	public java.lang.String getTool() {
		return _dockerContainer.getTool();
	}

	/**
	* Returns the tool description of this docker container.
	*
	* @return the tool description of this docker container
	*/
	@Override
	public java.lang.String getToolDescription() {
		return _dockerContainer.getToolDescription();
	}

	/**
	* Returns the tool name of this docker container.
	*
	* @return the tool name of this docker container
	*/
	@Override
	public java.lang.String getToolName() {
		return _dockerContainer.getToolName();
	}

	/**
	* Returns the url of this docker container.
	*
	* @return the url of this docker container
	*/
	@Override
	public java.lang.String getUrl() {
		return _dockerContainer.getUrl();
	}

	/**
	* Returns the user name of this docker container.
	*
	* @return the user name of this docker container
	*/
	@Override
	public java.lang.String getUserName() {
		return _dockerContainer.getUserName();
	}

	/**
	* Returns the user uuid of this docker container.
	*
	* @return the user uuid of this docker container
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _dockerContainer.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _dockerContainer.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dockerContainer.toXmlString();
	}

	/**
	* Returns the create date of this docker container.
	*
	* @return the create date of this docker container
	*/
	@Override
	public Date getCreateDate() {
		return _dockerContainer.getCreateDate();
	}

	/**
	* Returns the modified date of this docker container.
	*
	* @return the modified date of this docker container
	*/
	@Override
	public Date getModifiedDate() {
		return _dockerContainer.getModifiedDate();
	}

	/**
	* Returns the company ID of this docker container.
	*
	* @return the company ID of this docker container
	*/
	@Override
	public long getCompanyId() {
		return _dockerContainer.getCompanyId();
	}

	/**
	* Returns the docker container ID of this docker container.
	*
	* @return the docker container ID of this docker container
	*/
	@Override
	public long getDockerContainerId() {
		return _dockerContainer.getDockerContainerId();
	}

	/**
	* Returns the group ID of this docker container.
	*
	* @return the group ID of this docker container
	*/
	@Override
	public long getGroupId() {
		return _dockerContainer.getGroupId();
	}

	/**
	* Returns the primary key of this docker container.
	*
	* @return the primary key of this docker container
	*/
	@Override
	public long getPrimaryKey() {
		return _dockerContainer.getPrimaryKey();
	}

	/**
	* Returns the user ID of this docker container.
	*
	* @return the user ID of this docker container
	*/
	@Override
	public long getUserId() {
		return _dockerContainer.getUserId();
	}

	@Override
	public void persist() {
		_dockerContainer.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dockerContainer.setCachedModel(cachedModel);
	}

	/**
	* Sets the category of this docker container.
	*
	* @param category the category of this docker container
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_dockerContainer.setCategory(category);
	}

	/**
	* Sets the company of this docker container.
	*
	* @param company the company of this docker container
	*/
	@Override
	public void setCompany(java.lang.String company) {
		_dockerContainer.setCompany(company);
	}

	/**
	* Sets the company ID of this docker container.
	*
	* @param companyId the company ID of this docker container
	*/
	@Override
	public void setCompanyId(long companyId) {
		_dockerContainer.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this docker container.
	*
	* @param createDate the create date of this docker container
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_dockerContainer.setCreateDate(createDate);
	}

	/**
	* Sets the description of this docker container.
	*
	* @param description the description of this docker container
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_dockerContainer.setDescription(description);
	}

	/**
	* Sets the display name of this docker container.
	*
	* @param displayName the display name of this docker container
	*/
	@Override
	public void setDisplayName(java.lang.String displayName) {
		_dockerContainer.setDisplayName(displayName);
	}

	/**
	* Sets the display tool name of this docker container.
	*
	* @param displayToolName the display tool name of this docker container
	*/
	@Override
	public void setDisplayToolName(java.lang.String displayToolName) {
		_dockerContainer.setDisplayToolName(displayToolName);
	}

	/**
	* Sets the docker container ID of this docker container.
	*
	* @param dockerContainerId the docker container ID of this docker container
	*/
	@Override
	public void setDockerContainerId(long dockerContainerId) {
		_dockerContainer.setDockerContainerId(dockerContainerId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_dockerContainer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_dockerContainer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_dockerContainer.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this docker container.
	*
	* @param groupId the group ID of this docker container
	*/
	@Override
	public void setGroupId(long groupId) {
		_dockerContainer.setGroupId(groupId);
	}

	/**
	* Sets the instance of this docker container.
	*
	* @param instance the instance of this docker container
	*/
	@Override
	public void setInstance(java.lang.String instance) {
		_dockerContainer.setInstance(instance);
	}

	/**
	* Sets the ip of this docker container.
	*
	* @param ip the ip of this docker container
	*/
	@Override
	public void setIp(java.lang.String ip) {
		_dockerContainer.setIp(ip);
	}

	/**
	* Sets the license of this docker container.
	*
	* @param license the license of this docker container
	*/
	@Override
	public void setLicense(java.lang.String license) {
		_dockerContainer.setLicense(license);
	}

	/**
	* Sets the logourl of this docker container.
	*
	* @param logourl the logourl of this docker container
	*/
	@Override
	public void setLogourl(java.lang.String logourl) {
		_dockerContainer.setLogourl(logourl);
	}

	/**
	* Sets the modified date of this docker container.
	*
	* @param modifiedDate the modified date of this docker container
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_dockerContainer.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_dockerContainer.setNew(n);
	}

	/**
	* Sets the platform of this docker container.
	*
	* @param platform the platform of this docker container
	*/
	@Override
	public void setPlatform(java.lang.String platform) {
		_dockerContainer.setPlatform(platform);
	}

	/**
	* Sets the port of this docker container.
	*
	* @param port the port of this docker container
	*/
	@Override
	public void setPort(java.lang.String port) {
		_dockerContainer.setPort(port);
	}

	/**
	* Sets the primary key of this docker container.
	*
	* @param primaryKey the primary key of this docker container
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dockerContainer.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_dockerContainer.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the start command of this docker container.
	*
	* @param startCommand the start command of this docker container
	*/
	@Override
	public void setStartCommand(java.lang.String startCommand) {
		_dockerContainer.setStartCommand(startCommand);
	}

	/**
	* Sets the subdomain of this docker container.
	*
	* @param subdomain the subdomain of this docker container
	*/
	@Override
	public void setSubdomain(java.lang.String subdomain) {
		_dockerContainer.setSubdomain(subdomain);
	}

	/**
	* Sets the tool of this docker container.
	*
	* @param tool the tool of this docker container
	*/
	@Override
	public void setTool(java.lang.String tool) {
		_dockerContainer.setTool(tool);
	}

	/**
	* Sets the tool description of this docker container.
	*
	* @param toolDescription the tool description of this docker container
	*/
	@Override
	public void setToolDescription(java.lang.String toolDescription) {
		_dockerContainer.setToolDescription(toolDescription);
	}

	/**
	* Sets the tool name of this docker container.
	*
	* @param toolName the tool name of this docker container
	*/
	@Override
	public void setToolName(java.lang.String toolName) {
		_dockerContainer.setToolName(toolName);
	}

	/**
	* Sets the url of this docker container.
	*
	* @param url the url of this docker container
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_dockerContainer.setUrl(url);
	}

	/**
	* Sets the user ID of this docker container.
	*
	* @param userId the user ID of this docker container
	*/
	@Override
	public void setUserId(long userId) {
		_dockerContainer.setUserId(userId);
	}

	/**
	* Sets the user name of this docker container.
	*
	* @param userName the user name of this docker container
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_dockerContainer.setUserName(userName);
	}

	/**
	* Sets the user uuid of this docker container.
	*
	* @param userUuid the user uuid of this docker container
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dockerContainer.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DockerContainerWrapper)) {
			return false;
		}

		DockerContainerWrapper dockerContainerWrapper = (DockerContainerWrapper)obj;

		if (Objects.equals(_dockerContainer,
					dockerContainerWrapper._dockerContainer)) {
			return true;
		}

		return false;
	}

	@Override
	public DockerContainer getWrappedModel() {
		return _dockerContainer;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _dockerContainer.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _dockerContainer.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_dockerContainer.resetOriginalValues();
	}

	private final DockerContainer _dockerContainer;
}