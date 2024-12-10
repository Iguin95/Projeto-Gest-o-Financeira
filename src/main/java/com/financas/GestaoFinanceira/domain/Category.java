package com.financas.GestaoFinanceira.domain;

import java.io.Serializable;
import java.util.Objects;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double predictedCategoryLimit; //limite previsto da categoria
	
	//@OneToMany(mappedBy = "id.category")
	//Set<CategoryExpense> expenses = new HashSet<>();
	
	public Category() {
	}
	
	public Category(Long id, String name, Double predictedCategoryLimit) {
		this.id = id;
		this.name = name;
		this.predictedCategoryLimit = predictedCategoryLimit;
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

	public Double getPredictedCategoryLimit() {
		return predictedCategoryLimit;
	}

	public void setPredictedCategoryLimit(Double predictedCategoryLimit) {
		this.predictedCategoryLimit = predictedCategoryLimit;
	}

	/*@JsonIgnore
	public Set<CategoryExpense> getExpenses() {
		return expenses;
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
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}

}
