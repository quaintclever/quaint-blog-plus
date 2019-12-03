CREATE TABLE `article_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	`article_title` varchar(50) not null comment '文章标题',
	`article_abstract` varchar(255) not null comment '文章简介，摘要',
	`main_image_url` varchar(100) not null comment '首页主图url',
	`member_id` int(11) not null comment '作者id',
	`label` varchar(20) default null comment '标签 eg： 1,2,3 --> 博客,技术,java',
	`read_num` bigint(11) not null default 0 comment '阅读数',
  `article_content` tinytext not NULL COMMENT '文章内容',
  `show_home` tinyint(1) not null default 0 comment '首页是否展示 0 不展示， 1 展示',
	`create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	`valid` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否有效 1:是 0:否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章表';