package com.financas.GestaoFinanceira.domain.dto;

import java.util.ArrayList;
import java.util.List;

import com.financas.GestaoFinanceira.domain.Report;
import com.financas.GestaoFinanceira.domain.dto.min.FinancialPlanningMinExpenseDTO;

public class ReportDTO {

	private Long id;
	
	private List<FinancialPlanningMinExpenseDTO> financialPlannings = new ArrayList<>();
	
	public ReportDTO() {
	}

	public ReportDTO(Report entity) {
		this.id = entity.getId();
		
		if (entity.getUser().getFinancialPlanning() != null) {
            entity.getUser().getFinancialPlanning().forEach(fp -> this.financialPlannings.add(new FinancialPlanningMinExpenseDTO(fp)));
        }
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<FinancialPlanningMinExpenseDTO> getFinancialPlannings() {
		return financialPlannings;
	}
}
