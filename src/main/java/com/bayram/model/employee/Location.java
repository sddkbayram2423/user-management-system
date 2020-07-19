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
import javax.persistence.OneToMany;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


@Entity
@NamedQueries({
	@NamedQuery(name = "Location.findAll",query = "FROM Location"),	
	@NamedQuery(name = "Location.findLocationAndDepartmensById",query = "SELECT l FROM Location l LEFT OUTER JOÝN FETCH l.departments WHERE l.id=:id")
})
public class Location implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id")
	private long id;
	
	@Column(length = 50)
	private String street;
	
	@Column
	private int postCode;
	
	
	@Column
	private String city;
	
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.REFRESH},mappedBy = "location",fetch = FetchType.LAZY)
	private List<Department> departments=new ArrayList<>();
	
	public Location() {
	}

	public Location(String street, int postCode, String city) {
		this.street = street;
		this.postCode = postCode;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
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
		Location other = (Location) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", street=" + street + ", postCode=" + postCode + ", city=" + city + "]";
	}
	
	
	
	

}
