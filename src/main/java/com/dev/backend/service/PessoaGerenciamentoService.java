package com.dev.backend.service;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PessoaGerenciamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EmailService emailService;

    public String solicitarCodigo(String email) {
        Pessoa pessoa = pessoaRepository.findByEmail(email);
        pessoa.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(pessoa.getId()));
        pessoa.setDataEnvioCodigo(new Date());
        pessoaRepository.saveAndFlush(pessoa);
        emailService.enviarTextoEmail(pessoa.getEmail(), "Código de recuperação de senha", "Seu código de Recuperação de Senha: " + pessoa.getCodigoRecuperacaoSenha());

        return "Código Enviado";
    }

    public String alterarSenha(Pessoa pessoa) {
        Pessoa pessoaBanco = pessoaRepository.findByEmailAndCodigoRecuperacaoSenha(pessoa.getEmail(), pessoa.getCodigoRecuperacaoSenha());
        Date diferenca = new Date(new Date().getTime() - pessoaBanco.getDataEnvioCodigo().getTime());

        if (pessoaBanco != null) {

            if (diferenca.getTime() / 1000 < 900) {
                pessoaBanco.setSenha(pessoa.getSenha());
                pessoaBanco.setCodigoRecuperacaoSenha(null);
                pessoaRepository.saveAndFlush(pessoaBanco);
                return "Senha alterada com sucesso";
            } else {
                return "Tempo expirado. Solicite um novo código";
            }
        } else {
            return "Email ou código não encontrado!";
        }
    }

    private String getCodigoRecuperacaoSenha(Long id) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(new Date()) + id;
    }

}
