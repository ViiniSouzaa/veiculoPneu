package com.project.veiculoPneu.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.veiculoPneu.model.dto.PneuDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Table(name = "pneus")
@Builder
public class Pneu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;
    
    @Column(name = "numero_de_fogo", nullable = false, unique = true)
    @Schema(description = "Número de fogo do pneu", example = "12345")
    private Long numeroDeFogo;
    
    @Schema(description = "Marca do pneu", example = "Bridgestone")
    private String marca;
    
    @Schema(description = "Pressão atual do pneu em PSI", example = "32")
    private Integer pressaoAtual;
    
    @Schema(description = "Status do pneu (ativo/inativo)", defaultValue = "inativo")
    private String status;
    
    @OneToMany(mappedBy = "pneu")
    @JsonIgnore
    private List<VeiculoPneu> veiculoPneus;

    public static Pneu from(PneuDTO pneu) {
        return new PneuBuilder()
                    .id(pneu.getId())
                    .numeroDeFogo(pneu.getNumeroDeFogo())
                    .marca(pneu.getMarca())
                    .pressaoAtual(pneu.getPressaoAtual())
                    .status(pneu.getStatus())
                    .build();

    }
}
