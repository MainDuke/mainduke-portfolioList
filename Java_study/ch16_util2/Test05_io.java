
import static java.lang.System.out;
import static java.lang.Math.PI;
import java.util.Scanner;

class Test05_io{
   
   public static void main( String [] args )
   {
      out.println("�ȳ�.");
      out.println(PI);
  
      Scanner s1 = new Scanner(System.in);
      out.print("������ �Է��Ͻÿ�.");
      int a=s1.nextInt();
      
      out.print("�Ǽ��� �Է��Ͻÿ�.");
      double d=s1.nextDouble();
      
      out.print("���带 �Է��Ͻÿ�.");
      String str=s1.next();
      
      
      System.out.println("a:"+ a);
      System.out.println("d:"+ d);
      System.out.println("str:"+ str);
      
   }// end main
}