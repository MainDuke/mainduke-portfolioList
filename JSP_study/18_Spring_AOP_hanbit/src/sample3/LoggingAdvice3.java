package sample3;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

//advice
@Aspect
public class LoggingAdvice3 { //POJO 로 작성 했다. 상속이 없기 때문이다.

	@Around("execution (public * sample3.*.sayHello())")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
		
		
		String methodName=joinPoint.getKind();
		StopWatch sw=new StopWatch();
		
		sw.start(methodName);
		
		System.out.println("method : "+methodName+" is calling");
		Object ob=joinPoint.proceed(); //비즈니스 객체 메서드 호출. 
		sw.stop();
		
		System.out.println("method : "+methodName+" 호출 후");
		System.out.println("처리 시간 : "+sw.getTotalTimeMillis()/1000+"초");
		
		return ob;
	}//logAround end
	
	
	
	
}//class ed
