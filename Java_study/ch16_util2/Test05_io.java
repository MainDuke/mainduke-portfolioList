
import static java.lang.System.out;
import static java.lang.Math.PI;
import java.util.Scanner;

class Test05_io{
   
   public static void main( String [] args )
   {
      out.println("안녕.");
      out.println(PI);
  
      Scanner s1 = new Scanner(System.in);
      out.print("정수를 입력하시오.");
      int a=s1.nextInt();
      
      out.print("실수를 입력하시오.");
      double d=s1.nextDouble();
      
      out.print("문장를 입력하시오.");
      String str=s1.next();
      
      
      System.out.println("a:"+ a);
      System.out.println("d:"+ d);
      System.out.println("str:"+ str);
      
   }// end main
}