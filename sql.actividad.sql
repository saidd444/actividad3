-- ==========================
-- 0) Crear/usar la base
-- ==========================
CREATE DATABASE IF NOT EXISTS escuela
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci;
USE escuela;

-- ==========================================
-- 1) Limpieza segura (si quieres “resetear”)
--    Ejecuta esta sección solo si deseas
--    borrar tablas anteriores.
-- ==========================================
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS docente;
DROP TABLE IF EXISTS estudiante;
DROP TABLE IF EXISTS persona;
DROP TABLE IF EXISTS profesion;
SET FOREIGN_KEY_CHECKS = 1;

-- ==========================
-- 2) Tablas
-- ==========================

-- PROFESION
CREATE TABLE profesion (
  id_profesion INT AUTO_INCREMENT PRIMARY KEY,
  profesion     VARCHAR(80) NOT NULL UNIQUE
) ENGINE=InnoDB;

-- PERSONA (clase base)
CREATE TABLE persona (
  id               INT AUTO_INCREMENT PRIMARY KEY,
  nit              VARCHAR(20) UNIQUE,        -- Deja UNIQUE para evitar duplicados
  nombres          VARCHAR(60) NOT NULL,
  apellidos        VARCHAR(60) NOT NULL,
  direccion        VARCHAR(120),
  telefono         VARCHAR(20),
  fecha_nacimiento DATE,
  genero           BOOLEAN                    -- 1=masc, 0=fem, NULL=sin especificar
) ENGINE=InnoDB;

-- DOCENTE (hereda de persona)
CREATE TABLE docente (
  id_persona   INT PRIMARY KEY,               -- mismo id que persona.id
  codigo       VARCHAR(20) NOT NULL UNIQUE,
  salario      DECIMAL(10,2) NOT NULL DEFAULT 0,
  id_profesion INT,
  CONSTRAINT fk_docente_persona
    FOREIGN KEY (id_persona) REFERENCES persona(id)
    ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_docente_profesion
    FOREIGN KEY (id_profesion) REFERENCES profesion(id_profesion)
    ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB;

-- ESTUDIANTE (hereda de persona)
CREATE TABLE estudiante (
  id_persona INT PRIMARY KEY,                 -- mismo id que persona.id
  carnet     VARCHAR(20) NOT NULL UNIQUE,
  CONSTRAINT fk_estudiante_persona
    FOREIGN KEY (id_persona) REFERENCES persona(id)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB;

-- ==========================
-- 3) Datos de ejemplo
-- ==========================

-- Profesiones
INSERT INTO profesion (profesion) VALUES
  ('Ingeniero en Sistemas'),
  ('Matemático'),
  ('Físico'),
  ('Arquitecto');

-- Personas (usa NIT distintos para respetar UNIQUE)
INSERT INTO persona(nit,nombres,apellidos,direccion,telefono,fecha_nacimiento,genero) VALUES
  ('CF1','María','López','Zona 1','5555-1111','1995-05-01',0),
  ('CF2','Juan','Pérez','Zona 10','5555-2222','1990-01-15',1);

-- Asignar Docente a la persona con NIT CF1 (sin adivinar id)
INSERT INTO docente(id_persona,codigo,salario,id_profesion)
SELECT p.id, 'D-001', 6500.00, 1
FROM persona p
WHERE p.nit = 'CF1';

-- Asignar Estudiante a la persona con NIT CF2
INSERT INTO estudiante(id_persona,carnet)
SELECT p.id, 'E-2025-0001'
FROM persona p
WHERE p.nit = 'CF2';

-- ==========================
-- 4) Consultas de verificación
-- ==========================
-- SELECT * FROM profesion;
-- SELECT * FROM persona;
-- SELECT * FROM docente;
-- SELECT * FROM estudiante;
