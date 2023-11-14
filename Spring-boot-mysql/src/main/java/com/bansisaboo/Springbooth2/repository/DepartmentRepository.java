package com.bansisaboo.Springbooth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bansisaboo.Springbooth2.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long > {

	Department findByDepartmentName(String departmentName);

}
