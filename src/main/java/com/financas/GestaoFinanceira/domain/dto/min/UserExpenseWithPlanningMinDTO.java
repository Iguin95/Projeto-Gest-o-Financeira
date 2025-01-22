package com.financas.GestaoFinanceira.domain.dto.min;

import com.financas.GestaoFinanceira.domain.UserExpense;

public class UserExpenseWithPlanningMinDTO {

	private Integer quantity;

	private FinancialPlanningMinExpenseDTO fpExpense;

	public UserExpenseWithPlanningMinDTO() {
	}

	public UserExpenseWithPlanningMinDTO(UserExpense entity) {
		this.quantity = entity.getQuantity();
		
		if (entity.getExpense() != null && entity.getExpense().getFinancialPlanning() != null) {
            this.fpExpense = new FinancialPlanningMinExpenseDTO(entity.getExpense().getFinancialPlanning());
        }
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public FinancialPlanningMinExpenseDTO getFinancialPlanning() {
		return fpExpense;
	}

	public void setFinancialPlanning(FinancialPlanningMinExpenseDTO expense) {
		this.fpExpense = expense;
	}

	public Double getSubTotal() {
	     if (fpExpense == null || fpExpense.getExpenses() == null) {
	            return 0.0; // Retorna 0 se não houver despesas
	        }

	        // Calcula o subtotal multiplicando preço e quantidade
	        return fpExpense.getExpenses().stream()
	            .mapToDouble(expense -> expense.getPrice() * (quantity != null ? quantity : 1)) // Multiplica por 'quantity'
	            .sum(); // Soma os valores
	    }
	}

