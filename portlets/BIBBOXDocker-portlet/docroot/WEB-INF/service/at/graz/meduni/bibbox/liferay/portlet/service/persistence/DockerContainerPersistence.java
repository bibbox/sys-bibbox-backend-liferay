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

import at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchDockerContainerException;
import at.graz.meduni.bibbox.liferay.portlet.model.DockerContainer;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the docker container service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.DockerContainerPersistenceImpl
 * @see DockerContainerUtil
 * @generated
 */
@ProviderType
public interface DockerContainerPersistence extends BasePersistence<DockerContainer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DockerContainerUtil} to access the docker container persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the docker container where toolName = &#63; and instance = &#63; or throws a {@link NoSuchDockerContainerException} if it could not be found.
	*
	* @param toolName the tool name
	* @param instance the instance
	* @return the matching docker container
	* @throws NoSuchDockerContainerException if a matching docker container could not be found
	*/
	public DockerContainer findByDockerContainer(java.lang.String toolName,
		java.lang.String instance) throws NoSuchDockerContainerException;

	/**
	* Returns the docker container where toolName = &#63; and instance = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param toolName the tool name
	* @param instance the instance
	* @return the matching docker container, or <code>null</code> if a matching docker container could not be found
	*/
	public DockerContainer fetchByDockerContainer(java.lang.String toolName,
		java.lang.String instance);

	/**
	* Returns the docker container where toolName = &#63; and instance = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param toolName the tool name
	* @param instance the instance
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching docker container, or <code>null</code> if a matching docker container could not be found
	*/
	public DockerContainer fetchByDockerContainer(java.lang.String toolName,
		java.lang.String instance, boolean retrieveFromCache);

	/**
	* Removes the docker container where toolName = &#63; and instance = &#63; from the database.
	*
	* @param toolName the tool name
	* @param instance the instance
	* @return the docker container that was removed
	*/
	public DockerContainer removeByDockerContainer(java.lang.String toolName,
		java.lang.String instance) throws NoSuchDockerContainerException;

	/**
	* Returns the number of docker containers where toolName = &#63; and instance = &#63;.
	*
	* @param toolName the tool name
	* @param instance the instance
	* @return the number of matching docker containers
	*/
	public int countByDockerContainer(java.lang.String toolName,
		java.lang.String instance);

	/**
	* Returns all the docker containers where toolName = &#63;.
	*
	* @param toolName the tool name
	* @return the matching docker containers
	*/
	public java.util.List<DockerContainer> findByDockerContainerInstances(
		java.lang.String toolName);

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
	public java.util.List<DockerContainer> findByDockerContainerInstances(
		java.lang.String toolName, int start, int end);

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
	public java.util.List<DockerContainer> findByDockerContainerInstances(
		java.lang.String toolName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DockerContainer> orderByComparator);

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
	public java.util.List<DockerContainer> findByDockerContainerInstances(
		java.lang.String toolName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DockerContainer> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first docker container in the ordered set where toolName = &#63;.
	*
	* @param toolName the tool name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docker container
	* @throws NoSuchDockerContainerException if a matching docker container could not be found
	*/
	public DockerContainer findByDockerContainerInstances_First(
		java.lang.String toolName,
		com.liferay.portal.kernel.util.OrderByComparator<DockerContainer> orderByComparator)
		throws NoSuchDockerContainerException;

	/**
	* Returns the first docker container in the ordered set where toolName = &#63;.
	*
	* @param toolName the tool name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docker container, or <code>null</code> if a matching docker container could not be found
	*/
	public DockerContainer fetchByDockerContainerInstances_First(
		java.lang.String toolName,
		com.liferay.portal.kernel.util.OrderByComparator<DockerContainer> orderByComparator);

	/**
	* Returns the last docker container in the ordered set where toolName = &#63;.
	*
	* @param toolName the tool name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docker container
	* @throws NoSuchDockerContainerException if a matching docker container could not be found
	*/
	public DockerContainer findByDockerContainerInstances_Last(
		java.lang.String toolName,
		com.liferay.portal.kernel.util.OrderByComparator<DockerContainer> orderByComparator)
		throws NoSuchDockerContainerException;

	/**
	* Returns the last docker container in the ordered set where toolName = &#63;.
	*
	* @param toolName the tool name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docker container, or <code>null</code> if a matching docker container could not be found
	*/
	public DockerContainer fetchByDockerContainerInstances_Last(
		java.lang.String toolName,
		com.liferay.portal.kernel.util.OrderByComparator<DockerContainer> orderByComparator);

	/**
	* Returns the docker containers before and after the current docker container in the ordered set where toolName = &#63;.
	*
	* @param dockerContainerId the primary key of the current docker container
	* @param toolName the tool name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next docker container
	* @throws NoSuchDockerContainerException if a docker container with the primary key could not be found
	*/
	public DockerContainer[] findByDockerContainerInstances_PrevAndNext(
		long dockerContainerId, java.lang.String toolName,
		com.liferay.portal.kernel.util.OrderByComparator<DockerContainer> orderByComparator)
		throws NoSuchDockerContainerException;

	/**
	* Removes all the docker containers where toolName = &#63; from the database.
	*
	* @param toolName the tool name
	*/
	public void removeByDockerContainerInstances(java.lang.String toolName);

	/**
	* Returns the number of docker containers where toolName = &#63;.
	*
	* @param toolName the tool name
	* @return the number of matching docker containers
	*/
	public int countByDockerContainerInstances(java.lang.String toolName);

	/**
	* Caches the docker container in the entity cache if it is enabled.
	*
	* @param dockerContainer the docker container
	*/
	public void cacheResult(DockerContainer dockerContainer);

	/**
	* Caches the docker containers in the entity cache if it is enabled.
	*
	* @param dockerContainers the docker containers
	*/
	public void cacheResult(java.util.List<DockerContainer> dockerContainers);

	/**
	* Creates a new docker container with the primary key. Does not add the docker container to the database.
	*
	* @param dockerContainerId the primary key for the new docker container
	* @return the new docker container
	*/
	public DockerContainer create(long dockerContainerId);

	/**
	* Removes the docker container with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dockerContainerId the primary key of the docker container
	* @return the docker container that was removed
	* @throws NoSuchDockerContainerException if a docker container with the primary key could not be found
	*/
	public DockerContainer remove(long dockerContainerId)
		throws NoSuchDockerContainerException;

	public DockerContainer updateImpl(DockerContainer dockerContainer);

	/**
	* Returns the docker container with the primary key or throws a {@link NoSuchDockerContainerException} if it could not be found.
	*
	* @param dockerContainerId the primary key of the docker container
	* @return the docker container
	* @throws NoSuchDockerContainerException if a docker container with the primary key could not be found
	*/
	public DockerContainer findByPrimaryKey(long dockerContainerId)
		throws NoSuchDockerContainerException;

	/**
	* Returns the docker container with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dockerContainerId the primary key of the docker container
	* @return the docker container, or <code>null</code> if a docker container with the primary key could not be found
	*/
	public DockerContainer fetchByPrimaryKey(long dockerContainerId);

	@Override
	public java.util.Map<java.io.Serializable, DockerContainer> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the docker containers.
	*
	* @return the docker containers
	*/
	public java.util.List<DockerContainer> findAll();

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
	public java.util.List<DockerContainer> findAll(int start, int end);

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
	public java.util.List<DockerContainer> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DockerContainer> orderByComparator);

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
	public java.util.List<DockerContainer> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DockerContainer> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the docker containers from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of docker containers.
	*
	* @return the number of docker containers
	*/
	public int countAll();
}