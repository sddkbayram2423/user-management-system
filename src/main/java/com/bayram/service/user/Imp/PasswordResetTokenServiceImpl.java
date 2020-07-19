package com.bayram.service.user.Imp;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayram.dao.user.PasswordResetTokenRepository;
import com.bayram.model.user.PasswordResetToken;
import com.bayram.model.user.User;
import com.bayram.service.user.PasswordResetTokenService;
@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService{
	
	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;

	@Override
	public PasswordResetToken savePasswordResetToken(PasswordResetToken passwordResetToken) {
		return passwordResetTokenRepository.savePasswordResetToken(passwordResetToken);
	}

	@Override
	public PasswordResetToken deletePasswordResetToken(PasswordResetToken PasswordResetToken) {
		return passwordResetTokenRepository.deletePasswordResetToken(PasswordResetToken);
	}

	@Override
	public PasswordResetToken updatePasswordResetToken(PasswordResetToken PasswordResetToken) {
		return passwordResetTokenRepository.updatePasswordResetToken(PasswordResetToken);
	}

	@Override
	public PasswordResetToken findPasswordResetTokenById(long passwordResetTokenID) {
		return passwordResetTokenRepository.findPasswordResetTokenById(passwordResetTokenID);
	}

	@Override
	public PasswordResetToken findPasswordResetTokenByUser(User user) {
		return passwordResetTokenRepository.findPasswordResetTokenByUser(user);
	}

	@Override
	public PasswordResetToken findPasswordResetTokenByToken(String token) {
		return passwordResetTokenRepository.findPasswordResetTokenByToken(token);
	}

	@Override
	public List<PasswordResetToken> findAllByExpiredDataLessThan(Date date) {
		return passwordResetTokenRepository.findAllByExpiredDataLessThan(date);
	}

	@Override
	public boolean deleteAllByExpiredSince(Date date) {
		return passwordResetTokenRepository.deleteAllByExpiredSince(date);
	}

}
