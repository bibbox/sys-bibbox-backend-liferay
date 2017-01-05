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

import at.graz.meduni.liferay.portlet.saat.exception.NoSuchDictionaryException;
import at.graz.meduni.liferay.portlet.saat.model.Dictionary;
import at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryImpl;
import at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryModelImpl;
import at.graz.meduni.liferay.portlet.saat.service.persistence.DictionaryPersistence;

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
 * The persistence implementation for the dictionary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see DictionaryPersistence
 * @see at.graz.meduni.liferay.portlet.saat.service.persistence.DictionaryUtil
 * @generated
 */
@ProviderType
public class DictionaryPersistenceImpl extends BasePersistenceImpl<Dictionary>
	implements DictionaryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DictionaryUtil} to access the dictionary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DictionaryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CODETYPE = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCodeType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODETYPE =
		new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, DictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCodeType",
			new String[] { String.class.getName() },
			DictionaryModelImpl.CODETYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODETYPE = new FinderPath(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodeType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the dictionaries where codeType = &#63;.
	 *
	 * @param codeType the code type
	 * @return the matching dictionaries
	 */
	@Override
	public List<Dictionary> findByCodeType(String codeType) {
		return findByCodeType(codeType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the dictionaries where codeType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param codeType the code type
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @return the range of matching dictionaries
	 */
	@Override
	public List<Dictionary> findByCodeType(String codeType, int start, int end) {
		return findByCodeType(codeType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionaries where codeType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param codeType the code type
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dictionaries
	 */
	@Override
	public List<Dictionary> findByCodeType(String codeType, int start, int end,
		OrderByComparator<Dictionary> orderByComparator) {
		return findByCodeType(codeType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dictionaries where codeType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param codeType the code type
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching dictionaries
	 */
	@Override
	public List<Dictionary> findByCodeType(String codeType, int start, int end,
		OrderByComparator<Dictionary> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODETYPE;
			finderArgs = new Object[] { codeType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CODETYPE;
			finderArgs = new Object[] { codeType, start, end, orderByComparator };
		}

		List<Dictionary> list = null;

		if (retrieveFromCache) {
			list = (List<Dictionary>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Dictionary dictionary : list) {
					if (!Objects.equals(codeType, dictionary.getCodeType())) {
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

			query.append(_SQL_SELECT_DICTIONARY_WHERE);

			boolean bindCodeType = false;

			if (codeType == null) {
				query.append(_FINDER_COLUMN_CODETYPE_CODETYPE_1);
			}
			else if (codeType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODETYPE_CODETYPE_3);
			}
			else {
				bindCodeType = true;

				query.append(_FINDER_COLUMN_CODETYPE_CODETYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DictionaryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCodeType) {
					qPos.add(codeType);
				}

				if (!pagination) {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first dictionary in the ordered set where codeType = &#63;.
	 *
	 * @param codeType the code type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary
	 * @throws NoSuchDictionaryException if a matching dictionary could not be found
	 */
	@Override
	public Dictionary findByCodeType_First(String codeType,
		OrderByComparator<Dictionary> orderByComparator)
		throws NoSuchDictionaryException {
		Dictionary dictionary = fetchByCodeType_First(codeType,
				orderByComparator);

		if (dictionary != null) {
			return dictionary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("codeType=");
		msg.append(codeType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryException(msg.toString());
	}

	/**
	 * Returns the first dictionary in the ordered set where codeType = &#63;.
	 *
	 * @param codeType the code type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 */
	@Override
	public Dictionary fetchByCodeType_First(String codeType,
		OrderByComparator<Dictionary> orderByComparator) {
		List<Dictionary> list = findByCodeType(codeType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last dictionary in the ordered set where codeType = &#63;.
	 *
	 * @param codeType the code type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary
	 * @throws NoSuchDictionaryException if a matching dictionary could not be found
	 */
	@Override
	public Dictionary findByCodeType_Last(String codeType,
		OrderByComparator<Dictionary> orderByComparator)
		throws NoSuchDictionaryException {
		Dictionary dictionary = fetchByCodeType_Last(codeType, orderByComparator);

		if (dictionary != null) {
			return dictionary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("codeType=");
		msg.append(codeType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDictionaryException(msg.toString());
	}

	/**
	 * Returns the last dictionary in the ordered set where codeType = &#63;.
	 *
	 * @param codeType the code type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dictionary, or <code>null</code> if a matching dictionary could not be found
	 */
	@Override
	public Dictionary fetchByCodeType_Last(String codeType,
		OrderByComparator<Dictionary> orderByComparator) {
		int count = countByCodeType(codeType);

		if (count == 0) {
			return null;
		}

		List<Dictionary> list = findByCodeType(codeType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the dictionaries before and after the current dictionary in the ordered set where codeType = &#63;.
	 *
	 * @param dictionaryId the primary key of the current dictionary
	 * @param codeType the code type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dictionary
	 * @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	 */
	@Override
	public Dictionary[] findByCodeType_PrevAndNext(long dictionaryId,
		String codeType, OrderByComparator<Dictionary> orderByComparator)
		throws NoSuchDictionaryException {
		Dictionary dictionary = findByPrimaryKey(dictionaryId);

		Session session = null;

		try {
			session = openSession();

			Dictionary[] array = new DictionaryImpl[3];

			array[0] = getByCodeType_PrevAndNext(session, dictionary, codeType,
					orderByComparator, true);

			array[1] = dictionary;

			array[2] = getByCodeType_PrevAndNext(session, dictionary, codeType,
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

	protected Dictionary getByCodeType_PrevAndNext(Session session,
		Dictionary dictionary, String codeType,
		OrderByComparator<Dictionary> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DICTIONARY_WHERE);

		boolean bindCodeType = false;

		if (codeType == null) {
			query.append(_FINDER_COLUMN_CODETYPE_CODETYPE_1);
		}
		else if (codeType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CODETYPE_CODETYPE_3);
		}
		else {
			bindCodeType = true;

			query.append(_FINDER_COLUMN_CODETYPE_CODETYPE_2);
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
			query.append(DictionaryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCodeType) {
			qPos.add(codeType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dictionary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Dictionary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the dictionaries where codeType = &#63; from the database.
	 *
	 * @param codeType the code type
	 */
	@Override
	public void removeByCodeType(String codeType) {
		for (Dictionary dictionary : findByCodeType(codeType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dictionary);
		}
	}

	/**
	 * Returns the number of dictionaries where codeType = &#63;.
	 *
	 * @param codeType the code type
	 * @return the number of matching dictionaries
	 */
	@Override
	public int countByCodeType(String codeType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODETYPE;

		Object[] finderArgs = new Object[] { codeType };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DICTIONARY_WHERE);

			boolean bindCodeType = false;

			if (codeType == null) {
				query.append(_FINDER_COLUMN_CODETYPE_CODETYPE_1);
			}
			else if (codeType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODETYPE_CODETYPE_3);
			}
			else {
				bindCodeType = true;

				query.append(_FINDER_COLUMN_CODETYPE_CODETYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCodeType) {
					qPos.add(codeType);
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

	private static final String _FINDER_COLUMN_CODETYPE_CODETYPE_1 = "dictionary.codeType IS NULL";
	private static final String _FINDER_COLUMN_CODETYPE_CODETYPE_2 = "dictionary.codeType = ?";
	private static final String _FINDER_COLUMN_CODETYPE_CODETYPE_3 = "(dictionary.codeType IS NULL OR dictionary.codeType = '')";

	public DictionaryPersistenceImpl() {
		setModelClass(Dictionary.class);
	}

	/**
	 * Caches the dictionary in the entity cache if it is enabled.
	 *
	 * @param dictionary the dictionary
	 */
	@Override
	public void cacheResult(Dictionary dictionary) {
		entityCache.putResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryImpl.class, dictionary.getPrimaryKey(), dictionary);

		dictionary.resetOriginalValues();
	}

	/**
	 * Caches the dictionaries in the entity cache if it is enabled.
	 *
	 * @param dictionaries the dictionaries
	 */
	@Override
	public void cacheResult(List<Dictionary> dictionaries) {
		for (Dictionary dictionary : dictionaries) {
			if (entityCache.getResult(
						DictionaryModelImpl.ENTITY_CACHE_ENABLED,
						DictionaryImpl.class, dictionary.getPrimaryKey()) == null) {
				cacheResult(dictionary);
			}
			else {
				dictionary.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all dictionaries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DictionaryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dictionary.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Dictionary dictionary) {
		entityCache.removeResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryImpl.class, dictionary.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Dictionary> dictionaries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Dictionary dictionary : dictionaries) {
			entityCache.removeResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
				DictionaryImpl.class, dictionary.getPrimaryKey());
		}
	}

	/**
	 * Creates a new dictionary with the primary key. Does not add the dictionary to the database.
	 *
	 * @param dictionaryId the primary key for the new dictionary
	 * @return the new dictionary
	 */
	@Override
	public Dictionary create(long dictionaryId) {
		Dictionary dictionary = new DictionaryImpl();

		dictionary.setNew(true);
		dictionary.setPrimaryKey(dictionaryId);

		dictionary.setCompanyId(companyProvider.getCompanyId());

		return dictionary;
	}

	/**
	 * Removes the dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dictionaryId the primary key of the dictionary
	 * @return the dictionary that was removed
	 * @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	 */
	@Override
	public Dictionary remove(long dictionaryId)
		throws NoSuchDictionaryException {
		return remove((Serializable)dictionaryId);
	}

	/**
	 * Removes the dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dictionary
	 * @return the dictionary that was removed
	 * @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	 */
	@Override
	public Dictionary remove(Serializable primaryKey)
		throws NoSuchDictionaryException {
		Session session = null;

		try {
			session = openSession();

			Dictionary dictionary = (Dictionary)session.get(DictionaryImpl.class,
					primaryKey);

			if (dictionary == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDictionaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dictionary);
		}
		catch (NoSuchDictionaryException nsee) {
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
	protected Dictionary removeImpl(Dictionary dictionary) {
		dictionary = toUnwrappedModel(dictionary);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dictionary)) {
				dictionary = (Dictionary)session.get(DictionaryImpl.class,
						dictionary.getPrimaryKeyObj());
			}

			if (dictionary != null) {
				session.delete(dictionary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dictionary != null) {
			clearCache(dictionary);
		}

		return dictionary;
	}

	@Override
	public Dictionary updateImpl(Dictionary dictionary) {
		dictionary = toUnwrappedModel(dictionary);

		boolean isNew = dictionary.isNew();

		DictionaryModelImpl dictionaryModelImpl = (DictionaryModelImpl)dictionary;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (dictionary.getCreateDate() == null)) {
			if (serviceContext == null) {
				dictionary.setCreateDate(now);
			}
			else {
				dictionary.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!dictionaryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dictionary.setModifiedDate(now);
			}
			else {
				dictionary.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (dictionary.isNew()) {
				session.save(dictionary);

				dictionary.setNew(false);
			}
			else {
				dictionary = (Dictionary)session.merge(dictionary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DictionaryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dictionaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dictionaryModelImpl.getOriginalCodeType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CODETYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODETYPE,
					args);

				args = new Object[] { dictionaryModelImpl.getCodeType() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CODETYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODETYPE,
					args);
			}
		}

		entityCache.putResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
			DictionaryImpl.class, dictionary.getPrimaryKey(), dictionary, false);

		dictionary.resetOriginalValues();

		return dictionary;
	}

	protected Dictionary toUnwrappedModel(Dictionary dictionary) {
		if (dictionary instanceof DictionaryImpl) {
			return dictionary;
		}

		DictionaryImpl dictionaryImpl = new DictionaryImpl();

		dictionaryImpl.setNew(dictionary.isNew());
		dictionaryImpl.setPrimaryKey(dictionary.getPrimaryKey());

		dictionaryImpl.setDictionaryId(dictionary.getDictionaryId());
		dictionaryImpl.setCompanyId(dictionary.getCompanyId());
		dictionaryImpl.setUserId(dictionary.getUserId());
		dictionaryImpl.setUserName(dictionary.getUserName());
		dictionaryImpl.setCreateDate(dictionary.getCreateDate());
		dictionaryImpl.setModifiedDate(dictionary.getModifiedDate());
		dictionaryImpl.setIsroot(dictionary.isIsroot());
		dictionaryImpl.setIscode(dictionary.isIscode());
		dictionaryImpl.setSynonym(dictionary.getSynonym());
		dictionaryImpl.setPattern(dictionary.getPattern());
		dictionaryImpl.setBeforSynonym(dictionary.getBeforSynonym());
		dictionaryImpl.setAfterSynonym(dictionary.getAfterSynonym());
		dictionaryImpl.setForeword(dictionary.isForeword());
		dictionaryImpl.setEnding(dictionary.isEnding());
		dictionaryImpl.setSentence(dictionary.isSentence());
		dictionaryImpl.setOccure(dictionary.isOccure());
		dictionaryImpl.setNagation(dictionary.isNagation());
		dictionaryImpl.setPriority_mode(dictionary.isPriority_mode());
		dictionaryImpl.setCodeType(dictionary.getCodeType());
		dictionaryImpl.setCodeValue(dictionary.getCodeValue());
		dictionaryImpl.setPriority(dictionary.getPriority());
		dictionaryImpl.setDisease_ids(dictionary.getDisease_ids());
		dictionaryImpl.setDirty(dictionary.isDirty());
		dictionaryImpl.setDisease_ids_count(dictionary.getDisease_ids_count());

		return dictionaryImpl;
	}

	/**
	 * Returns the dictionary with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the dictionary
	 * @return the dictionary
	 * @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	 */
	@Override
	public Dictionary findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDictionaryException {
		Dictionary dictionary = fetchByPrimaryKey(primaryKey);

		if (dictionary == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDictionaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dictionary;
	}

	/**
	 * Returns the dictionary with the primary key or throws a {@link NoSuchDictionaryException} if it could not be found.
	 *
	 * @param dictionaryId the primary key of the dictionary
	 * @return the dictionary
	 * @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	 */
	@Override
	public Dictionary findByPrimaryKey(long dictionaryId)
		throws NoSuchDictionaryException {
		return findByPrimaryKey((Serializable)dictionaryId);
	}

	/**
	 * Returns the dictionary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dictionary
	 * @return the dictionary, or <code>null</code> if a dictionary with the primary key could not be found
	 */
	@Override
	public Dictionary fetchByPrimaryKey(Serializable primaryKey) {
		Dictionary dictionary = (Dictionary)entityCache.getResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
				DictionaryImpl.class, primaryKey);

		if (dictionary == _nullDictionary) {
			return null;
		}

		if (dictionary == null) {
			Session session = null;

			try {
				session = openSession();

				dictionary = (Dictionary)session.get(DictionaryImpl.class,
						primaryKey);

				if (dictionary != null) {
					cacheResult(dictionary);
				}
				else {
					entityCache.putResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
						DictionaryImpl.class, primaryKey, _nullDictionary);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
					DictionaryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dictionary;
	}

	/**
	 * Returns the dictionary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dictionaryId the primary key of the dictionary
	 * @return the dictionary, or <code>null</code> if a dictionary with the primary key could not be found
	 */
	@Override
	public Dictionary fetchByPrimaryKey(long dictionaryId) {
		return fetchByPrimaryKey((Serializable)dictionaryId);
	}

	@Override
	public Map<Serializable, Dictionary> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Dictionary> map = new HashMap<Serializable, Dictionary>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Dictionary dictionary = fetchByPrimaryKey(primaryKey);

			if (dictionary != null) {
				map.put(primaryKey, dictionary);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Dictionary dictionary = (Dictionary)entityCache.getResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
					DictionaryImpl.class, primaryKey);

			if (dictionary == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, dictionary);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DICTIONARY_WHERE_PKS_IN);

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

			for (Dictionary dictionary : (List<Dictionary>)q.list()) {
				map.put(dictionary.getPrimaryKeyObj(), dictionary);

				cacheResult(dictionary);

				uncachedPrimaryKeys.remove(dictionary.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DictionaryModelImpl.ENTITY_CACHE_ENABLED,
					DictionaryImpl.class, primaryKey, _nullDictionary);
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
	 * Returns all the dictionaries.
	 *
	 * @return the dictionaries
	 */
	@Override
	public List<Dictionary> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dictionaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @return the range of dictionaries
	 */
	@Override
	public List<Dictionary> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dictionaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dictionaries
	 */
	@Override
	public List<Dictionary> findAll(int start, int end,
		OrderByComparator<Dictionary> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dictionaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of dictionaries
	 * @param end the upper bound of the range of dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of dictionaries
	 */
	@Override
	public List<Dictionary> findAll(int start, int end,
		OrderByComparator<Dictionary> orderByComparator,
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

		List<Dictionary> list = null;

		if (retrieveFromCache) {
			list = (List<Dictionary>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DICTIONARY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DICTIONARY;

				if (pagination) {
					sql = sql.concat(DictionaryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Dictionary>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the dictionaries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Dictionary dictionary : findAll()) {
			remove(dictionary);
		}
	}

	/**
	 * Returns the number of dictionaries.
	 *
	 * @return the number of dictionaries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DICTIONARY);

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
		return DictionaryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dictionary persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DictionaryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_DICTIONARY = "SELECT dictionary FROM Dictionary dictionary";
	private static final String _SQL_SELECT_DICTIONARY_WHERE_PKS_IN = "SELECT dictionary FROM Dictionary dictionary WHERE dictionaryId IN (";
	private static final String _SQL_SELECT_DICTIONARY_WHERE = "SELECT dictionary FROM Dictionary dictionary WHERE ";
	private static final String _SQL_COUNT_DICTIONARY = "SELECT COUNT(dictionary) FROM Dictionary dictionary";
	private static final String _SQL_COUNT_DICTIONARY_WHERE = "SELECT COUNT(dictionary) FROM Dictionary dictionary WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dictionary.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Dictionary exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Dictionary exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DictionaryPersistenceImpl.class);
	private static final Dictionary _nullDictionary = new DictionaryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Dictionary> toCacheModel() {
				return _nullDictionaryCacheModel;
			}
		};

	private static final CacheModel<Dictionary> _nullDictionaryCacheModel = new CacheModel<Dictionary>() {
			@Override
			public Dictionary toEntityModel() {
				return _nullDictionary;
			}
		};
}