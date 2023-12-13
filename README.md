# PROYECTO_POO_INCIDENCIAS
# BASE DE DATOS

use gestorincidencias;

-- creando la tabla de areas

    CREATE TABLE tb_area(
    idArea                  INT			PRIMARY KEY	AUTO_INCREMENT,
    nombreArea              VARCHAR(100)        NOT NULL,
    responsable             VARCHAR(80)		NOT NULL,
    ubicacion               VARCHAR(100)	NOT NULL,
    fechaRegistro           DATE		NOT NULL,
    descripcion             VARCHAR(200) 	NOT NULL,
    indicador               CHAR(1) 		DEFAULT 'S'
    );

-- creando la tabla tipos de incidencias

    CREATE TABLE tb_tipoincidencia(
    idTipoInci              INT			PRIMARY KEY	AUTO_INCREMENT,
    nombreTipoInci          VARCHAR(100)	NOT NULL,
    categoria               VARCHAR(80)		NOT NULL,
    fechaRegistro           DATE		NOT NULL,
    descripcion             VARCHAR(200)	NOT NULL,
    indicador               CHAR(1)		DEFAULT 'S'
    );

-- creando la tabla empleados

    CREATE TABLE tb_empleado(
    idEmpleado              INT			PRIMARY KEY	AUTO_INCREMENT,
    nombreEmpleado          VARCHAR(50)		NOT NULL,
    apellidoEmpleado        VARCHAR(50)		NOT NULL,
    genero                  CHAR(1)		NOT NULL,
    telefono                CHAR(15)		DEFAULT '000-000-000',
    cargo                   VARCHAR(100)	NOT NULL,
    idArea                  INT 		NOT NULL,			
    fechaRegistro           DATE      		NOT NULL,
    sueldo                  DOUBLE(10,2)        DEFAULT '0',
    usuario                 VARCHAR(15)		NOT NULL,
    contraseña              VARCHAR(8)		NOT NULL,
    indicador               CHAR(1)		DEFAULT 'S'
    );

-- creando la tabla incidencias

    CREATE TABLE tb_incidencia(
    idIncidencia            INT			PRIMARY KEY     AUTO_INCREMENT,
    nombreIncidencia        VARCHAR(100)	NOT NULL,
    asignadox               INT			NOT NULL,
    asignadoa               INT			NOT NULL,
    prioridad               VARCHAR(15)		NOT NULL,
    idTipoInci              INT			NOT NULL,
    idArea                  INT 		NOT NULL,
    fechaRegistro           DATE 		NOT NULL,
    descripcion             VARCHAR(200)	NOT NULL,
    indicador               CHAR(1)		DEFAULT 'S'
    );

-- creando la tabla detalle de solucion

    CREATE TABLE tb_detsolucion(
    idDetSolucion           INT			PRIMARY KEY	AUTO_INCREMENT,
    idIncidencia            INT			NOT NULL,
    observacion             VARCHAR(200)	NOT NULL,
    estado                  VARCHAR(100)        NOT NULL,
    fechaModificacion       DATE		NOT NULL,
    indicador               CHAR(1)		DEFAULT 'S'
    );

-- estableciando las relaciones entre la tabla empleado y sus claves foraneas

    ALTER TABLE tb_empleado
    ADD CONSTRAINT fk_1
    FOREIGN KEY (idArea)
    REFERENCES tb_area(idArea);

-- estableciendo las realciones entre la tabla incidencia y sus claves foraneas

    ALTER TABLE tb_incidencia
    ADD CONSTRAINT fk_2
    FOREIGN KEY (idTipoInci)
    REFERENCES tb_tipoincidencia(idTipoInci);

    ALTER TABLE tb_incidencia
    ADD CONSTRAINT fk_3
    FOREIGN KEY (idArea)
    REFERENCES tb_area(idArea);

    ALTER TABLE tb_incidencia
    ADD CONSTRAINT fk_4
    FOREIGN KEY (asignadoa)
    REFERENCES tb_empleado(idEmpleado);

    ALTER TABLE tb_incidencia
    ADD CONSTRAINT fk_5
    FOREIGN KEY (asignadox)
    REFERENCES tb_empleado(idEmpleado);

