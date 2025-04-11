package com.project.veiculoPneu.repository.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.veiculoPneu.model.VeiculoPneu;
import com.project.veiculoPneu.model.VeiculoPneuId;

import jakarta.transaction.Transactional;

@Repository
public interface VeiculoPneuRepositoryJPA extends JpaRepository<VeiculoPneu, VeiculoPneuId>{

    @Modifying
    @Transactional
    @Query(
        value = "INSERT INTO veiculo_pneus (placa_veiculo, numero_fogo, posicao) VALUES (:placaVeiculo, :numeroDeFogo, :posicao)",
        nativeQuery = true
    )
    void salvarVeiculoPneu(@Param("placaVeiculo") String placaVeiculo,
                           @Param("numeroDeFogo") Long numeroDeFogo,
                           @Param("posicao") String posicao);
    
    @Modifying
    @Transactional
    @Query(
        value ="DELETE FROM veiculo_pneus WHERE numero_fogo = :numeroDeFogo",
        nativeQuery = true
        )                       
    void deleteByNumeroDeFogo(@Param("numeroDeFogo") Long numeroDeFogo);
    
}
