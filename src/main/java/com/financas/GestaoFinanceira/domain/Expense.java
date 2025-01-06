package com.financas.GestaoFinanceira.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "tb_expense") // Despesa
public class Expense implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Double price;
	private LocalDate date;
	private Boolean necessaryExpense; // despesa necessária

	@ManyToOne
	@JoinColumn(name = "financial_planning_id")
	private FinancialPlanning financialPlanning;
	
	@JsonIgnoreProperties("expenses")
	@ManyToMany
	@JoinTable(name = "Category_Expense",
	joinColumns = @JoinColumn(name = "expense_id"),
	inverseJoinColumns = @JoinColumn(name = "category_id"))
	List<Category> categories = new ArrayList<>();

	public Expense() {
	}

	public Expense(Long id, String description, Double value, LocalDate date, Boolean necessaryExpense, 
			FinancialPlanning financialPlanning) {
		this.id = id;
		this.description = description;
		this.price = value;
		this.date = date;
		this.necessaryExpense = necessaryExpense;
		this.financialPlanning = financialPlanning;
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

	public FinancialPlanning getFinancialPlanning() {
		return financialPlanning;
	}

	public void setFinancialPlanning(FinancialPlanning financialPlanning) {
		this.financialPlanning = financialPlanning;
	}

	public List<Category> getCategories() {
		return categories;
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
		Expense other = (Expense) obj;
		return Objects.equals(id, other.id);
	}
}
