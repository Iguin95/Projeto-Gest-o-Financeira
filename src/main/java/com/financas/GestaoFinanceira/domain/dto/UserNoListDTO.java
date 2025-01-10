package com.financas.GestaoFinanceira.domain.dto;

import org.springframework.beans.BeanUtils;

import com.financas.GestaoFinanceira.domain.User;

public class UserNoListDTO {

	private Long id;
	private String name;
	private Double monthlyIncome;
	
	public UserNoListDTO(){	
	}
	
	public UserNoListDTO(User entity) {
		BeanUtils.copyProperties(entity, this);
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

	public Double getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(Double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
}

