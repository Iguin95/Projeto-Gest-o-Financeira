package com.financas.GestaoFinanceira.domain.pk;

import java.io.Serializable;
import java.util.Objects;

import com.financas.GestaoFinanceira.domain.Category;
import com.financas.GestaoFinanceira.domain.Expense;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class CategoryExpensePK implements Serializable { //Despesas da categoria

	private static final long serialVersionUID = 1L; 
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "expense_id")
	private Expense expense;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, expense);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryExpensePK other = (CategoryExpensePK) obj;
		return Objects.equals(category, other.category) && Objects.equals(expense, other.expense);
	}
}
