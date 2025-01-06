package com.financas.GestaoFinanceira.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financas.GestaoFinanceira.domain.User;
import com.financas.GestaoFinanceira.domain.dto.UserDTO;
import com.financas.GestaoFinanceira.domain.dto.min.UserMinDTO;
import com.financas.GestaoFinanceira.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll(){
		List<User> list = repository.findAll();
		List<UserDTO> dto = list.stream().map(x -> new UserDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public UserMinDTO findById(Long id) {
		User obj = repository.findById(id).get();
		return new UserMinDTO(obj);
	}

}
