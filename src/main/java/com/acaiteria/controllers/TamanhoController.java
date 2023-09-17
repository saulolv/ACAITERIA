package com.acaiteria.controllers;

import com.acaiteria.models.Tamanho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.acaiteria.service.TamanhoService;

import java.util.List;

@RestController
@RequestMapping("/api/tamanho")
public class TamanhoController {

    @Autowired
    private TamanhoService tamanhoService;

    @GetMapping
    public ResponseEntity<List<Tamanho>> listarTamanho() {
        return ResponseEntity.ok().body(tamanhoService.listarTamanhos());
    }

    @PostMapping
    public ResponseEntity<Tamanho> criarTamanho(@RequestBody Tamanho tamanho) {
        return ResponseEntity.ok().body(tamanhoService.criarTamanho(tamanho));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tamanho> buscarTamanho(@PathVariable Long id) {
        return ResponseEntity.ok().body(tamanhoService.buscarTamanho(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTamanho(@PathVariable Long id) {
        tamanhoService.deletarTamanho(id);
        return ResponseEntity.noContent().build();
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<Tamanho> atualizarTamanho(@PathVariable Long id, @RequestBody Tamanho tamanho) {
        return ResponseEntity.ok().body(tamanhoService.atualizarTamanho(id, tamanho));
 */
}