-- estableciendo las relaciones entre la tabla detalle de solucion y sus claves foraneas

    ALTER TABLE tb_detsolucion
    ADD CONSTRAINT fk_6
    FOREIGN KEY (idIncidencia)
    REFERENCES tb_incidencia(idIncidencia);

-- insertando los registros en la tabla de áreas

    INSERT INTO tb_area(nombreArea,responsable,ubicacion,fechaRegistro,descripcion,indicador)
      VALUES('Área de Urgencias','Dr. Pérez','Planta baja, ala oeste','2023-10-21','Atención médica de emergencia','S');
    INSERT INTO tb_area(nombreArea,responsable,ubicacion,fechaRegistro,descripcion,indicador)
      VALUES('Unidad de Cuidados Intensivos','Dra. García','Segundo piso, ala este','2022-02-14','Cuidados intensivos y monitoreo especializado','S');
    INSERT INTO tb_area(nombreArea,responsable,ubicacion,fechaRegistro,descripcion,indicador)
      VALUES('Laboratorio Clínico','Lic. Martínez','Sótano, ala norte','2022-08-20','Análisis y pruebas médicas','S');
    INSERT INTO tb_area(nombreArea,responsable,ubicacion,fechaRegistro,descripcion,indicador)
      VALUES('Recursos Humanos','Lic. Rodríguez','Planta alta, ala oeste','2023-02-16','Gestión del personal y contrataciones','S');
    INSERT INTO tb_area(nombreArea,responsable,ubicacion,fechaRegistro,descripcion,indicador)
      VALUES('Administración','Lic. Gómez','Planta alta, ala este','2022-12-24','Gestión administrativa y financiera','S');
    INSERT INTO tb_area(nombreArea,responsable,ubicacion,fechaRegistro,descripcion,indicador)
      VALUES('Farmacia','Dra. Ramírez','Planta baja, ala sur','2021-10-24','Almacenamiento y dispensación de medicamentos','S');
    INSERT INTO tb_area(nombreArea,responsable,ubicacion,fechaRegistro,descripcion,indicador)
      VALUES('Radiología','Dr. Torres','Primer piso, ala este','2022-12-24','Imágenes médicas y diagnóstico por imágenes','S');
    INSERT INTO tb_area(nombreArea,responsable,ubicacion,fechaRegistro,descripcion,indicador)
      VALUES('Oftalmología','Dra. Gómez','Primer piso, ala oeste','2020-02-11','Atención médica oftalmológica','S');
    INSERT INTO tb_area(nombreArea,responsable,ubicacion,fechaRegistro,descripcion,indicador)
      VALUES('Neurología','Dr. Soto','Segundo piso, ala sur','2021-09-16','Evaluación y tratamiento de trastornos neurológicos','S');
    INSERT INTO tb_area(nombreArea,responsable,ubicacion,fechaRegistro,descripcion,indicador)
      VALUES('Rehabilitación','Lic. Vargas','Sótano, ala este','2022-03-15','Servicios de rehabilitación y terapia física','S');


