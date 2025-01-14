package com.financas.GestaoFinanceira.domain.dto;

import java.util.ArrayList;
import java.util.List;

import com.financas.GestaoFinanceira.domain.Report;
import com.financas.GestaoFinanceira.domain.dto.min.UserMinWithListDTO;

public class ReportDTO {

	private Long id;
	
	private List<FinancialPlanningDTO> financialPlannings = new ArrayList<>();
	
	private UserMinWithListDTO user;
	
	public ReportDTO() {
	}

	public ReportDTO(Report entity) {
		this.id = entity.getId();
		if (entity.getUser() != null) {
		this.user = new UserMinWithListDTO(entity.getUser());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserMinWithListDTO getUser() {
		return user;
	}

	public void setUser(UserMinWithListDTO user) {
		this.user = user;
	}

	public List<FinancialPlanningDTO> getFinancialPlannings() {
		return financialPlannings;
	}

	
}
