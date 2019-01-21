/*
 * Author: Administrator
 * Created: 2016년 2월 11일 목요일 오전 10:34:45
 * Modified: 2016년 2월 11일 목요일 오전 10:34:45
 */

class Test2{
  
}
class Test15_String
{
   public static void main( String [] args ) 
   {
      String a1="hello";
      String a2= "hello";
      
      System.out.println(a1==a2);
      
      String s3= new String("hello");
      String s4 = new String("hello");
      
      System.out.println(s3==s4);
      System.out.println(s3.equals(s4));
      
      //
      try{
         Test2 A=new Test2();
         Test2 B= new Test2();
         
         if(A==B)
         {
            System.out.println("A==B");
         }else{
            System.out.println("A != B");
         }
         
         if(A.equals(B))
         {
            System.out.println("A==B");
         }else{
            System.out.println("A!=B");
         }
      }catch(Exception ex){
         System.out.println(ex);
      }
      
   }// end main
   
}//class
