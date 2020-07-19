package com.bayram.service.employee;

import java.util.List;

import com.bayram.model.employee.Department;

public interface DepartmentService {
	
	boolean saveDepartment(Department department);

	boolean deleteDepartment(Department department);

	Department updateDepartment(Department department);

	Department findDepartmentById(long departmentId); 

	public List<Department> findAllDepartments();

	public List<String> findDepartmentNames();
	
	Department findLocationAndEmployeesByDepartmentId(long departmentId); 
	
	public Department findByDepartmentName(String name);

}
