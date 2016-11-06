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

import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance;

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
 * The cache model class for representing ApplicationInstance in entity cache.
 *
 * @author Robert Reihs
 * @see ApplicationInstance
 * @generated
 */
@ProviderType
public class ApplicationInstanceCacheModel implements CacheModel<ApplicationInstance>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApplicationInstanceCacheModel)) {
			return false;
		}

		ApplicationInstanceCacheModel applicationInstanceCacheModel = (ApplicationInstanceCacheModel)obj;

		if (applicationInstanceId == applicationInstanceCacheModel.applicationInstanceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, applicationInstanceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{applicationInstanceId=");
		sb.append(applicationInstanceId);
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
		sb.append(", instanceId=");
		sb.append(instanceId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", folderName=");
		sb.append(folderName);
		sb.append(", shortName=");
		sb.append(shortName);
		sb.append(", application=");
		sb.append(application);
		sb.append(", version=");
		sb.append(version);
		sb.append(", description=");
		sb.append(description);
		sb.append(", installlog=");
		sb.append(installlog);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ApplicationInstance toEntityModel() {
		ApplicationInstanceImpl applicationInstanceImpl = new ApplicationInstanceImpl();

		applicationInstanceImpl.setApplicationInstanceId(applicationInstanceId);
		applicationInstanceImpl.setGroupId(groupId);
		applicationInstanceImpl.setCompanyId(companyId);
		applicationInstanceImpl.setUserId(userId);

		if (userName == null) {
			applicationInstanceImpl.setUserName(StringPool.BLANK);
		}
		else {
			applicationInstanceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			applicationInstanceImpl.setCreateDate(null);
		}
		else {
			applicationInstanceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			applicationInstanceImpl.setModifiedDate(null);
		}
		else {
			applicationInstanceImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (instanceId == null) {
			applicationInstanceImpl.setInstanceId(StringPool.BLANK);
		}
		else {
			applicationInstanceImpl.setInstanceId(instanceId);
		}

		if (name == null) {
			applicationInstanceImpl.setName(StringPool.BLANK);
		}
		else {
			applicationInstanceImpl.setName(name);
		}

		if (folderName == null) {
			applicationInstanceImpl.setFolderName(StringPool.BLANK);
		}
		else {
			applicationInstanceImpl.setFolderName(folderName);
		}

		if (shortName == null) {
			applicationInstanceImpl.setShortName(StringPool.BLANK);
		}
		else {
			applicationInstanceImpl.setShortName(shortName);
		}

		if (application == null) {
			applicationInstanceImpl.setApplication(StringPool.BLANK);
		}
		else {
			applicationInstanceImpl.setApplication(application);
		}

		if (version == null) {
			applicationInstanceImpl.setVersion(StringPool.BLANK);
		}
		else {
			applicationInstanceImpl.setVersion(version);
		}

		if (description == null) {
			applicationInstanceImpl.setDescription(StringPool.BLANK);
		}
		else {
			applicationInstanceImpl.setDescription(description);
		}

		if (installlog == null) {
			applicationInstanceImpl.setInstalllog(StringPool.BLANK);
		}
		else {
			applicationInstanceImpl.setInstalllog(installlog);
		}

		applicationInstanceImpl.resetOriginalValues();

		return applicationInstanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		applicationInstanceId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		instanceId = objectInput.readUTF();
		name = objectInput.readUTF();
		folderName = objectInput.readUTF();
		shortName = objectInput.readUTF();
		application = objectInput.readUTF();
		version = objectInput.readUTF();
		description = objectInput.readUTF();
		installlog = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(applicationInstanceId);

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

		if (instanceId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(instanceId);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (folderName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(folderName);
		}

		if (shortName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shortName);
		}

		if (application == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(application);
		}

		if (version == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(version);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (installlog == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(installlog);
		}
	}

	public long applicationInstanceId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String instanceId;
	public String name;
	public String folderName;
	public String shortName;
	public String application;
	public String version;
	public String description;
	public String installlog;
}