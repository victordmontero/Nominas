DROP SCHEMA IF EXISTS Nominas;
CREATE DATABASE IF NOT EXISTS Nominas;

USE Nominas;

CREATE TABLE IF NOT EXISTS Puestos(
  IdPuesto INT PRIMARY KEY AUTO_INCREMENT,
  Descripcion VARCHAR(20) NOT NULL,
  Riesgo VARCHAR(10) NOT NULL,
  SalarioMin NUMERIC(12,2) NOT NULL DEFAULT 15000.00,
  SalarioMax NUMERIC(12,2) NOT NULL,
  Estado TINYINT(1) NOT NULL DEFAULT 1
 );

CREATE TABLE IF NOT EXISTS TipoIngresoDeduccion(
  IdTipoIngresoDeduccion INT PRIMARY KEY AUTO_INCREMENT,
  Descripcion VARCHAR(50) NOT NULL,
  DependeSalario TINYINT(1) DEFAULT 0,
  Tipo CHAR(1) NOT NULL,
  Estado TINYINT(1) NOT NULL DEFAULT 1,
  CONSTRAINT CHK_TIPO CHECK (Tipo = 'D' OR Tipo='I')
);

CREATE TABLE IF NOT EXISTS Departamentos(
  IdDepartamento INT PRIMARY KEY AUTO_INCREMENT,
  Nombre VARCHAR(25) NOT NULL,
  Ubicacion VARCHAR(25) NOT NULL,
  Estado TINYINT(1) NOT NULL DEFAULT 1
);

CREATE TABLE IF NOT EXISTS Empleados(
  IdEmpleado INT PRIMARY KEY AUTO_INCREMENT,
  Cedula CHAR(11) UNIQUE,
  Nombre VARCHAR(25) NOT NULL,
  IdDepartamento INT NOT NULL,
  IdPuesto INT NOT NULL,
  Salario NUMERIC(12,2) NOT NULL DEFAULT 15000.00,
  IdNomina CHAR(3) NOT NULL,
  Estado TINYINT(1) NOT NULL DEFAULT 1,
  FOREIGN KEY (IdDepartamento) REFERENCES Departamentos(IdDepartamento),
  FOREIGN KEY (IdPuesto) REFERENCES Puestos(IdPuesto)
);

CREATE TABLE IF NOT EXISTS Transacciones(
  IdTransaccion INT PRIMARY KEY AUTO_INCREMENT,
  IdEmpleado INT NOT NULL,
  IdIngresoDeduccion INT NOT NULL,
  TipoTransaccion VARCHAR(10),
  Fecha DATETIME NOT NULL DEFAULT NOW(),
  FOREIGN KEY (IdEmpleado) REFERENCES Empleados(IdEmpleado),
  FOREIGN KEY (IdIngresoDeduccion) REFERENCES TipoIngresoDeduccion(IdTipoIngresoDeduccion)
);

CREATE TABLE EmpleadoDepartamento(
  IdEmpleado INT NOT NULL,
  IdDepartamento INT NOT NULL,
  FOREIGN KEY (IdEmpleado) REFERENCES Empleados(IdEmpleado),
  FOREIGN KEY (IdDepartamento) REFERENCES Departamentos(IdDepartamento)
);
