/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : orienttdm_base

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 01/27/2018 20:14:07 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `sm_role`
-- ----------------------------
DROP TABLE IF EXISTS `sm_dept`;
CREATE TABLE `sm_dept` (
`id` int(11) NOT NULL,
`name` varchar(255) NOT NULL,
`description` varchar(2000) DEFAULT NULL,
`pid` int(11),
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `sm_dept_user`
-- ----------------------------
DROP TABLE IF EXISTS `sm_dept_user`;
CREATE TABLE `sm_dept_user` (
`id` int(11) NOT NULL,
`dept_id` int(11) NOT NULL,
`user_id` int(11) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `sm_role`
-- ----------------------------
DROP TABLE IF EXISTS `sm_role`;
CREATE TABLE `sm_role` (
`id` int(11) NOT NULL,
`name` varchar(255) NOT NULL,
`description` varchar(2000) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `sm_role_user`
-- ----------------------------
DROP TABLE IF EXISTS `sm_role_user`;
CREATE TABLE `sm_role_user` (
`id` int(11) NOT NULL,
`role_id` int(11) NOT NULL,
`user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `sm_user`
-- ----------------------------
DROP TABLE IF EXISTS `sm_user`;
CREATE TABLE `sm_user` (
`id` int(11) NOT NULL,
`user_name` varchar(255) NOT NULL,
`all_name` varchar(255) NOT NULL,
`user_password` varchar(255) NOT NULL,
`is_del` int(1) NOT NULL DEFAULT '0',
`create_time` datetime DEFAULT NULL,
`create_user` int(11) DEFAULT NULL,
`update_time` datetime DEFAULT NULL,
`update_user` int(11) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