-- insertando los registros en la tabla de tipos de incidencias

    INSERT INTO tb_tipoincidencia(nombreTipoInci,categoria,fechaRegistro,descripcion,indicador)
      VALUES
        ('Error de Sistema', 'Software', '2021-10-26', 'Error general del sistema informático', 'S'),
        ('Fallo de Red', 'Redes', '2022-10-27', 'Problemas de conectividad en la red', 'S'),
        ('Problema de Hardware', 'Hardware', '2023-10-28', 'Fallo en dispositivos físicos de hardware', 'S'),
        ('Ataque de Malware', 'Seguridad', '2023-10-29', 'Intento de intrusión por software malicioso', 'S'),
        ('Fallo de Aplicación', 'Software', '2022-04-30', 'Aplicación específica no funciona correctamente', 'S'),
	      ('Pérdida de Datos', 'Seguridad', '2022-05-31', 'Pérdida o corrupción de datos', 'S'),
	      ('Problema de Impresión', 'Hardware', '2023-11-01', 'Problemas con impresoras o impresión', 'S'),
	      ('Acceso No Autorizado', 'Seguridad', '2023-08-02', 'Intento de acceso no autorizado a sistemas', 'S'),
	      ('Fallo en Servidores', 'Redes', '2023-02-03', 'Falla en los servidores de la red', 'S'),
        ('Problema de Correo Electrónico', 'Software', '2023-11-05', 'Dificultades con el envío o recepción de correos electrónicos', 'S');


-- insertando los registros en la tabla de empleados

    INSERT INTO tb_empleado(nombreEmpleado,apellidoEmpleado,genero,telefono,cargo,idArea,fechaRegistro,sueldo,usuario,contraseña,indicador) 
      VALUES('Juan','García','M','918-764-329','Médico',1,'2022-06-15',2200,'JnGarcia01','10000001','S');
    INSERT INTO tb_empleado(nombreEmpleado,apellidoEmpleado,genero,telefono,cargo,idArea,fechaRegistro,sueldo,usuario,contraseña,indicador) 
      VALUES('María','López','F','987-654-321','Enfermera',2,'2023-01-12',1200,'MrLopez01','10000002','S');
    INSERT INTO tb_empleado(nombreEmpleado,apellidoEmpleado,genero,telefono,cargo,idArea,fechaRegistro,sueldo,usuario,contraseña,indicador) 
      VALUES('Pedro','Martínez','M','911-222-333','Técnico de Laboratorio',3,'2023-10-23',2000,'PeMartinez01','10000003','S');
    INSERT INTO tb_empleado(nombreEmpleado,apellidoEmpleado,genero,telefono,cargo,idArea,fechaRegistro,sueldo,usuario,contraseña,indicador) 
      VALUES('Ana','Pérez','F','944-555-666','Especialista en RRHH',4,'2023-11-22',1880,'AnPerez01','10000004','S');
    INSERT INTO tb_empleado(nombreEmpleado,apellidoEmpleado,genero,telefono,cargo,idArea,fechaRegistro,sueldo,usuario,contraseña,indicador) 
      VALUES('Luis','Gómez','M','977-888-999','Administrativo',5,'2022-12-30',3000,'LuGomez01','10000005','S');
    INSERT INTO tb_empleado(nombreEmpleado,apellidoEmpleado,genero,telefono,cargo,idArea,fechaRegistro,sueldo,usuario,contraseña,indicador) 
      VALUES('Marcela','Martínez','F','940-187-309','Farmacéutico',6,'2023-10-13',1600,'MaMartz01','10000006','S');
    INSERT INTO tb_empleado(nombreEmpleado,apellidoEmpleado,genero,telefono,cargo,idArea,fechaRegistro,sueldo,usuario,contraseña,indicador) 
      VALUES('Jorge','López','M','910-790-047','Técnico en Radiología',7,'2022-12-30',1550,'JorLopez01','10000007','S');
    INSERT INTO tb_empleado(nombreEmpleado,apellidoEmpleado,genero,telefono,cargo,idArea,fechaRegistro,sueldo,usuario,contraseña,indicador) 
      VALUES('Carolina','Hernández','F','900-701-200','Oftalmóloga',8,'2022-10-14',2900,'CaHernaz01','10000008','S');
    INSERT INTO tb_empleado(nombreEmpleado,apellidoEmpleado,genero,telefono,cargo,idArea,fechaRegistro,sueldo,usuario,contraseña,indicador) 
      VALUES('Ricardo','Gómez','M','977-202-471','Neurólogo',9,'2023-8-10',3200,'RicGomez01','10000009','S');
    INSERT INTO tb_empleado(nombreEmpleado,apellidoEmpleado,genero,telefono,cargo,idArea,fechaRegistro,sueldo,usuario,contraseña,indicador) 
      VALUES('Elena','Pérez','F','916-444-167','Terapeuta Física',10,'2023-10-29',1850,'ElPerez01','10000010','S');


