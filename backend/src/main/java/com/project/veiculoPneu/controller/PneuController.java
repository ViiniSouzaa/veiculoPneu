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

import com.project.veiculoPneu.model.dto.PneuDTO;
import com.project.veiculoPneu.service.PneuService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/pneus")
@Tag(name="Pneus")
public class PneuController {

    @Autowired
    private PneuService pneuService;

    // Endpoint para listar todos os pneus
    @GetMapping
    @Operation(	summary = "Lista todos os pneus", 
    			description = "Retorna uma lista de todos os pneus existentes")
    public ResponseEntity<List<PneuDTO>> listarPneus() {
        List<PneuDTO> pneus = pneuService.listarTodosPneus();
        if(pneus != null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pneus);
    }

    // Endpoint para obter um pneu específico
    @GetMapping("/{id}")
    @Operation(	summary = "Lista um pneu por id", 
    			description = "Retorna um pneu de acordo com seu id")
    public ResponseEntity<PneuDTO> obterPneu(	@Parameter(	description = "ID do pneu a ser buscado", 
										example = "1")
    						@PathVariable Long id) {

        PneuDTO pneu =  pneuService.obterPneu(id);

        if(pneu != null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pneu);
        
    }
    
 // Endpoint para obter um pneu específico
    @GetMapping("numeroDeFogo/{numeroDeFogo}")
    @Operation(	summary = "Lista um pneu por numero de fogo", 
    			description = "Retorna um pneu de acordo com seu numero de fogo")
    public ResponseEntity<PneuDTO> obterPneuByNumeroDeFogo(	@Parameter(	description = "Numero de fogo do pneu a ser buscado", 
										example = "12345")
    						@PathVariable Long numeroDeFogo) {

        PneuDTO pneu =  pneuService.findByNumeroDeFogo(numeroDeFogo);

        if(pneu != null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pneu);
    }

    // Endpoint para criar um novo pneu
    @PostMapping
    @Operation(summary = "Cria um pneu", description = "Retorna um pneu criado")
    public ResponseEntity<String> criarPneu(@RequestBody PneuDTO pneu) {
        if (pneu.getStatus() == null) {
            pneu.setStatus("INATIVO");
        }
        return pneuService.salvarPneu(pneu) != null ? 
                        ResponseEntity.ok().body("") : ResponseEntity.badRequest().build();
    }
}