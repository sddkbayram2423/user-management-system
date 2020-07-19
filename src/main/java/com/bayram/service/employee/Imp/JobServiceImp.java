package com.bayram.service.employee.Imp;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayram.dao.epmloyee.JobRepository;
import com.bayram.model.employee.Job;
import com.bayram.service.employee.JobService;
@Service
public class JobServiceImp implements JobService {
	
	@Autowired
	private  JobRepository  jobRepository;
	
	@Override
	public boolean saveJob(Job job) {
		return jobRepository.saveJob(job);
	}

	@Override
	public boolean deleteJob(Job job) {
		return jobRepository.deleteJob(job);
	}

	@Override
	public Job updateJob(Job job) {
		return jobRepository.updateJob(job);
	}

	@Override
	public Job findJobById(long jobid) {
		return jobRepository.findJobById(jobid);
	}

	@Override
	public List<Job> findAllJobs() {
		return jobRepository.findAllJobs();
	}

	@Override
	public List<String> findJobByTitles() {
		return jobRepository.findJobByTitles();
	}

	@Override
	public Job findEmployeesById(long id) {
		return jobRepository.findEmployeesById(id);
	}

	@Override
	public Job findByTitle(String title) {
		return jobRepository.findByTitle(title);
	}

}
