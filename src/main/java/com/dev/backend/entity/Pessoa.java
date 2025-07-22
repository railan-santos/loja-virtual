package com.dev.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

    private String email;

    private String senha;

    private String codigoRecuperacaoSenha;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEnvioCodigo;

    private String endereco;

    private String cep;

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    @Setter(value = AccessLevel.NONE)
    private List<PermissaoPessoa> permissaoPessoa;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    public void setPermissaoPessoa(List<PermissaoPessoa> pp) {
        for(PermissaoPessoa p : pp){
            p.setPessoa(this);
        }
        this.permissaoPessoa = pp;
    }
}
