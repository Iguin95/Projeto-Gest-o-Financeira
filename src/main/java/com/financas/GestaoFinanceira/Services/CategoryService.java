package com.financas.GestaoFinanceira.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financas.GestaoFinanceira.domain.Category;
import com.financas.GestaoFinanceira.domain.dto.CategoryDTO;
import com.financas.GestaoFinanceira.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){
		List<Category> result = repository.findAll();
		List<CategoryDTO> dto = result.stream().map(x -> new CategoryDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Category result = repository.findById(id).get();
		return new CategoryDTO(result);
	}
}
