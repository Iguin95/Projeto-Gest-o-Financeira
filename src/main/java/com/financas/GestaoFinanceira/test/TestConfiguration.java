package com.financas.GestaoFinanceira.test;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.financas.GestaoFinanceira.domain.Category;
import com.financas.GestaoFinanceira.domain.CategoryExpense;
import com.financas.GestaoFinanceira.domain.Expense;
import com.financas.GestaoFinanceira.domain.FinancialPlanning;
import com.financas.GestaoFinanceira.domain.Report;
import com.financas.GestaoFinanceira.domain.User;
import com.financas.GestaoFinanceira.repositories.CategoryExpenseRepository;
import com.financas.GestaoFinanceira.repositories.CategoryRepository;
import com.financas.GestaoFinanceira.repositories.ExpenseRepository;
//import com.financas.GestaoFinanceira.repositories.FinancialPlanningRepository;
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
	
	//@Autowired
	//FinancialPlanningRepository financialPlanningRepository;
	
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
		
		FinancialPlanning fp = new FinancialPlanning(null, 10000.00, 1000.00, user1);
		user1.setFinancialPlanning(fp);
		userRepository.saveAll(Arrays.asList(user1));
		
		Expense ex1 = new Expense(null, "Teclado", 400.00, LocalDate.parse("2019-06-20"), false, user1);
		Expense ex2 = new Expense(null, "Banana", 4.00, LocalDate.parse("2019-07-22"), true, user1);
		
		expenseRepository.saveAll(Arrays.asList(ex1, ex2));
		
		CategoryExpense ce1 = new CategoryExpense(cat2, ex2, 2, ex2.getPrice());
		CategoryExpense ce2 = new CategoryExpense(cat1, ex1, 5, ex1.getPrice());
		
		
		categoryExpenseRepository.saveAll(Arrays.asList(ce1, ce2));
		
		Report r1 = new Report(null, user1);
		reportRepository.save(r1);
		
	}

}
