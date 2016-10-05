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

import at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationStoreItemException;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationStoreItem;
import at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationStoreItemImpl;
import at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationStoreItemModelImpl;
import at.graz.meduni.bibbox.liferay.portlet.service.persistence.ApplicationStoreItemPersistence;

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
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the application store item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationStoreItemPersistence
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.ApplicationStoreItemUtil
 * @generated
 */
@ProviderType
public class ApplicationStoreItemPersistenceImpl extends BasePersistenceImpl<ApplicationStoreItem>
	implements ApplicationStoreItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ApplicationStoreItemUtil} to access the application store item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ApplicationStoreItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ApplicationStoreItemModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationStoreItemModelImpl.FINDER_CACHE_ENABLED,
			ApplicationStoreItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ApplicationStoreItemModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationStoreItemModelImpl.FINDER_CACHE_ENABLED,
			ApplicationStoreItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ApplicationStoreItemModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationStoreItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_APPLICATIONNAME = new FinderPath(ApplicationStoreItemModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationStoreItemModelImpl.FINDER_CACHE_ENABLED,
			ApplicationStoreItemImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByApplicationName", new String[] { String.class.getName() },
			ApplicationStoreItemModelImpl.APPLICATIONNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICATIONNAME = new FinderPath(ApplicationStoreItemModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationStoreItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApplicationName", new String[] { String.class.getName() });

	/**
	 * Returns the application store item where applicationName = &#63; or throws a {@link NoSuchApplicationStoreItemException} if it could not be found.
	 *
	 * @param applicationName the application name
	 * @return the matching application store item
	 * @throws NoSuchApplicationStoreItemException if a matching application store item could not be found
	 */
	@Override
	public ApplicationStoreItem findByApplicationName(String applicationName)
		throws NoSuchApplicationStoreItemException {
		ApplicationStoreItem applicationStoreItem = fetchByApplicationName(applicationName);

		if (applicationStoreItem == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("applicationName=");
			msg.append(applicationName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchApplicationStoreItemException(msg.toString());
		}

		return applicationStoreItem;
	}

	/**
	 * Returns the application store item where applicationName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param applicationName the application name
	 * @return the matching application store item, or <code>null</code> if a matching application store item could not be found
	 */
	@Override
	public ApplicationStoreItem fetchByApplicationName(String applicationName) {
		return fetchByApplicationName(applicationName, true);
	}

	/**
	 * Returns the application store item where applicationName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param applicationName the application name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching application store item, or <code>null</code> if a matching application store item could not be found
	 */
	@Override
	public ApplicationStoreItem fetchByApplicationName(String applicationName,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { applicationName };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_APPLICATIONNAME,
					finderArgs, this);
		}

		if (result instanceof ApplicationStoreItem) {
			ApplicationStoreItem applicationStoreItem = (ApplicationStoreItem)result;

			if (!Objects.equals(applicationName,
						applicationStoreItem.getApplicationName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_APPLICATIONSTOREITEM_WHERE);

			boolean bindApplicationName = false;

			if (applicationName == null) {
				query.append(_FINDER_COLUMN_APPLICATIONNAME_APPLICATIONNAME_1);
			}
			else if (applicationName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICATIONNAME_APPLICATIONNAME_3);
			}
			else {
				bindApplicationName = true;

				query.append(_FINDER_COLUMN_APPLICATIONNAME_APPLICATIONNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApplicationName) {
					qPos.add(applicationName);
				}

				List<ApplicationStoreItem> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_APPLICATIONNAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ApplicationStoreItemPersistenceImpl.fetchByApplicationName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ApplicationStoreItem applicationStoreItem = list.get(0);

					result = applicationStoreItem;

					cacheResult(applicationStoreItem);

					if ((applicationStoreItem.getApplicationName() == null) ||
							!applicationStoreItem.getApplicationName()
													 .equals(applicationName)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_APPLICATIONNAME,
							finderArgs, applicationStoreItem);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_APPLICATIONNAME,
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
			return (ApplicationStoreItem)result;
		}
	}

	/**
	 * Removes the application store item where applicationName = &#63; from the database.
	 *
	 * @param applicationName the application name
	 * @return the application store item that was removed
	 */
	@Override
	public ApplicationStoreItem removeByApplicationName(String applicationName)
		throws NoSuchApplicationStoreItemException {
		ApplicationStoreItem applicationStoreItem = findByApplicationName(applicationName);

		return remove(applicationStoreItem);
	}

	/**
	 * Returns the number of application store items where applicationName = &#63;.
	 *
	 * @param applicationName the application name
	 * @return the number of matching application store items
	 */
	@Override
	public int countByApplicationName(String applicationName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPLICATIONNAME;

		Object[] finderArgs = new Object[] { applicationName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPLICATIONSTOREITEM_WHERE);

			boolean bindApplicationName = false;

			if (applicationName == null) {
				query.append(_FINDER_COLUMN_APPLICATIONNAME_APPLICATIONNAME_1);
			}
			else if (applicationName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPLICATIONNAME_APPLICATIONNAME_3);
			}
			else {
				bindApplicationName = true;

				query.append(_FINDER_COLUMN_APPLICATIONNAME_APPLICATIONNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindApplicationName) {
					qPos.add(applicationName);
				}

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

	private static final String _FINDER_COLUMN_APPLICATIONNAME_APPLICATIONNAME_1 =
		"applicationStoreItem.applicationName IS NULL";
	private static final String _FINDER_COLUMN_APPLICATIONNAME_APPLICATIONNAME_2 =
		"applicationStoreItem.applicationName = ?";
	private static final String _FINDER_COLUMN_APPLICATIONNAME_APPLICATIONNAME_3 =
		"(applicationStoreItem.applicationName IS NULL OR applicationStoreItem.applicationName = '')";

	public ApplicationStoreItemPersistenceImpl() {
		setModelClass(ApplicationStoreItem.class);
	}

	/**
	 * Caches the application store item in the entity cache if it is enabled.
	 *
	 * @param applicationStoreItem the application store item
	 */
	@Override
	public void cacheResult(ApplicationStoreItem applicationStoreItem) {
		entityCache.putResult(ApplicationStoreItemModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationStoreItemImpl.class,
			applicationStoreItem.getPrimaryKey(), applicationStoreItem);

		finderCache.putResult(FINDER_PATH_FETCH_BY_APPLICATIONNAME,
			new Object[] { applicationStoreItem.getApplicationName() },
			applicationStoreItem);

		applicationStoreItem.resetOriginalValues();
	}

	/**
	 * Caches the application store items in the entity cache if it is enabled.
	 *
	 * @param applicationStoreItems the application store items
	 */
	@Override
	public void cacheResult(List<ApplicationStoreItem> applicationStoreItems) {
		for (ApplicationStoreItem applicationStoreItem : applicationStoreItems) {
			if (entityCache.getResult(
						ApplicationStoreItemModelImpl.ENTITY_CACHE_ENABLED,
						ApplicationStoreItemImpl.class,
						applicationStoreItem.getPrimaryKey()) == null) {
				cacheResult(applicationStoreItem);
			}
			else {
				applicationStoreItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all application store items.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ApplicationStoreItemImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the application store item.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ApplicationStoreItem applicationStoreItem) {
		entityCache.removeResult(ApplicationStoreItemModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationStoreItemImpl.class, applicationStoreItem.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ApplicationStoreItemModelImpl)applicationStoreItem);
	}

	@Override
	public void clearCache(List<ApplicationStoreItem> applicationStoreItems) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ApplicationStoreItem applicationStoreItem : applicationStoreItems) {
			entityCache.removeResult(ApplicationStoreItemModelImpl.ENTITY_CACHE_ENABLED,
				ApplicationStoreItemImpl.class,
				applicationStoreItem.getPrimaryKey());

			clearUniqueFindersCache((ApplicationStoreItemModelImpl)applicationStoreItem);
		}
	}

	protected void cacheUniqueFindersCache(
		ApplicationStoreItemModelImpl applicationStoreItemModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					applicationStoreItemModelImpl.getApplicationName()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_APPLICATIONNAME, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_APPLICATIONNAME, args,
				applicationStoreItemModelImpl);
		}
		else {
			if ((applicationStoreItemModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_APPLICATIONNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						applicationStoreItemModelImpl.getApplicationName()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_APPLICATIONNAME,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_APPLICATIONNAME,
					args, applicationStoreItemModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ApplicationStoreItemModelImpl applicationStoreItemModelImpl) {
		Object[] args = new Object[] {
				applicationStoreItemModelImpl.getApplicationName()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONNAME, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_APPLICATIONNAME, args);

		if ((applicationStoreItemModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_APPLICATIONNAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					applicationStoreItemModelImpl.getOriginalApplicationName()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONNAME, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_APPLICATIONNAME, args);
		}
	}

	/**
	 * Creates a new application store item with the primary key. Does not add the application store item to the database.
	 *
	 * @param applicationStoreItemId the primary key for the new application store item
	 * @return the new application store item
	 */
	@Override
	public ApplicationStoreItem create(long applicationStoreItemId) {
		ApplicationStoreItem applicationStoreItem = new ApplicationStoreItemImpl();

		applicationStoreItem.setNew(true);
		applicationStoreItem.setPrimaryKey(applicationStoreItemId);

		applicationStoreItem.setCompanyId(companyProvider.getCompanyId());

		return applicationStoreItem;
	}

	/**
	 * Removes the application store item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationStoreItemId the primary key of the application store item
	 * @return the application store item that was removed
	 * @throws NoSuchApplicationStoreItemException if a application store item with the primary key could not be found
	 */
	@Override
	public ApplicationStoreItem remove(long applicationStoreItemId)
		throws NoSuchApplicationStoreItemException {
		return remove((Serializable)applicationStoreItemId);
	}

	/**
	 * Removes the application store item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the application store item
	 * @return the application store item that was removed
	 * @throws NoSuchApplicationStoreItemException if a application store item with the primary key could not be found
	 */
	@Override
	public ApplicationStoreItem remove(Serializable primaryKey)
		throws NoSuchApplicationStoreItemException {
		Session session = null;

		try {
			session = openSession();

			ApplicationStoreItem applicationStoreItem = (ApplicationStoreItem)session.get(ApplicationStoreItemImpl.class,
					primaryKey);

			if (applicationStoreItem == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApplicationStoreItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(applicationStoreItem);
		}
		catch (NoSuchApplicationStoreItemException nsee) {
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
	protected ApplicationStoreItem removeImpl(
		ApplicationStoreItem applicationStoreItem) {
		applicationStoreItem = toUnwrappedModel(applicationStoreItem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(applicationStoreItem)) {
				applicationStoreItem = (ApplicationStoreItem)session.get(ApplicationStoreItemImpl.class,
						applicationStoreItem.getPrimaryKeyObj());
			}

			if (applicationStoreItem != null) {
				session.delete(applicationStoreItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (applicationStoreItem != null) {
			clearCache(applicationStoreItem);
		}

		return applicationStoreItem;
	}

	@Override
	public ApplicationStoreItem updateImpl(
		ApplicationStoreItem applicationStoreItem) {
		applicationStoreItem = toUnwrappedModel(applicationStoreItem);

		boolean isNew = applicationStoreItem.isNew();

		ApplicationStoreItemModelImpl applicationStoreItemModelImpl = (ApplicationStoreItemModelImpl)applicationStoreItem;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (applicationStoreItem.getCreateDate() == null)) {
			if (serviceContext == null) {
				applicationStoreItem.setCreateDate(now);
			}
			else {
				applicationStoreItem.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!applicationStoreItemModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				applicationStoreItem.setModifiedDate(now);
			}
			else {
				applicationStoreItem.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (applicationStoreItem.isNew()) {
				session.save(applicationStoreItem);

				applicationStoreItem.setNew(false);
			}
			else {
				applicationStoreItem = (ApplicationStoreItem)session.merge(applicationStoreItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ApplicationStoreItemModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(ApplicationStoreItemModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationStoreItemImpl.class,
			applicationStoreItem.getPrimaryKey(), applicationStoreItem, false);

		clearUniqueFindersCache(applicationStoreItemModelImpl);
		cacheUniqueFindersCache(applicationStoreItemModelImpl, isNew);

		applicationStoreItem.resetOriginalValues();

		return applicationStoreItem;
	}

	protected ApplicationStoreItem toUnwrappedModel(
		ApplicationStoreItem applicationStoreItem) {
		if (applicationStoreItem instanceof ApplicationStoreItemImpl) {
			return applicationStoreItem;
		}

		ApplicationStoreItemImpl applicationStoreItemImpl = new ApplicationStoreItemImpl();

		applicationStoreItemImpl.setNew(applicationStoreItem.isNew());
		applicationStoreItemImpl.setPrimaryKey(applicationStoreItem.getPrimaryKey());

		applicationStoreItemImpl.setApplicationStoreItemId(applicationStoreItem.getApplicationStoreItemId());
		applicationStoreItemImpl.setGroupId(applicationStoreItem.getGroupId());
		applicationStoreItemImpl.setCompanyId(applicationStoreItem.getCompanyId());
		applicationStoreItemImpl.setUserId(applicationStoreItem.getUserId());
		applicationStoreItemImpl.setUserName(applicationStoreItem.getUserName());
		applicationStoreItemImpl.setCreateDate(applicationStoreItem.getCreateDate());
		applicationStoreItemImpl.setModifiedDate(applicationStoreItem.getModifiedDate());
		applicationStoreItemImpl.setGithash(applicationStoreItem.getGithash());
		applicationStoreItemImpl.setDepreciated(applicationStoreItem.getDepreciated());
		applicationStoreItemImpl.setApplicationFolderName(applicationStoreItem.getApplicationFolderName());
		applicationStoreItemImpl.setApplicationName(applicationStoreItem.getApplicationName());
		applicationStoreItemImpl.setApplicationShortName(applicationStoreItem.getApplicationShortName());
		applicationStoreItemImpl.setApplicationVersion(applicationStoreItem.getApplicationVersion());
		applicationStoreItemImpl.setApplicationReleaseState(applicationStoreItem.getApplicationReleaseState());
		applicationStoreItemImpl.setApplicationDescription(applicationStoreItem.getApplicationDescription());
		applicationStoreItemImpl.setApplicationCatalogueUrl(applicationStoreItem.getApplicationCatalogueUrl());
		applicationStoreItemImpl.setApplicationApplicationUrl(applicationStoreItem.getApplicationApplicationUrl());

		return applicationStoreItemImpl;
	}

	/**
	 * Returns the application store item with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the application store item
	 * @return the application store item
	 * @throws NoSuchApplicationStoreItemException if a application store item with the primary key could not be found
	 */
	@Override
	public ApplicationStoreItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchApplicationStoreItemException {
		ApplicationStoreItem applicationStoreItem = fetchByPrimaryKey(primaryKey);

		if (applicationStoreItem == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchApplicationStoreItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return applicationStoreItem;
	}

	/**
	 * Returns the application store item with the primary key or throws a {@link NoSuchApplicationStoreItemException} if it could not be found.
	 *
	 * @param applicationStoreItemId the primary key of the application store item
	 * @return the application store item
	 * @throws NoSuchApplicationStoreItemException if a application store item with the primary key could not be found
	 */
	@Override
	public ApplicationStoreItem findByPrimaryKey(long applicationStoreItemId)
		throws NoSuchApplicationStoreItemException {
		return findByPrimaryKey((Serializable)applicationStoreItemId);
	}

	/**
	 * Returns the application store item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the application store item
	 * @return the application store item, or <code>null</code> if a application store item with the primary key could not be found
	 */
	@Override
	public ApplicationStoreItem fetchByPrimaryKey(Serializable primaryKey) {
		ApplicationStoreItem applicationStoreItem = (ApplicationStoreItem)entityCache.getResult(ApplicationStoreItemModelImpl.ENTITY_CACHE_ENABLED,
				ApplicationStoreItemImpl.class, primaryKey);

		if (applicationStoreItem == _nullApplicationStoreItem) {
			return null;
		}

		if (applicationStoreItem == null) {
			Session session = null;

			try {
				session = openSession();

				applicationStoreItem = (ApplicationStoreItem)session.get(ApplicationStoreItemImpl.class,
						primaryKey);

				if (applicationStoreItem != null) {
					cacheResult(applicationStoreItem);
				}
				else {
					entityCache.putResult(ApplicationStoreItemModelImpl.ENTITY_CACHE_ENABLED,
						ApplicationStoreItemImpl.class, primaryKey,
						_nullApplicationStoreItem);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ApplicationStoreItemModelImpl.ENTITY_CACHE_ENABLED,
					ApplicationStoreItemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return applicationStoreItem;
	}

	/**
	 * Returns the application store item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param applicationStoreItemId the primary key of the application store item
	 * @return the application store item, or <code>null</code> if a application store item with the primary key could not be found
	 */
	@Override
	public ApplicationStoreItem fetchByPrimaryKey(long applicationStoreItemId) {
		return fetchByPrimaryKey((Serializable)applicationStoreItemId);
	}

	@Override
	public Map<Serializable, ApplicationStoreItem> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ApplicationStoreItem> map = new HashMap<Serializable, ApplicationStoreItem>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ApplicationStoreItem applicationStoreItem = fetchByPrimaryKey(primaryKey);

			if (applicationStoreItem != null) {
				map.put(primaryKey, applicationStoreItem);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			ApplicationStoreItem applicationStoreItem = (ApplicationStoreItem)entityCache.getResult(ApplicationStoreItemModelImpl.ENTITY_CACHE_ENABLED,
					ApplicationStoreItemImpl.class, primaryKey);

			if (applicationStoreItem == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, applicationStoreItem);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_APPLICATIONSTOREITEM_WHERE_PKS_IN);

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

			for (ApplicationStoreItem applicationStoreItem : (List<ApplicationStoreItem>)q.list()) {
				map.put(applicationStoreItem.getPrimaryKeyObj(),
					applicationStoreItem);

				cacheResult(applicationStoreItem);

				uncachedPrimaryKeys.remove(applicationStoreItem.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ApplicationStoreItemModelImpl.ENTITY_CACHE_ENABLED,
					ApplicationStoreItemImpl.class, primaryKey,
					_nullApplicationStoreItem);
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
	 * Returns all the application store items.
	 *
	 * @return the application store items
	 */
	@Override
	public List<ApplicationStoreItem> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the application store items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationStoreItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of application store items
	 * @param end the upper bound of the range of application store items (not inclusive)
	 * @return the range of application store items
	 */
	@Override
	public List<ApplicationStoreItem> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the application store items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationStoreItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of application store items
	 * @param end the upper bound of the range of application store items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of application store items
	 */
	@Override
	public List<ApplicationStoreItem> findAll(int start, int end,
		OrderByComparator<ApplicationStoreItem> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the application store items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationStoreItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of application store items
	 * @param end the upper bound of the range of application store items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of application store items
	 */
	@Override
	public List<ApplicationStoreItem> findAll(int start, int end,
		OrderByComparator<ApplicationStoreItem> orderByComparator,
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

		List<ApplicationStoreItem> list = null;

		if (retrieveFromCache) {
			list = (List<ApplicationStoreItem>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_APPLICATIONSTOREITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPLICATIONSTOREITEM;

				if (pagination) {
					sql = sql.concat(ApplicationStoreItemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ApplicationStoreItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ApplicationStoreItem>)QueryUtil.list(q,
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
	 * Removes all the application store items from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ApplicationStoreItem applicationStoreItem : findAll()) {
			remove(applicationStoreItem);
		}
	}

	/**
	 * Returns the number of application store items.
	 *
	 * @return the number of application store items
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_APPLICATIONSTOREITEM);

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
		return ApplicationStoreItemModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the application store item persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ApplicationStoreItemImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_APPLICATIONSTOREITEM = "SELECT applicationStoreItem FROM ApplicationStoreItem applicationStoreItem";
	private static final String _SQL_SELECT_APPLICATIONSTOREITEM_WHERE_PKS_IN = "SELECT applicationStoreItem FROM ApplicationStoreItem applicationStoreItem WHERE applicationStoreItemId IN (";
	private static final String _SQL_SELECT_APPLICATIONSTOREITEM_WHERE = "SELECT applicationStoreItem FROM ApplicationStoreItem applicationStoreItem WHERE ";
	private static final String _SQL_COUNT_APPLICATIONSTOREITEM = "SELECT COUNT(applicationStoreItem) FROM ApplicationStoreItem applicationStoreItem";
	private static final String _SQL_COUNT_APPLICATIONSTOREITEM_WHERE = "SELECT COUNT(applicationStoreItem) FROM ApplicationStoreItem applicationStoreItem WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "applicationStoreItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ApplicationStoreItem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ApplicationStoreItem exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ApplicationStoreItemPersistenceImpl.class);
	private static final ApplicationStoreItem _nullApplicationStoreItem = new ApplicationStoreItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ApplicationStoreItem> toCacheModel() {
				return _nullApplicationStoreItemCacheModel;
			}
		};

	private static final CacheModel<ApplicationStoreItem> _nullApplicationStoreItemCacheModel =
		new CacheModel<ApplicationStoreItem>() {
			@Override
			public ApplicationStoreItem toEntityModel() {
				return _nullApplicationStoreItem;
			}
		};
}