-- insertando los registros en la tabla de incidencias

    INSERT INTO tb_incidencia(nombreIncidencia,asignadox,asignadoa,prioridad,idTipoInci,idArea,fechaRegistro,descripcion, indicador)
      VALUES 
        ('Error al iniciar sesión', 4, 1, 'Alta', 1, 4, '2023-11-06', 'El sistema presenta errores al iniciar sesión para algunos empleados', 'S'),
        ('Problema de impresión', 6, 5, 'Media', 7, 6, '2022-11-07', 'Las impresoras del área de farmacia no están imprimiendo correctamente', 'S'),
        ('Fallo en el servidor', 8, 9, 'Alta', 9, 3, '2023-11-08', 'Problemas de conexión con los servidores de la red', 'S'),
        ('Ataque de malware detectado', 2, 10, 'Alta', 4, 8, '2023-11-09', 'Se ha detectado un intento de intrusión por malware en el área de oftalmología', 'S'),
        ('Pérdida de datos crítica', 3, 7, 'Alta', 6, 7, '2021-11-10', 'Importantes datos clínicos se han perdido en el laboratorio clínico', 'S'),
        ('Fallo en el software de radiología', 7, 6, 'Alta', 1, 7, '2021-11-11', 'El software utilizado en radiología no está funcionando correctamente', 'S'),
        ('Problema de conexión a la red en el área de farmacia', 6, 5, 'Media', 2, 6, '2023-11-12', 'La red en el área de farmacia presenta problemas de conexión intermitente', 'S'),
        ('Intento de acceso no autorizado a sistemas en recursos humanos', 4, 3, 'Alta', 8, 4, '2023-11-13', 'Se ha detectado un intento de acceso no autorizado en el área de recursos humanos', 'S'),
        ('Error de sistema crítico en área de urgencias', 1, 2, 'Alta', 5, 1, '2022-11-14', 'Falla crítica del sistema en el área de urgencias', 'S'),
        ('Pérdida de datos en el laboratorio clínico', 3, 4, 'Alta', 6, 3, '2023-11-15', 'Se ha perdido información crítica en el laboratorio clínico', 'S');

-- insertando registros en a tabla de detalle de solucion

    INSERT INTO tb_detsolucion (idIncidencia, observacion, estado, fechaModificacion, indicador)
      VALUES
        (1, 'Iniciando solución del problema.', 'En proceso', '2023-11-06', 'S'),
        (2, 'Se está llevando a cabo la revisión de las impresoras.', 'En proceso', '2022-11-08', 'S'),
        (3, 'Trabajando en la corrección de la conexión a los servidores de red.', 'En proceso', '2023-11-09', 'S'),
        (4, 'Se ha derivado el problema a expertos en seguridad informática.', 'Derivado', '2023-11-10', 'S'),
        (5, 'La recuperación de datos está en marcha.', 'En proceso', '2021-11-12', 'S'),
        (6, 'Investigando el fallo en el software de radiología.', 'En proceso', '2021-11-13', 'S'),
        (7, 'Resolviendo problema de conexión a la red en el área de farmacia.', 'En proceso', '2023-11-14', 'S'),
        (8, 'Atendiendo intento de acceso no autorizado en recursos humanos.', 'Atendido', '2023-11-15', 'S'),
        (9, 'Actualizando sistema crítico en área de urgencias.', 'En proceso', '2022-11-16', 'S'),
        (10, 'Finalizando proceso de recuperación de datos en el laboratorio clínico.', 'En proceso', '2023-11-17', 'S'); 
