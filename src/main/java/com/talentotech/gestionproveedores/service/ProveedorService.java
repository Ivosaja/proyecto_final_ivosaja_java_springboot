package com.talentotech.gestionproveedores.service;

import java.util.List;

import com.talentotech.gestionproveedores.enums.TipoProveedor;
import com.talentotech.gestionproveedores.enums.TipoRubro;
import com.talentotech.gestionproveedores.model.Proveedor;

// Interfaz que brinda metodos a ser implementados
public interface ProveedorService {

    // Obtener todos los proveedores
    List<Proveedor> obtenerProveedores();

    // Obtener todos los proveedores de un Tipo de Rubro especifico
    List<Proveedor> obtenerProveedoresPorTipoRubro(TipoRubro tipoRubro);

    // Obtener todos los proveedores de un Tipo de Proveedor especifico
    List<Proveedor> obtenerProveedoresPorTipoProveedor(TipoProveedor tipoProveedor);

    // Obtener un proveedor por ID
    Proveedor obtenerProveedorPorId(Long id);

    // Crear un nuevo proveedor
    Proveedor crearProveedor(Proveedor p);
    
    // Actualizar un proveedor por ID
    Proveedor actualizarProveedor(Proveedor nuevoProveedor, Long id);
    
    // Eliminar un proveedor por ID
    void eliminarProveedor(Long id);

}
