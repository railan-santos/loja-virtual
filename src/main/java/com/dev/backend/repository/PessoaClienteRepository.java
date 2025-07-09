package com.dev.backend.repository;

import com.dev.backend.entity.Permissao;
import com.dev.backend.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaClienteRepository extends JpaRepository<Pessoa, Long> {
    List<Permissao> findByNome(String nome);
}
