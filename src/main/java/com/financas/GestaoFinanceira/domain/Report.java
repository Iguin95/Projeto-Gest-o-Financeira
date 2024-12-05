package com.financas.GestaoFinanceira.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_report")
public class Report implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "financialPlanning_id")
	private FinancialPlanning financialPlanning;
	
	@OneToMany(mappedBy = "report")
	List<CategoryExpense> expenses = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Report() {
	}

	public Report(Long id, User user) {
		this.id = id;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CategoryExpense> getExpenses() {
		return expenses;
	}
	
	public List<Double> getSpendingByCategory() { //gastos por categoria
		List<Double> category = new ArrayList<>();
		//para cada objeto x do tipo CategoryExpense contido na minha lista expenses, faça...
		for(CategoryExpense x : expenses) { 
			category.add(x.getSubTotal());
		}
		return category;
	}
	
	public Double getTotalExpenses() { //gastos totais
		double sum = 0.0;
		for(CategoryExpense x : expenses) {
			sum += x.getSubTotal();
		}
		return sum;
	}
	
	public Double getFinalBalance() { //saldo final (salario - gastos totais)
		return getTotalExpenses() - getUser().getMonthlyIncome();
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
