-- blog

DROP DATABASE IF EXISTS blog;
CREATE DATABASE blog;
use blog;

DROP TABLE IF EXISTS blog_user;
CREATE TABLE blog_user
(
    id            bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
    username      varchar(50)         NOT NULL COMMENT '用户名',
    nickname      varchar(50)                  DEFAULT NULL COMMENT '昵称',
    password      char(64)                     DEFAULT NULL COMMENT '密码(密文)',
    gender        varchar(10)                  DEFAULT NULL COMMENT '性别',
    age           int(10) unsigned             DEFAULT 0 COMMENT '年龄',
    birthday      timestamp           NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    avatar        varchar(255)                 DEFAULT NULL COMMENT '头像URL',
    phone         varchar(50)                  DEFAULT NULL COMMENT '手机号码',
    email         varchar(50)                  DEFAULT NULL COMMENT '电子邮箱',
    address       varchar(255)                 DEFAULT NULL COMMENT '地址',
    sign          varchar(255)                 DEFAULT NULL COMMENT '个性签名',
    article_count int(10) unsigned             DEFAULT 0 COMMENT '评论数量',
    gmt_create    datetime                     DEFAULT NULL COMMENT '数据创建时间',
    gmt_modified  datetime                     DEFAULT NULL COMMENT '数据最后修改时间',
    PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4 COMMENT ='用户表';
INSERT INTO blog_user(username, nickname, password, gender, age, birthday, avatar, phone, email, address, sign,
                      article_count, gmt_create, gmt_modified)
VALUES ('admin', '管理员', '$2a$10$N.ZOn9G6/YLFixAOPMg/h.z7pCu6v2XyFDtC4q.jeeGm/TEZyj15C', '男', '20',
        '2002-11-23 10:55:08',
        'https://img2.baidu.com/it/u=4244269751,4000533845&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500', '15551897568',
        '2168149199@qq.com', '北京', '这个人很懒,什么也没留下...', 0, '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       ('root', '开发者', '$2a$10$N.ZOn9G6/YLFixAOPMg/h.z7pCu6v2XyFDtC4q.jeeGm/TEZyj15C', '男', '20', '2002-11-17 10:55:08',
        'https://img2.baidu.com/it/u=2704182461,2749837878&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500', '15551898017',
        '2168149199@qq.com', '浙江',
        '这个人很懒,什么也没留下...', 0, '2022-11-20 19:43:53', '2022-11-20 19:43:53');

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
INSERT INTO blog_user_article(user_id, article_id, gmt_create, gmt_modified)
VALUES (1, 1, '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       (1, 2, '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       (1, 3, '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       (1, 4, '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       (2, 5, '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       (2, 6, '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       (2, 7, '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       (2, 8, '2022-11-20 19:43:53', '2022-11-20 19:43:53');

DROP TABLE IF EXISTS blog_article;
CREATE TABLE blog_article
(
    id           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '文章id',
    title        varchar(50)  DEFAULT NULL COMMENT '标题',
    description  varchar(255) DEFAULT NULL COMMENT '文章简介',
    text         text         DEFAULT NULL COMMENT '文章内容',
    url          varchar(255) DEFAULT NULL COMMENT '图片URL',
    gmt_create   datetime     DEFAULT NULL COMMENT '数据创建时间',
    gmt_modified datetime     DEFAULT NULL COMMENT '数据最后修改时间',
    PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4 COMMENT ='文章表';
INSERT INTO blog_article(title, description, text, url, gmt_create, gmt_modified)
VALUES ('加油!', '这是一次挑战', '金钱没有高贵，低贱之分。金钱在高尚人的手中，就会变得高尚；金钱在庸俗人手中，就会变得低级庸俗。',
        'https://img0.baidu.com/it/u=1600969112,4145041554&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500',
        '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       ('加油!', '这是一次挑战', '金钱没有高贵，低贱之分。金钱在高尚人的手中，就会变得高尚；金钱在庸俗人手中，就会变得低级庸俗。',
        'https://img0.baidu.com/it/u=1600969112,4145041554&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500',
        '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       ('加油!', '这是一次挑战', '金钱没有高贵，低贱之分。金钱在高尚人的手中，就会变得高尚；金钱在庸俗人手中，就会变得低级庸俗。',
        'https://img0.baidu.com/it/u=1600969112,4145041554&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500',
        '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       ('加油!', '这是一次挑战', '金钱没有高贵，低贱之分。金钱在高尚人的手中，就会变得高尚；金钱在庸俗人手中，就会变得低级庸俗。',
        'https://img0.baidu.com/it/u=1600969112,4145041554&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500',
        '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       ('Java开发!', '这是一次挑战', '金钱没有高贵，低贱之分。金钱在高尚人的手中，就会变得高尚；金钱在庸俗人手中，就会变得低级庸俗。',
        'https://img0.baidu.com/it/u=1600969112,4145041554&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500',
        '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       ('Java开发!', '这是一次挑战', '金钱没有高贵，低贱之分。金钱在高尚人的手中，就会变得高尚；金钱在庸俗人手中，就会变得低级庸俗。',
        'https://img0.baidu.com/it/u=1600969112,4145041554&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500',
        '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       ('Java开发!', '这是一次挑战', '金钱没有高贵，低贱之分。金钱在高尚人的手中，就会变得高尚；金钱在庸俗人手中，就会变得低级庸俗。',
        'https://img0.baidu.com/it/u=1600969112,4145041554&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500',
        '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       ('Java开发!', '这是一次挑战', '金钱没有高贵，低贱之分。金钱在高尚人的手中，就会变得高尚；金钱在庸俗人手中，就会变得低级庸俗。',
        'https://img0.baidu.com/it/u=1600969112,4145041554&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500',
        '2022-11-20 19:43:53', '2022-11-20 19:43:53');

DROP TABLE IF EXISTS blog_article_category;
CREATE TABLE blog_article_category
(
    id           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据id',
    user_id      bigint(20) unsigned DEFAULT NULL COMMENT '用户id',
    article_id   bigint(20) unsigned DEFAULT NULL COMMENT '文章id',
    category_id  bigint(20) unsigned DEFAULT NULL COMMENT '类别id',
    gmt_create   datetime            DEFAULT NULL COMMENT '数据创建时间',
    gmt_modified datetime            DEFAULT NULL COMMENT '数据最后修改时间',
    PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4 COMMENT ='文章类别关联';
INSERT INTO blog_article_category(user_id, article_id, category_id, gmt_create, gmt_modified)
VALUES (1, 1, 1, '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       (1, 2, 2, '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       (1, 3, 3, '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       (1, 4, 4, '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       (2, 5, 1, '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       (2, 6, 2, '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       (2, 7, 3, '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       (2, 8, 4, '2022-11-20 19:43:53', '2022-11-20 19:43:53');

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
INSERT INTO blog_category(name, sort, gmt_create, gmt_modified)
VALUES ('日常', 1, '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       ('休闲', 2, '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       ('技术', 3, '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       ('笔记', 4, '2022-11-20 19:43:53', '2022-11-20 19:43:53'),
       ('讨论', 5, '2022-11-20 19:43:53', '2022-11-20 19:43:53');

DROP TABLE IF EXISTS blog_user_article_comment;
CREATE TABLE blog_user_article_comment
(
    user_id      bigint(20) unsigned DEFAULT NULL COMMENT '用户id',
    article_id   bigint(20) unsigned DEFAULT NULL COMMENT '文章id',
    comment_id   bigint(20) unsigned DEFAULT NULL COMMENT '文章id',
    gmt_create   datetime            DEFAULT NULL COMMENT '数据创建时间',
    gmt_modified datetime            DEFAULT NULL COMMENT '数据最后修改时间'
) DEFAULT CHARSET = utf8mb4 COMMENT ='用户文章评论关联表';

DROP TABLE IF EXISTS blog_comment;
CREATE TABLE blog_comment
(
    id           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '数据id',
    content      varchar(50)         NOT NULL COMMENT '评论内容',
    gmt_create   datetime DEFAULT NULL COMMENT '数据创建时间',
    gmt_modified datetime DEFAULT NULL COMMENT '数据最后修改时间',
    PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4 COMMENT ='评论表';