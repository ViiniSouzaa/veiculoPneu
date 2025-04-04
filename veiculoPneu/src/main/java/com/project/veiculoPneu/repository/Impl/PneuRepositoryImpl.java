package com.project.veiculoPneu.repository.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.veiculoPneu.model.Pneu;
import com.project.veiculoPneu.model.Veiculo;
import com.project.veiculoPneu.model.VeiculoPneu;
import com.project.veiculoPneu.model.dto.PneuDTO;
import com.project.veiculoPneu.repository.PneuRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

@Repository
public class PneuRepositoryImpl implements PneuRepository{
	
	 @PersistenceContext
	 private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<PneuDTO> findPneuSituacaoByPlaca(String placa) {
//		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//
//        CriteriaQuery<PneuDTO> criteriaQuery = criteriaBuilder.createQuery(PneuDTO.class);
//
//        Root<Pneu> pneuRoot = criteriaQuery.from(Pneu.class);
//
//        Join<Pneu, VeiculoPneu> veiculoPneuJoin = pneuRoot.join("veiculoPneus");
//        Join<VeiculoPneu, Veiculo> veiculoJoin = veiculoPneuJoin.join("veiculo");
//
//        criteriaQuery.select(criteriaBuilder.construct(PneuDTO.class, 
//            pneuRoot.get("numeroDeFogo"), 
//            pneuRoot.get("marca"), 
//            pneuRoot.get("pressaoAtual"), 
//            pneuRoot.get("status"),
//            veiculoPneuJoin.get("posicao")
//        	));
//
//        criteriaQuery.where(criteriaBuilder.equal(veiculoJoin.get("placa"), placa));
//
//        TypedQuery<PneuDTO> query = entityManager.createQuery(criteriaQuery);
//        
//        return query.getResultList();
		
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
