package com.bayram.model.user;

import java.io.Serializable;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
@NamedQueries({
	@NamedQuery(name = "Role.findAll",query = "SELECT r FROM Role r"),	
	@NamedQuery(name = "Role.findRoleByName",query = "SELECT r FROM Role r WHERE r.name=:name")
})
public class Role implements Serializable {
	
	
	//--------------------------------------------------------
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private long id;
	
	
	private String name;
	
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(name = "roles_priviliges",
			joinColumns = {@JoinColumn(name ="role_id")}	,
			inverseJoinColumns = { @JoinColumn(name ="privilige_id")})	
	private List<Privilige> priviliges;
	
	
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},fetch =  FetchType.EAGER,mappedBy = "role")
	private List<User> users;
	
	//--------------------------------------------------------
	public Role() {
	}
	
	public Role(String name) {
		this.name = name;
	}
	
	
	//--------------------------------------------------------
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

	public List<Privilige> getPriviliges() {
		return priviliges;
	}

	public void setPriviliges(List<Privilige> priviliges) {
		this.priviliges = priviliges;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	//--------------------------------------------------------
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
		Role other = (Role) obj;
		if (id != other.id)
			return false;
		return true;
	}
	//--------------------------------------------------------
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name +  ", users=" + users + "]";
	}


}
