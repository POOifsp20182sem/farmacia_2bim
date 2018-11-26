CREATE DATABASE  IF NOT EXISTS `farmacia` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `farmacia`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: farmacia
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `classe_terapeutica`
--

DROP TABLE IF EXISTS `classe_terapeutica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classe_terapeutica` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe_terapeutica`
--

LOCK TABLES `classe_terapeutica` WRITE;
/*!40000 ALTER TABLE `classe_terapeutica` DISABLE KEYS */;
INSERT INTO `classe_terapeutica` VALUES (1,'teste'),(2,'Adstringente'),(3,'Amebicidas'),(4,'Bateriostático'),(5,'Broncodilatadores'),(6,'Calcitoninas'),(7,'Cicatrizante'),(8,'Descongestionante'),(9,'Diuréticos'),(10,'Emoliente'),(11,'Expectorantes'),(12,'Fibrinogênio'),(13,'Fibratos'),(14,'Gangliosideo'),(15,'Glicocorticóides'),(16,'Hormônio'),(17,'Hepatoprotetor'),(18,'Inibidores Fibrinólise'),(19,'Imunoglobulina Tetânica'),(20,'Laxante'),(21,'Lubrificante Oftálmico'),(22,'Monobactâmicos'),(23,'Mucolítico'),(24,'Nootrópicos'),(25,'Nitritos e Nitratos'),(26,'Orexígenos'),(27,'Polimixinas'),(28,'Pediculicida Sarnicida'),(29,'Quinolonas Urinários'),(30,'Quimioterápico Tópico'),(31,'Radiofármacos'),(32,'Regulador Intestinal'),(33,'Sedativo Hipnótico'),(34,'Soluções Aminoácidas Padrão'),(35,'Tecidos Hemostáticos'),(36,'Tranquilizantes'),(37,'Vasodilatadores'),(38,'Vasopressor'),(78,'classe 1'),(79,'classe 2'),(80,'classe 3');
/*!40000 ALTER TABLE `classe_terapeutica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `endereco` varchar(50) NOT NULL,
  `telefone` varchar(10) NOT NULL,
  `celular` varchar(11) DEFAULT NULL,
  `tipo_cliente` enum('juridica','fisica') NOT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `cnpj` varchar(14) DEFAULT NULL,
  `data_nascimento` date NOT NULL,
  `ativo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (7,'zé mane','eder@gmail.com','Rua x','3534652870','99999999999','fisica','12409536619',NULL,'2000-12-12',0),(8,'zé mane','ze@gmail.com','Rua 7','123213213','5454848444','juridica',NULL,'12409536619123','2000-10-15',0),(10,'Batman','eder@gmail.com','Rua x','3534652870','99999999999','fisica','12409536619',NULL,'2000-12-12',0),(11,'Éder','eder@gmail.com','Rua x','3534652870','99999999999','fisica','12409536619',NULL,'2000-12-12',0),(14,'Éder','eder@gmail','Monte Sião, Irineu Bernardi, 97, ','1988845','154544','fisica','12409534612','','1995-00-04',0),(16,'Éder','eder@gmail','Monte Sião, Irineu Bernardi, 97, ','1988845','154544','juridica','','12409534612','1995-00-04',0),(17,'aaa','asdasd','rua x','145454','45454','fisica','cpf',NULL,'1992-12-12',0),(20,'eder','adsad','asdasd','1213','12423','juridica',NULL,'1asdasd','1992-12-12',0),(21,'eder','eder','c, a, b, d','(11) 11111','(11) 111111','fisica',NULL,NULL,'1111-11-11',0),(22,'eder','eder','c, a, b, d','(11) 11111','(11) 111111','fisica',NULL,NULL,'1111-11-11',0),(23,'eder','eder','c, a, b, d','(11) 11111','(11) 111111','fisica',NULL,NULL,'1111-11-11',0),(24,'eder','eder','c, a, b, d','(11) 11111','(11) 111111','fisica',NULL,NULL,'1111-11-11',0),(25,'eder','eder','c, a, b, d','(11) 11111','(11) 111111','fisica',NULL,NULL,'1111-11-11',0),(26,'eder','eder','c, a, b, d','(11) 11111','(11) 111111','fisica',NULL,NULL,'1111-11-11',0),(27,'eder','der','c, a, b, d','2222222222','33333333333','fisica',NULL,NULL,'1111-11-11',0),(28,'joao','joao@lala.com','alameda, flor, caixa,34','1187654321','1109876543','fisica','12345678901',NULL,'2000-09-16',1),(29,'Ã‰der','eder@gmail','Monte Siï¿½o, Irineu Bernardi, 97, ','1988845','154544','juridica',NULL,'12409534612','1997-12-31',1),(30,'Ã‰der','eder@gmail','Monte Siï¿½o, Irineu Bernardi, 97, ','1988845','154544','juridica',NULL,'12409534612','1997-12-31',1),(31,'Ã‰der','eder@gmail','Monte Siï¿½o, Irineu Bernardi, 97, ','1988845','154544','juridica',NULL,'12409534612','1997-12-31',1),(32,'Ã‰der','eder@gmail','Monte Siï¿½o, Irineu Bernardi, 97, ','1988845','154544','juridica',NULL,'12409534612','1997-12-31',1),(34,'Teste','email@mail.com','rua das garcas, 65, jd mario, atibaia','1109876543','1112345678','fisica','12345678901',NULL,'2014-01-01',1),(35,'Teste','email@mail.com','rua das garcas, 65, jd mario, atibaia','1109876543','1112345678','fisica','12345678901',NULL,'2014-01-01',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `endereco` varchar(50) NOT NULL,
  `telefone` varchar(10) NOT NULL,
  `celular` varchar(11) DEFAULT NULL,
  `cpf` varchar(11) NOT NULL,
  `data_nascimento` date NOT NULL,
  `tipo_funcionario` enum('GERENTE','ATENDENTE') NOT NULL,
  `salario` double NOT NULL,
  `ativo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (2,'batatao','eder@gmail.com','Rua x','3534652870','99999999999','12409536619','2000-12-12','ATENDENTE',1200,1),(3,'aaa','aaa','aaa','aaa','aa','aaa','1987-12-12','',123,1),(4,'aaa','aaa','aaa','aaa','aa','aaa','1987-12-12','',123,1),(5,'aaa','aaa','aaa','aaa','aa','aaa','1987-12-12','ATENDENTE',123,1),(7,'a','b','c','12','345','123456','2000-09-09','ATENDENTE',1234.67,1),(8,'Teste','email@mail.com','rua das garcas, 65, jd mario, atibaia','1109876543','1112345678','12345678901','2001-01-20','ATENDENTE',1234.44,1),(9,'Teste','email@mail.com','rua das garcas, 65, jd mario, atibaia','1109876543','1112345678','12345678901','2001-01-20','ATENDENTE',1234.44,1),(11,'a','b','c','12','345','123456','2000-09-09','ATENDENTE',1234.67,1),(12,'a','b','c','12','345','123456','2000-09-09','ATENDENTE',1234.67,1),(13,'xsdfs','asadsad','adasdas','1234567897','123456787','123567','1209-11-09','ATENDENTE',1234.09,1),(14,'Teste','email@mail.com','rua das garcas, 65, jd mario, atibaia','1109876543','1112345678','12345678901','2001-01-20','ATENDENTE',1234.44,1),(15,'Teste','email@mail.com','rua das garcas, 65, jd mario, atibaia','1109876543','1112345678','12345678901','2001-01-20','ATENDENTE',1234.44,1),(16,'Teste','email@mail.com','rua das garcas, 65, jd mario, atibaia','1109876543','1112345678','12345678901','2001-01-20','ATENDENTE',1234.44,1),(17,'Teste','email@mail.com','rua das garcas, 65, jd mario, atibaia','1109876543','1112345678','12345678901','2001-01-20','ATENDENTE',1234.44,1),(18,'a','b','c','12','345','123456','2000-09-09','ATENDENTE',1234.67,1),(19,'Teste','email@mail.com','rua das garcas, 65, jd mario, atibaia','1109876543','1112345678','12345678901','2001-01-20','ATENDENTE',1234.44,1),(20,'Teste','email@mail.com','rua das garcas, 65, jd mario, atibaia','1109876543','1112345678','12345678901','2001-01-20','ATENDENTE',1234.44,1),(21,'Teste','email@mail.com','rua das garcas, 65, jd mario, atibaia','1109876543','1112345678','12345678901','2001-01-20','ATENDENTE',1234.44,1),(22,'Teste','email@mail.com','rua das garcas, 65, jd mario, atibaia','1109876543','1112345678','12345678901','2001-01-20','ATENDENTE',1234.44,1),(23,'Teste','email@mail.com','rua das garcas, 65, jd mario, atibaia','1109876543','1112345678','12345678901','2001-01-20','ATENDENTE',1234.44,1),(24,'Teste','email@mail.com','rua das garcas, 65, jd mario, atibaia','1109876543','1112345678','12345678901','2001-01-20','ATENDENTE',1234.44,1),(25,'Teste','email@mail.com','rua das garcas, 65, jd mario, atibaia','1109876543','1112345678','12345678901','2001-01-20','ATENDENTE',1234.44,1),(26,'a','b','c','12','345','123456','2000-09-09','ATENDENTE',1234.67,1),(27,'Teste','email@mail.com','rua das garcas, 65, jd mario, atibaia','1109876543','1112345678','12345678901','2001-01-20','ATENDENTE',1234.44,1),(28,'a','b','c','12','345','123456','2000-09-09','ATENDENTE',1234.67,1),(29,'a','b','c','12','345','123456','2000-09-09','ATENDENTE',1234.67,1),(30,'a','b','c','12','345','123456','2000-09-09','ATENDENTE',1234.67,1),(31,'a','b','c','12','345','123456','2000-09-09','ATENDENTE',1234.67,1),(32,'a','b','c','12','345','123456','2000-09-09','ATENDENTE',1234.67,1),(33,'a','b','c','12','345','123456','2000-09-09','ATENDENTE',1234.67,1),(35,'Teste','email@mail.com','rua das garcas, 65, jd mario, atibaia','1109876543','1112345678','12345678901','2001-01-20','ATENDENTE',1234.44,1),(36,'Teste','email@mail.com','rua das garcas, 65, jd mario, atibaia','1109876543','1112345678','12345678901','2001-01-20','ATENDENTE',1234.44,1),(37,'Teste','email@mail.com','rua das garcas, 65, jd mario, atibaia','1109876543','1112345678','12345678901','2001-01-20','ATENDENTE',1234.44,1);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens_pedido`
--

DROP TABLE IF EXISTS `itens_pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itens_pedido` (
  `produto_id` int(11) NOT NULL,
  `pedido_id` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `preco_unitario` double NOT NULL,
  PRIMARY KEY (`produto_id`,`pedido_id`),
  KEY `pedido_id` (`pedido_id`),
  CONSTRAINT `itens_pedido_ibfk_1` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`),
  CONSTRAINT `itens_pedido_ibfk_2` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens_pedido`
--

LOCK TABLES `itens_pedido` WRITE;
/*!40000 ALTER TABLE `itens_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `itens_pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `nome` varchar(40) NOT NULL,
  `senha` varchar(64) NOT NULL,
  `id_funcionario` int(11) NOT NULL,
  KEY `id_funcionario` (`id_funcionario`),
  CONSTRAINT `login_ibfk_1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('eder','123',1),('consoli','321',2),('admin','admin',3),('aaaa','1234',4),('lalala','098700',5),('aaaa','1234',12),('aaaa','1234',12),('eder','1234',13),('admin','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4',13),('lalala','1234',36),('alissa','1234',37);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimento`
--

DROP TABLE IF EXISTS `movimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sessao_id` int(11) NOT NULL,
  `pedido_id` int(11) DEFAULT NULL,
  `descricao` varchar(50) NOT NULL,
  `data_movimento` datetime NOT NULL,
  `valor_entrada` double NOT NULL,
  `valor_saida` double NOT NULL,
  `troco` double NOT NULL,
  `saldo` double NOT NULL,
  `forma_pagamento` enum('cartao','dinheiro') DEFAULT NULL,
  `nota_fiscal_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sessao_id` (`sessao_id`),
  KEY `pedido_id` (`pedido_id`),
  KEY `nota_fiscal_id` (`nota_fiscal_id`),
  CONSTRAINT `movimento_ibfk_1` FOREIGN KEY (`sessao_id`) REFERENCES `sessao` (`id`),
  CONSTRAINT `movimento_ibfk_2` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`),
  CONSTRAINT `movimento_ibfk_3` FOREIGN KEY (`nota_fiscal_id`) REFERENCES `nota_fiscal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimento`
