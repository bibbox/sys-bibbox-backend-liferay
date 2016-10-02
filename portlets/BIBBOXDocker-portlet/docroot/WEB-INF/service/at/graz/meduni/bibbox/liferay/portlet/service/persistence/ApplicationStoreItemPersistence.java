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

import at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationStoreItemException;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationStoreItem;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the application store item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.ApplicationStoreItemPersistenceImpl
 * @see ApplicationStoreItemUtil
 * @generated
 */
@ProviderType
public interface ApplicationStoreItemPersistence extends BasePersistence<ApplicationStoreItem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ApplicationStoreItemUtil} to access the application store item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the application store item where applicationName = &#63; or throws a {@link NoSuchApplicationStoreItemException} if it could not be found.
	*
	* @param applicationName the application name
	* @return the matching application store item
	* @throws NoSuchApplicationStoreItemException if a matching application store item could not be found
	*/
	public ApplicationStoreItem findByApplicationName(
		java.lang.String applicationName)
		throws NoSuchApplicationStoreItemException;

	/**
	* Returns the application store item where applicationName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param applicationName the application name
	* @return the matching application store item, or <code>null</code> if a matching application store item could not be found
	*/
	public ApplicationStoreItem fetchByApplicationName(
		java.lang.String applicationName);

	/**
	* Returns the application store item where applicationName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param applicationName the application name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching application store item, or <code>null</code> if a matching application store item could not be found
	*/
	public ApplicationStoreItem fetchByApplicationName(
		java.lang.String applicationName, boolean retrieveFromCache);

	/**
	* Removes the application store item where applicationName = &#63; from the database.
	*
	* @param applicationName the application name
	* @return the application store item that was removed
	*/
	public ApplicationStoreItem removeByApplicationName(
		java.lang.String applicationName)
		throws NoSuchApplicationStoreItemException;

	/**
	* Returns the number of application store items where applicationName = &#63;.
	*
	* @param applicationName the application name
	* @return the number of matching application store items
	*/
	public int countByApplicationName(java.lang.String applicationName);

	/**
	* Caches the application store item in the entity cache if it is enabled.
	*
	* @param applicationStoreItem the application store item
	*/
	public void cacheResult(ApplicationStoreItem applicationStoreItem);

	/**
	* Caches the application store items in the entity cache if it is enabled.
	*
	* @param applicationStoreItems the application store items
	*/
	public void cacheResult(
		java.util.List<ApplicationStoreItem> applicationStoreItems);

	/**
	* Creates a new application store item with the primary key. Does not add the application store item to the database.
	*
	* @param applicationStoreItemId the primary key for the new application store item
	* @return the new application store item
	*/
	public ApplicationStoreItem create(long applicationStoreItemId);

	/**
	* Removes the application store item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationStoreItemId the primary key of the application store item
	* @return the application store item that was removed
	* @throws NoSuchApplicationStoreItemException if a application store item with the primary key could not be found
	*/
	public ApplicationStoreItem remove(long applicationStoreItemId)
		throws NoSuchApplicationStoreItemException;

	public ApplicationStoreItem updateImpl(
		ApplicationStoreItem applicationStoreItem);

	/**
	* Returns the application store item with the primary key or throws a {@link NoSuchApplicationStoreItemException} if it could not be found.
	*
	* @param applicationStoreItemId the primary key of the application store item
	* @return the application store item
	* @throws NoSuchApplicationStoreItemException if a application store item with the primary key could not be found
	*/
	public ApplicationStoreItem findByPrimaryKey(long applicationStoreItemId)
		throws NoSuchApplicationStoreItemException;

	/**
	* Returns the application store item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param applicationStoreItemId the primary key of the application store item
	* @return the application store item, or <code>null</code> if a application store item with the primary key could not be found
	*/
	public ApplicationStoreItem fetchByPrimaryKey(long applicationStoreItemId);

	@Override
	public java.util.Map<java.io.Serializable, ApplicationStoreItem> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the application store items.
	*
	* @return the application store items
	*/
	public java.util.List<ApplicationStoreItem> findAll();

	/**
	* Returns a range of all the application store items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationStoreItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application store items
	* @param end the upper bound of the range of application store items (not inclusive)
	* @return the range of application store items
	*/
	public java.util.List<ApplicationStoreItem> findAll(int start, int end);

	/**
	* Returns an ordered range of all the application store items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationStoreItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application store items
	* @param end the upper bound of the range of application store items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of application store items
	*/
	public java.util.List<ApplicationStoreItem> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationStoreItem> orderByComparator);

	/**
	* Returns an ordered range of all the application store items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationStoreItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application store items
	* @param end the upper bound of the range of application store items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of application store items
	*/
	public java.util.List<ApplicationStoreItem> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationStoreItem> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the application store items from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of application store items.
	*
	* @return the number of application store items
	*/
	public int countAll();
}