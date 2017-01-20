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

import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort;

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
 * The cache model class for representing ApplicationInstancePort in entity cache.
 *
 * @author Robert Reihs
 * @see ApplicationInstancePort
 * @generated
 */
@ProviderType
public class ApplicationInstancePortCacheModel implements CacheModel<ApplicationInstancePort>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApplicationInstancePortCacheModel)) {
			return false;
		}

		ApplicationInstancePortCacheModel applicationInstancePortCacheModel = (ApplicationInstancePortCacheModel)obj;

		if (applicationInstancePortId == applicationInstancePortCacheModel.applicationInstancePortId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, applicationInstancePortId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{applicationInstancePortId=");
		sb.append(applicationInstancePortId);
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
		sb.append(", port=");
		sb.append(port);
		sb.append(", primary=");
		sb.append(primary);
		sb.append(", subdomain=");
		sb.append(subdomain);
		sb.append(", applicationInstanceId=");
		sb.append(applicationInstanceId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ApplicationInstancePort toEntityModel() {
		ApplicationInstancePortImpl applicationInstancePortImpl = new ApplicationInstancePortImpl();

		applicationInstancePortImpl.setApplicationInstancePortId(applicationInstancePortId);
		applicationInstancePortImpl.setGroupId(groupId);
		applicationInstancePortImpl.setCompanyId(companyId);
		applicationInstancePortImpl.setUserId(userId);

		if (userName == null) {
			applicationInstancePortImpl.setUserName(StringPool.BLANK);
		}
		else {
			applicationInstancePortImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			applicationInstancePortImpl.setCreateDate(null);
		}
		else {
			applicationInstancePortImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			applicationInstancePortImpl.setModifiedDate(null);
		}
		else {
			applicationInstancePortImpl.setModifiedDate(new Date(modifiedDate));
		}

		applicationInstancePortImpl.setPort(port);
		applicationInstancePortImpl.setPrimary(primary);

		if (subdomain == null) {
			applicationInstancePortImpl.setSubdomain(StringPool.BLANK);
		}
		else {
			applicationInstancePortImpl.setSubdomain(subdomain);
		}

		applicationInstancePortImpl.setApplicationInstanceId(applicationInstanceId);

		applicationInstancePortImpl.resetOriginalValues();

		return applicationInstancePortImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		applicationInstancePortId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		port = objectInput.readLong();

		primary = objectInput.readBoolean();
		subdomain = objectInput.readUTF();

		applicationInstanceId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(applicationInstancePortId);

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

		objectOutput.writeLong(port);

		objectOutput.writeBoolean(primary);

		if (subdomain == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subdomain);
		}

		objectOutput.writeLong(applicationInstanceId);
	}

	public long applicationInstancePortId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long port;
	public boolean primary;
	public String subdomain;
	public long applicationInstanceId;
}