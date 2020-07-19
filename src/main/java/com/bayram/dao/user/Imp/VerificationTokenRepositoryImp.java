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

import com.bayram.dao.user.VerificationTokenRepository;
import com.bayram.model.user.User;
import com.bayram.model.user.VerificicationToken;
@Repository
@Transactional
public class VerificationTokenRepositoryImp implements VerificationTokenRepository {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public VerificicationToken saveVerificicationToken(VerificicationToken token) {
		try {
			entityManager.persist(token);
			return token;
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public VerificicationToken deleteVerificicationToken(VerificicationToken token) {
		try {
			 if (entityManager.contains(token)) {
					entityManager.remove(token);
					return token;
				}
				VerificicationToken token2=findVerificicationTokenByToken(token.getToken());
				entityManager.remove(token2);
				return token2;
			
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
		
	}

	@Override
	public VerificicationToken updateVerificicationToken(VerificicationToken token) {
		try {
			return entityManager.merge(token);
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public VerificicationToken findVerificicationTokenByToken(String token) {
		try {
			TypedQuery<VerificicationToken> query=entityManager.createNamedQuery("VerificicationToken.findByToken",VerificicationToken.class);
			query.setParameter("token", token);
			return query.getSingleResult();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public VerificicationToken findVerificicationTokenByUser(User user) {
		try {
			TypedQuery<VerificicationToken> query=entityManager.createNamedQuery("VerificicationToken.findByUserId",VerificicationToken.class);
			query.setParameter("id", user.getId());
			return query.getSingleResult();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
	
	}

	@Override
	public List<VerificicationToken> findAllByExpiredDataLessThan(Date date) {
		try {
			TypedQuery<VerificicationToken> query=entityManager.createNamedQuery("VerificicationToken.findAllByExpiredDataLessThan",VerificicationToken.class);
			query.setParameter("expiryDate", date);
			return query.getResultList();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
	
	}

	@Override
	public VerificicationToken findVerificicationTokenById(long passwordResetTokenID) {
		try {
			return entityManager.find(VerificicationToken.class, passwordResetTokenID);
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public boolean deleteAllByExpiredSince(Date date) {
		try {
			Query query=entityManager.createNamedQuery("VerificicationToken.deleteAllByExpiredSince");
			int count=query.setParameter("expiryDate", date,TemporalType.TIMESTAMP).executeUpdate();
			return count!=-1;
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return false;
		}

		
		
	}

}
