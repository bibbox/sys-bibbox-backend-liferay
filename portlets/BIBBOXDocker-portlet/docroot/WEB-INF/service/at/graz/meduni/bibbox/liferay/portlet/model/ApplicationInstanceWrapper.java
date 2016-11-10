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
 * This class is a wrapper for {@link ApplicationInstance}.
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationInstance
 * @generated
 */
@ProviderType
public class ApplicationInstanceWrapper implements ApplicationInstance,
	ModelWrapper<ApplicationInstance> {
	public ApplicationInstanceWrapper(ApplicationInstance applicationInstance) {
		_applicationInstance = applicationInstance;
	}

	@Override
	public Class<?> getModelClass() {
		return ApplicationInstance.class;
	}

	@Override
	public String getModelClassName() {
		return ApplicationInstance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("applicationInstanceId", getApplicationInstanceId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("instanceId", getInstanceId());
		attributes.put("name", getName());
		attributes.put("shortName", getShortName());
		attributes.put("baseurl", getBaseurl());
		attributes.put("folderName", getFolderName());
		attributes.put("application", getApplication());
		attributes.put("version", getVersion());
		attributes.put("status", getStatus());
		attributes.put("deleted", getDeleted());
		attributes.put("shortdescription", getShortdescription());
		attributes.put("description", getDescription());
		attributes.put("maintenance", getMaintenance());
		attributes.put("ismaintenance", getIsmaintenance());
		attributes.put("installlog", getInstalllog());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long applicationInstanceId = (Long)attributes.get(
				"applicationInstanceId");

		if (applicationInstanceId != null) {
			setApplicationInstanceId(applicationInstanceId);
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

		String instanceId = (String)attributes.get("instanceId");

		if (instanceId != null) {
			setInstanceId(instanceId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String shortName = (String)attributes.get("shortName");

		if (shortName != null) {
			setShortName(shortName);
		}

		String baseurl = (String)attributes.get("baseurl");

		if (baseurl != null) {
			setBaseurl(baseurl);
		}

		String folderName = (String)attributes.get("folderName");

		if (folderName != null) {
			setFolderName(folderName);
		}

		String application = (String)attributes.get("application");

		if (application != null) {
			setApplication(application);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}

		String shortdescription = (String)attributes.get("shortdescription");

		if (shortdescription != null) {
			setShortdescription(shortdescription);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String maintenance = (String)attributes.get("maintenance");

		if (maintenance != null) {
			setMaintenance(maintenance);
		}

		Boolean ismaintenance = (Boolean)attributes.get("ismaintenance");

		if (ismaintenance != null) {
			setIsmaintenance(ismaintenance);
		}

		String installlog = (String)attributes.get("installlog");

		if (installlog != null) {
			setInstalllog(installlog);
		}
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance toEscapedModel() {
		return new ApplicationInstanceWrapper(_applicationInstance.toEscapedModel());
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance toUnescapedModel() {
		return new ApplicationInstanceWrapper(_applicationInstance.toUnescapedModel());
	}

	/**
	* Returns the deleted of this application instance.
	*
	* @return the deleted of this application instance
	*/
	@Override
	public boolean getDeleted() {
		return _applicationInstance.getDeleted();
	}

	/**
	* Returns the ismaintenance of this application instance.
	*
	* @return the ismaintenance of this application instance
	*/
	@Override
	public boolean getIsmaintenance() {
		return _applicationInstance.getIsmaintenance();
	}

	/**
	* Returns the status of this application instance.
	*
	* @return the status of this application instance
	*/
	@Override
	public boolean getStatus() {
		return _applicationInstance.getStatus();
	}

	@Override
	public boolean isCachedModel() {
		return _applicationInstance.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this application instance is deleted.
	*
	* @return <code>true</code> if this application instance is deleted; <code>false</code> otherwise
	*/
	@Override
	public boolean isDeleted() {
		return _applicationInstance.isDeleted();
	}

	@Override
	public boolean isEscapedModel() {
		return _applicationInstance.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this application instance is ismaintenance.
	*
	* @return <code>true</code> if this application instance is ismaintenance; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsmaintenance() {
		return _applicationInstance.isIsmaintenance();
	}

	@Override
	public boolean isNew() {
		return _applicationInstance.isNew();
	}

	/**
	* Returns <code>true</code> if this application instance is status.
	*
	* @return <code>true</code> if this application instance is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _applicationInstance.isStatus();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _applicationInstance.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getApplicationTags() {
		return _applicationInstance.getApplicationTags();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getInstanceJSONObject() {
		return _applicationInstance.getInstanceJSONObject();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance> toCacheModel() {
		return _applicationInstance.toCacheModel();
	}

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance applicationInstance) {
		return _applicationInstance.compareTo(applicationInstance);
	}

	@Override
	public int hashCode() {
		return _applicationInstance.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _applicationInstance.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ApplicationInstanceWrapper((ApplicationInstance)_applicationInstance.clone());
	}

	/**
	* Returns the application of this application instance.
	*
	* @return the application of this application instance
	*/
	@Override
	public java.lang.String getApplication() {
		return _applicationInstance.getApplication();
	}

	@Override
	public java.lang.String getApplicationStatus() {
		return _applicationInstance.getApplicationStatus();
	}

	@Override
	public java.lang.String getApplicationname() {
		return _applicationInstance.getApplicationname();
	}

	@Override
	public java.lang.String getBaseInstallationConfigString() {
		return _applicationInstance.getBaseInstallationConfigString();
	}

	/**
	* Returns the baseurl of this application instance.
	*
	* @return the baseurl of this application instance
	*/
	@Override
	public java.lang.String getBaseurl() {
		return _applicationInstance.getBaseurl();
	}

	@Override
	public java.lang.String getBasicProxyConfigString() {
		return _applicationInstance.getBasicProxyConfigString();
	}

	/**
	* Returns the description of this application instance.
	*
	* @return the description of this application instance
	*/
	@Override
	public java.lang.String getDescription() {
		return _applicationInstance.getDescription();
	}

	/**
	* Returns the folder name of this application instance.
	*
	* @return the folder name of this application instance
	*/
	@Override
	public java.lang.String getFolderName() {
		return _applicationInstance.getFolderName();
	}

	@Override
	public java.lang.String getFolderPath() {
		return _applicationInstance.getFolderPath();
	}

	/**
	* Returns the installlog of this application instance.
	*
	* @return the installlog of this application instance
	*/
	@Override
	public java.lang.String getInstalllog() {
		return _applicationInstance.getInstalllog();
	}

	/**
	* Returns the instance ID of this application instance.
	*
	* @return the instance ID of this application instance
	*/
	@Override
	public java.lang.String getInstanceId() {
		return _applicationInstance.getInstanceId();
	}

	@Override
	public java.lang.String getInstanceUrl() {
		return _applicationInstance.getInstanceUrl();
	}

	/**
	* Returns the maintenance of this application instance.
	*
	* @return the maintenance of this application instance
	*/
	@Override
	public java.lang.String getMaintenance() {
		return _applicationInstance.getMaintenance();
	}

	/**
	* Returns the name of this application instance.
	*
	* @return the name of this application instance
	*/
	@Override
	public java.lang.String getName() {
		return _applicationInstance.getName();
	}

	/**
	* Returns the short name of this application instance.
	*
	* @return the short name of this application instance
	*/
	@Override
	public java.lang.String getShortName() {
		return _applicationInstance.getShortName();
	}

	/**
	* Returns the shortdescription of this application instance.
	*
	* @return the shortdescription of this application instance
	*/
	@Override
	public java.lang.String getShortdescription() {
		return _applicationInstance.getShortdescription();
	}

	/**
	* Returns the user name of this application instance.
	*
	* @return the user name of this application instance
	*/
	@Override
	public java.lang.String getUserName() {
		return _applicationInstance.getUserName();
	}

	/**
	* Returns the user uuid of this application instance.
	*
	* @return the user uuid of this application instance
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _applicationInstance.getUserUuid();
	}

	/**
	* Returns the version of this application instance.
	*
	* @return the version of this application instance
	*/
	@Override
	public java.lang.String getVersion() {
		return _applicationInstance.getVersion();
	}

	@Override
	public java.lang.String toString() {
		return _applicationInstance.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _applicationInstance.toXmlString();
	}

	/**
	* Returns the create date of this application instance.
	*
	* @return the create date of this application instance
	*/
	@Override
	public Date getCreateDate() {
		return _applicationInstance.getCreateDate();
	}

	/**
	* Returns the modified date of this application instance.
	*
	* @return the modified date of this application instance
	*/
	@Override
	public Date getModifiedDate() {
		return _applicationInstance.getModifiedDate();
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort> getApplicationPorts() {
		return _applicationInstance.getApplicationPorts();
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer> getContainers() {
		return _applicationInstance.getContainers();
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer> getContainersNeedToRun() {
		return _applicationInstance.getContainersNeedToRun();
	}

	/**
	* Returns the application instance ID of this application instance.
	*
	* @return the application instance ID of this application instance
	*/
	@Override
	public long getApplicationInstanceId() {
		return _applicationInstance.getApplicationInstanceId();
	}

	/**
	* Returns the company ID of this application instance.
	*
	* @return the company ID of this application instance
	*/
	@Override
	public long getCompanyId() {
		return _applicationInstance.getCompanyId();
	}

	/**
	* Returns the group ID of this application instance.
	*
	* @return the group ID of this application instance
	*/
	@Override
	public long getGroupId() {
		return _applicationInstance.getGroupId();
	}

	/**
	* Returns the primary key of this application instance.
	*
	* @return the primary key of this application instance
	*/
	@Override
	public long getPrimaryKey() {
		return _applicationInstance.getPrimaryKey();
	}

	@Override
	public long getPrimaryPort() {
		return _applicationInstance.getPrimaryPort();
	}

	/**
	* Returns the user ID of this application instance.
	*
	* @return the user ID of this application instance
	*/
	@Override
	public long getUserId() {
		return _applicationInstance.getUserId();
	}

	@Override
	public void persist() {
		_applicationInstance.persist();
	}

	/**
	* Sets the application of this application instance.
	*
	* @param application the application of this application instance
	*/
	@Override
	public void setApplication(java.lang.String application) {
		_applicationInstance.setApplication(application);
	}

	/**
	* Sets the application instance ID of this application instance.
	*
	* @param applicationInstanceId the application instance ID of this application instance
	*/
	@Override
	public void setApplicationInstanceId(long applicationInstanceId) {
		_applicationInstance.setApplicationInstanceId(applicationInstanceId);
	}

	/**
	* Sets the baseurl of this application instance.
	*
	* @param baseurl the baseurl of this application instance
	*/
	@Override
	public void setBaseurl(java.lang.String baseurl) {
		_applicationInstance.setBaseurl(baseurl);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_applicationInstance.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this application instance.
	*
	* @param companyId the company ID of this application instance
	*/
	@Override
	public void setCompanyId(long companyId) {
		_applicationInstance.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this application instance.
	*
	* @param createDate the create date of this application instance
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_applicationInstance.setCreateDate(createDate);
	}

	/**
	* Sets whether this application instance is deleted.
	*
	* @param deleted the deleted of this application instance
	*/
	@Override
	public void setDeleted(boolean deleted) {
		_applicationInstance.setDeleted(deleted);
	}

	/**
	* Sets the description of this application instance.
	*
	* @param description the description of this application instance
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_applicationInstance.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_applicationInstance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_applicationInstance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_applicationInstance.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the folder name of this application instance.
	*
	* @param folderName the folder name of this application instance
	*/
	@Override
	public void setFolderName(java.lang.String folderName) {
		_applicationInstance.setFolderName(folderName);
	}

	/**
	* Sets the group ID of this application instance.
	*
	* @param groupId the group ID of this application instance
	*/
	@Override
	public void setGroupId(long groupId) {
		_applicationInstance.setGroupId(groupId);
	}

	/**
	* Sets the installlog of this application instance.
	*
	* @param installlog the installlog of this application instance
	*/
	@Override
	public void setInstalllog(java.lang.String installlog) {
		_applicationInstance.setInstalllog(installlog);
	}

	/**
	* Sets the instance ID of this application instance.
	*
	* @param instanceId the instance ID of this application instance
	*/
	@Override
	public void setInstanceId(java.lang.String instanceId) {
		_applicationInstance.setInstanceId(instanceId);
	}

	/**
	* Sets whether this application instance is ismaintenance.
	*
	* @param ismaintenance the ismaintenance of this application instance
	*/
	@Override
	public void setIsmaintenance(boolean ismaintenance) {
		_applicationInstance.setIsmaintenance(ismaintenance);
	}

	/**
	* Sets the maintenance of this application instance.
	*
	* @param maintenance the maintenance of this application instance
	*/
	@Override
	public void setMaintenance(java.lang.String maintenance) {
		_applicationInstance.setMaintenance(maintenance);
	}

	/**
	* Sets the modified date of this application instance.
	*
	* @param modifiedDate the modified date of this application instance
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_applicationInstance.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this application instance.
	*
	* @param name the name of this application instance
	*/
	@Override
	public void setName(java.lang.String name) {
		_applicationInstance.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_applicationInstance.setNew(n);
	}

	/**
	* Sets the primary key of this application instance.
	*
	* @param primaryKey the primary key of this application instance
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_applicationInstance.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_applicationInstance.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the short name of this application instance.
	*
	* @param shortName the short name of this application instance
	*/
	@Override
	public void setShortName(java.lang.String shortName) {
		_applicationInstance.setShortName(shortName);
	}

	/**
	* Sets the shortdescription of this application instance.
	*
	* @param shortdescription the shortdescription of this application instance
	*/
	@Override
	public void setShortdescription(java.lang.String shortdescription) {
		_applicationInstance.setShortdescription(shortdescription);
	}

	/**
	* Sets whether this application instance is status.
	*
	* @param status the status of this application instance
	*/
	@Override
	public void setStatus(boolean status) {
		_applicationInstance.setStatus(status);
	}

	/**
	* Sets the user ID of this application instance.
	*
	* @param userId the user ID of this application instance
	*/
	@Override
	public void setUserId(long userId) {
		_applicationInstance.setUserId(userId);
	}

	/**
	* Sets the user name of this application instance.
	*
	* @param userName the user name of this application instance
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_applicationInstance.setUserName(userName);
	}

	/**
	* Sets the user uuid of this application instance.
	*
	* @param userUuid the user uuid of this application instance
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_applicationInstance.setUserUuid(userUuid);
	}

	/**
	* Sets the version of this application instance.
	*
	* @param version the version of this application instance
	*/
	@Override
	public void setVersion(java.lang.String version) {
		_applicationInstance.setVersion(version);
	}

	@Override
	public void startUpApplicationInstance() {
		_applicationInstance.startUpApplicationInstance();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApplicationInstanceWrapper)) {
			return false;
		}

		ApplicationInstanceWrapper applicationInstanceWrapper = (ApplicationInstanceWrapper)obj;

		if (Objects.equals(_applicationInstance,
					applicationInstanceWrapper._applicationInstance)) {
			return true;
		}

		return false;
	}

	@Override
	public ApplicationInstance getWrappedModel() {
		return _applicationInstance;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _applicationInstance.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _applicationInstance.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_applicationInstance.resetOriginalValues();
	}

	private final ApplicationInstance _applicationInstance;
}