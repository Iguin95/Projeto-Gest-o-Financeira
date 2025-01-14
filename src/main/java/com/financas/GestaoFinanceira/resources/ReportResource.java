package com.financas.GestaoFinanceira.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financas.GestaoFinanceira.Services.ReportService;

import com.financas.GestaoFinanceira.domain.dto.ReportDTO;

@RestController
@RequestMapping(value = "/reports")
public class ReportResource {

	@Autowired
	ReportService service;

	@GetMapping
	public List<ReportDTO> findAll() {
		List<ReportDTO> list = service.findAll();
		return list;
	}

	@GetMapping(value = "/{id}")
	public ReportDTO findById(@PathVariable Long id) {
		ReportDTO obj = service.fingById(id);
		return obj;
	}
}
