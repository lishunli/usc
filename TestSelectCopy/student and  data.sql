/*
MySQL Data Transfer
Source Host: localhost
Source Database: student
Target Host: localhost
Target Database: student
Date: 6/22/2009 11:39:22 AM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `gno` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`gno`),
  KEY `gname` (`gname`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sno` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `sname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `sex` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `age` int(11) NOT NULL,
  `gname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`sno`),
  KEY `gname` (`gname`),
  KEY `sno` (`sno`),
  CONSTRAINT `student_ibfk_3` FOREIGN KEY (`gname`) REFERENCES `grade` (`gname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `grade` VALUES ('28', '数媒071班');
INSERT INTO `grade` VALUES ('26', '网络061班');
INSERT INTO `grade` VALUES ('31', '网络071班');
INSERT INTO `grade` VALUES ('32', '网络072班');
INSERT INTO `grade` VALUES ('22', '计算机061班');
INSERT INTO `grade` VALUES ('23', '计算机062班');
INSERT INTO `grade` VALUES ('27', '计算机071班');
INSERT INTO `grade` VALUES ('24', '软件061班');
INSERT INTO `grade` VALUES ('25', '软件062班');
INSERT INTO `grade` VALUES ('29', '软件071班');
INSERT INTO `grade` VALUES ('30', '软件072班');
INSERT INTO `student` VALUES ('20064350142', '章爱国', '女生', '20', '软件061班');
INSERT INTO `student` VALUES ('20064440101', '邹红玲', '女生', '20', '计算机061班');
INSERT INTO `student` VALUES ('20064440103', '段燕', '女生', '21', '计算机061班');
INSERT INTO `student` VALUES ('20064440105', '孙望霞', '女生', '20', '计算机061班');
INSERT INTO `student` VALUES ('20064440106', '邹影超', '男生', '20', '计算机061班');
INSERT INTO `student` VALUES ('20064440118', '张建', '男生', '20', '计算机061班');
INSERT INTO `student` VALUES ('20064440122', '王云飞', '男生', '20', '计算机061班');
INSERT INTO `student` VALUES ('20064440128', '廖威武', '男生', '21', '计算机061班');
INSERT INTO `student` VALUES ('20064440138', '何聪', '男生', '22', '计算机061班');
INSERT INTO `student` VALUES ('20064440150', '李顺利', '男生', '20', '计算机061班');
INSERT INTO `student` VALUES ('20080000000', 'zxn ', '男生', '1', '数媒071班');
