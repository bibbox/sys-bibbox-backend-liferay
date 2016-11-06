create table bibboxdocker_ApplicationInstance (
	applicationInstanceId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	instanceId TEXT null,
	name TEXT null,
	folderName TEXT null,
	shortName TEXT null,
	application TEXT null,
	version TEXT null,
	description TEXT null,
	installlog TEXT null
);

create table bibboxdocker_ApplicationInstancePort (
	applicationInstancePortId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	port LONG,
	primary_ BOOLEAN,
	applicationInstanceId LONG
);