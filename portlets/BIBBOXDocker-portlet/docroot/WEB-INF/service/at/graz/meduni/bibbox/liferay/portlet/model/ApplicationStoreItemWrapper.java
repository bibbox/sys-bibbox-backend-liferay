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
 * This class is a wrapper for {@link ApplicationStoreItem}.
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationStoreItem
 * @generated
 */
@ProviderType
public class ApplicationStoreItemWrapper implements ApplicationStoreItem,
	ModelWrapper<ApplicationStoreItem> {
	public ApplicationStoreItemWrapper(
		ApplicationStoreItem applicationStoreItem) {
		_applicationStoreItem = applicationStoreItem;
	}

	@Override
	public Class<?> getModelClass() {
		return ApplicationStoreItem.class;
	}

	@Override
	public String getModelClassName() {
		return ApplicationStoreItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("applicationStoreItemId", getApplicationStoreItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("githash", getGithash());
		attributes.put("depreciated", getDepreciated());
		attributes.put("applicationFolderName", getApplicationFolderName());
		attributes.put("applicationName", getApplicationName());
		attributes.put("applicationShortName", getApplicationShortName());
		attributes.put("applicationVersion", getApplicationVersion());
		attributes.put("applicationReleaseState", getApplicationReleaseState());
		attributes.put("applicationDescription", getApplicationDescription());
		attributes.put("applicationCatalogueUrl", getApplicationCatalogueUrl());
		attributes.put("applicationApplicationUrl",
			getApplicationApplicationUrl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long applicationStoreItemId = (Long)attributes.get(
				"applicationStoreItemId");

		if (applicationStoreItemId != null) {
			setApplicationStoreItemId(applicationStoreItemId);
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

		String githash = (String)attributes.get("githash");

		if (githash != null) {
			setGithash(githash);
		}

		Boolean depreciated = (Boolean)attributes.get("depreciated");

		if (depreciated != null) {
			setDepreciated(depreciated);
		}

		String applicationFolderName = (String)attributes.get(
				"applicationFolderName");

		if (applicationFolderName != null) {
			setApplicationFolderName(applicationFolderName);
		}

		String applicationName = (String)attributes.get("applicationName");

		if (applicationName != null) {
			setApplicationName(applicationName);
		}

		String applicationShortName = (String)attributes.get(
				"applicationShortName");

		if (applicationShortName != null) {
			setApplicationShortName(applicationShortName);
		}

		String applicationVersion = (String)attributes.get("applicationVersion");

		if (applicationVersion != null) {
			setApplicationVersion(applicationVersion);
		}

		String applicationReleaseState = (String)attributes.get(
				"applicationReleaseState");

		if (applicationReleaseState != null) {
			setApplicationReleaseState(applicationReleaseState);
		}

		String applicationDescription = (String)attributes.get(
				"applicationDescription");

		if (applicationDescription != null) {
			setApplicationDescription(applicationDescription);
		}

		String applicationCatalogueUrl = (String)attributes.get(
				"applicationCatalogueUrl");

		if (applicationCatalogueUrl != null) {
			setApplicationCatalogueUrl(applicationCatalogueUrl);
		}

		String applicationApplicationUrl = (String)attributes.get(
				"applicationApplicationUrl");

		if (applicationApplicationUrl != null) {
			setApplicationApplicationUrl(applicationApplicationUrl);
		}
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationStoreItem toEscapedModel() {
		return new ApplicationStoreItemWrapper(_applicationStoreItem.toEscapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationStoreItem toUnescapedModel() {
		return new ApplicationStoreItemWrapper(_applicationStoreItem.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _applicationStoreItem.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _applicationStoreItem.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _applicationStoreItem.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _applicationStoreItem.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationStoreItem> toCacheModel() {
		return _applicationStoreItem.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.liferay.portlet.model.ApplicationStoreItem applicationStoreItem) {
		return _applicationStoreItem.compareTo(applicationStoreItem);
	}

	@Override
	public int hashCode() {
		return _applicationStoreItem.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _applicationStoreItem.getPrimaryKeyObj();
	}

	/**
	* Returns the depreciated of this application store item.
	*
	* @return the depreciated of this application store item
	*/
	@Override
	public java.lang.Boolean getDepreciated() {
		return _applicationStoreItem.getDepreciated();
	}

	@Override
	public java.lang.Object clone() {
		return new ApplicationStoreItemWrapper((ApplicationStoreItem)_applicationStoreItem.clone());
	}

	/**
	* Returns the application application url of this application store item.
	*
	* @return the application application url of this application store item
	*/
	@Override
	public java.lang.String getApplicationApplicationUrl() {
		return _applicationStoreItem.getApplicationApplicationUrl();
	}

	/**
	* Returns the application catalogue url of this application store item.
	*
	* @return the application catalogue url of this application store item
	*/
	@Override
	public java.lang.String getApplicationCatalogueUrl() {
		return _applicationStoreItem.getApplicationCatalogueUrl();
	}

	/**
	* Returns the application description of this application store item.
	*
	* @return the application description of this application store item
	*/
	@Override
	public java.lang.String getApplicationDescription() {
		return _applicationStoreItem.getApplicationDescription();
	}

	/**
	* Returns the application folder name of this application store item.
	*
	* @return the application folder name of this application store item
	*/
	@Override
	public java.lang.String getApplicationFolderName() {
		return _applicationStoreItem.getApplicationFolderName();
	}

	/**
	* Returns the application name of this application store item.
	*
	* @return the application name of this application store item
	*/
	@Override
	public java.lang.String getApplicationName() {
		return _applicationStoreItem.getApplicationName();
	}

	/**
	* Returns the application release state of this application store item.
	*
	* @return the application release state of this application store item
	*/
	@Override
	public java.lang.String getApplicationReleaseState() {
		return _applicationStoreItem.getApplicationReleaseState();
	}

	/**
	* Returns the application short name of this application store item.
	*
	* @return the application short name of this application store item
	*/
	@Override
	public java.lang.String getApplicationShortName() {
		return _applicationStoreItem.getApplicationShortName();
	}

	/**
	* Returns the application version of this application store item.
	*
	* @return the application version of this application store item
	*/
	@Override
	public java.lang.String getApplicationVersion() {
		return _applicationStoreItem.getApplicationVersion();
	}

	/**
	* Returns the githash of this application store item.
	*
	* @return the githash of this application store item
	*/
	@Override
	public java.lang.String getGithash() {
		return _applicationStoreItem.getGithash();
	}

	/**
	* Returns the user name of this application store item.
	*
	* @return the user name of this application store item
	*/
	@Override
	public java.lang.String getUserName() {
		return _applicationStoreItem.getUserName();
	}

	/**
	* Returns the user uuid of this application store item.
	*
	* @return the user uuid of this application store item
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _applicationStoreItem.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _applicationStoreItem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _applicationStoreItem.toXmlString();
	}

	/**
	* Returns the create date of this application store item.
	*
	* @return the create date of this application store item
	*/
	@Override
	public Date getCreateDate() {
		return _applicationStoreItem.getCreateDate();
	}

	/**
	* Returns the modified date of this application store item.
	*
	* @return the modified date of this application store item
	*/
	@Override
	public Date getModifiedDate() {
		return _applicationStoreItem.getModifiedDate();
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag> getApplicationTags() {
		return _applicationStoreItem.getApplicationTags();
	}

	/**
	* Returns the application store item ID of this application store item.
	*
	* @return the application store item ID of this application store item
	*/
	@Override
	public long getApplicationStoreItemId() {
		return _applicationStoreItem.getApplicationStoreItemId();
	}

	/**
	* Returns the company ID of this application store item.
	*
	* @return the company ID of this application store item
	*/
	@Override
	public long getCompanyId() {
		return _applicationStoreItem.getCompanyId();
	}

	/**
	* Returns the group ID of this application store item.
	*
	* @return the group ID of this application store item
	*/
	@Override
	public long getGroupId() {
		return _applicationStoreItem.getGroupId();
	}

	/**
	* Returns the primary key of this application store item.
	*
	* @return the primary key of this application store item
	*/
	@Override
	public long getPrimaryKey() {
		return _applicationStoreItem.getPrimaryKey();
	}

	/**
	* Returns the user ID of this application store item.
	*
	* @return the user ID of this application store item
	*/
	@Override
	public long getUserId() {
		return _applicationStoreItem.getUserId();
	}

	@Override
	public void persist() {
		_applicationStoreItem.persist();
	}

	/**
	* Sets the application application url of this application store item.
	*
	* @param applicationApplicationUrl the application application url of this application store item
	*/
	@Override
	public void setApplicationApplicationUrl(
		java.lang.String applicationApplicationUrl) {
		_applicationStoreItem.setApplicationApplicationUrl(applicationApplicationUrl);
	}

	/**
	* Sets the application catalogue url of this application store item.
	*
	* @param applicationCatalogueUrl the application catalogue url of this application store item
	*/
	@Override
	public void setApplicationCatalogueUrl(
		java.lang.String applicationCatalogueUrl) {
		_applicationStoreItem.setApplicationCatalogueUrl(applicationCatalogueUrl);
	}

	/**
	* Sets the application description of this application store item.
	*
	* @param applicationDescription the application description of this application store item
	*/
	@Override
	public void setApplicationDescription(
		java.lang.String applicationDescription) {
		_applicationStoreItem.setApplicationDescription(applicationDescription);
	}

	/**
	* Sets the application folder name of this application store item.
	*
	* @param applicationFolderName the application folder name of this application store item
	*/
	@Override
	public void setApplicationFolderName(java.lang.String applicationFolderName) {
		_applicationStoreItem.setApplicationFolderName(applicationFolderName);
	}

	/**
	* Sets the application name of this application store item.
	*
	* @param applicationName the application name of this application store item
	*/
	@Override
	public void setApplicationName(java.lang.String applicationName) {
		_applicationStoreItem.setApplicationName(applicationName);
	}

	/**
	* Sets the application release state of this application store item.
	*
	* @param applicationReleaseState the application release state of this application store item
	*/
	@Override
	public void setApplicationReleaseState(
		java.lang.String applicationReleaseState) {
		_applicationStoreItem.setApplicationReleaseState(applicationReleaseState);
	}

	/**
	* Sets the application short name of this application store item.
	*
	* @param applicationShortName the application short name of this application store item
	*/
	@Override
	public void setApplicationShortName(java.lang.String applicationShortName) {
		_applicationStoreItem.setApplicationShortName(applicationShortName);
	}

	/**
	* Sets the application store item ID of this application store item.
	*
	* @param applicationStoreItemId the application store item ID of this application store item
	*/
	@Override
	public void setApplicationStoreItemId(long applicationStoreItemId) {
		_applicationStoreItem.setApplicationStoreItemId(applicationStoreItemId);
	}

	/**
	* Sets the application version of this application store item.
	*
	* @param applicationVersion the application version of this application store item
	*/
	@Override
	public void setApplicationVersion(java.lang.String applicationVersion) {
		_applicationStoreItem.setApplicationVersion(applicationVersion);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_applicationStoreItem.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this application store item.
	*
	* @param companyId the company ID of this application store item
	*/
	@Override
	public void setCompanyId(long companyId) {
		_applicationStoreItem.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this application store item.
	*
	* @param createDate the create date of this application store item
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_applicationStoreItem.setCreateDate(createDate);
	}

	/**
	* Sets the depreciated of this application store item.
	*
	* @param depreciated the depreciated of this application store item
	*/
	@Override
	public void setDepreciated(java.lang.Boolean depreciated) {
		_applicationStoreItem.setDepreciated(depreciated);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_applicationStoreItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_applicationStoreItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_applicationStoreItem.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the githash of this application store item.
	*
	* @param githash the githash of this application store item
	*/
	@Override
	public void setGithash(java.lang.String githash) {
		_applicationStoreItem.setGithash(githash);
	}

	/**
	* Sets the group ID of this application store item.
	*
	* @param groupId the group ID of this application store item
	*/
	@Override
	public void setGroupId(long groupId) {
		_applicationStoreItem.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this application store item.
	*
	* @param modifiedDate the modified date of this application store item
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_applicationStoreItem.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_applicationStoreItem.setNew(n);
	}

	/**
	* Sets the primary key of this application store item.
	*
	* @param primaryKey the primary key of this application store item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_applicationStoreItem.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_applicationStoreItem.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this application store item.
	*
	* @param userId the user ID of this application store item
	*/
	@Override
	public void setUserId(long userId) {
		_applicationStoreItem.setUserId(userId);
	}

	/**
	* Sets the user name of this application store item.
	*
	* @param userName the user name of this application store item
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_applicationStoreItem.setUserName(userName);
	}

	/**
	* Sets the user uuid of this application store item.
	*
	* @param userUuid the user uuid of this application store item
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_applicationStoreItem.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApplicationStoreItemWrapper)) {
			return false;
		}

		ApplicationStoreItemWrapper applicationStoreItemWrapper = (ApplicationStoreItemWrapper)obj;

		if (Objects.equals(_applicationStoreItem,
					applicationStoreItemWrapper._applicationStoreItem)) {
			return true;
		}

		return false;
	}

	@Override
	public ApplicationStoreItem getWrappedModel() {
		return _applicationStoreItem;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _applicationStoreItem.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _applicationStoreItem.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_applicationStoreItem.resetOriginalValues();
	}

	private final ApplicationStoreItem _applicationStoreItem;
}