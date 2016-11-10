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

import at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceException;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstance;
import at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceImpl;
import at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceModelImpl;
import at.graz.meduni.bibbox.liferay.portlet.service.persistence.ApplicationInstancePersistence;

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
 * The persistence implementation for the application instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationInstancePersistence
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.ApplicationInstanceUtil
 * @generated
 */
@ProviderType
public class ApplicationInstancePersistenceImpl extends BasePersistenceImpl<ApplicationInstance>
	implements ApplicationInstancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ApplicationInstanceUtil} to access the application instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ApplicationInstanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FOLDERNAME =
		new FinderPath(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFolderName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLDERNAME =
		new FinderPath(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFolderName",
			new String[] { String.class.getName() },
			ApplicationInstanceModelImpl.FOLDERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FOLDERNAME = new FinderPath(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFolderName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the application instances where folderName = &#63;.
	 *
	 * @param folderName the folder name
	 * @return the matching application instances
	 */
	@Override
	public List<ApplicationInstance> findByFolderName(String folderName) {
		return findByFolderName(folderName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ApplicationInstance> findByFolderName(String folderName,
		int start, int end) {
		return findByFolderName(folderName, start, end, null);
	}

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
	@Override
	public List<ApplicationInstance> findByFolderName(String folderName,
		int start, int end,
		OrderByComparator<ApplicationInstance> orderByComparator) {
		return findByFolderName(folderName, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ApplicationInstance> findByFolderName(String folderName,
		int start, int end,
		OrderByComparator<ApplicationInstance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLDERNAME;
			finderArgs = new Object[] { folderName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FOLDERNAME;
			finderArgs = new Object[] { folderName, start, end, orderByComparator };
		}

		List<ApplicationInstance> list = null;

		if (retrieveFromCache) {
			list = (List<ApplicationInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ApplicationInstance applicationInstance : list) {
					if (!Objects.equals(folderName,
								applicationInstance.getFolderName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_APPLICATIONINSTANCE_WHERE);

			boolean bindFolderName = false;

			if (folderName == null) {
				query.append(_FINDER_COLUMN_FOLDERNAME_FOLDERNAME_1);
			}
			else if (folderName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FOLDERNAME_FOLDERNAME_3);
			}
			else {
				bindFolderName = true;

				query.append(_FINDER_COLUMN_FOLDERNAME_FOLDERNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApplicationInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFolderName) {
					qPos.add(folderName);
				}

				if (!pagination) {
					list = (List<ApplicationInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ApplicationInstance>)QueryUtil.list(q,
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
	 * Returns the first application instance in the ordered set where folderName = &#63;.
	 *
	 * @param folderName the folder name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application instance
	 * @throws NoSuchApplicationInstanceException if a matching application instance could not be found
	 */
	@Override
	public ApplicationInstance findByFolderName_First(String folderName,
		OrderByComparator<ApplicationInstance> orderByComparator)
		throws NoSuchApplicationInstanceException {
		ApplicationInstance applicationInstance = fetchByFolderName_First(folderName,
				orderByComparator);

		if (applicationInstance != null) {
			return applicationInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("folderName=");
		msg.append(folderName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationInstanceException(msg.toString());
	}

	/**
	 * Returns the first application instance in the ordered set where folderName = &#63;.
	 *
	 * @param folderName the folder name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application instance, or <code>null</code> if a matching application instance could not be found
	 */
	@Override
	public ApplicationInstance fetchByFolderName_First(String folderName,
		OrderByComparator<ApplicationInstance> orderByComparator) {
		List<ApplicationInstance> list = findByFolderName(folderName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last application instance in the ordered set where folderName = &#63;.
	 *
	 * @param folderName the folder name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application instance
	 * @throws NoSuchApplicationInstanceException if a matching application instance could not be found
	 */
	@Override
	public ApplicationInstance findByFolderName_Last(String folderName,
		OrderByComparator<ApplicationInstance> orderByComparator)
		throws NoSuchApplicationInstanceException {
		ApplicationInstance applicationInstance = fetchByFolderName_Last(folderName,
				orderByComparator);

		if (applicationInstance != null) {
			return applicationInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("folderName=");
		msg.append(folderName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationInstanceException(msg.toString());
	}

	/**
	 * Returns the last application instance in the ordered set where folderName = &#63;.
	 *
	 * @param folderName the folder name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application instance, or <code>null</code> if a matching application instance could not be found
	 */
	@Override
	public ApplicationInstance fetchByFolderName_Last(String folderName,
		OrderByComparator<ApplicationInstance> orderByComparator) {
		int count = countByFolderName(folderName);

		if (count == 0) {
			return null;
		}

		List<ApplicationInstance> list = findByFolderName(folderName,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the application instances before and after the current application instance in the ordered set where folderName = &#63;.
	 *
	 * @param applicationInstanceId the primary key of the current application instance
	 * @param folderName the folder name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next application instance
	 * @throws NoSuchApplicationInstanceException if a application instance with the primary key could not be found
	 */
	@Override
	public ApplicationInstance[] findByFolderName_PrevAndNext(
		long applicationInstanceId, String folderName,
		OrderByComparator<ApplicationInstance> orderByComparator)
		throws NoSuchApplicationInstanceException {
		ApplicationInstance applicationInstance = findByPrimaryKey(applicationInstanceId);

		Session session = null;

		try {
			session = openSession();

			ApplicationInstance[] array = new ApplicationInstanceImpl[3];

			array[0] = getByFolderName_PrevAndNext(session,
					applicationInstance, folderName, orderByComparator, true);

			array[1] = applicationInstance;

			array[2] = getByFolderName_PrevAndNext(session,
					applicationInstance, folderName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ApplicationInstance getByFolderName_PrevAndNext(Session session,
		ApplicationInstance applicationInstance, String folderName,
		OrderByComparator<ApplicationInstance> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPLICATIONINSTANCE_WHERE);

		boolean bindFolderName = false;

		if (folderName == null) {
			query.append(_FINDER_COLUMN_FOLDERNAME_FOLDERNAME_1);
		}
		else if (folderName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_FOLDERNAME_FOLDERNAME_3);
		}
		else {
			bindFolderName = true;

			query.append(_FINDER_COLUMN_FOLDERNAME_FOLDERNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ApplicationInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindFolderName) {
			qPos.add(folderName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(applicationInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ApplicationInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the application instances where folderName = &#63; from the database.
	 *
	 * @param folderName the folder name
	 */
	@Override
	public void removeByFolderName(String folderName) {
		for (ApplicationInstance applicationInstance : findByFolderName(
				folderName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(applicationInstance);
		}
	}

	/**
	 * Returns the number of application instances where folderName = &#63;.
	 *
	 * @param folderName the folder name
	 * @return the number of matching application instances
	 */
	@Override
	public int countByFolderName(String folderName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FOLDERNAME;

		Object[] finderArgs = new Object[] { folderName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPLICATIONINSTANCE_WHERE);

			boolean bindFolderName = false;

			if (folderName == null) {
				query.append(_FINDER_COLUMN_FOLDERNAME_FOLDERNAME_1);
			}
			else if (folderName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FOLDERNAME_FOLDERNAME_3);
			}
			else {
				bindFolderName = true;

				query.append(_FINDER_COLUMN_FOLDERNAME_FOLDERNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFolderName) {
					qPos.add(folderName);
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

	private static final String _FINDER_COLUMN_FOLDERNAME_FOLDERNAME_1 = "applicationInstance.folderName IS NULL";
	private static final String _FINDER_COLUMN_FOLDERNAME_FOLDERNAME_2 = "applicationInstance.folderName = ?";
	private static final String _FINDER_COLUMN_FOLDERNAME_FOLDERNAME_3 = "(applicationInstance.folderName IS NULL OR applicationInstance.folderName = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_INSTANCEID = new FinderPath(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstanceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByInstanceId", new String[] { String.class.getName() },
			ApplicationInstanceModelImpl.INSTANCEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INSTANCEID = new FinderPath(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInstanceId",
			new String[] { String.class.getName() });

	/**
	 * Returns the application instance where instanceId = &#63; or throws a {@link NoSuchApplicationInstanceException} if it could not be found.
	 *
	 * @param instanceId the instance ID
	 * @return the matching application instance
	 * @throws NoSuchApplicationInstanceException if a matching application instance could not be found
	 */
	@Override
	public ApplicationInstance findByInstanceId(String instanceId)
		throws NoSuchApplicationInstanceException {
		ApplicationInstance applicationInstance = fetchByInstanceId(instanceId);

		if (applicationInstance == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("instanceId=");
			msg.append(instanceId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchApplicationInstanceException(msg.toString());
		}

		return applicationInstance;
	}

	/**
	 * Returns the application instance where instanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param instanceId the instance ID
	 * @return the matching application instance, or <code>null</code> if a matching application instance could not be found
	 */
	@Override
	public ApplicationInstance fetchByInstanceId(String instanceId) {
		return fetchByInstanceId(instanceId, true);
	}

	/**
	 * Returns the application instance where instanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param instanceId the instance ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching application instance, or <code>null</code> if a matching application instance could not be found
	 */
	@Override
	public ApplicationInstance fetchByInstanceId(String instanceId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { instanceId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_INSTANCEID,
					finderArgs, this);
		}

		if (result instanceof ApplicationInstance) {
			ApplicationInstance applicationInstance = (ApplicationInstance)result;

			if (!Objects.equals(instanceId, applicationInstance.getInstanceId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_APPLICATIONINSTANCE_WHERE);

			boolean bindInstanceId = false;

			if (instanceId == null) {
				query.append(_FINDER_COLUMN_INSTANCEID_INSTANCEID_1);
			}
			else if (instanceId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_INSTANCEID_INSTANCEID_3);
			}
			else {
				bindInstanceId = true;

				query.append(_FINDER_COLUMN_INSTANCEID_INSTANCEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindInstanceId) {
					qPos.add(instanceId);
				}

				List<ApplicationInstance> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_INSTANCEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ApplicationInstancePersistenceImpl.fetchByInstanceId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ApplicationInstance applicationInstance = list.get(0);

					result = applicationInstance;

					cacheResult(applicationInstance);

					if ((applicationInstance.getInstanceId() == null) ||
							!applicationInstance.getInstanceId()
													.equals(instanceId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_INSTANCEID,
							finderArgs, applicationInstance);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_INSTANCEID,
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
			return (ApplicationInstance)result;
		}
	}

	/**
	 * Removes the application instance where instanceId = &#63; from the database.
	 *
	 * @param instanceId the instance ID
	 * @return the application instance that was removed
	 */
	@Override
	public ApplicationInstance removeByInstanceId(String instanceId)
		throws NoSuchApplicationInstanceException {
		ApplicationInstance applicationInstance = findByInstanceId(instanceId);

		return remove(applicationInstance);
	}

	/**
	 * Returns the number of application instances where instanceId = &#63;.
	 *
	 * @param instanceId the instance ID
	 * @return the number of matching application instances
	 */
	@Override
	public int countByInstanceId(String instanceId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INSTANCEID;

		Object[] finderArgs = new Object[] { instanceId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPLICATIONINSTANCE_WHERE);

			boolean bindInstanceId = false;

			if (instanceId == null) {
				query.append(_FINDER_COLUMN_INSTANCEID_INSTANCEID_1);
			}
			else if (instanceId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_INSTANCEID_INSTANCEID_3);
			}
			else {
				bindInstanceId = true;

				query.append(_FINDER_COLUMN_INSTANCEID_INSTANCEID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindInstanceId) {
					qPos.add(instanceId);
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

	private static final String _FINDER_COLUMN_INSTANCEID_INSTANCEID_1 = "applicationInstance.instanceId IS NULL";
	private static final String _FINDER_COLUMN_INSTANCEID_INSTANCEID_2 = "applicationInstance.instanceId = ?";
	private static final String _FINDER_COLUMN_INSTANCEID_INSTANCEID_3 = "(applicationInstance.instanceId IS NULL OR applicationInstance.instanceId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTANCESNOTDELETED =
		new FinderPath(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByInstancesNotDeleted",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTANCESNOTDELETED =
		new FinderPath(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByInstancesNotDeleted",
			new String[] { Boolean.class.getName() },
			ApplicationInstanceModelImpl.DELETED_COLUMN_BITMASK |
			ApplicationInstanceModelImpl.FOLDERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INSTANCESNOTDELETED = new FinderPath(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByInstancesNotDeleted",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the application instances where deleted = &#63;.
	 *
	 * @param deleted the deleted
	 * @return the matching application instances
	 */
	@Override
	public List<ApplicationInstance> findByInstancesNotDeleted(boolean deleted) {
		return findByInstancesNotDeleted(deleted, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the application instances where deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deleted the deleted
	 * @param start the lower bound of the range of application instances
	 * @param end the upper bound of the range of application instances (not inclusive)
	 * @return the range of matching application instances
	 */
	@Override
	public List<ApplicationInstance> findByInstancesNotDeleted(
		boolean deleted, int start, int end) {
		return findByInstancesNotDeleted(deleted, start, end, null);
	}

	/**
	 * Returns an ordered range of all the application instances where deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deleted the deleted
	 * @param start the lower bound of the range of application instances
	 * @param end the upper bound of the range of application instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching application instances
	 */
	@Override
	public List<ApplicationInstance> findByInstancesNotDeleted(
		boolean deleted, int start, int end,
		OrderByComparator<ApplicationInstance> orderByComparator) {
		return findByInstancesNotDeleted(deleted, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the application instances where deleted = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deleted the deleted
	 * @param start the lower bound of the range of application instances
	 * @param end the upper bound of the range of application instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching application instances
	 */
	@Override
	public List<ApplicationInstance> findByInstancesNotDeleted(
		boolean deleted, int start, int end,
		OrderByComparator<ApplicationInstance> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTANCESNOTDELETED;
			finderArgs = new Object[] { deleted };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTANCESNOTDELETED;
			finderArgs = new Object[] { deleted, start, end, orderByComparator };
		}

		List<ApplicationInstance> list = null;

		if (retrieveFromCache) {
			list = (List<ApplicationInstance>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ApplicationInstance applicationInstance : list) {
					if ((deleted != applicationInstance.getDeleted())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_APPLICATIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_INSTANCESNOTDELETED_DELETED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApplicationInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(deleted);

				if (!pagination) {
					list = (List<ApplicationInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ApplicationInstance>)QueryUtil.list(q,
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
	 * Returns the first application instance in the ordered set where deleted = &#63;.
	 *
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application instance
	 * @throws NoSuchApplicationInstanceException if a matching application instance could not be found
	 */
	@Override
	public ApplicationInstance findByInstancesNotDeleted_First(
		boolean deleted,
		OrderByComparator<ApplicationInstance> orderByComparator)
		throws NoSuchApplicationInstanceException {
		ApplicationInstance applicationInstance = fetchByInstancesNotDeleted_First(deleted,
				orderByComparator);

		if (applicationInstance != null) {
			return applicationInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deleted=");
		msg.append(deleted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationInstanceException(msg.toString());
	}

	/**
	 * Returns the first application instance in the ordered set where deleted = &#63;.
	 *
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application instance, or <code>null</code> if a matching application instance could not be found
	 */
	@Override
	public ApplicationInstance fetchByInstancesNotDeleted_First(
		boolean deleted,
		OrderByComparator<ApplicationInstance> orderByComparator) {
		List<ApplicationInstance> list = findByInstancesNotDeleted(deleted, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last application instance in the ordered set where deleted = &#63;.
	 *
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application instance
	 * @throws NoSuchApplicationInstanceException if a matching application instance could not be found
	 */
	@Override
	public ApplicationInstance findByInstancesNotDeleted_Last(boolean deleted,
		OrderByComparator<ApplicationInstance> orderByComparator)
		throws NoSuchApplicationInstanceException {
		ApplicationInstance applicationInstance = fetchByInstancesNotDeleted_Last(deleted,
				orderByComparator);

		if (applicationInstance != null) {
			return applicationInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deleted=");
		msg.append(deleted);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationInstanceException(msg.toString());
	}

	/**
	 * Returns the last application instance in the ordered set where deleted = &#63;.
	 *
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application instance, or <code>null</code> if a matching application instance could not be found
	 */
	@Override
	public ApplicationInstance fetchByInstancesNotDeleted_Last(
		boolean deleted,
		OrderByComparator<ApplicationInstance> orderByComparator) {
		int count = countByInstancesNotDeleted(deleted);

		if (count == 0) {
			return null;
		}

		List<ApplicationInstance> list = findByInstancesNotDeleted(deleted,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the application instances before and after the current application instance in the ordered set where deleted = &#63;.
	 *
	 * @param applicationInstanceId the primary key of the current application instance
	 * @param deleted the deleted
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next application instance
	 * @throws NoSuchApplicationInstanceException if a application instance with the primary key could not be found
	 */
	@Override
	public ApplicationInstance[] findByInstancesNotDeleted_PrevAndNext(
		long applicationInstanceId, boolean deleted,
		OrderByComparator<ApplicationInstance> orderByComparator)
		throws NoSuchApplicationInstanceException {
		ApplicationInstance applicationInstance = findByPrimaryKey(applicationInstanceId);

		Session session = null;

		try {
			session = openSession();

			ApplicationInstance[] array = new ApplicationInstanceImpl[3];

			array[0] = getByInstancesNotDeleted_PrevAndNext(session,
					applicationInstance, deleted, orderByComparator, true);

			array[1] = applicationInstance;

			array[2] = getByInstancesNotDeleted_PrevAndNext(session,
					applicationInstance, deleted, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ApplicationInstance getByInstancesNotDeleted_PrevAndNext(
		Session session, ApplicationInstance applicationInstance,
		boolean deleted,
		OrderByComparator<ApplicationInstance> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPLICATIONINSTANCE_WHERE);

		query.append(_FINDER_COLUMN_INSTANCESNOTDELETED_DELETED_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ApplicationInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(deleted);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(applicationInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ApplicationInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the application instances where deleted = &#63; from the database.
	 *
	 * @param deleted the deleted
	 */
	@Override
	public void removeByInstancesNotDeleted(boolean deleted) {
		for (ApplicationInstance applicationInstance : findByInstancesNotDeleted(
				deleted, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(applicationInstance);
		}
	}

	/**
	 * Returns the number of application instances where deleted = &#63;.
	 *
	 * @param deleted the deleted
	 * @return the number of matching application instances
	 */
	@Override
	public int countByInstancesNotDeleted(boolean deleted) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INSTANCESNOTDELETED;

		Object[] finderArgs = new Object[] { deleted };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPLICATIONINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_INSTANCESNOTDELETED_DELETED_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(deleted);

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

	private static final String _FINDER_COLUMN_INSTANCESNOTDELETED_DELETED_2 = "applicationInstance.deleted = ?";

	public ApplicationInstancePersistenceImpl() {
		setModelClass(ApplicationInstance.class);
	}

	/**
	 * Caches the application instance in the entity cache if it is enabled.
	 *
	 * @param applicationInstance the application instance
	 */
	@Override
	public void cacheResult(ApplicationInstance applicationInstance) {
		entityCache.putResult(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceImpl.class, applicationInstance.getPrimaryKey(),
			applicationInstance);

		finderCache.putResult(FINDER_PATH_FETCH_BY_INSTANCEID,
			new Object[] { applicationInstance.getInstanceId() },
			applicationInstance);

		applicationInstance.resetOriginalValues();
	}

	/**
	 * Caches the application instances in the entity cache if it is enabled.
	 *
	 * @param applicationInstances the application instances
	 */
	@Override
	public void cacheResult(List<ApplicationInstance> applicationInstances) {
		for (ApplicationInstance applicationInstance : applicationInstances) {
			if (entityCache.getResult(
						ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
						ApplicationInstanceImpl.class,
						applicationInstance.getPrimaryKey()) == null) {
				cacheResult(applicationInstance);
			}
			else {
				applicationInstance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all application instances.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ApplicationInstanceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the application instance.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ApplicationInstance applicationInstance) {
		entityCache.removeResult(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceImpl.class, applicationInstance.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ApplicationInstanceModelImpl)applicationInstance);
	}

	@Override
	public void clearCache(List<ApplicationInstance> applicationInstances) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ApplicationInstance applicationInstance : applicationInstances) {
			entityCache.removeResult(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
				ApplicationInstanceImpl.class,
				applicationInstance.getPrimaryKey());

			clearUniqueFindersCache((ApplicationInstanceModelImpl)applicationInstance);
		}
	}

	protected void cacheUniqueFindersCache(
		ApplicationInstanceModelImpl applicationInstanceModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					applicationInstanceModelImpl.getInstanceId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_INSTANCEID, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_INSTANCEID, args,
				applicationInstanceModelImpl);
		}
		else {
			if ((applicationInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_INSTANCEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						applicationInstanceModelImpl.getInstanceId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_INSTANCEID, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_INSTANCEID, args,
					applicationInstanceModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ApplicationInstanceModelImpl applicationInstanceModelImpl) {
		Object[] args = new Object[] {
				applicationInstanceModelImpl.getInstanceId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_INSTANCEID, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_INSTANCEID, args);

		if ((applicationInstanceModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_INSTANCEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					applicationInstanceModelImpl.getOriginalInstanceId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_INSTANCEID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_INSTANCEID, args);
		}
	}

	/**
	 * Creates a new application instance with the primary key. Does not add the application instance to the database.
	 *
	 * @param applicationInstanceId the primary key for the new application instance
	 * @return the new application instance
	 */
	@Override
	public ApplicationInstance create(long applicationInstanceId) {
		ApplicationInstance applicationInstance = new ApplicationInstanceImpl();

		applicationInstance.setNew(true);
		applicationInstance.setPrimaryKey(applicationInstanceId);

		applicationInstance.setCompanyId(companyProvider.getCompanyId());

		return applicationInstance;
	}

	/**
	 * Removes the application instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationInstanceId the primary key of the application instance
	 * @return the application instance that was removed
	 * @throws NoSuchApplicationInstanceException if a application instance with the primary key could not be found
	 */
	@Override
	public ApplicationInstance remove(long applicationInstanceId)
		throws NoSuchApplicationInstanceException {
		return remove((Serializable)applicationInstanceId);
	}

	/**
	 * Removes the application instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the application instance
	 * @return the application instance that was removed
	 * @throws NoSuchApplicationInstanceException if a application instance with the primary key could not be found
	 */
	@Override
	public ApplicationInstance remove(Serializable primaryKey)
		throws NoSuchApplicationInstanceException {
		Session session = null;

		try {
			session = openSession();

			ApplicationInstance applicationInstance = (ApplicationInstance)session.get(ApplicationInstanceImpl.class,
					primaryKey);

			if (applicationInstance == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApplicationInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(applicationInstance);
		}
		catch (NoSuchApplicationInstanceException nsee) {
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
	protected ApplicationInstance removeImpl(
		ApplicationInstance applicationInstance) {
		applicationInstance = toUnwrappedModel(applicationInstance);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(applicationInstance)) {
				applicationInstance = (ApplicationInstance)session.get(ApplicationInstanceImpl.class,
						applicationInstance.getPrimaryKeyObj());
			}

			if (applicationInstance != null) {
				session.delete(applicationInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (applicationInstance != null) {
			clearCache(applicationInstance);
		}

		return applicationInstance;
	}

	@Override
	public ApplicationInstance updateImpl(
		ApplicationInstance applicationInstance) {
		applicationInstance = toUnwrappedModel(applicationInstance);

		boolean isNew = applicationInstance.isNew();

		ApplicationInstanceModelImpl applicationInstanceModelImpl = (ApplicationInstanceModelImpl)applicationInstance;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (applicationInstance.getCreateDate() == null)) {
			if (serviceContext == null) {
				applicationInstance.setCreateDate(now);
			}
			else {
				applicationInstance.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!applicationInstanceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				applicationInstance.setModifiedDate(now);
			}
			else {
				applicationInstance.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (applicationInstance.isNew()) {
				session.save(applicationInstance);

				applicationInstance.setNew(false);
			}
			else {
				applicationInstance = (ApplicationInstance)session.merge(applicationInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ApplicationInstanceModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((applicationInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLDERNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						applicationInstanceModelImpl.getOriginalFolderName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FOLDERNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLDERNAME,
					args);

				args = new Object[] { applicationInstanceModelImpl.getFolderName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_FOLDERNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLDERNAME,
					args);
			}

			if ((applicationInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTANCESNOTDELETED.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						applicationInstanceModelImpl.getOriginalDeleted()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_INSTANCESNOTDELETED,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTANCESNOTDELETED,
					args);

				args = new Object[] { applicationInstanceModelImpl.getDeleted() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_INSTANCESNOTDELETED,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTANCESNOTDELETED,
					args);
			}
		}

		entityCache.putResult(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceImpl.class, applicationInstance.getPrimaryKey(),
			applicationInstance, false);

		clearUniqueFindersCache(applicationInstanceModelImpl);
		cacheUniqueFindersCache(applicationInstanceModelImpl, isNew);

		applicationInstance.resetOriginalValues();

		return applicationInstance;
	}

	protected ApplicationInstance toUnwrappedModel(
		ApplicationInstance applicationInstance) {
		if (applicationInstance instanceof ApplicationInstanceImpl) {
			return applicationInstance;
		}

		ApplicationInstanceImpl applicationInstanceImpl = new ApplicationInstanceImpl();

		applicationInstanceImpl.setNew(applicationInstance.isNew());
		applicationInstanceImpl.setPrimaryKey(applicationInstance.getPrimaryKey());

		applicationInstanceImpl.setApplicationInstanceId(applicationInstance.getApplicationInstanceId());
		applicationInstanceImpl.setGroupId(applicationInstance.getGroupId());
		applicationInstanceImpl.setCompanyId(applicationInstance.getCompanyId());
		applicationInstanceImpl.setUserId(applicationInstance.getUserId());
		applicationInstanceImpl.setUserName(applicationInstance.getUserName());
		applicationInstanceImpl.setCreateDate(applicationInstance.getCreateDate());
		applicationInstanceImpl.setModifiedDate(applicationInstance.getModifiedDate());
		applicationInstanceImpl.setInstanceId(applicationInstance.getInstanceId());
		applicationInstanceImpl.setName(applicationInstance.getName());
		applicationInstanceImpl.setShortName(applicationInstance.getShortName());
		applicationInstanceImpl.setBaseurl(applicationInstance.getBaseurl());
		applicationInstanceImpl.setFolderName(applicationInstance.getFolderName());
		applicationInstanceImpl.setApplication(applicationInstance.getApplication());
		applicationInstanceImpl.setVersion(applicationInstance.getVersion());
		applicationInstanceImpl.setStatus(applicationInstance.isStatus());
		applicationInstanceImpl.setDeleted(applicationInstance.isDeleted());
		applicationInstanceImpl.setShortdescription(applicationInstance.getShortdescription());
		applicationInstanceImpl.setDescription(applicationInstance.getDescription());
		applicationInstanceImpl.setMaintenance(applicationInstance.getMaintenance());
		applicationInstanceImpl.setIsmaintenance(applicationInstance.isIsmaintenance());
		applicationInstanceImpl.setInstalllog(applicationInstance.getInstalllog());

		return applicationInstanceImpl;
	}

	/**
	 * Returns the application instance with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the application instance
	 * @return the application instance
	 * @throws NoSuchApplicationInstanceException if a application instance with the primary key could not be found
	 */
	@Override
	public ApplicationInstance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchApplicationInstanceException {
		ApplicationInstance applicationInstance = fetchByPrimaryKey(primaryKey);

		if (applicationInstance == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchApplicationInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return applicationInstance;
	}

	/**
	 * Returns the application instance with the primary key or throws a {@link NoSuchApplicationInstanceException} if it could not be found.
	 *
	 * @param applicationInstanceId the primary key of the application instance
	 * @return the application instance
	 * @throws NoSuchApplicationInstanceException if a application instance with the primary key could not be found
	 */
	@Override
	public ApplicationInstance findByPrimaryKey(long applicationInstanceId)
		throws NoSuchApplicationInstanceException {
		return findByPrimaryKey((Serializable)applicationInstanceId);
	}

	/**
	 * Returns the application instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the application instance
	 * @return the application instance, or <code>null</code> if a application instance with the primary key could not be found
	 */
	@Override
	public ApplicationInstance fetchByPrimaryKey(Serializable primaryKey) {
		ApplicationInstance applicationInstance = (ApplicationInstance)entityCache.getResult(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
				ApplicationInstanceImpl.class, primaryKey);

		if (applicationInstance == _nullApplicationInstance) {
			return null;
		}

		if (applicationInstance == null) {
			Session session = null;

			try {
				session = openSession();

				applicationInstance = (ApplicationInstance)session.get(ApplicationInstanceImpl.class,
						primaryKey);

				if (applicationInstance != null) {
					cacheResult(applicationInstance);
				}
				else {
					entityCache.putResult(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
						ApplicationInstanceImpl.class, primaryKey,
						_nullApplicationInstance);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
					ApplicationInstanceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return applicationInstance;
	}

	/**
	 * Returns the application instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param applicationInstanceId the primary key of the application instance
	 * @return the application instance, or <code>null</code> if a application instance with the primary key could not be found
	 */
	@Override
	public ApplicationInstance fetchByPrimaryKey(long applicationInstanceId) {
		return fetchByPrimaryKey((Serializable)applicationInstanceId);
	}

	@Override
	public Map<Serializable, ApplicationInstance> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ApplicationInstance> map = new HashMap<Serializable, ApplicationInstance>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ApplicationInstance applicationInstance = fetchByPrimaryKey(primaryKey);

			if (applicationInstance != null) {
				map.put(primaryKey, applicationInstance);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			ApplicationInstance applicationInstance = (ApplicationInstance)entityCache.getResult(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
					ApplicationInstanceImpl.class, primaryKey);

			if (applicationInstance == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, applicationInstance);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_APPLICATIONINSTANCE_WHERE_PKS_IN);

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

			for (ApplicationInstance applicationInstance : (List<ApplicationInstance>)q.list()) {
				map.put(applicationInstance.getPrimaryKeyObj(),
					applicationInstance);

				cacheResult(applicationInstance);

				uncachedPrimaryKeys.remove(applicationInstance.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ApplicationInstanceModelImpl.ENTITY_CACHE_ENABLED,
					ApplicationInstanceImpl.class, primaryKey,
					_nullApplicationInstance);
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
	 * Returns all the application instances.
	 *
	 * @return the application instances
	 */
	@Override
	public List<ApplicationInstance> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ApplicationInstance> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ApplicationInstance> findAll(int start, int end,
		OrderByComparator<ApplicationInstance> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<ApplicationInstance> findAll(int start, int end,
		OrderByComparator<ApplicationInstance> orderByComparator,
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

		List<ApplicationInstance> list = null;

		if (retrieveFromCache) {
			list = (List<ApplicationInstance>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_APPLICATIONINSTANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPLICATIONINSTANCE;

				if (pagination) {
					sql = sql.concat(ApplicationInstanceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ApplicationInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ApplicationInstance>)QueryUtil.list(q,
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
	 * Removes all the application instances from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ApplicationInstance applicationInstance : findAll()) {
			remove(applicationInstance);
		}
	}

	/**
	 * Returns the number of application instances.
	 *
	 * @return the number of application instances
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_APPLICATIONINSTANCE);

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
		return ApplicationInstanceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the application instance persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ApplicationInstanceImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_APPLICATIONINSTANCE = "SELECT applicationInstance FROM ApplicationInstance applicationInstance";
	private static final String _SQL_SELECT_APPLICATIONINSTANCE_WHERE_PKS_IN = "SELECT applicationInstance FROM ApplicationInstance applicationInstance WHERE applicationInstanceId IN (";
	private static final String _SQL_SELECT_APPLICATIONINSTANCE_WHERE = "SELECT applicationInstance FROM ApplicationInstance applicationInstance WHERE ";
	private static final String _SQL_COUNT_APPLICATIONINSTANCE = "SELECT COUNT(applicationInstance) FROM ApplicationInstance applicationInstance";
	private static final String _SQL_COUNT_APPLICATIONINSTANCE_WHERE = "SELECT COUNT(applicationInstance) FROM ApplicationInstance applicationInstance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "applicationInstance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ApplicationInstance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ApplicationInstance exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ApplicationInstancePersistenceImpl.class);
	private static final ApplicationInstance _nullApplicationInstance = new ApplicationInstanceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ApplicationInstance> toCacheModel() {
				return _nullApplicationInstanceCacheModel;
			}
		};

	private static final CacheModel<ApplicationInstance> _nullApplicationInstanceCacheModel =
		new CacheModel<ApplicationInstance>() {
			@Override
			public ApplicationInstance toEntityModel() {
				return _nullApplicationInstance;
			}
		};
}