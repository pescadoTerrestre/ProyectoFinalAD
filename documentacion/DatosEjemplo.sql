-- Usar la base de datos
USE instrumentos_db;

-- Insertar datos de ejemplo en marcas
INSERT INTO marcas (nombre, pais_origen) VALUES
('Yamaha', 'Japón'),
('Gibson', 'EE.UU.'),
('Fender', 'EE.UU.');

-- Insertar datos de ejemplo en familias
INSERT INTO familias (nombre) VALUES
('Cuerda'),
('Viento'),
('Percusión');

-- Insertar datos de ejemplo en instrumentos
INSERT INTO instrumentos (nombre, descripcion, cantidad, marca_id, familia_id) VALUES
('Guitarra Acústica', 'Guitarra de 6 cuerdas', 10, 2, 1),
('Flauta', 'Flauta de madera', 15, 1, 2),
('Batería', 'Batería completa', 5, 3, 3);

-- Insertar datos de ejemplo en usuarios
INSERT INTO usuarios (nombre, dni, email, telefono, direccion) VALUES
('Juan Pérez', '12345678A', 'juan.perez@example.com', '555-1234', 'Calle Falsa 123'),
('María López', '87654321B', 'maria.lopez@example.com', '555-5678', 'Avenida Siempre Viva 742');

-- Insertar datos de ejemplo en prestamos
INSERT INTO prestamos (instrumento_id, usuario_id, fecha_prestamo, fecha_devolucion, estado) VALUES
(2, 2, date(curdate()), NULL, 'Pendiente'),
(1, 1, date(CURDATE()), NULL, 'Devuelto');