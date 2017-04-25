CREATE DATABASE  IF NOT EXISTS `moviltrackerdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `moviltrackerdb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: moviltrackerdb
-- ------------------------------------------------------
-- Server version	5.7.17-0ubuntu0.16.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asignacion`
--

DROP TABLE IF EXISTS `asignacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asignacion` (
  `asignacion_id` int(11) NOT NULL AUTO_INCREMENT,
  `efectivo_id` int(11) DEFAULT NULL,
  `vehiculo_id` int(11) DEFAULT NULL,
  `comisaria_id` int(11) DEFAULT NULL,
  `zona_id` int(11) DEFAULT NULL,
  `fecha_asignacion` date DEFAULT NULL,
  `activo` bit(1) DEFAULT b'1',
  PRIMARY KEY (`asignacion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignacion`
--

LOCK TABLES `asignacion` WRITE;
/*!40000 ALTER TABLE `asignacion` DISABLE KEYS */;
INSERT INTO `asignacion` VALUES (1,1,1,3,2,'2017-01-01','');
/*!40000 ALTER TABLE `asignacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comisaria`
--

DROP TABLE IF EXISTS `comisaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comisaria` (
  `comisaria_id` int(11) NOT NULL AUTO_INCREMENT,
  `comisaria` varchar(200) DEFAULT NULL,
  `activo` int(11) DEFAULT '1',
  PRIMARY KEY (`comisaria_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comisaria`
--

LOCK TABLES `comisaria` WRITE;
/*!40000 ALTER TABLE `comisaria` DISABLE KEYS */;
INSERT INTO `comisaria` VALUES (1,'Ancón',1),(2,'Ate',1),(3,'Barranco',1),(4,'Bellavista',1),(5,'Breña',1),(6,'Callao',1),(7,'Carabayllo',1),(8,'Carmen de la Legua',1),(9,'Cercado de Lima',1),(10,'Chaclacayo',1),(11,'Chorrillos',1),(12,'Chosica',1),(13,'Cieneguilla',1),(14,'Comas',1),(15,'El agustino',1),(16,'Independencia',1),(17,'Jesús María',1),(18,'La Molina',1),(19,'La Perla',1),(20,'La Punta',1),(21,'La Victoria',1),(22,'Lince',1),(23,'Los Olivos',1),(24,'Lurín',1),(25,'Magdalena',1),(26,'Miraflores',1),(27,'Pachacámac',1),(28,'Pueblo Libre',1),(29,'Puente Piedra',1),(30,'Rimac',1),(31,'Salamanca',1),(32,'San Borja',1),(33,'San Isidro',1),(34,'San Juan de Lurigancho',1),(35,'San Juan de Miraflores',1),(36,'San Luis',1),(37,'San Martín de Porres',1),(38,'San Miguel',1),(39,'Santa Anita',1),(40,'Santa Rosa',1),(41,'Santiago de surgo',1),(42,'Surquillo',1),(43,'Ventanilla',1),(44,'Villa El Salvador',1),(45,'Villa María del Triunfo',1);
/*!40000 ALTER TABLE `comisaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `efectivo`
--

DROP TABLE IF EXISTS `efectivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `efectivo` (
  `efectivo_id` int(11) NOT NULL AUTO_INCREMENT,
  `efectivo_cip` varchar(50) DEFAULT NULL,
  `nombres` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `grado_id` int(11) DEFAULT NULL,
  `activo` bit(1) DEFAULT b'1',
  PRIMARY KEY (`efectivo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `efectivo`
--

