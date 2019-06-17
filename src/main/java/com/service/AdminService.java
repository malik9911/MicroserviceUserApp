package com.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;


import com.DTO.LoginForm;


@Service
public class AdminService {

	@Autowired
	private UserService userService;
	
	private Logger LOGGER =LoggerFactory.getLogger(AdminService.class);
	
	public Map<String,Object> adminLogin(LoginForm loginForm) {
	
		
		LOGGER.info("=========in servvice class====");
		  Map<String,Object> result =new HashMap<>();
		  RestTemplate restTemplate =new RestTemplate();
	      final String url="http://127.0.0.1:8082/admin/login";
	      
	      ResponseEntity<String> response=null;
	      HttpHeaders header=new HttpHeaders();
	      header.set("Content-Type", "application/json");
	      JSONObject data=new  JSONObject();
	      data.put("email", loginForm.getEmail());
	      data.put("password", loginForm.getPassword());	     
	     LOGGER.info("====email and password {}",loginForm.getEmail(), loginForm.getPassword());
	      
        try {
        	 URI uri=new URI(url);
        	 LOGGER.info("====trye");
             HttpEntity<String> entity=new HttpEntity<String>(data.toString(),header);
             response=restTemplate.exchange(uri,HttpMethod.POST, entity, String.class);
         }catch (Exception e) {
        	 LOGGER.error("======error {}",e.getMessage());
	        result.put("message","invalid admin");
	        result.put("isSuccess",false);
	         return result;
         }
        
        JSONObject body=new JSONObject(response.getBody());
        LOGGER.info("=======body {}",body);
        Map<String,Object> map=body.toMap();
        LOGGER.info("=======MAP {}",map);
       
      if(Optional.ofNullable(map).isPresent() &&(boolean)map.get("isSuccess")) {
    	    result.put("message","login success");
    	    result.put("adminName",map.get("adminUserName"));
    	    result.put("users",userService.getUsers());
	        result.put("isSuccess",true);
	         return result;
      }else {
    	     result.put("message","invalid admin");
	         result.put("isSuccess",false);
	         return result;
	         }
      
		   
		   
	}
}
