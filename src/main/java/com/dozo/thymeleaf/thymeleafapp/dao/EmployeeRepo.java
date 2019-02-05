package com.dozo.thymeleaf.thymeleafapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dozo.thymeleaf.thymeleafapp.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	// sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();

	
}
