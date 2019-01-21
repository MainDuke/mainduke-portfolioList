package sample1;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;


public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
	
		String methodName = invocation.getMethod().getName();
		StopWatch sw= new StopWatch();
		
		sw.start(methodName);
		
		System.out.println("[LOG] METHOD: "+methodName+ " is calling"); //�޼��� ȣ�� ��
		Object rtnObj = invocation.proceed(); //sayhello ȣ��
		
		sw.stop();
		
		System.out.println("[LOG] METHOD:"+methodName + " was called");
		System.out.println("[LOG] ó���ð�:"+sw.getTotalTimeMillis()/1000 + " �� ");
		
		return rtnObj;
	}
	
}//class end
