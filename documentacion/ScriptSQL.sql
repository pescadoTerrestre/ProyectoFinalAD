-- Crear base de datos
CREATE DATABASE IF NOT EXISTS instrumentos_db;
USE instrumentos_db;

-- Crear tabla marcas
CREATE TABLE marcas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL UNIQUE,
    pais_origen VARCHAR(255)
);

-- Crear tabla instrumentos
CREATE TABLE instrumentos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255),
    categoria VARCHAR(255) NOT NULL,
    marca_id BIGINT,
    familia ENUM('Viento', 'Percusión', 'Cuerda'),
    FOREIGN KEY (marca_id) REFERENCES marcas(id)
);

-- Crear tabla usuarios
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    dni VARCHAR(255)
);

-- Crear tabla inventario
CREATE TABLE inventario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    instrumento_id BIGINT,
    cantidad INT NOT NULL,
    FOREIGN KEY (instrumento_id) REFERENCES instrumentos(id)
);

-- Crear tabla prestamos
CREATE TABLE prestamos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    instrumento_id BIGINT,
    usuario_id BIGINT,
    fecha_prestamo DATE NOT NULL,
    fecha_devolucion DATE,
    FOREIGN KEY (instrumento_id) REFERENCES instrumentos(id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);