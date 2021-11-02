create table LS_Electronics (
	uuid_ VARCHAR(75) null,
	productId LONG not null primary key,
	name VARCHAR(150) null,
	productTypeId LONG,
	cost LONG,
	amount LONG,
	present BOOLEAN,
	archived BOOLEAN,
	description TEXT null
);

create table LS_ElectronicsType (
	uuid_ VARCHAR(75) null,
	productTypeId LONG not null primary key,
	name VARCHAR(100) null
);

create table LS_Employee (
	uuid_ VARCHAR(75) null,
	employeeId LONG not null primary key,
	firstName VARCHAR(100) null,
	lastName VARCHAR(100) null,
	middleName VARCHAR(100) null,
	birthDate DATE null,
	postId LONG,
	sex BOOLEAN
);

create table LS_EmployeeRight (
	rightId LONG not null primary key,
	employeeId LONG,
	productTypeId LONG
);

create table LS_Post (
	uuid_ VARCHAR(75) null,
	postId LONG not null primary key,
	name VARCHAR(100) null
);

create table LS_Product (
	uuid_ VARCHAR(75) null,
	productId LONG not null primary key,
	name VARCHAR(150) null,
	productTypeId LONG,
	cost LONG,
	amount LONG,
	present BOOLEAN,
	archived BOOLEAN,
	description TEXT null
);

create table LS_ProductType (
	uuid_ VARCHAR(75) null,
	productTypeId LONG not null primary key,
	name VARCHAR(100) null
);

create table LS_Purchase (
	uuid_ VARCHAR(75) null,
	purchaseId LONG not null primary key,
	productId LONG,
	employeeId LONG,
	datePurchased DATE null,
	purchaseTypeId LONG
);

create table LS_PurchaseType (
	uuid_ VARCHAR(75) null,
	purchaseTypeId LONG not null primary key,
	name VARCHAR(100) null
);