package com.acaiteria.controllers;


import com.acaiteria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.acaiteria.models.Pedido;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        return ResponseEntity.ok().body(pedidoService.listarPedidos());
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        return ResponseEntity.ok().body(pedidoService.criarPedido(pedido));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedidoId(@PathVariable Long id) {
        if (pedidoService.buscarPedidoId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pedidoService.buscarPedidoId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPedido(@PathVariable Long id) {
        pedidoService.excluirPedido(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@RequestBody Pedido pedido, @PathVariable Long id) {
        if (pedidoService.buscarPedidoId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pedidoService.atualizarPedido(pedido, id));
    }

}
