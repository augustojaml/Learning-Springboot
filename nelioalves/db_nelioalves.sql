-- MySQL dump 10.13  Distrib 8.0.28, for Linux (x86_64)
--
-- Host: 0.0.0.0    Database: db_nelioalves
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `complement` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `neighborhood` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  `city_id` int DEFAULT NULL,
  `client_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpo044ng5x4gynb291cv24vtea` (`city_id`),
  KEY `FK7156ty2o5atyuy9f6kuup9dna` (`client_id`),
  CONSTRAINT `FK7156ty2o5atyuy9f6kuup9dna` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `FKpo044ng5x4gynb291cv24vtea` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'Apto 303','Jardim','Rua Flores','300','38220834',1,1),(2,'Salva 800','Centro','AVenida Matos','105','3877701',2,1);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Informática'),(2,'Escritório'),(3,'Cama mesa e banho'),(4,'Eletrônicos'),(5,'Jardinagem'),(6,'Decoração'),(7,'Perfumaria');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `state_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6p2u50v8fg2y0js6djc6xanit` (`state_id`),
  CONSTRAINT `FK6p2u50v8fg2y0js6djc6xanit` FOREIGN KEY (`state_id`) REFERENCES `state` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Uberlândia',1),(2,'São Paulo',2),(3,'Campinas',2);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cpf_or_cnpj` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'11111111111','maria@gmail.com','Maria Sila',1);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_purchase`
--

DROP TABLE IF EXISTS `item_purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_purchase` (
  `discount` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `purchase_id` int NOT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`product_id`,`purchase_id`),
  KEY `FKeforbp14f81vc31bqqu40ga3r` (`purchase_id`),
  CONSTRAINT `FK39akf2fp166op1gjkhqdytxxs` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKeforbp14f81vc31bqqu40ga3r` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_purchase`
--

LOCK TABLES `item_purchase` WRITE;
/*!40000 ALTER TABLE `item_purchase` DISABLE KEYS */;
INSERT INTO `item_purchase` VALUES (0,2000,1,1,1),(100,800,1,2,2),(0,80,2,1,3);
/*!40000 ALTER TABLE `item_purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `purchase_id` int NOT NULL,
  `state` int DEFAULT NULL,
  PRIMARY KEY (`purchase_id`),
  CONSTRAINT `FKmm2h9p8cpu4741lwxyn2fnpgg` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,2),(2,1);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_card`
--

DROP TABLE IF EXISTS `payment_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_card` (
  `number_of_installments` int DEFAULT NULL,
  `purchase_id` int NOT NULL,
  PRIMARY KEY (`purchase_id`),
  CONSTRAINT `FK8hkfa7gfh5guub9ynpu8t8q0q` FOREIGN KEY (`purchase_id`) REFERENCES `payment` (`purchase_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_card`
--

LOCK TABLES `payment_card` WRITE;
/*!40000 ALTER TABLE `payment_card` DISABLE KEYS */;
INSERT INTO `payment_card` VALUES (6,1);
/*!40000 ALTER TABLE `payment_card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_ticket`
--

DROP TABLE IF EXISTS `payment_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_ticket` (
  `expire_date` datetime(6) DEFAULT NULL,
  `payment_date` datetime(6) DEFAULT NULL,
  `purchase_id` int NOT NULL,
  PRIMARY KEY (`purchase_id`),
  CONSTRAINT `FK8t3fggcu9eastxyp4bjv26vyx` FOREIGN KEY (`purchase_id`) REFERENCES `payment` (`purchase_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_ticket`
--

LOCK TABLES `payment_ticket` WRITE;
/*!40000 ALTER TABLE `payment_ticket` DISABLE KEYS */;
INSERT INTO `payment_ticket` VALUES ('2017-09-30 00:00:00.000000',NULL,2);
/*!40000 ALTER TABLE `payment_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone`
--

DROP TABLE IF EXISTS `phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phone` (
  `client_id` int NOT NULL,
  `phones` varchar(255) DEFAULT NULL,
  KEY `FK3o48ec26lujl3kf01hwqplhn2` (`client_id`),
  CONSTRAINT `FK3o48ec26lujl3kf01hwqplhn2` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone`
--

LOCK TABLES `phone` WRITE;
/*!40000 ALTER TABLE `phone` DISABLE KEYS */;
INSERT INTO `phone` VALUES (1,'11110000'),(1,'22220000');
/*!40000 ALTER TABLE `phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Computador',2000),(2,'Impressora',800),(3,'Mouse',80),(4,'Mesa de escritório',300),(5,'Toalha',50),(6,'Colcha',200),(7,'TV true color',1200),(8,'Roçadeira',800),(9,'Abajur',100),(10,'Pendente',180),(11,'Shampoo',90);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products_categories`
--

DROP TABLE IF EXISTS `products_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products_categories` (
  `product_id` int NOT NULL,
  `category_id` int NOT NULL,
  KEY `FKfdcalyppphnbbrsktuqd46c9` (`category_id`),
  KEY `FKt1s2ikavb75cb1b60jvvmjqr5` (`product_id`),
  CONSTRAINT `FKfdcalyppphnbbrsktuqd46c9` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKt1s2ikavb75cb1b60jvvmjqr5` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products_categories`
--

LOCK TABLES `products_categories` WRITE;
/*!40000 ALTER TABLE `products_categories` DISABLE KEYS */;
INSERT INTO `products_categories` VALUES (1,1),(1,4),(2,1),(2,2),(2,4),(3,1),(3,4),(4,2),(5,3),(6,3),(7,4),(8,5),(9,6),(10,6),(11,7);
/*!40000 ALTER TABLE `products_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase` (
  `id` int NOT NULL AUTO_INCREMENT,
  `instant` datetime(6) DEFAULT NULL,
  `client_id` int DEFAULT NULL,
  `shipping_address_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK72b3lvttv8rw80xc3orixyiml` (`client_id`),
  KEY `FKossmxn9e29klqck0c0h3ci4yp` (`shipping_address_id`),
  CONSTRAINT `FK72b3lvttv8rw80xc3orixyiml` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `FKossmxn9e29klqck0c0h3ci4yp` FOREIGN KEY (`shipping_address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` VALUES (1,'2017-09-30 10:32:00.000000',1,1),(2,'2017-10-10 19:35:00.000000',1,2);
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'Minas Gerais'),(2,'São Paulo');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-06 13:07:17
