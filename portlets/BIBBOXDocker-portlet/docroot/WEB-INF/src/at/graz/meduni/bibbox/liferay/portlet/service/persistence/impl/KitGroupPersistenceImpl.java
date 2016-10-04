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

import at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchKitGroupException;
import at.graz.meduni.bibbox.liferay.portlet.model.KitGroup;
import at.graz.meduni.bibbox.liferay.portlet.model.impl.KitGroupImpl;
import at.graz.meduni.bibbox.liferay.portlet.model.impl.KitGroupModelImpl;
import at.graz.meduni.bibbox.liferay.portlet.service.persistence.KitGroupPersistence;

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
 * The persistence implementation for the kit group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see KitGroupPersistence
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.KitGroupUtil
 * @generated
 */
@ProviderType
public class KitGroupPersistenceImpl extends BasePersistenceImpl<KitGroup>
	implements KitGroupPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link KitGroupUtil} to access the kit group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = KitGroupImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KitGroupModelImpl.ENTITY_CACHE_ENABLED,
			KitGroupModelImpl.FINDER_CACHE_ENABLED, KitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KitGroupModelImpl.ENTITY_CACHE_ENABLED,
			KitGroupModelImpl.FINDER_CACHE_ENABLED, KitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KitGroupModelImpl.ENTITY_CACHE_ENABLED,
			KitGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_KITGROUP = new FinderPath(KitGroupModelImpl.ENTITY_CACHE_ENABLED,
			KitGroupModelImpl.FINDER_CACHE_ENABLED, KitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByKitGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KITGROUP =
		new FinderPath(KitGroupModelImpl.ENTITY_CACHE_ENABLED,
			KitGroupModelImpl.FINDER_CACHE_ENABLED, KitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByKitGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			KitGroupModelImpl.APPLICATIONSTOREITEMID_COLUMN_BITMASK |
			KitGroupModelImpl.BIBBOXKITID_COLUMN_BITMASK |
			KitGroupModelImpl.GROUP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_KITGROUP = new FinderPath(KitGroupModelImpl.ENTITY_CACHE_ENABLED,
			KitGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKitGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the kit groups where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param bibboxKitId the bibbox kit ID
	 * @return the matching kit groups
	 */
	@Override
	public List<KitGroup> findByKitGroup(long applicationStoreItemId,
		long bibboxKitId) {
		return findByKitGroup(applicationStoreItemId, bibboxKitId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kit groups where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param bibboxKitId the bibbox kit ID
	 * @param start the lower bound of the range of kit groups
	 * @param end the upper bound of the range of kit groups (not inclusive)
	 * @return the range of matching kit groups
	 */
	@Override
	public List<KitGroup> findByKitGroup(long applicationStoreItemId,
		long bibboxKitId, int start, int end) {
		return findByKitGroup(applicationStoreItemId, bibboxKitId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the kit groups where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param bibboxKitId the bibbox kit ID
	 * @param start the lower bound of the range of kit groups
	 * @param end the upper bound of the range of kit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kit groups
	 */
	@Override
	public List<KitGroup> findByKitGroup(long applicationStoreItemId,
		long bibboxKitId, int start, int end,
		OrderByComparator<KitGroup> orderByComparator) {
		return findByKitGroup(applicationStoreItemId, bibboxKitId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the kit groups where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param bibboxKitId the bibbox kit ID
	 * @param start the lower bound of the range of kit groups
	 * @param end the upper bound of the range of kit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching kit groups
	 */
	@Override
	public List<KitGroup> findByKitGroup(long applicationStoreItemId,
		long bibboxKitId, int start, int end,
		OrderByComparator<KitGroup> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KITGROUP;
			finderArgs = new Object[] { applicationStoreItemId, bibboxKitId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_KITGROUP;
			finderArgs = new Object[] {
					applicationStoreItemId, bibboxKitId,
					
					start, end, orderByComparator
				};
		}

		List<KitGroup> list = null;

		if (retrieveFromCache) {
			list = (List<KitGroup>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (KitGroup kitGroup : list) {
					if ((applicationStoreItemId != kitGroup.getApplicationStoreItemId()) ||
							(bibboxKitId != kitGroup.getBibboxKitId())) {
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

			query.append(_SQL_SELECT_KITGROUP_WHERE);

			query.append(_FINDER_COLUMN_KITGROUP_APPLICATIONSTOREITEMID_2);

			query.append(_FINDER_COLUMN_KITGROUP_BIBBOXKITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(KitGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicationStoreItemId);

				qPos.add(bibboxKitId);

				if (!pagination) {
					list = (List<KitGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<KitGroup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first kit group in the ordered set where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param bibboxKitId the bibbox kit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kit group
	 * @throws NoSuchKitGroupException if a matching kit group could not be found
	 */
	@Override
	public KitGroup findByKitGroup_First(long applicationStoreItemId,
		long bibboxKitId, OrderByComparator<KitGroup> orderByComparator)
		throws NoSuchKitGroupException {
		KitGroup kitGroup = fetchByKitGroup_First(applicationStoreItemId,
				bibboxKitId, orderByComparator);

		if (kitGroup != null) {
			return kitGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationStoreItemId=");
		msg.append(applicationStoreItemId);

		msg.append(", bibboxKitId=");
		msg.append(bibboxKitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKitGroupException(msg.toString());
	}

	/**
	 * Returns the first kit group in the ordered set where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param bibboxKitId the bibbox kit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kit group, or <code>null</code> if a matching kit group could not be found
	 */
	@Override
	public KitGroup fetchByKitGroup_First(long applicationStoreItemId,
		long bibboxKitId, OrderByComparator<KitGroup> orderByComparator) {
		List<KitGroup> list = findByKitGroup(applicationStoreItemId,
				bibboxKitId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last kit group in the ordered set where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param bibboxKitId the bibbox kit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kit group
	 * @throws NoSuchKitGroupException if a matching kit group could not be found
	 */
	@Override
	public KitGroup findByKitGroup_Last(long applicationStoreItemId,
		long bibboxKitId, OrderByComparator<KitGroup> orderByComparator)
		throws NoSuchKitGroupException {
		KitGroup kitGroup = fetchByKitGroup_Last(applicationStoreItemId,
				bibboxKitId, orderByComparator);

		if (kitGroup != null) {
			return kitGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationStoreItemId=");
		msg.append(applicationStoreItemId);

		msg.append(", bibboxKitId=");
		msg.append(bibboxKitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKitGroupException(msg.toString());
	}

	/**
	 * Returns the last kit group in the ordered set where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param bibboxKitId the bibbox kit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kit group, or <code>null</code> if a matching kit group could not be found
	 */
	@Override
	public KitGroup fetchByKitGroup_Last(long applicationStoreItemId,
		long bibboxKitId, OrderByComparator<KitGroup> orderByComparator) {
		int count = countByKitGroup(applicationStoreItemId, bibboxKitId);

		if (count == 0) {
			return null;
		}

		List<KitGroup> list = findByKitGroup(applicationStoreItemId,
				bibboxKitId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the kit groups before and after the current kit group in the ordered set where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	 *
	 * @param kitGroupId the primary key of the current kit group
	 * @param applicationStoreItemId the application store item ID
	 * @param bibboxKitId the bibbox kit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kit group
	 * @throws NoSuchKitGroupException if a kit group with the primary key could not be found
	 */
	@Override
	public KitGroup[] findByKitGroup_PrevAndNext(long kitGroupId,
		long applicationStoreItemId, long bibboxKitId,
		OrderByComparator<KitGroup> orderByComparator)
		throws NoSuchKitGroupException {
		KitGroup kitGroup = findByPrimaryKey(kitGroupId);

		Session session = null;

		try {
			session = openSession();

			KitGroup[] array = new KitGroupImpl[3];

			array[0] = getByKitGroup_PrevAndNext(session, kitGroup,
					applicationStoreItemId, bibboxKitId, orderByComparator, true);

			array[1] = kitGroup;

			array[2] = getByKitGroup_PrevAndNext(session, kitGroup,
					applicationStoreItemId, bibboxKitId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected KitGroup getByKitGroup_PrevAndNext(Session session,
		KitGroup kitGroup, long applicationStoreItemId, long bibboxKitId,
		OrderByComparator<KitGroup> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_KITGROUP_WHERE);

		query.append(_FINDER_COLUMN_KITGROUP_APPLICATIONSTOREITEMID_2);

		query.append(_FINDER_COLUMN_KITGROUP_BIBBOXKITID_2);

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
			query.append(KitGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(applicationStoreItemId);

		qPos.add(bibboxKitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(kitGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<KitGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the kit groups where applicationStoreItemId = &#63; and bibboxKitId = &#63; from the database.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param bibboxKitId the bibbox kit ID
	 */
	@Override
	public void removeByKitGroup(long applicationStoreItemId, long bibboxKitId) {
		for (KitGroup kitGroup : findByKitGroup(applicationStoreItemId,
				bibboxKitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(kitGroup);
		}
	}

	/**
	 * Returns the number of kit groups where applicationStoreItemId = &#63; and bibboxKitId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param bibboxKitId the bibbox kit ID
	 * @return the number of matching kit groups
	 */
	@Override
	public int countByKitGroup(long applicationStoreItemId, long bibboxKitId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_KITGROUP;

		Object[] finderArgs = new Object[] { applicationStoreItemId, bibboxKitId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_KITGROUP_WHERE);

			query.append(_FINDER_COLUMN_KITGROUP_APPLICATIONSTOREITEMID_2);

			query.append(_FINDER_COLUMN_KITGROUP_BIBBOXKITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicationStoreItemId);

				qPos.add(bibboxKitId);

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

	private static final String _FINDER_COLUMN_KITGROUP_APPLICATIONSTOREITEMID_2 =
		"kitGroup.applicationStoreItemId = ? AND ";
	private static final String _FINDER_COLUMN_KITGROUP_BIBBOXKITID_2 = "kitGroup.bibboxKitId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_KITGROUPS =
		new FinderPath(KitGroupModelImpl.ENTITY_CACHE_ENABLED,
			KitGroupModelImpl.FINDER_CACHE_ENABLED, KitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByKitGroups",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KITGROUPS =
		new FinderPath(KitGroupModelImpl.ENTITY_CACHE_ENABLED,
			KitGroupModelImpl.FINDER_CACHE_ENABLED, KitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByKitGroups",
			new String[] { Long.class.getName() },
			KitGroupModelImpl.APPLICATIONSTOREITEMID_COLUMN_BITMASK |
			KitGroupModelImpl.GROUP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_KITGROUPS = new FinderPath(KitGroupModelImpl.ENTITY_CACHE_ENABLED,
			KitGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKitGroups",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the kit groups where applicationStoreItemId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @return the matching kit groups
	 */
	@Override
	public List<KitGroup> findByKitGroups(long applicationStoreItemId) {
		return findByKitGroups(applicationStoreItemId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kit groups where applicationStoreItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param start the lower bound of the range of kit groups
	 * @param end the upper bound of the range of kit groups (not inclusive)
	 * @return the range of matching kit groups
	 */
	@Override
	public List<KitGroup> findByKitGroups(long applicationStoreItemId,
		int start, int end) {
		return findByKitGroups(applicationStoreItemId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the kit groups where applicationStoreItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param start the lower bound of the range of kit groups
	 * @param end the upper bound of the range of kit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kit groups
	 */
	@Override
	public List<KitGroup> findByKitGroups(long applicationStoreItemId,
		int start, int end, OrderByComparator<KitGroup> orderByComparator) {
		return findByKitGroups(applicationStoreItemId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the kit groups where applicationStoreItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param start the lower bound of the range of kit groups
	 * @param end the upper bound of the range of kit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching kit groups
	 */
	@Override
	public List<KitGroup> findByKitGroups(long applicationStoreItemId,
		int start, int end, OrderByComparator<KitGroup> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KITGROUPS;
			finderArgs = new Object[] { applicationStoreItemId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_KITGROUPS;
			finderArgs = new Object[] {
					applicationStoreItemId,
					
					start, end, orderByComparator
				};
		}

		List<KitGroup> list = null;

		if (retrieveFromCache) {
			list = (List<KitGroup>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (KitGroup kitGroup : list) {
					if ((applicationStoreItemId != kitGroup.getApplicationStoreItemId())) {
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

			query.append(_SQL_SELECT_KITGROUP_WHERE);

			query.append(_FINDER_COLUMN_KITGROUPS_APPLICATIONSTOREITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(KitGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicationStoreItemId);

				if (!pagination) {
					list = (List<KitGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<KitGroup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first kit group in the ordered set where applicationStoreItemId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kit group
	 * @throws NoSuchKitGroupException if a matching kit group could not be found
	 */
	@Override
	public KitGroup findByKitGroups_First(long applicationStoreItemId,
		OrderByComparator<KitGroup> orderByComparator)
		throws NoSuchKitGroupException {
		KitGroup kitGroup = fetchByKitGroups_First(applicationStoreItemId,
				orderByComparator);

		if (kitGroup != null) {
			return kitGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationStoreItemId=");
		msg.append(applicationStoreItemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKitGroupException(msg.toString());
	}

	/**
	 * Returns the first kit group in the ordered set where applicationStoreItemId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kit group, or <code>null</code> if a matching kit group could not be found
	 */
	@Override
	public KitGroup fetchByKitGroups_First(long applicationStoreItemId,
		OrderByComparator<KitGroup> orderByComparator) {
		List<KitGroup> list = findByKitGroups(applicationStoreItemId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last kit group in the ordered set where applicationStoreItemId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kit group
	 * @throws NoSuchKitGroupException if a matching kit group could not be found
	 */
	@Override
	public KitGroup findByKitGroups_Last(long applicationStoreItemId,
		OrderByComparator<KitGroup> orderByComparator)
		throws NoSuchKitGroupException {
		KitGroup kitGroup = fetchByKitGroups_Last(applicationStoreItemId,
				orderByComparator);

		if (kitGroup != null) {
			return kitGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationStoreItemId=");
		msg.append(applicationStoreItemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchKitGroupException(msg.toString());
	}

	/**
	 * Returns the last kit group in the ordered set where applicationStoreItemId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kit group, or <code>null</code> if a matching kit group could not be found
	 */
	@Override
	public KitGroup fetchByKitGroups_Last(long applicationStoreItemId,
		OrderByComparator<KitGroup> orderByComparator) {
		int count = countByKitGroups(applicationStoreItemId);

		if (count == 0) {
			return null;
		}

		List<KitGroup> list = findByKitGroups(applicationStoreItemId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the kit groups before and after the current kit group in the ordered set where applicationStoreItemId = &#63;.
	 *
	 * @param kitGroupId the primary key of the current kit group
	 * @param applicationStoreItemId the application store item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kit group
	 * @throws NoSuchKitGroupException if a kit group with the primary key could not be found
	 */
	@Override
	public KitGroup[] findByKitGroups_PrevAndNext(long kitGroupId,
		long applicationStoreItemId,
		OrderByComparator<KitGroup> orderByComparator)
		throws NoSuchKitGroupException {
		KitGroup kitGroup = findByPrimaryKey(kitGroupId);

		Session session = null;

		try {
			session = openSession();

			KitGroup[] array = new KitGroupImpl[3];

			array[0] = getByKitGroups_PrevAndNext(session, kitGroup,
					applicationStoreItemId, orderByComparator, true);

			array[1] = kitGroup;

			array[2] = getByKitGroups_PrevAndNext(session, kitGroup,
					applicationStoreItemId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected KitGroup getByKitGroups_PrevAndNext(Session session,
		KitGroup kitGroup, long applicationStoreItemId,
		OrderByComparator<KitGroup> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_KITGROUP_WHERE);

		query.append(_FINDER_COLUMN_KITGROUPS_APPLICATIONSTOREITEMID_2);

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
			query.append(KitGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(applicationStoreItemId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(kitGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<KitGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the kit groups where applicationStoreItemId = &#63; from the database.
	 *
	 * @param applicationStoreItemId the application store item ID
	 */
	@Override
	public void removeByKitGroups(long applicationStoreItemId) {
		for (KitGroup kitGroup : findByKitGroups(applicationStoreItemId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(kitGroup);
		}
	}

	/**
	 * Returns the number of kit groups where applicationStoreItemId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @return the number of matching kit groups
	 */
	@Override
	public int countByKitGroups(long applicationStoreItemId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_KITGROUPS;

		Object[] finderArgs = new Object[] { applicationStoreItemId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KITGROUP_WHERE);

			query.append(_FINDER_COLUMN_KITGROUPS_APPLICATIONSTOREITEMID_2);

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

	private static final String _FINDER_COLUMN_KITGROUPS_APPLICATIONSTOREITEMID_2 =
		"kitGroup.applicationStoreItemId = ?";

	public KitGroupPersistenceImpl() {
		setModelClass(KitGroup.class);
	}

	/**
	 * Caches the kit group in the entity cache if it is enabled.
	 *
	 * @param kitGroup the kit group
	 */
	@Override
	public void cacheResult(KitGroup kitGroup) {
		entityCache.putResult(KitGroupModelImpl.ENTITY_CACHE_ENABLED,
			KitGroupImpl.class, kitGroup.getPrimaryKey(), kitGroup);

		kitGroup.resetOriginalValues();
	}

	/**
	 * Caches the kit groups in the entity cache if it is enabled.
	 *
	 * @param kitGroups the kit groups
	 */
	@Override
	public void cacheResult(List<KitGroup> kitGroups) {
		for (KitGroup kitGroup : kitGroups) {
			if (entityCache.getResult(KitGroupModelImpl.ENTITY_CACHE_ENABLED,
						KitGroupImpl.class, kitGroup.getPrimaryKey()) == null) {
				cacheResult(kitGroup);
			}
			else {
				kitGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all kit groups.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(KitGroupImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the kit group.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(KitGroup kitGroup) {
		entityCache.removeResult(KitGroupModelImpl.ENTITY_CACHE_ENABLED,
			KitGroupImpl.class, kitGroup.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<KitGroup> kitGroups) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (KitGroup kitGroup : kitGroups) {
			entityCache.removeResult(KitGroupModelImpl.ENTITY_CACHE_ENABLED,
				KitGroupImpl.class, kitGroup.getPrimaryKey());
		}
	}

	/**
	 * Creates a new kit group with the primary key. Does not add the kit group to the database.
	 *
	 * @param kitGroupId the primary key for the new kit group
	 * @return the new kit group
	 */
	@Override
	public KitGroup create(long kitGroupId) {
		KitGroup kitGroup = new KitGroupImpl();

		kitGroup.setNew(true);
		kitGroup.setPrimaryKey(kitGroupId);

		kitGroup.setCompanyId(companyProvider.getCompanyId());

		return kitGroup;
	}

	/**
	 * Removes the kit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kitGroupId the primary key of the kit group
	 * @return the kit group that was removed
	 * @throws NoSuchKitGroupException if a kit group with the primary key could not be found
	 */
	@Override
	public KitGroup remove(long kitGroupId) throws NoSuchKitGroupException {
		return remove((Serializable)kitGroupId);
	}

	/**
	 * Removes the kit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the kit group
	 * @return the kit group that was removed
	 * @throws NoSuchKitGroupException if a kit group with the primary key could not be found
	 */
	@Override
	public KitGroup remove(Serializable primaryKey)
		throws NoSuchKitGroupException {
		Session session = null;

		try {
			session = openSession();

			KitGroup kitGroup = (KitGroup)session.get(KitGroupImpl.class,
					primaryKey);

			if (kitGroup == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchKitGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(kitGroup);
		}
		catch (NoSuchKitGroupException nsee) {
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
	protected KitGroup removeImpl(KitGroup kitGroup) {
		kitGroup = toUnwrappedModel(kitGroup);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(kitGroup)) {
				kitGroup = (KitGroup)session.get(KitGroupImpl.class,
						kitGroup.getPrimaryKeyObj());
			}

			if (kitGroup != null) {
				session.delete(kitGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (kitGroup != null) {
			clearCache(kitGroup);
		}

		return kitGroup;
	}

	@Override
	public KitGroup updateImpl(KitGroup kitGroup) {
		kitGroup = toUnwrappedModel(kitGroup);

		boolean isNew = kitGroup.isNew();

		KitGroupModelImpl kitGroupModelImpl = (KitGroupModelImpl)kitGroup;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (kitGroup.getCreateDate() == null)) {
			if (serviceContext == null) {
				kitGroup.setCreateDate(now);
			}
			else {
				kitGroup.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!kitGroupModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				kitGroup.setModifiedDate(now);
			}
			else {
				kitGroup.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (kitGroup.isNew()) {
				session.save(kitGroup);

				kitGroup.setNew(false);
			}
			else {
				kitGroup = (KitGroup)session.merge(kitGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !KitGroupModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((kitGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KITGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						kitGroupModelImpl.getOriginalApplicationStoreItemId(),
						kitGroupModelImpl.getOriginalBibboxKitId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_KITGROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KITGROUP,
					args);

				args = new Object[] {
						kitGroupModelImpl.getApplicationStoreItemId(),
						kitGroupModelImpl.getBibboxKitId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_KITGROUP, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KITGROUP,
					args);
			}

			if ((kitGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KITGROUPS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						kitGroupModelImpl.getOriginalApplicationStoreItemId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_KITGROUPS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KITGROUPS,
					args);

				args = new Object[] {
						kitGroupModelImpl.getApplicationStoreItemId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_KITGROUPS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KITGROUPS,
					args);
			}
		}

		entityCache.putResult(KitGroupModelImpl.ENTITY_CACHE_ENABLED,
			KitGroupImpl.class, kitGroup.getPrimaryKey(), kitGroup, false);

		kitGroup.resetOriginalValues();

		return kitGroup;
	}

	protected KitGroup toUnwrappedModel(KitGroup kitGroup) {
		if (kitGroup instanceof KitGroupImpl) {
			return kitGroup;
		}

		KitGroupImpl kitGroupImpl = new KitGroupImpl();

		kitGroupImpl.setNew(kitGroup.isNew());
		kitGroupImpl.setPrimaryKey(kitGroup.getPrimaryKey());

		kitGroupImpl.setKitGroupId(kitGroup.getKitGroupId());
		kitGroupImpl.setGroupId(kitGroup.getGroupId());
		kitGroupImpl.setCompanyId(kitGroup.getCompanyId());
		kitGroupImpl.setUserId(kitGroup.getUserId());
		kitGroupImpl.setUserName(kitGroup.getUserName());
		kitGroupImpl.setCreateDate(kitGroup.getCreateDate());
		kitGroupImpl.setModifiedDate(kitGroup.getModifiedDate());
		kitGroupImpl.setGroup(kitGroup.getGroup());
		kitGroupImpl.setApplicationStoreItemId(kitGroup.getApplicationStoreItemId());
		kitGroupImpl.setBibboxKitId(kitGroup.getBibboxKitId());

		return kitGroupImpl;
	}

	/**
	 * Returns the kit group with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the kit group
	 * @return the kit group
	 * @throws NoSuchKitGroupException if a kit group with the primary key could not be found
	 */
	@Override
	public KitGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchKitGroupException {
		KitGroup kitGroup = fetchByPrimaryKey(primaryKey);

		if (kitGroup == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchKitGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return kitGroup;
	}

	/**
	 * Returns the kit group with the primary key or throws a {@link NoSuchKitGroupException} if it could not be found.
	 *
	 * @param kitGroupId the primary key of the kit group
	 * @return the kit group
	 * @throws NoSuchKitGroupException if a kit group with the primary key could not be found
	 */
	@Override
	public KitGroup findByPrimaryKey(long kitGroupId)
		throws NoSuchKitGroupException {
		return findByPrimaryKey((Serializable)kitGroupId);
	}

	/**
	 * Returns the kit group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the kit group
	 * @return the kit group, or <code>null</code> if a kit group with the primary key could not be found
	 */
	@Override
	public KitGroup fetchByPrimaryKey(Serializable primaryKey) {
		KitGroup kitGroup = (KitGroup)entityCache.getResult(KitGroupModelImpl.ENTITY_CACHE_ENABLED,
				KitGroupImpl.class, primaryKey);

		if (kitGroup == _nullKitGroup) {
			return null;
		}

		if (kitGroup == null) {
			Session session = null;

			try {
				session = openSession();

				kitGroup = (KitGroup)session.get(KitGroupImpl.class, primaryKey);

				if (kitGroup != null) {
					cacheResult(kitGroup);
				}
				else {
					entityCache.putResult(KitGroupModelImpl.ENTITY_CACHE_ENABLED,
						KitGroupImpl.class, primaryKey, _nullKitGroup);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(KitGroupModelImpl.ENTITY_CACHE_ENABLED,
					KitGroupImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return kitGroup;
	}

	/**
	 * Returns the kit group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param kitGroupId the primary key of the kit group
	 * @return the kit group, or <code>null</code> if a kit group with the primary key could not be found
	 */
	@Override
	public KitGroup fetchByPrimaryKey(long kitGroupId) {
		return fetchByPrimaryKey((Serializable)kitGroupId);
	}

	@Override
	public Map<Serializable, KitGroup> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, KitGroup> map = new HashMap<Serializable, KitGroup>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			KitGroup kitGroup = fetchByPrimaryKey(primaryKey);

			if (kitGroup != null) {
				map.put(primaryKey, kitGroup);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			KitGroup kitGroup = (KitGroup)entityCache.getResult(KitGroupModelImpl.ENTITY_CACHE_ENABLED,
					KitGroupImpl.class, primaryKey);

			if (kitGroup == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, kitGroup);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_KITGROUP_WHERE_PKS_IN);

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

			for (KitGroup kitGroup : (List<KitGroup>)q.list()) {
				map.put(kitGroup.getPrimaryKeyObj(), kitGroup);

				cacheResult(kitGroup);

				uncachedPrimaryKeys.remove(kitGroup.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(KitGroupModelImpl.ENTITY_CACHE_ENABLED,
					KitGroupImpl.class, primaryKey, _nullKitGroup);
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
	 * Returns all the kit groups.
	 *
	 * @return the kit groups
	 */
	@Override
	public List<KitGroup> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kit groups
	 * @param end the upper bound of the range of kit groups (not inclusive)
	 * @return the range of kit groups
	 */
	@Override
	public List<KitGroup> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the kit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kit groups
	 * @param end the upper bound of the range of kit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of kit groups
	 */
	@Override
	public List<KitGroup> findAll(int start, int end,
		OrderByComparator<KitGroup> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the kit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kit groups
	 * @param end the upper bound of the range of kit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of kit groups
	 */
	@Override
	public List<KitGroup> findAll(int start, int end,
		OrderByComparator<KitGroup> orderByComparator, boolean retrieveFromCache) {
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

		List<KitGroup> list = null;

		if (retrieveFromCache) {
			list = (List<KitGroup>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_KITGROUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_KITGROUP;

				if (pagination) {
					sql = sql.concat(KitGroupModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<KitGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<KitGroup>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the kit groups from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (KitGroup kitGroup : findAll()) {
			remove(kitGroup);
		}
	}

	/**
	 * Returns the number of kit groups.
	 *
	 * @return the number of kit groups
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_KITGROUP);

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
		return KitGroupModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the kit group persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(KitGroupImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_KITGROUP = "SELECT kitGroup FROM KitGroup kitGroup";
	private static final String _SQL_SELECT_KITGROUP_WHERE_PKS_IN = "SELECT kitGroup FROM KitGroup kitGroup WHERE kitGroupId IN (";
	private static final String _SQL_SELECT_KITGROUP_WHERE = "SELECT kitGroup FROM KitGroup kitGroup WHERE ";
	private static final String _SQL_COUNT_KITGROUP = "SELECT COUNT(kitGroup) FROM KitGroup kitGroup";
	private static final String _SQL_COUNT_KITGROUP_WHERE = "SELECT COUNT(kitGroup) FROM KitGroup kitGroup WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "kitGroup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No KitGroup exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No KitGroup exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(KitGroupPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"group"
			});
	private static final KitGroup _nullKitGroup = new KitGroupImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<KitGroup> toCacheModel() {
				return _nullKitGroupCacheModel;
			}
		};

	private static final CacheModel<KitGroup> _nullKitGroupCacheModel = new CacheModel<KitGroup>() {
			@Override
			public KitGroup toEntityModel() {
				return _nullKitGroup;
			}
		};
}