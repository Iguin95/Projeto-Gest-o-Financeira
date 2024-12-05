package com.financas.GestaoFinanceira.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financas.GestaoFinanceira.domain.Report;
import com.financas.GestaoFinanceira.repositories.ReportRepository;

@Service
public class ReportService {

	@Autowired
	ReportRepository repository;
	
	public List<Report> findAll(){
		return repository.findAll();
	}
	
	public Report fingById(Long id) {
		Optional<Report> obj = repository.findById(id);
		return obj.get();
	}
}
