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

import at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchKitGroupException;
import at.graz.meduni.bibbox.liferay.portlet.model.KitGroup;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the kit group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.KitGroupPersistenceImpl
 * @see KitGroupUtil
 * @generated
 */
@ProviderType
public interface KitGroupPersistence extends BasePersistence<KitGroup> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link KitGroupUtil} to access the kit group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the kit groups where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param bibboxKitId the bibbox kit ID
	* @return the matching kit groups
	*/
	public java.util.List<KitGroup> findByKitGroup(
		long applicationStoreItemId, long bibboxKitId);

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
	public java.util.List<KitGroup> findByKitGroup(
		long applicationStoreItemId, long bibboxKitId, int start, int end);

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
	public java.util.List<KitGroup> findByKitGroup(
		long applicationStoreItemId, long bibboxKitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KitGroup> orderByComparator);

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
	public java.util.List<KitGroup> findByKitGroup(
		long applicationStoreItemId, long bibboxKitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KitGroup> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first kit group in the ordered set where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param bibboxKitId the bibbox kit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kit group
	* @throws NoSuchKitGroupException if a matching kit group could not be found
	*/
	public KitGroup findByKitGroup_First(long applicationStoreItemId,
		long bibboxKitId,
		com.liferay.portal.kernel.util.OrderByComparator<KitGroup> orderByComparator)
		throws NoSuchKitGroupException;

	/**
	* Returns the first kit group in the ordered set where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param bibboxKitId the bibbox kit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kit group, or <code>null</code> if a matching kit group could not be found
	*/
	public KitGroup fetchByKitGroup_First(long applicationStoreItemId,
		long bibboxKitId,
		com.liferay.portal.kernel.util.OrderByComparator<KitGroup> orderByComparator);

	/**
	* Returns the last kit group in the ordered set where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param bibboxKitId the bibbox kit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kit group
	* @throws NoSuchKitGroupException if a matching kit group could not be found
	*/
	public KitGroup findByKitGroup_Last(long applicationStoreItemId,
		long bibboxKitId,
		com.liferay.portal.kernel.util.OrderByComparator<KitGroup> orderByComparator)
		throws NoSuchKitGroupException;

	/**
	* Returns the last kit group in the ordered set where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param bibboxKitId the bibbox kit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kit group, or <code>null</code> if a matching kit group could not be found
	*/
	public KitGroup fetchByKitGroup_Last(long applicationStoreItemId,
		long bibboxKitId,
		com.liferay.portal.kernel.util.OrderByComparator<KitGroup> orderByComparator);

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
	public KitGroup[] findByKitGroup_PrevAndNext(long kitGroupId,
		long applicationStoreItemId, long bibboxKitId,
		com.liferay.portal.kernel.util.OrderByComparator<KitGroup> orderByComparator)
		throws NoSuchKitGroupException;

	/**
	* Removes all the kit groups where applicationStoreItemId = &#63; and bibboxKitId = &#63; from the database.
	*
	* @param applicationStoreItemId the application store item ID
	* @param bibboxKitId the bibbox kit ID
	*/
	public void removeByKitGroup(long applicationStoreItemId, long bibboxKitId);

	/**
	* Returns the number of kit groups where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param bibboxKitId the bibbox kit ID
	* @return the number of matching kit groups
	*/
	public int countByKitGroup(long applicationStoreItemId, long bibboxKitId);

	/**
	* Returns all the kit groups where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @return the matching kit groups
	*/
	public java.util.List<KitGroup> findByKitGroups(long applicationStoreItemId);

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
	public java.util.List<KitGroup> findByKitGroups(
		long applicationStoreItemId, int start, int end);

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
	public java.util.List<KitGroup> findByKitGroups(
		long applicationStoreItemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KitGroup> orderByComparator);

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
	public java.util.List<KitGroup> findByKitGroups(
		long applicationStoreItemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KitGroup> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first kit group in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kit group
	* @throws NoSuchKitGroupException if a matching kit group could not be found
	*/
	public KitGroup findByKitGroups_First(long applicationStoreItemId,
		com.liferay.portal.kernel.util.OrderByComparator<KitGroup> orderByComparator)
		throws NoSuchKitGroupException;

	/**
	* Returns the first kit group in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching kit group, or <code>null</code> if a matching kit group could not be found
	*/
	public KitGroup fetchByKitGroups_First(long applicationStoreItemId,
		com.liferay.portal.kernel.util.OrderByComparator<KitGroup> orderByComparator);

	/**
	* Returns the last kit group in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kit group
	* @throws NoSuchKitGroupException if a matching kit group could not be found
	*/
	public KitGroup findByKitGroups_Last(long applicationStoreItemId,
		com.liferay.portal.kernel.util.OrderByComparator<KitGroup> orderByComparator)
		throws NoSuchKitGroupException;

	/**
	* Returns the last kit group in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching kit group, or <code>null</code> if a matching kit group could not be found
	*/
	public KitGroup fetchByKitGroups_Last(long applicationStoreItemId,
		com.liferay.portal.kernel.util.OrderByComparator<KitGroup> orderByComparator);

	/**
	* Returns the kit groups before and after the current kit group in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param kitGroupId the primary key of the current kit group
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next kit group
	* @throws NoSuchKitGroupException if a kit group with the primary key could not be found
	*/
	public KitGroup[] findByKitGroups_PrevAndNext(long kitGroupId,
		long applicationStoreItemId,
		com.liferay.portal.kernel.util.OrderByComparator<KitGroup> orderByComparator)
		throws NoSuchKitGroupException;

	/**
	* Removes all the kit groups where applicationStoreItemId = &#63; from the database.
	*
	* @param applicationStoreItemId the application store item ID
	*/
	public void removeByKitGroups(long applicationStoreItemId);

	/**
	* Returns the number of kit groups where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @return the number of matching kit groups
	*/
	public int countByKitGroups(long applicationStoreItemId);

	/**
	* Caches the kit group in the entity cache if it is enabled.
	*
	* @param kitGroup the kit group
	*/
	public void cacheResult(KitGroup kitGroup);

	/**
	* Caches the kit groups in the entity cache if it is enabled.
	*
	* @param kitGroups the kit groups
	*/
	public void cacheResult(java.util.List<KitGroup> kitGroups);

	/**
	* Creates a new kit group with the primary key. Does not add the kit group to the database.
	*
	* @param kitGroupId the primary key for the new kit group
	* @return the new kit group
	*/
	public KitGroup create(long kitGroupId);

	/**
	* Removes the kit group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param kitGroupId the primary key of the kit group
	* @return the kit group that was removed
	* @throws NoSuchKitGroupException if a kit group with the primary key could not be found
	*/
	public KitGroup remove(long kitGroupId) throws NoSuchKitGroupException;

	public KitGroup updateImpl(KitGroup kitGroup);

	/**
	* Returns the kit group with the primary key or throws a {@link NoSuchKitGroupException} if it could not be found.
	*
	* @param kitGroupId the primary key of the kit group
	* @return the kit group
	* @throws NoSuchKitGroupException if a kit group with the primary key could not be found
	*/
	public KitGroup findByPrimaryKey(long kitGroupId)
		throws NoSuchKitGroupException;

	/**
	* Returns the kit group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param kitGroupId the primary key of the kit group
	* @return the kit group, or <code>null</code> if a kit group with the primary key could not be found
	*/
	public KitGroup fetchByPrimaryKey(long kitGroupId);

	@Override
	public java.util.Map<java.io.Serializable, KitGroup> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the kit groups.
	*
	* @return the kit groups
	*/
	public java.util.List<KitGroup> findAll();

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
	public java.util.List<KitGroup> findAll(int start, int end);

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
	public java.util.List<KitGroup> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KitGroup> orderByComparator);

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
	public java.util.List<KitGroup> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KitGroup> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the kit groups from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of kit groups.
	*
	* @return the number of kit groups
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}