## COMANDOS BASICOS PARA MANEJO DE BASE DE DATOS
USE aplication; # selecsionas la base de datos
CREATE TABLE usuarios (id_usuario INT, nombre VARCHAR(45));## PARA CREAR UNA TABLA
SHOW TABLES;#PARA MOSTRAR TABLAS EN LA CONSOLA
SELECT * FROM usuarios;## SE SELECCIONA LA TABLA
INSERT INTO usuarios VALUES (1,rainer,25,1,1234rrr,3016019123);# inserta datos en la tabla
#INSERT INTO `aplication`.`usuarios` (`id_usuario`, `nombre`, `edad`, `sexo`, `contraseña`, `celular`) VALUES ('1', 'rainer', '25', '1', '1234rrr', '3012020123');
UPDATE usuarios SET nombre = 'rafael' WHERE id_usuario = 1;
##
##    PK – Clave primaria
##   NN – No admite null
##    UQ – Unico
##    BIN – Binario
##    UN – Números con signos positivos
##    ZF – Rellenar con ceros a la izquierda de los números
##    AI – Autoincremental



