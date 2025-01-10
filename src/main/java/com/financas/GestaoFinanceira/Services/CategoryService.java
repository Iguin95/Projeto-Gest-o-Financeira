package com.financas.GestaoFinanceira.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financas.GestaoFinanceira.domain.Category;
import com.financas.GestaoFinanceira.domain.dto.CategoryWithListDTO;
import com.financas.GestaoFinanceira.domain.dto.min.CategoryWithListMinDTO;
import com.financas.GestaoFinanceira.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryWithListMinDTO> findAll(){
		List<Category> result = repository.findAll();
		List<CategoryWithListMinDTO> dto = result.stream().map(x -> new CategoryWithListMinDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public CategoryWithListDTO findById(Long id) {
		Category result = repository.findById(id).get();
		return new CategoryWithListDTO(result);
	}
}
