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
 * Provides a wrapper for {@link ApplicationInstanceStatusService}.
 *
 * @author Robert Reihs
 * @see ApplicationInstanceStatusService
 * @generated
 */
@ProviderType
public class ApplicationInstanceStatusServiceWrapper
	implements ApplicationInstanceStatusService,
		ServiceWrapper<ApplicationInstanceStatusService> {
	public ApplicationInstanceStatusServiceWrapper(
		ApplicationInstanceStatusService applicationInstanceStatusService) {
		_applicationInstanceStatusService = applicationInstanceStatusService;
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _applicationInstanceStatusService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _applicationInstanceStatusService.getOSGiServiceIdentifier();
	}

	@Override
	public ApplicationInstanceStatusService getWrappedService() {
		return _applicationInstanceStatusService;
	}

	@Override
	public void setWrappedService(
		ApplicationInstanceStatusService applicationInstanceStatusService) {
		_applicationInstanceStatusService = applicationInstanceStatusService;
	}

	private ApplicationInstanceStatusService _applicationInstanceStatusService;
}