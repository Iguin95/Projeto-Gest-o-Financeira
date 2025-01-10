package com.financas.GestaoFinanceira.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financas.GestaoFinanceira.Services.CategoryService;
import com.financas.GestaoFinanceira.domain.dto.CategoryWithListDTO;
import com.financas.GestaoFinanceira.domain.dto.min.CategoryWithListMinDTO;


@RestController
@RequestMapping(value = "/categories") 
public class CategoryResource {
	
	@Autowired
	CategoryService service;
	
	@GetMapping
	public List<CategoryWithListMinDTO> findAll(){
		List<CategoryWithListMinDTO> list = service.findAll();
		return list;
	}
	
	@GetMapping(value = "/{id}")
	public CategoryWithListDTO findById(@PathVariable Long id){
		CategoryWithListDTO obj = service.findById(id);
		return obj;
	}
}
