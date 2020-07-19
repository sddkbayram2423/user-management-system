package com.bayram.service.employee;

import java.util.List;


import com.bayram.model.employee.Job;

public interface JobService {
	
	boolean saveJob(Job job);

	boolean deleteJob(Job job);

	Job updateJob(Job job);

	Job findJobById(long jobid);
	
	Job findEmployeesById(long id);

	public List<Job> findAllJobs();

	public List<String> findJobByTitles();
	
	Job findByTitle(String title);

}
