package com.talentotech.gestionproveedores.exception;

// Excepcion personalizada en caso de que mande un Proveedor invalido por Body
public class ProveedorInvalidoException extends RuntimeException {
    public ProveedorInvalidoException(String mensaje){
        super(mensaje);
    }
}
