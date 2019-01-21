package com.zeroad.spring.model;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class ContentReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] arg2)
			throws Throwable {
		
		
		return "this method is replaced....!";
	}
	
}//class end
