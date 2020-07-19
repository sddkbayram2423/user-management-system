package com.bayram.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bayram.validator.annotation.PasswordMatches;

@PasswordMatches(first = "newPassword", second = "newMatchingPassword")
public class NewPasswordDto {
	
	private long userId;
	
	
	@Size(min = 4,message = "Password size must be min {min} ")
	@NotNull(message = "Your password repeat field cant be empty")
	private String newPassword;
	
	@Size(min = 4,message = "Password size must be min {min} ")
	@NotNull(message = "Your password repeat field cant be empty")
	private String newMatchingPassword;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewMatchingPassword() {
		return newMatchingPassword;
	}

	public void setNewMatchingPassword(String newMatchingPassword) {
		this.newMatchingPassword = newMatchingPassword;
	}
	
	

}
