-- 演示 用户权限的管理

-- 创建用户 shunping 密码 123 , 从本地登录
CREATE USER 'shunping'@'localhost' IDENTIFIED BY '123';

-- 给用户授权 
-- 1、all 可以写成其他权限
-- all 表示 所有权限都授予，除了给其他用户授予权限的权限
-- 2、ON 后面的 hsp_db03.* 表示 该数据库下所有表
-- *.* 表示所有数据库的所有表
-- 3、TO 后面写 用户
GRANT ALL ON hsp_db03.* TO 'shunping'@'localhost';

-- 使用 root 用户创建 testdb ,表 news
CREATE DATABASE testdb;

CREATE TABLE news (
	id INT , 
	content VARCHAR(32)); 

-- 添加一条测试数据
INSERT INTO news VALUES(100, '北京新闻');
SELECT * FROM news; 

-- 给 shunping 分配查看 news 表和 添加 news 的权限
GRANT SELECT , INSERT
	ON testdb.news
	TO 'shunping'@'localhost';

-- 可以增加 update 权限
GRANT UPDATE
	ON testdb.news
	TO 'shunping'@'localhost';

-- 修改 shunping 的密码为 abc
SET PASSWORD FOR 'shunping'@'localhost' = PASSWORD('abc'); 

-- 回收 shunping 用户在 testdb.news 表的所有权限
REVOKE SELECT , UPDATE, INSERT ON testdb.news FROM 'shunping'@'localhost';
REVOKE ALL ON testdb.news FROM 'shunping'@'localhost';

-- 删除 shunping
DROP USER 'shunping'@'localhos';


