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

package at.graz.meduni.liferay.portlet.saat.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.liferay.portlet.saat.exception.NoSuchDictionaryDictionaryLinkException;
import at.graz.meduni.liferay.portlet.saat.model.DictionaryDictionaryLink;
import at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryDictionaryLinkImpl;
import at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryDictionaryLinkModelImpl;
import at.graz.meduni.liferay.portlet.saat.service.persistence.DictionaryDictionaryLinkPersistence;

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
 * The persistence implementation for the dictionary dictionary link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see DictionaryDictionaryLinkPersistence
 * @see at.graz.meduni.liferay.portlet.saat.service.persistence.DictionaryDictionaryLinkUtil
 * @generated
 */
@ProviderType
public class DictionaryDictionaryLinkPersistenceImpl extends BasePersistenceImpl<DictionaryDictionaryLink>
	implements DictionaryDictionaryLinkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DictionaryDictionaryLinkUtil} to access the dictionary dictionary link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DictionaryDictionaryLinkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID =
		new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentId",
			new String[] { Long.class.getName() },
			DictionaryDictionaryLinkModelImpl.DICTIONARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTID = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the dictionary dictionary links where dictionaryId = &#63;.
	 *
	 * @param dictionaryId the dictionary ID
	 * @return the matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByParentId(long dictionaryId) {
		return findByParentId(dictionaryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dictionary dictionary links where dictionaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictionaryId the dictionary ID
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @return the range of matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByParentId(long dictionaryId,
		int start, int end) {
		return findByParentId(dictionaryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionary dictionary links where dictionaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictionaryId the dictionary ID
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByParentId(long dictionaryId,
		int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return findByParentId(dictionaryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dictionary dictionary links where dictionaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictionaryId the dictionary ID
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByParentId(long dictionaryId,
		int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] { dictionaryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] {
					dictionaryId,
					
					start, end, orderByComparator
				};
		}

		List<DictionaryDictionaryLink> list = null;

		if (retrieveFromCache) {
			list = (List<DictionaryDictionaryLink>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DictionaryDictionaryLink dictionaryDictionaryLink : list) {
					if ((dictionaryId != dictionaryDictionaryLink.getDictionaryId())) {
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

			query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_DICTIONARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictionaryDictionaryLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictionaryId);

				if (!pagination) {
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
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
	 * Returns the first dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	 *
	 * @param dictionaryId the dictionary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink findByParentId_First(long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = fetchByParentId_First(dictionaryId,
				orderByComparator);

		if (dictionaryDictionaryLink != null) {
			return dictionaryDictionaryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictionaryId=");
		msg.append(dictionaryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryDictionaryLinkException(msg.toString());
	}

	/**
	 * Returns the first dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	 *
	 * @param dictionaryId the dictionary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink fetchByParentId_First(long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		List<DictionaryDictionaryLink> list = findByParentId(dictionaryId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	 *
	 * @param dictionaryId the dictionary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink findByParentId_Last(long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = fetchByParentId_Last(dictionaryId,
				orderByComparator);

		if (dictionaryDictionaryLink != null) {
			return dictionaryDictionaryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictionaryId=");
		msg.append(dictionaryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryDictionaryLinkException(msg.toString());
	}

	/**
	 * Returns the last dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	 *
	 * @param dictionaryId the dictionary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink fetchByParentId_Last(long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		int count = countByParentId(dictionaryId);

		if (count == 0) {
			return null;
		}

		List<DictionaryDictionaryLink> list = findByParentId(dictionaryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dictionary dictionary links before and after the current dictionary dictionary link in the ordered set where dictionaryId = &#63;.
	 *
	 * @param dictionaryDictionaryLinkId the primary key of the current dictionary dictionary link
	 * @param dictionaryId the dictionary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	 */
	@Override
	public DictionaryDictionaryLink[] findByParentId_PrevAndNext(
		long dictionaryDictionaryLinkId, long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = findByPrimaryKey(dictionaryDictionaryLinkId);

		Session session = null;

		try {
			session = openSession();

			DictionaryDictionaryLink[] array = new DictionaryDictionaryLinkImpl[3];

			array[0] = getByParentId_PrevAndNext(session,
					dictionaryDictionaryLink, dictionaryId, orderByComparator,
					true);

			array[1] = dictionaryDictionaryLink;

			array[2] = getByParentId_PrevAndNext(session,
					dictionaryDictionaryLink, dictionaryId, orderByComparator,
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

	protected DictionaryDictionaryLink getByParentId_PrevAndNext(
		Session session, DictionaryDictionaryLink dictionaryDictionaryLink,
		long dictionaryId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
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

		query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE);

		query.append(_FINDER_COLUMN_PARENTID_DICTIONARYID_2);

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
			query.append(DictionaryDictionaryLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dictionaryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictionaryDictionaryLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictionaryDictionaryLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dictionary dictionary links where dictionaryId = &#63; from the database.
	 *
	 * @param dictionaryId the dictionary ID
	 */
	@Override
	public void removeByParentId(long dictionaryId) {
		for (DictionaryDictionaryLink dictionaryDictionaryLink : findByParentId(
				dictionaryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dictionaryDictionaryLink);
		}
	}

	/**
	 * Returns the number of dictionary dictionary links where dictionaryId = &#63;.
	 *
	 * @param dictionaryId the dictionary ID
	 * @return the number of matching dictionary dictionary links
	 */
	@Override
	public int countByParentId(long dictionaryId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTID;

		Object[] finderArgs = new Object[] { dictionaryId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DICTIONARYDICTIONARYLINK_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_DICTIONARYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictionaryId);

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

	private static final String _FINDER_COLUMN_PARENTID_DICTIONARYID_2 = "dictionaryDictionaryLink.dictionaryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CHILDRENID =
		new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByChildrenId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHILDRENID =
		new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByChildrenId",
			new String[] { Long.class.getName() },
			DictionaryDictionaryLinkModelImpl.DICTIONARYADDICTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHILDRENID = new FinderPath(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByChildrenId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the dictionary dictionary links where dictionaryAddictionId = &#63;.
	 *
	 * @param dictionaryAddictionId the dictionary addiction ID
	 * @return the matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByChildrenId(
		long dictionaryAddictionId) {
		return findByChildrenId(dictionaryAddictionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dictionary dictionary links where dictionaryAddictionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictionaryAddictionId the dictionary addiction ID
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @return the range of matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByChildrenId(
		long dictionaryAddictionId, int start, int end) {
		return findByChildrenId(dictionaryAddictionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionary dictionary links where dictionaryAddictionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictionaryAddictionId the dictionary addiction ID
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByChildrenId(
		long dictionaryAddictionId, int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return findByChildrenId(dictionaryAddictionId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dictionary dictionary links where dictionaryAddictionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dictionaryAddictionId the dictionary addiction ID
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findByChildrenId(
		long dictionaryAddictionId, int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHILDRENID;
			finderArgs = new Object[] { dictionaryAddictionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CHILDRENID;
			finderArgs = new Object[] {
					dictionaryAddictionId,
					
					start, end, orderByComparator
				};
		}

		List<DictionaryDictionaryLink> list = null;

		if (retrieveFromCache) {
			list = (List<DictionaryDictionaryLink>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DictionaryDictionaryLink dictionaryDictionaryLink : list) {
					if ((dictionaryAddictionId != dictionaryDictionaryLink.getDictionaryAddictionId())) {
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

			query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE);

			query.append(_FINDER_COLUMN_CHILDRENID_DICTIONARYADDICTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictionaryDictionaryLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictionaryAddictionId);

				if (!pagination) {
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
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
	 * Returns the first dictionary dictionary link in the ordered set where dictionaryAddictionId = &#63;.
	 *
	 * @param dictionaryAddictionId the dictionary addiction ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink findByChildrenId_First(
		long dictionaryAddictionId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = fetchByChildrenId_First(dictionaryAddictionId,
				orderByComparator);

		if (dictionaryDictionaryLink != null) {
			return dictionaryDictionaryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictionaryAddictionId=");
		msg.append(dictionaryAddictionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryDictionaryLinkException(msg.toString());
	}

	/**
	 * Returns the first dictionary dictionary link in the ordered set where dictionaryAddictionId = &#63;.
	 *
	 * @param dictionaryAddictionId the dictionary addiction ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink fetchByChildrenId_First(
		long dictionaryAddictionId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		List<DictionaryDictionaryLink> list = findByChildrenId(dictionaryAddictionId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dictionary dictionary link in the ordered set where dictionaryAddictionId = &#63;.
	 *
	 * @param dictionaryAddictionId the dictionary addiction ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink findByChildrenId_Last(
		long dictionaryAddictionId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = fetchByChildrenId_Last(dictionaryAddictionId,
				orderByComparator);

		if (dictionaryDictionaryLink != null) {
			return dictionaryDictionaryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dictionaryAddictionId=");
		msg.append(dictionaryAddictionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryDictionaryLinkException(msg.toString());
	}

	/**
	 * Returns the last dictionary dictionary link in the ordered set where dictionaryAddictionId = &#63;.
	 *
	 * @param dictionaryAddictionId the dictionary addiction ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary dictionary link, or <code>null</code> if a matching dictionary dictionary link could not be found
	 */
	@Override
	public DictionaryDictionaryLink fetchByChildrenId_Last(
		long dictionaryAddictionId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		int count = countByChildrenId(dictionaryAddictionId);

		if (count == 0) {
			return null;
		}

		List<DictionaryDictionaryLink> list = findByChildrenId(dictionaryAddictionId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dictionary dictionary links before and after the current dictionary dictionary link in the ordered set where dictionaryAddictionId = &#63;.
	 *
	 * @param dictionaryDictionaryLinkId the primary key of the current dictionary dictionary link
	 * @param dictionaryAddictionId the dictionary addiction ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	 */
	@Override
	public DictionaryDictionaryLink[] findByChildrenId_PrevAndNext(
		long dictionaryDictionaryLinkId, long dictionaryAddictionId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = findByPrimaryKey(dictionaryDictionaryLinkId);

		Session session = null;

		try {
			session = openSession();

			DictionaryDictionaryLink[] array = new DictionaryDictionaryLinkImpl[3];

			array[0] = getByChildrenId_PrevAndNext(session,
					dictionaryDictionaryLink, dictionaryAddictionId,
					orderByComparator, true);

			array[1] = dictionaryDictionaryLink;

			array[2] = getByChildrenId_PrevAndNext(session,
					dictionaryDictionaryLink, dictionaryAddictionId,
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

	protected DictionaryDictionaryLink getByChildrenId_PrevAndNext(
		Session session, DictionaryDictionaryLink dictionaryDictionaryLink,
		long dictionaryAddictionId,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
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

		query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE);

		query.append(_FINDER_COLUMN_CHILDRENID_DICTIONARYADDICTIONID_2);

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
			query.append(DictionaryDictionaryLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(dictionaryAddictionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictionaryDictionaryLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DictionaryDictionaryLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dictionary dictionary links where dictionaryAddictionId = &#63; from the database.
	 *
	 * @param dictionaryAddictionId the dictionary addiction ID
	 */
	@Override
	public void removeByChildrenId(long dictionaryAddictionId) {
		for (DictionaryDictionaryLink dictionaryDictionaryLink : findByChildrenId(
				dictionaryAddictionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(dictionaryDictionaryLink);
		}
	}

	/**
	 * Returns the number of dictionary dictionary links where dictionaryAddictionId = &#63;.
	 *
	 * @param dictionaryAddictionId the dictionary addiction ID
	 * @return the number of matching dictionary dictionary links
	 */
	@Override
	public int countByChildrenId(long dictionaryAddictionId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CHILDRENID;

		Object[] finderArgs = new Object[] { dictionaryAddictionId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DICTIONARYDICTIONARYLINK_WHERE);

			query.append(_FINDER_COLUMN_CHILDRENID_DICTIONARYADDICTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dictionaryAddictionId);

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

	private static final String _FINDER_COLUMN_CHILDRENID_DICTIONARYADDICTIONID_2 =
		"dictionaryDictionaryLink.dictionaryAddictionId = ?";

	public DictionaryDictionaryLinkPersistenceImpl() {
		setModelClass(DictionaryDictionaryLink.class);
	}

	/**
	 * Caches the dictionary dictionary link in the entity cache if it is enabled.
	 *
	 * @param dictionaryDictionaryLink the dictionary dictionary link
	 */
	@Override
	public void cacheResult(DictionaryDictionaryLink dictionaryDictionaryLink) {
		entityCache.putResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			dictionaryDictionaryLink.getPrimaryKey(), dictionaryDictionaryLink);

		dictionaryDictionaryLink.resetOriginalValues();
	}

	/**
	 * Caches the dictionary dictionary links in the entity cache if it is enabled.
	 *
	 * @param dictionaryDictionaryLinks the dictionary dictionary links
	 */
	@Override
	public void cacheResult(
		List<DictionaryDictionaryLink> dictionaryDictionaryLinks) {
		for (DictionaryDictionaryLink dictionaryDictionaryLink : dictionaryDictionaryLinks) {
			if (entityCache.getResult(
						DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
						DictionaryDictionaryLinkImpl.class,
						dictionaryDictionaryLink.getPrimaryKey()) == null) {
				cacheResult(dictionaryDictionaryLink);
			}
			else {
				dictionaryDictionaryLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dictionary dictionary links.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DictionaryDictionaryLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dictionary dictionary link.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DictionaryDictionaryLink dictionaryDictionaryLink) {
		entityCache.removeResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			dictionaryDictionaryLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<DictionaryDictionaryLink> dictionaryDictionaryLinks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DictionaryDictionaryLink dictionaryDictionaryLink : dictionaryDictionaryLinks) {
			entityCache.removeResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
				DictionaryDictionaryLinkImpl.class,
				dictionaryDictionaryLink.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dictionary dictionary link with the primary key. Does not add the dictionary dictionary link to the database.
	 *
	 * @param dictionaryDictionaryLinkId the primary key for the new dictionary dictionary link
	 * @return the new dictionary dictionary link
	 */
	@Override
	public DictionaryDictionaryLink create(long dictionaryDictionaryLinkId) {
		DictionaryDictionaryLink dictionaryDictionaryLink = new DictionaryDictionaryLinkImpl();

		dictionaryDictionaryLink.setNew(true);
		dictionaryDictionaryLink.setPrimaryKey(dictionaryDictionaryLinkId);

		dictionaryDictionaryLink.setCompanyId(companyProvider.getCompanyId());

		return dictionaryDictionaryLink;
	}

	/**
	 * Removes the dictionary dictionary link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dictionaryDictionaryLinkId the primary key of the dictionary dictionary link
	 * @return the dictionary dictionary link that was removed
	 * @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	 */
	@Override
	public DictionaryDictionaryLink remove(long dictionaryDictionaryLinkId)
		throws NoSuchDictionaryDictionaryLinkException {
		return remove((Serializable)dictionaryDictionaryLinkId);
	}

	/**
	 * Removes the dictionary dictionary link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dictionary dictionary link
	 * @return the dictionary dictionary link that was removed
	 * @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	 */
	@Override
	public DictionaryDictionaryLink remove(Serializable primaryKey)
		throws NoSuchDictionaryDictionaryLinkException {
		Session session = null;

		try {
			session = openSession();

			DictionaryDictionaryLink dictionaryDictionaryLink = (DictionaryDictionaryLink)session.get(DictionaryDictionaryLinkImpl.class,
					primaryKey);

			if (dictionaryDictionaryLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDictionaryDictionaryLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dictionaryDictionaryLink);
		}
		catch (NoSuchDictionaryDictionaryLinkException nsee) {
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
	protected DictionaryDictionaryLink removeImpl(
		DictionaryDictionaryLink dictionaryDictionaryLink) {
		dictionaryDictionaryLink = toUnwrappedModel(dictionaryDictionaryLink);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dictionaryDictionaryLink)) {
				dictionaryDictionaryLink = (DictionaryDictionaryLink)session.get(DictionaryDictionaryLinkImpl.class,
						dictionaryDictionaryLink.getPrimaryKeyObj());
			}

			if (dictionaryDictionaryLink != null) {
				session.delete(dictionaryDictionaryLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dictionaryDictionaryLink != null) {
			clearCache(dictionaryDictionaryLink);
		}

		return dictionaryDictionaryLink;
	}

	@Override
	public DictionaryDictionaryLink updateImpl(
		DictionaryDictionaryLink dictionaryDictionaryLink) {
		dictionaryDictionaryLink = toUnwrappedModel(dictionaryDictionaryLink);

		boolean isNew = dictionaryDictionaryLink.isNew();

		DictionaryDictionaryLinkModelImpl dictionaryDictionaryLinkModelImpl = (DictionaryDictionaryLinkModelImpl)dictionaryDictionaryLink;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (dictionaryDictionaryLink.getCreateDate() == null)) {
			if (serviceContext == null) {
				dictionaryDictionaryLink.setCreateDate(now);
			}
			else {
				dictionaryDictionaryLink.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!dictionaryDictionaryLinkModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dictionaryDictionaryLink.setModifiedDate(now);
			}
			else {
				dictionaryDictionaryLink.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (dictionaryDictionaryLink.isNew()) {
				session.save(dictionaryDictionaryLink);

				dictionaryDictionaryLink.setNew(false);
			}
			else {
				dictionaryDictionaryLink = (DictionaryDictionaryLink)session.merge(dictionaryDictionaryLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DictionaryDictionaryLinkModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dictionaryDictionaryLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictionaryDictionaryLinkModelImpl.getOriginalDictionaryId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);

				args = new Object[] {
						dictionaryDictionaryLinkModelImpl.getDictionaryId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);
			}

			if ((dictionaryDictionaryLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHILDRENID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictionaryDictionaryLinkModelImpl.getOriginalDictionaryAddictionId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CHILDRENID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHILDRENID,
					args);

				args = new Object[] {
						dictionaryDictionaryLinkModelImpl.getDictionaryAddictionId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CHILDRENID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHILDRENID,
					args);
			}
		}

		entityCache.putResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryDictionaryLinkImpl.class,
			dictionaryDictionaryLink.getPrimaryKey(), dictionaryDictionaryLink,
			false);

		dictionaryDictionaryLink.resetOriginalValues();

		return dictionaryDictionaryLink;
	}

	protected DictionaryDictionaryLink toUnwrappedModel(
		DictionaryDictionaryLink dictionaryDictionaryLink) {
		if (dictionaryDictionaryLink instanceof DictionaryDictionaryLinkImpl) {
			return dictionaryDictionaryLink;
		}

		DictionaryDictionaryLinkImpl dictionaryDictionaryLinkImpl = new DictionaryDictionaryLinkImpl();

		dictionaryDictionaryLinkImpl.setNew(dictionaryDictionaryLink.isNew());
		dictionaryDictionaryLinkImpl.setPrimaryKey(dictionaryDictionaryLink.getPrimaryKey());

		dictionaryDictionaryLinkImpl.setDictionaryDictionaryLinkId(dictionaryDictionaryLink.getDictionaryDictionaryLinkId());
		dictionaryDictionaryLinkImpl.setCompanyId(dictionaryDictionaryLink.getCompanyId());
		dictionaryDictionaryLinkImpl.setUserId(dictionaryDictionaryLink.getUserId());
		dictionaryDictionaryLinkImpl.setUserName(dictionaryDictionaryLink.getUserName());
		dictionaryDictionaryLinkImpl.setCreateDate(dictionaryDictionaryLink.getCreateDate());
		dictionaryDictionaryLinkImpl.setModifiedDate(dictionaryDictionaryLink.getModifiedDate());
		dictionaryDictionaryLinkImpl.setDictionaryId(dictionaryDictionaryLink.getDictionaryId());
		dictionaryDictionaryLinkImpl.setDictionaryAddictionId(dictionaryDictionaryLink.getDictionaryAddictionId());

		return dictionaryDictionaryLinkImpl;
	}

	/**
	 * Returns the dictionary dictionary link with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dictionary dictionary link
	 * @return the dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	 */
	@Override
	public DictionaryDictionaryLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDictionaryDictionaryLinkException {
		DictionaryDictionaryLink dictionaryDictionaryLink = fetchByPrimaryKey(primaryKey);

		if (dictionaryDictionaryLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDictionaryDictionaryLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dictionaryDictionaryLink;
	}

	/**
	 * Returns the dictionary dictionary link with the primary key or throws a {@link NoSuchDictionaryDictionaryLinkException} if it could not be found.
	 *
	 * @param dictionaryDictionaryLinkId the primary key of the dictionary dictionary link
	 * @return the dictionary dictionary link
	 * @throws NoSuchDictionaryDictionaryLinkException if a dictionary dictionary link with the primary key could not be found
	 */
	@Override
	public DictionaryDictionaryLink findByPrimaryKey(
		long dictionaryDictionaryLinkId)
		throws NoSuchDictionaryDictionaryLinkException {
		return findByPrimaryKey((Serializable)dictionaryDictionaryLinkId);
	}

	/**
	 * Returns the dictionary dictionary link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dictionary dictionary link
	 * @return the dictionary dictionary link, or <code>null</code> if a dictionary dictionary link with the primary key could not be found
	 */
	@Override
	public DictionaryDictionaryLink fetchByPrimaryKey(Serializable primaryKey) {
		DictionaryDictionaryLink dictionaryDictionaryLink = (DictionaryDictionaryLink)entityCache.getResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
				DictionaryDictionaryLinkImpl.class, primaryKey);

		if (dictionaryDictionaryLink == _nullDictionaryDictionaryLink) {
			return null;
		}

		if (dictionaryDictionaryLink == null) {
			Session session = null;

			try {
				session = openSession();

				dictionaryDictionaryLink = (DictionaryDictionaryLink)session.get(DictionaryDictionaryLinkImpl.class,
						primaryKey);

				if (dictionaryDictionaryLink != null) {
					cacheResult(dictionaryDictionaryLink);
				}
				else {
					entityCache.putResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
						DictionaryDictionaryLinkImpl.class, primaryKey,
						_nullDictionaryDictionaryLink);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
					DictionaryDictionaryLinkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dictionaryDictionaryLink;
	}

	/**
	 * Returns the dictionary dictionary link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dictionaryDictionaryLinkId the primary key of the dictionary dictionary link
	 * @return the dictionary dictionary link, or <code>null</code> if a dictionary dictionary link with the primary key could not be found
	 */
	@Override
	public DictionaryDictionaryLink fetchByPrimaryKey(
		long dictionaryDictionaryLinkId) {
		return fetchByPrimaryKey((Serializable)dictionaryDictionaryLinkId);
	}

	@Override
	public Map<Serializable, DictionaryDictionaryLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DictionaryDictionaryLink> map = new HashMap<Serializable, DictionaryDictionaryLink>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DictionaryDictionaryLink dictionaryDictionaryLink = fetchByPrimaryKey(primaryKey);

			if (dictionaryDictionaryLink != null) {
				map.put(primaryKey, dictionaryDictionaryLink);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			DictionaryDictionaryLink dictionaryDictionaryLink = (DictionaryDictionaryLink)entityCache.getResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
					DictionaryDictionaryLinkImpl.class, primaryKey);

			if (dictionaryDictionaryLink == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, dictionaryDictionaryLink);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE_PKS_IN);

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

			for (DictionaryDictionaryLink dictionaryDictionaryLink : (List<DictionaryDictionaryLink>)q.list()) {
				map.put(dictionaryDictionaryLink.getPrimaryKeyObj(),
					dictionaryDictionaryLink);

				cacheResult(dictionaryDictionaryLink);

				uncachedPrimaryKeys.remove(dictionaryDictionaryLink.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DictionaryDictionaryLinkModelImpl.ENTITY_CACHE_ENABLED,
					DictionaryDictionaryLinkImpl.class, primaryKey,
					_nullDictionaryDictionaryLink);
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
	 * Returns all the dictionary dictionary links.
	 *
	 * @return the dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dictionary dictionary links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @return the range of dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionary dictionary links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findAll(int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dictionary dictionary links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryDictionaryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dictionary dictionary links
	 * @param end the upper bound of the range of dictionary dictionary links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of dictionary dictionary links
	 */
	@Override
	public List<DictionaryDictionaryLink> findAll(int start, int end,
		OrderByComparator<DictionaryDictionaryLink> orderByComparator,
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

		List<DictionaryDictionaryLink> list = null;

		if (retrieveFromCache) {
			list = (List<DictionaryDictionaryLink>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DICTIONARYDICTIONARYLINK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DICTIONARYDICTIONARYLINK;

				if (pagination) {
					sql = sql.concat(DictionaryDictionaryLinkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DictionaryDictionaryLink>)QueryUtil.list(q,
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
	 * Removes all the dictionary dictionary links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DictionaryDictionaryLink dictionaryDictionaryLink : findAll()) {
			remove(dictionaryDictionaryLink);
		}
	}

	/**
	 * Returns the number of dictionary dictionary links.
	 *
	 * @return the number of dictionary dictionary links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DICTIONARYDICTIONARYLINK);

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
		return DictionaryDictionaryLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dictionary dictionary link persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DictionaryDictionaryLinkImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_DICTIONARYDICTIONARYLINK = "SELECT dictionaryDictionaryLink FROM DictionaryDictionaryLink dictionaryDictionaryLink";
	private static final String _SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE_PKS_IN =
		"SELECT dictionaryDictionaryLink FROM DictionaryDictionaryLink dictionaryDictionaryLink WHERE dictionaryDictionaryLinkId IN (";
	private static final String _SQL_SELECT_DICTIONARYDICTIONARYLINK_WHERE = "SELECT dictionaryDictionaryLink FROM DictionaryDictionaryLink dictionaryDictionaryLink WHERE ";
	private static final String _SQL_COUNT_DICTIONARYDICTIONARYLINK = "SELECT COUNT(dictionaryDictionaryLink) FROM DictionaryDictionaryLink dictionaryDictionaryLink";
	private static final String _SQL_COUNT_DICTIONARYDICTIONARYLINK_WHERE = "SELECT COUNT(dictionaryDictionaryLink) FROM DictionaryDictionaryLink dictionaryDictionaryLink WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dictionaryDictionaryLink.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DictionaryDictionaryLink exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DictionaryDictionaryLink exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DictionaryDictionaryLinkPersistenceImpl.class);
	private static final DictionaryDictionaryLink _nullDictionaryDictionaryLink = new DictionaryDictionaryLinkImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DictionaryDictionaryLink> toCacheModel() {
				return _nullDictionaryDictionaryLinkCacheModel;
			}
		};

	private static final CacheModel<DictionaryDictionaryLink> _nullDictionaryDictionaryLinkCacheModel =
		new CacheModel<DictionaryDictionaryLink>() {
			@Override
			public DictionaryDictionaryLink toEntityModel() {
				return _nullDictionaryDictionaryLink;
			}
		};
}