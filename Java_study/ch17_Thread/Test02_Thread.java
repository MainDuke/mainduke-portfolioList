/*
 * Author: Administrator
 * Created: 2016�� 2�� 12�� �ݿ��� ���� 10:34:44
 * Modified: 2016�� 2�� 12�� �ݿ��� ���� 10:34:44
 */


class Test02_Thread
{
 
   
   
   
   public static void main( String [] args ) 	
   {
      MyTest02 t1 = new MyTest02();
      YouThread t2 = new YouThread();
      t1.setPriority(1);
      t2.setPriority(10);
      
      //t1.setPriority(Thread.MIN_PRIORITY);
      //t2.setPriority(Thread.MAX_PRIORITY);
  
      
      t1.start();

      t2.start();
      
      
   }// end main
   
}//class end
class MyTest02 extends Thread
{
   public void run(){
      for(char ch='A';ch<'Z';ch++)
      {
         System.out.print(ch);
      }
   }
}//class end 

class YouThread extends Thread{
   public void run(){
      for(char ch='a';ch<'z';ch++)
      {
         System.out.print(ch);
      }
   }
}//class end