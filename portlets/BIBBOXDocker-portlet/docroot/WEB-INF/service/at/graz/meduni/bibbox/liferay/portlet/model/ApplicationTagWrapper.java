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
 * This class is a wrapper for {@link ApplicationTag}.
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationTag
 * @generated
 */
@ProviderType
public class ApplicationTagWrapper implements ApplicationTag,
	ModelWrapper<ApplicationTag> {
	public ApplicationTagWrapper(ApplicationTag applicationTag) {
		_applicationTag = applicationTag;
	}

	@Override
	public Class<?> getModelClass() {
		return ApplicationTag.class;
	}

	@Override
	public String getModelClassName() {
		return ApplicationTag.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("applicationTagsId", getApplicationTagsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("tag", getTag());
		attributes.put("applicationStoreItemId", getApplicationStoreItemId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long applicationTagsId = (Long)attributes.get("applicationTagsId");

		if (applicationTagsId != null) {
			setApplicationTagsId(applicationTagsId);
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

		String tag = (String)attributes.get("tag");

		if (tag != null) {
			setTag(tag);
		}

		Long applicationStoreItemId = (Long)attributes.get(
				"applicationStoreItemId");

		if (applicationStoreItemId != null) {
			setApplicationStoreItemId(applicationStoreItemId);
		}
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag toEscapedModel() {
		return new ApplicationTagWrapper(_applicationTag.toEscapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag toUnescapedModel() {
		return new ApplicationTagWrapper(_applicationTag.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _applicationTag.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _applicationTag.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _applicationTag.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _applicationTag.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag> toCacheModel() {
		return _applicationTag.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag applicationTag) {
		return _applicationTag.compareTo(applicationTag);
	}

	@Override
	public int hashCode() {
		return _applicationTag.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _applicationTag.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ApplicationTagWrapper((ApplicationTag)_applicationTag.clone());
	}

	/**
	* Returns the tag of this application tag.
	*
	* @return the tag of this application tag
	*/
	@Override
	public java.lang.String getTag() {
		return _applicationTag.getTag();
	}

	/**
	* Returns the user name of this application tag.
	*
	* @return the user name of this application tag
	*/
	@Override
	public java.lang.String getUserName() {
		return _applicationTag.getUserName();
	}

	/**
	* Returns the user uuid of this application tag.
	*
	* @return the user uuid of this application tag
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _applicationTag.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _applicationTag.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _applicationTag.toXmlString();
	}

	/**
	* Returns the create date of this application tag.
	*
	* @return the create date of this application tag
	*/
	@Override
	public Date getCreateDate() {
		return _applicationTag.getCreateDate();
	}

	/**
	* Returns the modified date of this application tag.
	*
	* @return the modified date of this application tag
	*/
	@Override
	public Date getModifiedDate() {
		return _applicationTag.getModifiedDate();
	}

	/**
	* Returns the application store item ID of this application tag.
	*
	* @return the application store item ID of this application tag
	*/
	@Override
	public long getApplicationStoreItemId() {
		return _applicationTag.getApplicationStoreItemId();
	}

	/**
	* Returns the application tags ID of this application tag.
	*
	* @return the application tags ID of this application tag
	*/
	@Override
	public long getApplicationTagsId() {
		return _applicationTag.getApplicationTagsId();
	}

	/**
	* Returns the company ID of this application tag.
	*
	* @return the company ID of this application tag
	*/
	@Override
	public long getCompanyId() {
		return _applicationTag.getCompanyId();
	}

	/**
	* Returns the group ID of this application tag.
	*
	* @return the group ID of this application tag
	*/
	@Override
	public long getGroupId() {
		return _applicationTag.getGroupId();
	}

	/**
	* Returns the primary key of this application tag.
	*
	* @return the primary key of this application tag
	*/
	@Override
	public long getPrimaryKey() {
		return _applicationTag.getPrimaryKey();
	}

	/**
	* Returns the user ID of this application tag.
	*
	* @return the user ID of this application tag
	*/
	@Override
	public long getUserId() {
		return _applicationTag.getUserId();
	}

	@Override
	public void persist() {
		_applicationTag.persist();
	}

	/**
	* Sets the application store item ID of this application tag.
	*
	* @param applicationStoreItemId the application store item ID of this application tag
	*/
	@Override
	public void setApplicationStoreItemId(long applicationStoreItemId) {
		_applicationTag.setApplicationStoreItemId(applicationStoreItemId);
	}

	/**
	* Sets the application tags ID of this application tag.
	*
	* @param applicationTagsId the application tags ID of this application tag
	*/
	@Override
	public void setApplicationTagsId(long applicationTagsId) {
		_applicationTag.setApplicationTagsId(applicationTagsId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_applicationTag.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this application tag.
	*
	* @param companyId the company ID of this application tag
	*/
	@Override
	public void setCompanyId(long companyId) {
		_applicationTag.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this application tag.
	*
	* @param createDate the create date of this application tag
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_applicationTag.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_applicationTag.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_applicationTag.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_applicationTag.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this application tag.
	*
	* @param groupId the group ID of this application tag
	*/
	@Override
	public void setGroupId(long groupId) {
		_applicationTag.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this application tag.
	*
	* @param modifiedDate the modified date of this application tag
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_applicationTag.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_applicationTag.setNew(n);
	}

	/**
	* Sets the primary key of this application tag.
	*
	* @param primaryKey the primary key of this application tag
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_applicationTag.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_applicationTag.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the tag of this application tag.
	*
	* @param tag the tag of this application tag
	*/
	@Override
	public void setTag(java.lang.String tag) {
		_applicationTag.setTag(tag);
	}

	/**
	* Sets the user ID of this application tag.
	*
	* @param userId the user ID of this application tag
	*/
	@Override
	public void setUserId(long userId) {
		_applicationTag.setUserId(userId);
	}

	/**
	* Sets the user name of this application tag.
	*
	* @param userName the user name of this application tag
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_applicationTag.setUserName(userName);
	}

	/**
	* Sets the user uuid of this application tag.
	*
	* @param userUuid the user uuid of this application tag
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_applicationTag.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApplicationTagWrapper)) {
			return false;
		}

		ApplicationTagWrapper applicationTagWrapper = (ApplicationTagWrapper)obj;

		if (Objects.equals(_applicationTag,
					applicationTagWrapper._applicationTag)) {
			return true;
		}

		return false;
	}

	@Override
	public ApplicationTag getWrappedModel() {
		return _applicationTag;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _applicationTag.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _applicationTag.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_applicationTag.resetOriginalValues();
	}

	private final ApplicationTag _applicationTag;
}