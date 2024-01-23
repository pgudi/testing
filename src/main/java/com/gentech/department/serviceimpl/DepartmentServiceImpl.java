package com.gentech.department.serviceimpl;

import java.util.List; 
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gentech.department.entity.Department;
import com.gentech.department.repository.DepartmentRepository;
import com.gentech.department.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentRepository departmentRepository;
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	@Override
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartment(long id) {
		Optional<Department> department=departmentRepository.findById(id);
		return department.get();
	}

	@Override
	public Department modifyDepartment(Department department, long id) {
		Optional<Department> deptmentObject=departmentRepository.findById(id);
		Department existingDepartment=deptmentObject.get();
		
		existingDepartment.setDepartmentName(department.getDepartmentName());
		existingDepartment.setHodName(department.getHodName());
		existingDepartment.setLocation(department.getLocation());
		existingDepartment.setZipcode(department.getZipcode());
		departmentRepository.save(existingDepartment);
		
		return existingDepartment;
	}

	@Override
	public void deleteDepartment(long id) {			
		departmentRepository.deleteById(id);
	}

	
}
