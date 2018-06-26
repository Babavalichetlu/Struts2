package com;

public class NormalUser{
	//data member
	private String message;
 
	//business logic
	public String execute(){
		setMessage("Hello user.");
		return "success";	
	}	
 
	//getter setters
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}