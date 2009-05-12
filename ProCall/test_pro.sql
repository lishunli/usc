/*
MySQL Backup
Source Server Version: 3.21.0
Source Database: test
Date: 2009/5/11 09:10:32
*/


-- ----------------------------
--  Procedure definition for `AddPerson`
-- ----------------------------
DROP PROCEDURE IF EXISTS `AddPerson`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `AddPerson`()
BEGIN
INSERT into person values( null,'存储过程',1,25,'1980');
END;;
DELIMITER ;

-- ----------------------------
--  Procedure definition for `GetPersonList`
-- ----------------------------
DROP PROCEDURE IF EXISTS `GetPersonList`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetPersonList`()
BEGIN
select * from person;
END;;
DELIMITER ;

-- ----------------------------
--  Procedure definition for `GetPersonName`
-- ----------------------------
DROP PROCEDURE IF EXISTS `GetPersonName`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetPersonName`(IN Pid INTEGER(11))
BEGIN
select personname from person where `personid`=Pid;
 END;;
DELIMITER ;

-- ----------------------------
--  Procedure definition for `GetPersonPartProperties`
-- ----------------------------
DROP PROCEDURE IF EXISTS `GetPersonPartProperties`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetPersonPartProperties`()
BEGIN
SELECT personid, personname from person;
END;;
DELIMITER ;

-- ----------------------------
--  Records 
-- ----------------------------
