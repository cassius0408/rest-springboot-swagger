package br.com.estudo.rest_springboot.controller;

import br.com.estudo.rest_springboot.entity.Produto;
import br.com.estudo.rest_springboot.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping(value = "/save")
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) throws Exception {

        return ResponseEntity.ok().body(produtoService.save(produto));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduto(@PathVariable Long id){
        produtoService.deleteById(id);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Produto> alterarProduto(@RequestBody Produto produto){

        return ResponseEntity.ok().body(produtoService.update(produto));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> buscaProduto(@PathVariable Long id){

        return ResponseEntity.ok().body(produtoService.findById(id));
    }

    @GetMapping(value = "/busca-produtos")
    public ResponseEntity<List<Produto>> buscaTodosProdutos(){

        return ResponseEntity.ok().body(produtoService.findAll());
    }

}
