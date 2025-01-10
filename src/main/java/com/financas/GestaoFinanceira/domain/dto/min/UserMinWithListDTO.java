package com.financas.GestaoFinanceira.domain.dto.min;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.financas.GestaoFinanceira.domain.User;
import com.financas.GestaoFinanceira.domain.dto.UserExpenseDTO;

public class UserMinWithListDTO {

	private Long id;
	private String name;
	
	private List<UserExpenseDTO> userExpenses = new ArrayList<>();

	public UserMinWithListDTO() {
	}

	public UserMinWithListDTO(User entity) {
		BeanUtils.copyProperties(entity, this);

		if (entity.getUserExpenses() != null) {
            entity.getUserExpenses().forEach(x -> this.userExpenses.add(new UserExpenseDTO(x)));
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

	public List<UserExpenseDTO> getUserExpenses() {
		return userExpenses;
	}
	
}
