package com.financas.GestaoFinanceira.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financas.GestaoFinanceira.domain.Expense;
import com.financas.GestaoFinanceira.domain.dto.ExpenseDTO;
import com.financas.GestaoFinanceira.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	ExpenseRepository repository;
	
	@Transactional(readOnly = true)
	public List<ExpenseDTO> findAll(){
		List<Expense> result = repository.findAll();
		List<ExpenseDTO> dto = result.stream().map(x -> new ExpenseDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public ExpenseDTO findById(Long id) {
		Expense result = repository.findById(id).get();
		return new ExpenseDTO(result);
	}

}
