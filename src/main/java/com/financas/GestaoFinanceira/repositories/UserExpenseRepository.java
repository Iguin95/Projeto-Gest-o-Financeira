package com.financas.GestaoFinanceira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financas.GestaoFinanceira.domain.UserExpense;
import com.financas.GestaoFinanceira.domain.pk.UserExpensePK;

public interface UserExpenseRepository extends JpaRepository<UserExpense, UserExpensePK> {

}
