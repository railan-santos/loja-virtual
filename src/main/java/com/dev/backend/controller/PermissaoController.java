package com.dev.backend.controller;

import com.dev.backend.entity.Permissao;
import com.dev.backend.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissao/")
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping()
    public List<Permissao> listar() {
        return permissaoService.listarPermissao();
    }

    @PostMapping()
    public Permissao inserir(@RequestBody Permissao permissao) {
        return permissaoService.inserir(permissao);
    }

    @PutMapping()
    public Permissao alterar(@RequestBody Permissao permissao) {
        return permissaoService.alterar(permissao);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        permissaoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
