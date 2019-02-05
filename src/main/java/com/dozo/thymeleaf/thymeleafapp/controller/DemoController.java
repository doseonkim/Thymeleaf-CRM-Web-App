package com.dozo.thymeleaf.thymeleafapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dozo.thymeleaf.thymeleafapp.entity.Employee;

@Controller
public class DemoController {
	
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		theEmployees = new ArrayList<>();
		Employee emp1 = new Employee("Doseon", "Kim", "email@email.com");
		Employee emp2 = new Employee("Susan", "Boyle", "email@email.com");
		Employee emp3 = new Employee("Jeffrey", "Don", "email@email.com");
		
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
	}
	
	@GetMapping("/hello")
	public String getHello(Model model) {
		model.addAttribute("theDate",new java.util.Date());
		return "hello-world";
	}
	
	@GetMapping("/employees")
	public String getEmployees(Model model) {
		model.addAttribute("employees", theEmployees);
		return "list-employees";
	}
}
