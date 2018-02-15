CREATE PROCEDURE traerMisDocumentos(idUsuario INT)
BEGIN
	SELECT * FROM documents WHERE id_users = idUsuario;
END$$

CREATE PROCEDURE traerMisDocumentosCompartidos(idUsuario INT)
BEGIN
	SELECT * FROM documents WHERE id IN (SELECT documento FROM users_has_documents WHERE usuario = idUsuario);
END$$

CREATE FUNCTION compartirDocumento(idUsuarioPropietario INT, idUsuario INT, idDocumento INT) RETURNS BOOLEAN
BEGIN
	DECLARE estado BOOLEAN;
	DECLARE idUsuarioPro INT;
	SELECT id_users INTO idUsuarioPro FROM documents WHERE id = idDocumento;
	IF(idUsuarioPropietario = idUsuarioPro) THEN
			INSERT INTO users_has_documents SET usuario = idUsuario, documento = idDocumento;
			SET estado = true;
			RETURN estado;
	ELSE
		SET estado = false;
		RETURN estado;
	END IF;
END$$