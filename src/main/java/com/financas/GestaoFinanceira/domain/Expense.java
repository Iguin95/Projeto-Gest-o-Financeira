package com.financas.GestaoFinanceira.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_expense") //Despesa
public class Expense implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Double price;
	private LocalDate date;
	private Boolean necessaryExpense; //despesa necessária

	//@OneToMany(mappedBy = "id.expense")
	//Set<CategoryExpense> expensesAndTheirCategories = new HashSet<>(); //despesas e suas categorias
	
	public Expense() {
	}

	public Expense(Long id, String description, Double value, LocalDate date, Boolean necessaryExpense) {
		this.id = id;
		this.description = description;
		this.price = value;
		this.date = date;
		this.necessaryExpense = necessaryExpense;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double value) {
		this.price = value;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Boolean getNecessaryExpense() {
		return necessaryExpense;
	}

	public void setNecessaryExpense(Boolean necessaryExpense) {
		this.necessaryExpense = necessaryExpense;
	}
	
	/*@JsonIgnore
	public Set<CategoryExpense> getExpensesAndTheirCategories() {
		return expensesAndTheirCategories;
	}*/

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
		Expense other = (Expense) obj;
		return Objects.equals(id, other.id);
	}
}
