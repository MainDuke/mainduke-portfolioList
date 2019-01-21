/*
 * Author: Administrator
 * Created: 2016년 2월 3일 수요일 오후 2:14:43
 * Modified: 2016년 2월 3일 수요일 오후 2:14:43
 */


//메서드는 stack 에 저장된다.
//stack : Last in First Out (LIFO)
class Test05_Exception
{
   public static void main( String [] args )
   {
      try
      {
         System.out.println("aa호출전.");
         aa();
         System.out.println("aa호출 후");
      }
      catch(Exception e1)
         
      {
         //System.out.println("예외"+e1);
         e1.printStackTrace();
      }finally{
         System.out.println("main().... finally");
      }
      
   }// end main
  
   
public static void aa(){
      try
      {
         System.out.println("bb(); 호출전");
         bb();
         System.out.println("bb(); 호출후");
      }
      catch(Exception e2)
      {
          e2.printStackTrace();
         //System.out.println("예외2"+e2);
      }
      finally
      {
         System.out.println("bb().... finally");
      }
   }
   
   public static void bb(){
      try
      {
         System.out.println("cc(); 호출전");
         cc();
         System.out.println("cc(); 호출후");
      }
      catch(Exception e3)
      {
          e3.printStackTrace();
         //System.out.println("예외3"+e3);
      }
      finally
      {
         System.out.println("cc().... finally");
      }
   }


public static void cc(){
   try
   {
      System.out.println("dd(); 호출전");
      dd();
      System.out.println("dd(); 호출후");
   }
   catch(Exception e4)
   {
      System.out.println("예외4 "+e4);
   }
   finally
   {
      System.out.println("dd().... finally");
   }
}



public static void dd(){
   try
   {
      System.out.println("나누기 하기전.");
      int x=3;
      int y=0;
      System.out.println(x/y); //Exception발생.
      
   }
   catch(Exception e)
   {
      e.printStackTrace();
   }
   finally
   {
      System.out.println("dd().... finally");
   }
}





}//class end