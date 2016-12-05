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

import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @generated
 */
@ProviderType
public class ApplicationInstanceClp extends BaseModelImpl<ApplicationInstance>
	implements ApplicationInstance {
	public ApplicationInstanceClp() {
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
	public long getPrimaryKey() {
		return _applicationInstanceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setApplicationInstanceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _applicationInstanceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
		attributes.put("adminnode", getAdminnode());
		attributes.put("maintenance", getMaintenance());
		attributes.put("ismaintenance", getIsmaintenance());
		attributes.put("installlog", getInstalllog());
		attributes.put("isinstalling", getIsinstalling());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

		String status = (String)attributes.get("status");

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

		String adminnode = (String)attributes.get("adminnode");

		if (adminnode != null) {
			setAdminnode(adminnode);
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

		Boolean isinstalling = (Boolean)attributes.get("isinstalling");

		if (isinstalling != null) {
			setIsinstalling(isinstalling);
		}

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getApplicationInstanceId() {
		return _applicationInstanceId;
	}

	@Override
	public void setApplicationInstanceId(long applicationInstanceId) {
		_applicationInstanceId = applicationInstanceId;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationInstanceId",
						long.class);

				method.invoke(_applicationInstanceRemoteModel,
					applicationInstanceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_applicationInstanceRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_applicationInstanceRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_applicationInstanceRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_applicationInstanceRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_applicationInstanceRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_applicationInstanceRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInstanceId() {
		return _instanceId;
	}

	@Override
	public void setInstanceId(String instanceId) {
		_instanceId = instanceId;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setInstanceId", String.class);

				method.invoke(_applicationInstanceRemoteModel, instanceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_applicationInstanceRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShortName() {
		return _shortName;
	}

	@Override
	public void setShortName(String shortName) {
		_shortName = shortName;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setShortName", String.class);

				method.invoke(_applicationInstanceRemoteModel, shortName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBaseurl() {
		return _baseurl;
	}

	@Override
	public void setBaseurl(String baseurl) {
		_baseurl = baseurl;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setBaseurl", String.class);

				method.invoke(_applicationInstanceRemoteModel, baseurl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFolderName() {
		return _folderName;
	}

	@Override
	public void setFolderName(String folderName) {
		_folderName = folderName;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setFolderName", String.class);

				method.invoke(_applicationInstanceRemoteModel, folderName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApplication() {
		return _application;
	}

	@Override
	public void setApplication(String application) {
		_application = application;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setApplication", String.class);

				method.invoke(_applicationInstanceRemoteModel, application);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVersion() {
		return _version;
	}

	@Override
	public void setVersion(String version) {
		_version = version;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", String.class);

				method.invoke(_applicationInstanceRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_applicationInstanceRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDeleted() {
		return _deleted;
	}

	@Override
	public boolean isDeleted() {
		return _deleted;
	}

	@Override
	public void setDeleted(boolean deleted) {
		_deleted = deleted;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setDeleted", boolean.class);

				method.invoke(_applicationInstanceRemoteModel, deleted);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShortdescription() {
		return _shortdescription;
	}

	@Override
	public void setShortdescription(String shortdescription) {
		_shortdescription = shortdescription;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setShortdescription",
						String.class);

				method.invoke(_applicationInstanceRemoteModel, shortdescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_applicationInstanceRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAdminnode() {
		return _adminnode;
	}

	@Override
	public void setAdminnode(String adminnode) {
		_adminnode = adminnode;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setAdminnode", String.class);

				method.invoke(_applicationInstanceRemoteModel, adminnode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaintenance() {
		return _maintenance;
	}

	@Override
	public void setMaintenance(String maintenance) {
		_maintenance = maintenance;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setMaintenance", String.class);

				method.invoke(_applicationInstanceRemoteModel, maintenance);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsmaintenance() {
		return _ismaintenance;
	}

	@Override
	public boolean isIsmaintenance() {
		return _ismaintenance;
	}

	@Override
	public void setIsmaintenance(boolean ismaintenance) {
		_ismaintenance = ismaintenance;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setIsmaintenance",
						boolean.class);

				method.invoke(_applicationInstanceRemoteModel, ismaintenance);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInstalllog() {
		return _installlog;
	}

	@Override
	public void setInstalllog(String installlog) {
		_installlog = installlog;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setInstalllog", String.class);

				method.invoke(_applicationInstanceRemoteModel, installlog);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsinstalling() {
		return _isinstalling;
	}

	@Override
	public boolean isIsinstalling() {
		return _isinstalling;
	}

	@Override
	public void setIsinstalling(boolean isinstalling) {
		_isinstalling = isinstalling;

		if (_applicationInstanceRemoteModel != null) {
			try {
				Class<?> clazz = _applicationInstanceRemoteModel.getClass();

				Method method = clazz.getMethod("setIsinstalling", boolean.class);

				method.invoke(_applicationInstanceRemoteModel, isinstalling);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getBaseInstallationConfigString() {
		try {
			String methodName = "getBaseInstallationConfigString";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getBasicProxyConfigString() {
		try {
			String methodName = "getBasicProxyConfigString";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getFolderPath() {
		try {
			String methodName = "getFolderPath";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public long getPrimaryPort() {
		try {
			String methodName = "getPrimaryPort";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Long returnObj = (Long)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort> getApplicationPorts() {
		try {
			String methodName = "getApplicationPorts";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort> returnObj =
				(java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String stopApplicationInstance() {
		try {
			String methodName = "stopApplicationInstance";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String startApplicationInstance() {
		try {
			String methodName = "startApplicationInstance";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String restartApplicationInstance() {
		try {
			String methodName = "restartApplicationInstance";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getComposeLog(
		java.lang.String lines) {
		try {
			String methodName = "getComposeLog";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { lines };

			com.liferay.portal.kernel.json.JSONArray returnObj = (com.liferay.portal.kernel.json.JSONArray)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getInstanceJSONObject() {
		try {
			String methodName = "getInstanceJSONObject";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.liferay.portal.kernel.json.JSONObject returnObj = (com.liferay.portal.kernel.json.JSONObject)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getInstanceUrl() {
		try {
			String methodName = "getInstanceUrl";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer> getContainersNeedToRun() {
		try {
			String methodName = "getContainersNeedToRun";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer> returnObj =
				(java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer> getContainers() {
		try {
			String methodName = "getContainers";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer> returnObj =
				(java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getApplicationStatus() {
		try {
			String methodName = "getApplicationStatus";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getApplicationname() {
		try {
			String methodName = "getApplicationname";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getApplicationTags() {
		try {
			String methodName = "getApplicationTags";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.liferay.portal.kernel.json.JSONArray returnObj = (com.liferay.portal.kernel.json.JSONArray)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getApplicationInstanceRemoteModel() {
		return _applicationInstanceRemoteModel;
	}

	public void setApplicationInstanceRemoteModel(
		BaseModel<?> applicationInstanceRemoteModel) {
		_applicationInstanceRemoteModel = applicationInstanceRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _applicationInstanceRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_applicationInstanceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			ApplicationInstanceLocalServiceUtil.addApplicationInstance(this);
		}
		else {
			ApplicationInstanceLocalServiceUtil.updateApplicationInstance(this);
		}
	}

	@Override
	public ApplicationInstance toEscapedModel() {
		return (ApplicationInstance)ProxyUtil.newProxyInstance(ApplicationInstance.class.getClassLoader(),
			new Class[] { ApplicationInstance.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ApplicationInstanceClp clone = new ApplicationInstanceClp();

		clone.setApplicationInstanceId(getApplicationInstanceId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setInstanceId(getInstanceId());
		clone.setName(getName());
		clone.setShortName(getShortName());
		clone.setBaseurl(getBaseurl());
		clone.setFolderName(getFolderName());
		clone.setApplication(getApplication());
		clone.setVersion(getVersion());
		clone.setStatus(getStatus());
		clone.setDeleted(getDeleted());
		clone.setShortdescription(getShortdescription());
		clone.setDescription(getDescription());
		clone.setAdminnode(getAdminnode());
		clone.setMaintenance(getMaintenance());
		clone.setIsmaintenance(getIsmaintenance());
		clone.setInstalllog(getInstalllog());
		clone.setIsinstalling(getIsinstalling());

		return clone;
	}

	@Override
	public int compareTo(ApplicationInstance applicationInstance) {
		int value = 0;

		value = getFolderName().compareTo(applicationInstance.getFolderName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApplicationInstanceClp)) {
			return false;
		}

		ApplicationInstanceClp applicationInstance = (ApplicationInstanceClp)obj;

		long primaryKey = applicationInstance.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{applicationInstanceId=");
		sb.append(getApplicationInstanceId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", instanceId=");
		sb.append(getInstanceId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", shortName=");
		sb.append(getShortName());
		sb.append(", baseurl=");
		sb.append(getBaseurl());
		sb.append(", folderName=");
		sb.append(getFolderName());
		sb.append(", application=");
		sb.append(getApplication());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append(", shortdescription=");
		sb.append(getShortdescription());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", adminnode=");
		sb.append(getAdminnode());
		sb.append(", maintenance=");
		sb.append(getMaintenance());
		sb.append(", ismaintenance=");
		sb.append(getIsmaintenance());
		sb.append(", installlog=");
		sb.append(getInstalllog());
		sb.append(", isinstalling=");
		sb.append(getIsinstalling());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append(
			"at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>applicationInstanceId</column-name><column-value><![CDATA[");
		sb.append(getApplicationInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>instanceId</column-name><column-value><![CDATA[");
		sb.append(getInstanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortName</column-name><column-value><![CDATA[");
		sb.append(getShortName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>baseurl</column-name><column-value><![CDATA[");
		sb.append(getBaseurl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folderName</column-name><column-value><![CDATA[");
		sb.append(getFolderName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>application</column-name><column-value><![CDATA[");
		sb.append(getApplication());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortdescription</column-name><column-value><![CDATA[");
		sb.append(getShortdescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>adminnode</column-name><column-value><![CDATA[");
		sb.append(getAdminnode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maintenance</column-name><column-value><![CDATA[");
		sb.append(getMaintenance());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ismaintenance</column-name><column-value><![CDATA[");
		sb.append(getIsmaintenance());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>installlog</column-name><column-value><![CDATA[");
		sb.append(getInstalllog());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isinstalling</column-name><column-value><![CDATA[");
		sb.append(getIsinstalling());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _applicationInstanceId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _instanceId;
	private String _name;
	private String _shortName;
	private String _baseurl;
	private String _folderName;
	private String _application;
	private String _version;
	private String _status;
	private boolean _deleted;
	private String _shortdescription;
	private String _description;
	private String _adminnode;
	private String _maintenance;
	private boolean _ismaintenance;
	private String _installlog;
	private boolean _isinstalling;
	private BaseModel<?> _applicationInstanceRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}