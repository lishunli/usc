/*
MySQL Data Transfer
Source Host: localhost
Source Database: tree
Target Host: localhost
Target Database: tree
Date: 10/28/2009 5:57:38 PM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for tree
-- ----------------------------
DROP TABLE IF EXISTS `tree`;
CREATE TABLE `tree` (
  `id` int(11) NOT NULL,
  `pid` int(11) NOT NULL DEFAULT '0',
  `name` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `tree` VALUES ('1', '0', '1');
INSERT INTO `tree` VALUES ('2', '1', '10');
INSERT INTO `tree` VALUES ('3', '1', '11');
INSERT INTO `tree` VALUES ('4', '2', '100');
INSERT INTO `tree` VALUES ('5', '2', '101');
INSERT INTO `tree` VALUES ('6', '3', '110');
INSERT INTO `tree` VALUES ('7', '6', '1100');
INSERT INTO `tree` VALUES ('8', '0', '木子');
INSERT INTO `tree` VALUES ('9', '8', '李');
