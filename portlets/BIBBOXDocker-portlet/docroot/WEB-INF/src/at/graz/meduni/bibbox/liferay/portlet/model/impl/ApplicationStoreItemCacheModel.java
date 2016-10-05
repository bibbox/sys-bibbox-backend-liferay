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

import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationStoreItem;

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
 * The cache model class for representing ApplicationStoreItem in entity cache.
 *
 * @author Robert Reihs
 * @see ApplicationStoreItem
 * @generated
 */
@ProviderType
public class ApplicationStoreItemCacheModel implements CacheModel<ApplicationStoreItem>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ApplicationStoreItemCacheModel)) {
			return false;
		}

		ApplicationStoreItemCacheModel applicationStoreItemCacheModel = (ApplicationStoreItemCacheModel)obj;

		if (applicationStoreItemId == applicationStoreItemCacheModel.applicationStoreItemId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, applicationStoreItemId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{applicationStoreItemId=");
		sb.append(applicationStoreItemId);
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
		sb.append(", githash=");
		sb.append(githash);
		sb.append(", depreciated=");
		sb.append(depreciated);
		sb.append(", applicationFolderName=");
		sb.append(applicationFolderName);
		sb.append(", applicationName=");
		sb.append(applicationName);
		sb.append(", applicationShortName=");
		sb.append(applicationShortName);
		sb.append(", applicationVersion=");
		sb.append(applicationVersion);
		sb.append(", applicationReleaseState=");
		sb.append(applicationReleaseState);
		sb.append(", applicationDescription=");
		sb.append(applicationDescription);
		sb.append(", applicationCatalogueUrl=");
		sb.append(applicationCatalogueUrl);
		sb.append(", applicationApplicationUrl=");
		sb.append(applicationApplicationUrl);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ApplicationStoreItem toEntityModel() {
		ApplicationStoreItemImpl applicationStoreItemImpl = new ApplicationStoreItemImpl();

		applicationStoreItemImpl.setApplicationStoreItemId(applicationStoreItemId);
		applicationStoreItemImpl.setGroupId(groupId);
		applicationStoreItemImpl.setCompanyId(companyId);
		applicationStoreItemImpl.setUserId(userId);

		if (userName == null) {
			applicationStoreItemImpl.setUserName(StringPool.BLANK);
		}
		else {
			applicationStoreItemImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			applicationStoreItemImpl.setCreateDate(null);
		}
		else {
			applicationStoreItemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			applicationStoreItemImpl.setModifiedDate(null);
		}
		else {
			applicationStoreItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (githash == null) {
			applicationStoreItemImpl.setGithash(StringPool.BLANK);
		}
		else {
			applicationStoreItemImpl.setGithash(githash);
		}

		applicationStoreItemImpl.setDepreciated(depreciated);

		if (applicationFolderName == null) {
			applicationStoreItemImpl.setApplicationFolderName(StringPool.BLANK);
		}
		else {
			applicationStoreItemImpl.setApplicationFolderName(applicationFolderName);
		}

		if (applicationName == null) {
			applicationStoreItemImpl.setApplicationName(StringPool.BLANK);
		}
		else {
			applicationStoreItemImpl.setApplicationName(applicationName);
		}

		if (applicationShortName == null) {
			applicationStoreItemImpl.setApplicationShortName(StringPool.BLANK);
		}
		else {
			applicationStoreItemImpl.setApplicationShortName(applicationShortName);
		}

		if (applicationVersion == null) {
			applicationStoreItemImpl.setApplicationVersion(StringPool.BLANK);
		}
		else {
			applicationStoreItemImpl.setApplicationVersion(applicationVersion);
		}

		if (applicationReleaseState == null) {
			applicationStoreItemImpl.setApplicationReleaseState(StringPool.BLANK);
		}
		else {
			applicationStoreItemImpl.setApplicationReleaseState(applicationReleaseState);
		}

		if (applicationDescription == null) {
			applicationStoreItemImpl.setApplicationDescription(StringPool.BLANK);
		}
		else {
			applicationStoreItemImpl.setApplicationDescription(applicationDescription);
		}

		if (applicationCatalogueUrl == null) {
			applicationStoreItemImpl.setApplicationCatalogueUrl(StringPool.BLANK);
		}
		else {
			applicationStoreItemImpl.setApplicationCatalogueUrl(applicationCatalogueUrl);
		}

		if (applicationApplicationUrl == null) {
			applicationStoreItemImpl.setApplicationApplicationUrl(StringPool.BLANK);
		}
		else {
			applicationStoreItemImpl.setApplicationApplicationUrl(applicationApplicationUrl);
		}

		applicationStoreItemImpl.resetOriginalValues();

		return applicationStoreItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		applicationStoreItemId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		githash = objectInput.readUTF();

		depreciated = objectInput.readBoolean();
		applicationFolderName = objectInput.readUTF();
		applicationName = objectInput.readUTF();
		applicationShortName = objectInput.readUTF();
		applicationVersion = objectInput.readUTF();
		applicationReleaseState = objectInput.readUTF();
		applicationDescription = objectInput.readUTF();
		applicationCatalogueUrl = objectInput.readUTF();
		applicationApplicationUrl = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(applicationStoreItemId);

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

		if (githash == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(githash);
		}

		objectOutput.writeBoolean(depreciated);

		if (applicationFolderName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicationFolderName);
		}

		if (applicationName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicationName);
		}

		if (applicationShortName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicationShortName);
		}

		if (applicationVersion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicationVersion);
		}

		if (applicationReleaseState == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicationReleaseState);
		}

		if (applicationDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicationDescription);
		}

		if (applicationCatalogueUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicationCatalogueUrl);
		}

		if (applicationApplicationUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicationApplicationUrl);
		}
	}

	public long applicationStoreItemId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String githash;
	public boolean depreciated;
	public String applicationFolderName;
	public String applicationName;
	public String applicationShortName;
	public String applicationVersion;
	public String applicationReleaseState;
	public String applicationDescription;
	public String applicationCatalogueUrl;
	public String applicationApplicationUrl;
}