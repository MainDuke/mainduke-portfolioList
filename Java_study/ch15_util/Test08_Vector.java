/*
 * Author: Administrator
 * Created: 2016�� 2�� 5�� �ݿ��� ���� 11:37:09
 * Modified: 2016�� 2�� 5�� �ݿ��� ���� 11:37:09
 */
import java.util.*;

class Test08_Vector
{
	public static void main( String [] args ) 
   {
      Vector vec= new Vector();
      for(int i =0; i<args.length; i++)
      {
         vec.add(args[i]);
         
      }//fod
      
   String str="";
   for(int i = 0; i < vec.size();i++)
   {
      str=(String)vec.get(i);
      System.out.println("vec "+i+" ��° ��� :"+str);
   }//for
   
   
   System.out.println("---------------------------");
   
   //aa bb cc dd ee
   // 0 1 2 3 4
   
   vec.remove(2);
   for(int i=0; i < vec.size();i++)
   {
     str=(String)vec.get(i); //���Ϳ��� ��ü�� ��´�.
      System.out.println("vec "+i+" ��° ��� :"+str);
   }
   
   }// end main

}
