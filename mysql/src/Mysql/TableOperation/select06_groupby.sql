# 演示 group by + having
# GROUP by 用于对查询的结果分组统计, (示意图)
SELECT * FROM salgrade;
SELECT * FROM dept;
SELECT * FROM emp05;

-- having 子句用于限制分组显示结果. 
-- ?如何显示每个部门的平均工资和最高工资
-- 老韩分析: avg(sal) max(sal)
-- 按照部分来分组查询
SELECT AVG(sal), MAX(sal) , deptno
	FROM emp05 GROUP BY deptno; 
	
-- 使用数学方法，对小数点进行处理	
SELECT FORMAT(AVG(sal),2), MAX(sal) , deptno
	FROM emp05 GROUP BY deptno; 
	
-- ?显示每个部门的每种岗位的平均工资和最低工资
-- 老师分析 1. 显示每个部门的平均工资和最低工资
-- 	    2. 显示每个部门的每种岗位的平均工资和最低工资
SELECT AVG(sal), MIN(sal) , deptno, job
	FROM emp05 GROUP BY deptno, job; 

-- ?显示平均工资低于 2000 的部门号和它的平均工资 // 别名
-- 老师分析 [写 sql 语句的思路是化繁为简,各个击破]
-- 1. 显示各个部门的平均工资和部门号
SELECT AVG(sal), deptno
	FROM emp05 GROUP BY deptno;

-- 2. 在 1 的结果基础上，进行过滤，保留 AVG(sal) < 2000
-- 3. 使用别名进行过滤
SELECT AVG(sal), deptno
	FROM emp05 GROUP BY deptno
		HAVING AVG(sal) < 2000; 
	
-- 使用别名	
SELECT AVG(sal) AS avg_sal, deptno
	FROM emp05 GROUP BY deptno
		HAVING avg_sal < 2000;




