package com.maip202.comercio.categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "categoriaProducto", path = "categoria-producto")
public interface CategoriaProductoRepository extends JpaRepository<CategoriaProducto, Long> {



}
