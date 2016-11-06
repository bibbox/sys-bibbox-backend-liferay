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

import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort;
import at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstancePortLocalService;
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
 * Provides the base implementation for the application instance port local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link at.graz.meduni.bibbox.liferay.portlet.service.impl.ApplicationInstancePortLocalServiceImpl}.
 * </p>
 *
 * @author Robert Reihs
 * @see at.graz.meduni.bibbox.liferay.portlet.service.impl.ApplicationInstancePortLocalServiceImpl
 * @see at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstancePortLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class ApplicationInstancePortLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ApplicationInstancePortLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstancePortLocalServiceUtil} to access the application instance port local service.
	 */

	/**
	 * Adds the application instance port to the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationInstancePort the application instance port
	 * @return the application instance port that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ApplicationInstancePort addApplicationInstancePort(
		ApplicationInstancePort applicationInstancePort) {
		applicationInstancePort.setNew(true);

		return applicationInstancePortPersistence.update(applicationInstancePort);
	}

	/**
	 * Creates a new application instance port with the primary key. Does not add the application instance port to the database.
	 *
	 * @param applicationInstancePortId the primary key for the new application instance port
	 * @return the new application instance port
	 */
	@Override
	public ApplicationInstancePort createApplicationInstancePort(
		long applicationInstancePortId) {
		return applicationInstancePortPersistence.create(applicationInstancePortId);
	}

	/**
	 * Deletes the application instance port with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationInstancePortId the primary key of the application instance port
	 * @return the application instance port that was removed
	 * @throws PortalException if a application instance port with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ApplicationInstancePort deleteApplicationInstancePort(
		long applicationInstancePortId) throws PortalException {
		return applicationInstancePortPersistence.remove(applicationInstancePortId);
	}

	/**
	 * Deletes the application instance port from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationInstancePort the application instance port
	 * @return the application instance port that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ApplicationInstancePort deleteApplicationInstancePort(
		ApplicationInstancePort applicationInstancePort) {
		return applicationInstancePortPersistence.remove(applicationInstancePort);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ApplicationInstancePort.class,
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
		return applicationInstancePortPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstancePortModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return applicationInstancePortPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstancePortModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return applicationInstancePortPersistence.findWithDynamicQuery(dynamicQuery,
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
		return applicationInstancePortPersistence.countWithDynamicQuery(dynamicQuery);
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
		return applicationInstancePortPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public ApplicationInstancePort fetchApplicationInstancePort(
		long applicationInstancePortId) {
		return applicationInstancePortPersistence.fetchByPrimaryKey(applicationInstancePortId);
	}

	/**
	 * Returns the application instance port with the primary key.
	 *
	 * @param applicationInstancePortId the primary key of the application instance port
	 * @return the application instance port
	 * @throws PortalException if a application instance port with the primary key could not be found
	 */
	@Override
	public ApplicationInstancePort getApplicationInstancePort(
		long applicationInstancePortId) throws PortalException {
		return applicationInstancePortPersistence.findByPrimaryKey(applicationInstancePortId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(applicationInstancePortLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ApplicationInstancePort.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"applicationInstancePortId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(applicationInstancePortLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ApplicationInstancePort.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"applicationInstancePortId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(applicationInstancePortLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ApplicationInstancePort.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"applicationInstancePortId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return applicationInstancePortLocalService.deleteApplicationInstancePort((ApplicationInstancePort)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return applicationInstancePortPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the application instance ports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstancePortModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of application instance ports
	 * @param end the upper bound of the range of application instance ports (not inclusive)
	 * @return the range of application instance ports
	 */
	@Override
	public List<ApplicationInstancePort> getApplicationInstancePorts(
		int start, int end) {
		return applicationInstancePortPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of application instance ports.
	 *
	 * @return the number of application instance ports
	 */
	@Override
	public int getApplicationInstancePortsCount() {
		return applicationInstancePortPersistence.countAll();
	}

	/**
	 * Updates the application instance port in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param applicationInstancePort the application instance port
	 * @return the application instance port that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ApplicationInstancePort updateApplicationInstancePort(
		ApplicationInstancePort applicationInstancePort) {
		return applicationInstancePortPersistence.update(applicationInstancePort);
	}

	/**
	 * Returns the application instance local service.
	 *
	 * @return the application instance local service
	 */
	public at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalService getApplicationInstanceLocalService() {
		return applicationInstanceLocalService;
	}

	/**
	 * Sets the application instance local service.
	 *
	 * @param applicationInstanceLocalService the application instance local service
	 */
	public void setApplicationInstanceLocalService(
		at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalService applicationInstanceLocalService) {
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
	 * Returns the application instance port local service.
	 *
	 * @return the application instance port local service
	 */
	public ApplicationInstancePortLocalService getApplicationInstancePortLocalService() {
		return applicationInstancePortLocalService;
	}

	/**
	 * Sets the application instance port local service.
	 *
	 * @param applicationInstancePortLocalService the application instance port local service
	 */
	public void setApplicationInstancePortLocalService(
		ApplicationInstancePortLocalService applicationInstancePortLocalService) {
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

		PersistedModelLocalServiceRegistryUtil.register("at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort",
			applicationInstancePortLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ApplicationInstancePortLocalService.class.getName();
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
		return ApplicationInstancePort.class;
	}

	protected String getModelClassName() {
		return ApplicationInstancePort.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = applicationInstancePortPersistence.getDataSource();

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

	@BeanReference(type = at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalService.class)
	protected at.graz.meduni.bibbox.liferay.portlet.service.ApplicationInstanceLocalService applicationInstanceLocalService;
	@BeanReference(type = ApplicationInstancePersistence.class)
	protected ApplicationInstancePersistence applicationInstancePersistence;
	@BeanReference(type = ApplicationInstancePortLocalService.class)
	protected ApplicationInstancePortLocalService applicationInstancePortLocalService;
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
	private ApplicationInstancePortLocalServiceClpInvoker _clpInvoker = new ApplicationInstancePortLocalServiceClpInvoker();
}