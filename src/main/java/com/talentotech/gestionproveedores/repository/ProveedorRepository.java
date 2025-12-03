package com.talentotech.gestionproveedores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talentotech.gestionproveedores.enums.TipoProveedor;
import com.talentotech.gestionproveedores.enums.TipoRubro;
import com.talentotech.gestionproveedores.model.Proveedor;

// Marco esta clase como la que se encarga de acceder a los datos de la BD (Repository)
@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{

    // Metodos custom para buscar proveedores segun criterios
    List<Proveedor> findByTipoRubro(TipoRubro tipoRubro);
    List<Proveedor> findByTipoProveedor(TipoProveedor tipoProveedor);

}
