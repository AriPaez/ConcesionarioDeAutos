CREATE TABLE cliente
(
	dniCliente VARCHAR(8) PRIMARY KEY NOT NULL,
	primerNombre VARCHAR(20) NOT NULL,
	segundoNombre VARCHAR(20),
	apellido VARCHAR(20) NOT NULL,
	direccion VARCHAR(30) NOT NULL,
	teléfono VARCHAR(10) NOT NULL
)

CREATE TABLE taller
(
	idCodigoTaller INT  PRIMARY KEY IDENTITY(1,1) NOT NULL,
	descripción VARCHAR(30) NOT NULL
)

CREATE TABLE mecanico
(
	dniMecanico VARCHAR(8) PRIMARY KEY NOT NULL,
	idCodigoTaller INT  NOT NULL,
	primerNombre VARCHAR(20) NOT NULL,
	segundoNombre  VARCHAR(20),
	apellido VARCHAR(20) NOT NULL,
	fechaContratacion VARCHAR(30) NOT NULL,
	salario FLOAT

	FOREIGN KEY(idCodigoTaller) REFERENCES taller(idCodigoTaller)
)

CREATE TABLE autoMovil
(
	matricula VARCHAR(7) PRIMARY KEY NOT NULL,
	dniCliente VARCHAR(8) not null,
	marca VARCHAR(25) NOT NULL,

	FOREIGN KEY(dniCliente) REFERENCES cliente(dniCliente)
)

CREATE TABLE modelo
(
	idModelo INT  PRIMARY KEY IDENTITY(1,1) NOT NULL,
	modelo VARCHAR(20) NOT NULL,
	matricula VARCHAR(7) NOT NULL,
	color VARCHAR(15) NOT NULL
	
	FOREIGN KEY(matricula) REFERENCES autoMovil(matricula)


)

CREATE TABLE autoNuevo
(
	idNuevoAuto INT  PRIMARY KEY IDENTITY(1,1) NOT NULL,
	matricula VARCHAR(7) NOT NULL,
	cantidad INT NOT NULL
	FOREIGN KEY(matricula) REFERENCES autoMovil(matricula)

)

CREATE TABLE autoViejo
(
	idViejoAuto  INT  PRIMARY KEY IDENTITY(1,1) NOT NULL,
	matricula VARCHAR(7) NOT NULL,
	cantidadKilometros INT NOT NULL,
	dniDueñoAnterior VARCHAR(8) NOT NULL
	FOREIGN KEY(matricula) REFERENCES autoMovil(matricula)
)

CREATE TABLE reparacion
(
	idReparacion INT  PRIMARY KEY IDENTITY(1,1) NOT NULL,
	cantidadHorasDeArreglo TIME NOT NULL,
	matricula VARCHAR(7) NOT NULL,
	dniMecanico VARCHAR(8) NOT NULL,
	FOREIGN KEY(matricula) REFERENCES autoMovil(matricula),
	FOREIGN KEY(dniMecanico) REFERENCES mecanico(dniMecanico)
)