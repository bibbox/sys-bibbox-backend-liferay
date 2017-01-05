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

package at.graz.meduni.liferay.portlet.saat.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Dictionary service. Represents a row in the &quot;saat_Dictionary&quot; database table, with each column mapped to a property of this class.
 *
 * @author reihsr
 * @see DictionaryModel
 * @see at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryImpl
 * @see at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryModelImpl
 * @generated
 */
@ImplementationClassName("at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryImpl")
@ProviderType
public interface Dictionary extends DictionaryModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link at.graz.meduni.liferay.portlet.saat.model.impl.DictionaryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Dictionary, Long> DICTIONARY_ID_ACCESSOR = new Accessor<Dictionary, Long>() {
			@Override
			public Long get(Dictionary dictionary) {
				return dictionary.getDictionaryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Dictionary> getTypeClass() {
				return Dictionary.class;
			}
		};
}