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
 * Provides a wrapper for {@link ApplicationInstancePortLocalService}.
 *
 * @author Robert Reihs
 * @see ApplicationInstancePortLocalService
 * @generated
 */
@ProviderType
public class ApplicationInstancePortLocalServiceWrapper
	implements ApplicationInstancePortLocalService,
		ServiceWrapper<ApplicationInstancePortLocalService> {
	public ApplicationInstancePortLocalServiceWrapper(
		ApplicationInstancePortLocalService applicationInstancePortLocalService) {
		_applicationInstancePortLocalService = applicationInstancePortLocalService;
	}

	/**
	* Adds the application instance port to the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstancePort the application instance port
	* @return the application instance port that was added
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort addApplicationInstancePort(
		at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort applicationInstancePort) {
		return _applicationInstancePortLocalService.addApplicationInstancePort(applicationInstancePort);
	}

	/**
	* Creates a new application instance port with the primary key. Does not add the application instance port to the database.
	*
	* @param applicationInstancePortId the primary key for the new application instance port
	* @return the new application instance port
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort createApplicationInstancePort(
		long applicationInstancePortId) {
		return _applicationInstancePortLocalService.createApplicationInstancePort(applicationInstancePortId);
	}

	/**
	* Deletes the application instance port from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstancePort the application instance port
	* @return the application instance port that was removed
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort deleteApplicationInstancePort(
		at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort applicationInstancePort) {
		return _applicationInstancePortLocalService.deleteApplicationInstancePort(applicationInstancePort);
	}

	/**
	* Deletes the application instance port with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstancePortId the primary key of the application instance port
	* @return the application instance port that was removed
	* @throws PortalException if a application instance port with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort deleteApplicationInstancePort(
		long applicationInstancePortId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationInstancePortLocalService.deleteApplicationInstancePort(applicationInstancePortId);
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort fetchApplicationInstancePort(
		long applicationInstancePortId) {
		return _applicationInstancePortLocalService.fetchApplicationInstancePort(applicationInstancePortId);
	}

	/**
	* Returns the application instance port with the primary key.
	*
	* @param applicationInstancePortId the primary key of the application instance port
	* @return the application instance port
	* @throws PortalException if a application instance port with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort getApplicationInstancePort(
		long applicationInstancePortId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationInstancePortLocalService.getApplicationInstancePort(applicationInstancePortId);
	}

	/**
	* Updates the application instance port in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param applicationInstancePort the application instance port
	* @return the application instance port that was updated
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort updateApplicationInstancePort(
		at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort applicationInstancePort) {
		return _applicationInstancePortLocalService.updateApplicationInstancePort(applicationInstancePort);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _applicationInstancePortLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _applicationInstancePortLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _applicationInstancePortLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationInstancePortLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationInstancePortLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of application instance ports.
	*
	* @return the number of application instance ports
	*/
	@Override
	public int getApplicationInstancePortsCount() {
		return _applicationInstancePortLocalService.getApplicationInstancePortsCount();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _applicationInstancePortLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _applicationInstancePortLocalService.getOSGiServiceIdentifier();
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
		return _applicationInstancePortLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstancePortModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _applicationInstancePortLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstancePortModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _applicationInstancePortLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the application instance ports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstancePortModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application instance ports
	* @param end the upper bound of the range of application instance ports (not inclusive)
	* @return the range of application instance ports
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort> getApplicationInstancePorts(
		int start, int end) {
		return _applicationInstancePortLocalService.getApplicationInstancePorts(start,
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
		return _applicationInstancePortLocalService.dynamicQueryCount(dynamicQuery);
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
		return _applicationInstancePortLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public long getPrimaryPortForInstance(long applicationInstanceId) {
		return _applicationInstancePortLocalService.getPrimaryPortForInstance(applicationInstanceId);
	}

	@Override
	public ApplicationInstancePortLocalService getWrappedService() {
		return _applicationInstancePortLocalService;
	}

	@Override
	public void setWrappedService(
		ApplicationInstancePortLocalService applicationInstancePortLocalService) {
		_applicationInstancePortLocalService = applicationInstancePortLocalService;
	}

	private ApplicationInstancePortLocalService _applicationInstancePortLocalService;
}