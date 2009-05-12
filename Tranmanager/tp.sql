/*
MySQL Data Transfer
Source Host: localhost
Source Database: test
Target Host: localhost
Target Database: test
Date: 2009/5/12 13:44:56
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for tp
-- ----------------------------
DROP TABLE IF EXISTS `tp`;
CREATE TABLE `tp` (
  `pid` int(11) NOT NULL auto_increment,
  `pname` varchar(10) NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY  (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records 
-- ----------------------------
