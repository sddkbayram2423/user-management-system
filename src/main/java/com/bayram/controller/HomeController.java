package com.bayram.controller;




import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bayram.web.dto.UserDto;
import com.bayram.web.dto.UserLogin;

@Controller
public class HomeController {
	
	//------------------------------------------------/controller/---------------------------------------------
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	//------------------------------------------------/controller/loginForm---------------------------------------------
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		
		
		return new ModelAndView("goLoginPage","userLogin",new UserLogin());
	}
	
	//------------------------------------------------/controller/registerForm---------------------------------------------
	
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public ModelAndView registerPage() {
		
		
		return new ModelAndView("goRegisterPage","userDto",new UserDto());
	}
	

	

	
	
	

}
