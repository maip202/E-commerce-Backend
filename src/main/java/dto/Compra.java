package dto;

import com.maip202.comercio.pedido.ArticuloPedido;
import com.maip202.comercio.cliente.Cliente;
import com.maip202.comercio.direccion.Direccion;
import com.maip202.comercio.pedido.Pedido;
import lombok.Data;

import java.util.Set;

@Data
public class Compra {

    private Cliente cliente;
    private Direccion direccion;
    private Direccion direcion_envio;
    private Pedido pedido;
    private Set<ArticuloPedido> articuloPedido;

}
