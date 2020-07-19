package com.bayram.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bayram.model.user.PasswordResetToken;
import com.bayram.model.user.User;
import com.bayram.service.user.PasswordResetTokenService;
import com.bayram.service.user.UserService;
import com.bayram.service.user.Imp.MailService;
import com.bayram.web.dto.Mail;
import com.bayram.web.dto.NewPasswordDto;
import com.bayram.web.dto.PasswordForgotDto;

@Controller
@RequestMapping("forgotPassword")
public class PasswordForgotController {
	
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private PasswordResetTokenService passwordResetTokenService;
	
	
	@Autowired
	private MailService mailService;
	
	
	//------------------------------/controller/forgotPassword/goForgotResetPasswordForm--------------------------------------------
	
	@RequestMapping(value = "/goForgotResetPasswordForm",method = RequestMethod.GET)
	public ModelAndView goForgotResetPasswordForm() {
		
		return new ModelAndView("goForgotPasswordFormPage","passwordForgotDto", new PasswordForgotDto());
	}
	
	
	//------------------------------/controller/forgotPassword/resetForgotPassword--------------------------------------------
	
		@RequestMapping(value = "/resetForgotPassword",method = RequestMethod.POST)
		public ModelAndView resetForgotPassword(@Validated 
												@ModelAttribute("passwordForgotDto") PasswordForgotDto passwordForgotDto,
												BindingResult result,
												HttpServletRequest request) {
			
			
			
		if(result.hasErrors()) {
			return new ModelAndView("goForgotPasswordFormPage","passwordForgotDto",passwordForgotDto);
		}
			
			User user=userService.findUserByEmail(passwordForgotDto.getEmail());
			
			PasswordResetToken passwordResetToken=new PasswordResetToken();
			passwordResetToken.setToken(UUID.randomUUID().toString());
			passwordResetToken.setUser(user);
			passwordResetTokenService.savePasswordResetToken(passwordResetToken);
			
			Mail mail=new Mail();
			mail.setFrom("no-reply@bayram.com");
			mail.setTo(user.getEmail());
			mail.setSubject("Password reset request");
			
			
			
			Map<String, Object> model=new HashMap<>();
			model.put("token", passwordResetToken.getToken());
			model.put("user", user);
			model.put("signature", "https://bayram.com");
			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
			model.put("resetUrl", url + "/controller/forgotPassword/getRestToken?token=" + passwordResetToken.getToken());
			
			mail.setModel(model);
			
			mailService.sendToGmailAccount(mail);
			
			return new ModelAndView("reset","message","For update password a reset token sended your email.Please confirm your reset token.");
		}
		
		
		
		//------------------------------/controller/forgotPassword/getRestToken--------------------------------------------
		
		@RequestMapping(value = "/getRestToken",method = RequestMethod.GET)
		public ModelAndView getRestToken(@RequestParam("token")String token) {
			
			
			PasswordResetToken resetToken=passwordResetTokenService.findPasswordResetTokenByToken(token);
			
			if(new Date().compareTo(resetToken.getExpiryDate())>0) {
				
				return new ModelAndView("reset","message","Your password reset token is expirydate.");
				
			}
			
			
			NewPasswordDto newPasswordDto=new NewPasswordDto();
			newPasswordDto.setUserId(resetToken.getUser().getId());
			
			return new ModelAndView("goNewPasswordPage","newPasswordDto",newPasswordDto);
		}
		
		//------------------------------/controller/forgotPassword/updatePasword--------------------------------------------
		
		
		@RequestMapping(value = "/updatePasword",method = RequestMethod.POST)
		public ModelAndView updatePasword(@Validated 
										@ModelAttribute("newPasswordDto") NewPasswordDto newPasswordDto,
										BindingResult result) {
			
			
			User user=userService.findUserById(newPasswordDto.getUserId());
			
			userService.changeForgotUserPassword(user, newPasswordDto.getNewPassword());
			
			
			return new ModelAndView("reset","message","Your password updated");
			
		}
		

}
