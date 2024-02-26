CREATE TABLE Alumno (
    nombre VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    imagen VARCHAR(250),
    notaFinal FLOAT NOT NULL,
    cursoID INT
);

CREATE TABLE Curso (
    cursoID INT PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    fecha DATE NOT NULL,
    notaCorte FLOAT NOT NULL,
    mediaCalificaciones FLOAT DEFAULT 0
);

INSERT INTO Alumno (nombre, password, imagen, notaFinal, cursoID) VALUES
('Juan', 'password1', '/home/usuario/NetBeansProjects/P05/src/Datos/fotos/1001.jpg', 8.5, 1),
('María', 'password2', '/home/usuario/NetBeansProjects/P05/src/Datos/fotos/1002.jpg', 7.2, 5),
('Carlos', 'password3', '/home/usuario/NetBeansProjects/P05/src/Datos/fotos/1004.jpg', 6.9, 2),
('Ana', 'password4', '/home/usuario/NetBeansProjects/P05/src/Datos/fotos/1005.jpg', 9.1, 5),
('Pedro', 'password5', '/home/usuario/NetBeansProjects/P05/src/Datos/fotos/1007.jpg', 6.3, 3),
('Laura', 'password6', '/home/usuario/NetBeansProjects/P05/src/Datos/fotos/1008.jpg', 7.8, 3),
('Luis', 'password7', '/home/usuario/NetBeansProjects/P05/src/Datos/fotos/1009.jpg', 8.0, 1),
('Sofía', 'password8', '/home/usuario/NetBeansProjects/P05/src/Datos/fotos/1010.jpg', 6.5, 2),
('Miguel', 'password9', '/home/usuario/NetBeansProjects/P05/src/Datos/fotos/1011.jpg', 8.9, 5),
('Lucía', 'password10', '/home/usuario/NetBeansProjects/P05/src/Datos/fotos/1012.jpg', 7.4, 4),
('Diego', 'password11', '/home/usuario/NetBeansProjects/P05/src/Datos/fotos/1013.jpg', 7.0, 4),
('Elena', 'password12', '/home/usuario/NetBeansProjects/P05/src/Datos/fotos/1015.jpg', 6.8, 3),
('Pablo', 'password13', '/home/usuario/NetBeansProjects/P05/src/Datos/fotos/1017.jpg', 8.2, 1),
('Carmen', 'password14', '/home/usuario/NetBeansProjects/P05/src/Datos/fotos/1018.jpg', 6.7, 2),
('Manuel', 'password15', '/home/usuario/NetBeansProjects/P05/src/Datos/fotos/1019.jpg', 7.5, 4);

INSERT INTO Curso (cursoID, password, nombre, fecha, notaCorte) VALUES
(1, 'password1', 'Desarrollo de Aplicaciones Multiplataforma', '2023-09-01', 6.5),
(2, 'password2', 'Administración de Sistemas Informáticos en Red', '2023-09-01', 7.0),
(3, 'password3', 'Sistemas Microinformáticos y Redes', '2023-09-01', 6.0),
(4, 'password4', 'Automatización y Robótica Industrial', '2023-09-01', 7.2),
(5, 'password5', 'Desarrollo de Aplicaciones Web', '2023-09-01', 6.8);