LOCK TABLES `efectivo` WRITE;
/*!40000 ALTER TABLE `efectivo` DISABLE KEYS */;
INSERT INTO `efectivo` VALUES (1,'123456789','Elmer Cenario','Quintana Sevilla',1,''),(2,'12345645','Fernando Enrique','Valenzuela Zumarriva',3,'\0'),(3,'015478985','Valentina del Rosario','Berrio Huarancca',2,'\0');
/*!40000 ALTER TABLE `efectivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grado`
--

DROP TABLE IF EXISTS `grado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grado` (
  `grado_id` int(11) NOT NULL AUTO_INCREMENT,
  `grado` varchar(255) DEFAULT NULL,
  `activo` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`grado_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grado`
--

LOCK TABLES `grado` WRITE;
/*!40000 ALTER TABLE `grado` DISABLE KEYS */;
INSERT INTO `grado` VALUES (1,'Sub Oficial de Tercra',''),(2,'Sub Oficial de Segunda',''),(3,'Sub Oficial de Primera',''),(4,'Sub Oficial Tecnico de Tercera',''),(5,'Sub Oficial Tecnico de Segunda',''),(6,'Sub Oficial Tecnico de Primera',''),(7,'Sub Oficial Brigadier',''),(8,'Sub Oficial Superior',''),(9,'Alférez',''),(10,'Teniente',''),(11,'Capitán',''),(12,'Mayor',''),(13,'Comandante',''),(14,'Coronel',''),(15,'General',''),(16,'Teniente General','');
/*!40000 ALTER TABLE `grado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca` (
  `marca_id` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(45) DEFAULT NULL,
  `activo` bit(1) DEFAULT b'1',
  PRIMARY KEY (`marca_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (1,'Abarth',''),(2,'Alfa Romeo',''),(3,'Aston Martin',''),(4,'Audi',''),(5,'Bentley',''),(6,'BMW',''),(7,'Cadillac',''),(8,'Caterham',''),(9,'Chevrolet',''),(10,'Citroen',''),(11,'Dacia',''),(12,'Ferrari',''),(13,'Fiat',''),(14,'Ford',''),(15,'Honda',''),(16,'Infiniti',''),(17,'Isuzu',''),(18,'Iveco',''),(19,'Jaguar',''),(20,'Jeep',''),(21,'Kia',''),(22,'KTM',''),(23,'Lada',''),(24,'Lamborghini',''),(25,'Lancia',''),(26,'Land Rover',''),(27,'Lexus',''),(28,'Lotus',''),(29,'Maserati',''),(30,'Mazda',''),(31,'Mercedes-Benz',''),(32,'Mini',''),(33,'Mitsubishi',''),(34,'Morgan',''),(35,'Nissan',''),(36,'Opel',''),(37,'Peugeot',''),(38,'Piaggio',''),(39,'Porsche',''),(40,'Renault',''),(41,'Rolls-Royce',''),(42,'Seat',''),(43,'Skoda',''),(44,'Smart',''),(45,'SsangYong',''),(46,'Subaru',''),(47,'Suzuki',''),(48,'Tata',''),(49,'Tesla',''),(50,'Toyota',''),(51,'Volkswagen',''),(52,'Volvo','');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil` (
  `efectivo_id` int(11) DEFAULT NULL,
  `nombres` varchar(200) DEFAULT NULL,
  `apellidos` varchar(200) DEFAULT NULL,
  `grado` varchar(200) DEFAULT NULL,
  `comisaria` varchar(200) DEFAULT NULL,
  `zona` varchar(200) DEFAULT NULL,
  `marca` varchar(200) DEFAULT NULL,
  `nro_placa` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `usuario_id` int(11) NOT NULL AUTO_INCREMENT,
  `efectivo_id` int(11) NOT NULL,
  `efectivo_cip` varchar(50) NOT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `activo` bit(1) DEFAULT b'1',
  PRIMARY KEY (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,1,'123456789','elmercito123','');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehiculo` (
  `vehiculo_id` int(11) NOT NULL AUTO_INCREMENT,
  `nro_placa` varchar(50) DEFAULT NULL,
  `marca_id` int(11) DEFAULT NULL,
  `activo` bit(1) DEFAULT b'1',
  `anio_fabricacion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vehiculo_id`),
  KEY `fk_vehiculo_marca_idx` (`marca_id`),
  CONSTRAINT `fk_vehiculo_marca` FOREIGN KEY (`marca_id`) REFERENCES `marca` (`marca_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` VALUES (1,'ERG-2345',2,'','1998'),(2,'ATX-9274',7,'','2012');
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zona`
--

DROP TABLE IF EXISTS `zona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zona` (
  `zona_id` int(11) NOT NULL AUTO_INCREMENT,
  `zona` varchar(45) DEFAULT NULL,
  `activo` bit(1) DEFAULT b'1',
  PRIMARY KEY (`zona_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zona`
--

LOCK TABLES `zona` WRITE;
/*!40000 ALTER TABLE `zona` DISABLE KEYS */;
INSERT INTO `zona` VALUES (1,'Zona norte',''),(2,'Zon sur',''),(3,'Zona este',''),(4,'Zon oeste','');
/*!40000 ALTER TABLE `zona` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-17  4:10:23
