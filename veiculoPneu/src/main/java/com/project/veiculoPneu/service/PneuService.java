package com.project.veiculoPneu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.veiculoPneu.model.Pneu;
import com.project.veiculoPneu.model.dto.PneuDTO;
import com.project.veiculoPneu.repository.PneuRepository;
import com.project.veiculoPneu.repository.JPA.PneuRepositoryJPA;

@Service
public class PneuService {

    @Autowired
    private PneuRepositoryJPA pneuRepositoryJPA;
    
    @Autowired
    private PneuRepository pneuRepository;

    // Método para listar todos os pneus
    public List<PneuDTO> listarTodosPneus() {
        List<PneuDTO> pneusReturn = new ArrayList<PneuDTO>();
        
        for(Pneu pneu : pneuRepositoryJPA.findAll()){
            pneusReturn.add(PneuDTO.from(pneu));
        }

        return pneusReturn;
    }

    // Método para buscar um pneu específico
    public PneuDTO obterPneu(Long id) {
        return PneuDTO.from(pneuRepositoryJPA.findById(id)
                                .orElseThrow(() -> 
                                new RuntimeException("Pneu não encontrado")
                            ));
    }
    
    // Método para buscar um pneu específico
    public PneuDTO findByNumeroDeFogo(Long numeroDeFogo) {
        return PneuDTO.from(pneuRepositoryJPA.findByNumeroDeFogo(numeroDeFogo)
                                .orElseThrow(() -> 
                                new RuntimeException("Pneu não encontrado")
                                ));
    }
    
    //Método para buscar pneus e situacao por placa de veiculo
    public List<PneuDTO> findPneuSituacaoByPlaca(String placa){
    	return pneuRepository.findPneuSituacaoByPlaca(placa);
    }

    // Método para salvar um novo pneu
    public Pneu salvarPneu(PneuDTO pneu) {
        return pneuRepositoryJPA.save(Pneu.from(pneu));
    }
}