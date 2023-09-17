package com.acaiteria.application.service;

import com.acaiteria.application.models.Acompanhamento;
import com.acaiteria.application.repository.AcompanhamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcompanhamentoService {

    @Autowired
    private AcompanhamentoRepository acompanhamentoRepository;

    public List<Acompanhamento> listarAcompanhamentos() {
        return acompanhamentoRepository.findAll();
    }

    public Acompanhamento criarAcompanhamento(Acompanhamento acompanhamento) {
        return acompanhamentoRepository.save(acompanhamento);
    }

    public Acompanhamento buscarAcompanhamento(Long id) {
        return acompanhamentoRepository.findById(id).get();
    }

    public void deletarAcompanhamento(Long id) {
        acompanhamentoRepository.deleteById(id);
    }

    public Acompanhamento atualizarAcompanhamento(Long id, Acompanhamento acompanhamento) {
        Acompanhamento acompanhamentoAtual = acompanhamentoRepository.findById(id).get();

        acompanhamentoAtual.setName(acompanhamento.getName());
        acompanhamentoAtual.setPrice(acompanhamento.getPrice());

        return acompanhamentoRepository.save(acompanhamentoAtual);
    }


}
