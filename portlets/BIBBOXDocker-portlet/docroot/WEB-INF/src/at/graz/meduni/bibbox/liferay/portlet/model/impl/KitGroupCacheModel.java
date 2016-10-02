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

import at.graz.meduni.bibbox.liferay.portlet.model.KitGroup;

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
 * The cache model class for representing KitGroup in entity cache.
 *
 * @author Robert Reihs
 * @see KitGroup
 * @generated
 */
@ProviderType
public class KitGroupCacheModel implements CacheModel<KitGroup>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KitGroupCacheModel)) {
			return false;
		}

		KitGroupCacheModel kitGroupCacheModel = (KitGroupCacheModel)obj;

		if (kitGroupId == kitGroupCacheModel.kitGroupId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, kitGroupId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{kitGroupId=");
		sb.append(kitGroupId);
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
		sb.append(", group=");
		sb.append(group);
		sb.append(", applicationStoreItemId=");
		sb.append(applicationStoreItemId);
		sb.append(", bibboxKitId=");
		sb.append(bibboxKitId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public KitGroup toEntityModel() {
		KitGroupImpl kitGroupImpl = new KitGroupImpl();

		kitGroupImpl.setKitGroupId(kitGroupId);
		kitGroupImpl.setGroupId(groupId);
		kitGroupImpl.setCompanyId(companyId);
		kitGroupImpl.setUserId(userId);

		if (userName == null) {
			kitGroupImpl.setUserName(StringPool.BLANK);
		}
		else {
			kitGroupImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			kitGroupImpl.setCreateDate(null);
		}
		else {
			kitGroupImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			kitGroupImpl.setModifiedDate(null);
		}
		else {
			kitGroupImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (group == null) {
			kitGroupImpl.setGroup(StringPool.BLANK);
		}
		else {
			kitGroupImpl.setGroup(group);
		}

		kitGroupImpl.setApplicationStoreItemId(applicationStoreItemId);
		kitGroupImpl.setBibboxKitId(bibboxKitId);

		kitGroupImpl.resetOriginalValues();

		return kitGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		kitGroupId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		group = objectInput.readUTF();

		applicationStoreItemId = objectInput.readLong();

		bibboxKitId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(kitGroupId);

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

		if (group == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(group);
		}

		objectOutput.writeLong(applicationStoreItemId);

		objectOutput.writeLong(bibboxKitId);
	}

	public long kitGroupId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String group;
	public long applicationStoreItemId;
	public long bibboxKitId;
}