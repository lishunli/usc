/*
Navicat MySQL Data Transfer

Source Server         : Local
Source Server Version : 50512
Source Host           : localhost:3306
Source Database       : pis

Target Server Type    : MYSQL
Target Server Version : 50512
File Encoding         : 65001

Date: 2011-08-10 00:04:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `draw`
-- ----------------------------
DROP TABLE IF EXISTS `draw`;
CREATE TABLE `draw` (
  `draw_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`draw_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of draw
-- ----------------------------
INSERT INTO `draw` VALUES ('1', '1.png');
INSERT INTO `draw` VALUES ('2', '2.png');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `model` varchar(255) NOT NULL COMMENT '产品型号',
  `name` varchar(255) NOT NULL COMMENT '产品名称',
  `sampling_ratio` decimal(23,8) unsigned NOT NULL COMMENT '抽样比例',
  `standard_length` decimal(23,8) NOT NULL COMMENT '标准长度',
  `error_range` decimal(23,8) NOT NULL,
  `draw_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `ref_draw_id` (`draw_id`),
  CONSTRAINT `ref_draw_id` FOREIGN KEY (`draw_id`) REFERENCES `draw` (`draw_id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'XXX', 'XXX_NAME', '0.00500000', '5.50000000', '0.10000000', '1');
INSERT INTO `product` VALUES ('2', 'YYY', 'YYY_NAME', '0.00500000', '6.20000000', '0.20000000', '2');
