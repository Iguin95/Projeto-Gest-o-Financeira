package com.financas.GestaoFinanceira.test;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.financas.GestaoFinanceira.domain.Category;
import com.financas.GestaoFinanceira.domain.FinancialPlanning;
import com.financas.GestaoFinanceira.domain.User;
import com.financas.GestaoFinanceira.repositories.CategoryExpenseRepository;
import com.financas.GestaoFinanceira.repositories.CategoryRepository;
import com.financas.GestaoFinanceira.repositories.ExpenseRepository;
import com.financas.GestaoFinanceira.repositories.FinancialPlanningRepository;
import com.financas.GestaoFinanceira.repositories.ReportRepository;
import com.financas.GestaoFinanceira.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	FinancialPlanningRepository financialPlanningRepository;
	
	@Autowired
	CategoryExpenseRepository categoryExpenseRepository;
	
	@Autowired
	ReportRepository reportRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Igor", 2100.00);
		User user2 = new User(null, "Maria", 5000.00);
		userRepository.saveAll(Arrays.asList(user1, user2));
		
		Category cat1 = new Category(null, "Informática", 500.00);
		Category cat2 = new Category(null, "Alimentação", 850.00);
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		
		FinancialPlanning fp1 = new FinancialPlanning(null, 20000.00, 1500.00, user1);
		FinancialPlanning fp2 = new FinancialPlanning(null, 35000.00, 3600.00, user2);
		FinancialPlanning fp3 = new FinancialPlanning(null, 15000.00, 1250.00, user1);
		financialPlanningRepository.saveAll(Arrays.asList(fp1, fp2, fp3));
		
		
		
	}

}
