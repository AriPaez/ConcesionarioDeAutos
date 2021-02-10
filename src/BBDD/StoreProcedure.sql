--Verificacion de login.
ALTER PROCEDURE verificarLoginSecretario(@dniSecretario VARCHAR(8))
AS
BEGIN TRY
	IF NOT EXISTS (SELECT dniSecretario FROM secretario WHERE dniSecretario=@dniSecretario)
	BEGIN
		RAISERROR ('No existe el dni ingresado',14,1)
	END
	ELSE
	BEGIN
		SELECT dniSecretario FROM secretario  WHERE dniSecretario=@dniSecretario
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
	INSERT INTO [dbo].[secretario]
			   ([dniSecretario]
			   ,[contrasenia])
		 VALUES(@dniSecretario,
			   @password)
END TRY
BEGIN CATCH
	
	throw 500000,'¡Error. No se ha podido registrar!',1

END CATCH

--Ejecucio del procedimiento.

EXEC registrarSecretario '34234354','1234'

 