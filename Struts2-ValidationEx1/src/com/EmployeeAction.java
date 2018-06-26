package com;

import java.util.Date;
import com.opensymphony.xwork2.ActionSupport;
public class EmployeeAction extends ActionSupport {
  private String id;
  private String name;
  private String password1;
  private String password2;
  private Date dob;
  private Integer salary;
  private String city;
  private String email;
  
  @Override
  public String execute() throws Exception {
    return SUCCESS;
  }
//getter and setter methods

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPassword1() {
	return password1;
}

public void setPassword1(String password1) {
	this.password1 = password1;
}

public String getPassword2() {
	return password2;
}

public void setPassword2(String password2) {
	this.password2 = password2;
}

public Date getDob() {
	return dob;
}

public void setDob(Date dob) {
	this.dob = dob;
}

public Integer getSalary() {
	return salary;
}

public void setSalary(Integer salary) {
	this.salary = salary;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
  
  
}