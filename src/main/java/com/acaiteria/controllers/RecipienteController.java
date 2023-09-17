package com.acaiteria.controllers;

import com.acaiteria.models.Recipiente;
import com.acaiteria.service.RecipienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipiente")
public class RecipienteController {

    @Autowired
    private RecipienteService recipienteService;

    @GetMapping
    public ResponseEntity<List<Recipiente>> listarRecipiente() {
        return ResponseEntity.ok().body(recipienteService.listarRecipiente());
    }

    @PostMapping
    public ResponseEntity<Recipiente> criarRecipiente(@RequestBody Recipiente recipiente) {
        return ResponseEntity.ok().body(recipienteService.criarRecipiente(recipiente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipiente> buscarRecipiente(@PathVariable Long id) {
        return ResponseEntity.ok().body(recipienteService.buscarRecipiente(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRecipiente(@PathVariable Long id) {
        recipienteService.deletarRecipiente(id);
        return ResponseEntity.noContent().build();
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<Recipiente> atualizarRecipiente(@PathVariable Long id, @RequestBody Recipiente recipiente) {
        return ResponseEntity.ok().body(recipienteService.atualizarRecipiente(id, recipiente));
     */
}
