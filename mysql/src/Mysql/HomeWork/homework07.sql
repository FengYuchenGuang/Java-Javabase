
-- 1、创建部门表
CREATE TABLE h05_department (
	departmentID INT PRIMARY KEY,
	deptname VARCHAR(32)
	);
	
INSERT INTO h05_department 
	VALUES(001,'数学');
	
INSERT INTO h05_department 
	VALUES(002,'计算机'),(003,'化学'),(004,'中文'),(005,'经济');
	
-- 2、创建班级
CREATE TABLE h05_class (
	classID INT PRIMARY KEY,
	`subject` VARCHAR(32),
	deptname VARCHAR(32),
	enrolltime YEAR NOT NULL,
	num INT NOT NULL
	#foreign key(deptname) references h05_department(deptname)
	);
	
INSERT INTO h05_class 
	VALUES(101,'软件','计算机',1995,20);
	
INSERT INTO h05_class 
	VALUES(102,'微电子','计算机',1996,30),
	(111,'无机化学','化学',1995,29),
	(112,'高分子化学','化学',1996,25),
	(121,'统计数学','数学',1995,20),
	(131,'现代语言','中文',1996,20),
	(141,'国际贸易','经济',1997,30),
	(142,'国际金融','经济',1996,14);

-- 3、创建学生表 
CREATE TABLE h05_student (
	studentID INT PRIMARY KEY,
	`name` VARCHAR(32),
	age INT,
	classID INT
	#foreign key(classID) references h05_class(classID)
	);
	
INSERT INTO h05_student 
	VALUES(8101,'张三',18,101);
	
INSERT INTO h05_student 
	VALUES(8102,'钱四',16,121),
	(8103,'王玲',17,131),
	(8105,'李飞',19,102),
	(8109,'赵四',18,141),
	(8110,'李可',20,142),
	(8201,'张飞',18,111),
	(8302,'周瑜',16,112),
	(8203,'王亮',17,111),
	(8305,'董卿',19,102),
	(8409,'赵龙',18,101),
	(8510,'李丽',20,142);


DESC h05_student;
	
SELECT * FROM h05_department;
SELECT * FROM h05_class;
SELECT * FROM h05_student;
