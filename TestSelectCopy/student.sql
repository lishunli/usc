/*
MySQL Data Transfer
Source Host: localhost
Source Database: student
Target Host: localhost
Target Database: student
Date: 6/16/2009 7:32:21 PM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `gno` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`gno`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `grade` VALUES ('1', '计算机061班');
INSERT INTO `grade` VALUES ('2', '计算机062班');
INSERT INTO `grade` VALUES ('3', '软件061班');
INSERT INTO `grade` VALUES ('4', '软件062班');
INSERT INTO `grade` VALUES ('5', '网络061班');
INSERT INTO `grade` VALUES ('6', '计算机071班');
INSERT INTO `grade` VALUES ('7', '数媒071班');
INSERT INTO `grade` VALUES ('8', '软件071班');
INSERT INTO `grade` VALUES ('9', '软件072班');
INSERT INTO `grade` VALUES ('12', '网络071班');
INSERT INTO `grade` VALUES ('18', '网络072班');
INSERT INTO `student` VALUES ('12222222222', '2', '男生', '2', '计算机061班');
INSERT INTO `student` VALUES ('20064440101', '1', '男生', '1', '计算机061班');
INSERT INTO `student` VALUES ('20064440150', '12', '女生', '12', '计算机061班');
INSERT INTO `student` VALUES ('22222222222', '2', '男生', '2', '计算机061班');
