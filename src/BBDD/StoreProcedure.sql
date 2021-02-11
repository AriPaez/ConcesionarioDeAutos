--Verificacion de login.
CREATE PROCEDURE iniciarSesion(@dniSecretario VARCHAR(8),@password VARCHAR(30))
AS
BEGIN TRY
	IF NOT EXISTS (SELECT dniSecretario FROM secretario WHERE dniSecretario=@dniSecretario AND contrasenia=@password )
	BEGIN
		RAISERROR ('Error. Sesión Incorrecta',14,1)
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

CREATE PROCEDURE registrarAutoNuevo(@marca VARCHAR(30),@modelo VARCHAR(30),@color VARCHAR(15),@cantidad INT)
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

 