package com.acaiteria.service;

import com.acaiteria.models.FormaPagamento;
import com.acaiteria.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    public List<FormaPagamento> listarFormasPagamento() {
        return formaPagamentoRepository.findAll();
    }

    public FormaPagamento criarFormaPagamento(FormaPagamento formaPagamento) {
        return formaPagamentoRepository.save(formaPagamento);
    }

    public FormaPagamento buscarFormaPagamento(Long id) {
        return formaPagamentoRepository.findById(id).get();
    }

    public void deletarFormaPagamento(Long id) {
        formaPagamentoRepository.deleteById(id);
    }

    public FormaPagamento atualizarFormaPagamento(Long id, FormaPagamento formaPagamento) {
        FormaPagamento formaPagamentoAtual = formaPagamentoRepository.findById(id).get();

        formaPagamentoAtual.setName(formaPagamento.getName());
        formaPagamentoAtual.setDescription(formaPagamento.getDescription());

        return formaPagamentoRepository.save(formaPagamentoAtual);
    }



}
