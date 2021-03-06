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
 * The extended model interface for the ApplicationInstance service. Represents a row in the &quot;bibboxdocker_ApplicationInstance&quot; database table, with each column mapped to a property of this class.
 *
 * @author Robert Reihs
 * @see ApplicationInstanceModel
 * @see at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceImpl
 * @see at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceModelImpl
 * @generated
 */
@ImplementationClassName("at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceImpl")
@ProviderType
public interface ApplicationInstance extends ApplicationInstanceModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ApplicationInstance, Long> APPLICATION_INSTANCE_ID_ACCESSOR =
		new Accessor<ApplicationInstance, Long>() {
			@Override
			public Long get(ApplicationInstance applicationInstance) {
				return applicationInstance.getApplicationInstanceId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ApplicationInstance> getTypeClass() {
				return ApplicationInstance.class;
			}
		};

	public java.lang.String getBaseInstallationConfigString();

	public java.lang.String getBasicProxyConfigString();

	public java.lang.String getFolderPath();

	public long getPrimaryPort();

	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort> getApplicationPorts();

	public java.lang.String stopApplicationInstance();

	public java.lang.String startApplicationInstance();

	public java.lang.String restartApplicationInstance();

	public java.lang.String composeUpApplicationInstance();

	public java.lang.String composePullApplicationInstance();

	public com.liferay.portal.kernel.json.JSONArray getComposeLog(
		java.lang.String lines);

	public com.liferay.portal.kernel.json.JSONObject getInstanceJSONObject();

	public java.lang.String getInstanceUrl();

	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer> getContainersNeedToRun();

	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer> getContainers();

	public java.lang.String getApplicationStatus();

	public java.lang.String getApplicationname();

	public com.liferay.portal.kernel.json.JSONArray getApplicationTags();

	public com.liferay.portal.kernel.json.JSONObject getMetadataInformationAPP();
}