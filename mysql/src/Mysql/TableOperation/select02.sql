-- select 语句的使用
-- 统计每个学生的总分
SELECT `name`, (chinese+english+math) FROM student; 

-- 在所有学生总分加 10 分的情况
SELECT `name`, (chinese + english + math + 10) FROM student; 

-- 使用别名表示学生分数。
SELECT `name` AS '名字', (chinese + english + math + 10) AS total_score
	FROM student;

#练习
-- 给赵云总分增加 60%
SELECT `name` ,(chinese + english + math )*1.6 AS '1.6总分' ,(chinese + english + math ) AS '1总分' 
	FROM student
	WHERE `name` = '赵云';

-- 统计关羽总分
SELECT `name` ,(chinese + english + math ) AS '总分' 
	FROM student
	WHERE `name` = '关羽';
	
-- 使用别名表示学生的数学分数
SELECT `name`,math AS '数学' FROM student;

