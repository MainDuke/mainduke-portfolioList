/*
 * Author: Administrator
 * Created: 2016�� 2�� 5�� �ݿ��� ���� 11:16:07
 * Modified: 2016�� 2�� 5�� �ݿ��� ���� 11:16:07
 */

class Test07_StringBuffer_String
{
   public static void main(String args[]){
      
      long s; 
      long e;
      String s1= new String("1~10000������ ��");
      StringBuffer sb = new StringBuffer("1~10000 ������ ��.");    
     StringBuilder sbb = new StringBuilder("1~10000������ ��.");
      
      
      /*
      s = System.currentTimeMillis(); //���� �ð� ����.
      for(int i=1;i<=200000;i++)
      {
      s1+=i;
      s1+="+";
      }
      
      e =System.currentTimeMillis();
      
      
      System.out.println("s1�� ����ð� : "+ (e - s));    
       */
      
      s = System.currentTimeMillis(); //���� �ð� ����.
      for(int i = 1;i<=10000000;i++)
      {
         sb.append(i);
         sb.append("+");
      }
      e= System.currentTimeMillis(); 
  
      System.out.println("sb�� ����ð� : "+ (e - s));
   
      
      
      s = System.currentTimeMillis(); //���� �ð� ����.
      for(int i = 1;i<=10000000;i++)
      {
         sbb.append(i);
         sbb.append("+");
      }
      e= System.currentTimeMillis(); 
      
      System.out.println("sbb�� ����ð� : "+ (e - s));
      
      
      
   }//end main

}//class end.
