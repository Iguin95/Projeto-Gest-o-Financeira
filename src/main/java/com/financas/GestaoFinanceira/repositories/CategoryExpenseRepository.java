package com.financas.GestaoFinanceira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financas.GestaoFinanceira.domain.CategoryExpense;
import com.financas.GestaoFinanceira.domain.pk.CategoryExpensePK;

public interface CategoryExpenseRepository extends JpaRepository<CategoryExpense, CategoryExpensePK>{

}
