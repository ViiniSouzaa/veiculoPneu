package com.project.veiculoPneu.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.veiculoPneu.model.Pneu;

@Repository
public interface PneuRepository extends JpaRepository<Pneu, Long> {
    
	List<Pneu> findAll();
    
	Optional<Pneu> findById(Long id);
}
