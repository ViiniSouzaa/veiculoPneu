package com.project.veiculoPneu.model.dto;

import com.project.veiculoPneu.model.Veiculo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoDTO {
    
	private Long id;
    private String placa;
    private String marca;
    private Integer quilometragem;
    private String status;
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
