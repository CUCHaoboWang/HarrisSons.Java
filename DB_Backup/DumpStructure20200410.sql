CREATE DATABASE  IF NOT EXISTS `HarrisSonsDB` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `HarrisSonsDB`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: harrissonsdb.cewsoho8wmni.us-east-1.rds.amazonaws.com    Database: HarrisSonsDB
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `__EFMigrationsHistory`
--

DROP TABLE IF EXISTS `__EFMigrationsHistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `__EFMigrationsHistory` (
  `MigrationId` varchar(95) NOT NULL,
  `ProductVersion` varchar(32) NOT NULL,
  PRIMARY KEY (`MigrationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tblAddress`
--

DROP TABLE IF EXISTS `tblAddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblAddress` (
  `AddressID` int(11) NOT NULL AUTO_INCREMENT,
  `AddressLine1` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `AddressLine2` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `City` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `State` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Country` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PostalCode` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`AddressID`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tblAddress_bak`
--

DROP TABLE IF EXISTS `tblAddress_bak`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblAddress_bak` (
  `AddressID` int(11) NOT NULL AUTO_INCREMENT,
  `AddressLine1` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `AddressLine2` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `City` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `State` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Country` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PostalCode` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`AddressID`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tblBusinessContact`
--

DROP TABLE IF EXISTS `tblBusinessContact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblBusinessContact` (
  `BusinessContactID` int(11) NOT NULL AUTO_INCREMENT,
  `EmailAddress` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Telephone` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `BusinessTelephone` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `AddressID` int(11) NOT NULL,
  PRIMARY KEY (`BusinessContactID`),
  KEY `IX_tblBusinessContact_AddressID` (`AddressID`),
  CONSTRAINT `FK_tblBusinessContact_tblAddress_AddressID` FOREIGN KEY (`AddressID`) REFERENCES `tblAddress` (`AddressID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tblClient`
--

DROP TABLE IF EXISTS `tblClient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblClient` (
  `ClientID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `LastName` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `BirthDate` date NOT NULL,
  `FirstContactDate` date DEFAULT NULL,
  `LastContactDate` date DEFAULT NULL,
  `PersonalContactID` int(11) NOT NULL,
  PRIMARY KEY (`ClientID`),
  KEY `IX_tblClient_PersonalContactID` (`PersonalContactID`),
  CONSTRAINT `FK_tblClient_tblPersonalContact_PersonalContactID` FOREIGN KEY (`PersonalContactID`) REFERENCES `tblPersonalContact` (`PersonalContactID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tblDepartment`
--

DROP TABLE IF EXISTS `tblDepartment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblDepartment` (
  `DepartmentID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `GroupName` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`DepartmentID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tblEmployee`
--

DROP TABLE IF EXISTS `tblEmployee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblEmployee` (
  `EmployeeID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `LastName` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `BirthDate` date NOT NULL,
  `NationalInsuranceNumber` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HireDate` date NOT NULL,
  `PositionID` int(11) NOT NULL,
  `BusinessContactID` int(11) NOT NULL,
  PRIMARY KEY (`EmployeeID`),
  KEY `IX_tblEmployee_BusinessContactID` (`BusinessContactID`),
  KEY `IX_tblEmployee_PositionID` (`PositionID`),
  CONSTRAINT `FK_tblEmployee_tblBusinessContact_BusinessContactID` FOREIGN KEY (`BusinessContactID`) REFERENCES `tblBusinessContact` (`BusinessContactID`) ON DELETE CASCADE,
  CONSTRAINT `FK_tblEmployee_tblPosition_PositionID` FOREIGN KEY (`PositionID`) REFERENCES `tblPosition` (`PositionID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tblPayRate`
--

DROP TABLE IF EXISTS `tblPayRate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblPayRate` (
  `PayRateID` int(11) NOT NULL AUTO_INCREMENT,
  `Rank` int(11) NOT NULL,
  PRIMARY KEY (`PayRateID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tblPersonalContact`
--

DROP TABLE IF EXISTS `tblPersonalContact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblPersonalContact` (
  `PersonalContactID` int(11) NOT NULL AUTO_INCREMENT,
  `EmailAddress` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Telephone` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `HomeTelephone` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `AddressID` int(11) NOT NULL,
  PRIMARY KEY (`PersonalContactID`),
  KEY `IX_tblPersonalContact_AddressID` (`AddressID`),
  CONSTRAINT `FK_tblPersonalContact_tblAddress_AddressID` FOREIGN KEY (`AddressID`) REFERENCES `tblAddress` (`AddressID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tblPosition`
--

DROP TABLE IF EXISTS `tblPosition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tblPosition` (
  `PositionID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DepartmentID` int(11) NOT NULL,
  `PayRateID` int(11) NOT NULL,
  PRIMARY KEY (`PositionID`),
  KEY `IX_tblPosition_DepartmentID` (`DepartmentID`),
  KEY `IX_tblPosition_PayRateID` (`PayRateID`),
  CONSTRAINT `FK_tblPosition_tblDepartment_DepartmentID` FOREIGN KEY (`DepartmentID`) REFERENCES `tblDepartment` (`DepartmentID`) ON DELETE CASCADE,
  CONSTRAINT `FK_tblPosition_tblPayRate_PayRateID` FOREIGN KEY (`PayRateID`) REFERENCES `tblPayRate` (`PayRateID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Temporary view structure for view `vwBusinessContact`
--

DROP TABLE IF EXISTS `vwBusinessContact`;
/*!50001 DROP VIEW IF EXISTS `vwBusinessContact`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `vwBusinessContact` AS SELECT 
 1 AS `EmployeeID`,
 1 AS `FirstName`,
 1 AS `LastName`,
 1 AS `BirthDate`,
 1 AS `HireDate`,
 1 AS `Position`,
 1 AS `Department`,
 1 AS `EmailAddress`,
 1 AS `Telephone`,
 1 AS `BusinessTelephone`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vwBusinessContactDetail`
--

DROP TABLE IF EXISTS `vwBusinessContactDetail`;
/*!50001 DROP VIEW IF EXISTS `vwBusinessContactDetail`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `vwBusinessContactDetail` AS SELECT 
 1 AS `EmployeeID`,
 1 AS `FirstName`,
 1 AS `LastName`,
 1 AS `BirthDate`,
 1 AS `HireDate`,
 1 AS `Position`,
 1 AS `Department`,
 1 AS `EmailAddress`,
 1 AS `Telephone`,
 1 AS `BusinessTelephone`,
 1 AS `AddressLine1`,
 1 AS `AddressLine2`,
 1 AS `City`,
 1 AS `State`,
 1 AS `Country`,
 1 AS `PostalCode`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vwPersonalContact`
--

DROP TABLE IF EXISTS `vwPersonalContact`;
/*!50001 DROP VIEW IF EXISTS `vwPersonalContact`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `vwPersonalContact` AS SELECT 
 1 AS `ClientID`,
 1 AS `FirstName`,
 1 AS `LastName`,
 1 AS `BirthDate`,
 1 AS `ContactDate`,
 1 AS `EmailAddress`,
 1 AS `Telephone`,
 1 AS `HomeTelephone`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vwPersonalContactDetail`
--

DROP TABLE IF EXISTS `vwPersonalContactDetail`;
/*!50001 DROP VIEW IF EXISTS `vwPersonalContactDetail`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `vwPersonalContactDetail` AS SELECT 
 1 AS `ClientID`,
 1 AS `FirstName`,
 1 AS `LastName`,
 1 AS `BirthDate`,
 1 AS `ContactDate`,
 1 AS `EmailAddress`,
 1 AS `Telephone`,
 1 AS `HomeTelephone`,
 1 AS `AddressLine1`,
 1 AS `AddressLine2`,
 1 AS `City`,
 1 AS `State`,
 1 AS `Country`,
 1 AS `PostalCode`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vwPosition`
--

DROP TABLE IF EXISTS `vwPosition`;
/*!50001 DROP VIEW IF EXISTS `vwPosition`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `vwPosition` AS SELECT 
 1 AS `PositionID`,
 1 AS `Position`,
 1 AS `DepartmentID`,
 1 AS `Department`,
 1 AS `GroupName`,
 1 AS `PayRate`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'HarrisSonsDB'
--

--
-- Dumping routines for database 'HarrisSonsDB'
--
/*!50003 DROP PROCEDURE IF EXISTS `spAddAddress` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `spAddAddress`(address1 VARCHAR(255), address2 VARCHAR(255), city VARCHAR(255), state VARCHAR(255), country VARCHAR(255), postalcode VARCHAR(255))
BEGIN
INSERT INTO `HarrisSonsDB`.`tblAddress`
(`AddressID`,
`AddressLine1`,
`AddressLine2`,
`City`,
`State`,
`Country`,
`PostalCode`)
VALUES
(null, address1, address2, city, state, country, postalcode);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spAddBusinessContact` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `spAddBusinessContact`(IN firstname VARCHAR(255), lastname VARCHAR(255), birthdate VARCHAR(255), 
positionid INT, departmentid INT, emailaddress VARCHAR(255), telephone VARCHAR(255), businesstelephone VARCHAR(255),
address1 VARCHAR(255), address2 VARCHAR(255), city VARCHAR(255), state VARCHAR(255), country VARCHAR(255), postalcode VARCHAR(255))
BEGIN
DECLARE AddressID INT UNSIGNED;
DECLARE ContactID INT UNSIGNED;

START TRANSACTION;
INSERT INTO `HarrisSonsDB`.`tblAddress`
(`AddressID`, `AddressLine1`, `AddressLine2`, `City`, `State`, `Country`, `PostalCode`)
VALUES (null, address1, address2, city, state, country, postalcode);
SELECT last_insert_id() INTO AddressID;

INSERT INTO `HarrisSonsDB`.`tblBusinessContact`
(`BusinessContactID`, `EmailAddress`, `Telephone`, `BusinessTelephone`, `AddressID`)
VALUES (null, emailaddress, telephone, businesstelephone, AddressID);
SELECT last_insert_id() INTO ContactID;

INSERT INTO `HarrisSonsDB`.`tblEmployee`
(`EmployeeID`, `FirstName`, `LastName`, `BirthDate`, `NationalInsuranceNumber`, `HireDate`, `PositionID`, `BusinessContactID`)
VALUES (null, firstname, lastname, birthdate, '5f:f1:65:8e:22:46', now(), positionid, ContactID);
COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spAddPersonalContact` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `spAddPersonalContact`(IN firstname VARCHAR(255), lastname VARCHAR(255), birthdate VARCHAR(255), emailaddress VARCHAR(255), telephone VARCHAR(255), hometelephone VARCHAR(255),
address1 VARCHAR(255), address2 VARCHAR(255), city VARCHAR(255), state VARCHAR(255), country VARCHAR(255), postalcode VARCHAR(255))
BEGIN
DECLARE AddressID INT UNSIGNED;
DECLARE ContactID INT UNSIGNED;

START TRANSACTION;
INSERT INTO `HarrisSonsDB`.`tblAddress`
(`AddressID`, `AddressLine1`, `AddressLine2`, `City`, `State`, `Country`, `PostalCode`)
VALUES (null, address1, address2, city, state, country, postalcode);
SELECT last_insert_id() INTO AddressID;

INSERT INTO `HarrisSonsDB`.`tblPersonalContact`
(`PersonalContactID`, `EmailAddress`, `Telephone`, `HomeTelephone`, `AddressID`)
VALUES
(null, emailaddress, telephone, hometelephone, AddressID);
SELECT last_insert_id() INTO ContactID;

INSERT INTO `HarrisSonsDB`.`tblClient`
(`ClientID`, `FirstName`, `LastName`, `BirthDate`, `FirstContactDate`, `LastContactDate`, `PersonalContactID`)
VALUES (null, firstname, lastname, birthdate, now(), null, ContactID);
COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spDeleteAddress` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `spDeleteAddress`(IN id int)
BEGIN
DELETE FROM `HarrisSonsDB`.`tblAddress`
WHERE AddressID = id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spGetAllAddress` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `spGetAllAddress`()
BEGIN
SELECT * FROM HarrisSonsDB.tblAddress;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spGetAllPosition` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `spGetAllPosition`()
BEGIN
SELECT * FROM HarrisSonsDB.vwPosition ORDER BY PositionID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spGetAllViewBusinessContactDetail` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `spGetAllViewBusinessContactDetail`()
BEGIN
SELECT * FROM HarrisSonsDB.vwBusinessContactDetail ORDER BY EmployeeID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spGetAllViewPersonalContactDetail` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `spGetAllViewPersonalContactDetail`()
BEGIN
SELECT * FROM HarrisSonsDB.vwPersonalContactDetail ORDER BY ClientID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spGetBusinessAddressID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `spGetBusinessAddressID`(IN id INT)
BEGIN
SELECT AddressID FROM HarrisSonsDB.tblAddress
WHERE AddressID = (SELECT AddressID FROM HarrisSonsDB.tblBusinessContact 
WHERE BusinessContactID = (SELECT BusinessContactID FROM HarrisSonsDB.tblEmployee
WHERE EmployeeID = id));
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spGetPersonalAddressID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `spGetPersonalAddressID`(IN id INT)
BEGIN
SELECT AddressID FROM HarrisSonsDB.tblAddress
WHERE AddressID = (SELECT AddressID FROM HarrisSonsDB.tblPersonalContact 
WHERE PersonalContactID = (SELECT PersonalContactID FROM HarrisSonsDB.tblClient
WHERE ClientID = id));
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spSearchBusinessContact` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `spSearchBusinessContact`(IN text VARCHAR(255))
BEGIN
SELECT * FROM HarrisSonsDB.vwBusinessContactDetail 
WHERE FirstName LIKE CONCAT("%",text,"%") OR LastName LIKE CONCAT("%",text,"%") OR EmailAddress LIKE CONCAT("%",text,"%")
OR BirthDate LIKE CONCAT("%",text,"%") OR HireDate LIKE CONCAT("%",text,"%")
OR Position LIKE CONCAT("%",text,"%") OR Department LIKE CONCAT("%",text,"%") OR Telephone LIKE CONCAT("%",text,"%") 
OR BusinessTelephone LIKE CONCAT("%",text,"%") OR AddressLine1 LIKE CONCAT("%",text,"%")OR AddressLine2 LIKE CONCAT("%",text,"%") 
OR City LIKE CONCAT("%",text,"%") OR State LIKE CONCAT("%",text,"%") OR Country LIKE CONCAT("%",text,"%") OR PostalCode LIKE CONCAT("%",text,"%");
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spSearchPersonalContact` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `spSearchPersonalContact`(IN text VARCHAR(255))
BEGIN
SELECT * FROM HarrisSonsDB.vwPersonalContactDetail 
WHERE FirstName LIKE CONCAT("%",text,"%") OR LastName LIKE CONCAT("%",text,"%") OR EmailAddress LIKE CONCAT("%",text,"%") OR BirthDate LIKE CONCAT("%",text,"%")
OR Telephone LIKE CONCAT("%",text,"%") OR HomeTelephone LIKE CONCAT("%",text,"%") OR AddressLine1 LIKE CONCAT("%",text,"%")
OR AddressLine2 LIKE CONCAT("%",text,"%") OR City LIKE CONCAT("%",text,"%") OR State LIKE CONCAT("%",text,"%") 
OR Country LIKE CONCAT("%",text,"%") OR PostalCode LIKE CONCAT("%",text,"%");
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spUpdateAddress` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `spUpdateAddress`(IN id int, address1 VARCHAR(255), address2 VARCHAR(255), city VARCHAR(255), state VARCHAR(255), country VARCHAR(255), postalcode VARCHAR(255))
BEGIN
UPDATE `HarrisSonsDB`.`tblAddress`
SET
`AddressLine1` = address1,
`AddressLine2` = address2,
`City` = city,
`State` = state,
`Country` = country,
`PostalCode` = postalcode
WHERE `AddressID` = id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spUpdateBusinessContact` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `spUpdateBusinessContact`(IN id INT, IN firstname VARCHAR(255), lastname VARCHAR(255), birthdate VARCHAR(255), 
positionid INT, departmentid INT, emailaddress VARCHAR(255), telephone VARCHAR(255), businesstelephone VARCHAR(255),
address1 VARCHAR(255), address2 VARCHAR(255), city VARCHAR(255), state VARCHAR(255), country VARCHAR(255), postalcode VARCHAR(255))
BEGIN
DECLARE ConID INT UNSIGNED;
DECLARE AddID INT UNSIGNED;

START TRANSACTION;
UPDATE `HarrisSonsDB`.`tblEmployee`
SET `FirstName` = firstname, `LastName` = lastname, `BirthDate` = birthdate, `PositionID` = positionid 
WHERE `EmployeeID` = id;
SELECT BusinessContactID FROM `HarrisSonsDB`.`tblEmployee` WHERE EmployeeID = id INTO ConID;

UPDATE `HarrisSonsDB`.`tblBusinessContact`
SET `EmailAddress` = emailaddress, `Telephone` = telephone, `BusinessTelephone` = businesstelephone
WHERE `BusinessContactID` = ConID;
SELECT AddressID FROM `HarrisSonsDB`.`tblBusinessContact` WHERE BusinessContactID = ConID INTO AddID;

UPDATE `HarrisSonsDB`.`tblAddress`
SET `AddressLine1` = address1, `AddressLine2` = address2, `City` = city, `State` = state, `Country` = country, `PostalCode` = postalcode
WHERE `AddressID` = AddID;
COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spUpdatePersonalContact` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `spUpdatePersonalContact`(IN id INT, IN firstname VARCHAR(255), lastname VARCHAR(255), birthdate VARCHAR(255), emailaddress VARCHAR(255), telephone VARCHAR(255), hometelephone VARCHAR(255),
address1 VARCHAR(255), address2 VARCHAR(255), city VARCHAR(255), state VARCHAR(255), country VARCHAR(255), postalcode VARCHAR(255))
BEGIN
DECLARE ConID INT UNSIGNED;
DECLARE AddID INT UNSIGNED;
 
START TRANSACTION;
UPDATE `HarrisSonsDB`.`tblClient`
SET `FirstName` = firstname, `LastName` = lastname, `BirthDate` = birthdate 
WHERE `ClientID` = id;
SELECT PersonalContactID FROM `HarrisSonsDB`.`tblClient` WHERE ClientID = id INTO ConID;

UPDATE `HarrisSonsDB`.`tblPersonalContact`
SET `EmailAddress` = emailaddress, `Telephone` = telephone, `HomeTelephone` = hometelephone
WHERE `PersonalContactID` = ConID;
SELECT AddressID FROM `HarrisSonsDB`.`tblPersonalContact` WHERE PersonalContactID = ConID INTO AddID;

UPDATE `HarrisSonsDB`.`tblAddress`
SET `AddressLine1` = address1, `AddressLine2` = address2, `City` = city, `State` = state, `Country` = country, `PostalCode` = postalcode
WHERE `AddressID` = AddID;
COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `vwBusinessContact`
--

/*!50001 DROP VIEW IF EXISTS `vwBusinessContact`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `vwBusinessContact` AS select `employee`.`EmployeeID` AS `EmployeeID`,`employee`.`FirstName` AS `FirstName`,`employee`.`LastName` AS `LastName`,`employee`.`BirthDate` AS `BirthDate`,`employee`.`HireDate` AS `HireDate`,`position`.`Name` AS `Position`,`department`.`Name` AS `Department`,`contact`.`EmailAddress` AS `EmailAddress`,`contact`.`Telephone` AS `Telephone`,`contact`.`BusinessTelephone` AS `BusinessTelephone` from (((`tblEmployee` `employee` join `tblBusinessContact` `contact` on((`employee`.`BusinessContactID` = `contact`.`BusinessContactID`))) join `tblPosition` `position` on((`employee`.`PositionID` = `position`.`PositionID`))) join `tblDepartment` `department` on((`position`.`DepartmentID` = `department`.`DepartmentID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vwBusinessContactDetail`
--

/*!50001 DROP VIEW IF EXISTS `vwBusinessContactDetail`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `vwBusinessContactDetail` AS select `employee`.`EmployeeID` AS `EmployeeID`,`employee`.`FirstName` AS `FirstName`,`employee`.`LastName` AS `LastName`,`employee`.`BirthDate` AS `BirthDate`,`employee`.`HireDate` AS `HireDate`,`position`.`Name` AS `Position`,`department`.`Name` AS `Department`,`contact`.`EmailAddress` AS `EmailAddress`,`contact`.`Telephone` AS `Telephone`,`contact`.`BusinessTelephone` AS `BusinessTelephone`,`address`.`AddressLine1` AS `AddressLine1`,`address`.`AddressLine2` AS `AddressLine2`,`address`.`City` AS `City`,`address`.`State` AS `State`,`address`.`Country` AS `Country`,`address`.`PostalCode` AS `PostalCode` from ((((`tblEmployee` `employee` join `tblBusinessContact` `contact` on((`employee`.`BusinessContactID` = `contact`.`BusinessContactID`))) join `tblAddress` `address` on((`contact`.`AddressID` = `address`.`AddressID`))) join `tblPosition` `position` on((`employee`.`PositionID` = `position`.`PositionID`))) join `tblDepartment` `department` on((`position`.`DepartmentID` = `department`.`DepartmentID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vwPersonalContact`
--

/*!50001 DROP VIEW IF EXISTS `vwPersonalContact`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `vwPersonalContact` AS select `client`.`ClientID` AS `ClientID`,`client`.`FirstName` AS `FirstName`,`client`.`LastName` AS `LastName`,`client`.`BirthDate` AS `BirthDate`,`client`.`FirstContactDate` AS `ContactDate`,`contact`.`EmailAddress` AS `EmailAddress`,`contact`.`Telephone` AS `Telephone`,`contact`.`HomeTelephone` AS `HomeTelephone` from (`tblClient` `client` join `tblPersonalContact` `contact` on((`client`.`PersonalContactID` = `contact`.`PersonalContactID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vwPersonalContactDetail`
--

/*!50001 DROP VIEW IF EXISTS `vwPersonalContactDetail`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `vwPersonalContactDetail` AS select `client`.`ClientID` AS `ClientID`,`client`.`FirstName` AS `FirstName`,`client`.`LastName` AS `LastName`,`client`.`BirthDate` AS `BirthDate`,`client`.`FirstContactDate` AS `ContactDate`,`contact`.`EmailAddress` AS `EmailAddress`,`contact`.`Telephone` AS `Telephone`,`contact`.`HomeTelephone` AS `HomeTelephone`,`address`.`AddressLine1` AS `AddressLine1`,`address`.`AddressLine2` AS `AddressLine2`,`address`.`City` AS `City`,`address`.`State` AS `State`,`address`.`Country` AS `Country`,`address`.`PostalCode` AS `PostalCode` from ((`tblClient` `client` join `tblPersonalContact` `contact` on((`client`.`PersonalContactID` = `contact`.`PersonalContactID`))) join `tblAddress` `address` on((`contact`.`AddressID` = `address`.`AddressID`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vwPosition`
--

/*!50001 DROP VIEW IF EXISTS `vwPosition`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `vwPosition` AS select `Position`.`PositionID` AS `PositionID`,`Position`.`Name` AS `Position`,`Department`.`DepartmentID` AS `DepartmentID`,`Department`.`Name` AS `Department`,`Department`.`GroupName` AS `GroupName`,`Position`.`PayRateID` AS `PayRate` from (`tblPosition` `Position` join `tblDepartment` `Department` on((`Position`.`DepartmentID` = `Department`.`DepartmentID`))) order by `Position`.`PositionID` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-10 20:32:29
