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
 * This class is a wrapper for {@link KitGroup}.
 * </p>
 *
 * @author Robert Reihs
 * @see KitGroup
 * @generated
 */
@ProviderType
public class KitGroupWrapper implements KitGroup, ModelWrapper<KitGroup> {
	public KitGroupWrapper(KitGroup kitGroup) {
		_kitGroup = kitGroup;
	}

	@Override
	public Class<?> getModelClass() {
		return KitGroup.class;
	}

	@Override
	public String getModelClassName() {
		return KitGroup.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("kitGroupId", getKitGroupId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("group", getGroup());
		attributes.put("applicationStoreItemId", getApplicationStoreItemId());
		attributes.put("bibboxKitId", getBibboxKitId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long kitGroupId = (Long)attributes.get("kitGroupId");

		if (kitGroupId != null) {
			setKitGroupId(kitGroupId);
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

		String group = (String)attributes.get("group");

		if (group != null) {
			setGroup(group);
		}

		Long applicationStoreItemId = (Long)attributes.get(
				"applicationStoreItemId");

		if (applicationStoreItemId != null) {
			setApplicationStoreItemId(applicationStoreItemId);
		}

		Long bibboxKitId = (Long)attributes.get("bibboxKitId");

		if (bibboxKitId != null) {
			setBibboxKitId(bibboxKitId);
		}
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.KitGroup toEscapedModel() {
		return new KitGroupWrapper(_kitGroup.toEscapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.KitGroup toUnescapedModel() {
		return new KitGroupWrapper(_kitGroup.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _kitGroup.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _kitGroup.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _kitGroup.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _kitGroup.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.bibbox.liferay.portlet.model.KitGroup> toCacheModel() {
		return _kitGroup.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.liferay.portlet.model.KitGroup kitGroup) {
		return _kitGroup.compareTo(kitGroup);
	}

	@Override
	public int hashCode() {
		return _kitGroup.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _kitGroup.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new KitGroupWrapper((KitGroup)_kitGroup.clone());
	}

	/**
	* Returns the group of this kit group.
	*
	* @return the group of this kit group
	*/
	@Override
	public java.lang.String getGroup() {
		return _kitGroup.getGroup();
	}

	/**
	* Returns the user name of this kit group.
	*
	* @return the user name of this kit group
	*/
	@Override
	public java.lang.String getUserName() {
		return _kitGroup.getUserName();
	}

	/**
	* Returns the user uuid of this kit group.
	*
	* @return the user uuid of this kit group
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _kitGroup.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _kitGroup.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _kitGroup.toXmlString();
	}

	/**
	* Returns the create date of this kit group.
	*
	* @return the create date of this kit group
	*/
	@Override
	public Date getCreateDate() {
		return _kitGroup.getCreateDate();
	}

	/**
	* Returns the modified date of this kit group.
	*
	* @return the modified date of this kit group
	*/
	@Override
	public Date getModifiedDate() {
		return _kitGroup.getModifiedDate();
	}

	/**
	* Returns the application store item ID of this kit group.
	*
	* @return the application store item ID of this kit group
	*/
	@Override
	public long getApplicationStoreItemId() {
		return _kitGroup.getApplicationStoreItemId();
	}

	/**
	* Returns the bibbox kit ID of this kit group.
	*
	* @return the bibbox kit ID of this kit group
	*/
	@Override
	public long getBibboxKitId() {
		return _kitGroup.getBibboxKitId();
	}

	/**
	* Returns the company ID of this kit group.
	*
	* @return the company ID of this kit group
	*/
	@Override
	public long getCompanyId() {
		return _kitGroup.getCompanyId();
	}

	/**
	* Returns the group ID of this kit group.
	*
	* @return the group ID of this kit group
	*/
	@Override
	public long getGroupId() {
		return _kitGroup.getGroupId();
	}

	/**
	* Returns the kit group ID of this kit group.
	*
	* @return the kit group ID of this kit group
	*/
	@Override
	public long getKitGroupId() {
		return _kitGroup.getKitGroupId();
	}

	/**
	* Returns the primary key of this kit group.
	*
	* @return the primary key of this kit group
	*/
	@Override
	public long getPrimaryKey() {
		return _kitGroup.getPrimaryKey();
	}

	/**
	* Returns the user ID of this kit group.
	*
	* @return the user ID of this kit group
	*/
	@Override
	public long getUserId() {
		return _kitGroup.getUserId();
	}

	@Override
	public void persist() {
		_kitGroup.persist();
	}

	/**
	* Sets the application store item ID of this kit group.
	*
	* @param applicationStoreItemId the application store item ID of this kit group
	*/
	@Override
	public void setApplicationStoreItemId(long applicationStoreItemId) {
		_kitGroup.setApplicationStoreItemId(applicationStoreItemId);
	}

	/**
	* Sets the bibbox kit ID of this kit group.
	*
	* @param bibboxKitId the bibbox kit ID of this kit group
	*/
	@Override
	public void setBibboxKitId(long bibboxKitId) {
		_kitGroup.setBibboxKitId(bibboxKitId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_kitGroup.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this kit group.
	*
	* @param companyId the company ID of this kit group
	*/
	@Override
	public void setCompanyId(long companyId) {
		_kitGroup.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this kit group.
	*
	* @param createDate the create date of this kit group
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_kitGroup.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_kitGroup.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_kitGroup.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_kitGroup.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group of this kit group.
	*
	* @param group the group of this kit group
	*/
	@Override
	public void setGroup(java.lang.String group) {
		_kitGroup.setGroup(group);
	}

	/**
	* Sets the group ID of this kit group.
	*
	* @param groupId the group ID of this kit group
	*/
	@Override
	public void setGroupId(long groupId) {
		_kitGroup.setGroupId(groupId);
	}

	/**
	* Sets the kit group ID of this kit group.
	*
	* @param kitGroupId the kit group ID of this kit group
	*/
	@Override
	public void setKitGroupId(long kitGroupId) {
		_kitGroup.setKitGroupId(kitGroupId);
	}

	/**
	* Sets the modified date of this kit group.
	*
	* @param modifiedDate the modified date of this kit group
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_kitGroup.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_kitGroup.setNew(n);
	}

	/**
	* Sets the primary key of this kit group.
	*
	* @param primaryKey the primary key of this kit group
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_kitGroup.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_kitGroup.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this kit group.
	*
	* @param userId the user ID of this kit group
	*/
	@Override
	public void setUserId(long userId) {
		_kitGroup.setUserId(userId);
	}

	/**
	* Sets the user name of this kit group.
	*
	* @param userName the user name of this kit group
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_kitGroup.setUserName(userName);
	}

	/**
	* Sets the user uuid of this kit group.
	*
	* @param userUuid the user uuid of this kit group
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_kitGroup.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KitGroupWrapper)) {
			return false;
		}

		KitGroupWrapper kitGroupWrapper = (KitGroupWrapper)obj;

		if (Objects.equals(_kitGroup, kitGroupWrapper._kitGroup)) {
			return true;
		}

		return false;
	}

	@Override
	public KitGroup getWrappedModel() {
		return _kitGroup;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _kitGroup.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _kitGroup.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_kitGroup.resetOriginalValues();
	}

	private final KitGroup _kitGroup;
}