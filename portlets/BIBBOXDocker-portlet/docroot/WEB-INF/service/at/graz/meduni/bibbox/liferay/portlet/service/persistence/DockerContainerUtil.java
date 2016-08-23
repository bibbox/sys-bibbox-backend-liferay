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

import at.graz.meduni.bibbox.liferay.portlet.model.DockerContainer;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;

import java.util.List;

/**
 * The persistence utility for the docker container service. This utility wraps {@link at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.DockerContainerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see DockerContainerPersistence
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.DockerContainerPersistenceImpl
 * @generated
 */
@ProviderType
public class DockerContainerUtil {
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
	public static void clearCache(DockerContainer dockerContainer) {
		getPersistence().clearCache(dockerContainer);
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
	public static List<DockerContainer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DockerContainer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DockerContainer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DockerContainer> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DockerContainer update(DockerContainer dockerContainer) {
		return getPersistence().update(dockerContainer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DockerContainer update(DockerContainer dockerContainer,
		ServiceContext serviceContext) {
		return getPersistence().update(dockerContainer, serviceContext);
	}

	/**
	* Returns the docker container where toolName = &#63; and instance = &#63; or throws a {@link NoSuchDockerContainerException} if it could not be found.
	*
	* @param toolName the tool name
	* @param instance the instance
	* @return the matching docker container
	* @throws NoSuchDockerContainerException if a matching docker container could not be found
	*/
	public static DockerContainer findByDockerContainer(
		java.lang.String toolName, java.lang.String instance)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchDockerContainerException {
		return getPersistence().findByDockerContainer(toolName, instance);
	}

	/**
	* Returns the docker container where toolName = &#63; and instance = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param toolName the tool name
	* @param instance the instance
	* @return the matching docker container, or <code>null</code> if a matching docker container could not be found
	*/
	public static DockerContainer fetchByDockerContainer(
		java.lang.String toolName, java.lang.String instance) {
		return getPersistence().fetchByDockerContainer(toolName, instance);
	}

	/**
	* Returns the docker container where toolName = &#63; and instance = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param toolName the tool name
	* @param instance the instance
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching docker container, or <code>null</code> if a matching docker container could not be found
	*/
	public static DockerContainer fetchByDockerContainer(
		java.lang.String toolName, java.lang.String instance,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByDockerContainer(toolName, instance, retrieveFromCache);
	}

	/**
	* Removes the docker container where toolName = &#63; and instance = &#63; from the database.
	*
	* @param toolName the tool name
	* @param instance the instance
	* @return the docker container that was removed
	*/
	public static DockerContainer removeByDockerContainer(
		java.lang.String toolName, java.lang.String instance)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchDockerContainerException {
		return getPersistence().removeByDockerContainer(toolName, instance);
	}

	/**
	* Returns the number of docker containers where toolName = &#63; and instance = &#63;.
	*
	* @param toolName the tool name
	* @param instance the instance
	* @return the number of matching docker containers
	*/
	public static int countByDockerContainer(java.lang.String toolName,
		java.lang.String instance) {
		return getPersistence().countByDockerContainer(toolName, instance);
	}

	/**
	* Returns all the docker containers where toolName = &#63;.
	*
	* @param toolName the tool name
	* @return the matching docker containers
	*/
	public static List<DockerContainer> findByDockerContainerInstances(
		java.lang.String toolName) {
		return getPersistence().findByDockerContainerInstances(toolName);
	}

	/**
	* Returns a range of all the docker containers where toolName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DockerContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param toolName the tool name
	* @param start the lower bound of the range of docker containers
	* @param end the upper bound of the range of docker containers (not inclusive)
	* @return the range of matching docker containers
	*/
	public static List<DockerContainer> findByDockerContainerInstances(
		java.lang.String toolName, int start, int end) {
		return getPersistence()
				   .findByDockerContainerInstances(toolName, start, end);
	}

	/**
	* Returns an ordered range of all the docker containers where toolName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DockerContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param toolName the tool name
	* @param start the lower bound of the range of docker containers
	* @param end the upper bound of the range of docker containers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching docker containers
	*/
	public static List<DockerContainer> findByDockerContainerInstances(
		java.lang.String toolName, int start, int end,
		OrderByComparator<DockerContainer> orderByComparator) {
		return getPersistence()
				   .findByDockerContainerInstances(toolName, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the docker containers where toolName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DockerContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param toolName the tool name
	* @param start the lower bound of the range of docker containers
	* @param end the upper bound of the range of docker containers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching docker containers
	*/
	public static List<DockerContainer> findByDockerContainerInstances(
		java.lang.String toolName, int start, int end,
		OrderByComparator<DockerContainer> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByDockerContainerInstances(toolName, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first docker container in the ordered set where toolName = &#63;.
	*
	* @param toolName the tool name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docker container
	* @throws NoSuchDockerContainerException if a matching docker container could not be found
	*/
	public static DockerContainer findByDockerContainerInstances_First(
		java.lang.String toolName,
		OrderByComparator<DockerContainer> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchDockerContainerException {
		return getPersistence()
				   .findByDockerContainerInstances_First(toolName,
			orderByComparator);
	}

	/**
	* Returns the first docker container in the ordered set where toolName = &#63;.
	*
	* @param toolName the tool name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docker container, or <code>null</code> if a matching docker container could not be found
	*/
	public static DockerContainer fetchByDockerContainerInstances_First(
		java.lang.String toolName,
		OrderByComparator<DockerContainer> orderByComparator) {
		return getPersistence()
				   .fetchByDockerContainerInstances_First(toolName,
			orderByComparator);
	}

	/**
	* Returns the last docker container in the ordered set where toolName = &#63;.
	*
	* @param toolName the tool name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docker container
	* @throws NoSuchDockerContainerException if a matching docker container could not be found
	*/
	public static DockerContainer findByDockerContainerInstances_Last(
		java.lang.String toolName,
		OrderByComparator<DockerContainer> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchDockerContainerException {
		return getPersistence()
				   .findByDockerContainerInstances_Last(toolName,
			orderByComparator);
	}

	/**
	* Returns the last docker container in the ordered set where toolName = &#63;.
	*
	* @param toolName the tool name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docker container, or <code>null</code> if a matching docker container could not be found
	*/
	public static DockerContainer fetchByDockerContainerInstances_Last(
		java.lang.String toolName,
		OrderByComparator<DockerContainer> orderByComparator) {
		return getPersistence()
				   .fetchByDockerContainerInstances_Last(toolName,
			orderByComparator);
	}

	/**
	* Returns the docker containers before and after the current docker container in the ordered set where toolName = &#63;.
	*
	* @param dockerContainerId the primary key of the current docker container
	* @param toolName the tool name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next docker container
	* @throws NoSuchDockerContainerException if a docker container with the primary key could not be found
	*/
	public static DockerContainer[] findByDockerContainerInstances_PrevAndNext(
		long dockerContainerId, java.lang.String toolName,
		OrderByComparator<DockerContainer> orderByComparator)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchDockerContainerException {
		return getPersistence()
				   .findByDockerContainerInstances_PrevAndNext(dockerContainerId,
			toolName, orderByComparator);
	}

	/**
	* Removes all the docker containers where toolName = &#63; from the database.
	*
	* @param toolName the tool name
	*/
	public static void removeByDockerContainerInstances(
		java.lang.String toolName) {
		getPersistence().removeByDockerContainerInstances(toolName);
	}

	/**
	* Returns the number of docker containers where toolName = &#63;.
	*
	* @param toolName the tool name
	* @return the number of matching docker containers
	*/
	public static int countByDockerContainerInstances(java.lang.String toolName) {
		return getPersistence().countByDockerContainerInstances(toolName);
	}

	/**
	* Caches the docker container in the entity cache if it is enabled.
	*
	* @param dockerContainer the docker container
	*/
	public static void cacheResult(DockerContainer dockerContainer) {
		getPersistence().cacheResult(dockerContainer);
	}

	/**
	* Caches the docker containers in the entity cache if it is enabled.
	*
	* @param dockerContainers the docker containers
	*/
	public static void cacheResult(List<DockerContainer> dockerContainers) {
		getPersistence().cacheResult(dockerContainers);
	}

	/**
	* Creates a new docker container with the primary key. Does not add the docker container to the database.
	*
	* @param dockerContainerId the primary key for the new docker container
	* @return the new docker container
	*/
	public static DockerContainer create(long dockerContainerId) {
		return getPersistence().create(dockerContainerId);
	}

	/**
	* Removes the docker container with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dockerContainerId the primary key of the docker container
	* @return the docker container that was removed
	* @throws NoSuchDockerContainerException if a docker container with the primary key could not be found
	*/
	public static DockerContainer remove(long dockerContainerId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchDockerContainerException {
		return getPersistence().remove(dockerContainerId);
	}

	public static DockerContainer updateImpl(DockerContainer dockerContainer) {
		return getPersistence().updateImpl(dockerContainer);
	}

	/**
	* Returns the docker container with the primary key or throws a {@link NoSuchDockerContainerException} if it could not be found.
	*
	* @param dockerContainerId the primary key of the docker container
	* @return the docker container
	* @throws NoSuchDockerContainerException if a docker container with the primary key could not be found
	*/
	public static DockerContainer findByPrimaryKey(long dockerContainerId)
		throws at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchDockerContainerException {
		return getPersistence().findByPrimaryKey(dockerContainerId);
	}

	/**
	* Returns the docker container with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dockerContainerId the primary key of the docker container
	* @return the docker container, or <code>null</code> if a docker container with the primary key could not be found
	*/
	public static DockerContainer fetchByPrimaryKey(long dockerContainerId) {
		return getPersistence().fetchByPrimaryKey(dockerContainerId);
	}

	public static java.util.Map<java.io.Serializable, DockerContainer> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the docker containers.
	*
	* @return the docker containers
	*/
	public static List<DockerContainer> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the docker containers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DockerContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of docker containers
	* @param end the upper bound of the range of docker containers (not inclusive)
	* @return the range of docker containers
	*/
	public static List<DockerContainer> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the docker containers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DockerContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of docker containers
	* @param end the upper bound of the range of docker containers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of docker containers
	*/
	public static List<DockerContainer> findAll(int start, int end,
		OrderByComparator<DockerContainer> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the docker containers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DockerContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of docker containers
	* @param end the upper bound of the range of docker containers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of docker containers
	*/
	public static List<DockerContainer> findAll(int start, int end,
		OrderByComparator<DockerContainer> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the docker containers from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of docker containers.
	*
	* @return the number of docker containers
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DockerContainerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DockerContainerPersistence)PortletBeanLocatorUtil.locate(at.graz.meduni.bibbox.liferay.portlet.service.ClpSerializer.getServletContextName(),
					DockerContainerPersistence.class.getName());

			ReferenceRegistry.registerReference(DockerContainerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	private static DockerContainerPersistence _persistence;
}