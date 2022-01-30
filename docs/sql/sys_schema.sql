/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : 127.0.0.1:3306
 Source Schema         : fsocity

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 30/01/2022 13:58:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
                              `id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
                              `type` int(11) NOT NULL COMMENT '系统内置（0：是；1：否）',
                              `name` varchar(200) COLLATE utf8mb4_bin NOT NULL COMMENT '参数名称',
                              `key` varchar(200) COLLATE utf8mb4_bin NOT NULL COMMENT '参数键名',
                              `value` varchar(500) COLLATE utf8mb4_bin NOT NULL COMMENT '参数键值',
                              `remark` varchar(500) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '备注',
                              `create_by` int(11) NOT NULL DEFAULT '0' COMMENT '创建者',
                              `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `update_by` int(11) NOT NULL DEFAULT '0' COMMENT '更新者',
                              `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='参数配置表';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
BEGIN;
INSERT INTO `sys_config` VALUES (1, 0, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow', 1, '2022-01-25 16:27:27', 1, '2022-01-25 16:36:03');
INSERT INTO `sys_config` VALUES (2, 0, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', '初始化密码 123456', 1, '2022-01-25 16:27:27', 1, '2022-01-25 16:36:04');
INSERT INTO `sys_config` VALUES (3, 0, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', '深黑主题theme-dark，浅色主题theme-light，深蓝主题theme-blue', 1, '2022-01-25 16:27:27', 1, '2022-01-25 16:36:05');
INSERT INTO `sys_config` VALUES (4, 0, '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', '是否开启注册用户功能（true开启，false关闭）', 1, '2022-01-25 16:27:27', 1, '2022-01-25 16:36:06');
INSERT INTO `sys_config` VALUES (5, 0, '用户管理-密码字符范围', 'sys.account.chrtype', '0', '默认任意字符范围，0任意（密码可以输入任意字符），1数字（密码只能为0-9数字），2英文字母（密码只能为a-z和A-Z字母），3字母和数字（密码必须包含字母，数字）,4字母数字和特殊字符（目前支持的特殊字符包括：~!@#$%^&*()-=_+）', 1, '2022-01-25 16:27:27', 1, '2022-01-25 16:36:07');
INSERT INTO `sys_config` VALUES (6, 0, '用户管理-初始密码修改策略', 'sys.account.initPasswordModify', '0', '0：初始密码修改策略关闭，没有任何提示，1：提醒用户，如果未修改初始密码，则在登录时就会提醒修改密码对话框', 1, '2022-01-25 16:27:27', 1, '2022-01-25 16:36:08');
INSERT INTO `sys_config` VALUES (7, 0, '用户管理-账号密码更新周期', 'sys.account.passwordValidateDays', '0', '密码更新周期（填写数字，数据初始化值为0不限制，若修改必须为大于0小于365的正整数），如果超过这个周期登录系统时，则在登录时就会提醒修改密码对话框', 1, '2022-01-25 16:27:27', 1, '2022-01-25 16:36:09');
INSERT INTO `sys_config` VALUES (8, 0, '主框架页-菜单导航显示风格', 'sys.index.menuStyle', 'default', '菜单导航显示风格（default为左侧导航菜单，topnav为顶部导航菜单）', 1, '2022-01-25 16:27:27', 1, '2022-01-25 16:36:10');
INSERT INTO `sys_config` VALUES (9, 0, '主框架页-是否开启页脚', 'sys.index.footer', 'true', '是否开启底部页脚显示（true显示，false隐藏）', 1, '2022-01-25 16:27:27', 1, '2022-01-25 16:36:10');
INSERT INTO `sys_config` VALUES (10, 0, '主框架页-是否开启页签', 'sys.index.tagsView', 'true', '是否开启菜单多页签显示（true显示，false隐藏）', 1, '2022-01-25 16:27:27', 1, '2022-01-25 16:36:13');
COMMIT;

-- ----------------------------
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department` (
                                  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门id',
                                  `parent_id` int(11) NOT NULL COMMENT '父部门id',
                                  `ancestors` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '祖级列表',
                                  `name` varchar(30) COLLATE utf8mb4_bin NOT NULL COMMENT '部门名称',
                                  `order_num` int(4) NOT NULL DEFAULT '0' COMMENT '显示顺序',
                                  `leader` varchar(20) COLLATE utf8mb4_bin NOT NULL COMMENT '负责人',
                                  `phone` varchar(11) COLLATE utf8mb4_bin NOT NULL COMMENT '联系电话',
                                  `email` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '邮箱',
                                  `status` char(1) COLLATE utf8mb4_bin NOT NULL DEFAULT '0' COMMENT '部门状态（0：正常；1：停用）',
                                  `del_flag` char(1) COLLATE utf8mb4_bin NOT NULL DEFAULT '0' COMMENT '删除标志（0：正常；1：删除）',
                                  `create_by` int(11) NOT NULL DEFAULT '0' COMMENT '创建者',
                                  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                  `update_by` int(11) NOT NULL DEFAULT '0' COMMENT '更新者',
                                  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='部门表';

-- ----------------------------
-- Records of sys_department
-- ----------------------------
BEGIN;
INSERT INTO `sys_department` VALUES (100, 0, '0', '若依科技', 0, '若依', '15888888888', 'ry@qq.com', '0', '0', 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:09:21');
INSERT INTO `sys_department` VALUES (101, 100, '0,100', '深圳总公司', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:09:26');
INSERT INTO `sys_department` VALUES (102, 100, '0,100', '长沙分公司', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:09:29');
INSERT INTO `sys_department` VALUES (103, 101, '0,100,101', '研发部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:09:32');
INSERT INTO `sys_department` VALUES (104, 101, '0,100,101', '市场部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:09:37');
INSERT INTO `sys_department` VALUES (105, 101, '0,100,101', '测试部门', 3, '若依', '15888888888', 'ry@qq.com', '0', '0', 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:09:39');
INSERT INTO `sys_department` VALUES (106, 101, '0,100,101', '财务部门', 4, '若依', '15888888888', 'ry@qq.com', '0', '0', 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:09:43');
INSERT INTO `sys_department` VALUES (107, 101, '0,100,101', '运维部门', 5, '若依', '15888888888', 'ry@qq.com', '0', '0', 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:09:46');
INSERT INTO `sys_department` VALUES (108, 102, '0,100,102', '市场部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:09:49');
INSERT INTO `sys_department` VALUES (109, 102, '0,100,102', '财务部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:09:52');
COMMIT;

-- ----------------------------
-- Table structure for sys_dictionary_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary_data`;
CREATE TABLE `sys_dictionary_data` (
                                       `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
                                       `code` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '字典类型',
                                       `label` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '字典标签',
                                       `value` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '字典键值',
                                       `sort_num` int(4) NOT NULL DEFAULT '0' COMMENT '字典排序',
                                       `is_default` int(11) NOT NULL DEFAULT '0' COMMENT '是否默认（0：否；1：是）',
                                       `remark` varchar(500) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '备注',
                                       `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态（0：正常；1：停用）',
                                       `create_by` int(11) NOT NULL DEFAULT '0' COMMENT '创建者',
                                       `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                       `update_by` int(11) NOT NULL DEFAULT '0' COMMENT '更新者',
                                       `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                                       PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='字典数据表';

-- ----------------------------
-- Records of sys_dictionary_data
-- ----------------------------
BEGIN;
INSERT INTO `sys_dictionary_data` VALUES (1, 'sys_user_sex', '男', '0', 1, 1, '性别男', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (2, 'sys_user_sex', '女', '1', 2, 0, '性别女', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (3, 'sys_user_sex', '未知', '2', 3, 0, '性别未知', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (4, 'sys_show_hide', '显示', '0', 1, 1, '显示菜单', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (5, 'sys_show_hide', '隐藏', '1', 2, 0, '隐藏菜单', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (6, 'sys_normal_disable', '正常', '0', 1, 1, '正常状态', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (7, 'sys_normal_disable', '停用', '1', 2, 0, '停用状态', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (8, 'sys_job_status', '正常', '0', 1, 1, '正常状态', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (9, 'sys_job_status', '暂停', '1', 2, 0, '停用状态', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (10, 'sys_job_group', '默认', 'DEFAULT', 1, 1, '默认分组', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (11, 'sys_job_group', '系统', 'SYSTEM', 2, 0, '系统分组', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (12, 'sys_yes_no', '是', 'Y', 1, 1, '系统默认是', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (13, 'sys_yes_no', '否', 'N', 2, 0, '系统默认否', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (14, 'sys_notice_type', '通知', '1', 1, 1, '通知', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (15, 'sys_notice_type', '公告', '2', 2, 0, '公告', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (16, 'sys_notice_status', '正常', '0', 1, 1, '正常状态', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (17, 'sys_notice_status', '关闭', '1', 2, 0, '关闭状态', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (18, 'sys_oper_type', '其他', '0', 99, 0, '其他操作', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (19, 'sys_oper_type', '新增', '1', 1, 0, '新增操作', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (20, 'sys_oper_type', '修改', '2', 2, 0, '修改操作', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (21, 'sys_oper_type', '删除', '3', 3, 0, '删除操作', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (22, 'sys_oper_type', '授权', '4', 4, 0, '授权操作', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (23, 'sys_oper_type', '导出', '5', 5, 0, '导出操作', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (24, 'sys_oper_type', '导入', '6', 6, 0, '导入操作', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (25, 'sys_oper_type', '强退', '7', 7, 0, '强退操作', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (26, 'sys_oper_type', '生成代码', '8', 8, 0, '生成操作', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (27, 'sys_oper_type', '清空数据', '9', 9, 0, '清空操作', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (28, 'sys_common_status', '成功', '0', 1, 0, '正常状态', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
INSERT INTO `sys_dictionary_data` VALUES (29, 'sys_common_status', '失败', '1', 2, 0, '停用状态', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:21:21');
COMMIT;

-- ----------------------------
-- Table structure for sys_dictionary_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary_type`;
CREATE TABLE `sys_dictionary_type` (
                                       `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
                                       `code` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '字典代码',
                                       `name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '字典名称',
                                       `remark` varchar(500) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '备注',
                                       `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态（0：正常；1：停用）',
                                       `create_by` int(11) NOT NULL DEFAULT '0' COMMENT '创建者',
                                       `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                       `update_by` int(11) NOT NULL DEFAULT '0' COMMENT '更新者',
                                       `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                                       PRIMARY KEY (`id`) USING BTREE,
                                       UNIQUE KEY `dict_type` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='字典类型表';

-- ----------------------------
-- Records of sys_dictionary_type
-- ----------------------------
BEGIN;
INSERT INTO `sys_dictionary_type` VALUES (1, 'sys_user_sex', '用户性别', '用户性别列表', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:16:24');
INSERT INTO `sys_dictionary_type` VALUES (2, 'sys_show_hide', '菜单状态', '菜单状态列表', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:16:24');
INSERT INTO `sys_dictionary_type` VALUES (3, 'sys_normal_disable', '系统开关', '系统开关列表', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:16:24');
INSERT INTO `sys_dictionary_type` VALUES (4, 'sys_job_status', '任务状态', '任务状态列表', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:16:24');
INSERT INTO `sys_dictionary_type` VALUES (5, 'sys_job_group', '任务分组', '任务分组列表', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:16:24');
INSERT INTO `sys_dictionary_type` VALUES (6, 'sys_yes_no', '系统是否', '系统是否列表', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:16:24');
INSERT INTO `sys_dictionary_type` VALUES (7, 'sys_notice_type', '通知类型', '通知类型列表', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:16:24');
INSERT INTO `sys_dictionary_type` VALUES (8, 'sys_notice_status', '通知状态', '通知状态列表', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:16:24');
INSERT INTO `sys_dictionary_type` VALUES (9, 'sys_oper_type', '操作类型', '操作类型列表', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:16:24');
INSERT INTO `sys_dictionary_type` VALUES (10, 'sys_common_status', '系统状态', '登录状态列表', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:16:24');
COMMIT;

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job` (
                           `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
                           `group` varchar(64) COLLATE utf8mb4_bin NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
                           `name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '任务名称',
                           `invoke_target` varchar(500) COLLATE utf8mb4_bin NOT NULL COMMENT '调用目标字符串',
                           `cron_expression` varchar(500) COLLATE utf8mb4_bin NOT NULL COMMENT 'cron执行表达式',
                           `misfire_policy` int(11) NOT NULL DEFAULT '0' COMMENT '计划执行错误策略（0：放弃执行；1：立即执行；2：执行一次；）',
                           `concurrent` int(11) NOT NULL DEFAULT '0' COMMENT '是否并发执行（0：禁止；1：允许）',
                           `remark` varchar(500) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '备注信息',
                           `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态（0：正常；1：暂停）',
                           `create_by` int(11) NOT NULL DEFAULT '0' COMMENT '创建者ID',
                           `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `update_by` int(11) NOT NULL DEFAULT '0' COMMENT '更新者ID',
                           `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='定时任务调度表';

-- ----------------------------
-- Records of sys_job
-- ----------------------------
BEGIN;
INSERT INTO `sys_job` VALUES (1, 'DEFAULT', '系统默认（无参）', 'ryTask.ryNoParams', '0/10 * * * * ?', 3, 1, '', 1, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:44:55');
INSERT INTO `sys_job` VALUES (2, 'DEFAULT', '系统默认（有参）', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', 3, 1, '', 1, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:44:55');
INSERT INTO `sys_job` VALUES (3, 'DEFAULT', '系统默认（多参）', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', 3, 1, '', 1, 1, '2022-01-25 16:27:27', 1, '2022-01-30 12:44:55');
COMMIT;

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log` (
                               `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
                               `group` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '任务组名',
                               `name` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '任务名称',
                               `invoke_target` varchar(500) COLLATE utf8mb4_bin NOT NULL COMMENT '调用目标字符串',
                               `job_message` varchar(500) COLLATE utf8mb4_bin NOT NULL COMMENT '日志信息',
                               `status` int(11) NOT NULL DEFAULT '0' COMMENT '执行状态（0：正常；1：失败）',
                               `exception_info` varchar(2000) COLLATE utf8mb4_bin NOT NULL COMMENT '异常信息',
                               `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='定时任务调度日志表';

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
                            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
                            `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父菜单ID',
                            `type` int(11) NOT NULL DEFAULT '0' COMMENT '菜单类型（0：目录；1：菜单；2：按钮）',
                            `name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '菜单名称',
                            `order_num` int(11) NOT NULL DEFAULT '0' COMMENT '显示顺序',
                            `url` varchar(200) COLLATE utf8mb4_bin NOT NULL DEFAULT '#' COMMENT '请求地址',
                            `target` int(11) NOT NULL DEFAULT '0' COMMENT '打开方式（0：默认打开；1：打开页标签；2：打开新窗口）',
                            `visible` int(11) NOT NULL DEFAULT '0' COMMENT '菜单状态（0：显示；1：隐藏）',
                            `is_refresh` int(11) NOT NULL DEFAULT '0' COMMENT '是否刷新（0：刷新；1：不刷新）',
                            `perms` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '权限标识',
                            `icon` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '菜单图标',
                            `remark` varchar(500) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '备注',
                            `create_by` int(11) NOT NULL DEFAULT '0' COMMENT '创建者ID',
                            `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_by` int(11) NOT NULL DEFAULT '0' COMMENT '更新者ID',
                            `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1062 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES (1, 0, 0, '系统管理', 1, '#', 0, 0, 1, '', 'fa fa-gear', '系统管理目录', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (2, 0, 0, '系统监控', 2, '#', 0, 0, 1, '', 'fa fa-video-camera', '系统监控目录', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (3, 0, 0, '系统工具', 3, '#', 0, 0, 1, '', 'fa fa-bars', '系统工具目录', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (4, 0, 1, '若依官网', 4, 'http://ruoyi.vip', 2, 0, 1, '', 'fa fa-location-arrow', '若依官网地址', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (100, 1, 1, '用户管理', 1, '/system/user', 0, 0, 1, 'system:user:view', 'fa fa-user-o', '用户管理菜单', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (101, 1, 1, '角色管理', 2, '/system/role', 0, 0, 1, 'system:role:view', 'fa fa-user-secret', '角色管理菜单', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (102, 1, 1, '菜单管理', 3, '/system/menu', 0, 0, 1, 'system:menu:view', 'fa fa-th-list', '菜单管理菜单', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (103, 1, 1, '部门管理', 4, '/system/dept', 0, 0, 1, 'system:dept:view', 'fa fa-outdent', '部门管理菜单', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (104, 1, 1, '岗位管理', 5, '/system/post', 0, 0, 1, 'system:post:view', 'fa fa-address-card-o', '岗位管理菜单', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (105, 1, 1, '字典管理', 6, '/system/dict', 0, 0, 1, 'system:dict:view', 'fa fa-bookmark-o', '字典管理菜单', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (106, 1, 1, '参数设置', 7, '/system/config', 0, 0, 1, 'system:config:view', 'fa fa-sun-o', '参数设置菜单', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (107, 1, 1, '通知公告', 8, '/system/notice', 0, 0, 1, 'system:notice:view', 'fa fa-bullhorn', '通知公告菜单', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (108, 1, 0, '日志管理', 9, '#', 0, 0, 1, '', 'fa fa-pencil-square-o', '日志管理菜单', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (109, 2, 1, '在线用户', 1, '/monitor/online', 0, 0, 1, 'monitor:online:view', 'fa fa-user-circle', '在线用户菜单', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (110, 2, 1, '定时任务', 2, '/monitor/job', 0, 0, 1, 'monitor:job:view', 'fa fa-tasks', '定时任务菜单', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (111, 2, 1, '数据监控', 3, '/monitor/data', 0, 0, 1, 'monitor:data:view', 'fa fa-bug', '数据监控菜单', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (112, 2, 1, '服务监控', 4, '/monitor/server', 0, 0, 1, 'monitor:server:view', 'fa fa-server', '服务监控菜单', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (113, 2, 1, '缓存监控', 5, '/monitor/cache', 0, 0, 1, 'monitor:cache:view', 'fa fa-cube', '缓存监控菜单', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (114, 3, 1, '表单构建', 1, '/tool/build', 0, 0, 1, 'tool:build:view', 'fa fa-wpforms', '表单构建菜单', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (115, 3, 1, '代码生成', 2, '/tool/gen', 0, 0, 1, 'tool:gen:view', 'fa fa-code', '代码生成菜单', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (116, 3, 1, '系统接口', 3, '/tool/swagger', 0, 0, 1, 'tool:swagger:view', 'fa fa-gg', '系统接口菜单', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (500, 108, 1, '操作日志', 1, '/monitor/operlog', 0, 0, 1, 'monitor:operlog:view', 'fa fa-address-book', '操作日志菜单', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (501, 108, 1, '登录日志', 2, '/monitor/logininfor', 0, 0, 1, 'monitor:logininfor:view', 'fa fa-file-image-o', '登录日志菜单', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1000, 100, 2, '用户查询', 1, '#', 0, 0, 1, 'system:user:list', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1001, 100, 2, '用户新增', 2, '#', 0, 0, 1, 'system:user:add', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1002, 100, 2, '用户修改', 3, '#', 0, 0, 1, 'system:user:edit', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1003, 100, 2, '用户删除', 4, '#', 0, 0, 1, 'system:user:remove', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1004, 100, 2, '用户导出', 5, '#', 0, 0, 1, 'system:user:export', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1005, 100, 2, '用户导入', 6, '#', 0, 0, 1, 'system:user:import', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1006, 100, 2, '重置密码', 7, '#', 0, 0, 1, 'system:user:resetPwd', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1007, 101, 2, '角色查询', 1, '#', 0, 0, 1, 'system:role:list', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1008, 101, 2, '角色新增', 2, '#', 0, 0, 1, 'system:role:add', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1009, 101, 2, '角色修改', 3, '#', 0, 0, 1, 'system:role:edit', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1010, 101, 2, '角色删除', 4, '#', 0, 0, 1, 'system:role:remove', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1011, 101, 2, '角色导出', 5, '#', 0, 0, 1, 'system:role:export', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1012, 102, 2, '菜单查询', 1, '#', 0, 0, 1, 'system:menu:list', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1013, 102, 2, '菜单新增', 2, '#', 0, 0, 1, 'system:menu:add', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1014, 102, 2, '菜单修改', 3, '#', 0, 0, 1, 'system:menu:edit', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1015, 102, 2, '菜单删除', 4, '#', 0, 0, 1, 'system:menu:remove', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1016, 103, 2, '部门查询', 1, '#', 0, 0, 1, 'system:dept:list', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1017, 103, 2, '部门新增', 2, '#', 0, 0, 1, 'system:dept:add', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1018, 103, 2, '部门修改', 3, '#', 0, 0, 1, 'system:dept:edit', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1019, 103, 2, '部门删除', 4, '#', 0, 0, 1, 'system:dept:remove', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1020, 104, 2, '岗位查询', 1, '#', 0, 0, 1, 'system:post:list', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1021, 104, 2, '岗位新增', 2, '#', 0, 0, 1, 'system:post:add', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1022, 104, 2, '岗位修改', 3, '#', 0, 0, 1, 'system:post:edit', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1023, 104, 2, '岗位删除', 4, '#', 0, 0, 1, 'system:post:remove', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1024, 104, 2, '岗位导出', 5, '#', 0, 0, 1, 'system:post:export', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1025, 105, 2, '字典查询', 1, '#', 0, 0, 1, 'system:dict:list', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1026, 105, 2, '字典新增', 2, '#', 0, 0, 1, 'system:dict:add', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1027, 105, 2, '字典修改', 3, '#', 0, 0, 1, 'system:dict:edit', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1028, 105, 2, '字典删除', 4, '#', 0, 0, 1, 'system:dict:remove', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1029, 105, 2, '字典导出', 5, '#', 0, 0, 1, 'system:dict:export', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1030, 106, 2, '参数查询', 1, '#', 0, 0, 1, 'system:config:list', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1031, 106, 2, '参数新增', 2, '#', 0, 0, 1, 'system:config:add', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1032, 106, 2, '参数修改', 3, '#', 0, 0, 1, 'system:config:edit', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1033, 106, 2, '参数删除', 4, '#', 0, 0, 1, 'system:config:remove', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1034, 106, 2, '参数导出', 5, '#', 0, 0, 1, 'system:config:export', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1035, 107, 2, '公告查询', 1, '#', 0, 0, 1, 'system:notice:list', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1036, 107, 2, '公告新增', 2, '#', 0, 0, 1, 'system:notice:add', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1037, 107, 2, '公告修改', 3, '#', 0, 0, 1, 'system:notice:edit', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1038, 107, 2, '公告删除', 4, '#', 0, 0, 1, 'system:notice:remove', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1039, 500, 2, '操作查询', 1, '#', 0, 0, 1, 'monitor:operlog:list', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1040, 500, 2, '操作删除', 2, '#', 0, 0, 1, 'monitor:operlog:remove', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1041, 500, 2, '详细信息', 3, '#', 0, 0, 1, 'monitor:operlog:detail', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1042, 500, 2, '日志导出', 4, '#', 0, 0, 1, 'monitor:operlog:export', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1043, 501, 2, '登录查询', 1, '#', 0, 0, 1, 'monitor:logininfor:list', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1044, 501, 2, '登录删除', 2, '#', 0, 0, 1, 'monitor:logininfor:remove', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1045, 501, 2, '日志导出', 3, '#', 0, 0, 1, 'monitor:logininfor:export', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1046, 501, 2, '账户解锁', 4, '#', 0, 0, 1, 'monitor:logininfor:unlock', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1047, 109, 2, '在线查询', 1, '#', 0, 0, 1, 'monitor:online:list', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1048, 109, 2, '批量强退', 2, '#', 0, 0, 1, 'monitor:online:batchForceLogout', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1049, 109, 2, '单条强退', 3, '#', 0, 0, 1, 'monitor:online:forceLogout', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1050, 110, 2, '任务查询', 1, '#', 0, 0, 1, 'monitor:job:list', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1051, 110, 2, '任务新增', 2, '#', 0, 0, 1, 'monitor:job:add', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1052, 110, 2, '任务修改', 3, '#', 0, 0, 1, 'monitor:job:edit', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1053, 110, 2, '任务删除', 4, '#', 0, 0, 1, 'monitor:job:remove', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1054, 110, 2, '状态修改', 5, '#', 0, 0, 1, 'monitor:job:changeStatus', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1055, 110, 2, '任务详细', 6, '#', 0, 0, 1, 'monitor:job:detail', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1056, 110, 2, '任务导出', 7, '#', 0, 0, 1, 'monitor:job:export', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1057, 115, 2, '生成查询', 1, '#', 0, 0, 1, 'tool:gen:list', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1058, 115, 2, '生成修改', 2, '#', 0, 0, 1, 'tool:gen:edit', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1059, 115, 2, '生成删除', 3, '#', 0, 0, 1, 'tool:gen:remove', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1060, 115, 2, '预览代码', 4, '#', 0, 0, 1, 'tool:gen:preview', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
INSERT INTO `sys_menu` VALUES (1061, 115, 2, '生成代码', 5, '#', 0, 0, 1, 'tool:gen:code', '#', '', 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:01:49');
COMMIT;

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
                              `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
                              `type` int(11) NOT NULL COMMENT '公告类型（0：通知 ；1：公告）',
                              `title` varchar(200) COLLATE utf8mb4_bin NOT NULL COMMENT '公告标题',
                              `content` varchar(2000) COLLATE utf8mb4_bin NOT NULL COMMENT '公告内容',
                              `status` int(11) NOT NULL DEFAULT '0' COMMENT '公告状态（0：正常；1：关闭）',
                              `remark` varchar(255) COLLATE utf8mb4_bin NOT NULL COMMENT '备注',
                              `create_by` int(11) NOT NULL DEFAULT '0' COMMENT '创建者ID',
                              `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `update_by` int(11) NOT NULL DEFAULT '0' COMMENT '更新者ID',
                              `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='通知公告表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_operation_log`;
CREATE TABLE `sys_operation_log` (
                                     `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
                                     `title` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '模块标题',
                                     `business_type` int(11) NOT NULL DEFAULT '0' COMMENT '业务类型（0：其它；1：新增；2：修改；3：删除）',
                                     `method` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '方法名称',
                                     `request_method` varchar(10) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '请求方式',
                                     `operator_type` int(1) NOT NULL DEFAULT '0' COMMENT '操作对象类别（0：其它；1：后台用户；2：手机端用户）',
                                     `operator_name` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '操作人员',
                                     `department_name` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '部门名称',
                                     `url` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '请求URL',
                                     `ip` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '主机地址',
                                     `location` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '操作地点',
                                     `param` varchar(2000) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '请求参数',
                                     `result` varchar(2000) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '返回参数',
                                     `status` int(11) NOT NULL DEFAULT '0' COMMENT '操作状态（0：正常；1：异常）',
                                     `error_msg` varchar(2000) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '错误消息',
                                     `operation_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='操作日志记录';

-- ----------------------------
-- Records of sys_operation_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `sys_persistent_logins`;
CREATE TABLE `sys_persistent_logins` (
                                         `username` varchar(64) COLLATE utf8mb4_bin NOT NULL,
                                         `series` varchar(64) COLLATE utf8mb4_bin NOT NULL,
                                         `token` varchar(64) COLLATE utf8mb4_bin NOT NULL,
                                         `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                         PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='登录持久化表';

-- ----------------------------
-- Records of sys_persistent_logins
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for sys_position
-- ----------------------------
DROP TABLE IF EXISTS `sys_position`;
CREATE TABLE `sys_position` (
                                `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
                                `code` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '岗位编码',
                                `name` varchar(50) COLLATE utf8mb4_bin NOT NULL COMMENT '岗位名称',
                                `sort_num` int(4) NOT NULL COMMENT '显示顺序',
                                `remark` varchar(500) COLLATE utf8mb4_bin NOT NULL COMMENT '备注',
                                `status` int(11) NOT NULL COMMENT '状态（0：正常；1：停用）',
                                `create_by` int(11) NOT NULL DEFAULT '0' COMMENT '创建者ID',
                                `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `update_by` int(11) NOT NULL DEFAULT '0' COMMENT '更新者ID',
                                `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='岗位信息表';

-- ----------------------------
-- Records of sys_position
-- ----------------------------
BEGIN;
INSERT INTO `sys_position` VALUES (1, 'ceo', '董事长', 1, '', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:12:59');
INSERT INTO `sys_position` VALUES (2, 'se', '项目经理', 2, '', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:13:02');
INSERT INTO `sys_position` VALUES (3, 'hr', '人力资源', 3, '', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:13:06');
INSERT INTO `sys_position` VALUES (4, 'user', '普通员工', 4, '', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:13:09');
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
                            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
                            `key` varchar(100) COLLATE utf8mb4_bin NOT NULL COMMENT '角色权限字符串',
                            `name` varchar(30) COLLATE utf8mb4_bin NOT NULL COMMENT '角色名称',
                            `sort_num` int(11) NOT NULL COMMENT '显示顺序',
                            `data_scope` int(11) NOT NULL DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
                            `del_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标志（0：存在；1：删除）',
                            `remark` varchar(500) COLLATE utf8mb4_bin NOT NULL COMMENT '备注',
                            `status` int(11) NOT NULL COMMENT '角色状态（0：正常；1：停用）',
                            `create_by` int(11) NOT NULL DEFAULT '0' COMMENT '创建者ID',
                            `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_by` int(11) NOT NULL DEFAULT '0' COMMENT '更新者ID',
                            `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色信息表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, 'admin', '超级管理员', 1, 1, 0, '超级管理员', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:17:10');
INSERT INTO `sys_role` VALUES (2, 'common', '普通角色', 2, 2, 0, '普通角色', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:17:13');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_department`;
CREATE TABLE `sys_role_department` (
                                       `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                       `role_id` int(11) NOT NULL COMMENT '角色ID',
                                       `department_id` int(11) NOT NULL COMMENT '部门ID',
                                       PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色和部门关联表';

-- ----------------------------
-- Records of sys_role_department
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_department` VALUES (1, 2, 100);
INSERT INTO `sys_role_department` VALUES (2, 2, 101);
INSERT INTO `sys_role_department` VALUES (3, 2, 105);
COMMIT;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                 `role_id` int(11) NOT NULL COMMENT '角色ID',
                                 `menu_id` int(11) NOT NULL COMMENT '菜单ID',
                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_menu` VALUES (1, 2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2, 2);
INSERT INTO `sys_role_menu` VALUES (3, 2, 3);
INSERT INTO `sys_role_menu` VALUES (4, 2, 4);
INSERT INTO `sys_role_menu` VALUES (5, 2, 100);
INSERT INTO `sys_role_menu` VALUES (6, 2, 101);
INSERT INTO `sys_role_menu` VALUES (7, 2, 102);
INSERT INTO `sys_role_menu` VALUES (8, 2, 103);
INSERT INTO `sys_role_menu` VALUES (9, 2, 104);
INSERT INTO `sys_role_menu` VALUES (10, 2, 105);
INSERT INTO `sys_role_menu` VALUES (11, 2, 106);
INSERT INTO `sys_role_menu` VALUES (12, 2, 107);
INSERT INTO `sys_role_menu` VALUES (13, 2, 108);
INSERT INTO `sys_role_menu` VALUES (14, 2, 109);
INSERT INTO `sys_role_menu` VALUES (15, 2, 110);
INSERT INTO `sys_role_menu` VALUES (16, 2, 111);
INSERT INTO `sys_role_menu` VALUES (17, 2, 112);
INSERT INTO `sys_role_menu` VALUES (18, 2, 113);
INSERT INTO `sys_role_menu` VALUES (19, 2, 114);
INSERT INTO `sys_role_menu` VALUES (20, 2, 115);
INSERT INTO `sys_role_menu` VALUES (21, 2, 116);
INSERT INTO `sys_role_menu` VALUES (22, 2, 500);
INSERT INTO `sys_role_menu` VALUES (23, 2, 501);
INSERT INTO `sys_role_menu` VALUES (24, 2, 1000);
INSERT INTO `sys_role_menu` VALUES (25, 2, 1001);
INSERT INTO `sys_role_menu` VALUES (26, 2, 1002);
INSERT INTO `sys_role_menu` VALUES (27, 2, 1003);
INSERT INTO `sys_role_menu` VALUES (28, 2, 1004);
INSERT INTO `sys_role_menu` VALUES (29, 2, 1005);
INSERT INTO `sys_role_menu` VALUES (30, 2, 1006);
INSERT INTO `sys_role_menu` VALUES (31, 2, 1007);
INSERT INTO `sys_role_menu` VALUES (32, 2, 1008);
INSERT INTO `sys_role_menu` VALUES (33, 2, 1009);
INSERT INTO `sys_role_menu` VALUES (34, 2, 1010);
INSERT INTO `sys_role_menu` VALUES (35, 2, 1011);
INSERT INTO `sys_role_menu` VALUES (36, 2, 1012);
INSERT INTO `sys_role_menu` VALUES (37, 2, 1013);
INSERT INTO `sys_role_menu` VALUES (38, 2, 1014);
INSERT INTO `sys_role_menu` VALUES (39, 2, 1015);
INSERT INTO `sys_role_menu` VALUES (40, 2, 1016);
INSERT INTO `sys_role_menu` VALUES (41, 2, 1017);
INSERT INTO `sys_role_menu` VALUES (42, 2, 1018);
INSERT INTO `sys_role_menu` VALUES (43, 2, 1019);
INSERT INTO `sys_role_menu` VALUES (44, 2, 1020);
INSERT INTO `sys_role_menu` VALUES (45, 2, 1021);
INSERT INTO `sys_role_menu` VALUES (46, 2, 1022);
INSERT INTO `sys_role_menu` VALUES (47, 2, 1023);
INSERT INTO `sys_role_menu` VALUES (48, 2, 1024);
INSERT INTO `sys_role_menu` VALUES (49, 2, 1025);
INSERT INTO `sys_role_menu` VALUES (50, 2, 1026);
INSERT INTO `sys_role_menu` VALUES (51, 2, 1027);
INSERT INTO `sys_role_menu` VALUES (52, 2, 1028);
INSERT INTO `sys_role_menu` VALUES (53, 2, 1029);
INSERT INTO `sys_role_menu` VALUES (54, 2, 1030);
INSERT INTO `sys_role_menu` VALUES (55, 2, 1031);
INSERT INTO `sys_role_menu` VALUES (56, 2, 1032);
INSERT INTO `sys_role_menu` VALUES (57, 2, 1033);
INSERT INTO `sys_role_menu` VALUES (58, 2, 1034);
INSERT INTO `sys_role_menu` VALUES (59, 2, 1035);
INSERT INTO `sys_role_menu` VALUES (60, 2, 1036);
INSERT INTO `sys_role_menu` VALUES (61, 2, 1037);
INSERT INTO `sys_role_menu` VALUES (62, 2, 1038);
INSERT INTO `sys_role_menu` VALUES (63, 2, 1039);
INSERT INTO `sys_role_menu` VALUES (64, 2, 1040);
INSERT INTO `sys_role_menu` VALUES (65, 2, 1041);
INSERT INTO `sys_role_menu` VALUES (66, 2, 1042);
INSERT INTO `sys_role_menu` VALUES (67, 2, 1043);
INSERT INTO `sys_role_menu` VALUES (68, 2, 1044);
INSERT INTO `sys_role_menu` VALUES (69, 2, 1045);
INSERT INTO `sys_role_menu` VALUES (70, 2, 1046);
INSERT INTO `sys_role_menu` VALUES (71, 2, 1047);
INSERT INTO `sys_role_menu` VALUES (72, 2, 1048);
INSERT INTO `sys_role_menu` VALUES (73, 2, 1049);
INSERT INTO `sys_role_menu` VALUES (74, 2, 1050);
INSERT INTO `sys_role_menu` VALUES (75, 2, 1051);
INSERT INTO `sys_role_menu` VALUES (76, 2, 1052);
INSERT INTO `sys_role_menu` VALUES (77, 2, 1053);
INSERT INTO `sys_role_menu` VALUES (78, 2, 1054);
INSERT INTO `sys_role_menu` VALUES (79, 2, 1055);
INSERT INTO `sys_role_menu` VALUES (80, 2, 1056);
INSERT INTO `sys_role_menu` VALUES (81, 2, 1057);
INSERT INTO `sys_role_menu` VALUES (82, 2, 1058);
INSERT INTO `sys_role_menu` VALUES (83, 2, 1059);
INSERT INTO `sys_role_menu` VALUES (84, 2, 1060);
INSERT INTO `sys_role_menu` VALUES (85, 2, 1061);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
                            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                            `department_id` int(11) NOT NULL COMMENT '部门ID',
                            `type` int(11) NOT NULL DEFAULT '0' COMMENT '用户类型（0：系统用户；1：注册用户）',
                            `login_name` varchar(30) COLLATE utf8mb4_bin NOT NULL COMMENT '登录账号',
                            `user_name` varchar(30) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '用户昵称',
                            `email` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '用户邮箱',
                            `phone` varchar(11) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '手机号码',
                            `sex` int(11) NOT NULL DEFAULT '0' COMMENT '用户性别（0：男；1：女；2：未知）',
                            `avatar` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '头像',
                            `password` varchar(50) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '密码',
                            `salt` varchar(20) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '盐加密',
                            `del_flag` int(11) NOT NULL DEFAULT '0' COMMENT '删除标志（0：存在；1：删除）',
                            `login_ip` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '最后登录IP',
                            `login_date` datetime NOT NULL COMMENT '最后登录时间',
                            `pwd_update_date` datetime NOT NULL COMMENT '密码最后更新时间',
                            `remark` varchar(500) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '备注',
                            `status` int(11) NOT NULL DEFAULT '0' COMMENT '帐号状态（0：正常；1：停用）',
                            `create_by` int(11) NOT NULL DEFAULT '0' COMMENT '创建者ID',
                            `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_by` int(11) NOT NULL DEFAULT '0' COMMENT '更新者ID',
                            `update_time` datetime NOT NULL COMMENT '更新时间',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 103, 0, 'admin', '若依', 'ry@163.com', '15888888888', 1, '', '29c67a30398638269fe600f73a054934', '111111', 0, '127.0.0.1', '2022-01-25 16:27:27', '2022-01-25 16:27:27', '管理员', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:23:00');
INSERT INTO `sys_user` VALUES (2, 105, 0, 'ry', '若依', 'ry@qq.com', '15666666666', 1, '', '8e6d98b90472783cc73c17047ddccf36', '222222', 0, '127.0.0.1', '2022-01-25 16:27:27', '2022-01-25 16:27:27', '测试员', 0, 1, '2022-01-25 16:27:27', 1, '2022-01-30 13:23:03');
COMMIT;

-- ----------------------------
-- Table structure for sys_user_position
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_position`;
CREATE TABLE `sys_user_position` (
                                     `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                     `user_id` int(11) NOT NULL COMMENT '用户ID',
                                     `postion_id` int(11) NOT NULL COMMENT '岗位ID',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户与岗位关联表';

-- ----------------------------
-- Records of sys_user_position
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_position` VALUES (1, 1, 1);
INSERT INTO `sys_user_position` VALUES (2, 2, 2);
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                 `user_id` int(11) NOT NULL COMMENT '用户ID',
                                 `role_id` int(11) NOT NULL COMMENT '角色ID',
                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES (1, 1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2, 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
