package com.acaiteria.service;

import com.acaiteria.models.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.acaiteria.repository.PedidoRepository;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido criarPedido(Pedido pedido) {
        double totalprice = calcularPrecoTotal(pedido);
        return pedidoRepository.save(pedido);
    }

    public Pedido buscarPedidoId(Long id) {
        return pedidoRepository.findById(id).get();
    }

    public void excluirPedido(Long id) {
        pedidoRepository.deleteById(id);
    }

    public Pedido atualizarPedido(Pedido pedido, Long id) {
        Pedido pedidoExistente = pedidoRepository.findById(id).get();
        pedidoExistente.setClient(pedido.getClient());
        pedidoExistente.setStatus(pedido.getStatus());
        pedidoExistente.setTotalPrice(pedido.getTotalPrice());
        pedidoExistente.setItems(pedido.getItems());
        return pedidoRepository.save(pedidoExistente);
    }

    /*
    public List<Pedido> listarPedidosPorCliente(String client) {
        return pedidoRepository.findByClient(client);
    }
    */

    public double calcularPrecoTotal(Pedido pedido) {
        double total = 0;
        for (int i = 0; i < pedido.getItems().size(); i++) {
            total += pedido.getItems().get(i).getProduto().getPrice();
        }
        return total;
    }

}
