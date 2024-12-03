package com.financas.GestaoFinanceira.test;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.financas.GestaoFinanceira.domain.FinancialPlanning;
import com.financas.GestaoFinanceira.domain.User;
import com.financas.GestaoFinanceira.repositories.FinancialPlanningRepository;
import com.financas.GestaoFinanceira.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FinancialPlanningRepository financialPlanningRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Igor", 2100.00);
		//User user2 = new User(null, "Maria", 5000.00);
		userRepository.saveAll(Arrays.asList(user1));
		
		FinancialPlanning fp = new FinancialPlanning(null, 10000.00, 1000.00, user1);
		
		user1.setFinancialPlanning(fp);
		userRepository.save(user1);

		
	}

}
