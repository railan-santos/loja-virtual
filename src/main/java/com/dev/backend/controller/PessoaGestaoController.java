package com.dev.backend.controller;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.service.PessoaGerenciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa-gerenciamento/")
public class PessoaGestaoController {

    @Autowired
    private PessoaGerenciamentoService pessoaGerenciamentoService;

    @PostMapping("codigo-senha")
    public String recuperarCodigo(@RequestBody Pessoa pessoa) {
        return pessoaGerenciamentoService.solicitarCodigo(pessoa.getEmail());
    }

    @PutMapping("alterar-senha")
    public String alterarSenha(@RequestBody Pessoa pessoa) {
        return pessoaGerenciamentoService.alterarSenha(pessoa);
    }

}
