/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.25-log : Database - film_review_web
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`film_review_web` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `film_review_web`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `cid` smallint(6) NOT NULL,
  `cname` varchar(20) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`cid`,`cname`) values (1,'热门'),(2,'最新'),(3,'高分'),(4,'冷门佳片'),(5,'华语'),(6,'欧美'),(7,'韩国');

/*Table structure for table `display_films` */

DROP TABLE IF EXISTS `display_films`;

CREATE TABLE `display_films` (
  `film_id` smallint(5) unsigned NOT NULL,
  `film_name` varchar(20) DEFAULT NULL,
  `img_src` varchar(100) DEFAULT NULL,
  `cid` smallint(6) DEFAULT NULL,
  `rating` float unsigned DEFAULT NULL COMMENT '评分',
  KEY `cid` (`cid`),
  CONSTRAINT `display_films_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `display_films` */

insert  into `display_films`(`film_id`,`film_name`,`img_src`,`cid`,`rating`) values (4,'肖申克的救赎','https://i.loli.net/2020/06/05/iZnJjWl1rTosxCz.jpg',1,9.6),(3,'明日边缘','https://i.loli.net/2020/05/26/m5y3GNxEHOBrzq4.jpg',1,9.6),(12,'海绵宝宝','https://i.loli.net/2020/06/05/lkROGh9rPitma2g.jpg',1,6.5),(14,'让子弹飞','https://i.loli.net/2020/06/06/Eh2bxLIqpremZV7.jpg',1,8.6),(15,'蝴蝶效应','https://i.loli.net/2020/06/06/cSlWbVaXKEY1NxT.jpg',1,8.6),(16,'记忆碎片','https://i.loli.net/2020/06/06/HrWkX91tdPmT3sz.jpg',1,9.1),(17,'无双','https://i.loli.net/2020/06/06/T5dKFaYOmh7cHMB.jpg',1,8.9),(18,'我不是药神','https://i.loli.net/2020/06/06/BNGHYpQRwO9LF1g.jpg',1,9.2),(19,'唐人街探案2','https://i.loli.net/2020/06/06/vNsireQmzTn1X9O.jpg',1,7.8),(13,'功夫','https://i.loli.net/2020/06/06/hHkbBsKSztPRIxC.jpg',1,7.5);

/*Table structure for table `feedback` */

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
  `feedback_id` smallint(6) NOT NULL AUTO_INCREMENT,
  `user_id` mediumint(9) DEFAULT NULL,
  `user_name` varchar(9) DEFAULT NULL,
  `read` smallint(6) DEFAULT '0' COMMENT '0代表未读，1代表已读',
  `creat_date` datetime DEFAULT NULL,
  `text` varchar(140) NOT NULL,
  PRIMARY KEY (`feedback_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `feedback` */

insert  into `feedback`(`feedback_id`,`user_id`,`user_name`,`read`,`creat_date`,`text`) values (1,2020001,'123456',0,'2020-06-06 22:21:00','这个网站做得是真的棒(๑•̀ㅂ•́)و✧');

/*Table structure for table `film` */

DROP TABLE IF EXISTS `film`;

CREATE TABLE `film` (
  `film_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `film_name` varchar(20) NOT NULL,
  `rating` float unsigned DEFAULT NULL COMMENT '评分',
  `director` varchar(50) DEFAULT NULL COMMENT '导演',
  `writer` varchar(50) DEFAULT NULL COMMENT '编剧',
  `performer` varchar(50) DEFAULT NULL,
  `genre` varchar(20) DEFAULT NULL COMMENT '题材',
  `area` varchar(20) DEFAULT NULL COMMENT '制片国家或地区',
  `language` varchar(10) DEFAULT NULL,
  `duration` varchar(10) DEFAULT NULL COMMENT '片长',
  `synopsis` varchar(300) DEFAULT NULL COMMENT '概要',
  `release_date` varchar(10) DEFAULT NULL,
  `image_source` varchar(100) DEFAULT NULL COMMENT '海报图片地址',
  PRIMARY KEY (`film_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `film` */

insert  into `film`(`film_id`,`film_name`,`rating`,`director`,`writer`,`performer`,`genre`,`area`,`language`,`duration`,`synopsis`,`release_date`,`image_source`) values (3,'明日边缘',9.6,'道格·里曼','丹特·哈珀','汤姆·克鲁斯，艾米莉·布朗特','科幻，动作','美国','英文','113min','该片以神秘外星生物袭击地球为背景，少校比尔·凯奇首次出战就“折戟沙场”惨烈牺牲，但他却由于某种不明原因重获新生，在一次一次的生死循环中，比尔越来越明了制敌方法，最终走向胜利','2014','https://i.loli.net/2020/05/26/m5y3GNxEHOBrzq4.jpg'),(4,'肖申克的救赎',9.6,'弗兰克·达拉邦特','弗兰克·达拉邦特，斯蒂芬·金','摩根·弗里曼，蒂姆·罗宾斯','剧情、犯罪','美国','英文','142min','该片改编自斯蒂芬·金《四季奇谭》中收录的同名小说，该片中涵盖全片的主题是“希望”，全片透过监狱这一强制剥夺自由、高度强调纪律的特殊背景来展现作为个体的人对“时间流逝、环境改造”的恐惧。影片的结局有《基督山伯爵》式的复仇宣泄。','1994','https://i.loli.net/2020/06/05/iZnJjWl1rTosxCz.jpg'),(12,'海绵宝宝',6.5,' 保罗·提比特',' 史蒂芬·海伦伯格、乔纳森·阿贝尔、格伦·伯杰',' 安东尼奥·班德拉斯，艾瑞克·鲍扎',' 喜剧，动画，冒险',' 美国','英语',' 92min','该片讲述了海绵宝宝带领他的几位伙伴冲出海底，化身超级英雄来打败海盗，夺回蟹黄堡秘方的故事 [2]',' 2015','https://i.loli.net/2020/06/05/lkROGh9rPitma2g.jpg'),(13,'功夫',7.5,'周星驰','周星驰','周星驰，黄圣依','喜剧','香港','粤语','95min','影片讲述了一个街头混混变成一代武术家，一个本性善良的黑帮流氓改邪归正的故事','2004','https://i.loli.net/2020/06/06/hHkbBsKSztPRIxC.jpg'),(14,'让子弹飞',8.6,'姜文','朱苏进、述平、姜文、郭俊立、危笑、李不空、马识途','姜文、周润发、葛优、刘嘉玲、陈坤、周韵、廖凡、姜武','喜剧','香港，大陆','中文','132min','该片讲述了悍匪张牧之摇身一变化名清官“马邦德”上任鹅城县长，并与镇守鹅城的恶霸黄四郎展开一场激烈争斗的故事','2010','https://i.loli.net/2020/06/06/Eh2bxLIqpremZV7.jpg'),(15,'蝴蝶效应',8.6,'埃里克·布雷斯，J·麦凯伊·格鲁伯','埃里克·布雷斯，J·麦凯伊·格鲁伯','艾什顿·库彻，艾米·斯马特','科幻，惊悚，剧情','美国','英文','113min','电影讲述伊万（艾什顿·库奇 饰）在小时候经历了一系列糟糕的事情，损坏了他原本完美的人生。在童年可怕记忆的折磨下，伊万请求心理医生的帮助，医生鼓励他把发生的事情一件件详细记下来，但是事情变得越来越糟糕。','2004','https://i.loli.net/2020/06/06/cSlWbVaXKEY1NxT.jpg'),(16,'记忆碎片',9.1,'Christopher Nolan','Christopher&Jonathan Nolan兄弟','Guy Pearce','惊悚','法国','法语','113min','影片讲述了患有“短期记忆丧失症”的莱昂纳多·谢尔比必须根据自己支离破碎的记忆来找到杀害自己妻子的凶手的故事。','2000','https://i.loli.net/2020/06/06/HrWkX91tdPmT3sz.jpg'),(17,'无双',8.9,'庄文强','庄文强','周润发，郭富城','剧情，悬疑，犯罪','香港','粤语','130min','影片讲述了犯罪天才“画家”与造假天才李问双剑合璧，联手造出超级伪钞的故事 [2]  。','2018','https://i.loli.net/2020/06/06/T5dKFaYOmh7cHMB.jpg'),(18,'我不是药神',9.2,'文牧野','韩家女、钟伟、文牧野','徐峥 ，周一围 ，王传君 ，谭卓 ，章宇 ，杨新鸣','剧情','中国','中文','116min','该片讲述了神油店老板程勇从一个交不起房租的男性保健品商贩，一跃成为印度仿制药“格列宁”独家代理商的故事','2018','https://i.loli.net/2020/06/06/BNGHYpQRwO9LF1g.jpg'),(19,'唐人街探案2',7.8,'陈思诚','陈思诚','王宝强，刘昊然，肖央','喜剧','中国','中文','120min','该片讲述了唐仁为巨额奖金欺骗秦风到纽约参加世界名侦探大赛，比赛的内容是寻找杀害唐人街教父七叔的孙子的凶手。两人再次组合侦破案件，并冒着生命危险闹翻纽约的故事','2018','https://i.loli.net/2020/06/06/vNsireQmzTn1X9O.jpg');

/*Table structure for table `information` */

DROP TABLE IF EXISTS `information`;

CREATE TABLE `information` (
  `user_name` varchar(9) NOT NULL,
  `petName` varchar(10) DEFAULT '',
  `gender` varchar(6) DEFAULT NULL,
  `birthday` date DEFAULT '0000-00-00',
  `hobby` varchar(30) DEFAULT '',
  `email` varchar(20) DEFAULT '',
  `signature` varchar(100) DEFAULT '',
  `imageResource` varchar(100) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `information` */

insert  into `information`(`user_name`,`petName`,`gender`,`birthday`,`hobby`,`email`,`signature`,`imageResource`) values ('987654','','male','0000-00-00','','','',''),('56789','','female','0000-00-00','','','',''),('8520','','male','0000-00-00','','','',''),('7530','','female','0000-00-00','','','',''),('6666','','male','0000-00-00','','','','');

/*Table structure for table `review` */

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
  `review_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `check` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否审核',
  `pass` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否通过',
  `rating` float DEFAULT NULL,
  `user_name` varchar(9) DEFAULT NULL,
  `user_id` mediumint(9) DEFAULT NULL,
  `film_name` varchar(20) NOT NULL,
  `film_id` smallint(6) DEFAULT NULL,
  `creat_date` datetime DEFAULT NULL,
  `title` varchar(15) NOT NULL,
  `text` varchar(140) NOT NULL,
  `likes` smallint(5) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`review_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `review` */

insert  into `review`(`review_id`,`check`,`pass`,`rating`,`user_name`,`user_id`,`film_name`,`film_id`,`creat_date`,`title`,`text`,`likes`) values (1,0,0,NULL,'javk',2020001,'罗马假日',6,NULL,'','很好',0),(2,0,0,9.5,'javk',2020001,'罗马假日',6,'2020-05-16 00:09:27','观后感','真的好看太好看了啊啊啊啊',0),(3,1,1,9.5,'javk',2020001,'罗马假日',6,'2020-05-16 00:28:10','观后感','真的好看太好看了啊啊啊啊',2),(4,1,0,8.4,'javk',2020001,'罗马假日',6,'2020-05-16 00:43:06','作文','very good',0),(5,1,0,8.4,'飞天小魔女',2020004,'在干嘛',8,'2020-05-16 01:35:32','作文','very good',0),(6,0,0,5.2,'飞天小魔女',2020004,'在干嘛',8,'2020-05-24 20:40:56','不知道取什么标题','凸(艹皿艹 )凸(艹皿艹 )凸(艹皿艹 )凸(艹皿艹 )凸(艹皿艹 )凸(艹皿艹凸(艹皿艹 )凸(艹皿艹 )凸(艹皿艹 )凸(艹皿艹 )凸(艹皿艹 )凸(艹皿艹 )凸(艹皿艹 )凸(艹皿艹 )凸(艹皿艹 )',0),(7,0,0,NULL,'飞天小魔女',2020004,'在干嘛',8,'2020-05-27 00:35:17','xx','啊啊啊',0),(8,0,0,NULL,'飞天小魔女',2020004,'在干嘛',8,'2020-05-13 00:35:49','55','6666666666',0),(9,1,0,NULL,'飞天小魔女',2020004,'在干嘛',8,'2020-05-20 00:36:21','可以','土',0),(10,1,0,5.5,'123456',NULL,'ææè¾¹ç¼',3,'2020-06-04 15:31:20','DSAJHDLKAJSH','SADDSADSADASDASDSADSADAS',0),(11,1,0,4.2,'123456',NULL,'ææè¾¹ç¼',3,'2020-06-04 15:32:30','æ©ä¸å¥½','æ©ä¸å¥½æ©ä¸å¥½æ©ä¸å¥½æ©ä¸å¥½æ©ä¸å¥½æ©ä¸å¥½æ©ä¸å¥½æ©ä¸å¥½æ©ä¸å¥½',0),(12,0,0,4.7,'123456',NULL,'明月边缘',3,'2020-06-04 15:38:17','啊啊啊','啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊',0),(13,0,0,0,'7530',NULL,'肖申克的救赎',4,'2020-06-05 19:12:16','旷世巨作','太感人了呜呜呜呜把我看哭了呀呀呀呀呀呀晕',0),(14,1,0,3,'7530',NULL,'肖申克的救赎',4,'2020-06-05 19:23:23','观后感','太好看了太好看了太好看了太好看了太好看了太好看了太好看了太好看了太好看了太好看了',0),(15,0,0,5.8,'123456',NULL,'让子弹飞',14,'2020-06-06 22:18:06','旷世巨作','太好看了太好看了太好看了太好看了太好看了太好看了',0);

/*Table structure for table `review_like` */

DROP TABLE IF EXISTS `review_like`;

CREATE TABLE `review_like` (
  `review_id` smallint(6) NOT NULL,
  `user_name` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `review_like` */

insert  into `review_like`(`review_id`,`user_name`) values (2,'javk'),(5,'javk'),(6,'飞天小魔女'),(3,'56789'),(3,'7530');

/*Table structure for table `short_review` */

DROP TABLE IF EXISTS `short_review`;

CREATE TABLE `short_review` (
  `review_id` smallint(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `check` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否审核',
  `pass` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否通过',
  `rating` float DEFAULT NULL,
  `user_name` varchar(9) DEFAULT NULL,
  `user_id` mediumint(9) DEFAULT NULL,
  `film_name` varchar(20) DEFAULT NULL,
  `file_id` smallint(6) DEFAULT NULL,
  `creat_date` datetime DEFAULT NULL,
  `text` varchar(140) NOT NULL,
  PRIMARY KEY (`review_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `short_review` */

/*Table structure for table `slideshow` */

DROP TABLE IF EXISTS `slideshow`;

CREATE TABLE `slideshow` (
  `id` smallint(6) NOT NULL,
  `img_src` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `slideshow` */

insert  into `slideshow`(`id`,`img_src`) values (3,'https://i.loli.net/2020/05/26/m5y3GNxEHOBrzq4.jpg'),(13,'https://i.loli.net/2020/06/06/hHkbBsKSztPRIxC.jpg'),(19,'https://i.loli.net/2020/06/06/vNsireQmzTn1X9O.jpg');

/*Table structure for table `test` */

DROP TABLE IF EXISTS `test`;

CREATE TABLE `test` (
  `creat_data` datetime DEFAULT NULL,
  `context` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `test` */

insert  into `test`(`creat_data`,`context`) values ('2020-05-12 17:15:44',NULL),('2020-05-12 17:27:55',NULL),('2020-05-12 17:29:01',NULL),('2020-05-12 18:22:47',NULL),('2020-05-12 20:36:59',NULL),('2020-05-12 20:37:15',NULL),('2020-05-12 20:37:37',NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(9) NOT NULL,
  `password` varchar(8) NOT NULL,
  `power` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0用户 1管理员',
  `regist_date` datetime NOT NULL,
  `last_online_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2020016 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`password`,`power`,`regist_date`,`last_online_date`) values (2020001,'javk','e10adc39',0,'2020-05-13 19:41:35','2020-05-22 19:41:38'),(2020002,'带带大师兄','e10adc39',0,'2020-05-15 19:41:56','2020-05-28 19:41:59'),(2020003,'ajaxK','e10adc39',0,'2020-05-13 19:42:44','2020-05-29 19:42:47'),(2020004,'飞天小魔女','e10adc39',0,'2020-04-28 22:58:37','2020-05-29 22:58:40'),(2020005,'阿里郎','e10adc39',0,'2020-05-13 22:58:54','2020-05-30 22:58:56'),(2020006,'梁非凡','e10adc39',0,'2020-05-18 22:59:08','2020-05-29 22:59:11'),(2020007,'123456','e10adc39',0,'2020-05-21 22:59:21','2020-05-31 22:59:25'),(2020008,'再见吧朋友','e10adc39',0,'2020-05-13 22:59:51','2020-05-28 22:59:54'),(2020009,'药水哥刘波','e10adc39',0,'2020-05-19 23:00:47','2020-05-16 23:00:50'),(2020010,'西蜀霸王','e10adc39',0,'2020-06-18 23:00:59','2020-05-28 23:01:05'),(2020011,'987654','e10adc39',0,'2020-05-29 10:17:51',NULL),(2020012,'56789','e10adc39',0,'2020-05-29 10:53:40',NULL),(2020013,'8520','e10adc39',0,'2020-05-29 11:26:21',NULL),(2020014,'7530','e10adc39',1,'2020-05-29 11:26:48',NULL),(2020015,'6666','6d071901',0,'2020-06-04 11:21:27',NULL);

/* Function  structure for function  `firstPinyin` */

/*!50003 DROP FUNCTION IF EXISTS `firstPinyin` */;
DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` FUNCTION `firstPinyin`(P_NAME VARCHAR(255)) RETURNS varchar(255) CHARSET utf8
    DETERMINISTIC
BEGIN  
    DECLARE V_RETURN VARCHAR(255);
    DECLARE V_BOOL INT DEFAULT 0;
          DECLARE FIRST_VARCHAR VARCHAR(1);
    SET FIRST_VARCHAR = left(CONVERT(P_NAME USING gbk),1);
    SELECT FIRST_VARCHAR REGEXP '[a-zA-Z]' INTO V_BOOL;
    IF V_BOOL = 1 THEN
      SET V_RETURN = FIRST_VARCHAR;
    ELSE
      SET V_RETURN = ELT(INTERVAL(CONV(HEX(left(CONVERT(P_NAME USING gbk),1)),16,10),   
          0xB0A1,0xB0C5,0xB2C1,0xB4EE,0xB6EA,0xB7A2,0xB8C1,0xB9FE,0xBBF7,   
          0xBFA6,0xC0AC,0xC2E8,0xC4C3,0xC5B6,0xC5BE,0xC6DA,0xC8BB,  
          0xC8F6,0xCBFA,0xCDDA,0xCEF4,0xD1B9,0xD4D1),   
      'A','B','C','D','E','F','G','H','J','K','L','M','N','O','P','Q','R','S','T','W','X','Y','Z');  
    END IF;
    RETURN V_RETURN;
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
