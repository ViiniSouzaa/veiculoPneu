package com.project.veiculoPneu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.veiculoPneu.model.dto.VinculoPneuVeiculoDTO;
import com.project.veiculoPneu.repository.JPA.VeiculoPneuRepositoryJPA;

@Service
public class VeiculoPneuService {

    @Autowired
    private VeiculoPneuRepositoryJPA veiculoPneuRepositoryJPA;

    public void vincularPneuVeiculo(VinculoPneuVeiculoDTO pneuVeiculo) {
        veiculoPneuRepositoryJPA.salvarVeiculoPneu(pneuVeiculo.getPlacaVeiculo(), pneuVeiculo.getNumeroDeFogo(), pneuVeiculo.getPosicao());
    }

    public void desvincularPneuVeiculo(Long numeroDeFogo) {
        veiculoPneuRepositoryJPA.deleteByNumeroDeFogo(numeroDeFogo);
    }

}
