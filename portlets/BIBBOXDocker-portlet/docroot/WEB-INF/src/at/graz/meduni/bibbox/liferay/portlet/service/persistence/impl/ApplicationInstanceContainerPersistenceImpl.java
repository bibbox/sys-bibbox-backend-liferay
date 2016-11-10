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

import at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstanceContainerException;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer;
import at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceContainerImpl;
import at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceContainerModelImpl;
import at.graz.meduni.bibbox.liferay.portlet.service.persistence.ApplicationInstanceContainerPersistence;

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
 * The persistence implementation for the application instance container service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationInstanceContainerPersistence
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.ApplicationInstanceContainerUtil
 * @generated
 */
@ProviderType
public class ApplicationInstanceContainerPersistenceImpl
	extends BasePersistenceImpl<ApplicationInstanceContainer>
	implements ApplicationInstanceContainerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ApplicationInstanceContainerUtil} to access the application instance container persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ApplicationInstanceContainerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ApplicationInstanceContainerModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceContainerModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstanceContainerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ApplicationInstanceContainerModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceContainerModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstanceContainerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ApplicationInstanceContainerModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceContainerModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICATIONINSTANCE =
		new FinderPath(ApplicationInstanceContainerModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceContainerModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstanceContainerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByApplicationInstance",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONINSTANCE =
		new FinderPath(ApplicationInstanceContainerModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceContainerModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstanceContainerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByApplicationInstance", new String[] { Long.class.getName() },
			ApplicationInstanceContainerModelImpl.APPLICATIONINSTANCEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICATIONINSTANCE = new FinderPath(ApplicationInstanceContainerModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceContainerModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApplicationInstance", new String[] { Long.class.getName() });

	/**
	 * Returns all the application instance containers where applicationInstanceId = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @return the matching application instance containers
	 */
	@Override
	public List<ApplicationInstanceContainer> findByApplicationInstance(
		long applicationInstanceId) {
		return findByApplicationInstance(applicationInstanceId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ApplicationInstanceContainer> findByApplicationInstance(
		long applicationInstanceId, int start, int end) {
		return findByApplicationInstance(applicationInstanceId, start, end, null);
	}

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
	@Override
	public List<ApplicationInstanceContainer> findByApplicationInstance(
		long applicationInstanceId, int start, int end,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator) {
		return findByApplicationInstance(applicationInstanceId, start, end,
			orderByComparator, true);
	}

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
	@Override
	public List<ApplicationInstanceContainer> findByApplicationInstance(
		long applicationInstanceId, int start, int end,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONINSTANCE;
			finderArgs = new Object[] { applicationInstanceId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICATIONINSTANCE;
			finderArgs = new Object[] {
					applicationInstanceId,
					
					start, end, orderByComparator
				};
		}

		List<ApplicationInstanceContainer> list = null;

		if (retrieveFromCache) {
			list = (List<ApplicationInstanceContainer>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ApplicationInstanceContainer applicationInstanceContainer : list) {
					if ((applicationInstanceId != applicationInstanceContainer.getApplicationInstanceId())) {
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

			query.append(_SQL_SELECT_APPLICATIONINSTANCECONTAINER_WHERE);

			query.append(_FINDER_COLUMN_APPLICATIONINSTANCE_APPLICATIONINSTANCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApplicationInstanceContainerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicationInstanceId);

				if (!pagination) {
					list = (List<ApplicationInstanceContainer>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ApplicationInstanceContainer>)QueryUtil.list(q,
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
	 * Returns the first application instance container in the ordered set where applicationInstanceId = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application instance container
	 * @throws NoSuchApplicationInstanceContainerException if a matching application instance container could not be found
	 */
	@Override
	public ApplicationInstanceContainer findByApplicationInstance_First(
		long applicationInstanceId,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator)
		throws NoSuchApplicationInstanceContainerException {
		ApplicationInstanceContainer applicationInstanceContainer = fetchByApplicationInstance_First(applicationInstanceId,
				orderByComparator);

		if (applicationInstanceContainer != null) {
			return applicationInstanceContainer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationInstanceId=");
		msg.append(applicationInstanceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationInstanceContainerException(msg.toString());
	}

	/**
	 * Returns the first application instance container in the ordered set where applicationInstanceId = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application instance container, or <code>null</code> if a matching application instance container could not be found
	 */
	@Override
	public ApplicationInstanceContainer fetchByApplicationInstance_First(
		long applicationInstanceId,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator) {
		List<ApplicationInstanceContainer> list = findByApplicationInstance(applicationInstanceId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last application instance container in the ordered set where applicationInstanceId = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application instance container
	 * @throws NoSuchApplicationInstanceContainerException if a matching application instance container could not be found
	 */
	@Override
	public ApplicationInstanceContainer findByApplicationInstance_Last(
		long applicationInstanceId,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator)
		throws NoSuchApplicationInstanceContainerException {
		ApplicationInstanceContainer applicationInstanceContainer = fetchByApplicationInstance_Last(applicationInstanceId,
				orderByComparator);

		if (applicationInstanceContainer != null) {
			return applicationInstanceContainer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationInstanceId=");
		msg.append(applicationInstanceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationInstanceContainerException(msg.toString());
	}

	/**
	 * Returns the last application instance container in the ordered set where applicationInstanceId = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application instance container, or <code>null</code> if a matching application instance container could not be found
	 */
	@Override
	public ApplicationInstanceContainer fetchByApplicationInstance_Last(
		long applicationInstanceId,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator) {
		int count = countByApplicationInstance(applicationInstanceId);

		if (count == 0) {
			return null;
		}

		List<ApplicationInstanceContainer> list = findByApplicationInstance(applicationInstanceId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the application instance containers before and after the current application instance container in the ordered set where applicationInstanceId = &#63;.
	 *
	 * @param applicationInstanceContainerId the primary key of the current application instance container
	 * @param applicationInstanceId the application instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next application instance container
	 * @throws NoSuchApplicationInstanceContainerException if a application instance container with the primary key could not be found
	 */
	@Override
	public ApplicationInstanceContainer[] findByApplicationInstance_PrevAndNext(
		long applicationInstanceContainerId, long applicationInstanceId,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator)
		throws NoSuchApplicationInstanceContainerException {
		ApplicationInstanceContainer applicationInstanceContainer = findByPrimaryKey(applicationInstanceContainerId);

		Session session = null;

		try {
			session = openSession();

			ApplicationInstanceContainer[] array = new ApplicationInstanceContainerImpl[3];

			array[0] = getByApplicationInstance_PrevAndNext(session,
					applicationInstanceContainer, applicationInstanceId,
					orderByComparator, true);

			array[1] = applicationInstanceContainer;

			array[2] = getByApplicationInstance_PrevAndNext(session,
					applicationInstanceContainer, applicationInstanceId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ApplicationInstanceContainer getByApplicationInstance_PrevAndNext(
		Session session,
		ApplicationInstanceContainer applicationInstanceContainer,
		long applicationInstanceId,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator,
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

		query.append(_SQL_SELECT_APPLICATIONINSTANCECONTAINER_WHERE);

		query.append(_FINDER_COLUMN_APPLICATIONINSTANCE_APPLICATIONINSTANCEID_2);

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
			query.append(ApplicationInstanceContainerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(applicationInstanceId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(applicationInstanceContainer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ApplicationInstanceContainer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the application instance containers where applicationInstanceId = &#63; from the database.
	 *
	 * @param applicationInstanceId the application instance ID
	 */
	@Override
	public void removeByApplicationInstance(long applicationInstanceId) {
		for (ApplicationInstanceContainer applicationInstanceContainer : findByApplicationInstance(
				applicationInstanceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(applicationInstanceContainer);
		}
	}

	/**
	 * Returns the number of application instance containers where applicationInstanceId = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @return the number of matching application instance containers
	 */
	@Override
	public int countByApplicationInstance(long applicationInstanceId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPLICATIONINSTANCE;

		Object[] finderArgs = new Object[] { applicationInstanceId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPLICATIONINSTANCECONTAINER_WHERE);

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
		"applicationInstanceContainer.applicationInstanceId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICATIONINSTANCERUNNING =
		new FinderPath(ApplicationInstanceContainerModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceContainerModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstanceContainerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByApplicationInstanceRunning",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONINSTANCERUNNING =
		new FinderPath(ApplicationInstanceContainerModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceContainerModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstanceContainerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByApplicationInstanceRunning",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			ApplicationInstanceContainerModelImpl.APPLICATIONINSTANCEID_COLUMN_BITMASK |
			ApplicationInstanceContainerModelImpl.NEEDRUNNING_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICATIONINSTANCERUNNING =
		new FinderPath(ApplicationInstanceContainerModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceContainerModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApplicationInstanceRunning",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the application instance containers where applicationInstanceId = &#63; and needrunning = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param needrunning the needrunning
	 * @return the matching application instance containers
	 */
	@Override
	public List<ApplicationInstanceContainer> findByApplicationInstanceRunning(
		long applicationInstanceId, boolean needrunning) {
		return findByApplicationInstanceRunning(applicationInstanceId,
			needrunning, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ApplicationInstanceContainer> findByApplicationInstanceRunning(
		long applicationInstanceId, boolean needrunning, int start, int end) {
		return findByApplicationInstanceRunning(applicationInstanceId,
			needrunning, start, end, null);
	}

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
	@Override
	public List<ApplicationInstanceContainer> findByApplicationInstanceRunning(
		long applicationInstanceId, boolean needrunning, int start, int end,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator) {
		return findByApplicationInstanceRunning(applicationInstanceId,
			needrunning, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ApplicationInstanceContainer> findByApplicationInstanceRunning(
		long applicationInstanceId, boolean needrunning, int start, int end,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONINSTANCERUNNING;
			finderArgs = new Object[] { applicationInstanceId, needrunning };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICATIONINSTANCERUNNING;
			finderArgs = new Object[] {
					applicationInstanceId, needrunning,
					
					start, end, orderByComparator
				};
		}

		List<ApplicationInstanceContainer> list = null;

		if (retrieveFromCache) {
			list = (List<ApplicationInstanceContainer>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ApplicationInstanceContainer applicationInstanceContainer : list) {
					if ((applicationInstanceId != applicationInstanceContainer.getApplicationInstanceId()) ||
							(needrunning != applicationInstanceContainer.getNeedrunning())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_APPLICATIONINSTANCECONTAINER_WHERE);

			query.append(_FINDER_COLUMN_APPLICATIONINSTANCERUNNING_APPLICATIONINSTANCEID_2);

			query.append(_FINDER_COLUMN_APPLICATIONINSTANCERUNNING_NEEDRUNNING_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApplicationInstanceContainerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicationInstanceId);

				qPos.add(needrunning);

				if (!pagination) {
					list = (List<ApplicationInstanceContainer>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ApplicationInstanceContainer>)QueryUtil.list(q,
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
	 * Returns the first application instance container in the ordered set where applicationInstanceId = &#63; and needrunning = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param needrunning the needrunning
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application instance container
	 * @throws NoSuchApplicationInstanceContainerException if a matching application instance container could not be found
	 */
	@Override
	public ApplicationInstanceContainer findByApplicationInstanceRunning_First(
		long applicationInstanceId, boolean needrunning,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator)
		throws NoSuchApplicationInstanceContainerException {
		ApplicationInstanceContainer applicationInstanceContainer = fetchByApplicationInstanceRunning_First(applicationInstanceId,
				needrunning, orderByComparator);

		if (applicationInstanceContainer != null) {
			return applicationInstanceContainer;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationInstanceId=");
		msg.append(applicationInstanceId);

		msg.append(", needrunning=");
		msg.append(needrunning);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationInstanceContainerException(msg.toString());
	}

	/**
	 * Returns the first application instance container in the ordered set where applicationInstanceId = &#63; and needrunning = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param needrunning the needrunning
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application instance container, or <code>null</code> if a matching application instance container could not be found
	 */
	@Override
	public ApplicationInstanceContainer fetchByApplicationInstanceRunning_First(
		long applicationInstanceId, boolean needrunning,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator) {
		List<ApplicationInstanceContainer> list = findByApplicationInstanceRunning(applicationInstanceId,
				needrunning, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last application instance container in the ordered set where applicationInstanceId = &#63; and needrunning = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param needrunning the needrunning
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application instance container
	 * @throws NoSuchApplicationInstanceContainerException if a matching application instance container could not be found
	 */
	@Override
	public ApplicationInstanceContainer findByApplicationInstanceRunning_Last(
		long applicationInstanceId, boolean needrunning,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator)
		throws NoSuchApplicationInstanceContainerException {
		ApplicationInstanceContainer applicationInstanceContainer = fetchByApplicationInstanceRunning_Last(applicationInstanceId,
				needrunning, orderByComparator);

		if (applicationInstanceContainer != null) {
			return applicationInstanceContainer;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationInstanceId=");
		msg.append(applicationInstanceId);

		msg.append(", needrunning=");
		msg.append(needrunning);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationInstanceContainerException(msg.toString());
	}

	/**
	 * Returns the last application instance container in the ordered set where applicationInstanceId = &#63; and needrunning = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param needrunning the needrunning
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application instance container, or <code>null</code> if a matching application instance container could not be found
	 */
	@Override
	public ApplicationInstanceContainer fetchByApplicationInstanceRunning_Last(
		long applicationInstanceId, boolean needrunning,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator) {
		int count = countByApplicationInstanceRunning(applicationInstanceId,
				needrunning);

		if (count == 0) {
			return null;
		}

		List<ApplicationInstanceContainer> list = findByApplicationInstanceRunning(applicationInstanceId,
				needrunning, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public ApplicationInstanceContainer[] findByApplicationInstanceRunning_PrevAndNext(
		long applicationInstanceContainerId, long applicationInstanceId,
		boolean needrunning,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator)
		throws NoSuchApplicationInstanceContainerException {
		ApplicationInstanceContainer applicationInstanceContainer = findByPrimaryKey(applicationInstanceContainerId);

		Session session = null;

		try {
			session = openSession();

			ApplicationInstanceContainer[] array = new ApplicationInstanceContainerImpl[3];

			array[0] = getByApplicationInstanceRunning_PrevAndNext(session,
					applicationInstanceContainer, applicationInstanceId,
					needrunning, orderByComparator, true);

			array[1] = applicationInstanceContainer;

			array[2] = getByApplicationInstanceRunning_PrevAndNext(session,
					applicationInstanceContainer, applicationInstanceId,
					needrunning, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ApplicationInstanceContainer getByApplicationInstanceRunning_PrevAndNext(
		Session session,
		ApplicationInstanceContainer applicationInstanceContainer,
		long applicationInstanceId, boolean needrunning,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_APPLICATIONINSTANCECONTAINER_WHERE);

		query.append(_FINDER_COLUMN_APPLICATIONINSTANCERUNNING_APPLICATIONINSTANCEID_2);

		query.append(_FINDER_COLUMN_APPLICATIONINSTANCERUNNING_NEEDRUNNING_2);

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
			query.append(ApplicationInstanceContainerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(applicationInstanceId);

		qPos.add(needrunning);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(applicationInstanceContainer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ApplicationInstanceContainer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the application instance containers where applicationInstanceId = &#63; and needrunning = &#63; from the database.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param needrunning the needrunning
	 */
	@Override
	public void removeByApplicationInstanceRunning(long applicationInstanceId,
		boolean needrunning) {
		for (ApplicationInstanceContainer applicationInstanceContainer : findByApplicationInstanceRunning(
				applicationInstanceId, needrunning, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(applicationInstanceContainer);
		}
	}

	/**
	 * Returns the number of application instance containers where applicationInstanceId = &#63; and needrunning = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param needrunning the needrunning
	 * @return the number of matching application instance containers
	 */
	@Override
	public int countByApplicationInstanceRunning(long applicationInstanceId,
		boolean needrunning) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPLICATIONINSTANCERUNNING;

		Object[] finderArgs = new Object[] { applicationInstanceId, needrunning };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_APPLICATIONINSTANCECONTAINER_WHERE);

			query.append(_FINDER_COLUMN_APPLICATIONINSTANCERUNNING_APPLICATIONINSTANCEID_2);

			query.append(_FINDER_COLUMN_APPLICATIONINSTANCERUNNING_NEEDRUNNING_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicationInstanceId);

				qPos.add(needrunning);

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

	private static final String _FINDER_COLUMN_APPLICATIONINSTANCERUNNING_APPLICATIONINSTANCEID_2 =
		"applicationInstanceContainer.applicationInstanceId = ? AND ";
	private static final String _FINDER_COLUMN_APPLICATIONINSTANCERUNNING_NEEDRUNNING_2 =
		"applicationInstanceContainer.needrunning = ?";

	public ApplicationInstanceContainerPersistenceImpl() {
		setModelClass(ApplicationInstanceContainer.class);
	}

	/**
	 * Caches the application instance container in the entity cache if it is enabled.
	 *
	 * @param applicationInstanceContainer the application instance container
	 */
	@Override
	public void cacheResult(
		ApplicationInstanceContainer applicationInstanceContainer) {
		entityCache.putResult(ApplicationInstanceContainerModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceContainerImpl.class,
			applicationInstanceContainer.getPrimaryKey(),
			applicationInstanceContainer);

		applicationInstanceContainer.resetOriginalValues();
	}

	/**
	 * Caches the application instance containers in the entity cache if it is enabled.
	 *
	 * @param applicationInstanceContainers the application instance containers
	 */
	@Override
	public void cacheResult(
		List<ApplicationInstanceContainer> applicationInstanceContainers) {
		for (ApplicationInstanceContainer applicationInstanceContainer : applicationInstanceContainers) {
			if (entityCache.getResult(
						ApplicationInstanceContainerModelImpl.ENTITY_CACHE_ENABLED,
						ApplicationInstanceContainerImpl.class,
						applicationInstanceContainer.getPrimaryKey()) == null) {
				cacheResult(applicationInstanceContainer);
			}
			else {
				applicationInstanceContainer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all application instance containers.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ApplicationInstanceContainerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the application instance container.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ApplicationInstanceContainer applicationInstanceContainer) {
		entityCache.removeResult(ApplicationInstanceContainerModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceContainerImpl.class,
			applicationInstanceContainer.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ApplicationInstanceContainer> applicationInstanceContainers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ApplicationInstanceContainer applicationInstanceContainer : applicationInstanceContainers) {
			entityCache.removeResult(ApplicationInstanceContainerModelImpl.ENTITY_CACHE_ENABLED,
				ApplicationInstanceContainerImpl.class,
				applicationInstanceContainer.getPrimaryKey());
		}
	}

	/**
	 * Creates a new application instance container with the primary key. Does not add the application instance container to the database.
	 *
	 * @param applicationInstanceContainerId the primary key for the new application instance container
	 * @return the new application instance container
	 */
	@Override
	public ApplicationInstanceContainer create(
		long applicationInstanceContainerId) {
		ApplicationInstanceContainer applicationInstanceContainer = new ApplicationInstanceContainerImpl();

		applicationInstanceContainer.setNew(true);
		applicationInstanceContainer.setPrimaryKey(applicationInstanceContainerId);

		applicationInstanceContainer.setCompanyId(companyProvider.getCompanyId());

		return applicationInstanceContainer;
	}

	/**
	 * Removes the application instance container with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationInstanceContainerId the primary key of the application instance container
	 * @return the application instance container that was removed
	 * @throws NoSuchApplicationInstanceContainerException if a application instance container with the primary key could not be found
	 */
	@Override
	public ApplicationInstanceContainer remove(
		long applicationInstanceContainerId)
		throws NoSuchApplicationInstanceContainerException {
		return remove((Serializable)applicationInstanceContainerId);
	}

	/**
	 * Removes the application instance container with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the application instance container
	 * @return the application instance container that was removed
	 * @throws NoSuchApplicationInstanceContainerException if a application instance container with the primary key could not be found
	 */
	@Override
	public ApplicationInstanceContainer remove(Serializable primaryKey)
		throws NoSuchApplicationInstanceContainerException {
		Session session = null;

		try {
			session = openSession();

			ApplicationInstanceContainer applicationInstanceContainer = (ApplicationInstanceContainer)session.get(ApplicationInstanceContainerImpl.class,
					primaryKey);

			if (applicationInstanceContainer == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApplicationInstanceContainerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(applicationInstanceContainer);
		}
		catch (NoSuchApplicationInstanceContainerException nsee) {
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
	protected ApplicationInstanceContainer removeImpl(
		ApplicationInstanceContainer applicationInstanceContainer) {
		applicationInstanceContainer = toUnwrappedModel(applicationInstanceContainer);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(applicationInstanceContainer)) {
				applicationInstanceContainer = (ApplicationInstanceContainer)session.get(ApplicationInstanceContainerImpl.class,
						applicationInstanceContainer.getPrimaryKeyObj());
			}

			if (applicationInstanceContainer != null) {
				session.delete(applicationInstanceContainer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (applicationInstanceContainer != null) {
			clearCache(applicationInstanceContainer);
		}

		return applicationInstanceContainer;
	}

	@Override
	public ApplicationInstanceContainer updateImpl(
		ApplicationInstanceContainer applicationInstanceContainer) {
		applicationInstanceContainer = toUnwrappedModel(applicationInstanceContainer);

		boolean isNew = applicationInstanceContainer.isNew();

		ApplicationInstanceContainerModelImpl applicationInstanceContainerModelImpl =
			(ApplicationInstanceContainerModelImpl)applicationInstanceContainer;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (applicationInstanceContainer.getCreateDate() == null)) {
			if (serviceContext == null) {
				applicationInstanceContainer.setCreateDate(now);
			}
			else {
				applicationInstanceContainer.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!applicationInstanceContainerModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				applicationInstanceContainer.setModifiedDate(now);
			}
			else {
				applicationInstanceContainer.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (applicationInstanceContainer.isNew()) {
				session.save(applicationInstanceContainer);

				applicationInstanceContainer.setNew(false);
			}
			else {
				applicationInstanceContainer = (ApplicationInstanceContainer)session.merge(applicationInstanceContainer);
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
				!ApplicationInstanceContainerModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((applicationInstanceContainerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONINSTANCE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						applicationInstanceContainerModelImpl.getOriginalApplicationInstanceId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONINSTANCE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONINSTANCE,
					args);

				args = new Object[] {
						applicationInstanceContainerModelImpl.getApplicationInstanceId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONINSTANCE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONINSTANCE,
					args);
			}

			if ((applicationInstanceContainerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONINSTANCERUNNING.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						applicationInstanceContainerModelImpl.getOriginalApplicationInstanceId(),
						applicationInstanceContainerModelImpl.getOriginalNeedrunning()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONINSTANCERUNNING,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONINSTANCERUNNING,
					args);

				args = new Object[] {
						applicationInstanceContainerModelImpl.getApplicationInstanceId(),
						applicationInstanceContainerModelImpl.getNeedrunning()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONINSTANCERUNNING,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONINSTANCERUNNING,
					args);
			}
		}

		entityCache.putResult(ApplicationInstanceContainerModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstanceContainerImpl.class,
			applicationInstanceContainer.getPrimaryKey(),
			applicationInstanceContainer, false);

		applicationInstanceContainer.resetOriginalValues();

		return applicationInstanceContainer;
	}

	protected ApplicationInstanceContainer toUnwrappedModel(
		ApplicationInstanceContainer applicationInstanceContainer) {
		if (applicationInstanceContainer instanceof ApplicationInstanceContainerImpl) {
			return applicationInstanceContainer;
		}

		ApplicationInstanceContainerImpl applicationInstanceContainerImpl = new ApplicationInstanceContainerImpl();

		applicationInstanceContainerImpl.setNew(applicationInstanceContainer.isNew());
		applicationInstanceContainerImpl.setPrimaryKey(applicationInstanceContainer.getPrimaryKey());

		applicationInstanceContainerImpl.setApplicationInstanceContainerId(applicationInstanceContainer.getApplicationInstanceContainerId());
		applicationInstanceContainerImpl.setGroupId(applicationInstanceContainer.getGroupId());
		applicationInstanceContainerImpl.setCompanyId(applicationInstanceContainer.getCompanyId());
		applicationInstanceContainerImpl.setUserId(applicationInstanceContainer.getUserId());
		applicationInstanceContainerImpl.setUserName(applicationInstanceContainer.getUserName());
		applicationInstanceContainerImpl.setCreateDate(applicationInstanceContainer.getCreateDate());
		applicationInstanceContainerImpl.setModifiedDate(applicationInstanceContainer.getModifiedDate());
		applicationInstanceContainerImpl.setContainerName(applicationInstanceContainer.getContainerName());
		applicationInstanceContainerImpl.setNeedrunning(applicationInstanceContainer.isNeedrunning());
		applicationInstanceContainerImpl.setApplicationInstanceId(applicationInstanceContainer.getApplicationInstanceId());

		return applicationInstanceContainerImpl;
	}

	/**
	 * Returns the application instance container with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the application instance container
	 * @return the application instance container
	 * @throws NoSuchApplicationInstanceContainerException if a application instance container with the primary key could not be found
	 */
	@Override
	public ApplicationInstanceContainer findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchApplicationInstanceContainerException {
		ApplicationInstanceContainer applicationInstanceContainer = fetchByPrimaryKey(primaryKey);

		if (applicationInstanceContainer == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchApplicationInstanceContainerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return applicationInstanceContainer;
	}

	/**
	 * Returns the application instance container with the primary key or throws a {@link NoSuchApplicationInstanceContainerException} if it could not be found.
	 *
	 * @param applicationInstanceContainerId the primary key of the application instance container
	 * @return the application instance container
	 * @throws NoSuchApplicationInstanceContainerException if a application instance container with the primary key could not be found
	 */
	@Override
	public ApplicationInstanceContainer findByPrimaryKey(
		long applicationInstanceContainerId)
		throws NoSuchApplicationInstanceContainerException {
		return findByPrimaryKey((Serializable)applicationInstanceContainerId);
	}

	/**
	 * Returns the application instance container with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the application instance container
	 * @return the application instance container, or <code>null</code> if a application instance container with the primary key could not be found
	 */
	@Override
	public ApplicationInstanceContainer fetchByPrimaryKey(
		Serializable primaryKey) {
		ApplicationInstanceContainer applicationInstanceContainer = (ApplicationInstanceContainer)entityCache.getResult(ApplicationInstanceContainerModelImpl.ENTITY_CACHE_ENABLED,
				ApplicationInstanceContainerImpl.class, primaryKey);

		if (applicationInstanceContainer == _nullApplicationInstanceContainer) {
			return null;
		}

		if (applicationInstanceContainer == null) {
			Session session = null;

			try {
				session = openSession();

				applicationInstanceContainer = (ApplicationInstanceContainer)session.get(ApplicationInstanceContainerImpl.class,
						primaryKey);

				if (applicationInstanceContainer != null) {
					cacheResult(applicationInstanceContainer);
				}
				else {
					entityCache.putResult(ApplicationInstanceContainerModelImpl.ENTITY_CACHE_ENABLED,
						ApplicationInstanceContainerImpl.class, primaryKey,
						_nullApplicationInstanceContainer);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ApplicationInstanceContainerModelImpl.ENTITY_CACHE_ENABLED,
					ApplicationInstanceContainerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return applicationInstanceContainer;
	}

	/**
	 * Returns the application instance container with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param applicationInstanceContainerId the primary key of the application instance container
	 * @return the application instance container, or <code>null</code> if a application instance container with the primary key could not be found
	 */
	@Override
	public ApplicationInstanceContainer fetchByPrimaryKey(
		long applicationInstanceContainerId) {
		return fetchByPrimaryKey((Serializable)applicationInstanceContainerId);
	}

	@Override
	public Map<Serializable, ApplicationInstanceContainer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ApplicationInstanceContainer> map = new HashMap<Serializable, ApplicationInstanceContainer>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ApplicationInstanceContainer applicationInstanceContainer = fetchByPrimaryKey(primaryKey);

			if (applicationInstanceContainer != null) {
				map.put(primaryKey, applicationInstanceContainer);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			ApplicationInstanceContainer applicationInstanceContainer = (ApplicationInstanceContainer)entityCache.getResult(ApplicationInstanceContainerModelImpl.ENTITY_CACHE_ENABLED,
					ApplicationInstanceContainerImpl.class, primaryKey);

			if (applicationInstanceContainer == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, applicationInstanceContainer);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_APPLICATIONINSTANCECONTAINER_WHERE_PKS_IN);

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

			for (ApplicationInstanceContainer applicationInstanceContainer : (List<ApplicationInstanceContainer>)q.list()) {
				map.put(applicationInstanceContainer.getPrimaryKeyObj(),
					applicationInstanceContainer);

				cacheResult(applicationInstanceContainer);

				uncachedPrimaryKeys.remove(applicationInstanceContainer.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ApplicationInstanceContainerModelImpl.ENTITY_CACHE_ENABLED,
					ApplicationInstanceContainerImpl.class, primaryKey,
					_nullApplicationInstanceContainer);
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
	 * Returns all the application instance containers.
	 *
	 * @return the application instance containers
	 */
	@Override
	public List<ApplicationInstanceContainer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ApplicationInstanceContainer> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ApplicationInstanceContainer> findAll(int start, int end,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<ApplicationInstanceContainer> findAll(int start, int end,
		OrderByComparator<ApplicationInstanceContainer> orderByComparator,
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

		List<ApplicationInstanceContainer> list = null;

		if (retrieveFromCache) {
			list = (List<ApplicationInstanceContainer>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_APPLICATIONINSTANCECONTAINER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPLICATIONINSTANCECONTAINER;

				if (pagination) {
					sql = sql.concat(ApplicationInstanceContainerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ApplicationInstanceContainer>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ApplicationInstanceContainer>)QueryUtil.list(q,
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
	 * Removes all the application instance containers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ApplicationInstanceContainer applicationInstanceContainer : findAll()) {
			remove(applicationInstanceContainer);
		}
	}

	/**
	 * Returns the number of application instance containers.
	 *
	 * @return the number of application instance containers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_APPLICATIONINSTANCECONTAINER);

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
		return ApplicationInstanceContainerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the application instance container persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ApplicationInstanceContainerImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_APPLICATIONINSTANCECONTAINER = "SELECT applicationInstanceContainer FROM ApplicationInstanceContainer applicationInstanceContainer";
	private static final String _SQL_SELECT_APPLICATIONINSTANCECONTAINER_WHERE_PKS_IN =
		"SELECT applicationInstanceContainer FROM ApplicationInstanceContainer applicationInstanceContainer WHERE applicationInstanceContainerId IN (";
	private static final String _SQL_SELECT_APPLICATIONINSTANCECONTAINER_WHERE = "SELECT applicationInstanceContainer FROM ApplicationInstanceContainer applicationInstanceContainer WHERE ";
	private static final String _SQL_COUNT_APPLICATIONINSTANCECONTAINER = "SELECT COUNT(applicationInstanceContainer) FROM ApplicationInstanceContainer applicationInstanceContainer";
	private static final String _SQL_COUNT_APPLICATIONINSTANCECONTAINER_WHERE = "SELECT COUNT(applicationInstanceContainer) FROM ApplicationInstanceContainer applicationInstanceContainer WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "applicationInstanceContainer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ApplicationInstanceContainer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ApplicationInstanceContainer exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ApplicationInstanceContainerPersistenceImpl.class);
	private static final ApplicationInstanceContainer _nullApplicationInstanceContainer =
		new ApplicationInstanceContainerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ApplicationInstanceContainer> toCacheModel() {
				return _nullApplicationInstanceContainerCacheModel;
			}
		};

	private static final CacheModel<ApplicationInstanceContainer> _nullApplicationInstanceContainerCacheModel =
		new CacheModel<ApplicationInstanceContainer>() {
			@Override
			public ApplicationInstanceContainer toEntityModel() {
				return _nullApplicationInstanceContainer;
			}
		};
}