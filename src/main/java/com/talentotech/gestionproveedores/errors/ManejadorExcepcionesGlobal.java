package com.talentotech.gestionproveedores.errors;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.talentotech.gestionproveedores.enums.TipoProveedor;
import com.talentotech.gestionproveedores.enums.TipoRubro;
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

    // Maneja la excepcion de MethodArgumentNotValidException que tira el propio Jakarta.validations
    @ExceptionHandler(exception = MethodArgumentNotValidException.class)
    public ResponseEntity<RespuestaError> manejarRequestInvalida(MethodArgumentNotValidException ex){

        List<String> mensajes = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String campo = ((FieldError) error).getField();
            String mensaje = error.getDefaultMessage();
            mensajes.add("[-] " + campo + ": " + mensaje);
        });

        RespuestaError error = new RespuestaError(
            HttpStatus.BAD_REQUEST.value(),
            mensajes,
            LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // Maneja la excepcion de HttpMessageNotReadableException que tira al intentar convertir cuerpos de peticiones HTTP a objetos de Java
    @ExceptionHandler(exception = HttpMessageNotReadableException.class)
    public ResponseEntity<RespuestaError> manejarConversionesInvalidas(HttpMessageNotReadableException ex){
        String mensaje = "Datos invalidos en la peticion";
        if(ex.getMessage().contains("TipoRubro") || ex.getMessage().contains("TipoProveedor")){
            mensaje = "Valor de enum invalido. Valores permitidos para tipoRubro: " + Arrays.toString(TipoRubro.values()) + ". Valores permitidos para tipoProveedor: " + Arrays.toString(TipoProveedor.values());
        }

        RespuestaError error = new RespuestaError(
            HttpStatus.BAD_REQUEST.value(),
            mensaje,
            LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
