

CREATE TABLE `account` (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(32) NOT NULL DEFAULT '',
	balance DOUBLE NOT NULL DEFAULT 0)
	CHARACTER SET utf8;
	
INSERT INTO `account` VALUES(NULL, '马云',3000),(NULL, '马化腾',10000);

UPDATE `account` 
	SET balance = 3000
	WHERE id = 1;
	
UPDATE `account` 
	SET balance = 10000
	WHERE id = 2;
	
SELECT * FROM `account`;

