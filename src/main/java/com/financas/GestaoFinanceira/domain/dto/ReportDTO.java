package com.financas.GestaoFinanceira.domain.dto;

import com.financas.GestaoFinanceira.domain.Report;
import com.financas.GestaoFinanceira.domain.dto.min.UserWithPlanningMinDTO;

public class ReportDTO {

	private Long id;
	
	private UserWithPlanningMinDTO user;
	
	public ReportDTO() {
	}

	public ReportDTO(Report entity) {
		this.id = entity.getId();
		
		if (entity.getUser() != null) {
			this.user = new UserWithPlanningMinDTO(entity.getUser());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserWithPlanningMinDTO getUsers() {
		return user;
	}
}
