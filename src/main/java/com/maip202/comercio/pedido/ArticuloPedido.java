package com.maip202.comercio.pedido;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "articulo_pedido")
public class ArticuloPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "url")
    private String url;

    @Column(name = "unidad_precio")
    private BigDecimal unidadPrecio;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "producto_id")
    private Long productoId;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getUnidadPrecio() {
        return unidadPrecio;
    }

    public void setUnidadPrecio(BigDecimal unidadPrecio) {
        this.unidadPrecio = unidadPrecio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
