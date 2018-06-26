package com;

import com.opensymphony.xwork2.ActionSupport;  

public class RegisterAction extends ActionSupport{  
private String name,password; 
//setters and getters

public void validate() {  
	System.out.println("**** in validate method*****");
	 if(name.length()<1)   
        addFieldError("name","Name can't be blank");  
	 if(password.length()<6)  
        addFieldError("password","Password must be greater than 5");  
}  
public String execute(){  
	//perform business logic here
		System.out.println("**** in Execute method*****");
	    return "success";  
	}  
  
//getters and setters  
  
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


}  