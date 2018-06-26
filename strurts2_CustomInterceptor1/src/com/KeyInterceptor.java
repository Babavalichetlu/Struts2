package com;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class KeyInterceptor implements Interceptor {

	public void destroy() {
		System.out.println("Calling : KeyInterceptor.destroy()...");
	}

	public void init() {
		System.out.println("Calling : KeyInterceptor.init()...");
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("Calling : KeyInterceptor.intercept(..) : before invoke()...");
		String result = invocation.invoke();
		System.out.println("Calling : KeyInterceptor.intercept(..) : after invoke()...");
		return result;
	}

}