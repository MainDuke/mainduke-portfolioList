/*
 * Author: Administrator
 * Created: 2016년 2월 12일 금요일 오전 11:31:06
 * Modified: 2016년 2월 12일 금요일 오전 11:31:06
 */

import java.util.*;

class Test05_Thread
{
	public static void main( String [] args ) 
   {
      
      House house = new House();
      Producer p =new Producer(house);
      Consumer c = new Consumer(house);
         
      p.start();
      c.start();
      
      
   }// end main------------------------------------------------
   
}//class end---------------------------------------------------

class House{
   Vector vec;
   public House(){
      vec = new Vector();
   
    }
   //벡터 저장하는 메서드.
   
   synchronized void put(char ch){
      while(vec.size()==3)
      {
         try
         {
          wait(); //기다려.  
         }
         catch(Exception ex)
         {
            System.out.println(ex);
         }
      }//while
      //
      vec.add(new Character(ch));
      System.out.println("창고에 제품 "+ch+"저장했다.");
      System.out.println("재고 수량"+vec.size());
      //일을 마쳤으면  알려준다.
      notifyAll(); //작업이 종료 되었음을 모두에게 알려준다. 다음 대기자가 실행된다.
      
   }//put end
   
   synchronized char get(){
      while(vec.size()==0)
      {
         try
         {
            wait();
         }catch(InterruptedException ex){}
      }//end whlie
   
   Character ch = (Character)vec.remove(0);//0번째 꺼내고 제거.
   System.out.println("창고에서 제품 "+ch+" 가 나갔음");
   System.out.println("재고 수량 : "+vec.size()); 
   notifyAll(); //일을 다 했을을 모두에게 알린다.,
   return ch.charValue();
   
   }//end get
  
}//class end-------------------------------------------------


class Producer extends Thread{//생상하는 Thread , put() 호출하는 작업.
   
   private House house; //변수.
   public Producer(House house){
      this.house=house;
   }
   //over
   public void run(){
      for(char ch='A';ch<='J';ch++)
      {
         house.put(ch);
         System.out.println("생산자가 제품 "+ch+"을 생산하였다.");
      }//for
   }//run end
   
}//Producer class end---------------------------------

class Consumer extends Thread{//소비하는 Thread, get() 호출하는 작업.
   private House house;
   public Consumer(House house){
      this.house=house;
   }
   
   public void run(){
      char ch;
      for(int i =1;i<=10;i++)
      {
         ch=house.get();
         System.out.println("소비자가 제품 "+ch+"을 가져감.");
      }
   }//run end
   
}//Consumer class end ------------------------------------
