package com;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

public class EmpRegAction1 extends ActionSupport {
private String eid, name, city, email, dob;
int salary;

public String getEid() {
return eid;
}

@RequiredStringValidator(type = ValidatorType.FIELD, message = "Emp Id is required")
public void setEid(String eid) {
this.eid = eid;
}

public String getName() {
return name;
}
@RequiredStringValidator(type = ValidatorType.FIELD, message = "Employee Name is required")
public void setName(String name) {
this.name = name;
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
@RequiredStringValidator(type = ValidatorType.FIELD, message = "Email is required")
@EmailValidator(type=ValidatorType.FIELD,message="Email id required",key="",fieldName="email",shortCircuit=true)
public void setEmail(String email) {
this.email = email;
}

public String getDob() {
return dob;
}
/*
@RequiredStringValidator(type = ValidatorType.FIELD, message = "Date of Birth is required")
//@RegexFieldValidator(type=ValidatorType.FIELD, message="date is not is proper format- dd-Month-Year",key="", expression = "[0-9][0-9]-[A-Z][a-z][a-z]-[0-9][0-9][0-9][0-9]")
public void setDob(String dob) {
this.dob = dob;
}
*/
public int getSalary() {
return salary;
}

@IntRangeFieldValidator(message = "Salary is not in range", key = "", shortCircuit = true, min = "1", max = "50000")
public void setSalary(int salary) {
this.salary = salary;
}

@Override
public String execute() throws Exception {
System.out.println("Inside exceute method");
return SUCCESS;
}

@SkipValidation
public String noValidation() throws Exception {
System.out.println("In Novalidation");
return SUCCESS;
}
}