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

import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the application instance container service. This utility wraps {@link at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.ApplicationInstanceContainerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationInstanceContainerPersistence
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.ApplicationInstanceContainerPersistenceImpl
 * @generated
 */
@ProviderType
public class ApplicationInstanceContainerUtil {
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
		ApplicationInstanceContainer applicationInstanceContainer) {
		getPersistence().clearCache(applicationInstanceContainer);
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
	public static List<ApplicationInstanceContainer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ApplicationInstanceContainer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ApplicationInstanceContainer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ApplicationInstanceContainer update(
		ApplicationInstanceContainer applicationInstanceContainer) {
		return getPersistence().update(applicationInstanceContainer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ApplicationInstanceContainer update(
		ApplicationInstanceContainer applicationInstanceContainer,
		ServiceContext serviceContext) {
		return getPersistence()
				   .update(applicationInstanceContainer, serviceContext);
	}

	/**
	* Returns all the application instance containers where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @return the matching application instance containers
	*/
	public static List<ApplicationInstanceContainer> findByApplicationInstance(
		long applicationInstanceId) {
		return getPersistence().findByApplicationInstance(applicationInstanceId);
	}

	/**
	* Returns a range of all the application instance containers where applicationInstanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationInstanceId the application instance ID
	* @param start the lower bound of the range of application instance containers
	* @param end the upper bound of the range of application instance containers (not inclusive)
	* @return the range of matching application instance containers
	*/
	public static List<ApplicationInstanceContainer> findByApplicationInstance(
		long applicationInstanceId, int start, int end) {
		return getPersistence()
				   .findByApplicationInstance(applicationInstanceId, start, end);
	}

	/**
	* Returns an ordered range of all the application instance containers where applicationInstanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationInstanceId the application instance ID
	* @param start the lower bound of the range of application instance containers
	* @param end the upper bound of the range of application instance containers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching application instance containers
	*/
	public static List<ApplicationInstanceContainer> findByApplicationInstance(
		long applicationInstanceId, int start, int end,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator) {
		return getPersistence()
				   .findByApplicationInstance(applicationInstanceId, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the application instance containers where applicationInstanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationInstanceId the application instance ID
	* @param start the lower bound of the range of application instance containers
	* @param end the upper bound of the range of application instance containers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching application instance containers
	*/
	public static List<ApplicationInstanceContainer> findByApplicationInstance(
		long applicationInstanceId, int start, int end,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByApplicationInstance(applicationInstanceId, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first application instance container in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance container
	* @throws NoSuchApplicationInstanceContainerException if a matching application instance container could not be found
	*/
	public static ApplicationInstanceContainer findByApplicationInstance_First(
		long applicationInstanceId,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceContainerException {
		return getPersistence()
				   .findByApplicationInstance_First(applicationInstanceId,
			orderByComparator);
	}

	/**
	* Returns the first application instance container in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance container, or <code>null</code> if a matching application instance container could not be found
	*/
	public static ApplicationInstanceContainer fetchByApplicationInstance_First(
		long applicationInstanceId,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator) {
		return getPersistence()
				   .fetchByApplicationInstance_First(applicationInstanceId,
			orderByComparator);
	}

	/**
	* Returns the last application instance container in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance container
	* @throws NoSuchApplicationInstanceContainerException if a matching application instance container could not be found
	*/
	public static ApplicationInstanceContainer findByApplicationInstance_Last(
		long applicationInstanceId,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceContainerException {
		return getPersistence()
				   .findByApplicationInstance_Last(applicationInstanceId,
			orderByComparator);
	}

	/**
	* Returns the last application instance container in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance container, or <code>null</code> if a matching application instance container could not be found
	*/
	public static ApplicationInstanceContainer fetchByApplicationInstance_Last(
		long applicationInstanceId,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator) {
		return getPersistence()
				   .fetchByApplicationInstance_Last(applicationInstanceId,
			orderByComparator);
	}

	/**
	* Returns the application instance containers before and after the current application instance container in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceContainerId the primary key of the current application instance container
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next application instance container
	* @throws NoSuchApplicationInstanceContainerException if a application instance container with the primary key could not be found
	*/
	public static ApplicationInstanceContainer[] findByApplicationInstance_PrevAndNext(
		long applicationInstanceContainerId, long applicationInstanceId,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceContainerException {
		return getPersistence()
				   .findByApplicationInstance_PrevAndNext(applicationInstanceContainerId,
			applicationInstanceId, orderByComparator);
	}

	/**
	* Removes all the application instance containers where applicationInstanceId = &#63; from the database.
	*
	* @param applicationInstanceId the application instance ID
	*/
	public static void removeByApplicationInstance(long applicationInstanceId) {
		getPersistence().removeByApplicationInstance(applicationInstanceId);
	}

	/**
	* Returns the number of application instance containers where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @return the number of matching application instance containers
	*/
	public static int countByApplicationInstance(long applicationInstanceId) {
		return getPersistence().countByApplicationInstance(applicationInstanceId);
	}

	/**
	* Returns all the application instance containers where applicationInstanceId = &#63; and needrunning = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param needrunning the needrunning
	* @return the matching application instance containers
	*/
	public static List<ApplicationInstanceContainer> findByApplicationInstanceRunning(
		long applicationInstanceId, boolean needrunning) {
		return getPersistence()
				   .findByApplicationInstanceRunning(applicationInstanceId,
			needrunning);
	}

	/**
	* Returns a range of all the application instance containers where applicationInstanceId = &#63; and needrunning = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationInstanceId the application instance ID
	* @param needrunning the needrunning
	* @param start the lower bound of the range of application instance containers
	* @param end the upper bound of the range of application instance containers (not inclusive)
	* @return the range of matching application instance containers
	*/
	public static List<ApplicationInstanceContainer> findByApplicationInstanceRunning(
		long applicationInstanceId, boolean needrunning, int start, int end) {
		return getPersistence()
				   .findByApplicationInstanceRunning(applicationInstanceId,
			needrunning, start, end);
	}

	/**
	* Returns an ordered range of all the application instance containers where applicationInstanceId = &#63; and needrunning = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationInstanceId the application instance ID
	* @param needrunning the needrunning
	* @param start the lower bound of the range of application instance containers
	* @param end the upper bound of the range of application instance containers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching application instance containers
	*/
	public static List<ApplicationInstanceContainer> findByApplicationInstanceRunning(
		long applicationInstanceId, boolean needrunning, int start, int end,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator) {
		return getPersistence()
				   .findByApplicationInstanceRunning(applicationInstanceId,
			needrunning, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the application instance containers where applicationInstanceId = &#63; and needrunning = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationInstanceId the application instance ID
	* @param needrunning the needrunning
	* @param start the lower bound of the range of application instance containers
	* @param end the upper bound of the range of application instance containers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching application instance containers
	*/
	public static List<ApplicationInstanceContainer> findByApplicationInstanceRunning(
		long applicationInstanceId, boolean needrunning, int start, int end,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByApplicationInstanceRunning(applicationInstanceId,
			needrunning, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first application instance container in the ordered set where applicationInstanceId = &#63; and needrunning = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param needrunning the needrunning
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance container
	* @throws NoSuchApplicationInstanceContainerException if a matching application instance container could not be found
	*/
	public static ApplicationInstanceContainer findByApplicationInstanceRunning_First(
		long applicationInstanceId, boolean needrunning,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceContainerException {
		return getPersistence()
				   .findByApplicationInstanceRunning_First(applicationInstanceId,
			needrunning, orderByComparator);
	}

	/**
	* Returns the first application instance container in the ordered set where applicationInstanceId = &#63; and needrunning = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param needrunning the needrunning
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance container, or <code>null</code> if a matching application instance container could not be found
	*/
	public static ApplicationInstanceContainer fetchByApplicationInstanceRunning_First(
		long applicationInstanceId, boolean needrunning,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator) {
		return getPersistence()
				   .fetchByApplicationInstanceRunning_First(applicationInstanceId,
			needrunning, orderByComparator);
	}

	/**
	* Returns the last application instance container in the ordered set where applicationInstanceId = &#63; and needrunning = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param needrunning the needrunning
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance container
	* @throws NoSuchApplicationInstanceContainerException if a matching application instance container could not be found
	*/
	public static ApplicationInstanceContainer findByApplicationInstanceRunning_Last(
		long applicationInstanceId, boolean needrunning,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceContainerException {
		return getPersistence()
				   .findByApplicationInstanceRunning_Last(applicationInstanceId,
			needrunning, orderByComparator);
	}

	/**
	* Returns the last application instance container in the ordered set where applicationInstanceId = &#63; and needrunning = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param needrunning the needrunning
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance container, or <code>null</code> if a matching application instance container could not be found
	*/
	public static ApplicationInstanceContainer fetchByApplicationInstanceRunning_Last(
		long applicationInstanceId, boolean needrunning,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator) {
		return getPersistence()
				   .fetchByApplicationInstanceRunning_Last(applicationInstanceId,
			needrunning, orderByComparator);
	}

	/**
	* Returns the application instance containers before and after the current application instance container in the ordered set where applicationInstanceId = &#63; and needrunning = &#63;.
	*
	* @param applicationInstanceContainerId the primary key of the current application instance container
	* @param applicationInstanceId the application instance ID
	* @param needrunning the needrunning
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next application instance container
	* @throws NoSuchApplicationInstanceContainerException if a application instance container with the primary key could not be found
	*/
	public static ApplicationInstanceContainer[] findByApplicationInstanceRunning_PrevAndNext(
		long applicationInstanceContainerId, long applicationInstanceId,
		boolean needrunning,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceContainerException {
		return getPersistence()
				   .findByApplicationInstanceRunning_PrevAndNext(applicationInstanceContainerId,
			applicationInstanceId, needrunning, orderByComparator);
	}

	/**
	* Removes all the application instance containers where applicationInstanceId = &#63; and needrunning = &#63; from the database.
	*
	* @param applicationInstanceId the application instance ID
	* @param needrunning the needrunning
	*/
	public static void removeByApplicationInstanceRunning(
		long applicationInstanceId, boolean needrunning) {
		getPersistence()
			.removeByApplicationInstanceRunning(applicationInstanceId,
			needrunning);
	}

	/**
	* Returns the number of application instance containers where applicationInstanceId = &#63; and needrunning = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param needrunning the needrunning
	* @return the number of matching application instance containers
	*/
	public static int countByApplicationInstanceRunning(
		long applicationInstanceId, boolean needrunning) {
		return getPersistence()
				   .countByApplicationInstanceRunning(applicationInstanceId,
			needrunning);
	}

	/**
	* Caches the application instance container in the entity cache if it is enabled.
	*
	* @param applicationInstanceContainer the application instance container
	*/
	public static void cacheResult(
		ApplicationInstanceContainer applicationInstanceContainer) {
		getPersistence().cacheResult(applicationInstanceContainer);
	}

	/**
	* Caches the application instance containers in the entity cache if it is enabled.
	*
	* @param applicationInstanceContainers the application instance containers
	*/
	public static void cacheResult(
		List<ApplicationInstanceContainer> applicationInstanceContainers) {
		getPersistence().cacheResult(applicationInstanceContainers);
	}

	/**
	* Creates a new application instance container with the primary key. Does not add the application instance container to the database.
	*
	* @param applicationInstanceContainerId the primary key for the new application instance container
	* @return the new application instance container
	*/
	public static ApplicationInstanceContainer create(
		long applicationInstanceContainerId) {
		return getPersistence().create(applicationInstanceContainerId);
	}

	/**
	* Removes the application instance container with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstanceContainerId the primary key of the application instance container
	* @return the application instance container that was removed
	* @throws NoSuchApplicationInstanceContainerException if a application instance container with the primary key could not be found
	*/
	public static ApplicationInstanceContainer remove(
		long applicationInstanceContainerId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceContainerException {
		return getPersistence().remove(applicationInstanceContainerId);
	}

	public static ApplicationInstanceContainer updateImpl(
		ApplicationInstanceContainer applicationInstanceContainer) {
		return getPersistence().updateImpl(applicationInstanceContainer);
	}

	/**
	* Returns the application instance container with the primary key or throws a {@link NoSuchApplicationInstanceContainerException} if it could not be found.
	*
	* @param applicationInstanceContainerId the primary key of the application instance container
	* @return the application instance container
	* @throws NoSuchApplicationInstanceContainerException if a application instance container with the primary key could not be found
	*/
	public static ApplicationInstanceContainer findByPrimaryKey(
		long applicationInstanceContainerId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceContainerException {
		return getPersistence().findByPrimaryKey(applicationInstanceContainerId);
	}

	/**
	* Returns the application instance container with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param applicationInstanceContainerId the primary key of the application instance container
	* @return the application instance container, or <code>null</code> if a application instance container with the primary key could not be found
	*/
	public static ApplicationInstanceContainer fetchByPrimaryKey(
		long applicationInstanceContainerId) {
		return getPersistence().fetchByPrimaryKey(applicationInstanceContainerId);
	}

	public static java.util.Map<java.io.Serializable, ApplicationInstanceContainer> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the application instance containers.
	*
	* @return the application instance containers
	*/
	public static List<ApplicationInstanceContainer> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the application instance containers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application instance containers
	* @param end the upper bound of the range of application instance containers (not inclusive)
	* @return the range of application instance containers
	*/
	public static List<ApplicationInstanceContainer> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the application instance containers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application instance containers
	* @param end the upper bound of the range of application instance containers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of application instance containers
	*/
	public static List<ApplicationInstanceContainer> findAll(int start,
		int end,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the application instance containers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application instance containers
	* @param end the upper bound of the range of application instance containers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of application instance containers
	*/
	public static List<ApplicationInstanceContainer> findAll(int start,
		int end,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the application instance containers from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of application instance containers.
	*
	* @return the number of application instance containers
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ApplicationInstanceContainerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ApplicationInstanceContainerPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.bibbox.liferay.portlet.service.ClpSerializer.getServletContextName(),
					ApplicationInstanceContainerPersistence.class.getName());

			ReferenceRegistry.registerReference(ApplicationInstanceContainerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static ApplicationInstanceContainerPersistence _persistence;
}