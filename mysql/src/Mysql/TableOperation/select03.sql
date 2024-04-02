-- select 语句
-- 查询姓名为赵云的学生成绩
SELECT * FROM student
	WHERE `name` = '赵云'; -- 查询英语成绩大于 90 分的同学

SELECT * FROM student
	WHERE english > 90;

-- 查询总分大于 200 分的所有同学
SELECT * FROM student
	WHERE (chinese + english + math) > 200;
	
-- 查询 math 大于 60 并且(and) id 大于 4 的学生成绩
SELECT * FROM student
	WHERE math >60 AND id > 4;

-- 查询英语成绩大于语文成绩的同学
SELECT * FROM student
	WHERE english > chinese;

-- 查询总分大于 200 分 并且 数学成绩小于语文成绩,的姓赵的学生. -- 赵% 表示 名字以赵开头的就可以
-- % 表示 0到多个字符
SELECT * FROM student
	WHERE (chinese + english + math) > 200 AND
		math < chinese AND `name` LIKE '赵%'; -- 查询英语分数在 80－90 之间的同学。

SELECT * FROM student
	WHERE english >= 80 AND english <= 90;

SELECT * FROM student
	WHERE english BETWEEN 80 AND 90; -- between .. and .. 是 闭区间

-- 查询数学分数为 89,90,91 的同学。
SELECT * FROM student
	WHERE math = 89 OR math = 90 OR math = 91;

SELECT * FROM student
	WHERE math IN (89, 90, 91);

-- 查询所有姓李的学生成绩。
SELECT * FROM student
	WHERE `name` LIKE '韩%';

 -- 查询数学分>80，语文分>80 的同学
 SELECT * FROM student
	WHERE math > 80 AND chinese > 80;



 