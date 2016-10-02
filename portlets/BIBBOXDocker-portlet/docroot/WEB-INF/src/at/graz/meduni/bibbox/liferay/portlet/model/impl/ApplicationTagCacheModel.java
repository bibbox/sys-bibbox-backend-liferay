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

import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag;

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
 * The cache model class for representing ApplicationTag in entity cache.
 *
 * @author Robert Reihs
 * @see ApplicationTag
 * @generated
 */
@ProviderType
public class ApplicationTagCacheModel implements CacheModel<ApplicationTag>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApplicationTagCacheModel)) {
			return false;
		}

		ApplicationTagCacheModel applicationTagCacheModel = (ApplicationTagCacheModel)obj;

		if (applicationTagsId == applicationTagCacheModel.applicationTagsId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, applicationTagsId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{applicationTagsId=");
		sb.append(applicationTagsId);
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
		sb.append(", tag=");
		sb.append(tag);
		sb.append(", applicationStoreItemId=");
		sb.append(applicationStoreItemId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ApplicationTag toEntityModel() {
		ApplicationTagImpl applicationTagImpl = new ApplicationTagImpl();

		applicationTagImpl.setApplicationTagsId(applicationTagsId);
		applicationTagImpl.setGroupId(groupId);
		applicationTagImpl.setCompanyId(companyId);
		applicationTagImpl.setUserId(userId);

		if (userName == null) {
			applicationTagImpl.setUserName(StringPool.BLANK);
		}
		else {
			applicationTagImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			applicationTagImpl.setCreateDate(null);
		}
		else {
			applicationTagImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			applicationTagImpl.setModifiedDate(null);
		}
		else {
			applicationTagImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (tag == null) {
			applicationTagImpl.setTag(StringPool.BLANK);
		}
		else {
			applicationTagImpl.setTag(tag);
		}

		applicationTagImpl.setApplicationStoreItemId(applicationStoreItemId);

		applicationTagImpl.resetOriginalValues();

		return applicationTagImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		applicationTagsId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		tag = objectInput.readUTF();

		applicationStoreItemId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(applicationTagsId);

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

		if (tag == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tag);
		}

		objectOutput.writeLong(applicationStoreItemId);
	}

	public long applicationTagsId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String tag;
	public long applicationStoreItemId;
}