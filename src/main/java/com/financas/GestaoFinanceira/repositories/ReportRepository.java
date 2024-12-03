package com.financas.GestaoFinanceira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financas.GestaoFinanceira.domain.Report;

public interface ReportRepository extends JpaRepository<Report, Long>{

}
