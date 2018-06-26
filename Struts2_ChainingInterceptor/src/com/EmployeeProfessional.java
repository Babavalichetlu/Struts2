package com;

import com.opensymphony.xwork2.ActionSupport;
public class EmployeeProfessional extends ActionSupport {
  private int salary;
  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  @Override
  public String execute() throws Exception {
    return SUCCESS;
  }
}