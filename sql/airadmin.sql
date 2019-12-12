/*
Navicat MySQL Data Transfer

Source Server         : myserver
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : air_admin

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2019-12-12 11:36:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ts_flight`
-- ----------------------------
DROP TABLE IF EXISTS `ts_flight`;
CREATE TABLE `ts_flight` (
  `ticket_id` int(10) NOT NULL COMMENT '订单号',
  `flight_no` varchar(6) DEFAULT NULL COMMENT '航班号',
  `starttime` datetime DEFAULT NULL,
  `start` varchar(20) DEFAULT NULL COMMENT '起点站',
  `end` varchar(20) DEFAULT NULL COMMENT '终点站',
  `price` float DEFAULT NULL COMMENT '价格',
  `peo_num` tinyint(4) DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `discount` float DEFAULT NULL,
  `start_city` varchar(30) DEFAULT NULL,
  `end_city` varchar(30) DEFAULT NULL,
  `aircraft_type` varchar(30) DEFAULT NULL,
  `air_company` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;、

-- ----------------------------
-- Table structure for `ts_flight_ticket`
-- ----------------------------
DROP TABLE IF EXISTS `ts_flight_ticket`;
CREATE TABLE `ts_flight_ticket` (
  `flight_ticket_id` int(10) NOT NULL AUTO_INCREMENT,
  `ticket_id` int(10) NOT NULL,
  `flight_id` int(10) NOT NULL,
  PRIMARY KEY (`flight_ticket_id`),
  KEY `fk_ticket_flight` (`ticket_id`),
  KEY `fk_flight_ticket` (`flight_id`),
  CONSTRAINT `ts_flight_ticket_ibfk_1` FOREIGN KEY (`ticket_id`) REFERENCES `ts_ticket` (`ticket_id`) ON UPDATE CASCADE,
  CONSTRAINT `ts_flight_ticket_ibfk_2` FOREIGN KEY (`flight_id`) REFERENCES `ts_flight` (`ticket_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `ts_takeperson`
-- ----------------------------
DROP TABLE IF EXISTS `ts_takeperson`;
CREATE TABLE `ts_takeperson` (
  `takeperson_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `id_number` varchar(18) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`takeperson_id`),
  UNIQUE KEY `id_number` (`id_number`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `ts_ticket`
-- ----------------------------
DROP TABLE IF EXISTS `ts_ticket`;
CREATE TABLE `ts_ticket` (
  `ticket_id` int(10) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ticket_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `ts_ticket_takepersion`
-- ----------------------------
DROP TABLE IF EXISTS `ts_ticket_takepersion`;
CREATE TABLE `ts_ticket_takepersion` (
  `ticket_takepersion_id` int(10) NOT NULL AUTO_INCREMENT,
  `ticket_id` int(10) NOT NULL,
  `takeperson_id` int(10) NOT NULL,
  PRIMARY KEY (`ticket_takepersion_id`),
  KEY `fk_ticket_flight` (`ticket_id`),
  KEY `fk_takepersion_ticket` (`takeperson_id`),
  CONSTRAINT `ts_ticket_takepersion_ibfk_1` FOREIGN KEY (`ticket_id`) REFERENCES `ts_ticket` (`ticket_id`) ON UPDATE CASCADE,
  CONSTRAINT `ts_ticket_takepersion_ibfk_2` FOREIGN KEY (`takeperson_id`) REFERENCES `ts_takeperson` (`takeperson_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `ts_ticket_user`
-- ----------------------------
DROP TABLE IF EXISTS `ts_ticket_user`;
CREATE TABLE `ts_ticket_user` (
  `ticket_user_id` int(10) NOT NULL AUTO_INCREMENT,
  `ticket_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  PRIMARY KEY (`ticket_user_id`),
  KEY `fk_ticket_user` (`ticket_id`),
  KEY `fk_user_ticket` (`user_id`),
  CONSTRAINT `ts_ticket_user_ibfk_1` FOREIGN KEY (`ticket_id`) REFERENCES `ts_ticket` (`ticket_id`) ON UPDATE CASCADE,
  CONSTRAINT `ts_ticket_user_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `um_user` (`user_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `um_user`
-- ----------------------------
DROP TABLE IF EXISTS `um_user`;
CREATE TABLE `um_user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(20) DEFAULT NULL COMMENT '账号',
  `password` varchar(32) DEFAULT NULL COMMENT '密码(密码+盐)',
  `salt` varchar(36) DEFAULT NULL COMMENT '盐',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别(0未知;1男;2女)',
  `nickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `birth` date DEFAULT NULL COMMENT '出生日期',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `us_role`
-- ----------------------------
DROP TABLE IF EXISTS `us_role`;
CREATE TABLE `us_role` (
  `role_id` int(10) NOT NULL COMMENT '编号',
  `name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(1000) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `us_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `us_user_role`;
CREATE TABLE `us_user_role` (
  `user_role_id` int(10) NOT NULL COMMENT '编号',
  `user_id` int(10) DEFAULT NULL COMMENT '编号',
  `role_id` int(10) DEFAULT NULL COMMENT '编号',
  PRIMARY KEY (`user_role_id`),
  KEY `FK_Reference_1` (`user_id`),
  KEY `FK_Reference_2` (`role_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`user_id`) REFERENCES `um_user` (`user_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`role_id`) REFERENCES `us_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;