--

LOCK TABLES `movimento` WRITE;
/*!40000 ALTER TABLE `movimento` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nota_fiscal`
--

DROP TABLE IF EXISTS `nota_fiscal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nota_fiscal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero_nf` int(11) NOT NULL,
  `status_nf` enum('AUTORIZADA','CANCELADA','PROCESSANDO') NOT NULL,
  `chave_nf` varchar(45) NOT NULL,
  `protocolo_nf` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_nf` (`numero_nf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota_fiscal`
--

LOCK TABLES `nota_fiscal` WRITE;
/*!40000 ALTER TABLE `nota_fiscal` DISABLE KEYS */;
/*!40000 ALTER TABLE `nota_fiscal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_pedido` int(11) NOT NULL,
  `forma_pagamento` varchar(45) DEFAULT NULL,
  `data_pagamento` date DEFAULT NULL,
  `valor_pago` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_pedido` (`id_pedido`),
  CONSTRAINT `pagamento_ibfk_1` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento`
--

LOCK TABLES `pagamento` WRITE;
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
INSERT INTO `pagamento` VALUES (1,3,'cartao','2018-11-01',90),(3,2,'cartao','2018-11-01',90),(4,2,'cartao','2018-11-01',90);
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_compra` date DEFAULT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `funcionario_id` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `desconto` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente_id` (`cliente_id`),
  KEY `funcionario_id` (`funcionario_id`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (2,'2005-10-29',7,2,100,0.1),(3,'2018-10-23',8,5,40,1);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `principio_ativo`
--

DROP TABLE IF EXISTS `principio_ativo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `principio_ativo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `principio_ativo`
--

LOCK TABLES `principio_ativo` WRITE;
/*!40000 ALTER TABLE `principio_ativo` DISABLE KEYS */;
INSERT INTO `principio_ativo` VALUES (1,'teste'),(2,'Acebrofilina'),(3,'Aceclofenaco'),(4,'Baclofeno'),(5,'Benzocaína'),(6,'Calcitriol'),(7,'Carbocisteína'),(8,'Deltametrina'),(9,'Desonida'),(10,'Ebastina'),(11,'Estradiol'),(12,'Fentanila'),(13,'Fenitoína'),(14,'Glicina'),(15,'Glicerina'),(16,'Halotano'),(17,'Haloperidol'),(18,'Ibuprofeno'),(19,'Icodextrina'),(20,'Jaborandi'),(21,'Lactase'),(22,'Lansoprazol'),(23,'Macitentana'),(24,'Magaldrato'),(25,'Nicotina'),(26,'Nicergolina'),(27,'Ocitocina'),(28,'Oxitocina'),(29,'Paracetamol'),(30,'Paricalcitol'),(31,'Quitosana'),(32,'Quelato de Cálcio'),(33,'Roxitromicina'),(34,'Secnidazol'),(35,'Simeticona'),(36,'Teofilina'),(37,'Tianeptina'),(38,'Ureia'),(39,'Urtiga Dioica'),(40,'Xilometazolina'),(41,'Zinco'),(42,'principio 1'),(43,'principio 2'),(44,'principio 3');
/*!40000 ALTER TABLE `principio_ativo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome_comercial` varchar(50) NOT NULL,
  `apresentacao` varchar(50) NOT NULL,
  `forma_farmaco` varchar(30) NOT NULL,
  `codigo_barras` varchar(13) DEFAULT NULL,
  `ativo` tinyint(1) DEFAULT '1',
  `classe_terapeutica_id` int(11) NOT NULL,
  `principio_ativo_id` int(11) NOT NULL,
  `preco_unitario` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `classe_terapeutica_id` (`classe_terapeutica_id`),
  KEY `principio_ativo_id` (`principio_ativo_id`),
  CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`classe_terapeutica_id`) REFERENCES `classe_terapeutica` (`id`),
  CONSTRAINT `produto_ibfk_2` FOREIGN KEY (`principio_ativo_id`) REFERENCES `principio_ativo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (6,'juju','dfadf','dragea','dfa',1,2,2,2132),(7,'aa','a','a','a',1,1,1,0),(8,'','','COMPRIMIDO','',1,1,1,0),(9,'jujusa','ssadasd','COMPRIMIDO','dsa45d4a2',1,1,1,0),(13,'juju','dfadf','dragea','dfa',1,2,2,2132);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessao`
--

DROP TABLE IF EXISTS `sessao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sessao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `func_abertura_id` int(11) NOT NULL,
  `func_fechamento_id` int(11) DEFAULT NULL,
  `saldo_inicial` double NOT NULL,
  `saldo_final` double DEFAULT NULL,
  `data_abertura` datetime DEFAULT NULL,
  `data_fechamento` datetime DEFAULT NULL,
  `status` enum('ABERTO','FECHADO') NOT NULL,
  `ativo` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `func_abertura_id` (`func_abertura_id`),
  KEY `func_fechamento_id` (`func_fechamento_id`),
  CONSTRAINT `sessao_ibfk_1` FOREIGN KEY (`func_abertura_id`) REFERENCES `funcionario` (`id`),
  CONSTRAINT `sessao_ibfk_2` FOREIGN KEY (`func_fechamento_id`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessao`
--

LOCK TABLES `sessao` WRITE;
/*!40000 ALTER TABLE `sessao` DISABLE KEYS */;
INSERT INTO `sessao` VALUES (4,2,NULL,1000,NULL,'2018-09-25 21:21:21',NULL,'FECHADO',1),(5,2,NULL,1000,NULL,'2018-09-25 21:21:21',NULL,'FECHADO',1),(6,2,NULL,1000,NULL,'2018-09-25 21:21:21',NULL,'ABERTO',1),(7,2,2,100,200,'2018-11-15 02:08:38','2018-11-15 02:08:39','FECHADO',1),(8,2,2,100,200,'2018-11-15 02:13:11','2018-11-15 02:13:12','FECHADO',1),(9,2,2,100,200,'2018-11-15 02:14:59','2018-11-15 02:14:59','FECHADO',0),(10,2,2,100,200,'2018-11-15 02:15:24','2018-11-15 02:15:25','FECHADO',0),(11,2,2,100,200,'2018-11-15 02:16:58','2018-11-15 02:16:58','FECHADO',0);
/*!40000 ALTER TABLE `sessao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'farmacia'
--

--
-- Dumping routines for database 'farmacia'
--
/*!50003 DROP FUNCTION IF EXISTS `validar_login` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `validar_login`(p_nome VARCHAR(40), p_senha VARCHAR(64)) RETURNS double
    READS SQL DATA
    DETERMINISTIC
BEGIN
	IF (EXISTS(SELECT id_funcionario FROM login WHERE nome = p_nome AND senha = p_senha )) THEN                                             
		RETURN TRUE;                                                                                                                         
	END IF; 
RETURN FALSE;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alterar_caixa` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alterar_caixa`(IN p_id_caixa INT,
								IN p_func_aber INT,
                                IN p_func_fec INT,
                                IN p_saldo_inical DOUBLE,
                                IN p_saldo_final DOUBLE,
                                IN p_data_abertura DATETIME,
                                IN p_data_fechamento DATETIME,
                                IN p_status ENUM('ABERTO', 'FECHADO'))
BEGIN
	UPDATE sessao c
		SET
			c.func_abertura_id = p_func_aber,
            c.func_fechamento_id = p_func_fec,
            c.saldo_inicial = p_saldo_inical,
            c.saldo_final = p_saldo_final,
            c.data_abertura = data_abertura,
            c.data_fechamento = p_data_fechamento,
            c.status = p_status
		WHERE
			c.id = p_id_caixa;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alterar_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alterar_cliente`(
IN p_id int,
IN p_nome varchar(50),
IN p_email varchar(50),
IN p_endereco varchar(50),
IN p_telefone varchar(10),
IN p_celular varchar(11),
IN p_tipo_cliente enum('juridica','fisica'),
IN p_documento varchar(14) ,
IN p_data_nascimento date
)
BEGIN

IF p_tipo_cliente = 'fisica' THEN

	UPDATE cliente
	SET
		nome = p_nome, 
		email = p_email, 
		endereco = p_endereco, 
		telefone = p_telefone, 
		celular = p_celular, 
		tipo_cliente = p_tipo_cliente,
		cnpj = NULL,
		cpf = p_documento, 
		data_nascimento = p_data_nascimento
	WHERE id = p_id;

ELSE 
	UPDATE cliente
	SET
		nome = p_nome, 
		email = p_email, 
		endereco = p_endereco, 
		telefone = p_telefone, 
		celular = p_celular, 
		tipo_cliente = p_tipo_cliente,
		cnpj = p_documento,
		cpf = NULL, 
		data_nascimento = p_data_nascimento
	WHERE id = p_id;

END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alterar_funcionario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alterar_funcionario`(
IN p_id int,
IN p_nome varchar(50),
IN p_email varchar(50) ,
IN p_endereco varchar(50) ,
IN p_telefone varchar(10),
IN p_celular varchar(11),
IN p_cpf varchar(11),
IN p_data_nascimento date,
IN p_tipo_funcionario enum('gerente','atendente'),
IN p_salario double,
IN p_user varchar(40),
IN p_senha varchar(40)
)
BEGIN
	
    UPDATE funcionario 
    SET
    nome = p_nome,
    email = p_email,
    endereco = p_endereco,
    telefone = p_telefone,
    celular = p_celular,
    cpf = p_cpf,
    data_nascimento = p_data_nascimento,
    tipo_funcionario = p_tipo_funcionario,
    salario = p_salario
    WHERE
    id = p_id;
    
    UPDATE login SET
    nome = p_user,
    senha = p_senha
    WHERE
    funcionario.id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alterar_itens_pedido` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alterar_itens_pedido`(
IN p_old_produto_id	int(11),
IN p_old_pedido_id	int(11),
IN p_new_produto_id	int(11),
IN p_new_pedido_id	int(11),
IN p_quantidade	int(11),
IN p_preco_unitario	double
)
BEGIN
	UPDATE itens_pedido 
    SET
    produto_id = p_new_produto_id,
    pedido_id= p_new_pedido_id,
    quantidade = p_quantidade,
    preco_unitario = p_preco_unitario
    WHERE 
    produto_id = p_old_produto_id 
    AND
    pedido_id= p_old_pedido_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alterar_pedido` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alterar_pedido`(
IN p_id int(11),
IN p_cliente_id int(11),
IN p_funcionario_id int(11),
IN p_desconto double,
IN p_total double,
IN p_data_compra date
)
BEGIN
	UPDATE pedido
    SET 
    cliente_id = p_cliente_id,
    funcionario_id = p_funcionario_id,
    desconto = p_desconto,
    total = p_total,
    data_compra = p_data_compra
    WHERE 
    id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alterar_produto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alterar_produto`(
IN p_id int(11),
IN p_nome_comercial varchar(50),
IN p_apresentacao varchar(50),
IN p_forma_farmaco varchar(30),
IN p_principio_ativo_id int(11),
IN p_codigo_barras varchar(13),
IN p_classe_terapeutica_id int(11),
IN p_preco_unitario double)
BEGIN
	UPDATE produto SET
    nome_comercial = p_nome_comercial,
    apresentacao = p_apresentacao,
    forma_farmaco = p_forma_farmaco,
    principio_ativo_id = p_principio_ativo_id,
    codigo_barras = p_codigo_barras,
    classe_terapeutica_id = p_classe_terapeutica_id,
    preco_unitario = p_preco_unitario
    WHERE 
    id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alterar_sessao` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alterar_sessao`(IN p_id INT, IN p_func_abertura INT, IN p_func_fechamento_id INT,
									IN p_saldo_inicial DOUBLE, IN p_saldo_final DOUBLE,
                                    IN p_data_abertura DATETIME, IN p_data_fechamento DATETIME,
                                    IN p_status enum('ABERTO','FECHADO'))
BEGIN
	UPDATE sessao s                                                  
		SET                                                          
			s.func_abertura_id = p_func_abertura_id,                 
			s.func_fechamento_id = p_func_fechamento_id,             
			s.saldo_inicial = p_saldo_inicial,                       
			s.saldo_final = p_saldo_final,                           
			s.data_abertura = p_data_abertura,                       
			s.data_fechamento = p_data_fechamento,
            s.status = p_status
		WHERE                                                        
			s.id = p_id; 	
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_classe_terapeutica` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_classe_terapeutica`()
BEGIN
	SELECT * FROM classe_terapeutica;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_clientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_clientes`(IN filter varchar(50))
BEGIN

# pensar em diferentes modos de filtragem de dados
# converter todos os dados para upper ou converter apenas na busca?

	IF filter LIKE '' THEN
		SELECT id, nome, email, endereco,telefone, celular, tipo_cliente, cpf, cnpj, data_nascimento 
			FROM cliente 
				WHERE ativo IS TRUE;
	ELSE
		SELECT id, nome, email, endereco,telefone, celular, tipo_cliente, cpf, cnpj, data_nascimento
			FROM cliente
				WHERE 
					(nome LIKE CONCAT('%', filter,'%') OR
					email LIKE CONCAT('%', filter,'%') OR
					endereco LIKE CONCAT('%', filter,'%') OR
					telefone LIKE CONCAT('%', filter,'%') OR
					celular LIKE CONCAT('%', filter,'%') OR
					tipo_cliente LIKE CONCAT('%', filter,'%') OR
					cpf LIKE CONCAT('%', filter,'%') OR
					cnpj LIKE CONCAT('%', filter,'%')) AND ativo IS TRUE;
	END IF;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_funcionarios` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_funcionarios`(IN filter varchar(50))
BEGIN

# pensar em diferentes modos de filtragem de dados
# converter todos os dados para upper ou converter apenas na busca?

	IF filter LIKE '' THEN
		SELECT id, nome, email, endereco, telefone, celular, cpf, data_nascimento, tipo_funcionario, salario
        FROM funcionario WHERE ativo IS TRUE;
	ELSE
		SELECT id, nome,email, endereco, telefone, celular, cpf, data_nascimento, tipo_funcionario, salario
			FROM funcionario
				WHERE 
					(nome LIKE CONCAT('%', filter,'%') OR
					email LIKE CONCAT('%', filter,'%') OR
					endereco LIKE CONCAT('%', filter,'%') OR
					telefone LIKE CONCAT('%', filter,'%') OR
					celular LIKE CONCAT('%', filter,'%') OR
					tipo_funcionario LIKE CONCAT('%', filter,'%') OR
					cpf LIKE CONCAT('%', filter,'%')) AND ativo IS TRUE;
	END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_movimento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_movimento`(
IN filter varchar(50))
BEGIN
	IF filter LIKE '' THEN
		SELECT id, sessao_id, pedido_id, descricao, data_movimento, valor_entrada, valor_saida, troco, saldo, forma_pagamento, nota_fiscal_id
        FROM movimento;
	ELSE
    #Por enquanto a pesquisa vai ficar simples, posteriormente pesquisar por período
		SELECT id, sessao_id, pedido_id, descricao, data_movimento, valor_entrada, valor_saida, troco, saldo, forma_pagamento, nota_fiscal_id
			FROM movimento
				WHERE
					descricao LIKE CONCAT('%', filter,'%') OR
					forma_pagamento LIKE CONCAT('%', filter,'%') OR
					nota_fiscal_id LIKE CONCAT('%', filter,'%');
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_pedidos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_pedidos`(IN filter varchar(50))
BEGIN

# pensar em um modo de pesquisa por período
# e um modo eficiente de procurar só com através do id

	IF filter IS NULL THEN
		SELECT p.id, p.data_compra, p.cliente_id,c.nome, p.funcionario_id,f.nome, p.total, p.desconto
			FROM pedido as p 
				INNER JOIN cliente c on (p.cliente_id = c.id)
				INNER JOIN funcionario f on (p.funcionario_id = f.id);
	ELSE
		SELECT p.id, p.data_compra, p.cliente_id,c.nome, p.funcionario_id,f.nome as 'nome_fun', p.total, p.desconto
			FROM pedido as p 
				INNER JOIN cliente c on (p.cliente_id = c.id)
				INNER JOIN funcionario f on (p.funcionario_id = f.id)
					WHERE  
						p.id LIKE CONCAT('%', filter,'%') OR
						f.nome LIKE CONCAT('%', filter,'%') OR
						c.nome LIKE CONCAT('%', filter,'%') OR
						data_compra LIKE CONCAT('%', filter,'%');
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_principio_ativo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_principio_ativo`()
BEGIN
	SELECT * FROM principio_ativo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_produtos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_produtos`(IN filter varchar(50))
BEGIN

# pensar em diferentes modos de filtragem de dados
# converter todos os dados para upper ou converter apenas na busca?
# fazer inner join para buscar por classe terapeutica e princípio ativo?

	IF filter LIKE '' THEN
		SELECT id, nome_comercial, apresentacao, forma_farmaco, codigo_barras, preco_unitario, classe_terapeutica_id, principio_ativo_id
			FROM produto 
				WHERE ativo is TRUE;
	ELSE
		SELECT id, nome_comercial, apresentacao, forma_farmaco, codigo_barras, preco_unitario, classe_terapeutica_id, principio_ativo_id
			FROM produto
				WHERE 
					(nome_comercial LIKE CONCAT('%', filter,'%') OR
					apresentacao LIKE CONCAT('%', filter,'%') OR
					forma_farmaco LIKE CONCAT('%', filter,'%') OR
					codigo_barras LIKE CONCAT('%', filter,'%')) AND ativo IS TRUE;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_sessao` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_sessao`(IN p_filtro VARCHAR(15))
BEGIN
	IF p_filtro = '' THEN
		SELECT `id`,
				`func_abertura_id`,
				`func_fechamento_id`,
				`saldo_inicial`,
				`saldo_final`,
				`data_abertura`,
				`data_fechamento`,
				`status`
		FROM sessao s
        WHERE s.ativo is true;
    ELSE
		SELECT `id`,
				`func_abertura_id`,
				`func_fechamento_id`,
				`saldo_inicial`,
				`saldo_final`,
				`data_abertura`,
				`data_fechamento`,
				`status`
		FROM sessao s
        WHERE
			(
				`id` LIKE CONCAT('%', p_filtro, '%')  OR
				`func_abertura_id` LIKE CONCAT('%', p_filtro, '%') OR
				`func_fechamento_id` LIKE CONCAT('%', p_filtro, '%') OR
				`saldo_inicial` LIKE CONCAT('%', p_filtro, '%') OR
				`saldo_final` LIKE CONCAT('%', p_filtro, '%') OR
				`data_abertura` LIKE CONCAT('%', p_filtro, '%') OR
				`data_fechamento` LIKE CONCAT('%', p_filtro, '%') OR
				`status` LIKE CONCAT('%', p_filtro, '%')
			)
        AND s.ativo is true;
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `excluir_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `excluir_cliente`(IN p_id int)
BEGIN
	
    # if the cliente has any association he has the field ativo modify to false
	IF EXISTS(SELECT id FROM pedido where cliente_id = p_id) THEN
		UPDATE cliente SET
			ativo = FALSE 
				WHERE id = p_id;
	# if the cliente does not have any association with another table he can be deleted
    ELSE
		DELETE FROM cliente where id = p_id;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `excluir_funcionario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `excluir_funcionario`(IN p_id int)
BEGIN
	IF EXISTS(SELECT id FROM pedido where funcionario_id = p_id) THEN
		UPDATE funcionario SET
			ativo = FALSE 
				WHERE id = p_id;
    ELSE
			DELETE FROM funcionario where id = p_id;
    END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `excluir_itens_pedido` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `excluir_itens_pedido`(
IN p_produto_id	int(11),
IN p_pedido_id	int(11)
)
BEGIN
	DELETE from itens_pedido where produto_id = p_produto_id AND pedido_id = p_pedido_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `excluir_pagamento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `excluir_pagamento`(in p_id int)
BEGIN
	
    delete from pagamento where id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `excluir_pedido` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `excluir_pedido`(
IN p_id int(11)
)
BEGIN
	DELETE FROM pedido where id = p_id;
	#posso colocar um variavel para o status e também uma para ocultar
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `excluir_produto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `excluir_produto`(IN p_id int)
BEGIN

	IF EXISTS(SELECT id FROM itens_pedido where produto_id = p_id) THEN
		UPDATE produto SET
			ativo = FALSE 
				WHERE id = p_id;
    ELSE
			DELETE FROM produto where id = p_id;
    END IF;
    
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `excluir_sessao` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `excluir_sessao`(IN p_id INT)
BEGIN
	UPDATE sessao s
		SET
			s.ativo = false
		WHERE
			s.id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserir_caixa` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_caixa`(IN p_id_func_abertura INT,
															IN p_saldo_inicial DOUBLE,
															IN p_abertura DATETIME,
                                                            IN p_status enum('ABERTO','FECHADO'))
BEGIN
	INSERT INTO sessao (func_abertura_id, saldo_inicial, data_abertura, status)
		VALUES (
                p_id_func_abertura,
                p_saldo_inicial,
                p_abertura,
                p_status
                );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserir_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_cliente`(
IN p_nome varchar(50),
IN p_email varchar(50),
IN p_endereco varchar(50),
IN p_telefone varchar(10),
IN p_celular varchar(11),
IN p_tipo_cliente enum('juridica','fisica'),
IN p_documento varchar(14) ,
IN p_data_nascimento date
)
BEGIN

# criar um campo para documento (generico) ou fazer este processo sempre?

IF p_tipo_cliente = 'fisica' THEN

	INSERT INTO cliente
		(nome, email, endereco, telefone, celular, tipo_cliente, cpf, cnpj, data_nascimento) 
	VALUES
		(
		p_nome,
		p_email,
		p_endereco,
		p_telefone,
		p_celular,
		p_tipo_cliente,
		p_documento, null,
		p_data_nascimento
		);
ELSE
	INSERT INTO cliente
		(nome, email, endereco, telefone, celular, tipo_cliente, cpf, cnpj, data_nascimento) 
	VALUES
		(
		p_nome,
		p_email,
		p_endereco,
		p_telefone,
		p_celular,
		p_tipo_cliente,
		null, p_documento,
		p_data_nascimento
		);

END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserir_funcionario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_funcionario`(
IN p_nome varchar(50),
IN p_email varchar(50) ,
IN p_endereco varchar(50) ,
IN p_telefone varchar(10),
IN p_celular varchar(11),
IN p_cpf varchar(11),
IN p_data_nascimento date,
IN p_tipo_funcionario enum('GERENTE','ATENDENTE'),
IN p_salario double

)
BEGIN
	INSERT INTO funcionario
    (nome, email, endereco, telefone, celular, cpf, data_nascimento, tipo_funcionario, salario)
    VALUES
    (p_nome,
    p_email,
    p_endereco,
    p_telefone,
    p_celular,
    p_cpf,
    p_data_nascimento,
    p_tipo_funcionario,
    p_salario
    );

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserir_itens_pedido` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_itens_pedido`(
IN p_produto_id	int(11),
IN p_pedido_id	int(11),
IN p_quantidade	int(11),
IN p_preco_unitario	double
)
BEGIN
	INSERT INTO itens_pedido 
    VALUES
    (
    p_produto_id,
    p_pedido_id,
    p_quantidade,
    p_preco_unitario
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserir_login` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_login`(
IN p_user varchar(40),
IN p_senha varchar(64)
)
BEGIN

set @ultimo_id = (SELECT max(id) FROM funcionario);

    INSERT INTO login (nome, senha, id_funcionario) VALUES (p_user, p_senha, @ultimo_id); 
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserir_movimento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_movimento`(
IN p_sessao_id int(11),
IN p_pedido_id int(11),
IN p_descricao varchar(50),
IN p_data_movimento datetime,
IN p_valor_entrada double,
IN p_valor_saida double,
IN p_troco double,
IN p_saldo double,
IN p_forma_pagamento enum('cartao','dinheiro'),
IN p_nota_fiscal_id int(11)
)
BEGIN

	INSERT INTO movimento (sessao_id, pedido_id, descricao, data_movimento, valor_entrada, valor_saida, troco, saldo, forma_pagamento, nota_fiscal_id) 
    VALUES 
    (
    p_sessao_id,
    p_pedido_id,
    p_descricao,
    p_data_movimento,
    p_valor_entrada,
    p_valor_saida,
    p_troco, 
    p_saldo,
    p_forma_pagamento,
    p_nota_fiscal_id
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserir_nota_fiscal` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_nota_fiscal`(
IN p_numero_nf int(11),
IN p_status_nf enum('AUTORIZADA','CANCELADA','PROCESSANDO'),
IN p_chave_nf varchar(45),
IN p_protocolo_nf	varchar(40)
)
BEGIN
	INSERT INTO nota_fiscal (numero_nf, status_nf, chave_nf, protocolo_nf) 
		VALUES
        (
        p_numero_nf,
        p_status_nf,
        p_chave_nf,
        p_protocolo_nf
        );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserir_pagamento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_pagamento`(in p_id_pedido int,
in p_forma_pagamento varchar(45),
in p_data_pagamento date,
in p_valor_pago double
)
BEGIN
	
    insert into pagamento(id_pedido, forma_pagamento, data_pagamento, valor_pago)
		values (p_id_pedido, p_forma_pagamento, p_data_pagamento, p_valor_pago);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserir_pedido` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_pedido`(
IN p_cliente_id int(11),
IN p_funcionario_id int(11),
IN p_desconto double,
IN p_total double,
IN p_data_compra date
)
BEGIN
	INSERT INTO pedido
    (cliente_id, funcionario_id,desconto,total,data_compra)
    VALUES
    (
    p_cliente_id,
    p_funcionario_id,
    p_desconto,
    p_total,
    p_data_compra
    );
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserir_produto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_produto`(
IN p_nome_comercial varchar(50),
IN p_apresentacao varchar(50),
IN p_forma_farmaco varchar(30),
IN p_codigo_barras varchar(13),
IN p_principio_ativo_id int(11),
IN p_classe_terapeutica_id int(11),
IN p_preco_unitario double)
BEGIN
	INSERT INTO produto
    (nome_comercial, apresentacao, forma_farmaco, codigo_barras, preco_unitario, classe_terapeutica_id, principio_ativo_id)
    VALUES
    (p_nome_comercial,
	p_apresentacao,
	p_forma_farmaco,
	p_codigo_barras,
	p_preco_unitario,
	p_classe_terapeutica_id,
	p_principio_ativo_id
	);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserir_sessao` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserir_sessao`(IN p_func_abertura INT, IN p_func_fechamento_id INT,
									IN p_saldo_inicial DOUBLE, IN p_data_abertura DATETIME, IN p_status enum('ABERTO','FECHADO'))
BEGIN
	INSERT INTO sessao (func_abertura_id, func_fechamento_id, saldo_inicial, data_abertura, status)
    VALUES (p_func_abertura, p_func_fechamento_id, p_saldo_inicial, p_data_abertura, p_status);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `salvar_sessao` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `salvar_sessao`(
IN p_func_abertura_id int(11),
IN p_func_fechamento_id int(11),
IN p_saldo_inicial double,
IN p_saldo_final double,
IN p_data_abertura datetime,
IN p_data_fechamento datetime
)
BEGIN
	set @last_id = (SELECT max(id) FROM sessao);

	IF((SELECT `status` FROM sessao WHERE id = @last_id) LIKE 'FECHADO') THEN
    
		INSERT INTO sessao (func_abertura_id, saldo_inicial, data_abertura, status) 
			VALUES 
			(
			p_func_abertura_id,
			p_saldo_inicial,
			p_data_abertura,
			'ABERTO' 
			);
	ELSE
		UPDATE sessao
        SET
			func_fechamento_id = p_func_fechamento_id,
			saldo_final = p_saldo_final,
			data_fechamento = p_data_fechamento,
			status = 'FECHADO'
            WHERE id = @last_id;
    END IF;

END ;;
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

-- Dump completed on 2018-11-24 21:47:49
