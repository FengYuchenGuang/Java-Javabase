-- 删除表中名称为’老妖怪’的记录。
DELETE FROM employee
	WHERE user_name = '老妖怪'; 

-- 删除表中所有记录, 老师提醒，一定要小心
DELETE FROM employee; 

-- Delete 语句不能删除某一列的值（可使用 update 设为 null 或者 ''）
UPDATE employee SET job = ''
	WHERE user_name = '老妖怪';

SELECT * FROM employee


-- 要删除这个表
DROP TABLE employee

CREATE 	TABLE `employee` (
	id INT,
	`name` VARCHAR(32), 
	sex CHAR(1), 
	brithday DATE,
	entry_date DATETIME, 
	job VARCHAR(32), 
	salary DOUBLE, 
	`resume` TEXT) 
	CHARSET utf8 COLLATE utf8_bin ENGINE INNODB; 
	
-- 添加一条
INSERT INTO `employee` VALUES(100, '小妖怪', '男', '2000-11-11',
	'2010-11-10 11:11:11', '巡山的', 3000, '大王叫我来巡山');
	
INSERT INTO `employee` VALUES(101,'hxz','男','2001-04-26',
	'2024-11-11 11:11:11','学习java',9000,'sjsjsjsjs');
	
ALTER TABLE `employee`
	DROP sex;

ALTER TABLE `employee`
	ADD image VARCHAR(32) NOT NULL DEFAULT '' 
	AFTER RESUME;
	
INSERT INTO employee VALUES(200, '老妖怪', '1990-11-11', '2000-11-11 10:10:10', 
	'捶背的', 5000, '给大王捶背', 'd:\\a.jpg');
	


	