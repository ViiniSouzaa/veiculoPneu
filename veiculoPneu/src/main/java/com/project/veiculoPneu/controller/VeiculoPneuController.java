package com.project.veiculoPneu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.veiculoPneu.model.dto.VinculoPneuVeiculoDTO;
import com.project.veiculoPneu.service.VeiculoPneuService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/vinculoPneu")
@Tag(name="Vinculo de Pneu")
public class VeiculoPneuController {

    @Autowired
    VeiculoPneuService veiculoPneuService;
    
    @PutMapping("/vincular")
    @Operation(	summary = "Vincula um pneu a um veiculo")
    public ResponseEntity<String> vincularPneuVeiculo(VinculoPneuVeiculoDTO pneuVeiculo){
        if(veiculoPneuService.vincularPneuVeiculo(pneuVeiculo) != Boolean.TRUE){
        return ResponseEntity.ok().body("Pneu " + pneuVeiculo.getNumeroDeFogo() + 
                                        "Foi vinculado ao veiculo " + pneuVeiculo.getPlacaVeiculo()
                                        );
        }
        return ResponseEntity.badRequest().body("");
    }

    @PutMapping("/desvincular")
    @Operation(	summary = "Desvincula um pneu a um veiculo")
    public ResponseEntity<String> desvincularPneuVeiculo(VinculoPneuVeiculoDTO pneuVeiculo){
        
        return ResponseEntity.ok().body("Pneu " + pneuVeiculo.getNumeroDeFogo() + 
                                        "Foi desvinculado do veiculo " + pneuVeiculo.getPlacaVeiculo()
                                        );
        
    }
}
