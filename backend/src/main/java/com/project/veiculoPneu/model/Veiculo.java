package com.project.veiculoPneu.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.veiculoPneu.model.dto.VeiculoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "veiculos")
@Data
@Builder
@AllArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String placa;
    
    private String marca;

    private int quilometragem;

    private String status;
    
    private String tipo;

    @OneToMany(mappedBy = "veiculo")
    @JsonIgnore
    private List<VeiculoPneu> veiculoPneus;

    public Veiculo() {
    }

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
