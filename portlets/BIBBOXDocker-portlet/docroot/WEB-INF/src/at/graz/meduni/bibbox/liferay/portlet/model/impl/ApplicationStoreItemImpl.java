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

import java.util.List;

import aQute.bnd.annotation.ProviderType;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag;
import at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit;
import at.graz.meduni.bibbox.liferay.portlet.model.KitGroup;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationStoreItemLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationTagLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.BibboxKitLocalServiceUtil;
import at.graz.meduni.bibbox.liferay.portlet.service.KitGroupLocalServiceUtil;

/**
 * The extended model implementation for the ApplicationStoreItem service. Represents a row in the &quot;bibboxdocker_ApplicationStoreItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link at.graz.meduni.bibbox.liferay.portlet.model.ApplicationStoreItem} interface.
 * </p>
 *
 * @author Robert Reihs
 */
@ProviderType
public class ApplicationStoreItemImpl extends ApplicationStoreItemBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a application store item model instance should use the {@link at.graz.meduni.bibbox.liferay.portlet.model.ApplicationStoreItem} interface instead.
	 */
	public ApplicationStoreItemImpl() {
	}
	
	public List<ApplicationTag> getApplicationTags() {
		return ApplicationTagLocalServiceUtil.getApplicationTags(this.getApplicationStoreItemId());
	}
	
	public List<BibboxKit> getBibboxKits() {
		return BibboxKitLocalServiceUtil.getBibboxKits(this.getApplicationStoreItemId());
	}
	
	public List<KitGroup> getKitGroups() {
		return KitGroupLocalServiceUtil.getKitGroups(this.getApplicationStoreItemId());
	}
	
	public String getKitGroupForKit(String kitname) {
		List<BibboxKit> bibboxkits = getBibboxKits();
		for(BibboxKit bibboxkit : bibboxkits) {
			if(bibboxkit.getKitName().equals(kitname)) {
				KitGroup kitgroup = KitGroupLocalServiceUtil.getKitGroup(this.getApplicationStoreItemId(), bibboxkit.getBibboxKitId());
				if(kitgroup != null) {
					return kitgroup.getBibboxKitName();
				}
			}
		}
		return "";
	}
}