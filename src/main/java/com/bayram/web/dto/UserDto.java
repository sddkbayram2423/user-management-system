package com.bayram.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


import javax.validation.constraints.Size;



import com.bayram.validator.annotation.PasswordMatches;
//User Data Transfer Object
@PasswordMatches(first = "password", second = "matchingPassword")
public class UserDto {
	
	
	@NotNull(message = "Firstname field cant be empty")
	@Size(min = 3,max = 25,message = "Firstname must be between 3-25 letter")
	private String fistname;
	
	
	@NotNull(message = "Lastname field cant be empty")
	@Size(min = 3,max = 25,message = "Lastname must be between 3-25 letter")
	private String lastname;
	
	

	@Size(min = 4,message = "Username minimum  size must be {min}")
	@NotNull(message = "Username field cant be empty")
	private String username;
	
	@Email(message = "Invalid email")
	@NotNull(message = "Email field cant be empty")
	private String email;
	
	
	@Size(min = 4,message = "Password size must be min {min} ")
	@NotNull(message = "Your password field cant be empty")
	private String password;

	
	@Size(min = 4,message = "Password size must be min {min} ")
	@NotNull(message = "Your password repeat field cant be empty")
	private String matchingPassword;
	
	public UserDto() {
	}

	public UserDto(String fistname, String lastname, String username, String email, String password,
			String matchingPassword) {
		this.fistname = fistname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.matchingPassword = matchingPassword;
	}

	public String getFistname() {
		return fistname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setFistname(String fistname) {
		this.fistname = fistname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	@Override
	public String toString() {
		return "UserDto [fistname=" + fistname + ", lastname=" + lastname + ", username=" + username + ", email="
				+ email + ", password=" + password + ", matchingPassword=" + matchingPassword + "]";
	}
	
	
	

}
