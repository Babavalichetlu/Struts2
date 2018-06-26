package com;
import com.opensymphony.xwork2.ActionSupport;

public class MyAction extends ActionSupport{
	private String username;
	private String email;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		System.out.println("****ToString() *******");
		return "MyAction [username=" + username + ", email=" + email + "]";
	}
}
