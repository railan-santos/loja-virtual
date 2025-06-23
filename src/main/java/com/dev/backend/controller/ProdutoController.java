package com.dev.backend.controller;

import com.dev.backend.entity.Produto;
import com.dev.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    public List<Produto> listar(){
        return produtoService.listarProduto();
    }



}
