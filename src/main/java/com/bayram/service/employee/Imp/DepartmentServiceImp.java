package com.bayram.service.employee.Imp;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayram.dao.epmloyee.DepartmentRepository;
import com.bayram.model.employee.Department;
import com.bayram.service.employee.DepartmentService;
@Service
public class DepartmentServiceImp implements DepartmentService{
	
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public boolean saveDepartment(Department department) {
		return departmentRepository.saveDepartment(department);
	}

	@Override
	public boolean deleteDepartment(Department department) {
		return departmentRepository.deleteDepartment(department);
	}

	@Override
	public Department updateDepartment(Department department) {
		return departmentRepository.updateDepartment(department);
	}

	@Override
	public Department findDepartmentById(long departmentId) {
		return departmentRepository.findDepartmentById(departmentId);
	}

	@Override
	public List<Department> findAllDepartments() {
		return departmentRepository.findAllDepartments();
	}

	@Override
	public List<String> findDepartmentNames() {
		return departmentRepository.findDepartmentNames();
	}

	@Override
	public Department findLocationAndEmployeesByDepartmentId(long departmentId) {
		return departmentRepository.findLocationAndEmployeesByDepartmentId(departmentId);
	}

	@Override
	public Department findByDepartmentName(String name) {
		return departmentRepository.findByDepartmentName(name);
	}

}
