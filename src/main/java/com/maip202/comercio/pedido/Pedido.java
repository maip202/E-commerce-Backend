package com.maip202.comercio.pedido;

import com.maip202.comercio.cliente.Cliente;
import com.maip202.comercio.direccion.Direccion;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "pedido_numero")
    private String pedidoNumero;

    @Column(name = "precio_total")
    private BigDecimal precioTotal;

    @Column(name = "cantidad_total")
    private int cantidadTotal;


    @Column(name = "fecha_creacion")
    @CreationTimestamp
    private Date fechaCreacion;

    @Column(name = "ultima_actualizacion")
    @UpdateTimestamp
    private Date ultimaActualizacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Set<ArticuloPedido> articuloPedido = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private Direccion direccion;


    public void add(ArticuloPedido articulo) {
        if (articulo != null) {
            if (articuloPedido == null) {
                articuloPedido = new HashSet<>();
            }
            articuloPedido.add(articulo);
            articulo.setPedido(this);

        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPedidoNumero() {
        return pedidoNumero;
    }

    public void setPedidoNumero(String pedidoNumero) {
        this.pedidoNumero = pedidoNumero;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(Date ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public Set<ArticuloPedido> getArticuloPedido() {
        return articuloPedido;
    }

    public void setArticuloPedido(Set<ArticuloPedido> articuloPedido) {
        this.articuloPedido = articuloPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
