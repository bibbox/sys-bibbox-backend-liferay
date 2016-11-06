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

import at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceException;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the application instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.ApplicationInstancePersistenceImpl
 * @see ApplicationInstanceUtil
 * @generated
 */
@ProviderType
public interface ApplicationInstancePersistence extends BasePersistence<ApplicationInstance> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ApplicationInstanceUtil} to access the application instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the application instances where folderName = &#63;.
	*
	* @param folderName the folder name
	* @return the matching application instances
	*/
	public java.util.List<ApplicationInstance> findByFolderName(
		java.lang.String folderName);

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
	public java.util.List<ApplicationInstance> findByFolderName(
		java.lang.String folderName, int start, int end);

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
	public java.util.List<ApplicationInstance> findByFolderName(
		java.lang.String folderName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstance> orderByComparator);

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
	public java.util.List<ApplicationInstance> findByFolderName(
		java.lang.String folderName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first application instance in the ordered set where folderName = &#63;.
	*
	* @param folderName the folder name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance
	* @throws NoSuchApplicationInstanceException if a matching application instance could not be found
	*/
	public ApplicationInstance findByFolderName_First(
		java.lang.String folderName,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstance> orderByComparator)
		throws NoSuchApplicationInstanceException;

	/**
	* Returns the first application instance in the ordered set where folderName = &#63;.
	*
	* @param folderName the folder name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance, or <code>null</code> if a matching application instance could not be found
	*/
	public ApplicationInstance fetchByFolderName_First(
		java.lang.String folderName,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstance> orderByComparator);

	/**
	* Returns the last application instance in the ordered set where folderName = &#63;.
	*
	* @param folderName the folder name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance
	* @throws NoSuchApplicationInstanceException if a matching application instance could not be found
	*/
	public ApplicationInstance findByFolderName_Last(
		java.lang.String folderName,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstance> orderByComparator)
		throws NoSuchApplicationInstanceException;

	/**
	* Returns the last application instance in the ordered set where folderName = &#63;.
	*
	* @param folderName the folder name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance, or <code>null</code> if a matching application instance could not be found
	*/
	public ApplicationInstance fetchByFolderName_Last(
		java.lang.String folderName,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstance> orderByComparator);

	/**
	* Returns the application instances before and after the current application instance in the ordered set where folderName = &#63;.
	*
	* @param applicationInstanceId the primary key of the current application instance
	* @param folderName the folder name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next application instance
	* @throws NoSuchApplicationInstanceException if a application instance with the primary key could not be found
	*/
	public ApplicationInstance[] findByFolderName_PrevAndNext(
		long applicationInstanceId, java.lang.String folderName,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstance> orderByComparator)
		throws NoSuchApplicationInstanceException;

	/**
	* Removes all the application instances where folderName = &#63; from the database.
	*
	* @param folderName the folder name
	*/
	public void removeByFolderName(java.lang.String folderName);

	/**
	* Returns the number of application instances where folderName = &#63;.
	*
	* @param folderName the folder name
	* @return the number of matching application instances
	*/
	public int countByFolderName(java.lang.String folderName);

	/**
	* Returns the application instance where instanceId = &#63; or throws a {@link NoSuchApplicationInstanceException} if it could not be found.
	*
	* @param instanceId the instance ID
	* @return the matching application instance
	* @throws NoSuchApplicationInstanceException if a matching application instance could not be found
	*/
	public ApplicationInstance findByInstanceId(java.lang.String instanceId)
		throws NoSuchApplicationInstanceException;

	/**
	* Returns the application instance where instanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param instanceId the instance ID
	* @return the matching application instance, or <code>null</code> if a matching application instance could not be found
	*/
	public ApplicationInstance fetchByInstanceId(java.lang.String instanceId);

	/**
	* Returns the application instance where instanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param instanceId the instance ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching application instance, or <code>null</code> if a matching application instance could not be found
	*/
	public ApplicationInstance fetchByInstanceId(java.lang.String instanceId,
		boolean retrieveFromCache);

	/**
	* Removes the application instance where instanceId = &#63; from the database.
	*
	* @param instanceId the instance ID
	* @return the application instance that was removed
	*/
	public ApplicationInstance removeByInstanceId(java.lang.String instanceId)
		throws NoSuchApplicationInstanceException;

	/**
	* Returns the number of application instances where instanceId = &#63;.
	*
	* @param instanceId the instance ID
	* @return the number of matching application instances
	*/
	public int countByInstanceId(java.lang.String instanceId);

	/**
	* Caches the application instance in the entity cache if it is enabled.
	*
	* @param applicationInstance the application instance
	*/
	public void cacheResult(ApplicationInstance applicationInstance);

	/**
	* Caches the application instances in the entity cache if it is enabled.
	*
	* @param applicationInstances the application instances
	*/
	public void cacheResult(
		java.util.List<ApplicationInstance> applicationInstances);

	/**
	* Creates a new application instance with the primary key. Does not add the application instance to the database.
	*
	* @param applicationInstanceId the primary key for the new application instance
	* @return the new application instance
	*/
	public ApplicationInstance create(long applicationInstanceId);

	/**
	* Removes the application instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstanceId the primary key of the application instance
	* @return the application instance that was removed
	* @throws NoSuchApplicationInstanceException if a application instance with the primary key could not be found
	*/
	public ApplicationInstance remove(long applicationInstanceId)
		throws NoSuchApplicationInstanceException;

	public ApplicationInstance updateImpl(
		ApplicationInstance applicationInstance);

	/**
	* Returns the application instance with the primary key or throws a {@link NoSuchApplicationInstanceException} if it could not be found.
	*
	* @param applicationInstanceId the primary key of the application instance
	* @return the application instance
	* @throws NoSuchApplicationInstanceException if a application instance with the primary key could not be found
	*/
	public ApplicationInstance findByPrimaryKey(long applicationInstanceId)
		throws NoSuchApplicationInstanceException;

	/**
	* Returns the application instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param applicationInstanceId the primary key of the application instance
	* @return the application instance, or <code>null</code> if a application instance with the primary key could not be found
	*/
	public ApplicationInstance fetchByPrimaryKey(long applicationInstanceId);

	@Override
	public java.util.Map<java.io.Serializable, ApplicationInstance> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the application instances.
	*
	* @return the application instances
	*/
	public java.util.List<ApplicationInstance> findAll();

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
	public java.util.List<ApplicationInstance> findAll(int start, int end);

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
	public java.util.List<ApplicationInstance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstance> orderByComparator);

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
	public java.util.List<ApplicationInstance> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstance> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the application instances from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of application instances.
	*
	* @return the number of application instances
	*/
	public int countAll();
}