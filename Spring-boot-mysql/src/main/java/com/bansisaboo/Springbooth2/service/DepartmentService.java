package com.bansisaboo.Springbooth2.service;

import java.util.List;

import com.bansisaboo.Springbooth2.entity.Department;
import com.bansisaboo.Springbooth2.errors.DepartmentNotFoundException;

public interface DepartmentService {

	Department saveDepartment(Department department);

	List<Department> getAllDepartments();

	Department getDepartmentById(long departmentId) throws DepartmentNotFoundException;

	void deleteDepartmentById(long departmentId);

	Department updateDepartmentById(long departmentId, Department department);

	Department getDepartmentByName(String departmentName);

}
