package com.dev.backend.controller;

import com.dev.backend.entity.Categoria;
import com.dev.backend.repository.CategoriaRepository;
import com.dev.backend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/")
    public List<Categoria> listarCategorias() {
        return categoriaService.listarCategoria();
    }

    @PostMapping("/")
    public Categoria inserir(@RequestBody Categoria categoria) {
        return categoriaService.inserir(categoria);
    }

    @PutMapping("/")
    public Categoria alterar(@RequestBody Categoria categoria) {
        return categoriaService.alterar(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        categoriaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
