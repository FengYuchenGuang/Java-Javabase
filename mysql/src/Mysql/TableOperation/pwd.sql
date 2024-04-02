-- 演示加密函数和系统函数

-- USER() 查询用户
-- 可以查看登录到 mysql 的有哪些用户，以及登录的 IP
SELECT USER() FROM DUAL; -- 用户@IP 地址

-- DATABASE()查询当前使用数据库名称
SELECT DATABASE(); 

-- MD5(str) 为字符串算出一个 MD5 32 的字符串，常用(用户密码)加密
-- root 密码是 hsp -> 加密 md5 -> 在数据库中存放的是加密后的密码
SELECT MD5('hxz') FROM DUAL;
SELECT LENGTH(MD5('hxz')) FROM DUAL; -- 演示用户表，存放密码时，是 md5

CREATE TABLE hsp_user (
	id INT , 
	`name` VARCHAR(32) NOT NULL DEFAULT '',
	 pwd CHAR(32) NOT NULL DEFAULT '');
	 
INSERT INTO hsp_user VALUES(100, '韩顺平', MD5('hsp'));
INSERT INTO hsp_user VALUES(200, '黄叙臻', MD5('hxz'));

SELECT * FROM hsp_user; -- csdn

-- SQL 注入问题
SELECT * FROM hsp_user 
	WHERE `name`='韩顺平' AND pwd = MD5('hsp');
	
-- PASSWORD(str) -- 加密函数, MySQL 数据库的用户密码就是 PASSWORD 函数加密
SELECT PASSWORD('hsp') FROM DUAL; 
SELECT PASSWORD('hxz') FROM DUAL; 

-- 数据库的 *81220D972A52D4C51BB1C37518A2613706220DAC
-- select * from mysql.user \G 从原文密码 str 计算并返回密码字符串
-- 通常用于对 mysql 数据库的用户密码加密
-- mysql.user 表示 数据库.表
SELECT * FROM mysql.user
SELECT * FROM mysql.user \G

