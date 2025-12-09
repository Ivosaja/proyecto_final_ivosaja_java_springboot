package com.talentotech.gestionproveedores.model;

import com.talentotech.gestionproveedores.enums.TipoProveedor;
import com.talentotech.gestionproveedores.enums.TipoRubro;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombox para reducir codigo repetitivo
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @NotBlank(message = "El email no puede ser vacio")
    @Email(message = "El email debe ser valido")
    private String email;
    
    @NotEmpty(message = "El numero de telefono no puede ser vacio")
    @Pattern(regexp = "^\\+[0-9]{10,15}$", message = "El numero de telefono debe tener entre 10 y 15 digitos y arrancar con +")
    private String telefono;

    @NotNull(message = "El tipo de rubro es obligatorio")
    @Enumerated(EnumType.STRING)
    private TipoRubro tipoRubro;

    @NotNull(message = "El tipo de proveedor es obligatorio")
    @Enumerated(EnumType.STRING)
    private TipoProveedor tipoProveedor;

}
