package com.bayram.dao.user.Imp;

import java.util.List;







import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bayram.dao.user.UserRepository;
import com.bayram.model.user.User;

@Repository
@Transactional
public class UserRepositoryImp implements  UserRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public User saveUser(User user) {
		try {
			entityManager.persist(user);
			return user;
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public User deleteUser(User user) {
		System.out.println("Contains: "+entityManager.contains(user));
		try {
			if (entityManager.contains(user)) {
				entityManager.remove(user);
				return user;
			}
			User user2=findUserById(user.getId());
			entityManager.remove(user2);
			return user;
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
	
	}

	@Override
	public User updateUser(User user) {
		
		try {
			return entityManager.merge(user);
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
		
		
	}

	@Override
	public User findUserById(long id) {
		
		try {
			return entityManager.find(User.class, id);
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public User findUserByUserName(String name){
		
		
		try {
			TypedQuery<User> query=entityManager.createNamedQuery("User.findUserByUserName", User.class);
			query.setParameter("username", name);
			return query.getSingleResult();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public User findUserByEmail(String email) {
		
		try {
			TypedQuery<User> query=entityManager.createNamedQuery("User.findUserByEmail", User.class);
			query.setParameter("email", email);
			return query.getSingleResult();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public List<User> findAllUsers() {
		
		try {
			return entityManager.createNamedQuery("User.findAll", User.class).getResultList();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
	
	}

	@Override
	public void updatePassword(String password, long id) {
		try {
			entityManager.createNamedQuery("User.updatePassword", User.class)
						.setParameter("password", password)
						.setParameter("id", id);
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			
		}
		
	}


}
