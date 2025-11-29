package com.talentotech.gestionproveedores.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talentotech.gestionproveedores.model.Proveedor;

// Marco esta clase como la que se encarga de acceder a los datos de la BD (Repository)
@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{

}
