/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : minilibrary

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2020-12-07 20:58:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_book
-- ----------------------------
DROP TABLE IF EXISTS `sys_book`;
CREATE TABLE `sys_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书编号',
  `bookName` varchar(50) DEFAULT NULL COMMENT '书名',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  `publisher` varchar(50) DEFAULT NULL COMMENT '出版社',
  `bookNumbers` int(11) DEFAULT NULL COMMENT '图书数量',
  `lendedNumber` int(11) DEFAULT NULL COMMENT '借出数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_book
-- ----------------------------
INSERT INTO `sys_book` VALUES (1, '第一本书', '作者1', 'PUP', 10, 4);
INSERT INTO `sys_book` VALUES (2, '第二本书', 'author2', 'PUP', 5, 5);
INSERT INTO `sys_book` VALUES (3, '第三本书', '作者3', 'NKU', 15, 2);
INSERT INTO `sys_book` VALUES (4, '第四本书', '作者4', 'NKU', 20, 2);
INSERT INTO `sys_book` VALUES (5, '第五本书', '作者5', 'NKU', 5, 5);
-- ----------------------------
-- Table structure for sys_lend
-- ----------------------------
DROP TABLE IF EXISTS `sys_lend`;
CREATE TABLE `sys_lend` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '借阅编号，主键',
  `userId` int(11) DEFAULT NULL COMMENT '用户编号，外键',
  `bookId` int(11) DEFAULT NULL COMMENT '图书编号，外键',
  `lendDate` date DEFAULT NULL COMMENT '借阅时间',
  `estimateReturnDate` date DEFAULT NULL COMMENT '预计归还时间',
  `actualDeturnDate` date DEFAULT NULL COMMENT '实际归还时间',
  `status` varchar(2) DEFAULT NULL COMMENT '借阅标志位：（00-借阅中;11-已归还）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_lend
-- ----------------------------
INSERT INTO `sys_lend` VALUES (6, 1, 1, '2021-1-2', '2021-7-1', '2021-1-2', '11');
INSERT INTO `sys_lend` VALUES (7, 2, 5, '2021-1-2', '2021-4-2', NULL, '0');
INSERT INTO `sys_lend` VALUES (8, 3, 2, '2021-1-2', '2021-7-1', NULL, '0');
INSERT INTO `sys_lend` VALUES (9, 4, 3, '2021-1-2', '2021-4-2', NULL, '0');
INSERT INTO `sys_lend` VALUES (10, 6, 3, '2021-1-2', '2021-7-1', NULL, '0');
INSERT INTO `sys_lend` VALUES (11, 5, 4, '2021-1-2', '2021-7-1', NULL, '0');
INSERT INTO `sys_lend` VALUES (12, 2, 4, '2021-1-2', '2021-4-2', '2021-1-2', '11');
INSERT INTO `sys_lend` VALUES (13, 2, 1, '2021-1-2', '2021-4-2', NULL, '0');
INSERT INTO `sys_lend` VALUES (14, 2, 2, '2021-1-2', '2021-4-2', NULL, '0');
INSERT INTO `sys_lend` VALUES (15, 4, 3, '2021-1-2', '2021-4-2', '2021-1-2', '11');
INSERT INTO `sys_lend` VALUES (16, 4, 2, '2021-1-2', '2021-4-2', NULL, '0');
INSERT INTO `sys_lend` VALUES (17, 4, 5, '2021-1-2', '2021-4-2', NULL, '0');
INSERT INTO `sys_lend` VALUES (18, 6, 2, '2021-1-2', '2021-7-1', NULL, '0');
INSERT INTO `sys_lend` VALUES (19, 6, 1, '2021-1-2', '2021-7-1', '2021-1-2', '11');
INSERT INTO `sys_lend` VALUES (20, 6, 5, '2021-1-2', '2021-7-1', NULL, '0');
INSERT INTO `sys_lend` VALUES (21, 3, 2, '2021-1-2', '2021-7-1', '2021-1-2', '11');
INSERT INTO `sys_lend` VALUES (22, 3, 1, '2021-1-2', '2021-7-1', NULL, '0');
INSERT INTO `sys_lend` VALUES (23, 1, 1, '2021-1-2', '2021-7-1', NULL, '0');
INSERT INTO `sys_lend` VALUES (24, 1, 5, '2021-1-2', '2021-7-1', NULL, '0');
INSERT INTO `sys_lend` VALUES (25, 5, 1, '2021-1-2', '2021-7-1', NULL, '0');
INSERT INTO `sys_lend` VALUES (26, 5, 5, '2021-1-2', '2021-7-1', NULL, '0');
INSERT INTO `sys_lend` VALUES (27, 1, 2, '2021-1-2', '2021-7-1', NULL, '0');
INSERT INTO `sys_lend` VALUES (28, 11, 4, '2021-1-2', '2021-4-2', NULL, '0');
INSERT INTO `sys_lend` VALUES (29, 11, 3, '2021-1-2', '2021-4-2', NULL, '0');
INSERT INTO `sys_lend` VALUES (30, 11, 3, '2021-1-2', '2021-4-2', '2021-1-2', '11');
INSERT INTO `sys_lend` VALUES (31, 11, 3, '2021-1-2', '2021-4-2', '2021-1-2', '11');
INSERT INTO `sys_lend` VALUES (32, 1, 3, '2021-1-2', '2021-7-1', NULL, '0');
-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色主键',
  `roleName` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '系统管理员');
INSERT INTO `sys_role` VALUES ('2', 'teacher', '教师');
INSERT INTO `sys_role` VALUES ('3', 'student', '学生');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `loginName` varchar(20) DEFAULT NULL COMMENT '登录名称',
  `realName` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `roleId` int(11) DEFAULT NULL COMMENT '角色编号',
  `maxLendNumber` int(11) DEFAULT NULL COMMENT '最大借阅数量：教师：10；学生：5',
  `maxLendDays` int(11) DEFAULT NULL COMMENT '最大借阅天数：教师：180；学生：90',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '管理员测试用户', '123456', 1, 10, 180);
INSERT INTO `sys_user` VALUES (2, 'student', '学生测试用户', '123456', 3, 5, 90);
INSERT INTO `sys_user` VALUES (3, 'teacher', '教师测试用户', '123456', 2, 10, 180);
INSERT INTO `sys_user` VALUES (4, 'student2', '学生2', '123456', 3, 5, 90);
INSERT INTO `sys_user` VALUES (5, 'admin2', '管理员2', '123456', 1, 5, 90);
INSERT INTO `sys_user` VALUES (6, 'teacher2', '教师2', '123456', 2, 10, 180);