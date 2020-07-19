package com.bayram.dao.user.Imp;

import java.util.Date;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bayram.dao.user.PasswordResetTokenRepository;
import com.bayram.model.user.PasswordResetToken;
import com.bayram.model.user.User;

@Repository
@Transactional
public class PasswordResetTokenRepositoryImp implements PasswordResetTokenRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public PasswordResetToken savePasswordResetToken(PasswordResetToken passwordResetToken) {

		try {
			entityManager.persist(passwordResetToken);
			return passwordResetToken;
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public PasswordResetToken deletePasswordResetToken(PasswordResetToken passwordResetToken) {
		try {
			if (entityManager.contains(passwordResetToken)) {
				entityManager.remove(passwordResetToken);
				return passwordResetToken;
			}

			PasswordResetToken resetToken = findPasswordResetTokenById(passwordResetToken.getId());
			entityManager.remove(resetToken);
			return resetToken;
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public PasswordResetToken updatePasswordResetToken(PasswordResetToken passwordResetToken) {
		try {
			PasswordResetToken resetToken = entityManager.merge(passwordResetToken);
			entityManager.flush();
			return resetToken;
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public PasswordResetToken findPasswordResetTokenById(long passwordResetTokenID) {
		try {
			return entityManager.find(PasswordResetToken.class, passwordResetTokenID);
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}

		
	}

	@Override
	@Transactional(readOnly = true)
	public PasswordResetToken findPasswordResetTokenByUser(User user) {
		try {
			TypedQuery<PasswordResetToken> typedQuery = entityManager.createNamedQuery("PasswordResetToken.findByUserId",
					PasswordResetToken.class);
			typedQuery.setParameter("id", user.getId());
			return typedQuery.getSingleResult();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public PasswordResetToken findPasswordResetTokenByToken(String token) {
		try {
			TypedQuery<PasswordResetToken> typedQuery = entityManager.createNamedQuery("PasswordResetToken.findByToken",
					PasswordResetToken.class);
			typedQuery.setParameter("token", token);
			return typedQuery.getSingleResult();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<PasswordResetToken> findAllByExpiredDataLessThan(Date date) {
		try {
			TypedQuery<PasswordResetToken> typedQuery = entityManager
					.createNamedQuery("PasswordResetToken.findAllExpiredDateLessThan", PasswordResetToken.class);
			typedQuery.setParameter("expiryDate", date, TemporalType.TIMESTAMP);
			return typedQuery.getResultList();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public boolean deleteAllByExpiredSince(Date date) {
		try {
			Query query = entityManager.createNamedQuery("PasswordResetToken.deleteExpireyDateToken");
			query.setParameter("expiryDate", date, TemporalType.TIMESTAMP);
			int i = query.executeUpdate();
			return i != -1;
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return false;
		}
		
	}

}
