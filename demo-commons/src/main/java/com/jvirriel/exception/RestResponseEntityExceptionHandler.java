package com.jvirriel.exception;

import com.jvirriel.logger.LoggerProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private final LoggerProducer producer;

    @Autowired
    public RestResponseEntityExceptionHandler(LoggerProducer producer) {
        this.producer = producer;
    }

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<?> handleIllegalArgumentException(RuntimeException runtimeException, WebRequest request) {
        producer.log(runtimeException);
        runtimeException.printStackTrace();

        return getResponseEntity("Error del Sistema.", SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<?> handleSqlConstraintException(EmptyResultDataAccessException exception, WebRequest request) {
        producer.log(exception);
        exception.printStackTrace();

        return getResponseEntity("Sin resultados.", NOT_FOUND);
    }

    @ExceptionHandler(NonTransientDataAccessException.class)
    public ResponseEntity<?> handleSqlConstraintException(NonTransientDataAccessException exception, WebRequest request) {
        producer.log(exception);
        exception.printStackTrace();

        return getResponseEntity("Violacion de restriccion de Base de Datos.", CONFLICT);
    }

    @ExceptionHandler(EntityVersionConflictException.class)
    public ResponseEntity<?> handleVersionException(EntityVersionConflictException exception, WebRequest request) {
        producer.log(exception);
        exception.printStackTrace();

        return getResponseEntity("Version de entidad desactualizada.", CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralException(Exception exception, WebRequest request) {
        producer.log(exception);
        exception.printStackTrace();

        return getResponseEntity("Error interno del servidor.", INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<?> getResponseEntity(String errorMessage, HttpStatus httpStatus) {
        return new ResponseEntity<>(CustomErrorType.get(errorMessage), httpStatus);
    }
}