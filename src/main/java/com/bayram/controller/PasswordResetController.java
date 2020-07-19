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

import com.bayram.service.user.UserService;
import com.bayram.web.dto.PasswordResetDto;

@Controller
@RequestMapping("resetPassword")
public class PasswordResetController {
	
	
	@Autowired
	private UserService userService;
	
	
	//------------------------------/controller/resetPassword/goResetForm--------------------------------------------
	
	@RequestMapping(value = "/goResetForm",method = RequestMethod.GET)
	public ModelAndView goResetForm(@RequestParam("id")long id) {
		
		ModelAndView modelAndView=new ModelAndView("goResetFormPage");
		PasswordResetDto passwordResetDto=new PasswordResetDto();
		passwordResetDto.setUserId(id);
		
		modelAndView.addObject("passwordResetDto", passwordResetDto);
		System.out.println("p: "+passwordResetDto.getUserId());
		
		return modelAndView;
	}
	
	
	//------------------------------/controller/resetPassword/resetPassword--------------------------------------------
	
	@RequestMapping(value = "/resetPassword",method = RequestMethod.POST)
	public ModelAndView resetPassword(@Validated
									@ModelAttribute("passwordResetDto") PasswordResetDto passwordResetDto,
									BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("goResetFormPage","passwordResetDto", passwordResetDto);
		}
		userService.resetPassword(passwordResetDto.getOldPassword(), passwordResetDto.getNewPassword(), passwordResetDto.getUserId());
		return new ModelAndView("index");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
