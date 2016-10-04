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

import at.graz.meduni.bibbox.liferay.portlet.model.KitGroup;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the kit group service. This utility wraps {@link at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.KitGroupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see KitGroupPersistence
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.KitGroupPersistenceImpl
 * @generated
 */
@ProviderType
public class KitGroupUtil {
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
	public static void clearCache(KitGroup kitGroup) {
		getPersistence().clearCache(kitGroup);
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
	public static List<KitGroup> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<KitGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<KitGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<KitGroup> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static KitGroup update(KitGroup kitGroup) {
		return getPersistence().update(kitGroup);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static KitGroup update(KitGroup kitGroup,
		ServiceContext serviceContext) {
		return getPersistence().update(kitGroup, serviceContext);
	}

	/**
	* Returns all the kit groups where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param bibboxKitId the bibbox kit ID
	* @return the matching kit groups
	*/
	public static List<KitGroup> findByKitGroup(long applicationStoreItemId,
		long bibboxKitId) {
		return getPersistence()
				   .findByKitGroup(applicationStoreItemId, bibboxKitId);
	}

	/**
	* Returns a range of all the kit groups where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationStoreItemId the application store item ID
	* @param bibboxKitId the bibbox kit ID
	* @param start the lower bound of the range of kit groups
	* @param end the upper bound of the range of kit groups (not inclusive)
	* @return the range of matching kit groups
	*/
	public static List<KitGroup> findByKitGroup(long applicationStoreItemId,
		long bibboxKitId, int start, int end) {
		return getPersistence()
				   .findByKitGroup(applicationStoreItemId, bibboxKitId, start,
			end);
	}

	/**
	* Returns an ordered range of all the kit groups where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationStoreItemId the application store item ID
	* @param bibboxKitId the bibbox kit ID
	* @param start the lower bound of the range of kit groups
	* @param end the upper bound of the range of kit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching kit groups
	*/
	public static List<KitGroup> findByKitGroup(long applicationStoreItemId,
		long bibboxKitId, int start, int end,
		OrderByComparator<KitGroup> orderByComparator) {
		return getPersistence()
				   .findByKitGroup(applicationStoreItemId, bibboxKitId, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the kit groups where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationStoreItemId the application store item ID
	* @param bibboxKitId the bibbox kit ID
	* @param start the lower bound of the range of kit groups
	* @param end the upper bound of the range of kit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching kit groups
	*/
	public static List<KitGroup> findByKitGroup(long applicationStoreItemId,
		long bibboxKitId, int start, int end,
		OrderByComparator<KitGroup> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByKitGroup(applicationStoreItemId, bibboxKitId, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first kit group in the ordered set where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param bibboxKitId the bibbox kit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kit group
	* @throws NoSuchKitGroupException if a matching kit group could not be found
	*/
	public static KitGroup findByKitGroup_First(long applicationStoreItemId,
		long bibboxKitId, OrderByComparator<KitGroup> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchKitGroupException {
		return getPersistence()
				   .findByKitGroup_First(applicationStoreItemId, bibboxKitId,
			orderByComparator);
	}

	/**
	* Returns the first kit group in the ordered set where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param bibboxKitId the bibbox kit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kit group, or <code>null</code> if a matching kit group could not be found
	*/
	public static KitGroup fetchByKitGroup_First(long applicationStoreItemId,
		long bibboxKitId, OrderByComparator<KitGroup> orderByComparator) {
		return getPersistence()
				   .fetchByKitGroup_First(applicationStoreItemId, bibboxKitId,
			orderByComparator);
	}

	/**
	* Returns the last kit group in the ordered set where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param bibboxKitId the bibbox kit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kit group
	* @throws NoSuchKitGroupException if a matching kit group could not be found
	*/
	public static KitGroup findByKitGroup_Last(long applicationStoreItemId,
		long bibboxKitId, OrderByComparator<KitGroup> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchKitGroupException {
		return getPersistence()
				   .findByKitGroup_Last(applicationStoreItemId, bibboxKitId,
			orderByComparator);
	}

	/**
	* Returns the last kit group in the ordered set where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param bibboxKitId the bibbox kit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kit group, or <code>null</code> if a matching kit group could not be found
	*/
	public static KitGroup fetchByKitGroup_Last(long applicationStoreItemId,
		long bibboxKitId, OrderByComparator<KitGroup> orderByComparator) {
		return getPersistence()
				   .fetchByKitGroup_Last(applicationStoreItemId, bibboxKitId,
			orderByComparator);
	}

	/**
	* Returns the kit groups before and after the current kit group in the ordered set where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	*
	* @param kitGroupId the primary key of the current kit group
	* @param applicationStoreItemId the application store item ID
	* @param bibboxKitId the bibbox kit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kit group
	* @throws NoSuchKitGroupException if a kit group with the primary key could not be found
	*/
	public static KitGroup[] findByKitGroup_PrevAndNext(long kitGroupId,
		long applicationStoreItemId, long bibboxKitId,
		OrderByComparator<KitGroup> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchKitGroupException {
		return getPersistence()
				   .findByKitGroup_PrevAndNext(kitGroupId,
			applicationStoreItemId, bibboxKitId, orderByComparator);
	}

	/**
	* Removes all the kit groups where applicationStoreItemId = &#63; and bibboxKitId = &#63; from the database.
	*
	* @param applicationStoreItemId the application store item ID
	* @param bibboxKitId the bibbox kit ID
	*/
	public static void removeByKitGroup(long applicationStoreItemId,
		long bibboxKitId) {
		getPersistence().removeByKitGroup(applicationStoreItemId, bibboxKitId);
	}

	/**
	* Returns the number of kit groups where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param bibboxKitId the bibbox kit ID
	* @return the number of matching kit groups
	*/
	public static int countByKitGroup(long applicationStoreItemId,
		long bibboxKitId) {
		return getPersistence()
				   .countByKitGroup(applicationStoreItemId, bibboxKitId);
	}

	/**
	* Returns all the kit groups where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @return the matching kit groups
	*/
	public static List<KitGroup> findByKitGroups(long applicationStoreItemId) {
		return getPersistence().findByKitGroups(applicationStoreItemId);
	}

	/**
	* Returns a range of all the kit groups where applicationStoreItemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationStoreItemId the application store item ID
	* @param start the lower bound of the range of kit groups
	* @param end the upper bound of the range of kit groups (not inclusive)
	* @return the range of matching kit groups
	*/
	public static List<KitGroup> findByKitGroups(long applicationStoreItemId,
		int start, int end) {
		return getPersistence()
				   .findByKitGroups(applicationStoreItemId, start, end);
	}

	/**
	* Returns an ordered range of all the kit groups where applicationStoreItemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationStoreItemId the application store item ID
	* @param start the lower bound of the range of kit groups
	* @param end the upper bound of the range of kit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching kit groups
	*/
	public static List<KitGroup> findByKitGroups(long applicationStoreItemId,
		int start, int end, OrderByComparator<KitGroup> orderByComparator) {
		return getPersistence()
				   .findByKitGroups(applicationStoreItemId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the kit groups where applicationStoreItemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationStoreItemId the application store item ID
	* @param start the lower bound of the range of kit groups
	* @param end the upper bound of the range of kit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching kit groups
	*/
	public static List<KitGroup> findByKitGroups(long applicationStoreItemId,
		int start, int end, OrderByComparator<KitGroup> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByKitGroups(applicationStoreItemId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first kit group in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kit group
	* @throws NoSuchKitGroupException if a matching kit group could not be found
	*/
	public static KitGroup findByKitGroups_First(long applicationStoreItemId,
		OrderByComparator<KitGroup> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchKitGroupException {
		return getPersistence()
				   .findByKitGroups_First(applicationStoreItemId,
			orderByComparator);
	}

	/**
	* Returns the first kit group in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kit group, or <code>null</code> if a matching kit group could not be found
	*/
	public static KitGroup fetchByKitGroups_First(long applicationStoreItemId,
		OrderByComparator<KitGroup> orderByComparator) {
		return getPersistence()
				   .fetchByKitGroups_First(applicationStoreItemId,
			orderByComparator);
	}

	/**
	* Returns the last kit group in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kit group
	* @throws NoSuchKitGroupException if a matching kit group could not be found
	*/
	public static KitGroup findByKitGroups_Last(long applicationStoreItemId,
		OrderByComparator<KitGroup> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchKitGroupException {
		return getPersistence()
				   .findByKitGroups_Last(applicationStoreItemId,
			orderByComparator);
	}

	/**
	* Returns the last kit group in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kit group, or <code>null</code> if a matching kit group could not be found
	*/
	public static KitGroup fetchByKitGroups_Last(long applicationStoreItemId,
		OrderByComparator<KitGroup> orderByComparator) {
		return getPersistence()
				   .fetchByKitGroups_Last(applicationStoreItemId,
			orderByComparator);
	}

	/**
	* Returns the kit groups before and after the current kit group in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param kitGroupId the primary key of the current kit group
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kit group
	* @throws NoSuchKitGroupException if a kit group with the primary key could not be found
	*/
	public static KitGroup[] findByKitGroups_PrevAndNext(long kitGroupId,
		long applicationStoreItemId,
		OrderByComparator<KitGroup> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchKitGroupException {
		return getPersistence()
				   .findByKitGroups_PrevAndNext(kitGroupId,
			applicationStoreItemId, orderByComparator);
	}

	/**
	* Removes all the kit groups where applicationStoreItemId = &#63; from the database.
	*
	* @param applicationStoreItemId the application store item ID
	*/
	public static void removeByKitGroups(long applicationStoreItemId) {
		getPersistence().removeByKitGroups(applicationStoreItemId);
	}

	/**
	* Returns the number of kit groups where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @return the number of matching kit groups
	*/
	public static int countByKitGroups(long applicationStoreItemId) {
		return getPersistence().countByKitGroups(applicationStoreItemId);
	}

	/**
	* Caches the kit group in the entity cache if it is enabled.
	*
	* @param kitGroup the kit group
	*/
	public static void cacheResult(KitGroup kitGroup) {
		getPersistence().cacheResult(kitGroup);
	}

	/**
	* Caches the kit groups in the entity cache if it is enabled.
	*
	* @param kitGroups the kit groups
	*/
	public static void cacheResult(List<KitGroup> kitGroups) {
		getPersistence().cacheResult(kitGroups);
	}

	/**
	* Creates a new kit group with the primary key. Does not add the kit group to the database.
	*
	* @param kitGroupId the primary key for the new kit group
	* @return the new kit group
	*/
	public static KitGroup create(long kitGroupId) {
		return getPersistence().create(kitGroupId);
	}

	/**
	* Removes the kit group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param kitGroupId the primary key of the kit group
	* @return the kit group that was removed
	* @throws NoSuchKitGroupException if a kit group with the primary key could not be found
	*/
	public static KitGroup remove(long kitGroupId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchKitGroupException {
		return getPersistence().remove(kitGroupId);
	}

	public static KitGroup updateImpl(KitGroup kitGroup) {
		return getPersistence().updateImpl(kitGroup);
	}

	/**
	* Returns the kit group with the primary key or throws a {@link NoSuchKitGroupException} if it could not be found.
	*
	* @param kitGroupId the primary key of the kit group
	* @return the kit group
	* @throws NoSuchKitGroupException if a kit group with the primary key could not be found
	*/
	public static KitGroup findByPrimaryKey(long kitGroupId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchKitGroupException {
		return getPersistence().findByPrimaryKey(kitGroupId);
	}

	/**
	* Returns the kit group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param kitGroupId the primary key of the kit group
	* @return the kit group, or <code>null</code> if a kit group with the primary key could not be found
	*/
	public static KitGroup fetchByPrimaryKey(long kitGroupId) {
		return getPersistence().fetchByPrimaryKey(kitGroupId);
	}

	public static java.util.Map<java.io.Serializable, KitGroup> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the kit groups.
	*
	* @return the kit groups
	*/
	public static List<KitGroup> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the kit groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kit groups
	* @param end the upper bound of the range of kit groups (not inclusive)
	* @return the range of kit groups
	*/
	public static List<KitGroup> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the kit groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kit groups
	* @param end the upper bound of the range of kit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of kit groups
	*/
	public static List<KitGroup> findAll(int start, int end,
		OrderByComparator<KitGroup> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the kit groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kit groups
	* @param end the upper bound of the range of kit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of kit groups
	*/
	public static List<KitGroup> findAll(int start, int end,
		OrderByComparator<KitGroup> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the kit groups from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of kit groups.
	*
	* @return the number of kit groups
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static KitGroupPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (KitGroupPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.bibbox.liferay.portlet.service.ClpSerializer.getServletContextName(),
					KitGroupPersistence.class.getName());

			ReferenceRegistry.registerReference(KitGroupUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static KitGroupPersistence _persistence;
}