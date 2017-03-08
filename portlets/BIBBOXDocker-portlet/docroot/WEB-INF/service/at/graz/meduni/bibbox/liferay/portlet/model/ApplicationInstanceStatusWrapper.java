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
 * This class is a wrapper for {@link ApplicationInstanceStatus}.
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationInstanceStatus
 * @generated
 */
@ProviderType
public class ApplicationInstanceStatusWrapper
	implements ApplicationInstanceStatus,
		ModelWrapper<ApplicationInstanceStatus> {
	public ApplicationInstanceStatusWrapper(
		ApplicationInstanceStatus applicationInstanceStatus) {
		_applicationInstanceStatus = applicationInstanceStatus;
	}

	@Override
	public Class<?> getModelClass() {
		return ApplicationInstanceStatus.class;
	}

	@Override
	public String getModelClassName() {
		return ApplicationInstanceStatus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("applicationInstanceStatusId",
			getApplicationInstanceStatusId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("applicationInstanceId", getApplicationInstanceId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long applicationInstanceStatusId = (Long)attributes.get(
				"applicationInstanceStatusId");

		if (applicationInstanceStatusId != null) {
			setApplicationInstanceStatusId(applicationInstanceStatusId);
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

		Long applicationInstanceId = (Long)attributes.get(
				"applicationInstanceId");

		if (applicationInstanceId != null) {
			setApplicationInstanceId(applicationInstanceId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus toEscapedModel() {
		return new ApplicationInstanceStatusWrapper(_applicationInstanceStatus.toEscapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus toUnescapedModel() {
		return new ApplicationInstanceStatusWrapper(_applicationInstanceStatus.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _applicationInstanceStatus.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _applicationInstanceStatus.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _applicationInstanceStatus.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _applicationInstanceStatus.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus> toCacheModel() {
		return _applicationInstanceStatus.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus applicationInstanceStatus) {
		return _applicationInstanceStatus.compareTo(applicationInstanceStatus);
	}

	@Override
	public int hashCode() {
		return _applicationInstanceStatus.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _applicationInstanceStatus.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ApplicationInstanceStatusWrapper((ApplicationInstanceStatus)_applicationInstanceStatus.clone());
	}

	/**
	* Returns the status of this application instance status.
	*
	* @return the status of this application instance status
	*/
	@Override
	public java.lang.String getStatus() {
		return _applicationInstanceStatus.getStatus();
	}

	/**
	* Returns the user name of this application instance status.
	*
	* @return the user name of this application instance status
	*/
	@Override
	public java.lang.String getUserName() {
		return _applicationInstanceStatus.getUserName();
	}

	/**
	* Returns the user uuid of this application instance status.
	*
	* @return the user uuid of this application instance status
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _applicationInstanceStatus.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _applicationInstanceStatus.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _applicationInstanceStatus.toXmlString();
	}

	/**
	* Returns the create date of this application instance status.
	*
	* @return the create date of this application instance status
	*/
	@Override
	public Date getCreateDate() {
		return _applicationInstanceStatus.getCreateDate();
	}

	/**
	* Returns the modified date of this application instance status.
	*
	* @return the modified date of this application instance status
	*/
	@Override
	public Date getModifiedDate() {
		return _applicationInstanceStatus.getModifiedDate();
	}

	/**
	* Returns the application instance ID of this application instance status.
	*
	* @return the application instance ID of this application instance status
	*/
	@Override
	public long getApplicationInstanceId() {
		return _applicationInstanceStatus.getApplicationInstanceId();
	}

	/**
	* Returns the application instance status ID of this application instance status.
	*
	* @return the application instance status ID of this application instance status
	*/
	@Override
	public long getApplicationInstanceStatusId() {
		return _applicationInstanceStatus.getApplicationInstanceStatusId();
	}

	/**
	* Returns the company ID of this application instance status.
	*
	* @return the company ID of this application instance status
	*/
	@Override
	public long getCompanyId() {
		return _applicationInstanceStatus.getCompanyId();
	}

	/**
	* Returns the group ID of this application instance status.
	*
	* @return the group ID of this application instance status
	*/
	@Override
	public long getGroupId() {
		return _applicationInstanceStatus.getGroupId();
	}

	/**
	* Returns the primary key of this application instance status.
	*
	* @return the primary key of this application instance status
	*/
	@Override
	public long getPrimaryKey() {
		return _applicationInstanceStatus.getPrimaryKey();
	}

	/**
	* Returns the user ID of this application instance status.
	*
	* @return the user ID of this application instance status
	*/
	@Override
	public long getUserId() {
		return _applicationInstanceStatus.getUserId();
	}

	@Override
	public void persist() {
		_applicationInstanceStatus.persist();
	}

	/**
	* Sets the application instance ID of this application instance status.
	*
	* @param applicationInstanceId the application instance ID of this application instance status
	*/
	@Override
	public void setApplicationInstanceId(long applicationInstanceId) {
		_applicationInstanceStatus.setApplicationInstanceId(applicationInstanceId);
	}

	/**
	* Sets the application instance status ID of this application instance status.
	*
	* @param applicationInstanceStatusId the application instance status ID of this application instance status
	*/
	@Override
	public void setApplicationInstanceStatusId(long applicationInstanceStatusId) {
		_applicationInstanceStatus.setApplicationInstanceStatusId(applicationInstanceStatusId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_applicationInstanceStatus.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this application instance status.
	*
	* @param companyId the company ID of this application instance status
	*/
	@Override
	public void setCompanyId(long companyId) {
		_applicationInstanceStatus.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this application instance status.
	*
	* @param createDate the create date of this application instance status
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_applicationInstanceStatus.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_applicationInstanceStatus.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_applicationInstanceStatus.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_applicationInstanceStatus.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this application instance status.
	*
	* @param groupId the group ID of this application instance status
	*/
	@Override
	public void setGroupId(long groupId) {
		_applicationInstanceStatus.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this application instance status.
	*
	* @param modifiedDate the modified date of this application instance status
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_applicationInstanceStatus.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_applicationInstanceStatus.setNew(n);
	}

	/**
	* Sets the primary key of this application instance status.
	*
	* @param primaryKey the primary key of this application instance status
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_applicationInstanceStatus.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_applicationInstanceStatus.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this application instance status.
	*
	* @param status the status of this application instance status
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_applicationInstanceStatus.setStatus(status);
	}

	/**
	* Sets the user ID of this application instance status.
	*
	* @param userId the user ID of this application instance status
	*/
	@Override
	public void setUserId(long userId) {
		_applicationInstanceStatus.setUserId(userId);
	}

	/**
	* Sets the user name of this application instance status.
	*
	* @param userName the user name of this application instance status
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_applicationInstanceStatus.setUserName(userName);
	}

	/**
	* Sets the user uuid of this application instance status.
	*
	* @param userUuid the user uuid of this application instance status
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_applicationInstanceStatus.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApplicationInstanceStatusWrapper)) {
			return false;
		}

		ApplicationInstanceStatusWrapper applicationInstanceStatusWrapper = (ApplicationInstanceStatusWrapper)obj;

		if (Objects.equals(_applicationInstanceStatus,
					applicationInstanceStatusWrapper._applicationInstanceStatus)) {
			return true;
		}

		return false;
	}

	@Override
	public ApplicationInstanceStatus getWrappedModel() {
		return _applicationInstanceStatus;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _applicationInstanceStatus.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _applicationInstanceStatus.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_applicationInstanceStatus.resetOriginalValues();
	}

	private final ApplicationInstanceStatus _applicationInstanceStatus;
}