package com.financas.GestaoFinanceira.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financas.GestaoFinanceira.Services.UserService;
import com.financas.GestaoFinanceira.domain.dto.UserNoListDTO;
import com.financas.GestaoFinanceira.domain.dto.min.UserMinWithListDTO;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	UserService service;
	
	@GetMapping
	public List<UserNoListDTO> findAll(){
		List<UserNoListDTO> list = service.findAll();
		return list;
	}
	
	@GetMapping(value = "/{id}")
	public UserMinWithListDTO findById(@PathVariable Long id){
		UserMinWithListDTO obj = service.findById(id);
		return obj;
	}
	
	
}
