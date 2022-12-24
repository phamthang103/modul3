create database quanlisinhvien;
use quanlisinhvien;
CREATE TABLE Class
(
    ClassID   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ClassName VARCHAR(60) NOT NULL,
    StartDate DATETIME    NOT NULL,
    Status    BIT
);
CREATE TABLE Student(
StudentId int not null primary key auto_increment,
StudentName varchar(30) not null,
Address varchar(50),
Phone varchar(20),
Status bit,
ClassID  int not null,
foreign key(ClassID) references Class(ClassID)
);
create table Subject(
SubId int not null auto_increment primary key,
SubName varchar(30) not null,
Credit tinyint not null default 1 check(Credit>=1),
 status bit default 1
);
CREATE TABLE Mark
(
    MarkId    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubId     INT NOT NULL,
    StudentId INT NOT NULL,
    Mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    UNIQUE (SubId, StudentId),
    FOREIGN KEY (SubId) REFERENCES Subject (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
);
INSERT INTO Class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);
insert into student(StudentName,Address,Phone,Status,ClassID)
values('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO Student (StudentName, Address, Status, ClassId)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);
INSERT INTO Subject
VALUES (1, 'CF', 5, 1),
       (3, 'C', 6, 1),
       (2, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (3, 2, 10, 2),
       (2, 1, 12, 1);
select* from student;
select *from student where Status=false;
select *from student where Status=true;
select*from subject where Credit<10;
select *from subject where Credit=10;
/*sử dụng join và where để hiện thị danh sách lớp A1*/
select student.StudentId,student.StudentName,class.ClassName
from student join class on ClassName='A1';
select c.StudentId,c.StudentName,s.ClassName
from student c join class s on c.ClassId=s.ClassID;
select s.studentID,s.studentName,sub.subName,m.Mark
from student s join mark m on s.StudentId=m.StudentId join subject sub on m.SubId=sub.SubId
where sub.SubName='CF';
/*Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’*/
select s.studentID,s.studentName,c.className
from student s join class c on s.ClassId=c.ClassID
where StudentName like 'h%';
/*Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘m’*/
select * from student
where StudentName like 'h%';
/*Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.8*/
select *from class
where month(startdate)=12;
/*Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5*/
select * from subject
where Credit between 5 and 7;
select * from subject
where Credit='5';
/*Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.*/
set sql_safe_updates=0;
update student set classID='2' where studentName='Hung';
set sql_safe_updates=1;
/*Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần*/
select s.studentName,sub.subName,m.mark
from Student S join Subject Sub join Mark M
order by mark asc,studentname asc;