

CREATE DATABASE mhl;

-- =======员工表=======
CREATE TABLE `employee`(
	id INT PRIMARY KEY AUTO_INCREMENT, -- 自增
	empId VARCHAR(50) NOT NULL DEFAULT '' UNIQUE,
	pwd CHAR(32) NOT NULL DEFAULT '', -- 密码MD5
	`name` VARCHAR(50) NOT NULL DEFAULT '',
	sex CHAR(1) NOT NULL,
	job VARCHAR(50) NOT NULL DEFAULT '',
	phone VARCHAR(12) NOT NULL
	) CHARSET utf8;

SELECT * FROM `employee`;

-- drop table `employee`;

INSERT INTO `employee` VALUES(NULL,'1001',MD5('000000'),'hxz','男','老板','18968687247'),
	(NULL,'1002',MD5('111111'),'cmx','女','大堂经理','18968687247'),
	(NULL,'1003',MD5('222222'),'cooker1','男','厨师','18968687247'),
	(NULL,'1004',MD5('222222'),'cooker2','男','厨师','18968687247'),
	(NULL,'1005',MD5('333333'),'wjh','女','服务员','18968687247'),
	(NULL,'1006',MD5('333333'),'jmx','女','服务员','18968687247'),
	(NULL,'1007',MD5('444444'),'xd','男','仓库管理员','18968687247'),
	(NULL,'1008',MD5('555555'),'wmj','女','收银员','18968687247');



-- =======餐桌=======
CREATE TABLE `diningTable`(
	id INT PRIMARY KEY AUTO_INCREMENT, -- 自增 餐桌编号
	state VARCHAR(20) NOT NULL DEFAULT '', -- 餐桌状态 空 已预订 用餐中
	orderName VARCHAR(50) NOT NULL DEFAULT '', -- 预定人名字
	orderPhone VARCHAR(12) NOT NULL DEFAULT '' -- 预定人电话
	) CHARSET utf8;

SELECT * FROM `diningTable`;

-- drop table `diningTable`;

DELETE FROM diningTable;

INSERT INTO `diningTable` VALUES(1,'空','',''),
	(2,'空','',''),
	(3,'空','','');
	
INSERT INTO `diningTable` VALUES(NULL,'空','',''),
	(NULL,'空','',''),
	(NULL,'空','','');

SELECT id,state FROM diningTable;
	
UPDATE diningTable SET state = '已预订',orderName = '黄叙臻',orderPhone = '1228989' WHERE id = 1;

UPDATE diningTable SET state = '空' ,orderName = '', orderPhone = '' WHERE id = 1;


-- =======菜单=======
CREATE TABLE `menu`(
	id INT PRIMARY KEY AUTO_INCREMENT, -- 自增 作为菜谱编号
	`name` VARCHAR(50) NOT NULL DEFAULT '', -- 菜谱名称
	`type` VARCHAR(50) NOT NULL DEFAULT '', -- 菜品类型
	price DOUBLE NOT NULL DEFAULT 0 -- 价格
	) CHARSET utf8;

SELECT * FROM `menu`;

-- drop table `menu`;

INSERT INTO `menu` VALUES(NULL,'八宝饭','主食',10),
	(NULL,'叉烧包','主食',20),
	(NULL,'宫保鸡丁','热菜',30),
	(NULL,'山药拔鱼','凉菜',14),
	(NULL,'银丝卷','甜食',9),
	(NULL,'水煮鱼','热菜',26),
	(NULL,'甲鱼汤','汤类',100),
	(NULL,'鸡蛋汤','汤类',16);
	
SELECT * FROM menu;



-- =======账单=======
CREATE TABLE `bill`(
	id INT PRIMARY KEY AUTO_INCREMENT, -- 自增 作为账单编号
	billId VARCHAR(50) NOT NULL DEFAULT '', 
	menuId INT NOT NULL, -- 菜谱编号 外键
	nums INT NOT NULL DEFAULT 0, -- 菜品数量
	money DOUBLE NOT NULL DEFAULT 0, -- 价格 
	tableId INT NOT NULL DEFAULT 0, -- 桌号 外键
	billDate DATETIME NOT NULL, -- 账单日期
	state VARCHAR(50) NOT NULL DEFAULT '', -- 账单状态 未结账 已结账 挂单 现金 支付宝 坏账
	FOREIGN KEY (menuId) REFERENCES menu(id),
	FOREIGN KEY (tableId) REFERENCES diningTable(id)
	) CHARSET utf8;

SELECT * FROM `bill`;

-- drop table `bill`;


SELECT * FROM bill;

SELECT DISTINCT billId FROM bill WHERE tableId = 1;

SELECT id,billId,menuId,nums,money,tableId,billDate,state FROM bill;
	

INSERT INTO bill VALUES(NULL,'773ggssjsj',1,2,20,2,NOW(),'未结账');

UPDATE bill SET state = '现金' WHERE billId = 'ssjsjsj';
UPDATE bill SET state = '未结账';

SELECT DISTINCT billId FROM bill WHERE tableId = 1;

DELETE FROM bill WHERE id = 15 OR id = 16;

SELECT * FROM bill WHERE state = '未结账' AND tableId = 1;

SELECT billId,billDate FROM bill WHERE tableId = 2 ORDER BY billDate DESC;



-- 多表查询
SELECT bill.*, `name`
	FROM bill,menu
	WHERE bill.menuId = menu.id;

