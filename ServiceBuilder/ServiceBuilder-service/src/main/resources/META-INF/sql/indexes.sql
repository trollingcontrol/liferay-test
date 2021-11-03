create index IX_1FBB836F on LS_Electronics (uuid_[$COLUMN_LENGTH:75$]);

create index IX_2B089CD5 on LS_ElectronicsType (uuid_[$COLUMN_LENGTH:75$]);

create index IX_B26EB768 on LS_Employee (uuid_[$COLUMN_LENGTH:75$]);

create index IX_1C4EE9B6 on LS_Post (uuid_[$COLUMN_LENGTH:75$]);

create index IX_DD0AC6F7 on LS_Product (uuid_[$COLUMN_LENGTH:75$]);

create index IX_A37E23F6 on LS_ProductType (name[$COLUMN_LENGTH:100$]);
create index IX_607ADC5D on LS_ProductType (uuid_[$COLUMN_LENGTH:75$]);

create index IX_DF7A0675 on LS_Purchase (uuid_[$COLUMN_LENGTH:75$]);

create index IX_12222CDB on LS_PurchaseType (uuid_[$COLUMN_LENGTH:75$]);