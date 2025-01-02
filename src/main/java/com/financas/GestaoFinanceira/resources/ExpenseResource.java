package com.financas.GestaoFinanceira.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financas.GestaoFinanceira.Services.ExpenseService;
import com.financas.GestaoFinanceira.domain.dto.ExpenseDTO;

@RestController
@RequestMapping(value = "/expenses") 
public class ExpenseResource {
	
	@Autowired
	ExpenseService service;
	
	@GetMapping
	public List<ExpenseDTO> findAll(){
		List<ExpenseDTO> list = service.findAll();
		return list;
	}
	
	@GetMapping(value = "/{id}")
	public ExpenseDTO findById(@PathVariable Long id){
		ExpenseDTO obj = service.findById(id);
		return obj;
	}

}
