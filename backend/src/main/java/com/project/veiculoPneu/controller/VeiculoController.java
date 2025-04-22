package com.project.veiculoPneu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.veiculoPneu.model.dto.VeiculoDTO;
import com.project.veiculoPneu.model.dto.VeiculoPneuDTO;
import com.project.veiculoPneu.service.VeiculoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/veiculos")
@Tag(name="Veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    @Operation(	summary = "Lista todos os veiculos", 
    			description = "Retorna uma lista de todos os veiculos existentes")
    public ResponseEntity<List<VeiculoDTO>> listarVeiculos() {
        List<VeiculoDTO> veiculos = veiculoService.listarTodosVeiculos();
        if(veiculos != null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(veiculos);
    }

    @GetMapping("/{id}")
    @Operation(	summary = "Lista um veiculo completo por id", 
    			description = "Retorna um veiculo completo (com Pneus) de acordo com seu id")
    public ResponseEntity<VeiculoPneuDTO> obterVeiculo(	@Parameter(	description = "ID do veiculo a ser buscado", 
    												example = "1")
    									@PathVariable Long id) {
        
        VeiculoPneuDTO veiculoPneu =  veiculoService.obterVeiculoComPneus(id);

        if(veiculoPneu != null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(veiculoPneu);
        
    }
    
    @GetMapping("/placa/{placa}")
    @Operation(	summary = "Lista um veiculo completo por placa", 
    			description = "Retorna um veiculo completo (com Pneus) de acordo com sua placa")
    public ResponseEntity<VeiculoPneuDTO> obterVeiculobyPlaca(	@Parameter(	description = "Placa do veiculo a ser buscado", 
    												example = "ABC-1234")
    									@PathVariable String placa) {
        
    VeiculoPneuDTO veiculoPneu =  veiculoService.obterVeiculoComPneus(placa);

        if(veiculoPneu != null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(veiculoPneu);
    
    }

    @PostMapping
    @Operation(summary = "Cria um veiculo", description = "Retorna um veiculo criado")
    public ResponseEntity<String> criarVeiculo(@RequestBody VeiculoDTO veiculo) {
        return veiculoService.salvarVeiculo(veiculo) != null ? 
                                ResponseEntity.ok().body("") : ResponseEntity.badRequest().build();
    }
}