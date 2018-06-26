package com;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware; 
import com.opensymphony.xwork2.ActionSupport; 
public class SumAction extends ActionSupport implements ServletRequestAware {
    private HttpServletRequest request;
    private int sum;
 
    public int getSum() {
        return sum;
    }
 
    public String execute() {
    	System.out.println("**** In execute method******");
        // an exception might be thrown here if x/y is not a number
        int x = Integer.parseInt(request.getParameter("x"));
        int y = Integer.parseInt(request.getParameter("y"));
        System.out.println("**** values are -->"+x+"<--->"+y);
        sum = x + y;
        return SUCCESS;
    }
 
    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
}