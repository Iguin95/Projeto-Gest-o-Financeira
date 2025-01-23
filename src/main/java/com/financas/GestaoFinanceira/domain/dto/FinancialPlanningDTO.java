package com.financas.GestaoFinanceira.domain.dto;

import org.springframework.beans.BeanUtils;

import com.financas.GestaoFinanceira.domain.FinancialPlanning;
import com.financas.GestaoFinanceira.domain.dto.min.UserExpenseWithPlanningMinDTO;
import com.financas.GestaoFinanceira.domain.dto.min.UserMinWithListDTO;
import com.financas.GestaoFinanceira.domain.dto.min.UserWithPlanningMinDTO;

public class FinancialPlanningDTO {

	private Long id;
	private Double annualGoal;
	private Double monthlyGoal;

	private UserWithPlanningMinDTO user;

	public FinancialPlanningDTO() {
	}

	public FinancialPlanningDTO(FinancialPlanning entity) {
		BeanUtils.copyProperties(entity, this);
		if (entity.getUser() != null) {
			this.user = new UserWithPlanningMinDTO(entity.getUser());
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

	public UserWithPlanningMinDTO getUser() {
		return user;
	}

	public void setUser(UserWithPlanningMinDTO user) {
		this.user = user;
	}

	public Double getDesiredSavings() {
		return monthlyGoal * 12;
	}

	public Double getTotal() {
		if (user == null || user.getUserExpenses() == null) {
			return 0.0;
		}
		// Calcula o total somando os subtotais de cada UserExpenseDTO
		return user.getUserExpenses().stream().mapToDouble(UserExpenseWithPlanningMinDTO::getSubTotal) // Chama o método getSubTotal
				.sum();
	}
}
