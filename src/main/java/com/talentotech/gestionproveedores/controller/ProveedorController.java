package com.talentotech.gestionproveedores.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talentotech.gestionproveedores.enums.TipoProveedor;
import com.talentotech.gestionproveedores.enums.TipoRubro;
import com.talentotech.gestionproveedores.model.Proveedor;
import com.talentotech.gestionproveedores.service.ProveedorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService){
        this.proveedorService = proveedorService;
    }

    // --------------- ENDPOINT GET: OBTENER TODOS LOS PROVEEDORES --------------- //
    @GetMapping()
    public ResponseEntity<List<Proveedor>> obtenerProveedores(){
        return ResponseEntity.ok(this.proveedorService.obtenerProveedores());
    }

    // --------------- ENDPOINT GET: OBTENER TODOS LOS PROVEEDORES DE UN TIPO DE RUBRO ESPECIFICO --------------- //
    @GetMapping("/filtrar/tipo-rubro")
    public ResponseEntity<List<Proveedor>> obtenerProveedoresPorTipoRubro(@RequestParam TipoRubro tipoRubro){
        return ResponseEntity.ok(this.proveedorService.obtenerProveedoresPorTipoRubro(tipoRubro));
    }

    // --------------- ENDPOINT GET: OBTENER TODOS LOS PROVEEDORES DE UN TIPO DE PROVEEDOR ESPECIFICO --------------- //
    @GetMapping("/filtrar/tipo-proveedor")
    public ResponseEntity<List<Proveedor>> obtenerProveedoresPorTipoProveedor(@RequestParam TipoProveedor tipoProveedor){
        return ResponseEntity.ok(this.proveedorService.obtenerProveedoresPorTipoProveedor(tipoProveedor));
    }

    // --------------- ENDPOINT GET: OBTENER UN PROVEEDOR POR ID --------------- //
    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtenerProveedor(@PathVariable Long id){
        Proveedor p = this.proveedorService.obtenerProveedorPorId(id);
        return ResponseEntity.ok(p);
    }

    // --------------- ENDPOINT POST: CREAR UN NUEVO PROVEEDOR --------------- //
    @PostMapping()
    public ResponseEntity<Proveedor> agregarProveedor(@Valid @RequestBody Proveedor proveedor){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.proveedorService.crearProveedor(proveedor));
    }

    // --------------- ENDPOINT PUT: ACTUALIZAR UN PROVEEDOR --------------- //
    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Long id, @Valid @RequestBody Proveedor nuevoProveedor){
        Proveedor proveedorActualizado = this.proveedorService.actualizarProveedor(nuevoProveedor, id);
        return ResponseEntity.ok(proveedorActualizado);
    }

    // --------------- ENDPOINT DELETE: ELIMINAR UN PROVEEDOR --------------- //
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id){
        this.proveedorService.eliminarProveedor(id);
        return ResponseEntity.noContent().build();
    }

}
