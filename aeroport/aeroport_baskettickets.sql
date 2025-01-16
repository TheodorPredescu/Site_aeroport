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
-- Table structure for table `baskettickets`
--

DROP TABLE IF EXISTS `baskettickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baskettickets` (
  `BasketTicketID` int NOT NULL AUTO_INCREMENT,
  `BasketID` int NOT NULL,
  `TicketID` int NOT NULL,
  `BookingDate` datetime DEFAULT NULL,
  `seatNumber` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`BasketTicketID`),
  KEY `FK__BasketTic__Ticke__34C8D9D1` (`TicketID`),
  KEY `FK_Basket_BasketID` (`BasketID`),
  CONSTRAINT `FK__BasketTic__Ticke__34C8D9D1` FOREIGN KEY (`TicketID`) REFERENCES `tickets` (`TicketID`),
  CONSTRAINT `FK_Basket_BasketID` FOREIGN KEY (`BasketID`) REFERENCES `clientbaskets` (`BasketID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baskettickets`
--

LOCK TABLES `baskettickets` WRITE;
/*!40000 ALTER TABLE `baskettickets` DISABLE KEYS */;
INSERT INTO `baskettickets` VALUES (1,1,1,'2024-01-01 12:00:00','12A'),(2,2,2,'2023-12-25 18:30:45','14B'),(3,3,3,'2024-07-04 09:15:00','16C'),(4,4,4,'2025-10-31 23:59:59','18D'),(5,4,4,'2024-02-29 00:00:00','20E'),(6,10,2,'2025-01-01 23:08:49','14B'),(7,11,2,'2025-01-01 23:11:12','18C'),(8,12,3,'2025-01-01 23:13:21','20F'),(9,13,2,'2025-01-01 23:13:41','20F'),(10,14,5,'2025-01-14 18:02:48','20F');
/*!40000 ALTER TABLE `baskettickets` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-16 20:31:48
