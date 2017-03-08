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

import at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceStatusException;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the application instance status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.ApplicationInstanceStatusPersistenceImpl
 * @see ApplicationInstanceStatusUtil
 * @generated
 */
@ProviderType
public interface ApplicationInstanceStatusPersistence extends BasePersistence<ApplicationInstanceStatus> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ApplicationInstanceStatusUtil} to access the application instance status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the application instance status where applicationInstanceId = &#63; or throws a {@link NoSuchApplicationInstanceStatusException} if it could not be found.
	*
	* @param applicationInstanceId the application instance ID
	* @return the matching application instance status
	* @throws NoSuchApplicationInstanceStatusException if a matching application instance status could not be found
	*/
	public ApplicationInstanceStatus findByApplicationInstance(
		long applicationInstanceId)
		throws NoSuchApplicationInstanceStatusException;

	/**
	* Returns the application instance status where applicationInstanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param applicationInstanceId the application instance ID
	* @return the matching application instance status, or <code>null</code> if a matching application instance status could not be found
	*/
	public ApplicationInstanceStatus fetchByApplicationInstance(
		long applicationInstanceId);

	/**
	* Returns the application instance status where applicationInstanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param applicationInstanceId the application instance ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching application instance status, or <code>null</code> if a matching application instance status could not be found
	*/
	public ApplicationInstanceStatus fetchByApplicationInstance(
		long applicationInstanceId, boolean retrieveFromCache);

	/**
	* Removes the application instance status where applicationInstanceId = &#63; from the database.
	*
	* @param applicationInstanceId the application instance ID
	* @return the application instance status that was removed
	*/
	public ApplicationInstanceStatus removeByApplicationInstance(
		long applicationInstanceId)
		throws NoSuchApplicationInstanceStatusException;

	/**
	* Returns the number of application instance statuses where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @return the number of matching application instance statuses
	*/
	public int countByApplicationInstance(long applicationInstanceId);

	/**
	* Caches the application instance status in the entity cache if it is enabled.
	*
	* @param applicationInstanceStatus the application instance status
	*/
	public void cacheResult(ApplicationInstanceStatus applicationInstanceStatus);

	/**
	* Caches the application instance statuses in the entity cache if it is enabled.
	*
	* @param applicationInstanceStatuses the application instance statuses
	*/
	public void cacheResult(
		java.util.List<ApplicationInstanceStatus> applicationInstanceStatuses);

	/**
	* Creates a new application instance status with the primary key. Does not add the application instance status to the database.
	*
	* @param applicationInstanceStatusId the primary key for the new application instance status
	* @return the new application instance status
	*/
	public ApplicationInstanceStatus create(long applicationInstanceStatusId);

	/**
	* Removes the application instance status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstanceStatusId the primary key of the application instance status
	* @return the application instance status that was removed
	* @throws NoSuchApplicationInstanceStatusException if a application instance status with the primary key could not be found
	*/
	public ApplicationInstanceStatus remove(long applicationInstanceStatusId)
		throws NoSuchApplicationInstanceStatusException;

	public ApplicationInstanceStatus updateImpl(
		ApplicationInstanceStatus applicationInstanceStatus);

	/**
	* Returns the application instance status with the primary key or throws a {@link NoSuchApplicationInstanceStatusException} if it could not be found.
	*
	* @param applicationInstanceStatusId the primary key of the application instance status
	* @return the application instance status
	* @throws NoSuchApplicationInstanceStatusException if a application instance status with the primary key could not be found
	*/
	public ApplicationInstanceStatus findByPrimaryKey(
		long applicationInstanceStatusId)
		throws NoSuchApplicationInstanceStatusException;

	/**
	* Returns the application instance status with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param applicationInstanceStatusId the primary key of the application instance status
	* @return the application instance status, or <code>null</code> if a application instance status with the primary key could not be found
	*/
	public ApplicationInstanceStatus fetchByPrimaryKey(
		long applicationInstanceStatusId);

	@Override
	public java.util.Map<java.io.Serializable, ApplicationInstanceStatus> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the application instance statuses.
	*
	* @return the application instance statuses
	*/
	public java.util.List<ApplicationInstanceStatus> findAll();

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
	public java.util.List<ApplicationInstanceStatus> findAll(int start, int end);

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
	public java.util.List<ApplicationInstanceStatus> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstanceStatus> orderByComparator);

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
	public java.util.List<ApplicationInstanceStatus> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstanceStatus> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the application instance statuses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of application instance statuses.
	*
	* @return the number of application instance statuses
	*/
	public int countAll();
}