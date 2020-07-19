package com.bayram.model.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name = "privilige")
@NamedQueries({
	@NamedQuery(name = "Privilige.findAll",query = "FROM Privilige"),
	@NamedQuery(name = "Privilige.findPriviligeByName",query =  "FROM Privilige WHERE name=:name" ),
	
})
public class Privilige implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "privilige_id")
	private long id;
	
	@Column
	private String name;
	
	@ManyToMany(mappedBy = "priviliges")
	private List<Role> roles=new ArrayList<>();
	
	public Privilige() {
	}

	public Privilige(String name) {
		this.name = name;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
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
		Privilige other = (Privilige) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Privilige [id=" + id + ", name=" + name + ", roles=" + roles + "]";
	}
	
	


}
