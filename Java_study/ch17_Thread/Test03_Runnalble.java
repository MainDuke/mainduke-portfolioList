/*
 * Author: Administrator
 * Created: 2016�� 2�� 12�� �ݿ��� ���� 10:49:59
 * Modified: 2016�� 2�� 12�� �ݿ��� ���� 10:49:59
 */


class Test03_Runnalble
{
	public static void main( String [] args ) 
   {
      
   }// end main

}//class end

class MyTest03 implements Runnable{
   public void run(){
      for(int i = 1;i<=50;i++)
      {
         System.out.print("very ");
      }
   }
}//class end

class YouTest03 implements Runnable{
   public void run(){
      for(int i =1;i<=50;i++)
      {
         System.out.print("good ");
      }
   }
}//class end