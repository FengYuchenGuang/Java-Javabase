-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: hsp_db03
-- ------------------------------------------------------
-- Server version	5.7.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `hsp_db03`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `hsp_db03` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `hsp_db03`;

--
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dept` (
  `deptno` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `dname` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `loc` varchar(13) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept`
--

LOCK TABLES `dept` WRITE;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
INSERT INTO `dept` VALUES (10,'ACCOUNTING','NEW YORK'),(20,'RESEARCH','DALLAS'),(30,'SALES','CHICAGO'),(40,'OPERATIONS','BOSTON');
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `sex` char(1) COLLATE utf8_bin DEFAULT NULL,
  `brithday` date DEFAULT NULL,
  `entry_date` datetime DEFAULT NULL,
  `job` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `resume` text COLLATE utf8_bin,
  `image` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (100,'小妖怪','男','2000-11-11','2010-11-10 11:11:11','巡山的',3000,'大王叫我来巡山',''),(101,'hxz','男','2001-04-26','2024-11-11 11:11:11','学习java',9000,'sjsjsjsjs','');
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp05`
--

DROP TABLE IF EXISTS `emp05`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp05` (
  `empno` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `ename` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `job` varchar(9) COLLATE utf8_bin NOT NULL DEFAULT '',
  `mgr` mediumint(8) unsigned DEFAULT NULL,
  `hiredate` date NOT NULL,
  `sal` decimal(7,2) NOT NULL,
  `comm` decimal(7,2) DEFAULT NULL,
  `deptno` mediumint(8) unsigned NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp05`
--

LOCK TABLES `emp05` WRITE;
/*!40000 ALTER TABLE `emp05` DISABLE KEYS */;
INSERT INTO `emp05` VALUES (7369,'SMITH','CLERK',7902,'1990-12-17',800.00,NULL,20),(7499,'ALLEN','SALESMAN',7698,'1991-02-20',1600.00,300.00,30),(7521,'WARD','SALESMAN',7698,'1991-02-22',1250.00,500.00,30),(7566,'JONES','MANAGER',7839,'1991-04-02',2975.00,NULL,20),(7654,'MARTIN','SALESMAN',7698,'1991-09-28',1250.00,1400.00,30),(7698,'BLAKE','MANAGER',7839,'1991-05-01',2850.00,NULL,30),(7782,'CLARK','MANAGER',7839,'1991-06-09',2450.00,NULL,10),(7788,'SCOTT','ANALYST',7566,'1997-04-19',3000.00,NULL,20),(7839,'KING','PRESIDENT',NULL,'1991-11-17',5000.00,NULL,10),(7844,'TURNER','SALESMAN',7698,'1991-09-08',1500.00,NULL,30),(7900,'JAMES','CLERK',7698,'1991-12-03',950.00,NULL,30),(7902,'FORD','ANALYST',7566,'1991-12-03',3000.00,NULL,20),(7934,'MILLER','CLERK',7782,'1992-01-23',1300.00,NULL,10);
/*!40000 ALTER TABLE `emp05` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp2`
--

DROP TABLE IF EXISTS `emp2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emp2` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `sex` char(1) COLLATE utf8_bin DEFAULT NULL,
  `brithday` date DEFAULT NULL,
  `entry_date` datetime DEFAULT NULL,
  `job` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `resume` text COLLATE utf8_bin
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp2`
--

LOCK TABLES `emp2` WRITE;
/*!40000 ALTER TABLE `emp2` DISABLE KEYS */;
/*!40000 ALTER TABLE `emp2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `emp_view01`
--

DROP TABLE IF EXISTS `emp_view01`;
/*!50001 DROP VIEW IF EXISTS `emp_view01`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `emp_view01` AS SELECT 
 1 AS `empno`,
 1 AS `ename`,
 1 AS `job`,
 1 AS `deptno`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `emp_view02`
--

DROP TABLE IF EXISTS `emp_view02`;
/*!50001 DROP VIEW IF EXISTS `emp_view02`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `emp_view02` AS SELECT 
 1 AS `empno`,
 1 AS `ename`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `emp_view03`
--

DROP TABLE IF EXISTS `emp_view03`;
/*!50001 DROP VIEW IF EXISTS `emp_view03`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `emp_view03` AS SELECT 
 1 AS `empno`,
 1 AS `ename`,
 1 AS `dname`,
 1 AS `grade`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `brithday` date DEFAULT NULL,
  `entry_date` datetime DEFAULT NULL,
  `job` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `resume` text COLLATE utf8_bin,
  `image` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (100,'小妖怪','2000-11-11','2010-11-10 11:11:11','巡山的',3000,'大王叫我来巡山',''),(101,'hxz','2001-04-26','2024-11-11 11:11:11','学习java',9000,'sjsjsjsjs',''),(200,'老妖怪','1990-11-11','2000-11-11 10:10:10','捶背的',5000,'给大王捶背','d:\\a.jpg');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam` (
  `id` int(11) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES (1,56),(2,76),(11,8);
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `id` int(11) DEFAULT NULL,
  `goods_name` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `price` double NOT NULL DEFAULT '100'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (10,'华为手机',2000),(11,'苹果手机',7000),(12,'手机',100),(30,'小米手机',2000),(50,'三星手机',2300),(60,'海尔手机',1800),(70,'IBM 手机',5000),(80,'格力手机',100);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `h05_class`
--

DROP TABLE IF EXISTS `h05_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `h05_class` (
  `classID` int(11) NOT NULL,
  `subject` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `deptname` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `enrolltime` year(4) NOT NULL,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`classID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `h05_class`
--

LOCK TABLES `h05_class` WRITE;
/*!40000 ALTER TABLE `h05_class` DISABLE KEYS */;
INSERT INTO `h05_class` VALUES (101,'软件','计算机',1995,20),(102,'微电子','计算机',1996,30),(111,'无机化学','化学',1995,29),(112,'高分子化学','化学',1996,25),(121,'统计数学','数学',1995,20),(131,'现代语言','中文',1996,20),(141,'国际贸易','经济',1997,30),(142,'国际金融','经济',1996,14);
/*!40000 ALTER TABLE `h05_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `h05_department`
--

DROP TABLE IF EXISTS `h05_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `h05_department` (
  `departmentID` int(11) NOT NULL,
  `deptname` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`departmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `h05_department`
--

LOCK TABLES `h05_department` WRITE;
/*!40000 ALTER TABLE `h05_department` DISABLE KEYS */;
INSERT INTO `h05_department` VALUES (1,'数学'),(2,'计算机'),(3,'化学'),(4,'中文'),(5,'经济');
/*!40000 ALTER TABLE `h05_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `h05_student`
--

DROP TABLE IF EXISTS `h05_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `h05_student` (
  `studentID` int(11) NOT NULL,
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `classID` int(11) DEFAULT NULL,
  PRIMARY KEY (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `h05_student`
--

LOCK TABLES `h05_student` WRITE;
/*!40000 ALTER TABLE `h05_student` DISABLE KEYS */;
/*!40000 ALTER TABLE `h05_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hsp_user`
--

DROP TABLE IF EXISTS `hsp_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hsp_user` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `pwd` char(32) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hsp_user`
--

LOCK TABLES `hsp_user` WRITE;
/*!40000 ALTER TABLE `hsp_user` DISABLE KEYS */;
INSERT INTO `hsp_user` VALUES (100,'韩顺平','c435a9810009800cafef7dce3b7844a6'),(200,'黄叙臻','9f653e2b24ed7563f519c394636c33c6');
/*!40000 ALTER TABLE `hsp_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mes`
--

DROP TABLE IF EXISTS `mes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mes` (
  `id` int(11) DEFAULT NULL,
  `content` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `send_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mes`
--

LOCK TABLES `mes` WRITE;
/*!40000 ALTER TABLE `mes` DISABLE KEYS */;
INSERT INTO `mes` VALUES (1,'北京新闻','2024-04-02 20:27:20'),(2,'上海新闻','2024-04-02 20:27:20'),(3,'广州新闻','2024-04-02 20:27:20');
/*!40000 ALTER TABLE `mes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_class`
--

DROP TABLE IF EXISTS `my_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `my_class` (
  `id` int(11) NOT NULL,
  `name` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_class`
--

LOCK TABLES `my_class` WRITE;
/*!40000 ALTER TABLE `my_class` DISABLE KEYS */;
INSERT INTO `my_class` VALUES (100,'java'),(200,'web'),(300,'php');
/*!40000 ALTER TABLE `my_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_stu`
--

DROP TABLE IF EXISTS `my_stu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `my_stu` (
  `id` int(11) NOT NULL,
  `name` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `my_stu_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `my_class` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_stu`
--

LOCK TABLES `my_stu` WRITE;
/*!40000 ALTER TABLE `my_stu` DISABLE KEYS */;
INSERT INTO `my_stu` VALUES (1,'tom',100),(2,'jack',200),(3,'hsp',300),(5,'king',NULL);
/*!40000 ALTER TABLE `my_stu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_tab01`
--

DROP TABLE IF EXISTS `my_tab01`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `my_tab01` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `sal` double DEFAULT NULL,
  `job` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_tab01`
--

LOCK TABLES `my_tab01` WRITE;
/*!40000 ALTER TABLE `my_tab01` DISABLE KEYS */;
INSERT INTO `my_tab01` VALUES (7369,'SMITH',800,'CLERK',20),(7499,'ALLEN',1600,'SALESMAN',30),(7521,'WARD',1250,'SALESMAN',30),(7566,'JONES',2975,'MANAGER',20),(7654,'MARTIN',1250,'SALESMAN',30),(7698,'BLAKE',2850,'MANAGER',30),(7782,'CLARK',2450,'MANAGER',10),(7788,'SCOTT',3000,'ANALYST',20),(7839,'KING',5000,'PRESIDENT',10),(7844,'TURNER',1500,'SALESMAN',30),(7900,'JAMES',950,'CLERK',30),(7902,'FORD',3000,'ANALYST',20),(7934,'MILLER',1300,'CLERK',10),(7369,'SMITH',800,'CLERK',20),(7499,'ALLEN',1600,'SALESMAN',30),(7521,'WARD',1250,'SALESMAN',30),(7566,'JONES',2975,'MANAGER',20),(7654,'MARTIN',1250,'SALESMAN',30),(7698,'BLAKE',2850,'MANAGER',30),(7782,'CLARK',2450,'MANAGER',10),(7788,'SCOTT',3000,'ANALYST',20),(7839,'KING',5000,'PRESIDENT',10),(7844,'TURNER',1500,'SALESMAN',30),(7900,'JAMES',950,'CLERK',30),(7902,'FORD',3000,'ANALYST',20),(7934,'MILLER',1300,'CLERK',10),(7369,'SMITH',800,'CLERK',20),(7499,'ALLEN',1600,'SALESMAN',30),(7521,'WARD',1250,'SALESMAN',30),(7566,'JONES',2975,'MANAGER',20),(7654,'MARTIN',1250,'SALESMAN',30),(7698,'BLAKE',2850,'MANAGER',30),(7782,'CLARK',2450,'MANAGER',10),(7788,'SCOTT',3000,'ANALYST',20),(7839,'KING',5000,'PRESIDENT',10),(7844,'TURNER',1500,'SALESMAN',30),(7900,'JAMES',950,'CLERK',30),(7902,'FORD',3000,'ANALYST',20),(7934,'MILLER',1300,'CLERK',10),(7369,'SMITH',800,'CLERK',20),(7499,'ALLEN',1600,'SALESMAN',30),(7521,'WARD',1250,'SALESMAN',30),(7566,'JONES',2975,'MANAGER',20),(7654,'MARTIN',1250,'SALESMAN',30),(7698,'BLAKE',2850,'MANAGER',30),(7782,'CLARK',2450,'MANAGER',10),(7788,'SCOTT',3000,'ANALYST',20),(7839,'KING',5000,'PRESIDENT',10),(7844,'TURNER',1500,'SALESMAN',30),(7900,'JAMES',950,'CLERK',30),(7902,'FORD',3000,'ANALYST',20),(7934,'MILLER',1300,'CLERK',10),(7369,'SMITH',800,'CLERK',20),(7499,'ALLEN',1600,'SALESMAN',30),(7521,'WARD',1250,'SALESMAN',30),(7566,'JONES',2975,'MANAGER',20),(7654,'MARTIN',1250,'SALESMAN',30),(7698,'BLAKE',2850,'MANAGER',30),(7782,'CLARK',2450,'MANAGER',10),(7788,'SCOTT',3000,'ANALYST',20),(7839,'KING',5000,'PRESIDENT',10),(7844,'TURNER',1500,'SALESMAN',30),(7900,'JAMES',950,'CLERK',30),(7902,'FORD',3000,'ANALYST',20),(7934,'MILLER',1300,'CLERK',10),(7369,'SMITH',800,'CLERK',20),(7499,'ALLEN',1600,'SALESMAN',30),(7521,'WARD',1250,'SALESMAN',30),(7566,'JONES',2975,'MANAGER',20),(7654,'MARTIN',1250,'SALESMAN',30),(7698,'BLAKE',2850,'MANAGER',30),(7782,'CLARK',2450,'MANAGER',10),(7788,'SCOTT',3000,'ANALYST',20),(7839,'KING',5000,'PRESIDENT',10),(7844,'TURNER',1500,'SALESMAN',30),(7900,'JAMES',950,'CLERK',30),(7902,'FORD',3000,'ANALYST',20),(7934,'MILLER',1300,'CLERK',10),(7369,'SMITH',800,'CLERK',20),(7499,'ALLEN',1600,'SALESMAN',30),(7521,'WARD',1250,'SALESMAN',30),(7566,'JONES',2975,'MANAGER',20),(7654,'MARTIN',1250,'SALESMAN',30),(7698,'BLAKE',2850,'MANAGER',30),(7782,'CLARK',2450,'MANAGER',10),(7788,'SCOTT',3000,'ANALYST',20),(7839,'KING',5000,'PRESIDENT',10),(7844,'TURNER',1500,'SALESMAN',30),(7900,'JAMES',950,'CLERK',30),(7902,'FORD',3000,'ANALYST',20),(7934,'MILLER',1300,'CLERK',10),(7369,'SMITH',800,'CLERK',20),(7499,'ALLEN',1600,'SALESMAN',30),(7521,'WARD',1250,'SALESMAN',30),(7566,'JONES',2975,'MANAGER',20),(7654,'MARTIN',1250,'SALESMAN',30),(7698,'BLAKE',2850,'MANAGER',30),(7782,'CLARK',2450,'MANAGER',10),(7788,'SCOTT',3000,'ANALYST',20),(7839,'KING',5000,'PRESIDENT',10),(7844,'TURNER',1500,'SALESMAN',30),(7900,'JAMES',950,'CLERK',30),(7902,'FORD',3000,'ANALYST',20),(7934,'MILLER',1300,'CLERK',10);
/*!40000 ALTER TABLE `my_tab01` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `my_tab02`
--

DROP TABLE IF EXISTS `my_tab02`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `my_tab02` (
  `empno` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `ename` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `job` varchar(9) COLLATE utf8_bin NOT NULL DEFAULT '',
  `mgr` mediumint(8) unsigned DEFAULT NULL,
  `hiredate` date NOT NULL,
  `sal` decimal(7,2) NOT NULL,
  `comm` decimal(7,2) DEFAULT NULL,
  `deptno` mediumint(8) unsigned NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_tab02`
--

LOCK TABLES `my_tab02` WRITE;
/*!40000 ALTER TABLE `my_tab02` DISABLE KEYS */;
INSERT INTO `my_tab02` VALUES (7369,'SMITH','CLERK',7902,'1990-12-17',800.00,NULL,20),(7499,'ALLEN','SALESMAN',7698,'1991-02-20',1600.00,300.00,30),(7521,'WARD','SALESMAN',7698,'1991-02-22',1250.00,500.00,30),(7566,'JONES','MANAGER',7839,'1991-04-02',2975.00,NULL,20),(7654,'MARTIN','SALESMAN',7698,'1991-09-28',1250.00,1400.00,30),(7698,'BLAKE','MANAGER',7839,'1991-05-01',2850.00,NULL,30),(7782,'CLARK','MANAGER',7839,'1991-06-09',2450.00,NULL,10),(7788,'SCOTT','ANALYST',7566,'1997-04-19',3000.00,NULL,20),(7839,'KING','PRESIDENT',NULL,'1991-11-17',5000.00,NULL,10),(7844,'TURNER','SALESMAN',7698,'1991-09-08',1500.00,NULL,30),(7900,'JAMES','CLERK',7698,'1991-12-03',950.00,NULL,30),(7902,'FORD','ANALYST',7566,'1991-12-03',3000.00,NULL,20),(7934,'MILLER','CLERK',7782,'1992-01-23',1300.00,NULL,10);
/*!40000 ALTER TABLE `my_tab02` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salgrade`
--

DROP TABLE IF EXISTS `salgrade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salgrade` (
  `grade` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `losal` decimal(17,2) NOT NULL,
  `hisal` decimal(17,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salgrade`
--

LOCK TABLES `salgrade` WRITE;
/*!40000 ALTER TABLE `salgrade` DISABLE KEYS */;
INSERT INTO `salgrade` VALUES (1,700.00,1200.00),(2,1201.00,1400.00),(3,1401.00,2000.00),(4,2001.00,3000.00),(5,3001.00,9999.00);
/*!40000 ALTER TABLE `salgrade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stu`
--

DROP TABLE IF EXISTS `stu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stu` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stu`
--

LOCK TABLES `stu` WRITE;
/*!40000 ALTER TABLE `stu` DISABLE KEYS */;
INSERT INTO `stu` VALUES (1,'jack'),(2,'tom'),(3,'kity'),(4,'nono');
/*!40000 ALTER TABLE `stu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL DEFAULT '1',
  `NAME` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '',
  `chinese` float NOT NULL DEFAULT '0',
  `english` float NOT NULL DEFAULT '0',
  `math` float NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'韩顺平',89,78,90),(2,'张飞',67,98,56),(3,'宋江',87,78,77),(4,'关羽',88,98,90),(5,'赵云',82,84,67),(6,'欧阳锋',55,85,45),(7,'黄蓉',75,65,30),(8,'韩信',45,65,99),(8,'韩信',45,65,99),(8,'韩信',45,65,99);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t05`
--

DROP TABLE IF EXISTS `t05`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t05` (
  `num` bit(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t05`
--

LOCK TABLES `t05` WRITE;
/*!40000 ALTER TABLE `t05` DISABLE KEYS */;
INSERT INTO `t05` VALUES ('�'),('�'),('�'),('');
/*!40000 ALTER TABLE `t05` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t06`
--

DROP TABLE IF EXISTS `t06`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t06` (
  `num1` float DEFAULT NULL,
  `num2` double DEFAULT NULL,
  `num3` decimal(30,20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t06`
--

LOCK TABLES `t06` WRITE;
/*!40000 ALTER TABLE `t06` DISABLE KEYS */;
INSERT INTO `t06` VALUES (88.1235,88.12345678912345,88.12345678912345000000);
/*!40000 ALTER TABLE `t06` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t07`
--

DROP TABLE IF EXISTS `t07`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t07` (
  `num` decimal(65,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t07`
--

LOCK TABLES `t07` WRITE;
/*!40000 ALTER TABLE `t07` DISABLE KEYS */;
INSERT INTO `t07` VALUES (8999999933338388388383838838383009338388383838383838383);
/*!40000 ALTER TABLE `t07` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t08`
--

DROP TABLE IF EXISTS `t08`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t08` (
  `num` bigint(20) unsigned DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t08`
--

LOCK TABLES `t08` WRITE;
/*!40000 ALTER TABLE `t08` DISABLE KEYS */;
/*!40000 ALTER TABLE `t08` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t09`
--

DROP TABLE IF EXISTS `t09`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t09` (
  `name` char(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t09`
--

LOCK TABLES `t09` WRITE;
/*!40000 ALTER TABLE `t09` DISABLE KEYS */;
/*!40000 ALTER TABLE `t09` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t1`
--

DROP TABLE IF EXISTS `t1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t1` (
  `id` int(11) NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `introduce` varchar(255) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t1`
--

LOCK TABLES `t1` WRITE;
/*!40000 ALTER TABLE `t1` DISABLE KEYS */;
INSERT INTO `t1` VALUES (1,'tom','222'),(2,'ee','33'),(3,'44','566'),(4,'Tom','qwqw');
/*!40000 ALTER TABLE `t1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t10`
--

DROP TABLE IF EXISTS `t10`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t10` (
  `name` varchar(32766) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t10`
--

LOCK TABLES `t10` WRITE;
/*!40000 ALTER TABLE `t10` DISABLE KEYS */;
/*!40000 ALTER TABLE `t10` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t11`
--

DROP TABLE IF EXISTS `t11`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t11` (
  `name` char(4) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t11`
--

LOCK TABLES `t11` WRITE;
/*!40000 ALTER TABLE `t11` DISABLE KEYS */;
INSERT INTO `t11` VALUES ('韩顺平好'),('abcd'),('韩顺平好'),('abcd'),('韩顺平好');
/*!40000 ALTER TABLE `t11` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t12`
--

DROP TABLE IF EXISTS `t12`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t12` (
  `name` varchar(4) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t12`
--

LOCK TABLES `t12` WRITE;
/*!40000 ALTER TABLE `t12` DISABLE KEYS */;
INSERT INTO `t12` VALUES ('韩顺平好');
/*!40000 ALTER TABLE `t12` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t13`
--

DROP TABLE IF EXISTS `t13`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t13` (
  `content` text COLLATE utf8_bin,
  `content2` mediumtext COLLATE utf8_bin,
  `content3` longtext COLLATE utf8_bin
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t13`
--

LOCK TABLES `t13` WRITE;
/*!40000 ALTER TABLE `t13` DISABLE KEYS */;
INSERT INTO `t13` VALUES ('韩顺平教育','韩顺平教育 100','韩顺平教育 1000~~');
/*!40000 ALTER TABLE `t13` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t14`
--

DROP TABLE IF EXISTS `t14`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t14` (
  `birthday` date DEFAULT NULL,
  `job_time` datetime DEFAULT NULL,
  `login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t14`
--

LOCK TABLES `t14` WRITE;
/*!40000 ALTER TABLE `t14` DISABLE KEYS */;
INSERT INTO `t14` VALUES ('2022-11-11','2022-11-11 10:10:10','2024-04-02 02:40:40');
/*!40000 ALTER TABLE `t14` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t15`
--

DROP TABLE IF EXISTS `t15`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t15` (
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t15`
--

LOCK TABLES `t15` WRITE;
/*!40000 ALTER TABLE `t15` DISABLE KEYS */;
INSERT INTO `t15` VALUES ('tom'),('jack'),('mary'),(NULL);
/*!40000 ALTER TABLE `t15` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t17`
--

DROP TABLE IF EXISTS `t17`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t17` (
  `id` int(11) NOT NULL,
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t17`
--

LOCK TABLES `t17` WRITE;
/*!40000 ALTER TABLE `t17` DISABLE KEYS */;
INSERT INTO `t17` VALUES (1,'jack','jack@sohu.com'),(2,'tom','tom@sohu.com');
/*!40000 ALTER TABLE `t17` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t18`
--

DROP TABLE IF EXISTS `t18`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t18` (
  `id` int(11) NOT NULL,
  `name` varchar(32) COLLATE utf8_bin NOT NULL,
  `email` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t18`
--

LOCK TABLES `t18` WRITE;
/*!40000 ALTER TABLE `t18` DISABLE KEYS */;
INSERT INTO `t18` VALUES (1,'jack','jack@sohu.com'),(1,'tom','tom@sohu.com');
/*!40000 ALTER TABLE `t18` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t19`
--

DROP TABLE IF EXISTS `t19`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t19` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_bin NOT NULL,
  `email` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t19`
--

LOCK TABLES `t19` WRITE;
/*!40000 ALTER TABLE `t19` DISABLE KEYS */;
/*!40000 ALTER TABLE `t19` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t2`
--

DROP TABLE IF EXISTS `t2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t2` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t2`
--

LOCK TABLES `t2` WRITE;
/*!40000 ALTER TABLE `t2` DISABLE KEYS */;
INSERT INTO `t2` VALUES (1,'mak'),(2,'jack'),(3,'Tom'),(4,'tom'),(5,'nii');
/*!40000 ALTER TABLE `t2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t20`
--

DROP TABLE IF EXISTS `t20`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t20` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_bin NOT NULL,
  `email` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t20`
--

LOCK TABLES `t20` WRITE;
/*!40000 ALTER TABLE `t20` DISABLE KEYS */;
/*!40000 ALTER TABLE `t20` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t21`
--

DROP TABLE IF EXISTS `t21`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t21` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t21`
--

LOCK TABLES `t21` WRITE;
/*!40000 ALTER TABLE `t21` DISABLE KEYS */;
INSERT INTO `t21` VALUES (1,'jack','jack@sohu.com'),(NULL,'tom','tom@sohu.com');
/*!40000 ALTER TABLE `t21` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t22`
--

DROP TABLE IF EXISTS `t22`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t22` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t22`
--

LOCK TABLES `t22` WRITE;
/*!40000 ALTER TABLE `t22` DISABLE KEYS */;
/*!40000 ALTER TABLE `t22` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t23`
--

DROP TABLE IF EXISTS `t23`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t23` (
  `id` int(11) NOT NULL,
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(6) COLLATE utf8_bin DEFAULT NULL,
  `sal` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t23`
--

LOCK TABLES `t23` WRITE;
/*!40000 ALTER TABLE `t23` DISABLE KEYS */;
INSERT INTO `t23` VALUES (1,'jack','mid',1);
/*!40000 ALTER TABLE `t23` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t24`
--

DROP TABLE IF EXISTS `t24`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t24` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `name` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t24`
--

LOCK TABLES `t24` WRITE;
/*!40000 ALTER TABLE `t24` DISABLE KEYS */;
INSERT INTO `t24` VALUES (1,'tom@qq.com','tom'),(2,'hsp@sohu.com','hsp');
/*!40000 ALTER TABLE `t24` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t25`
--

DROP TABLE IF EXISTS `t25`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t25` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  `name` varchar(32) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=667 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t25`
--

LOCK TABLES `t25` WRITE;
/*!40000 ALTER TABLE `t25` DISABLE KEYS */;
INSERT INTO `t25` VALUES (100,'mary@qq.com','mary'),(101,'hxz@qq.com','hxz'),(666,'hsp@qq.com','hsp');
/*!40000 ALTER TABLE `t25` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t25_1`
--

DROP TABLE IF EXISTS `t25_1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t25_1` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  KEY `id_index2` (`id`),
  KEY `id_index3` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t25_1`
--

LOCK TABLES `t25_1` WRITE;
/*!40000 ALTER TABLE `t25_1` DISABLE KEYS */;
/*!40000 ALTER TABLE `t25_1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t26`
--

DROP TABLE IF EXISTS `t26`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t26` (
  `id` int(11) NOT NULL,
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t26`
--

LOCK TABLES `t26` WRITE;
/*!40000 ALTER TABLE `t26` DISABLE KEYS */;
/*!40000 ALTER TABLE `t26` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t27`
--

DROP TABLE IF EXISTS `t27`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t27` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(32) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t27`
--

LOCK TABLES `t27` WRITE;
/*!40000 ALTER TABLE `t27` DISABLE KEYS */;
INSERT INTO `t27` VALUES (300,'milan'),(100,'tom'),(200,'jack');
/*!40000 ALTER TABLE `t27` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t3`
--

DROP TABLE IF EXISTS `t3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t3` (
  `id` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t3`
--

LOCK TABLES `t3` WRITE;
/*!40000 ALTER TABLE `t3` DISABLE KEYS */;
INSERT INTO `t3` VALUES (127);
/*!40000 ALTER TABLE `t3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t4`
--

DROP TABLE IF EXISTS `t4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t4` (
  `id` tinyint(3) unsigned DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t4`
--

LOCK TABLES `t4` WRITE;
/*!40000 ALTER TABLE `t4` DISABLE KEYS */;
INSERT INTO `t4` VALUES (255),(255);
/*!40000 ALTER TABLE `t4` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `birthday` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `hsp_db03`
--

USE `hsp_db03`;

--
-- Final view structure for view `emp_view01`
--

/*!50001 DROP VIEW IF EXISTS `emp_view01`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `emp_view01` AS select `emp05`.`empno` AS `empno`,`emp05`.`ename` AS `ename`,`emp05`.`job` AS `job`,`emp05`.`deptno` AS `deptno` from `emp05` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `emp_view02`
--

/*!50001 DROP VIEW IF EXISTS `emp_view02`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `emp_view02` AS select `emp_view01`.`empno` AS `empno`,`emp_view01`.`ename` AS `ename` from `emp_view01` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `emp_view03`
--

/*!50001 DROP VIEW IF EXISTS `emp_view03`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `emp_view03` AS select `emp05`.`empno` AS `empno`,`emp05`.`ename` AS `ename`,`dept`.`dname` AS `dname`,`salgrade`.`grade` AS `grade` from ((`emp05` join `dept`) join `salgrade`) where ((`emp05`.`deptno` = `dept`.`deptno`) and (`emp05`.`sal` between `salgrade`.`losal` and `salgrade`.`hisal`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-09 21:12:36
