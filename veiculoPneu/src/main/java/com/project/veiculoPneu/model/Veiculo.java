package com.project.veiculoPneu.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.veiculoPneu.model.dto.VeiculoDTO;

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
@Table(name = "veiculos")
@Data
@Builder
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    @Schema(description = "Placa do veículo", example = "ABC-1234")
    @Column(nullable = false, unique = true)
    private String placa;
    
    @Schema(description = "Marca do veículo", example = "Volkswagen")
    private String marca;

    @Schema(description = "Quilometragem atual do veículo em quilômetros", example = "15000")
    private int quilometragem;

    @Schema(description = "Status do veículo (ativo/inativo)", defaultValue = "inativo")
    private String status;
    
    @Schema(description = "Tipo do veículo", example = "Carro")
    private String tipo;

    @OneToMany(mappedBy = "veiculo")
    @JsonIgnore
    private List<VeiculoPneu> veiculoPneus;

    public static Veiculo from(VeiculoDTO veiculo) {
        return new VeiculoBuilder()
        .id(veiculo.getId())
        .placa(veiculo.getPlaca())
        .marca(veiculo.getMarca())
        .quilometragem(veiculo.getQuilometragem())
        .status(veiculo.getStatus())
        .tipo(veiculo.getTipo())
        .build();
    }
}
