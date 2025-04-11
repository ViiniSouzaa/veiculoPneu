package com.project.veiculoPneu.model;


import com.project.veiculoPneu.model.dto.VinculoPneuVeiculoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "veiculo_pneus")
@IdClass(VeiculoPneuId.class)  // Usando a chave composta
@Data
@Builder
public class VeiculoPneu {

    @Id
    @Column(name = "placa_veiculo")
    private String placaVeiculo;  // Chave estrangeira para Veiculo (placa)

    @Id
    @Column(name = "numero_fogo")
    private Long numeroDeFogo;  // Chave estrangeira para Pneu (numero_de_fogo)

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "placa_veiculo", insertable = false, updatable = false)
    private Veiculo veiculo;  // Relacionamento com a entidade Veiculo

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero_fogo", insertable = false, updatable = false)
    private Pneu pneu;  // Relacionamento com a entidade Pneu

    private String posicao;  // Ex: A, B, C, D

    public static VeiculoPneu from(VinculoPneuVeiculoDTO veiculoPneu) {
        return new VeiculoPneuBuilder()
                        .placaVeiculo(veiculoPneu.getPlacaVeiculo())
                        .numeroDeFogo(veiculoPneu.getNumeroDeFogo())
                        .posicao(veiculoPneu.getPosicao())
                        .build();
    }

}