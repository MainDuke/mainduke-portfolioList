/*
 * Author: Administrator
 * Created: 2016�� 2�� 4�� ����� ���� 3:48:08
 * Modified: 2016�� 2�� 4�� ����� ���� 3:48:08
 */


import java.io.*;
class HandPhone implements Serializable
{
	//vari
   String hpName;
   transient int price;
   
   
   //cons
   public HandPhone(String hpName, int price){
      
      this.price=price;
      this.hpName=hpName;
      
   }//cons end

   //method
   public String getHpName(){
      return hpName;
   }
   
   public int getPrice(){
      return price;
   }
   
   
}//class end
