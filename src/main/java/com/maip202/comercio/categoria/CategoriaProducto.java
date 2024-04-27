package com.maip202.comercio.categoria;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.maip202.comercio.producto.Producto;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="producto_categoria")
public class CategoriaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre_categoria")
    private String nombreCategoria;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    private Set<Producto> productos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
}
