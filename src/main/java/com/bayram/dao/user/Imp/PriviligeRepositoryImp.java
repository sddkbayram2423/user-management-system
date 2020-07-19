package com.bayram.dao.user.Imp;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bayram.dao.user.PriviligeRepository;
import com.bayram.model.user.Privilige;

@Repository
@Transactional
public class PriviligeRepositoryImp implements PriviligeRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Privilige savePrivilige(Privilige privilige) {
		try {
			entityManager.persist(privilige);
			return privilige;	
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public Privilige deletePrivilige(Privilige privilige) {
		try {
			if (entityManager.contains(privilige)) {
				entityManager.remove(privilige);
				return privilige;
			}
				Privilige privilige2=findPriviligeById(privilige.getId());
				entityManager.remove(privilige2);
			return privilige2;
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public Privilige updatePrivilige(Privilige privilige) {
		try {
			return entityManager.merge(privilige);	
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
	
	}

	@Override
	public Privilige findPriviligeById(long id) {
		if(id<=0) {
			return null;
		}
		try {
			return entityManager.find(Privilige.class, id);
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
		
	}

	@Override
	public Privilige findPriviligeByName(String name) {
		try {
			TypedQuery<Privilige> typedQuery=entityManager.createNamedQuery("Privilige.findPriviligeByName", Privilige.class);
			typedQuery.setParameter("name", name);
			return typedQuery.getSingleResult();	
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

	@Override
	public List<Privilige> findAllPriviliges() {
		try {
			return entityManager.createNamedQuery("Privilige.findAll", Privilige.class).getResultList();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
		
	}

}
