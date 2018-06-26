package com;

public class AdminUser{
	//data member
	private String message;
 
	//business logic
	public String execute(){
		System.out.println("**** in execute method****");
		setMessage("Hello Admin.");
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