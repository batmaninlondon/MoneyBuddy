package com.myMoneyBuddy.Interceptors;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;

public class MyInterceptor implements Interceptor {

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
	
		SessionMap<String,Object> sessionMap =(SessionMap<String, Object>) actionInvocation.getInvocationContext().getSession();
		String customerId = (String) sessionMap.get("customerId ");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
		LocalDateTime currentTime = LocalDateTime.now();  
		   
		ValueStack stack = actionInvocation.getStack();  
		
		System.out.println("Action class - "+stack.getRoot().get(0).getClass().getSimpleName()+" for customerId - "+customerId+" - START - time - "+formatter.format(currentTime));
		
		String result = actionInvocation.invoke();
		
		currentTime = LocalDateTime.now();  

		System.out.println("Action class - "+stack.getRoot().get(0).getClass().getSimpleName()+" for customerId - "+customerId+" - END - time - "+formatter.format(currentTime));
		
		for ( Method method : stack.getRoot().get(0).getClass().getDeclaredMethods())   {
			
			if ( method.getName().equals("execute") )   {
				System.out.println(" this is a call to execute method !! ");
				for (Parameter param : method.getParameters())   {
					System.out.println(" parameter is : "+param);
				}
			}
			
		}
		
        return result;
		
	}
	
	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}



	
	

}
