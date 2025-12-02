package com.talentotech.gestionproveedores.exception;

// Excepcion personalizada en caso de no encontrar un proveedor
public class ProveedorNoEncontradoException extends RuntimeException {
    public ProveedorNoEncontradoException(String mensaje){
        super(mensaje);
    }
}
