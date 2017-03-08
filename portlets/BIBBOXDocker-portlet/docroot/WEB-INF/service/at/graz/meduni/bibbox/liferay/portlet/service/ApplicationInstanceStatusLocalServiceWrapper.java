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
 * Provides a wrapper for {@link ApplicationInstanceStatusLocalService}.
 *
 * @author Robert Reihs
 * @see ApplicationInstanceStatusLocalService
 * @generated
 */
@ProviderType
public class ApplicationInstanceStatusLocalServiceWrapper
	implements ApplicationInstanceStatusLocalService,
		ServiceWrapper<ApplicationInstanceStatusLocalService> {
	public ApplicationInstanceStatusLocalServiceWrapper(
		ApplicationInstanceStatusLocalService applicationInstanceStatusLocalService) {
		_applicationInstanceStatusLocalService = applicationInstanceStatusLocalService;
	}

	/**
	* Adds the application instance status to the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstanceStatus the application instance status
	* @return the application instance status that was added
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus addApplicationInstanceStatus(
		at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus applicationInstanceStatus) {
		return _applicationInstanceStatusLocalService.addApplicationInstanceStatus(applicationInstanceStatus);
	}

	/**
	* Creates a new application instance status with the primary key. Does not add the application instance status to the database.
	*
	* @param applicationInstanceStatusId the primary key for the new application instance status
	* @return the new application instance status
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus createApplicationInstanceStatus(
		long applicationInstanceStatusId) {
		return _applicationInstanceStatusLocalService.createApplicationInstanceStatus(applicationInstanceStatusId);
	}

	/**
	* Deletes the application instance status from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstanceStatus the application instance status
	* @return the application instance status that was removed
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus deleteApplicationInstanceStatus(
		at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus applicationInstanceStatus) {
		return _applicationInstanceStatusLocalService.deleteApplicationInstanceStatus(applicationInstanceStatus);
	}

	/**
	* Deletes the application instance status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstanceStatusId the primary key of the application instance status
	* @return the application instance status that was removed
	* @throws PortalException if a application instance status with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus deleteApplicationInstanceStatus(
		long applicationInstanceStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationInstanceStatusLocalService.deleteApplicationInstanceStatus(applicationInstanceStatusId);
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus fetchApplicationInstanceStatus(
		long applicationInstanceStatusId) {
		return _applicationInstanceStatusLocalService.fetchApplicationInstanceStatus(applicationInstanceStatusId);
	}

	/**
	* Returns the application instance status with the primary key.
	*
	* @param applicationInstanceStatusId the primary key of the application instance status
	* @return the application instance status
	* @throws PortalException if a application instance status with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus getApplicationInstanceStatus(
		long applicationInstanceStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationInstanceStatusLocalService.getApplicationInstanceStatus(applicationInstanceStatusId);
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus getApplicationInstanceStatusByInstanceId(
		long applicationInstanceId) {
		return _applicationInstanceStatusLocalService.getApplicationInstanceStatusByInstanceId(applicationInstanceId);
	}

	/**
	* Updates the application instance status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param applicationInstanceStatus the application instance status
	* @return the application instance status that was updated
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus updateApplicationInstanceStatus(
		at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus applicationInstanceStatus) {
		return _applicationInstanceStatusLocalService.updateApplicationInstanceStatus(applicationInstanceStatus);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _applicationInstanceStatusLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _applicationInstanceStatusLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _applicationInstanceStatusLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationInstanceStatusLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _applicationInstanceStatusLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of application instance statuses.
	*
	* @return the number of application instance statuses
	*/
	@Override
	public int getApplicationInstanceStatusesCount() {
		return _applicationInstanceStatusLocalService.getApplicationInstanceStatusesCount();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _applicationInstanceStatusLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _applicationInstanceStatusLocalService.getOSGiServiceIdentifier();
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
		return _applicationInstanceStatusLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _applicationInstanceStatusLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _applicationInstanceStatusLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the application instance statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application instance statuses
	* @param end the upper bound of the range of application instance statuses (not inclusive)
	* @return the range of application instance statuses
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus> getApplicationInstanceStatuses(
		int start, int end) {
		return _applicationInstanceStatusLocalService.getApplicationInstanceStatuses(start,
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
		return _applicationInstanceStatusLocalService.dynamicQueryCount(dynamicQuery);
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
		return _applicationInstanceStatusLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public ApplicationInstanceStatusLocalService getWrappedService() {
		return _applicationInstanceStatusLocalService;
	}

	@Override
	public void setWrappedService(
		ApplicationInstanceStatusLocalService applicationInstanceStatusLocalService) {
		_applicationInstanceStatusLocalService = applicationInstanceStatusLocalService;
	}

	private ApplicationInstanceStatusLocalService _applicationInstanceStatusLocalService;
}