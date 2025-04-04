package com.project.veiculoPneu.model.dto;

import java.util.List;

import com.project.veiculoPneu.model.Veiculo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class VeiculoPneuDTO {
	
	private VeiculoDTO veiculo;
	
	private List<PneuDTO> pneus;
 
	public VeiculoPneuDTO(Veiculo veiculo, List<PneuDTO> veiculoPneus) {
		this.veiculo = VeiculoDTO.from(veiculo);
		this.pneus = veiculoPneus;
	}
}
