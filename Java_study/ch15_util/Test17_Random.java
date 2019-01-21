import java.util.Random;

class Test17_Random
{
   
  	public static void main( String [] args ) 
   {
      Random r = new Random();
      
     int a1= r.nextInt(10);//객체 생성.
   
     int a2 =r.nextInt(10); //0~10 사이.
     int a3 =r.nextInt(1000); //0~100사이.
      
     float f= r.nextFloat();
     double d = r.nextDouble(); //임의의 더블값 발생.
      
     double d2= Math.random(); //0~1.0 사이 임의 난수.
      
     
     System.out.println("a1 : "+a1);
  System.out.println("a2 : "+a2);
   System.out.println("a3 : "+a3);
    System.out.println("f : "+f);
     System.out.println("d : "+d);
     System.out.println("d2 : "+d2);
      
      
   }// end main

}//class end
