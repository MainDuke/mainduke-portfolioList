/*
 * Author: Administrator
 * Created: 2016�� 2�� 11�� ����� ���� 4:09:19
 * Modified: 2016�� 2�� 11�� ����� ���� 4:09:19
 */

import java.util.*;

class Test12_HashTable
{
   public static void main( String [] args )
   {
      
  Hashtable<String,String> ht= new Hashtable<String, String>();
   ht.put("id", "kim");
   ht.put("pwd", "12345");
   ht.put("addr", "���� ������");
   ht.put("date",new Date().toString());

   Enumeration<String> e = ht.keys();
   
   while(e.hasMoreElements())
   {
      String key=(String)e.nextElement();
      String val=ht.get(key);
      System.out.println(key+":"+val);
    }
   
   
   
   //Enumeration : �������� ó���ȴ�.
   
   System.out.println();
   
  System.out.println(ht.get("id"));
  System.out.println(ht.get("pwd"));
   System.out.println(ht.get("addr"));
   System.out.println(ht.get("date"));
   }// end main
	 
   
}
