package com.talentotech.gestionproveedores.service;

import java.util.List;

import com.talentotech.gestionproveedores.enums.TipoProveedor;
import com.talentotech.gestionproveedores.enums.TipoRubro;
import com.talentotech.gestionproveedores.model.Proveedor;

// Interfaz que brinda metodos a ser implementados
public interface ProveedorService {

    // Obtener todos los proveedores o filtrar por query params
    List<Proveedor> obtenerProveedores(TipoRubro tipoRubro, TipoProveedor tipoProveedor);

    // Obtener un proveedor por ID
    Proveedor obtenerProveedorPorId(Long id);

    // Crear un nuevo proveedor
    Proveedor crearProveedor(Proveedor p);
    
    // Actualizar un proveedor por ID
    Proveedor actualizarProveedor(Proveedor nuevoProveedor, Long id);
    
    // Eliminar un proveedor por ID
    void eliminarProveedor(Long id);

}
