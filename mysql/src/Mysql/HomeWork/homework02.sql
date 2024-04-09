-- 2、写出查看 dept 和 emp05 表的结构的sql语句
DESC dept; 
DESC emp05; 

SELECT * FROM emp05;


-- 3、使用简单查询语句完成：
-- (1) 显示所有部门名称
-- (2) 显示所有雇员名及全年收入 13月(工资+补助)，并指定列别名 "年收入"
SELECT DISTINCT dname FROM dept;

SELECT ename,sal,comm FROM emp05;

SELECT  ename, 13*(sal+IFNULL(comm,0)) AS "年收入"
	FROM emp05;
	
-- 4、限制查询数据
-- (1) 显示工资超过2850的雇员姓名和工资
SELECT ename,sal
	FROM emp05
	WHERE sal >= 2850;

-- (2) 显示工资不在1500到2850之间的所有雇员姓名和工资
SELECT ename,sal
	FROM emp05
	WHERE sal < 1500 OR sal > 2850;

-- (3) 显示编号为7566的雇员姓名及所在部门编号
SELECT ename,deptno
	FROM emp05
	WHERE empno = 7566;

-- (4) 显示部门10和30中工资超过1500的雇员名及工资
SELECT ename,sal,deptno
	FROM emp05
	WHERE (deptno = 10 OR deptno = 30) AND sal > 1500;

-- (5) 显示无管理者的雇员名及岗位
SELECT ename,job
	FROM emp05
	WHERE mgr IS NULL;
	

-- 5、排序数据
-- (1) 显示在1991年2月1日到1991年5月1日之间雇佣的雇员名，岗位及雇佣日期，并以雇佣日期进行排序
SELECT ename,job,hiredate
	FROM emp05
	WHERE hiredate >= '1991-2-1' AND hiredate <= '1991-5-1'
	ORDER BY hiredate;

-- BETWEEN ... AND ... 包含边界
SELECT ename,job,hiredate
	FROM emp05
	WHERE hiredate BETWEEN '1991-2-1' BETWEEN '1991-5-1'
	ORDER BY hiredate;

-- (2) 显示获得补助的所有雇员名，工资及补助，并以工资降序排列
SELECT ename,sal,comm
	FROM emp05
	WHERE comm IS NOT NULL
	ORDER BY comm DESC;


