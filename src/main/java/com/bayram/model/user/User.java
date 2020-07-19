package com.bayram.model.user;

import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "user")
@NamedQueries({
	@NamedQuery(name = "User.findAll",query = "SELECT u FROM User u"),
	@NamedQuery(name = "User.updatePassword",query = "UPDATE User u set u.password = :password where u.id = :id"),
	@NamedQuery(name = "User.findUserByUserName",query = "SELECT u FROM User u WHERE u.username=:username"),
	@NamedQuery(name = "User.findUserByEmail",query = "SELECT u FROM User u WHERE u.email=:email")
	})
public class User implements Serializable{
	
	//--------------------------------------------------------
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;
	
	@Column
	@NotNull(message = "Firstname field cant be empty")
	@Size(min = 3,max = 25,message = "Firstname must be between 3-25 letter")
	private String fistname;
	
	@Column
	@NotNull(message = "Lastname field cant be empty")
	@Size(min = 3,max = 25,message = "Lastname must be between 3-25 letter")
	private String lastname;
	
	@Column(unique = true,nullable = false)
	@Size(min = 4,message = "Username minimum  size must be {min}")
	@NotNull(message = "Username field cant be empty")
	private String username;
	
	@Column(unique = true)
	@Email(message = "Invalid email")
	@NotNull(message = "Email field cant be empty")
	private String email;
	
	@Column(length = 75,nullable = false)
	@Size(min = 4,message = "Password size must be min {min} ")
	private String password;
	
	private boolean enabled;
	
	private boolean accountNonExpired;
	
	private boolean credentialsNoneExpired;
	
	private boolean accountNonLocked;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	//--------------------------------------------------------
	
	public User() {
		this.accountNonExpired=true;
		this.accountNonLocked=true;
		this.enabled=false;
		this.credentialsNoneExpired=true;
		
	}
	
	public User(String fistname, String lastname, String username, String email, String password) {
		this.fistname = fistname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
		
		this.accountNonExpired=true;
		this.accountNonLocked=true;
		this.enabled=false;
		this.credentialsNoneExpired=true;
		
	}
	
	//--------------------------------------------------------
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFistname() {
		return fistname;
	}
	public void setFistname(String fistname) {
		this.fistname = fistname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public boolean isCredentialsNoneExpired() {
		return credentialsNoneExpired;
	}
	public void setCredentialsNoneExpired(boolean credentialsNoneExpired) {
		this.credentialsNoneExpired = credentialsNoneExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	//--------------------------------------------------------
	@Override
	public String toString() {
		return "User [id=" + id + ", fistname=" + fistname + ", lastname=" + lastname + ", username=" + username
				+ ", email=" + email + ", password=" + password + ", enabled=" + enabled + ", accountNonExpired="
				+ accountNonExpired + ", credentialsNoneExpired=" + credentialsNoneExpired + ", accountNonLocked="
				+ accountNonLocked +  "]";
	}
	
	

}
