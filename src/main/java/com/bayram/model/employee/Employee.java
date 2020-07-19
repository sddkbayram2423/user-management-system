package com.bayram.model.employee;

import java.io.Serializable;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
@Entity
@NamedQueries({
	@NamedQuery(name = "Employee.findAll",query = "FROM Employee"),
	@NamedQuery(name = "Employee.findFullById",query = "SELECT e FROM Employee e LEFT OUTER JOÝN FETCH e.job LEFT OUTER JOÝN FETCH e.department WHERE e.id=:id "),
	@NamedQuery(name = "Employee.count",query = "SELECT count(e) FROM Employee e"),
	@NamedQuery(name = "Employee.betweenSalary",query = "FROM Employee WHERE salary BETWEEN :minSalary  AND :maxSalary")
})
public class Employee implements Serializable {



	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private long id;
	
	@Column
	@NotNull(message = "Firstname field cant be empty")
	@Size(min = 3,max = 25,message = "Firstname must be between 3-25 letter")
	private String firstName;
	
	@Column
	@NotNull(message = "Lastname field cant be empty")
	@Size(min = 3,max = 25,message = "Lastname must be between 3-25 letter")
	private String lastName;
	
	@Column(unique = true)
	@Email(message = "Invalid email")
	@NotNull(message = "Email field cant be empty")
	private String email;
	
	@Column
	@NotNull(message = "Email field cant be empty")
	@Size(min=11,max = 11,message = "Phonenumber size must be {max}")
	private String phoneNumber;
	
	@Column
	@NotNull(message = "Salary field cant be empty")
	@NumberFormat(style = Style.NUMBER)
	private double salary;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "DD/MM/YY")
	private Date hireDate;
	
	@ManyToOne(targetEntity = Job.class)
	@JoinColumn(name="job_id")
	private Job job;
	
	@ManyToOne(targetEntity = Department.class)
	@JoinColumn(name="department_id")
	private Department department;
	
	public Employee() {
	}

	public Employee(String firstName, String lastName, String email, String phoneNumber, double salary, Date hireDate,
			Job job, Department department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
		this.hireDate = hireDate;
		this.job = job;
		this.department = department;
	}
	

	public Employee(String firstName, String lastName, String email, String phoneNumber, double salary, Date hireDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
		this.hireDate = hireDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", salary=" + salary + ", hireDate=" + hireDate + "]";
	}
	
	
	
	

}
