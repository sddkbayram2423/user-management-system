package com.bayram.dao.employee.Imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bayram.dao.epmloyee.LocationRepository;
import com.bayram.model.employee.Location;

@Repository
@Transactional(isolation = Isolation.DEFAULT, rollbackFor = { RuntimeException.class, Throwable.class })
public class LocationRepositoryImp implements LocationRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean saveLocation(Location location) {

		try {
			entityManager.persist(location);
			return true;
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return false;
		}

	}

	@Override
	public boolean deleteLocation(Location location) {
		try {
			if (entityManager.contains(location)) {
				entityManager.remove(location);
			} else {
				Location location2 = findLocationById(location.getId());
				entityManager.remove(location2);
			}
			return true;
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return false;
		}

	}

	@Override
	public Location updateLocation(Location location) {
		try {
			return entityManager.merge(location);
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}

	}

	@Override
	public Location findLocationAndDepartmensById(long locationId) {
		try {
			TypedQuery<Location> query = entityManager.createNamedQuery("Location.findLocationAndDepartmensById",
					Location.class);
			query.setParameter("id", locationId);
			return query.getSingleResult();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}

	}

	@Override
	public List<Location> findAllLocations() {
		try {
			return entityManager.createNamedQuery("Location.findAll", Location.class).getResultList();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}

	}

	@Override
	public Location findLocationById(long locationId) {
		try {
			return entityManager.find(Location.class, locationId);
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}

	}

}
