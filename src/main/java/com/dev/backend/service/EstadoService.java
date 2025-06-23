package com.dev.backend.service;

import com.dev.backend.entity.Estado;
import com.dev.backend.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EstadoService {

    @Autowired
    public EstadoRepository estadoRepository;

    public List<Estado> buscarEstado() {
        return estadoRepository.findAll();
    }

    public Estado inserir(Estado estado) {
        estado.setDataCriacao(new Date());
        Estado estadoNovo = estadoRepository.saveAndFlush(estado);
        return estadoNovo;
    }

    public Estado alterar(Estado estado) {
        estado.setDataAtualizacao(new Date());
        Estado estadoNovo = estadoRepository.saveAndFlush(estado);
        return estadoNovo;
    }

    public void excluir(Long id) {
        Estado estado = estadoRepository.findById(id).get();
        estadoRepository.delete(estado);
    }


}
