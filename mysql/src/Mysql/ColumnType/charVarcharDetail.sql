#演示字符串类型的使用细节
#char(4) 和 varchar(4) 这个 4 表示的是字符，而不是字节, 不区分字符是汉字还是字母

#char(4) 和 varchar(4)
# 4 表示的字符数，存储四个字符，根据编码方式不同，存储的空间不同，因此 char 与 varchar 是变长的
CREATE TABLE t11(
	`name` CHAR(4));

INSERT INTO t11 VALUES('abcd');
INSERT INTO t11 VALUES('韩顺平好');

SELECT * FROM t11;

CREATE TABLE t12(
	`name` VARCHAR(4));
INSERT INTO t12 VALUES('韩顺平好');
INSERT INTO t12 VALUES('ab 北京');

SELECT * FROM t12;

#如果 varchar 不够用，可以考试使用 mediumtext 或者 longtext, 
#如果想简单点，可以使用直接使用 text
#text 存放0~2^16 个字节 的内容
#mediumtext 存放0~2^24 个字节 的内容
#longtext 存放0~2^32 个字节 的内容
CREATE TABLE t13( content TEXT, content2 MEDIUMTEXT , content3 LONGTEXT);
INSERT INTO t13 VALUES('韩顺平教育', '韩顺平教育 100', '韩顺平教育 1000~~');

SELECT * FROM t13;