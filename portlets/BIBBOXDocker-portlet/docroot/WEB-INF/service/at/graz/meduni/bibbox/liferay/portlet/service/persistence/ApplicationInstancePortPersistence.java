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

import at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstancePortException;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the application instance port service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl.ApplicationInstancePortPersistenceImpl
 * @see ApplicationInstancePortUtil
 * @generated
 */
@ProviderType
public interface ApplicationInstancePortPersistence extends BasePersistence<ApplicationInstancePort> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ApplicationInstancePortUtil} to access the application instance port persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the application instance ports where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @return the matching application instance ports
	*/
	public java.util.List<ApplicationInstancePort> findByApplicationInstance(
		long applicationInstanceId);

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
	public java.util.List<ApplicationInstancePort> findByApplicationInstance(
		long applicationInstanceId, int start, int end);

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
	public java.util.List<ApplicationInstancePort> findByApplicationInstance(
		long applicationInstanceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstancePort> orderByComparator);

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
	public java.util.List<ApplicationInstancePort> findByApplicationInstance(
		long applicationInstanceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstancePort> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first application instance port in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance port
	* @throws NoSuchApplicationInstancePortException if a matching application instance port could not be found
	*/
	public ApplicationInstancePort findByApplicationInstance_First(
		long applicationInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstancePort> orderByComparator)
		throws NoSuchApplicationInstancePortException;

	/**
	* Returns the first application instance port in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance port, or <code>null</code> if a matching application instance port could not be found
	*/
	public ApplicationInstancePort fetchByApplicationInstance_First(
		long applicationInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstancePort> orderByComparator);

	/**
	* Returns the last application instance port in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance port
	* @throws NoSuchApplicationInstancePortException if a matching application instance port could not be found
	*/
	public ApplicationInstancePort findByApplicationInstance_Last(
		long applicationInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstancePort> orderByComparator)
		throws NoSuchApplicationInstancePortException;

	/**
	* Returns the last application instance port in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance port, or <code>null</code> if a matching application instance port could not be found
	*/
	public ApplicationInstancePort fetchByApplicationInstance_Last(
		long applicationInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstancePort> orderByComparator);

	/**
	* Returns the application instance ports before and after the current application instance port in the ordered set where applicationInstanceId = &#63;.
	*
	* @param applicationInstancePortId the primary key of the current application instance port
	* @param applicationInstanceId the application instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next application instance port
	* @throws NoSuchApplicationInstancePortException if a application instance port with the primary key could not be found
	*/
	public ApplicationInstancePort[] findByApplicationInstance_PrevAndNext(
		long applicationInstancePortId, long applicationInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstancePort> orderByComparator)
		throws NoSuchApplicationInstancePortException;

	/**
	* Removes all the application instance ports where applicationInstanceId = &#63; from the database.
	*
	* @param applicationInstanceId the application instance ID
	*/
	public void removeByApplicationInstance(long applicationInstanceId);

	/**
	* Returns the number of application instance ports where applicationInstanceId = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @return the number of matching application instance ports
	*/
	public int countByApplicationInstance(long applicationInstanceId);

	/**
	* Returns all the application instance ports where applicationInstanceId = &#63; and primary = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param primary the primary
	* @return the matching application instance ports
	*/
	public java.util.List<ApplicationInstancePort> findByPrimaryApplicationInstancePort(
		long applicationInstanceId, boolean primary);

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
	public java.util.List<ApplicationInstancePort> findByPrimaryApplicationInstancePort(
		long applicationInstanceId, boolean primary, int start, int end);

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
	public java.util.List<ApplicationInstancePort> findByPrimaryApplicationInstancePort(
		long applicationInstanceId, boolean primary, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstancePort> orderByComparator);

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
	public java.util.List<ApplicationInstancePort> findByPrimaryApplicationInstancePort(
		long applicationInstanceId, boolean primary, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstancePort> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first application instance port in the ordered set where applicationInstanceId = &#63; and primary = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param primary the primary
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance port
	* @throws NoSuchApplicationInstancePortException if a matching application instance port could not be found
	*/
	public ApplicationInstancePort findByPrimaryApplicationInstancePort_First(
		long applicationInstanceId, boolean primary,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstancePort> orderByComparator)
		throws NoSuchApplicationInstancePortException;

	/**
	* Returns the first application instance port in the ordered set where applicationInstanceId = &#63; and primary = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param primary the primary
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching application instance port, or <code>null</code> if a matching application instance port could not be found
	*/
	public ApplicationInstancePort fetchByPrimaryApplicationInstancePort_First(
		long applicationInstanceId, boolean primary,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstancePort> orderByComparator);

	/**
	* Returns the last application instance port in the ordered set where applicationInstanceId = &#63; and primary = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param primary the primary
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance port
	* @throws NoSuchApplicationInstancePortException if a matching application instance port could not be found
	*/
	public ApplicationInstancePort findByPrimaryApplicationInstancePort_Last(
		long applicationInstanceId, boolean primary,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstancePort> orderByComparator)
		throws NoSuchApplicationInstancePortException;

	/**
	* Returns the last application instance port in the ordered set where applicationInstanceId = &#63; and primary = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param primary the primary
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching application instance port, or <code>null</code> if a matching application instance port could not be found
	*/
	public ApplicationInstancePort fetchByPrimaryApplicationInstancePort_Last(
		long applicationInstanceId, boolean primary,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstancePort> orderByComparator);

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
	public ApplicationInstancePort[] findByPrimaryApplicationInstancePort_PrevAndNext(
		long applicationInstancePortId, long applicationInstanceId,
		boolean primary,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstancePort> orderByComparator)
		throws NoSuchApplicationInstancePortException;

	/**
	* Removes all the application instance ports where applicationInstanceId = &#63; and primary = &#63; from the database.
	*
	* @param applicationInstanceId the application instance ID
	* @param primary the primary
	*/
	public void removeByPrimaryApplicationInstancePort(
		long applicationInstanceId, boolean primary);

	/**
	* Returns the number of application instance ports where applicationInstanceId = &#63; and primary = &#63;.
	*
	* @param applicationInstanceId the application instance ID
	* @param primary the primary
	* @return the number of matching application instance ports
	*/
	public int countByPrimaryApplicationInstancePort(
		long applicationInstanceId, boolean primary);

	/**
	* Caches the application instance port in the entity cache if it is enabled.
	*
	* @param applicationInstancePort the application instance port
	*/
	public void cacheResult(ApplicationInstancePort applicationInstancePort);

	/**
	* Caches the application instance ports in the entity cache if it is enabled.
	*
	* @param applicationInstancePorts the application instance ports
	*/
	public void cacheResult(
		java.util.List<ApplicationInstancePort> applicationInstancePorts);

	/**
	* Creates a new application instance port with the primary key. Does not add the application instance port to the database.
	*
	* @param applicationInstancePortId the primary key for the new application instance port
	* @return the new application instance port
	*/
	public ApplicationInstancePort create(long applicationInstancePortId);

	/**
	* Removes the application instance port with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param applicationInstancePortId the primary key of the application instance port
	* @return the application instance port that was removed
	* @throws NoSuchApplicationInstancePortException if a application instance port with the primary key could not be found
	*/
	public ApplicationInstancePort remove(long applicationInstancePortId)
		throws NoSuchApplicationInstancePortException;

	public ApplicationInstancePort updateImpl(
		ApplicationInstancePort applicationInstancePort);

	/**
	* Returns the application instance port with the primary key or throws a {@link NoSuchApplicationInstancePortException} if it could not be found.
	*
	* @param applicationInstancePortId the primary key of the application instance port
	* @return the application instance port
	* @throws NoSuchApplicationInstancePortException if a application instance port with the primary key could not be found
	*/
	public ApplicationInstancePort findByPrimaryKey(
		long applicationInstancePortId)
		throws NoSuchApplicationInstancePortException;

	/**
	* Returns the application instance port with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param applicationInstancePortId the primary key of the application instance port
	* @return the application instance port, or <code>null</code> if a application instance port with the primary key could not be found
	*/
	public ApplicationInstancePort fetchByPrimaryKey(
		long applicationInstancePortId);

	@Override
	public java.util.Map<java.io.Serializable, ApplicationInstancePort> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the application instance ports.
	*
	* @return the application instance ports
	*/
	public java.util.List<ApplicationInstancePort> findAll();

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
	public java.util.List<ApplicationInstancePort> findAll(int start, int end);

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
	public java.util.List<ApplicationInstancePort> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstancePort> orderByComparator);

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
	public java.util.List<ApplicationInstancePort> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ApplicationInstancePort> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the application instance ports from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of application instance ports.
	*
	* @return the number of application instance ports
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}