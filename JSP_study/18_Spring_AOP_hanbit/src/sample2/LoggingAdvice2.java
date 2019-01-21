package sample2;

import org.aspectj.lang.ProceedingJoinPoint;
//POJO ( Plain Old Java Object )�� �α� ��� Ŭ������
//Advice�ν� �̿��ϴ� ���� �ٽ��̴�
import org.springframework.util.StopWatch;

//���� ��� �κ�
//ProceedingJoinpoint
public class LoggingAdvice2 {//POJO �ۼ�
	
	//logAround()�� AroundAdvice�� ���� ��ų
	//�޼��� �ε�, �μ��� ProceedingJoinPointŸ������ ����ؾ� �Ѵ�
	public Object logAround(ProceedingJoinPoint joinpoint) throws Throwable{
		
		String methodName=joinpoint.getKind();
		StopWatch sw=new StopWatch();
		
		sw.start(methodName);
		System.out.println("method "+methodName+" is calling");
		
		Object reobj=joinpoint.proceed();//�����Ͻ� ��ü �޼��� ȣ�� �κ��̴�.
		
		sw.stop();//�ð� ���� ����
		System.out.println("ó���ð� :"+sw.getTotalTimeMillis()/1000+"��");
		
		return reobj;
	}//logAround()

}//class
