package com;

import com.opensymphony.xwork2.Action;
public class Login implements Action{
	//data members
	private String userName;
	private String password;
	private String message;
 
	//business logic
	public String execute(){
		if(userName.equals("baba") &&password.equals("baba")){
			setMessage("Hello " +userName + ", " +"You are successfully logged in.");
			return SUCCESS;
		}else{
			setMessage("Invalid username or password.");
			return ERROR;
		}		
	}	
 
	//getter setters
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}