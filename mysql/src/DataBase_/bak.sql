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
  `resume` text COLLATE utf8_bin
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (100,'小妖怪','男','2000-11-11','2010-11-10 11:11:11','巡山的',3000,'大王叫我来巡山'),(101,'hxz','男','2001-04-26','2024-11-11 11:11:11','学习java',9000,'sjsjsjsjs');
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-03 13:49:46
