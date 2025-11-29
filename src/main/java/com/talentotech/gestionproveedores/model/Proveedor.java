package com.talentotech.gestionproveedores.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Marco la clase como entidad JPA
@Table(name = "proveedor") // Mapeo a la tabla "proveedor" de la BD
public class Proveedor {

    @Id // Indica que este atributo va a ser la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El valor va a ser generado automaticamente de forma incremental
    private Long id;
    private String nombre;
    private String apellido;

    public Proveedor(){}

    public Proveedor(Long id, String nombre, String apellido){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    


}
