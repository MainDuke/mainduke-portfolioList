package sample2;

import org.aspectj.lang.ProceedingJoinPoint;
//POJO ( Plain Old Java Object )의 로그 출력 클래스를
//Advice로써 이용하는 것이 핵심이다
import org.springframework.util.StopWatch;

//공통 사용 부분
//ProceedingJoinpoint
public class LoggingAdvice2 {//POJO 작성
	
	//logAround()는 AroundAdvice로 동작 시킬
	//메서드 인데, 인수를 ProceedingJoinPoint타입으로 사용해야 한다
	public Object logAround(ProceedingJoinPoint joinpoint) throws Throwable{
		
		String methodName=joinpoint.getKind();
		StopWatch sw=new StopWatch();
		
		sw.start(methodName);
		System.out.println("method "+methodName+" is calling");
		
		Object reobj=joinpoint.proceed();//비지니스 객체 메서드 호출 부분이다.
		
		sw.stop();//시간 측정 종료
		System.out.println("처리시간 :"+sw.getTotalTimeMillis()/1000+"초");
		
		return reobj;
	}//logAround()

}//class
