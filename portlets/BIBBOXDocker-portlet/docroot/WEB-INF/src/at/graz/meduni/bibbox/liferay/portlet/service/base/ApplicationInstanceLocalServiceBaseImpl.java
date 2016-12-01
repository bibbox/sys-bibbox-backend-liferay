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

package at.graz.meduni.bibbox.liferay.portlet.service.base;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalService;
import at.graz.meduni.bibbox.liferay.portlet.service.persistence.ApplicationInstanceContainerPersistence;
import at.graz.meduni.bibbox.liferay.portlet.service.persistence.ApplicationInstancePersistence;
import at.graz.meduni.bibbox.liferay.portlet.service.persistence.ApplicationInstancePortPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the application instance local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link at.graz.meduni.bibbox.liferay.portlet.service.impl.ApplicationInstanceLocalServiceImpl}.
 * </p>
 *
 * @author Robert Reihs
 * @see at.graz.meduni.bibbox.liferay.portlet.service.impl.ApplicationInstanceLocalServiceImpl
 * @see at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class ApplicationInstanceLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ApplicationInstanceLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalServiceUtil} to access the application instance local service.
	 */

	/**
	 * Adds the application instance to the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationInstance the application instance
	 * @return the application instance that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ApplicationInstance addApplicationInstance(
		ApplicationInstance applicationInstance) {
		applicationInstance.setNew(true);

		return applicationInstancePersistence.update(applicationInstance);
	}

	/**
	 * Creates a new application instance with the primary key. Does not add the application instance to the database.
	 *
	 * @param applicationInstanceId the primary key for the new application instance
	 * @return the new application instance
	 */
	@Override
	public ApplicationInstance createApplicationInstance(
		long applicationInstanceId) {
		return applicationInstancePersistence.create(applicationInstanceId);
	}

	/**
	 * Deletes the application instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationInstanceId the primary key of the application instance
	 * @return the application instance that was removed
	 * @throws PortalException if a application instance with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ApplicationInstance deleteApplicationInstance(
		long applicationInstanceId) throws PortalException {
		return applicationInstancePersistence.remove(applicationInstanceId);
	}

	/**
	 * Deletes the application instance from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationInstance the application instance
	 * @return the application instance that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ApplicationInstance deleteApplicationInstance(
		ApplicationInstance applicationInstance) {
		return applicationInstancePersistence.remove(applicationInstance);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ApplicationInstance.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return applicationInstancePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return applicationInstancePersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return applicationInstancePersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return applicationInstancePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return applicationInstancePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public ApplicationInstance fetchApplicationInstance(
		long applicationInstanceId) {
		return applicationInstancePersistence.fetchByPrimaryKey(applicationInstanceId);
	}

	/**
	 * Returns the application instance with the primary key.
	 *
	 * @param applicationInstanceId the primary key of the application instance
	 * @return the application instance
	 * @throws PortalException if a application instance with the primary key could not be found
	 */
	@Override
	public ApplicationInstance getApplicationInstance(
		long applicationInstanceId) throws PortalException {
		return applicationInstancePersistence.findByPrimaryKey(applicationInstanceId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(applicationInstanceLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ApplicationInstance.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"applicationInstanceId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(applicationInstanceLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ApplicationInstance.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"applicationInstanceId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(applicationInstanceLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ApplicationInstance.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"applicationInstanceId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return applicationInstanceLocalService.deleteApplicationInstance((ApplicationInstance)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return applicationInstancePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the application instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of application instances
	 * @param end the upper bound of the range of application instances (not inclusive)
	 * @return the range of application instances
	 */
	@Override
	public List<ApplicationInstance> getApplicationInstances(int start, int end) {
		return applicationInstancePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of application instances.
	 *
	 * @return the number of application instances
	 */
	@Override
	public int getApplicationInstancesCount() {
		return applicationInstancePersistence.countAll();
	}

	/**
	 * Updates the application instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param applicationInstance the application instance
	 * @return the application instance that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ApplicationInstance updateApplicationInstance(
		ApplicationInstance applicationInstance) {
		return applicationInstancePersistence.update(applicationInstance);
	}

	/**
	 * Returns the application instance local service.
	 *
	 * @return the application instance local service
	 */
	public ApplicationInstanceLocalService getApplicationInstanceLocalService() {
		return applicationInstanceLocalService;
	}

	/**
	 * Sets the application instance local service.
	 *
	 * @param applicationInstanceLocalService the application instance local service
	 */
	public void setApplicationInstanceLocalService(
		ApplicationInstanceLocalService applicationInstanceLocalService) {
		this.applicationInstanceLocalService = applicationInstanceLocalService;
	}

	/**
	 * Returns the application instance persistence.
	 *
	 * @return the application instance persistence
	 */
	public ApplicationInstancePersistence getApplicationInstancePersistence() {
		return applicationInstancePersistence;
	}

	/**
	 * Sets the application instance persistence.
	 *
	 * @param applicationInstancePersistence the application instance persistence
	 */
	public void setApplicationInstancePersistence(
		ApplicationInstancePersistence applicationInstancePersistence) {
		this.applicationInstancePersistence = applicationInstancePersistence;
	}

	/**
	 * Returns the application instance container local service.
	 *
	 * @return the application instance container local service
	 */
	public at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceContainerLocalService getApplicationInstanceContainerLocalService() {
		return applicationInstanceContainerLocalService;
	}

	/**
	 * Sets the application instance container local service.
	 *
	 * @param applicationInstanceContainerLocalService the application instance container local service
	 */
	public void setApplicationInstanceContainerLocalService(
		at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceContainerLocalService applicationInstanceContainerLocalService) {
		this.applicationInstanceContainerLocalService = applicationInstanceContainerLocalService;
	}

	/**
	 * Returns the application instance container persistence.
	 *
	 * @return the application instance container persistence
	 */
	public ApplicationInstanceContainerPersistence getApplicationInstanceContainerPersistence() {
		return applicationInstanceContainerPersistence;
	}

	/**
	 * Sets the application instance container persistence.
	 *
	 * @param applicationInstanceContainerPersistence the application instance container persistence
	 */
	public void setApplicationInstanceContainerPersistence(
		ApplicationInstanceContainerPersistence applicationInstanceContainerPersistence) {
		this.applicationInstanceContainerPersistence = applicationInstanceContainerPersistence;
	}

	/**
	 * Returns the application instance port local service.
	 *
	 * @return the application instance port local service
	 */
	public at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstancePortLocalService getApplicationInstancePortLocalService() {
		return applicationInstancePortLocalService;
	}

	/**
	 * Sets the application instance port local service.
	 *
	 * @param applicationInstancePortLocalService the application instance port local service
	 */
	public void setApplicationInstancePortLocalService(
		at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstancePortLocalService applicationInstancePortLocalService) {
		this.applicationInstancePortLocalService = applicationInstancePortLocalService;
	}

	/**
	 * Returns the application instance port persistence.
	 *
	 * @return the application instance port persistence
	 */
	public ApplicationInstancePortPersistence getApplicationInstancePortPersistence() {
		return applicationInstancePortPersistence;
	}

	/**
	 * Sets the application instance port persistence.
	 *
	 * @param applicationInstancePortPersistence the application instance port persistence
	 */
	public void setApplicationInstancePortPersistence(
		ApplicationInstancePortPersistence applicationInstancePortPersistence) {
		this.applicationInstancePortPersistence = applicationInstancePortPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance",
			applicationInstanceLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ApplicationInstanceLocalService.class.getName();
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return ApplicationInstance.class;
	}

	protected String getModelClassName() {
		return ApplicationInstance.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = applicationInstancePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = ApplicationInstanceLocalService.class)
	protected ApplicationInstanceLocalService applicationInstanceLocalService;
	@BeanReference(type = ApplicationInstancePersistence.class)
	protected ApplicationInstancePersistence applicationInstancePersistence;
	@BeanReference(type = at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceContainerLocalService.class)
	protected at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceContainerLocalService applicationInstanceContainerLocalService;
	@BeanReference(type = ApplicationInstanceContainerPersistence.class)
	protected ApplicationInstanceContainerPersistence applicationInstanceContainerPersistence;
	@BeanReference(type = at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstancePortLocalService.class)
	protected at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstancePortLocalService applicationInstancePortLocalService;
	@BeanReference(type = ApplicationInstancePortPersistence.class)
	protected ApplicationInstancePortPersistence applicationInstancePortPersistence;
	@BeanReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@BeanReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private ClassLoader _classLoader;
	private ApplicationInstanceLocalServiceClpInvoker _clpInvoker = new ApplicationInstanceLocalServiceClpInvoker();
}