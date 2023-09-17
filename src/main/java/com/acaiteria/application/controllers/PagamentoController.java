package com.acaiteria.application.controllers;

import com.acaiteria.application.models.FormaPagamento;
import com.acaiteria.application.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public ResponseEntity<List<FormaPagamento>> listarPagamentos() {
        return ResponseEntity.ok().body(pagamentoService.listarFormasPagamento());
    }

    @PostMapping
    public ResponseEntity<FormaPagamento> criarPagamento(@RequestBody FormaPagamento pagamento) {
        return ResponseEntity.ok().body(pagamentoService.criarFormaPagamento(pagamento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamento> buscarPagamento(@PathVariable Long id) {
        return ResponseEntity.ok().body(pagamentoService.buscarFormaPagamento(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPagamento(@PathVariable Long id) {
        pagamentoService.deletarFormaPagamento(id);
        return ResponseEntity.noContent().build();
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<FormaPagamento> atualizarPagamento(@PathVariable Long id, @RequestBody FormaPagamento pagamento) {
        return ResponseEntity.ok().body(pagamentoService.atualizarFormaPagamento(id, pagamento));
     */

}
