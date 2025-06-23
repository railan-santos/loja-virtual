package com.dev.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "produto")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricaoCurta;

    private String descricaoDetalhada;

    private Double valorCusto;

    private Double valorVenda;

    @ManyToOne()
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @ManyToOne()
    @JoinColumn(name = "id_marca")
    private Marca marca;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;



}
