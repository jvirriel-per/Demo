package com.jvirriel.exception;

import org.springframework.dao.DataAccessException;

/**
 * Excepcion para señalar inconsistencia de versiones al momento insertar en BD.
 */
public class EntityVersionConflictException extends DataAccessException {
    public EntityVersionConflictException(String msg) {
        super(msg);
    }

    public EntityVersionConflictException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
