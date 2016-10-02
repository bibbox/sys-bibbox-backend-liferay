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

import at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationTagException;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the application tag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.ApplicationTagPersistenceImpl
 * @see ApplicationTagUtil
 * @generated
 */
@ProviderType
public interface ApplicationTagPersistence extends BasePersistence<ApplicationTag> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ApplicationTagUtil} to access the application tag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the application tags where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @return the matching application tags
	*/
	public java.util.List<ApplicationTag> findByApplicationStoreItemId(
		long applicationStoreItemId);

	/**
	* Returns a range of all the application tags where applicationStoreItemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationStoreItemId the application store item ID
	* @param start the lower bound of the range of application tags
	* @param end the upper bound of the range of application tags (not inclusive)
	* @return the range of matching application tags
	*/
	public java.util.List<ApplicationTag> findByApplicationStoreItemId(
		long applicationStoreItemId, int start, int end);

	/**
	* Returns an ordered range of all the application tags where applicationStoreItemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationStoreItemId the application store item ID
	* @param start the lower bound of the range of application tags
	* @param end the upper bound of the range of application tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching application tags
	*/
	public java.util.List<ApplicationTag> findByApplicationStoreItemId(
		long applicationStoreItemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationTag> orderByComparator);

	/**
	* Returns an ordered range of all the application tags where applicationStoreItemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationStoreItemId the application store item ID
	* @param start the lower bound of the range of application tags
	* @param end the upper bound of the range of application tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching application tags
	*/
	public java.util.List<ApplicationTag> findByApplicationStoreItemId(
		long applicationStoreItemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationTag> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first application tag in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application tag
	* @throws NoSuchApplicationTagException if a matching application tag could not be found
	*/
	public ApplicationTag findByApplicationStoreItemId_First(
		long applicationStoreItemId,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationTag> orderByComparator)
		throws NoSuchApplicationTagException;

	/**
	* Returns the first application tag in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application tag, or <code>null</code> if a matching application tag could not be found
	*/
	public ApplicationTag fetchByApplicationStoreItemId_First(
		long applicationStoreItemId,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationTag> orderByComparator);

	/**
	* Returns the last application tag in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application tag
	* @throws NoSuchApplicationTagException if a matching application tag could not be found
	*/
	public ApplicationTag findByApplicationStoreItemId_Last(
		long applicationStoreItemId,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationTag> orderByComparator)
		throws NoSuchApplicationTagException;

	/**
	* Returns the last application tag in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application tag, or <code>null</code> if a matching application tag could not be found
	*/
	public ApplicationTag fetchByApplicationStoreItemId_Last(
		long applicationStoreItemId,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationTag> orderByComparator);

	/**
	* Returns the application tags before and after the current application tag in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationTagsId the primary key of the current application tag
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next application tag
	* @throws NoSuchApplicationTagException if a application tag with the primary key could not be found
	*/
	public ApplicationTag[] findByApplicationStoreItemId_PrevAndNext(
		long applicationTagsId, long applicationStoreItemId,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationTag> orderByComparator)
		throws NoSuchApplicationTagException;

	/**
	* Removes all the application tags where applicationStoreItemId = &#63; from the database.
	*
	* @param applicationStoreItemId the application store item ID
	*/
	public void removeByApplicationStoreItemId(long applicationStoreItemId);

	/**
	* Returns the number of application tags where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @return the number of matching application tags
	*/
	public int countByApplicationStoreItemId(long applicationStoreItemId);

	/**
	* Returns all the application tags where tag = &#63;.
	*
	* @param tag the tag
	* @return the matching application tags
	*/
	public java.util.List<ApplicationTag> findByTag(java.lang.String tag);

	/**
	* Returns a range of all the application tags where tag = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tag the tag
	* @param start the lower bound of the range of application tags
	* @param end the upper bound of the range of application tags (not inclusive)
	* @return the range of matching application tags
	*/
	public java.util.List<ApplicationTag> findByTag(java.lang.String tag,
		int start, int end);

	/**
	* Returns an ordered range of all the application tags where tag = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tag the tag
	* @param start the lower bound of the range of application tags
	* @param end the upper bound of the range of application tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching application tags
	*/
	public java.util.List<ApplicationTag> findByTag(java.lang.String tag,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationTag> orderByComparator);

	/**
	* Returns an ordered range of all the application tags where tag = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tag the tag
	* @param start the lower bound of the range of application tags
	* @param end the upper bound of the range of application tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching application tags
	*/
	public java.util.List<ApplicationTag> findByTag(java.lang.String tag,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationTag> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first application tag in the ordered set where tag = &#63;.
	*
	* @param tag the tag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application tag
	* @throws NoSuchApplicationTagException if a matching application tag could not be found
	*/
	public ApplicationTag findByTag_First(java.lang.String tag,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationTag> orderByComparator)
		throws NoSuchApplicationTagException;

	/**
	* Returns the first application tag in the ordered set where tag = &#63;.
	*
	* @param tag the tag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application tag, or <code>null</code> if a matching application tag could not be found
	*/
	public ApplicationTag fetchByTag_First(java.lang.String tag,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationTag> orderByComparator);

	/**
	* Returns the last application tag in the ordered set where tag = &#63;.
	*
	* @param tag the tag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application tag
	* @throws NoSuchApplicationTagException if a matching application tag could not be found
	*/
	public ApplicationTag findByTag_Last(java.lang.String tag,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationTag> orderByComparator)
		throws NoSuchApplicationTagException;

	/**
	* Returns the last application tag in the ordered set where tag = &#63;.
	*
	* @param tag the tag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application tag, or <code>null</code> if a matching application tag could not be found
	*/
	public ApplicationTag fetchByTag_Last(java.lang.String tag,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationTag> orderByComparator);

	/**
	* Returns the application tags before and after the current application tag in the ordered set where tag = &#63;.
	*
	* @param applicationTagsId the primary key of the current application tag
	* @param tag the tag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next application tag
	* @throws NoSuchApplicationTagException if a application tag with the primary key could not be found
	*/
	public ApplicationTag[] findByTag_PrevAndNext(long applicationTagsId,
		java.lang.String tag,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationTag> orderByComparator)
		throws NoSuchApplicationTagException;

	/**
	* Removes all the application tags where tag = &#63; from the database.
	*
	* @param tag the tag
	*/
	public void removeByTag(java.lang.String tag);

	/**
	* Returns the number of application tags where tag = &#63;.
	*
	* @param tag the tag
	* @return the number of matching application tags
	*/
	public int countByTag(java.lang.String tag);

	/**
	* Caches the application tag in the entity cache if it is enabled.
	*
	* @param applicationTag the application tag
	*/
	public void cacheResult(ApplicationTag applicationTag);

	/**
	* Caches the application tags in the entity cache if it is enabled.
	*
	* @param applicationTags the application tags
	*/
	public void cacheResult(java.util.List<ApplicationTag> applicationTags);

	/**
	* Creates a new application tag with the primary key. Does not add the application tag to the database.
	*
	* @param applicationTagsId the primary key for the new application tag
	* @return the new application tag
	*/
	public ApplicationTag create(long applicationTagsId);

	/**
	* Removes the application tag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationTagsId the primary key of the application tag
	* @return the application tag that was removed
	* @throws NoSuchApplicationTagException if a application tag with the primary key could not be found
	*/
	public ApplicationTag remove(long applicationTagsId)
		throws NoSuchApplicationTagException;

	public ApplicationTag updateImpl(ApplicationTag applicationTag);

	/**
	* Returns the application tag with the primary key or throws a {@link NoSuchApplicationTagException} if it could not be found.
	*
	* @param applicationTagsId the primary key of the application tag
	* @return the application tag
	* @throws NoSuchApplicationTagException if a application tag with the primary key could not be found
	*/
	public ApplicationTag findByPrimaryKey(long applicationTagsId)
		throws NoSuchApplicationTagException;

	/**
	* Returns the application tag with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param applicationTagsId the primary key of the application tag
	* @return the application tag, or <code>null</code> if a application tag with the primary key could not be found
	*/
	public ApplicationTag fetchByPrimaryKey(long applicationTagsId);

	@Override
	public java.util.Map<java.io.Serializable, ApplicationTag> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the application tags.
	*
	* @return the application tags
	*/
	public java.util.List<ApplicationTag> findAll();

	/**
	* Returns a range of all the application tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application tags
	* @param end the upper bound of the range of application tags (not inclusive)
	* @return the range of application tags
	*/
	public java.util.List<ApplicationTag> findAll(int start, int end);

	/**
	* Returns an ordered range of all the application tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application tags
	* @param end the upper bound of the range of application tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of application tags
	*/
	public java.util.List<ApplicationTag> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationTag> orderByComparator);

	/**
	* Returns an ordered range of all the application tags.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application tags
	* @param end the upper bound of the range of application tags (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of application tags
	*/
	public java.util.List<ApplicationTag> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationTag> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the application tags from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of application tags.
	*
	* @return the number of application tags
	*/
	public int countAll();
}