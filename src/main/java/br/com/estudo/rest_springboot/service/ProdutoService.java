package br.com.estudo.rest_springboot.service;

import br.com.estudo.rest_springboot.entity.Produto;
import br.com.estudo.rest_springboot.exception.ProductNullException;
import br.com.estudo.rest_springboot.exception.ProductPriceException;
import br.com.estudo.rest_springboot.handler.BusinessException;
import br.com.estudo.rest_springboot.handler.CampoObrigatorioException;
import br.com.estudo.rest_springboot.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto) throws Exception {

        if(produto.getNome() == null){
            throw new CampoObrigatorioException("nome");
        }
        if(produto.getPreco() == null || produto.getPreco() == 0){
            throw new CampoObrigatorioException("preço");
        }
        if(produto.getPreco() < 0){
            throw new BusinessException("Verifique o preço do produto");
        }
        return produtoRepository.save(produto);
    }

    public Produto update(Produto produto){
        return produtoRepository.save(produto);
    }

    public void deleteById(Long id){
        produtoRepository.deleteById(id);
    }

    public Produto findById(Long id){
        return produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

}
