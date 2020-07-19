package com.bayram.service.user.Imp;

import java.util.Calendar;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayram.dao.user.UserRepository;
import com.bayram.dao.user.VerificationTokenRepository;
import com.bayram.model.user.User;
import com.bayram.model.user.VerificicationToken;
import com.bayram.service.user.VerificationTokenService;
@Service
public class VerificationTokenServiceImp implements VerificationTokenService {
	
	@Autowired
	private VerificationTokenRepository verificationTokenRepository;
	
	@Autowired
	private UserRepository userRepository;
	private static final String TOKEN_INVALID="invalidToken";
	private static final String TOKEN_VALID="valid";
	private static final String TOKEN_EXPIRED="expired";
	
	
	@Override
	public String validateVerificationToken(String token) {
		
		
			VerificicationToken verificicationToken=verificationTokenRepository.findVerificicationTokenByToken(token);
			
			if (verificicationToken==null) {
				return TOKEN_INVALID;
			}
			
			
			Calendar calendar=Calendar.getInstance();
			if(verificicationToken.getExpiryDate().getTime()-calendar.getTime().getTime()<=0) {
				return TOKEN_EXPIRED;
			}
			
			
			User user=verificicationToken.getUser();
			System.out.println("User: "+user);
			user.setEnabled(true);
			user.setAccountNonExpired(false);
			userRepository.updateUser(user);
			
			return TOKEN_VALID;
	
		
	}
	@Override
	public VerificicationToken saveVerificicationToken(VerificicationToken token) {
		
		
		
		
		return verificationTokenRepository.saveVerificicationToken(token);
	}

	@Override
	public VerificicationToken deleteVerificicationToken(VerificicationToken token) {
		return verificationTokenRepository.deleteVerificicationToken(token);
	}

	@Override
	public VerificicationToken updateVerificicationToken(VerificicationToken token) {
		return verificationTokenRepository.updateVerificicationToken(token);
	}

	@Override
	public VerificicationToken findVerificicationTokenByToken(String token) {
		return verificationTokenRepository.findVerificicationTokenByToken(token);
	}

	@Override
	public VerificicationToken findVerificicationTokenByUser(User user) {
		return verificationTokenRepository.findVerificicationTokenByUser(user);
	}

	@Override
	public List<VerificicationToken> findAllByExpiredDataLessThan(Date date) {
		return verificationTokenRepository.findAllByExpiredDataLessThan(date);
	}

	@Override
	public VerificicationToken findVerificicationTokenById(long passwordResetTokenID) {
		return verificationTokenRepository.findVerificicationTokenById(passwordResetTokenID);
	}

	@Override
	public boolean deleteAllByExpiredSince(Date date) {
		return verificationTokenRepository.deleteAllByExpiredSince(date);
	}

	

}
