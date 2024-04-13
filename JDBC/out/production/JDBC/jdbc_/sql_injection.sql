

CREATE TABLE actor (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(32) NOT NULL,
	sex CHAR(1) NOT NULL,
	borndate DATE,
	phone VARCHAR(12)
	)
	
INSERT INTO actor VALUES(NULL, 'cmx', '女', '2001-11-11', '456');

INSERT INTO actor VALUES(4, 'ddc', '女', '2061-11-11', 'aaa'),
		(NULL, 'ddf', '女', '2501-11-11', 'sss'),
		(NULL, 'ffg', '女', '2041-11-11', 'ddd');
	
SELECT * FROM actor;

-- 演示 sql 注入
-- 创建一张表
CREATE TABLE admin ( -- 管理员表
	`name` VARCHAR(32) NOT NULL UNIQUE, 
	pwd VARCHAR(32) NOT NULL DEFAULT '') 
	CHARACTER SET utf8; 
	
-- 添加数据
INSERT INTO admin VALUES('tom', '123'); 

-- 查找某个管理是否存在
SELECT *
	FROM admin
	WHERE NAME = 'tom' AND pwd = '123';

-- SQL
-- 输入用户名 为 1' or
-- 输入万能密码 为 or '1'= '1
SELECT *
	FROM admin
	WHERE NAME = '1' OR' AND pwd = 'OR '1'= '1';
	
SELECT * FROM admin;



