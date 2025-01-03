package com.financas.GestaoFinanceira.domain.dto;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;

import com.financas.GestaoFinanceira.domain.Expense;

public class ExpenseDTO {

	private Long id;
	private String description;
	private Double price;
	private LocalDate date;
	private Boolean necessaryExpense;
	
	public ExpenseDTO(){
	}
	
	public ExpenseDTO(Expense entity) {
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Boolean getNecessaryExpense() {
		return necessaryExpense;
	}

	public void setNecessaryExpense(Boolean necessaryExpense) {
		this.necessaryExpense = necessaryExpense;
	}
}
