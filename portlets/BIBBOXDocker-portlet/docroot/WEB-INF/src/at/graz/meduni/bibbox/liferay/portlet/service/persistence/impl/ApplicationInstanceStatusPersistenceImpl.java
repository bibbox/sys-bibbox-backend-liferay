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

package at.graz.meduni.bibbox.liferay.portlet.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceStatusException;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceStatus;
import at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceStatusImpl;
import at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceStatusModelImpl;
import at.graz.meduni.bibbox.liferay.portlet.service.persistence.ApplicationInstanceStatusPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the application instance status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationInstanceStatusPersistence
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.ApplicationInstanceStatusUtil
 * @generated
 */
@ProviderType
public class ApplicationInstanceStatusPersistenceImpl
	extends BasePersistenceImpl<ApplicationInstanceStatus>
	implements ApplicationInstanceStatusPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ApplicationInstanceStatusUtil} to access the application instance status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ApplicationInstanceStatusImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ApplicationInstanceStatusModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceStatusModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstanceStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ApplicationInstanceStatusModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceStatusModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstanceStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ApplicationInstanceStatusModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceStatusModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_APPLICATIONINSTANCE = new FinderPath(ApplicationInstanceStatusModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceStatusModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstanceStatusImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByApplicationInstance",
			new String[] { Long.class.getName() },
			ApplicationInstanceStatusModelImpl.APPLICATIONINSTANCEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICATIONINSTANCE = new FinderPath(ApplicationInstanceStatusModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceStatusModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApplicationInstance", new String[] { Long.class.getName() });

	/**
	 * Returns the application instance status where applicationInstanceId = &#63; or throws a {@link NoSuchApplicationInstanceStatusException} if it could not be found.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @return the matching application instance status
	 * @throws NoSuchApplicationInstanceStatusException if a matching application instance status could not be found
	 */
	@Override
	public ApplicationInstanceStatus findByApplicationInstance(
		long applicationInstanceId)
		throws NoSuchApplicationInstanceStatusException {
		ApplicationInstanceStatus applicationInstanceStatus = fetchByApplicationInstance(applicationInstanceId);

		if (applicationInstanceStatus == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("applicationInstanceId=");
			msg.append(applicationInstanceId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchApplicationInstanceStatusException(msg.toString());
		}

		return applicationInstanceStatus;
	}

	/**
	 * Returns the application instance status where applicationInstanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @return the matching application instance status, or <code>null</code> if a matching application instance status could not be found
	 */
	@Override
	public ApplicationInstanceStatus fetchByApplicationInstance(
		long applicationInstanceId) {
		return fetchByApplicationInstance(applicationInstanceId, true);
	}

	/**
	 * Returns the application instance status where applicationInstanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching application instance status, or <code>null</code> if a matching application instance status could not be found
	 */
	@Override
	public ApplicationInstanceStatus fetchByApplicationInstance(
		long applicationInstanceId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { applicationInstanceId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_APPLICATIONINSTANCE,
					finderArgs, this);
		}

		if (result instanceof ApplicationInstanceStatus) {
			ApplicationInstanceStatus applicationInstanceStatus = (ApplicationInstanceStatus)result;

			if ((applicationInstanceId != applicationInstanceStatus.getApplicationInstanceId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_APPLICATIONINSTANCESTATUS_WHERE);

			query.append(_FINDER_COLUMN_APPLICATIONINSTANCE_APPLICATIONINSTANCEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicationInstanceId);

				List<ApplicationInstanceStatus> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_APPLICATIONINSTANCE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ApplicationInstanceStatusPersistenceImpl.fetchByApplicationInstance(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ApplicationInstanceStatus applicationInstanceStatus = list.get(0);

					result = applicationInstanceStatus;

					cacheResult(applicationInstanceStatus);

					if ((applicationInstanceStatus.getApplicationInstanceId() != applicationInstanceId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_APPLICATIONINSTANCE,
							finderArgs, applicationInstanceStatus);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_APPLICATIONINSTANCE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ApplicationInstanceStatus)result;
		}
	}

	/**
	 * Removes the application instance status where applicationInstanceId = &#63; from the database.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @return the application instance status that was removed
	 */
	@Override
	public ApplicationInstanceStatus removeByApplicationInstance(
		long applicationInstanceId)
		throws NoSuchApplicationInstanceStatusException {
		ApplicationInstanceStatus applicationInstanceStatus = findByApplicationInstance(applicationInstanceId);

		return remove(applicationInstanceStatus);
	}

	/**
	 * Returns the number of application instance statuses where applicationInstanceId = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @return the number of matching application instance statuses
	 */
	@Override
	public int countByApplicationInstance(long applicationInstanceId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPLICATIONINSTANCE;

		Object[] finderArgs = new Object[] { applicationInstanceId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPLICATIONINSTANCESTATUS_WHERE);

			query.append(_FINDER_COLUMN_APPLICATIONINSTANCE_APPLICATIONINSTANCEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicationInstanceId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_APPLICATIONINSTANCE_APPLICATIONINSTANCEID_2 =
		"applicationInstanceStatus.applicationInstanceId = ?";

	public ApplicationInstanceStatusPersistenceImpl() {
		setModelClass(ApplicationInstanceStatus.class);
	}

	/**
	 * Caches the application instance status in the entity cache if it is enabled.
	 *
	 * @param applicationInstanceStatus the application instance status
	 */
	@Override
	public void cacheResult(ApplicationInstanceStatus applicationInstanceStatus) {
		entityCache.putResult(ApplicationInstanceStatusModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceStatusImpl.class,
			applicationInstanceStatus.getPrimaryKey(), applicationInstanceStatus);

		finderCache.putResult(FINDER_PATH_FETCH_BY_APPLICATIONINSTANCE,
			new Object[] { applicationInstanceStatus.getApplicationInstanceId() },
			applicationInstanceStatus);

		applicationInstanceStatus.resetOriginalValues();
	}

	/**
	 * Caches the application instance statuses in the entity cache if it is enabled.
	 *
	 * @param applicationInstanceStatuses the application instance statuses
	 */
	@Override
	public void cacheResult(
		List<ApplicationInstanceStatus> applicationInstanceStatuses) {
		for (ApplicationInstanceStatus applicationInstanceStatus : applicationInstanceStatuses) {
			if (entityCache.getResult(
						ApplicationInstanceStatusModelImpl.ENTITY_CACHE_ENABLED,
						ApplicationInstanceStatusImpl.class,
						applicationInstanceStatus.getPrimaryKey()) == null) {
				cacheResult(applicationInstanceStatus);
			}
			else {
				applicationInstanceStatus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all application instance statuses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ApplicationInstanceStatusImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the application instance status.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ApplicationInstanceStatus applicationInstanceStatus) {
		entityCache.removeResult(ApplicationInstanceStatusModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceStatusImpl.class,
			applicationInstanceStatus.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ApplicationInstanceStatusModelImpl)applicationInstanceStatus);
	}

	@Override
	public void clearCache(
		List<ApplicationInstanceStatus> applicationInstanceStatuses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ApplicationInstanceStatus applicationInstanceStatus : applicationInstanceStatuses) {
			entityCache.removeResult(ApplicationInstanceStatusModelImpl.ENTITY_CACHE_ENABLED,
				ApplicationInstanceStatusImpl.class,
				applicationInstanceStatus.getPrimaryKey());

			clearUniqueFindersCache((ApplicationInstanceStatusModelImpl)applicationInstanceStatus);
		}
	}

	protected void cacheUniqueFindersCache(
		ApplicationInstanceStatusModelImpl applicationInstanceStatusModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					applicationInstanceStatusModelImpl.getApplicationInstanceId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_APPLICATIONINSTANCE,
				args, Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_APPLICATIONINSTANCE,
				args, applicationInstanceStatusModelImpl);
		}
		else {
			if ((applicationInstanceStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_APPLICATIONINSTANCE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						applicationInstanceStatusModelImpl.getApplicationInstanceId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_APPLICATIONINSTANCE,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_APPLICATIONINSTANCE,
					args, applicationInstanceStatusModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ApplicationInstanceStatusModelImpl applicationInstanceStatusModelImpl) {
		Object[] args = new Object[] {
				applicationInstanceStatusModelImpl.getApplicationInstanceId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONINSTANCE, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_APPLICATIONINSTANCE, args);

		if ((applicationInstanceStatusModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_APPLICATIONINSTANCE.getColumnBitmask()) != 0) {
			args = new Object[] {
					applicationInstanceStatusModelImpl.getOriginalApplicationInstanceId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONINSTANCE,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_APPLICATIONINSTANCE,
				args);
		}
	}

	/**
	 * Creates a new application instance status with the primary key. Does not add the application instance status to the database.
	 *
	 * @param applicationInstanceStatusId the primary key for the new application instance status
	 * @return the new application instance status
	 */
	@Override
	public ApplicationInstanceStatus create(long applicationInstanceStatusId) {
		ApplicationInstanceStatus applicationInstanceStatus = new ApplicationInstanceStatusImpl();

		applicationInstanceStatus.setNew(true);
		applicationInstanceStatus.setPrimaryKey(applicationInstanceStatusId);

		applicationInstanceStatus.setCompanyId(companyProvider.getCompanyId());

		return applicationInstanceStatus;
	}

	/**
	 * Removes the application instance status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationInstanceStatusId the primary key of the application instance status
	 * @return the application instance status that was removed
	 * @throws NoSuchApplicationInstanceStatusException if a application instance status with the primary key could not be found
	 */
	@Override
	public ApplicationInstanceStatus remove(long applicationInstanceStatusId)
		throws NoSuchApplicationInstanceStatusException {
		return remove((Serializable)applicationInstanceStatusId);
	}

	/**
	 * Removes the application instance status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the application instance status
	 * @return the application instance status that was removed
	 * @throws NoSuchApplicationInstanceStatusException if a application instance status with the primary key could not be found
	 */
	@Override
	public ApplicationInstanceStatus remove(Serializable primaryKey)
		throws NoSuchApplicationInstanceStatusException {
		Session session = null;

		try {
			session = openSession();

			ApplicationInstanceStatus applicationInstanceStatus = (ApplicationInstanceStatus)session.get(ApplicationInstanceStatusImpl.class,
					primaryKey);

			if (applicationInstanceStatus == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApplicationInstanceStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(applicationInstanceStatus);
		}
		catch (NoSuchApplicationInstanceStatusException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ApplicationInstanceStatus removeImpl(
		ApplicationInstanceStatus applicationInstanceStatus) {
		applicationInstanceStatus = toUnwrappedModel(applicationInstanceStatus);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(applicationInstanceStatus)) {
				applicationInstanceStatus = (ApplicationInstanceStatus)session.get(ApplicationInstanceStatusImpl.class,
						applicationInstanceStatus.getPrimaryKeyObj());
			}

			if (applicationInstanceStatus != null) {
				session.delete(applicationInstanceStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (applicationInstanceStatus != null) {
			clearCache(applicationInstanceStatus);
		}

		return applicationInstanceStatus;
	}

	@Override
	public ApplicationInstanceStatus updateImpl(
		ApplicationInstanceStatus applicationInstanceStatus) {
		applicationInstanceStatus = toUnwrappedModel(applicationInstanceStatus);

		boolean isNew = applicationInstanceStatus.isNew();

		ApplicationInstanceStatusModelImpl applicationInstanceStatusModelImpl = (ApplicationInstanceStatusModelImpl)applicationInstanceStatus;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (applicationInstanceStatus.getCreateDate() == null)) {
			if (serviceContext == null) {
				applicationInstanceStatus.setCreateDate(now);
			}
			else {
				applicationInstanceStatus.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!applicationInstanceStatusModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				applicationInstanceStatus.setModifiedDate(now);
			}
			else {
				applicationInstanceStatus.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (applicationInstanceStatus.isNew()) {
				session.save(applicationInstanceStatus);

				applicationInstanceStatus.setNew(false);
			}
			else {
				applicationInstanceStatus = (ApplicationInstanceStatus)session.merge(applicationInstanceStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!ApplicationInstanceStatusModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(ApplicationInstanceStatusModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceStatusImpl.class,
			applicationInstanceStatus.getPrimaryKey(),
			applicationInstanceStatus, false);

		clearUniqueFindersCache(applicationInstanceStatusModelImpl);
		cacheUniqueFindersCache(applicationInstanceStatusModelImpl, isNew);

		applicationInstanceStatus.resetOriginalValues();

		return applicationInstanceStatus;
	}

	protected ApplicationInstanceStatus toUnwrappedModel(
		ApplicationInstanceStatus applicationInstanceStatus) {
		if (applicationInstanceStatus instanceof ApplicationInstanceStatusImpl) {
			return applicationInstanceStatus;
		}

		ApplicationInstanceStatusImpl applicationInstanceStatusImpl = new ApplicationInstanceStatusImpl();

		applicationInstanceStatusImpl.setNew(applicationInstanceStatus.isNew());
		applicationInstanceStatusImpl.setPrimaryKey(applicationInstanceStatus.getPrimaryKey());

		applicationInstanceStatusImpl.setApplicationInstanceStatusId(applicationInstanceStatus.getApplicationInstanceStatusId());
		applicationInstanceStatusImpl.setGroupId(applicationInstanceStatus.getGroupId());
		applicationInstanceStatusImpl.setCompanyId(applicationInstanceStatus.getCompanyId());
		applicationInstanceStatusImpl.setUserId(applicationInstanceStatus.getUserId());
		applicationInstanceStatusImpl.setUserName(applicationInstanceStatus.getUserName());
		applicationInstanceStatusImpl.setCreateDate(applicationInstanceStatus.getCreateDate());
		applicationInstanceStatusImpl.setModifiedDate(applicationInstanceStatus.getModifiedDate());
		applicationInstanceStatusImpl.setApplicationInstanceId(applicationInstanceStatus.getApplicationInstanceId());
		applicationInstanceStatusImpl.setStatus(applicationInstanceStatus.getStatus());

		return applicationInstanceStatusImpl;
	}

	/**
	 * Returns the application instance status with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the application instance status
	 * @return the application instance status
	 * @throws NoSuchApplicationInstanceStatusException if a application instance status with the primary key could not be found
	 */
	@Override
	public ApplicationInstanceStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchApplicationInstanceStatusException {
		ApplicationInstanceStatus applicationInstanceStatus = fetchByPrimaryKey(primaryKey);

		if (applicationInstanceStatus == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchApplicationInstanceStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return applicationInstanceStatus;
	}

	/**
	 * Returns the application instance status with the primary key or throws a {@link NoSuchApplicationInstanceStatusException} if it could not be found.
	 *
	 * @param applicationInstanceStatusId the primary key of the application instance status
	 * @return the application instance status
	 * @throws NoSuchApplicationInstanceStatusException if a application instance status with the primary key could not be found
	 */
	@Override
	public ApplicationInstanceStatus findByPrimaryKey(
		long applicationInstanceStatusId)
		throws NoSuchApplicationInstanceStatusException {
		return findByPrimaryKey((Serializable)applicationInstanceStatusId);
	}

	/**
	 * Returns the application instance status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the application instance status
	 * @return the application instance status, or <code>null</code> if a application instance status with the primary key could not be found
	 */
	@Override
	public ApplicationInstanceStatus fetchByPrimaryKey(Serializable primaryKey) {
		ApplicationInstanceStatus applicationInstanceStatus = (ApplicationInstanceStatus)entityCache.getResult(ApplicationInstanceStatusModelImpl.ENTITY_CACHE_ENABLED,
				ApplicationInstanceStatusImpl.class, primaryKey);

		if (applicationInstanceStatus == _nullApplicationInstanceStatus) {
			return null;
		}

		if (applicationInstanceStatus == null) {
			Session session = null;

			try {
				session = openSession();

				applicationInstanceStatus = (ApplicationInstanceStatus)session.get(ApplicationInstanceStatusImpl.class,
						primaryKey);

				if (applicationInstanceStatus != null) {
					cacheResult(applicationInstanceStatus);
				}
				else {
					entityCache.putResult(ApplicationInstanceStatusModelImpl.ENTITY_CACHE_ENABLED,
						ApplicationInstanceStatusImpl.class, primaryKey,
						_nullApplicationInstanceStatus);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ApplicationInstanceStatusModelImpl.ENTITY_CACHE_ENABLED,
					ApplicationInstanceStatusImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return applicationInstanceStatus;
	}

	/**
	 * Returns the application instance status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param applicationInstanceStatusId the primary key of the application instance status
	 * @return the application instance status, or <code>null</code> if a application instance status with the primary key could not be found
	 */
	@Override
	public ApplicationInstanceStatus fetchByPrimaryKey(
		long applicationInstanceStatusId) {
		return fetchByPrimaryKey((Serializable)applicationInstanceStatusId);
	}

	@Override
	public Map<Serializable, ApplicationInstanceStatus> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ApplicationInstanceStatus> map = new HashMap<Serializable, ApplicationInstanceStatus>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ApplicationInstanceStatus applicationInstanceStatus = fetchByPrimaryKey(primaryKey);

			if (applicationInstanceStatus != null) {
				map.put(primaryKey, applicationInstanceStatus);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			ApplicationInstanceStatus applicationInstanceStatus = (ApplicationInstanceStatus)entityCache.getResult(ApplicationInstanceStatusModelImpl.ENTITY_CACHE_ENABLED,
					ApplicationInstanceStatusImpl.class, primaryKey);

			if (applicationInstanceStatus == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, applicationInstanceStatus);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_APPLICATIONINSTANCESTATUS_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (ApplicationInstanceStatus applicationInstanceStatus : (List<ApplicationInstanceStatus>)q.list()) {
				map.put(applicationInstanceStatus.getPrimaryKeyObj(),
					applicationInstanceStatus);

				cacheResult(applicationInstanceStatus);

				uncachedPrimaryKeys.remove(applicationInstanceStatus.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ApplicationInstanceStatusModelImpl.ENTITY_CACHE_ENABLED,
					ApplicationInstanceStatusImpl.class, primaryKey,
					_nullApplicationInstanceStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the application instance statuses.
	 *
	 * @return the application instance statuses
	 */
	@Override
	public List<ApplicationInstanceStatus> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ApplicationInstanceStatus> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ApplicationInstanceStatus> findAll(int start, int end,
		OrderByComparator<ApplicationInstanceStatus> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<ApplicationInstanceStatus> findAll(int start, int end,
		OrderByComparator<ApplicationInstanceStatus> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ApplicationInstanceStatus> list = null;

		if (retrieveFromCache) {
			list = (List<ApplicationInstanceStatus>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_APPLICATIONINSTANCESTATUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPLICATIONINSTANCESTATUS;

				if (pagination) {
					sql = sql.concat(ApplicationInstanceStatusModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ApplicationInstanceStatus>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ApplicationInstanceStatus>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the application instance statuses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ApplicationInstanceStatus applicationInstanceStatus : findAll()) {
			remove(applicationInstanceStatus);
		}
	}

	/**
	 * Returns the number of application instance statuses.
	 *
	 * @return the number of application instance statuses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_APPLICATIONINSTANCESTATUS);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ApplicationInstanceStatusModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the application instance status persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ApplicationInstanceStatusImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_APPLICATIONINSTANCESTATUS = "SELECT applicationInstanceStatus FROM ApplicationInstanceStatus applicationInstanceStatus";
	private static final String _SQL_SELECT_APPLICATIONINSTANCESTATUS_WHERE_PKS_IN =
		"SELECT applicationInstanceStatus FROM ApplicationInstanceStatus applicationInstanceStatus WHERE applicationInstanceStatusId IN (";
	private static final String _SQL_SELECT_APPLICATIONINSTANCESTATUS_WHERE = "SELECT applicationInstanceStatus FROM ApplicationInstanceStatus applicationInstanceStatus WHERE ";
	private static final String _SQL_COUNT_APPLICATIONINSTANCESTATUS = "SELECT COUNT(applicationInstanceStatus) FROM ApplicationInstanceStatus applicationInstanceStatus";
	private static final String _SQL_COUNT_APPLICATIONINSTANCESTATUS_WHERE = "SELECT COUNT(applicationInstanceStatus) FROM ApplicationInstanceStatus applicationInstanceStatus WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "applicationInstanceStatus.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ApplicationInstanceStatus exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ApplicationInstanceStatus exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ApplicationInstanceStatusPersistenceImpl.class);
	private static final ApplicationInstanceStatus _nullApplicationInstanceStatus =
		new ApplicationInstanceStatusImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ApplicationInstanceStatus> toCacheModel() {
				return _nullApplicationInstanceStatusCacheModel;
			}
		};

	private static final CacheModel<ApplicationInstanceStatus> _nullApplicationInstanceStatusCacheModel =
		new CacheModel<ApplicationInstanceStatus>() {
			@Override
			public ApplicationInstanceStatus toEntityModel() {
				return _nullApplicationInstanceStatus;
			}
		};
}