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

package at.graz.meduni.bibbox.liferay.portlet.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ApplicationInstanceLocalService}.
 *
 * @author Robert Reihs
 * @see ApplicationInstanceLocalService
 * @generated
 */
@ProviderType
public class ApplicationInstanceLocalServiceWrapper
	implements ApplicationInstanceLocalService,
		ServiceWrapper<ApplicationInstanceLocalService> {
	public ApplicationInstanceLocalServiceWrapper(
		ApplicationInstanceLocalService applicationInstanceLocalService) {
		_applicationInstanceLocalService = applicationInstanceLocalService;
	}

	/**
	* Adds the application instance to the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstance the application instance
	* @return the application instance that was added
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance addApplicationInstance(
		at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance applicationInstance) {
		return _applicationInstanceLocalService.addApplicationInstance(applicationInstance);
	}

	/**
	* Creates a new application instance with the primary key. Does not add the application instance to the database.
	*
	* @param applicationInstanceId the primary key for the new application instance
	* @return the new application instance
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance createApplicationInstance(
		long applicationInstanceId) {
		return _applicationInstanceLocalService.createApplicationInstance(applicationInstanceId);
	}

	/**
	* Deletes the application instance from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstance the application instance
	* @return the application instance that was removed
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance deleteApplicationInstance(
		at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance applicationInstance) {
		return _applicationInstanceLocalService.deleteApplicationInstance(applicationInstance);
	}

	/**
	* Deletes the application instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstanceId the primary key of the application instance
	* @return the application instance that was removed
	* @throws PortalException if a application instance with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance deleteApplicationInstance(
		long applicationInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationInstanceLocalService.deleteApplicationInstance(applicationInstanceId);
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance fetchApplicationInstance(
		long applicationInstanceId) {
		return _applicationInstanceLocalService.fetchApplicationInstance(applicationInstanceId);
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance getApplicationInstance(
		java.lang.String instanceId) {
		return _applicationInstanceLocalService.getApplicationInstance(instanceId);
	}

	/**
	* Returns the application instance with the primary key.
	*
	* @param applicationInstanceId the primary key of the application instance
	* @return the application instance
	* @throws PortalException if a application instance with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance getApplicationInstance(
		long applicationInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationInstanceLocalService.getApplicationInstance(applicationInstanceId);
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance registerApplication(
		java.lang.String applicationname, java.lang.String version,
		java.lang.String instanceid, java.lang.String instancename) {
		return _applicationInstanceLocalService.registerApplication(applicationname,
			version, instanceid, instancename);
	}

	/**
	* Updates the application instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param applicationInstance the application instance
	* @return the application instance that was updated
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance updateApplicationInstance(
		at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance applicationInstance) {
		return _applicationInstanceLocalService.updateApplicationInstance(applicationInstance);
	}

	@Override
	public boolean checkInstanceNameAvailable(java.lang.String instanceId) {
		return _applicationInstanceLocalService.checkInstanceNameAvailable(instanceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _applicationInstanceLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _applicationInstanceLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _applicationInstanceLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getUsedInstanceIds() {
		return _applicationInstanceLocalService.getUsedInstanceIds();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationInstanceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationInstanceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of application instances.
	*
	* @return the number of application instances
	*/
	@Override
	public int getApplicationInstancesCount() {
		return _applicationInstanceLocalService.getApplicationInstancesCount();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _applicationInstanceLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _applicationInstanceLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _applicationInstanceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _applicationInstanceLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _applicationInstanceLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance> getActiveApplicationInstances() {
		return _applicationInstanceLocalService.getActiveApplicationInstances();
	}

	/**
	* Returns a range of all the application instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application instances
	* @param end the upper bound of the range of application instances (not inclusive)
	* @return the range of application instances
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance> getApplicationInstances(
		int start, int end) {
		return _applicationInstanceLocalService.getApplicationInstances(start,
			end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _applicationInstanceLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _applicationInstanceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public ApplicationInstanceLocalService getWrappedService() {
		return _applicationInstanceLocalService;
	}

	@Override
	public void setWrappedService(
		ApplicationInstanceLocalService applicationInstanceLocalService) {
		_applicationInstanceLocalService = applicationInstanceLocalService;
	}

	private ApplicationInstanceLocalService _applicationInstanceLocalService;
}