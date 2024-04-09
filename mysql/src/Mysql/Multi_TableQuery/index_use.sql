-- 演示 mysql 的索引的使用

-- 创建索引
CREATE TABLE t25_1 (
	id INT , 
	`name` VARCHAR(32));

-- 查询表是否有索引
SHOW INDEXES FROM t25_1; 

-- 添加索引
-- 添加唯一索引
CREATE UNIQUE INDEX id_index ON t25_1 (id); 

-- 添加普通索引方式 1
CREATE INDEX id_index2 ON t25_1 (id); 

-- 如何选择
-- 1. 如果某列的值，是不会重复的，则优先考虑使用 unique 索引, 否则使用普通索引
-- 添加普通索引方式 2
ALTER TABLE t25_1 ADD INDEX id_index3 (id)

-- 添加主键索引
CREATE TABLE t26 (
	id INT ,
	 `name` VARCHAR(32));

ALTER TABLE t26 ADD PRIMARY KEY (id);
SHOW INDEX FROM t26;
SHOW INDEX FROM t25_1;

-- 删除索引
DROP INDEX id_index ON t25_1
-- 删除主键索引
ALTER TABLE t26 DROP PRIMARY KEY

-- 修改索引 ， 先删除，在添加新的索引
-- 查询索引
-- 1. 方式
SHOW INDEX FROM t25_1
-- 2. 方式
SHOW INDEXES FROM t25_1
-- 3. 方式
SHOW KEYS FROM t25_1
-- 4 方式
DESC t25_1

