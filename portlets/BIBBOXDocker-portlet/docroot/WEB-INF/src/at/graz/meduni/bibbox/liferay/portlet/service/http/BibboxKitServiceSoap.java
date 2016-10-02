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

package at.graz.meduni.bibbox.liferay.portlet.service.http;

import aQute.bnd.annotation.ProviderType;

/**
 * Provides the SOAP utility for the
 * {@link at.graz.meduni.bibbox.liferay.portlet.service.BibboxKitServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link at.graz.meduni.bibbox.liferay.portlet.model.BibboxKitSoap}.
 * If the method in the service utility returns a
 * {@link at.graz.meduni.bibbox.liferay.portlet.model.BibboxKit}, that is translated to a
 * {@link at.graz.meduni.bibbox.liferay.portlet.model.BibboxKitSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Robert Reihs
 * @see BibboxKitServiceHttp
 * @see at.graz.meduni.bibbox.liferay.portlet.model.BibboxKitSoap
 * @see at.graz.meduni.bibbox.liferay.portlet.service.BibboxKitServiceUtil
 * @generated
 */
@ProviderType
public class BibboxKitServiceSoap {
}