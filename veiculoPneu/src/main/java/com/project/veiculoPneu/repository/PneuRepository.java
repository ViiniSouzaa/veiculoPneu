package com.project.veiculoPneu.repository;

import java.util.List;

import com.project.veiculoPneu.model.dto.PneuDTO;

public interface PneuRepository {

	List<PneuDTO> findPneuSituacaoByPlaca(String placa);
}
