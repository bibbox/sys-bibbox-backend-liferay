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

import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the application instance port service. This utility wraps {@link at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.ApplicationInstancePortPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationInstancePortPersistence
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.ApplicationInstancePortPersistenceImpl
 * @generated
 */
@ProviderType
public class ApplicationInstancePortUtil {
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
		ApplicationInstancePort applicationInstancePort) {
		getPersistence().clearCache(applicationInstancePort);
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
	public static List<ApplicationInstancePort> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ApplicationInstancePort> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ApplicationInstancePort> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ApplicationInstancePort> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ApplicationInstancePort update(
		ApplicationInstancePort applicationInstancePort) {
		return getPersistence().update(applicationInstancePort);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ApplicationInstancePort update(
		ApplicationInstancePort applicationInstancePort,
		ServiceContext serviceContext) {
		return getPersistence().update(applicationInstancePort, serviceContext);
	}

	/**
	* Returns all the application instance ports where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @return the matching application instance ports
	*/
	public static List<ApplicationInstancePort> findByApplicationInstance(
		long applicationInstanceId) {
		return getPersistence().findByApplicationInstance(applicationInstanceId);
	}

	/**
	* Returns a range of all the application instance ports where applicationInstanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstancePortModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationInstanceId the application instance ID
	* @param start the lower bound of the range of application instance ports
	* @param end the upper bound of the range of application instance ports (not inclusive)
	* @return the range of matching application instance ports
	*/
	public static List<ApplicationInstancePort> findByApplicationInstance(
		long applicationInstanceId, int start, int end) {
		return getPersistence()
				   .findByApplicationInstance(applicationInstanceId, start, end);
	}

	/**
	* Returns an ordered range of all the application instance ports where applicationInstanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstancePortModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationInstanceId the application instance ID
	* @param start the lower bound of the range of application instance ports
	* @param end the upper bound of the range of application instance ports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching application instance ports
	*/
	public static List<ApplicationInstancePort> findByApplicationInstance(
		long applicationInstanceId, int start, int end,
		OrderByComparator<ApplicationInstancePort> orderByComparator) {
		return getPersistence()
				   .findByApplicationInstance(applicationInstanceId, start,
			end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the application instance ports where applicationInstanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstancePortModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationInstanceId the application instance ID
	* @param start the lower bound of the range of application instance ports
	* @param end the upper bound of the range of application instance ports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching application instance ports
	*/
	public static List<ApplicationInstancePort> findByApplicationInstance(
		long applicationInstanceId, int start, int end,
		OrderByComparator<ApplicationInstancePort> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByApplicationInstance(applicationInstanceId, start,
			end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first application instance port in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance port
	* @throws NoSuchApplicationInstancePortException if a matching application instance port could not be found
	*/
	public static ApplicationInstancePort findByApplicationInstance_First(
		long applicationInstanceId,
		OrderByComparator<ApplicationInstancePort> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstancePortException {
		return getPersistence()
				   .findByApplicationInstance_First(applicationInstanceId,
			orderByComparator);
	}

	/**
	* Returns the first application instance port in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance port, or <code>null</code> if a matching application instance port could not be found
	*/
	public static ApplicationInstancePort fetchByApplicationInstance_First(
		long applicationInstanceId,
		OrderByComparator<ApplicationInstancePort> orderByComparator) {
		return getPersistence()
				   .fetchByApplicationInstance_First(applicationInstanceId,
			orderByComparator);
	}

	/**
	* Returns the last application instance port in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance port
	* @throws NoSuchApplicationInstancePortException if a matching application instance port could not be found
	*/
	public static ApplicationInstancePort findByApplicationInstance_Last(
		long applicationInstanceId,
		OrderByComparator<ApplicationInstancePort> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstancePortException {
		return getPersistence()
				   .findByApplicationInstance_Last(applicationInstanceId,
			orderByComparator);
	}

	/**
	* Returns the last application instance port in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance port, or <code>null</code> if a matching application instance port could not be found
	*/
	public static ApplicationInstancePort fetchByApplicationInstance_Last(
		long applicationInstanceId,
		OrderByComparator<ApplicationInstancePort> orderByComparator) {
		return getPersistence()
				   .fetchByApplicationInstance_Last(applicationInstanceId,
			orderByComparator);
	}

	/**
	* Returns the application instance ports before and after the current application instance port in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstancePortId the primary key of the current application instance port
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next application instance port
	* @throws NoSuchApplicationInstancePortException if a application instance port with the primary key could not be found
	*/
	public static ApplicationInstancePort[] findByApplicationInstance_PrevAndNext(
		long applicationInstancePortId, long applicationInstanceId,
		OrderByComparator<ApplicationInstancePort> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstancePortException {
		return getPersistence()
				   .findByApplicationInstance_PrevAndNext(applicationInstancePortId,
			applicationInstanceId, orderByComparator);
	}

	/**
	* Removes all the application instance ports where applicationInstanceId = &#63; from the database.
	*
	* @param applicationInstanceId the application instance ID
	*/
	public static void removeByApplicationInstance(long applicationInstanceId) {
		getPersistence().removeByApplicationInstance(applicationInstanceId);
	}

	/**
	* Returns the number of application instance ports where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @return the number of matching application instance ports
	*/
	public static int countByApplicationInstance(long applicationInstanceId) {
		return getPersistence().countByApplicationInstance(applicationInstanceId);
	}

	/**
	* Returns all the application instance ports where applicationInstanceId = &#63; and primary = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param primary the primary
	* @return the matching application instance ports
	*/
	public static List<ApplicationInstancePort> findByPrimaryApplicationInstancePort(
		long applicationInstanceId, boolean primary) {
		return getPersistence()
				   .findByPrimaryApplicationInstancePort(applicationInstanceId,
			primary);
	}

	/**
	* Returns a range of all the application instance ports where applicationInstanceId = &#63; and primary = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstancePortModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationInstanceId the application instance ID
	* @param primary the primary
	* @param start the lower bound of the range of application instance ports
	* @param end the upper bound of the range of application instance ports (not inclusive)
	* @return the range of matching application instance ports
	*/
	public static List<ApplicationInstancePort> findByPrimaryApplicationInstancePort(
		long applicationInstanceId, boolean primary, int start, int end) {
		return getPersistence()
				   .findByPrimaryApplicationInstancePort(applicationInstanceId,
			primary, start, end);
	}

	/**
	* Returns an ordered range of all the application instance ports where applicationInstanceId = &#63; and primary = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstancePortModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationInstanceId the application instance ID
	* @param primary the primary
	* @param start the lower bound of the range of application instance ports
	* @param end the upper bound of the range of application instance ports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching application instance ports
	*/
	public static List<ApplicationInstancePort> findByPrimaryApplicationInstancePort(
		long applicationInstanceId, boolean primary, int start, int end,
		OrderByComparator<ApplicationInstancePort> orderByComparator) {
		return getPersistence()
				   .findByPrimaryApplicationInstancePort(applicationInstanceId,
			primary, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the application instance ports where applicationInstanceId = &#63; and primary = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstancePortModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param applicationInstanceId the application instance ID
	* @param primary the primary
	* @param start the lower bound of the range of application instance ports
	* @param end the upper bound of the range of application instance ports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching application instance ports
	*/
	public static List<ApplicationInstancePort> findByPrimaryApplicationInstancePort(
		long applicationInstanceId, boolean primary, int start, int end,
		OrderByComparator<ApplicationInstancePort> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByPrimaryApplicationInstancePort(applicationInstanceId,
			primary, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first application instance port in the ordered set where applicationInstanceId = &#63; and primary = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param primary the primary
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance port
	* @throws NoSuchApplicationInstancePortException if a matching application instance port could not be found
	*/
	public static ApplicationInstancePort findByPrimaryApplicationInstancePort_First(
		long applicationInstanceId, boolean primary,
		OrderByComparator<ApplicationInstancePort> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstancePortException {
		return getPersistence()
				   .findByPrimaryApplicationInstancePort_First(applicationInstanceId,
			primary, orderByComparator);
	}

	/**
	* Returns the first application instance port in the ordered set where applicationInstanceId = &#63; and primary = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param primary the primary
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance port, or <code>null</code> if a matching application instance port could not be found
	*/
	public static ApplicationInstancePort fetchByPrimaryApplicationInstancePort_First(
		long applicationInstanceId, boolean primary,
		OrderByComparator<ApplicationInstancePort> orderByComparator) {
		return getPersistence()
				   .fetchByPrimaryApplicationInstancePort_First(applicationInstanceId,
			primary, orderByComparator);
	}

	/**
	* Returns the last application instance port in the ordered set where applicationInstanceId = &#63; and primary = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param primary the primary
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance port
	* @throws NoSuchApplicationInstancePortException if a matching application instance port could not be found
	*/
	public static ApplicationInstancePort findByPrimaryApplicationInstancePort_Last(
		long applicationInstanceId, boolean primary,
		OrderByComparator<ApplicationInstancePort> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstancePortException {
		return getPersistence()
				   .findByPrimaryApplicationInstancePort_Last(applicationInstanceId,
			primary, orderByComparator);
	}

	/**
	* Returns the last application instance port in the ordered set where applicationInstanceId = &#63; and primary = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param primary the primary
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance port, or <code>null</code> if a matching application instance port could not be found
	*/
	public static ApplicationInstancePort fetchByPrimaryApplicationInstancePort_Last(
		long applicationInstanceId, boolean primary,
		OrderByComparator<ApplicationInstancePort> orderByComparator) {
		return getPersistence()
				   .fetchByPrimaryApplicationInstancePort_Last(applicationInstanceId,
			primary, orderByComparator);
	}

	/**
	* Returns the application instance ports before and after the current application instance port in the ordered set where applicationInstanceId = &#63; and primary = &#63;.
	*
	* @param applicationInstancePortId the primary key of the current application instance port
	* @param applicationInstanceId the application instance ID
	* @param primary the primary
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next application instance port
	* @throws NoSuchApplicationInstancePortException if a application instance port with the primary key could not be found
	*/
	public static ApplicationInstancePort[] findByPrimaryApplicationInstancePort_PrevAndNext(
		long applicationInstancePortId, long applicationInstanceId,
		boolean primary,
		OrderByComparator<ApplicationInstancePort> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstancePortException {
		return getPersistence()
				   .findByPrimaryApplicationInstancePort_PrevAndNext(applicationInstancePortId,
			applicationInstanceId, primary, orderByComparator);
	}

	/**
	* Removes all the application instance ports where applicationInstanceId = &#63; and primary = &#63; from the database.
	*
	* @param applicationInstanceId the application instance ID
	* @param primary the primary
	*/
	public static void removeByPrimaryApplicationInstancePort(
		long applicationInstanceId, boolean primary) {
		getPersistence()
			.removeByPrimaryApplicationInstancePort(applicationInstanceId,
			primary);
	}

	/**
	* Returns the number of application instance ports where applicationInstanceId = &#63; and primary = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param primary the primary
	* @return the number of matching application instance ports
	*/
	public static int countByPrimaryApplicationInstancePort(
		long applicationInstanceId, boolean primary) {
		return getPersistence()
				   .countByPrimaryApplicationInstancePort(applicationInstanceId,
			primary);
	}

	/**
	* Caches the application instance port in the entity cache if it is enabled.
	*
	* @param applicationInstancePort the application instance port
	*/
	public static void cacheResult(
		ApplicationInstancePort applicationInstancePort) {
		getPersistence().cacheResult(applicationInstancePort);
	}

	/**
	* Caches the application instance ports in the entity cache if it is enabled.
	*
	* @param applicationInstancePorts the application instance ports
	*/
	public static void cacheResult(
		List<ApplicationInstancePort> applicationInstancePorts) {
		getPersistence().cacheResult(applicationInstancePorts);
	}

	/**
	* Creates a new application instance port with the primary key. Does not add the application instance port to the database.
	*
	* @param applicationInstancePortId the primary key for the new application instance port
	* @return the new application instance port
	*/
	public static ApplicationInstancePort create(long applicationInstancePortId) {
		return getPersistence().create(applicationInstancePortId);
	}

	/**
	* Removes the application instance port with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstancePortId the primary key of the application instance port
	* @return the application instance port that was removed
	* @throws NoSuchApplicationInstancePortException if a application instance port with the primary key could not be found
	*/
	public static ApplicationInstancePort remove(long applicationInstancePortId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstancePortException {
		return getPersistence().remove(applicationInstancePortId);
	}

	public static ApplicationInstancePort updateImpl(
		ApplicationInstancePort applicationInstancePort) {
		return getPersistence().updateImpl(applicationInstancePort);
	}

	/**
	* Returns the application instance port with the primary key or throws a {@link NoSuchApplicationInstancePortException} if it could not be found.
	*
	* @param applicationInstancePortId the primary key of the application instance port
	* @return the application instance port
	* @throws NoSuchApplicationInstancePortException if a application instance port with the primary key could not be found
	*/
	public static ApplicationInstancePort findByPrimaryKey(
		long applicationInstancePortId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstancePortException {
		return getPersistence().findByPrimaryKey(applicationInstancePortId);
	}

	/**
	* Returns the application instance port with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param applicationInstancePortId the primary key of the application instance port
	* @return the application instance port, or <code>null</code> if a application instance port with the primary key could not be found
	*/
	public static ApplicationInstancePort fetchByPrimaryKey(
		long applicationInstancePortId) {
		return getPersistence().fetchByPrimaryKey(applicationInstancePortId);
	}

	public static java.util.Map<java.io.Serializable, ApplicationInstancePort> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the application instance ports.
	*
	* @return the application instance ports
	*/
	public static List<ApplicationInstancePort> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the application instance ports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstancePortModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application instance ports
	* @param end the upper bound of the range of application instance ports (not inclusive)
	* @return the range of application instance ports
	*/
	public static List<ApplicationInstancePort> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the application instance ports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstancePortModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application instance ports
	* @param end the upper bound of the range of application instance ports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of application instance ports
	*/
	public static List<ApplicationInstancePort> findAll(int start, int end,
		OrderByComparator<ApplicationInstancePort> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the application instance ports.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstancePortModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of application instance ports
	* @param end the upper bound of the range of application instance ports (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of application instance ports
	*/
	public static List<ApplicationInstancePort> findAll(int start, int end,
		OrderByComparator<ApplicationInstancePort> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the application instance ports from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of application instance ports.
	*
	* @return the number of application instance ports
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ApplicationInstancePortPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ApplicationInstancePortPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.bibbox.liferay.portlet.service.ClpSerializer.getServletContextName(),
					ApplicationInstancePortPersistence.class.getName());

			ReferenceRegistry.registerReference(ApplicationInstancePortUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static ApplicationInstancePortPersistence _persistence;
}