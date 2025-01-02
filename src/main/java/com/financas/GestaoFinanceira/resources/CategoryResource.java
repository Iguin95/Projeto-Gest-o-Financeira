package com.financas.GestaoFinanceira.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financas.GestaoFinanceira.Services.CategoryService;
import com.financas.GestaoFinanceira.domain.dto.CategoryDTO;


@RestController
@RequestMapping(value = "/categories") 
public class CategoryResource {
	
	@Autowired
	CategoryService service;
	
	@GetMapping
	public List<CategoryDTO> findAll(){
		List<CategoryDTO> list = service.findAll();
		return list;
	}
	
	@GetMapping(value = "/{id}")
	public CategoryDTO findById(@PathVariable Long id){
		CategoryDTO obj = service.findById(id);
		return obj;
	}
}
