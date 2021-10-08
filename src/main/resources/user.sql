CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int DEFAULT '1',
  `deleted` bit(1) DEFAULT b'0' COMMENT '1:已删除；0:未删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8