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
 * Provides a wrapper for {@link DictionaryLocalService}.
 *
 * @author reihsr
 * @see DictionaryLocalService
 * @generated
 */
@ProviderType
public class DictionaryLocalServiceWrapper implements DictionaryLocalService,
	ServiceWrapper<DictionaryLocalService> {
	public DictionaryLocalServiceWrapper(
		DictionaryLocalService dictionaryLocalService) {
		_dictionaryLocalService = dictionaryLocalService;
	}

	/**
	* Adds the dictionary to the database. Also notifies the appropriate model listeners.
	*
	* @param dictionary the dictionary
	* @return the dictionary that was added
	*/
	@Override
	public at.graz.meduni.liferay.portlet.saat.model.Dictionary addDictionary(
		at.graz.meduni.liferay.portlet.saat.model.Dictionary dictionary) {
		return _dictionaryLocalService.addDictionary(dictionary);
	}

	/**
	* Creates a new dictionary with the primary key. Does not add the dictionary to the database.
	*
	* @param dictionaryId the primary key for the new dictionary
	* @return the new dictionary
	*/
	@Override
	public at.graz.meduni.liferay.portlet.saat.model.Dictionary createDictionary(
		long dictionaryId) {
		return _dictionaryLocalService.createDictionary(dictionaryId);
	}

	/**
	* Deletes the dictionary from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionary the dictionary
	* @return the dictionary that was removed
	*/
	@Override
	public at.graz.meduni.liferay.portlet.saat.model.Dictionary deleteDictionary(
		at.graz.meduni.liferay.portlet.saat.model.Dictionary dictionary) {
		return _dictionaryLocalService.deleteDictionary(dictionary);
	}

	/**
	* Deletes the dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary that was removed
	* @throws PortalException if a dictionary with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.liferay.portlet.saat.model.Dictionary deleteDictionary(
		long dictionaryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dictionaryLocalService.deleteDictionary(dictionaryId);
	}

	@Override
	public at.graz.meduni.liferay.portlet.saat.model.Dictionary fetchDictionary(
		long dictionaryId) {
		return _dictionaryLocalService.fetchDictionary(dictionaryId);
	}

	/**
	* Returns the dictionary with the primary key.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary
	* @throws PortalException if a dictionary with the primary key could not be found
	*/
	@Override
	public at.graz.meduni.liferay.portlet.saat.model.Dictionary getDictionary(
		long dictionaryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dictionaryLocalService.getDictionary(dictionaryId);
	}

	/**
	* Updates the dictionary in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param dictionary the dictionary
	* @return the dictionary that was updated
	*/
	@Override
	public at.graz.meduni.liferay.portlet.saat.model.Dictionary updateDictionary(
		at.graz.meduni.liferay.portlet.saat.model.Dictionary dictionary) {
		return _dictionaryLocalService.updateDictionary(dictionary);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _dictionaryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _dictionaryLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _dictionaryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dictionaryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _dictionaryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of dictionaries.
	*
	* @return the number of dictionaries
	*/
	@Override
	public int getDictionariesCount() {
		return _dictionaryLocalService.getDictionariesCount();
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _dictionaryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _dictionaryLocalService.getOSGiServiceIdentifier();
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
		return _dictionaryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dictionaryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _dictionaryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the dictionaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @return the range of dictionaries
	*/
	@Override
	public java.util.List<at.graz.meduni.liferay.portlet.saat.model.Dictionary> getDictionaries(
		int start, int end) {
		return _dictionaryLocalService.getDictionaries(start, end);
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
		return _dictionaryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _dictionaryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public DictionaryLocalService getWrappedService() {
		return _dictionaryLocalService;
	}

	@Override
	public void setWrappedService(DictionaryLocalService dictionaryLocalService) {
		_dictionaryLocalService = dictionaryLocalService;
	}

	private DictionaryLocalService _dictionaryLocalService;
}