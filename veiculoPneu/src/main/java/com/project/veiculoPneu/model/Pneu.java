package com.project.veiculoPneu.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "pneus")
public class Pneu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "numero_de_fogo", nullable = false, unique = true)
    private Long numeroDeFogo;
    
    private String marca;
    private Integer pressaoAtual;
    
    private String status;
    
    @OneToMany(mappedBy = "pneu")
    @JsonIgnore
    private List<VeiculoPneu> veiculoPneus;
}
