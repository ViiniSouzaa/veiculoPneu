package com.project.veiculoPneu.model.dto;

import com.project.veiculoPneu.model.VeiculoPneu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VinculoPneuVeiculoDTO {

    @Schema(description = "Placa do Veiculo", example = "ABC-1234")
    String placaVeiculo;

    @Schema(description = "Numero de Fogo do Pneu", example = "12345")
    Long numeroDeFogo;

    @Schema(description = "Posicao do Pneu no Veiculo", example = "A")
    String posicao;

    public static VinculoPneuVeiculoDTO from(VeiculoPneu veiculoPneu) {
        return new VinculoPneuVeiculoDTOBuilder()
                        .placaVeiculo(veiculoPneu.getPlacaVeiculo())
                        .numeroDeFogo(veiculoPneu.getNumeroDeFogo())
                        .posicao(veiculoPneu.getPosicao())
                        .build();
    }
}
