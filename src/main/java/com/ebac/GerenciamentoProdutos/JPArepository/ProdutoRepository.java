package com.ebac.GerenciamentoProdutos.JPArepository;

import com.ebac.GerenciamentoProdutos.entitys.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.nome = :nome")
    List<Produto> findByNomePersonalizado(@Param("nome") String nome);
    Page<Produto> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}