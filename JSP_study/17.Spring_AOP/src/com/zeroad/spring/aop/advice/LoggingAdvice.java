package com.zeroad.spring.aop.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import com.zeroad.spring.service.order.OrderService;

//advice : 공통 사용 부분
public class LoggingAdvice implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice{

	
	protected final Log logger=(Log)LogFactory.getLog(getClass());
	
	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		// TODO Auto-generated method stub
		
		if(logger.isDebugEnabled()){
			logger.debug("start MethodBeforeAdvice.before()");
			logger.debug(target.getClass().getName());
			logger.debug(target.getClass().getName());//비즈니스 클래스
			logger.debug(method.getName());
		
			for(int i=0; i<args.length; i++){
				logger.debug("args["+i+"] : "+args[i]);
				
			}//for
		}//if
		
	}//end over

	
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args,
			Object target) throws Throwable {
		// TODO Auto-generated method stub
		
		logger.debug("start AfterReturningAdvice.afterReturning()....");
		logger.debug(target.getClass().getName());
		logger.debug(method.getName());
		logger.debug("returnValues : "+returnValue);
	}//afterReturning() end

	public void afterThrowing(Method method, Object[] args,	Object target, Exception e) throws Throwable {
		// TODO Auto-generated method stub
		
		String methodName=method.getName();
		
		if(target instanceof OrderService ){
			logger.debug("Start ThrowsAdvice.afterThrowing()");
			logger.error(target.getClass()+"."+method.getName(), e);
		}
		
	}//afterThrowing end
	
	
}//class end
