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

import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer;

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
 * The cache model class for representing ApplicationInstanceContainer in entity cache.
 *
 * @author Robert Reihs
 * @see ApplicationInstanceContainer
 * @generated
 */
@ProviderType
public class ApplicationInstanceContainerCacheModel implements CacheModel<ApplicationInstanceContainer>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApplicationInstanceContainerCacheModel)) {
			return false;
		}

		ApplicationInstanceContainerCacheModel applicationInstanceContainerCacheModel =
			(ApplicationInstanceContainerCacheModel)obj;

		if (applicationInstanceContainerId == applicationInstanceContainerCacheModel.applicationInstanceContainerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, applicationInstanceContainerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{applicationInstanceContainerId=");
		sb.append(applicationInstanceContainerId);
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
		sb.append(", containerName=");
		sb.append(containerName);
		sb.append(", needrunning=");
		sb.append(needrunning);
		sb.append(", applicationInstanceId=");
		sb.append(applicationInstanceId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ApplicationInstanceContainer toEntityModel() {
		ApplicationInstanceContainerImpl applicationInstanceContainerImpl = new ApplicationInstanceContainerImpl();

		applicationInstanceContainerImpl.setApplicationInstanceContainerId(applicationInstanceContainerId);
		applicationInstanceContainerImpl.setGroupId(groupId);
		applicationInstanceContainerImpl.setCompanyId(companyId);
		applicationInstanceContainerImpl.setUserId(userId);

		if (userName == null) {
			applicationInstanceContainerImpl.setUserName(StringPool.BLANK);
		}
		else {
			applicationInstanceContainerImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			applicationInstanceContainerImpl.setCreateDate(null);
		}
		else {
			applicationInstanceContainerImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			applicationInstanceContainerImpl.setModifiedDate(null);
		}
		else {
			applicationInstanceContainerImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		if (containerName == null) {
			applicationInstanceContainerImpl.setContainerName(StringPool.BLANK);
		}
		else {
			applicationInstanceContainerImpl.setContainerName(containerName);
		}

		applicationInstanceContainerImpl.setNeedrunning(needrunning);
		applicationInstanceContainerImpl.setApplicationInstanceId(applicationInstanceId);

		applicationInstanceContainerImpl.resetOriginalValues();

		return applicationInstanceContainerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		applicationInstanceContainerId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		containerName = objectInput.readUTF();

		needrunning = objectInput.readBoolean();

		applicationInstanceId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(applicationInstanceContainerId);

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

		if (containerName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(containerName);
		}

		objectOutput.writeBoolean(needrunning);

		objectOutput.writeLong(applicationInstanceId);
	}

	public long applicationInstanceContainerId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String containerName;
	public boolean needrunning;
	public long applicationInstanceId;
}