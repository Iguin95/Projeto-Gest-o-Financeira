package com.financas.GestaoFinanceira.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private Double monthlyIncome; //renda mensal
	
	@JsonIgnoreProperties("user")
	@OneToMany(mappedBy = "user")
	private List<FinancialPlanning> financialPlanning = new ArrayList<>();
	
	@JsonIgnoreProperties("users")
	@OneToMany(mappedBy = "id.user")
	private List<UserExpense> userExpenses = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name = "tb_contato")
	private Set<String> contatosTelefonicos = new HashSet<>();
	
	public User() {
	}

	public User(Long id, String name, String email, Double monthlyIncome) {
		this.id = id;
		this.name = name;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(Double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public List<FinancialPlanning> getFinancialPlanning() {
		System.out.println("Lista de planejamentos financeiros na classe User serializada!");
		return financialPlanning;
	}

	public List<UserExpense> getUserExpenses() {
		return userExpenses;
	}

	public Set<String> getContatosTelefonicos() {
		return contatosTelefonicos;
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
