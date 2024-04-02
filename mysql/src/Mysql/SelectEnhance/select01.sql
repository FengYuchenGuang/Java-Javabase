-- 查询加强
-- ■ 使用 where 子句
-- ?如何查找 1992.1.1 后入职的员工
-- 老师说明： 在 mysql 中,日期类型可以直接比较, 需要注意格式
SELECT * FROM emp05
	WHERE hiredate > '1992-01-01'

-- ■ 如何使用 like 操作符(模糊)
-- %: 表示 0 到多个任意字符 _: 表示单个任意字符
-- ?如何显示首字符为 S 的员工姓名和工资
SELECT ename, sal FROM emp05
	WHERE ename LIKE 'S%' ;
	
-- ?如何显示第三个字符为大写 O 的所有员工的姓名和工资
SELECT ename, sal FROM emp05
	WHERE ename LIKE '__O%' ;

-- ■ 如何显示没有上级的雇员的情况
SELECT * FROM emp05
	WHERE mgr IS NULL; 

-- ■ 查询表结构
DESC emp05

-- 使用 order by 子句
-- ?如何按照工资的从低到高的顺序[升序]，显示雇员的信息
SELECT * FROM emp05
	ORDER BY sal;
	
SELECT * FROM emp05
	ORDER BY sal DESC;
	
-- ?按照部门号升序而雇员的工资降序排列 , 显示雇员信息
SELECT * FROM emp05
	ORDER BY deptno ASC , sal;
	

