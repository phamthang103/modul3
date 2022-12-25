-- Bước 1: 
create DATABASE SS05;

-- Bước 2:
use SS05;
create table Product
(	Id int not null primary key AUTO_INCREMENT,
	productCode int not null,
    productName varchar(30),
    productPrice DOUBLE,
    productAmount int,
    productDescription varchar(30) DEFAULT 'No Description',
    productStatus bit
);

insert into Product (productCode, productName, productPrice, productAmount, productDescription, productStatus)
values (111, 'CocaCola', 10.0, 5, 'Made in Vietnam', 1),
		(123, 'Pepsi', 10.5, 10, 'Made in Vietnam', 1),
		(124, 'Sting', 12.0, 2, 'Product of PepsiCo', 0),
        (321, 'Redbull', 15.0, 20, 'Made in Thailand', 1);
 
-- Bước 3:
alter table Product add unique index id_product(Id);
alter table Product add index nameprice_product(productName, productPrice);

explain select * from Product where Id = '1';
explain select * from Product where productName = 'Sting' or productPrice = '12.0';

-- Bước 4:
create view product_view as
select productCode, productName, productPrice, productStatus
from product;

select *
from product_view;

drop view product_view;

-- Bước 5:
-- 5.1: Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER //
create procedure findallProduct()
begin
	select * from product ;
end//
DELIMITER ;

call findallProduct();

-- 5.2: Tạo store procedure thêm một sản phẩm mới
DELIMITER //
create procedure addProduct(
	in in_code int,
    in in_name varchar(30),
    in in_price double,
    in in_amount int,
    in in_description varchar(30),
    in in_status bit)
begin
	insert into product(productCode, productName, productPrice, productAmount, productDescription, productStatus)
	values (in_code, in_name, in_price, in_amount, in_description, in_status);
    call findallProduct();
end//
DELIMITER ;

call addProduct(222, 'Number One', 12.5, 20, 'Made in Vietnam', 0);

-- 5.3: Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER //
create procedure updateProductByID(
	in in_id int,
    in in_code int,
    in in_name varchar(30),
    in in_price double,
    in in_amount int,
    in in_description varchar(30),
    in in_status bit)
begin
	update product
    set productCode = in_code,
		productName = in_name,
		productPrice = in_price,
		productAmount = in_amount,
		productDescription = in_description,
		productStatus = in_status
	where in_id = Id;
    call findallProduct();
end//
DELIMITER ;

call updateProductByID(1, 999, 'Thạch Bích', 8.0, 30, 'Made in Vietnam', 1);

-- 5.4: Tạo store procedure xoá sản phẩm theo id
DELIMITER //
create procedure deleteProductByID(in in_id int)
begin
	delete from product
    where in_id = Id;
    call findallProduct();
end//
DELIMITER ;

call deleteProductByID(4);