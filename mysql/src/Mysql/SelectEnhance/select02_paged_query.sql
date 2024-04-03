-- 分页查询

-- 按雇员的 id 号升序取出， 每页显示 3 条记录，请分别显示 第 1 页，第 2 页，第 3 页
-- 第 1 页
SELECT * FROM emp05
	ORDER BY empno
	LIMIT 0, 3; 

-- 第 2 页
SELECT * FROM emp05
	ORDER BY empno
	LIMIT 3, 3; 

-- 第 3 页
SELECT * FROM emp05
	ORDER BY empno
	LIMIT 6, 3;

-- 推导一个公式
SELECT * FROM emp05
	ORDER BY empno
	LIMIT 每页显示记录数 * (第几页-1) , 每页显示记录数;

-- 测试
SELECT job, COUNT(*) FROM emp05 GROUP BY job; 

-- 显示雇员总数，以及获得补助的雇员数
SELECT COUNT(*) FROM emp05 WHERE mgr IS NOT NULL;

SELECT MAX(sal) - MIN(sal) FROM emp05;


