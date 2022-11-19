-- blog

DROP DATABASE IF EXISTS blog;
CREATE DATABASE blog;
use blog;

DROP TABLE IF EXISTS blog_user;
CREATE TABLE blog_user
(
    id            bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
    username      varchar(50)         NOT NULL COMMENT '用户名',
    nickname      varchar(50)      DEFAULT NULL COMMENT '昵称',
    password      char(64)         DEFAULT NULL COMMENT '密码',
    avatar        varchar(255)     DEFAULT NULL COMMENT '头像URL',
    phone         varchar(50)      DEFAULT NULL COMMENT '手机号码',
    email         varchar(50)      DEFAULT NULL COMMENT '电子邮箱',
    address       varchar(255)     DEFAULT NULL COMMENT '地址',
    sign          varchar(255)     DEFAULT NULL COMMENT '个性签名',
    article_count int(10) unsigned DEFAULT 0 COMMENT '文章数量',
    gmt_create    datetime         DEFAULT NULL COMMENT '数据创建时间',
    gmt_modified  datetime         DEFAULT NULL COMMENT '数据最后修改时间',
    PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4 COMMENT ='用户表';

DROP TABLE IF EXISTS blog_user_article;
CREATE TABLE blog_user_article
(
    id           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据id',
    user_id      bigint(20) unsigned DEFAULT NULL COMMENT '用户id',
    article_id   bigint(20) unsigned DEFAULT NULL COMMENT '文章id',
    gmt_create   datetime            DEFAULT NULL COMMENT '数据创建时间',
    gmt_modified datetime            DEFAULT NULL COMMENT '数据最后修改时间',
    PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4 COMMENT ='用户文章关联';

DROP TABLE IF EXISTS blog_article;
CREATE TABLE blog_article
(
    id           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '文章id',
    title        varchar(50)         DEFAULT NULL COMMENT '标题',
    description  varchar(255)        DEFAULT NULL COMMENT '文章简介',
    text         text                DEFAULT NULL COMMENT '文章内容',
    sort         tinyint(3) unsigned DEFAULT '0' COMMENT '排序序号',
    url          varchar(255)        DEFAULT NULL COMMENT '图片URL',
    gmt_create   datetime            DEFAULT NULL COMMENT '数据创建时间',
    gmt_modified datetime            DEFAULT NULL COMMENT '数据最后修改时间',
    PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4 COMMENT ='文章表';

DROP TABLE IF EXISTS blog_article_category;
CREATE TABLE blog_article_category
(
    id           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据id',
    article_id   bigint(20) unsigned DEFAULT NULL COMMENT '文章id',
    category_id  bigint(20) unsigned DEFAULT NULL COMMENT '类别id',
    gmt_create   datetime            DEFAULT NULL COMMENT '数据创建时间',
    gmt_modified datetime            DEFAULT NULL COMMENT '数据最后修改时间',
    PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4 COMMENT ='文章类别关联';

DROP TABLE IF EXISTS blog_category;
CREATE TABLE blog_category
(
    id           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据id',
    name         varchar(50)         NOT NULL COMMENT '类别名称',
    sort         tinyint(3) unsigned DEFAULT '0' COMMENT '排序序号',
    gmt_create   datetime            DEFAULT NULL COMMENT '数据创建时间',
    gmt_modified datetime            DEFAULT NULL COMMENT '数据最后修改时间',
    PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4 COMMENT ='类别表';