create index IX_86898C72 on bibboxdocker_ApplicationStoreItem (applicationName[$COLUMN_LENGTH:75$]);

create index IX_5226FFF2 on bibboxdocker_ApplicationTag (applicationStoreItemId);
create index IX_699CDDCB on bibboxdocker_ApplicationTag (tag[$COLUMN_LENGTH:75$]);

create index IX_824CE450 on bibboxdocker_BibboxKit (applicationStoreItemId);
create index IX_6E5242E7 on bibboxdocker_BibboxKit (kitName[$COLUMN_LENGTH:75$], applicationStoreItemId);

create index IX_7AC78038 on bibboxdocker_DockerContainer (toolName[$COLUMN_LENGTH:75$], instance[$COLUMN_LENGTH:75$]);

create index IX_D1FC0980 on bibboxdocker_KitGroup (applicationStoreItemId, bibboxKitId);