package com.financas.GestaoFinanceira.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_report")
public class Report implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double totalExpenses; //gastos totais
	private Double spendingByCategory; //gastos por categoria
	private Double finalBalance; //saldo final
	
	public Report() {
	}

	public Report(Long id, Double totalExpenses, Double spendingByCategory, Double finalBalance) {
		this.id = id;
		this.totalExpenses = totalExpenses;
		this.spendingByCategory = spendingByCategory;
		this.finalBalance = finalBalance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotalExpenses() {
		return totalExpenses;
	}

	public void setTotalExpenses(Double totalExpenses) {
		this.totalExpenses = totalExpenses;
	}

	public Double getSpendingByCategory() {
		return spendingByCategory;
	}

	public void setSpendingByCategory(Double spendingByCategory) {
		this.spendingByCategory = spendingByCategory;
	}

	public Double getFinalBalance() {
		return finalBalance;
	}

	public void setFinalBalance(Double finalBalance) {
		this.finalBalance = finalBalance;
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
		Report other = (Report) obj;
		return Objects.equals(id, other.id);
	}
}
