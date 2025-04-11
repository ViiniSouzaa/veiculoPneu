package com.project.veiculoPneu.model.dto;

import com.project.veiculoPneu.model.Pneu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class   PneuDTO {

    private Long id;
	private Long numeroDeFogo;
    private String marca;
    private Integer pressaoAtual;
    private String status;
    private String posicao;

    // Método estático para criar a instância do DTO de forma mais explícita
    public static PneuDTO from(Pneu pneu) {
        return new PneuDTOBuilder()
                    .id(pneu.getId())
                    .numeroDeFogo(pneu.getNumeroDeFogo())
                    .marca(pneu.getMarca())
                    .pressaoAtual(pneu.getPressaoAtual())
                    .status(pneu.getStatus())
                    .build();
    }

}
