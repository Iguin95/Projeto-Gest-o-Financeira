package com.financas.GestaoFinanceira.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double monthlyIncome; //renda mensal
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private FinancialPlanning financialPlanning;
	
	@OneToMany(mappedBy = "user")
	List<Report> reports = new ArrayList<>();
	
	public User() {
	}

	public User(Long id, String name, Double monthlyIncome) {
		this.id = id;
		this.name = name;
		this.monthlyIncome = monthlyIncome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(Double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public FinancialPlanning getFinancialPlanning() {
		return financialPlanning;
	}

	public void setFinancialPlanning(FinancialPlanning financialPlanning) {
		this.financialPlanning = financialPlanning;
	}

	public List<Report> getReports() {
		return reports;
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
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
