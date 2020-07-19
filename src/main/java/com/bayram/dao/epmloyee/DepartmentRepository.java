package com.bayram.dao.epmloyee;

import java.util.List;

import com.bayram.model.employee.Department;


public interface DepartmentRepository {
	
	boolean saveDepartment(Department department);

	boolean deleteDepartment(Department department);

	Department updateDepartment(Department department);

	Department findByDepartmentName(String name);

	Department findDepartmentById(long departmentId);
	
	Department findLocationAndEmployeesByDepartmentId(long departmentId);

	public List<Department> findAllDepartments();

	public List<String> findDepartmentNames();
}
