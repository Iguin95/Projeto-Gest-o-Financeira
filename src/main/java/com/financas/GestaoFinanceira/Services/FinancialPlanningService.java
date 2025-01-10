package com.financas.GestaoFinanceira.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financas.GestaoFinanceira.domain.FinancialPlanning;
import com.financas.GestaoFinanceira.domain.dto.FinancialPlanningDTO;
import com.financas.GestaoFinanceira.repositories.FinancialPlanningRepository;

@Service
public class FinancialPlanningService {

	@Autowired
	private FinancialPlanningRepository repository;
	
	@Transactional(readOnly = true)
	public List<FinancialPlanningDTO> findAll(){
		List<FinancialPlanning> list = repository.findAll();
		List<FinancialPlanningDTO> dto = list.stream().map(x -> new FinancialPlanningDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public FinancialPlanningDTO fingById(Long id) {
		FinancialPlanning obj = repository.findById(id).get();
		return new FinancialPlanningDTO(obj);
	}
}
