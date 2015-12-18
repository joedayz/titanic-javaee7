


-- Volcando estructura para tabla titanic_diplomado.pvm_bus
DROP TABLE IF EXISTS `pvm_bus`;
CREATE TABLE IF NOT EXISTS `pvm_bus` (
  `ide_bus` bigint(20) NOT NULL AUTO_INCREMENT,
  `con_aire_acondicionado` tinyint(1) DEFAULT NULL,
  `descripcion_bus` varchar(255) NOT NULL,
  `numero_motor` varchar(50) DEFAULT NULL,
  `placa` varchar(10) NOT NULL,
  `tipo_bus` varchar(50) NOT NULL,
  `tipo_planta` varchar(50) NOT NULL,
  PRIMARY KEY (`ide_bus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- Volcando estructura para tabla titanic_diplomado.pvm_terminal
DROP TABLE IF EXISTS `pvm_terminal`;
CREATE TABLE IF NOT EXISTS `pvm_terminal` (
  `ide_terminal` bigint(20) NOT NULL AUTO_INCREMENT,
  `direccion_terminal` varchar(255) NOT NULL,
  `nombre_terminal` varchar(50) NOT NULL,
  `telefonos_terminal` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ide_terminal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- Volcando estructura para tabla titanic_diplomado.pvm_recorrido
DROP TABLE IF EXISTS `pvm_recorrido`;
CREATE TABLE IF NOT EXISTS `pvm_recorrido` (
  `ide_recorrido` bigint(20) NOT NULL AUTO_INCREMENT,
  `ruta` varchar(50) NOT NULL,
  `terminal_destino` bigint(20) NOT NULL,
  `terminal_origen` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_recorrido`),
  KEY `FK_rb6rsegyvyuojomtf1daqtfra` (`terminal_destino`),
  KEY `FK_ckpy4hvr9momo0xxv1ch46y4p` (`terminal_origen`),
  CONSTRAINT `FK_ckpy4hvr9momo0xxv1ch46y4p` FOREIGN KEY (`terminal_origen`) REFERENCES `pvm_terminal` (`ide_terminal`),
  CONSTRAINT `FK_rb6rsegyvyuojomtf1daqtfra` FOREIGN KEY (`terminal_destino`) REFERENCES `pvm_terminal` (`ide_terminal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- Volcando estructura para tabla titanic_diplomado.pvm_programacion
DROP TABLE IF EXISTS `pvm_programacion`;
CREATE TABLE IF NOT EXISTS `pvm_programacion` (
  `ide_programacion` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_programacion` date NOT NULL,
  `hora_llegada` varchar(10) NOT NULL,
  `hora_salida` varchar(10) NOT NULL,
  `tipo_programacion` varchar(50) NOT NULL,
  `ide_bus` bigint(20) NOT NULL,
  `ide_recorrido` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_programacion`),
  KEY `FK_gvhttbsi6en4s7594v50wofwl` (`ide_bus`),
  KEY `FK_ipngjscna2thcntv6ija5pdm4` (`ide_recorrido`),
  CONSTRAINT `FK_gvhttbsi6en4s7594v50wofwl` FOREIGN KEY (`ide_bus`) REFERENCES `pvm_bus` (`ide_bus`),
  CONSTRAINT `FK_ipngjscna2thcntv6ija5pdm4` FOREIGN KEY (`ide_recorrido`) REFERENCES `pvm_recorrido` (`ide_recorrido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- Volcando estructura para tabla titanic_diplomado.pvm_venta
DROP TABLE IF EXISTS `pvm_venta`;
CREATE TABLE IF NOT EXISTS `pvm_venta` (
  `ide_venta` bigint(20) NOT NULL AUTO_INCREMENT,
  `total_venta` decimal(10,2) NOT NULL,
  `ide_programacion` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_venta`),
  KEY `FK_bax2alasfkogujxv66omqcoi7` (`ide_programacion`),
  CONSTRAINT `FK_bax2alasfkogujxv66omqcoi7` FOREIGN KEY (`ide_programacion`) REFERENCES `pvm_programacion` (`ide_programacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando estructura para tabla titanic_diplomado.pvm_cliente
DROP TABLE IF EXISTS `pvm_cliente`;
CREATE TABLE IF NOT EXISTS `pvm_cliente` (
  `ide_cliente` bigint(20) NOT NULL AUTO_INCREMENT,
  `edad` int(11) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `nombre_cliente` varchar(255) NOT NULL,
  `numero_documento` varchar(11) NOT NULL,
  `sexo` varchar(50) NOT NULL,
  `tipo_documento` varchar(50) NOT NULL,
  `tipo_persona` varchar(50) NOT NULL,
  PRIMARY KEY (`ide_cliente`),
  UNIQUE KEY `UK_mltspc80hk7uiyf2w5s3ovuax` (`numero_documento`),
  UNIQUE KEY `UK_5q329len9ewfauirhy7iicpcf` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla titanic_diplomado.pvm_fila_boleto_inferior
DROP TABLE IF EXISTS `pvm_fila_boleto_inferior`;
CREATE TABLE IF NOT EXISTS `pvm_fila_boleto_inferior` (
  `ide_fila` bigint(20) NOT NULL AUTO_INCREMENT,
  `ubicacion_planta` varchar(50) NOT NULL,
  `ide_venta` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_fila`),
  KEY `FK_r0kipi10hl3bile95i2ny3wxl` (`ide_venta`),
  CONSTRAINT `FK_r0kipi10hl3bile95i2ny3wxl` FOREIGN KEY (`ide_venta`) REFERENCES `pvm_venta` (`ide_venta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla titanic_diplomado.pvm_fila_boleto_superior
DROP TABLE IF EXISTS `pvm_fila_boleto_superior`;
CREATE TABLE IF NOT EXISTS `pvm_fila_boleto_superior` (
  `ide_fila` bigint(20) NOT NULL AUTO_INCREMENT,
  `ubicacion_planta` varchar(50) NOT NULL,
  `ide_venta` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_fila`),
  KEY `FK_o11b9wvp6cd239seejyyqrt8k` (`ide_venta`),
  CONSTRAINT `FK_o11b9wvp6cd239seejyyqrt8k` FOREIGN KEY (`ide_venta`) REFERENCES `pvm_venta` (`ide_venta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- Volcando estructura para tabla titanic_diplomado.pvm_usuario
DROP TABLE IF EXISTS `pvm_usuario`;
CREATE TABLE IF NOT EXISTS `pvm_usuario` (
  `ide_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `dni` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nombre_usuario` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `sexo` varchar(50) NOT NULL,
  PRIMARY KEY (`ide_usuario`),
  UNIQUE KEY `UK_s53ueirklqhgqy32ptmf9am69` (`dni`),
  UNIQUE KEY `UK_4psi8oj5ie550n6nckh2f6mj9` (`email`),
  UNIQUE KEY `UK_rc5bdw49quyjc7c1ux7d9bqvs` (`nombre_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- Volcando estructura para tabla titanic_diplomado.pvm_boleto_inferior
DROP TABLE IF EXISTS `pvm_boleto_inferior`;
CREATE TABLE IF NOT EXISTS `pvm_boleto_inferior` (
  `ide_boleto` bigint(20) NOT NULL AUTO_INCREMENT,
  `calidad` varchar(50) DEFAULT NULL,
  `destino` varchar(50) DEFAULT NULL,
  `estado_boleto` varchar(50) NOT NULL,
  `fecha_venta` date DEFAULT NULL,
  `hora_salida` varchar(10) DEFAULT NULL,
  `nombre_cliente` varchar(255) DEFAULT NULL,
  `numero_asiento` varchar(10) DEFAULT NULL,
  `numero_boleto` varchar(10) NOT NULL,
  `numero_documento` varchar(10) DEFAULT NULL,
  `origen` varchar(50) DEFAULT NULL,
  `precio` decimal(10,2) NOT NULL,
  `presento_carta_notarial` tinyint(1) DEFAULT NULL,
  `tipo_boleto` varchar(50) NOT NULL,
  `ide_cliente` bigint(20) DEFAULT NULL,
  `ide_fila` bigint(20) NOT NULL,
  `vendedor` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ide_boleto`),
  KEY `FK_49c7j78ns0wawdqw890sngko0` (`ide_cliente`),
  KEY `FK_569pi7di8e4ve8v88y0xph129` (`ide_fila`),
  KEY `FK_m7n632m17ufnppo4vq41oj9vj` (`vendedor`),
  CONSTRAINT `FK_49c7j78ns0wawdqw890sngko0` FOREIGN KEY (`ide_cliente`) REFERENCES `pvm_cliente` (`ide_cliente`),
  CONSTRAINT `FK_569pi7di8e4ve8v88y0xph129` FOREIGN KEY (`ide_fila`) REFERENCES `pvm_fila_boleto_inferior` (`ide_fila`),
  CONSTRAINT `FK_m7n632m17ufnppo4vq41oj9vj` FOREIGN KEY (`vendedor`) REFERENCES `pvm_usuario` (`ide_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla titanic_diplomado.pvm_boleto_superior
DROP TABLE IF EXISTS `pvm_boleto_superior`;
CREATE TABLE IF NOT EXISTS `pvm_boleto_superior` (
  `ide_boleto` bigint(20) NOT NULL AUTO_INCREMENT,
  `calidad` varchar(50) DEFAULT NULL,
  `destino` varchar(50) DEFAULT NULL,
  `estado_boleto` varchar(50) NOT NULL,
  `fecha_venta` date DEFAULT NULL,
  `hora_salida` varchar(10) DEFAULT NULL,
  `nombre_cliente` varchar(255) DEFAULT NULL,
  `numero_asiento` varchar(10) DEFAULT NULL,
  `numero_boleto` varchar(10) NOT NULL,
  `numero_documento` varchar(10) DEFAULT NULL,
  `origen` varchar(50) DEFAULT NULL,
  `precio` decimal(10,2) NOT NULL,
  `presento_carta_notarial` tinyint(1) DEFAULT NULL,
  `tipo_boleto` varchar(50) NOT NULL,
  `ide_cliente` bigint(20) DEFAULT NULL,
  `ide_fila` bigint(20) NOT NULL,
  `vendedor` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ide_boleto`),
  KEY `FK_g7bkgtk5203wibyodgbrj51qx` (`ide_cliente`),
  KEY `FK_l6g2xbjxf4noepti2ym40ebb7` (`ide_fila`),
  KEY `FK_tcbe6ctcmejgg84k9g3urat6w` (`vendedor`),
  CONSTRAINT `FK_g7bkgtk5203wibyodgbrj51qx` FOREIGN KEY (`ide_cliente`) REFERENCES `pvm_cliente` (`ide_cliente`),
  CONSTRAINT `FK_l6g2xbjxf4noepti2ym40ebb7` FOREIGN KEY (`ide_fila`) REFERENCES `pvm_fila_boleto_superior` (`ide_fila`),
  CONSTRAINT `FK_tcbe6ctcmejgg84k9g3urat6w` FOREIGN KEY (`vendedor`) REFERENCES `pvm_usuario` (`ide_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- Volcando estructura para tabla titanic_diplomado.pvm_fila_inferior
DROP TABLE IF EXISTS `pvm_fila_inferior`;
CREATE TABLE IF NOT EXISTS `pvm_fila_inferior` (
  `ide_fila` bigint(20) NOT NULL AUTO_INCREMENT,
  `ubicacion_planta` varchar(50) NOT NULL,
  `ide_bus` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_fila`),
  KEY `FK_pykwwmn74da893b15w35mr2gq` (`ide_bus`),
  CONSTRAINT `FK_pykwwmn74da893b15w35mr2gq` FOREIGN KEY (`ide_bus`) REFERENCES `pvm_bus` (`ide_bus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla titanic_diplomado.pvm_fila_superior
DROP TABLE IF EXISTS `pvm_fila_superior`;
CREATE TABLE IF NOT EXISTS `pvm_fila_superior` (
  `ide_fila` bigint(20) NOT NULL AUTO_INCREMENT,
  `ubicacion_planta` varchar(50) NOT NULL,
  `ide_bus` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_fila`),
  KEY `FK_614antectn477461br9mpxffm` (`ide_bus`),
  CONSTRAINT `FK_614antectn477461br9mpxffm` FOREIGN KEY (`ide_bus`) REFERENCES `pvm_bus` (`ide_bus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla titanic_diplomado.pvm_celda_inferior
DROP TABLE IF EXISTS `pvm_celda_inferior`;
CREATE TABLE IF NOT EXISTS `pvm_celda_inferior` (
  `ide_celda` bigint(20) NOT NULL AUTO_INCREMENT,
  `calidad` varchar(50) DEFAULT NULL,
  `estado_celda` varchar(50) NOT NULL,
  `numero_asiento` varchar(10) DEFAULT NULL,
  `numero_celda` varchar(10) NOT NULL,
  `tipo_celda` varchar(50) NOT NULL,
  `ide_fila` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_celda`),
  KEY `FK_9064einjkff6d5nhp3exmyw14` (`ide_fila`),
  CONSTRAINT `FK_9064einjkff6d5nhp3exmyw14` FOREIGN KEY (`ide_fila`) REFERENCES `pvm_fila_inferior` (`ide_fila`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla titanic_diplomado.pvm_celda_superior
DROP TABLE IF EXISTS `pvm_celda_superior`;
CREATE TABLE IF NOT EXISTS `pvm_celda_superior` (
  `ide_celda` bigint(20) NOT NULL AUTO_INCREMENT,
  `calidad` varchar(50) DEFAULT NULL,
  `estado_celda` varchar(50) NOT NULL,
  `numero_asiento` varchar(10) DEFAULT NULL,
  `numero_celda` varchar(10) NOT NULL,
  `tipo_celda` varchar(50) NOT NULL,
  `ide_fila` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_celda`),
  KEY `FK_n592qhkab8js8ly1xeffu90ds` (`ide_fila`),
  CONSTRAINT `FK_n592qhkab8js8ly1xeffu90ds` FOREIGN KEY (`ide_fila`) REFERENCES `pvm_fila_superior` (`ide_fila`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.



-- La exportación de datos fue deseleccionada.



-- La exportación de datos fue deseleccionada.





-- Volcando estructura para tabla titanic_diplomado.pvm_grupo
DROP TABLE IF EXISTS `pvm_grupo`;
CREATE TABLE IF NOT EXISTS `pvm_grupo` (
  `ide_grupo` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(355) DEFAULT NULL,
  `nombre_grupo` varchar(255) NOT NULL,
  PRIMARY KEY (`ide_grupo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.


-- La exportación de datos fue deseleccionada.



-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla titanic_diplomado.pvm_tarifa_general
DROP TABLE IF EXISTS `pvm_tarifa_general`;
CREATE TABLE IF NOT EXISTS `pvm_tarifa_general` (
  `ide_tarifa_general` bigint(20) NOT NULL AUTO_INCREMENT,
  `precio` decimal(10,2) NOT NULL,
  `tipo_bus` varchar(20) NOT NULL,
  `tipo_pasaje` varchar(50) NOT NULL,
  `ide_recorrido` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_tarifa_general`),
  KEY `FK_dc08ve3e2v6h1lgcu08jnhr5y` (`ide_recorrido`),
  CONSTRAINT `FK_dc08ve3e2v6h1lgcu08jnhr5y` FOREIGN KEY (`ide_recorrido`) REFERENCES `pvm_recorrido` (`ide_recorrido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.




-- La exportación de datos fue deseleccionada.



-- La exportación de datos fue deseleccionada.



-- La exportación de datos fue deseleccionada.


-- Volcando estructura para tabla titanic_diplomado.pvr_usuario_grupo
DROP TABLE IF EXISTS `pvr_usuario_grupo`;
CREATE TABLE IF NOT EXISTS `pvr_usuario_grupo` (
  `ide_usuario` bigint(20) NOT NULL,
  `ide_grupo` bigint(20) NOT NULL,
  KEY `FK_pa8wjiie7sora7a3rh1tg4r44` (`ide_grupo`),
  KEY `FK_kvybvbbr1exo3ve8omcs8mqfp` (`ide_usuario`),
  CONSTRAINT `FK_kvybvbbr1exo3ve8omcs8mqfp` FOREIGN KEY (`ide_usuario`) REFERENCES `pvm_usuario` (`ide_usuario`),
  CONSTRAINT `FK_pa8wjiie7sora7a3rh1tg4r44` FOREIGN KEY (`ide_grupo`) REFERENCES `pvm_grupo` (`ide_grupo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- La exportación de datos fue deseleccionada.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
