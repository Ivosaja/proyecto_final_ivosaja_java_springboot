package com.talentotech.gestionproveedores.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity // Marco la clase como entidad JPA
@Table(name = "proveedor") // Mapeo a la tabla "proveedor" de la BD
public class Proveedor {

    @Id // Indica que este atributo va a ser la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El valor va a ser generado automaticamente de forma incremental
    private Long id;

    @NotBlank(message = "El nombre no puede ser vacio")
    @Size(min = 3, max = 30, message = "El nombre debe tener minimo 3 y maximo 30 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido no puede ser vacio")
    @Size(min = 3, max = 30, message = "El apellido debe tener minimo 3 y maximo 30 caracteres")
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
