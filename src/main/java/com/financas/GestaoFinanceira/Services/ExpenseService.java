package com.financas.GestaoFinanceira.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financas.GestaoFinanceira.domain.Expense;
import com.financas.GestaoFinanceira.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	ExpenseRepository repository;
	
	public List<Expense> findAll(){
		return repository.findAll();
	}
	
	public Expense findById(Long id) {
		Optional<Expense> obj = repository.findById(id);
		return obj.get();
	}

}
