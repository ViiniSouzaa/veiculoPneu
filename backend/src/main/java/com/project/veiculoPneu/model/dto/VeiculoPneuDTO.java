package com.project.veiculoPneu.model.dto;

import java.util.List;

import com.project.veiculoPneu.model.Veiculo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class VeiculoPneuDTO {
	
	@Schema(description = "Informações do veículo associado")
    private VeiculoDTO veiculo;

    @Schema(description = "Lista de pneus vinculados ao veículo")
    private List<PneuDTO> pneus;
 
	public VeiculoPneuDTO(Veiculo veiculo, List<PneuDTO> veiculoPneus) {
		this.veiculo = VeiculoDTO.from(veiculo);
		this.pneus = veiculoPneus;
	}
}
