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

package at.graz.meduni.bibbox.liferay.portlet.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the BibboxKit service. Represents a row in the &quot;bibboxdocker_BibboxKit&quot; database table, with each column mapped to a property of this class.
 *
 * @author Robert Reihs
 * @see BibboxKitModel
 * @see at.graz.meduni.bibbox.liferay.portlet.model.impl.BibboxKitImpl
 * @see at.graz.meduni.bibbox.liferay.portlet.model.impl.BibboxKitModelImpl
 * @generated
 */
@ImplementationClassName("at.graz.meduni.bibbox.liferay.portlet.model.impl.BibboxKitImpl")
@ProviderType
public interface BibboxKit extends BibboxKitModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.BibboxKitImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<BibboxKit, Long> BIBBOX_KIT_ID_ACCESSOR = new Accessor<BibboxKit, Long>() {
			@Override
			public Long get(BibboxKit bibboxKit) {
				return bibboxKit.getBibboxKitId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<BibboxKit> getTypeClass() {
				return BibboxKit.class;
			}
		};
}