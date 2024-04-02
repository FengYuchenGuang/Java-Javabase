#练习 insert 语句
-- 创建一张商品表 goods (id int , goods_name varchar(10), price double ); -- 添加 2 条记录
CREATE TABLE `goods` (
	id INT ,
	goods_name VARCHAR(10), -- 长度 10
	price DOUBLE NOT NULL DEFAULT 100 ); -- 添加数据

INSERT INTO `goods` (id, goods_name, price)
	VALUES(10, '华为手机', 2000);

INSERT INTO `goods` (id, goods_name, price)
	VALUES(11, '苹果手机', 7000);

INSERT INTO `goods` (id, goods_name)
	VALUES(12, '手机');
	
SELECT * FROM `goods`;


