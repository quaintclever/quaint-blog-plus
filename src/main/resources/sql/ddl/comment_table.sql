CREATE TABLE `comment_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	`article_id` int(11) not null default 0 comment '评论文章id，留言默认为 0 ',
	`member_id` int(11) comment '评论者id',
	`parent_id` int(11) comment '回复的 评论人id（评论表id）',
	`re_id` int(11) comment '回复的 回复者id（用户表id）',
  `comment_content` varchar(7777) not null COMMENT '评论内容',
	`create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	`valid` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否有效 1:是 0:否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论记录表';
