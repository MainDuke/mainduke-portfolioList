/*
 * Author: Administrator
 * Created: 2016�� 2�� 11�� ����� ���� 12:08:43
 * Modified: 2016�� 2�� 11�� ����� ���� 12:08:43
 */

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;


class Test01_Generic
{
   //����� ���� �޼���.
   public void testCollection(){
      List list= new ArrayList();//���� Ŭ���� ���� ���� ��ü ó��.
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
   
   
   //main
   public static void main( String [] args ) 
   {
      Test01_Generic A=new Test01_Generic();
      
      A.testCollection();
   }// end main
   
}//class end
