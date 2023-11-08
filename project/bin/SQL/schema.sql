CREATE DATABASE IF NOT EXISTS ssafy_fit;

USE ssafy_fit;

DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `video`;
DROP TABLE IF EXISTS `review`;
DROP TABLE IF EXISTS `likedVideo`;
DROP TABLE IF EXISTS `follow`;


CREATE TABLE IF NOT EXISTS `user`(
  `id` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
  `pass` varchar(45) CHARACTER SET utf8mb4 NOT NULL DEFAULT '',
  `name` varchar(45) CHARACTER SET utf8mb4 NOT NULL DEFAULT '',
  PRIMARY KEY (`Id`)
);

CREATE TABLE IF NOT EXISTS `video`(
  `youtubeId` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
  `channelName` varchar(45) CHARACTER SET utf8mb4 NOT NULL DEFAULT '',
  `fitPartName` varchar(45) CHARACTER SET utf8mb4 NOT NULL DEFAULT '',
  `title` varchar(45) CHARACTER SET utf8mb4 NOT NULL DEFAULT '',
  `date` Date,
  `viewCnt` int(52) DEFAULT 0,
  PRIMARY KEY (`YoutubeId`)
);

CREATE TABLE IF NOT EXISTS `review`(
  `reviewNo` int(52) AUTO_INCREMENT NOT NULL,
  `youtubeId` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
  `userId` varchar(45) CHARACTER SET utf8mb4 NOT NULL DEFAULT '',
  `content` varchar(200) CHARACTER SET utf8mb4 NOT NULL DEFAULT '',
  `regDate` TIMESTAMP DEFAULT now() ,
  PRIMARY KEY (`reviewNo`),
  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `review_ibfk_2` FOREIGN KEY (`youtubeId`) REFERENCES `video` (`youtubeId`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `likedVideo`(
  `userId` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
  `youtubeId` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
  PRIMARY KEY (`userId`, `youtubeId`),
  CONSTRAINT `like_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `like_ibfk_2` FOREIGN KEY (`youtubeId`) REFERENCES `video` (`youtubeId`) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS `follow`(
  `followerId` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
  `followingId` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
   PRIMARY KEY (`followerId`, `followingId`),
  FOREIGN KEY (`followerId`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  FOREIGN KEY (`followingId`) REFERENCES `user` (`id`) ON DELETE CASCADE
);


