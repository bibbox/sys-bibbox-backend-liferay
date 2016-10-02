create table bibboxdocker_ApplicationStoreItem (
	applicationStoreItemId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	githash VARCHAR(75) null,
	depreciated BOOLEAN,
	applicationFolderName VARCHAR(75) null,
	applicationName VARCHAR(75) null,
	applicationShortName VARCHAR(75) null,
	applicationVersion VARCHAR(75) null,
	applicationReleaseState VARCHAR(75) null,
	applicationDescription TEXT null,
	applicationCatalogueUrl VARCHAR(200) null,
	applicationApplicationUrl VARCHAR(200) null
);

create table bibboxdocker_ApplicationTag (
	applicationTagsId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	tag VARCHAR(75) null,
	applicationStoreItemId LONG
);

create table bibboxdocker_BibboxKit (
	bibboxKitId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	kitName VARCHAR(75) null,
	applicationStoreItemId LONG
);

create table bibboxdocker_DockerContainer (
	dockerContainerId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	startCommand TEXT null,
	toolName VARCHAR(75) null,
	instance VARCHAR(75) null,
	port VARCHAR(75) null,
	url VARCHAR(75) null,
	subdomain VARCHAR(75) null,
	ip VARCHAR(75) null,
	displayName VARCHAR(75) null,
	displayToolName VARCHAR(75) null,
	category VARCHAR(75) null,
	tool VARCHAR(75) null,
	description TEXT null,
	company VARCHAR(75) null,
	platform VARCHAR(75) null,
	license VARCHAR(75) null,
	toolDescription TEXT null,
	logourl VARCHAR(150) null
);

create table bibboxdocker_KitGroup (
	kitGroupId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	group_ VARCHAR(75) null,
	applicationStoreItemId LONG,
	bibboxKitId LONG
);