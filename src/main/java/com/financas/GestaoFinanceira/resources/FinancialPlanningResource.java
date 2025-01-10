package com.financas.GestaoFinanceira.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financas.GestaoFinanceira.Services.FinancialPlanningService;
import com.financas.GestaoFinanceira.domain.dto.FinancialPlanningDTO;
import com.financas.GestaoFinanceira.domain.dto.min.FinancialPlanningMinDTO;

@RestController
@RequestMapping(value = "/financial_plans")
public class FinancialPlanningResource {

	@Autowired
	FinancialPlanningService service;
	
	@GetMapping
	public List<FinancialPlanningMinDTO> findAll(){
		List<FinancialPlanningMinDTO> list = service.findAll();
		return list;
	}
	
	@GetMapping(value = "/{id}")
	public FinancialPlanningDTO findById(@PathVariable Long id){
		FinancialPlanningDTO obj = service.fingById(id);
		return obj;
	}
}
