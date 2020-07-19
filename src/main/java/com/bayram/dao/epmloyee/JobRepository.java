package com.bayram.dao.epmloyee;

import java.util.List;


import com.bayram.model.employee.Job;




public interface JobRepository {
	
	boolean saveJob(Job job);

	boolean deleteJob(Job job);

	Job updateJob(Job job);

	Job findJobById(long jobid);
	
	Job findByTitle(String title);

	public List<Job> findAllJobs();

	public List<String> findJobByTitles();
	
	Job findEmployeesById(long id);

}
