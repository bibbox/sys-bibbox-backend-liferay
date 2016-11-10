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

import at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceContainerException;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the application instance container service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.ApplicationInstanceContainerPersistenceImpl
 * @see ApplicationInstanceContainerUtil
 * @generated
 */
@ProviderType
public interface ApplicationInstanceContainerPersistence extends BasePersistence<ApplicationInstanceContainer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ApplicationInstanceContainerUtil} to access the application instance container persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the application instance containers where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @return the matching application instance containers
	*/
	public java.util.List<ApplicationInstanceContainer> findByApplicationInstance(
		long applicationInstanceId);

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
	public java.util.List<ApplicationInstanceContainer> findByApplicationInstance(
		long applicationInstanceId, int start, int end);

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
	public java.util.List<ApplicationInstanceContainer> findByApplicationInstance(
		long applicationInstanceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstanceContainer> orderByComparator);

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
	public java.util.List<ApplicationInstanceContainer> findByApplicationInstance(
		long applicationInstanceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstanceContainer> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first application instance container in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance container
	* @throws NoSuchApplicationInstanceContainerException if a matching application instance container could not be found
	*/
	public ApplicationInstanceContainer findByApplicationInstance_First(
		long applicationInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstanceContainer> orderByComparator)
		throws NoSuchApplicationInstanceContainerException;

	/**
	* Returns the first application instance container in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance container, or <code>null</code> if a matching application instance container could not be found
	*/
	public ApplicationInstanceContainer fetchByApplicationInstance_First(
		long applicationInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstanceContainer> orderByComparator);

	/**
	* Returns the last application instance container in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance container
	* @throws NoSuchApplicationInstanceContainerException if a matching application instance container could not be found
	*/
	public ApplicationInstanceContainer findByApplicationInstance_Last(
		long applicationInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstanceContainer> orderByComparator)
		throws NoSuchApplicationInstanceContainerException;

	/**
	* Returns the last application instance container in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance container, or <code>null</code> if a matching application instance container could not be found
	*/
	public ApplicationInstanceContainer fetchByApplicationInstance_Last(
		long applicationInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstanceContainer> orderByComparator);

	/**
	* Returns the application instance containers before and after the current application instance container in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceContainerId the primary key of the current application instance container
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next application instance container
	* @throws NoSuchApplicationInstanceContainerException if a application instance container with the primary key could not be found
	*/
	public ApplicationInstanceContainer[] findByApplicationInstance_PrevAndNext(
		long applicationInstanceContainerId, long applicationInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstanceContainer> orderByComparator)
		throws NoSuchApplicationInstanceContainerException;

	/**
	* Removes all the application instance containers where applicationInstanceId = &#63; from the database.
	*
	* @param applicationInstanceId the application instance ID
	*/
	public void removeByApplicationInstance(long applicationInstanceId);

	/**
	* Returns the number of application instance containers where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @return the number of matching application instance containers
	*/
	public int countByApplicationInstance(long applicationInstanceId);

	/**
	* Returns all the application instance containers where applicationInstanceId = &#63; and needrunning = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param needrunning the needrunning
	* @return the matching application instance containers
	*/
	public java.util.List<ApplicationInstanceContainer> findByApplicationInstanceRunning(
		long applicationInstanceId, boolean needrunning);

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
	public java.util.List<ApplicationInstanceContainer> findByApplicationInstanceRunning(
		long applicationInstanceId, boolean needrunning, int start, int end);

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
	public java.util.List<ApplicationInstanceContainer> findByApplicationInstanceRunning(
		long applicationInstanceId, boolean needrunning, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstanceContainer> orderByComparator);

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
	public java.util.List<ApplicationInstanceContainer> findByApplicationInstanceRunning(
		long applicationInstanceId, boolean needrunning, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstanceContainer> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first application instance container in the ordered set where applicationInstanceId = &#63; and needrunning = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param needrunning the needrunning
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance container
	* @throws NoSuchApplicationInstanceContainerException if a matching application instance container could not be found
	*/
	public ApplicationInstanceContainer findByApplicationInstanceRunning_First(
		long applicationInstanceId, boolean needrunning,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstanceContainer> orderByComparator)
		throws NoSuchApplicationInstanceContainerException;

	/**
	* Returns the first application instance container in the ordered set where applicationInstanceId = &#63; and needrunning = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param needrunning the needrunning
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance container, or <code>null</code> if a matching application instance container could not be found
	*/
	public ApplicationInstanceContainer fetchByApplicationInstanceRunning_First(
		long applicationInstanceId, boolean needrunning,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstanceContainer> orderByComparator);

	/**
	* Returns the last application instance container in the ordered set where applicationInstanceId = &#63; and needrunning = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param needrunning the needrunning
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance container
	* @throws NoSuchApplicationInstanceContainerException if a matching application instance container could not be found
	*/
	public ApplicationInstanceContainer findByApplicationInstanceRunning_Last(
		long applicationInstanceId, boolean needrunning,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstanceContainer> orderByComparator)
		throws NoSuchApplicationInstanceContainerException;

	/**
	* Returns the last application instance container in the ordered set where applicationInstanceId = &#63; and needrunning = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param needrunning the needrunning
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance container, or <code>null</code> if a matching application instance container could not be found
	*/
	public ApplicationInstanceContainer fetchByApplicationInstanceRunning_Last(
		long applicationInstanceId, boolean needrunning,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstanceContainer> orderByComparator);

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
	public ApplicationInstanceContainer[] findByApplicationInstanceRunning_PrevAndNext(
		long applicationInstanceContainerId, long applicationInstanceId,
		boolean needrunning,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstanceContainer> orderByComparator)
		throws NoSuchApplicationInstanceContainerException;

	/**
	* Removes all the application instance containers where applicationInstanceId = &#63; and needrunning = &#63; from the database.
	*
	* @param applicationInstanceId the application instance ID
	* @param needrunning the needrunning
	*/
	public void removeByApplicationInstanceRunning(long applicationInstanceId,
		boolean needrunning);

	/**
	* Returns the number of application instance containers where applicationInstanceId = &#63; and needrunning = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param needrunning the needrunning
	* @return the number of matching application instance containers
	*/
	public int countByApplicationInstanceRunning(long applicationInstanceId,
		boolean needrunning);

	/**
	* Caches the application instance container in the entity cache if it is enabled.
	*
	* @param applicationInstanceContainer the application instance container
	*/
	public void cacheResult(
		ApplicationInstanceContainer applicationInstanceContainer);

	/**
	* Caches the application instance containers in the entity cache if it is enabled.
	*
	* @param applicationInstanceContainers the application instance containers
	*/
	public void cacheResult(
		java.util.List<ApplicationInstanceContainer> applicationInstanceContainers);

	/**
	* Creates a new application instance container with the primary key. Does not add the application instance container to the database.
	*
	* @param applicationInstanceContainerId the primary key for the new application instance container
	* @return the new application instance container
	*/
	public ApplicationInstanceContainer create(
		long applicationInstanceContainerId);

	/**
	* Removes the application instance container with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstanceContainerId the primary key of the application instance container
	* @return the application instance container that was removed
	* @throws NoSuchApplicationInstanceContainerException if a application instance container with the primary key could not be found
	*/
	public ApplicationInstanceContainer remove(
		long applicationInstanceContainerId)
		throws NoSuchApplicationInstanceContainerException;

	public ApplicationInstanceContainer updateImpl(
		ApplicationInstanceContainer applicationInstanceContainer);

	/**
	* Returns the application instance container with the primary key or throws a {@link NoSuchApplicationInstanceContainerException} if it could not be found.
	*
	* @param applicationInstanceContainerId the primary key of the application instance container
	* @return the application instance container
	* @throws NoSuchApplicationInstanceContainerException if a application instance container with the primary key could not be found
	*/
	public ApplicationInstanceContainer findByPrimaryKey(
		long applicationInstanceContainerId)
		throws NoSuchApplicationInstanceContainerException;

	/**
	* Returns the application instance container with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param applicationInstanceContainerId the primary key of the application instance container
	* @return the application instance container, or <code>null</code> if a application instance container with the primary key could not be found
	*/
	public ApplicationInstanceContainer fetchByPrimaryKey(
		long applicationInstanceContainerId);

	@Override
	public java.util.Map<java.io.Serializable, ApplicationInstanceContainer> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the application instance containers.
	*
	* @return the application instance containers
	*/
	public java.util.List<ApplicationInstanceContainer> findAll();

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
	public java.util.List<ApplicationInstanceContainer> findAll(int start,
		int end);

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
	public java.util.List<ApplicationInstanceContainer> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstanceContainer> orderByComparator);

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
	public java.util.List<ApplicationInstanceContainer> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstanceContainer> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the application instance containers from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of application instance containers.
	*
	* @return the number of application instance containers
	*/
	public int countAll();
}