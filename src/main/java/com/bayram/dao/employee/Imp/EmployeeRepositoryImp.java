package com.bayram.dao.employee.Imp;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bayram.dao.epmloyee.EmployeeRepository;
import com.bayram.model.employee.Employee;

@Repository
@Transactional(isolation = Isolation.DEFAULT,rollbackFor = {RuntimeException.class,Throwable.class})
public class EmployeeRepositoryImp implements EmployeeRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean saveEmployee(Employee employee) {
		

		
		try {
			entityManager.persist(employee);
			return true;
			
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return false;
		}
	
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		
		try {
			if(entityManager.contains(employee)) {
				entityManager.remove(employee);
			}
			Employee employee2=findFullById(employee.getId());
			
			entityManager.remove(employee2);
			
			return true;
		} catch (Exception e) {
			
			System.out.println("Delete Error: "+e.getLocalizedMessage());
			return false;

			
		}
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		try {
			return entityManager.merge(employee);
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return  null;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findEmployeeById(long id) {
		
		if(id<0) {
			return null;	 
		}
		
		try {
			return entityManager.find(Employee.class, id);
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Employee> findAllEmployees() {
		try {
			return entityManager.createNamedQuery("Employee.findAll", Employee.class).getResultList();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public long countEmployee() {
		try {
			return entityManager.createNamedQuery("Employee.count", Long.class).getSingleResult();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return 0;
		}
		
	}

	@Override
	public List<Employee> betweenSalatryEpmloyess(double minSalary, double maxSalary) {
		try {
			return entityManager.createNamedQuery("Employee.betweenSalary",Employee.class)
					.setParameter("minSalary", minSalary)
					.setParameter("maxSalary", maxSalary)
					.getResultList();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
		
				
	}

	@Override
	public List<Employee> findEpmloyessFirstMax(int fist, int max) {
		try {
			return entityManager.createNamedQuery( "Employee.findAll", Employee.class)
					.setFirstResult(fist)
					.setMaxResults(max)
					.getResultList();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
		
	}

	@Override
	public Employee findFullById(long id) {
		if(id<0) {
			return null;	 
		}
		
		try {
			TypedQuery<Employee> query=entityManager.createNamedQuery("Employee.findFullById", Employee.class);
			query.setParameter("id", id);
			return query.getSingleResult();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
		
	}
}
