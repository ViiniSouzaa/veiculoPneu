package com.project.veiculoPneu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.veiculoPneu.model.Veiculo;
import com.project.veiculoPneu.model.VeiculoPneu;
import com.project.veiculoPneu.model.repository.VeiculoPneuRepository;
import com.project.veiculoPneu.model.repository.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;
    
    @Autowired
    private VeiculoPneuRepository veiculoPneuRepository;

    public List<Veiculo> listarTodosVeiculos() {
        return veiculoRepository.findAll();
    }

    public Veiculo obterVeiculoComPneus(Long id) {
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
        List<VeiculoPneu> veiculoPneus = veiculoPneuRepository.findByVeiculoId(id);
        // Associar pneus ao veículo
        veiculo.setVeiculoPneus(veiculoPneus);
        return veiculo;
    }

    public Veiculo salvarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }
}
