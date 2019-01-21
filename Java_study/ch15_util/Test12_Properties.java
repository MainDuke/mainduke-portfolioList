/*
 * Author: Administrator
 * Created: 2016년 2월 5일 금요일 오후 2:43:45
 * Modified: 2016년 2월 5일 금요일 오후 2:43:45
 */

import java.util.*;

class Test12_Properties
{
   public static void main( String [] args ) 
   {
      //프로퍼티 타입으로 객체 생성후, HashTable 타입으로 key,value를 인풋!
      Properties pro=new Properties(); 
      pro.put("id", "kim");
      pro.put("pwd", "123");
      pro.put("name", "홍길동");
           
      //HashTable에 저장된 값을String 변수 값으로 입력한다.
      String id= (String)pro.get("id");
      String pwd= (String)pro.get("pwd");
      String name= (String)pro.get("name");
      
      
      //String 타입 변수에 입력된 값을  출력한다.
      System.out.println("id :"+id);
      System.out.println("pwd :"+pwd);
      System.out.println("name :"+name);
      
      
      
      //Enumeration : 나열형 데이터 가져올떄 사용.
      //					순서 없이 처리 된다.
      // 결과값을 보면 알겠지만, 마지막에 처리된 데이터가 처음으로 튀어나온다.
      // name>pwd>id 순으로 출력된다.
      
      
      Enumeration en =pro.propertyNames(); //속성의 모든 내용을 받아서 en에 할당.
      while(en.hasMoreElements())
      {
         String k=(String)en.nextElement();
      String v= pro.getProperty(k);
          System.out.print(v+" ");
         }//while end
         System.out.println();
          System.out.println("Test 2 end");
      //properties.
    
      pro.list(System.out);
      
   }// end main
   
}//class end 
