/*
 * Author: Administrator
 * Created: 2016�� 2�� 11�� ����� ���� 12:24:56
 * Modified: 2016�� 2�� 11�� ����� ���� 12:24:56
 */


//Generic ��� �����Ͻ� ���� �߰� �Ҽ� �ִ�.
//Iterator�� ��ӹ��� Ŭ������ : Collection , List , Set


import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class Test02_Generic
{
   
   //����� ���� �޼���.
   public void testCollection(){
      List <String>list= new ArrayList<String>();//���� Ŭ���� ���� ���� ��ü ó��.
      list.add(new String("Hello World"));
      list.add(new String("Very Good"));
      list.add(new Integer(100));//���� ����. 
      
      printCollection(list);
      
   }//testCollection end
   
   //����� ���� �޼���.
   public void printCollection(Collection c){
      Iterator iter=c.iterator();//���� ���.
      while(iter.hasNext())//�ڷᰡ �ִ� ���� �ݺ�,
      {
         String item=(String)iter.next();
         System.out.println("item : "+item);
         
      }
   }//printCollection() end
   
	public static void main( String [] args )
   {
      Test02_Generic A = new Test02_Generic();
      A.testCollection();
      
      
   }// end main

}//class end
