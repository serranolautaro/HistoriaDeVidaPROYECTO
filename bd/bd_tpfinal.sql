CREATE DATABASE  IF NOT EXISTS `bd_tpfinal` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_tpfinal`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_tpfinal
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `ccdtye`
--

DROP TABLE IF EXISTS `ccdtye`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ccdtye` (
  `idccdtye` int NOT NULL AUTO_INCREMENT,
  `ubicacion_ccdtye` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  PRIMARY KEY (`idccdtye`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccdtye`
--

LOCK TABLES `ccdtye` WRITE;
/*!40000 ALTER TABLE `ccdtye` DISABLE KEYS */;
INSERT INTO `ccdtye` VALUES (1,'Floresta','Olimpo','1978-08-02','1979-11-06'),(2,'Nuniez','ESMA','1980-06-05','1982-11-06'),(3,'La boca','Calcio','1978-02-04','1981-04-15');
/*!40000 ALTER TABLE `ccdtye` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ccdtye_fuerza`
--

DROP TABLE IF EXISTS `ccdtye_fuerza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ccdtye_fuerza` (
  `idCcdtye_fuerza` int NOT NULL AUTO_INCREMENT,
  `idccdtye` int DEFAULT NULL,
  `idfuerzas` int DEFAULT NULL,
  PRIMARY KEY (`idCcdtye_fuerza`),
  KEY `fkCcdtye_idx` (`idccdtye`),
  KEY `fkFuerzas_idx` (`idfuerzas`),
  CONSTRAINT `fkCcdtye` FOREIGN KEY (`idccdtye`) REFERENCES `ccdtye` (`idccdtye`),
  CONSTRAINT `fkFuerzas` FOREIGN KEY (`idfuerzas`) REFERENCES `fuerzas` (`idfuerzas`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccdtye_fuerza`
--

LOCK TABLES `ccdtye_fuerza` WRITE;
/*!40000 ALTER TABLE `ccdtye_fuerza` DISABLE KEYS */;
INSERT INTO `ccdtye_fuerza` VALUES (1,1,2),(2,2,1),(3,2,3),(4,3,3);
/*!40000 ALTER TABLE `ccdtye_fuerza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ccdtye_identificados`
--

DROP TABLE IF EXISTS `ccdtye_identificados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ccdtye_identificados` (
  `idCcdtye_identificados` int NOT NULL AUTO_INCREMENT,
  `id_ccdtye` int DEFAULT NULL,
  `id_detenido` int DEFAULT NULL,
  PRIMARY KEY (`idCcdtye_identificados`),
  KEY `ubicacion_ccdtye_idx` (`id_ccdtye`),
  KEY `dniDetenido_idx` (`id_detenido`),
  CONSTRAINT `fkCcdtyee` FOREIGN KEY (`id_ccdtye`) REFERENCES `ccdtye` (`idccdtye`),
  CONSTRAINT `fkDetenido` FOREIGN KEY (`id_detenido`) REFERENCES `detenidos_identificados` (`idDetenido`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccdtye_identificados`
--

LOCK TABLES `ccdtye_identificados` WRITE;
/*!40000 ALTER TABLE `ccdtye_identificados` DISABLE KEYS */;
/*!40000 ALTER TABLE `ccdtye_identificados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ccdtye_noidentificados`
--

DROP TABLE IF EXISTS `ccdtye_noidentificados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ccdtye_noidentificados` (
  `idCcdtye_noidentificados` int NOT NULL AUTO_INCREMENT,
  `idCcdtye` int DEFAULT NULL,
  `idNoidentificados` int DEFAULT NULL,
  PRIMARY KEY (`idCcdtye_noidentificados`),
  KEY `ubicacion_ccdtye_idx` (`idCcdtye`),
  KEY `fkNoIdentificados_idx` (`idNoidentificados`),
  CONSTRAINT `fkCcdtyenoide` FOREIGN KEY (`idCcdtye`) REFERENCES `ccdtye` (`idccdtye`),
  CONSTRAINT `fkNoIdentificados` FOREIGN KEY (`idNoidentificados`) REFERENCES `detenidos_noidentificados` (`idNoidentificados`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ccdtye_noidentificados`
--

LOCK TABLES `ccdtye_noidentificados` WRITE;
/*!40000 ALTER TABLE `ccdtye_noidentificados` DISABLE KEYS */;
/*!40000 ALTER TABLE `ccdtye_noidentificados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detenidos_identificados`
--

DROP TABLE IF EXISTS `detenidos_identificados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detenidos_identificados` (
  `idDetenido` int NOT NULL AUTO_INCREMENT,
  `dniDetenido` int NOT NULL,
  `nombreDetenido` varchar(45) NOT NULL,
  `fechaUltimaVezVisto` date DEFAULT NULL,
  `biografia` mediumtext,
  `materialAudiovisual` varchar(60) DEFAULT NULL,
  `idTestigos` int DEFAULT NULL,
  `idProfesiones` int DEFAULT NULL,
  `idLugares` int DEFAULT NULL,
  PRIMARY KEY (`idDetenido`),
  KEY `fkTestigos_idx` (`idTestigos`),
  KEY `fkProfesiones_idx` (`idProfesiones`),
  KEY `fkLugares_idx` (`idLugares`),
  CONSTRAINT `fkLugares` FOREIGN KEY (`idLugares`) REFERENCES `lugaresdedetencion` (`idLugares`),
  CONSTRAINT `fkProfesiones` FOREIGN KEY (`idProfesiones`) REFERENCES `profesiones` (`idProfesiones`),
  CONSTRAINT `fkTestigos` FOREIGN KEY (`idTestigos`) REFERENCES `testigos` (`idTestigos`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detenidos_identificados`
--

LOCK TABLES `detenidos_identificados` WRITE;
/*!40000 ALTER TABLE `detenidos_identificados` DISABLE KEYS */;
INSERT INTO `detenidos_identificados` VALUES (2,46716046,'Leandro Loayza','1978-07-20','Leandro era un pibe de villa celina que un dia paso por el olimpo y desaparecio','nada',3,1,1),(3,15566778,'Arthur Morgan','1982-09-03','','no',NULL,1,6),(4,11223344,'Mateo Gomez','1992-03-10','','no',NULL,6,3),(5,22334455,'Lucas Perez','1990-05-01','Lucas era un pibe de la boca que vivia con sus viejos, teniendo 16 años lo secuestraron en Floresta','no',NULL,2,2);
/*!40000 ALTER TABLE `detenidos_identificados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detenidos_noidentificados`
--

DROP TABLE IF EXISTS `detenidos_noidentificados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detenidos_noidentificados` (
  `idNoidentificados` int NOT NULL AUTO_INCREMENT,
  `apodo` varchar(45) NOT NULL,
  `descripcion` mediumtext,
  `idTestigo` int DEFAULT NULL,
  PRIMARY KEY (`idNoidentificados`),
  KEY `fkTestigoo_idx` (`idTestigo`),
  CONSTRAINT `fkTestigoo` FOREIGN KEY (`idTestigo`) REFERENCES `testigos` (`idTestigos`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detenidos_noidentificados`
--

LOCK TABLES `detenidos_noidentificados` WRITE;
/*!40000 ALTER TABLE `detenidos_noidentificados` DISABLE KEYS */;
INSERT INTO `detenidos_noidentificados` VALUES (3,'El Pluma','Simplemente era un pibe de lentes que se decia que usaba el peinado de peso pluma',1);
/*!40000 ALTER TABLE `detenidos_noidentificados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fuerzas`
--

DROP TABLE IF EXISTS `fuerzas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fuerzas` (
  `idfuerzas` int NOT NULL AUTO_INCREMENT,
  `nombreFuerza` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idfuerzas`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fuerzas`
--

LOCK TABLES `fuerzas` WRITE;
/*!40000 ALTER TABLE `fuerzas` DISABLE KEYS */;
INSERT INTO `fuerzas` VALUES (1,'Policia'),(2,'Ejercito'),(3,'Gendarmeria');
/*!40000 ALTER TABLE `fuerzas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lugaresdedetencion`
--

DROP TABLE IF EXISTS `lugaresdedetencion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lugaresdedetencion` (
  `idLugares` int NOT NULL AUTO_INCREMENT,
  `nombreLugar` varchar(60) NOT NULL,
  PRIMARY KEY (`idLugares`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugaresdedetencion`
--

LOCK TABLES `lugaresdedetencion` WRITE;
/*!40000 ALTER TABLE `lugaresdedetencion` DISABLE KEYS */;
INSERT INTO `lugaresdedetencion` VALUES (1,'Floresta'),(2,'Mataderos'),(3,'La boca'),(4,'Nuniez'),(5,'Lugano'),(6,'Constitucion');
/*!40000 ALTER TABLE `lugaresdedetencion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesiones`
--

DROP TABLE IF EXISTS `profesiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesiones` (
  `idProfesiones` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idProfesiones`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesiones`
--

LOCK TABLES `profesiones` WRITE;
/*!40000 ALTER TABLE `profesiones` DISABLE KEYS */;
INSERT INTO `profesiones` VALUES (1,'Profesor'),(2,'Escritor'),(3,'Artista'),(4,'Abogado'),(5,'Obrero'),(6,'Arquitecto');
/*!40000 ALTER TABLE `profesiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testigos`
--

DROP TABLE IF EXISTS `testigos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testigos` (
  `idTestigos` int NOT NULL AUTO_INCREMENT,
  `DNITestigos` int NOT NULL,
  `Nombre_completo` varchar(50) DEFAULT NULL,
  `Testimonio` mediumtext,
  PRIMARY KEY (`idTestigos`),
  KEY `DNITestigos_idx` (`DNITestigos`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testigos`
--

LOCK TABLES `testigos` WRITE;
/*!40000 ALTER TABLE `testigos` DISABLE KEYS */;
INSERT INTO `testigos` VALUES (1,47234213,'Juan Manuel Bermudez','Vio a un tal Leandro, con la camiseta de Almirante Brown ser levantado por un falcon a plena luz del dia'),(3,12233445,'Arthur','Vio como se lo llevaban a El Pluma, levantandolo con un auto verde'),(4,213131,'Claudio','En una noche, se llevaron a su compañero Mateo a plena luz del dia en frente de su casa');
/*!40000 ALTER TABLE `testigos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-21 22:13:59
