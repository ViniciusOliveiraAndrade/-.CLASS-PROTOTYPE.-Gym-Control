CREATE DATABASE  IF NOT EXISTS `academia` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `academia`;
-- MySQL dump 10.13  Distrib 5.7.12, for Linux (i686)
--
-- Host: localhost    Database: academia
-- ------------------------------------------------------
-- Server version	5.7.12-0ubuntu1

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
-- Table structure for table `Atividades`
--

DROP TABLE IF EXISTS `Atividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Atividades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `segunda` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Atividades`
--

LOCK TABLES `Atividades` WRITE;
/*!40000 ALTER TABLE `Atividades` DISABLE KEYS */;
INSERT INTO `Atividades` VALUES (1,':1:1:1:1:1:1:1:2:2:2:2:2:2:2:3:3:3:3:3:3:3:4:4:4:4:4:4:4:5:5:5:5:5:5:5');
/*!40000 ALTER TABLE `Atividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DadosPessoa`
--

DROP TABLE IF EXISTS `DadosPessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DadosPessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `braco` double NOT NULL,
  `cintura` double NOT NULL,
  `coxa` double NOT NULL,
  `panturrilha` double NOT NULL,
  `quadril` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DadosPessoa`
--

LOCK TABLES `DadosPessoa` WRITE;
/*!40000 ALTER TABLE `DadosPessoa` DISABLE KEYS */;
INSERT INTO `DadosPessoa` VALUES (1,0,0,0,0,0);
/*!40000 ALTER TABLE `DadosPessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Endereco`
--

DROP TABLE IF EXISTS `Endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Endereco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `numero` int(11) NOT NULL,
  `rua` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Endereco`
--

LOCK TABLES `Endereco` WRITE;
/*!40000 ALTER TABLE `Endereco` DISABLE KEYS */;
INSERT INTO `Endereco` VALUES (1,'2','22222222',2,'Instrutor'),(2,'333','        ',3,'Aluno'),(3,'3','22222222',2,'Admin');
/*!40000 ALTER TABLE `Endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pessoa`
--

DROP TABLE IF EXISTS `Pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Pessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `altura` double NOT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `pagamento` double NOT NULL,
  `peso` double NOT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `tipo` int(11) NOT NULL,
  `atividades_id` int(11) DEFAULT NULL,
  `dados_id` int(11) DEFAULT NULL,
  `endereco_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gej40f8jfd5efnwlggtpwjloo` (`cpf`),
  KEY `FK_sbmsbk3olnh0cis30uk85rxg6` (`atividades_id`),
  KEY `FK_hjppigkb7xq56vy5rt9g4dehr` (`dados_id`),
  KEY `FK_buhd5wq46ssq3db3crto3qptb` (`endereco_id`),
  CONSTRAINT `FK_buhd5wq46ssq3db3crto3qptb` FOREIGN KEY (`endereco_id`) REFERENCES `Endereco` (`id`),
  CONSTRAINT `FK_hjppigkb7xq56vy5rt9g4dehr` FOREIGN KEY (`dados_id`) REFERENCES `DadosPessoa` (`id`),
  CONSTRAINT `FK_sbmsbk3olnh0cis30uk85rxg6` FOREIGN KEY (`atividades_id`) REFERENCES `Atividades` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pessoa`
--

LOCK TABLES `Pessoa` WRITE;
/*!40000 ALTER TABLE `Pessoa` DISABLE KEYS */;
INSERT INTO `Pessoa` VALUES (1,0,'22222222222','Instrutor',0,0,'2','22222222222',3,NULL,NULL,1),(2,3,'33333333333','Aluno',0,3,'3','           ',1,1,1,2),(3,0,'11111111111','Admin',0,0,'1','0000',2,NULL,NULL,3);
/*!40000 ALTER TABLE `Pessoa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-18 22:03:15
