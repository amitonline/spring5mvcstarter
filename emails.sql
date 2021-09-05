-- Adminer 4.8.1 MySQL 5.7.35 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `emails`;
CREATE TABLE `emails` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `signup` datetime NOT NULL,
  `vkey` varchar(200) NOT NULL,
  `verified` smallint(6) DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `email` (`email`),
  KEY `vkey` (`vkey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- 2021-09-05 07:04:30
