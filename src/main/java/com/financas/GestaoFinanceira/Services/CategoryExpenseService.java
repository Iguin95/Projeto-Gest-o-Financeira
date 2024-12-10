package com.financas.GestaoFinanceira.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financas.GestaoFinanceira.domain.CategoryExpense;
import com.financas.GestaoFinanceira.repositories.CategoryExpenseRepository;

@Service
public class CategoryExpenseService {
	
	@Autowired
	private CategoryExpenseRepository repository;
	
	public List<CategoryExpense> findAll(){
		return repository.findAll();
	}
	
}
