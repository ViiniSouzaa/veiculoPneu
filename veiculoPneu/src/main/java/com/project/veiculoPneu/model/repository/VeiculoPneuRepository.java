package com.project.veiculoPneu.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.veiculoPneu.model.VeiculoPneu;

@Repository
public interface VeiculoPneuRepository extends JpaRepository<VeiculoPneu, Long> {
    List<VeiculoPneu> findByVeiculoId(Long veiculoId);
}