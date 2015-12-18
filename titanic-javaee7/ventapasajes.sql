insert into pvm_usuario (ide_usuario, email, nombre_usuario, password, activo,sexo, dni)
values(1, 'jose.diaz@joedayz.pe', 'Jose Diaz', '123', 1, 'MASCULINO', '25723525');

insert into pvm_usuario (ide_usuario, email, nombre_usuario, password, activo,sexo, dni)
values(2, 'miryan.ramirez@joedayz.pe', 'Miryan Ramirez', '123', 1, 'FEMENINO', '41191089');



insert into pvm_grupo (ide_grupo, descripcion, nombre_grupo)
	values(1, 'ADMINISTRADORES','ADMINISTRADORES');

insert into pvm_grupo (ide_grupo, descripcion, nombre_grupo)
	values(2, 'AUXILIARES','AUXILIARES');	

insert into pvm_grupo (ide_grupo, descripcion, nombre_grupo)
	values(3, 'VENDEDORES','VENDEDORES');	

insert into pvr_usuario_grupo (ide_usuario, ide_grupo) 
	values(1, 1);

insert into pvr_usuario_grupo (ide_usuario, ide_grupo) 
	values(1, 2);

insert into pvr_usuario_grupo (ide_usuario, ide_grupo) 
	values(1, 3);	

insert into pvr_usuario_grupo (ide_usuario, ide_grupo) 
	values(2, 3)	
	
insert into pvm_terminal (ide_terminal, nombre_terminal, direccion_terminal, telefonos_terminal)
values (1, 'Fiori', 'En Fiori de Lima Norte', '');

insert into pvm_terminal (ide_terminal, nombre_terminal, direccion_terminal, telefonos_terminal)
values (2, 'Zapallal', 'En Local de Zapallal', '');

insert into pvm_terminal (ide_terminal, nombre_terminal, direccion_terminal, telefonos_terminal)
values (3, 'Plaza Norte', 'En Local de Plaza Norte', '');

insert into pvm_terminal (ide_terminal, nombre_terminal, direccion_terminal, telefonos_terminal)
values (4, 'Chiclayo', 'En Local de Chiclayo', '');



INSERT INTO `pvm_recorrido` (`ide_recorrido`,`ruta`,`terminal_destino`,`terminal_origen`) VALUES (2,'FIORI-CHICLAYO',4,1);


