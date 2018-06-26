package com;
import com.opensymphony.xwork2.ActionSupport;
public class Login extends ActionSupport{
	//data members
	private String userName;
	private String password;
 
	//business logic
	public String execute(){
		return SUCCESS;	
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
}