package com.dev.backend.service;

import com.dev.backend.dto.PessoaClienteRequestDTO;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PessoaClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PessoaClienteService {

    @Autowired
    private PessoaClienteRepository pessoaClienteRepository;

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    @Autowired
    private EmailService emailService;

    public Pessoa inserir(PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNova = pessoaClienteRepository.saveAndFlush(pessoa);
        permissaoPessoaService.vincularPessoaPermissaoCliente(pessoaNova);
        emailService.enviarTextoEmail(pessoaNova.getEmail(), "Cadastro na loja QUERO EMPREGO", "Registro realizado com sucesso. Em breve recerá a senha de acesso por email");
        return pessoaNova;
    }

}
