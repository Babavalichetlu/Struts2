package com;

import com.opensymphony.xwork2.ActionSupport;

public class EmpDebugAction extends ActionSupport {
	private String code;
	private String name;
	private String city;
	private double salary;

	public String getCode() {
	return code;
	}

	public void setCode(String code) {
	this.code = code;
	}

	public String getName() {
	return name;
	}

	public void setName(String name) {
	this.name = name;
	}

	public String getCity() {
	return city;
	}

	public void setCity(String city) {
	this.city = city;
	}

	public double getSalary() {
	return salary;
	}

	public void setSalary(double salary) {
	this.salary = salary;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("*****In execute method");
	return "success";
	}
	}