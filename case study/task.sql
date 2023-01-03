use furamadatabase;
-- Task 02
select * from nhan_vien
where (ho_ten like 'h%') or (ho_ten like 't%') or (ho_ten like 'k%') and (select length(ho_ten) <= 15);
-- Task 03
select * from khach_hang
where timestampdiff(year,ngay_sinh,curdate())between 18 and 50 and (dia_chi like '%Da Nang' or dia_chi like '%Quang Tri');
-- task 4
select k.ho_ten,count(h.ma_hop_dong)as dem_so
from khach_hang k join hop_dong h on k.ma_khach_hang=h.ma_khach_hang
where k.ma_loai_khach=1
group by k.ho_ten
order by dem_so asc;
-- task 5;
select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong,hd.ngay_ket_thuc, (dv.chi_phi_thue + ifnull(hdct.so_luong * dvdk.gia, 0)) as tong_tien
from khach_hang kh
left join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
left join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
left join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by hd.ma_hop_dong
order by kh.ma_khach_hang;
-- task 6;
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv
inner join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where dv.ma_dich_vu not in
(select ma_dich_vu from hop_dong where
year(ngay_lam_hop_dong) = '2021' and (month(ngay_lam_hop_dong) between 1 and 3));
-- Task 07
select dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv
inner join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
inner join hop_dong hd on hd.ma_dich_vu = dv.ma_dich_vu
where dv.ma_dich_vu not in 
(select ma_dich_vu from hop_dong where
year(ngay_lam_hop_dong) = '2021') and year(hd.ngay_lam_hop_dong) = '2020'
group by dv.ma_dich_vu;

-- Task 08
SELECT 
	DISTINCT ho_ten 
FROM 
	khach_hang;

-- Task 09
select month(ngay_lam_hop_dong) as 'thang', count(ma_khach_hang) as so_luong_kh
from hop_dong
where year(ngay_lam_hop_dong) = '2021'
GROUP BY thang
order by thang asc;

-- Task 10
select hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, sum(ifnull(hdct.so_luong, 0)) as so_luong
from hop_dong hd
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
group by hd.ma_hop_dong;

-- Task 11
select lk.ten_loai_khach, dvdk.ma_dich_vu_di_kem ,dvdk.ten_dich_vu_di_kem
from hop_dong hd
inner join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
inner join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
inner join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
inner join loai_khach lk on lk.ma_loai_khach = kh.ma_loai_khach
where (kh.dia_chi like '%_Vinh') or (kh.dia_chi like '%_Quãng Ngãi') and (kh.ma_loai_khach = 1);

-- Task 12
select hd.ma_hop_dong, nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, dv.ten_dich_vu, sum(ifnull(hdct.so_luong, 0)) as so_luong
from hop_dong hd
left join khach_hang kh on kh.ma_khach_hang = hd.ma_khach_hang
left join nhan_vien nv on nv.ma_nhan_vien = hd.ma_nhan_vien
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
where hd.ma_hop_dong in 
(select ma_hop_dong from hop_dong where
year(ngay_lam_hop_dong) = '2020' and (month(ngay_lam_hop_dong)between 10 and 12))
and hd.ma_hop_dong not in
(select ma_hop_dong from hop_dong where
year(ngay_lam_hop_dong) = '2021' and (month(ngay_lam_hop_dong)between 1 and 6))
group by hd.ma_hop_dong;

-- Task 13
select dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, sum(hdct.so_luong) as so_luong_dv_di_kem
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
group by dvdk.ma_dich_vu_di_kem
having sum(hdct.so_luong) = (select max(max.soluong) from
(select sum(hdct.so_luong) as soluong from hop_dong_chi_tiet hdct 
group by hdct.ma_dich_vu_di_kem) as max);

-- Task 14
select hd.ma_hop_dong, dv.ten_dich_vu, dvdk.ten_dich_vu_di_kem, count(hdct.ma_dich_vu_di_kem) as so_lan_su_dung
from hop_dong hd
join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
group by dvdk.ten_dich_vu_di_kem
having count(hdct.ma_dich_vu_di_kem) = 1
order by hd.ma_hop_dong asc;

-- Task 15
select nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi
from nhan_vien nv
join hop_dong hd on hd.ma_nhan_vien = nv.ma_nhan_vien
join trinh_do td on td.ma_trinh_do = nv.ma_trinh_do
join bo_phan bp on bp.ma_bo_phan = nv.ma_bo_phan
where year(hd.ngay_lam_hop_dong) between 2020 and 2021
group by nv.ma_nhan_vien
having count(hd.ma_nhan_vien) <= 3;

-- Task 16
delete
from nhan_vien nv
where nv.ma_nhan_vien not in (select ma_nhan_vien from hop_dong hd);
-- Task 17






