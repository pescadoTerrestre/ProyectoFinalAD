-- Crear base de datos
CREATE DATABASE IF NOT EXISTS instrumentos_db;
USE instrumentos_db;

-- Crear tabla marcas
CREATE TABLE marcas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL UNIQUE,
    pais_origen VARCHAR(255)
);

-- Crear tabla familias
CREATE TABLE familias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL UNIQUE,
    descripcion VARCHAR(255)
);

-- Crear tabla instrumentos
CREATE TABLE instrumentos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255),
    cantidad INT DEFAULT 0 NOT NULL,
    marca_id BIGINT,
    familia_id BIGINT,
    FOREIGN KEY (marca_id) REFERENCES marcas(id),
    FOREIGN KEY (familia_id) REFERENCES familias(id)
);

-- Crear tabla usuarios
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    dni VARCHAR(255),
    email VARCHAR(255),
    telefono VARCHAR(255),
    direccion VARCHAR(255),
    fecha_registro DATE DEFAULT (CURDATE())
);

-- Crear tabla prestamos
CREATE TABLE prestamos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    instrumento_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    fecha_prestamo DATE DEFAULT (current_date) NOT NULL,
    fecha_devolucion DATE,
    estado varchar(255) DEFAULT 'Pendiente' NOT NULL,
    FOREIGN KEY (instrumento_id) REFERENCES instrumentos(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

delimiter //
create trigger PrestamosAU
after update on prestamos
for each row
begin
	update instrumentos 
    set cantidad = 
		case
			when old.estado != new.estado and new.estado = 'Devuelto' then cantidad + 1
			when old.estado != new.estado and new.estado = 'Pendiente' then cantidad - 1
			else cantidad
		end
    where id = new.instrumento_id;
end;
//
delimiter ;

delimiter //
create trigger PrestamosAI
after insert on prestamos
for each row
begin
	update instrumentos 
    set cantidad = 
		case
			when new.estado = 'Pendiente' then cantidad - 1
            else cantidad
		end
    where id = new.instrumento_id;
end;
//
delimiter ;

delimiter //
create trigger PrestamosBD
before delete on prestamos
for each row
begin
	update instrumentos 
    set cantidad = 
		case
			when old.estado = 'Pendiente' then cantidad + 1
            else cantidad
		end
    where id = old.instrumento_id;
end;
//
delimiter ;