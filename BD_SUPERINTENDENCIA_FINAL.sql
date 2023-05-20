CREATE DATABASE  IF NOT EXISTS `proyectosuperintendencia` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `proyectosuperintendencia`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: proyectosuperintendencia
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `tb_cargo`
--

DROP TABLE IF EXISTS `tb_cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cargo` (
  `id_cargo` int NOT NULL AUTO_INCREMENT,
  `descrip_cargo` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cargo`
--

LOCK TABLES `tb_cargo` WRITE;
/*!40000 ALTER TABLE `tb_cargo` DISABLE KEYS */;
INSERT INTO `tb_cargo` VALUES (1,'Tecnico Admin'),(2,'Jefe de RRHH'),(3,'Coordinador OGA'),(4,'Superintend OGA');
/*!40000 ALTER TABLE `tb_cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_contrato`
--

DROP TABLE IF EXISTS `tb_contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_contrato` (
  `id_contrato` char(10) NOT NULL,
  `tipo_contrato` int DEFAULT NULL,
  `id_participante` int DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  `resolucion` varchar(300) DEFAULT NULL,
  `estado` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_contrato`),
  KEY `tipo_contrato` (`tipo_contrato`),
  KEY `id_participante` (`id_participante`),
  CONSTRAINT `tb_contrato_ibfk_1` FOREIGN KEY (`tipo_contrato`) REFERENCES `tb_tipocontrato` (`id_tipocontrato`),
  CONSTRAINT `tb_contrato_ibfk_2` FOREIGN KEY (`id_participante`) REFERENCES `tb_participante` (`id_participante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_contrato`
--

LOCK TABLES `tb_contrato` WRITE;
/*!40000 ALTER TABLE `tb_contrato` DISABLE KEYS */;
INSERT INTO `tb_contrato` VALUES ('C0001',2,1,'2022-05-10','Contrato entre Superintendencia de Mercado de Valores y Ingeniero. Establece las obligaciones, remuneración, horario de trabajo, causales de terminación, confidencialidad y propiedad intelectual. Vigencia: 1 año, renovable. Ley aplicable: Panamá..','No Necesita','PENDIENTE');
/*!40000 ALTER TABLE `tb_contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_detallecontrato`
--

DROP TABLE IF EXISTS `tb_detallecontrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_detallecontrato` (
  `id_contrato` char(10) NOT NULL,
  `id_visado` int NOT NULL,
  `id_usuario` char(10) DEFAULT NULL,
  `estado` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_contrato`,`id_visado`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `tb_detallecontrato_ibfk_1` FOREIGN KEY (`id_contrato`) REFERENCES `tb_contrato` (`id_contrato`),
  CONSTRAINT `tb_detallecontrato_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_detallecontrato`
--

LOCK TABLES `tb_detallecontrato` WRITE;
/*!40000 ALTER TABLE `tb_detallecontrato` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_detallecontrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_participante`
--

DROP TABLE IF EXISTS `tb_participante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_participante` (
  `id_participante` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(25) DEFAULT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  `dni` char(8) DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  `correo` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_participante`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_participante`
--

LOCK TABLES `tb_participante` WRITE;
/*!40000 ALTER TABLE `tb_participante` DISABLE KEYS */;
INSERT INTO `tb_participante` VALUES (1,'Tipiciano','Alexander','45286693',925968376,'ticipiano@gmail.com'),(2,'Mendoza','Jose','45286399',993459675,'mendoza@gmail.com'),(3,'Hernandez','Gustavo','85459669',986355145,'hernandez@gmail.com');
/*!40000 ALTER TABLE `tb_participante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_perfil`
--

DROP TABLE IF EXISTS `tb_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_perfil` (
  `id_perfil` int NOT NULL AUTO_INCREMENT,
  `descrip_perfil` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_perfil`
--

LOCK TABLES `tb_perfil` WRITE;
/*!40000 ALTER TABLE `tb_perfil` DISABLE KEYS */;
INSERT INTO `tb_perfil` VALUES (1,'Usuario'),(2,'Tecnico'),(3,'Administrador');
/*!40000 ALTER TABLE `tb_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipocontrato`
--

DROP TABLE IF EXISTS `tb_tipocontrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipocontrato` (
  `id_tipocontrato` int NOT NULL AUTO_INCREMENT,
  `descrip_tipo` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_tipocontrato`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipocontrato`
--

LOCK TABLES `tb_tipocontrato` WRITE;
/*!40000 ALTER TABLE `tb_tipocontrato` DISABLE KEYS */;
INSERT INTO `tb_tipocontrato` VALUES (1,'Indeterminado'),(2,'Plazo fijo'),(3,'administrativo');
/*!40000 ALTER TABLE `tb_tipocontrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `id_usuario` char(10) NOT NULL,
  `contraseña` varchar(10) DEFAULT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  `apellido` varchar(25) DEFAULT NULL,
  `id_cargo` int DEFAULT NULL,
  `id_perfil` int DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `id_cargo` (`id_cargo`),
  KEY `id_perfil` (`id_perfil`),
  CONSTRAINT `tb_usuario_ibfk_1` FOREIGN KEY (`id_cargo`) REFERENCES `tb_cargo` (`id_cargo`),
  CONSTRAINT `tb_usuario_ibfk_2` FOREIGN KEY (`id_perfil`) REFERENCES `tb_perfil` (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES ('ADMIN','1234','Juan','Carlos',2,3),('KLISMAN01','4321','Kllisman','Santillan',2,NULL),('TECNI','1234','Welitom','raza',3,1),('U001','1234','Klinsmann','Santillan',1,1),('U002','1234','Nikolas','Flores',4,2);
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'proyectosuperintendencia'
--

--
-- Dumping routines for database 'proyectosuperintendencia'
--
/*!50003 DROP PROCEDURE IF EXISTS `ups_validarAcceso` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ups_validarAcceso`(usr char(10),pas  varchar(10))
select * from tb_usuario where id_usuario = usr and contraseña = pas ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-21  9:58:51
