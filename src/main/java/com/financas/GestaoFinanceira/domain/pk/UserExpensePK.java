package com.financas.GestaoFinanceira.domain.pk;

import java.io.Serializable;
import java.util.Objects;

import com.financas.GestaoFinanceira.domain.User;
import com.financas.GestaoFinanceira.domain.Expense;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class UserExpensePK implements Serializable { //Despesas da categoria

	private static final long serialVersionUID = 1L; 
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "expense_id")
	private Expense expense;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}

	@Override
	public int hashCode() {
		return Objects.hash(user, expense);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserExpensePK other = (UserExpensePK) obj;
		return Objects.equals(user, other.user) && Objects.equals(expense, other.expense);
	}
}
