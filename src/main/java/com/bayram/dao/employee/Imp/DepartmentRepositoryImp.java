package com.bayram.dao.employee.Imp;

import java.util.List;




import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bayram.dao.epmloyee.DepartmentRepository;
import com.bayram.model.employee.Department;

@Repository
@Transactional(isolation = Isolation.DEFAULT,rollbackFor = {RuntimeException.class,Throwable.class})
public class DepartmentRepositoryImp implements DepartmentRepository {
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean saveDepartment(Department department) {
		try {
			entityManager.persist(department);
			return true;
		} catch (Exception e) {
			
			System.err.println("Error : "+e.getMessage());
			return false;
		}
		
	}

	@Override
	public boolean deleteDepartment(Department department) {
		
		try {
			Department deleteDep=findDepartmentById(department.getId());
			entityManager.remove(deleteDep);
			return true;
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return false;
		}
	}

	@Override
	public Department updateDepartment(Department department) {
		try {
			Department upDateDep=entityManager.merge(department);
			entityManager.flush();
			return upDateDep;
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
			
		}
	
	}

	@Override
	public Department findDepartmentById(long departmentId) {
		try {
			return entityManager.find(Department.class, departmentId);
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
		
	}

	@Override
	public List<Department> findAllDepartments() {
		
		try {
			TypedQuery<Department> typedQuery=entityManager.createNamedQuery( "Department.findAll", Department.class);
			return typedQuery.getResultList();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	
	}

	@Override
	public List<String> findDepartmentNames() {
		try {
			TypedQuery<String> typedQuery=entityManager.createNamedQuery( "Department.findDepartmentNames", String.class);
			return typedQuery.getResultList();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
		
	}

	@Override
	public Department findLocationAndEmployeesByDepartmentId(long departmentId) {
		
		try {
			TypedQuery<Department> typedQuery=entityManager.createNamedQuery("Department.findLocationAndEmployeesByDepartmentId", Department.class);
			typedQuery.setParameter("id", departmentId);
			return typedQuery.getSingleResult();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public Department findByDepartmentName(String name) {
		try {
			TypedQuery<Department> typedQuery=entityManager.createNamedQuery("Department.findByDepartmentName", Department.class);
			typedQuery.setParameter("name", name);
			return typedQuery.getSingleResult();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
	}

}
