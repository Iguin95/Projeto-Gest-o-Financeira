package com.financas.GestaoFinanceira.domain.dto.min;

import org.springframework.beans.BeanUtils;

import com.financas.GestaoFinanceira.domain.FinancialPlanning;
import com.financas.GestaoFinanceira.domain.dto.UserNoListDTO;

public class FinancialPlanningMinDTO {

	private Long id;
	private Double annualGoal; 
	private Double monthlyGoal;
	
	private UserNoListDTO user;
	
	public FinancialPlanningMinDTO() {
	}

	public FinancialPlanningMinDTO(FinancialPlanning entity) {
		BeanUtils.copyProperties(entity, this);
		if (entity.getUser() != null) {
	        this.user = new UserNoListDTO(entity.getUser());
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

	public UserNoListDTO getUser() {
		return user;
	}

	public void setUser(UserNoListDTO user) {
		this.user = user;
	}
}
