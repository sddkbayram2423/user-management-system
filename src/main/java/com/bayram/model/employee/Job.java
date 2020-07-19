package com.bayram.model.employee;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@NamedQueries({
	@NamedQuery(name = "Job.findAll",query = "FROM Job"),
	@NamedQuery(name = "Job.findByTitle",query = "SELECT j FROM Job j LEFT OUTER JOÝN FETCH j.employees WHERE j.title=:title"),
	@NamedQuery(name = "Job.findAllJobTitle",query = "SELECT title FROM Job"),
	@NamedQuery(name = "Job.findEmployeesById",query = "SELECT j FROM Job j LEFT OUTER JOÝN FETCH j.employees WHERE j.id=:id"),
})
public class Job implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id")
	private long id;
	
	@Lob
	@NotNull(message = "Title field cant be empty")
	@Size(min = 4,max = 150,message = "Title must be between {min}-{max} letter")
	private String title;
	
	
	@NotNull(message = "Minsalary field cant be empty")
	@NumberFormat(style = Style.NUMBER)
	private double minSalary;
	
	
	@NotNull(message = "Maxsalary field cant be empty")
	@NumberFormat(style = Style.NUMBER)
	private double maxSalary;
	
	
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},mappedBy = "job",fetch = FetchType.LAZY)
	private List<Employee> employees;
	
	public Job() {
	}

	public Job(String title, double minSalary, double maxSalary) {
		this.title = title;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}

	public double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
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
		Job other = (Job) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", minSalary=" + minSalary + ", maxSalary=" + maxSalary+"]";
	}
	
	
	
	
	
}
