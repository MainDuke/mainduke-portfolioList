/*
 * Author: Administrator
 * Created: 2016년 2월 5일 금요일 오전 10:50:13
 * Modified: 2016년 2월 5일 금요일 오전 10:50:13
 */


class Test06_StringBuffer
{
	public static void main(String args[]){
      StringBuffer sb = new StringBuffer();
      
      sb.append("hello");
      sb.append("Good");
      
      System.out.println(sb.toString());
      
      sb.reverse();
      System.out.println(sb.toString());
      
      sb.delete(0,5);
      System.out.println(sb.toString());
      
      sb.reverse();
      System.out.println(sb.toString());

  
      StringBuffer sb1 = new StringBuffer();
      StringBuffer sb2 = new StringBuffer(10); //초기 용량을 10 으로.
      StringBuffer sb3 = new StringBuffer("java");
      
      System.out.println("sb1 capacity 버퍼 크기 :"+sb1.capacity());
      System.out.println("sb2 capacity 버퍼 크기 :"+sb2.capacity());
      System.out.println("sb3 capacity 버퍼 크기 :"+sb3.capacity());
      
      System.out.println("sb1 실제 데이타 길이 : "+sb1.length());
      System.out.println("sb2 실제 데이타 길이 : "+sb2.length());
      System.out.println("sb3 실제 데이타 길이 : "+sb3.length());
      
      
   }//main end

}//class end
