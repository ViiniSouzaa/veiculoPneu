package com.project.veiculoPneu.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.veiculoPneu.model.VeiculoPneu;
import com.project.veiculoPneu.model.dto.VinculoPneuVeiculoDTO;
import com.project.veiculoPneu.repository.JPA.VeiculoPneuRepositoryJPA;

public class VeiculoPneuService {

    @Autowired
    private VeiculoPneuRepositoryJPA veiculoPneuRepositoryJPA;

    public Boolean vincularPneuVeiculo(VinculoPneuVeiculoDTO pneuVeiculo) {
        return veiculoPneuRepositoryJPA.save(VeiculoPneu.from(pneuVeiculo)) != null ? Boolean.TRUE :Boolean.FALSE;
    }

    public void desvincularPneuVeiculo(VinculoPneuVeiculoDTO pneuVeiculo) {
        veiculoPneuRepositoryJPA.delete(VeiculoPneu.from(pneuVeiculo));
    }

}
