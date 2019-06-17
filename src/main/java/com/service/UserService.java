package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import com.DTO.LoginForm;
import com.DTO.RegistrationForm;
import com.DTO.UserDto;
import com.configuration.EnvConfiguration;
import com.configuration.EnvConfigurationImp;
import com.domain.User;
import com.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;;

@Service
public class UserService {
	
	@Autowired 
	private UserRepository userRepository;

	private final Logger LOGGER =LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	EnvConfigurationImp envConfiguration;
	
	public Map<String,Object> saveUser(UserDto userDto){
		Map<String,Object> result=new HashMap<>();
		System.out.println("in service controller "+envConfiguration.getDataBaseUrl());
		User user=new User(userDto.getName(),userDto.getEmail(),userDto.getPassword());
	    userRepository.save(user);	
		result.put("message","datasaved successfully");
		return result;
	}
	
	
	public Map<String,Object> getUsers(){
		Map<String,Object> result=new HashMap<>();
	    List<User> list =	userRepository.findAll();
		result.put("message", "Users fetch successfully");
		result.put("users", list);
	    return result;
	}
	
	
	public Map<String,Object> updateUser(UserDto userDto,Long userId){
		Map<String,Object> result=new HashMap<>();
		
		User user =userRepository.findById(userId);
		if(Optional.ofNullable(user).isPresent()) {
			user.setUserName(userDto.getName());
			user.setEmail(userDto.getEmail());
			user.setPassword(userDto.getPassword());
		    userRepository.saveAndFlush(user);
		    result.put("message", "updated successfully");
		}
		else {
			result.put("message", "User not found");
		}
		result.put("isSuccess", true);
	    return result;
	}

	
	public Map<String,Object> deleteUser(String email){
		Map<String,Object> result=new HashMap<>();
	    User user =	userRepository.findByEmail(email);
		if(Optional.ofNullable(user).isPresent()) {
			userRepository.delete(user);
			 result.put("message", "User deleted successfully");
		}else {
			 result.put("message", "User not found");
		}
	    result.put("isSuccess", true);
	    return result;
	}

	
	public Map<String,Object> userRegistration(RegistrationForm registrationForm){
		Map<String,Object> result=new HashMap<>();
		System.out.println("in service controller "+envConfiguration.getDataBaseUrl());
		User user=new User(registrationForm.getUserName(),registrationForm.getEmail(),registrationForm.getPassword());
	    userRepository.save(user);	
		result.put("message","data saved successfully");
		return result;
	}
	
	
	public Map<String,Object> userLogin(LoginForm loginForm){
		Map<String,Object> result=new HashMap<>();
		System.out.println("in service controller "+envConfiguration.getDataBaseUrl());
		if(Optional.ofNullable(loginForm.getEmail()).isPresent()) {
		 User user=	userRepository.findByEmail(loginForm.getEmail());
		 LOGGER.info("============User :::: {}",user);
		 if(Optional.ofNullable(user).isPresent() && loginForm.getPassword().equals(user.getPassword())) {
			 
			 result.put("message", "login successfully");
			 result.put("email", user.getEmail());
			 result.put("userName", user.getUserName());
			 result.put("isSuccess", true);
			 
		 }else {
			 result.put("message", "invalid user");
			 result.put("isSuccess", false);
		 }
		}else {
			 result.put("message", "required email");
			 result.put("isSuccess", false);
		 }
	    
		return result;
	}
	
	
	

}
