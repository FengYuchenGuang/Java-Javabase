

CREATE TABLE `account` (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(32) NOT NULL DEFAULT '',
	balance DOUBLE NOT NULL DEFAULT 0)
	CHARACTER SET utf8;
	
INSERT INTO `account` VALUES(NULL, '马云',3000),(NULL, '马化腾',10000);

	
SELECT * FROM `account`;

