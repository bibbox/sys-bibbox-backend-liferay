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

package at.graz.meduni.liferay.portlet.saat.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DictionaryDictionaryLinkLocalService}.
 *
 * @author reihsr
 * @see DictionaryDictionaryLinkLocalService
 * @generated
 */
@ProviderType
public class DictionaryDictionaryLinkLocalServiceWrapper
	implements DictionaryDictionaryLinkLocalService,
		ServiceWrapper<DictionaryDictionaryLinkLocalService> {
	public DictionaryDictionaryLinkLocalServiceWrapper(
		DictionaryDictionaryLinkLocalService dictionaryDictionaryLinkLocalService) {
		_dictionaryDictionaryLinkLocalService = dictionaryDictionaryLinkLocalService;
	}

	/**
	* Adds the dictionary dictionary link to the database. Also notifies the appropriate model listeners.
	*
	* @param dictionaryDictionaryLink the dictionary dictionary link
	* @return the dictionary dictionary link that was added
	*/
	@Override
	public at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink addDictionaryDictionaryLink(
		at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink dictionaryDictionaryLink) {
		return _dictionaryDictionaryLinkLocalService.addDictionaryDictionaryLink(dictionaryDictionaryLink);
	}

	/**
	* Creates a new dictionary dictionary link with the primary key. Does not add the dictionary dictionary link to the database.
	*
	* @param dictionaryDictionaryLinkId the primary key for the new dictionary dictionary link
	* @return the new dictionary dictionary link
	*/
	@Override
	public at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink createDictionaryDictionaryLink(
		long dictionaryDictionaryLinkId) {
		return _dictionaryDictionaryLinkLocalService.createDictionaryDictionaryLink(dictionaryDictionaryLinkId);
	}

	/**
	* Deletes the dictionary dictionary link from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionaryDictionaryLink the dictionary dictionary link
	* @return the dictionary dictionary link that was removed
	*/
	@Override
	public at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink deleteDictionaryDictionaryLink(
		at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink dictionaryDictionaryLink) {
		return _dictionaryDictionaryLinkLocalService.deleteDictionaryDictionaryLink(dictionaryDictionaryLink);
	}

	/**
	* Deletes the dictionary dictionary link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionaryDictionaryLinkId the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link that was removed
	* @throws PortalException if a dictionary dictionary link with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink deleteDictionaryDictionaryLink(
		long dictionaryDictionaryLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dictionaryDictionaryLinkLocalService.deleteDictionaryDictionaryLink(dictionaryDictionaryLinkId);
	}

	@Override
	public at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink fetchDictionaryDictionaryLink(
		long dictionaryDictionaryLinkId) {
		return _dictionaryDictionaryLinkLocalService.fetchDictionaryDictionaryLink(dictionaryDictionaryLinkId);
	}

	/**
	* Returns the dictionary dictionary link with the primary key.
	*
	* @param dictionaryDictionaryLinkId the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link
	* @throws PortalException if a dictionary dictionary link with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink getDictionaryDictionaryLink(
		long dictionaryDictionaryLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dictionaryDictionaryLinkLocalService.getDictionaryDictionaryLink(dictionaryDictionaryLinkId);
	}

	/**
	* Updates the dictionary dictionary link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dictionaryDictionaryLink the dictionary dictionary link
	* @return the dictionary dictionary link that was updated
	*/
	@Override
	public at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink updateDictionaryDictionaryLink(
		at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink dictionaryDictionaryLink) {
		return _dictionaryDictionaryLinkLocalService.updateDictionaryDictionaryLink(dictionaryDictionaryLink);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _dictionaryDictionaryLinkLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dictionaryDictionaryLinkLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _dictionaryDictionaryLinkLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dictionaryDictionaryLinkLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dictionaryDictionaryLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of dictionary dictionary links.
	*
	* @return the number of dictionary dictionary links
	*/
	@Override
	public int getDictionaryDictionaryLinksCount() {
		return _dictionaryDictionaryLinkLocalService.getDictionaryDictionaryLinksCount();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dictionaryDictionaryLinkLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _dictionaryDictionaryLinkLocalService.getOSGiServiceIdentifier();
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
		return _dictionaryDictionaryLinkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dictionaryDictionaryLinkLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dictionaryDictionaryLinkLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns a range of all the dictionary dictionary links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @return the range of dictionary dictionary links
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink> getDictionaryDictionaryLinks(
		int start, int end) {
		return _dictionaryDictionaryLinkLocalService.getDictionaryDictionaryLinks(start,
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
		return _dictionaryDictionaryLinkLocalService.dynamicQueryCount(dynamicQuery);
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
		return _dictionaryDictionaryLinkLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public DictionaryDictionaryLinkLocalService getWrappedService() {
		return _dictionaryDictionaryLinkLocalService;
	}

	@Override
	public void setWrappedService(
		DictionaryDictionaryLinkLocalService dictionaryDictionaryLinkLocalService) {
		_dictionaryDictionaryLinkLocalService = dictionaryDictionaryLinkLocalService;
	}

	private DictionaryDictionaryLinkLocalService _dictionaryDictionaryLinkLocalService;
}