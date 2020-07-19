package com.bayram.dao.user.Imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bayram.dao.user.RoleRepository;
import com.bayram.model.user.Role;

@Repository
@Transactional
public class RoleRepositoryImp implements RoleRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Role saveRole(Role role) {
		try {
			entityManager.persist(role);
			return role;
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}

	}

	@Override
	public Role deleteRole(Role role) {
		try {
			if (entityManager.contains(role)) {
				entityManager.remove(role);
				return role;
			}
			Role role2 = findRoleById(role.getId());
			entityManager.remove(role2);
			return role2;
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}

	}

	@Override
	public Role updateRole(Role role) {
		try {
			return entityManager.merge(role);
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}

	}

	@Override
	public Role findRoleById(long id) {
		try {
			return entityManager.find(Role.class, id);
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}

	}

	@Override
	public Role findRoleByName(String name) {

		if (name == null || name.trim().length() <= 0) {
			return null;
		}

		try {
			TypedQuery<Role> query = entityManager.createNamedQuery("Role.findRoleByName", Role.class)
					.setParameter("name", name);
			return query.getSingleResult();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}

	}

	@Override
	public List<Role> findAllRoles() {
		try {
			return entityManager.createNamedQuery("Role.findAll", Role.class).getResultList();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}

	}

}
