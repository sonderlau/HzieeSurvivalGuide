/*
 Navicat Premium Data Transfer

 Source Server         : localMySQL
 Source Server Type    : MySQL
 Source Server Version : 50643
 Source Host           : localhost:3306
 Source Schema         : homeworkmanager

 Target Server Type    : MySQL
 Target Server Version : 50643
 File Encoding         : 65001

 Date: 07/06/2020 17:24:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for achievements
-- ----------------------------
DROP TABLE IF EXISTS `achievements`;
CREATE TABLE `achievements`  (
  `Homework_ID` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Student_ID` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Serial_Number` decimal(4, 0) NULL DEFAULT NULL,
  `Comment` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `Revised_Score` decimal(4, 1) NULL DEFAULT 0.0,
  PRIMARY KEY (`Homework_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `Lesson_ID` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '对应的课程ID',
  `ID` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'UUID',
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名字 不能重复',
  `teacher` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '这个班的老师ID',
  `creator` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `father` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '父层级班级ID',
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('0582ceb8-4725-49db-ba68-0d64786cb953', 'd34ca632-90d5-43de-88b9-3facc7a0ae14', '2019-2020-1', '1', 'sonderlau', '0');
INSERT INTO `class` VALUES ('0582ceb8-4725-49db-ba68-0d64786cb953', 'f5d03efc-1260-4eb3-b649-543985450444', '实验班', '1', 'sonderlau', '0');
INSERT INTO `class` VALUES ('0582ceb8-4725-49db-ba68-0d64786cb953', 'c7803802-f8ff-4f0d-a3c3-71efc7bb159c', '教学班1', '1', 'sonderlau', 'd34ca632-90d5-43de-88b9-3facc7a0ae14');

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework`  (
  `LessonID` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '哪门课的作业',
  `ID` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '唯一标识符',
  `Brief_Description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `Requirements` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `Need_For_Review` decimal(1, 0) NULL DEFAULT 1,
  `Arrange_For` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Start_Time` datetime(0) NOT NULL,
  `End_Time` datetime(0) NOT NULL,
  `Overdue_Time` datetime(0) NULL DEFAULT NULL,
  `Question_List` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of homework
-- ----------------------------
INSERT INTO `homework` VALUES ('0582ceb8-4725-49db-ba68-0d64786cb953', '1bd32839-ed4c-410f-a073-13d661c4228c', 'amskldgfkj', 'asijdgioasdjgio', 1, 'd34ca632-90d5-43de-88b9-3facc7a0ae14', '2020-05-30 20:35:00', '2020-05-30 22:33:00', NULL, '{\"QuestionList\":[\"14e0e32c-575f-4651-b03b-614596145725 \",\"43055fcd-5dd2-44b3-aa86-c49efdf9bca1 \",\"5cb5da53-dcd0-4cc1-ad6e-082f4338bd01 \",\"938ad670-a2a5-4093-aded-071bb56183fb \"]}');
INSERT INTO `homework` VALUES ('0582ceb8-4725-49db-ba68-0d64786cb953', '32147a10-603d-4b58-b342-5fe1ab09bc67', 'asasdf', 'asdfasdf', 0, 'd34ca632-90d5-43de-88b9-3facc7a0ae14', '2020-06-02 02:52:00', '2020-06-02 04:56:00', NULL, '{\"QuestionList\":[]}');
INSERT INTO `homework` VALUES ('0582ceb8-4725-49db-ba68-0d64786cb953', '640648f5-fe2e-4d29-8b6c-4658b80a65f1', 'test', 'test', 0, 'd34ca632-90d5-43de-88b9-3facc7a0ae14', '2020-06-01 18:09:00', '2020-06-01 17:09:00', NULL, '{\"QuestionList\":[\"14e0e32c-575f-4651-b03b-614596145725 \",\"43055fcd-5dd2-44b3-aa86-c49efdf9bca1 \"]}');
INSERT INTO `homework` VALUES ('0582ceb8-4725-49db-ba68-0d64786cb953', '90d8987b-94b2-42fa-8a01-ac9a32de2032', '第一个作业', '电脑', 1, 'd34ca632-90d5-43de-88b9-3facc7a0ae14', '2020-05-25 16:01:16', '2020-06-06 16:01:20', '2020-06-26 16:01:26', '{\r\n    \"QuesitonList\": [\r\n        \"14e0e32c-575f-4651-b03b-614596145725\",\r\n        \"ec681445-945a-49b1-b57d-0dbc439c5dad\",\r\n        \"67ed4947-189f-4879-b2fa-d48178424d0\"\r\n    ]\r\n}');
INSERT INTO `homework` VALUES ('0582ceb8-4725-49db-ba68-0d64786cb953', 'd9d70a89-16b6-41ac-826d-39d44d36975f', 'asasdf', 'asdfasdf', 0, 'd34ca632-90d5-43de-88b9-3facc7a0ae14', '2020-06-02 02:52:00', '2020-06-02 04:56:00', NULL, '{\"QuestionList\":[]}');
INSERT INTO `homework` VALUES ('0582ceb8-4725-49db-ba68-0d64786cb953', 'e8eb8b81-bd71-4943-a8b6-dbdbbdfd0c61', 'amskldgfkj', 'asijdgioasdjgio', 0, 'd34ca632-90d5-43de-88b9-3facc7a0ae14', '2020-05-30 20:35:00', '2020-05-30 22:33:00', NULL, '{\"QuestionList\":[\"14e0e32c-575f-4651-b03b-614596145725 \",\"43055fcd-5dd2-44b3-aa86-c49efdf9bca1 \",\"5cb5da53-dcd0-4cc1-ad6e-082f4338bd01 \"]}');

-- ----------------------------
-- Table structure for lesson
-- ----------------------------
DROP TABLE IF EXISTS `lesson`;
CREATE TABLE `lesson`  (
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teacher` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teacher_description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `precursor_lesson` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teaching_plans` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `exams` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bibliography` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `file` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `announcement` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `file_type` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lesson
-- ----------------------------
INSERT INTO `lesson` VALUES ('jquery', 'zmx', 'c0df550f-7dd9-41df-83fa-4d6196e1f8c9', '1', '1', '1', '1', '1', '1', NULL, '我吐了', NULL);
INSERT INTO `lesson` VALUES ('jsp', 'zmx', '0582ceb8-4725-49db-ba68-0d64786cb953', '<p>！！！！！</p>', '<p>昂昂昂</p>', 'java', '<p>@#￥%@#￥%@#￥%@#￥%</p>', '1', '1', '[\r\n   \r\n]', '<p>我修改了他</p>', NULL);

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `ID` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'UUID',
  `Type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Brief_Description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简述',
  `Description` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `Answer` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '答案',
  `Score` decimal(4, 1) NOT NULL COMMENT '文件上传题 : 分数 ',
  `Max_Size` decimal(3, 0) NULL DEFAULT NULL COMMENT '最大大小 MB',
  `File_Type` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文件格式',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('14e0e32c-575f-4651-b03b-614596145725', 'choice', '简述是啥呢', '这是测试选择题 这道题要选A哦<blankSpace>   A:1111 B:22222 C:33333 D:44444', 'A', 5.0, NULL, NULL);
INSERT INTO `question` VALUES ('43055fcd-5dd2-44b3-aa86-c49efdf9bca1', 'choice', 'aaaa', '这波啊 <blankSpace>', 'A', 0.0, 0, NULL);
INSERT INTO `question` VALUES ('5cb5da53-dcd0-4cc1-ad6e-082f4338bd01', 'judgement', '这是判断题呢', '可以的', '1', 0.0, 0, NULL);
INSERT INTO `question` VALUES ('67ed4947-189f-4879-b2fa-d48178424d0', 'judgement', '这是判断题', '这道题对的哦', '1', 5.0, NULL, NULL);
INSERT INTO `question` VALUES ('938ad670-a2a5-4093-aded-071bb56183fb', 'file', 'test for file', '上传个文件啊', '我', 0.0, 3, 'zip/doc/md');
INSERT INTO `question` VALUES ('a4de38d3-d2a0-40df-8978-750f8784160b', 'blank', 'ahfasodfhq', '我最帅', '我', 0.0, 0, NULL);
INSERT INTO `question` VALUES ('cb01b393-6c3f-4d25-a871-34550b4f402c', 'choice', '这是多选哦', '<blankSpace> <blacnkSpace> <blankSpace> 答案是 BDC AB DC ', 'BCD/AB/DC', 10.0, NULL, NULL);
INSERT INTO `question` VALUES ('eb868554-c50b-4d73-9fa2-16d5b9af6aec', 'file', '这是文件上传题', '随便整个活 <blankSpace>', '', 10.0, 5, NULL);
INSERT INTO `question` VALUES ('ec681445-945a-49b1-b57d-0dbc439c5dad', 'blank', '这是填空题', '最帅是我 <blankSpace>', '我', 15.0, NULL, NULL);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` char(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `affiliation` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('123', 'asfas', '202cb962ac59075b964b07152d234b70', '{\"Lessons\":{\"0582ceb8-4725-49db-ba68-0d64786cb953\":\"d34ca632-90d5-43de-88b9-3facc7a0ae14\"}}');
INSERT INTO `student` VALUES ('123123', 'test', '202CB962AC59075B964B07152D234B70', '{\"Lessons\":{\"0582ceb8-4725-49db-ba68-0d64786cb953\":\"d34ca632-90d5-43de-88b9-3facc7a0ae14\"}}');
INSERT INTO `student` VALUES ('1233456', 'asfas', '202cb962ac59075b964b07152d234b70', '{\"Lessons\":{\"0582ceb8-4725-49db-ba68-0d64786cb953\":\"d34ca632-90d5-43de-88b9-3facc7a0ae14\"}}');
INSERT INTO `student` VALUES ('435645678', 'dapao', '202cb962ac59075b964b07152d234b70', '{\"Lessons\":{\"0582ceb8-4725-49db-ba68-0d64786cb953\":\"d34ca632-90d5-43de-88b9-3facc7a0ae14\"}}');
INSERT INTO `student` VALUES ('789789789', 'testDemo', '202cb962ac59075b964b07152d234b70', '{\"Lessons\":{\"0582ceb8-4725-49db-ba68-0d64786cb953\":\"d34ca632-90d5-43de-88b9-3facc7a0ae14\"}}');
INSERT INTO `student` VALUES ('8888', '大炮', '202cb962ac59075b964b07152d234b70', '{\"Lessons\":{\"0582ceb8-4725-49db-ba68-0d64786cb953\":\"d34ca632-90d5-43de-88b9-3facc7a0ae14\"}}');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` char(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `InCharge` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('nice', '202CB962AC59075B964B07152D234B70', '0582ceb8-4725-49db-ba68-0d64786cb953', '1');

SET FOREIGN_KEY_CHECKS = 1;
