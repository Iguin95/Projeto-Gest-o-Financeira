package com.financas.GestaoFinanceira.domain.dto;

import org.springframework.beans.BeanUtils;

import com.financas.GestaoFinanceira.domain.FinancialPlanning;
import com.financas.GestaoFinanceira.domain.dto.min.UserMinDTO;

public class FinancialPlanningDTO {

	private Long id;
	private Double annualGoal; 
	private Double monthlyGoal;
	
	private UserMinDTO user;
	
	public FinancialPlanningDTO() {
	}

	public FinancialPlanningDTO(FinancialPlanning entity) {
		BeanUtils.copyProperties(entity, this);
		if (entity.getUser() != null) {
	        this.user = new UserMinDTO(entity.getUser());
	    }
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAnnualGoal() {
		return annualGoal;
	}

	public void setAnnualGoal(Double annualGoal) {
		this.annualGoal = annualGoal;
	}

	public Double getMonthlyGoal() {
		return monthlyGoal;
	}

	public void setMonthlyGoal(Double monthlyGoal) {
		this.monthlyGoal = monthlyGoal;
	}

	public UserMinDTO getUser() {
		return user;
	}

	public void setUser(UserMinDTO user) {
		this.user = user;
	}
	
	
}
