#演示时间相关的类型
#创建一张表, date , datetime , timestamp
CREATE TABLE t14 (
	birthday DATE , -- 生日
	job_time DATETIME, -- 记录年月日 时分秒
	login_time TIMESTAMP
		NOT NULL DEFAULT CURRENT_TIMESTAMP
		ON UPDATE CURRENT_TIMESTAMP); -- 登录时间, 如果希望 login_time 列自动更新, 需要配置
	
SELECT * FROM t14;

#如果我们更新 t14 表的某条记录，login_time 列会自动的以当前时间进行更新
INSERT INTO t14(birthday, job_time)
	VALUES('2022-11-11','2022-11-11 10:10:10'); 

SELECT * FROM t14;