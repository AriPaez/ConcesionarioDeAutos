--Verificacion de login.
CREATE PROCEDURE verificarLoginSecretario(@dniSecretario VARCHAR(8))
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