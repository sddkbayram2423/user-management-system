package com.bayram.web.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLogin {
	
	
	@Size(min = 4,message = "Username minimum  size must be {min}")
	@NotNull(message = "Username field cant be empty")
	private String username;
	
	
	@NotEmpty(message = "Password field cant be empty")
	@Size(max = 16,min = 4,message = "Password size must be between {min} -{max}")
	private String password;
	
	public UserLogin() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLogin [username=" + username + ", password=" + password + "]";
	}
	
	

}
