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
 * Provides a wrapper for {@link ApplicationInstanceContainerLocalService}.
 *
 * @author Robert Reihs
 * @see ApplicationInstanceContainerLocalService
 * @generated
 */
@ProviderType
public class ApplicationInstanceContainerLocalServiceWrapper
	implements ApplicationInstanceContainerLocalService,
		ServiceWrapper<ApplicationInstanceContainerLocalService> {
	public ApplicationInstanceContainerLocalServiceWrapper(
		ApplicationInstanceContainerLocalService applicationInstanceContainerLocalService) {
		_applicationInstanceContainerLocalService = applicationInstanceContainerLocalService;
	}

	/**
	* Adds the application instance container to the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstanceContainer the application instance container
	* @return the application instance container that was added
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer addApplicationInstanceContainer(
		at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer applicationInstanceContainer) {
		return _applicationInstanceContainerLocalService.addApplicationInstanceContainer(applicationInstanceContainer);
	}

	/**
	* Creates a new application instance container with the primary key. Does not add the application instance container to the database.
	*
	* @param applicationInstanceContainerId the primary key for the new application instance container
	* @return the new application instance container
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer createApplicationInstanceContainer(
		long applicationInstanceContainerId) {
		return _applicationInstanceContainerLocalService.createApplicationInstanceContainer(applicationInstanceContainerId);
	}

	/**
	* Deletes the application instance container from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstanceContainer the application instance container
	* @return the application instance container that was removed
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer deleteApplicationInstanceContainer(
		at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer applicationInstanceContainer) {
		return _applicationInstanceContainerLocalService.deleteApplicationInstanceContainer(applicationInstanceContainer);
	}

	/**
	* Deletes the application instance container with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstanceContainerId the primary key of the application instance container
	* @return the application instance container that was removed
	* @throws PortalException if a application instance container with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer deleteApplicationInstanceContainer(
		long applicationInstanceContainerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationInstanceContainerLocalService.deleteApplicationInstanceContainer(applicationInstanceContainerId);
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer fetchApplicationInstanceContainer(
		long applicationInstanceContainerId) {
		return _applicationInstanceContainerLocalService.fetchApplicationInstanceContainer(applicationInstanceContainerId);
	}

	/**
	* Returns the application instance container with the primary key.
	*
	* @param applicationInstanceContainerId the primary key of the application instance container
	* @return the application instance container
	* @throws PortalException if a application instance container with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer getApplicationInstanceContainer(
		long applicationInstanceContainerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationInstanceContainerLocalService.getApplicationInstanceContainer(applicationInstanceContainerId);
	}

	/**
	* Updates the application instance container in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param applicationInstanceContainer the application instance container
	* @return the application instance container that was updated
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer updateApplicationInstanceContainer(
		at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer applicationInstanceContainer) {
		return _applicationInstanceContainerLocalService.updateApplicationInstanceContainer(applicationInstanceContainer);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _applicationInstanceContainerLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _applicationInstanceContainerLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _applicationInstanceContainerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationInstanceContainerLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationInstanceContainerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of application instance containers.
	*
	* @return the number of application instance containers
	*/
	@Override
	public int getApplicationInstanceContainersCount() {
		return _applicationInstanceContainerLocalService.getApplicationInstanceContainersCount();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _applicationInstanceContainerLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _applicationInstanceContainerLocalService.getOSGiServiceIdentifier();
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
		return _applicationInstanceContainerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _applicationInstanceContainerLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _applicationInstanceContainerLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer> getApplicationInstanceContainerForInstance(
		long applicationinstanceId) {
		return _applicationInstanceContainerLocalService.getApplicationInstanceContainerForInstance(applicationinstanceId);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer> getApplicationInstanceContainerNeedToRun(
		long applicationinstanceId) {
		return _applicationInstanceContainerLocalService.getApplicationInstanceContainerNeedToRun(applicationinstanceId);
	}

	/**
	* Returns a range of all the application instance containers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application instance containers
	* @param end the upper bound of the range of application instance containers (not inclusive)
	* @return the range of application instance containers
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer> getApplicationInstanceContainers(
		int start, int end) {
		return _applicationInstanceContainerLocalService.getApplicationInstanceContainers(start,
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
		return _applicationInstanceContainerLocalService.dynamicQueryCount(dynamicQuery);
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
		return _applicationInstanceContainerLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public ApplicationInstanceContainerLocalService getWrappedService() {
		return _applicationInstanceContainerLocalService;
	}

	@Override
	public void setWrappedService(
		ApplicationInstanceContainerLocalService applicationInstanceContainerLocalService) {
		_applicationInstanceContainerLocalService = applicationInstanceContainerLocalService;
	}

	private ApplicationInstanceContainerLocalService _applicationInstanceContainerLocalService;
}