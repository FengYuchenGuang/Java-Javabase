-- 多表查询

-- ?显示雇员名,雇员工资及所在部门的名字 【笛卡尔集】
/*
老韩分析
1. 雇员名,雇员工资 来自 emp05 表
2. 部门的名字 来自 dept 表
3. 需求对 emp05 和 dept 查询 ename,sal,dname,deptno
4. 当我们需要指定显示某个表的列是，需要 表.列表
*/
SELECT ename,sal,dname,emp05.deptno
	FROM emp05, dept
	WHERE emp05.deptno = dept.deptno;

SELECT * FROM emp05;
SELECT * FROM dept;
SELECT * FROM salgrade; 

-- 老韩小技巧：多表查询的条件不能少于 表的个数-1, 否则会出现笛卡尔集
-- ?如何显示部门号为 10 的部门名、员工名和工资
SELECT ename,sal,dname,emp05.deptno
	FROM emp05, dept
	WHERE emp05.deptno = dept.deptno AND emp05.deptno = 10;

-- ?显示各个员工的姓名，工资，及其工资的级别
-- 思路 姓名，工资 来自 emp 13
-- 工资级别 salgrade 5
-- 写 sql , 先写一个简单，然后加入过滤条件... 
SELECT ename, sal, grade
	FROM emp05 , salgrade
	WHERE sal BETWEEN losal AND hisal;


