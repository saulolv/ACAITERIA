package com.acaiteria.service;

import com.acaiteria.models.Tamanho;
import com.acaiteria.repository.TamanhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TamanhoService {
    @Autowired
    private TamanhoRepository tamanhoRepository;

    public List<Tamanho> listarTamanhos() {
        return tamanhoRepository.findAll();
    }

    public Tamanho criarTamanho(Tamanho tamanho) {
        return tamanhoRepository.save(tamanho);
    }

    public Tamanho buscarTamanho(Long id) {
        return tamanhoRepository.findById(id).get();
    }

    public void deletarTamanho(Long id) {
        tamanhoRepository.deleteById(id);
    }
}
