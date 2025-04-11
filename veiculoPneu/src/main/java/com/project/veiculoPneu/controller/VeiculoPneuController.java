package com.project.veiculoPneu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.veiculoPneu.model.dto.VinculoPneuVeiculoDTO;
import com.project.veiculoPneu.service.VeiculoPneuService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/vinculoPneu")
@Tag(name="Vinculo de Pneu")
public class VeiculoPneuController {

    @Autowired
    VeiculoPneuService veiculoPneuService;
    
    @PutMapping("/vincular")
    @Operation(	summary = "Vincula um pneu a um veiculo")
    public ResponseEntity<String> vincularPneuVeiculo(@RequestBody VinculoPneuVeiculoDTO pneuVeiculo){
        veiculoPneuService.vincularPneuVeiculo(pneuVeiculo);
        return ResponseEntity.ok().body("Pneu " + pneuVeiculo.getNumeroDeFogo() + 
                                        " foi vinculado ao veiculo " + pneuVeiculo.getPlacaVeiculo()
                                        );
        
    }

    @PutMapping("/desvincular/{numeroDeFogo}")
    @Operation(	summary = "Desvincula um pneu a um veiculo")
    public ResponseEntity<String> desvincularPneuVeiculo(	
                        @Parameter(	description = "Numero de fogo do pneu a ser buscado", example = "12345")
    					@PathVariable Long numeroDeFogo){

        veiculoPneuService.desvincularPneuVeiculo(numeroDeFogo);
        return ResponseEntity.ok().body("Pneu " + numeroDeFogo + " foi desvinculado.");
        
    }
}
