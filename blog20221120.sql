-- MariaDB dump 10.19  Distrib 10.5.17-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: blog
-- ------------------------------------------------------
-- Server version	10.5.17-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `blog_article`
--

DROP TABLE IF EXISTS `blog_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_article` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `description` varchar(255) DEFAULT NULL COMMENT '文章简介',
  `text` text DEFAULT NULL COMMENT '文章内容',
  `url` varchar(255) DEFAULT NULL COMMENT '图片URL',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='文章表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_article`
--

LOCK TABLES `blog_article` WRITE;
/*!40000 ALTER TABLE `blog_article` DISABLE KEYS */;
INSERT INTO `blog_article` VALUES (1,'小学生作文1','考试作文','11月19am:完成发送文章及页面布局个人信息的显示，修改','a6a0f9dd-585b-4461-b27f-61a37030c428.jpeg',NULL,NULL),(2,'小学生作文2','考试作文','11月19am:完成发送文章及页面布局个人信息的显示，修改','a6a0f9dd-585b-4461-b27f-61a37030c428.jpeg',NULL,NULL),(3,'小学生作文3','考试作文','11月19am:完成发送文章及页面布局个人信息的显示，修改','a6a0f9dd-585b-4461-b27f-61a37030c428.jpeg',NULL,NULL),(4,'小学生作文4','考试作文','11月19am:完成发送文章及页面布局个人信息的显示，修改','a6a0f9dd-585b-4461-b27f-61a37030c428.jpeg',NULL,NULL),(5,'小学生作文5','考试作文','11月19am:完成发送文章及页面布局个人信息的显示，修改','a6a0f9dd-585b-4461-b27f-61a37030c428.jpeg',NULL,NULL),(6,'Java开发','我是一名初级程序员!','我要成为高级程序员!!!!','/cdd07fbd-2910-4272-a5b4-662dee2471e6.jpeg','2022-11-20 19:43:53',NULL),(7,'快乐周末','哒哒哒哒哒哒哒哒哒','好得很!','/9e9bbb43-954a-419a-b813-250161aa2278.jpeg','2022-11-20 19:51:37',NULL);
/*!40000 ALTER TABLE `blog_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_article_category`
--

DROP TABLE IF EXISTS `blog_article_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_article_category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据id',
  `article_id` bigint(20) unsigned DEFAULT NULL COMMENT '文章id',
  `category_id` bigint(20) unsigned DEFAULT NULL COMMENT '类别id',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='文章类别关联';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_article_category`
--

LOCK TABLES `blog_article_category` WRITE;
/*!40000 ALTER TABLE `blog_article_category` DISABLE KEYS */;
INSERT INTO `blog_article_category` VALUES (1,1,1,NULL,NULL),(2,2,2,NULL,NULL),(3,3,3,NULL,NULL),(4,4,4,NULL,NULL),(5,5,5,NULL,NULL),(6,6,4,NULL,NULL),(7,7,6,NULL,NULL);
/*!40000 ALTER TABLE `blog_article_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_category`
--

DROP TABLE IF EXISTS `blog_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据id',
  `name` varchar(50) NOT NULL COMMENT '类别名称',
  `sort` tinyint(3) unsigned DEFAULT 0 COMMENT '排序序号',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='类别表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_category`
--

LOCK TABLES `blog_category` WRITE;
/*!40000 ALTER TABLE `blog_category` DISABLE KEYS */;
INSERT INTO `blog_category` VALUES (1,'休闲',1,NULL,NULL),(2,'美食',2,NULL,NULL),(3,'技术',3,NULL,NULL),(4,'程序',4,NULL,NULL),(5,'健康',5,NULL,NULL),(6,'生活',6,NULL,NULL);
/*!40000 ALTER TABLE `blog_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_comment`
--

DROP TABLE IF EXISTS `blog_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_comment` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据id',
  `content` varchar(50) DEFAULT NULL COMMENT '文章id',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_comment`
--

LOCK TABLES `blog_comment` WRITE;
/*!40000 ALTER TABLE `blog_comment` DISABLE KEYS */;
INSERT INTO `blog_comment` VALUES (1,'好棒!','2022-11-20 19:42:27',NULL),(2,'这孩子写的什么作文?','2022-11-20 19:47:53',NULL),(3,'这是你写的!','2022-11-20 19:50:03',NULL),(4,'快乐!','2022-11-20 20:10:12',NULL);
/*!40000 ALTER TABLE `blog_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_user`
--

DROP TABLE IF EXISTS `blog_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `password` char(64) DEFAULT NULL COMMENT '密码',
  `gender` varchar(10) DEFAULT NULL COMMENT '性别',
  `age` int(10) unsigned DEFAULT NULL COMMENT '年龄',
  `birthday` varchar(50) DEFAULT NULL COMMENT '生日',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像URL',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `sign` varchar(255) DEFAULT NULL COMMENT '个性签名',
  `article_count` int(10) unsigned DEFAULT 0 COMMENT '文章数量',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_user`
--

LOCK TABLES `blog_user` WRITE;
/*!40000 ALTER TABLE `blog_user` DISABLE KEYS */;
INSERT INTO `blog_user` VALUES (1,'admin','罡仔','123456','男',15,'2022-11-01 00:00:00','https://img2.baidu.com/it/u=4244269751,4000533845&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500','110','2168149199@qq.com','浙江宁波','这个人很懒,什么也没留下...',3,'2022-11-20 19:37:29','2022-11-20 19:37:29'),(2,'super_admin','武清源','123456','男',22,'2022-11-16 00:00:00','https://img2.baidu.com/it/u=2704182461,2749837878&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500','1122211','1243243gfdhfeh','北京','这个人很懒,什么也没留下...',1,'2022-11-20 19:48:37','2022-11-20 19:48:37');
/*!40000 ALTER TABLE `blog_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_user_article`
--

DROP TABLE IF EXISTS `blog_user_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_user_article` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据id',
  `user_id` bigint(20) unsigned DEFAULT NULL COMMENT '用户id',
  `article_id` bigint(20) unsigned DEFAULT NULL COMMENT '文章id',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='用户文章关联';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_user_article`
--

LOCK TABLES `blog_user_article` WRITE;
/*!40000 ALTER TABLE `blog_user_article` DISABLE KEYS */;
INSERT INTO `blog_user_article` VALUES (1,1,1,NULL,NULL),(2,1,2,NULL,NULL),(3,1,3,NULL,NULL),(4,1,4,NULL,NULL),(5,1,5,NULL,NULL),(6,1,6,NULL,NULL),(7,1,6,NULL,NULL),(8,2,7,NULL,NULL);
/*!40000 ALTER TABLE `blog_user_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_user_article_comment`
--

DROP TABLE IF EXISTS `blog_user_article_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_user_article_comment` (
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `article_id` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `comment_id` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `gmt_create` datetime DEFAULT NULL COMMENT '数据创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '数据最后修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户文章评论关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_user_article_comment`
--

LOCK TABLES `blog_user_article_comment` WRITE;
/*!40000 ALTER TABLE `blog_user_article_comment` DISABLE KEYS */;
INSERT INTO `blog_user_article_comment` VALUES (1,1,1,'2022-11-20 19:42:27',NULL),(1,1,2,'2022-11-20 19:47:53',NULL),(2,1,3,'2022-11-20 19:50:03',NULL),(2,7,4,'2022-11-20 20:10:12',NULL);
/*!40000 ALTER TABLE `blog_user_article_comment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-20 20:16:30
