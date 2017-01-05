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

package at.graz.meduni.liferay.portlet.saat.model.impl;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.liferay.portlet.saat.model.Dictionary;

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
 * The cache model class for representing Dictionary in entity cache.
 *
 * @author reihsr
 * @see Dictionary
 * @generated
 */
@ProviderType
public class DictionaryCacheModel implements CacheModel<Dictionary>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DictionaryCacheModel)) {
			return false;
		}

		DictionaryCacheModel dictionaryCacheModel = (DictionaryCacheModel)obj;

		if (dictionaryId == dictionaryCacheModel.dictionaryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, dictionaryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{dictionaryId=");
		sb.append(dictionaryId);
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
		sb.append(", isroot=");
		sb.append(isroot);
		sb.append(", iscode=");
		sb.append(iscode);
		sb.append(", synonym=");
		sb.append(synonym);
		sb.append(", pattern=");
		sb.append(pattern);
		sb.append(", beforSynonym=");
		sb.append(beforSynonym);
		sb.append(", afterSynonym=");
		sb.append(afterSynonym);
		sb.append(", foreword=");
		sb.append(foreword);
		sb.append(", ending=");
		sb.append(ending);
		sb.append(", sentence=");
		sb.append(sentence);
		sb.append(", occure=");
		sb.append(occure);
		sb.append(", nagation=");
		sb.append(nagation);
		sb.append(", priority_mode=");
		sb.append(priority_mode);
		sb.append(", codeType=");
		sb.append(codeType);
		sb.append(", codeValue=");
		sb.append(codeValue);
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", disease_ids=");
		sb.append(disease_ids);
		sb.append(", dirty=");
		sb.append(dirty);
		sb.append(", disease_ids_count=");
		sb.append(disease_ids_count);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Dictionary toEntityModel() {
		DictionaryImpl dictionaryImpl = new DictionaryImpl();

		dictionaryImpl.setDictionaryId(dictionaryId);
		dictionaryImpl.setCompanyId(companyId);
		dictionaryImpl.setUserId(userId);

		if (userName == null) {
			dictionaryImpl.setUserName(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			dictionaryImpl.setCreateDate(null);
		}
		else {
			dictionaryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dictionaryImpl.setModifiedDate(null);
		}
		else {
			dictionaryImpl.setModifiedDate(new Date(modifiedDate));
		}

		dictionaryImpl.setIsroot(isroot);
		dictionaryImpl.setIscode(iscode);

		if (synonym == null) {
			dictionaryImpl.setSynonym(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setSynonym(synonym);
		}

		if (pattern == null) {
			dictionaryImpl.setPattern(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setPattern(pattern);
		}

		dictionaryImpl.setBeforSynonym(beforSynonym);
		dictionaryImpl.setAfterSynonym(afterSynonym);
		dictionaryImpl.setForeword(foreword);
		dictionaryImpl.setEnding(ending);
		dictionaryImpl.setSentence(sentence);
		dictionaryImpl.setOccure(occure);
		dictionaryImpl.setNagation(nagation);
		dictionaryImpl.setPriority_mode(priority_mode);

		if (codeType == null) {
			dictionaryImpl.setCodeType(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setCodeType(codeType);
		}

		if (codeValue == null) {
			dictionaryImpl.setCodeValue(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setCodeValue(codeValue);
		}

		dictionaryImpl.setPriority(priority);

		if (disease_ids == null) {
			dictionaryImpl.setDisease_ids(StringPool.BLANK);
		}
		else {
			dictionaryImpl.setDisease_ids(disease_ids);
		}

		dictionaryImpl.setDirty(dirty);
		dictionaryImpl.setDisease_ids_count(disease_ids_count);

		dictionaryImpl.resetOriginalValues();

		return dictionaryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dictionaryId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		isroot = objectInput.readBoolean();

		iscode = objectInput.readBoolean();
		synonym = objectInput.readUTF();
		pattern = objectInput.readUTF();

		beforSynonym = objectInput.readLong();

		afterSynonym = objectInput.readLong();

		foreword = objectInput.readBoolean();

		ending = objectInput.readBoolean();

		sentence = objectInput.readBoolean();

		occure = objectInput.readBoolean();

		nagation = objectInput.readBoolean();

		priority_mode = objectInput.readBoolean();
		codeType = objectInput.readUTF();
		codeValue = objectInput.readUTF();

		priority = objectInput.readLong();
		disease_ids = objectInput.readUTF();

		dirty = objectInput.readBoolean();

		disease_ids_count = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dictionaryId);

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

		objectOutput.writeBoolean(isroot);

		objectOutput.writeBoolean(iscode);

		if (synonym == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(synonym);
		}

		if (pattern == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pattern);
		}

		objectOutput.writeLong(beforSynonym);

		objectOutput.writeLong(afterSynonym);

		objectOutput.writeBoolean(foreword);

		objectOutput.writeBoolean(ending);

		objectOutput.writeBoolean(sentence);

		objectOutput.writeBoolean(occure);

		objectOutput.writeBoolean(nagation);

		objectOutput.writeBoolean(priority_mode);

		if (codeType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codeType);
		}

		if (codeValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codeValue);
		}

		objectOutput.writeLong(priority);

		if (disease_ids == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(disease_ids);
		}

		objectOutput.writeBoolean(dirty);

		objectOutput.writeLong(disease_ids_count);
	}

	public long dictionaryId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean isroot;
	public boolean iscode;
	public String synonym;
	public String pattern;
	public long beforSynonym;
	public long afterSynonym;
	public boolean foreword;
	public boolean ending;
	public boolean sentence;
	public boolean occure;
	public boolean nagation;
	public boolean priority_mode;
	public String codeType;
	public String codeValue;
	public long priority;
	public String disease_ids;
	public boolean dirty;
	public long disease_ids_count;
}