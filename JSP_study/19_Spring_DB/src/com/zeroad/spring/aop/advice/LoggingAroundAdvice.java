package com.zeroad.spring.aop.advice;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.zeroad.spring.service.order.OrderService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoggingAroundAdvice implements MethodInterceptor {
	
	protected final Log logger=(Log)LogFactory.getLog(getClass());
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Object returnVal= null; //리턴 받을 변수
		Object obj = invocation.getThis(); //현재 사용한 객체
		String methodName = invocation.getMethod().getName(); //현재객체의 사용호출중인 메서드
		
		Object[] args= invocation.getArguments(); //인수
		
		if(obj instanceof OrderService || methodName.equals("createOrder"))
		{ 
			if(logger.isDebugEnabled()){
			logger.debug("start  : "+methodName+"() 실행 되었음.");
			logger.debug(args[0]);
			}
			
		}
		
		try{
			returnVal=invocation.proceed(); //정말 중요. 비즈니스 로직 처리 된다.
			
		}catch(Exception e){
			logger.error("주문실패 : ",e);
			throw e;
		}
		
		
		logger.debug("주문완료");
		
		return returnVal;
	}//invoke() end
	
}
