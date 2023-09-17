package com.acaiteria.application.controllers;

import com.acaiteria.application.models.Produto;
import com.acaiteria.application.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();

        return ResponseEntity.ok(produtos).getBody();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoId(@PathVariable Long id) {
        Produto produto = produtoService.buscarProdutoId(id);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        Produto produtoCriado = produtoService.criarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCriado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        if (!produtoService.excluirProduto(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        Produto produtoAtualizado = produtoService.atualizarProduto(id, produto);
        if (produtoAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtoAtualizado);
    }

    /*
    @GetMapping("nome/{nome}")
    public ResponseEntity<Produto> buscarProdutoNome(@PathVariable String nome) {
        Produto produto = produtoService.listarProdutos(nome);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }
     */
}
