package com;
import java.util.HashMap;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
public class Login {
	//data members
	private String userName;
 
	//business logic
	public String execute(){
		ValueStack stack =	ActionContext.getContext().getValueStack();
		Map<String, Object> context = new HashMap<String, Object>(); 
	  	context.put("value1", new String("First value")); 
	  	context.put("value2", new String("Second value"));
	  	stack.push(context);
		return "success";	
	}	
 
	//getter setters
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
