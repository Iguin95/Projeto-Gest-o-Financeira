package com.financas.GestaoFinanceira.domain.dto.min;

import org.springframework.beans.BeanUtils;

import com.financas.GestaoFinanceira.domain.Expense;

public class ExpenseMinDTO {

	private Long id;
	private String description;
	
	public ExpenseMinDTO(){
	}
	
	public ExpenseMinDTO(Expense entity) {
		BeanUtils.copyProperties(entity, this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
}
