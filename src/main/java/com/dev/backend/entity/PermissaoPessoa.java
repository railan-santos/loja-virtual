package com.dev.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table (name = "permissaoPessoa")
@Data
public class PermissaoPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_pessoa")
    @JsonIgnore
    private Pessoa pessoa;

    @ManyToOne()
    @JoinColumn(name = "id_permissao")
    private Permissao permissao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
