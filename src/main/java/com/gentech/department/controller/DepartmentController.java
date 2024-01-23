package com.gentech.department.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gentech.department.entity.Department;
import com.gentech.department.service.DepartmentService;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {
	
	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	
	// http://localhost:9091/api/v1/dept/department
	@PostMapping("/department")
	public  ResponseEntity<Department> addDepartment(@RequestBody Department department)
	{
		return new ResponseEntity<Department>(departmentService.createDepartment(department), HttpStatus.CREATED);
	}
	
	// http://localhost:9091/api/v1/dept/department
	@GetMapping("/department")
	public List<Department> getDepartments()
	{
		return departmentService.getAllDepartments();
	}

	// http://localhost:9091/api/v1/dept/department/1
	@GetMapping("/department/{id}")
	public ResponseEntity<Department> getParticularDepartment(@PathVariable("id") long id)
	{
		return new ResponseEntity<Department>(departmentService.getDepartment(id), HttpStatus.OK);
	}
	
	// http://localhost:9091/api/v1/dept/department/1
	@PutMapping("/department/{id}")
	public ResponseEntity<Department> updateParticularDepartment(@RequestBody Department department,
			@PathVariable("id") long id)
	{
		return new ResponseEntity<Department>(departmentService.modifyDepartment(department, id), HttpStatus.OK);
	}
	
	// http://localhost:9091/api/v1/dept/department/1
	@DeleteMapping("/department/{id}")
	public ResponseEntity<String> deleteParticularDepartment(@PathVariable("id") long id)
	{
		departmentService.deleteDepartment(id);
		return new ResponseEntity<String>("The Department id "+id+" details has deleted successfully", HttpStatus.OK);
	}
}
