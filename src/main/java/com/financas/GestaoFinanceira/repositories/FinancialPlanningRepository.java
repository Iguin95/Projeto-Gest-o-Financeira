package com.financas.GestaoFinanceira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financas.GestaoFinanceira.domain.FinancialPlanning;

public interface FinancialPlanningRepository extends JpaRepository<FinancialPlanning, Long> {

}
