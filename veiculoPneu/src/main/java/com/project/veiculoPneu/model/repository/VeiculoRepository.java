package com.project.veiculoPneu.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.veiculoPneu.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    
	List<Veiculo> findAll();
    
    Optional<Veiculo> findById(Long id);
}
