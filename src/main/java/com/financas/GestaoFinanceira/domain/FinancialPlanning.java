package com.financas.GestaoFinanceira.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_FinancialPlanning") //Planejamento financeiro
public class FinancialPlanning implements Serializable{ 

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double annualGoal; //meta anual de economia
	private Double monthlyGoal; //meta mensal de economia
	
	@JsonIgnoreProperties("financialPlanning")
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@JsonIgnoreProperties("financialPlanning")
	@OneToMany(mappedBy = "financialPlanning")
	private List<Expense> expenses = new ArrayList<>();
	
	public FinancialPlanning() {
	}

	public FinancialPlanning(Long id, Double annualGoal, Double monthlyGoal, User user) {
		this.id = id;
		this.annualGoal = annualGoal;
		this.monthlyGoal = monthlyGoal;
		this.user = user;
		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAnnualGoal() {
		return annualGoal;
	}

	public void setAnnualGoal(Double annualGoal) {
		this.annualGoal = annualGoal;
	}

	public Double getMonthlyGoal() {
		return monthlyGoal;
	}

	public void setMonthlyGoal(Double monthlyGoal) {
		this.monthlyGoal = monthlyGoal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Double getDesiredSavings() {
		return monthlyGoal * 12;
	}

	public List<Expense> getExpenses() {
		return expenses;
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
		FinancialPlanning other = (FinancialPlanning) obj;
		return Objects.equals(id, other.id);
	}
}
