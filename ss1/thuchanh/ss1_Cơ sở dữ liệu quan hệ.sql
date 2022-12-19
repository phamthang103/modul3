use a07_phamthang;
create table thong_tin(
ma_hs int,
ten_hs varchar(255),
tuoi_hs int
);
select *from thong_tin;
insert into thong_tin(ma_sv, ten_hs, diem_hs)
value
(1, 'thang', 25),
(2, 'thang', 26),
(2, 'thang', 26);
select diem_hs
from thong_tin
