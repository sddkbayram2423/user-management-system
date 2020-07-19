package com.bayram.model.employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@Entity
@NamedQueries({
	@NamedQuery(name = "Department.findAll",query = "FROM Department"),
	@NamedQuery(name = "Department.findByDepartmentName",query = "SELECT d FROM Department d WHERE d.name=:name"),
	@NamedQuery(name = "Department.findDepartmentNames",query = "SELECT name FROM Department"),
	@NamedQuery(name = "Department.findLocationAndEmployeesByDepartmentId",query = "SELECT d FROM Department d LEFT OUTER JOIN FETCH d.location "
			+ "LEFT OUTER JOIN FETCH d.employees WHERE d.id= :id"),
})
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private long id;
	
	@Column
	private String name;
	
	
	@ManyToOne(targetEntity = Location.class,fetch = FetchType.EAGER,cascade =CascadeType.ALL)
	@JoinColumn(name = "location_id")
	private Location location;
	
	
	@OneToMany( mappedBy = "department",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Employee> employees=new ArrayList<>();
	
	
	public Department() {}


	public Department(String name, Location location) {
		this.name = name;
		this.location = location;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}


	
	
	
	
	
	

}
