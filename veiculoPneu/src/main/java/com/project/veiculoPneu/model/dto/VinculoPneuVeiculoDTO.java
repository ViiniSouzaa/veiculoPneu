package com.project.veiculoPneu.model.dto;

import com.project.veiculoPneu.model.VeiculoPneu;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VinculoPneuVeiculoDTO {

    String placaVeiculo;
    Long numeroDeFogo;
    String posicao;

    public static VinculoPneuVeiculoDTO from(VeiculoPneu veiculoPneu) {
        return new VinculoPneuVeiculoDTOBuilder()
                        .placaVeiculo(veiculoPneu.getPlacaVeiculo())
                        .numeroDeFogo(veiculoPneu.getNumeroDeFogo())
                        .posicao(veiculoPneu.getPosicao())
                        .build();
    }
}
