-- 6、根据：emp员工表 写出正确SQL
SELECT * 
	FROM emp05;

-- (1) 选择部门30中的所有员工
SELECT * 
	FROM emp05
	WHERE deptno = 30;

-- (2) 列出所有办事员（CLERK）的姓名，编号和部门编号
SELECT ename,empno,deptno 
	FROM emp05
	WHERE job = 'CLERK';
	
-- (3) 找出佣金高于薪金的员工
SELECT *
	FROM emp05
	WHERE IFNULL(comm,0) > sal;

-- (4) 找出佣金高于薪金60%的员工
SELECT *
	FROM emp05
	WHERE IFNULL(comm,0) > (sal*0.6);

-- (5) 找出部门10中所有经理（manager）和部门20中所有办事员（CLERK）的资料
SELECT *
	FROM emp05
	WHERE (job = 'CLERK' AND deptno = 20) OR (job = 'MANAGER' AND deptno = 10);

-- **************
-- (6) 找出部门10中所有经理（manager）和部门20中所有办事员（CLERK）
--     还有既不是经理又不是办事员但其薪金大于或等于2000的所有员工的详细资料
SELECT DISTINCT *
	FROM emp05
	WHERE (job = 'CLERK' AND deptno = 20) 
		OR (job = 'MANAGER' AND deptno = 10)
		OR (sal >= 2000 AND job != 'CLERK' AND job != 'MANAGER');

-- (7) 找出收取佣金的员工的不同工作
SELECT DISTINCT job
	FROM emp05
	WHERE comm IS NOT NULL;

-- (8) 找出不收取佣金或收取佣金低于100的员工
SELECT *
	FROM emp05
	WHERE comm IS NULL OR IFNULL(comm,0) < 100;

-- ******************
-- (9) 找出各月倒数第三天受雇的所有员工
-- LAST_DAY(日期) 可以返回该日期所在月份的最后一天
SELECT *
	FROM emp05
	WHERE DATE_SUB(LAST_DAY(hiredate),INTERVAL 2 DAY) = hiredate;

-- (10) 找出早于30年前受雇的员工
SELECT *
	FROM emp05
	WHERE hiredate < DATE_SUB(NOW(), INTERVAL 30 YEAR);


-- (11) 以首字母小写方式显示所有员工姓名
SELECT CONCAT(LCASE(LEFT(ename,1)),SUBSTRING(ename,2,LENGTH(ename)-1)) AS '名字'
	FROM emp05;

SELECT CONCAT(LCASE(LEFT(ename,1)),SUBSTRING(ename,2)) AS '名字'
	FROM emp05;

-- (12) 显示正好五个字符的员工的姓名
SELECT ename AS '名字'
	FROM emp05
	WHERE LENGTH(ename) = 5;


