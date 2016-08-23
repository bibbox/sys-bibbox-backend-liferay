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

import at.graz.meduni.bibbox.liferay.portlet.exception.NoSuchDockerContainerException;
import at.graz.meduni.bibbox.liferay.portlet.model.DockerContainer;
import at.graz.meduni.bibbox.liferay.portlet.model.impl.DockerContainerImpl;
import at.graz.meduni.bibbox.liferay.portlet.model.impl.DockerContainerModelImpl;
import at.graz.meduni.bibbox.liferay.portlet.service.persistence.DockerContainerPersistence;

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
 * The persistence implementation for the docker container service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Robert Reihs
 * @see DockerContainerPersistence
 * @see at.graz.meduni.bibbox.liferay.portlet.service.persistence.DockerContainerUtil
 * @generated
 */
@ProviderType
public class DockerContainerPersistenceImpl extends BasePersistenceImpl<DockerContainer>
	implements DockerContainerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DockerContainerUtil} to access the docker container persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DockerContainerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DockerContainerModelImpl.ENTITY_CACHE_ENABLED,
			DockerContainerModelImpl.FINDER_CACHE_ENABLED,
			DockerContainerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DockerContainerModelImpl.ENTITY_CACHE_ENABLED,
			DockerContainerModelImpl.FINDER_CACHE_ENABLED,
			DockerContainerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DockerContainerModelImpl.ENTITY_CACHE_ENABLED,
			DockerContainerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_DOCKERCONTAINER = new FinderPath(DockerContainerModelImpl.ENTITY_CACHE_ENABLED,
			DockerContainerModelImpl.FINDER_CACHE_ENABLED,
			DockerContainerImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByDockerContainer",
			new String[] { String.class.getName(), String.class.getName() },
			DockerContainerModelImpl.TOOLNAME_COLUMN_BITMASK |
			DockerContainerModelImpl.INSTANCE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DOCKERCONTAINER = new FinderPath(DockerContainerModelImpl.ENTITY_CACHE_ENABLED,
			DockerContainerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDockerContainer",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the docker container where toolName = &#63; and instance = &#63; or throws a {@link NoSuchDockerContainerException} if it could not be found.
	 *
	 * @param toolName the tool name
	 * @param instance the instance
	 * @return the matching docker container
	 * @throws NoSuchDockerContainerException if a matching docker container could not be found
	 */
	@Override
	public DockerContainer findByDockerContainer(String toolName,
		String instance) throws NoSuchDockerContainerException {
		DockerContainer dockerContainer = fetchByDockerContainer(toolName,
				instance);

		if (dockerContainer == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("toolName=");
			msg.append(toolName);

			msg.append(", instance=");
			msg.append(instance);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchDockerContainerException(msg.toString());
		}

		return dockerContainer;
	}

	/**
	 * Returns the docker container where toolName = &#63; and instance = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param toolName the tool name
	 * @param instance the instance
	 * @return the matching docker container, or <code>null</code> if a matching docker container could not be found
	 */
	@Override
	public DockerContainer fetchByDockerContainer(String toolName,
		String instance) {
		return fetchByDockerContainer(toolName, instance, true);
	}

	/**
	 * Returns the docker container where toolName = &#63; and instance = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param toolName the tool name
	 * @param instance the instance
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching docker container, or <code>null</code> if a matching docker container could not be found
	 */
	@Override
	public DockerContainer fetchByDockerContainer(String toolName,
		String instance, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { toolName, instance };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_DOCKERCONTAINER,
					finderArgs, this);
		}

		if (result instanceof DockerContainer) {
			DockerContainer dockerContainer = (DockerContainer)result;

			if (!Objects.equals(toolName, dockerContainer.getToolName()) ||
					!Objects.equals(instance, dockerContainer.getInstance())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DOCKERCONTAINER_WHERE);

			boolean bindToolName = false;

			if (toolName == null) {
				query.append(_FINDER_COLUMN_DOCKERCONTAINER_TOOLNAME_1);
			}
			else if (toolName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DOCKERCONTAINER_TOOLNAME_3);
			}
			else {
				bindToolName = true;

				query.append(_FINDER_COLUMN_DOCKERCONTAINER_TOOLNAME_2);
			}

			boolean bindInstance = false;

			if (instance == null) {
				query.append(_FINDER_COLUMN_DOCKERCONTAINER_INSTANCE_1);
			}
			else if (instance.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DOCKERCONTAINER_INSTANCE_3);
			}
			else {
				bindInstance = true;

				query.append(_FINDER_COLUMN_DOCKERCONTAINER_INSTANCE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindToolName) {
					qPos.add(toolName);
				}

				if (bindInstance) {
					qPos.add(instance);
				}

				List<DockerContainer> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_DOCKERCONTAINER,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DockerContainerPersistenceImpl.fetchByDockerContainer(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					DockerContainer dockerContainer = list.get(0);

					result = dockerContainer;

					cacheResult(dockerContainer);

					if ((dockerContainer.getToolName() == null) ||
							!dockerContainer.getToolName().equals(toolName) ||
							(dockerContainer.getInstance() == null) ||
							!dockerContainer.getInstance().equals(instance)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_DOCKERCONTAINER,
							finderArgs, dockerContainer);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_DOCKERCONTAINER,
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
			return (DockerContainer)result;
		}
	}

	/**
	 * Removes the docker container where toolName = &#63; and instance = &#63; from the database.
	 *
	 * @param toolName the tool name
	 * @param instance the instance
	 * @return the docker container that was removed
	 */
	@Override
	public DockerContainer removeByDockerContainer(String toolName,
		String instance) throws NoSuchDockerContainerException {
		DockerContainer dockerContainer = findByDockerContainer(toolName,
				instance);

		return remove(dockerContainer);
	}

	/**
	 * Returns the number of docker containers where toolName = &#63; and instance = &#63;.
	 *
	 * @param toolName the tool name
	 * @param instance the instance
	 * @return the number of matching docker containers
	 */
	@Override
	public int countByDockerContainer(String toolName, String instance) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DOCKERCONTAINER;

		Object[] finderArgs = new Object[] { toolName, instance };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DOCKERCONTAINER_WHERE);

			boolean bindToolName = false;

			if (toolName == null) {
				query.append(_FINDER_COLUMN_DOCKERCONTAINER_TOOLNAME_1);
			}
			else if (toolName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DOCKERCONTAINER_TOOLNAME_3);
			}
			else {
				bindToolName = true;

				query.append(_FINDER_COLUMN_DOCKERCONTAINER_TOOLNAME_2);
			}

			boolean bindInstance = false;

			if (instance == null) {
				query.append(_FINDER_COLUMN_DOCKERCONTAINER_INSTANCE_1);
			}
			else if (instance.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DOCKERCONTAINER_INSTANCE_3);
			}
			else {
				bindInstance = true;

				query.append(_FINDER_COLUMN_DOCKERCONTAINER_INSTANCE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindToolName) {
					qPos.add(toolName);
				}

				if (bindInstance) {
					qPos.add(instance);
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

	private static final String _FINDER_COLUMN_DOCKERCONTAINER_TOOLNAME_1 = "dockerContainer.toolName IS NULL AND ";
	private static final String _FINDER_COLUMN_DOCKERCONTAINER_TOOLNAME_2 = "dockerContainer.toolName = ? AND ";
	private static final String _FINDER_COLUMN_DOCKERCONTAINER_TOOLNAME_3 = "(dockerContainer.toolName IS NULL OR dockerContainer.toolName = '') AND ";
	private static final String _FINDER_COLUMN_DOCKERCONTAINER_INSTANCE_1 = "dockerContainer.instance IS NULL";
	private static final String _FINDER_COLUMN_DOCKERCONTAINER_INSTANCE_2 = "dockerContainer.instance = ?";
	private static final String _FINDER_COLUMN_DOCKERCONTAINER_INSTANCE_3 = "(dockerContainer.instance IS NULL OR dockerContainer.instance = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DOCKERCONTAINERINSTANCES =
		new FinderPath(DockerContainerModelImpl.ENTITY_CACHE_ENABLED,
			DockerContainerModelImpl.FINDER_CACHE_ENABLED,
			DockerContainerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDockerContainerInstances",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCKERCONTAINERINSTANCES =
		new FinderPath(DockerContainerModelImpl.ENTITY_CACHE_ENABLED,
			DockerContainerModelImpl.FINDER_CACHE_ENABLED,
			DockerContainerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDockerContainerInstances",
			new String[] { String.class.getName() },
			DockerContainerModelImpl.TOOLNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DOCKERCONTAINERINSTANCES =
		new FinderPath(DockerContainerModelImpl.ENTITY_CACHE_ENABLED,
			DockerContainerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDockerContainerInstances",
			new String[] { String.class.getName() });

	/**
	 * Returns all the docker containers where toolName = &#63;.
	 *
	 * @param toolName the tool name
	 * @return the matching docker containers
	 */
	@Override
	public List<DockerContainer> findByDockerContainerInstances(String toolName) {
		return findByDockerContainerInstances(toolName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the docker containers where toolName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DockerContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param toolName the tool name
	 * @param start the lower bound of the range of docker containers
	 * @param end the upper bound of the range of docker containers (not inclusive)
	 * @return the range of matching docker containers
	 */
	@Override
	public List<DockerContainer> findByDockerContainerInstances(
		String toolName, int start, int end) {
		return findByDockerContainerInstances(toolName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the docker containers where toolName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DockerContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param toolName the tool name
	 * @param start the lower bound of the range of docker containers
	 * @param end the upper bound of the range of docker containers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching docker containers
	 */
	@Override
	public List<DockerContainer> findByDockerContainerInstances(
		String toolName, int start, int end,
		OrderByComparator<DockerContainer> orderByComparator) {
		return findByDockerContainerInstances(toolName, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the docker containers where toolName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DockerContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param toolName the tool name
	 * @param start the lower bound of the range of docker containers
	 * @param end the upper bound of the range of docker containers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching docker containers
	 */
	@Override
	public List<DockerContainer> findByDockerContainerInstances(
		String toolName, int start, int end,
		OrderByComparator<DockerContainer> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCKERCONTAINERINSTANCES;
			finderArgs = new Object[] { toolName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DOCKERCONTAINERINSTANCES;
			finderArgs = new Object[] { toolName, start, end, orderByComparator };
		}

		List<DockerContainer> list = null;

		if (retrieveFromCache) {
			list = (List<DockerContainer>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (DockerContainer dockerContainer : list) {
					if (!Objects.equals(toolName, dockerContainer.getToolName())) {
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

			query.append(_SQL_SELECT_DOCKERCONTAINER_WHERE);

			boolean bindToolName = false;

			if (toolName == null) {
				query.append(_FINDER_COLUMN_DOCKERCONTAINERINSTANCES_TOOLNAME_1);
			}
			else if (toolName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DOCKERCONTAINERINSTANCES_TOOLNAME_3);
			}
			else {
				bindToolName = true;

				query.append(_FINDER_COLUMN_DOCKERCONTAINERINSTANCES_TOOLNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DockerContainerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindToolName) {
					qPos.add(toolName);
				}

				if (!pagination) {
					list = (List<DockerContainer>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DockerContainer>)QueryUtil.list(q,
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
	 * Returns the first docker container in the ordered set where toolName = &#63;.
	 *
	 * @param toolName the tool name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching docker container
	 * @throws NoSuchDockerContainerException if a matching docker container could not be found
	 */
	@Override
	public DockerContainer findByDockerContainerInstances_First(
		String toolName, OrderByComparator<DockerContainer> orderByComparator)
		throws NoSuchDockerContainerException {
		DockerContainer dockerContainer = fetchByDockerContainerInstances_First(toolName,
				orderByComparator);

		if (dockerContainer != null) {
			return dockerContainer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("toolName=");
		msg.append(toolName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDockerContainerException(msg.toString());
	}

	/**
	 * Returns the first docker container in the ordered set where toolName = &#63;.
	 *
	 * @param toolName the tool name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching docker container, or <code>null</code> if a matching docker container could not be found
	 */
	@Override
	public DockerContainer fetchByDockerContainerInstances_First(
		String toolName, OrderByComparator<DockerContainer> orderByComparator) {
		List<DockerContainer> list = findByDockerContainerInstances(toolName,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last docker container in the ordered set where toolName = &#63;.
	 *
	 * @param toolName the tool name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching docker container
	 * @throws NoSuchDockerContainerException if a matching docker container could not be found
	 */
	@Override
	public DockerContainer findByDockerContainerInstances_Last(
		String toolName, OrderByComparator<DockerContainer> orderByComparator)
		throws NoSuchDockerContainerException {
		DockerContainer dockerContainer = fetchByDockerContainerInstances_Last(toolName,
				orderByComparator);

		if (dockerContainer != null) {
			return dockerContainer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("toolName=");
		msg.append(toolName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDockerContainerException(msg.toString());
	}

	/**
	 * Returns the last docker container in the ordered set where toolName = &#63;.
	 *
	 * @param toolName the tool name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching docker container, or <code>null</code> if a matching docker container could not be found
	 */
	@Override
	public DockerContainer fetchByDockerContainerInstances_Last(
		String toolName, OrderByComparator<DockerContainer> orderByComparator) {
		int count = countByDockerContainerInstances(toolName);

		if (count == 0) {
			return null;
		}

		List<DockerContainer> list = findByDockerContainerInstances(toolName,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the docker containers before and after the current docker container in the ordered set where toolName = &#63;.
	 *
	 * @param dockerContainerId the primary key of the current docker container
	 * @param toolName the tool name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next docker container
	 * @throws NoSuchDockerContainerException if a docker container with the primary key could not be found
	 */
	@Override
	public DockerContainer[] findByDockerContainerInstances_PrevAndNext(
		long dockerContainerId, String toolName,
		OrderByComparator<DockerContainer> orderByComparator)
		throws NoSuchDockerContainerException {
		DockerContainer dockerContainer = findByPrimaryKey(dockerContainerId);

		Session session = null;

		try {
			session = openSession();

			DockerContainer[] array = new DockerContainerImpl[3];

			array[0] = getByDockerContainerInstances_PrevAndNext(session,
					dockerContainer, toolName, orderByComparator, true);

			array[1] = dockerContainer;

			array[2] = getByDockerContainerInstances_PrevAndNext(session,
					dockerContainer, toolName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DockerContainer getByDockerContainerInstances_PrevAndNext(
		Session session, DockerContainer dockerContainer, String toolName,
		OrderByComparator<DockerContainer> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOCKERCONTAINER_WHERE);

		boolean bindToolName = false;

		if (toolName == null) {
			query.append(_FINDER_COLUMN_DOCKERCONTAINERINSTANCES_TOOLNAME_1);
		}
		else if (toolName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DOCKERCONTAINERINSTANCES_TOOLNAME_3);
		}
		else {
			bindToolName = true;

			query.append(_FINDER_COLUMN_DOCKERCONTAINERINSTANCES_TOOLNAME_2);
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
			query.append(DockerContainerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindToolName) {
			qPos.add(toolName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(dockerContainer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DockerContainer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the docker containers where toolName = &#63; from the database.
	 *
	 * @param toolName the tool name
	 */
	@Override
	public void removeByDockerContainerInstances(String toolName) {
		for (DockerContainer dockerContainer : findByDockerContainerInstances(
				toolName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(dockerContainer);
		}
	}

	/**
	 * Returns the number of docker containers where toolName = &#63;.
	 *
	 * @param toolName the tool name
	 * @return the number of matching docker containers
	 */
	@Override
	public int countByDockerContainerInstances(String toolName) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DOCKERCONTAINERINSTANCES;

		Object[] finderArgs = new Object[] { toolName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOCKERCONTAINER_WHERE);

			boolean bindToolName = false;

			if (toolName == null) {
				query.append(_FINDER_COLUMN_DOCKERCONTAINERINSTANCES_TOOLNAME_1);
			}
			else if (toolName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DOCKERCONTAINERINSTANCES_TOOLNAME_3);
			}
			else {
				bindToolName = true;

				query.append(_FINDER_COLUMN_DOCKERCONTAINERINSTANCES_TOOLNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindToolName) {
					qPos.add(toolName);
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

	private static final String _FINDER_COLUMN_DOCKERCONTAINERINSTANCES_TOOLNAME_1 =
		"dockerContainer.toolName IS NULL";
	private static final String _FINDER_COLUMN_DOCKERCONTAINERINSTANCES_TOOLNAME_2 =
		"dockerContainer.toolName = ?";
	private static final String _FINDER_COLUMN_DOCKERCONTAINERINSTANCES_TOOLNAME_3 =
		"(dockerContainer.toolName IS NULL OR dockerContainer.toolName = '')";

	public DockerContainerPersistenceImpl() {
		setModelClass(DockerContainer.class);
	}

	/**
	 * Caches the docker container in the entity cache if it is enabled.
	 *
	 * @param dockerContainer the docker container
	 */
	@Override
	public void cacheResult(DockerContainer dockerContainer) {
		entityCache.putResult(DockerContainerModelImpl.ENTITY_CACHE_ENABLED,
			DockerContainerImpl.class, dockerContainer.getPrimaryKey(),
			dockerContainer);

		finderCache.putResult(FINDER_PATH_FETCH_BY_DOCKERCONTAINER,
			new Object[] {
				dockerContainer.getToolName(), dockerContainer.getInstance()
			}, dockerContainer);

		dockerContainer.resetOriginalValues();
	}

	/**
	 * Caches the docker containers in the entity cache if it is enabled.
	 *
	 * @param dockerContainers the docker containers
	 */
	@Override
	public void cacheResult(List<DockerContainer> dockerContainers) {
		for (DockerContainer dockerContainer : dockerContainers) {
			if (entityCache.getResult(
						DockerContainerModelImpl.ENTITY_CACHE_ENABLED,
						DockerContainerImpl.class,
						dockerContainer.getPrimaryKey()) == null) {
				cacheResult(dockerContainer);
			}
			else {
				dockerContainer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all docker containers.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DockerContainerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the docker container.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DockerContainer dockerContainer) {
		entityCache.removeResult(DockerContainerModelImpl.ENTITY_CACHE_ENABLED,
			DockerContainerImpl.class, dockerContainer.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((DockerContainerModelImpl)dockerContainer);
	}

	@Override
	public void clearCache(List<DockerContainer> dockerContainers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DockerContainer dockerContainer : dockerContainers) {
			entityCache.removeResult(DockerContainerModelImpl.ENTITY_CACHE_ENABLED,
				DockerContainerImpl.class, dockerContainer.getPrimaryKey());

			clearUniqueFindersCache((DockerContainerModelImpl)dockerContainer);
		}
	}

	protected void cacheUniqueFindersCache(
		DockerContainerModelImpl dockerContainerModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					dockerContainerModelImpl.getToolName(),
					dockerContainerModelImpl.getInstance()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_DOCKERCONTAINER, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_DOCKERCONTAINER, args,
				dockerContainerModelImpl);
		}
		else {
			if ((dockerContainerModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_DOCKERCONTAINER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dockerContainerModelImpl.getToolName(),
						dockerContainerModelImpl.getInstance()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_DOCKERCONTAINER,
					args, Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_DOCKERCONTAINER,
					args, dockerContainerModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		DockerContainerModelImpl dockerContainerModelImpl) {
		Object[] args = new Object[] {
				dockerContainerModelImpl.getToolName(),
				dockerContainerModelImpl.getInstance()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_DOCKERCONTAINER, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_DOCKERCONTAINER, args);

		if ((dockerContainerModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_DOCKERCONTAINER.getColumnBitmask()) != 0) {
			args = new Object[] {
					dockerContainerModelImpl.getOriginalToolName(),
					dockerContainerModelImpl.getOriginalInstance()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DOCKERCONTAINER, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_DOCKERCONTAINER, args);
		}
	}

	/**
	 * Creates a new docker container with the primary key. Does not add the docker container to the database.
	 *
	 * @param dockerContainerId the primary key for the new docker container
	 * @return the new docker container
	 */
	@Override
	public DockerContainer create(long dockerContainerId) {
		DockerContainer dockerContainer = new DockerContainerImpl();

		dockerContainer.setNew(true);
		dockerContainer.setPrimaryKey(dockerContainerId);

		dockerContainer.setCompanyId(companyProvider.getCompanyId());

		return dockerContainer;
	}

	/**
	 * Removes the docker container with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dockerContainerId the primary key of the docker container
	 * @return the docker container that was removed
	 * @throws NoSuchDockerContainerException if a docker container with the primary key could not be found
	 */
	@Override
	public DockerContainer remove(long dockerContainerId)
		throws NoSuchDockerContainerException {
		return remove((Serializable)dockerContainerId);
	}

	/**
	 * Removes the docker container with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the docker container
	 * @return the docker container that was removed
	 * @throws NoSuchDockerContainerException if a docker container with the primary key could not be found
	 */
	@Override
	public DockerContainer remove(Serializable primaryKey)
		throws NoSuchDockerContainerException {
		Session session = null;

		try {
			session = openSession();

			DockerContainer dockerContainer = (DockerContainer)session.get(DockerContainerImpl.class,
					primaryKey);

			if (dockerContainer == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDockerContainerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(dockerContainer);
		}
		catch (NoSuchDockerContainerException nsee) {
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
	protected DockerContainer removeImpl(DockerContainer dockerContainer) {
		dockerContainer = toUnwrappedModel(dockerContainer);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dockerContainer)) {
				dockerContainer = (DockerContainer)session.get(DockerContainerImpl.class,
						dockerContainer.getPrimaryKeyObj());
			}

			if (dockerContainer != null) {
				session.delete(dockerContainer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (dockerContainer != null) {
			clearCache(dockerContainer);
		}

		return dockerContainer;
	}

	@Override
	public DockerContainer updateImpl(DockerContainer dockerContainer) {
		dockerContainer = toUnwrappedModel(dockerContainer);

		boolean isNew = dockerContainer.isNew();

		DockerContainerModelImpl dockerContainerModelImpl = (DockerContainerModelImpl)dockerContainer;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (dockerContainer.getCreateDate() == null)) {
			if (serviceContext == null) {
				dockerContainer.setCreateDate(now);
			}
			else {
				dockerContainer.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!dockerContainerModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				dockerContainer.setModifiedDate(now);
			}
			else {
				dockerContainer.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (dockerContainer.isNew()) {
				session.save(dockerContainer);

				dockerContainer.setNew(false);
			}
			else {
				dockerContainer = (DockerContainer)session.merge(dockerContainer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DockerContainerModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((dockerContainerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCKERCONTAINERINSTANCES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						dockerContainerModelImpl.getOriginalToolName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DOCKERCONTAINERINSTANCES,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCKERCONTAINERINSTANCES,
					args);

				args = new Object[] { dockerContainerModelImpl.getToolName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DOCKERCONTAINERINSTANCES,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCKERCONTAINERINSTANCES,
					args);
			}
		}

		entityCache.putResult(DockerContainerModelImpl.ENTITY_CACHE_ENABLED,
			DockerContainerImpl.class, dockerContainer.getPrimaryKey(),
			dockerContainer, false);

		clearUniqueFindersCache(dockerContainerModelImpl);
		cacheUniqueFindersCache(dockerContainerModelImpl, isNew);

		dockerContainer.resetOriginalValues();

		return dockerContainer;
	}

	protected DockerContainer toUnwrappedModel(DockerContainer dockerContainer) {
		if (dockerContainer instanceof DockerContainerImpl) {
			return dockerContainer;
		}

		DockerContainerImpl dockerContainerImpl = new DockerContainerImpl();

		dockerContainerImpl.setNew(dockerContainer.isNew());
		dockerContainerImpl.setPrimaryKey(dockerContainer.getPrimaryKey());

		dockerContainerImpl.setDockerContainerId(dockerContainer.getDockerContainerId());
		dockerContainerImpl.setGroupId(dockerContainer.getGroupId());
		dockerContainerImpl.setCompanyId(dockerContainer.getCompanyId());
		dockerContainerImpl.setUserId(dockerContainer.getUserId());
		dockerContainerImpl.setUserName(dockerContainer.getUserName());
		dockerContainerImpl.setCreateDate(dockerContainer.getCreateDate());
		dockerContainerImpl.setModifiedDate(dockerContainer.getModifiedDate());
		dockerContainerImpl.setStartCommand(dockerContainer.getStartCommand());
		dockerContainerImpl.setToolName(dockerContainer.getToolName());
		dockerContainerImpl.setInstance(dockerContainer.getInstance());
		dockerContainerImpl.setPort(dockerContainer.getPort());
		dockerContainerImpl.setUrl(dockerContainer.getUrl());
		dockerContainerImpl.setSubdomain(dockerContainer.getSubdomain());
		dockerContainerImpl.setIp(dockerContainer.getIp());
		dockerContainerImpl.setDisplayName(dockerContainer.getDisplayName());
		dockerContainerImpl.setDisplayToolName(dockerContainer.getDisplayToolName());
		dockerContainerImpl.setCategory(dockerContainer.getCategory());
		dockerContainerImpl.setTool(dockerContainer.getTool());
		dockerContainerImpl.setDescription(dockerContainer.getDescription());
		dockerContainerImpl.setCompany(dockerContainer.getCompany());
		dockerContainerImpl.setPlatform(dockerContainer.getPlatform());
		dockerContainerImpl.setLicense(dockerContainer.getLicense());
		dockerContainerImpl.setToolDescription(dockerContainer.getToolDescription());
		dockerContainerImpl.setLogourl(dockerContainer.getLogourl());

		return dockerContainerImpl;
	}

	/**
	 * Returns the docker container with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the docker container
	 * @return the docker container
	 * @throws NoSuchDockerContainerException if a docker container with the primary key could not be found
	 */
	@Override
	public DockerContainer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDockerContainerException {
		DockerContainer dockerContainer = fetchByPrimaryKey(primaryKey);

		if (dockerContainer == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDockerContainerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return dockerContainer;
	}

	/**
	 * Returns the docker container with the primary key or throws a {@link NoSuchDockerContainerException} if it could not be found.
	 *
	 * @param dockerContainerId the primary key of the docker container
	 * @return the docker container
	 * @throws NoSuchDockerContainerException if a docker container with the primary key could not be found
	 */
	@Override
	public DockerContainer findByPrimaryKey(long dockerContainerId)
		throws NoSuchDockerContainerException {
		return findByPrimaryKey((Serializable)dockerContainerId);
	}

	/**
	 * Returns the docker container with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the docker container
	 * @return the docker container, or <code>null</code> if a docker container with the primary key could not be found
	 */
	@Override
	public DockerContainer fetchByPrimaryKey(Serializable primaryKey) {
		DockerContainer dockerContainer = (DockerContainer)entityCache.getResult(DockerContainerModelImpl.ENTITY_CACHE_ENABLED,
				DockerContainerImpl.class, primaryKey);

		if (dockerContainer == _nullDockerContainer) {
			return null;
		}

		if (dockerContainer == null) {
			Session session = null;

			try {
				session = openSession();

				dockerContainer = (DockerContainer)session.get(DockerContainerImpl.class,
						primaryKey);

				if (dockerContainer != null) {
					cacheResult(dockerContainer);
				}
				else {
					entityCache.putResult(DockerContainerModelImpl.ENTITY_CACHE_ENABLED,
						DockerContainerImpl.class, primaryKey,
						_nullDockerContainer);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(DockerContainerModelImpl.ENTITY_CACHE_ENABLED,
					DockerContainerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return dockerContainer;
	}

	/**
	 * Returns the docker container with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dockerContainerId the primary key of the docker container
	 * @return the docker container, or <code>null</code> if a docker container with the primary key could not be found
	 */
	@Override
	public DockerContainer fetchByPrimaryKey(long dockerContainerId) {
		return fetchByPrimaryKey((Serializable)dockerContainerId);
	}

	@Override
	public Map<Serializable, DockerContainer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, DockerContainer> map = new HashMap<Serializable, DockerContainer>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			DockerContainer dockerContainer = fetchByPrimaryKey(primaryKey);

			if (dockerContainer != null) {
				map.put(primaryKey, dockerContainer);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			DockerContainer dockerContainer = (DockerContainer)entityCache.getResult(DockerContainerModelImpl.ENTITY_CACHE_ENABLED,
					DockerContainerImpl.class, primaryKey);

			if (dockerContainer == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, dockerContainer);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_DOCKERCONTAINER_WHERE_PKS_IN);

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

			for (DockerContainer dockerContainer : (List<DockerContainer>)q.list()) {
				map.put(dockerContainer.getPrimaryKeyObj(), dockerContainer);

				cacheResult(dockerContainer);

				uncachedPrimaryKeys.remove(dockerContainer.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(DockerContainerModelImpl.ENTITY_CACHE_ENABLED,
					DockerContainerImpl.class, primaryKey, _nullDockerContainer);
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
	 * Returns all the docker containers.
	 *
	 * @return the docker containers
	 */
	@Override
	public List<DockerContainer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the docker containers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DockerContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of docker containers
	 * @param end the upper bound of the range of docker containers (not inclusive)
	 * @return the range of docker containers
	 */
	@Override
	public List<DockerContainer> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the docker containers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DockerContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of docker containers
	 * @param end the upper bound of the range of docker containers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of docker containers
	 */
	@Override
	public List<DockerContainer> findAll(int start, int end,
		OrderByComparator<DockerContainer> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the docker containers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link DockerContainerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of docker containers
	 * @param end the upper bound of the range of docker containers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of docker containers
	 */
	@Override
	public List<DockerContainer> findAll(int start, int end,
		OrderByComparator<DockerContainer> orderByComparator,
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

		List<DockerContainer> list = null;

		if (retrieveFromCache) {
			list = (List<DockerContainer>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_DOCKERCONTAINER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOCKERCONTAINER;

				if (pagination) {
					sql = sql.concat(DockerContainerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DockerContainer>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<DockerContainer>)QueryUtil.list(q,
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
	 * Removes all the docker containers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DockerContainer dockerContainer : findAll()) {
			remove(dockerContainer);
		}
	}

	/**
	 * Returns the number of docker containers.
	 *
	 * @return the number of docker containers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DOCKERCONTAINER);

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
		return DockerContainerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the docker container persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(DockerContainerImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	protected EntityCache entityCache = EntityCacheUtil.getEntityCache();
	protected FinderCache finderCache = FinderCacheUtil.getFinderCache();
	private static final String _SQL_SELECT_DOCKERCONTAINER = "SELECT dockerContainer FROM DockerContainer dockerContainer";
	private static final String _SQL_SELECT_DOCKERCONTAINER_WHERE_PKS_IN = "SELECT dockerContainer FROM DockerContainer dockerContainer WHERE dockerContainerId IN (";
	private static final String _SQL_SELECT_DOCKERCONTAINER_WHERE = "SELECT dockerContainer FROM DockerContainer dockerContainer WHERE ";
	private static final String _SQL_COUNT_DOCKERCONTAINER = "SELECT COUNT(dockerContainer) FROM DockerContainer dockerContainer";
	private static final String _SQL_COUNT_DOCKERCONTAINER_WHERE = "SELECT COUNT(dockerContainer) FROM DockerContainer dockerContainer WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "dockerContainer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DockerContainer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DockerContainer exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(DockerContainerPersistenceImpl.class);
	private static final DockerContainer _nullDockerContainer = new DockerContainerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DockerContainer> toCacheModel() {
				return _nullDockerContainerCacheModel;
			}
		};

	private static final CacheModel<DockerContainer> _nullDockerContainerCacheModel =
		new CacheModel<DockerContainer>() {
			@Override
			public DockerContainer toEntityModel() {
				return _nullDockerContainer;
			}
		};
}