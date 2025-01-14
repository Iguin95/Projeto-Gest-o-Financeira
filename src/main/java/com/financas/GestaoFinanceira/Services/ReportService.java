package com.financas.GestaoFinanceira.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financas.GestaoFinanceira.domain.Report;

import com.financas.GestaoFinanceira.domain.dto.ReportDTO;
import com.financas.GestaoFinanceira.repositories.ReportRepository;

@Service
public class ReportService {

	@Autowired
	ReportRepository repository;

	@Transactional(readOnly = true)
	public List<ReportDTO> findAll() {
		List<Report> list = repository.findAll();
		List<ReportDTO> dto = list.stream().map(x -> new ReportDTO(x)).toList();
		return dto;
	}

	@Transactional(readOnly = true)
	public ReportDTO fingById(Long id) {
		Report obj = repository.findById(id).get();
		return new ReportDTO(obj);
	}
}
