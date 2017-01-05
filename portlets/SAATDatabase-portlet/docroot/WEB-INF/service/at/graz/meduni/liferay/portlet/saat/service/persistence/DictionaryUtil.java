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

package at.graz.meduni.liferay.portlet.saat.service.persistence;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.liferay.portlet.saat.model.Dictionary;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the dictionary service. This utility wraps {@link at.graz.meduni.liferay.portlet.saat.service.persistence.impl.DictionaryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see DictionaryPersistence
 * @see at.graz.meduni.liferay.portlet.saat.service.persistence.impl.DictionaryPersistenceImpl
 * @generated
 */
@ProviderType
public class DictionaryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Dictionary dictionary) {
		getPersistence().clearCache(dictionary);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Dictionary> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Dictionary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Dictionary> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Dictionary> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Dictionary update(Dictionary dictionary) {
		return getPersistence().update(dictionary);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Dictionary update(Dictionary dictionary,
		ServiceContext serviceContext) {
		return getPersistence().update(dictionary, serviceContext);
	}

	/**
	* Returns all the dictionaries where codeType = &#63;.
	*
	* @param codeType the code type
	* @return the matching dictionaries
	*/
	public static List<Dictionary> findByCodeType(java.lang.String codeType) {
		return getPersistence().findByCodeType(codeType);
	}

	/**
	* Returns a range of all the dictionaries where codeType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param codeType the code type
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @return the range of matching dictionaries
	*/
	public static List<Dictionary> findByCodeType(java.lang.String codeType,
		int start, int end) {
		return getPersistence().findByCodeType(codeType, start, end);
	}

	/**
	* Returns an ordered range of all the dictionaries where codeType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param codeType the code type
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dictionaries
	*/
	public static List<Dictionary> findByCodeType(java.lang.String codeType,
		int start, int end, OrderByComparator<Dictionary> orderByComparator) {
		return getPersistence()
				   .findByCodeType(codeType, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the dictionaries where codeType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param codeType the code type
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching dictionaries
	*/
	public static List<Dictionary> findByCodeType(java.lang.String codeType,
		int start, int end, OrderByComparator<Dictionary> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCodeType(codeType, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first dictionary in the ordered set where codeType = &#63;.
	*
	* @param codeType the code type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary
	* @throws NoSuchDictionaryException if a matching dictionary could not be found
	*/
	public static Dictionary findByCodeType_First(java.lang.String codeType,
		OrderByComparator<Dictionary> orderByComparator)
		throws at.graz.meduni.liferay.portlet.saat.exception.NoSuchDictionaryException {
		return getPersistence().findByCodeType_First(codeType, orderByComparator);
	}

	/**
	* Returns the first dictionary in the ordered set where codeType = &#63;.
	*
	* @param codeType the code type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary, or <code>null</code> if a matching dictionary could not be found
	*/
	public static Dictionary fetchByCodeType_First(java.lang.String codeType,
		OrderByComparator<Dictionary> orderByComparator) {
		return getPersistence()
				   .fetchByCodeType_First(codeType, orderByComparator);
	}

	/**
	* Returns the last dictionary in the ordered set where codeType = &#63;.
	*
	* @param codeType the code type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary
	* @throws NoSuchDictionaryException if a matching dictionary could not be found
	*/
	public static Dictionary findByCodeType_Last(java.lang.String codeType,
		OrderByComparator<Dictionary> orderByComparator)
		throws at.graz.meduni.liferay.portlet.saat.exception.NoSuchDictionaryException {
		return getPersistence().findByCodeType_Last(codeType, orderByComparator);
	}

	/**
	* Returns the last dictionary in the ordered set where codeType = &#63;.
	*
	* @param codeType the code type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary, or <code>null</code> if a matching dictionary could not be found
	*/
	public static Dictionary fetchByCodeType_Last(java.lang.String codeType,
		OrderByComparator<Dictionary> orderByComparator) {
		return getPersistence().fetchByCodeType_Last(codeType, orderByComparator);
	}

	/**
	* Returns the dictionaries before and after the current dictionary in the ordered set where codeType = &#63;.
	*
	* @param dictionaryId the primary key of the current dictionary
	* @param codeType the code type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary
	* @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	*/
	public static Dictionary[] findByCodeType_PrevAndNext(long dictionaryId,
		java.lang.String codeType,
		OrderByComparator<Dictionary> orderByComparator)
		throws at.graz.meduni.liferay.portlet.saat.exception.NoSuchDictionaryException {
		return getPersistence()
				   .findByCodeType_PrevAndNext(dictionaryId, codeType,
			orderByComparator);
	}

	/**
	* Removes all the dictionaries where codeType = &#63; from the database.
	*
	* @param codeType the code type
	*/
	public static void removeByCodeType(java.lang.String codeType) {
		getPersistence().removeByCodeType(codeType);
	}

	/**
	* Returns the number of dictionaries where codeType = &#63;.
	*
	* @param codeType the code type
	* @return the number of matching dictionaries
	*/
	public static int countByCodeType(java.lang.String codeType) {
		return getPersistence().countByCodeType(codeType);
	}

	/**
	* Caches the dictionary in the entity cache if it is enabled.
	*
	* @param dictionary the dictionary
	*/
	public static void cacheResult(Dictionary dictionary) {
		getPersistence().cacheResult(dictionary);
	}

	/**
	* Caches the dictionaries in the entity cache if it is enabled.
	*
	* @param dictionaries the dictionaries
	*/
	public static void cacheResult(List<Dictionary> dictionaries) {
		getPersistence().cacheResult(dictionaries);
	}

	/**
	* Creates a new dictionary with the primary key. Does not add the dictionary to the database.
	*
	* @param dictionaryId the primary key for the new dictionary
	* @return the new dictionary
	*/
	public static Dictionary create(long dictionaryId) {
		return getPersistence().create(dictionaryId);
	}

	/**
	* Removes the dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary that was removed
	* @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	*/
	public static Dictionary remove(long dictionaryId)
		throws at.graz.meduni.liferay.portlet.saat.exception.NoSuchDictionaryException {
		return getPersistence().remove(dictionaryId);
	}

	public static Dictionary updateImpl(Dictionary dictionary) {
		return getPersistence().updateImpl(dictionary);
	}

	/**
	* Returns the dictionary with the primary key or throws a {@link NoSuchDictionaryException} if it could not be found.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary
	* @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	*/
	public static Dictionary findByPrimaryKey(long dictionaryId)
		throws at.graz.meduni.liferay.portlet.saat.exception.NoSuchDictionaryException {
		return getPersistence().findByPrimaryKey(dictionaryId);
	}

	/**
	* Returns the dictionary with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary, or <code>null</code> if a dictionary with the primary key could not be found
	*/
	public static Dictionary fetchByPrimaryKey(long dictionaryId) {
		return getPersistence().fetchByPrimaryKey(dictionaryId);
	}

	public static java.util.Map<java.io.Serializable, Dictionary> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the dictionaries.
	*
	* @return the dictionaries
	*/
	public static List<Dictionary> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the dictionaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @return the range of dictionaries
	*/
	public static List<Dictionary> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the dictionaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dictionaries
	*/
	public static List<Dictionary> findAll(int start, int end,
		OrderByComparator<Dictionary> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the dictionaries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionaries
	* @param end the upper bound of the range of dictionaries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of dictionaries
	*/
	public static List<Dictionary> findAll(int start, int end,
		OrderByComparator<Dictionary> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the dictionaries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dictionaries.
	*
	* @return the number of dictionaries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DictionaryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DictionaryPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.saat.service.ClpSerializer.getServletContextName(),
					DictionaryPersistence.class.getName());

			ReferenceRegistry.registerReference(DictionaryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static DictionaryPersistence _persistence;
}