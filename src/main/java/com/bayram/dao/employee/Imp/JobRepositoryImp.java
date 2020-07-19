package com.bayram.dao.employee.Imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bayram.dao.epmloyee.JobRepository;
import com.bayram.model.employee.Job;

@Repository
@Transactional(isolation = Isolation.DEFAULT, rollbackFor = { RuntimeException.class, Throwable.class })
public class JobRepositoryImp implements JobRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean saveJob(Job job) {

		try {
			entityManager.persist(job);
			return true;
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return false;
		}

	}

	@Override
	public boolean deleteJob(Job job) {

		try {
			if (entityManager.contains(job)) {
				entityManager.remove(job);
			} else {
				Job job2 = findJobById(job.getId());
				entityManager.remove(job2);
			}
			return true;
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return false;
		}

	}

	@Override
	public Job updateJob(Job job) {
		try {
			return entityManager.merge(job);
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}

	}

	@Override
	public Job findJobById(long jobid) {
		try {
			return entityManager.find(Job.class, jobid);
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}

	}

	@Override
	public List<Job> findAllJobs() {
		try {
			return entityManager.createNamedQuery("Job.findAll", Job.class).getResultList();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}

	}

	@Override
	public List<String> findJobByTitles() {
		try {
			return entityManager.createNamedQuery("Job.findAllJobTitle", String.class).getResultList();

		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
	}

	@Override
	public Job findEmployeesById(long id) {
		try {
			TypedQuery<Job> query = entityManager.createNamedQuery("Job.findEmployeesById", Job.class);
			query.setParameter("id", id);
			return query.getSingleResult();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}

	}
	@Override
	public Job findByTitle(String title) {
		try {
			TypedQuery<Job> query = entityManager.createNamedQuery("Job.findByTitle", Job.class);
			query.setParameter("title", title);
			return query.getSingleResult();
		} catch (Exception e) {
			System.err.println("Error : "+e.getMessage());
			return null;
		}
	}

}
