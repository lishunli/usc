/*
MySQL Data Transfer
Source Host: localhost
Source Database: users
Target Host: localhost
Target Database: users
Date: 8/1/2009 9:00:37 PM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(48) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `user` VALUES ('16', 'usc3l', 'acd87e50576a99b13feaf6cf53575ef5');
INSERT INTO `user` VALUES ('17', 'jsjmz', 'acd87e50576a99b13feaf6cf53575ef5');
INSERT INTO `user` VALUES ('18', 'abcde', 'acd87e50576a99b13feaf6cf53575ef5');
INSERT INTO `user` VALUES ('19', 'lishunli', 'acd87e50576a99b13feaf6cf53575ef5');
INSERT INTO `user` VALUES ('20', 'admin', 'acd87e50576a99b13feaf6cf53575ef5');
INSERT INTO `user` VALUES ('21', 'jsjmz1', 'acd87e50576a99b13feaf6cf53575ef5');
INSERT INTO `user` VALUES ('22', '中国人你好', 'acd87e50576a99b13feaf6cf53575ef5');
INSERT INTO `user` VALUES ('23', 'asdfasfa', 'acd87e50576a99b13feaf6cf53575ef5');
INSERT INTO `user` VALUES ('24', 'sadfasdfa', 'c4ca4238a0b92382dcc509a6f75849b');
INSERT INTO `user` VALUES ('25', 'safasddfa', 'acd87e50576a99b13feaf6cf53575ef5');
INSERT INTO `user` VALUES ('26', 'jsjmz3', 'acd87e50576a99b13feaf6cf53575ef5');
INSERT INTO `user` VALUES ('27', 'jsjmz4', 'acd87e50576a99b13feaf6cf53575ef5');
INSERT INTO `user` VALUES ('28', 'lishunli3', 'acd87e50576a99b13feaf6cf53575ef5');
INSERT INTO `user` VALUES ('29', 'dsafkljlk', 'acd87e50576a99b13feaf6cf53575ef5');
INSERT INTO `user` VALUES ('30', 'lishunli5', 'acd87e50576a99b13feaf6cf53575ef5');
INSERT INTO `user` VALUES ('31', '111111', 'acd87e50576a99b13feaf6cf53575ef5');
INSERT INTO `user` VALUES ('32', 'aaaaaa', '74b8733745420d4d33f80c4663dc5e5');
INSERT INTO `user` VALUES ('33', 'qqqqq', '3bad6af0fa4b8b33d162e19938ee981');
INSERT INTO `user` VALUES ('34', 'aaaaaaa', '74b8733745420d4d33f80c4663dc5e5');
INSERT INTO `user` VALUES ('35', 'aaaaaaaa', '74b8733745420d4d33f80c4663dc5e5');
