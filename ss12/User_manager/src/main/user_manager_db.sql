create database user_manager_db;
use user_manager_db;
create table user(
id int(3) not null auto_increment,
`name` varchar(120) not null,
email   VARCHAR(220) NOT NULL,
country VARCHAR(120) NOT NULL,
    PRIMARY KEY (id)
);
insert into user(`name`,email,country)
values
('Nguyễn Văn An', 'annguyen@gmail.com', 'Việt Nam'),
       ('Lê Văn Bình', 'binhlv@gmail.com', 'Việt Nam'),
       ('Hồ Thị Yến', 'thiyen@gmail.com', 'Singapore'),
       ('Võ Công Toản', 'toan0404@gmail.com', 'Việt Nam'),
       ('Nguyễn Bỉnh Phát', 'phatphat@gmail.com', 'Singapore'),
       ('Khúc Nguyễn An Nghi', 'annghi20@gmail.com', 'Việt Nam'),
       ('Nguyễn Hữu Hà', 'nhh0101@gmail.com', 'Việt Nam'),
       ('Nguyễn Hà Đông', 'donghanguyen@gmail.com', 'Thái Lan'),
       ('Tòng Hoang', 'hoangtong@gmail.com', 'Việt Nam'),
       ('Nguyễn Công Đạo', 'nguyencongdao12@gmail.com', 'Việt Nam'),
       ('Nguyễn Thị Hào', 'thihao07@gmail.com', 'Việt Nam'),
       ('Phạm Xuân Diệu', 'xuandieu92@gmail.com', 'Thái Lan'),
       ('Trương Đình Nghệ', 'nghenhan2702@gmail.com', 'Việt Nam'),
       ('Dương Văn Quan', 'duongquan@gmail.com', 'Việt Nam'),
       ('Hoàng Trần Nhi Nhi', 'nhinhi123@gmail.com', 'Thái Lan'),
       ('Tôn Nữ Mộc Châu', 'tonnuchau@gmail.com', 'Việt Nam'),
       ('Nguyễn Mỹ Kim', 'kimcuong84@gmail.com', 'Lào'),
       ('Nguyễn Thị Hào', 'haohao99@gmail.com', 'Việt Nam'),
       ('Trần Đại Danh', 'danhhai99@gmail.com', 'Lào'),
       ('Nguyễn Tâm Đắc', 'dactam@gmail.com', 'Việt Nam');
       