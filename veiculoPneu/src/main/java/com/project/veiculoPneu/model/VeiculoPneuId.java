package com.project.veiculoPneu.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class VeiculoPneuId implements Serializable {
    private String placaVeiculo;
    private Long numeroDeFogo;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VeiculoPneuId that = (VeiculoPneuId) o;

        if (!placaVeiculo.equals(that.placaVeiculo)) return false;
        return numeroDeFogo.equals(that.numeroDeFogo);
    }

    @Override
    public int hashCode() {
        int result = placaVeiculo.hashCode();
        result = 31 * result + numeroDeFogo.hashCode();
        return result;
    }
}
