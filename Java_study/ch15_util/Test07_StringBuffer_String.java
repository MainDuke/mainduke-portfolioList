/*
 * Author: Administrator
 * Created: 2016년 2월 5일 금요일 오전 11:16:07
 * Modified: 2016년 2월 5일 금요일 오전 11:16:07
 */

class Test07_StringBuffer_String
{
   public static void main(String args[]){
      
      long s; 
      long e;
      String s1= new String("1~10000까지의 합");
      StringBuffer sb = new StringBuffer("1~10000 까지의 합.");    
     StringBuilder sbb = new StringBuilder("1~10000까지의 합.");
      
      
      /*
      s = System.currentTimeMillis(); //현재 시간 구함.
      for(int i=1;i<=200000;i++)
      {
      s1+=i;
      s1+="+";
      }
      
      e =System.currentTimeMillis();
      
      
      System.out.println("s1의 연산시간 : "+ (e - s));    
       */
      
      s = System.currentTimeMillis(); //현재 시간 구함.
      for(int i = 1;i<=10000000;i++)
      {
         sb.append(i);
         sb.append("+");
      }
      e= System.currentTimeMillis(); 
  
      System.out.println("sb의 연산시간 : "+ (e - s));
   
      
      
      s = System.currentTimeMillis(); //현재 시간 구함.
      for(int i = 1;i<=10000000;i++)
      {
         sbb.append(i);
         sbb.append("+");
      }
      e= System.currentTimeMillis(); 
      
      System.out.println("sbb의 연산시간 : "+ (e - s));
      
      
      
   }//end main

}//class end.
