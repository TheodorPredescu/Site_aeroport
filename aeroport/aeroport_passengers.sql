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
-- Table structure for table `passengers`
--

DROP TABLE IF EXISTS `passengers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passengers` (
  `PassengerID` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `LastName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `PassportNumber` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nationality` varchar(255) DEFAULT NULL,
  `Password` varchar(50) NOT NULL,
  `CNP` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`PassengerID`),
  UNIQUE KEY `UQ__Passenge__45809E712066B18A` (`PassportNumber`),
  UNIQUE KEY `UQ__Passenge__A9D10534D053051F` (`email`),
  UNIQUE KEY `unique_CNP` (`CNP`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passengers`
--

LOCK TABLES `passengers` WRITE;
/*!40000 ALTER TABLE `passengers` DISABLE KEYS */;
INSERT INTO `passengers` VALUES (1,'John','Doe','john.doe@example.com','A12345678','USA','john.doe','1234567890123'),(2,'Jane','Smith','jane.smith@example.com','B98765432','UK','jane.smith','2941034123456'),(3,'Tom','Brown','tom.brown@example.com','C19283746','Canada','tom.brown','5020703123456'),(4,'Alice','Johnson','alice.johnson@example.com','D56473829','Australia','alice.johnson','8712140198765'),(5,'Emily','Davis','emily.davis@example.com','E38475619','India','emily.davis','3012045123456'),(6,'Theodor','Predescu','tprede@gmail.com','AD1235','romanian','Theodor@','123456789'),(15,'Denisa','Predescu','deni@gmail.com','AR12345','romanian','Denisa@','12308947'),(18,'Stefania','Predescu','stefania@gmail.com','RO1234','romanian','Stefania@','014892241390'),(22,'Stefania','Predescu','stef@gmail.com','ROM123','romanian','Stefania@','09823412'),(23,'Mihai C','Predescu','mihai@gmail.com','ROMAN123','romanian','Mihai@','123456789012'),(25,'Denisa','Prede','denisaprede@gmail.com','aweaewf','romanian','Denisa01!','1234567890129');
/*!40000 ALTER TABLE `passengers` ENABLE KEYS */;
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
