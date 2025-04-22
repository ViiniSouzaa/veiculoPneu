package com.project.veiculoPneu.model.dto;

import com.project.veiculoPneu.model.Veiculo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoDTO {
    
    @Schema(hidden = true)
	private Long id;
    
    @Schema(description = "Placa do veículo", example = "ABC-1234")
    private String placa;
    
    @Schema(description = "Marca do veículo", example = "Volkswagen")
    private String marca;
    
    @Schema(description = "Quilometragem atual do veículo em quilômetros", example = "15000")
    private Integer quilometragem;
    
    @Schema(description = "Status do veículo (ativo/inativo)", defaultValue = "inativo")
    private String status;
    
    @Schema(description = "Tipo do veículo", example = "Carro")
    private String tipo;

    
 // Método estático para criar a instância do DTO de forma mais explícita
    public static VeiculoDTO from(Veiculo veiculo) {
        return new VeiculoDTO(
            veiculo.getId(),
            veiculo.getPlaca(),
            veiculo.getMarca(),
            veiculo.getQuilometragem(),
            veiculo.getStatus(),
            veiculo.getTipo()
        );
    }
    
}
