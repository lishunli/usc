/*
Navicat MySQL Data Transfer

Source Server         : Local
Source Server Version : 50512
Source Host           : localhost:3306
Source Database       : pis

Target Server Type    : MYSQL
Target Server Version : 50512
File Encoding         : 65001

Date: 2011-08-15 22:55:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `draw`
-- ----------------------------
DROP TABLE IF EXISTS `draw`;
CREATE TABLE `draw` (
  `draw_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图纸ID',
  `part_id` int(11) NOT NULL COMMENT '零件ID',
  `name` varchar(255) NOT NULL COMMENT '图纸路径',
  PRIMARY KEY (`draw_id`),
  KEY `part_id_ref` (`part_id`),
  CONSTRAINT `part_id_ref` FOREIGN KEY (`part_id`) REFERENCES `part` (`part_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of draw
-- ----------------------------
INSERT INTO `draw` VALUES ('1', '1', '1.pdf');
INSERT INTO `draw` VALUES ('2', '2', '2.pdf');
INSERT INTO `draw` VALUES ('3', '3', '1.pdf');

-- ----------------------------
-- Table structure for `injection`
-- ----------------------------
DROP TABLE IF EXISTS `injection`;
CREATE TABLE `injection` (
  `injection_id` int(11) NOT NULL AUTO_INCREMENT,
  `part_id` int(11) NOT NULL COMMENT '零件ID',
  `name` varchar(255) NOT NULL COMMENT '检测部分',
  `standard_length` decimal(23,8) NOT NULL COMMENT '标准长度',
  `up_error_range` decimal(23,8) NOT NULL COMMENT '上偏差',
  `down_error_range` decimal(23,8) NOT NULL COMMENT '下偏差',
  PRIMARY KEY (`injection_id`),
  KEY `part_id_ref` (`part_id`),
  CONSTRAINT `injection_ibfk_1` FOREIGN KEY (`part_id`) REFERENCES `part` (`part_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of injection
-- ----------------------------
INSERT INTO `injection` VALUES ('1', '1', '长', '5.00000000', '0.10000000', '0.20000000');
INSERT INTO `injection` VALUES ('2', '1', '宽', '6.00000000', '0.20000000', '0.20000000');
INSERT INTO `injection` VALUES ('3', '1', '高', '5.50000000', '0.15000000', '1.00000000');
INSERT INTO `injection` VALUES ('4', '2', '长', '10.00000000', '1.00000000', '1.00000000');
INSERT INTO `injection` VALUES ('5', '2', '高', '4.00000000', '0.10000000', '1.00000000');
INSERT INTO `injection` VALUES ('6', '2', '内径', '5.00000000', '0.30000000', '2.00000000');
INSERT INTO `injection` VALUES ('7', '2', '外径', '6.00000000', '0.20000000', '2.00000000');
INSERT INTO `injection` VALUES ('8', '3', '长', '10.00000000', '1.00000000', '2.00000000');
INSERT INTO `injection` VALUES ('9', '3', '高', '5.00000000', '0.80000000', '1.20000000');
INSERT INTO `injection` VALUES ('10', '3', '内径', '6.00000000', '1.00000000', '1.00000000');
INSERT INTO `injection` VALUES ('11', '3', '外径', '8.00000000', '2.00000000', '1.50000000');

-- ----------------------------
-- Table structure for `part`
-- ----------------------------
DROP TABLE IF EXISTS `part`;
CREATE TABLE `part` (
  `part_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '零件ID',
  `product_id` int(11) NOT NULL COMMENT '产品ID',
  `name` varchar(255) NOT NULL COMMENT '零件名称',
  PRIMARY KEY (`part_id`),
  KEY `product_id_ref` (`product_id`),
  CONSTRAINT `product_id_ref` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of part
-- ----------------------------
INSERT INTO `part` VALUES ('1', '1', 'HP60.001');
INSERT INTO `part` VALUES ('2', '2', '001 0602 00');
INSERT INTO `part` VALUES ('3', '1', 'HP60.002');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品ID',
  `model` varchar(255) NOT NULL COMMENT '型号',
  `name` varchar(255) NOT NULL COMMENT '产品名称',
  `sampling_ratio` decimal(23,8) NOT NULL COMMENT '抽样比率',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'HP60', '惠普60打印机', '0.00500000');
INSERT INTO `product` VALUES ('2', 'HP62', '惠普62打印机', '0.00600000');
