package com.project.veiculoPneu.model.dto;

import com.project.veiculoPneu.model.Pneu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class   PneuDTO {

    @Schema(hidden = true)
    private Long id;

    @Schema(description = "Número de fogo do pneu", example = "12345")
    private Long numeroDeFogo;
    
    @Schema(description = "Marca do pneu", example = "Bridgestone")
    private String marca;
    
    @Schema(description = "Pressão atual do pneu em PSI", example = "32")
    private Integer pressaoAtual;
    
    @Schema(description = "Status do pneu (ativo/inativo)", defaultValue = "inativo")
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
