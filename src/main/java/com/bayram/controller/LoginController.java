package com.bayram.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bayram.model.user.User;
import com.bayram.service.user.UserService;
import com.bayram.web.dto.UserLogin;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	
	
	//------------------------------------------------/controller/login/userLogin---------------------------------------------
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("userLogin") @Validated  UserLogin userLogin, BindingResult result) {
		
		
		String rawPassword=userLogin.getPassword();
		String userName=userLogin.getUsername();
		
		
		if(result.hasErrors()) {
			return new ModelAndView("goLoginPage","userLogin",userLogin);
			
		}
		User user=userService.findUserByUserName(userName);
		
		if(user!=null) {
			if(userService.checkIfValidOldPassword(user, rawPassword)&&(user!=null)) {
				
				if(user.getRole().getName().equals("ADMIN")) {
					
					return new ModelAndView("login_for_admin","user",user);
					
				}
				if(user.getRole().getName().equals("USER")) {
					
					return new ModelAndView("login_for_user","user",user);
					
				}
			}
		}
		return new ModelAndView("goLoginPage","userLogin",userLogin);
		
	}
	
	
	
	
	

}
