create database Quan_Ly_Don_Hang;
use Quan_Ly_Don_Hang;
create table Product
(
product_ID int not null primary key,
product_name varchar(50) not null,
product_price double not null
);
create table Customer
(
customer_ID int not null primary key,
customer_name varchar(50),
customer_age int not null
);
create table orders
(
order_ID int not null primary key ,
order_Date DATETIME,
order_totalprice double,
foreign key (customer_ID) REFERENCES Customer (customer_ID)
);