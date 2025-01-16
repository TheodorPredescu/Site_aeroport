CREATE DATABASE  IF NOT EXISTS `aeroport` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `aeroport`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: aeroport
-- ------------------------------------------------------
-- Server version	9.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `availableseats`
--

DROP TABLE IF EXISTS `availableseats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `availableseats` (
  `SeatID` int NOT NULL AUTO_INCREMENT,
  `FlightID` int NOT NULL,
  `SeatNumber` varchar(10) NOT NULL,
  `IsAvailable` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`SeatID`),
  KEY `FlightID` (`FlightID`),
  CONSTRAINT `availableseats_ibfk_1` FOREIGN KEY (`FlightID`) REFERENCES `flights` (`FlightID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `availableseats`
--

LOCK TABLES `availableseats` WRITE;
/*!40000 ALTER TABLE `availableseats` DISABLE KEYS */;
INSERT INTO `availableseats` VALUES (1,1,'12A',0),(2,1,'14B',1),(3,1,'16C',1),(4,2,'18D',1),(5,2,'20E',1),(6,2,'12A',1),(7,2,'14B',0),(8,2,'16C',1),(9,2,'18C',0),(10,2,'20F',0),(11,3,'12A',1),(12,3,'14B',1),(13,3,'16C',1),(14,3,'18C',1),(15,3,'20F',0),(16,4,'12A',1),(17,4,'14B',1),(18,4,'16C',1),(19,4,'18C',1),(20,4,'20F',1),(21,5,'12A',1),(22,5,'14B',1),(23,5,'16C',1),(24,5,'18C',1),(25,5,'20F',0);
/*!40000 ALTER TABLE `availableseats` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-16 20:31:49
