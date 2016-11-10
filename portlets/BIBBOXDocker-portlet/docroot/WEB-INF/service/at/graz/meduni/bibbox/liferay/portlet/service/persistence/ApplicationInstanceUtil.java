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

import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the application instance service. This utility wraps {@link at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.ApplicationInstancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationInstancePersistence
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.ApplicationInstancePersistenceImpl
 * @generated
 */
@ProviderType
public class ApplicationInstanceUtil {
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
	public static void clearCache(ApplicationInstance applicationInstance) {
		getPersistence().clearCache(applicationInstance);
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
	public static List<ApplicationInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ApplicationInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ApplicationInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ApplicationInstance> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ApplicationInstance update(
		ApplicationInstance applicationInstance) {
		return getPersistence().update(applicationInstance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ApplicationInstance update(
		ApplicationInstance applicationInstance, ServiceContext serviceContext) {
		return getPersistence().update(applicationInstance, serviceContext);
	}

	/**
	* Returns all the application instances where folderName = &#63;.
	*
	* @param folderName the folder name
	* @return the matching application instances
	*/
	public static List<ApplicationInstance> findByFolderName(
		java.lang.String folderName) {
		return getPersistence().findByFolderName(folderName);
	}

	/**
	* Returns a range of all the application instances where folderName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param folderName the folder name
	* @param start the lower bound of the range of application instances
	* @param end the upper bound of the range of application instances (not inclusive)
	* @return the range of matching application instances
	*/
	public static List<ApplicationInstance> findByFolderName(
		java.lang.String folderName, int start, int end) {
		return getPersistence().findByFolderName(folderName, start, end);
	}

	/**
	* Returns an ordered range of all the application instances where folderName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param folderName the folder name
	* @param start the lower bound of the range of application instances
	* @param end the upper bound of the range of application instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching application instances
	*/
	public static List<ApplicationInstance> findByFolderName(
		java.lang.String folderName, int start, int end,
		OrderByComparator<ApplicationInstance> orderByComparator) {
		return getPersistence()
				   .findByFolderName(folderName, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the application instances where folderName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param folderName the folder name
	* @param start the lower bound of the range of application instances
	* @param end the upper bound of the range of application instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching application instances
	*/
	public static List<ApplicationInstance> findByFolderName(
		java.lang.String folderName, int start, int end,
		OrderByComparator<ApplicationInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByFolderName(folderName, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first application instance in the ordered set where folderName = &#63;.
	*
	* @param folderName the folder name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance
	* @throws NoSuchApplicationInstanceException if a matching application instance could not be found
	*/
	public static ApplicationInstance findByFolderName_First(
		java.lang.String folderName,
		OrderByComparator<ApplicationInstance> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceException {
		return getPersistence()
				   .findByFolderName_First(folderName, orderByComparator);
	}

	/**
	* Returns the first application instance in the ordered set where folderName = &#63;.
	*
	* @param folderName the folder name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance, or <code>null</code> if a matching application instance could not be found
	*/
	public static ApplicationInstance fetchByFolderName_First(
		java.lang.String folderName,
		OrderByComparator<ApplicationInstance> orderByComparator) {
		return getPersistence()
				   .fetchByFolderName_First(folderName, orderByComparator);
	}

	/**
	* Returns the last application instance in the ordered set where folderName = &#63;.
	*
	* @param folderName the folder name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance
	* @throws NoSuchApplicationInstanceException if a matching application instance could not be found
	*/
	public static ApplicationInstance findByFolderName_Last(
		java.lang.String folderName,
		OrderByComparator<ApplicationInstance> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceException {
		return getPersistence()
				   .findByFolderName_Last(folderName, orderByComparator);
	}

	/**
	* Returns the last application instance in the ordered set where folderName = &#63;.
	*
	* @param folderName the folder name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance, or <code>null</code> if a matching application instance could not be found
	*/
	public static ApplicationInstance fetchByFolderName_Last(
		java.lang.String folderName,
		OrderByComparator<ApplicationInstance> orderByComparator) {
		return getPersistence()
				   .fetchByFolderName_Last(folderName, orderByComparator);
	}

	/**
	* Returns the application instances before and after the current application instance in the ordered set where folderName = &#63;.
	*
	* @param applicationInstanceId the primary key of the current application instance
	* @param folderName the folder name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next application instance
	* @throws NoSuchApplicationInstanceException if a application instance with the primary key could not be found
	*/
	public static ApplicationInstance[] findByFolderName_PrevAndNext(
		long applicationInstanceId, java.lang.String folderName,
		OrderByComparator<ApplicationInstance> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceException {
		return getPersistence()
				   .findByFolderName_PrevAndNext(applicationInstanceId,
			folderName, orderByComparator);
	}

	/**
	* Removes all the application instances where folderName = &#63; from the database.
	*
	* @param folderName the folder name
	*/
	public static void removeByFolderName(java.lang.String folderName) {
		getPersistence().removeByFolderName(folderName);
	}

	/**
	* Returns the number of application instances where folderName = &#63;.
	*
	* @param folderName the folder name
	* @return the number of matching application instances
	*/
	public static int countByFolderName(java.lang.String folderName) {
		return getPersistence().countByFolderName(folderName);
	}

	/**
	* Returns the application instance where instanceId = &#63; or throws a {@link NoSuchApplicationInstanceException} if it could not be found.
	*
	* @param instanceId the instance ID
	* @return the matching application instance
	* @throws NoSuchApplicationInstanceException if a matching application instance could not be found
	*/
	public static ApplicationInstance findByInstanceId(
		java.lang.String instanceId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceException {
		return getPersistence().findByInstanceId(instanceId);
	}

	/**
	* Returns the application instance where instanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param instanceId the instance ID
	* @return the matching application instance, or <code>null</code> if a matching application instance could not be found
	*/
	public static ApplicationInstance fetchByInstanceId(
		java.lang.String instanceId) {
		return getPersistence().fetchByInstanceId(instanceId);
	}

	/**
	* Returns the application instance where instanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param instanceId the instance ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching application instance, or <code>null</code> if a matching application instance could not be found
	*/
	public static ApplicationInstance fetchByInstanceId(
		java.lang.String instanceId, boolean retrieveFromCache) {
		return getPersistence().fetchByInstanceId(instanceId, retrieveFromCache);
	}

	/**
	* Removes the application instance where instanceId = &#63; from the database.
	*
	* @param instanceId the instance ID
	* @return the application instance that was removed
	*/
	public static ApplicationInstance removeByInstanceId(
		java.lang.String instanceId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceException {
		return getPersistence().removeByInstanceId(instanceId);
	}

	/**
	* Returns the number of application instances where instanceId = &#63;.
	*
	* @param instanceId the instance ID
	* @return the number of matching application instances
	*/
	public static int countByInstanceId(java.lang.String instanceId) {
		return getPersistence().countByInstanceId(instanceId);
	}

	/**
	* Returns all the application instances where deleted = &#63;.
	*
	* @param deleted the deleted
	* @return the matching application instances
	*/
	public static List<ApplicationInstance> findByInstancesNotDeleted(
		boolean deleted) {
		return getPersistence().findByInstancesNotDeleted(deleted);
	}

	/**
	* Returns a range of all the application instances where deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param deleted the deleted
	* @param start the lower bound of the range of application instances
	* @param end the upper bound of the range of application instances (not inclusive)
	* @return the range of matching application instances
	*/
	public static List<ApplicationInstance> findByInstancesNotDeleted(
		boolean deleted, int start, int end) {
		return getPersistence().findByInstancesNotDeleted(deleted, start, end);
	}

	/**
	* Returns an ordered range of all the application instances where deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param deleted the deleted
	* @param start the lower bound of the range of application instances
	* @param end the upper bound of the range of application instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching application instances
	*/
	public static List<ApplicationInstance> findByInstancesNotDeleted(
		boolean deleted, int start, int end,
		OrderByComparator<ApplicationInstance> orderByComparator) {
		return getPersistence()
				   .findByInstancesNotDeleted(deleted, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the application instances where deleted = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param deleted the deleted
	* @param start the lower bound of the range of application instances
	* @param end the upper bound of the range of application instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching application instances
	*/
	public static List<ApplicationInstance> findByInstancesNotDeleted(
		boolean deleted, int start, int end,
		OrderByComparator<ApplicationInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByInstancesNotDeleted(deleted, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first application instance in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance
	* @throws NoSuchApplicationInstanceException if a matching application instance could not be found
	*/
	public static ApplicationInstance findByInstancesNotDeleted_First(
		boolean deleted,
		OrderByComparator<ApplicationInstance> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceException {
		return getPersistence()
				   .findByInstancesNotDeleted_First(deleted, orderByComparator);
	}

	/**
	* Returns the first application instance in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance, or <code>null</code> if a matching application instance could not be found
	*/
	public static ApplicationInstance fetchByInstancesNotDeleted_First(
		boolean deleted,
		OrderByComparator<ApplicationInstance> orderByComparator) {
		return getPersistence()
				   .fetchByInstancesNotDeleted_First(deleted, orderByComparator);
	}

	/**
	* Returns the last application instance in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance
	* @throws NoSuchApplicationInstanceException if a matching application instance could not be found
	*/
	public static ApplicationInstance findByInstancesNotDeleted_Last(
		boolean deleted,
		OrderByComparator<ApplicationInstance> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceException {
		return getPersistence()
				   .findByInstancesNotDeleted_Last(deleted, orderByComparator);
	}

	/**
	* Returns the last application instance in the ordered set where deleted = &#63;.
	*
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance, or <code>null</code> if a matching application instance could not be found
	*/
	public static ApplicationInstance fetchByInstancesNotDeleted_Last(
		boolean deleted,
		OrderByComparator<ApplicationInstance> orderByComparator) {
		return getPersistence()
				   .fetchByInstancesNotDeleted_Last(deleted, orderByComparator);
	}

	/**
	* Returns the application instances before and after the current application instance in the ordered set where deleted = &#63;.
	*
	* @param applicationInstanceId the primary key of the current application instance
	* @param deleted the deleted
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next application instance
	* @throws NoSuchApplicationInstanceException if a application instance with the primary key could not be found
	*/
	public static ApplicationInstance[] findByInstancesNotDeleted_PrevAndNext(
		long applicationInstanceId, boolean deleted,
		OrderByComparator<ApplicationInstance> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceException {
		return getPersistence()
				   .findByInstancesNotDeleted_PrevAndNext(applicationInstanceId,
			deleted, orderByComparator);
	}

	/**
	* Removes all the application instances where deleted = &#63; from the database.
	*
	* @param deleted the deleted
	*/
	public static void removeByInstancesNotDeleted(boolean deleted) {
		getPersistence().removeByInstancesNotDeleted(deleted);
	}

	/**
	* Returns the number of application instances where deleted = &#63;.
	*
	* @param deleted the deleted
	* @return the number of matching application instances
	*/
	public static int countByInstancesNotDeleted(boolean deleted) {
		return getPersistence().countByInstancesNotDeleted(deleted);
	}

	/**
	* Caches the application instance in the entity cache if it is enabled.
	*
	* @param applicationInstance the application instance
	*/
	public static void cacheResult(ApplicationInstance applicationInstance) {
		getPersistence().cacheResult(applicationInstance);
	}

	/**
	* Caches the application instances in the entity cache if it is enabled.
	*
	* @param applicationInstances the application instances
	*/
	public static void cacheResult(
		List<ApplicationInstance> applicationInstances) {
		getPersistence().cacheResult(applicationInstances);
	}

	/**
	* Creates a new application instance with the primary key. Does not add the application instance to the database.
	*
	* @param applicationInstanceId the primary key for the new application instance
	* @return the new application instance
	*/
	public static ApplicationInstance create(long applicationInstanceId) {
		return getPersistence().create(applicationInstanceId);
	}

	/**
	* Removes the application instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstanceId the primary key of the application instance
	* @return the application instance that was removed
	* @throws NoSuchApplicationInstanceException if a application instance with the primary key could not be found
	*/
	public static ApplicationInstance remove(long applicationInstanceId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceException {
		return getPersistence().remove(applicationInstanceId);
	}

	public static ApplicationInstance updateImpl(
		ApplicationInstance applicationInstance) {
		return getPersistence().updateImpl(applicationInstance);
	}

	/**
	* Returns the application instance with the primary key or throws a {@link NoSuchApplicationInstanceException} if it could not be found.
	*
	* @param applicationInstanceId the primary key of the application instance
	* @return the application instance
	* @throws NoSuchApplicationInstanceException if a application instance with the primary key could not be found
	*/
	public static ApplicationInstance findByPrimaryKey(
		long applicationInstanceId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceException {
		return getPersistence().findByPrimaryKey(applicationInstanceId);
	}

	/**
	* Returns the application instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param applicationInstanceId the primary key of the application instance
	* @return the application instance, or <code>null</code> if a application instance with the primary key could not be found
	*/
	public static ApplicationInstance fetchByPrimaryKey(
		long applicationInstanceId) {
		return getPersistence().fetchByPrimaryKey(applicationInstanceId);
	}

	public static java.util.Map<java.io.Serializable, ApplicationInstance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the application instances.
	*
	* @return the application instances
	*/
	public static List<ApplicationInstance> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the application instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application instances
	* @param end the upper bound of the range of application instances (not inclusive)
	* @return the range of application instances
	*/
	public static List<ApplicationInstance> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the application instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application instances
	* @param end the upper bound of the range of application instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of application instances
	*/
	public static List<ApplicationInstance> findAll(int start, int end,
		OrderByComparator<ApplicationInstance> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the application instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application instances
	* @param end the upper bound of the range of application instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of application instances
	*/
	public static List<ApplicationInstance> findAll(int start, int end,
		OrderByComparator<ApplicationInstance> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the application instances from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of application instances.
	*
	* @return the number of application instances
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ApplicationInstancePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ApplicationInstancePersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.bibbox.liferay.portlet.service.ClpSerializer.getServletContextName(),
					ApplicationInstancePersistence.class.getName());

			ReferenceRegistry.registerReference(ApplicationInstanceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static ApplicationInstancePersistence _persistence;
}