package com.dev.backend.service;

import com.dev.backend.controller.ProdutoController;
import com.dev.backend.entity.Permissao;
import com.dev.backend.entity.Produto;
import com.dev.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarProduto() {
        return produtoRepository.findAll();
    }

    public Produto inserir(@RequestBody Produto produto) {
        produto.setDataCriacao(new Date());
        Produto produtoNovo = produtoRepository.saveAndFlush(produto);
        return produtoNovo;
    }

    public Produto alterar(Produto produto) {
        produto.setDataAtualizacao(new Date());
        Produto permissaoNova = produtoRepository.saveAndFlush(produto);
        return permissaoNova;
    }

    public void excluir(Long id) {
        Produto produto = produtoRepository.findById(id).get();
        produtoRepository.delete(produto);
    }

}
