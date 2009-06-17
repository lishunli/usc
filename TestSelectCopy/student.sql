/*
MySQL Data Transfer
Source Host: localhost
Source Database: student
Target Host: localhost
Target Database: student
Date: 6/18/2009 12:42:32 AM
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
  CONSTRAINT `student_ibfk_3` FOREIGN KEY (`gname`) REFERENCES `grade` (`gname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records 
-- ----------------------------
