-- 演示自增长的使用
-- 自增长肯定是唯一的，要和 主键 PRIMARY KEY 或 UNIQUE 组合使用
-- 创建表
CREATE TABLE t24(
	id INT PRIMARY KEY AUTO_INCREMENT,
	email VARCHAR(32)NOT NULL DEFAULT '', 
	`name` VARCHAR(32)NOT NULL DEFAULT '');

DESC t24;

-- 测试自增长的使用
INSERT INTO t24 VALUES(NULL, 'tom@qq.com', 'tom');

INSERT INTO t24 (email, `name`) VALUES('hsp@sohu.com', 'hsp');

SELECT * FROM t24; 


CREATE TABLE t25 (
	id INT PRIMARY KEY AUTO_INCREMENT, 
	email VARCHAR(32)NOT NULL DEFAULT '', 
	`name` VARCHAR(32)NOT NULL DEFAULT '');

-- 修改默认的自增长开始值
ALTER TABLE t25 AUTO_INCREMENT = 100;
	
INSERT INTO t25 VALUES(NULL, 'mary@qq.com', 'mary');
INSERT INTO t25 VALUES(NULL, 'hxz@qq.com', 'hxz');
INSERT INTO t25 VALUES(666, 'hsp@qq.com', 'hsp');

SELECT * FROM t25;

DROP TABLE t25;




