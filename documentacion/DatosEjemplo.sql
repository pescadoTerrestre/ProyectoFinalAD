-- Usar la base de datos
USE instrumentos_db;

-- Insertar datos de ejemplo en la tabla marcas
INSERT INTO marcas (nombre, pais_origen) VALUES
('Fender', 'Estados Unidos'),
('Yamaha', 'Japón'),
('Gibson', 'Estados Unidos'),
('Roland', 'Japón'),
('Ibanez', 'Japón');

-- Insertar datos de ejemplo en la tabla instrumentos
INSERT INTO instrumentos (nombre, descripcion, categoria, marca_id, familia) VALUES
('Stratocaster', 'Guitarra eléctrica de cuerpo sólido', 'Guitarras', 1, 'Cuerda'),
('Pacifica', 'Guitarra eléctrica versátil', 'Guitarras', 2, 'Cuerda'),
('Les Paul', 'Guitarra eléctrica de cuerpo sólido', 'Guitarras', 3, 'Cuerda'),
('Juno-DS88', 'Sintetizador con teclado de 88 teclas', 'Teclados', 4, 'Viento'),
('RG550', 'Guitarra eléctrica de alto rendimiento', 'Guitarras', 5, 'Cuerda');

-- Insertar datos de ejemplo en la tabla usuarios
INSERT INTO usuarios (nombre, dni) VALUES
('Juan Pérez', '12345678A'),
('María López', '87654321B'),
('Carlos García', '11223344C'),
('Ana Martínez', '44332211D'),
('Luis Fernández', '55667788E');

-- Insertar datos de ejemplo en la tabla inventario
INSERT INTO inventario (instrumento_id, cantidad) VALUES
(1, 10),
(2, 5),
(3, 8),
(4, 3),
(5, 7);

-- Insertar datos de ejemplo en la tabla prestamos
INSERT INTO prestamos (instrumento_id, usuario_id, fecha_prestamo, fecha_devolucion) VALUES
(1, 1, '2023-01-10', '2023-01-20'),
(2, 2, '2023-02-15', '2023-02-25'),
(3, 3, '2023-03-05', '2023-03-15'),
(4, 4, '2023-04-10', '2023-04-20'),
(5, 5, '2023-05-01', '2023-05-11');