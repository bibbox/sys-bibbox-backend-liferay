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

import at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit;

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
 * The cache model class for representing BibboxKit in entity cache.
 *
 * @author Robert Reihs
 * @see BibboxKit
 * @generated
 */
@ProviderType
public class BibboxKitCacheModel implements CacheModel<BibboxKit>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BibboxKitCacheModel)) {
			return false;
		}

		BibboxKitCacheModel bibboxKitCacheModel = (BibboxKitCacheModel)obj;

		if (bibboxKitId == bibboxKitCacheModel.bibboxKitId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bibboxKitId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{bibboxKitId=");
		sb.append(bibboxKitId);
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
		sb.append(", kitName=");
		sb.append(kitName);
		sb.append(", applicationStoreItemId=");
		sb.append(applicationStoreItemId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BibboxKit toEntityModel() {
		BibboxKitImpl bibboxKitImpl = new BibboxKitImpl();

		bibboxKitImpl.setBibboxKitId(bibboxKitId);
		bibboxKitImpl.setGroupId(groupId);
		bibboxKitImpl.setCompanyId(companyId);
		bibboxKitImpl.setUserId(userId);

		if (userName == null) {
			bibboxKitImpl.setUserName(StringPool.BLANK);
		}
		else {
			bibboxKitImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			bibboxKitImpl.setCreateDate(null);
		}
		else {
			bibboxKitImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bibboxKitImpl.setModifiedDate(null);
		}
		else {
			bibboxKitImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (kitName == null) {
			bibboxKitImpl.setKitName(StringPool.BLANK);
		}
		else {
			bibboxKitImpl.setKitName(kitName);
		}

		bibboxKitImpl.setApplicationStoreItemId(applicationStoreItemId);

		bibboxKitImpl.resetOriginalValues();

		return bibboxKitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bibboxKitId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		kitName = objectInput.readUTF();

		applicationStoreItemId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(bibboxKitId);

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

		if (kitName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(kitName);
		}

		objectOutput.writeLong(applicationStoreItemId);
	}

	public long bibboxKitId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String kitName;
	public long applicationStoreItemId;
}