package com.financas.GestaoFinanceira.domain.dto;

import com.financas.GestaoFinanceira.domain.UserExpense;

public class UserExpenseDTO {
	
	private Integer quantity;
	
    private ExpenseDTO expense; 

    public UserExpenseDTO() {
    }

    public UserExpenseDTO(UserExpense entity) {
    	this.quantity = entity.getQuantity();
    	this.expense = new ExpenseDTO(entity.getExpense());
    }

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ExpenseDTO getExpense() {
		return expense;
	}

	public void setExpense(ExpenseDTO expense) {
		this.expense = expense;
	}
	
	public Double getSubTotal() {
		return quantity * expense.getPrice();
	}	
}
