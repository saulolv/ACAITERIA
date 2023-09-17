package com.acaiteria.service;

import com.acaiteria.models.Produto;
import com.acaiteria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto buscarProdutoId(Long id) {
        return produtoRepository.findById(id).get();
    }

    public boolean excluirProduto(Long id) {
        produtoRepository.deleteById(id);

        return false;
    }

    public Produto atualizarProduto(Long id, Produto produto) {
        Produto produtoExistente = produtoRepository.findById(id).get();
        produtoExistente.setName(produto.getName());
        produtoExistente.setPrice(produto.getPrice());
        produtoExistente.setDescription(produto.getDescription());

        return produtoRepository.save(produtoExistente);
    }
}
