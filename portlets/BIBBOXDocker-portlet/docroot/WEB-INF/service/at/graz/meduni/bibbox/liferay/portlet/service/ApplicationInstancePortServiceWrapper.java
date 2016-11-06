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

package at.graz.meduni.bibbox.liferay.portlet.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ApplicationInstancePortService}.
 *
 * @author Robert Reihs
 * @see ApplicationInstancePortService
 * @generated
 */
@ProviderType
public class ApplicationInstancePortServiceWrapper
	implements ApplicationInstancePortService,
		ServiceWrapper<ApplicationInstancePortService> {
	public ApplicationInstancePortServiceWrapper(
		ApplicationInstancePortService applicationInstancePortService) {
		_applicationInstancePortService = applicationInstancePortService;
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _applicationInstancePortService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _applicationInstancePortService.getOSGiServiceIdentifier();
	}

	@Override
	public ApplicationInstancePortService getWrappedService() {
		return _applicationInstancePortService;
	}

	@Override
	public void setWrappedService(
		ApplicationInstancePortService applicationInstancePortService) {
		_applicationInstancePortService = applicationInstancePortService;
	}

	private ApplicationInstancePortService _applicationInstancePortService;
}