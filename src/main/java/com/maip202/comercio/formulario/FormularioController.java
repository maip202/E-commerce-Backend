package com.maip202.comercio.formulario;

import dto.Compra;
import dto.CompraResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/formulario")
@CrossOrigin("http://localhost:4200")
public class FormularioController {

    private FormularioService formularioService;

    @Autowired
    public FormularioController(FormularioService formularioService) {
        this.formularioService = formularioService;
    }

    @PostMapping("/compra")
    public CompraResponse lugarPedido(@RequestBody Compra compra) {
        CompraResponse compraResponse = formularioService.lugarOrder(compra);

        return compraResponse;
    }
}
