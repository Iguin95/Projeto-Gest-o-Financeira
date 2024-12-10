package com.financas.GestaoFinanceira.domain;

import java.io.Serializable;
import java.util.Objects;

import com.financas.GestaoFinanceira.domain.pk.CategoryExpensePK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_category_expense")
public class CategoryExpense implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CategoryExpensePK id = new CategoryExpensePK();
	
	private Integer quantity;
	private Double pricePerUnit;
	
	public CategoryExpense() {
	}

	public CategoryExpense(Category category, Expense expense, Integer quantity, Double price) {
		id.setCategory(category);
		id.setExpense(expense);
		this.quantity = quantity;
		this.pricePerUnit = price;
	}
	
	public Category getCategory() {
		return id.getCategory();
	}
	
	public void setCategory(Category category) {
		id.setCategory(category);
	}
	
	public Expense getExpense() {
		return id.getExpense();
	}
	
	public void setExpense(Expense expense) {
		id.setExpense(expense);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(Double price) {
		this.pricePerUnit = price;
	}
	
	public Double getSubTotal() {
		return pricePerUnit * quantity;
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
		CategoryExpense other = (CategoryExpense) obj;
		return Objects.equals(id, other.id);
	}
}
