package com.ebac.GerenciamentoProdutos.services;

import com.ebac.GerenciamentoProdutos.JPArepository.ProdutoRepository;
import com.ebac.GerenciamentoProdutos.entitys.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Transactional
    public List<Produto> saveAll(List<Produto> produtos) {
        return produtoRepository.saveAll(produtos);
    }

    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    @Transactional
    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    public Page<Produto> buscarProdutosPaginados(String nomeBusca, int pagina, int tamanho, String direcaoOrdem) {
        Sort.Direction direcao = Sort.Direction.fromString(direcaoOrdem);

        Pageable pageable = PageRequest.of(pagina, tamanho, Sort.by(direcao, "nome"));

        return produtoRepository.findByNomeContainingIgnoreCase(nomeBusca, pageable);
    }
}