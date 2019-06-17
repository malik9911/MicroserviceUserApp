package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.DTO.LoginForm;
import com.DTO.RegistrationForm;
import com.DTO.UserDto;
import com.domain.User;
import com.service.UserService;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = "/user")
public class UserController{
	
	
	
    private Logger LOGGER =LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/saveUser", method =RequestMethod.POST)
	public Map<String,Object> saveUser( @RequestBody UserDto userDto){
        LOGGER.info("in saved controller");
		Map<String,Object> result=new HashMap<>();
		result= userService.saveUser(userDto);
		return result;
		
	}
	
	
	
	@RequestMapping(value="/getUsers", method =RequestMethod.GET)
	public Map<String,Object> getUser(){
		
		Map<String,Object> result=new HashMap<>();
		result= userService.getUsers();
		return result;
	}
	
	
	@RequestMapping(value="/updateUser", method =RequestMethod.PUT)
	public Map<String,Object> updateUser(@RequestBody UserDto userDto, @RequestParam(name="id", required=true)Long id ){	
		Map<String,Object> result=new HashMap<>();
		result= userService.updateUser(userDto, id);
		return result;
	}
	
	
	@RequestMapping(value="/deleteUser", method =RequestMethod.PUT)
	public Map<String,Object> deleteUser(@RequestParam(name="email", required=true)String email ){
		Map<String,Object> result;
		result= userService.deleteUser(email);
		return result;
	}
	
	
	
	@RequestMapping(value="/home", method =RequestMethod.GET)
	public ModelAndView home(ModelAndView model ){
		System.out.print("in controler");
		model.addObject("message","test msg");
		model.setViewName("welcome");
		return model;
	}
	
	
	@GetMapping("/login")
	public ModelAndView login(){
		ModelAndView model=new ModelAndView();
		model.setViewName("login");
		return model;
	}
	
	@PostMapping("/loginSuccess")
	public ModelAndView loginSuccess(@ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult){
	ModelAndView model=new ModelAndView();		
		LOGGER.info("email {} and password {}", loginForm.getEmail(), loginForm.getPassword());
		if(bindingResult.hasErrors()) {
			model.addObject("message",bindingResult.getFieldError());
			model.setViewName("login");
			return model;
		}
		
	 Map<String,Object> result=	userService.userLogin(loginForm);
	 LOGGER.info("result {}", result);
		if((boolean)result.get("isSuccess")) {
		model.addObject("message",result.get("userName"));
		model.setViewName("welcome");
		}else {
			model.addObject("message",result.get("message"));
			model.setViewName("login");
		}
		
		return model;
		
	}
	
	
	
	
	@RequestMapping(value="/registration", method =RequestMethod.GET)
	public ModelAndView registartion(ModelAndView model ){
		
		model.addObject("message","");
		model.setViewName("registration");
		return model;
	}
	
	@RequestMapping(value="/registrationSuccesss", method =RequestMethod.GET)
	public ModelAndView registartionSuccess(@ModelAttribute("registrationForm") RegistrationForm registrationForm, BindingResult bindingResult ){
	  LOGGER.info("====IN REGISTRATION SUCCESS====");
		ModelAndView model =new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			model.addObject("message",bindingResult.getFieldError().toString());
			model.setViewName("registration");
		}
		
		Map<String,Object> result= userService.userRegistration(registrationForm);
		model.addObject("message",result.get("message"));
		model.setViewName("registration");
		return model;
	}
	
	
}

