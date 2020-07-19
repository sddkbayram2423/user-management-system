package com.bayram.controller;

import java.util.HashMap;


import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bayram.model.user.User;
import com.bayram.model.user.VerificicationToken;
import com.bayram.service.user.UserService;
import com.bayram.service.user.VerificationTokenService;
import com.bayram.service.user.Imp.MailService;
import com.bayram.web.dto.Mail;
import com.bayram.web.dto.UserDto;

@Controller
@RequestMapping("verificationToken")
public class VerificationTokenController {
	
	
	@Autowired
	private VerificationTokenService verificationTokenService;
	@Autowired
	private MailService mailService;
	

	@Autowired
	private UserService userService;
	
	
	
	
	
	//------------------/controller/verificationToken/veriVicationTokenForNewUser------------------------------------
	
	@RequestMapping(value = "/veriVicationTokenForNewUser",method = RequestMethod.POST)
	public ModelAndView resetForgotPassword(@Validated 
											@ModelAttribute("userDto") UserDto userDto,
											BindingResult result,
											HttpServletRequest request) {
		
		
		
	if(result.hasErrors()) {
		return new ModelAndView("goRegisterPage", "userDto", userDto);
	}
		
		User user=userService.registerNewUser(userDto);
		user.setEnabled(false);
	
		VerificicationToken verificicationToken=new VerificicationToken();
		verificicationToken.setUser(user);
		verificicationToken.setToken(UUID.randomUUID().toString()+UUID.randomUUID().toString());
		verificationTokenService.saveVerificicationToken(verificicationToken);
		
		Mail mail=new Mail();
		mail.setFrom("no-reply@bayram.com");
		mail.setTo(userDto.getEmail());
		mail.setSubject("Password reset request");
		
		
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
		
		
		Map<String, Object> model=new HashMap<>();
		model.put("token", verificicationToken.getToken());
		model.put("userDto", userDto);
		model.put("signature", "https://bayram.com");
		model.put("resetUrl", url + "/controller/user/makeAktiveUser?token=" + verificicationToken.getToken());
		
		
		mail.setModel(model);
		
		mailService.sendToGmailAccount(mail);
		
		
		return new ModelAndView("reset","message","For Sign up a verificication token sended your email.Please confirm it.");
	}

}
