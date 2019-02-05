package com.dozo.thymeleaf.thymeleafapp.service;

import java.util.List;

import com.dozo.thymeleaf.thymeleafapp.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee emp);
	
	public void deleteById(int id);
	
	public List<Employee> findAllLastNameAsc();
}