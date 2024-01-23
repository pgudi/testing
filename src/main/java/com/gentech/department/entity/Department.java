package com.gentech.department.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "departments")
public class Department {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@Column(name = "hod_name")
	private String hodName;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "zip_code")
	private int zipcode;
	
	public Department() {
		
	}

	public Department(String departmentName, String hodName, String location, int zipcode) {
		super();
		this.departmentName = departmentName;
		this.hodName = hodName;
		this.location = location;
		this.zipcode = zipcode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getHodName() {
		return hodName;
	}

	public void setHodName(String hodName) {
		this.hodName = hodName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
}
