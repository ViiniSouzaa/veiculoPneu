package com.project.veiculoPneu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.veiculoPneu.model.Veiculo;
import com.project.veiculoPneu.model.VeiculoPneu;
import com.project.veiculoPneu.model.dto.PneuDTO;
import com.project.veiculoPneu.model.dto.VeiculoDTO;
import com.project.veiculoPneu.model.dto.VeiculoPneuDTO;
import com.project.veiculoPneu.repository.JPA.VeiculoRepositoryJPA;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepositoryJPA veiculoRepository;
    
    @Autowired
    private PneuService pneuService;

    public List<Veiculo> listarTodosVeiculos() {
        return veiculoRepository.findAll();
    }

    public VeiculoPneuDTO obterVeiculoComPneus(Long id) {
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
        List<PneuDTO> veiculoPneus = pneuService.findPneuSituacaoByPlaca(veiculo.getPlaca());
        VeiculoPneuDTO veiculoDTO = new VeiculoPneuDTO(veiculo, veiculoPneus);
        return veiculoDTO;
    }
    
    public VeiculoPneuDTO obterVeiculoComPneus(String placa) {
        Veiculo veiculo = veiculoRepository.findByPlaca(placa).orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
        List<PneuDTO> veiculoPneus = pneuService.findPneuSituacaoByPlaca(placa);
        VeiculoPneuDTO veiculoDTO = new VeiculoPneuDTO(veiculo, veiculoPneus);
        return veiculoDTO;
    }

    public Veiculo salvarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }
}
