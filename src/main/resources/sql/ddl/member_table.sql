CREATE TABLE `member_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `username` varchar(50) DEFAULT NULL COMMENT '账号',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
	`valid` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否有效 1:是 0:否',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_user` (`username`,`password`) USING BTREE COMMENT '用户名，和密码映射，唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';