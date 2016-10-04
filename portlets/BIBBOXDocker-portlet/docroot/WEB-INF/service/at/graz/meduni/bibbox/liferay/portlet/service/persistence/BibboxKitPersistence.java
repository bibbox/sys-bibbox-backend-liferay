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

import at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchBibboxKitException;
import at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the bibbox kit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.BibboxKitPersistenceImpl
 * @see BibboxKitUtil
 * @generated
 */
@ProviderType
public interface BibboxKitPersistence extends BasePersistence<BibboxKit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BibboxKitUtil} to access the bibbox kit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bibbox kits where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @return the matching bibbox kits
	*/
	public java.util.List<BibboxKit> findByApplicationStoreItemId(
		long applicationStoreItemId);

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
	public java.util.List<BibboxKit> findByApplicationStoreItemId(
		long applicationStoreItemId, int start, int end);

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
	public java.util.List<BibboxKit> findByApplicationStoreItemId(
		long applicationStoreItemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BibboxKit> orderByComparator);

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
	public java.util.List<BibboxKit> findByApplicationStoreItemId(
		long applicationStoreItemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BibboxKit> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first bibbox kit in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bibbox kit
	* @throws NoSuchBibboxKitException if a matching bibbox kit could not be found
	*/
	public BibboxKit findByApplicationStoreItemId_First(
		long applicationStoreItemId,
		com.liferay.portal.kernel.util.OrderByComparator<BibboxKit> orderByComparator)
		throws NoSuchBibboxKitException;

	/**
	* Returns the first bibbox kit in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bibbox kit, or <code>null</code> if a matching bibbox kit could not be found
	*/
	public BibboxKit fetchByApplicationStoreItemId_First(
		long applicationStoreItemId,
		com.liferay.portal.kernel.util.OrderByComparator<BibboxKit> orderByComparator);

	/**
	* Returns the last bibbox kit in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bibbox kit
	* @throws NoSuchBibboxKitException if a matching bibbox kit could not be found
	*/
	public BibboxKit findByApplicationStoreItemId_Last(
		long applicationStoreItemId,
		com.liferay.portal.kernel.util.OrderByComparator<BibboxKit> orderByComparator)
		throws NoSuchBibboxKitException;

	/**
	* Returns the last bibbox kit in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bibbox kit, or <code>null</code> if a matching bibbox kit could not be found
	*/
	public BibboxKit fetchByApplicationStoreItemId_Last(
		long applicationStoreItemId,
		com.liferay.portal.kernel.util.OrderByComparator<BibboxKit> orderByComparator);

	/**
	* Returns the bibbox kits before and after the current bibbox kit in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param bibboxKitId the primary key of the current bibbox kit
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bibbox kit
	* @throws NoSuchBibboxKitException if a bibbox kit with the primary key could not be found
	*/
	public BibboxKit[] findByApplicationStoreItemId_PrevAndNext(
		long bibboxKitId, long applicationStoreItemId,
		com.liferay.portal.kernel.util.OrderByComparator<BibboxKit> orderByComparator)
		throws NoSuchBibboxKitException;

	/**
	* Removes all the bibbox kits where applicationStoreItemId = &#63; from the database.
	*
	* @param applicationStoreItemId the application store item ID
	*/
	public void removeByApplicationStoreItemId(long applicationStoreItemId);

	/**
	* Returns the number of bibbox kits where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @return the number of matching bibbox kits
	*/
	public int countByApplicationStoreItemId(long applicationStoreItemId);

	/**
	* Returns all the bibbox kits where kitName = &#63;.
	*
	* @param kitName the kit name
	* @return the matching bibbox kits
	*/
	public java.util.List<BibboxKit> findByKitName(java.lang.String kitName);

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
	public java.util.List<BibboxKit> findByKitName(java.lang.String kitName,
		int start, int end);

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
	public java.util.List<BibboxKit> findByKitName(java.lang.String kitName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BibboxKit> orderByComparator);

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
	public java.util.List<BibboxKit> findByKitName(java.lang.String kitName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BibboxKit> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first bibbox kit in the ordered set where kitName = &#63;.
	*
	* @param kitName the kit name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bibbox kit
	* @throws NoSuchBibboxKitException if a matching bibbox kit could not be found
	*/
	public BibboxKit findByKitName_First(java.lang.String kitName,
		com.liferay.portal.kernel.util.OrderByComparator<BibboxKit> orderByComparator)
		throws NoSuchBibboxKitException;

	/**
	* Returns the first bibbox kit in the ordered set where kitName = &#63;.
	*
	* @param kitName the kit name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bibbox kit, or <code>null</code> if a matching bibbox kit could not be found
	*/
	public BibboxKit fetchByKitName_First(java.lang.String kitName,
		com.liferay.portal.kernel.util.OrderByComparator<BibboxKit> orderByComparator);

	/**
	* Returns the last bibbox kit in the ordered set where kitName = &#63;.
	*
	* @param kitName the kit name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bibbox kit
	* @throws NoSuchBibboxKitException if a matching bibbox kit could not be found
	*/
	public BibboxKit findByKitName_Last(java.lang.String kitName,
		com.liferay.portal.kernel.util.OrderByComparator<BibboxKit> orderByComparator)
		throws NoSuchBibboxKitException;

	/**
	* Returns the last bibbox kit in the ordered set where kitName = &#63;.
	*
	* @param kitName the kit name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bibbox kit, or <code>null</code> if a matching bibbox kit could not be found
	*/
	public BibboxKit fetchByKitName_Last(java.lang.String kitName,
		com.liferay.portal.kernel.util.OrderByComparator<BibboxKit> orderByComparator);

	/**
	* Returns the bibbox kits before and after the current bibbox kit in the ordered set where kitName = &#63;.
	*
	* @param bibboxKitId the primary key of the current bibbox kit
	* @param kitName the kit name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bibbox kit
	* @throws NoSuchBibboxKitException if a bibbox kit with the primary key could not be found
	*/
	public BibboxKit[] findByKitName_PrevAndNext(long bibboxKitId,
		java.lang.String kitName,
		com.liferay.portal.kernel.util.OrderByComparator<BibboxKit> orderByComparator)
		throws NoSuchBibboxKitException;

	/**
	* Removes all the bibbox kits where kitName = &#63; from the database.
	*
	* @param kitName the kit name
	*/
	public void removeByKitName(java.lang.String kitName);

	/**
	* Returns the number of bibbox kits where kitName = &#63;.
	*
	* @param kitName the kit name
	* @return the number of matching bibbox kits
	*/
	public int countByKitName(java.lang.String kitName);

	/**
	* Returns the bibbox kit where kitName = &#63; and applicationStoreItemId = &#63; or throws a {@link NoSuchBibboxKitException} if it could not be found.
	*
	* @param kitName the kit name
	* @param applicationStoreItemId the application store item ID
	* @return the matching bibbox kit
	* @throws NoSuchBibboxKitException if a matching bibbox kit could not be found
	*/
	public BibboxKit findByKitName(java.lang.String kitName,
		long applicationStoreItemId) throws NoSuchBibboxKitException;

	/**
	* Returns the bibbox kit where kitName = &#63; and applicationStoreItemId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param kitName the kit name
	* @param applicationStoreItemId the application store item ID
	* @return the matching bibbox kit, or <code>null</code> if a matching bibbox kit could not be found
	*/
	public BibboxKit fetchByKitName(java.lang.String kitName,
		long applicationStoreItemId);

	/**
	* Returns the bibbox kit where kitName = &#63; and applicationStoreItemId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param kitName the kit name
	* @param applicationStoreItemId the application store item ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching bibbox kit, or <code>null</code> if a matching bibbox kit could not be found
	*/
	public BibboxKit fetchByKitName(java.lang.String kitName,
		long applicationStoreItemId, boolean retrieveFromCache);

	/**
	* Removes the bibbox kit where kitName = &#63; and applicationStoreItemId = &#63; from the database.
	*
	* @param kitName the kit name
	* @param applicationStoreItemId the application store item ID
	* @return the bibbox kit that was removed
	*/
	public BibboxKit removeByKitName(java.lang.String kitName,
		long applicationStoreItemId) throws NoSuchBibboxKitException;

	/**
	* Returns the number of bibbox kits where kitName = &#63; and applicationStoreItemId = &#63;.
	*
	* @param kitName the kit name
	* @param applicationStoreItemId the application store item ID
	* @return the number of matching bibbox kits
	*/
	public int countByKitName(java.lang.String kitName,
		long applicationStoreItemId);

	/**
	* Caches the bibbox kit in the entity cache if it is enabled.
	*
	* @param bibboxKit the bibbox kit
	*/
	public void cacheResult(BibboxKit bibboxKit);

	/**
	* Caches the bibbox kits in the entity cache if it is enabled.
	*
	* @param bibboxKits the bibbox kits
	*/
	public void cacheResult(java.util.List<BibboxKit> bibboxKits);

	/**
	* Creates a new bibbox kit with the primary key. Does not add the bibbox kit to the database.
	*
	* @param bibboxKitId the primary key for the new bibbox kit
	* @return the new bibbox kit
	*/
	public BibboxKit create(long bibboxKitId);

	/**
	* Removes the bibbox kit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param bibboxKitId the primary key of the bibbox kit
	* @return the bibbox kit that was removed
	* @throws NoSuchBibboxKitException if a bibbox kit with the primary key could not be found
	*/
	public BibboxKit remove(long bibboxKitId) throws NoSuchBibboxKitException;

	public BibboxKit updateImpl(BibboxKit bibboxKit);

	/**
	* Returns the bibbox kit with the primary key or throws a {@link NoSuchBibboxKitException} if it could not be found.
	*
	* @param bibboxKitId the primary key of the bibbox kit
	* @return the bibbox kit
	* @throws NoSuchBibboxKitException if a bibbox kit with the primary key could not be found
	*/
	public BibboxKit findByPrimaryKey(long bibboxKitId)
		throws NoSuchBibboxKitException;

	/**
	* Returns the bibbox kit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param bibboxKitId the primary key of the bibbox kit
	* @return the bibbox kit, or <code>null</code> if a bibbox kit with the primary key could not be found
	*/
	public BibboxKit fetchByPrimaryKey(long bibboxKitId);

	@Override
	public java.util.Map<java.io.Serializable, BibboxKit> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the bibbox kits.
	*
	* @return the bibbox kits
	*/
	public java.util.List<BibboxKit> findAll();

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
	public java.util.List<BibboxKit> findAll(int start, int end);

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
	public java.util.List<BibboxKit> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BibboxKit> orderByComparator);

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
	public java.util.List<BibboxKit> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BibboxKit> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the bibbox kits from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of bibbox kits.
	*
	* @return the number of bibbox kits
	*/
	public int countAll();
}