package com.project.veiculoPneu.repository.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.veiculoPneu.model.dto.PneuDTO;
import com.project.veiculoPneu.repository.PneuRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class PneuRepositoryImpl implements PneuRepository{
	
	 @PersistenceContext
	 private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<PneuDTO> findPneuSituacaoByPlaca(String placa) {		
		String jpql = "SELECT new com.project.veiculoPneu.model.dto.PneuDTO(p.id, p.numeroDeFogo, p.marca, p.pressaoAtual, p.status, vp.posicao) " +
	              "FROM Pneu p " +
	              "JOIN VeiculoPneu vp ON vp.numeroDeFogo = p.numeroDeFogo " +
	              "JOIN Veiculo v ON v.placa = vp.placaVeiculo " +
	              "WHERE v.placa = :placa";

		Query query = entityManager.createQuery(jpql);
		query.setParameter("placa", placa);

		List<PneuDTO> pneuDTOs = query.getResultList();
		
		return pneuDTOs;
	}

}
