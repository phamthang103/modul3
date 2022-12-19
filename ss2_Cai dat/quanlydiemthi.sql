create database QuanLyDiemHocSinh;
use QuanLyDiemHocSinh;
create table HocSinh(
MaHS varchar(20) primary key,
TenHS varchar(50),
NgaySinh datetime,
Lop varchar(20),
GT varchar(20)
);
create table Monhoc(
MaMH varchar(20) primary key,
TenMH varchar(50)
);
create table BangDiem(
MaHS varchar(20),
MaMH varchar(20),
DiemThi int,
NgayKt datetime,
primary key(MaHS,MaMH),
foreign key(MaHS)references HocSinh(MaHS),
foreign key(MaMH)references Monhoc(MaMH)
);
create table GiaoVien(
MaGv varchar(20) primary key,
TenGV varchar(20),
SDT varchar(10)
);
alter table Monhoc
add MaGv varchar(20);
alter table Monhoc 
add
 constraint FK_MaGv foreign key(MaGv) references GiaoVien(MaGv); 
