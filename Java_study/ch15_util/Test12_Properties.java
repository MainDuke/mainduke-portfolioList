/*
 * Author: Administrator
 * Created: 2016�� 2�� 5�� �ݿ��� ���� 2:43:45
 * Modified: 2016�� 2�� 5�� �ݿ��� ���� 2:43:45
 */

import java.util.*;

class Test12_Properties
{
   public static void main( String [] args ) 
   {
      //������Ƽ Ÿ������ ��ü ������, HashTable Ÿ������ key,value�� ��ǲ!
      Properties pro=new Properties(); 
      pro.put("id", "kim");
      pro.put("pwd", "123");
      pro.put("name", "ȫ�浿");
           
      //HashTable�� ����� ����String ���� ������ �Է��Ѵ�.
      String id= (String)pro.get("id");
      String pwd= (String)pro.get("pwd");
      String name= (String)pro.get("name");
      
      
      //String Ÿ�� ������ �Էµ� ����  ����Ѵ�.
      System.out.println("id :"+id);
      System.out.println("pwd :"+pwd);
      System.out.println("name :"+name);
      
      
      
      //Enumeration : ������ ������ �����Ë� ���.
      //					���� ���� ó�� �ȴ�.
      // ������� ���� �˰�����, �������� ó���� �����Ͱ� ó������ Ƣ��´�.
      // name>pwd>id ������ ��µȴ�.
      
      
      Enumeration en =pro.propertyNames(); //�Ӽ��� ��� ������ �޾Ƽ� en�� �Ҵ�.
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
