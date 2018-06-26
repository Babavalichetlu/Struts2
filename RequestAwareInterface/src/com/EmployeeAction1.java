package com;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction1 extends ActionSupport implements RequestAware {
Map<String, Object> requestMap;

@Override
public void setRequest(Map<String, Object> reqmap) {
	System.out.println("***** in setRequest mehtod*****");
requestMap = reqmap;
}

@Override
public String execute() throws Exception {
	System.out.println("***** in execute mehtod*****");
ActionContext ctx = ActionContext.getContext();
HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
String code = request.getParameter("code");
String name = request.getParameter("name");
String city = request.getParameter("city");
String salary = request.getParameter("salary");
requestMap.put("code", code);
requestMap.put("name", name);
requestMap.put("city", city);
requestMap.put("salary", salary);
requestMap.put("msg","If you got this message, it means it is working");
return "success";
}
}