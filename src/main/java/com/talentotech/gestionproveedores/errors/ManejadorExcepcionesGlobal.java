package com.talentotech.gestionproveedores.errors;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.talentotech.gestionproveedores.exception.ProveedorInvalidoException;
import com.talentotech.gestionproveedores.exception.ProveedorNoEncontradoException;

@RestControllerAdvice // Este decorador hace que la clase maneje las excepciones de cualquier controlador en toda la aplicacion
public class ManejadorExcepcionesGlobal {
    
    // Maneja la excepcion de ProveedorNoEncontradoException
    @ExceptionHandler(exception = ProveedorNoEncontradoException.class)
    public ResponseEntity<RespuestaError> manejarProveedorNoEncontrardo(ProveedorNoEncontradoException ex){
        RespuestaError error = new RespuestaError(
            HttpStatus.NOT_FOUND.value(),
            ex.getMessage(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error); // Devuelvo un error personalizado por el cuerpo de la response
    }

    // Maneja la excepcion de ProveedorInvalidoException
    @ExceptionHandler(exception = ProveedorInvalidoException.class)
    public ResponseEntity<RespuestaError> manejarProveedorInvalido(ProveedorInvalidoException ex){
        RespuestaError error = new RespuestaError(
            HttpStatus.BAD_REQUEST.value(),
            ex.getMessage(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error); // Devuelvo un error personalizado por el cuerpo de la response
    }
}
