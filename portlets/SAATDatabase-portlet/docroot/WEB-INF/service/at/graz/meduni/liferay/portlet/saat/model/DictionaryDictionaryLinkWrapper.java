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

package at.graz.meduni.liferay.portlet.saat.model;

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
 * This class is a wrapper for {@link DictionaryDictionaryLink}.
 * </p>
 *
 * @author reihsr
 * @see DictionaryDictionaryLink
 * @generated
 */
@ProviderType
public class DictionaryDictionaryLinkWrapper implements DictionaryDictionaryLink,
	ModelWrapper<DictionaryDictionaryLink> {
	public DictionaryDictionaryLinkWrapper(
		DictionaryDictionaryLink dictionaryDictionaryLink) {
		_dictionaryDictionaryLink = dictionaryDictionaryLink;
	}

	@Override
	public Class<?> getModelClass() {
		return DictionaryDictionaryLink.class;
	}

	@Override
	public String getModelClassName() {
		return DictionaryDictionaryLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dictionaryDictionaryLinkId",
			getDictionaryDictionaryLinkId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dictionaryId", getDictionaryId());
		attributes.put("dictionaryAddictionId", getDictionaryAddictionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dictionaryDictionaryLinkId = (Long)attributes.get(
				"dictionaryDictionaryLinkId");

		if (dictionaryDictionaryLinkId != null) {
			setDictionaryDictionaryLinkId(dictionaryDictionaryLinkId);
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

		Long dictionaryId = (Long)attributes.get("dictionaryId");

		if (dictionaryId != null) {
			setDictionaryId(dictionaryId);
		}

		Long dictionaryAddictionId = (Long)attributes.get(
				"dictionaryAddictionId");

		if (dictionaryAddictionId != null) {
			setDictionaryAddictionId(dictionaryAddictionId);
		}
	}

	@Override
	public at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink toEscapedModel() {
		return new DictionaryDictionaryLinkWrapper(_dictionaryDictionaryLink.toEscapedModel());
	}

	@Override
	public at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink toUnescapedModel() {
		return new DictionaryDictionaryLinkWrapper(_dictionaryDictionaryLink.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _dictionaryDictionaryLink.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _dictionaryDictionaryLink.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _dictionaryDictionaryLink.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _dictionaryDictionaryLink.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink> toCacheModel() {
		return _dictionaryDictionaryLink.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink dictionaryDictionaryLink) {
		return _dictionaryDictionaryLink.compareTo(dictionaryDictionaryLink);
	}

	@Override
	public int hashCode() {
		return _dictionaryDictionaryLink.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dictionaryDictionaryLink.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new DictionaryDictionaryLinkWrapper((DictionaryDictionaryLink)_dictionaryDictionaryLink.clone());
	}

	/**
	* Returns the user name of this dictionary dictionary link.
	*
	* @return the user name of this dictionary dictionary link
	*/
	@Override
	public java.lang.String getUserName() {
		return _dictionaryDictionaryLink.getUserName();
	}

	/**
	* Returns the user uuid of this dictionary dictionary link.
	*
	* @return the user uuid of this dictionary dictionary link
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _dictionaryDictionaryLink.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _dictionaryDictionaryLink.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dictionaryDictionaryLink.toXmlString();
	}

	/**
	* Returns the create date of this dictionary dictionary link.
	*
	* @return the create date of this dictionary dictionary link
	*/
	@Override
	public Date getCreateDate() {
		return _dictionaryDictionaryLink.getCreateDate();
	}

	/**
	* Returns the modified date of this dictionary dictionary link.
	*
	* @return the modified date of this dictionary dictionary link
	*/
	@Override
	public Date getModifiedDate() {
		return _dictionaryDictionaryLink.getModifiedDate();
	}

	/**
	* Returns the company ID of this dictionary dictionary link.
	*
	* @return the company ID of this dictionary dictionary link
	*/
	@Override
	public long getCompanyId() {
		return _dictionaryDictionaryLink.getCompanyId();
	}

	/**
	* Returns the dictionary addiction ID of this dictionary dictionary link.
	*
	* @return the dictionary addiction ID of this dictionary dictionary link
	*/
	@Override
	public long getDictionaryAddictionId() {
		return _dictionaryDictionaryLink.getDictionaryAddictionId();
	}

	/**
	* Returns the dictionary dictionary link ID of this dictionary dictionary link.
	*
	* @return the dictionary dictionary link ID of this dictionary dictionary link
	*/
	@Override
	public long getDictionaryDictionaryLinkId() {
		return _dictionaryDictionaryLink.getDictionaryDictionaryLinkId();
	}

	/**
	* Returns the dictionary ID of this dictionary dictionary link.
	*
	* @return the dictionary ID of this dictionary dictionary link
	*/
	@Override
	public long getDictionaryId() {
		return _dictionaryDictionaryLink.getDictionaryId();
	}

	/**
	* Returns the primary key of this dictionary dictionary link.
	*
	* @return the primary key of this dictionary dictionary link
	*/
	@Override
	public long getPrimaryKey() {
		return _dictionaryDictionaryLink.getPrimaryKey();
	}

	/**
	* Returns the user ID of this dictionary dictionary link.
	*
	* @return the user ID of this dictionary dictionary link
	*/
	@Override
	public long getUserId() {
		return _dictionaryDictionaryLink.getUserId();
	}

	@Override
	public void persist() {
		_dictionaryDictionaryLink.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dictionaryDictionaryLink.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this dictionary dictionary link.
	*
	* @param companyId the company ID of this dictionary dictionary link
	*/
	@Override
	public void setCompanyId(long companyId) {
		_dictionaryDictionaryLink.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this dictionary dictionary link.
	*
	* @param createDate the create date of this dictionary dictionary link
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_dictionaryDictionaryLink.setCreateDate(createDate);
	}

	/**
	* Sets the dictionary addiction ID of this dictionary dictionary link.
	*
	* @param dictionaryAddictionId the dictionary addiction ID of this dictionary dictionary link
	*/
	@Override
	public void setDictionaryAddictionId(long dictionaryAddictionId) {
		_dictionaryDictionaryLink.setDictionaryAddictionId(dictionaryAddictionId);
	}

	/**
	* Sets the dictionary dictionary link ID of this dictionary dictionary link.
	*
	* @param dictionaryDictionaryLinkId the dictionary dictionary link ID of this dictionary dictionary link
	*/
	@Override
	public void setDictionaryDictionaryLinkId(long dictionaryDictionaryLinkId) {
		_dictionaryDictionaryLink.setDictionaryDictionaryLinkId(dictionaryDictionaryLinkId);
	}

	/**
	* Sets the dictionary ID of this dictionary dictionary link.
	*
	* @param dictionaryId the dictionary ID of this dictionary dictionary link
	*/
	@Override
	public void setDictionaryId(long dictionaryId) {
		_dictionaryDictionaryLink.setDictionaryId(dictionaryId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_dictionaryDictionaryLink.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_dictionaryDictionaryLink.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_dictionaryDictionaryLink.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this dictionary dictionary link.
	*
	* @param modifiedDate the modified date of this dictionary dictionary link
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_dictionaryDictionaryLink.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_dictionaryDictionaryLink.setNew(n);
	}

	/**
	* Sets the primary key of this dictionary dictionary link.
	*
	* @param primaryKey the primary key of this dictionary dictionary link
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dictionaryDictionaryLink.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_dictionaryDictionaryLink.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this dictionary dictionary link.
	*
	* @param userId the user ID of this dictionary dictionary link
	*/
	@Override
	public void setUserId(long userId) {
		_dictionaryDictionaryLink.setUserId(userId);
	}

	/**
	* Sets the user name of this dictionary dictionary link.
	*
	* @param userName the user name of this dictionary dictionary link
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_dictionaryDictionaryLink.setUserName(userName);
	}

	/**
	* Sets the user uuid of this dictionary dictionary link.
	*
	* @param userUuid the user uuid of this dictionary dictionary link
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dictionaryDictionaryLink.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DictionaryDictionaryLinkWrapper)) {
			return false;
		}

		DictionaryDictionaryLinkWrapper dictionaryDictionaryLinkWrapper = (DictionaryDictionaryLinkWrapper)obj;

		if (Objects.equals(_dictionaryDictionaryLink,
					dictionaryDictionaryLinkWrapper._dictionaryDictionaryLink)) {
			return true;
		}

		return false;
	}

	@Override
	public DictionaryDictionaryLink getWrappedModel() {
		return _dictionaryDictionaryLink;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _dictionaryDictionaryLink.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _dictionaryDictionaryLink.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_dictionaryDictionaryLink.resetOriginalValues();
	}

	private final DictionaryDictionaryLink _dictionaryDictionaryLink;
}