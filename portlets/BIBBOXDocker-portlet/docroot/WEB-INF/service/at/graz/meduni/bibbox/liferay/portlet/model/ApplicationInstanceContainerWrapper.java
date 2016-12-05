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
 * This class is a wrapper for {@link ApplicationInstanceContainer}.
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationInstanceContainer
 * @generated
 */
@ProviderType
public class ApplicationInstanceContainerWrapper
	implements ApplicationInstanceContainer,
		ModelWrapper<ApplicationInstanceContainer> {
	public ApplicationInstanceContainerWrapper(
		ApplicationInstanceContainer applicationInstanceContainer) {
		_applicationInstanceContainer = applicationInstanceContainer;
	}

	@Override
	public Class<?> getModelClass() {
		return ApplicationInstanceContainer.class;
	}

	@Override
	public String getModelClassName() {
		return ApplicationInstanceContainer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("applicationInstanceContainerId",
			getApplicationInstanceContainerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("containerName", getContainerName());
		attributes.put("needrunning", getNeedrunning());
		attributes.put("running", getRunning());
		attributes.put("applicationInstanceId", getApplicationInstanceId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long applicationInstanceContainerId = (Long)attributes.get(
				"applicationInstanceContainerId");

		if (applicationInstanceContainerId != null) {
			setApplicationInstanceContainerId(applicationInstanceContainerId);
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

		String containerName = (String)attributes.get("containerName");

		if (containerName != null) {
			setContainerName(containerName);
		}

		Boolean needrunning = (Boolean)attributes.get("needrunning");

		if (needrunning != null) {
			setNeedrunning(needrunning);
		}

		Boolean running = (Boolean)attributes.get("running");

		if (running != null) {
			setRunning(running);
		}

		Long applicationInstanceId = (Long)attributes.get(
				"applicationInstanceId");

		if (applicationInstanceId != null) {
			setApplicationInstanceId(applicationInstanceId);
		}
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer toEscapedModel() {
		return new ApplicationInstanceContainerWrapper(_applicationInstanceContainer.toEscapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer toUnescapedModel() {
		return new ApplicationInstanceContainerWrapper(_applicationInstanceContainer.toUnescapedModel());
	}

	@Override
	public boolean ApplicationInstanceExists() {
		return _applicationInstanceContainer.ApplicationInstanceExists();
	}

	/**
	* Returns the needrunning of this application instance container.
	*
	* @return the needrunning of this application instance container
	*/
	@Override
	public boolean getNeedrunning() {
		return _applicationInstanceContainer.getNeedrunning();
	}

	/**
	* Returns the running of this application instance container.
	*
	* @return the running of this application instance container
	*/
	@Override
	public boolean getRunning() {
		return _applicationInstanceContainer.getRunning();
	}

	@Override
	public boolean isCachedModel() {
		return _applicationInstanceContainer.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _applicationInstanceContainer.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this application instance container is needrunning.
	*
	* @return <code>true</code> if this application instance container is needrunning; <code>false</code> otherwise
	*/
	@Override
	public boolean isNeedrunning() {
		return _applicationInstanceContainer.isNeedrunning();
	}

	@Override
	public boolean isNew() {
		return _applicationInstanceContainer.isNew();
	}

	/**
	* Returns <code>true</code> if this application instance container is running.
	*
	* @return <code>true</code> if this application instance container is running; <code>false</code> otherwise
	*/
	@Override
	public boolean isRunning() {
		return _applicationInstanceContainer.isRunning();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _applicationInstanceContainer.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getContainerLog(
		java.lang.String lines) {
		return _applicationInstanceContainer.getContainerLog(lines);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer> toCacheModel() {
		return _applicationInstanceContainer.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer applicationInstanceContainer) {
		return _applicationInstanceContainer.compareTo(applicationInstanceContainer);
	}

	@Override
	public int hashCode() {
		return _applicationInstanceContainer.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _applicationInstanceContainer.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ApplicationInstanceContainerWrapper((ApplicationInstanceContainer)_applicationInstanceContainer.clone());
	}

	/**
	* Returns the container name of this application instance container.
	*
	* @return the container name of this application instance container
	*/
	@Override
	public java.lang.String getContainerName() {
		return _applicationInstanceContainer.getContainerName();
	}

	/**
	* Returns the user name of this application instance container.
	*
	* @return the user name of this application instance container
	*/
	@Override
	public java.lang.String getUserName() {
		return _applicationInstanceContainer.getUserName();
	}

	/**
	* Returns the user uuid of this application instance container.
	*
	* @return the user uuid of this application instance container
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _applicationInstanceContainer.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _applicationInstanceContainer.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _applicationInstanceContainer.toXmlString();
	}

	/**
	* Returns the create date of this application instance container.
	*
	* @return the create date of this application instance container
	*/
	@Override
	public Date getCreateDate() {
		return _applicationInstanceContainer.getCreateDate();
	}

	/**
	* Returns the modified date of this application instance container.
	*
	* @return the modified date of this application instance container
	*/
	@Override
	public Date getModifiedDate() {
		return _applicationInstanceContainer.getModifiedDate();
	}

	/**
	* Returns the application instance container ID of this application instance container.
	*
	* @return the application instance container ID of this application instance container
	*/
	@Override
	public long getApplicationInstanceContainerId() {
		return _applicationInstanceContainer.getApplicationInstanceContainerId();
	}

	/**
	* Returns the application instance ID of this application instance container.
	*
	* @return the application instance ID of this application instance container
	*/
	@Override
	public long getApplicationInstanceId() {
		return _applicationInstanceContainer.getApplicationInstanceId();
	}

	/**
	* Returns the company ID of this application instance container.
	*
	* @return the company ID of this application instance container
	*/
	@Override
	public long getCompanyId() {
		return _applicationInstanceContainer.getCompanyId();
	}

	/**
	* Returns the group ID of this application instance container.
	*
	* @return the group ID of this application instance container
	*/
	@Override
	public long getGroupId() {
		return _applicationInstanceContainer.getGroupId();
	}

	/**
	* Returns the primary key of this application instance container.
	*
	* @return the primary key of this application instance container
	*/
	@Override
	public long getPrimaryKey() {
		return _applicationInstanceContainer.getPrimaryKey();
	}

	/**
	* Returns the user ID of this application instance container.
	*
	* @return the user ID of this application instance container
	*/
	@Override
	public long getUserId() {
		return _applicationInstanceContainer.getUserId();
	}

	@Override
	public void persist() {
		_applicationInstanceContainer.persist();
	}

	/**
	* Sets the application instance container ID of this application instance container.
	*
	* @param applicationInstanceContainerId the application instance container ID of this application instance container
	*/
	@Override
	public void setApplicationInstanceContainerId(
		long applicationInstanceContainerId) {
		_applicationInstanceContainer.setApplicationInstanceContainerId(applicationInstanceContainerId);
	}

	/**
	* Sets the application instance ID of this application instance container.
	*
	* @param applicationInstanceId the application instance ID of this application instance container
	*/
	@Override
	public void setApplicationInstanceId(long applicationInstanceId) {
		_applicationInstanceContainer.setApplicationInstanceId(applicationInstanceId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_applicationInstanceContainer.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this application instance container.
	*
	* @param companyId the company ID of this application instance container
	*/
	@Override
	public void setCompanyId(long companyId) {
		_applicationInstanceContainer.setCompanyId(companyId);
	}

	/**
	* Sets the container name of this application instance container.
	*
	* @param containerName the container name of this application instance container
	*/
	@Override
	public void setContainerName(java.lang.String containerName) {
		_applicationInstanceContainer.setContainerName(containerName);
	}

	/**
	* Sets the create date of this application instance container.
	*
	* @param createDate the create date of this application instance container
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_applicationInstanceContainer.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_applicationInstanceContainer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_applicationInstanceContainer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_applicationInstanceContainer.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this application instance container.
	*
	* @param groupId the group ID of this application instance container
	*/
	@Override
	public void setGroupId(long groupId) {
		_applicationInstanceContainer.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this application instance container.
	*
	* @param modifiedDate the modified date of this application instance container
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_applicationInstanceContainer.setModifiedDate(modifiedDate);
	}

	/**
	* Sets whether this application instance container is needrunning.
	*
	* @param needrunning the needrunning of this application instance container
	*/
	@Override
	public void setNeedrunning(boolean needrunning) {
		_applicationInstanceContainer.setNeedrunning(needrunning);
	}

	@Override
	public void setNew(boolean n) {
		_applicationInstanceContainer.setNew(n);
	}

	/**
	* Sets the primary key of this application instance container.
	*
	* @param primaryKey the primary key of this application instance container
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_applicationInstanceContainer.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_applicationInstanceContainer.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets whether this application instance container is running.
	*
	* @param running the running of this application instance container
	*/
	@Override
	public void setRunning(boolean running) {
		_applicationInstanceContainer.setRunning(running);
	}

	/**
	* Sets the user ID of this application instance container.
	*
	* @param userId the user ID of this application instance container
	*/
	@Override
	public void setUserId(long userId) {
		_applicationInstanceContainer.setUserId(userId);
	}

	/**
	* Sets the user name of this application instance container.
	*
	* @param userName the user name of this application instance container
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_applicationInstanceContainer.setUserName(userName);
	}

	/**
	* Sets the user uuid of this application instance container.
	*
	* @param userUuid the user uuid of this application instance container
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_applicationInstanceContainer.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApplicationInstanceContainerWrapper)) {
			return false;
		}

		ApplicationInstanceContainerWrapper applicationInstanceContainerWrapper = (ApplicationInstanceContainerWrapper)obj;

		if (Objects.equals(_applicationInstanceContainer,
					applicationInstanceContainerWrapper._applicationInstanceContainer)) {
			return true;
		}

		return false;
	}

	@Override
	public ApplicationInstanceContainer getWrappedModel() {
		return _applicationInstanceContainer;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _applicationInstanceContainer.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _applicationInstanceContainer.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_applicationInstanceContainer.resetOriginalValues();
	}

	private final ApplicationInstanceContainer _applicationInstanceContainer;
}