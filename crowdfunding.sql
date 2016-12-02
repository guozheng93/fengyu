/*
Navicat MySQL Data Transfer

Source Server         : 本地测试
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : crowdfunding

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2016-12-01 16:36:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `ID` int(11) NOT NULL,
  `TOPIC_ID` int(11) NOT NULL COMMENT '主题id 项目id',
  `TOPIC_TYPE` varchar(10) NOT NULL COMMENT '主题类型',
  `COMMENT_CONTENT` varchar(100) DEFAULT NULL COMMENT '评论内容',
  `FROM_UID` int(11) DEFAULT NULL COMMENT '评论用户',
  `COMMENT_TIME` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for comment_reply
-- ----------------------------
DROP TABLE IF EXISTS `comment_reply`;
CREATE TABLE `comment_reply` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `COMMENT_ID` int(11) NOT NULL,
  `REPLY_ID` int(11) NOT NULL COMMENT '回复目标id',
  `REPLY_TYPE` varchar(10) NOT NULL COMMENT '回复类型',
  `REPLY_CONTENT` varchar(100) DEFAULT NULL COMMENT '回复内容',
  `FROM_UID` int(11) NOT NULL COMMENT '回复用户id',
  `TO_UID` int(11) NOT NULL COMMENT '目标用户id',
  `REPLY_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment_reply
-- ----------------------------

-- ----------------------------
-- Table structure for crowdfunding
-- ----------------------------
DROP TABLE IF EXISTS `crowdfunding`;
CREATE TABLE `crowdfunding` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '项目编号',
  `PRJT_NAME` varchar(30) NOT NULL COMMENT '众筹项目名称',
  `PRJT_ITEM_ID` int(11) DEFAULT NULL,
  `PRJT_SUMMARY` varchar(200) DEFAULT '' COMMENT '项目简介摘要',
  `PRJT_RAISE_TYPE` varchar(10) DEFAULT NULL COMMENT '募集对象类型 MONEY',
  `PRJT_RAISE_AMOUNT` double unsigned zerofill NOT NULL COMMENT '筹集资金额度',
  `PRJT_RAISE_TOPLIMIT` double unsigned zerofill NOT NULL COMMENT '筹集金额上限',
  `PRJT_FUND_CYCLE` int(11) NOT NULL COMMENT '筹集周期',
  `PRJT_COMMIT_TTIME` datetime DEFAULT NULL,
  `PRJT_STATUS` varchar(10) DEFAULT '' COMMENT '项目状态',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='众筹基本表 可以当做商品产品来设计  产品组';

-- ----------------------------
-- Records of crowdfunding
-- ----------------------------

-- ----------------------------
-- Table structure for crowdfunding_acct
-- ----------------------------
DROP TABLE IF EXISTS `crowdfunding_acct`;
CREATE TABLE `crowdfunding_acct` (
  `ID` int(11) NOT NULL,
  `PRJT_ID` int(11) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `ACCT_TYPE` varchar(10) DEFAULT NULL,
  `ACCT_NAME` varchar(100) DEFAULT NULL,
  `BANK_ID` int(11) DEFAULT NULL,
  `ACCT_NO` bigint(20) DEFAULT NULL,
  `OPEN_BANK_CITY` int(11) DEFAULT NULL,
  `ACCT_OPEN_BANK` int(11) DEFAULT NULL,
  `OPEN_BANK_PROVINCE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crowdfunding_acct
-- ----------------------------

-- ----------------------------
-- Table structure for crowdfunding_audit
-- ----------------------------
DROP TABLE IF EXISTS `crowdfunding_audit`;
CREATE TABLE `crowdfunding_audit` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRJT_ID` int(11) NOT NULL COMMENT '项目编号',
  `AUDITOR` int(11) NOT NULL COMMENT '审批人',
  `AUDIT_ACTION_TYPE` varchar(10) NOT NULL COMMENT '审批动作类型',
  `AUDIT_RESULT` tinyint(4) NOT NULL COMMENT '审批结果',
  `AUDIT_REMARK` varchar(100) DEFAULT NULL COMMENT '审批备注',
  `AUDIT_TIME` datetime NOT NULL COMMENT '审批时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='众筹项目审批表';

-- ----------------------------
-- Records of crowdfunding_audit
-- ----------------------------

-- ----------------------------
-- Table structure for crowdfunding_detail
-- ----------------------------
DROP TABLE IF EXISTS `crowdfunding_detail`;
CREATE TABLE `crowdfunding_detail` (
  `PRJT_ID` int(11) NOT NULL COMMENT ' 项目id',
  `PRJT_DETAIL` longtext NOT NULL COMMENT '项目详细',
  KEY `CRD_ID` (`PRJT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目详情表\r\nid来自项目基本信息表 crowdfunding';

-- ----------------------------
-- Records of crowdfunding_detail
-- ----------------------------

-- ----------------------------
-- Table structure for crowdfunding_entity
-- ----------------------------
DROP TABLE IF EXISTS `crowdfunding_entity`;
CREATE TABLE `crowdfunding_entity` (
  `PRJT_ID` int(11) NOT NULL,
  `ENTITY_COVER_IMAGE` varchar(50) DEFAULT NULL COMMENT '产品众筹封面图片',
  `ENTITY_CATALOG_IMAGE` varchar(50) DEFAULT NULL COMMENT '目录图片 列表页图片',
  `ENTITY_LOCATION_PROVINCE` varchar(10) DEFAULT NULL COMMENT '产品众筹所在省',
  `ENTITY_LOCATION_CITY` varchar(10) DEFAULT NULL COMMENT '产品众筹所在市',
  `ENTITY_LOCATION_COUNTY` varchar(10) DEFAULT NULL COMMENT '产品众筹所在区县',
  `ENTITY_LOCATION_FULL` varchar(100) DEFAULT NULL COMMENT '产品众筹项目详细地址',
  PRIMARY KEY (`PRJT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品众筹项目基本信息表';

-- ----------------------------
-- Records of crowdfunding_entity
-- ----------------------------

-- ----------------------------
-- Table structure for crowdfunding_item
-- ----------------------------
DROP TABLE IF EXISTS `crowdfunding_item`;
CREATE TABLE `crowdfunding_item` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ITEM_NAME` varchar(100) DEFAULT NULL,
  `PITEM_ID` int(11) DEFAULT NULL,
  `IS_PITEM` tinyint(4) DEFAULT NULL COMMENT '是否为为父级类目',
  `SORT_REQ` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='众筹类目表';

-- ----------------------------
-- Records of crowdfunding_item
-- ----------------------------

-- ----------------------------
-- Table structure for crowdfunding_item_props
-- ----------------------------
DROP TABLE IF EXISTS `crowdfunding_item_props`;
CREATE TABLE `crowdfunding_item_props` (
  `ID` int(11) NOT NULL,
  `REPAY_ID` int(11) DEFAULT NULL COMMENT '回报编号',
  `PROP_NAME` int(11) DEFAULT NULL COMMENT '商品属性表',
  `ITEM_ID` int(11) DEFAULT NULL COMMENT '类目id',
  `P_PROP_ID` varchar(255) DEFAULT NULL COMMENT '父级属性名id',
  `PRJT_ID` int(11) DEFAULT NULL COMMENT '项目编号，产品编号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='众筹项目属性名表';

-- ----------------------------
-- Records of crowdfunding_item_props
-- ----------------------------

-- ----------------------------
-- Table structure for crowdfunding_item_propvalue
-- ----------------------------
DROP TABLE IF EXISTS `crowdfunding_item_propvalue`;
CREATE TABLE `crowdfunding_item_propvalue` (
  `ID` int(11) NOT NULL,
  `PROP_VALUE_NAME` varchar(100) DEFAULT NULL COMMENT '属性值名称',
  `PROP_ID` int(11) DEFAULT NULL COMMENT '属性名id',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='众筹项目属性值表';

-- ----------------------------
-- Records of crowdfunding_item_propvalue
-- ----------------------------

-- ----------------------------
-- Table structure for crowdfunding_organiser
-- ----------------------------
DROP TABLE IF EXISTS `crowdfunding_organiser`;
CREATE TABLE `crowdfunding_organiser` (
  `PRJT_ID` int(11) NOT NULL,
  `ORGNR_RESUME` varchar(200) DEFAULT NULL COMMENT '发起人简历',
  `ORGNR_BLOG` varchar(50) DEFAULT NULL COMMENT '发起人博客',
  `ORGNR_BLESS_WORD` varchar(200) DEFAULT NULL COMMENT '祝福语',
  `ORGNR_TELEPHONE` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`PRJT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='众筹项目发起人信息表';

-- ----------------------------
-- Records of crowdfunding_organiser
-- ----------------------------

-- ----------------------------
-- Table structure for crowdfunding_publicity
-- ----------------------------
DROP TABLE IF EXISTS `crowdfunding_publicity`;
CREATE TABLE `crowdfunding_publicity` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRJT_ID` int(11) NOT NULL,
  `AUTHOR` varchar(10) DEFAULT NULL COMMENT '披露人类型 系统披露，本人披露，披露用户',
  `MESSAGE` varchar(255) DEFAULT NULL COMMENT '披露内容',
  `PUBLICITY_TIME` datetime DEFAULT NULL COMMENT '披露时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目信息披露表';

-- ----------------------------
-- Records of crowdfunding_publicity
-- ----------------------------

-- ----------------------------
-- Table structure for crowdfunding_publicity_img
-- ----------------------------
DROP TABLE IF EXISTS `crowdfunding_publicity_img`;
CREATE TABLE `crowdfunding_publicity_img` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PUBLICITY_ID` int(11) NOT NULL,
  `PUBLICITY_IMAGE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目动态信息披露图片表';

-- ----------------------------
-- Records of crowdfunding_publicity_img
-- ----------------------------

-- ----------------------------
-- Table structure for crowdfunding_repay
-- ----------------------------
DROP TABLE IF EXISTS `crowdfunding_repay`;
CREATE TABLE `crowdfunding_repay` (
  `ID` int(11) NOT NULL COMMENT '回报编号',
  `PRJT_ID` int(11) DEFAULT NULL COMMENT '项目编号',
  `REPAY_TYPE` varchar(10) DEFAULT NULL COMMENT '回报类别',
  `REPAY_PRICE` double(10,2) NOT NULL COMMENT '回报基本价格，当sku中匹配不到价格时',
  `REPAY_DETAIL` varchar(200) DEFAULT NULL COMMENT '回报详细信息',
  `REPAY_NEED_REMARK` tinyint(4) DEFAULT NULL COMMENT '是否需要备注',
  `REPAY_REMARK` varchar(200) DEFAULT NULL COMMENT '备注信息',
  `REPAY_LIMIT_AMOUNT` int(11) DEFAULT NULL COMMENT '限额',
  `REPAY_EXPRESS_FEE` double DEFAULT NULL COMMENT '运费',
  `REPAY_INVOICE_FLAG` tinyint(4) DEFAULT NULL COMMENT '是否需要发票',
  `REPAY_INVOICE_REMARK` varchar(50) DEFAULT NULL COMMENT '发票信息备注',
  `REPAY_TIME` datetime DEFAULT NULL COMMENT '回报时间  基本回报时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='众筹回报表 商品基本属性表 ';

-- ----------------------------
-- Records of crowdfunding_repay
-- ----------------------------

-- ----------------------------
-- Table structure for crowdfunding_repay_sku
-- ----------------------------
DROP TABLE IF EXISTS `crowdfunding_repay_sku`;
CREATE TABLE `crowdfunding_repay_sku` (
  `ID` int(11) NOT NULL,
  `REPAY_ID` int(11) DEFAULT NULL,
  `PROPERTIES` varchar(255) DEFAULT NULL,
  `QUANTITY` int(11) DEFAULT NULL,
  `PRICE` decimal(10,2) DEFAULT NULL,
  `DELIVERY_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crowdfunding_repay_sku
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ORDER_AMT` double NOT NULL,
  `ORDER_PARTY_A` int(11) NOT NULL COMMENT '订单甲方，即采购人',
  `ORDER_TIME` datetime DEFAULT NULL,
  `ORDER_STATUS` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for order_shipment
-- ----------------------------
DROP TABLE IF EXISTS `order_shipment`;
CREATE TABLE `order_shipment` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ORDER_ID` int(11) NOT NULL,
  `MERCHANDISE_TYPE` varchar(255) DEFAULT NULL COMMENT '货品类别',
  `MERCHANDISE_ID` int(11) DEFAULT NULL COMMENT '货品id 回报id',
  `ORDER_QUANTITY` double DEFAULT NULL COMMENT '订货数量',
  `ORDER_REMARK` varchar(50) DEFAULT NULL COMMENT '订单备注',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_shipment
-- ----------------------------
