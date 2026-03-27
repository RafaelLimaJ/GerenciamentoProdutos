package com.ebac.GerenciamentoProdutos.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

}