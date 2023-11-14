package com.bansisaboo.Springbooth2.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bansisaboo.Springbooth2.entity.Department;
import com.bansisaboo.Springbooth2.errors.DepartmentNotFoundException;
import com.bansisaboo.Springbooth2.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {

	private final Logger LOGGER = 
			LoggerFactory.getLogger(DepartmentController.class);

	
	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/addDepartments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.info("Inside the addDepartments controller");
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/allDepartments")
	public List<Department> getAllDeaprtments() {
		return departmentService.getAllDepartments();
	}

	@GetMapping("/getDepartmentById/{id}")
	public Department getDepartmentById(@PathVariable("id") long departmentId) throws DepartmentNotFoundException {
		return departmentService.getDepartmentById(departmentId);
	}

	@DeleteMapping("/deleteDepartmentById/{id}")
	public void deleteDepartmentById(@PathVariable("id") long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
	}

	@PutMapping("/updateDepartmentById/{id}")
	public Department updateDepartmentById(@PathVariable("id") long departmentId, @RequestBody Department department) {
		return departmentService.updateDepartmentById(departmentId, department);
	}

	@GetMapping("/getDepartmentByName/name/{departmentName}")
	public Department getDepartmentByName(@PathVariable("departmentName") String departmentName) {
		return departmentService.getDepartmentByName(departmentName);
	}
}
