create index IX_4BB418C9 on bibboxdocker_ApplicationInstance (folderName[$COLUMN_LENGTH:5000$]);
create index IX_710D7F80 on bibboxdocker_ApplicationInstance (instanceId[$COLUMN_LENGTH:5000$]);

create index IX_FCCFF6C4 on bibboxdocker_ApplicationInstancePort (applicationInstanceId, primary_);