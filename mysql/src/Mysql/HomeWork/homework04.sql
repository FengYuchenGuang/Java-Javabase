
SELECT * 
	FROM emp05;

-- ********** 
-- (13) 显示不带有'R'的员工的姓名
-- INSTR(str1,str2) 返回 str2 在 str1 中出现的位置，没有返回0
SELECT ename
	FROM emp05
	WHERE INSTR(ename,'R') = 0;

SELECT ename
	FROM emp05
	WHERE ename NOT LIKE '%R%';

-- (14) 显示所有员工姓名的前三个字符
SELECT LEFT(ename,3) AS ename
	FROM emp05;

-- (15) 显示所有员工姓名，用'a'替换所有'A'
SELECT REPLACE(ename,'A','a') AS ename
	FROM emp05;

-- (16) 显示满十年服务年限的员工姓名和受雇日期
SELECT ename,hiredate
	FROM emp05
	WHERE DATE_ADD(hiredate,INTERVAL 10 YEAR) <= NOW();

-- (17) 显示员工的详细资料，按姓名排序
SELECT * 
	FROM emp05
	ORDER BY ename;

-- (18) 显示员工的姓名和受雇日期，根据其服务年限，将最老的员工排在最前面
SELECT ename,hiredate 
	FROM emp05
	ORDER BY hiredate;

-- (19) 显示所有员工的姓名、工作和薪金，按工作降序排序，若工作相同则按薪金排序
SELECT ename,job,sal 
	FROM emp05
	ORDER BY job DESC,sal DESC;

-- (20) 显示所有员工的姓名、加入公司的年份和月份，按受雇日期所在月排序，若月份相同则将年份早的员工排前面
SELECT ename,`year` AS '年',`month` AS '月'
	FROM (SELECT ename,YEAR(hiredate) AS `year`,MONTH(hiredate) AS `month`
	FROM emp05) temp
	ORDER BY `month`,`year`;

-- (21) 显示一个月为30的情况所有员工的日薪金 忽略余数
SELECT ename,FLOOR(sal/30) AS '日薪金' ,sal/30
	FROM emp05
	ORDER BY job DESC,sal DESC;

-- (22) 找出在(任何年份的)2月受聘的员工
SELECT ename,`year` AS '年',`month` AS '月'
	FROM (SELECT ename,YEAR(hiredate) AS `year`,MONTH(hiredate) AS `month`
	FROM emp05) temp
	WHERE `month` = 2;

-- ***********
-- (23) 对于每个员工,显示其加入公司天数
SELECT ename,DATEDIFF(NOW(),hiredate) AS '加入公司天数'
	FROM emp05;

-- ******************
-- (24) 显示姓名字段的任何位置包含'A'的所有员工的姓名
SELECT ename
	FROM emp05
	WHERE INSTR(ename,'A') != 0;

SELECT ename
	FROM emp05
	WHERE ename LIKE '%A%';
	
-- ********************
-- (25) 以年月日的方式显示所有员工的服务年限
SELECT ename, FLOOR(workday/365) AS '工作年',
	FLOOR(workday%365/30) AS '工作月',
	FLOOR(workday%365%30) AS '工作日'
	FROM (SELECT ename,DATEDIFF(NOW(),hiredate) AS workday
		FROM emp05) temp;
	


