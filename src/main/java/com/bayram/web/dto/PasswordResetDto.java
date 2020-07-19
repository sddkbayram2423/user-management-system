package com.bayram.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bayram.validator.annotation.PasswordMatches;

@PasswordMatches(first = "newPassword", second = "nwMatchingPassword",message = "Password' field cant be different")
public class PasswordResetDto {
	
	private long userId;
	

	@Size(min = 4,message = "Password size must be min {min} ")
	@NotNull(message = "Your password field cant be empty")
	private String oldPassword;
	
	

	@Size(min = 4,message = "Password size must be min {min} ")
	@NotNull(message = "Your new password cant be empty")
	private String newPassword;
	

	@Size(min = 4,message = "Password size must be min {min} ")
	@NotNull(message = "Your password repeat field cant be empty")
	private String nwMatchingPassword;
	
	public PasswordResetDto() {
	}

	public PasswordResetDto(String oldPassword, String newPassword, String nwMatchingPassword) {
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.nwMatchingPassword = nwMatchingPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public String getNwMatchingPassword() {
		return nwMatchingPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public void setNwMatchingPassword(String nwMatchingPassword) {
		this.nwMatchingPassword = nwMatchingPassword;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "PasswordResetDto [userId=" + userId + ", oldPassword=" + oldPassword + ", newPassword=" + newPassword
				+ ", nwMatchingPassword=" + nwMatchingPassword + "]";
	}
	
	
	

}
