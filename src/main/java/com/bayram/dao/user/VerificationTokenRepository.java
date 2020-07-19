package com.bayram.dao.user;

import java.util.Date;

import java.util.List;

import com.bayram.model.user.User;
import com.bayram.model.user.VerificicationToken;

public interface VerificationTokenRepository {
	
	VerificicationToken saveVerificicationToken(VerificicationToken token);

	VerificicationToken deleteVerificicationToken(VerificicationToken token);
	
	VerificicationToken updateVerificicationToken(VerificicationToken token);
	
	VerificicationToken findVerificicationTokenByToken(String token);
	
	VerificicationToken findVerificicationTokenByUser(User user);
	
	public List<VerificicationToken> findAllByExpiredDataLessThan(Date date);

	VerificicationToken findVerificicationTokenById(long passwordResetTokenID);
	
	boolean deleteAllByExpiredSince(Date date);

}
