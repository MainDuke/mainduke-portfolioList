/*
 * Author: Administrator
 * Created: 2016년 2월 11일 목요일 오후 4:09:19
 * Modified: 2016년 2월 11일 목요일 오후 4:09:19
 */

import java.util.*;

class Test12_HashTable
{
   public static void main( String [] args )
   {
      
  Hashtable<String,String> ht= new Hashtable<String, String>();
   ht.put("id", "kim");
   ht.put("pwd", "12345");
   ht.put("addr", "서울 마포구");
   ht.put("date",new Date().toString());

   Enumeration<String> e = ht.keys();
   
   while(e.hasMoreElements())
   {
      String key=(String)e.nextElement();
      String val=ht.get(key);
      System.out.println(key+":"+val);
    }
   
   
   
   //Enumeration : 무순서로 처리된다.
   
   System.out.println();
   
  System.out.println(ht.get("id"));
  System.out.println(ht.get("pwd"));
   System.out.println(ht.get("addr"));
   System.out.println(ht.get("date"));
   }// end main
	 
   
}
