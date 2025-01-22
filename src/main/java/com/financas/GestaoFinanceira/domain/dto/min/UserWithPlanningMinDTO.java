package com.financas.GestaoFinanceira.domain.dto.min;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.financas.GestaoFinanceira.domain.User;

public class UserWithPlanningMinDTO {
	
	private Long id;
	private String name;
	
	private List<UserExpenseWithPlanningMinDTO> userExpenses = new ArrayList<>();

	public UserWithPlanningMinDTO() {
	}

	public UserWithPlanningMinDTO(User entity) {
		BeanUtils.copyProperties(entity, this);

		if (entity.getUserExpenses() != null) {
            entity.getUserExpenses().forEach(x -> this.userExpenses.add(new UserExpenseWithPlanningMinDTO(x)));
        }
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

	public List<UserExpenseWithPlanningMinDTO> getUserExpenses() {
		return userExpenses;
	}	
}

