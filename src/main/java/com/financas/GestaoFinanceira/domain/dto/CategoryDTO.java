package com.financas.GestaoFinanceira.domain.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.financas.GestaoFinanceira.domain.Category;

public class CategoryDTO {

	private Long id;
	private String name;
	private Double predictedCategoryLimit;
	
	List<ExpenseDTO> expenses = new ArrayList<>();
	
	public CategoryDTO() {
	}
	
	public CategoryDTO(Category result) {
		BeanUtils.copyProperties(result, this);
		// Convertendo cada Expense para ExpenseDTO
        if (result.getExpenses() != null) {
            result.getExpenses().forEach(expense -> this.expenses.add(new ExpenseDTO(expense)));
        }
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

	public List<ExpenseDTO> getExpenses() {
		return expenses;
	}
	
}
