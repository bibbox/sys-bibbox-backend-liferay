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

import java.util.HashSet;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;

import aQute.bnd.annotation.ProviderType;
import at.graz.meduni.bibbox.docker.ApplicationStoreHelper;
import at.graz.meduni.bibbox.helper.FormatExceptionMessage;
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
	
	/**
	 * Error Format for date
	 */
	private String log_portlet_ = "BIBBOXDocker";
	private String log_classname_ = "at.graz.meduni.bibbox.liferay.portlet.service.impl.ApplicationStoreItemServiceImpl";
	
	@JSONWebService("/get-application-store-list")
	public JSONObject getApplicationStoreListAPI() {
		return getApplicationStoreList();
	}
	
	@JSONWebService("/get-application-store-updated-list")
	public JSONObject getApplicationStoreUpdatedListAPI() {
		ApplicationStoreHelper applicationstorehelper = new ApplicationStoreHelper();
		applicationstorehelper.loadApplicationStoreItems();
		return getApplicationStoreList();
	}
	
	@JSONWebService("/get-application-store-item")
	public JSONObject getApplicationStoreItemAPI(long applicationstoreitemId) {
		return getApplicationStoreItem(applicationstoreitemId);
	}
	
	private JSONObject getApplicationStoreItem(long applicationstoreitemId) {
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
			applicationstoreitemjsonobject.put("group", applicationstoreitem.getKitGroupForKit("eB3Kit"));
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return applicationstoreitemjsonobject;
	}
	
	private JSONObject getApplicationStoreList() {
		JSONObject applicationstorejsonobject = JSONFactoryUtil.createJSONObject();
		applicationstorejsonobject.put("groups", getApplicationStoreGroupList());
		applicationstorejsonobject.put("tools", getApplicationStoreItemList());
		return applicationstorejsonobject;
	}
	
	private JSONArray getApplicationStoreGroupList() {
		JSONArray application_store_list = JSONFactoryUtil.createJSONArray();
		JSONObject g1 = JSONFactoryUtil.createJSONObject();
		JSONObject g2 = JSONFactoryUtil.createJSONObject();
		JSONObject g3 = JSONFactoryUtil.createJSONObject();
		g1.put("order", "1");
		g1.put("id", "biobank");
		g1.put("name", "Biobank Apps");
		g2.put("order", "2");
		g2.put("id", "bioinformatics");
		g2.put("name", "Bioinformatics Apps");
		g3.put("order", "2");
		g3.put("id", "helper");
		g3.put("name", "Helper Apps");
		application_store_list.put(g1);
		application_store_list.put(g2);
		application_store_list.put(g3);
		return application_store_list;
	}
	
	private JSONArray getApplicationStoreItemList() {
		JSONArray application_store_list = JSONFactoryUtil.createJSONArray();
		List<ApplicationStoreItem> applicationstoreitems = ApplicationStoreItemLocalServiceUtil.getApplicationStoreItems(-1, -1);
		for(ApplicationStoreItem applicationstoreitem : applicationstoreitems) {
			if(!applicationstoreitem.getDepreciated()) {
				application_store_list.put(getApplicationStoreItemListInformation(applicationstoreitem));
			}
		}
		return application_store_list;
	}
	
	private JSONObject getApplicationStoreItemListInformation(ApplicationStoreItem applicationstoreitem) {
		JSONObject applicationstoreitemjsonobject = JSONFactoryUtil.createJSONObject();
		applicationstoreitemjsonobject.put("id", applicationstoreitem.getApplicationStoreItemId());
		applicationstoreitemjsonobject.put("name", applicationstoreitem.getApplicationName());
		applicationstoreitemjsonobject.put("shortname", applicationstoreitem.getApplicationShortName());
		applicationstoreitemjsonobject.put("group", applicationstoreitem.getKitGroupForKit("eB3Kit"));
		applicationstoreitemjsonobject.put("description", applicationstoreitem.getApplicationDescription());
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