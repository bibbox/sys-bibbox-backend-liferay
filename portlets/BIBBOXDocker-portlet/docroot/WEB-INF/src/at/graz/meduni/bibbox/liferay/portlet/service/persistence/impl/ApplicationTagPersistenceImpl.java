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

import at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchApplicationTagException;
import at.graz.meduni.bibbox.liferay.portlet.model.ApplicationTag;
import at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationTagImpl;
import at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationTagModelImpl;
import at.graz.meduni.bibbox.liferay.portlet.service.persistence.ApplicationTagPersistence;

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
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the application tag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationTagPersistence
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.ApplicationTagUtil
 * @generated
 */
@ProviderType
public class ApplicationTagPersistenceImpl extends BasePersistenceImpl<ApplicationTag>
	implements ApplicationTagPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ApplicationTagUtil} to access the application tag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ApplicationTagImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ApplicationTagModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationTagModelImpl.FINDER_CACHE_ENABLED,
			ApplicationTagImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ApplicationTagModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationTagModelImpl.FINDER_CACHE_ENABLED,
			ApplicationTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ApplicationTagModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPLICATIONSTOREITEMID =
		new FinderPath(ApplicationTagModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationTagModelImpl.FINDER_CACHE_ENABLED,
			ApplicationTagImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByApplicationStoreItemId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONSTOREITEMID =
		new FinderPath(ApplicationTagModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationTagModelImpl.FINDER_CACHE_ENABLED,
			ApplicationTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByApplicationStoreItemId",
			new String[] { Long.class.getName() },
			ApplicationTagModelImpl.APPLICATIONSTOREITEMID_COLUMN_BITMASK |
			ApplicationTagModelImpl.TAG_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPLICATIONSTOREITEMID = new FinderPath(ApplicationTagModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByApplicationStoreItemId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the application tags where applicationStoreItemId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @return the matching application tags
	 */
	@Override
	public List<ApplicationTag> findByApplicationStoreItemId(
		long applicationStoreItemId) {
		return findByApplicationStoreItemId(applicationStoreItemId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the application tags where applicationStoreItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param start the lower bound of the range of application tags
	 * @param end the upper bound of the range of application tags (not inclusive)
	 * @return the range of matching application tags
	 */
	@Override
	public List<ApplicationTag> findByApplicationStoreItemId(
		long applicationStoreItemId, int start, int end) {
		return findByApplicationStoreItemId(applicationStoreItemId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the application tags where applicationStoreItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param start the lower bound of the range of application tags
	 * @param end the upper bound of the range of application tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching application tags
	 */
	@Override
	public List<ApplicationTag> findByApplicationStoreItemId(
		long applicationStoreItemId, int start, int end,
		OrderByComparator<ApplicationTag> orderByComparator) {
		return findByApplicationStoreItemId(applicationStoreItemId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the application tags where applicationStoreItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param start the lower bound of the range of application tags
	 * @param end the upper bound of the range of application tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching application tags
	 */
	@Override
	public List<ApplicationTag> findByApplicationStoreItemId(
		long applicationStoreItemId, int start, int end,
		OrderByComparator<ApplicationTag> orderByComparator,
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

		List<ApplicationTag> list = null;

		if (retrieveFromCache) {
			list = (List<ApplicationTag>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ApplicationTag applicationTag : list) {
					if ((applicationStoreItemId != applicationTag.getApplicationStoreItemId())) {
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

			query.append(_SQL_SELECT_APPLICATIONTAG_WHERE);

			query.append(_FINDER_COLUMN_APPLICATIONSTOREITEMID_APPLICATIONSTOREITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApplicationTagModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(applicationStoreItemId);

				if (!pagination) {
					list = (List<ApplicationTag>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ApplicationTag>)QueryUtil.list(q,
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
	 * Returns the first application tag in the ordered set where applicationStoreItemId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application tag
	 * @throws NoSuchApplicationTagException if a matching application tag could not be found
	 */
	@Override
	public ApplicationTag findByApplicationStoreItemId_First(
		long applicationStoreItemId,
		OrderByComparator<ApplicationTag> orderByComparator)
		throws NoSuchApplicationTagException {
		ApplicationTag applicationTag = fetchByApplicationStoreItemId_First(applicationStoreItemId,
				orderByComparator);

		if (applicationTag != null) {
			return applicationTag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationStoreItemId=");
		msg.append(applicationStoreItemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationTagException(msg.toString());
	}

	/**
	 * Returns the first application tag in the ordered set where applicationStoreItemId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application tag, or <code>null</code> if a matching application tag could not be found
	 */
	@Override
	public ApplicationTag fetchByApplicationStoreItemId_First(
		long applicationStoreItemId,
		OrderByComparator<ApplicationTag> orderByComparator) {
		List<ApplicationTag> list = findByApplicationStoreItemId(applicationStoreItemId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last application tag in the ordered set where applicationStoreItemId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application tag
	 * @throws NoSuchApplicationTagException if a matching application tag could not be found
	 */
	@Override
	public ApplicationTag findByApplicationStoreItemId_Last(
		long applicationStoreItemId,
		OrderByComparator<ApplicationTag> orderByComparator)
		throws NoSuchApplicationTagException {
		ApplicationTag applicationTag = fetchByApplicationStoreItemId_Last(applicationStoreItemId,
				orderByComparator);

		if (applicationTag != null) {
			return applicationTag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("applicationStoreItemId=");
		msg.append(applicationStoreItemId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationTagException(msg.toString());
	}

	/**
	 * Returns the last application tag in the ordered set where applicationStoreItemId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application tag, or <code>null</code> if a matching application tag could not be found
	 */
	@Override
	public ApplicationTag fetchByApplicationStoreItemId_Last(
		long applicationStoreItemId,
		OrderByComparator<ApplicationTag> orderByComparator) {
		int count = countByApplicationStoreItemId(applicationStoreItemId);

		if (count == 0) {
			return null;
		}

		List<ApplicationTag> list = findByApplicationStoreItemId(applicationStoreItemId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the application tags before and after the current application tag in the ordered set where applicationStoreItemId = &#63;.
	 *
	 * @param applicationTagsId the primary key of the current application tag
	 * @param applicationStoreItemId the application store item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next application tag
	 * @throws NoSuchApplicationTagException if a application tag with the primary key could not be found
	 */
	@Override
	public ApplicationTag[] findByApplicationStoreItemId_PrevAndNext(
		long applicationTagsId, long applicationStoreItemId,
		OrderByComparator<ApplicationTag> orderByComparator)
		throws NoSuchApplicationTagException {
		ApplicationTag applicationTag = findByPrimaryKey(applicationTagsId);

		Session session = null;

		try {
			session = openSession();

			ApplicationTag[] array = new ApplicationTagImpl[3];

			array[0] = getByApplicationStoreItemId_PrevAndNext(session,
					applicationTag, applicationStoreItemId, orderByComparator,
					true);

			array[1] = applicationTag;

			array[2] = getByApplicationStoreItemId_PrevAndNext(session,
					applicationTag, applicationStoreItemId, orderByComparator,
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

	protected ApplicationTag getByApplicationStoreItemId_PrevAndNext(
		Session session, ApplicationTag applicationTag,
		long applicationStoreItemId,
		OrderByComparator<ApplicationTag> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPLICATIONTAG_WHERE);

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
			query.append(ApplicationTagModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(applicationStoreItemId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(applicationTag);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ApplicationTag> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the application tags where applicationStoreItemId = &#63; from the database.
	 *
	 * @param applicationStoreItemId the application store item ID
	 */
	@Override
	public void removeByApplicationStoreItemId(long applicationStoreItemId) {
		for (ApplicationTag applicationTag : findByApplicationStoreItemId(
				applicationStoreItemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(applicationTag);
		}
	}

	/**
	 * Returns the number of application tags where applicationStoreItemId = &#63;.
	 *
	 * @param applicationStoreItemId the application store item ID
	 * @return the number of matching application tags
	 */
	@Override
	public int countByApplicationStoreItemId(long applicationStoreItemId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPLICATIONSTOREITEMID;

		Object[] finderArgs = new Object[] { applicationStoreItemId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPLICATIONTAG_WHERE);

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
		"applicationTag.applicationStoreItemId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAG = new FinderPath(ApplicationTagModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationTagModelImpl.FINDER_CACHE_ENABLED,
			ApplicationTagImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTag",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG = new FinderPath(ApplicationTagModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationTagModelImpl.FINDER_CACHE_ENABLED,
			ApplicationTagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTag",
			new String[] { String.class.getName() },
			ApplicationTagModelImpl.TAG_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAG = new FinderPath(ApplicationTagModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationTagModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTag",
			new String[] { String.class.getName() });

	/**
	 * Returns all the application tags where tag = &#63;.
	 *
	 * @param tag the tag
	 * @return the matching application tags
	 */
	@Override
	public List<ApplicationTag> findByTag(String tag) {
		return findByTag(tag, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the application tags where tag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tag the tag
	 * @param start the lower bound of the range of application tags
	 * @param end the upper bound of the range of application tags (not inclusive)
	 * @return the range of matching application tags
	 */
	@Override
	public List<ApplicationTag> findByTag(String tag, int start, int end) {
		return findByTag(tag, start, end, null);
	}

	/**
	 * Returns an ordered range of all the application tags where tag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tag the tag
	 * @param start the lower bound of the range of application tags
	 * @param end the upper bound of the range of application tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching application tags
	 */
	@Override
	public List<ApplicationTag> findByTag(String tag, int start, int end,
		OrderByComparator<ApplicationTag> orderByComparator) {
		return findByTag(tag, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the application tags where tag = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tag the tag
	 * @param start the lower bound of the range of application tags
	 * @param end the upper bound of the range of application tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching application tags
	 */
	@Override
	public List<ApplicationTag> findByTag(String tag, int start, int end,
		OrderByComparator<ApplicationTag> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG;
			finderArgs = new Object[] { tag };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TAG;
			finderArgs = new Object[] { tag, start, end, orderByComparator };
		}

		List<ApplicationTag> list = null;

		if (retrieveFromCache) {
			list = (List<ApplicationTag>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ApplicationTag applicationTag : list) {
					if (!Objects.equals(tag, applicationTag.getTag())) {
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

			query.append(_SQL_SELECT_APPLICATIONTAG_WHERE);

			boolean bindTag = false;

			if (tag == null) {
				query.append(_FINDER_COLUMN_TAG_TAG_1);
			}
			else if (tag.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TAG_TAG_3);
			}
			else {
				bindTag = true;

				query.append(_FINDER_COLUMN_TAG_TAG_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ApplicationTagModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTag) {
					qPos.add(tag);
				}

				if (!pagination) {
					list = (List<ApplicationTag>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ApplicationTag>)QueryUtil.list(q,
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
	 * Returns the first application tag in the ordered set where tag = &#63;.
	 *
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application tag
	 * @throws NoSuchApplicationTagException if a matching application tag could not be found
	 */
	@Override
	public ApplicationTag findByTag_First(String tag,
		OrderByComparator<ApplicationTag> orderByComparator)
		throws NoSuchApplicationTagException {
		ApplicationTag applicationTag = fetchByTag_First(tag, orderByComparator);

		if (applicationTag != null) {
			return applicationTag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tag=");
		msg.append(tag);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationTagException(msg.toString());
	}

	/**
	 * Returns the first application tag in the ordered set where tag = &#63;.
	 *
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching application tag, or <code>null</code> if a matching application tag could not be found
	 */
	@Override
	public ApplicationTag fetchByTag_First(String tag,
		OrderByComparator<ApplicationTag> orderByComparator) {
		List<ApplicationTag> list = findByTag(tag, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last application tag in the ordered set where tag = &#63;.
	 *
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application tag
	 * @throws NoSuchApplicationTagException if a matching application tag could not be found
	 */
	@Override
	public ApplicationTag findByTag_Last(String tag,
		OrderByComparator<ApplicationTag> orderByComparator)
		throws NoSuchApplicationTagException {
		ApplicationTag applicationTag = fetchByTag_Last(tag, orderByComparator);

		if (applicationTag != null) {
			return applicationTag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tag=");
		msg.append(tag);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchApplicationTagException(msg.toString());
	}

	/**
	 * Returns the last application tag in the ordered set where tag = &#63;.
	 *
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching application tag, or <code>null</code> if a matching application tag could not be found
	 */
	@Override
	public ApplicationTag fetchByTag_Last(String tag,
		OrderByComparator<ApplicationTag> orderByComparator) {
		int count = countByTag(tag);

		if (count == 0) {
			return null;
		}

		List<ApplicationTag> list = findByTag(tag, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the application tags before and after the current application tag in the ordered set where tag = &#63;.
	 *
	 * @param applicationTagsId the primary key of the current application tag
	 * @param tag the tag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next application tag
	 * @throws NoSuchApplicationTagException if a application tag with the primary key could not be found
	 */
	@Override
	public ApplicationTag[] findByTag_PrevAndNext(long applicationTagsId,
		String tag, OrderByComparator<ApplicationTag> orderByComparator)
		throws NoSuchApplicationTagException {
		ApplicationTag applicationTag = findByPrimaryKey(applicationTagsId);

		Session session = null;

		try {
			session = openSession();

			ApplicationTag[] array = new ApplicationTagImpl[3];

			array[0] = getByTag_PrevAndNext(session, applicationTag, tag,
					orderByComparator, true);

			array[1] = applicationTag;

			array[2] = getByTag_PrevAndNext(session, applicationTag, tag,
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

	protected ApplicationTag getByTag_PrevAndNext(Session session,
		ApplicationTag applicationTag, String tag,
		OrderByComparator<ApplicationTag> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_APPLICATIONTAG_WHERE);

		boolean bindTag = false;

		if (tag == null) {
			query.append(_FINDER_COLUMN_TAG_TAG_1);
		}
		else if (tag.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TAG_TAG_3);
		}
		else {
			bindTag = true;

			query.append(_FINDER_COLUMN_TAG_TAG_2);
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
			query.append(ApplicationTagModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTag) {
			qPos.add(tag);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(applicationTag);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ApplicationTag> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the application tags where tag = &#63; from the database.
	 *
	 * @param tag the tag
	 */
	@Override
	public void removeByTag(String tag) {
		for (ApplicationTag applicationTag : findByTag(tag, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(applicationTag);
		}
	}

	/**
	 * Returns the number of application tags where tag = &#63;.
	 *
	 * @param tag the tag
	 * @return the number of matching application tags
	 */
	@Override
	public int countByTag(String tag) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TAG;

		Object[] finderArgs = new Object[] { tag };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_APPLICATIONTAG_WHERE);

			boolean bindTag = false;

			if (tag == null) {
				query.append(_FINDER_COLUMN_TAG_TAG_1);
			}
			else if (tag.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TAG_TAG_3);
			}
			else {
				bindTag = true;

				query.append(_FINDER_COLUMN_TAG_TAG_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTag) {
					qPos.add(tag);
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

	private static final String _FINDER_COLUMN_TAG_TAG_1 = "applicationTag.tag IS NULL";
	private static final String _FINDER_COLUMN_TAG_TAG_2 = "applicationTag.tag = ?";
	private static final String _FINDER_COLUMN_TAG_TAG_3 = "(applicationTag.tag IS NULL OR applicationTag.tag = '')";

	public ApplicationTagPersistenceImpl() {
		setModelClass(ApplicationTag.class);
	}

	/**
	 * Caches the application tag in the entity cache if it is enabled.
	 *
	 * @param applicationTag the application tag
	 */
	@Override
	public void cacheResult(ApplicationTag applicationTag) {
		entityCache.putResult(ApplicationTagModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationTagImpl.class, applicationTag.getPrimaryKey(),
			applicationTag);

		applicationTag.resetOriginalValues();
	}

	/**
	 * Caches the application tags in the entity cache if it is enabled.
	 *
	 * @param applicationTags the application tags
	 */
	@Override
	public void cacheResult(List<ApplicationTag> applicationTags) {
		for (ApplicationTag applicationTag : applicationTags) {
			if (entityCache.getResult(
						ApplicationTagModelImpl.ENTITY_CACHE_ENABLED,
						ApplicationTagImpl.class, applicationTag.getPrimaryKey()) == null) {
				cacheResult(applicationTag);
			}
			else {
				applicationTag.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all application tags.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ApplicationTagImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the application tag.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ApplicationTag applicationTag) {
		entityCache.removeResult(ApplicationTagModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationTagImpl.class, applicationTag.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ApplicationTag> applicationTags) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ApplicationTag applicationTag : applicationTags) {
			entityCache.removeResult(ApplicationTagModelImpl.ENTITY_CACHE_ENABLED,
				ApplicationTagImpl.class, applicationTag.getPrimaryKey());
		}
	}

	/**
	 * Creates a new application tag with the primary key. Does not add the application tag to the database.
	 *
	 * @param applicationTagsId the primary key for the new application tag
	 * @return the new application tag
	 */
	@Override
	public ApplicationTag create(long applicationTagsId) {
		ApplicationTag applicationTag = new ApplicationTagImpl();

		applicationTag.setNew(true);
		applicationTag.setPrimaryKey(applicationTagsId);

		applicationTag.setCompanyId(companyProvider.getCompanyId());

		return applicationTag;
	}

	/**
	 * Removes the application tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param applicationTagsId the primary key of the application tag
	 * @return the application tag that was removed
	 * @throws NoSuchApplicationTagException if a application tag with the primary key could not be found
	 */
	@Override
	public ApplicationTag remove(long applicationTagsId)
		throws NoSuchApplicationTagException {
		return remove((Serializable)applicationTagsId);
	}

	/**
	 * Removes the application tag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the application tag
	 * @return the application tag that was removed
	 * @throws NoSuchApplicationTagException if a application tag with the primary key could not be found
	 */
	@Override
	public ApplicationTag remove(Serializable primaryKey)
		throws NoSuchApplicationTagException {
		Session session = null;

		try {
			session = openSession();

			ApplicationTag applicationTag = (ApplicationTag)session.get(ApplicationTagImpl.class,
					primaryKey);

			if (applicationTag == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApplicationTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(applicationTag);
		}
		catch (NoSuchApplicationTagException nsee) {
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
	protected ApplicationTag removeImpl(ApplicationTag applicationTag) {
		applicationTag = toUnwrappedModel(applicationTag);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(applicationTag)) {
				applicationTag = (ApplicationTag)session.get(ApplicationTagImpl.class,
						applicationTag.getPrimaryKeyObj());
			}

			if (applicationTag != null) {
				session.delete(applicationTag);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (applicationTag != null) {
			clearCache(applicationTag);
		}

		return applicationTag;
	}

	@Override
	public ApplicationTag updateImpl(ApplicationTag applicationTag) {
		applicationTag = toUnwrappedModel(applicationTag);

		boolean isNew = applicationTag.isNew();

		ApplicationTagModelImpl applicationTagModelImpl = (ApplicationTagModelImpl)applicationTag;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (applicationTag.getCreateDate() == null)) {
			if (serviceContext == null) {
				applicationTag.setCreateDate(now);
			}
			else {
				applicationTag.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!applicationTagModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				applicationTag.setModifiedDate(now);
			}
			else {
				applicationTag.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (applicationTag.isNew()) {
				session.save(applicationTag);

				applicationTag.setNew(false);
			}
			else {
				applicationTag = (ApplicationTag)session.merge(applicationTag);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ApplicationTagModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((applicationTagModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONSTOREITEMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						applicationTagModelImpl.getOriginalApplicationStoreItemId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONSTOREITEMID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONSTOREITEMID,
					args);

				args = new Object[] {
						applicationTagModelImpl.getApplicationStoreItemId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_APPLICATIONSTOREITEMID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPLICATIONSTOREITEMID,
					args);
			}

			if ((applicationTagModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						applicationTagModelImpl.getOriginalTag()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TAG, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG,
					args);

				args = new Object[] { applicationTagModelImpl.getTag() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TAG, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAG,
					args);
			}
		}

		entityCache.putResult(ApplicationTagModelImpl.ENTITY_CACHE_ENABLED,
			ApplicationTagImpl.class, applicationTag.getPrimaryKey(),
			applicationTag, false);

		applicationTag.resetOriginalValues();

		return applicationTag;
	}

	protected ApplicationTag toUnwrappedModel(ApplicationTag applicationTag) {
		if (applicationTag instanceof ApplicationTagImpl) {
			return applicationTag;
		}

		ApplicationTagImpl applicationTagImpl = new ApplicationTagImpl();

		applicationTagImpl.setNew(applicationTag.isNew());
		applicationTagImpl.setPrimaryKey(applicationTag.getPrimaryKey());

		applicationTagImpl.setApplicationTagsId(applicationTag.getApplicationTagsId());
		applicationTagImpl.setGroupId(applicationTag.getGroupId());
		applicationTagImpl.setCompanyId(applicationTag.getCompanyId());
		applicationTagImpl.setUserId(applicationTag.getUserId());
		applicationTagImpl.setUserName(applicationTag.getUserName());
		applicationTagImpl.setCreateDate(applicationTag.getCreateDate());
		applicationTagImpl.setModifiedDate(applicationTag.getModifiedDate());
		applicationTagImpl.setTag(applicationTag.getTag());
		applicationTagImpl.setApplicationStoreItemId(applicationTag.getApplicationStoreItemId());

		return applicationTagImpl;
	}

	/**
	 * Returns the application tag with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the application tag
	 * @return the application tag
	 * @throws NoSuchApplicationTagException if a application tag with the primary key could not be found
	 */
	@Override
	public ApplicationTag findByPrimaryKey(Serializable primaryKey)
		throws NoSuchApplicationTagException {
		ApplicationTag applicationTag = fetchByPrimaryKey(primaryKey);

		if (applicationTag == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchApplicationTagException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return applicationTag;
	}

	/**
	 * Returns the application tag with the primary key or throws a {@link NoSuchApplicationTagException} if it could not be found.
	 *
	 * @param applicationTagsId the primary key of the application tag
	 * @return the application tag
	 * @throws NoSuchApplicationTagException if a application tag with the primary key could not be found
	 */
	@Override
	public ApplicationTag findByPrimaryKey(long applicationTagsId)
		throws NoSuchApplicationTagException {
		return findByPrimaryKey((Serializable)applicationTagsId);
	}

	/**
	 * Returns the application tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the application tag
	 * @return the application tag, or <code>null</code> if a application tag with the primary key could not be found
	 */
	@Override
	public ApplicationTag fetchByPrimaryKey(Serializable primaryKey) {
		ApplicationTag applicationTag = (ApplicationTag)entityCache.getResult(ApplicationTagModelImpl.ENTITY_CACHE_ENABLED,
				ApplicationTagImpl.class, primaryKey);

		if (applicationTag == _nullApplicationTag) {
			return null;
		}

		if (applicationTag == null) {
			Session session = null;

			try {
				session = openSession();

				applicationTag = (ApplicationTag)session.get(ApplicationTagImpl.class,
						primaryKey);

				if (applicationTag != null) {
					cacheResult(applicationTag);
				}
				else {
					entityCache.putResult(ApplicationTagModelImpl.ENTITY_CACHE_ENABLED,
						ApplicationTagImpl.class, primaryKey,
						_nullApplicationTag);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ApplicationTagModelImpl.ENTITY_CACHE_ENABLED,
					ApplicationTagImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return applicationTag;
	}

	/**
	 * Returns the application tag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param applicationTagsId the primary key of the application tag
	 * @return the application tag, or <code>null</code> if a application tag with the primary key could not be found
	 */
	@Override
	public ApplicationTag fetchByPrimaryKey(long applicationTagsId) {
		return fetchByPrimaryKey((Serializable)applicationTagsId);
	}

	@Override
	public Map<Serializable, ApplicationTag> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ApplicationTag> map = new HashMap<Serializable, ApplicationTag>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ApplicationTag applicationTag = fetchByPrimaryKey(primaryKey);

			if (applicationTag != null) {
				map.put(primaryKey, applicationTag);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			ApplicationTag applicationTag = (ApplicationTag)entityCache.getResult(ApplicationTagModelImpl.ENTITY_CACHE_ENABLED,
					ApplicationTagImpl.class, primaryKey);

			if (applicationTag == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, applicationTag);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_APPLICATIONTAG_WHERE_PKS_IN);

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

			for (ApplicationTag applicationTag : (List<ApplicationTag>)q.list()) {
				map.put(applicationTag.getPrimaryKeyObj(), applicationTag);

				cacheResult(applicationTag);

				uncachedPrimaryKeys.remove(applicationTag.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ApplicationTagModelImpl.ENTITY_CACHE_ENABLED,
					ApplicationTagImpl.class, primaryKey, _nullApplicationTag);
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
	 * Returns all the application tags.
	 *
	 * @return the application tags
	 */
	@Override
	public List<ApplicationTag> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the application tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of application tags
	 * @param end the upper bound of the range of application tags (not inclusive)
	 * @return the range of application tags
	 */
	@Override
	public List<ApplicationTag> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the application tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of application tags
	 * @param end the upper bound of the range of application tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of application tags
	 */
	@Override
	public List<ApplicationTag> findAll(int start, int end,
		OrderByComparator<ApplicationTag> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the application tags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ApplicationTagModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of application tags
	 * @param end the upper bound of the range of application tags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of application tags
	 */
	@Override
	public List<ApplicationTag> findAll(int start, int end,
		OrderByComparator<ApplicationTag> orderByComparator,
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

		List<ApplicationTag> list = null;

		if (retrieveFromCache) {
			list = (List<ApplicationTag>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_APPLICATIONTAG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_APPLICATIONTAG;

				if (pagination) {
					sql = sql.concat(ApplicationTagModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ApplicationTag>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ApplicationTag>)QueryUtil.list(q,
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
	 * Removes all the application tags from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ApplicationTag applicationTag : findAll()) {
			remove(applicationTag);
		}
	}

	/**
	 * Returns the number of application tags.
	 *
	 * @return the number of application tags
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_APPLICATIONTAG);

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
		return ApplicationTagModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the application tag persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ApplicationTagImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_APPLICATIONTAG = "SELECT applicationTag FROM ApplicationTag applicationTag";
	private static final String _SQL_SELECT_APPLICATIONTAG_WHERE_PKS_IN = "SELECT applicationTag FROM ApplicationTag applicationTag WHERE applicationTagsId IN (";
	private static final String _SQL_SELECT_APPLICATIONTAG_WHERE = "SELECT applicationTag FROM ApplicationTag applicationTag WHERE ";
	private static final String _SQL_COUNT_APPLICATIONTAG = "SELECT COUNT(applicationTag) FROM ApplicationTag applicationTag";
	private static final String _SQL_COUNT_APPLICATIONTAG_WHERE = "SELECT COUNT(applicationTag) FROM ApplicationTag applicationTag WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "applicationTag.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ApplicationTag exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ApplicationTag exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ApplicationTagPersistenceImpl.class);
	private static final ApplicationTag _nullApplicationTag = new ApplicationTagImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ApplicationTag> toCacheModel() {
				return _nullApplicationTagCacheModel;
			}
		};

	private static final CacheModel<ApplicationTag> _nullApplicationTagCacheModel =
		new CacheModel<ApplicationTag>() {
			@Override
			public ApplicationTag toEntityModel() {
				return _nullApplicationTag;
			}
		};
}