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

import at.graz.meduni.bibbox.liferay.portlet.service.ClpSerializer;
import at.graz.meduni.bibbox.liferay.portlet.service.DockerContainerLocalServiceUtil;

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
public class DockerContainerClp extends BaseModelImpl<DockerContainer>
	implements DockerContainer {
	public DockerContainerClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DockerContainer.class;
	}

	@Override
	public String getModelClassName() {
		return DockerContainer.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _dockerContainerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDockerContainerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dockerContainerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dockerContainerId", getDockerContainerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("startCommand", getStartCommand());
		attributes.put("toolName", getToolName());
		attributes.put("instance", getInstance());
		attributes.put("port", getPort());
		attributes.put("url", getUrl());
		attributes.put("subdomain", getSubdomain());
		attributes.put("ip", getIp());
		attributes.put("displayName", getDisplayName());
		attributes.put("displayToolName", getDisplayToolName());
		attributes.put("category", getCategory());
		attributes.put("tool", getTool());
		attributes.put("description", getDescription());
		attributes.put("company", getCompany());
		attributes.put("platform", getPlatform());
		attributes.put("license", getLicense());
		attributes.put("toolDescription", getToolDescription());
		attributes.put("logourl", getLogourl());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dockerContainerId = (Long)attributes.get("dockerContainerId");

		if (dockerContainerId != null) {
			setDockerContainerId(dockerContainerId);
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

		String startCommand = (String)attributes.get("startCommand");

		if (startCommand != null) {
			setStartCommand(startCommand);
		}

		String toolName = (String)attributes.get("toolName");

		if (toolName != null) {
			setToolName(toolName);
		}

		String instance = (String)attributes.get("instance");

		if (instance != null) {
			setInstance(instance);
		}

		String port = (String)attributes.get("port");

		if (port != null) {
			setPort(port);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String subdomain = (String)attributes.get("subdomain");

		if (subdomain != null) {
			setSubdomain(subdomain);
		}

		String ip = (String)attributes.get("ip");

		if (ip != null) {
			setIp(ip);
		}

		String displayName = (String)attributes.get("displayName");

		if (displayName != null) {
			setDisplayName(displayName);
		}

		String displayToolName = (String)attributes.get("displayToolName");

		if (displayToolName != null) {
			setDisplayToolName(displayToolName);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String tool = (String)attributes.get("tool");

		if (tool != null) {
			setTool(tool);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}

		String platform = (String)attributes.get("platform");

		if (platform != null) {
			setPlatform(platform);
		}

		String license = (String)attributes.get("license");

		if (license != null) {
			setLicense(license);
		}

		String toolDescription = (String)attributes.get("toolDescription");

		if (toolDescription != null) {
			setToolDescription(toolDescription);
		}

		String logourl = (String)attributes.get("logourl");

		if (logourl != null) {
			setLogourl(logourl);
		}

		_entityCacheEnabled = GetterUtil.getBoolean("entityCacheEnabled");
		_finderCacheEnabled = GetterUtil.getBoolean("finderCacheEnabled");
	}

	@Override
	public long getDockerContainerId() {
		return _dockerContainerId;
	}

	@Override
	public void setDockerContainerId(long dockerContainerId) {
		_dockerContainerId = dockerContainerId;

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setDockerContainerId",
						long.class);

				method.invoke(_dockerContainerRemoteModel, dockerContainerId);
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

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_dockerContainerRemoteModel, groupId);
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

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_dockerContainerRemoteModel, companyId);
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

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_dockerContainerRemoteModel, userId);
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

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_dockerContainerRemoteModel, userName);
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

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_dockerContainerRemoteModel, createDate);
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

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_dockerContainerRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStartCommand() {
		return _startCommand;
	}

	@Override
	public void setStartCommand(String startCommand) {
		_startCommand = startCommand;

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setStartCommand", String.class);

				method.invoke(_dockerContainerRemoteModel, startCommand);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getToolName() {
		return _toolName;
	}

	@Override
	public void setToolName(String toolName) {
		_toolName = toolName;

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setToolName", String.class);

				method.invoke(_dockerContainerRemoteModel, toolName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInstance() {
		return _instance;
	}

	@Override
	public void setInstance(String instance) {
		_instance = instance;

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setInstance", String.class);

				method.invoke(_dockerContainerRemoteModel, instance);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPort() {
		return _port;
	}

	@Override
	public void setPort(String port) {
		_port = port;

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setPort", String.class);

				method.invoke(_dockerContainerRemoteModel, port);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUrl() {
		return _url;
	}

	@Override
	public void setUrl(String url) {
		_url = url;

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_dockerContainerRemoteModel, url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubdomain() {
		return _subdomain;
	}

	@Override
	public void setSubdomain(String subdomain) {
		_subdomain = subdomain;

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setSubdomain", String.class);

				method.invoke(_dockerContainerRemoteModel, subdomain);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIp() {
		return _ip;
	}

	@Override
	public void setIp(String ip) {
		_ip = ip;

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setIp", String.class);

				method.invoke(_dockerContainerRemoteModel, ip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDisplayName() {
		return _displayName;
	}

	@Override
	public void setDisplayName(String displayName) {
		_displayName = displayName;

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayName", String.class);

				method.invoke(_dockerContainerRemoteModel, displayName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDisplayToolName() {
		return _displayToolName;
	}

	@Override
	public void setDisplayToolName(String displayToolName) {
		_displayToolName = displayToolName;

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayToolName",
						String.class);

				method.invoke(_dockerContainerRemoteModel, displayToolName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategory() {
		return _category;
	}

	@Override
	public void setCategory(String category) {
		_category = category;

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_dockerContainerRemoteModel, category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTool() {
		return _tool;
	}

	@Override
	public void setTool(String tool) {
		_tool = tool;

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setTool", String.class);

				method.invoke(_dockerContainerRemoteModel, tool);
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

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_dockerContainerRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompany() {
		return _company;
	}

	@Override
	public void setCompany(String company) {
		_company = company;

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setCompany", String.class);

				method.invoke(_dockerContainerRemoteModel, company);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPlatform() {
		return _platform;
	}

	@Override
	public void setPlatform(String platform) {
		_platform = platform;

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setPlatform", String.class);

				method.invoke(_dockerContainerRemoteModel, platform);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLicense() {
		return _license;
	}

	@Override
	public void setLicense(String license) {
		_license = license;

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setLicense", String.class);

				method.invoke(_dockerContainerRemoteModel, license);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getToolDescription() {
		return _toolDescription;
	}

	@Override
	public void setToolDescription(String toolDescription) {
		_toolDescription = toolDescription;

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setToolDescription",
						String.class);

				method.invoke(_dockerContainerRemoteModel, toolDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLogourl() {
		return _logourl;
	}

	@Override
	public void setLogourl(String logourl) {
		_logourl = logourl;

		if (_dockerContainerRemoteModel != null) {
			try {
				Class<?> clazz = _dockerContainerRemoteModel.getClass();

				Method method = clazz.getMethod("setLogourl", String.class);

				method.invoke(_dockerContainerRemoteModel, logourl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDockerContainerRemoteModel() {
		return _dockerContainerRemoteModel;
	}

	public void setDockerContainerRemoteModel(
		BaseModel<?> dockerContainerRemoteModel) {
		_dockerContainerRemoteModel = dockerContainerRemoteModel;
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

		Class<?> remoteModelClass = _dockerContainerRemoteModel.getClass();

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

		Object returnValue = method.invoke(_dockerContainerRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() {
		if (this.isNew()) {
			DockerContainerLocalServiceUtil.addDockerContainer(this);
		}
		else {
			DockerContainerLocalServiceUtil.updateDockerContainer(this);
		}
	}

	@Override
	public DockerContainer toEscapedModel() {
		return (DockerContainer)ProxyUtil.newProxyInstance(DockerContainer.class.getClassLoader(),
			new Class[] { DockerContainer.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DockerContainerClp clone = new DockerContainerClp();

		clone.setDockerContainerId(getDockerContainerId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setStartCommand(getStartCommand());
		clone.setToolName(getToolName());
		clone.setInstance(getInstance());
		clone.setPort(getPort());
		clone.setUrl(getUrl());
		clone.setSubdomain(getSubdomain());
		clone.setIp(getIp());
		clone.setDisplayName(getDisplayName());
		clone.setDisplayToolName(getDisplayToolName());
		clone.setCategory(getCategory());
		clone.setTool(getTool());
		clone.setDescription(getDescription());
		clone.setCompany(getCompany());
		clone.setPlatform(getPlatform());
		clone.setLicense(getLicense());
		clone.setToolDescription(getToolDescription());
		clone.setLogourl(getLogourl());

		return clone;
	}

	@Override
	public int compareTo(DockerContainer dockerContainer) {
		int value = 0;

		if (getDockerContainerId() < dockerContainer.getDockerContainerId()) {
			value = -1;
		}
		else if (getDockerContainerId() > dockerContainer.getDockerContainerId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof DockerContainerClp)) {
			return false;
		}

		DockerContainerClp dockerContainer = (DockerContainerClp)obj;

		long primaryKey = dockerContainer.getPrimaryKey();

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
		StringBundler sb = new StringBundler(49);

		sb.append("{dockerContainerId=");
		sb.append(getDockerContainerId());
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
		sb.append(", startCommand=");
		sb.append(getStartCommand());
		sb.append(", toolName=");
		sb.append(getToolName());
		sb.append(", instance=");
		sb.append(getInstance());
		sb.append(", port=");
		sb.append(getPort());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", subdomain=");
		sb.append(getSubdomain());
		sb.append(", ip=");
		sb.append(getIp());
		sb.append(", displayName=");
		sb.append(getDisplayName());
		sb.append(", displayToolName=");
		sb.append(getDisplayToolName());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", tool=");
		sb.append(getTool());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", company=");
		sb.append(getCompany());
		sb.append(", platform=");
		sb.append(getPlatform());
		sb.append(", license=");
		sb.append(getLicense());
		sb.append(", toolDescription=");
		sb.append(getToolDescription());
		sb.append(", logourl=");
		sb.append(getLogourl());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(76);

		sb.append("<model><model-name>");
		sb.append("at.graz.meduni.bibbox.liferay.portlet.model.DockerContainer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dockerContainerId</column-name><column-value><![CDATA[");
		sb.append(getDockerContainerId());
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
			"<column><column-name>startCommand</column-name><column-value><![CDATA[");
		sb.append(getStartCommand());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toolName</column-name><column-value><![CDATA[");
		sb.append(getToolName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>instance</column-name><column-value><![CDATA[");
		sb.append(getInstance());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>port</column-name><column-value><![CDATA[");
		sb.append(getPort());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subdomain</column-name><column-value><![CDATA[");
		sb.append(getSubdomain());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ip</column-name><column-value><![CDATA[");
		sb.append(getIp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayName</column-name><column-value><![CDATA[");
		sb.append(getDisplayName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayToolName</column-name><column-value><![CDATA[");
		sb.append(getDisplayToolName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tool</column-name><column-value><![CDATA[");
		sb.append(getTool());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>company</column-name><column-value><![CDATA[");
		sb.append(getCompany());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>platform</column-name><column-value><![CDATA[");
		sb.append(getPlatform());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>license</column-name><column-value><![CDATA[");
		sb.append(getLicense());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>toolDescription</column-name><column-value><![CDATA[");
		sb.append(getToolDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logourl</column-name><column-value><![CDATA[");
		sb.append(getLogourl());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _dockerContainerId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _startCommand;
	private String _toolName;
	private String _instance;
	private String _port;
	private String _url;
	private String _subdomain;
	private String _ip;
	private String _displayName;
	private String _displayToolName;
	private String _category;
	private String _tool;
	private String _description;
	private String _company;
	private String _platform;
	private String _license;
	private String _toolDescription;
	private String _logourl;
	private BaseModel<?> _dockerContainerRemoteModel;
	private Class<?> _clpSerializerClass = ClpSerializer.class;
	private boolean _entityCacheEnabled;
	private boolean _finderCacheEnabled;
}