package com.financas.GestaoFinanceira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financas.GestaoFinanceira.domain.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{

}
