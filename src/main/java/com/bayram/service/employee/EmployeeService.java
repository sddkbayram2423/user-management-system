package com.bayram.service.employee;

import java.util.List;

import com.bayram.model.employee.Employee;

public interface EmployeeService {
	
	boolean saveEmployee(Employee employee);

	boolean deleteEmployee(Employee employee);

	Employee updateEmployee(Employee employee);
	
	Employee findFullById(long id);

	Employee findEmployeeById(long id);

	public List<Employee> findAllEmployees();
	
	public long countEmployee();
	
	public List<Employee> betweenSalatryEpmloyess(double minSalary,double maxSalary);
	
	public List<Employee> findEpmloyessFirstMax(int fist,int max);

}
