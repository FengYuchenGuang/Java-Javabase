
SELECT *
	FROM emp05;

SELECT emp05.deptno,dname
	FROM emp05,dept
	WHERE emp05.deptno = dept.deptno

-- *********************
-- (1) 列出至少有一个员工的所有部门
SELECT COUNT(*) AS num,deptno
	FROM emp05
	GROUP BY deptno
	HAVING num > 1;

-- (2) 列出薪金比 'SMITH' 多的员工
SELECT ename,sal
	FROM emp05
	WHERE sal > (SELECT sal
		FROM emp05
		WHERE ename = 'SMITH');

-- (3) 列出受雇日期晚于其直接上级的员工
-- 自连接
SELECT worker.ename AS '员工', worker.hiredate AS '员工入职时间',
	leader.ename AS '领导', leader.hiredate AS '领导入职时间'
	FROM emp05 worker, emp05 leader
	WHERE worker.hiredate > leader.hiredate 
	AND worker.mgr = leader.empno;

-- *************************
-- (4) 列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门
-- 表外连接
SELECT dname, emp05.*
	FROM dept LEFT JOIN emp05
	ON dept.deptno = emp05.deptno
	ORDER BY dname;

-- (5) 列出所有 'CLERK' （办事员）的姓名及部门名称
SELECT ename,dname,job
	FROM emp05,dept
	WHERE emp05.deptno = dept.deptno AND job = 'CLERK';

-- ******************
-- (6) 列出最低薪金大于1500的各种工作
SELECT MIN(sal) AS min_sal,job
	FROM emp05
	GROUP BY job
	HAVING min_sal > 1500;

-- (7) 列出在部门 'SALES' （销售部）工作的员工姓名
SELECT ename,job,dname
	FROM emp05,dept
	WHERE dname = 'SALES' AND emp05.deptno = dept.deptno;

-- (8) 列出薪金高于工资平均薪金的员工
SELECT AVG(sal)
	FROM emp05;
	
SELECT ename,sal
	FROM emp05
	WHERE sal > (SELECT AVG(sal)
		FROM emp05);
	

