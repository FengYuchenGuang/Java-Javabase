-- 合并查询

SELECT ename,sal,job 
	FROM emp05 
	WHERE sal>2500; -- 5

SELECT ename,sal,job 
	FROM emp05 
	WHERE job='MANAGER'; -- 3

-- union all 就是将两个查询结果合并，不会去重
SELECT ename,sal,job 
	FROM emp05 WHERE sal>2500 -- 5
	UNION ALL
	SELECT ename,sal,job 
		FROM emp05 
		WHERE job='MANAGER'; -- 3
		
-- union 就是将两个查询结果合并，会去重
SELECT ename,sal,job 
	FROM emp05 
	WHERE sal>2500 -- 5
	UNION
	SELECT ename,sal,job 
		FROM emp05 
		WHERE job='MANAGER'; -- 3