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
 * This class is a wrapper for {@link BibboxKit}.
 * </p>
 *
 * @author Robert Reihs
 * @see BibboxKit
 * @generated
 */
@ProviderType
public class BibboxKitWrapper implements BibboxKit, ModelWrapper<BibboxKit> {
	public BibboxKitWrapper(BibboxKit bibboxKit) {
		_bibboxKit = bibboxKit;
	}

	@Override
	public Class<?> getModelClass() {
		return BibboxKit.class;
	}

	@Override
	public String getModelClassName() {
		return BibboxKit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bibboxKitId", getBibboxKitId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("kitName", getKitName());
		attributes.put("applicationStoreItemId", getApplicationStoreItemId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bibboxKitId = (Long)attributes.get("bibboxKitId");

		if (bibboxKitId != null) {
			setBibboxKitId(bibboxKitId);
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

		String kitName = (String)attributes.get("kitName");

		if (kitName != null) {
			setKitName(kitName);
		}

		Long applicationStoreItemId = (Long)attributes.get(
				"applicationStoreItemId");

		if (applicationStoreItemId != null) {
			setApplicationStoreItemId(applicationStoreItemId);
		}
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit toEscapedModel() {
		return new BibboxKitWrapper(_bibboxKit.toEscapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit toUnescapedModel() {
		return new BibboxKitWrapper(_bibboxKit.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _bibboxKit.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _bibboxKit.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _bibboxKit.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _bibboxKit.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit> toCacheModel() {
		return _bibboxKit.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit bibboxKit) {
		return _bibboxKit.compareTo(bibboxKit);
	}

	@Override
	public int hashCode() {
		return _bibboxKit.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bibboxKit.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new BibboxKitWrapper((BibboxKit)_bibboxKit.clone());
	}

	/**
	* Returns the kit name of this bibbox kit.
	*
	* @return the kit name of this bibbox kit
	*/
	@Override
	public java.lang.String getKitName() {
		return _bibboxKit.getKitName();
	}

	/**
	* Returns the user name of this bibbox kit.
	*
	* @return the user name of this bibbox kit
	*/
	@Override
	public java.lang.String getUserName() {
		return _bibboxKit.getUserName();
	}

	/**
	* Returns the user uuid of this bibbox kit.
	*
	* @return the user uuid of this bibbox kit
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _bibboxKit.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _bibboxKit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _bibboxKit.toXmlString();
	}

	/**
	* Returns the create date of this bibbox kit.
	*
	* @return the create date of this bibbox kit
	*/
	@Override
	public Date getCreateDate() {
		return _bibboxKit.getCreateDate();
	}

	/**
	* Returns the modified date of this bibbox kit.
	*
	* @return the modified date of this bibbox kit
	*/
	@Override
	public Date getModifiedDate() {
		return _bibboxKit.getModifiedDate();
	}

	/**
	* Returns the application store item ID of this bibbox kit.
	*
	* @return the application store item ID of this bibbox kit
	*/
	@Override
	public long getApplicationStoreItemId() {
		return _bibboxKit.getApplicationStoreItemId();
	}

	/**
	* Returns the bibbox kit ID of this bibbox kit.
	*
	* @return the bibbox kit ID of this bibbox kit
	*/
	@Override
	public long getBibboxKitId() {
		return _bibboxKit.getBibboxKitId();
	}

	/**
	* Returns the company ID of this bibbox kit.
	*
	* @return the company ID of this bibbox kit
	*/
	@Override
	public long getCompanyId() {
		return _bibboxKit.getCompanyId();
	}

	/**
	* Returns the group ID of this bibbox kit.
	*
	* @return the group ID of this bibbox kit
	*/
	@Override
	public long getGroupId() {
		return _bibboxKit.getGroupId();
	}

	/**
	* Returns the primary key of this bibbox kit.
	*
	* @return the primary key of this bibbox kit
	*/
	@Override
	public long getPrimaryKey() {
		return _bibboxKit.getPrimaryKey();
	}

	/**
	* Returns the user ID of this bibbox kit.
	*
	* @return the user ID of this bibbox kit
	*/
	@Override
	public long getUserId() {
		return _bibboxKit.getUserId();
	}

	@Override
	public void persist() {
		_bibboxKit.persist();
	}

	/**
	* Sets the application store item ID of this bibbox kit.
	*
	* @param applicationStoreItemId the application store item ID of this bibbox kit
	*/
	@Override
	public void setApplicationStoreItemId(long applicationStoreItemId) {
		_bibboxKit.setApplicationStoreItemId(applicationStoreItemId);
	}

	/**
	* Sets the bibbox kit ID of this bibbox kit.
	*
	* @param bibboxKitId the bibbox kit ID of this bibbox kit
	*/
	@Override
	public void setBibboxKitId(long bibboxKitId) {
		_bibboxKit.setBibboxKitId(bibboxKitId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bibboxKit.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this bibbox kit.
	*
	* @param companyId the company ID of this bibbox kit
	*/
	@Override
	public void setCompanyId(long companyId) {
		_bibboxKit.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this bibbox kit.
	*
	* @param createDate the create date of this bibbox kit
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_bibboxKit.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_bibboxKit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_bibboxKit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_bibboxKit.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this bibbox kit.
	*
	* @param groupId the group ID of this bibbox kit
	*/
	@Override
	public void setGroupId(long groupId) {
		_bibboxKit.setGroupId(groupId);
	}

	/**
	* Sets the kit name of this bibbox kit.
	*
	* @param kitName the kit name of this bibbox kit
	*/
	@Override
	public void setKitName(java.lang.String kitName) {
		_bibboxKit.setKitName(kitName);
	}

	/**
	* Sets the modified date of this bibbox kit.
	*
	* @param modifiedDate the modified date of this bibbox kit
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_bibboxKit.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_bibboxKit.setNew(n);
	}

	/**
	* Sets the primary key of this bibbox kit.
	*
	* @param primaryKey the primary key of this bibbox kit
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bibboxKit.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_bibboxKit.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this bibbox kit.
	*
	* @param userId the user ID of this bibbox kit
	*/
	@Override
	public void setUserId(long userId) {
		_bibboxKit.setUserId(userId);
	}

	/**
	* Sets the user name of this bibbox kit.
	*
	* @param userName the user name of this bibbox kit
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_bibboxKit.setUserName(userName);
	}

	/**
	* Sets the user uuid of this bibbox kit.
	*
	* @param userUuid the user uuid of this bibbox kit
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_bibboxKit.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BibboxKitWrapper)) {
			return false;
		}

		BibboxKitWrapper bibboxKitWrapper = (BibboxKitWrapper)obj;

		if (Objects.equals(_bibboxKit, bibboxKitWrapper._bibboxKit)) {
			return true;
		}

		return false;
	}

	@Override
	public BibboxKit getWrappedModel() {
		return _bibboxKit;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _bibboxKit.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _bibboxKit.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_bibboxKit.resetOriginalValues();
	}

	private final BibboxKit _bibboxKit;
}