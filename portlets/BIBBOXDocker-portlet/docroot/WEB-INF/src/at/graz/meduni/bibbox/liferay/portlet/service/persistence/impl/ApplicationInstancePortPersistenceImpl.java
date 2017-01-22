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

import at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationInstancePortException;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstancePort;
import at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstancePortImpl;
import at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstancePortModelImpl;
import at.graz.meduni.bibbox.liferay.portlet.service.persistence.ApplicationInstancePortPersistence;

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
import com.liferay.portal.kernel.util.SetUtil;
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
 * The persistence implementation for the application instance port service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationInstancePortPersistence
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.ApplicationInstancePortUtil
 * @generated
 */
@ProviderType
public class ApplicationInstancePortPersistenceImpl extends BasePersistenceImpl<ApplicationInstancePort>
	implements ApplicationInstancePortPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ApplicationInstancePortUtil} to access the application instance port persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ApplicationInstancePortImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ApplicationInstancePortModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstancePortModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstancePortImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ApplicationInstancePortModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstancePortModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstancePortImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ApplicationInstancePortModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstancePortModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICATIONINSTANCE =
		new FinderPath(ApplicationInstancePortModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstancePortModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstancePortImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByApplicationInstance",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONINSTANCE =
		new FinderPath(ApplicationInstancePortModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstancePortModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstancePortImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByApplicationInstance", new String[] { Long.class.getName() },
			ApplicationInstancePortModelImpl.APPLICATIONINSTANCEID_COLUMN_BITMASK |
			ApplicationInstancePortModelImpl.PORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICATIONINSTANCE = new FinderPath(ApplicationInstancePortModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstancePortModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApplicationInstance", new String[] { Long.class.getName() });

	/**
	 * Returns all the application instance ports where applicationInstanceId = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @return the matching application instance ports
	 */
	@Override
	public List<ApplicationInstancePort> findByApplicationInstance(
		long applicationInstanceId) {
		return findByApplicationInstance(applicationInstanceId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ApplicationInstancePort> findByApplicationInstance(
		long applicationInstanceId, int start, int end) {
		return findByApplicationInstance(applicationInstanceId, start, end, null);
	}

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
	@Override
	public List<ApplicationInstancePort> findByApplicationInstance(
		long applicationInstanceId, int start, int end,
		OrderByComparator<ApplicationInstancePort> orderByComparator) {
		return findByApplicationInstance(applicationInstanceId, start, end,
			orderByComparator, true);
	}

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
	@Override
	public List<ApplicationInstancePort> findByApplicationInstance(
		long applicationInstanceId, int start, int end,
		OrderByComparator<ApplicationInstancePort> orderByComparator,
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

		List<ApplicationInstancePort> list = null;

		if (retrieveFromCache) {
			list = (List<ApplicationInstancePort>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ApplicationInstancePort applicationInstancePort : list) {
					if ((applicationInstanceId != applicationInstancePort.getApplicationInstanceId())) {
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

			query.append(_SQL_SELECT_APPLICATIONINSTANCEPORT_WHERE);

			query.append(_FINDER_COLUMN_APPLICATIONINSTANCE_APPLICATIONINSTANCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApplicationInstancePortModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicationInstanceId);

				if (!pagination) {
					list = (List<ApplicationInstancePort>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ApplicationInstancePort>)QueryUtil.list(q,
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
	 * Returns the first application instance port in the ordered set where applicationInstanceId = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application instance port
	 * @throws NoSuchApplicationInstancePortException if a matching application instance port could not be found
	 */
	@Override
	public ApplicationInstancePort findByApplicationInstance_First(
		long applicationInstanceId,
		OrderByComparator<ApplicationInstancePort> orderByComparator)
		throws NoSuchApplicationInstancePortException {
		ApplicationInstancePort applicationInstancePort = fetchByApplicationInstance_First(applicationInstanceId,
				orderByComparator);

		if (applicationInstancePort != null) {
			return applicationInstancePort;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationInstanceId=");
		msg.append(applicationInstanceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationInstancePortException(msg.toString());
	}

	/**
	 * Returns the first application instance port in the ordered set where applicationInstanceId = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application instance port, or <code>null</code> if a matching application instance port could not be found
	 */
	@Override
	public ApplicationInstancePort fetchByApplicationInstance_First(
		long applicationInstanceId,
		OrderByComparator<ApplicationInstancePort> orderByComparator) {
		List<ApplicationInstancePort> list = findByApplicationInstance(applicationInstanceId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last application instance port in the ordered set where applicationInstanceId = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application instance port
	 * @throws NoSuchApplicationInstancePortException if a matching application instance port could not be found
	 */
	@Override
	public ApplicationInstancePort findByApplicationInstance_Last(
		long applicationInstanceId,
		OrderByComparator<ApplicationInstancePort> orderByComparator)
		throws NoSuchApplicationInstancePortException {
		ApplicationInstancePort applicationInstancePort = fetchByApplicationInstance_Last(applicationInstanceId,
				orderByComparator);

		if (applicationInstancePort != null) {
			return applicationInstancePort;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationInstanceId=");
		msg.append(applicationInstanceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationInstancePortException(msg.toString());
	}

	/**
	 * Returns the last application instance port in the ordered set where applicationInstanceId = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application instance port, or <code>null</code> if a matching application instance port could not be found
	 */
	@Override
	public ApplicationInstancePort fetchByApplicationInstance_Last(
		long applicationInstanceId,
		OrderByComparator<ApplicationInstancePort> orderByComparator) {
		int count = countByApplicationInstance(applicationInstanceId);

		if (count == 0) {
			return null;
		}

		List<ApplicationInstancePort> list = findByApplicationInstance(applicationInstanceId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the application instance ports before and after the current application instance port in the ordered set where applicationInstanceId = &#63;.
	 *
	 * @param applicationInstancePortId the primary key of the current application instance port
	 * @param applicationInstanceId the application instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next application instance port
	 * @throws NoSuchApplicationInstancePortException if a application instance port with the primary key could not be found
	 */
	@Override
	public ApplicationInstancePort[] findByApplicationInstance_PrevAndNext(
		long applicationInstancePortId, long applicationInstanceId,
		OrderByComparator<ApplicationInstancePort> orderByComparator)
		throws NoSuchApplicationInstancePortException {
		ApplicationInstancePort applicationInstancePort = findByPrimaryKey(applicationInstancePortId);

		Session session = null;

		try {
			session = openSession();

			ApplicationInstancePort[] array = new ApplicationInstancePortImpl[3];

			array[0] = getByApplicationInstance_PrevAndNext(session,
					applicationInstancePort, applicationInstanceId,
					orderByComparator, true);

			array[1] = applicationInstancePort;

			array[2] = getByApplicationInstance_PrevAndNext(session,
					applicationInstancePort, applicationInstanceId,
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

	protected ApplicationInstancePort getByApplicationInstance_PrevAndNext(
		Session session, ApplicationInstancePort applicationInstancePort,
		long applicationInstanceId,
		OrderByComparator<ApplicationInstancePort> orderByComparator,
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

		query.append(_SQL_SELECT_APPLICATIONINSTANCEPORT_WHERE);

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
			query.append(ApplicationInstancePortModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(applicationInstanceId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(applicationInstancePort);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ApplicationInstancePort> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the application instance ports where applicationInstanceId = &#63; from the database.
	 *
	 * @param applicationInstanceId the application instance ID
	 */
	@Override
	public void removeByApplicationInstance(long applicationInstanceId) {
		for (ApplicationInstancePort applicationInstancePort : findByApplicationInstance(
				applicationInstanceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(applicationInstancePort);
		}
	}

	/**
	 * Returns the number of application instance ports where applicationInstanceId = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @return the number of matching application instance ports
	 */
	@Override
	public int countByApplicationInstance(long applicationInstanceId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPLICATIONINSTANCE;

		Object[] finderArgs = new Object[] { applicationInstanceId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPLICATIONINSTANCEPORT_WHERE);

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
		"applicationInstancePort.applicationInstanceId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PRIMARYAPPLICATIONINSTANCEPORT =
		new FinderPath(ApplicationInstancePortModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstancePortModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstancePortImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPrimaryApplicationInstancePort",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIMARYAPPLICATIONINSTANCEPORT =
		new FinderPath(ApplicationInstancePortModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstancePortModelImpl.FINDER_CACHE_ENABLED,
			ApplicationInstancePortImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPrimaryApplicationInstancePort",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			ApplicationInstancePortModelImpl.APPLICATIONINSTANCEID_COLUMN_BITMASK |
			ApplicationInstancePortModelImpl.PRIMARY_COLUMN_BITMASK |
			ApplicationInstancePortModelImpl.PORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PRIMARYAPPLICATIONINSTANCEPORT =
		new FinderPath(ApplicationInstancePortModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstancePortModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPrimaryApplicationInstancePort",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the application instance ports where applicationInstanceId = &#63; and primary = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param primary the primary
	 * @return the matching application instance ports
	 */
	@Override
	public List<ApplicationInstancePort> findByPrimaryApplicationInstancePort(
		long applicationInstanceId, boolean primary) {
		return findByPrimaryApplicationInstancePort(applicationInstanceId,
			primary, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ApplicationInstancePort> findByPrimaryApplicationInstancePort(
		long applicationInstanceId, boolean primary, int start, int end) {
		return findByPrimaryApplicationInstancePort(applicationInstanceId,
			primary, start, end, null);
	}

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
	@Override
	public List<ApplicationInstancePort> findByPrimaryApplicationInstancePort(
		long applicationInstanceId, boolean primary, int start, int end,
		OrderByComparator<ApplicationInstancePort> orderByComparator) {
		return findByPrimaryApplicationInstancePort(applicationInstanceId,
			primary, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ApplicationInstancePort> findByPrimaryApplicationInstancePort(
		long applicationInstanceId, boolean primary, int start, int end,
		OrderByComparator<ApplicationInstancePort> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIMARYAPPLICATIONINSTANCEPORT;
			finderArgs = new Object[] { applicationInstanceId, primary };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PRIMARYAPPLICATIONINSTANCEPORT;
			finderArgs = new Object[] {
					applicationInstanceId, primary,
					
					start, end, orderByComparator
				};
		}

		List<ApplicationInstancePort> list = null;

		if (retrieveFromCache) {
			list = (List<ApplicationInstancePort>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ApplicationInstancePort applicationInstancePort : list) {
					if ((applicationInstanceId != applicationInstancePort.getApplicationInstanceId()) ||
							(primary != applicationInstancePort.getPrimary())) {
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

			query.append(_SQL_SELECT_APPLICATIONINSTANCEPORT_WHERE);

			query.append(_FINDER_COLUMN_PRIMARYAPPLICATIONINSTANCEPORT_APPLICATIONINSTANCEID_2);

			query.append(_FINDER_COLUMN_PRIMARYAPPLICATIONINSTANCEPORT_PRIMARY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApplicationInstancePortModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicationInstanceId);

				qPos.add(primary);

				if (!pagination) {
					list = (List<ApplicationInstancePort>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ApplicationInstancePort>)QueryUtil.list(q,
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
	 * Returns the first application instance port in the ordered set where applicationInstanceId = &#63; and primary = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param primary the primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application instance port
	 * @throws NoSuchApplicationInstancePortException if a matching application instance port could not be found
	 */
	@Override
	public ApplicationInstancePort findByPrimaryApplicationInstancePort_First(
		long applicationInstanceId, boolean primary,
		OrderByComparator<ApplicationInstancePort> orderByComparator)
		throws NoSuchApplicationInstancePortException {
		ApplicationInstancePort applicationInstancePort = fetchByPrimaryApplicationInstancePort_First(applicationInstanceId,
				primary, orderByComparator);

		if (applicationInstancePort != null) {
			return applicationInstancePort;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationInstanceId=");
		msg.append(applicationInstanceId);

		msg.append(", primary=");
		msg.append(primary);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationInstancePortException(msg.toString());
	}

	/**
	 * Returns the first application instance port in the ordered set where applicationInstanceId = &#63; and primary = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param primary the primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application instance port, or <code>null</code> if a matching application instance port could not be found
	 */
	@Override
	public ApplicationInstancePort fetchByPrimaryApplicationInstancePort_First(
		long applicationInstanceId, boolean primary,
		OrderByComparator<ApplicationInstancePort> orderByComparator) {
		List<ApplicationInstancePort> list = findByPrimaryApplicationInstancePort(applicationInstanceId,
				primary, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last application instance port in the ordered set where applicationInstanceId = &#63; and primary = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param primary the primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application instance port
	 * @throws NoSuchApplicationInstancePortException if a matching application instance port could not be found
	 */
	@Override
	public ApplicationInstancePort findByPrimaryApplicationInstancePort_Last(
		long applicationInstanceId, boolean primary,
		OrderByComparator<ApplicationInstancePort> orderByComparator)
		throws NoSuchApplicationInstancePortException {
		ApplicationInstancePort applicationInstancePort = fetchByPrimaryApplicationInstancePort_Last(applicationInstanceId,
				primary, orderByComparator);

		if (applicationInstancePort != null) {
			return applicationInstancePort;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationInstanceId=");
		msg.append(applicationInstanceId);

		msg.append(", primary=");
		msg.append(primary);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationInstancePortException(msg.toString());
	}

	/**
	 * Returns the last application instance port in the ordered set where applicationInstanceId = &#63; and primary = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param primary the primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application instance port, or <code>null</code> if a matching application instance port could not be found
	 */
	@Override
	public ApplicationInstancePort fetchByPrimaryApplicationInstancePort_Last(
		long applicationInstanceId, boolean primary,
		OrderByComparator<ApplicationInstancePort> orderByComparator) {
		int count = countByPrimaryApplicationInstancePort(applicationInstanceId,
				primary);

		if (count == 0) {
			return null;
		}

		List<ApplicationInstancePort> list = findByPrimaryApplicationInstancePort(applicationInstanceId,
				primary, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public ApplicationInstancePort[] findByPrimaryApplicationInstancePort_PrevAndNext(
		long applicationInstancePortId, long applicationInstanceId,
		boolean primary,
		OrderByComparator<ApplicationInstancePort> orderByComparator)
		throws NoSuchApplicationInstancePortException {
		ApplicationInstancePort applicationInstancePort = findByPrimaryKey(applicationInstancePortId);

		Session session = null;

		try {
			session = openSession();

			ApplicationInstancePort[] array = new ApplicationInstancePortImpl[3];

			array[0] = getByPrimaryApplicationInstancePort_PrevAndNext(session,
					applicationInstancePort, applicationInstanceId, primary,
					orderByComparator, true);

			array[1] = applicationInstancePort;

			array[2] = getByPrimaryApplicationInstancePort_PrevAndNext(session,
					applicationInstancePort, applicationInstanceId, primary,
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

	protected ApplicationInstancePort getByPrimaryApplicationInstancePort_PrevAndNext(
		Session session, ApplicationInstancePort applicationInstancePort,
		long applicationInstanceId, boolean primary,
		OrderByComparator<ApplicationInstancePort> orderByComparator,
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

		query.append(_SQL_SELECT_APPLICATIONINSTANCEPORT_WHERE);

		query.append(_FINDER_COLUMN_PRIMARYAPPLICATIONINSTANCEPORT_APPLICATIONINSTANCEID_2);

		query.append(_FINDER_COLUMN_PRIMARYAPPLICATIONINSTANCEPORT_PRIMARY_2);

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
			query.append(ApplicationInstancePortModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(applicationInstanceId);

		qPos.add(primary);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(applicationInstancePort);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ApplicationInstancePort> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the application instance ports where applicationInstanceId = &#63; and primary = &#63; from the database.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param primary the primary
	 */
	@Override
	public void removeByPrimaryApplicationInstancePort(
		long applicationInstanceId, boolean primary) {
		for (ApplicationInstancePort applicationInstancePort : findByPrimaryApplicationInstancePort(
				applicationInstanceId, primary, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(applicationInstancePort);
		}
	}

	/**
	 * Returns the number of application instance ports where applicationInstanceId = &#63; and primary = &#63;.
	 *
	 * @param applicationInstanceId the application instance ID
	 * @param primary the primary
	 * @return the number of matching application instance ports
	 */
	@Override
	public int countByPrimaryApplicationInstancePort(
		long applicationInstanceId, boolean primary) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PRIMARYAPPLICATIONINSTANCEPORT;

		Object[] finderArgs = new Object[] { applicationInstanceId, primary };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_APPLICATIONINSTANCEPORT_WHERE);

			query.append(_FINDER_COLUMN_PRIMARYAPPLICATIONINSTANCEPORT_APPLICATIONINSTANCEID_2);

			query.append(_FINDER_COLUMN_PRIMARYAPPLICATIONINSTANCEPORT_PRIMARY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicationInstanceId);

				qPos.add(primary);

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

	private static final String _FINDER_COLUMN_PRIMARYAPPLICATIONINSTANCEPORT_APPLICATIONINSTANCEID_2 =
		"applicationInstancePort.applicationInstanceId = ? AND ";
	private static final String _FINDER_COLUMN_PRIMARYAPPLICATIONINSTANCEPORT_PRIMARY_2 =
		"applicationInstancePort.primary = ?";

	public ApplicationInstancePortPersistenceImpl() {
		setModelClass(ApplicationInstancePort.class);
	}

	/**
	 * Caches the application instance port in the entity cache if it is enabled.
	 *
	 * @param applicationInstancePort the application instance port
	 */
	@Override
	public void cacheResult(ApplicationInstancePort applicationInstancePort) {
		entityCache.putResult(ApplicationInstancePortModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstancePortImpl.class,
			applicationInstancePort.getPrimaryKey(), applicationInstancePort);

		applicationInstancePort.resetOriginalValues();
	}

	/**
	 * Caches the application instance ports in the entity cache if it is enabled.
	 *
	 * @param applicationInstancePorts the application instance ports
	 */
	@Override
	public void cacheResult(
		List<ApplicationInstancePort> applicationInstancePorts) {
		for (ApplicationInstancePort applicationInstancePort : applicationInstancePorts) {
			if (entityCache.getResult(
						ApplicationInstancePortModelImpl.ENTITY_CACHE_ENABLED,
						ApplicationInstancePortImpl.class,
						applicationInstancePort.getPrimaryKey()) == null) {
				cacheResult(applicationInstancePort);
			}
			else {
				applicationInstancePort.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all application instance ports.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ApplicationInstancePortImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the application instance port.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ApplicationInstancePort applicationInstancePort) {
		entityCache.removeResult(ApplicationInstancePortModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstancePortImpl.class,
			applicationInstancePort.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ApplicationInstancePort> applicationInstancePorts) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ApplicationInstancePort applicationInstancePort : applicationInstancePorts) {
			entityCache.removeResult(ApplicationInstancePortModelImpl.ENTITY_CACHE_ENABLED,
				ApplicationInstancePortImpl.class,
				applicationInstancePort.getPrimaryKey());
		}
	}

	/**
	 * Creates a new application instance port with the primary key. Does not add the application instance port to the database.
	 *
	 * @param applicationInstancePortId the primary key for the new application instance port
	 * @return the new application instance port
	 */
	@Override
	public ApplicationInstancePort create(long applicationInstancePortId) {
		ApplicationInstancePort applicationInstancePort = new ApplicationInstancePortImpl();

		applicationInstancePort.setNew(true);
		applicationInstancePort.setPrimaryKey(applicationInstancePortId);

		applicationInstancePort.setCompanyId(companyProvider.getCompanyId());

		return applicationInstancePort;
	}

	/**
	 * Removes the application instance port with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationInstancePortId the primary key of the application instance port
	 * @return the application instance port that was removed
	 * @throws NoSuchApplicationInstancePortException if a application instance port with the primary key could not be found
	 */
	@Override
	public ApplicationInstancePort remove(long applicationInstancePortId)
		throws NoSuchApplicationInstancePortException {
		return remove((Serializable)applicationInstancePortId);
	}

	/**
	 * Removes the application instance port with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the application instance port
	 * @return the application instance port that was removed
	 * @throws NoSuchApplicationInstancePortException if a application instance port with the primary key could not be found
	 */
	@Override
	public ApplicationInstancePort remove(Serializable primaryKey)
		throws NoSuchApplicationInstancePortException {
		Session session = null;

		try {
			session = openSession();

			ApplicationInstancePort applicationInstancePort = (ApplicationInstancePort)session.get(ApplicationInstancePortImpl.class,
					primaryKey);

			if (applicationInstancePort == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApplicationInstancePortException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(applicationInstancePort);
		}
		catch (NoSuchApplicationInstancePortException nsee) {
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
	protected ApplicationInstancePort removeImpl(
		ApplicationInstancePort applicationInstancePort) {
		applicationInstancePort = toUnwrappedModel(applicationInstancePort);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(applicationInstancePort)) {
				applicationInstancePort = (ApplicationInstancePort)session.get(ApplicationInstancePortImpl.class,
						applicationInstancePort.getPrimaryKeyObj());
			}

			if (applicationInstancePort != null) {
				session.delete(applicationInstancePort);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (applicationInstancePort != null) {
			clearCache(applicationInstancePort);
		}

		return applicationInstancePort;
	}

	@Override
	public ApplicationInstancePort updateImpl(
		ApplicationInstancePort applicationInstancePort) {
		applicationInstancePort = toUnwrappedModel(applicationInstancePort);

		boolean isNew = applicationInstancePort.isNew();

		ApplicationInstancePortModelImpl applicationInstancePortModelImpl = (ApplicationInstancePortModelImpl)applicationInstancePort;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (applicationInstancePort.getCreateDate() == null)) {
			if (serviceContext == null) {
				applicationInstancePort.setCreateDate(now);
			}
			else {
				applicationInstancePort.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!applicationInstancePortModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				applicationInstancePort.setModifiedDate(now);
			}
			else {
				applicationInstancePort.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (applicationInstancePort.isNew()) {
				session.save(applicationInstancePort);

				applicationInstancePort.setNew(false);
			}
			else {
				applicationInstancePort = (ApplicationInstancePort)session.merge(applicationInstancePort);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ApplicationInstancePortModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((applicationInstancePortModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONINSTANCE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						applicationInstancePortModelImpl.getOriginalApplicationInstanceId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONINSTANCE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONINSTANCE,
					args);

				args = new Object[] {
						applicationInstancePortModelImpl.getApplicationInstanceId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONINSTANCE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONINSTANCE,
					args);
			}

			if ((applicationInstancePortModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIMARYAPPLICATIONINSTANCEPORT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						applicationInstancePortModelImpl.getOriginalApplicationInstanceId(),
						applicationInstancePortModelImpl.getOriginalPrimary()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PRIMARYAPPLICATIONINSTANCEPORT,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIMARYAPPLICATIONINSTANCEPORT,
					args);

				args = new Object[] {
						applicationInstancePortModelImpl.getApplicationInstanceId(),
						applicationInstancePortModelImpl.getPrimary()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PRIMARYAPPLICATIONINSTANCEPORT,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PRIMARYAPPLICATIONINSTANCEPORT,
					args);
			}
		}

		entityCache.putResult(ApplicationInstancePortModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationInstancePortImpl.class,
			applicationInstancePort.getPrimaryKey(), applicationInstancePort,
			false);

		applicationInstancePort.resetOriginalValues();

		return applicationInstancePort;
	}

	protected ApplicationInstancePort toUnwrappedModel(
		ApplicationInstancePort applicationInstancePort) {
		if (applicationInstancePort instanceof ApplicationInstancePortImpl) {
			return applicationInstancePort;
		}

		ApplicationInstancePortImpl applicationInstancePortImpl = new ApplicationInstancePortImpl();

		applicationInstancePortImpl.setNew(applicationInstancePort.isNew());
		applicationInstancePortImpl.setPrimaryKey(applicationInstancePort.getPrimaryKey());

		applicationInstancePortImpl.setApplicationInstancePortId(applicationInstancePort.getApplicationInstancePortId());
		applicationInstancePortImpl.setGroupId(applicationInstancePort.getGroupId());
		applicationInstancePortImpl.setCompanyId(applicationInstancePort.getCompanyId());
		applicationInstancePortImpl.setUserId(applicationInstancePort.getUserId());
		applicationInstancePortImpl.setUserName(applicationInstancePort.getUserName());
		applicationInstancePortImpl.setCreateDate(applicationInstancePort.getCreateDate());
		applicationInstancePortImpl.setModifiedDate(applicationInstancePort.getModifiedDate());
		applicationInstancePortImpl.setPort(applicationInstancePort.getPort());
		applicationInstancePortImpl.setPortId(applicationInstancePort.getPortId());
		applicationInstancePortImpl.setPrimary(applicationInstancePort.isPrimary());
		applicationInstancePortImpl.setSubdomain(applicationInstancePort.getSubdomain());
		applicationInstancePortImpl.setApplicationInstanceId(applicationInstancePort.getApplicationInstanceId());

		return applicationInstancePortImpl;
	}

	/**
	 * Returns the application instance port with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the application instance port
	 * @return the application instance port
	 * @throws NoSuchApplicationInstancePortException if a application instance port with the primary key could not be found
	 */
	@Override
	public ApplicationInstancePort findByPrimaryKey(Serializable primaryKey)
		throws NoSuchApplicationInstancePortException {
		ApplicationInstancePort applicationInstancePort = fetchByPrimaryKey(primaryKey);

		if (applicationInstancePort == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchApplicationInstancePortException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return applicationInstancePort;
	}

	/**
	 * Returns the application instance port with the primary key or throws a {@link NoSuchApplicationInstancePortException} if it could not be found.
	 *
	 * @param applicationInstancePortId the primary key of the application instance port
	 * @return the application instance port
	 * @throws NoSuchApplicationInstancePortException if a application instance port with the primary key could not be found
	 */
	@Override
	public ApplicationInstancePort findByPrimaryKey(
		long applicationInstancePortId)
		throws NoSuchApplicationInstancePortException {
		return findByPrimaryKey((Serializable)applicationInstancePortId);
	}

	/**
	 * Returns the application instance port with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the application instance port
	 * @return the application instance port, or <code>null</code> if a application instance port with the primary key could not be found
	 */
	@Override
	public ApplicationInstancePort fetchByPrimaryKey(Serializable primaryKey) {
		ApplicationInstancePort applicationInstancePort = (ApplicationInstancePort)entityCache.getResult(ApplicationInstancePortModelImpl.ENTITY_CACHE_ENABLED,
				ApplicationInstancePortImpl.class, primaryKey);

		if (applicationInstancePort == _nullApplicationInstancePort) {
			return null;
		}

		if (applicationInstancePort == null) {
			Session session = null;

			try {
				session = openSession();

				applicationInstancePort = (ApplicationInstancePort)session.get(ApplicationInstancePortImpl.class,
						primaryKey);

				if (applicationInstancePort != null) {
					cacheResult(applicationInstancePort);
				}
				else {
					entityCache.putResult(ApplicationInstancePortModelImpl.ENTITY_CACHE_ENABLED,
						ApplicationInstancePortImpl.class, primaryKey,
						_nullApplicationInstancePort);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ApplicationInstancePortModelImpl.ENTITY_CACHE_ENABLED,
					ApplicationInstancePortImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return applicationInstancePort;
	}

	/**
	 * Returns the application instance port with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param applicationInstancePortId the primary key of the application instance port
	 * @return the application instance port, or <code>null</code> if a application instance port with the primary key could not be found
	 */
	@Override
	public ApplicationInstancePort fetchByPrimaryKey(
		long applicationInstancePortId) {
		return fetchByPrimaryKey((Serializable)applicationInstancePortId);
	}

	@Override
	public Map<Serializable, ApplicationInstancePort> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ApplicationInstancePort> map = new HashMap<Serializable, ApplicationInstancePort>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ApplicationInstancePort applicationInstancePort = fetchByPrimaryKey(primaryKey);

			if (applicationInstancePort != null) {
				map.put(primaryKey, applicationInstancePort);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			ApplicationInstancePort applicationInstancePort = (ApplicationInstancePort)entityCache.getResult(ApplicationInstancePortModelImpl.ENTITY_CACHE_ENABLED,
					ApplicationInstancePortImpl.class, primaryKey);

			if (applicationInstancePort == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, applicationInstancePort);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_APPLICATIONINSTANCEPORT_WHERE_PKS_IN);

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

			for (ApplicationInstancePort applicationInstancePort : (List<ApplicationInstancePort>)q.list()) {
				map.put(applicationInstancePort.getPrimaryKeyObj(),
					applicationInstancePort);

				cacheResult(applicationInstancePort);

				uncachedPrimaryKeys.remove(applicationInstancePort.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ApplicationInstancePortModelImpl.ENTITY_CACHE_ENABLED,
					ApplicationInstancePortImpl.class, primaryKey,
					_nullApplicationInstancePort);
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
	 * Returns all the application instance ports.
	 *
	 * @return the application instance ports
	 */
	@Override
	public List<ApplicationInstancePort> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ApplicationInstancePort> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ApplicationInstancePort> findAll(int start, int end,
		OrderByComparator<ApplicationInstancePort> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<ApplicationInstancePort> findAll(int start, int end,
		OrderByComparator<ApplicationInstancePort> orderByComparator,
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

		List<ApplicationInstancePort> list = null;

		if (retrieveFromCache) {
			list = (List<ApplicationInstancePort>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_APPLICATIONINSTANCEPORT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPLICATIONINSTANCEPORT;

				if (pagination) {
					sql = sql.concat(ApplicationInstancePortModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ApplicationInstancePort>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ApplicationInstancePort>)QueryUtil.list(q,
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
	 * Removes all the application instance ports from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ApplicationInstancePort applicationInstancePort : findAll()) {
			remove(applicationInstancePort);
		}
	}

	/**
	 * Returns the number of application instance ports.
	 *
	 * @return the number of application instance ports
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_APPLICATIONINSTANCEPORT);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ApplicationInstancePortModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the application instance port persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ApplicationInstancePortImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_APPLICATIONINSTANCEPORT = "SELECT applicationInstancePort FROM ApplicationInstancePort applicationInstancePort";
	private static final String _SQL_SELECT_APPLICATIONINSTANCEPORT_WHERE_PKS_IN =
		"SELECT applicationInstancePort FROM ApplicationInstancePort applicationInstancePort WHERE applicationInstancePortId IN (";
	private static final String _SQL_SELECT_APPLICATIONINSTANCEPORT_WHERE = "SELECT applicationInstancePort FROM ApplicationInstancePort applicationInstancePort WHERE ";
	private static final String _SQL_COUNT_APPLICATIONINSTANCEPORT = "SELECT COUNT(applicationInstancePort) FROM ApplicationInstancePort applicationInstancePort";
	private static final String _SQL_COUNT_APPLICATIONINSTANCEPORT_WHERE = "SELECT COUNT(applicationInstancePort) FROM ApplicationInstancePort applicationInstancePort WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "applicationInstancePort.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ApplicationInstancePort exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ApplicationInstancePort exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ApplicationInstancePortPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"primary"
			});
	private static final ApplicationInstancePort _nullApplicationInstancePort = new ApplicationInstancePortImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ApplicationInstancePort> toCacheModel() {
				return _nullApplicationInstancePortCacheModel;
			}
		};

	private static final CacheModel<ApplicationInstancePort> _nullApplicationInstancePortCacheModel =
		new CacheModel<ApplicationInstancePort>() {
			@Override
			public ApplicationInstancePort toEntityModel() {
				return _nullApplicationInstancePort;
			}
		};
}