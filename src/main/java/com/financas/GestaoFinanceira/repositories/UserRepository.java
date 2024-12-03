package com.financas.GestaoFinanceira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financas.GestaoFinanceira.domain.User;

public interface UserRepository extends JpaRepository<Long, User> {

}
