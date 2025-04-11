package com.project.veiculoPneu.repository.JPA;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.veiculoPneu.model.Veiculo;

@Repository
public interface VeiculoRepositoryJPA extends JpaRepository<Veiculo, Long> {
    
	@SuppressWarnings("null")
    @Query("SELECT v FROM Veiculo v")
	List<Veiculo> findAll();
    
    @SuppressWarnings("null")
    Optional<Veiculo> findById(@SuppressWarnings("null") Long id);
    
    @Query("SELECT v FROM Veiculo v WHERE v.placa = :placa")
    Optional<Veiculo> findByPlaca(String placa);
}
