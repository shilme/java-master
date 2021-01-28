/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : security

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2021-01-28 17:55:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` double NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `nick_Name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `create_Time` varchar(255) DEFAULT NULL,
  `login_Time` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'root', '123', null, null, null, null, null, null, null);
INSERT INTO `admin` VALUES ('2', 'admin', '$2a$10$xjQgJ1sDs7WEwyaZWuG37Olwv3qauV6s8BGIv3v.sFenQBGDb0/Ea', '1', '1', '1', '2021-01-28 17:17:34.474', '2021-01-28 16:04:19.572', '1', '1');
INSERT INTO `admin` VALUES ('1.354689722684928e18', '123', '$2a$10$PGbL20ukHJUyege3/4aobuBDxSrhfHtGDxf7gKlfOLHJ8ZV/H8dXi', '1', '1', '1', '2021-01-28 15:16:10.716', '2021-01-28 14:42:53.241', '1', '1');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `patter` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '/dba/**');
INSERT INTO `menu` VALUES ('2', '/admin/**');
INSERT INTO `menu` VALUES ('3', '/user/**');

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role` (
  `id` int(11) NOT NULL,
  `mid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES ('1', '1', '1');
INSERT INTO `menu_role` VALUES ('2', '2', '2');
INSERT INTO `menu_role` VALUES ('3', '3', '3');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` double NOT NULL,
  `pid` double(255,0) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `uri` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `createTime` varchar(255) DEFAULT NULL,
  `sort` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nameZh` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_dba', '数据库管理员');
INSERT INTO `role` VALUES ('2', 'ROLE_admin', '系统管理员');
INSERT INTO `role` VALUES ('3', 'ROLE_user', '用户');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `enable` varchar(255) DEFAULT NULL,
  `locked` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'root', '123', '1', '0');
INSERT INTO `user` VALUES ('2', 'admin', '123', '1', '0');
INSERT INTO `user` VALUES ('3', 'sang', '123', '1', '0');
INSERT INTO `user` VALUES ('4', 'fern', '123', '1', '0');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '1', '2');
INSERT INTO `user_role` VALUES ('3', '2', '2');
INSERT INTO `user_role` VALUES ('4', '3', '3');
