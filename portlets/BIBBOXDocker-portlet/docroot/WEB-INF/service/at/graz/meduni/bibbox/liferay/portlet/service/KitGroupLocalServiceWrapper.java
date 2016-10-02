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
 * Provides a wrapper for {@link KitGroupLocalService}.
 *
 * @author Robert Reihs
 * @see KitGroupLocalService
 * @generated
 */
@ProviderType
public class KitGroupLocalServiceWrapper implements KitGroupLocalService,
	ServiceWrapper<KitGroupLocalService> {
	public KitGroupLocalServiceWrapper(
		KitGroupLocalService kitGroupLocalService) {
		_kitGroupLocalService = kitGroupLocalService;
	}

	/**
	* Adds the kit group to the database. Also notifies the appropriate model listeners.
	*
	* @param kitGroup the kit group
	* @return the kit group that was added
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.KitGroup addKitGroup(
		at.graz.meduni.bibbox.liferay.portlet.model.KitGroup kitGroup) {
		return _kitGroupLocalService.addKitGroup(kitGroup);
	}

	/**
	* Creates a new kit group with the primary key. Does not add the kit group to the database.
	*
	* @param kitGroupId the primary key for the new kit group
	* @return the new kit group
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.KitGroup createKitGroup(
		long kitGroupId) {
		return _kitGroupLocalService.createKitGroup(kitGroupId);
	}

	/**
	* Deletes the kit group from the database. Also notifies the appropriate model listeners.
	*
	* @param kitGroup the kit group
	* @return the kit group that was removed
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.KitGroup deleteKitGroup(
		at.graz.meduni.bibbox.liferay.portlet.model.KitGroup kitGroup) {
		return _kitGroupLocalService.deleteKitGroup(kitGroup);
	}

	/**
	* Deletes the kit group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param kitGroupId the primary key of the kit group
	* @return the kit group that was removed
	* @throws PortalException if a kit group with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.KitGroup deleteKitGroup(
		long kitGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _kitGroupLocalService.deleteKitGroup(kitGroupId);
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.KitGroup fetchKitGroup(
		long kitGroupId) {
		return _kitGroupLocalService.fetchKitGroup(kitGroupId);
	}

	/**
	* Returns the kit group with the primary key.
	*
	* @param kitGroupId the primary key of the kit group
	* @return the kit group
	* @throws PortalException if a kit group with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.KitGroup getKitGroup(
		long kitGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _kitGroupLocalService.getKitGroup(kitGroupId);
	}

	/**
	* Updates the kit group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param kitGroup the kit group
	* @return the kit group that was updated
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.KitGroup updateKitGroup(
		at.graz.meduni.bibbox.liferay.portlet.model.KitGroup kitGroup) {
		return _kitGroupLocalService.updateKitGroup(kitGroup);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _kitGroupLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _kitGroupLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _kitGroupLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _kitGroupLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _kitGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of kit groups.
	*
	* @return the number of kit groups
	*/
	@Override
	public int getKitGroupsCount() {
		return _kitGroupLocalService.getKitGroupsCount();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _kitGroupLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _kitGroupLocalService.getOSGiServiceIdentifier();
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
		return _kitGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _kitGroupLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _kitGroupLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the kit groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kit groups
	* @param end the upper bound of the range of kit groups (not inclusive)
	* @return the range of kit groups
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.KitGroup> getKitGroups(
		int start, int end) {
		return _kitGroupLocalService.getKitGroups(start, end);
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
		return _kitGroupLocalService.dynamicQueryCount(dynamicQuery);
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
		return _kitGroupLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public KitGroupLocalService getWrappedService() {
		return _kitGroupLocalService;
	}

	@Override
	public void setWrappedService(KitGroupLocalService kitGroupLocalService) {
		_kitGroupLocalService = kitGroupLocalService;
	}

	private KitGroupLocalService _kitGroupLocalService;
}