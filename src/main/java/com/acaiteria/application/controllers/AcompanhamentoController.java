package com.acaiteria.application.controllers;

import com.acaiteria.application.service.AcompanhamentoService;
import com.acaiteria.application.models.Acompanhamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acompanhamentos")
public class AcompanhamentoController {
    @Autowired
    private AcompanhamentoService acompanhamentoService;

    @GetMapping
    public ResponseEntity<List<Acompanhamento>> listarAcompanhamentos() {
        return ResponseEntity.ok().body(acompanhamentoService.listarAcompanhamentos());
    }

    @PostMapping
    public ResponseEntity<Acompanhamento> criarAcompanhamento(@RequestBody Acompanhamento acompanhamento) {
        return ResponseEntity.ok().body(acompanhamentoService.criarAcompanhamento(acompanhamento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acompanhamento> buscarAcompanhamento(@PathVariable Long id) {
        if (acompanhamentoService.buscarAcompanhamento(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(acompanhamentoService.buscarAcompanhamento(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAcompanhamento(@PathVariable Long id) {
        acompanhamentoService.deletarAcompanhamento(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Acompanhamento> atualizarAcompanhamento(@RequestBody Acompanhamento acompanhamento, @PathVariable Long id) {
        if (acompanhamentoService.buscarAcompanhamento(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(acompanhamentoService.atualizarAcompanhamento(id, acompanhamento));
    }
}
