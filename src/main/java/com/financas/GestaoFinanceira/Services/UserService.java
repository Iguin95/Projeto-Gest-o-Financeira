package com.financas.GestaoFinanceira.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.financas.GestaoFinanceira.domain.User;
import com.financas.GestaoFinanceira.repositories.UserRepository;

@Service
public class UserService {

	UserRepository repository;

	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
}
