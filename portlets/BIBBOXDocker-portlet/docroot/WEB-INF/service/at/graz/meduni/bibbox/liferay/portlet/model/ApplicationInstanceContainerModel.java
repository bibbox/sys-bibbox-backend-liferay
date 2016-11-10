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

package at.graz.meduni.bibbox.liferay.portlet.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ApplicationInstanceContainer service. Represents a row in the &quot;bibboxdocker_ApplicationInstanceContainer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceContainerModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceContainerImpl}.
 * </p>
 *
 * @author Robert Reihs
 * @see ApplicationInstanceContainer
 * @see at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceContainerImpl
 * @see at.graz.meduni.bibbox.liferay.portlet.model.impl.ApplicationInstanceContainerModelImpl
 * @generated
 */
@ProviderType
public interface ApplicationInstanceContainerModel extends BaseModel<ApplicationInstanceContainer>,
	GroupedModel, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a application instance container model instance should use the {@link ApplicationInstanceContainer} interface instead.
	 */

	/**
	 * Returns the primary key of this application instance container.
	 *
	 * @return the primary key of this application instance container
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this application instance container.
	 *
	 * @param primaryKey the primary key of this application instance container
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the application instance container ID of this application instance container.
	 *
	 * @return the application instance container ID of this application instance container
	 */
	public long getApplicationInstanceContainerId();

	/**
	 * Sets the application instance container ID of this application instance container.
	 *
	 * @param applicationInstanceContainerId the application instance container ID of this application instance container
	 */
	public void setApplicationInstanceContainerId(
		long applicationInstanceContainerId);

	/**
	 * Returns the group ID of this application instance container.
	 *
	 * @return the group ID of this application instance container
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this application instance container.
	 *
	 * @param groupId the group ID of this application instance container
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this application instance container.
	 *
	 * @return the company ID of this application instance container
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this application instance container.
	 *
	 * @param companyId the company ID of this application instance container
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this application instance container.
	 *
	 * @return the user ID of this application instance container
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this application instance container.
	 *
	 * @param userId the user ID of this application instance container
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this application instance container.
	 *
	 * @return the user uuid of this application instance container
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this application instance container.
	 *
	 * @param userUuid the user uuid of this application instance container
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this application instance container.
	 *
	 * @return the user name of this application instance container
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this application instance container.
	 *
	 * @param userName the user name of this application instance container
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this application instance container.
	 *
	 * @return the create date of this application instance container
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this application instance container.
	 *
	 * @param createDate the create date of this application instance container
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this application instance container.
	 *
	 * @return the modified date of this application instance container
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this application instance container.
	 *
	 * @param modifiedDate the modified date of this application instance container
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the container name of this application instance container.
	 *
	 * @return the container name of this application instance container
	 */
	@AutoEscape
	public String getContainerName();

	/**
	 * Sets the container name of this application instance container.
	 *
	 * @param containerName the container name of this application instance container
	 */
	public void setContainerName(String containerName);

	/**
	 * Returns the needrunning of this application instance container.
	 *
	 * @return the needrunning of this application instance container
	 */
	public boolean getNeedrunning();

	/**
	 * Returns <code>true</code> if this application instance container is needrunning.
	 *
	 * @return <code>true</code> if this application instance container is needrunning; <code>false</code> otherwise
	 */
	public boolean isNeedrunning();

	/**
	 * Sets whether this application instance container is needrunning.
	 *
	 * @param needrunning the needrunning of this application instance container
	 */
	public void setNeedrunning(boolean needrunning);

	/**
	 * Returns the application instance ID of this application instance container.
	 *
	 * @return the application instance ID of this application instance container
	 */
	public long getApplicationInstanceId();

	/**
	 * Sets the application instance ID of this application instance container.
	 *
	 * @param applicationInstanceId the application instance ID of this application instance container
	 */
	public void setApplicationInstanceId(long applicationInstanceId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer applicationInstanceContainer);

	@Override
	public int hashCode();

	@Override
	public CacheModel<at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer> toCacheModel();

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer toEscapedModel();

	@Override
	public at.graz.meduni.bibbox.liferay.portlet.model.ApplicationInstanceContainer toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}