package com.talentotech.gestionproveedores.errors;

import java.time.LocalDateTime;

// Clase de respuesta de error que va a mandar el manejador global de excepciones
public class RespuestaError {

    private int status;
    private Object mensaje; // Acepta String o List (en caso de tener varios errores)
    private LocalDateTime timestamp;

    public RespuestaError(int status, Object mensaje, LocalDateTime timestamp){
        this.status = status;
        this.mensaje = mensaje;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return this.status;
    }

    public Object getMensaje() {
        return this.mensaje;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMensaje(Object mensaje) {
        this.mensaje = mensaje;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
