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

import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the application tag service. This utility wraps {@link at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.ApplicationTagPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationTagPersistence
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.ApplicationTagPersistenceImpl
 * @generated
 */
@ProviderType
public class ApplicationTagUtil {
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
	public static void clearCache(ApplicationTag applicationTag) {
		getPersistence().clearCache(applicationTag);
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
	public static List<ApplicationTag> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ApplicationTag> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ApplicationTag> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ApplicationTag> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ApplicationTag update(ApplicationTag applicationTag) {
		return getPersistence().update(applicationTag);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ApplicationTag update(ApplicationTag applicationTag,
		ServiceContext serviceContext) {
		return getPersistence().update(applicationTag, serviceContext);
	}

	/**
	* Returns all the application tags where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @return the matching application tags
	*/
	public static List<ApplicationTag> findByApplicationStoreItemId(
		long applicationStoreItemId) {
		return getPersistence()
				   .findByApplicationStoreItemId(applicationStoreItemId);
	}

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
	public static List<ApplicationTag> findByApplicationStoreItemId(
		long applicationStoreItemId, int start, int end) {
		return getPersistence()
				   .findByApplicationStoreItemId(applicationStoreItemId, start,
			end);
	}

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
	public static List<ApplicationTag> findByApplicationStoreItemId(
		long applicationStoreItemId, int start, int end,
		OrderByComparator<ApplicationTag> orderByComparator) {
		return getPersistence()
				   .findByApplicationStoreItemId(applicationStoreItemId, start,
			end, orderByComparator);
	}

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
	public static List<ApplicationTag> findByApplicationStoreItemId(
		long applicationStoreItemId, int start, int end,
		OrderByComparator<ApplicationTag> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByApplicationStoreItemId(applicationStoreItemId, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first application tag in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application tag
	* @throws NoSuchApplicationTagException if a matching application tag could not be found
	*/
	public static ApplicationTag findByApplicationStoreItemId_First(
		long applicationStoreItemId,
		OrderByComparator<ApplicationTag> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationTagException {
		return getPersistence()
				   .findByApplicationStoreItemId_First(applicationStoreItemId,
			orderByComparator);
	}

	/**
	* Returns the first application tag in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application tag, or <code>null</code> if a matching application tag could not be found
	*/
	public static ApplicationTag fetchByApplicationStoreItemId_First(
		long applicationStoreItemId,
		OrderByComparator<ApplicationTag> orderByComparator) {
		return getPersistence()
				   .fetchByApplicationStoreItemId_First(applicationStoreItemId,
			orderByComparator);
	}

	/**
	* Returns the last application tag in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application tag
	* @throws NoSuchApplicationTagException if a matching application tag could not be found
	*/
	public static ApplicationTag findByApplicationStoreItemId_Last(
		long applicationStoreItemId,
		OrderByComparator<ApplicationTag> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationTagException {
		return getPersistence()
				   .findByApplicationStoreItemId_Last(applicationStoreItemId,
			orderByComparator);
	}

	/**
	* Returns the last application tag in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application tag, or <code>null</code> if a matching application tag could not be found
	*/
	public static ApplicationTag fetchByApplicationStoreItemId_Last(
		long applicationStoreItemId,
		OrderByComparator<ApplicationTag> orderByComparator) {
		return getPersistence()
				   .fetchByApplicationStoreItemId_Last(applicationStoreItemId,
			orderByComparator);
	}

	/**
	* Returns the application tags before and after the current application tag in the ordered set where applicationStoreItemId = &#63;.
	*
	* @param applicationTagsId the primary key of the current application tag
	* @param applicationStoreItemId the application store item ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next application tag
	* @throws NoSuchApplicationTagException if a application tag with the primary key could not be found
	*/
	public static ApplicationTag[] findByApplicationStoreItemId_PrevAndNext(
		long applicationTagsId, long applicationStoreItemId,
		OrderByComparator<ApplicationTag> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationTagException {
		return getPersistence()
				   .findByApplicationStoreItemId_PrevAndNext(applicationTagsId,
			applicationStoreItemId, orderByComparator);
	}

	/**
	* Removes all the application tags where applicationStoreItemId = &#63; from the database.
	*
	* @param applicationStoreItemId the application store item ID
	*/
	public static void removeByApplicationStoreItemId(
		long applicationStoreItemId) {
		getPersistence().removeByApplicationStoreItemId(applicationStoreItemId);
	}

	/**
	* Returns the number of application tags where applicationStoreItemId = &#63;.
	*
	* @param applicationStoreItemId the application store item ID
	* @return the number of matching application tags
	*/
	public static int countByApplicationStoreItemId(long applicationStoreItemId) {
		return getPersistence()
				   .countByApplicationStoreItemId(applicationStoreItemId);
	}

	/**
	* Returns all the application tags where tag = &#63;.
	*
	* @param tag the tag
	* @return the matching application tags
	*/
	public static List<ApplicationTag> findByTag(java.lang.String tag) {
		return getPersistence().findByTag(tag);
	}

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
	public static List<ApplicationTag> findByTag(java.lang.String tag,
		int start, int end) {
		return getPersistence().findByTag(tag, start, end);
	}

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
	public static List<ApplicationTag> findByTag(java.lang.String tag,
		int start, int end, OrderByComparator<ApplicationTag> orderByComparator) {
		return getPersistence().findByTag(tag, start, end, orderByComparator);
	}

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
	public static List<ApplicationTag> findByTag(java.lang.String tag,
		int start, int end,
		OrderByComparator<ApplicationTag> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByTag(tag, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first application tag in the ordered set where tag = &#63;.
	*
	* @param tag the tag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application tag
	* @throws NoSuchApplicationTagException if a matching application tag could not be found
	*/
	public static ApplicationTag findByTag_First(java.lang.String tag,
		OrderByComparator<ApplicationTag> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationTagException {
		return getPersistence().findByTag_First(tag, orderByComparator);
	}

	/**
	* Returns the first application tag in the ordered set where tag = &#63;.
	*
	* @param tag the tag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application tag, or <code>null</code> if a matching application tag could not be found
	*/
	public static ApplicationTag fetchByTag_First(java.lang.String tag,
		OrderByComparator<ApplicationTag> orderByComparator) {
		return getPersistence().fetchByTag_First(tag, orderByComparator);
	}

	/**
	* Returns the last application tag in the ordered set where tag = &#63;.
	*
	* @param tag the tag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application tag
	* @throws NoSuchApplicationTagException if a matching application tag could not be found
	*/
	public static ApplicationTag findByTag_Last(java.lang.String tag,
		OrderByComparator<ApplicationTag> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationTagException {
		return getPersistence().findByTag_Last(tag, orderByComparator);
	}

	/**
	* Returns the last application tag in the ordered set where tag = &#63;.
	*
	* @param tag the tag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application tag, or <code>null</code> if a matching application tag could not be found
	*/
	public static ApplicationTag fetchByTag_Last(java.lang.String tag,
		OrderByComparator<ApplicationTag> orderByComparator) {
		return getPersistence().fetchByTag_Last(tag, orderByComparator);
	}

	/**
	* Returns the application tags before and after the current application tag in the ordered set where tag = &#63;.
	*
	* @param applicationTagsId the primary key of the current application tag
	* @param tag the tag
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next application tag
	* @throws NoSuchApplicationTagException if a application tag with the primary key could not be found
	*/
	public static ApplicationTag[] findByTag_PrevAndNext(
		long applicationTagsId, java.lang.String tag,
		OrderByComparator<ApplicationTag> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationTagException {
		return getPersistence()
				   .findByTag_PrevAndNext(applicationTagsId, tag,
			orderByComparator);
	}

	/**
	* Removes all the application tags where tag = &#63; from the database.
	*
	* @param tag the tag
	*/
	public static void removeByTag(java.lang.String tag) {
		getPersistence().removeByTag(tag);
	}

	/**
	* Returns the number of application tags where tag = &#63;.
	*
	* @param tag the tag
	* @return the number of matching application tags
	*/
	public static int countByTag(java.lang.String tag) {
		return getPersistence().countByTag(tag);
	}

	/**
	* Caches the application tag in the entity cache if it is enabled.
	*
	* @param applicationTag the application tag
	*/
	public static void cacheResult(ApplicationTag applicationTag) {
		getPersistence().cacheResult(applicationTag);
	}

	/**
	* Caches the application tags in the entity cache if it is enabled.
	*
	* @param applicationTags the application tags
	*/
	public static void cacheResult(List<ApplicationTag> applicationTags) {
		getPersistence().cacheResult(applicationTags);
	}

	/**
	* Creates a new application tag with the primary key. Does not add the application tag to the database.
	*
	* @param applicationTagsId the primary key for the new application tag
	* @return the new application tag
	*/
	public static ApplicationTag create(long applicationTagsId) {
		return getPersistence().create(applicationTagsId);
	}

	/**
	* Removes the application tag with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationTagsId the primary key of the application tag
	* @return the application tag that was removed
	* @throws NoSuchApplicationTagException if a application tag with the primary key could not be found
	*/
	public static ApplicationTag remove(long applicationTagsId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationTagException {
		return getPersistence().remove(applicationTagsId);
	}

	public static ApplicationTag updateImpl(ApplicationTag applicationTag) {
		return getPersistence().updateImpl(applicationTag);
	}

	/**
	* Returns the application tag with the primary key or throws a {@link NoSuchApplicationTagException} if it could not be found.
	*
	* @param applicationTagsId the primary key of the application tag
	* @return the application tag
	* @throws NoSuchApplicationTagException if a application tag with the primary key could not be found
	*/
	public static ApplicationTag findByPrimaryKey(long applicationTagsId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationTagException {
		return getPersistence().findByPrimaryKey(applicationTagsId);
	}

	/**
	* Returns the application tag with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param applicationTagsId the primary key of the application tag
	* @return the application tag, or <code>null</code> if a application tag with the primary key could not be found
	*/
	public static ApplicationTag fetchByPrimaryKey(long applicationTagsId) {
		return getPersistence().fetchByPrimaryKey(applicationTagsId);
	}

	public static java.util.Map<java.io.Serializable, ApplicationTag> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the application tags.
	*
	* @return the application tags
	*/
	public static List<ApplicationTag> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ApplicationTag> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ApplicationTag> findAll(int start, int end,
		OrderByComparator<ApplicationTag> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ApplicationTag> findAll(int start, int end,
		OrderByComparator<ApplicationTag> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the application tags from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of application tags.
	*
	* @return the number of application tags
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ApplicationTagPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ApplicationTagPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.bibbox.liferay.portlet.service.ClpSerializer.getServletContextName(),
					ApplicationTagPersistence.class.getName());

			ReferenceRegistry.registerReference(ApplicationTagUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static ApplicationTagPersistence _persistence;
}