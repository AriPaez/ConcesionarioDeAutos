--Verificacion de login.
CREATE PROCEDURE iniciarSesion(@dniSecretario VARCHAR(8),@password VARCHAR(30))
AS
BEGIN TRY
	IF NOT EXISTS (SELECT dniSecretario FROM secretario WHERE dniSecretario=@dniSecretario AND contrasenia=@password )
	BEGIN
		RAISERROR ('Error. Sesi�n Incorrecta',14,1)
	END
	ELSE
	BEGIN
		SELECT dniSecretario FROM secretario  WHERE dniSecretario=@dniSecretario AND contrasenia=@password
	END
END TRY
BEGIN CATCH
	
	DECLARE @mensajeDeError VARCHAR(100)
	SELECT @mensajeDeError=ERROR_MESSAGE()
	RAISERROR (@mensajeDeError,14,1)

END CATCH

--ejecucion del procedimiento.

EXEC verificarLoginSecretario '67576867'

--Registrar secretario.
ALTER PROCEDURE registrarSecretario(@dniSecretario VARCHAR(8),@password VARCHAR(30))
AS
BEGIN TRY
	IF(@dniSecretario IS NULL OR @password  IS NULL OR @dniSecretario='' OR
	@password='')
	 BEGIN
		 RAISERROR('CAMPOS VACIOS. INGRESE UN VALOR!',14,1)
	 END
	 ELSE
	 BEGIN
		INSERT INTO [dbo].[secretario]
				   ([dniSecretario]
				   ,[contrasenia])
		VALUES(@dniSecretario,
				   @password)
	END
END TRY
BEGIN CATCH
	DECLARE @mensajeDeError VARCHAR(50)
	SELECT @mensajeDeError=ERROR_MESSAGE()
	RAISERROR(@mensajeDeError,14,1);

END CATCH

--Ejecucio del procedimiento.

EXEC registrarSecretario '',''


--Registrar auto nuevo.

ALTER PROCEDURE registrarAutoNuevo(@marca VARCHAR(30),@modelo VARCHAR(30),
@color VARCHAR(15),@cantidad INT)
AS
BEGIN TRY
	IF (@marca IS NULL OR 
	@modelo IS NULL OR @color IS NULL OR @cantidad IS NULL OR @marca=''
	OR @modelo='' OR @color='' OR @cantidad='')
		BEGIN 
			RAISERROR('CAMPOS VACIOS. INGRESE UN VALOR!',14,1)
		END
	ELSE
			--Insersion de autoMovil
			INSERT INTO [dbo].[autoMovil]
					   (marca)
				 VALUES
					   (@marca)
			--Insersion de modelo
			INSERT INTO [dbo].[modelo]
					   ([idAutoMovil]
					   ,[modelo]
					   ,[color])
				 VALUES
					   ((SELECT MAX(idAutoMovil) FROM autoMovil)
					   ,@modelo
					   ,@color)

			--Insersion de cantidad de autos nuevos.
			INSERT INTO [dbo].[autoNuevo]
					   ([idAutoMovil]
					   ,[cantidad])
				 VALUES
					   ((SELECT MAX(idAutoMovil) FROM autoMovil)
					   ,@cantidad)
END TRY
BEGIN CATCH
	DECLARE @mensajeDeError VARCHAR(80)
	
	SELECT @mensajeDeError=ERROR_MESSAGE()
	RAISERROR(@mensajeDeError,14,1);

END CATCH
 
-- registrar auto viejo

CREATE PROCEDURE registrarAutoViejo(@marca varchar(30),@modelo VARCHAR(30),
@color VARCHAR(15),@matricula VARCHAR(7),@cantidadKilometros
FLOAT,@dniDue�oAnterior VARCHAR(8))
AS
BEGIN TRY
	IF (@marca='' OR @modelo='' OR 
	@color='' OR @matricula='' OR @cantidadKilometros='' OR @dniDue�oAnterior='')
		BEGIN 
			RAISERROR('CAMPOS VACIOS. INGRESE UN VALOR!',14,1)
		END
	ELSE
			--Insersion de autoMovil
			INSERT INTO [dbo].[autoMovil]
					   (marca)
				 VALUES
					   (@marca)
			--Insersion de modelo
			INSERT INTO [dbo].[modelo]
					   ([idAutoMovil]
					   ,[modelo]
					   ,[color])
				 VALUES
					   ((SELECT MAX(idAutoMovil) FROM autoMovil)
					   ,@modelo
					   ,@color)

			--Insersion de auto viejo.
			INSERT INTO [dbo].[autoViejo]
					   ([idAutoMovil]
					   ,[matricula]
					   ,[cantidadKilometros]
					   ,[dniDue�oAnterior])
				 VALUES
					   ((SELECT MAX(idAutoMovil) FROM autoMovil), 
					   @matricula, 
					   @cantidadKilometros,
					   @dniDue�oAnterior)
END TRY
BEGIN CATCH
	DECLARE @mensajeDeError VARCHAR(80)
	
	SELECT @mensajeDeError=ERROR_MESSAGE()
	RAISERROR(@mensajeDeError,14,1);

END CATCH

--Registrar cliente.

ALTER PROCEDURE registrarCliente(@dniCliente VARCHAR(8),
@dniSecretario VARCHAR(8),@primerNombre VARCHAR(30),@segundoNombre VARCHAR(30),
@apellido VARCHAR(20),@direccion VARCHAR(40),@tel�fono VARCHAR(10))
AS
BEGIN TRY
	IF (@dniCliente='' OR @dniSecretario='' OR @primerNombre='' 
	OR @segundoNombre='' OR @apellido='' OR  @direccion='' OR  @tel�fono='')
	BEGIN 
			RAISERROR('CAMPOS VACIOS. INGRESE UN VALOR!',14,1)
	END
	ELSE IF(LEN(@dniCliente)<>8 OR LEN(@dniSecretario)<>8)
	BEGIN 
			RAISERROR('�EL DNI DEBE SER DE 8 DIG�TOS!',14,1)
	END
	ELSE IF(LEN(@tel�fono)<>10)
	BEGIN 
			RAISERROR('�EL NRO. DE TEL�FONO DEBE SER DE 10 DIG�TOS!',14,1)
	END
	ELSE IF (ISNUMERIC(@dniCliente)=0 OR ISNUMERIC(@dniSecretario)=0)
	BEGIN
			RAISERROR('�EL NRO. DE DNI DEBE SER DE ENTERO!',14,1)
	END
	ELSE IF(ISNUMERIC(@tel�fono)=0)
	BEGIN
			RAISERROR('�EL NRO. DE TEL�FONO DEBE SER DE ENTERO!',14,1)
	END
	BEGIN 

	INSERT INTO [dbo].[cliente]
			   ([dniCliente]
			   ,[dniSecretario]
			   ,[primerNombre]
			   ,[segundoNombre]
			   ,[apellido]
			   ,[direccion]
			   ,[tel�fono])
		 VALUES
			   (@dniCliente,
			   @dniSecretario, 
			   @primerNombre, 
			   @segundoNombre, 
			   @apellido, 
			   @direccion, 
			   @tel�fono )
		END
END TRY

BEGIN CATCH

	DECLARE @mensajeDeError VARCHAR(100);

	SELECT @mensajeDeError=ERROR_MESSAGE()
	
	RAISERROR(@MENSAJEDEERROR,14,1);
END CATCH

EXEC registrarCliente '21212121','32323232','sdf','fsf','sfs','fsdf','fsdf'