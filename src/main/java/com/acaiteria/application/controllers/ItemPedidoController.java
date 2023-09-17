package com.acaiteria.application.controllers;

import com.acaiteria.application.service.ItemPedidoService;
import com.acaiteria.application.models.ItemPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itempedidos")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public ResponseEntity<List<ItemPedido>> listarItensPedidos() {
        return ResponseEntity.ok().body(itemPedidoService.listarItensPedidos());
    }

    @PostMapping
    public ResponseEntity<ItemPedido> criarItemPedido(@RequestBody ItemPedido itemPedido) {
        return ResponseEntity.ok().body(itemPedidoService.criarItemPedido(itemPedido));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> buscarItemPedido(@PathVariable Long id) {
        return ResponseEntity.ok().body(itemPedidoService.buscarItemPedido(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItemPedido(@PathVariable Long id) {
        itemPedidoService.deletarItemPedido(id);
        return ResponseEntity.noContent().build();
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<ItemPedido> atualizarItemPedido(@PathVariable Long id, @RequestBody ItemPedido itemPedido) {
        return ResponseEntity.ok().body(itemPedidoService.atualizarItemPedido(id, itemPedido));
    }
    */




}
