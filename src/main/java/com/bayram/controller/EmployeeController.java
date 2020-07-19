package com.bayram.controller;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bayram.model.employee.Department;
import com.bayram.model.employee.Employee;
import com.bayram.model.employee.Job;
import com.bayram.service.employee.DepartmentService;
import com.bayram.service.employee.EmployeeService;
import com.bayram.service.employee.JobService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private JobService jobService;
	
	
	//------------------------------------------------/controller/employee/employeeListForAdmin---------------------------------------------
	
	@RequestMapping(value = "/employeeListForAdmin",method = RequestMethod.GET)
	public ModelAndView employeeListForAdmin() {
		
		return new ModelAndView("getEmployeelistForAdmin", "employees", employeeService.findAllEmployees());
	}
	
	
	
	//------------------------------------------------/controller/employee/employeeListForUser------------------------------------------------------------------
	
	@RequestMapping(value = "/employeeListForUser",method = RequestMethod.GET)
	public ModelAndView employeeListForUser() {

		return new ModelAndView("getEmployeelistForUser", "employees", employeeService.findAllEmployees());
	}
	
	
	//------------------------------------------------/controller/employee/detailsEmployee------------------------------------------------------------------
	
	@RequestMapping(value = "/detailsEmployee",method = RequestMethod.GET)
	public ModelAndView detailsEmployee(@RequestParam("id")long id) {
		
		Employee employee=employeeService.findFullById(id);

		return new ModelAndView("detailsEmployee", "employee", employee);
	}
	
	
	//------------------------------------------------/controller/employee/deleteEmployee------------------------------------------------------------------
	
	@RequestMapping(value = "/deleteEmployee",method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@RequestParam("id")long id) {
		
		Employee employee=employeeService.findEmployeeById(id);
		
		System.out.println("Edlete: Empl: "+employee);
		employeeService.deleteEmployee(employee);
		
		return new ModelAndView("redirect:employeeListForAdmin");
	}
	
	
	//------------------------------------------------/controller/employee/editEmployee------------------------------------------------------------------
	
	@RequestMapping(value = "/editEmployee",method = RequestMethod.GET)
	public ModelAndView editEmployee(@RequestParam("id")long id) {
		
		Employee employee=employeeService.findFullById(id);
		
		return new ModelAndView("editEmployee",  "employee", employee);
	}
	
	
	//------------------------------------------------/controller/employee/updateEpmloyee------------------------------------------------------------------
	
	@RequestMapping(value = "/updateEpmloyee",method = RequestMethod.POST)
	public ModelAndView updateEpmloyee(@Validated @ModelAttribute("employee") Employee employee,BindingResult result) {

		if(result.hasErrors()) {
			return new ModelAndView("editEmployee",  "employee", employee);
		}
		
		
		Department department=departmentService.findByDepartmentName(employee.getDepartment().getName());
		Job job=jobService.findByTitle(employee.getJob().getTitle());
		
		employee.setDepartment(department);
		employee.setJob(job);
		
		employee.setHireDate(new Date());
		
		employeeService.updateEmployee(employee);
		
		
		
		
		return new ModelAndView("redirect:employeeListForAdmin");
	}
	
	
	
	//------------------------------------------------/controller/employee/addNewEmployee------------------------------------------------------------------
	
	@RequestMapping(value = "/addNewEmployee",method = RequestMethod.GET)
	public ModelAndView addNewEmployee() {

		
		return new ModelAndView("addNewEmployee", "employee", new Employee());
	}
	
	
	
	
	
	//------------------------------------------------/controller/employee/saveEpmloyee------------------------------------------------------------------
	
	@RequestMapping(value = "/saveEpmloyee",method = RequestMethod.POST)
	public ModelAndView saveEpmloyee(@Validated @ModelAttribute("employee") Employee employee,BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("addNewEmployee",  "employee", employee);
		}
		
		Department department=departmentService.findByDepartmentName(employee.getDepartment().getName());
		Job job=jobService.findByTitle(employee.getJob().getTitle());
		
		employee.setDepartment(department);
		employee.setJob(job);
		
		employeeService.saveEmployee(employee);

		return new ModelAndView("redirect:employeeListForAdmin");
	}

}
