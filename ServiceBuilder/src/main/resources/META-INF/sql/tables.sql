create table LS_Electronics (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	productType LONG,
	amount LONG,
	present BOOLEAN,
	archived BOOLEAN,
	description VARCHAR(75) null
);

create table LS_ElectronicsType (
	uuid_ VARCHAR(75) null,
	productType LONG not null primary key,
	name VARCHAR(75) null
);

create table LS_Employee (
	uuid_ VARCHAR(75) null,
	employeeId LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	middleName VARCHAR(75) null,
	birthDate DATE null,
	postId LONG,
	sex BOOLEAN
);

create table LS_Post (
	uuid_ VARCHAR(75) null,
	postId LONG not null primary key,
	name VARCHAR(75) null
);

create table LS_Purchase (
	uuid_ VARCHAR(75) null,
	purchaseId LONG not null primary key,
	productId LONG,
	employeeId LONG,
	datePurchased DATE null,
	purchaseType LONG
);

create table LS_PurchaseType (
	uuid_ VARCHAR(75) null,
	id_ LONG not null primary key,
	name VARCHAR(75) null
);