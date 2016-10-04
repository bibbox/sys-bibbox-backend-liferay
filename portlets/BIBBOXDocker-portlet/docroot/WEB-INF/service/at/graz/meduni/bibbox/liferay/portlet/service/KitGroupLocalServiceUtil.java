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

package at.graz.meduni.bibbox.liferay.portlet.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.service.InvokableLocalService;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * Provides the local service utility for KitGroup. This utility wraps
 * {@link at.graz.meduni.bibbox.liferay.portlet.service.impl.KitGroupLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Robert Reihs
 * @see KitGroupLocalService
 * @see at.graz.meduni.bibbox.liferay.portlet.service.base.KitGroupLocalServiceBaseImpl
 * @see at.graz.meduni.bibbox.liferay.portlet.service.impl.KitGroupLocalServiceImpl
 * @generated
 */
@ProviderType
public class KitGroupLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link at.graz.meduni.bibbox.liferay.portlet.service.impl.KitGroupLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the kit group to the database. Also notifies the appropriate model listeners.
	*
	* @param kitGroup the kit group
	* @return the kit group that was added
	*/
	public static at.graz.meduni.bibbox.liferay.portlet.model.KitGroup addKitGroup(
		at.graz.meduni.bibbox.liferay.portlet.model.KitGroup kitGroup) {
		return getService().addKitGroup(kitGroup);
	}

	/**
	* Creates a new kit group with the primary key. Does not add the kit group to the database.
	*
	* @param kitGroupId the primary key for the new kit group
	* @return the new kit group
	*/
	public static at.graz.meduni.bibbox.liferay.portlet.model.KitGroup createKitGroup(
		long kitGroupId) {
		return getService().createKitGroup(kitGroupId);
	}

	/**
	* Deletes the kit group from the database. Also notifies the appropriate model listeners.
	*
	* @param kitGroup the kit group
	* @return the kit group that was removed
	*/
	public static at.graz.meduni.bibbox.liferay.portlet.model.KitGroup deleteKitGroup(
		at.graz.meduni.bibbox.liferay.portlet.model.KitGroup kitGroup) {
		return getService().deleteKitGroup(kitGroup);
	}

	/**
	* Deletes the kit group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param kitGroupId the primary key of the kit group
	* @return the kit group that was removed
	* @throws PortalException if a kit group with the primary key could not be found
	*/
	public static at.graz.meduni.bibbox.liferay.portlet.model.KitGroup deleteKitGroup(
		long kitGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteKitGroup(kitGroupId);
	}

	public static at.graz.meduni.bibbox.liferay.portlet.model.KitGroup fetchKitGroup(
		long kitGroupId) {
		return getService().fetchKitGroup(kitGroupId);
	}

	/**
	* Returns the kit group with the primary key.
	*
	* @param kitGroupId the primary key of the kit group
	* @return the kit group
	* @throws PortalException if a kit group with the primary key could not be found
	*/
	public static at.graz.meduni.bibbox.liferay.portlet.model.KitGroup getKitGroup(
		long kitGroupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getKitGroup(kitGroupId);
	}

	/**
	* Updates the kit group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param kitGroup the kit group
	* @return the kit group that was updated
	*/
	public static at.graz.meduni.bibbox.liferay.portlet.model.KitGroup updateKitGroup(
		at.graz.meduni.bibbox.liferay.portlet.model.KitGroup kitGroup) {
		return getService().updateKitGroup(kitGroup);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of kit groups.
	*
	* @return the number of kit groups
	*/
	public static int getKitGroupsCount() {
		return getService().getKitGroupsCount();
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the kit groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of kit groups
	* @param end the upper bound of the range of kit groups (not inclusive)
	* @return the range of kit groups
	*/
	public static java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.KitGroup> getKitGroups(
		int start, int end) {
		return getService().getKitGroups(start, end);
	}

	public static java.util.List<at.graz.meduni.bibbox.liferay.portlet.model.KitGroup> getKitGroups(
		long applicationStoreItemId) {
		return getService().getKitGroups(applicationStoreItemId);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static void clearService() {
		_service = null;
	}

	public static KitGroupLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					KitGroupLocalService.class.getName());

			if (invokableLocalService instanceof KitGroupLocalService) {
				_service = (KitGroupLocalService)invokableLocalService;
			}
			else {
				_service = new KitGroupLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(KitGroupLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	private static KitGroupLocalService _service;
}