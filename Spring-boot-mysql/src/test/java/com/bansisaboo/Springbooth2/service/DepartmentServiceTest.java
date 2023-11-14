package com.bansisaboo.Springbooth2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.bansisaboo.Springbooth2.entity.Department;

@SpringBootTest
class DepartmentServiceTest {

	private DepartmentService departmentService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void whenValidDepartmentnameFound_thenDepartmentShouldFound() {
		String departmentName = "IT";
		Department found = departmentService.getDepartmentByName(departmentName);
	}


}
