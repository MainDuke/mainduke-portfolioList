/*
 * Author: Administrator
 * Created: 2016�� 2�� 4�� ����� ���� 4:44:57
 * Modified: 2016�� 2�� 4�� ����� ���� 4:44:57
 */


import java.util.*;

class Test02_HashTable
{
	public static void main(String args[]){
      Hashtable ht= new Hashtable();
      
      //�������� �� �۾��� �Ѵٰ� �ϸ�.
      
      ht.put("id", "kim");
      ht.put("pwd", "12345");
      ht.put("name", "��浿");
      ht.put("number", new Integer(111));
      
      //ht Ŭ���̾�Ʈ�� ������.
     //Ŭ���̾�Ʈ����
      
      String id= (String)ht.get("id");
      String pwd= (String)ht.get("pwd");
      String name= (String)ht.get("name");
     
      int number=(Integer)ht.get("number");
      
      //��ȭ�鿡 �ѿ��ش�.
      System.out.println("ID : "+id);
      System.out.println("PWD : "+pwd);
      System.out.println("Name : "+name);
      System.out.println("number : "+number);
      System.out.println("���� : "+ht.size());
      //������ ����.
      
      
   }

}
