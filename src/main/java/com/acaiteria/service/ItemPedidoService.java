package com.acaiteria.service;

import com.acaiteria.models.ItemPedido;
import com.acaiteria.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> listarItensPedido() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedido criarItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public ItemPedido buscarItemPedido(Long id) {
        return itemPedidoRepository.findById(id).get();
    }

    public void deletarItemPedido(Long id) {
        itemPedidoRepository.deleteById(id);
    }
}
