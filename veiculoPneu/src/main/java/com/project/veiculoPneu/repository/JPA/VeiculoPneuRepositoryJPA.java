package com.project.veiculoPneu.repository.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.veiculoPneu.model.VeiculoPneu;
import com.project.veiculoPneu.model.VeiculoPneuId;

public interface VeiculoPneuRepositoryJPA extends JpaRepository<VeiculoPneu, VeiculoPneuId>{

    
}
