package com.financas.GestaoFinanceira.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financas.GestaoFinanceira.Services.CategoryExpenseService;
import com.financas.GestaoFinanceira.domain.CategoryExpense;

@RestController
@RequestMapping(value = "/categories_expenses")
public class CategoryExpenseResource {

	@Autowired
	CategoryExpenseService service;
	
	@GetMapping
	public ResponseEntity<List<CategoryExpense>> findAll(){
		List<CategoryExpense> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
