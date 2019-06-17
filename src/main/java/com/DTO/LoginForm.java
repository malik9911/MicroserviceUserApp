package com.DTO;

import javax.validation.constraints.NotNull;

public class LoginForm {
	
	@NotNull(message = "email is required")
	private String email;
	
	@NotNull(message = "passowrd is required")
	private String password; 
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginForm( String email,
			String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	
	

}
