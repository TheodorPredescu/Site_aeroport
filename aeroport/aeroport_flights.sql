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
-- Table structure for table `flights`
--

DROP TABLE IF EXISTS `flights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flights` (
  `FlightID` int NOT NULL,
  `FlightNumber` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `DepartureTime` datetime NOT NULL,
  `ArrivalTime` datetime NOT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `AirplaneID` int NOT NULL,
  `arrival_time` varchar(255) DEFAULT NULL,
  `departure_time` varchar(255) DEFAULT NULL,
  `flight_number` varchar(255) DEFAULT NULL,
  `airplane_airplaneid` int DEFAULT NULL,
  PRIMARY KEY (`FlightID`),
  UNIQUE KEY `UQ__Flights__2EAE6F509EBE6077` (`FlightNumber`),
  KEY `FK__Flights__Airplan__267ABA7A` (`AirplaneID`),
  KEY `FKgbbhk4lhmfveo8x1tfhopjp11` (`airplane_airplaneid`),
  CONSTRAINT `FK__Flights__Airplan__267ABA7A` FOREIGN KEY (`AirplaneID`) REFERENCES `airplanes` (`AirplaneID`),
  CONSTRAINT `FKgbbhk4lhmfveo8x1tfhopjp11` FOREIGN KEY (`airplane_airplaneid`) REFERENCES `airplanes` (`AirplaneID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flights`
--

LOCK TABLES `flights` WRITE;
/*!40000 ALTER TABLE `flights` DISABLE KEYS */;
INSERT INTO `flights` VALUES (1,'FL1001','2024-12-20 08:00:00','2024-12-20 12:00:00','New York','London',1,NULL,NULL,NULL,NULL),(2,'FL1002','2024-12-21 09:00:00','2024-12-21 13:00:00','Paris','Berlin',2,NULL,NULL,NULL,NULL),(3,'FL1003','2024-12-22 10:00:00','2024-12-22 14:00:00','Tokyo','Seoul',3,NULL,NULL,NULL,NULL),(4,'FL1004','2024-12-23 11:00:00','2024-12-23 15:00:00','Sydney','Singapore',4,NULL,NULL,NULL,NULL),(5,'FL1005','2024-12-24 12:00:00','2024-12-24 16:00:00','Dubai','Mumbai',5,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `flights` ENABLE KEYS */;
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
