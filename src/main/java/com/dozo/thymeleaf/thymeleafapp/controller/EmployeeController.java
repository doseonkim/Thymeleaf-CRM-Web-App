package com.dozo.thymeleaf.thymeleafapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dozo.thymeleaf.thymeleafapp.entity.Employee;
import com.dozo.thymeleaf.thymeleafapp.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;

	@GetMapping("/list")
	public String getEmployees(Model model) {
		model.addAttribute("employees", service.findAllLastNameAsc());
		return "/employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd") 
	public String showForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "/employees/employee-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee emp) {
		service.save(emp);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showUpdate(@PathVariable int id, Model model) {
		Employee emp = service.findById(id);
		if (emp == null)
			throw new RuntimeException("Could not find employee id - " + id);
		model.addAttribute(emp);
		return "/employees/employee-form";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		Employee emp = service.findById(id);
		if (emp == null)
			throw new RuntimeException("Could not find employee id - " + id);
		service.deleteById(id);
		return "redirect:/employees/list";
	}
}
