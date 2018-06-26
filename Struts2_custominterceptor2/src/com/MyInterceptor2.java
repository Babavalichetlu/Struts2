package com;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
public class MyInterceptor2 implements Interceptor {
  @Override
  public void init() {
    System.out.println("MyInterceptor2 init method");
  }

  @Override
  public void destroy() {
    System.out.println("MyInterceptor2 destroy method");
  }

  @Override
  public String intercept(ActionInvocation inv) throws Exception {
    System.out.println("intercept method in Interceptor2 before invoke");
    String result = inv.invoke();
    System.out.println(result);
    System.out.println("intercept method in Interceptor2 after invoke");
    return result;
  }
}