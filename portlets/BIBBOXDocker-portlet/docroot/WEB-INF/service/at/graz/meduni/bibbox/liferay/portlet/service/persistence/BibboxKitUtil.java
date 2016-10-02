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

package at.graz.meduni.bibbox.liferay.portlet.service.persistence;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the bibbox kit service. This utility wraps {@link at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.BibboxKitPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see BibboxKitPersistence
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.BibboxKitPersistenceImpl
 * @generated
 */
@ProviderType
public class BibboxKitUtil {
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
	public static void clearCache(BibboxKit bibboxKit) {
		getPersistence().clearCache(bibboxKit);
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
	public static List<BibboxKit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BibboxKit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BibboxKit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BibboxKit> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BibboxKit update(BibboxKit bibboxKit) {
		return getPersistence().update(bibboxKit);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BibboxKit update(BibboxKit bibboxKit,
		ServiceContext serviceContext) {
		return getPersistence().update(bibboxKit, serviceContext);
	}

	/**
	* Returns all the bibbox kits where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @return the matching bibbox kits
	*/
	public static List<BibboxKit> findByApplicationStoreItemId(
		long applicationStoreItemId) {
		return getPersistence()
				   .findByApplicationStoreItemId(applicationStoreItemId);
	}

	/**
	* Returns a range of all the bibbox kits where applicationStoreItemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationStoreItemId the application store item ID
	* @param start the lower bound of the range of bibbox kits
	* @param end the upper bound of the range of bibbox kits (not inclusive)
	* @return the range of matching bibbox kits
	*/
	public static List<BibboxKit> findByApplicationStoreItemId(
		long applicationStoreItemId, int start, int end) {
		return getPersistence()
				   .findByApplicationStoreItemId(applicationStoreItemId, start,
			end);
	}

	/**
	* Returns an ordered range of all the bibbox kits where applicationStoreItemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationStoreItemId the application store item ID
	* @param start the lower bound of the range of bibbox kits
	* @param end the upper bound of the range of bibbox kits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bibbox kits
	*/
	public static List<BibboxKit> findByApplicationStoreItemId(
		long applicationStoreItemId, int start, int end,
		OrderByComparator<BibboxKit> orderByComparator) {
		return getPersistence()
				   .findByApplicationStoreItemId(applicationStoreItemId, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the bibbox kits where applicationStoreItemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationStoreItemId the application store item ID
	* @param start the lower bound of the range of bibbox kits
	* @param end the upper bound of the range of bibbox kits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching bibbox kits
	*/
	public static List<BibboxKit> findByApplicationStoreItemId(
		long applicationStoreItemId, int start, int end,
		OrderByComparator<BibboxKit> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByApplicationStoreItemId(applicationStoreItemId, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first bibbox kit in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bibbox kit
	* @throws NoSuchBibboxKitException if a matching bibbox kit could not be found
	*/
	public static BibboxKit findByApplicationStoreItemId_First(
		long applicationStoreItemId,
		OrderByComparator<BibboxKit> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchBibboxKitException {
		return getPersistence()
				   .findByApplicationStoreItemId_First(applicationStoreItemId,
			orderByComparator);
	}

	/**
	* Returns the first bibbox kit in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bibbox kit, or <code>null</code> if a matching bibbox kit could not be found
	*/
	public static BibboxKit fetchByApplicationStoreItemId_First(
		long applicationStoreItemId,
		OrderByComparator<BibboxKit> orderByComparator) {
		return getPersistence()
				   .fetchByApplicationStoreItemId_First(applicationStoreItemId,
			orderByComparator);
	}

	/**
	* Returns the last bibbox kit in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bibbox kit
	* @throws NoSuchBibboxKitException if a matching bibbox kit could not be found
	*/
	public static BibboxKit findByApplicationStoreItemId_Last(
		long applicationStoreItemId,
		OrderByComparator<BibboxKit> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchBibboxKitException {
		return getPersistence()
				   .findByApplicationStoreItemId_Last(applicationStoreItemId,
			orderByComparator);
	}

	/**
	* Returns the last bibbox kit in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bibbox kit, or <code>null</code> if a matching bibbox kit could not be found
	*/
	public static BibboxKit fetchByApplicationStoreItemId_Last(
		long applicationStoreItemId,
		OrderByComparator<BibboxKit> orderByComparator) {
		return getPersistence()
				   .fetchByApplicationStoreItemId_Last(applicationStoreItemId,
			orderByComparator);
	}

	/**
	* Returns the bibbox kits before and after the current bibbox kit in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param bibboxKitId the primary key of the current bibbox kit
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bibbox kit
	* @throws NoSuchBibboxKitException if a bibbox kit with the primary key could not be found
	*/
	public static BibboxKit[] findByApplicationStoreItemId_PrevAndNext(
		long bibboxKitId, long applicationStoreItemId,
		OrderByComparator<BibboxKit> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchBibboxKitException {
		return getPersistence()
				   .findByApplicationStoreItemId_PrevAndNext(bibboxKitId,
			applicationStoreItemId, orderByComparator);
	}

	/**
	* Removes all the bibbox kits where applicationStoreItemId = &#63; from the database.
	*
	* @param applicationStoreItemId the application store item ID
	*/
	public static void removeByApplicationStoreItemId(
		long applicationStoreItemId) {
		getPersistence().removeByApplicationStoreItemId(applicationStoreItemId);
	}

	/**
	* Returns the number of bibbox kits where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @return the number of matching bibbox kits
	*/
	public static int countByApplicationStoreItemId(long applicationStoreItemId) {
		return getPersistence()
				   .countByApplicationStoreItemId(applicationStoreItemId);
	}

	/**
	* Returns all the bibbox kits where kitName = &#63;.
	*
	* @param kitName the kit name
	* @return the matching bibbox kits
	*/
	public static List<BibboxKit> findByKitName(java.lang.String kitName) {
		return getPersistence().findByKitName(kitName);
	}

	/**
	* Returns a range of all the bibbox kits where kitName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param kitName the kit name
	* @param start the lower bound of the range of bibbox kits
	* @param end the upper bound of the range of bibbox kits (not inclusive)
	* @return the range of matching bibbox kits
	*/
	public static List<BibboxKit> findByKitName(java.lang.String kitName,
		int start, int end) {
		return getPersistence().findByKitName(kitName, start, end);
	}

	/**
	* Returns an ordered range of all the bibbox kits where kitName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param kitName the kit name
	* @param start the lower bound of the range of bibbox kits
	* @param end the upper bound of the range of bibbox kits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bibbox kits
	*/
	public static List<BibboxKit> findByKitName(java.lang.String kitName,
		int start, int end, OrderByComparator<BibboxKit> orderByComparator) {
		return getPersistence()
				   .findByKitName(kitName, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the bibbox kits where kitName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param kitName the kit name
	* @param start the lower bound of the range of bibbox kits
	* @param end the upper bound of the range of bibbox kits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching bibbox kits
	*/
	public static List<BibboxKit> findByKitName(java.lang.String kitName,
		int start, int end, OrderByComparator<BibboxKit> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByKitName(kitName, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first bibbox kit in the ordered set where kitName = &#63;.
	*
	* @param kitName the kit name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bibbox kit
	* @throws NoSuchBibboxKitException if a matching bibbox kit could not be found
	*/
	public static BibboxKit findByKitName_First(java.lang.String kitName,
		OrderByComparator<BibboxKit> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchBibboxKitException {
		return getPersistence().findByKitName_First(kitName, orderByComparator);
	}

	/**
	* Returns the first bibbox kit in the ordered set where kitName = &#63;.
	*
	* @param kitName the kit name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bibbox kit, or <code>null</code> if a matching bibbox kit could not be found
	*/
	public static BibboxKit fetchByKitName_First(java.lang.String kitName,
		OrderByComparator<BibboxKit> orderByComparator) {
		return getPersistence().fetchByKitName_First(kitName, orderByComparator);
	}

	/**
	* Returns the last bibbox kit in the ordered set where kitName = &#63;.
	*
	* @param kitName the kit name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bibbox kit
	* @throws NoSuchBibboxKitException if a matching bibbox kit could not be found
	*/
	public static BibboxKit findByKitName_Last(java.lang.String kitName,
		OrderByComparator<BibboxKit> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchBibboxKitException {
		return getPersistence().findByKitName_Last(kitName, orderByComparator);
	}

	/**
	* Returns the last bibbox kit in the ordered set where kitName = &#63;.
	*
	* @param kitName the kit name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bibbox kit, or <code>null</code> if a matching bibbox kit could not be found
	*/
	public static BibboxKit fetchByKitName_Last(java.lang.String kitName,
		OrderByComparator<BibboxKit> orderByComparator) {
		return getPersistence().fetchByKitName_Last(kitName, orderByComparator);
	}

	/**
	* Returns the bibbox kits before and after the current bibbox kit in the ordered set where kitName = &#63;.
	*
	* @param bibboxKitId the primary key of the current bibbox kit
	* @param kitName the kit name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bibbox kit
	* @throws NoSuchBibboxKitException if a bibbox kit with the primary key could not be found
	*/
	public static BibboxKit[] findByKitName_PrevAndNext(long bibboxKitId,
		java.lang.String kitName, OrderByComparator<BibboxKit> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchBibboxKitException {
		return getPersistence()
				   .findByKitName_PrevAndNext(bibboxKitId, kitName,
			orderByComparator);
	}

	/**
	* Removes all the bibbox kits where kitName = &#63; from the database.
	*
	* @param kitName the kit name
	*/
	public static void removeByKitName(java.lang.String kitName) {
		getPersistence().removeByKitName(kitName);
	}

	/**
	* Returns the number of bibbox kits where kitName = &#63;.
	*
	* @param kitName the kit name
	* @return the number of matching bibbox kits
	*/
	public static int countByKitName(java.lang.String kitName) {
		return getPersistence().countByKitName(kitName);
	}

	/**
	* Caches the bibbox kit in the entity cache if it is enabled.
	*
	* @param bibboxKit the bibbox kit
	*/
	public static void cacheResult(BibboxKit bibboxKit) {
		getPersistence().cacheResult(bibboxKit);
	}

	/**
	* Caches the bibbox kits in the entity cache if it is enabled.
	*
	* @param bibboxKits the bibbox kits
	*/
	public static void cacheResult(List<BibboxKit> bibboxKits) {
		getPersistence().cacheResult(bibboxKits);
	}

	/**
	* Creates a new bibbox kit with the primary key. Does not add the bibbox kit to the database.
	*
	* @param bibboxKitId the primary key for the new bibbox kit
	* @return the new bibbox kit
	*/
	public static BibboxKit create(long bibboxKitId) {
		return getPersistence().create(bibboxKitId);
	}

	/**
	* Removes the bibbox kit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bibboxKitId the primary key of the bibbox kit
	* @return the bibbox kit that was removed
	* @throws NoSuchBibboxKitException if a bibbox kit with the primary key could not be found
	*/
	public static BibboxKit remove(long bibboxKitId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchBibboxKitException {
		return getPersistence().remove(bibboxKitId);
	}

	public static BibboxKit updateImpl(BibboxKit bibboxKit) {
		return getPersistence().updateImpl(bibboxKit);
	}

	/**
	* Returns the bibbox kit with the primary key or throws a {@link NoSuchBibboxKitException} if it could not be found.
	*
	* @param bibboxKitId the primary key of the bibbox kit
	* @return the bibbox kit
	* @throws NoSuchBibboxKitException if a bibbox kit with the primary key could not be found
	*/
	public static BibboxKit findByPrimaryKey(long bibboxKitId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchBibboxKitException {
		return getPersistence().findByPrimaryKey(bibboxKitId);
	}

	/**
	* Returns the bibbox kit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bibboxKitId the primary key of the bibbox kit
	* @return the bibbox kit, or <code>null</code> if a bibbox kit with the primary key could not be found
	*/
	public static BibboxKit fetchByPrimaryKey(long bibboxKitId) {
		return getPersistence().fetchByPrimaryKey(bibboxKitId);
	}

	public static java.util.Map<java.io.Serializable, BibboxKit> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the bibbox kits.
	*
	* @return the bibbox kits
	*/
	public static List<BibboxKit> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the bibbox kits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bibbox kits
	* @param end the upper bound of the range of bibbox kits (not inclusive)
	* @return the range of bibbox kits
	*/
	public static List<BibboxKit> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bibbox kits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bibbox kits
	* @param end the upper bound of the range of bibbox kits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bibbox kits
	*/
	public static List<BibboxKit> findAll(int start, int end,
		OrderByComparator<BibboxKit> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the bibbox kits.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bibbox kits
	* @param end the upper bound of the range of bibbox kits (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of bibbox kits
	*/
	public static List<BibboxKit> findAll(int start, int end,
		OrderByComparator<BibboxKit> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the bibbox kits from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bibbox kits.
	*
	* @return the number of bibbox kits
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BibboxKitPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BibboxKitPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.bibbox.liferay.portlet.service.ClpSerializer.getServletContextName(),
					BibboxKitPersistence.class.getName());

			ReferenceRegistry.registerReference(BibboxKitUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static BibboxKitPersistence _persistence;
}