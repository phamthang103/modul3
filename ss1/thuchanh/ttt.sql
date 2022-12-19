create database tao_bang;
use tao_bang;
create table manager_student(
name_st varchar(255),
score_st int
);
select *from manager_student;
insert into manager_student(name_st,score_st)
value
('Thang',6),
('Thao',9);
select name_st
from manager_student;



