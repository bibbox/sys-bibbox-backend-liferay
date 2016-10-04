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

package at.graz.meduni.bibbox.liferay.portlet.service.impl;

import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

import aQute.bnd.annotation.ProviderType;
import at.graz.meduni.bibbox.docker.ApplicationStoreHelper;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationStoreItem;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag;
import at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationStoreItemLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationTagLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.BibboxKitLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.base.ApplicationStoreItemServiceBaseImpl;

/**
 * The implementation of the application store item remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.bibbox.liferay.portlet.service.ApplicationStoreItemService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationStoreItemServiceBaseImpl
 * @see at.graz.meduni.bibbox.liferay.portlet.service.ApplicationStoreItemServiceUtil
 */
@ProviderType
public class ApplicationStoreItemServiceImpl
	extends ApplicationStoreItemServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link at.graz.meduni.bibbox.liferay.portlet.service.ApplicationStoreItemServiceUtil} to access the application store item remote service.
	 */
	
	@JSONWebService("/get-application-store-list")
	public JSONArray getApplicationStoreListAPI() {
		return getApplicationStoreList();
	}
	
	@JSONWebService("/get-application-store-updated-list")
	public JSONArray getApplicationStoreUpdatedListAPI() {
		ApplicationStoreHelper applicationstorehelper = new ApplicationStoreHelper();
		applicationstorehelper.loadApplicationStoreItems();
		return getApplicationStoreList();
	}
	
	@JSONWebService("/get-application-store-item")
	public JSONObject getApplicationStoreItemAPI(long applicationstoreitemId) {
		return getApplicationStoreItem(applicationstoreitemId);
	}
	
	public JSONObject getApplicationStoreItem(long applicationstoreitemId) {
		JSONObject applicationstoreitemjsonobject = JSONFactoryUtil.createJSONObject();
		try {
			ApplicationStoreItem applicationstoreitem = ApplicationStoreItemLocalServiceUtil.getApplicationStoreItem(applicationstoreitemId);
			applicationstoreitemjsonobject.put("id", applicationstoreitem.getApplicationStoreItemId());
			applicationstoreitemjsonobject.put("name", applicationstoreitem.getApplicationName());
			applicationstoreitemjsonobject.put("shortname", applicationstoreitem.getApplicationShortName());
			applicationstoreitemjsonobject.put("description", applicationstoreitem.getApplicationDescription());
			applicationstoreitemjsonobject.put("applicationurl", applicationstoreitem.getApplicationApplicationUrl());
			applicationstoreitemjsonobject.put("catalogueurl", applicationstoreitem.getApplicationCatalogueUrl());
			applicationstoreitemjsonobject.put("releasestate", applicationstoreitem.getApplicationReleaseState());
			applicationstoreitemjsonobject.put("version", applicationstoreitem.getApplicationVersion());
			applicationstoreitemjsonobject.put("tags", getApplicationStoreItemTags(applicationstoreitem));
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return applicationstoreitemjsonobject;
	}
	
	public void addApplicationStoreItem(String name, String shortname, String version, String release_state, String description, String catalogue_url, String application_url, String kits, String tags) {
		ApplicationStoreItem applicationstoreitem = ApplicationStoreItemLocalServiceUtil.createApplicationStoreItem(CounterLocalServiceUtil.increment());
		applicationstoreitem.setApplicationName(name);
		applicationstoreitem.setApplicationShortName(shortname);
		applicationstoreitem.setApplicationVersion(version);
		applicationstoreitem.setApplicationReleaseState(release_state);
		applicationstoreitem.setApplicationDescription(description);
		applicationstoreitem.setApplicationCatalogueUrl(catalogue_url);
		applicationstoreitem.setApplicationApplicationUrl(application_url);
		ApplicationStoreItemLocalServiceUtil.updateApplicationStoreItem(applicationstoreitem);
		for(String kit : kits.split(";")) {
			BibboxKit bibboxkit = BibboxKitLocalServiceUtil.createBibboxKit(CounterLocalServiceUtil.increment());
			bibboxkit.setApplicationStoreItemId(applicationstoreitem.getApplicationStoreItemId());
			bibboxkit.setKitName(kit);
			BibboxKitLocalServiceUtil.updateBibboxKit(bibboxkit);
		}
		for(String tag : tags.split(";")) {
			ApplicationTag applicationtag = ApplicationTagLocalServiceUtil.createApplicationTag(CounterLocalServiceUtil.increment());
			applicationtag.setApplicationStoreItemId(applicationstoreitem.getApplicationStoreItemId());
			applicationtag.setTag(tag);
			ApplicationTagLocalServiceUtil.updateApplicationTag(applicationtag);
		}
	}
	
	private JSONArray getApplicationStoreList() {
		JSONArray application_store_list = JSONFactoryUtil.createJSONArray();
		List<ApplicationStoreItem> applicationstoreitems = ApplicationStoreItemLocalServiceUtil.getApplicationStoreItems(-1, -1);
		for(ApplicationStoreItem applicationstoreitem : applicationstoreitems) {
			application_store_list.put(getApplicationStoreItemListInformation(applicationstoreitem));
		}
		return application_store_list;
	}
	
	private JSONObject getApplicationStoreItemListInformation(ApplicationStoreItem applicationstoreitem) {
		JSONObject applicationstoreitemjsonobject = JSONFactoryUtil.createJSONObject();
		applicationstoreitemjsonobject.put("id", applicationstoreitem.getApplicationStoreItemId());
		applicationstoreitemjsonobject.put("name", applicationstoreitem.getApplicationShortName());
		applicationstoreitemjsonobject.put("tags", getApplicationStoreItemTags(applicationstoreitem));
		return applicationstoreitemjsonobject;
	}
	
	private JSONArray getApplicationStoreItemTags(ApplicationStoreItem applicationstoreitem) {
		JSONArray tag_list = JSONFactoryUtil.createJSONArray();
		List<ApplicationTag> applicationtags = applicationstoreitem.getApplicationTags();
		for(ApplicationTag applicationtag : applicationtags) {
			tag_list.put(applicationtag.getTag());
		}
		return tag_list;
	}
}