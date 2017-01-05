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

import at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the dictionary dictionary link service. This utility wraps {@link at.graz.meduni.liferay.portlet.saat.service.persistence.impl.DictionaryDictionaryLinkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see DictionaryDictionaryLinkPersistence
 * @see at.graz.meduni.liferay.portlet.saat.service.persistence.impl.DictionaryDictionaryLinkPersistenceImpl
 * @generated
 */
@ProviderType
public class DictionaryDictionaryLinkUtil {
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
	public static void clearCache(
		DictionaryDictionaryLink dictionaryDictionaryLink) {
		getPersistence().clearCache(dictionaryDictionaryLink);
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
	public static List<DictionaryDictionaryLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DictionaryDictionaryLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DictionaryDictionaryLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DictionaryDictionaryLink update(
		DictionaryDictionaryLink dictionaryDictionaryLink) {
		return getPersistence().update(dictionaryDictionaryLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DictionaryDictionaryLink update(
		DictionaryDictionaryLink dictionaryDictionaryLink,
		ServiceContext serviceContext) {
		return getPersistence().update(dictionaryDictionaryLink, serviceContext);
	}

	/**
	* Returns all the dictionary dictionary links where dictionaryId = &#63;.
	*
	* @param dictionaryId the dictionary ID
	* @return the matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByParentId(
		long dictionaryId) {
		return getPersistence().findByParentId(dictionaryId);
	}

	/**
	* Returns a range of all the dictionary dictionary links where dictionaryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictionaryId the dictionary ID
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @return the range of matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByParentId(
		long dictionaryId, int start, int end) {
		return getPersistence().findByParentId(dictionaryId, start, end);
	}

	/**
	* Returns an ordered range of all the dictionary dictionary links where dictionaryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictionaryId the dictionary ID
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByParentId(
		long dictionaryId, int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence()
				   .findByParentId(dictionaryId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the dictionary dictionary links where dictionaryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictionaryId the dictionary ID
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByParentId(
		long dictionaryId, int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByParentId(dictionaryId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	*
	* @param dictionaryId the dictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink findByParentId_First(
		long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws at.graz.meduni.liferay.portlet.saat.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence()
				   .findByParentId_First(dictionaryId, orderByComparator);
	}

	/**
	* Returns the first dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	*
	* @param dictionaryId the dictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink fetchByParentId_First(
		long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence()
				   .fetchByParentId_First(dictionaryId, orderByComparator);
	}

	/**
	* Returns the last dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	*
	* @param dictionaryId the dictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink findByParentId_Last(
		long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws at.graz.meduni.liferay.portlet.saat.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence()
				   .findByParentId_Last(dictionaryId, orderByComparator);
	}

	/**
	* Returns the last dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	*
	* @param dictionaryId the dictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink fetchByParentId_Last(
		long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence()
				   .fetchByParentId_Last(dictionaryId, orderByComparator);
	}

	/**
	* Returns the dictionary dictionary links before and after the current dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	*
	* @param dictionaryDictionaryLinkId the primary key of the current dictionary dictionary link
	* @param dictionaryId the dictionary ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	*/
	public static DictionaryDictionaryLink[] findByParentId_PrevAndNext(
		long dictionaryDictionaryLinkId, long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws at.graz.meduni.liferay.portlet.saat.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence()
				   .findByParentId_PrevAndNext(dictionaryDictionaryLinkId,
			dictionaryId, orderByComparator);
	}

	/**
	* Removes all the dictionary dictionary links where dictionaryId = &#63; from the database.
	*
	* @param dictionaryId the dictionary ID
	*/
	public static void removeByParentId(long dictionaryId) {
		getPersistence().removeByParentId(dictionaryId);
	}

	/**
	* Returns the number of dictionary dictionary links where dictionaryId = &#63;.
	*
	* @param dictionaryId the dictionary ID
	* @return the number of matching dictionary dictionary links
	*/
	public static int countByParentId(long dictionaryId) {
		return getPersistence().countByParentId(dictionaryId);
	}

	/**
	* Returns all the dictionary dictionary links where dictionaryAddictionId = &#63;.
	*
	* @param dictionaryAddictionId the dictionary addiction ID
	* @return the matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByChildrenId(
		long dictionaryAddictionId) {
		return getPersistence().findByChildrenId(dictionaryAddictionId);
	}

	/**
	* Returns a range of all the dictionary dictionary links where dictionaryAddictionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictionaryAddictionId the dictionary addiction ID
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @return the range of matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByChildrenId(
		long dictionaryAddictionId, int start, int end) {
		return getPersistence()
				   .findByChildrenId(dictionaryAddictionId, start, end);
	}

	/**
	* Returns an ordered range of all the dictionary dictionary links where dictionaryAddictionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictionaryAddictionId the dictionary addiction ID
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByChildrenId(
		long dictionaryAddictionId, int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence()
				   .findByChildrenId(dictionaryAddictionId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the dictionary dictionary links where dictionaryAddictionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dictionaryAddictionId the dictionary addiction ID
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findByChildrenId(
		long dictionaryAddictionId, int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByChildrenId(dictionaryAddictionId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first dictionary dictionary link in the ordered set where dictionaryAddictionId = &#63;.
	*
	* @param dictionaryAddictionId the dictionary addiction ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink findByChildrenId_First(
		long dictionaryAddictionId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws at.graz.meduni.liferay.portlet.saat.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence()
				   .findByChildrenId_First(dictionaryAddictionId,
			orderByComparator);
	}

	/**
	* Returns the first dictionary dictionary link in the ordered set where dictionaryAddictionId = &#63;.
	*
	* @param dictionaryAddictionId the dictionary addiction ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink fetchByChildrenId_First(
		long dictionaryAddictionId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence()
				   .fetchByChildrenId_First(dictionaryAddictionId,
			orderByComparator);
	}

	/**
	* Returns the last dictionary dictionary link in the ordered set where dictionaryAddictionId = &#63;.
	*
	* @param dictionaryAddictionId the dictionary addiction ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink findByChildrenId_Last(
		long dictionaryAddictionId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws at.graz.meduni.liferay.portlet.saat.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence()
				   .findByChildrenId_Last(dictionaryAddictionId,
			orderByComparator);
	}

	/**
	* Returns the last dictionary dictionary link in the ordered set where dictionaryAddictionId = &#63;.
	*
	* @param dictionaryAddictionId the dictionary addiction ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	*/
	public static DictionaryDictionaryLink fetchByChildrenId_Last(
		long dictionaryAddictionId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence()
				   .fetchByChildrenId_Last(dictionaryAddictionId,
			orderByComparator);
	}

	/**
	* Returns the dictionary dictionary links before and after the current dictionary dictionary link in the ordered set where dictionaryAddictionId = &#63;.
	*
	* @param dictionaryDictionaryLinkId the primary key of the current dictionary dictionary link
	* @param dictionaryAddictionId the dictionary addiction ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	*/
	public static DictionaryDictionaryLink[] findByChildrenId_PrevAndNext(
		long dictionaryDictionaryLinkId, long dictionaryAddictionId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws at.graz.meduni.liferay.portlet.saat.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence()
				   .findByChildrenId_PrevAndNext(dictionaryDictionaryLinkId,
			dictionaryAddictionId, orderByComparator);
	}

	/**
	* Removes all the dictionary dictionary links where dictionaryAddictionId = &#63; from the database.
	*
	* @param dictionaryAddictionId the dictionary addiction ID
	*/
	public static void removeByChildrenId(long dictionaryAddictionId) {
		getPersistence().removeByChildrenId(dictionaryAddictionId);
	}

	/**
	* Returns the number of dictionary dictionary links where dictionaryAddictionId = &#63;.
	*
	* @param dictionaryAddictionId the dictionary addiction ID
	* @return the number of matching dictionary dictionary links
	*/
	public static int countByChildrenId(long dictionaryAddictionId) {
		return getPersistence().countByChildrenId(dictionaryAddictionId);
	}

	/**
	* Caches the dictionary dictionary link in the entity cache if it is enabled.
	*
	* @param dictionaryDictionaryLink the dictionary dictionary link
	*/
	public static void cacheResult(
		DictionaryDictionaryLink dictionaryDictionaryLink) {
		getPersistence().cacheResult(dictionaryDictionaryLink);
	}

	/**
	* Caches the dictionary dictionary links in the entity cache if it is enabled.
	*
	* @param dictionaryDictionaryLinks the dictionary dictionary links
	*/
	public static void cacheResult(
		List<DictionaryDictionaryLink> dictionaryDictionaryLinks) {
		getPersistence().cacheResult(dictionaryDictionaryLinks);
	}

	/**
	* Creates a new dictionary dictionary link with the primary key. Does not add the dictionary dictionary link to the database.
	*
	* @param dictionaryDictionaryLinkId the primary key for the new dictionary dictionary link
	* @return the new dictionary dictionary link
	*/
	public static DictionaryDictionaryLink create(
		long dictionaryDictionaryLinkId) {
		return getPersistence().create(dictionaryDictionaryLinkId);
	}

	/**
	* Removes the dictionary dictionary link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionaryDictionaryLinkId the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link that was removed
	* @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	*/
	public static DictionaryDictionaryLink remove(
		long dictionaryDictionaryLinkId)
		throws at.graz.meduni.liferay.portlet.saat.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence().remove(dictionaryDictionaryLinkId);
	}

	public static DictionaryDictionaryLink updateImpl(
		DictionaryDictionaryLink dictionaryDictionaryLink) {
		return getPersistence().updateImpl(dictionaryDictionaryLink);
	}

	/**
	* Returns the dictionary dictionary link with the primary key or throws a {@link NoSuchDictionaryDictionaryLinkException} if it could not be found.
	*
	* @param dictionaryDictionaryLinkId the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link
	* @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	*/
	public static DictionaryDictionaryLink findByPrimaryKey(
		long dictionaryDictionaryLinkId)
		throws at.graz.meduni.liferay.portlet.saat.exception.NoSuchDictionaryDictionaryLinkException {
		return getPersistence().findByPrimaryKey(dictionaryDictionaryLinkId);
	}

	/**
	* Returns the dictionary dictionary link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dictionaryDictionaryLinkId the primary key of the dictionary dictionary link
	* @return the dictionary dictionary link, or <code>null</code> if a dictionary dictionary link with the primary key could not be found
	*/
	public static DictionaryDictionaryLink fetchByPrimaryKey(
		long dictionaryDictionaryLinkId) {
		return getPersistence().fetchByPrimaryKey(dictionaryDictionaryLinkId);
	}

	public static java.util.Map<java.io.Serializable, DictionaryDictionaryLink> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the dictionary dictionary links.
	*
	* @return the dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the dictionary dictionary links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @return the range of dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the dictionary dictionary links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findAll(int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the dictionary dictionary links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of dictionary dictionary links
	* @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of dictionary dictionary links
	*/
	public static List<DictionaryDictionaryLink> findAll(int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the dictionary dictionary links from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of dictionary dictionary links.
	*
	* @return the number of dictionary dictionary links
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DictionaryDictionaryLinkPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DictionaryDictionaryLinkPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.liferay.portlet.saat.service.ClpSerializer.getServletContextName(),
					DictionaryDictionaryLinkPersistence.class.getName());

			ReferenceRegistry.registerReference(DictionaryDictionaryLinkUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static DictionaryDictionaryLinkPersistence _persistence;
}