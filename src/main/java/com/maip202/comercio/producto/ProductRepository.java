package com.maip202.comercio.producto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "producto", path = "productos")
public interface ProductRepository extends JpaRepository<Producto, Long> {

    Page<Producto> findByCategoriaId(@Param("id") Long id, Pageable pageable);

    @Query("SELECT p FROM Producto p WHERE p.nombre LIKE %:nombre%")
    Page<Producto> findByNombre(@Param("nombre") String nombre, Pageable pageable);



}
