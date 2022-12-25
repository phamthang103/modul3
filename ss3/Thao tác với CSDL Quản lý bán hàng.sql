use quan_li_ban_hang;
insert into customer
value
(1, 'Minh Quan', 10),
(2, 'Ngoc Oanh', 20),
(3, 'Hong Ha',50);
insert into `order`(oID,cID,oDate)
value(1,1,'2006-3-21'),
(2,2,'2006-3-23'),
(3,1,'2006-3-16');
insert into product
value(1,'May Giac',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);
insert into orderdetail
value(1,1,3),
	(1, 3, 7),
        (1, 4, 2),
        (2, 1, 1),
        (3, 1, 8),
        (2, 5, 4),
        (2, 3, 3);
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order;        
select oID, cID,oDate,oTotalPrice
from `Order`;
 -- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách;
 select c.cID,c.cName,o.oID,p.pName
 from customer c inner join `order` o on c.cID=o.cID inner join orderdetail od on o.oID=od.oID
 inner join product p on p.pID=od.pID;
  -- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào;
  select c.cName
  from customer c left join `order` o on o.cID=c.cID
  where o.cID is null;
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng  giá bán của từng loại mặt hàng xuất hiện trong hóa đơn);
select o.oID,o.odate,sum(p.pPrice*od.odQty)
from `order` o inner join orderdetail od on od.oID=o.oID inner join product p on p.pID=od.pID
group by o.oID