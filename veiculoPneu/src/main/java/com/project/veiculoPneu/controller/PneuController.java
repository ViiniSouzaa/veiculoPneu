package com.project.veiculoPneu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.veiculoPneu.model.Pneu;
import com.project.veiculoPneu.service.PneuService;

@RestController
@RequestMapping("/api/pneus")
public class PneuController {

    @Autowired
    private PneuService pneuService;

    // Endpoint para listar todos os pneus
    @GetMapping
    public List<Pneu> listarPneus() {
        return pneuService.listarTodosPneus();
    }

    // Endpoint para obter um pneu específico
    @GetMapping("/{id}")
    public Pneu obterPneu(@PathVariable Long id) {
        return pneuService.obterPneu(id);
    }

    // Endpoint para criar um novo pneu
    @PostMapping
    public Pneu criarPneu(@RequestBody Pneu pneu) {
        if (pneu.getStatus() == null) {
            pneu.setStatus("INATIVO");
        }
        return pneuService.salvarPneu(pneu);
    }
}