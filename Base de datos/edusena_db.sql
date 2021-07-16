CREATE DATABASE edusena; 
USE edusena; 

CREATE TABLE Profesores(
    identificacion_prof INT PRIMARY KEY NOT NULL,
    nombres_prof VARCHAR(50) NOT NULL,
    apellidos_prof varchar(50) NOT NULL,
    edad_prof INT NOT NULL,
    direccion_prof VARCHAR(30) NOT NULL, 
    genero_prof VARCHAR(10) NOT NULL,
    correo_prof VARCHAR(30) NOT NULL,
    telefono_prof INT NOT NULL
);


CREATE TABLE Cursos(
    codigo_curso INT PRIMARY KEY NOT NULL,
    nombre_curso VARCHAR(30) NOT NULL,
    cant_estu_curso INT NOT NULL,
    id_prof_curso INT NOT NULL, FOREIGN KEY(id_prof_curso) REFERENCES profesores(identificacion_prof)  ON DELETE CASCADE

);

CREATE TABLE Estudiantes(
    identificacion_estu INT NOT NULL PRIMARY KEY,
    nombres_estu VARCHAR(50)  NOT NULL,
    apellidos_estu varchar(50) NOT NULL,
    edad_estu INT NOT NULL,
    direccion_estu VARCHAR(30) NOT NULL,     
    genero_estu VARCHAR(10) NOT NULL,
    correo_estu VARCHAR(30) NOT NULL,
    telefono_estu INT NOT NULL,
    nombre_acu_estu VARCHAR(50) NOT NULL,
    telefono_acu_estu INT NOT NULL,
    id_prof_estu INT NOT NULL, FOREIGN KEY(id_prof_estu ) REFERENCES Profesores(identificacion_prof) ON DELETE CASCADE ,
    codigo_curso_estu INT NOT NULL, FOREIGN KEY(codigo_curso_estu) REFERENCES Cursos(codigo_curso )  ON DELETE CASCADE
);

CREATE TABLE Usuarios(
    id_user INT NOT NULL PRIMARY KEY,
    usuario VARCHAR(60) NOT NULL,
	password_user VARCHAR(60) NOT NULL
);

SELECT  estu.identificacion_estu, estu.nombres_estu, estu.apellidos_estu, estu.edad_estu, estu.direccion_estu, estu.genero_estu, estu.correo_estu, estu.telefono_estu, estu.nombre_acu_estu, estu.telefono_acu_estu, prof.nombres_prof, prof.apellidos_prof, cur.nombre_curso FROM estudiantes estu INNER JOIN profesores prof ON estu.id_prof_estu  = prof.identificacion_prof INNER JOIN cursos cur ON estu.codigo_curso_estu = cur.codigo_curso ORDER BY estu.nombres_estu ;


