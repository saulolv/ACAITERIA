package com.acaiteria.application.service;

import com.acaiteria.application.models.Recipiente;
import com.acaiteria.application.repository.RecipienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipienteService {
    @Autowired
    private RecipienteRepository recipienteRepository;

    public List<Recipiente> listarRecipiente() {
        return recipienteRepository.findAll();
    }

    public Recipiente criarRecipiente(Recipiente recipiente) {
        return recipienteRepository.save(recipiente);
    }

    public Recipiente buscarRecipiente(Long id) {
        return recipienteRepository.findById(id).get();
    }

    public void deletarRecipiente(Long id) {
        recipienteRepository.deleteById(id);
    }


}
