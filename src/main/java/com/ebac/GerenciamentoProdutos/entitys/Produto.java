package com.ebac.GerenciamentoProdutos.entitys;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private BigDecimal preco;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

}