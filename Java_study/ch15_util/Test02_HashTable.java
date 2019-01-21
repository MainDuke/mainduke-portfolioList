/*
 * Author: Administrator
 * Created: 2016년 2월 4일 목요일 오후 4:44:57
 * Modified: 2016년 2월 4일 목요일 오후 4:44:57
 */


import java.util.*;

class Test02_HashTable
{
	public static void main(String args[]){
      Hashtable ht= new Hashtable();
      
      //서버에서 이 작업을 한다고 하면.
      
      ht.put("id", "kim");
      ht.put("pwd", "12345");
      ht.put("name", "김길동");
      ht.put("number", new Integer(111));
      
      //ht 클라이언트로 던진다.
     //클라이언트에서
      
      String id= (String)ht.get("id");
      String pwd= (String)ht.get("pwd");
      String name= (String)ht.get("name");
     
      int number=(Integer)ht.get("number");
      
      //웹화면에 뿌여준다.
      System.out.println("ID : "+id);
      System.out.println("PWD : "+pwd);
      System.out.println("Name : "+name);
      System.out.println("number : "+number);
      System.out.println("갯수 : "+ht.size());
      //컴파일 수행.
      
      
   }

}
