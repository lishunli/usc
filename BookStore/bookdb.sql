/*
MySQL Data Transfer
Source Host: localhost
Source Database: bookdb
Target Host: localhost
Target Database: bookdb
Date: 10/24/2009 11:40:46 PM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `ID` varchar(8) NOT NULL,
  `NAME` varchar(24) DEFAULT NULL,
  `TITLE` varchar(96) DEFAULT NULL,
  `PRICE` float DEFAULT NULL,
  `YR` int(11) DEFAULT NULL,
  `DESCRIPTION` varchar(128) DEFAULT NULL,
  `SALE_AMOUNT` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `books` VALUES ('202', '孙卫琴', '精通Struts', '49', '2004', '真的很棒', '80000');
INSERT INTO `books` VALUES ('203', '孙卫琴', 'Tomcat与JavaWeb开发技术详解', '45', '2004', '关于Tomcat与JavaWeb开发的最畅销的技术书', '40000');
INSERT INTO `books` VALUES ('204', '孙卫琴', 'Java网络编程精解', '55', '2007', '很值得一看', '20000');
INSERT INTO `books` VALUES ('205', '孙卫琴', '精通Hibernate', '59', '2005', '权威的Hibernate技术资料', '50000');
INSERT INTO `books` VALUES ('206', '孙卫琴', 'Java2认证考试指南与试题解析', '88', '2002', '权威的Java技术资料', '8000');
