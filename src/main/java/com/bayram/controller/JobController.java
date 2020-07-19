package com.bayram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bayram.model.employee.Job;
import com.bayram.service.employee.JobService;

@Controller
@RequestMapping("job")
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	
	
	
	
	//------------------------------------------------/controller/job/jobListForAdmin---------------------------------------------
	
	@RequestMapping(value = "/jobListForAdmin", method = RequestMethod.GET)
	public ModelAndView jobListForAdmin() {
		
		return new ModelAndView("getJoblistForAdmin", "jobs", jobService.findAllJobs());
	}
	
	
	
	
	
	//------------------------------------------------/controller/job/jobListForUser---------------------------------------------
	
	@RequestMapping(value = "/jobListForUser", method = RequestMethod.GET)
	public ModelAndView jobListForUser() {
		
		return new ModelAndView("getJoblistForUser", "jobs", jobService.findAllJobs());
	}
	
	
	
	
	
	//------------------------------------------------/controller/job/detailJob---------------------------------------------
	
	@RequestMapping(value = "/detailJob", method = RequestMethod.GET)
	public ModelAndView detailJob(@RequestParam("id") long id) {
		
		
		return new ModelAndView("detailJobForAdmin", "job", jobService.findEmployeesById(id));
	}
	
	
	
	
	
	
	
	//------------------------------------------------/controller/job/addNewJob---------------------------------------------
	
	@RequestMapping(value = "/addNewJob", method = RequestMethod.GET)
	public ModelAndView addNewJob() {
		
		return new ModelAndView("addNewJobForAdmin", "job", new Job());
	}

	
	
	
	
	
	//------------------------------------------------/controller/job/addNewJob---------------------------------------------
	
	@RequestMapping(value = "/addNewJob", method = RequestMethod.POST)
	public ModelAndView saveJob(@Validated @ModelAttribute("job") Job job,BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("addNewJobForAdmin", "job", job);
		}
		
		
		jobService.saveJob(job);
		
		return new ModelAndView("redirect:jobListForAdmin");
	}
}
