package com.financas.GestaoFinanceira.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financas.GestaoFinanceira.domain.User;
import com.financas.GestaoFinanceira.domain.dto.UserNoListDTO;
import com.financas.GestaoFinanceira.domain.dto.min.UserMinWithListDTO;
import com.financas.GestaoFinanceira.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public List<UserNoListDTO> findAll(){
		List<User> list = repository.findAll();
		List<UserNoListDTO> dto = list.stream().map(x -> new UserNoListDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public UserMinWithListDTO findById(Long id) {
		User obj = repository.findById(id).get();
		return new UserMinWithListDTO(obj);
	}

}
