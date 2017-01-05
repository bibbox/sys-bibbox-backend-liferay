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

package at.graz.meduni.liferay.portlet.saat.service.persistence;

import aQute.bnd.annotation.ProviderType;

import at.graz.meduni.liferay.portlet.saat.exception.NoSuchDictionaryException;
import at.graz.meduni.liferay.portlet.saat.model.Dictionary;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the dictionary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author reihsr
 * @see at.graz.meduni.liferay.portlet.saat.service.persistence.impl.DictionaryPersistenceImpl
 * @see DictionaryUtil
 * @generated
 */
@ProviderType
public interface DictionaryPersistence extends BasePersistence<Dictionary> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DictionaryUtil} to access the dictionary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the dictionaries where codeType = &#63;.
	*
	* @param codeType the code type
	* @return the matching dictionaries
	*/
	public java.util.List<Dictionary> findByCodeType(java.lang.String codeType);

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
	public java.util.List<Dictionary> findByCodeType(
		java.lang.String codeType, int start, int end);

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
	public java.util.List<Dictionary> findByCodeType(
		java.lang.String codeType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dictionary> orderByComparator);

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
	public java.util.List<Dictionary> findByCodeType(
		java.lang.String codeType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dictionary> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first dictionary in the ordered set where codeType = &#63;.
	*
	* @param codeType the code type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary
	* @throws NoSuchDictionaryException if a matching dictionary could not be found
	*/
	public Dictionary findByCodeType_First(java.lang.String codeType,
		com.liferay.portal.kernel.util.OrderByComparator<Dictionary> orderByComparator)
		throws NoSuchDictionaryException;

	/**
	* Returns the first dictionary in the ordered set where codeType = &#63;.
	*
	* @param codeType the code type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching dictionary, or <code>null</code> if a matching dictionary could not be found
	*/
	public Dictionary fetchByCodeType_First(java.lang.String codeType,
		com.liferay.portal.kernel.util.OrderByComparator<Dictionary> orderByComparator);

	/**
	* Returns the last dictionary in the ordered set where codeType = &#63;.
	*
	* @param codeType the code type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary
	* @throws NoSuchDictionaryException if a matching dictionary could not be found
	*/
	public Dictionary findByCodeType_Last(java.lang.String codeType,
		com.liferay.portal.kernel.util.OrderByComparator<Dictionary> orderByComparator)
		throws NoSuchDictionaryException;

	/**
	* Returns the last dictionary in the ordered set where codeType = &#63;.
	*
	* @param codeType the code type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching dictionary, or <code>null</code> if a matching dictionary could not be found
	*/
	public Dictionary fetchByCodeType_Last(java.lang.String codeType,
		com.liferay.portal.kernel.util.OrderByComparator<Dictionary> orderByComparator);

	/**
	* Returns the dictionaries before and after the current dictionary in the ordered set where codeType = &#63;.
	*
	* @param dictionaryId the primary key of the current dictionary
	* @param codeType the code type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next dictionary
	* @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	*/
	public Dictionary[] findByCodeType_PrevAndNext(long dictionaryId,
		java.lang.String codeType,
		com.liferay.portal.kernel.util.OrderByComparator<Dictionary> orderByComparator)
		throws NoSuchDictionaryException;

	/**
	* Removes all the dictionaries where codeType = &#63; from the database.
	*
	* @param codeType the code type
	*/
	public void removeByCodeType(java.lang.String codeType);

	/**
	* Returns the number of dictionaries where codeType = &#63;.
	*
	* @param codeType the code type
	* @return the number of matching dictionaries
	*/
	public int countByCodeType(java.lang.String codeType);

	/**
	* Caches the dictionary in the entity cache if it is enabled.
	*
	* @param dictionary the dictionary
	*/
	public void cacheResult(Dictionary dictionary);

	/**
	* Caches the dictionaries in the entity cache if it is enabled.
	*
	* @param dictionaries the dictionaries
	*/
	public void cacheResult(java.util.List<Dictionary> dictionaries);

	/**
	* Creates a new dictionary with the primary key. Does not add the dictionary to the database.
	*
	* @param dictionaryId the primary key for the new dictionary
	* @return the new dictionary
	*/
	public Dictionary create(long dictionaryId);

	/**
	* Removes the dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary that was removed
	* @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	*/
	public Dictionary remove(long dictionaryId)
		throws NoSuchDictionaryException;

	public Dictionary updateImpl(Dictionary dictionary);

	/**
	* Returns the dictionary with the primary key or throws a {@link NoSuchDictionaryException} if it could not be found.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary
	* @throws NoSuchDictionaryException if a dictionary with the primary key could not be found
	*/
	public Dictionary findByPrimaryKey(long dictionaryId)
		throws NoSuchDictionaryException;

	/**
	* Returns the dictionary with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dictionaryId the primary key of the dictionary
	* @return the dictionary, or <code>null</code> if a dictionary with the primary key could not be found
	*/
	public Dictionary fetchByPrimaryKey(long dictionaryId);

	@Override
	public java.util.Map<java.io.Serializable, Dictionary> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the dictionaries.
	*
	* @return the dictionaries
	*/
	public java.util.List<Dictionary> findAll();

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
	public java.util.List<Dictionary> findAll(int start, int end);

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
	public java.util.List<Dictionary> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dictionary> orderByComparator);

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
	public java.util.List<Dictionary> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Dictionary> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the dictionaries from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of dictionaries.
	*
	* @return the number of dictionaries
	*/
	public int countAll();
}