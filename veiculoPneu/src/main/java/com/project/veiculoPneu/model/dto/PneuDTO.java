package com.project.veiculoPneu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PneuDTO {

	private Long id;
	private Long numeroDeFogo;
    private String marca;
    private Integer pressaoAtual;
    private String status;
    private String posicao;
}
