package com.financas.GestaoFinanceira.domain.dto.min;

import java.util.List;
import java.util.stream.Collectors;

import com.financas.GestaoFinanceira.domain.FinancialPlanning;
import com.financas.GestaoFinanceira.domain.dto.ExpenseDTO;

public class FinancialPlanningMinExpenseDTO {

	private Long id;
	private Double annualGoal;
	private Double monthlyGoal;
	
	public FinancialPlanningMinExpenseDTO() {
	}
	
	private List<ExpenseDTO> expenses; // Cada planejamento tem sua própria lista de despesas.

    public FinancialPlanningMinExpenseDTO(FinancialPlanning entity) {
        this.id = entity.getId();
        this.annualGoal = entity.getAnnualGoal();
        this.monthlyGoal = entity.getMonthlyGoal();
        
        // Mapear despesas associadas ao planejamento
        this.expenses = entity.getExpenses().stream().map(ExpenseDTO::new).collect(Collectors.toList());
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

	public List<ExpenseDTO> getExpenses() {
		return expenses;
	}   
    
	public Double getDesiredSavings() {
		return monthlyGoal * 12;
	}
	
	public Double getSubTotal() {
	    return expenses.stream()
	                   .mapToDouble(ExpenseDTO::getPrice) 
	                   .sum(); 
	}
}


