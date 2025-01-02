package com.financas.GestaoFinanceira.test;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.financas.GestaoFinanceira.domain.Category;
import com.financas.GestaoFinanceira.domain.Expense;
import com.financas.GestaoFinanceira.domain.FinancialPlanning;
import com.financas.GestaoFinanceira.domain.User;
import com.financas.GestaoFinanceira.repositories.CategoryRepository;
import com.financas.GestaoFinanceira.repositories.ExpenseRepository;
import com.financas.GestaoFinanceira.repositories.FinancialPlanningRepository;
import com.financas.GestaoFinanceira.repositories.ReportRepository;
import com.financas.GestaoFinanceira.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner {
	
	DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	FinancialPlanningRepository financialPlanningRepository;
	
	@Autowired
	ReportRepository reportRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Igor", 2100.00);
		User user2 = new User(null, "Maria", 5000.00);
		userRepository.saveAll(Arrays.asList(user1, user2));
		
		FinancialPlanning fp1 = new FinancialPlanning(null, 20000.00, 1500.00, user1);
		FinancialPlanning fp2 = new FinancialPlanning(null, 35000.00, 3600.00, user2);
		FinancialPlanning fp3 = new FinancialPlanning(null, 15000.00, 1250.00, user1);
		financialPlanningRepository.saveAll(Arrays.asList(fp1, fp2, fp3));
		
		user1.getFinancialPlanning().addAll(Arrays.asList(fp1, fp3));
		user2.getFinancialPlanning().addAll(Arrays.asList(fp2));
		userRepository.saveAll(Arrays.asList(user1, user2));
		
		Expense ex1 = new Expense(null, "Iorgute", 13.99, LocalDate.parse("10/12/2024", fmt1), false, fp1);
		Expense ex2 = new Expense(null, "RTX 2080", 1800.99, LocalDate.parse("19/10/2022", fmt1), false, fp3);
		Expense ex3 = new Expense(null, "Arroz 5kg", 31.98, LocalDate.parse("28/11/2024", fmt1), true, fp2);
		expenseRepository.saveAll(Arrays.asList(ex1, ex2, ex3));
		
		fp1.getExpenses().addAll(Arrays.asList(ex1));
		fp2.getExpenses().addAll(Arrays.asList(ex3));
		fp3.getExpenses().addAll(Arrays.asList(ex2));
		financialPlanningRepository.saveAll(Arrays.asList(fp1, fp2, fp3));
		
		Category cat1 = new Category(null, "Informática", 500.00);
		Category cat2 = new Category(null, "Alimentação", 850.00);
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		
		ex1.getCategories().addAll(Arrays.asList(cat2));
		ex2.getCategories().addAll(Arrays.asList(cat1));
		ex3.getCategories().addAll(Arrays.asList(cat2));
		expenseRepository.saveAll(Arrays.asList(ex1, ex2, ex3));
		
		cat1.getExpenses().addAll(Arrays.asList(ex1, ex2));
		cat2.getExpenses().addAll(Arrays.asList(ex3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
