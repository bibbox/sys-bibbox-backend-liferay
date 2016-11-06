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
 * This class is a wrapper for {@link ApplicationInstancePort}.
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationInstancePort
 * @generated
 */
@ProviderType
public class ApplicationInstancePortWrapper implements ApplicationInstancePort,
	ModelWrapper<ApplicationInstancePort> {
	public ApplicationInstancePortWrapper(
		ApplicationInstancePort applicationInstancePort) {
		_applicationInstancePort = applicationInstancePort;
	}

	@Override
	public Class<?> getModelClass() {
		return ApplicationInstancePort.class;
	}

	@Override
	public String getModelClassName() {
		return ApplicationInstancePort.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("applicationInstancePortId",
			getApplicationInstancePortId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("port", getPort());
		attributes.put("primary", getPrimary());
		attributes.put("applicationInstanceId", getApplicationInstanceId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long applicationInstancePortId = (Long)attributes.get(
				"applicationInstancePortId");

		if (applicationInstancePortId != null) {
			setApplicationInstancePortId(applicationInstancePortId);
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

		Long port = (Long)attributes.get("port");

		if (port != null) {
			setPort(port);
		}

		Boolean primary = (Boolean)attributes.get("primary");

		if (primary != null) {
			setPrimary(primary);
		}

		Long applicationInstanceId = (Long)attributes.get(
				"applicationInstanceId");

		if (applicationInstanceId != null) {
			setApplicationInstanceId(applicationInstanceId);
		}
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort toEscapedModel() {
		return new ApplicationInstancePortWrapper(_applicationInstancePort.toEscapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort toUnescapedModel() {
		return new ApplicationInstancePortWrapper(_applicationInstancePort.toUnescapedModel());
	}

	/**
	* Returns the primary of this application instance port.
	*
	* @return the primary of this application instance port
	*/
	@Override
	public boolean getPrimary() {
		return _applicationInstancePort.getPrimary();
	}

	@Override
	public boolean isCachedModel() {
		return _applicationInstancePort.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _applicationInstancePort.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _applicationInstancePort.isNew();
	}

	/**
	* Returns <code>true</code> if this application instance port is primary.
	*
	* @return <code>true</code> if this application instance port is primary; <code>false</code> otherwise
	*/
	@Override
	public boolean isPrimary() {
		return _applicationInstancePort.isPrimary();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _applicationInstancePort.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort> toCacheModel() {
		return _applicationInstancePort.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort applicationInstancePort) {
		return _applicationInstancePort.compareTo(applicationInstancePort);
	}

	@Override
	public int hashCode() {
		return _applicationInstancePort.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _applicationInstancePort.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ApplicationInstancePortWrapper((ApplicationInstancePort)_applicationInstancePort.clone());
	}

	/**
	* Returns the user name of this application instance port.
	*
	* @return the user name of this application instance port
	*/
	@Override
	public java.lang.String getUserName() {
		return _applicationInstancePort.getUserName();
	}

	/**
	* Returns the user uuid of this application instance port.
	*
	* @return the user uuid of this application instance port
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _applicationInstancePort.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _applicationInstancePort.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _applicationInstancePort.toXmlString();
	}

	/**
	* Returns the create date of this application instance port.
	*
	* @return the create date of this application instance port
	*/
	@Override
	public Date getCreateDate() {
		return _applicationInstancePort.getCreateDate();
	}

	/**
	* Returns the modified date of this application instance port.
	*
	* @return the modified date of this application instance port
	*/
	@Override
	public Date getModifiedDate() {
		return _applicationInstancePort.getModifiedDate();
	}

	/**
	* Returns the application instance ID of this application instance port.
	*
	* @return the application instance ID of this application instance port
	*/
	@Override
	public long getApplicationInstanceId() {
		return _applicationInstancePort.getApplicationInstanceId();
	}

	/**
	* Returns the application instance port ID of this application instance port.
	*
	* @return the application instance port ID of this application instance port
	*/
	@Override
	public long getApplicationInstancePortId() {
		return _applicationInstancePort.getApplicationInstancePortId();
	}

	/**
	* Returns the company ID of this application instance port.
	*
	* @return the company ID of this application instance port
	*/
	@Override
	public long getCompanyId() {
		return _applicationInstancePort.getCompanyId();
	}

	/**
	* Returns the group ID of this application instance port.
	*
	* @return the group ID of this application instance port
	*/
	@Override
	public long getGroupId() {
		return _applicationInstancePort.getGroupId();
	}

	/**
	* Returns the port of this application instance port.
	*
	* @return the port of this application instance port
	*/
	@Override
	public long getPort() {
		return _applicationInstancePort.getPort();
	}

	/**
	* Returns the primary key of this application instance port.
	*
	* @return the primary key of this application instance port
	*/
	@Override
	public long getPrimaryKey() {
		return _applicationInstancePort.getPrimaryKey();
	}

	/**
	* Returns the user ID of this application instance port.
	*
	* @return the user ID of this application instance port
	*/
	@Override
	public long getUserId() {
		return _applicationInstancePort.getUserId();
	}

	@Override
	public void persist() {
		_applicationInstancePort.persist();
	}

	/**
	* Sets the application instance ID of this application instance port.
	*
	* @param applicationInstanceId the application instance ID of this application instance port
	*/
	@Override
	public void setApplicationInstanceId(long applicationInstanceId) {
		_applicationInstancePort.setApplicationInstanceId(applicationInstanceId);
	}

	/**
	* Sets the application instance port ID of this application instance port.
	*
	* @param applicationInstancePortId the application instance port ID of this application instance port
	*/
	@Override
	public void setApplicationInstancePortId(long applicationInstancePortId) {
		_applicationInstancePort.setApplicationInstancePortId(applicationInstancePortId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_applicationInstancePort.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this application instance port.
	*
	* @param companyId the company ID of this application instance port
	*/
	@Override
	public void setCompanyId(long companyId) {
		_applicationInstancePort.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this application instance port.
	*
	* @param createDate the create date of this application instance port
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_applicationInstancePort.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_applicationInstancePort.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_applicationInstancePort.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_applicationInstancePort.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this application instance port.
	*
	* @param groupId the group ID of this application instance port
	*/
	@Override
	public void setGroupId(long groupId) {
		_applicationInstancePort.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this application instance port.
	*
	* @param modifiedDate the modified date of this application instance port
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_applicationInstancePort.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_applicationInstancePort.setNew(n);
	}

	/**
	* Sets the port of this application instance port.
	*
	* @param port the port of this application instance port
	*/
	@Override
	public void setPort(long port) {
		_applicationInstancePort.setPort(port);
	}

	/**
	* Sets whether this application instance port is primary.
	*
	* @param primary the primary of this application instance port
	*/
	@Override
	public void setPrimary(boolean primary) {
		_applicationInstancePort.setPrimary(primary);
	}

	/**
	* Sets the primary key of this application instance port.
	*
	* @param primaryKey the primary key of this application instance port
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_applicationInstancePort.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_applicationInstancePort.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this application instance port.
	*
	* @param userId the user ID of this application instance port
	*/
	@Override
	public void setUserId(long userId) {
		_applicationInstancePort.setUserId(userId);
	}

	/**
	* Sets the user name of this application instance port.
	*
	* @param userName the user name of this application instance port
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_applicationInstancePort.setUserName(userName);
	}

	/**
	* Sets the user uuid of this application instance port.
	*
	* @param userUuid the user uuid of this application instance port
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_applicationInstancePort.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApplicationInstancePortWrapper)) {
			return false;
		}

		ApplicationInstancePortWrapper applicationInstancePortWrapper = (ApplicationInstancePortWrapper)obj;

		if (Objects.equals(_applicationInstancePort,
					applicationInstancePortWrapper._applicationInstancePort)) {
			return true;
		}

		return false;
	}

	@Override
	public ApplicationInstancePort getWrappedModel() {
		return _applicationInstancePort;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _applicationInstancePort.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _applicationInstancePort.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_applicationInstancePort.resetOriginalValues();
	}

	private final ApplicationInstancePort _applicationInstancePort;
}