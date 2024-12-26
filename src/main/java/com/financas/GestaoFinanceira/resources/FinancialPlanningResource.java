package com.financas.GestaoFinanceira.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financas.GestaoFinanceira.Services.FinancialPlanningService;
import com.financas.GestaoFinanceira.domain.FinancialPlanning;

@RestController
@RequestMapping(value = "/financial_plans")
public class FinancialPlanningResource {

	@Autowired
	FinancialPlanningService service;
	
	@GetMapping
	public ResponseEntity<List<FinancialPlanning>> findAll(){
		List<FinancialPlanning> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<FinancialPlanning> findById(@PathVariable Long id){
		FinancialPlanning obj = service.fingById(id);
		return ResponseEntity.ok().body(obj);
	}
}
