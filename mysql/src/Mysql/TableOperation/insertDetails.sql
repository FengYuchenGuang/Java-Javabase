#说明 insert 语句的细节
-- 1.插入的数据应与字段的数据类型相同。
-- 比如 把 'abc' 添加到 int 类型会错误
INSERT INTO `goods` (id, goods_name, price)
	VALUES('30', '小米手机', 2000);  -- 如果'30' 底层将会尝试将 字符转为 int 
INSERT INTO `goods` (id, goods_name, price)
	VALUES('hxz', '小米手机', 2000);  -- 转为 int 失败，报错

-- 2. 数据的长度应在列的规定范围内，例如：不能将一个长度为 80 的字符串加入到长度为 40 的列中。
INSERT INTO `goods` (id, goods_name, price)
	VALUES(40, 'vovo 手机 vovo 手机 vovo 手机 vovo 手机 vovo 手机', 3000); 

-- 3. 在 values 中列出的数据位置必须与被加入的列的排列位置相对应。
INSERT INTO `goods` (id, goods_name, price) -- 不对
	VALUES('vovo 手机',40, 2000); 

-- 4. 字符和日期型数据应包含在单引号中。
INSERT INTO `goods` (id, goods_name, price)
	VALUES(40, vovo 手机, 3000); -- 错误的 vovo 手机 应该 'vovo 手机' 

-- 5. 列可以插入空值[前提是该字段允许为空]，insert into table value(null)
INSERT INTO `goods` (id, goods_name, price)
	VALUES(40, 'vovo 手机', NULL); 

-- 6. insert into tab_name (列名..) values (),(),() 形式添加多条记录
INSERT INTO `goods` (id, goods_name, price)
	VALUES(50, '三星手机', 2300),(60, '海尔手机', 1800); 

-- 7. 如果是给表中的所有字段添加数据，可以不写前面的字段名称
INSERT INTO `goods` VALUES(70, 'IBM 手机', 5000); 

-- 8. 默认值的使用，当不给某个字段值时，如果有默认值就会添加默认值，否则报错
-- 如果某个列 没有指定 not null ,那么当添加数据时，没有给定值，则会默认给 null 
-- 如果我们希望指定某个列的默认值，可以在创建表时指定
INSERT INTO `goods` (id, goods_name)
	VALUES(80, '格力手机');

SELECT * FROM goods;

INSERT INTO `goods2` (id, goods_name)
	VALUES(10, '顺平手机');
	
SELECT * FROM goods2;


