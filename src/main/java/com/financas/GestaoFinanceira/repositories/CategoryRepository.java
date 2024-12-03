package com.financas.GestaoFinanceira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financas.GestaoFinanceira.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
