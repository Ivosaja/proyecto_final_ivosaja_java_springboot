package com.talentotech.gestionproveedores.errors;

import java.time.LocalDateTime;

// Clase de respuesta de error que va a mandar el manejador global de excepciones
public class RespuestaError {

    private int status;
    private String mensaje;
    private LocalDateTime timestamp;

    public RespuestaError(int status, String mensaje, LocalDateTime timestamp){
        this.status = status;
        this.mensaje = mensaje;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return this.status;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
