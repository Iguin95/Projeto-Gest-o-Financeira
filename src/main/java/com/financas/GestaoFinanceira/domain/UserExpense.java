package com.financas.GestaoFinanceira.domain;

import java.util.Objects;

import com.financas.GestaoFinanceira.domain.pk.UserExpensePK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user_expense")
public class UserExpense {

	@EmbeddedId
	private UserExpensePK id = new UserExpensePK();
	
	private Integer quantity;
	
	public UserExpense() {
	}

	public UserExpense(Expense expense, User user, Integer quantity) {
		id.setExpense(expense);
		id.setUser(user);
		this.quantity = quantity;
	}
	
	public Expense getExpense() {
		return id.getExpense();
	}
	
	public User getUser() {
		return id.getUser();
	}

	public UserExpensePK getId() {
		return id;
	}

	public void setId(UserExpensePK id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double getSubTotal() {
		return quantity * id.getExpense().getPrice();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserExpense other = (UserExpense) obj;
		return Objects.equals(id, other.id);
	}
}
