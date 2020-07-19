package com.bayram.controller;


import java.text.DateFormat;



import java.util.Date;
import java.util.Locale;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bayram.model.user.Role;
import com.bayram.model.user.User;
import com.bayram.model.user.VerificicationToken;
import com.bayram.service.user.RoleService;
import com.bayram.service.user.UserService;
import com.bayram.service.user.VerificationTokenService;
import com.bayram.web.dto.UserDto;
import com.bayram.web.dto.UserLogin;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private VerificationTokenService verificationTokenService;
	
	//------------------------------------------------/controller/user/newUserForAdmin---------------------------------------------
	
	@RequestMapping(value = "/newUserForAdmin", method = RequestMethod.GET)
	public ModelAndView registerPage() {
		
		return new ModelAndView("newUserForAdmin", "userDto", new UserDto());
	}
	
	
	
	
	//------------------------------------------------/controller/user/newUser---------------------------------------------
	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public ModelAndView newUser() {
		
		return new ModelAndView("goRegisterPage", "userDto", new UserDto());
	}
	
	
	
	
	//------------------------------------------------/controller/user/listUsers---------------------------------------------
	
	@RequestMapping(value = "/listUsers", method = RequestMethod.GET)
	public ModelAndView listUsers() {
		
		return new ModelAndView("listUsersForAdmin", "users", userService.findAllUsers());
	}
	
	
	
	
	//------------------------------------------------/controller/user/editUserForAdmin---------------------------------------------
	
	@RequestMapping(value = "/editUserForAdmin", method = RequestMethod.GET)
	public ModelAndView editUser(@RequestParam("id") long id) {
		return new ModelAndView("editUserForAdmin","user",userService.findUserById(id));
	}
	
	
	
	//------------------------------------------------/controller/user/editUserForUser---------------------------------------------
	
	@RequestMapping(value = "/editUserForUser", method = RequestMethod.GET)
	public ModelAndView editUserForUser(@RequestParam("id") long id) {
		return new ModelAndView("editUserForUser", "user", userService.findUserById(id));
	}
	
	
	
	
	//------------------------------------------------/controller/user/updateUser---------------------------------------------
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ModelAndView updateUser(@Validated @ModelAttribute("user") User user,BindingResult result) {
		
		if(result.hasErrors()) {
			
			return new ModelAndView("editUserForAdmin","user",user);
		}
		
		Role role=roleService.findRoleByName(user.getRole().getName());
		user.setRole(role);
		
		userService.updateUser(user);
		return new ModelAndView("redirect:listUsers");
	}	
	
	
	
	//------------------------------------------------/controller/user/updateUserForUser---------------------------------------------
	
	@RequestMapping(value = "/updateUserForUser", method = RequestMethod.POST)
	public ModelAndView updateUserForUser(@Validated @ModelAttribute("user") User user,BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("editUserForUser", "user", user);
		}
		
		
		
		User user2=userService.findUserById(user.getId());
		
		String roleName=user2.getRole().getName();
		
		Role role=roleService.findRoleByName(roleName);
		
		user.setRole(role);
		userService.updateUser(user);
		return new ModelAndView("redirect:listUsers");
	}	
	
	
	
	
	
	//------------------------------------------------/controller/user/makeAktiveUser---------------------------------------------
	
	@RequestMapping(value = "/makeAktiveUser", method = RequestMethod.GET)
	public ModelAndView saveUser(@RequestParam("token")String token) {
		
		
		
		
		
		String validateToke=verificationTokenService.validateVerificationToken(token);
		
		if(validateToke!="valid") {
			return new ModelAndView("reset","message","Your verificication  token is "+validateToke);
		}
		else {
			VerificicationToken verificicationToken=verificationTokenService.findVerificicationTokenByToken(token);
			
			User user=verificicationToken.getUser();
			user.setEnabled(true);
			userService.updateUser(user);
			UserLogin userLogin=new UserLogin();
			userLogin.setUsername(user.getUsername());
			return new ModelAndView("goLoginPage", "userLogin", userLogin);
			
		}
		
	}	
	
	
	
	
	
	//------------------------------------------------/controller/user/saveUserForAdmin---------------------------------------------
	
	@RequestMapping(value = "/saveUserForAdmin", method = RequestMethod.POST)
	public ModelAndView saveUserForAdmin(@Validated @ModelAttribute("userDto") UserDto userDto,BindingResult result) {
		
		
		if(result.hasErrors()) {
			return new ModelAndView("newUserForAdmin", "userDto", userDto);
		}
		
		
		User user=userService.registerNewUser(userDto);
		if(user!=null) {
			return new ModelAndView("redirect:listUsers");
			
		}
		return new ModelAndView("newUserForAdmin", "userDto", new UserDto());
		
	}	
	
	
	
	
	
	
	//------------------------------------------------/controller/user/showProfile---------------------------------------------
	
	@RequestMapping(value = "/showProfile", method = RequestMethod.GET)
	public ModelAndView showMyProfile(@RequestParam("id") long id) {
		String statu="";
		User user=new User();
		user=userService.findUserById(id);
		Locale locale=new Locale("tr", "TR");
		DateFormat dateFormat=DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		if(user.isAccountNonExpired()) {
			statu="Active";
		}
		else {
			statu="Pasive";
		}
		ModelAndView modelAndView;
		
		if(user.getRole().getName().equals("ADMIN")) {
			
			modelAndView=new ModelAndView("showMyProfileForAdmin");
			modelAndView.addObject("date", dateFormat.format(new Date()));
			modelAndView.addObject("user",user);
			modelAndView.addObject("statu",statu);
			return modelAndView;
		}
		else {
			modelAndView=new ModelAndView("showMyProfileForUser");
			modelAndView.addObject("date", dateFormat.format(new Date()));
			modelAndView.addObject("user",user);
			modelAndView.addObject("statu",statu);
			return modelAndView;
			
		}
		
		
	}	

}
