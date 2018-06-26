package com;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("Calling : UserAction.execute()...");
		return SUCCESS;
	}

}
