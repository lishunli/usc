/*
Navicat MySQL Data Transfer

Source Server         : 顺利
Source Server Version : 50140
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50140
File Encoding         : 65001

Date: 2009-12-27 00:05:10
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `sex` varchar(1) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `eduTime` date DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '陈琳琳', '男', '21', '95.5', '2006-09-15');
INSERT INTO `student` VALUES ('2', '肖清', '男', '21', '95.5', '2006-09-17');
INSERT INTO `student` VALUES ('3', '李叶青', '男', '21', '95.5', '2006-09-19');
INSERT INTO `student` VALUES ('4', '林淼', '男', '21', '85.5', '2006-09-23');
INSERT INTO `student` VALUES ('5', '赵刚', '男', '21', '87.5', '2006-09-25');
INSERT INTO `student` VALUES ('6', '刘书培', '男', '21', '88.5', '2006-09-26');
INSERT INTO `student` VALUES ('7', '刘海宽', '男', '21', '89.5', '2006-09-27');
INSERT INTO `student` VALUES ('8', '蔡博远', '男', '21', '90.5', '2006-09-28');
INSERT INTO `student` VALUES ('9', '韩麒麟', '男', '21', '91.5', '2006-09-29');
INSERT INTO `student` VALUES ('10', '章爱国', '男', '20', '99', '2006-09-28');
INSERT INTO `student` VALUES ('11', '蔡晓晨', '男', '21', '93.5', '2006-10-01');
INSERT INTO `student` VALUES ('12', '唐建芳', '男', '21', '94.5', '2006-10-02');
INSERT INTO `student` VALUES ('13', '刘煜晗', '男', '21', '95.5', '2006-10-03');
INSERT INTO `student` VALUES ('14', '阳小丽', '男', '21', '96.5', '2006-10-04');
INSERT INTO `student` VALUES ('15', '郑银思', '男', '21', '97.5', '2006-10-05');
INSERT INTO `student` VALUES ('16', '王鸿净', '男', '21', '98.5', '2006-10-06');
INSERT INTO `student` VALUES ('17', '叶娜', '男', '21', '99.5', '2006-10-07');
INSERT INTO `student` VALUES ('18', '张天文', '男', '21', '99.5', '2006-10-08');
INSERT INTO `student` VALUES ('19', '邢超', '男', '21', '99.5', '2006-10-09');
INSERT INTO `student` VALUES ('20', '李顺利', '男', '21', '95', '2006-12-24');
INSERT INTO `student` VALUES ('21', '呵呵', '女', '18', '100', '2009-12-26');
