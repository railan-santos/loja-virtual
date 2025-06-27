package com.dev.backend.controller;

import com.dev.backend.entity.Produto;
import com.dev.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    public List<Produto> listarProduto(){
        return produtoService.listarProduto();
    }

    @PostMapping("/")
    public Produto inserirProduto(@RequestBody Produto produto){
        return produtoService.inserir(produto);
    }

    @PutMapping("/")
    public Produto alterarProduto(@RequestBody Produto produto){
        return produtoService.alterar(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable("id") Long id) {
        produtoService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
