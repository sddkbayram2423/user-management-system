package com.bayram.service.user;

import java.util.Date;

import java.util.List;

import com.bayram.model.user.PasswordResetToken;
import com.bayram.model.user.User;


public interface PasswordResetTokenService {
	
	PasswordResetToken savePasswordResetToken(PasswordResetToken passwordResetToken);

	PasswordResetToken deletePasswordResetToken(PasswordResetToken PasswordResetToken);
	
	PasswordResetToken updatePasswordResetToken(PasswordResetToken PasswordResetToken);

	PasswordResetToken findPasswordResetTokenById(long passwordResetTokenID);
	
	PasswordResetToken findPasswordResetTokenByUser(User user);
	
	PasswordResetToken findPasswordResetTokenByToken(String token);

	public List<PasswordResetToken> findAllByExpiredDataLessThan(Date date);

	boolean deleteAllByExpiredSince(Date date);

}
