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

import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the application instance status service. This utility wraps {@link at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.ApplicationInstanceStatusPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationInstanceStatusPersistence
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.ApplicationInstanceStatusPersistenceImpl
 * @generated
 */
@ProviderType
public class ApplicationInstanceStatusUtil {
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
		ApplicationInstanceStatus applicationInstanceStatus) {
		getPersistence().clearCache(applicationInstanceStatus);
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
	public static List<ApplicationInstanceStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ApplicationInstanceStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ApplicationInstanceStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ApplicationInstanceStatus> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ApplicationInstanceStatus update(
		ApplicationInstanceStatus applicationInstanceStatus) {
		return getPersistence().update(applicationInstanceStatus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ApplicationInstanceStatus update(
		ApplicationInstanceStatus applicationInstanceStatus,
		ServiceContext serviceContext) {
		return getPersistence().update(applicationInstanceStatus, serviceContext);
	}

	/**
	* Returns the application instance status where applicationInstanceId = &#63; or throws a {@link NoSuchApplicationInstanceStatusException} if it could not be found.
	*
	* @param applicationInstanceId the application instance ID
	* @return the matching application instance status
	* @throws NoSuchApplicationInstanceStatusException if a matching application instance status could not be found
	*/
	public static ApplicationInstanceStatus findByApplicationInstance(
		long applicationInstanceId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceStatusException {
		return getPersistence().findByApplicationInstance(applicationInstanceId);
	}

	/**
	* Returns the application instance status where applicationInstanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param applicationInstanceId the application instance ID
	* @return the matching application instance status, or <code>null</code> if a matching application instance status could not be found
	*/
	public static ApplicationInstanceStatus fetchByApplicationInstance(
		long applicationInstanceId) {
		return getPersistence().fetchByApplicationInstance(applicationInstanceId);
	}

	/**
	* Returns the application instance status where applicationInstanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param applicationInstanceId the application instance ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching application instance status, or <code>null</code> if a matching application instance status could not be found
	*/
	public static ApplicationInstanceStatus fetchByApplicationInstance(
		long applicationInstanceId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByApplicationInstance(applicationInstanceId,
			retrieveFromCache);
	}

	/**
	* Removes the application instance status where applicationInstanceId = &#63; from the database.
	*
	* @param applicationInstanceId the application instance ID
	* @return the application instance status that was removed
	*/
	public static ApplicationInstanceStatus removeByApplicationInstance(
		long applicationInstanceId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceStatusException {
		return getPersistence()
				   .removeByApplicationInstance(applicationInstanceId);
	}

	/**
	* Returns the number of application instance statuses where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @return the number of matching application instance statuses
	*/
	public static int countByApplicationInstance(long applicationInstanceId) {
		return getPersistence().countByApplicationInstance(applicationInstanceId);
	}

	/**
	* Caches the application instance status in the entity cache if it is enabled.
	*
	* @param applicationInstanceStatus the application instance status
	*/
	public static void cacheResult(
		ApplicationInstanceStatus applicationInstanceStatus) {
		getPersistence().cacheResult(applicationInstanceStatus);
	}

	/**
	* Caches the application instance statuses in the entity cache if it is enabled.
	*
	* @param applicationInstanceStatuses the application instance statuses
	*/
	public static void cacheResult(
		List<ApplicationInstanceStatus> applicationInstanceStatuses) {
		getPersistence().cacheResult(applicationInstanceStatuses);
	}

	/**
	* Creates a new application instance status with the primary key. Does not add the application instance status to the database.
	*
	* @param applicationInstanceStatusId the primary key for the new application instance status
	* @return the new application instance status
	*/
	public static ApplicationInstanceStatus create(
		long applicationInstanceStatusId) {
		return getPersistence().create(applicationInstanceStatusId);
	}

	/**
	* Removes the application instance status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstanceStatusId the primary key of the application instance status
	* @return the application instance status that was removed
	* @throws NoSuchApplicationInstanceStatusException if a application instance status with the primary key could not be found
	*/
	public static ApplicationInstanceStatus remove(
		long applicationInstanceStatusId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceStatusException {
		return getPersistence().remove(applicationInstanceStatusId);
	}

	public static ApplicationInstanceStatus updateImpl(
		ApplicationInstanceStatus applicationInstanceStatus) {
		return getPersistence().updateImpl(applicationInstanceStatus);
	}

	/**
	* Returns the application instance status with the primary key or throws a {@link NoSuchApplicationInstanceStatusException} if it could not be found.
	*
	* @param applicationInstanceStatusId the primary key of the application instance status
	* @return the application instance status
	* @throws NoSuchApplicationInstanceStatusException if a application instance status with the primary key could not be found
	*/
	public static ApplicationInstanceStatus findByPrimaryKey(
		long applicationInstanceStatusId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceStatusException {
		return getPersistence().findByPrimaryKey(applicationInstanceStatusId);
	}

	/**
	* Returns the application instance status with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param applicationInstanceStatusId the primary key of the application instance status
	* @return the application instance status, or <code>null</code> if a application instance status with the primary key could not be found
	*/
	public static ApplicationInstanceStatus fetchByPrimaryKey(
		long applicationInstanceStatusId) {
		return getPersistence().fetchByPrimaryKey(applicationInstanceStatusId);
	}

	public static java.util.Map<java.io.Serializable, ApplicationInstanceStatus> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the application instance statuses.
	*
	* @return the application instance statuses
	*/
	public static List<ApplicationInstanceStatus> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the application instance statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application instance statuses
	* @param end the upper bound of the range of application instance statuses (not inclusive)
	* @return the range of application instance statuses
	*/
	public static List<ApplicationInstanceStatus> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the application instance statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application instance statuses
	* @param end the upper bound of the range of application instance statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of application instance statuses
	*/
	public static List<ApplicationInstanceStatus> findAll(int start, int end,
		OrderByComparator<ApplicationInstanceStatus> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the application instance statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application instance statuses
	* @param end the upper bound of the range of application instance statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of application instance statuses
	*/
	public static List<ApplicationInstanceStatus> findAll(int start, int end,
		OrderByComparator<ApplicationInstanceStatus> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the application instance statuses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of application instance statuses.
	*
	* @return the number of application instance statuses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ApplicationInstanceStatusPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ApplicationInstanceStatusPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.bibbox.liferay.portlet.service.ClpSerializer.getServletContextName(),
					ApplicationInstanceStatusPersistence.class.getName());

			ReferenceRegistry.registerReference(ApplicationInstanceStatusUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static ApplicationInstanceStatusPersistence _persistence;
}