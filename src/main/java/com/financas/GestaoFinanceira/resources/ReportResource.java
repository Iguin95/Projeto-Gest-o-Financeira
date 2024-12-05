package com.financas.GestaoFinanceira.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financas.GestaoFinanceira.Services.ReportService;
import com.financas.GestaoFinanceira.domain.Report;

@RestController
@RequestMapping(value = "/reports")
public class ReportResource {

	@Autowired
	ReportService service;
	
	@GetMapping
	public ResponseEntity<List<Report>> findAll(){
		List<Report> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Report> findById(@PathVariable Long id){
		Report obj = service.fingById(id);
		return ResponseEntity.ok().body(obj);
	}
}
