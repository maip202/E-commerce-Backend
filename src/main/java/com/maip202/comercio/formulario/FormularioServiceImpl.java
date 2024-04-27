package com.maip202.comercio.formulario;

import com.maip202.comercio.pedido.ArticuloPedido;
import com.maip202.comercio.cliente.Cliente;
import com.maip202.comercio.cliente.ClienteRepository;
import com.maip202.comercio.pedido.Pedido;
import dto.Compra;
import dto.CompraResponse;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class FormularioServiceImpl implements FormularioService {

    private ClienteRepository clienteRepository;

    public FormularioServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    @Override
    @Transactional
    public CompraResponse lugarOrder(Compra compra) {

        Pedido pedido = compra.getPedido();

        String numeroPedido = generarNumeroPedido();
        pedido.setPedidoNumero(numeroPedido);

        Set<ArticuloPedido> articuloPedido = compra.getArticuloPedido();
        articuloPedido.forEach(articulo -> pedido.add(articulo));

        pedido.setDireccion(compra.getDireccion());


        Cliente cliente = compra.getCliente();
        cliente.add(pedido);

        clienteRepository.save(cliente);


        return new CompraResponse(numeroPedido);
    }

    private String generarNumeroPedido() {

        return UUID.randomUUID().toString();
    }
}
