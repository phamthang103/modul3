create database QUAN_LI_BAN_HANG;
use QUAN_LI_BAN_HANG;
create table customer
(
cID int not null primary key,
cName varchar(50),
cAge int not null
);
create table product(
pID int not null primary key,
pName varchar(30),
pPrice double not null
);
create table `Order`(
cID int not null,
oID int not null primary key,
oDate datetime,
oTotalPrice double,
foreign key(cID)references Customer(cID)
);
create table OrderDetail(
oID int not null,
pID int not null,
odQty varchar(50),
foreign key(oID)references `Order`(oID),
foreign key(pID)references product(pID)
);
