package sample3;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

//advice
@Aspect
public class LoggingAdvice3 { //POJO �� �ۼ� �ߴ�. ����� ���� �����̴�.

	@Around("execution (public * sample3.*.sayHello())")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
		
		
		String methodName=joinPoint.getKind();
		StopWatch sw=new StopWatch();
		
		sw.start(methodName);
		
		System.out.println("method : "+methodName+" is calling");
		Object ob=joinPoint.proceed(); //����Ͻ� ��ü �޼��� ȣ��. 
		sw.stop();
		
		System.out.println("method : "+methodName+" ȣ�� ��");
		System.out.println("ó�� �ð� : "+sw.getTotalTimeMillis()/1000+"��");
		
		return ob;
	}//logAround end
	
	
	
	
}//class ed
