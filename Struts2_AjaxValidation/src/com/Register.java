package com;
import com.opensymphony.xwork2.ActionSupport;  

public class Register extends ActionSupport{  
private static final long serialVersionUID = 1L;
private String name,password,email;  
  
//setters and getters    
public String execute(){  
    return "success";  
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}  
}  