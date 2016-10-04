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
 * Provides a wrapper for {@link BibboxKitLocalService}.
 *
 * @author Robert Reihs
 * @see BibboxKitLocalService
 * @generated
 */
@ProviderType
public class BibboxKitLocalServiceWrapper implements BibboxKitLocalService,
	ServiceWrapper<BibboxKitLocalService> {
	public BibboxKitLocalServiceWrapper(
		BibboxKitLocalService bibboxKitLocalService) {
		_bibboxKitLocalService = bibboxKitLocalService;
	}

	/**
	* Adds the bibbox kit to the database. Also notifies the appropriate model listeners.
	*
	* @param bibboxKit the bibbox kit
	* @return the bibbox kit that was added
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit addBibboxKit(
		at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit bibboxKit) {
		return _bibboxKitLocalService.addBibboxKit(bibboxKit);
	}

	/**
	* Creates a new bibbox kit with the primary key. Does not add the bibbox kit to the database.
	*
	* @param bibboxKitId the primary key for the new bibbox kit
	* @return the new bibbox kit
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit createBibboxKit(
		long bibboxKitId) {
		return _bibboxKitLocalService.createBibboxKit(bibboxKitId);
	}

	/**
	* Deletes the bibbox kit from the database. Also notifies the appropriate model listeners.
	*
	* @param bibboxKit the bibbox kit
	* @return the bibbox kit that was removed
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit deleteBibboxKit(
		at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit bibboxKit) {
		return _bibboxKitLocalService.deleteBibboxKit(bibboxKit);
	}

	/**
	* Deletes the bibbox kit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bibboxKitId the primary key of the bibbox kit
	* @return the bibbox kit that was removed
	* @throws PortalException if a bibbox kit with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit deleteBibboxKit(
		long bibboxKitId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bibboxKitLocalService.deleteBibboxKit(bibboxKitId);
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit fetchBibboxKit(
		long bibboxKitId) {
		return _bibboxKitLocalService.fetchBibboxKit(bibboxKitId);
	}

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit getBibboxKit(
		long applicationStoreItemId, java.lang.String kitName) {
		return _bibboxKitLocalService.getBibboxKit(applicationStoreItemId,
			kitName);
	}

	/**
	* Returns the bibbox kit with the primary key.
	*
	* @param bibboxKitId the primary key of the bibbox kit
	* @return the bibbox kit
	* @throws PortalException if a bibbox kit with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit getBibboxKit(
		long bibboxKitId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bibboxKitLocalService.getBibboxKit(bibboxKitId);
	}

	/**
	* Updates the bibbox kit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bibboxKit the bibbox kit
	* @return the bibbox kit that was updated
	*/
	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit updateBibboxKit(
		at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit bibboxKit) {
		return _bibboxKitLocalService.updateBibboxKit(bibboxKit);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _bibboxKitLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bibboxKitLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _bibboxKitLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bibboxKitLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _bibboxKitLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of bibbox kits.
	*
	* @return the number of bibbox kits
	*/
	@Override
	public int getBibboxKitsCount() {
		return _bibboxKitLocalService.getBibboxKitsCount();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bibboxKitLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _bibboxKitLocalService.getOSGiServiceIdentifier();
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
		return _bibboxKitLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _bibboxKitLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _bibboxKitLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the bibbox kits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bibbox kits
	* @param end the upper bound of the range of bibbox kits (not inclusive)
	* @return the range of bibbox kits
	*/
	@Override
	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit> getBibboxKits(
		int start, int end) {
		return _bibboxKitLocalService.getBibboxKits(start, end);
	}

	@Override
	public java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit> getBibboxKits(
		long applicationStoreItemId) {
		return _bibboxKitLocalService.getBibboxKits(applicationStoreItemId);
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
		return _bibboxKitLocalService.dynamicQueryCount(dynamicQuery);
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
		return _bibboxKitLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public BibboxKitLocalService getWrappedService() {
		return _bibboxKitLocalService;
	}

	@Override
	public void setWrappedService(BibboxKitLocalService bibboxKitLocalService) {
		_bibboxKitLocalService = bibboxKitLocalService;
	}

	private BibboxKitLocalService _bibboxKitLocalService;
}