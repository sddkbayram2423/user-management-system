package com.bayram.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class PasswordForgotDto {
	
	
	@Email(message = "Invalid email")
	@NotNull(message = "Email field cant be empty")
	private String email;
	
	public PasswordForgotDto() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "PasswordForgotDto [email=" + email + "]";
	}

	
	
	
	

}
