-- 演示字符串相关函数的使用 ， 使用 emp 表来演示
-- CHARSET(str) 返回字串字符集
SELECT CHARSET(ename) FROM emp05; 

-- CONCAT (string2 [,... ]) 连接字串, 将多个列拼接成一列
SELECT CONCAT(ename, ' 工作是 ', job) FROM emp05; 

-- INSTR (string ,substring ) 返回 substring 在 string 中出现的位置,没有返回 0
-- dual 亚元表, 系统表 可以作为测试表使用
SELECT INSTR('hanshunping', 'ping') FROM DUAL; 

-- UCASE (string2 ) 转换成大写
SELECT UCASE(ename) FROM emp05; 

-- LCASE (string2 ) 转换成小写
SELECT LCASE(ename) FROM emp05; 

-- LEFT (string2 ,length )从 string2 中的左边起取 length 个字符
-- RIGHT (string2 ,length ) 从 string2 中的右边起取 length 个字符
SELECT LEFT(ename, 2) FROM emp05; 
SELECT RIGHT(ename, 2) FROM emp05; 

-- LENGTH (string )string 长度[按照字节]
SELECT LENGTH(ename) FROM emp05; 
SELECT LENGTH('黄叙臻') FROM emp05; 

-- REPLACE (str ,search_str ,replace_str )
-- 在 str 中用 replace_str 替换 search_str
-- 如果是 manager 就替换成 经理
SELECT ename, REPLACE(job,'MANAGER', '经理') FROM emp05;

-- STRCMP (string1 ,string2 ) 逐字符比较两字串大小
SELECT STRCMP('hsp', 'hsp') FROM DUAL; 
SELECT STRCMP('hspa', 'hsp') FROM DUAL; 
SELECT STRCMP('hxz', 'hsp') FROM DUAL; 
SELECT STRCMP('aa', 'hsp') FROM DUAL; 

-- SUBSTRING (str , position [,length ])
-- 从 str 的 position 开始【从 1 开始计算】,取 length 个字符
-- 从 ename 列的第一个位置开始取出 2 个字符
SELECT SUBSTRING(ename, 1, 2) FROM emp05; 

-- LTRIM (string2 ) RTRIM (string2 ) TRIM(string)
-- 去除前端空格或后端空格
SELECT LTRIM('    韩顺平教育') FROM DUAL;
SELECT RTRIM('韩顺平教育   ') FROM DUAL;
SELECT TRIM('   韩顺平教育 ') FROM DUAL; 

-- 练习: 以首字母小写的方式显示所有员工 emp 表的姓名
-- 方法 1
-- 思路先取出 ename 的第一个字符，转成小写的
-- 把他和后面的字符串进行拼接输出即可
SELECT CONCAT(LCASE(SUBSTRING(ename,1,1)), SUBSTRING(ename,2)) AS new_name
	FROM emp05;
SELECT CONCAT(LCASE(LEFT(ename,1)), SUBSTRING(ename,2)) AS new_name
	FROM emp05;


