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
		
		System.out.println("[LOG] METHOD: "+methodName+ " is calling"); //메서드 호출 전
		Object rtnObj = invocation.proceed(); //sayhello 호출
		
		sw.stop();
		
		System.out.println("[LOG] METHOD:"+methodName + " was called");
		System.out.println("[LOG] 처리시간:"+sw.getTotalTimeMillis()/1000 + " 초 ");
		
		return rtnObj;
	}
	
}//class end
