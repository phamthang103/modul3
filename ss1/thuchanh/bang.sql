create database student_management;
use student_management;
create table teacher(
id int auto_increment,
name varchar(50),
age int,
country varchar(50),
primary key(id)
);
create table student(
id int auto_increment,
name varchar(50),
primary key(id)
);
insert into student(name) value('Thang'),('Thao'),('Thanh');
select*from student;
alter table student add age int;
set sql_safe_updates=0;
insert into teacher(name) value('Cong');
insert into teacher(age) value(34);
insert into teacher(country) value('VietNam');
select*from teacher;






