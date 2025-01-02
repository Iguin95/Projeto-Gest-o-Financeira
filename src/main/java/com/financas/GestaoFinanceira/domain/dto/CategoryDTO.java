package com.financas.GestaoFinanceira.domain.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.financas.GestaoFinanceira.domain.Category;
import com.financas.GestaoFinanceira.domain.Expense;

public class CategoryDTO {

	private Long id;
	private String name;
	private Double predictedCategoryLimit;
	
	List<Expense> expenses = new ArrayList<>();
	
	public CategoryDTO() {
	}
	
	public CategoryDTO(Category result) {
		BeanUtils.copyProperties(result, this);
		expenses = result.getExpenses();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPredictedCategoryLimit() {
		return predictedCategoryLimit;
	}

	public void setPredictedCategoryLimit(Double predictedCategoryLimit) {
		this.predictedCategoryLimit = predictedCategoryLimit;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}
	
}
