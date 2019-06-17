package com.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.DTO.LoginForm;
import com.service.AdminService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	
	Logger LOGGER =LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private AdminService adminService;
	
	@GetMapping(value="/login")
	public ModelAndView login(){
		ModelAndView model=new ModelAndView();
		model.setViewName("adminLogin");
		return model;
	}
	
	@PostMapping(value="/loginSuccess")
	public ModelAndView loginSuccess(@ModelAttribute("loginForm")LoginForm loginForm){
		
		LOGGER.info("======in admin controller==");
		Map<String,Object> result=adminService.adminLogin(loginForm);
		ModelAndView model=new ModelAndView();
		if((boolean)result.get("isSuccess"))
		{
			model.addObject("adminName",result.get("adminName"));
			
			model.addObject("users",result.get("users"));
			model.setViewName("adminWelcome");
		}else {
			model.setViewName("adminLogin");
			model.addObject("errorMessage",result.get("message"));
		}
			
		
		
		return model;
	}
}
