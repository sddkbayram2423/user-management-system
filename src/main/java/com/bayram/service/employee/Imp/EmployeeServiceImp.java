package com.bayram.service.employee.Imp;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayram.dao.epmloyee.EmployeeRepository;
import com.bayram.model.employee.Employee;
import com.bayram.service.employee.EmployeeService;
@Service
public class EmployeeServiceImp implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public boolean saveEmployee(Employee employee) {
		
		return employeeRepository.saveEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		return employeeRepository.deleteEmployee(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.updateEmployee(employee);
	}

	@Override
	public Employee findEmployeeById(long id) {
		return employeeRepository.findEmployeeById(id);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAllEmployees();
	}

	@Override
	public long countEmployee() {
		return employeeRepository.countEmployee();
	}

	@Override
	public List<Employee> betweenSalatryEpmloyess(double minSalary, double maxSalary) {
		return employeeRepository.betweenSalatryEpmloyess(minSalary, maxSalary);
	}

	@Override
	public List<Employee> findEpmloyessFirstMax(int fist, int max) {
		return employeeRepository.findEpmloyessFirstMax(fist, max);
	}

	@Override
	public Employee findFullById(long id) {
		return employeeRepository.findFullById(id);
	}

}
