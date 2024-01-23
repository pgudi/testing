package com.gentech.department.service;

import java.util.List;

import com.gentech.department.entity.Department;



public interface DepartmentService {
	
	Department createDepartment(Department department);
	
	List<Department> getAllDepartments();
	
	Department getDepartment(long id);
	
	Department modifyDepartment(Department department, long id);
	
	void deleteDepartment(long id);
}
