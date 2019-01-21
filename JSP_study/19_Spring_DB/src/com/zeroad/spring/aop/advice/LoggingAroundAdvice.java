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
		
		Object returnVal= null; //���� ���� ����
		Object obj = invocation.getThis(); //���� ����� ��ü
		String methodName = invocation.getMethod().getName(); //���簴ü�� ���ȣ������ �޼���
		
		Object[] args= invocation.getArguments(); //�μ�
		
		if(obj instanceof OrderService || methodName.equals("createOrder"))
		{ 
			if(logger.isDebugEnabled()){
			logger.debug("start  : "+methodName+"() ���� �Ǿ���.");
			logger.debug(args[0]);
			}
			
		}
		
		try{
			returnVal=invocation.proceed(); //���� �߿�. ����Ͻ� ���� ó�� �ȴ�.
			
		}catch(Exception e){
			logger.error("�ֹ����� : ",e);
			throw e;
		}
		
		
		logger.debug("�ֹ��Ϸ�");
		
		return returnVal;
	}//invoke() end
	
}
