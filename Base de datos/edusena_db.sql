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
    telefono_prof VARCHAR(30) NOT NULL
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
    telefono_estu VARCHAR(30) NOT NULL,
    nombre_acu_estu VARCHAR(50) NOT NULL,
    telefono_acu_estu VARCHAR(30) NOT NULL,
    id_prof_estu INT NOT NULL, FOREIGN KEY(id_prof_estu ) REFERENCES Profesores(identificacion_prof) ON DELETE CASCADE ,
    codigo_curso_estu INT NOT NULL, FOREIGN KEY(codigo_curso_estu) REFERENCES Cursos(codigo_curso )  ON DELETE CASCADE
);

CREATE TABLE Usuarios(
    id_user INT NOT NULL PRIMARY KEY,
    usuario VARCHAR(60) NOT NULL,
	password_user VARCHAR(60) NOT NULL
);

INSERT INTO Usuarios(id_user,usuario,password_user) VALUES ("1","admin","1234");


INSERT INTO Profesores(identificacion_prof,nombres_prof,apellidos_prof,edad_prof,direccion_prof, genero_prof,correo_prof,telefono_prof) VALUES ("1","Gabriel","Rizaralda","35","Calle 23B #2-c","Masculino","GabRizaralda@edusena.co","36254");
INSERT INTO Profesores(identificacion_prof,nombres_prof,apellidos_prof,edad_prof,direccion_prof, genero_prof,correo_prof,telefono_prof) VALUES ("2","Adrian","Davila","46","Calle 42C #4b","Masculino","AdrDavila@edusena.co","369864");
INSERT INTO Profesores(identificacion_prof,nombres_prof,apellidos_prof,edad_prof,direccion_prof, genero_prof,correo_prof,telefono_prof) VALUES ("3","Lucia","Orozco","56","Cra 3c 45 #4b","Femenino","LuciOrozco@edusena.co","36654686");
INSERT INTO Profesores(identificacion_prof,nombres_prof,apellidos_prof,edad_prof,direccion_prof, genero_prof,correo_prof,telefono_prof) VALUES ("4","Aida","Carbajal","27","Calle 19a #34-6","Femenino","AidCarbajal@edusena.co","36354654");

INSERT INTO Cursos(codigo_curso,nombre_curso,cant_estu_curso,id_prof_curso) VALUES ("1","Matematicas","45","1");
INSERT INTO Cursos(codigo_curso,nombre_curso,cant_estu_curso,id_prof_curso) VALUES ("2","Informatica","35","2");
INSERT INTO Cursos(codigo_curso,nombre_curso,cant_estu_curso,id_prof_curso) VALUES ("3","Fisica","35","1");
INSERT INTO Cursos(codigo_curso,nombre_curso,cant_estu_curso,id_prof_curso) VALUES ("4","Historia","35","3");
INSERT INTO Cursos(codigo_curso,nombre_curso,cant_estu_curso,id_prof_curso) VALUES ("5","ArtÃ­stica","45","4");

INSERT INTO Estudiantes(identificacion_estu,nombres_estu,apellidos_estu,edad_estu,direccion_estu,genero_estu,correo_estu,telefono_estu,nombre_acu_estu,telefono_acu_estu,id_prof_estu,codigo_curso_estu) VALUES ("1","Juan","Guerra","18","Calle 45G #3e","Masculino","JGuerraEs@edusena.co","135465","Roberto Guerra","646749","1","1");
INSERT INTO Estudiantes(identificacion_estu,nombres_estu,apellidos_estu,edad_estu,direccion_estu,genero_estu,correo_estu,telefono_estu,nombre_acu_estu,telefono_acu_estu,id_prof_estu,codigo_curso_estu) VALUES ("2","Mateo","Mesa","19","Calle 12B #4c-45","Masculino","MMesa@edusena.co","15645","Lucas mesa","390123","2","2");
INSERT INTO Estudiantes(identificacion_estu,nombres_estu,apellidos_estu,edad_estu,direccion_estu,genero_estu,correo_estu,telefono_estu,nombre_acu_estu,telefono_acu_estu,id_prof_estu,codigo_curso_estu) VALUES ("3","Felipe","Velez","15","Cra 10b #1-60","Masculino","FelVelez@edusena.co","3235645","Magno Velez","32363749","1","3");
INSERT INTO Estudiantes(identificacion_estu,nombres_estu,apellidos_estu,edad_estu,direccion_estu,genero_estu,correo_estu,telefono_estu,nombre_acu_estu,telefono_acu_estu,id_prof_estu,codigo_curso_estu) VALUES ("4","Jorge","Manzur","16","Calle 14C #31-1","Masculino","JorManzur@edusena.co","15645","Enilda Manzur","66789639","3","4");
INSERT INTO Estudiantes(identificacion_estu,nombres_estu,apellidos_estu,edad_estu,direccion_estu,genero_estu,correo_estu,telefono_estu,nombre_acu_estu,telefono_acu_estu,id_prof_estu,codigo_curso_estu) VALUES ("5","Abelardo","De la hoz","19","Calle 12B #4c-45","Masculino","AbelDelahoz@edusena.co","1564235","Alvaro De la hoz","61663749","4","5");
INSERT INTO Estudiantes(identificacion_estu,nombres_estu,apellidos_estu,edad_estu,direccion_estu,genero_estu,correo_estu,telefono_estu,nombre_acu_estu,telefono_acu_estu,id_prof_estu,codigo_curso_estu) VALUES ("6","Luisa","De la hoz","22","Calle 12B #4c-45","Femenino","LuiDelahoz@edusena.co","15146345","Alvaro De la hoz","61663749","4","5");
