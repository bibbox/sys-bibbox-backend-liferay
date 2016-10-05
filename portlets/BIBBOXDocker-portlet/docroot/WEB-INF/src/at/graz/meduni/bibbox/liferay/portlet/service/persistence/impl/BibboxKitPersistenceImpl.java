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

import at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchBibboxKitException;
import at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit;
import at.graz.meduni.bibbox.liferay.portlet.model.impl.BibboxKitImpl;
import at.graz.meduni.bibbox.liferay.portlet.model.impl.BibboxKitModelImpl;
import at.graz.meduni.bibbox.liferay.portlet.service.persistence.BibboxKitPersistence;

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
 * The persistence implementation for the bibbox kit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see BibboxKitPersistence
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.BibboxKitUtil
 * @generated
 */
@ProviderType
public class BibboxKitPersistenceImpl extends BasePersistenceImpl<BibboxKit>
	implements BibboxKitPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BibboxKitUtil} to access the bibbox kit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BibboxKitImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
			BibboxKitModelImpl.FINDER_CACHE_ENABLED, BibboxKitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
			BibboxKitModelImpl.FINDER_CACHE_ENABLED, BibboxKitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
			BibboxKitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICATIONSTOREITEMID =
		new FinderPath(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
			BibboxKitModelImpl.FINDER_CACHE_ENABLED, BibboxKitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByApplicationStoreItemId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONSTOREITEMID =
		new FinderPath(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
			BibboxKitModelImpl.FINDER_CACHE_ENABLED, BibboxKitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByApplicationStoreItemId",
			new String[] { Long.class.getName() },
			BibboxKitModelImpl.APPLICATIONSTOREITEMID_COLUMN_BITMASK |
			BibboxKitModelImpl.KITNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICATIONSTOREITEMID = new FinderPath(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
			BibboxKitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApplicationStoreItemId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the bibbox kits where applicationStoreItemId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @return the matching bibbox kits
	 */
	@Override
	public List<BibboxKit> findByApplicationStoreItemId(
		long applicationStoreItemId) {
		return findByApplicationStoreItemId(applicationStoreItemId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bibbox kits where applicationStoreItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param start the lower bound of the range of bibbox kits
	 * @param end the upper bound of the range of bibbox kits (not inclusive)
	 * @return the range of matching bibbox kits
	 */
	@Override
	public List<BibboxKit> findByApplicationStoreItemId(
		long applicationStoreItemId, int start, int end) {
		return findByApplicationStoreItemId(applicationStoreItemId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the bibbox kits where applicationStoreItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param start the lower bound of the range of bibbox kits
	 * @param end the upper bound of the range of bibbox kits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bibbox kits
	 */
	@Override
	public List<BibboxKit> findByApplicationStoreItemId(
		long applicationStoreItemId, int start, int end,
		OrderByComparator<BibboxKit> orderByComparator) {
		return findByApplicationStoreItemId(applicationStoreItemId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bibbox kits where applicationStoreItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param start the lower bound of the range of bibbox kits
	 * @param end the upper bound of the range of bibbox kits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bibbox kits
	 */
	@Override
	public List<BibboxKit> findByApplicationStoreItemId(
		long applicationStoreItemId, int start, int end,
		OrderByComparator<BibboxKit> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONSTOREITEMID;
			finderArgs = new Object[] { applicationStoreItemId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICATIONSTOREITEMID;
			finderArgs = new Object[] {
					applicationStoreItemId,
					
					start, end, orderByComparator
				};
		}

		List<BibboxKit> list = null;

		if (retrieveFromCache) {
			list = (List<BibboxKit>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BibboxKit bibboxKit : list) {
					if ((applicationStoreItemId != bibboxKit.getApplicationStoreItemId())) {
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

			query.append(_SQL_SELECT_BIBBOXKIT_WHERE);

			query.append(_FINDER_COLUMN_APPLICATIONSTOREITEMID_APPLICATIONSTOREITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BibboxKitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicationStoreItemId);

				if (!pagination) {
					list = (List<BibboxKit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BibboxKit>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first bibbox kit in the ordered set where applicationStoreItemId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bibbox kit
	 * @throws NoSuchBibboxKitException if a matching bibbox kit could not be found
	 */
	@Override
	public BibboxKit findByApplicationStoreItemId_First(
		long applicationStoreItemId,
		OrderByComparator<BibboxKit> orderByComparator)
		throws NoSuchBibboxKitException {
		BibboxKit bibboxKit = fetchByApplicationStoreItemId_First(applicationStoreItemId,
				orderByComparator);

		if (bibboxKit != null) {
			return bibboxKit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationStoreItemId=");
		msg.append(applicationStoreItemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBibboxKitException(msg.toString());
	}

	/**
	 * Returns the first bibbox kit in the ordered set where applicationStoreItemId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bibbox kit, or <code>null</code> if a matching bibbox kit could not be found
	 */
	@Override
	public BibboxKit fetchByApplicationStoreItemId_First(
		long applicationStoreItemId,
		OrderByComparator<BibboxKit> orderByComparator) {
		List<BibboxKit> list = findByApplicationStoreItemId(applicationStoreItemId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bibbox kit in the ordered set where applicationStoreItemId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bibbox kit
	 * @throws NoSuchBibboxKitException if a matching bibbox kit could not be found
	 */
	@Override
	public BibboxKit findByApplicationStoreItemId_Last(
		long applicationStoreItemId,
		OrderByComparator<BibboxKit> orderByComparator)
		throws NoSuchBibboxKitException {
		BibboxKit bibboxKit = fetchByApplicationStoreItemId_Last(applicationStoreItemId,
				orderByComparator);

		if (bibboxKit != null) {
			return bibboxKit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationStoreItemId=");
		msg.append(applicationStoreItemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBibboxKitException(msg.toString());
	}

	/**
	 * Returns the last bibbox kit in the ordered set where applicationStoreItemId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bibbox kit, or <code>null</code> if a matching bibbox kit could not be found
	 */
	@Override
	public BibboxKit fetchByApplicationStoreItemId_Last(
		long applicationStoreItemId,
		OrderByComparator<BibboxKit> orderByComparator) {
		int count = countByApplicationStoreItemId(applicationStoreItemId);

		if (count == 0) {
			return null;
		}

		List<BibboxKit> list = findByApplicationStoreItemId(applicationStoreItemId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bibbox kits before and after the current bibbox kit in the ordered set where applicationStoreItemId = &#63;.
	 *
	 * @param bibboxKitId the primary key of the current bibbox kit
	 * @param applicationStoreItemId the application store item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bibbox kit
	 * @throws NoSuchBibboxKitException if a bibbox kit with the primary key could not be found
	 */
	@Override
	public BibboxKit[] findByApplicationStoreItemId_PrevAndNext(
		long bibboxKitId, long applicationStoreItemId,
		OrderByComparator<BibboxKit> orderByComparator)
		throws NoSuchBibboxKitException {
		BibboxKit bibboxKit = findByPrimaryKey(bibboxKitId);

		Session session = null;

		try {
			session = openSession();

			BibboxKit[] array = new BibboxKitImpl[3];

			array[0] = getByApplicationStoreItemId_PrevAndNext(session,
					bibboxKit, applicationStoreItemId, orderByComparator, true);

			array[1] = bibboxKit;

			array[2] = getByApplicationStoreItemId_PrevAndNext(session,
					bibboxKit, applicationStoreItemId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BibboxKit getByApplicationStoreItemId_PrevAndNext(
		Session session, BibboxKit bibboxKit, long applicationStoreItemId,
		OrderByComparator<BibboxKit> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BIBBOXKIT_WHERE);

		query.append(_FINDER_COLUMN_APPLICATIONSTOREITEMID_APPLICATIONSTOREITEMID_2);

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
			query.append(BibboxKitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(applicationStoreItemId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bibboxKit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BibboxKit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bibbox kits where applicationStoreItemId = &#63; from the database.
	 *
	 * @param applicationStoreItemId the application store item ID
	 */
	@Override
	public void removeByApplicationStoreItemId(long applicationStoreItemId) {
		for (BibboxKit bibboxKit : findByApplicationStoreItemId(
				applicationStoreItemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(bibboxKit);
		}
	}

	/**
	 * Returns the number of bibbox kits where applicationStoreItemId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @return the number of matching bibbox kits
	 */
	@Override
	public int countByApplicationStoreItemId(long applicationStoreItemId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPLICATIONSTOREITEMID;

		Object[] finderArgs = new Object[] { applicationStoreItemId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BIBBOXKIT_WHERE);

			query.append(_FINDER_COLUMN_APPLICATIONSTOREITEMID_APPLICATIONSTOREITEMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicationStoreItemId);

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

	private static final String _FINDER_COLUMN_APPLICATIONSTOREITEMID_APPLICATIONSTOREITEMID_2 =
		"bibboxKit.applicationStoreItemId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_KITNAMES = new FinderPath(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
			BibboxKitModelImpl.FINDER_CACHE_ENABLED, BibboxKitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByKitNames",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KITNAMES =
		new FinderPath(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
			BibboxKitModelImpl.FINDER_CACHE_ENABLED, BibboxKitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByKitNames",
			new String[] { String.class.getName() },
			BibboxKitModelImpl.KITNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_KITNAMES = new FinderPath(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
			BibboxKitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKitNames",
			new String[] { String.class.getName() });

	/**
	 * Returns all the bibbox kits where kitName = &#63;.
	 *
	 * @param kitName the kit name
	 * @return the matching bibbox kits
	 */
	@Override
	public List<BibboxKit> findByKitNames(String kitName) {
		return findByKitNames(kitName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the bibbox kits where kitName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param kitName the kit name
	 * @param start the lower bound of the range of bibbox kits
	 * @param end the upper bound of the range of bibbox kits (not inclusive)
	 * @return the range of matching bibbox kits
	 */
	@Override
	public List<BibboxKit> findByKitNames(String kitName, int start, int end) {
		return findByKitNames(kitName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bibbox kits where kitName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param kitName the kit name
	 * @param start the lower bound of the range of bibbox kits
	 * @param end the upper bound of the range of bibbox kits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bibbox kits
	 */
	@Override
	public List<BibboxKit> findByKitNames(String kitName, int start, int end,
		OrderByComparator<BibboxKit> orderByComparator) {
		return findByKitNames(kitName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bibbox kits where kitName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param kitName the kit name
	 * @param start the lower bound of the range of bibbox kits
	 * @param end the upper bound of the range of bibbox kits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching bibbox kits
	 */
	@Override
	public List<BibboxKit> findByKitNames(String kitName, int start, int end,
		OrderByComparator<BibboxKit> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KITNAMES;
			finderArgs = new Object[] { kitName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_KITNAMES;
			finderArgs = new Object[] { kitName, start, end, orderByComparator };
		}

		List<BibboxKit> list = null;

		if (retrieveFromCache) {
			list = (List<BibboxKit>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BibboxKit bibboxKit : list) {
					if (!Objects.equals(kitName, bibboxKit.getKitName())) {
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

			query.append(_SQL_SELECT_BIBBOXKIT_WHERE);

			boolean bindKitName = false;

			if (kitName == null) {
				query.append(_FINDER_COLUMN_KITNAMES_KITNAME_1);
			}
			else if (kitName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KITNAMES_KITNAME_3);
			}
			else {
				bindKitName = true;

				query.append(_FINDER_COLUMN_KITNAMES_KITNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BibboxKitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKitName) {
					qPos.add(kitName);
				}

				if (!pagination) {
					list = (List<BibboxKit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BibboxKit>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first bibbox kit in the ordered set where kitName = &#63;.
	 *
	 * @param kitName the kit name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bibbox kit
	 * @throws NoSuchBibboxKitException if a matching bibbox kit could not be found
	 */
	@Override
	public BibboxKit findByKitNames_First(String kitName,
		OrderByComparator<BibboxKit> orderByComparator)
		throws NoSuchBibboxKitException {
		BibboxKit bibboxKit = fetchByKitNames_First(kitName, orderByComparator);

		if (bibboxKit != null) {
			return bibboxKit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("kitName=");
		msg.append(kitName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBibboxKitException(msg.toString());
	}

	/**
	 * Returns the first bibbox kit in the ordered set where kitName = &#63;.
	 *
	 * @param kitName the kit name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bibbox kit, or <code>null</code> if a matching bibbox kit could not be found
	 */
	@Override
	public BibboxKit fetchByKitNames_First(String kitName,
		OrderByComparator<BibboxKit> orderByComparator) {
		List<BibboxKit> list = findByKitNames(kitName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bibbox kit in the ordered set where kitName = &#63;.
	 *
	 * @param kitName the kit name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bibbox kit
	 * @throws NoSuchBibboxKitException if a matching bibbox kit could not be found
	 */
	@Override
	public BibboxKit findByKitNames_Last(String kitName,
		OrderByComparator<BibboxKit> orderByComparator)
		throws NoSuchBibboxKitException {
		BibboxKit bibboxKit = fetchByKitNames_Last(kitName, orderByComparator);

		if (bibboxKit != null) {
			return bibboxKit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("kitName=");
		msg.append(kitName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBibboxKitException(msg.toString());
	}

	/**
	 * Returns the last bibbox kit in the ordered set where kitName = &#63;.
	 *
	 * @param kitName the kit name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bibbox kit, or <code>null</code> if a matching bibbox kit could not be found
	 */
	@Override
	public BibboxKit fetchByKitNames_Last(String kitName,
		OrderByComparator<BibboxKit> orderByComparator) {
		int count = countByKitNames(kitName);

		if (count == 0) {
			return null;
		}

		List<BibboxKit> list = findByKitNames(kitName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bibbox kits before and after the current bibbox kit in the ordered set where kitName = &#63;.
	 *
	 * @param bibboxKitId the primary key of the current bibbox kit
	 * @param kitName the kit name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bibbox kit
	 * @throws NoSuchBibboxKitException if a bibbox kit with the primary key could not be found
	 */
	@Override
	public BibboxKit[] findByKitNames_PrevAndNext(long bibboxKitId,
		String kitName, OrderByComparator<BibboxKit> orderByComparator)
		throws NoSuchBibboxKitException {
		BibboxKit bibboxKit = findByPrimaryKey(bibboxKitId);

		Session session = null;

		try {
			session = openSession();

			BibboxKit[] array = new BibboxKitImpl[3];

			array[0] = getByKitNames_PrevAndNext(session, bibboxKit, kitName,
					orderByComparator, true);

			array[1] = bibboxKit;

			array[2] = getByKitNames_PrevAndNext(session, bibboxKit, kitName,
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

	protected BibboxKit getByKitNames_PrevAndNext(Session session,
		BibboxKit bibboxKit, String kitName,
		OrderByComparator<BibboxKit> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BIBBOXKIT_WHERE);

		boolean bindKitName = false;

		if (kitName == null) {
			query.append(_FINDER_COLUMN_KITNAMES_KITNAME_1);
		}
		else if (kitName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_KITNAMES_KITNAME_3);
		}
		else {
			bindKitName = true;

			query.append(_FINDER_COLUMN_KITNAMES_KITNAME_2);
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
			query.append(BibboxKitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindKitName) {
			qPos.add(kitName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bibboxKit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BibboxKit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bibbox kits where kitName = &#63; from the database.
	 *
	 * @param kitName the kit name
	 */
	@Override
	public void removeByKitNames(String kitName) {
		for (BibboxKit bibboxKit : findByKitNames(kitName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(bibboxKit);
		}
	}

	/**
	 * Returns the number of bibbox kits where kitName = &#63;.
	 *
	 * @param kitName the kit name
	 * @return the number of matching bibbox kits
	 */
	@Override
	public int countByKitNames(String kitName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_KITNAMES;

		Object[] finderArgs = new Object[] { kitName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BIBBOXKIT_WHERE);

			boolean bindKitName = false;

			if (kitName == null) {
				query.append(_FINDER_COLUMN_KITNAMES_KITNAME_1);
			}
			else if (kitName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KITNAMES_KITNAME_3);
			}
			else {
				bindKitName = true;

				query.append(_FINDER_COLUMN_KITNAMES_KITNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKitName) {
					qPos.add(kitName);
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

	private static final String _FINDER_COLUMN_KITNAMES_KITNAME_1 = "bibboxKit.kitName IS NULL";
	private static final String _FINDER_COLUMN_KITNAMES_KITNAME_2 = "bibboxKit.kitName = ?";
	private static final String _FINDER_COLUMN_KITNAMES_KITNAME_3 = "(bibboxKit.kitName IS NULL OR bibboxKit.kitName = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_KITNAMEFORAPPLICATION = new FinderPath(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
			BibboxKitModelImpl.FINDER_CACHE_ENABLED, BibboxKitImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByKitNameforApplication",
			new String[] { String.class.getName(), Long.class.getName() },
			BibboxKitModelImpl.KITNAME_COLUMN_BITMASK |
			BibboxKitModelImpl.APPLICATIONSTOREITEMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_KITNAMEFORAPPLICATION = new FinderPath(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
			BibboxKitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByKitNameforApplication",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the bibbox kit where kitName = &#63; and applicationStoreItemId = &#63; or throws a {@link NoSuchBibboxKitException} if it could not be found.
	 *
	 * @param kitName the kit name
	 * @param applicationStoreItemId the application store item ID
	 * @return the matching bibbox kit
	 * @throws NoSuchBibboxKitException if a matching bibbox kit could not be found
	 */
	@Override
	public BibboxKit findByKitNameforApplication(String kitName,
		long applicationStoreItemId) throws NoSuchBibboxKitException {
		BibboxKit bibboxKit = fetchByKitNameforApplication(kitName,
				applicationStoreItemId);

		if (bibboxKit == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("kitName=");
			msg.append(kitName);

			msg.append(", applicationStoreItemId=");
			msg.append(applicationStoreItemId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchBibboxKitException(msg.toString());
		}

		return bibboxKit;
	}

	/**
	 * Returns the bibbox kit where kitName = &#63; and applicationStoreItemId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param kitName the kit name
	 * @param applicationStoreItemId the application store item ID
	 * @return the matching bibbox kit, or <code>null</code> if a matching bibbox kit could not be found
	 */
	@Override
	public BibboxKit fetchByKitNameforApplication(String kitName,
		long applicationStoreItemId) {
		return fetchByKitNameforApplication(kitName, applicationStoreItemId,
			true);
	}

	/**
	 * Returns the bibbox kit where kitName = &#63; and applicationStoreItemId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param kitName the kit name
	 * @param applicationStoreItemId the application store item ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching bibbox kit, or <code>null</code> if a matching bibbox kit could not be found
	 */
	@Override
	public BibboxKit fetchByKitNameforApplication(String kitName,
		long applicationStoreItemId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { kitName, applicationStoreItemId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_KITNAMEFORAPPLICATION,
					finderArgs, this);
		}

		if (result instanceof BibboxKit) {
			BibboxKit bibboxKit = (BibboxKit)result;

			if (!Objects.equals(kitName, bibboxKit.getKitName()) ||
					(applicationStoreItemId != bibboxKit.getApplicationStoreItemId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_BIBBOXKIT_WHERE);

			boolean bindKitName = false;

			if (kitName == null) {
				query.append(_FINDER_COLUMN_KITNAMEFORAPPLICATION_KITNAME_1);
			}
			else if (kitName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KITNAMEFORAPPLICATION_KITNAME_3);
			}
			else {
				bindKitName = true;

				query.append(_FINDER_COLUMN_KITNAMEFORAPPLICATION_KITNAME_2);
			}

			query.append(_FINDER_COLUMN_KITNAMEFORAPPLICATION_APPLICATIONSTOREITEMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKitName) {
					qPos.add(kitName);
				}

				qPos.add(applicationStoreItemId);

				List<BibboxKit> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_KITNAMEFORAPPLICATION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BibboxKitPersistenceImpl.fetchByKitNameforApplication(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BibboxKit bibboxKit = list.get(0);

					result = bibboxKit;

					cacheResult(bibboxKit);

					if ((bibboxKit.getKitName() == null) ||
							!bibboxKit.getKitName().equals(kitName) ||
							(bibboxKit.getApplicationStoreItemId() != applicationStoreItemId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_KITNAMEFORAPPLICATION,
							finderArgs, bibboxKit);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_KITNAMEFORAPPLICATION,
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
			return (BibboxKit)result;
		}
	}

	/**
	 * Removes the bibbox kit where kitName = &#63; and applicationStoreItemId = &#63; from the database.
	 *
	 * @param kitName the kit name
	 * @param applicationStoreItemId the application store item ID
	 * @return the bibbox kit that was removed
	 */
	@Override
	public BibboxKit removeByKitNameforApplication(String kitName,
		long applicationStoreItemId) throws NoSuchBibboxKitException {
		BibboxKit bibboxKit = findByKitNameforApplication(kitName,
				applicationStoreItemId);

		return remove(bibboxKit);
	}

	/**
	 * Returns the number of bibbox kits where kitName = &#63; and applicationStoreItemId = &#63;.
	 *
	 * @param kitName the kit name
	 * @param applicationStoreItemId the application store item ID
	 * @return the number of matching bibbox kits
	 */
	@Override
	public int countByKitNameforApplication(String kitName,
		long applicationStoreItemId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_KITNAMEFORAPPLICATION;

		Object[] finderArgs = new Object[] { kitName, applicationStoreItemId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BIBBOXKIT_WHERE);

			boolean bindKitName = false;

			if (kitName == null) {
				query.append(_FINDER_COLUMN_KITNAMEFORAPPLICATION_KITNAME_1);
			}
			else if (kitName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KITNAMEFORAPPLICATION_KITNAME_3);
			}
			else {
				bindKitName = true;

				query.append(_FINDER_COLUMN_KITNAMEFORAPPLICATION_KITNAME_2);
			}

			query.append(_FINDER_COLUMN_KITNAMEFORAPPLICATION_APPLICATIONSTOREITEMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKitName) {
					qPos.add(kitName);
				}

				qPos.add(applicationStoreItemId);

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

	private static final String _FINDER_COLUMN_KITNAMEFORAPPLICATION_KITNAME_1 = "bibboxKit.kitName IS NULL AND ";
	private static final String _FINDER_COLUMN_KITNAMEFORAPPLICATION_KITNAME_2 = "bibboxKit.kitName = ? AND ";
	private static final String _FINDER_COLUMN_KITNAMEFORAPPLICATION_KITNAME_3 = "(bibboxKit.kitName IS NULL OR bibboxKit.kitName = '') AND ";
	private static final String _FINDER_COLUMN_KITNAMEFORAPPLICATION_APPLICATIONSTOREITEMID_2 =
		"bibboxKit.applicationStoreItemId = ?";

	public BibboxKitPersistenceImpl() {
		setModelClass(BibboxKit.class);
	}

	/**
	 * Caches the bibbox kit in the entity cache if it is enabled.
	 *
	 * @param bibboxKit the bibbox kit
	 */
	@Override
	public void cacheResult(BibboxKit bibboxKit) {
		entityCache.putResult(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
			BibboxKitImpl.class, bibboxKit.getPrimaryKey(), bibboxKit);

		finderCache.putResult(FINDER_PATH_FETCH_BY_KITNAMEFORAPPLICATION,
			new Object[] {
				bibboxKit.getKitName(), bibboxKit.getApplicationStoreItemId()
			}, bibboxKit);

		bibboxKit.resetOriginalValues();
	}

	/**
	 * Caches the bibbox kits in the entity cache if it is enabled.
	 *
	 * @param bibboxKits the bibbox kits
	 */
	@Override
	public void cacheResult(List<BibboxKit> bibboxKits) {
		for (BibboxKit bibboxKit : bibboxKits) {
			if (entityCache.getResult(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
						BibboxKitImpl.class, bibboxKit.getPrimaryKey()) == null) {
				cacheResult(bibboxKit);
			}
			else {
				bibboxKit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bibbox kits.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BibboxKitImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bibbox kit.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BibboxKit bibboxKit) {
		entityCache.removeResult(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
			BibboxKitImpl.class, bibboxKit.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((BibboxKitModelImpl)bibboxKit);
	}

	@Override
	public void clearCache(List<BibboxKit> bibboxKits) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BibboxKit bibboxKit : bibboxKits) {
			entityCache.removeResult(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
				BibboxKitImpl.class, bibboxKit.getPrimaryKey());

			clearUniqueFindersCache((BibboxKitModelImpl)bibboxKit);
		}
	}

	protected void cacheUniqueFindersCache(
		BibboxKitModelImpl bibboxKitModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					bibboxKitModelImpl.getKitName(),
					bibboxKitModelImpl.getApplicationStoreItemId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_KITNAMEFORAPPLICATION,
				args, Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_KITNAMEFORAPPLICATION,
				args, bibboxKitModelImpl);
		}
		else {
			if ((bibboxKitModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_KITNAMEFORAPPLICATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bibboxKitModelImpl.getKitName(),
						bibboxKitModelImpl.getApplicationStoreItemId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_KITNAMEFORAPPLICATION,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_KITNAMEFORAPPLICATION,
					args, bibboxKitModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		BibboxKitModelImpl bibboxKitModelImpl) {
		Object[] args = new Object[] {
				bibboxKitModelImpl.getKitName(),
				bibboxKitModelImpl.getApplicationStoreItemId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_KITNAMEFORAPPLICATION,
			args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_KITNAMEFORAPPLICATION,
			args);

		if ((bibboxKitModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_KITNAMEFORAPPLICATION.getColumnBitmask()) != 0) {
			args = new Object[] {
					bibboxKitModelImpl.getOriginalKitName(),
					bibboxKitModelImpl.getOriginalApplicationStoreItemId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_KITNAMEFORAPPLICATION,
				args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_KITNAMEFORAPPLICATION,
				args);
		}
	}

	/**
	 * Creates a new bibbox kit with the primary key. Does not add the bibbox kit to the database.
	 *
	 * @param bibboxKitId the primary key for the new bibbox kit
	 * @return the new bibbox kit
	 */
	@Override
	public BibboxKit create(long bibboxKitId) {
		BibboxKit bibboxKit = new BibboxKitImpl();

		bibboxKit.setNew(true);
		bibboxKit.setPrimaryKey(bibboxKitId);

		bibboxKit.setCompanyId(companyProvider.getCompanyId());

		return bibboxKit;
	}

	/**
	 * Removes the bibbox kit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bibboxKitId the primary key of the bibbox kit
	 * @return the bibbox kit that was removed
	 * @throws NoSuchBibboxKitException if a bibbox kit with the primary key could not be found
	 */
	@Override
	public BibboxKit remove(long bibboxKitId) throws NoSuchBibboxKitException {
		return remove((Serializable)bibboxKitId);
	}

	/**
	 * Removes the bibbox kit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bibbox kit
	 * @return the bibbox kit that was removed
	 * @throws NoSuchBibboxKitException if a bibbox kit with the primary key could not be found
	 */
	@Override
	public BibboxKit remove(Serializable primaryKey)
		throws NoSuchBibboxKitException {
		Session session = null;

		try {
			session = openSession();

			BibboxKit bibboxKit = (BibboxKit)session.get(BibboxKitImpl.class,
					primaryKey);

			if (bibboxKit == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBibboxKitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bibboxKit);
		}
		catch (NoSuchBibboxKitException nsee) {
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
	protected BibboxKit removeImpl(BibboxKit bibboxKit) {
		bibboxKit = toUnwrappedModel(bibboxKit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bibboxKit)) {
				bibboxKit = (BibboxKit)session.get(BibboxKitImpl.class,
						bibboxKit.getPrimaryKeyObj());
			}

			if (bibboxKit != null) {
				session.delete(bibboxKit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bibboxKit != null) {
			clearCache(bibboxKit);
		}

		return bibboxKit;
	}

	@Override
	public BibboxKit updateImpl(BibboxKit bibboxKit) {
		bibboxKit = toUnwrappedModel(bibboxKit);

		boolean isNew = bibboxKit.isNew();

		BibboxKitModelImpl bibboxKitModelImpl = (BibboxKitModelImpl)bibboxKit;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (bibboxKit.getCreateDate() == null)) {
			if (serviceContext == null) {
				bibboxKit.setCreateDate(now);
			}
			else {
				bibboxKit.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!bibboxKitModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				bibboxKit.setModifiedDate(now);
			}
			else {
				bibboxKit.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (bibboxKit.isNew()) {
				session.save(bibboxKit);

				bibboxKit.setNew(false);
			}
			else {
				bibboxKit = (BibboxKit)session.merge(bibboxKit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BibboxKitModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((bibboxKitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONSTOREITEMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bibboxKitModelImpl.getOriginalApplicationStoreItemId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONSTOREITEMID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONSTOREITEMID,
					args);

				args = new Object[] {
						bibboxKitModelImpl.getApplicationStoreItemId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONSTOREITEMID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONSTOREITEMID,
					args);
			}

			if ((bibboxKitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KITNAMES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bibboxKitModelImpl.getOriginalKitName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_KITNAMES, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KITNAMES,
					args);

				args = new Object[] { bibboxKitModelImpl.getKitName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_KITNAMES, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KITNAMES,
					args);
			}
		}

		entityCache.putResult(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
			BibboxKitImpl.class, bibboxKit.getPrimaryKey(), bibboxKit, false);

		clearUniqueFindersCache(bibboxKitModelImpl);
		cacheUniqueFindersCache(bibboxKitModelImpl, isNew);

		bibboxKit.resetOriginalValues();

		return bibboxKit;
	}

	protected BibboxKit toUnwrappedModel(BibboxKit bibboxKit) {
		if (bibboxKit instanceof BibboxKitImpl) {
			return bibboxKit;
		}

		BibboxKitImpl bibboxKitImpl = new BibboxKitImpl();

		bibboxKitImpl.setNew(bibboxKit.isNew());
		bibboxKitImpl.setPrimaryKey(bibboxKit.getPrimaryKey());

		bibboxKitImpl.setBibboxKitId(bibboxKit.getBibboxKitId());
		bibboxKitImpl.setGroupId(bibboxKit.getGroupId());
		bibboxKitImpl.setCompanyId(bibboxKit.getCompanyId());
		bibboxKitImpl.setUserId(bibboxKit.getUserId());
		bibboxKitImpl.setUserName(bibboxKit.getUserName());
		bibboxKitImpl.setCreateDate(bibboxKit.getCreateDate());
		bibboxKitImpl.setModifiedDate(bibboxKit.getModifiedDate());
		bibboxKitImpl.setKitName(bibboxKit.getKitName());
		bibboxKitImpl.setApplicationStoreItemId(bibboxKit.getApplicationStoreItemId());

		return bibboxKitImpl;
	}

	/**
	 * Returns the bibbox kit with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bibbox kit
	 * @return the bibbox kit
	 * @throws NoSuchBibboxKitException if a bibbox kit with the primary key could not be found
	 */
	@Override
	public BibboxKit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBibboxKitException {
		BibboxKit bibboxKit = fetchByPrimaryKey(primaryKey);

		if (bibboxKit == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBibboxKitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bibboxKit;
	}

	/**
	 * Returns the bibbox kit with the primary key or throws a {@link NoSuchBibboxKitException} if it could not be found.
	 *
	 * @param bibboxKitId the primary key of the bibbox kit
	 * @return the bibbox kit
	 * @throws NoSuchBibboxKitException if a bibbox kit with the primary key could not be found
	 */
	@Override
	public BibboxKit findByPrimaryKey(long bibboxKitId)
		throws NoSuchBibboxKitException {
		return findByPrimaryKey((Serializable)bibboxKitId);
	}

	/**
	 * Returns the bibbox kit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bibbox kit
	 * @return the bibbox kit, or <code>null</code> if a bibbox kit with the primary key could not be found
	 */
	@Override
	public BibboxKit fetchByPrimaryKey(Serializable primaryKey) {
		BibboxKit bibboxKit = (BibboxKit)entityCache.getResult(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
				BibboxKitImpl.class, primaryKey);

		if (bibboxKit == _nullBibboxKit) {
			return null;
		}

		if (bibboxKit == null) {
			Session session = null;

			try {
				session = openSession();

				bibboxKit = (BibboxKit)session.get(BibboxKitImpl.class,
						primaryKey);

				if (bibboxKit != null) {
					cacheResult(bibboxKit);
				}
				else {
					entityCache.putResult(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
						BibboxKitImpl.class, primaryKey, _nullBibboxKit);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
					BibboxKitImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bibboxKit;
	}

	/**
	 * Returns the bibbox kit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bibboxKitId the primary key of the bibbox kit
	 * @return the bibbox kit, or <code>null</code> if a bibbox kit with the primary key could not be found
	 */
	@Override
	public BibboxKit fetchByPrimaryKey(long bibboxKitId) {
		return fetchByPrimaryKey((Serializable)bibboxKitId);
	}

	@Override
	public Map<Serializable, BibboxKit> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, BibboxKit> map = new HashMap<Serializable, BibboxKit>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			BibboxKit bibboxKit = fetchByPrimaryKey(primaryKey);

			if (bibboxKit != null) {
				map.put(primaryKey, bibboxKit);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			BibboxKit bibboxKit = (BibboxKit)entityCache.getResult(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
					BibboxKitImpl.class, primaryKey);

			if (bibboxKit == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, bibboxKit);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_BIBBOXKIT_WHERE_PKS_IN);

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

			for (BibboxKit bibboxKit : (List<BibboxKit>)q.list()) {
				map.put(bibboxKit.getPrimaryKeyObj(), bibboxKit);

				cacheResult(bibboxKit);

				uncachedPrimaryKeys.remove(bibboxKit.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(BibboxKitModelImpl.ENTITY_CACHE_ENABLED,
					BibboxKitImpl.class, primaryKey, _nullBibboxKit);
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
	 * Returns all the bibbox kits.
	 *
	 * @return the bibbox kits
	 */
	@Override
	public List<BibboxKit> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bibbox kits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bibbox kits
	 * @param end the upper bound of the range of bibbox kits (not inclusive)
	 * @return the range of bibbox kits
	 */
	@Override
	public List<BibboxKit> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bibbox kits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bibbox kits
	 * @param end the upper bound of the range of bibbox kits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bibbox kits
	 */
	@Override
	public List<BibboxKit> findAll(int start, int end,
		OrderByComparator<BibboxKit> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bibbox kits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link BibboxKitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bibbox kits
	 * @param end the upper bound of the range of bibbox kits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of bibbox kits
	 */
	@Override
	public List<BibboxKit> findAll(int start, int end,
		OrderByComparator<BibboxKit> orderByComparator,
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

		List<BibboxKit> list = null;

		if (retrieveFromCache) {
			list = (List<BibboxKit>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_BIBBOXKIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BIBBOXKIT;

				if (pagination) {
					sql = sql.concat(BibboxKitModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BibboxKit>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<BibboxKit>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the bibbox kits from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BibboxKit bibboxKit : findAll()) {
			remove(bibboxKit);
		}
	}

	/**
	 * Returns the number of bibbox kits.
	 *
	 * @return the number of bibbox kits
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_BIBBOXKIT);

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
		return BibboxKitModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bibbox kit persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(BibboxKitImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_BIBBOXKIT = "SELECT bibboxKit FROM BibboxKit bibboxKit";
	private static final String _SQL_SELECT_BIBBOXKIT_WHERE_PKS_IN = "SELECT bibboxKit FROM BibboxKit bibboxKit WHERE bibboxKitId IN (";
	private static final String _SQL_SELECT_BIBBOXKIT_WHERE = "SELECT bibboxKit FROM BibboxKit bibboxKit WHERE ";
	private static final String _SQL_COUNT_BIBBOXKIT = "SELECT COUNT(bibboxKit) FROM BibboxKit bibboxKit";
	private static final String _SQL_COUNT_BIBBOXKIT_WHERE = "SELECT COUNT(bibboxKit) FROM BibboxKit bibboxKit WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bibboxKit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BibboxKit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BibboxKit exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(BibboxKitPersistenceImpl.class);
	private static final BibboxKit _nullBibboxKit = new BibboxKitImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BibboxKit> toCacheModel() {
				return _nullBibboxKitCacheModel;
			}
		};

	private static final CacheModel<BibboxKit> _nullBibboxKitCacheModel = new CacheModel<BibboxKit>() {
			@Override
			public BibboxKit toEntityModel() {
				return _nullBibboxKit;
			}
		};
}