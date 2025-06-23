package com.dev.backend.service;

import com.dev.backend.entity.Marca;
import com.dev.backend.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarcaService {

    @Autowired
    public MarcaRepository marcaRepository;

    public List<Marca> buscarMarca() {
        return marcaRepository.findAll();
    }

    public Marca inserir(Marca marca) {
        marca.setDataCriacao(new Date());
        Marca marcaNova = marcaRepository.saveAndFlush(marca);
        return marcaNova;
    }

    public Marca alterar(Marca marca) {
        marca.setDataAtualizacao(new Date());
        Marca marcaNova = marcaRepository.saveAndFlush(marca);
        return marcaNova;
    }

    public void excluir(Long id) {
        Marca marca = marcaRepository.findById(id).get();
        marcaRepository.delete(marca);
    }

}
