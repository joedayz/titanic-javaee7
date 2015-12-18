
DROP TABLE IF EXISTS `pvm_bus`;

CREATE TABLE `pvm_bus` (
  `ide_bus` bigint(20) NOT NULL AUTO_INCREMENT,
  `con_aire_acondicionado` tinyint(1) DEFAULT NULL,
  `descripcion_bus` varchar(255) NOT NULL,
  `numero_motor` varchar(50) DEFAULT NULL,
  `placa` varchar(10) NOT NULL,
  PRIMARY KEY (`ide_bus`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO `pvm_bus` (`ide_bus`, `con_aire_acondicionado`, `descripcion_bus`, `numero_motor`, `placa`)
VALUES
	(6,1,'AKG-247','123434','AKG-247'),
	(7,1,'PPK-123','1234567890','PPK-123');

DROP TABLE IF EXISTS `pvm_fila`;

CREATE TABLE `pvm_fila` (
  `ide_fila` bigint(20) NOT NULL AUTO_INCREMENT,
  `es_primer_piso` tinyint(1) DEFAULT NULL,
  `ide_bus` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_fila`),
  KEY `FK_7uf3ee033ut9vm2957trbu8p8` (`ide_bus`),
  CONSTRAINT `FK_7uf3ee033ut9vm2957trbu8p8` FOREIGN KEY (`ide_bus`) REFERENCES `pvm_bus` (`ide_bus`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `pvm_fila` (`ide_fila`, `es_primer_piso`, `ide_bus`)
VALUES
	(3,1,6),
	(4,0,6),
	(5,0,6),
	(6,0,6),
	(7,1,6),
	(8,1,6),
	(9,1,7),
	(10,1,7),
	(11,0,7),
	(12,1,7),
	(13,0,7);


DROP TABLE IF EXISTS `pvm_asiento`;

CREATE TABLE `pvm_asiento` (
  `ide_asiento` bigint(20) NOT NULL AUTO_INCREMENT,
  `es_asiento` tinyint(1) DEFAULT NULL,
  `numero_asiento` varchar(10) DEFAULT NULL,
  `es_primer_piso` tinyint(1) DEFAULT NULL,
  `tipo_asiento` varchar(50) NOT NULL,
  `ide_fila` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_asiento`),
  KEY `FK_4ib2xoxv4ucb43r9krlv2bxal` (`ide_fila`),
  CONSTRAINT `FK_4ib2xoxv4ucb43r9krlv2bxal` FOREIGN KEY (`ide_fila`) REFERENCES `pvm_fila` (`ide_fila`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `pvm_asiento` WRITE;
/*!40000 ALTER TABLE `pvm_asiento` DISABLE KEYS */;

INSERT INTO `pvm_asiento` (`ide_asiento`, `es_asiento`, `numero_asiento`, `es_primer_piso`, `tipo_asiento`, `ide_fila`)
VALUES
	(1,1,'1',1,'COMUN',3),
	(2,1,'2',1,'COMUN',3),
	(3,0,'TV',1,'NO_APLICA',3),
	(4,1,'3',1,'COMUN',3),
	(5,1,'4',1,'COMUN',3),
	(6,1,'1',0,'COMUN',4),
	(7,1,'2',0,'COMUN',4),
	(8,0,'TV',0,'NO_APLICA',4),
	(9,1,'3',0,'COMUN',4),
	(10,1,'4',0,'COMUN',4),
	(11,1,'5',0,'COMUN',5),
	(12,1,'6',0,'COMUN',5),
	(13,0,'',0,'NO_APLICA',5),
	(14,1,'7',0,'COMUN',5),
	(15,1,'8',0,'COMUN',5),
	(16,1,'9',0,'COMUN',6),
	(17,1,'10',0,'COMUN',6),
	(18,0,'',0,'NO_APLICA',6),
	(19,1,'11',0,'COMUN',6),
	(20,1,'12',0,'COMUN',6),
	(21,1,'5',1,'COMUN',7),
	(22,1,'6',1,'COMUN',7),
	(23,0,'',1,'NO_APLICA',7),
	(24,1,'7',1,'COMUN',7),
	(25,1,'8',1,'COMUN',7),
	(26,1,'9',1,'COMUN',8),
	(27,1,'10',1,'COMUN',8),
	(28,0,'',1,'NO_APLICA',8),
	(29,1,'12',1,'COMUN',8),
	(30,1,'13',1,'COMUN',8),
	(31,1,'1',1,'COMUN',9),
	(32,1,'2',1,'COMUN',9),
	(33,0,'TV',1,'NO_APLICA',9),
	(34,1,'3',1,'COMUN',9),
	(35,1,'4',1,'COMUN',9),
	(36,1,'5',1,'COMUN',10),
	(37,1,'6',1,'COMUN',10),
	(38,0,'',1,'NO_APLICA',10),
	(39,1,'7',1,'COMUN',10),
	(40,1,'8',1,'COMUN',10),
	(41,1,'1',0,'COMUN',11),
	(42,1,'2',0,'COMUN',11),
	(43,0,'TV',0,'NO_APLICA',11),
	(44,1,'3',0,'COMUN',11),
	(45,1,'4',0,'COMUN',11),
	(46,1,'9',1,'COMUN',12),
	(47,1,'10',1,'COMUN',12),
	(48,0,'',1,'NO_APLICA',12),
	(49,1,'11',1,'COMUN',12),
	(50,1,'12',1,'COMUN',12),
	(51,1,'5',0,'COMUN',13),
	(52,1,'6',0,'COMUN',13),
	(53,0,'',0,'NO_APLICA',13),
	(54,1,'7',0,'COMUN',13),
	(55,1,'8',0,'COMUN',13);



DROP TABLE IF EXISTS `pvm_cliente`;

CREATE TABLE `pvm_cliente` (
  `ide_cliente` bigint(20) NOT NULL AUTO_INCREMENT,
  `edad` int(11) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `nombre_cliente` varchar(255) NOT NULL,
  `numero_documento` varchar(11) NOT NULL,
  `numero_telefono` varchar(100) DEFAULT NULL,
  `sexo` varchar(50) NOT NULL,
  `tipo_documento` varchar(50) NOT NULL,
  `tipo_persona` varchar(50) NOT NULL,
  PRIMARY KEY (`ide_cliente`),
  UNIQUE KEY `UK_mltspc80hk7uiyf2w5s3ovuax` (`numero_documento`),
  UNIQUE KEY `UK_5q329len9ewfauirhy7iicpcf` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `pvm_cliente` (`ide_cliente`, `edad`, `email`, `nombre_cliente`, `numero_documento`, `numero_telefono`, `sexo`, `tipo_documento`, `tipo_persona`)
VALUES
	(1,0,'martin.programmer@gmail.com','MARTIN GRADOS SALINAS','45963555','5555555','MASCULINO','DNI','NATURAL');


DROP TABLE IF EXISTS `pvm_grupo`;

CREATE TABLE `pvm_grupo` (
  `ide_grupo` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(355) DEFAULT NULL,
  `nombre_grupo` varchar(255) NOT NULL,
  PRIMARY KEY (`ide_grupo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `pvm_grupo` (`ide_grupo`, `descripcion`, `nombre_grupo`)
VALUES
	(1,'ADMINISTRADORES','ADMINISTRADORES'),
	(2,'AUXILIARES','AUXILIARES'),
	(3,'VENDEDORES','VENDEDORES');


DROP TABLE IF EXISTS `pvm_terminal`;

CREATE TABLE `pvm_terminal` (
  `ide_terminal` bigint(20) NOT NULL AUTO_INCREMENT,
  `direccion_terminal` varchar(255) NOT NULL,
  `nombre_terminal` varchar(50) NOT NULL,
  `telefonos_terminal` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ide_terminal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `pvm_terminal` WRITE;
/*!40000 ALTER TABLE `pvm_terminal` DISABLE KEYS */;

INSERT INTO `pvm_terminal` (`ide_terminal`, `direccion_terminal`, `nombre_terminal`, `telefonos_terminal`)
VALUES
	(1,'En Fiori de Lima Norte','Fiori',''),
	(2,'En Local de Zapallal','Zapallal',''),
	(3,'En Local de Plaza Norte','Plaza Norte',''),
	(4,'En Local de Chiclayo','Chiclayo',''),
	(5,'Dirección de Chepen','Chepen','');


DROP TABLE IF EXISTS `pvm_recorrido`;

CREATE TABLE `pvm_recorrido` (
  `ide_recorrido` bigint(20) NOT NULL AUTO_INCREMENT,
  `ruta` varchar(50) NOT NULL,
  `terminal_destino` bigint(20) NOT NULL,
  `terminal_origen` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_recorrido`),
  KEY `FK_rb6rsegyvyuojomtf1daqtfra` (`terminal_destino`),
  KEY `FK_ckpy4hvr9momo0xxv1ch46y4p` (`terminal_origen`),
  CONSTRAINT `FK_ckpy4hvr9momo0xxv1ch46y4p` FOREIGN KEY (`terminal_origen`) REFERENCES `pvm_terminal` (`ide_terminal`),
  CONSTRAINT `FK_rb6rsegyvyuojomtf1daqtfra` FOREIGN KEY (`terminal_destino`) REFERENCES `pvm_terminal` (`ide_terminal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `pvm_recorrido` (`ide_recorrido`, `ruta`, `terminal_destino`, `terminal_origen`)
VALUES
	(2,'FIORI-CHICLAYO',4,1),
	(3,'Zapallal - Chiclayo',4,2);



DROP TABLE IF EXISTS `pvm_tarifa_general`;

CREATE TABLE `pvm_tarifa_general` (
  `ide_tarifa_general` bigint(20) NOT NULL AUTO_INCREMENT,
  `precio` decimal(10,2) NOT NULL,
  `tipo_bus` varchar(20) NOT NULL,
  `tipo_pasaje` varchar(50) NOT NULL,
  `ide_recorrido` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_tarifa_general`),
  KEY `FK_dc08ve3e2v6h1lgcu08jnhr5y` (`ide_recorrido`),
  CONSTRAINT `FK_dc08ve3e2v6h1lgcu08jnhr5y` FOREIGN KEY (`ide_recorrido`) REFERENCES `pvm_recorrido` (`ide_recorrido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `pvm_tarifa_general` (`ide_tarifa_general`, `precio`, `tipo_bus`, `tipo_pasaje`, `ide_recorrido`)
VALUES
	(1,40.00,'COMUN','INGRESE CONCEPTO',2),
	(2,40.00,'SEMI_CAMA','INGRESE CONCEPTO',2),
	(3,40.00,'CAMA','INGRESE CONCEPTO',2),
	(4,40.00,'SUIT','INGRESE CONCEPTO',2),
	(5,40.00,'COMUN','INGRESE CONCEPTO',3),
	(6,40.00,'SEMI_CAMA','INGRESE CONCEPTO',3),
	(7,40.00,'CAMA','INGRESE CONCEPTO',3),
	(8,40.00,'SUIT','INGRESE CONCEPTO',3),
	(9,40.00,'NO_APLICA','INGRESE CONCEPTO',3);



DROP TABLE IF EXISTS `pvm_usuario`;

CREATE TABLE `pvm_usuario` (
  `ide_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `color_usuario` varchar(50) DEFAULT NULL,
  `dni` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nombre_usuario` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `sexo` varchar(50) NOT NULL,
  PRIMARY KEY (`ide_usuario`),
  UNIQUE KEY `UK_s53ueirklqhgqy32ptmf9am69` (`dni`),
  UNIQUE KEY `UK_4psi8oj5ie550n6nckh2f6mj9` (`email`),
  UNIQUE KEY `UK_rc5bdw49quyjc7c1ux7d9bqvs` (`nombre_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO `pvm_usuario` (`ide_usuario`, `activo`, `color_usuario`, `dni`, `email`, `nombre_usuario`, `password`, `sexo`)
VALUES
	(1,1,'','25723525','jose.diaz@joedayz.pe','Jose Diaz','123','MASCULINO'),
	(3,1,'ffaa00','24242424','j.gustavo.falcon.garcia@gmail.com','John Gustavo Falcon Garcia','123','MASCULINO'),
	(4,1,'ff00a6','41191089','miryan.ramirez@joedayz.pe','Miryan Ramirez','123','FEMENINO');



DROP TABLE IF EXISTS `pvr_bus_filas`;

CREATE TABLE `pvr_bus_filas` (
  `ide_bus` bigint(20) NOT NULL,
  `ide_fila` bigint(20) NOT NULL,
  UNIQUE KEY `UK_scpvrrrovqgpodksv51ioibf9` (`ide_fila`),
  KEY `FK_scpvrrrovqgpodksv51ioibf9` (`ide_fila`),
  KEY `FK_kxfkgc61sg0iy0ed7cyfl5v48` (`ide_bus`),
  CONSTRAINT `FK_kxfkgc61sg0iy0ed7cyfl5v48` FOREIGN KEY (`ide_bus`) REFERENCES `pvm_bus` (`ide_bus`),
  CONSTRAINT `FK_scpvrrrovqgpodksv51ioibf9` FOREIGN KEY (`ide_fila`) REFERENCES `pvm_fila` (`ide_fila`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO `pvr_bus_filas` (`ide_bus`, `ide_fila`)
VALUES
	(6,3),
	(6,4),
	(6,5),
	(6,6),
	(6,7),
	(6,8),
	(7,9),
	(7,10),
	(7,11),
	(7,12),
	(7,13);



DROP TABLE IF EXISTS `pvr_fila_asientos`;

CREATE TABLE `pvr_fila_asientos` (
  `ide_fila` bigint(20) NOT NULL,
  `ide_asiento` bigint(20) NOT NULL,
  UNIQUE KEY `UK_povf7uceias39ny7xokabeei5` (`ide_asiento`),
  KEY `FK_povf7uceias39ny7xokabeei5` (`ide_asiento`),
  KEY `FK_2mg0sdkh8uhtbffr23qny1aht` (`ide_fila`),
  CONSTRAINT `FK_2mg0sdkh8uhtbffr23qny1aht` FOREIGN KEY (`ide_fila`) REFERENCES `pvm_fila` (`ide_fila`),
  CONSTRAINT `FK_povf7uceias39ny7xokabeei5` FOREIGN KEY (`ide_asiento`) REFERENCES `pvm_asiento` (`ide_asiento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `pvr_fila_asientos` (`ide_fila`, `ide_asiento`)
VALUES
	(3,1),
	(3,2),
	(3,3),
	(3,4),
	(3,5),
	(4,6),
	(4,7),
	(4,8),
	(4,9),
	(4,10),
	(5,11),
	(5,12),
	(5,13),
	(5,14),
	(5,15),
	(6,16),
	(6,17),
	(6,18),
	(6,19),
	(6,20),
	(7,21),
	(7,22),
	(7,23),
	(7,24),
	(7,25),
	(8,26),
	(8,27),
	(8,28),
	(8,29),
	(8,30),
	(9,31),
	(9,32),
	(9,33),
	(9,34),
	(9,35),
	(10,36),
	(10,37),
	(10,38),
	(10,39),
	(10,40),
	(11,41),
	(11,42),
	(11,43),
	(11,44),
	(11,45),
	(12,46),
	(12,47),
	(12,48),
	(12,49),
	(12,50),
	(13,51),
	(13,52),
	(13,53),
	(13,54),
	(13,55);


DROP TABLE IF EXISTS `pvr_recorrido_tarifa_general`;

CREATE TABLE `pvr_recorrido_tarifa_general` (
  `ide_recorrido` bigint(20) NOT NULL,
  `ide_tarifa_general` bigint(20) NOT NULL,
  UNIQUE KEY `UK_ct5acomfan2j47s71gmenpo0b` (`ide_tarifa_general`),
  KEY `FK_ct5acomfan2j47s71gmenpo0b` (`ide_tarifa_general`),
  KEY `FK_le00l3yerytqi6de2lpdyeti` (`ide_recorrido`),
  CONSTRAINT `FK_ct5acomfan2j47s71gmenpo0b` FOREIGN KEY (`ide_tarifa_general`) REFERENCES `pvm_tarifa_general` (`ide_tarifa_general`),
  CONSTRAINT `FK_le00l3yerytqi6de2lpdyeti` FOREIGN KEY (`ide_recorrido`) REFERENCES `pvm_recorrido` (`ide_recorrido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO `pvr_recorrido_tarifa_general` (`ide_recorrido`, `ide_tarifa_general`)
VALUES
	(2,1),
	(2,2),
	(2,3),
	(2,4),
	(3,5),
	(3,6),
	(3,7),
	(3,8),
	(3,9);



DROP TABLE IF EXISTS `pvr_usuario_grupo`;

CREATE TABLE `pvr_usuario_grupo` (
  `ide_usuario` bigint(20) NOT NULL,
  `ide_grupo` bigint(20) NOT NULL,
  KEY `FK_pa8wjiie7sora7a3rh1tg4r44` (`ide_grupo`),
  KEY `FK_kvybvbbr1exo3ve8omcs8mqfp` (`ide_usuario`),
  CONSTRAINT `FK_kvybvbbr1exo3ve8omcs8mqfp` FOREIGN KEY (`ide_usuario`) REFERENCES `pvm_usuario` (`ide_usuario`),
  CONSTRAINT `FK_pa8wjiie7sora7a3rh1tg4r44` FOREIGN KEY (`ide_grupo`) REFERENCES `pvm_grupo` (`ide_grupo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `pvr_usuario_grupo` WRITE;
/*!40000 ALTER TABLE `pvr_usuario_grupo` DISABLE KEYS */;

INSERT INTO `pvr_usuario_grupo` (`ide_usuario`, `ide_grupo`)
VALUES
	(1,1),
	(1,2),
	(1,3),
	(3,1),
	(4,3);


