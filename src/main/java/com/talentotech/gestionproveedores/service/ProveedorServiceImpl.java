package com.talentotech.gestionproveedores.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talentotech.gestionproveedores.enums.TipoProveedor;
import com.talentotech.gestionproveedores.enums.TipoRubro;
import com.talentotech.gestionproveedores.exception.ProveedorNoEncontradoException;
import com.talentotech.gestionproveedores.model.Proveedor;
import com.talentotech.gestionproveedores.repository.ProveedorRepository;

// Marco la clase como servicio de Spring
@Service
public class ProveedorServiceImpl implements ProveedorService{

    private final ProveedorRepository proveedorRepository;

    public ProveedorServiceImpl(ProveedorRepository proveedorRepository){
        this.proveedorRepository = proveedorRepository;
    }

    // ----------------------- OBTENER PROVEEDORES ----------------------- //
    // Metodo encargado de devolver todos los proveedores de la BD
    @Override
    public List<Proveedor> obtenerProveedores(){
        return this.proveedorRepository.findAll();
    }

    // ----------------------------- OBTENER PROVEEDORES POR TIPO RUBRO ----------------------------- //
    // Metodo encargado de devolver todos los proveedores de un tipo de rubro especifico de la DB
    @Override
    public List<Proveedor> obtenerProveedoresPorTipoRubro(TipoRubro tipoRubro){
        return this.proveedorRepository.findByTipoRubro(tipoRubro);
    }

    // ----------------------------- OBTENER PROVEEDORES POR TIPO RUBRO ----------------------------- //
    // Metodo encargado de devolver todos los proveedores de un tipo de rubro especifico de la DB
    @Override
    public List<Proveedor> obtenerProveedoresPorTipoProveedor(TipoProveedor tipoProveedor){
        return this.proveedorRepository.findByTipoProveedor(tipoProveedor);
    }

    // ----------------- OBTENER PROVEEDOR POR ID ----------------- //
    // Metodo encargado de devolver un proveedor por ID de la BD
    @Override
    public Proveedor obtenerProveedorPorId(Long id){
        return this.proveedorRepository.findById(id)
            .orElseThrow(() -> new ProveedorNoEncontradoException("Proveedor con ID: " + id + " no encontrado"));
    }

    // ---------------------- CREAR PROVEEDOR ---------------------- //
    // Metodo encargado de crear un proveedor en la BD
    @Override
    public Proveedor crearProveedor(Proveedor p){
        return this.proveedorRepository.save(p);
    }

    // ------------- ACTUALIZAR PROVEEDOR ------------- //
    // Metodo encargado de actualizar un proveedor de la BD
    @Override
    public Proveedor actualizarProveedor(Proveedor nuevoProveedor, Long id){
        Proveedor p = this.proveedorRepository.findById(id)
            .orElseThrow(() -> new ProveedorNoEncontradoException("Proveedor con ID: " + id + " no encontrado"));

        p.setNombre(nuevoProveedor.getNombre());
        p.setApellido(nuevoProveedor.getApellido());
        return this.proveedorRepository.save(p);
    }

    // ------------------- ELIMINAR PROVEEDOR ------------------- //
    // Metodo encargado de eliminar un proveedor de la BD
    @Override
    public void eliminarProveedor(Long id){
        Proveedor p = this.proveedorRepository.findById(id)
            .orElseThrow(() -> new ProveedorNoEncontradoException("Proveedor con ID: " + id + " no encontrado"));
        this.proveedorRepository.deleteById(p.getId());
    }

}
