create database QuanLySinhVien;
use QuanLySinhVien;
create table Class(
classID int not null primary key auto_increment,
className varchar(60),
startDate datetime,
status bit
);
create table Student(
StudentId int not null auto_increment,
StudentName varchar(30) not null,
Address varchar(50),
Phone varchar(20),
SclassID int not null,
foreign key(classID)references Class(classID)
);
