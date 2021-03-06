CREATE PROCEDURE traerMisDocumentos(idUsuario INT)
BEGIN
	SELECT * FROM documents WHERE id_users = idUsuario AND folders_id IS NULL;
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

CREATE PROCEDURE traerMisCarpetas(idUsuario INT)
BEGIN
	SELECT * FROM folders WHERE users_id = idUsuario;
END$$

CREATE PROCEDURE traerMisCarpetasCompartidos(idUsuario INT)
BEGIN
	SELECT * FROM folders WHERE id IN (SELECT folders_id FROM users_has_folders WHERE users_id = idUsuario);
END$$

CREATE FUNCTION compartirCarpeta(idUsuarioPropietario INT, idUsuario INT, idCarpeta INT) RETURNS BOOLEAN
BEGIN
	DECLARE estado BOOLEAN;
	DECLARE idUsuarioPro INT;
	SELECT users_id INTO idUsuarioPro FROM folders WHERE id = idCarpeta;
	IF(idUsuarioPropietario = idUsuarioPro) THEN
			INSERT INTO users_has_folders SET users_id = idUsuario, folders_id = idCarpeta;
			SET estado = true;
			RETURN estado;
	ELSE
		SET estado = false;
		RETURN estado;
	END IF;
END$$
