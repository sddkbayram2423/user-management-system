package com.bayram.dao.epmloyee;

import java.util.List;

import com.bayram.model.employee.Employee;



public interface EmployeeRepository {
	
	boolean saveEmployee(Employee employee);

	boolean deleteEmployee(Employee employee);

	Employee findFullById(long id);
	
	Employee updateEmployee(Employee employee);

	Employee findEmployeeById(long id);

	public List<Employee> findAllEmployees();
	
	public long countEmployee();
	
	public List<Employee> betweenSalatryEpmloyess(double minSalary,double maxSalary);
	
	public List<Employee> findEpmloyessFirstMax(int fist,int max);
}
