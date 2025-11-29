package com.talentotech.gestionproveedores.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talentotech.gestionproveedores.model.Proveedor;
import com.talentotech.gestionproveedores.repository.ProveedorRepository;

// Marco la clase como servicio de Spring
@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository){
        this.proveedorRepository = proveedorRepository;
    }

    // ----------------------- OBTENER PROVEEDORES ----------------------- //
    // Metodo encargado de devolver todos los proveedores de la BD
    public List<Proveedor> obtenerProveedores(){
        return this.proveedorRepository.findAll();
    }

    // ----------------- OBTENER PROVEEDOR POR ID ----------------- //
    // Metodo encargado de devolver un proveedor por ID de la BD
    public Proveedor obtenerProveedorPorId(Long id){
        return this.proveedorRepository.findById(id).orElseThrow(() -> new IllegalStateException("Proveedor con ID: " + id + " no encontrado"));
    }

    // ---------------------- CREAR PROVEEDOR ---------------------- //
    // Metodo encargado de crear un proveedor en la BD
    public Proveedor creaProveedor(Proveedor p){
        return this.proveedorRepository.save(p);
    }

    // ------------- ACTUALIZAR PROVEEDOR ------------- //
    // Metodo encargado de actualizar un proveedor de la BD
    public void actualizarProveedor(Proveedor nuevoProveedor, Long id){
        Proveedor proveedorParaActualizar = this.proveedorRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("Proveedor con ID: " + id + " no encontrado"));
        
        proveedorParaActualizar.setNombre(nuevoProveedor.getNombre());
        proveedorParaActualizar.setApellido(nuevoProveedor.getApellido());
        this.proveedorRepository.save(proveedorParaActualizar);
        
    }

    // ------------------- ELIMINAR PROVEEDOR ------------------- //
    // Metodo encargado de eliminar un proveedor de la BD
    public void eliminarProveedor(Long id){
        this.proveedorRepository.deleteById(id);
    }


}
