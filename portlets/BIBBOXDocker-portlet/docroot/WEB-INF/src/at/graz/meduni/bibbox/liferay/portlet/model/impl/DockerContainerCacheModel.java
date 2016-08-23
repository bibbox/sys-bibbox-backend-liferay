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

package at.graz.meduni.bibbox.liferay.portlet.model.impl;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.liferay.portlet.model.DockerContainer;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DockerContainer in entity cache.
 *
 * @author Robert Reihs
 * @see DockerContainer
 * @generated
 */
@ProviderType
public class DockerContainerCacheModel implements CacheModel<DockerContainer>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DockerContainerCacheModel)) {
			return false;
		}

		DockerContainerCacheModel dockerContainerCacheModel = (DockerContainerCacheModel)obj;

		if (dockerContainerId == dockerContainerCacheModel.dockerContainerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dockerContainerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{dockerContainerId=");
		sb.append(dockerContainerId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", startCommand=");
		sb.append(startCommand);
		sb.append(", toolName=");
		sb.append(toolName);
		sb.append(", instance=");
		sb.append(instance);
		sb.append(", port=");
		sb.append(port);
		sb.append(", url=");
		sb.append(url);
		sb.append(", subdomain=");
		sb.append(subdomain);
		sb.append(", ip=");
		sb.append(ip);
		sb.append(", displayName=");
		sb.append(displayName);
		sb.append(", displayToolName=");
		sb.append(displayToolName);
		sb.append(", category=");
		sb.append(category);
		sb.append(", tool=");
		sb.append(tool);
		sb.append(", description=");
		sb.append(description);
		sb.append(", company=");
		sb.append(company);
		sb.append(", platform=");
		sb.append(platform);
		sb.append(", license=");
		sb.append(license);
		sb.append(", toolDescription=");
		sb.append(toolDescription);
		sb.append(", logourl=");
		sb.append(logourl);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DockerContainer toEntityModel() {
		DockerContainerImpl dockerContainerImpl = new DockerContainerImpl();

		dockerContainerImpl.setDockerContainerId(dockerContainerId);
		dockerContainerImpl.setGroupId(groupId);
		dockerContainerImpl.setCompanyId(companyId);
		dockerContainerImpl.setUserId(userId);

		if (userName == null) {
			dockerContainerImpl.setUserName(StringPool.BLANK);
		}
		else {
			dockerContainerImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dockerContainerImpl.setCreateDate(null);
		}
		else {
			dockerContainerImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dockerContainerImpl.setModifiedDate(null);
		}
		else {
			dockerContainerImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (startCommand == null) {
			dockerContainerImpl.setStartCommand(StringPool.BLANK);
		}
		else {
			dockerContainerImpl.setStartCommand(startCommand);
		}

		if (toolName == null) {
			dockerContainerImpl.setToolName(StringPool.BLANK);
		}
		else {
			dockerContainerImpl.setToolName(toolName);
		}

		if (instance == null) {
			dockerContainerImpl.setInstance(StringPool.BLANK);
		}
		else {
			dockerContainerImpl.setInstance(instance);
		}

		if (port == null) {
			dockerContainerImpl.setPort(StringPool.BLANK);
		}
		else {
			dockerContainerImpl.setPort(port);
		}

		if (url == null) {
			dockerContainerImpl.setUrl(StringPool.BLANK);
		}
		else {
			dockerContainerImpl.setUrl(url);
		}

		if (subdomain == null) {
			dockerContainerImpl.setSubdomain(StringPool.BLANK);
		}
		else {
			dockerContainerImpl.setSubdomain(subdomain);
		}

		if (ip == null) {
			dockerContainerImpl.setIp(StringPool.BLANK);
		}
		else {
			dockerContainerImpl.setIp(ip);
		}

		if (displayName == null) {
			dockerContainerImpl.setDisplayName(StringPool.BLANK);
		}
		else {
			dockerContainerImpl.setDisplayName(displayName);
		}

		if (displayToolName == null) {
			dockerContainerImpl.setDisplayToolName(StringPool.BLANK);
		}
		else {
			dockerContainerImpl.setDisplayToolName(displayToolName);
		}

		if (category == null) {
			dockerContainerImpl.setCategory(StringPool.BLANK);
		}
		else {
			dockerContainerImpl.setCategory(category);
		}

		if (tool == null) {
			dockerContainerImpl.setTool(StringPool.BLANK);
		}
		else {
			dockerContainerImpl.setTool(tool);
		}

		if (description == null) {
			dockerContainerImpl.setDescription(StringPool.BLANK);
		}
		else {
			dockerContainerImpl.setDescription(description);
		}

		if (company == null) {
			dockerContainerImpl.setCompany(StringPool.BLANK);
		}
		else {
			dockerContainerImpl.setCompany(company);
		}

		if (platform == null) {
			dockerContainerImpl.setPlatform(StringPool.BLANK);
		}
		else {
			dockerContainerImpl.setPlatform(platform);
		}

		if (license == null) {
			dockerContainerImpl.setLicense(StringPool.BLANK);
		}
		else {
			dockerContainerImpl.setLicense(license);
		}

		if (toolDescription == null) {
			dockerContainerImpl.setToolDescription(StringPool.BLANK);
		}
		else {
			dockerContainerImpl.setToolDescription(toolDescription);
		}

		if (logourl == null) {
			dockerContainerImpl.setLogourl(StringPool.BLANK);
		}
		else {
			dockerContainerImpl.setLogourl(logourl);
		}

		dockerContainerImpl.resetOriginalValues();

		return dockerContainerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dockerContainerId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		startCommand = objectInput.readUTF();
		toolName = objectInput.readUTF();
		instance = objectInput.readUTF();
		port = objectInput.readUTF();
		url = objectInput.readUTF();
		subdomain = objectInput.readUTF();
		ip = objectInput.readUTF();
		displayName = objectInput.readUTF();
		displayToolName = objectInput.readUTF();
		category = objectInput.readUTF();
		tool = objectInput.readUTF();
		description = objectInput.readUTF();
		company = objectInput.readUTF();
		platform = objectInput.readUTF();
		license = objectInput.readUTF();
		toolDescription = objectInput.readUTF();
		logourl = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dockerContainerId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (startCommand == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(startCommand);
		}

		if (toolName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(toolName);
		}

		if (instance == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(instance);
		}

		if (port == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(port);
		}

		if (url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url);
		}

		if (subdomain == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subdomain);
		}

		if (ip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ip);
		}

		if (displayName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(displayName);
		}

		if (displayToolName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(displayToolName);
		}

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		if (tool == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tool);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (company == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(company);
		}

		if (platform == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(platform);
		}

		if (license == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(license);
		}

		if (toolDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(toolDescription);
		}

		if (logourl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(logourl);
		}
	}

	public long dockerContainerId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String startCommand;
	public String toolName;
	public String instance;
	public String port;
	public String url;
	public String subdomain;
	public String ip;
	public String displayName;
	public String displayToolName;
	public String category;
	public String tool;
	public String description;
	public String company;
	public String platform;
	public String license;
	public String toolDescription;
	public String logourl;
}