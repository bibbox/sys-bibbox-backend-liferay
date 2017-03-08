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

import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus;

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
 * The cache model class for representing ApplicationInstanceStatus in entity cache.
 *
 * @author Robert Reihs
 * @see ApplicationInstanceStatus
 * @generated
 */
@ProviderType
public class ApplicationInstanceStatusCacheModel implements CacheModel<ApplicationInstanceStatus>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApplicationInstanceStatusCacheModel)) {
			return false;
		}

		ApplicationInstanceStatusCacheModel applicationInstanceStatusCacheModel = (ApplicationInstanceStatusCacheModel)obj;

		if (applicationInstanceStatusId == applicationInstanceStatusCacheModel.applicationInstanceStatusId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, applicationInstanceStatusId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{applicationInstanceStatusId=");
		sb.append(applicationInstanceStatusId);
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
		sb.append(", applicationInstanceId=");
		sb.append(applicationInstanceId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ApplicationInstanceStatus toEntityModel() {
		ApplicationInstanceStatusImpl applicationInstanceStatusImpl = new ApplicationInstanceStatusImpl();

		applicationInstanceStatusImpl.setApplicationInstanceStatusId(applicationInstanceStatusId);
		applicationInstanceStatusImpl.setGroupId(groupId);
		applicationInstanceStatusImpl.setCompanyId(companyId);
		applicationInstanceStatusImpl.setUserId(userId);

		if (userName == null) {
			applicationInstanceStatusImpl.setUserName(StringPool.BLANK);
		}
		else {
			applicationInstanceStatusImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			applicationInstanceStatusImpl.setCreateDate(null);
		}
		else {
			applicationInstanceStatusImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			applicationInstanceStatusImpl.setModifiedDate(null);
		}
		else {
			applicationInstanceStatusImpl.setModifiedDate(new Date(modifiedDate));
		}

		applicationInstanceStatusImpl.setApplicationInstanceId(applicationInstanceId);

		if (status == null) {
			applicationInstanceStatusImpl.setStatus(StringPool.BLANK);
		}
		else {
			applicationInstanceStatusImpl.setStatus(status);
		}

		applicationInstanceStatusImpl.resetOriginalValues();

		return applicationInstanceStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		applicationInstanceStatusId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		applicationInstanceId = objectInput.readLong();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(applicationInstanceStatusId);

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

		objectOutput.writeLong(applicationInstanceId);

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public long applicationInstanceStatusId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long applicationInstanceId;
	public String status;
}