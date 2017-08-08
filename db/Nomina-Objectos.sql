DROP SCHEMA IF EXISTS Nominas;
CREATE DATABASE IF NOT EXISTS Nominas;

USE Nominas;

CREATE TABLE IF NOT EXISTS Puestos(
  IdPuesto INT PRIMARY KEY AUTO_INCREMENT,
  Descripcion VARCHAR(50) NOT NULL,
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
  Nombre VARCHAR(50) NOT NULL,
  Ubicacion VARCHAR(25) NOT NULL,
  Estado TINYINT(1) NOT NULL DEFAULT 1
);

CREATE TABLE IF NOT EXISTS Nominas(
  IdNomina INT PRIMARY KEY AUTO_INCREMENT,
  Descripcion VARCHAR(50) NOT NULL,
  Estado TINYINT(1) NOT NULL DEFAULT 1
);

CREATE TABLE IF NOT EXISTS Empleados(
  IdEmpleado INT PRIMARY KEY AUTO_INCREMENT,
  Cedula CHAR(11) UNIQUE,
  Nombre VARCHAR(80) NOT NULL,
  IdDepartamento INT NOT NULL,
  IdPuesto INT NOT NULL,
  Salario NUMERIC(12,2) NOT NULL DEFAULT 15000.00,
  IdNomina INT NOT NULL,
  Estado TINYINT(1) NOT NULL DEFAULT 1,
  FOREIGN KEY (IdDepartamento) REFERENCES Departamentos(IdDepartamento),
  FOREIGN KEY (IdPuesto) REFERENCES Puestos(IdPuesto),
  FOREIGN KEY (IdNomina) REFERENCES Nominas(IdNomina)
);

CREATE TABLE IF NOT EXISTS Transacciones(
  IdTransaccion INT PRIMARY KEY AUTO_INCREMENT,
  IdEmpleado INT NOT NULL,
  IdIngresoDeduccion INT NOT NULL,
  TipoTransaccion VARCHAR(10),
  Fecha DATETIME NOT NULL DEFAULT NOW(),
  Monto NUMERIC(12,2) NOT NULL DEFAULT 0.00,
  Estado TINYINT(1) NOT NULL DEFAULT 1,
  FOREIGN KEY (IdEmpleado) REFERENCES Empleados(IdEmpleado),
  FOREIGN KEY (IdIngresoDeduccion) REFERENCES TipoIngresoDeduccion(IdTipoIngresoDeduccion)
);

CREATE TABLE EmpleadoDepartamento(
  IdEmpleado INT NOT NULL,
  IdDepartamento INT NOT NULL,
  FOREIGN KEY (IdEmpleado) REFERENCES Empleados(IdEmpleado),
  FOREIGN KEY (IdDepartamento) REFERENCES Departamentos(IdDepartamento)
);

CREATE TABLE Usuario(
    IdUsuario INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(25) UNIQUE,
    Password VARCHAR(60) NOT NULL,
    Activo TINYINT(1) NOT NULL DEFAULT 1
);

CREATE TABLE Roles(
    IdRol INT PRIMARY KEY AUTO_INCREMENT,
    NombreRole VARCHAR(10) NOT NULL,
    Estado TINYINT(1) NOT NULL DEFAULT 1
);

CREATE TABLE Usuario_Rol(
    IdRol INT NOT NULL,
    IdUsuario INT NOT NULL,
    FOREIGN KEY (IdRol) REFERENCES Roles(IdRol),
    FOREIGN KEY (IdUsuario) REFERENCES Usuario(IdUsuario),
    PRIMARY KEY (IdRol, IdUsuario)
);


INSERT INTO Usuario (Nombre,Password)
VALUES
('admin','$2a$11$mTSFLSVlUC5KFBjIxQaMO.hEvO.RM0i191wQ54wjRk4CQQ3WrcOxq'),
('mortal','$2a$11$mTSFLSVlUC5KFBjIxQaMO.hEvO.RM0i191wQ54wjRk4CQQ3WrcOxq');

INSERT INTO Roles (NombreRole)
VALUES
('ADMIN'),
('USER');

INSERT INTO Usuario_Rol
(IdRol,IdUsuario)
VALUES
(1,1),
(2,2);

DELIMITER .

CREATE PROCEDURE RerporteNominas(
    DepId INT
)
BEGIN
  SELECT E.Nombre,
        E.Cedula,
        P.Descripcion Puesto,
        E.Salario,
        D.Nombre Departamento,
        N.Descripcion Nomina
    FROM Empleados E
    JOIN Departamentos D
    ON E.IdDepartamento = D.IdDepartamento
    JOIN Nominas N
    ON N.IdNomina = E.IdNomina
    JOIN Puestos P
    ON P.IdPuesto = E.IdPuesto
    WHERE D.IdDepartamento = DepId
END.

DELIMITER ;