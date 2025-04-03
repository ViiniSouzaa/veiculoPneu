package com.project.veiculoPneu.model;

import java.util.List;



import com.project.veiculoPneu.VeiculoPneuApplication;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String marca;
    private Integer quilometragem;
    private String status;

    @OneToMany(mappedBy = "veiculo")
    private List<VeiculoPneu> veiculoPneus;

	public void setVeiculoPneus(List<VeiculoPneu> veiculoPneus) {
		this.veiculoPneus = veiculoPneus;
		
	}
}
