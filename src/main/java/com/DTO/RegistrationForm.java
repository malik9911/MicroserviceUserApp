package com.DTO;


import javax.validation.constraints.NotNull;

public class RegistrationForm {
	
@NotNull(message = "email id required")	
private String email;
@NotNull(message = "password required")
private String password;
@NotNull(message = "user name required")
private String userName;

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

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

}
