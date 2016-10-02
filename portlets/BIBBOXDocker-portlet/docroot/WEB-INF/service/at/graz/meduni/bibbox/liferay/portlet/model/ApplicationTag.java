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
 * The extended model interface for the ApplicationTag service. Represents a row in the &quot;bibboxdocker_ApplicationTag&quot; database table, with each column mapped to a property of this class.
 *
 * @author Robert Reihs
 * @see ApplicationTagModel
 * @see at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationTagImpl
 * @see at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationTagModelImpl
 * @generated
 */
@ImplementationClassName("at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationTagImpl")
@ProviderType
public interface ApplicationTag extends ApplicationTagModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationTagImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ApplicationTag, Long> APPLICATION_TAGS_ID_ACCESSOR =
		new Accessor<ApplicationTag, Long>() {
			@Override
			public Long get(ApplicationTag applicationTag) {
				return applicationTag.getApplicationTagsId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ApplicationTag> getTypeClass() {
				return ApplicationTag.class;
			}
		};
}