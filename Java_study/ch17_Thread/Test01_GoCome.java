/*
 * Author: Administrator
 * Created: 2016년 2월 12일 금요일 오전 10:20:58
 * Modified: 2016년 2월 12일 금요일 오전 10:20:58
 */

class Go extends Thread{
   public void run(){//오버라이딩
      int i=1;
      while(i<=50)
      {
         System.out.print("go ");
         i++;
      }//while
   }//run
}

class Come extends Thread{
   public void run(){//오버라이딩
      int i=1;
      while(i<=50)
      {
         System.out.print("come ");
         i++;
         }//while
   }//run
   
}
/*


5. 스레드를 사용하여 프로그램를 작성하는 방법

(1)  Thread 나 Runnable를 상속 받아 

(2)  run()메서드에 스레드안에서 수행할 내용을 오버라이딩 하고

(3)  이 Thread 클래스의 객체를  생성하고 start()메서드를 이용하여 run() 메서드를

호출하면 된다



 */

class Test01_GoCome
{
   public static void main( String [] args ) 
   {
      
  Go go = new Go();
   Come come = new Come();
   go.start(); //run() call
   come.start(); //run() call

}//end main
}
