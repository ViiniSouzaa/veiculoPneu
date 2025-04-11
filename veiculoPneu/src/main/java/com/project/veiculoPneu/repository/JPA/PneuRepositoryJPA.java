package com.project.veiculoPneu.repository.JPA;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.veiculoPneu.model.Pneu;

@Repository
public interface PneuRepositoryJPA extends JpaRepository<Pneu, Long> {
    
	@SuppressWarnings("null")
	@Query("SELECT p FROM Pneu p")
	List<Pneu> findAll();
    
	@SuppressWarnings("null")
	@Query("SELECT p FROM Pneu p WHERE p.id = :id")
	Optional<Pneu> findById( Long id);
	
	@Query("SELECT p FROM Pneu p WHERE p.numeroDeFogo = :numeroDeFogo")
	Optional<Pneu> findByNumeroDeFogo(Long numeroDeFogo);
}
