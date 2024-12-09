package com.financas.GestaoFinanceira.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financas.GestaoFinanceira.domain.FinancialPlanning;
import com.financas.GestaoFinanceira.repositories.FinancialPlanningRepository;

@Service
public class FinancialPlanningService {

	@Autowired
	private FinancialPlanningRepository repository;
	
	public List<FinancialPlanning> findAll(){
		return repository.findAll();
	}
	
	public FinancialPlanning fingById(Long id) {
		Optional<FinancialPlanning> obj = repository.findById(id);
		return obj.get();
	}
}
