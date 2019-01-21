/*
 * Author: Administrator
 * Created: 2016�� 2�� 12�� �ݿ��� ���� 11:31:06
 * Modified: 2016�� 2�� 12�� �ݿ��� ���� 11:31:06
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
   //���� �����ϴ� �޼���.
   
   synchronized void put(char ch){
      while(vec.size()==3)
      {
         try
         {
          wait(); //��ٷ�.  
         }
         catch(Exception ex)
         {
            System.out.println(ex);
         }
      }//while
      //
      vec.add(new Character(ch));
      System.out.println("â�� ��ǰ "+ch+"�����ߴ�.");
      System.out.println("��� ����"+vec.size());
      //���� ��������  �˷��ش�.
      notifyAll(); //�۾��� ���� �Ǿ����� ��ο��� �˷��ش�. ���� ����ڰ� ����ȴ�.
      
   }//put end
   
   synchronized char get(){
      while(vec.size()==0)
      {
         try
         {
            wait();
         }catch(InterruptedException ex){}
      }//end whlie
   
   Character ch = (Character)vec.remove(0);//0��° ������ ����.
   System.out.println("â���� ��ǰ "+ch+" �� ������");
   System.out.println("��� ���� : "+vec.size()); 
   notifyAll(); //���� �� ������ ��ο��� �˸���.,
   return ch.charValue();
   
   }//end get
  
}//class end-------------------------------------------------


class Producer extends Thread{//�����ϴ� Thread , put() ȣ���ϴ� �۾�.
   
   private House house; //����.
   public Producer(House house){
      this.house=house;
   }
   //over
   public void run(){
      for(char ch='A';ch<='J';ch++)
      {
         house.put(ch);
         System.out.println("�����ڰ� ��ǰ "+ch+"�� �����Ͽ���.");
      }//for
   }//run end
   
}//Producer class end---------------------------------

class Consumer extends Thread{//�Һ��ϴ� Thread, get() ȣ���ϴ� �۾�.
   private House house;
   public Consumer(House house){
      this.house=house;
   }
   
   public void run(){
      char ch;
      for(int i =1;i<=10;i++)
      {
         ch=house.get();
         System.out.println("�Һ��ڰ� ��ǰ "+ch+"�� ������.");
      }
   }//run end
   
}//Consumer class end ------------------------------------
