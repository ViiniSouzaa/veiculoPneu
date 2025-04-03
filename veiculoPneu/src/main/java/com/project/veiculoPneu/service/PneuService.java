package com.project.veiculoPneu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.veiculoPneu.model.Pneu;
import com.project.veiculoPneu.model.repository.PneuRepository;

@Service
public class PneuService {

    @Autowired
    private PneuRepository pneuRepository;

    // Método para listar todos os pneus
    public List<Pneu> listarTodosPneus() {
        return pneuRepository.findAll();
    }

    // Método para buscar um pneu específico
    public Pneu obterPneu(Long id) {
        return pneuRepository.findById(id).orElseThrow(() -> new RuntimeException("Pneu não encontrado"));
    }

    // Método para salvar um novo pneu
    public Pneu salvarPneu(Pneu pneu) {
        return pneuRepository.save(pneu);
    }
}