CREATE DATABASE BMST;

USE BMST;
CREATE DATABASE blog;

USE blog;
CREATE TABLE IF NOT EXISTS `User` (
   `id`       INT UNSIGNED AUTO_INCREMENT,
   `userName`     VARCHAR(20) NOT NULL,
   `password` VARCHAR(20) NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `Article`(
   `id`       INT UNSIGNED AUTO_INCREMENT,
   `title`    VARCHAR(100) NOT NULL,
   `author`   VARCHAR(100) NOT NULL,
   `content`  VARCHAR(100) NOT NULL,
   `date`     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO User(userName, password) VALUE ('admin', 'passwd');

INSERT INTO Article(title, author, content) VALUE ('test', 'test', 'test');
INSERT INTO Article(title, author, content) VALUE ('test', 'test', 'test');
INSERT INTO Article(title, author, content) VALUE ('test', 'test', 'test');
INSERT INTO Article(title, author, content) VALUE ('test', 'test', 'test');
INSERT INTO Article(title, author, content) VALUE ('test', 'test', 'test');
INSERT INTO Article(title, author, content) VALUE ('test', 'test', 'test');
INSERT INTO Article(title, author, content) VALUE ('test', 'test', 'test');
INSERT INTO Article(title, author, content) VALUE ('test', 'test', 'test');
INSERT INTO Article(title, author, content) VALUE ('test', 'test', 'test');
INSERT INTO Article(title, author, content) VALUE ('test', 'test', 'test');
INSERT INTO Article(title, author, content) VALUE ('test', 'test', 'test');
INSERT INTO Article(title, author, content) VALUE ('test', 'test', 'test');