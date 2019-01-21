/*
 * Author: Administrator
 * Created: 2016년 2월 12일 금요일 오전 11:13:58
 * Modified: 2016년 2월 12일 금요일 오전 11:13:58
 */


class Test04_Thread
{
	public static void main( String [] args ) 
   {
    
      MyTest04 t1 = new MyTest04("AAA", 2000);
      MyTest04 t2 = new MyTest04("BBB", 1000);
      MyTest04 t3 = new MyTest04("CCC", 3000);
           
      t1.start();
      t2.start();
      t3.start();
      
   }// end main

}//class end

class MyTest04 extends Thread{
   String msg;
   long msec;
   
   public MyTest04(String msg, long msec){
      this.msg=msg;
      this.msec=msec;
   }//cons end
   
   //overriding
   public void run(){
      try{
         while(true)
         {
            Thread.sleep(msec);
            System.out.println(msg);
         }//while
      }catch(InterruptedException ex){
         System.out.println(ex);
      }
   }//over end
   
}//class end