package com.dev.backend.controller;

import com.dev.backend.entity.Imagens;
import com.dev.backend.service.ImagensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/imagens/")
public class ImagensController {

    @Autowired
    private ImagensService imagensService;

    @GetMapping
    public List<Imagens> findAll() {
        return imagensService.listarImagens();
    }

    @PostMapping
    public Imagens inserir(@RequestParam("id_produto") Long id_produto, @RequestParam("file") MultipartFile file) {
        return imagensService.inserir(id_produto, file);
    }

    @PutMapping
    public Imagens alterarImagem(@RequestBody Imagens imagens) {
        return imagensService.alterar(imagens);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluirImagem(@PathVariable("id") Long id) {
        imagensService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
