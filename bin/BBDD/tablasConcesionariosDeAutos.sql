CREATE TABLE secretario
(
	dniSecretario VARCHAR(8) PRIMARY KEY NOT NULL,
	contrasenia VARCHAR(30) NOT NULL
)

CREATE TABLE cliente
(
	dniCliente VARCHAR(8) PRIMARY KEY NOT NULL,
	dniSecretario VARCHAR(8) NOT NULL,
	primerNombre VARCHAR(20) NOT NULL,
	segundoNombre VARCHAR(20),
	apellido VARCHAR(20) NOT NULL,
	direccion VARCHAR(30) NOT NULL,
	telefono VARCHAR(10) NOT NULL,

	FOREIGN KEY(dniSecretario) REFERENCES secretario(dniSecretario)
)

CREATE TABLE taller
(
	idTaller VARCHAR (20) PRIMARY KEY NOT NULL,
	descripción VARCHAR(30) NOT NULL
)

CREATE TABLE mecanico
(
	dniMecanico VARCHAR(8) PRIMARY KEY NOT NULL,
	dniSecretario VARCHAR(8) NOT NULL,
	idTaller VARCHAR (20) NOT NULL,
	primerNombre VARCHAR(20) NOT NULL,
	segundoNombre  VARCHAR(20),
	apellido VARCHAR(20) NOT NULL,
	fechaContratacion DATE NOT NULL,
	salario FLOAT

	FOREIGN KEY(dniSecretario) REFERENCES secretario(dniSecretario),
	FOREIGN KEY(idTaller) REFERENCES taller(idTaller)
)

CREATE TABLE autoMovil
(
	idAutoMovil INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
	dniCliente VARCHAR(8),
	marca VARCHAR(25) NOT NULL,
	imagenAuto VARCHAR(200)
	FOREIGN KEY(dniCliente) REFERENCES cliente(dniCliente)
)

CREATE TABLE modelo
(
	idModelo INT  PRIMARY KEY IDENTITY(1,1) NOT NULL,
	idAutoMovil INT NOT NULL,
	modelo VARCHAR(20) NOT NULL,
	color VARCHAR(15) NOT NULL
	
	FOREIGN KEY(idAutoMovil) REFERENCES autoMovil(idAutoMovil)


)

CREATE TABLE autoNuevo
(
	idNuevoAuto INT  PRIMARY KEY IDENTITY(1,1) NOT NULL,
	idAutoMovil INT NOT NULL,
	cantidad INT NOT NULL
	FOREIGN KEY(idAutoMovil) REFERENCES autoMovil(idAutoMovil)

)

CREATE TABLE autoViejo
(
	idViejoAuto  INT  PRIMARY KEY IDENTITY(1,1) NOT NULL,
	idAutoMovil INT NOT NULL,
	matricula VARCHAR(7) NOT NULL,
	cantidadKilometros INT NOT NULL,
	dniDueñoAnterior VARCHAR(8) NOT NULL
	FOREIGN KEY(idAutoMovil) REFERENCES autoMovil(idAutoMovil)
)

CREATE TABLE reparacion
(
	idReparacion INT  PRIMARY KEY IDENTITY(1,1) NOT NULL,
	cantidadHorasDeArreglo TIME NOT NULL,
	idAutoMovil INT NOT NULL,
	dniMecanico VARCHAR(8) NOT NULL,
	FOREIGN KEY(idAutoMovil) REFERENCES autoMovil(idAutoMovil),
	FOREIGN KEY(dniMecanico) REFERENCES mecanico(dniMecanico)
)

