package com.dev.backend.service;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class PessoaService {

    @Autowired
    public PessoaRepository pessoaRepository;

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa cadastrarPessoa(Pessoa pessoa){
        return pessoaRepository.saveAndFlush(pessoa);
    }

    public Pessoa alterar(Pessoa pessoa){
        pessoa.setDataAtualizacao(new Date());
        Pessoa pessoaNova = pessoaRepository.saveAndFlush(pessoa);
        return pessoaNova;
    }

    public void excluir (Long id){
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoaRepository.delete(pessoa);
    }

}
