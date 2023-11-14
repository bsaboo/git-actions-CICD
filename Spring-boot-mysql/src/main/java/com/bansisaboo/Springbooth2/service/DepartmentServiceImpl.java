package com.bansisaboo.Springbooth2.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bansisaboo.Springbooth2.entity.Department;
import com.bansisaboo.Springbooth2.errors.DepartmentNotFoundException;
import com.bansisaboo.Springbooth2.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(long id) throws DepartmentNotFoundException {
		Optional<Department> department = departmentRepository.findById(id);
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department not found");
		}
		
		return department.get();
	}

	@Override
	public void deleteDepartmentById(long departmentId) {
		departmentRepository.deleteById(departmentId);
		
	}

	@Override
	public Department updateDepartmentById(long departmentId, Department department) {
		Department updatedDb = departmentRepository.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDepartmentName()) && 
				!"".equalsIgnoreCase(department.getDepartmentName())) {
			updatedDb.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(department.getDepartAddress()) && 
				!"".equalsIgnoreCase(department.getDepartAddress())) {
			updatedDb.setDepartmentName(department.getDepartAddress());
		}
		if(Objects.nonNull(department.getDepartmentCode()) && 
				!"".equalsIgnoreCase(department.getDepartmentCode())) {
			updatedDb.setDepartmentName(department.getDepartmentCode());
		}
		return departmentRepository.save(updatedDb);
	}

	@Override
	public Department getDepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentName(departmentName);	
	}
	

}
