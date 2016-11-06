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
 * The extended model interface for the ApplicationInstancePort service. Represents a row in the &quot;bibboxdocker_ApplicationInstancePort&quot; database table, with each column mapped to a property of this class.
 *
 * @author Robert Reihs
 * @see ApplicationInstancePortModel
 * @see at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstancePortImpl
 * @see at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstancePortModelImpl
 * @generated
 */
@ImplementationClassName("at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstancePortImpl")
@ProviderType
public interface ApplicationInstancePort extends ApplicationInstancePortModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstancePortImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ApplicationInstancePort, Long> APPLICATION_INSTANCE_PORT_ID_ACCESSOR =
		new Accessor<ApplicationInstancePort, Long>() {
			@Override
			public Long get(ApplicationInstancePort applicationInstancePort) {
				return applicationInstancePort.getApplicationInstancePortId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ApplicationInstancePort> getTypeClass() {
				return ApplicationInstancePort.class;
			}
		};
}