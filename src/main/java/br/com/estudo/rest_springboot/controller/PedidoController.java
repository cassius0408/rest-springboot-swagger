package br.com.estudo.rest_springboot.controller;

import br.com.estudo.rest_springboot.entity.Pedido;
import br.com.estudo.rest_springboot.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping(value = "/save")
    public ResponseEntity<Pedido> salvaProduto(@RequestBody Pedido produto) {

        return ResponseEntity.ok().body(pedidoService.save(produto));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> buscaProduto(@PathVariable Long id) {

        return ResponseEntity.ok().body(pedidoService.findById(id));
    }

    @GetMapping(value = "/busca-todos")
    public ResponseEntity<List<Pedido>> buscaTodosProdutos() {

        List<Pedido> pedidos = pedidoService.findAll();
        return ResponseEntity.ok().body(pedidos);
    }

}
