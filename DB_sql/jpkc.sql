/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : jpkc

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2016-10-05 17:18:30
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` varchar(30) NOT NULL,
  `course_name` varchar(30) NOT NULL,
  `course_parent_id` varchar(30) DEFAULT NULL,
  `course_add_time` datetime NOT NULL,
  `course_update_time` datetime NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1609032328561463430094744', '第一章 职业教育师范技能导论', '', '2016-09-03 23:28:56', '2016-09-03 23:28:56');
INSERT INTO `course` VALUES ('1609032329024414038704677', '第二章 课堂教学技能训练', '', '2016-09-03 23:29:02', '2016-09-03 23:29:02');
INSERT INTO `course` VALUES ('1609032329113770895767119', '第三章 信息化教学技能训练', '', '2016-09-03 23:29:11', '2016-09-03 23:29:11');
INSERT INTO `course` VALUES ('1609032329186526790450679', '第四章 行动导向教学训练', '', '2016-09-03 23:29:19', '2016-09-03 23:29:19');
INSERT INTO `course` VALUES ('1609032329247519977586013', '第五章 综合训练', '', '2016-09-03 23:29:25', '2016-09-03 23:29:25');
INSERT INTO `course` VALUES ('1609032329404095427579225', '第一节 导入技能', '1609032329024414038704677', '2016-09-03 23:29:40', '2016-09-03 23:29:40');
INSERT INTO `course` VALUES ('1609032330181185030132085', '第二节 提问技能', '1609032329024414038704677', '2016-09-03 23:30:18', '2016-09-03 23:30:18');
INSERT INTO `course` VALUES ('1609032330181198767956911', '第三节 语言技能', '1609032329024414038704677', '2016-09-03 23:30:18', '2016-09-03 23:30:18');
INSERT INTO `course` VALUES ('1609032330181201636650298', '第四节 讲授技能', '1609032329024414038704677', '2016-09-03 23:30:18', '2016-09-03 23:30:18');
INSERT INTO `course` VALUES ('1609032330565210215733343', '第五节 板书技能', '1609032329024414038704677', '2016-09-03 23:30:57', '2016-09-03 23:30:57');
INSERT INTO `course` VALUES ('1609032330565227783453664', '第六节 组织技能', '1609032329024414038704677', '2016-09-03 23:30:57', '2016-09-03 23:30:57');
INSERT INTO `course` VALUES ('1609032330565231603288096', '第七节 强化技能', '1609032329024414038704677', '2016-09-03 23:30:57', '2016-09-03 23:30:57');
INSERT INTO `course` VALUES ('1609032330565249897385409', '第八节 结束技能', '1609032329024414038704677', '2016-09-03 23:30:57', '2016-09-03 23:30:57');
INSERT INTO `course` VALUES ('1609032331166390354889519', '第一节 教学课件设计与制作', '1609032329113770895767119', '2016-09-03 23:31:17', '2016-09-03 23:31:17');
INSERT INTO `course` VALUES ('1609032331166409457790041', '第二节 微课设计与制作', '1609032329113770895767119', '2016-09-03 23:31:17', '2016-09-03 23:31:17');
INSERT INTO `course` VALUES ('1609032331166418921710228', '第三节 多媒体素材采集与处理', '1609032329113770895767119', '2016-09-03 23:31:17', '2016-09-03 23:31:17');
INSERT INTO `course` VALUES ('1609032332066462197480247', '第一节 项目教学法', '1609032329186526790450679', '2016-09-03 23:32:07', '2016-09-03 23:32:07');
INSERT INTO `course` VALUES ('1609032332066478624377658', '第二节 案例教学法', '1609032329186526790450679', '2016-09-03 23:32:07', '2016-09-03 23:32:07');
INSERT INTO `course` VALUES ('1609032332066485625210269', '第三节 引导文教学法', '1609032329186526790450679', '2016-09-03 23:32:07', '2016-09-03 23:32:07');
INSERT INTO `course` VALUES ('1609032332066492666651926', '第四节 任务驱动', '1609032329186526790450679', '2016-09-03 23:32:07', '2016-09-03 23:32:07');
INSERT INTO `course` VALUES ('1609032332066505539476926', '第五节 角色扮演', '1609032329186526790450679', '2016-09-03 23:32:07', '2016-09-03 23:32:07');
INSERT INTO `course` VALUES ('1609032332066515913934081', '第六节 头脑风暴', '1609032329186526790450679', '2016-09-03 23:32:07', '2016-09-03 23:32:07');
INSERT INTO `course` VALUES ('1609032332278894713006629', '第一节 个人教学训练微课', '1609032329247519977586013', '2016-09-03 23:32:28', '2016-09-03 23:32:28');
INSERT INTO `course` VALUES ('1609032332278909594745509', '第二节 小组集体汇报', '1609032329247519977586013', '2016-09-03 23:32:28', '2016-09-03 23:32:28');
INSERT INTO `course` VALUES ('1609091643463778230487490', '第一节 职业教育课程改革与目标', '1609032328561463430094744', '2016-09-09 16:43:46', '2016-09-09 16:43:46');
INSERT INTO `course` VALUES ('1609091643589234126056316', '第二节 职业教育师范技能训练方法发展', '1609032328561463430094744', '2016-09-09 16:43:59', '2016-09-09 16:43:59');

-- ----------------------------
-- Table structure for `course_info`
-- ----------------------------
DROP TABLE IF EXISTS `course_info`;
CREATE TABLE `course_info` (
  `course_id` varchar(30) NOT NULL,
  `video_mp4` varchar(300) NOT NULL,
  `video_flv` varchar(300) DEFAULT NULL,
  `star_score` double(8,2) DEFAULT NULL,
  `doc_1` varchar(300) DEFAULT NULL,
  `doc_2` varchar(300) DEFAULT NULL,
  `doc_3` varchar(300) DEFAULT NULL,
  `doc_4` varchar(300) DEFAULT NULL,
  `doc_5` varchar(300) DEFAULT NULL,
  `doc_6` varchar(300) DEFAULT NULL,
  `doc_7` varchar(300) DEFAULT NULL,
  `doc_8` varchar(300) DEFAULT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_info
-- ----------------------------
INSERT INTO `course_info` VALUES ('1609032329332864655731643', 'http://localhost/jpkc/ue/jsp/upload/20160904/98391472982982283.mp4', null, '5.00', '1', null, null, null, null, null, null, null, '2016-09-04 17:56:26');
INSERT INTO `course_info` VALUES ('1609032329404095427579225', 'http://localhost/jpkc/ue/jsp/upload/20160904/67701472985756032.mp4', null, '5.00', null, null, null, null, null, null, null, null, '2016-09-04 18:42:49');

-- ----------------------------
-- Table structure for `star`
-- ----------------------------
DROP TABLE IF EXISTS `star`;
CREATE TABLE `star` (
  `star_id` varchar(30) NOT NULL,
  `course_id` varchar(30) NOT NULL,
  `star_score` int(11) NOT NULL,
  `star_time` datetime NOT NULL,
  `device_info` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`star_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of star
-- ----------------------------
