CREATE TABLE `member_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `nack_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';